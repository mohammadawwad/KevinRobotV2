package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.util.Color;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

import com.revrobotics.ColorMatchResult;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

public class ControlPannel extends SubsystemBase {

  public final TalonSRX wheelSpinner = new TalonSRX(Constants.WHEEL_SPINNER_MOTOR_ID);
  public static Encoder wheelSpinnesrEncoder = new Encoder(0,1, true, EncodingType.k4X);
  // double[] blue = Constants.BlueTarget();
  // double[] green = Constants.GreenTarget();
  // double[] yellow = Constants.YellowTarget();
  // double[] red = Constants.RedTarget();
  // private final I2C.Port i2cPort = I2C.Port.kOnboard;
  // private final ColorSensorV3 m_colorSensor = new ColorSensorV3(i2cPort);
  // public final ColorMatch m_colorMatcher = new ColorMatch();
  // public final Color kBlueTarget = ColorMatch.makeColor(blue[0], blue[1], blue[2]);
  // public final Color kGreenTarget = ColorMatch.makeColor(green[0], green[1], green[2]);
  // public final Color kRedTarget = ColorMatch.makeColor(red[0], red[1], red[2]);
  // public final Color kYellowTarget = ColorMatch.makeColor(yellow[0], yellow[1], yellow[2]);


  Color detectedColor;
  String colorString;
  public ColorMatchResult match;
  String gameData;
  
  @Override
  public void periodic() 
  {
    // m_colorMatcher.addColorMatch(kBlueTarget);
    // m_colorMatcher.addColorMatch(kRedTarget);
    // m_colorMatcher.addColorMatch(kYellowTarget);
    // m_colorMatcher.addColorMatch(kGreenTarget);
    // m_colorMatcher.setConfidenceThreshold(Constants.COLOR_SENSOR_CONFIDENCE);
    // detectedColor = m_colorSensor.getColor();
    // match = m_colorMatcher.matchClosestColor(detectedColor);
    // gameData = DriverStation.getInstance().getGameSpecificMessage();
    
    //  if (match.color == kBlueTarget) {
    //    colorString = "Blue";
    //  } else if (match.color == kRedTarget) {
    //    colorString = "Red";
    //  } else if (match.color == kGreenTarget) {
    //    colorString = "Green";
    //  } else if (match.color == kYellowTarget) {
    //   colorString = "Yellow";
    //  } else {
    //    colorString = "Unknown";
    // }
  
    // SmartDashboard.putNumber("Red", detectedColor.red);
    // SmartDashboard.putNumber("Green", detectedColor.green);
    // SmartDashboard.putNumber("Blue", detectedColor.blue);

    // SmartDashboard.putNumber("Confidence", match.confidence);
    // SmartDashboard.putString("Detected Color", colorString);
    // SmartDashboard.putNumber("encoder", wheelSpinner.getSelectedSensorPosition());  
  }
  
  // public Color getNeedToSeeColour(){
  //   final String gameData = DriverStation.getInstance().getGameSpecificMessage();
  //   Color Target;
  //   SmartDashboard.putString("GameData", gameData);
    
  //   if(gameData == "B")
  //   {
  //     Target = kRedTarget;
  //   }
  //   else if (gameData == "R")
  //   {
  //     Target = kBlueTarget;
  //     SmartDashboard.putString("WUT?", "ITS FREAKING RED");
  //   }
  //   else if(gameData == "Y")
  //   {
  //     Target = kGreenTarget;
  //   }
  //   else if(gameData == "G")
  //   {
  //     Target = kYellowTarget;
  //   }
  //   else
  //   {
  //     Target = null;
  //   }
  //   return Target;
   
  // }
  // public Color getSeenColour()
  // {
  //   return match.color;
  // }
  
  public void wheelSpinner(final double Speed)
  {
    wheelSpinner.set(ControlMode.PercentOutput, Speed);
  }
  public void WheelReset()
  {
    wheelSpinner.setSelectedSensorPosition(0);
  }
}