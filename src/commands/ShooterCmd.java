package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

import frc.robot.subsystems.Shooter;

public class ShooterCmd extends CommandBase {
 
  boolean done;
  double error, distance, driveSpeed, P, I, D, T, Ilimit, errorLast, errorRate,errorSum,lastTimeStamp;
  
  public ShooterCmd(boolean done) 
  {
    addRequirements(new Shooter());
    this.done = done;
  }

  @Override
  public void initialize() 
  {
    distance = 13000000;
    P = 6;
    I = 0.1;
  
    
  }

  @Override
  public void execute() 
  {
    double Encoder = Robot.shooter.getVolocity();
     SmartDashboard.putNumber("Vol", Encoder);
     error = distance - Encoder;
     driveSpeed = error * P;
     T = Timer.getFPGATimestamp() - lastTimeStamp;

     if (Math.abs(error) < Ilimit) 
     {
       errorSum += error + T;
       errorRate = (error - errorLast) / T;
     }

     driveSpeed = P * error + I * errorSum + D * errorRate;

     if(Robot.shooter.getVolocity() < -8900000){
     Robot.shooter.setAllMotors(driveSpeed, driveSpeed, -0.6);
     Robot.intake.IntakeOnly(-0.45);
     }
     else{
       Robot.shooter.setAllMotors(driveSpeed, driveSpeed, 0);
     }
     
     lastTimeStamp = Timer.getFPGATimestamp();
     errorLast = error;
     
    
    

  }

  @Override
  public void end(boolean interrupted) {
    Robot.shooter.setAllMotors(0.0, 0.0, 0.0);
    Robot.intake.IntakeOnly(0);
  }

  @Override
  public boolean isFinished() 
  {
    return done;
  }
}
