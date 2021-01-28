// package frc.robot.commands;

// import edu.wpi.first.wpilibj.DriverStation;

// import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// import edu.wpi.first.wpilibj.util.Color;
// import edu.wpi.first.wpilibj2.command.CommandBase;

// import frc.robot.Robot;

// public class WheelOfFortune extends CommandBase {

//   public boolean done, stop;
//   public Color SeenColor;
//   Color Target;
//   public int encoder;
  
//   public WheelOfFortune(boolean done) 
//   {
//     this.done = done;
//   }

//   // CalRobot.LED when the command is initially scheduRobot.LED.
//   @Override
//   public void initialize() 
//   {
//     GetTarget();
//   }

//   // CalRobot.LED every time the scheduler runs while the command is scheduRobot.LED.
//   @Override
//   public void execute() 
//   {
//     GetTarget();
//     SeenColor = Robot.ctrlpannel.match.color;
    
//     if(SeenColor == Target)
//     {
//       Robot.ctrlpannel.wheelSpinner(0.0);
//       Robot.LED.setCorrect(3);
//     }
//     else
//     {
//       Robot.LED.setCustom(3,-0.99);
//       Robot.ctrlpannel.wheelSpinner(0.2);
//     }

//     setLED();

// }
//   // CalRobot.LED once the command ends or is interrupted.
//   @Override
//   public void end(boolean interrupted) 
//   {
//     Robot.ctrlpannel.wheelSpinner(0.0);
//     Robot.LED.setCustom(3,-0.99);
//   }
 
// void GetTarget()
// {
//   String gameData = DriverStation.getInstance().getGameSpecificMessage();
    
//   switch(gameData.charAt(0)){
//     case 'B':
//         Target = Robot.ctrlpannel.kRedTarget;
//         SmartDashboard.putString("Target", "Red");
//       break;
//       case 'R':
//         Target = Robot.ctrlpannel.kBlueTarget;
//         SmartDashboard.putString("Target", "Blue");
//       break;
//       case 'G':
//         Target = Robot.ctrlpannel.kYellowTarget;
//         SmartDashboard.putString("Target", "Yellow");
//       break;
//       case 'Y':
//         Target = Robot.ctrlpannel.kGreenTarget;
//          SmartDashboard.putString("Target", "Green");
//       break;
//       default:
      
//       done = true;
//       break;
//     }
// }
// void setLED()
// {
//   if(SeenColor == Target)
//   {
//     Robot.LED.setCorrect(3);
//   }
//   else if(SeenColor == Robot.ctrlpannel.kRedTarget)
//   {
//     Robot.LED.setBlue(3);
//   }
//   else if(SeenColor == Robot.ctrlpannel.kBlueTarget)
//   {
//     Robot.LED.setRed(3);
//   }
//   else if(SeenColor == Robot.ctrlpannel.kYellowTarget)
//   {
//     Robot.LED.setGreen(3);
//   }
//   else if(SeenColor == Robot.ctrlpannel.kGreenTarget)
//   {
//     Robot.LED.setYellow(3);
//   }
// }
//   @Override
//   public boolean isFinished() {
//     return done;
//   }
// }
