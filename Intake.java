
package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class Intake extends SubsystemBase {

  public static Hopper hopper = new Hopper();

  static TalonSRX intake1 = new TalonSRX(Constants.INTAKE_1_MOTOR_ID);
  static TalonSRX intake2 = new TalonSRX(Constants.INTAKE_2_MOTOR_ID);

  public Intake() {

  }

  @Override
  public void periodic() {

  }

  public void setAllMotors (double Speed, double hopperSpeed)
  {
    intake1.set(ControlMode.PercentOutput, -Speed);
    intake2.set(ControlMode.PercentOutput, -Speed);
    hopper.hopper(-hopperSpeed);
  }
  public void feeder(double speed)
  {
    hopper.feeder(speed);
  }
  public void setAllHI (double Speed, double hopperSpeed)
  {
    intake1.set(ControlMode.PercentOutput, -Speed);
    intake2.set(ControlMode.PercentOutput, -Speed);
    hopper.hopperOnly(-hopperSpeed);
  }
  public void IntakeOnly (double Speed)
  {
    intake1.set(ControlMode.PercentOutput, -Speed);
    intake2.set(ControlMode.PercentOutput, -Speed);
   
  }
}
 