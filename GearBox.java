package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class GearBox extends InstantCommand 
{
    public boolean pos, run = true;
  
    public GearBox() 
    {

    }

    @Override
    public void initialize()
    {

      if(Robot.joystickDebouncer.get())
      {
        run = true;
        while(run == true && Robot.global.GearShiftPosition == true)
        {
          Robot.piston.GearShiftExtend();
          run = false;
          pos =false;
          Robot.LED.setGearShift(false);
          Robot.global.GearShiftPosition = !Robot.global.GearShiftPosition;
        }
        while(run == true && Robot.global.GearShiftPosition == false)
        {
          Robot.piston.GearShiftRetract();
          run = false;
          pos = true;
          Robot.global.GearShiftPosition = !Robot.global.GearShiftPosition;
          Robot.LED.setGearShift(true);
        }
    }
  }
}
