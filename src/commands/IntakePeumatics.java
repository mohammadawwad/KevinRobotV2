package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class IntakePeumatics extends InstantCommand 
{
    public boolean pos, run = true;
  
    public IntakePeumatics() 
    {

    }

    @Override
    public void initialize()
    {

      if(Robot.xboxDebouncer.get())
      {
        run = true;
        while(run == true && Robot.global.IntakeShiftPosition == true)
        {
          Robot.piston.FeederOut();
          run = false;
          pos =false;
          Robot.global.IntakeShiftPosition = !Robot.global.IntakeShiftPosition;
        }
        while(run == true && Robot.global.IntakeShiftPosition == false)
        {
          Robot.piston.FeederIn();
          run = false;
          pos = true;
          Robot.global.IntakeShiftPosition = !Robot.global.IntakeShiftPosition;
      }
    }
    }
}
