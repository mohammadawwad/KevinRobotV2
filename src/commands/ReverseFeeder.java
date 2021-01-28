package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ReverseFeeder extends CommandBase {
 boolean done;
  public ReverseFeeder(boolean done) {
   this.done =done;
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    Robot.intake.feeder(1);
  }

  @Override
  public void end(boolean interrupted) {
    Robot.intake.feeder(0.0);
  }

  @Override
  public boolean isFinished() {
    return done;
  }
}
