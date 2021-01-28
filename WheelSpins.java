package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class WheelSpins extends CommandBase {
  boolean done;
  double encoder, start, end, clicks;
  public double goal;
  public WheelSpins(boolean done) 
  {
    this.done = done;
  }

  @Override
  public void initialize() 
  {
    done = false;
    goal = -200000;
  }

   @Override
  public void execute() 
  {
    start = Timer.getFPGATimestamp();
    System.out.print("test");
    
    encoder = Robot.ctrlpannel.wheelSpinner.getSelectedSensorPosition();
    
    if (encoder > goal)
    {
      Robot.ctrlpannel.wheelSpinner(0.5);
      Robot.driveTrain.RobotReset();
    }
    else
    {
      Robot.ctrlpannel.wheelSpinner(0.0);
      done = true;
    }
     end = Timer.getFPGATimestamp();
  }

  @Override
  public void end(boolean interrupted) 
  {
    Robot.ctrlpannel.wheelSpinner(0.0);
    Robot.LED.setCustom(3,-0.99);
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
