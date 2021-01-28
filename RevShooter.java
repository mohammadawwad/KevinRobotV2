package frc.robot.commands;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Shooter;

public class RevShooter extends CommandBase {
  double time;
  boolean done = false;
  double start, end;
  double T, lastTimeStamp;
  public RevShooter(double time)
  {
    
    addRequirements(new Shooter());
    this.time = time;
  }

  @Override
  public void initialize() 
  {
    done = false;
    start = Timer.getFPGATimestamp();

  }

  
  @Override
  public void execute()
  { 
    T = Timer.getFPGATimestamp() - lastTimeStamp;

    Robot.aimAdjuster.HudAdjuster.setAngle(137);
   
    Robot.shooter.revShooter(1, 1);
  






    end = Timer.getFPGATimestamp();
    if(end-start > time){
      done = true;
    }
  }

  
  @Override
  public void end(boolean interrupted)
  {
    Robot.shooter.revShooter(0, 0);
  }
  @Override
  public boolean isFinished() 
  {                                    
   return done;
  }
}
