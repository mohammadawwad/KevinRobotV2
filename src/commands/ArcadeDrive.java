package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class ArcadeDrive extends CommandBase {

  public ArcadeDrive() {

  }

  @Override
  public void initialize() {

  }

  @Override
  public void execute() {

    double throttle = Robot.control.stick.getThrottle();
    double stickY = Robot.control.stick.getY();
    double stickZ = Robot.control.stick.getZ();

    stickZ = stickZ * ((((-throttle) + 1) / 2));
    stickY = stickY * ((((-throttle) + 1) / 2));

    double leftmotor = stickZ - stickY;
    double rightmotor = stickZ + stickY;

    Robot.driveTrain.setRightMotors(rightmotor);
    Robot.driveTrain.setLeftMotors(-leftmotor);

  }

  @Override
  public void end(boolean interrupted) {

  }

  @Override
  public boolean isFinished() {
    return false;
  }
}
