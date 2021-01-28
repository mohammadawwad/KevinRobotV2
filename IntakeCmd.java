package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.Intake;

public class IntakeCmd extends CommandBase 
{
  double speed, hopperSpeed;
  
  
    public IntakeCmd(double speed, double hopperSpeed) 
    {
      addRequirements(new Intake());
      this.speed = speed;
      this.hopperSpeed = hopperSpeed;
    }

    @Override
    public void initialize() 
    {
      
    }

    @Override
    public void execute() 
    {
      Robot.intake.setAllMotors(speed, hopperSpeed);
      //Robot.hopper.hopper(-0.5);
    }

    @Override
    public void end(boolean interrupted) 
    {
      Robot.intake.setAllMotors(0.0,0.0);
      //Robot.hopper.hopper(0.0);
    }

    @Override
    public boolean isFinished() 
    {
      return false;
    }
}
