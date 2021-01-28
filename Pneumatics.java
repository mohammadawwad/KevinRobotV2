package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Pneumatics extends SubsystemBase
 {
  static Solenoid Climber = new Solenoid(Constants.CLIMBER_SOLENOID);
  static Solenoid GearShifter = new Solenoid(Constants.GEARSHIFT_SOLENOID);
  static Solenoid Intake = new Solenoid(Constants.INTAKE_SOLENOID);
  static Solenoid ColourArm = new Solenoid(Constants.COLOURARM_SOLENOID);

  
  // boolean pressureSwitch = Robot.compressor.getPressureSwitchValue();
  
  public Pneumatics() {
    // SmartDashboard.putBoolean("Pressure Value", pressureSwitch);
  }

 public void ClimbExtend()
 {
   Climber.set(true);
 }

 public void ClimbRetract()
 {
   Climber.set(false);
 }

 public void ColourArmExtend()
 {
   ColourArm.set(true);
 }

 public void ColourArmRetract()
 {
   ColourArm.set(false);
 }

 public void FeederOut()
 {
   Intake.set(true);
 }
 public void FeederIn()
 {
   Intake.set(false);  
 }

 public void GearShiftExtend()
 {
   GearShifter.set(true);
 }

 public void GearShiftRetract()
 {
   GearShifter.set(false);
 }

  @Override
  public void periodic() {
 
  }
}
