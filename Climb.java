package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Pneumatics;

public class Climb extends CommandBase {
  boolean done;

  public Climb(boolean done) {
    addRequirements(new Pneumatics());
    this.done = done;
  }

  @Override
  public void initialize() 
  {
    
  }

  @Override
  public void execute() {
   
    Robot.shooter.setAllMotors(-1, -1, 0);
    
  }

  @Override
  public void end(boolean interrupted) {
    Robot.shooter.setAllMotors(0, 0, 0);
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
