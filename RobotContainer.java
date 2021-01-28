package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.AimAdjuster;

import frc.robot.commands.Climb;
import frc.robot.commands.ClimbPneumatic;
import frc.robot.commands.GearBox;
import frc.robot.commands.IntakeCmd;
import frc.robot.commands.IntakePeumatics;
import frc.robot.commands.LimeLightAim;
import frc.robot.commands.ReverseFeeder;
import frc.robot.commands.ShooterCmd;
import frc.robot.commands.ColourArm;
import frc.robot.commands.WheelSpins;
//import jdk.nashorn.internal.ir.ReturnNode;
import frc.robot.classes.AxisButton;



public class RobotContainer {
  public Joystick stick = new Joystick(0);
  public JoystickButton button1 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_1),
  button2 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_2),
  button3 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_3),
  button4 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_4),
  button5 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_5),
  button6 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_6),
  button7 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_7),
  button8 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_8),
  button9 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_9),
  button10 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_10),
  button11 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_11),
  button12 = new JoystickButton(stick, Constants.JOYSTICK_BUTTON_12);
  
  public XboxController xbox = new XboxController(Constants.XBOX_CONTROLLER);
  public JoystickButton XboxA = new JoystickButton(xbox, Constants.XBOX_BUTTON_A),
  XboxB = new JoystickButton(xbox, Constants.XBOX_BUTTON_B),
  XboxX = new JoystickButton(xbox, Constants.XBOX_BUTTON_X),
  XboxY = new JoystickButton(xbox, Constants.XBOX_BUTTON_Y),
  XboxBumperLeft = new JoystickButton(xbox, Constants.XBOX_BUMPER_LEFT),
  XboxBumperRight = new JoystickButton(xbox, Constants.XBOX_BUMPER_RIGHT),
  XboxBack = new JoystickButton(xbox, Constants.XBOX_BUTTON_BACK),
  XboxStart = new JoystickButton(xbox, Constants.XBOX_BUTTON_START),
  XboxLeftStickIn = new JoystickButton(xbox, Constants.XBOX_BUTTON_LEFT_JOYSTICK_IN),
  XboxRightStickIn = new JoystickButton(xbox, Constants.XBOX_BUTTON_RIGHT_JOYSTICK_IN);
  public AxisButton XboxLeftTrigger = new AxisButton(xbox, 2);
  public AxisButton XboxRightTrigger = new AxisButton(xbox, 3);
  
  public RobotContainer() {
    configureButtonBindings();
  }


  private void configureButtonBindings() 
  {
  
   
    button1.whileHeld(new LimeLightAim(true));
    button1.whenReleased(new LimeLightAim(false));
    button2.whenPressed(new GearBox());
    // button3.whenPressed(null);
    // button4.whenPressed(null);
    // button5.whenPressed(null);
    // button6.whenPressed(null);
    //button7.whenPressed(new Climb(true));
    //button8.whenPressed(new Climb(false));
    // button9.whenPressed(null);
    // button10.whenPressed(null);
    button4.whileHeld(new Climb(false));
    button4.whenReleased(new Climb(true));
    button12.whenPressed(new ClimbPneumatic());
    
    XboxA.whileHeld(new ReverseFeeder(false));
    XboxA.whenReleased(new ReverseFeeder(true));
    //XboxB.whenPressed(null);
    XboxX.whileHeld(new AimAdjuster(true));
    XboxX.whenReleased(new AimAdjuster(false));
    
    XboxY.whenPressed(new ColourArm());
    XboxBumperLeft.whileHeld(new IntakeCmd(0.5 , 0.8));
    XboxBumperRight.whenPressed(new IntakePeumatics());
    // XboxBack.whenPressed(null);
    // XboxStart.whenPressed(null);
    // XboxLeftStickIn.whenPressed(null);
    // XboxRightStickIn.whenPressed(null);
    XboxLeftTrigger.whileHeld(new IntakeCmd(-0.5 , -0.8));
    XboxRightTrigger.whileHeld(new ShooterCmd(false));
    XboxRightTrigger.whenReleased(new ShooterCmd(true));
    XboxRightTrigger.whileHeld(new AimAdjuster(true));
    XboxRightTrigger.whenReleased(new AimAdjuster(false));
    //XboxBack.whileHeld(new WheelOfFortune(true));
    XboxStart.whileHeld(new WheelSpins(true));
    //XboxBack.whenReleased(new WheelOfFortune(false));
    XboxStart.whenReleased(new WheelSpins(false));
  }

  public double GetDriverRawAxis(final int axis)
  {
    return stick.getRawAxis(axis);
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   *//*
   public Command getAutonomousCommand() {

  }
  */
}


/////////////////////////////////////////////Needs to be implemented
/*import java.util.Arrays;

import org.ghrobotics.frc2020.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.controller.RamseteController;
import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.TrajectoryConfig;
import edu.wpi.first.wpilibj.trajectory.TrajectoryGenerator;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RamseteCommand;

public class RobotContainer {
  private Drivetrain drive = new Drivetrain();

  public Command getAutonomousCommand() {
    TrajectoryConfig config = new TrajectoryConfig(
        Units.feetToMeters(2.0), Units.feetToMeters(2.0));
    config.setKinematics(drive.getKinematics());

    Trajectory trajectory = TrajectoryGenerator.generateTrajectory(
        Arrays.asList(new Pose2d(), new Pose2d(1.0, 0, new Rotation2d()),
            new Pose2d(2.3, 1.2, Rotation2d.fromDegrees(90.0))),
        config
    );

    RamseteCommand command = new RamseteCommand(
        trajectory,
        drive::getPose,
        new RamseteController(2, .7),
        drive.getFeedforward(),
        drive.getKinematics(),
        drive::getSpeeds,
        drive.getLeftPIDController(),
        drive.getRightPIDController(),
        drive::setOutputVolts,
        drive
    );

    return command.andThen(() -> drive.setOutputVolts(0, 0));
  }

  public void reset() {
    drive.reset();
  }
} */