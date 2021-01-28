package frc.robot.subsystems;

import com.kauailabs.navx.frc.AHRS;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import com.revrobotics.CANSparkMaxLowLevel;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj.controller.SimpleMotorFeedforward;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveWheelSpeeds;
import edu.wpi.first.wpilibj.util.Units;


public class DriveTrain extends SubsystemBase {
  public CANSparkMax frontLeftMotor = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_ID, MotorType.kBrushless);
  private CANSparkMax backLeftMotor = new CANSparkMax(Constants.BACK_LEFT_MOTOR_ID, MotorType.kBrushless);
  private CANSparkMax frontRightMotor = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_ID, MotorType.kBrushless);
  private CANSparkMax backRightMotor = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_ID, MotorType.kBrushless);
 
  public CANEncoder frontLeftEncoder = new CANSparkMax(Constants.FRONT_LEFT_MOTOR_ID, MotorType.kBrushless).getEncoder();
  public CANEncoder backLeftEncoder = new CANSparkMax(Constants.BACK_LEFT_MOTOR_ID, MotorType.kBrushless).getEncoder();
  public CANEncoder frontRightEncoder = new CANSparkMax(Constants.FRONT_RIGHT_MOTOR_ID, MotorType.kBrushless).getEncoder();
  public CANEncoder backRightEncoder = new CANSparkMax(Constants.BACK_RIGHT_MOTOR_ID, MotorType.kBrushless).getEncoder();
 

    

  public AHRS ahrs = new AHRS(Port.kMXP);

  private PowerDistributionPanel PDP = new PowerDistributionPanel(Constants.PDP_DEVICE_ID);
  public Compressor PCM = new Compressor(Constants.PCM_DEVICE_ID);
  public DriveTrain() 
  {
    //setDefaultCommand(new ArcadeDrive());
  }

  @Override
  public void periodic() 
  {
    SmartDashboard.putNumber("Right Current", PDP.getCurrent(4));
    SmartDashboard.putNumber("Left Current", PDP.getCurrent(11));
    // double shiftLevel = backLeftEncoder.getVelocity() / -10000;
    // if(shiftLevel <= 0.0000 && DriverStationDataJNI.getAutonomous() == false)
    // {
    //   Robot.global.GearShiftPosition = true;
    //   Robot.gearBox.schedule();
    // }
    // else if (shiftLevel >= 0.3 && DriverStationDataJNI.getAutonomous() == false)
    // {
    //   Robot.global.GearShiftPosition = false;
    //   Robot.gearBox.schedule();
    // }
    // SmartDashboard.putNumber("Vol", shiftLevel);

  }

public void GyroReset()
{
  ahrs.reset();
  ahrs.zeroYaw();
}

  public void setLeftMotors(double speed)
  {
    frontLeftMotor.set(speed);
    backLeftMotor.set(speed);
    frontLeftMotor.setSmartCurrentLimit(0, 0, 0);
    backLeftMotor.setSmartCurrentLimit(0,0,0);
  }
  public void setRightMotors(double speed)
  {
    frontRightMotor.set(-speed);
    backRightMotor.set(-speed);
  }
  public void setAllMotors(double speed)
  {
    setLeftMotors(speed);
    setRightMotors(speed);
  }
  public void factoryMotors()
  {
  frontLeftMotor.restoreFactoryDefaults();
  frontRightMotor.restoreFactoryDefaults();
  backRightMotor.restoreFactoryDefaults();
  backLeftMotor.restoreFactoryDefaults();
  }
  public void zeroLeftEncoders()
  {
    frontLeftEncoder.setPosition(0.0);
    backLeftEncoder.setPosition(0.0);
  }
  public void zeroRightEncoders()
  {
    frontRightEncoder.setPosition(0.0);
    backRightEncoder.setPosition(0.0);
  }
  public void zeroEncoders()
  {
    zeroRightEncoders();
    zeroLeftEncoders();
  }

  public void RobotReset()
  {
    zeroEncoders();

    frontRightEncoder.setPositionConversionFactor(0);
    frontLeftEncoder.setPositionConversionFactor(0);
    backRightEncoder.setPositionConversionFactor(0);
    backLeftEncoder.setPositionConversionFactor(0);
    System.out.print("Encoders set to 0");
    PDP.clearStickyFaults();
    PCM.clearAllPCMStickyFaults();
    GyroReset();
  }
}
  
/////////////////////////////////Needs to be implemented 
/*
private static final double kGearRatio = 7.29;
  private static final double kWheelRadiusInches = 3.0;

  CANSparkMax leftMaster = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightMaster = new CANSparkMax(3, CANSparkMaxLowLevel.MotorType.kBrushless);

  CANSparkMax leftSlave = new CANSparkMax(2, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightSlave = new CANSparkMax(4, CANSparkMaxLowLevel.MotorType.kBrushless);

  AHRS gyro = new AHRS(SPI.Port.kMXP);

  DifferentialDriveKinematics kinematics = new DifferentialDriveKinematics(Units.inchesToMeters(28));
  DifferentialDriveOdometry odometry = new DifferentialDriveOdometry(kinematics, getHeading());

  SimpleMotorFeedforward feedforward = new SimpleMotorFeedforward(0.3, 1.96, 0.06);

  PIDController leftPIDController = new PIDController(2.95, 0, 0);
  PIDController rightPIDController = new PIDController(2.95, 0, 0);

  Pose2d pose = new Pose2d();

  public Drivetrain() {
    leftSlave.follow(leftMaster);
    rightSlave.follow(rightMaster);

    leftMaster.setInverted(false);
    rightMaster.setInverted(true);

    gyro.reset();
  }

  public Rotation2d getHeading() {
    return Rotation2d.fromDegrees(-gyro.getAngle());
  }

  public DifferentialDriveWheelSpeeds getSpeeds() {
    return new DifferentialDriveWheelSpeeds(
        leftMaster.getEncoder().getVelocity() / kGearRatio * 2 * Math.PI * Units.inchesToMeters(kWheelRadiusInches) / 60,
        rightMaster.getEncoder().getVelocity() / kGearRatio * 2 * Math.PI * Units.inchesToMeters(kWheelRadiusInches) / 60
    );
  }

  public DifferentialDriveKinematics getKinematics() {
    return kinematics;
  }

  public Pose2d getPose() {
    return pose;
  }

  public SimpleMotorFeedforward getFeedforward() {
    return feedforward;
  }

  public PIDController getLeftPIDController() {
    return leftPIDController;
  }

  public PIDController getRightPIDController() {
    return rightPIDController;
  }

  public void setOutputVolts(double leftVolts, double rightVolts) {
    leftMaster.set(leftVolts / 12);
    rightMaster.set(rightVolts / 12);
  }

  public void reset() {
    odometry.resetPosition(new Pose2d(), getHeading());
  }

  @Override
  public void periodic() {
    pose = odometry.Update(gyroHeading(), m_leftEncoder.GetDistance(), m_rightEncoder.GetDistance());
  }*/