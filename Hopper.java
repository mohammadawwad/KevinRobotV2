package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Hopper extends SubsystemBase {
 
  public Hopper() {

  }

  @Override
  public void periodic() {
  }
  public static Hopper hopper = new Hopper();
   public static VictorSPX hoppermotor1 = new VictorSPX(Constants.HOPPER_1_MOTOR_ID);
   public static VictorSPX hoppermotor2 = new VictorSPX(Constants.HOPPER_2_MOTOR_ID);
   private static TalonSRX feeder = new TalonSRX(Constants.FEEDER_MOTOR_ID);

  public void hopper(double speed)
  {
    hoppermotor1.set(ControlMode.PercentOutput, speed);
    hoppermotor2.set(ControlMode.PercentOutput, -speed);
    feeder.set(ControlMode.PercentOutput, speed);
  }
  public void Intaking(double speed)
  {
    hoppermotor1.set(ControlMode.PercentOutput, speed);
    hoppermotor2.set(ControlMode.PercentOutput, -speed);
    feeder.set(ControlMode.PercentOutput, speed);
  }
  public void feeder(double speed)
  {
    feeder.set(ControlMode.PercentOutput, speed);
    hoppermotor1.set(ControlMode.PercentOutput, -speed);
    hoppermotor2.set(ControlMode.PercentOutput, speed);
    
  }
  public void hopperOnly(double speed)
  {
    hoppermotor1.set(ControlMode.PercentOutput, speed);
    hoppermotor2.set(ControlMode.PercentOutput, -speed);
    
  }
  public void shootingHopper(double speed)
  {

    hoppermotor1.set(ControlMode.PercentOutput, -speed);
    hoppermotor2.set(ControlMode.PercentOutput, speed);
    feeder.set(ControlMode.PercentOutput, speed);
 
  }

}
