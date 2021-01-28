package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.classes.GlobalVaribles;
import frc.robot.classes.JoystickDebouncer;
import frc.robot.classes.XboxDebouncer;
import frc.robot.commands.AimAdjuster;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.GearBox;
import frc.robot.commands.IntakeCmd;
import frc.robot.commands.IntakePeumatics;
import frc.robot.commands.ShooterCmd;
import frc.robot.commands.WheelSpins;
import frc.robot.commands.LimeLightAim;
import frc.robot.subsystems.ControlPannel;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Hopper;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.LEDS;
import frc.robot.subsystems.LimeLight;
import frc.robot.subsystems.Pneumatics;
import frc.robot.subsystems.Shooter;




public class Robot extends TimedRobot {
  
  public static RobotContainer control;
  public static LimeLight limelight;
  public static ArcadeDrive arcade;
  public static ShooterCmd shooterCmd;
  public static JoystickDebouncer joystickDebouncer, pneumaticClimb;
  public static XboxDebouncer xboxDebouncer, pneumaticColorArm;
  public static ControlPannel ctrlpannel;
  public static Intake intake;
  public static IntakeCmd intakeCmd;
  public static LEDS LED;
  public static DriveTrain driveTrain;
  public static Pneumatics piston = new Pneumatics();
  public static Shooter shooter;
  public static Hopper hopper;
  public static LimeLightAim limeLightAim;
  // public static WheelSpins wheelSpins;
  // public static WheelOfFortune wheelColour;
  public static Compressor compressor;
  public static GlobalVaribles global;
  public static AimAdjuster aimAdjuster;
  public static GearBox gearBox;
  public static IntakePeumatics intakePeumatics;
  double xbuttonend,xbuttonstart = 0;
 
  @Override
  public void robotInit() 
  {
    aimAdjuster = new AimAdjuster(false);
    arcade = new ArcadeDrive();
    shooterCmd = new ShooterCmd(false);
    ctrlpannel = new ControlPannel();;
    intake = new Intake();
    LED = new LEDS();
    driveTrain  = new DriveTrain();
    control = new RobotContainer();
    limelight = new LimeLight(false);
    joystickDebouncer = new JoystickDebouncer(control.stick, 2);
    pneumaticClimb = new JoystickDebouncer(control.stick, 12);
    shooter = new Shooter();
    xboxDebouncer = new XboxDebouncer(control.xbox, 6);
    pneumaticColorArm = new XboxDebouncer(control.xbox, 6);
    limeLightAim = new LimeLightAim(false);
    compressor = new Compressor();
    global = new GlobalVaribles();
    intakePeumatics = new IntakePeumatics();
    gearBox = new GearBox();
    //CameraServer.getInstance().startAutomaticCapture();
    limelight.camMode.setDouble(0.0);
    driveTrain.PCM.enabled();
    driveTrain.RobotReset();
  }

  @Override
  public void robotPeriodic() {

    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {
    driveTrain.RobotReset();
    driveTrain.factoryMotors();
   // CommandScheduler.getInstance().cancel(control.getAutonomousCommand());
  }

  @Override
  public void disabledPeriodic() {
  }


  @Override
  public void autonomousInit() 
  {
    //global.GearShiftPosition = true;
    global.IntakeShiftPosition = true;
    //gearBox.schedule();
    //intakePeumatics.schedule();
  /*  if(control.getAutonomousCommand() != null)
    {
      control.getAutonomousCommand().schedule();
    }*/
  }

  
  @Override
  public void autonomousPeriodic() {
    //LED.Auto(true);
    // if(driveTrain.ahrs.getRoll() > 13){
    //   driveTrain.setLeftMotors(0.7);
    //   driveTrain.setRightMotors(0.7);
    //   Timer.delay(1.2);
    //   CommandScheduler.getInstance().cancel(control.getAutonomousCommand());
    //   CommandScheduler.getInstance().schedule(control.getAutonomousErrorCommand());
    // }
    // if(driveTrain.ahrs.getRoll() < -12){
    //   driveTrain.setLeftMotors(-0.7);
    //   driveTrain.setRightMotors(-0.7);
    //   Timer.delay(1.2);
    //   CommandScheduler.getInstance().cancel(control.getAutonomousCommand());
    //   CommandScheduler.getInstance().schedule(control.getAutonomousErrorCommand());
    // }
    SmartDashboard.putNumber("gyri", driveTrain.ahrs.getYaw());
  }

  @Override
  public void teleopInit() {
    driveTrain.RobotReset();
    arcade.schedule();
    shooter.rightEncoder.setPosition(-1);
    // hopper.Intaking(0);
    // hopper.hopper(0);
    // shooter.setAllMotors(0, 0, 0);
    //LED.Auto(false);
  }

  @Override
  public void teleopPeriodic()
  {
    // SmartDashboard.putNumber("Encoder Left Back", (driveTrain.backLeftEncoder.getPosition()/240));
    // SmartDashboard.putNumber("Encoder Left Front", (driveTrain.frontLeftEncoder.getPosition()/240));
    // SmartDashboard.putNumber("Encoder Right Back", (driveTrain.backRightEncoder.getPosition()/240));
    // SmartDashboard.putNumber("Encoder Right Front", (driveTrain.frontRightEncoder.getPosition()/240));
    // SmartDashboard.putNumber("Gyro", (driveTrain.ahrs.getYaw()));
    // SmartDashboard.putNumber("Winch Encoder", shooter.rightEncoder.getPosition());
    //SmartDashboard.putNumber("shooterRPM", Robot.shooter.leftShooterWheel.getRot)
    if(shooter.rightEncoder.getPosition() > 0)
    {
      shooter.rightEncoder.setPosition(-1);
    }
    if(control.XboxLeftStickIn.get() && control.XboxRightStickIn.get())
    {
      ctrlpannel.WheelReset();
      LED.WheelReset(3);
    }

    
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {

  }

  public static void Zero()
  {
    driveTrain.RobotReset();
  }
}
