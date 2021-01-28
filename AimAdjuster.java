package frc.robot.commands;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;


public class AimAdjuster extends CommandBase 
{
    public static Servo HudAdjuster = new Servo(2);
    public boolean held, done;
    private NetworkTable table;
    public NetworkTableEntry camMode, ledMode, txvalue, tyvalue, tHorvalue, tVertvalue;
    public double kP, tx, ty, heading_error,distance_error,steering_adjust,distance_adjust, steering, kpAim, kpDistance;
    
    public AimAdjuster(boolean isHeld) 
    {
      held = isHeld;
      table = NetworkTableInstance.getDefault().getTable("limelight");
      ledMode = table.getEntry("ledMode");
      camMode = table.getEntry("camMode");
      txvalue = table.getEntry("tx");
      tyvalue = table.getEntry("ty");
      tVertvalue = table.getEntry("thor");
      tHorvalue = table.getEntry("tvert");
    }

    @Override
    public void initialize() 
    {

      if (held == true)
      {
        kP = -0.021;
        kpDistance = -0.14;
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
     
      SmartDashboard.putNumber("Thor", tHorvalue.getDouble(0));
      SmartDashboard.putNumber("TVert", tVertvalue.getDouble(0));
      double distance = tHorvalue.getDouble(0) * tVertvalue.getDouble(0);

      if(distance < 1000)
      {
        HudAdjuster.setAngle(137);
        Robot.LED.ToClose(false);
      }
      else if(distance > 1500 && distance < 3300)
      {
        HudAdjuster.setAngle(137);
        Robot.LED.ToClose(false);
        
      }
      else if(distance > 3500)
      {
        Robot.LED.ToClose(true);
      }
      SmartDashboard.putNumber("distance", distance);
      if(distance > 2900 && distance < 3200)
      {
        Robot.LED.ShootNow(true);
      }
      else
      {
        Robot.LED.ShootNow(false);
      }
    }
	
    @Override
    public void end(boolean interrupted) 
    { 
      Robot.LED.ShootNow(false);
      Robot.LED.ToClose(false);
    }

    @Override
    public boolean isFinished() 
    {
      return done;
    }
}

