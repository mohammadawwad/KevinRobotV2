package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class LimeLightAim extends CommandBase 
{
    public boolean held, done;
    private NetworkTable table;
    public NetworkTableEntry tvvalue, camMode, ledMode, txvalue, tyvalue, tHorvalue, tVertvalue;
    public double kP, tx, tv, ty, heading_error,distance_error,steering_adjust,distance_adjust, steering, kpAim, kpDistance;
    
    public LimeLightAim(boolean isHeld) 
    {
      held = isHeld;
      table = NetworkTableInstance.getDefault().getTable("limelight");
      ledMode = table.getEntry("ledMode");
      camMode = table.getEntry("camMode");
      txvalue = table.getEntry("tx");
      tyvalue = table.getEntry("ty");
      tvvalue = table.getEntry("tv");
      tVertvalue = table.getEntry("thor");
      tHorvalue = table.getEntry("tvert");
    }

    @Override
    public void initialize() 
    {

      if (held == true)
      {
       kP = 0.014;
       kpDistance = 0.08;
       steering_adjust = 0.0;
       tx = txvalue.getDouble(0.0);
        ty = tyvalue.getDouble(0.0);
        camMode.setDouble(0.0);
        ledMode.setDouble(3.0);
        done = false;
     }
     else if(held == false)
     {
        camMode.setDouble(1.0);
        ledMode.setDouble(1.0);
        done = true;
     }
  }
  
    @Override
    public void execute() 
    {
      tx = txvalue.getDouble(0.0);
      ty = tyvalue.getDouble(0);
      tv = tvvalue.getDouble(0.0);
      heading_error = -tx;
      steering = kP * -tx;
      //distance_error = ty;
     // distance_adjust = kpDistance * distance_error;
      Robot.driveTrain.setLeftMotors(steering);
      Robot.driveTrain.setRightMotors(-steering);
      if(tv != 1)
      {
        Robot.LED.LimeLightTracking(true);
      }
      else
      {
        Robot.LED.LimeLightFound(true);
      }
    }
	
    @Override
    public void end(boolean interrupted) 
    { 
      Robot.LED.LimeLightFound(false);
      Robot.LED.LimeLightTracking(false);
      Robot.driveTrain.setAllMotors(0.01);
    }

    @Override
    public boolean isFinished() 
    {
      return done;
    }
}

