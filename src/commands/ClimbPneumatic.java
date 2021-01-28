package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.Robot;

public class ClimbPneumatic extends InstantCommand 
{
    public boolean pos, run = true;
  
    public ClimbPneumatic() 
    {

    }

    @Override
    public void initialize()
    {

      if(Robot.pneumaticClimb.get())
      {
        run = true;
        while(pos == true && run == true)
        {
          Robot.piston.ClimbExtend();
          run = false;
          pos =false;
        }
        while(pos == false && run == true)
        {
          Robot.piston.ClimbRetract();
          run = false;
          pos = true;
        }
     }
   }
}
