package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class ColourArm extends InstantCommand 
{
    public boolean pos, run = true;
  
    public ColourArm() 
    {

    }

    @Override
    public void initialize()
    {

      if(Robot.pneumaticColorArm.get())
      {
        run = true;
        while(pos == true && run == true)
        {
          Robot.piston.ColourArmRetract();
          run = false;
          pos =false;
        }
        while(pos == false && run == true)
        {
          Robot.piston.ColourArmExtend();
          run = false;
          pos = true;
        }
     }
    }
}
