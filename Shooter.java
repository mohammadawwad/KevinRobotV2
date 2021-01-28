package frc.robot.subsystems;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;


public class Shooter extends SubsystemBase
 {
  public static Hopper hopper = new Hopper();
  public static CANSparkMax leftShooterWheel = new CANSparkMax(Constants.SHOOTER_LEFT_MOTOR_ID, MotorType.kBrushless);
  public static CANSparkMax rightShooterWheel = new CANSparkMax(Constants.SHOOTER_RIGHT_MOTOR_ID, MotorType.kBrushless);
  
  double start, end;
 
  public static CANEncoder leftEncoder = new CANSparkMax(Constants.SHOOTER_LEFT_MOTOR_ID, MotorType.kBrushless).getEncoder();
  public static CANEncoder rightEncoder = new CANSparkMax(Constants.SHOOTER_RIGHT_MOTOR_ID, MotorType.kBrushless).getEncoder();
  public Shooter() 
  {

  }

  @Override
  public void periodic()
  {
    
  }
  public double getVolocity()
  {
    double left = leftEncoder.getVelocity();
    double right = rightEncoder.getVelocity();
    double volocity = left * right / 2;
    return volocity;
  }
  public double getRightVolocity()
  {
    double right = rightEncoder.getVelocity();
    return right;
  }
  public double getLeftVolocity()
  {
    double left = leftEncoder.getVelocity();
    return left;
  }
  public void setAllMotors(double leftSpeed, double rightSpeed, double hopperSpeed)
  {
    leftShooterWheel.set(-leftSpeed);
    rightShooterWheel.set(rightSpeed);
    hopper.shootingHopper(hopperSpeed);
  }
  public void revShooter(double leftSpeed, double rightSpeed)
  {
    leftShooterWheel.set(-leftSpeed);
    rightShooterWheel.set(rightSpeed);
  }
}
