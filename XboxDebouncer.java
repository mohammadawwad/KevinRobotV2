package frc.robot.classes;


import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.XboxController;

public class XboxDebouncer 
{
    int buttonnum;
    double latest;
    double debounce_period;
    XboxController controller;
        
    public XboxDebouncer(XboxController controller,int buttonnum)
    {
      this.controller = controller;
      this.buttonnum = buttonnum;
      this.latest = 0;
      this.debounce_period = 0.25;
        
    }

    public void setDebouncePeriod(float period)
    {
      this.debounce_period = period;
    }

    public boolean get()
    {
            double now = Timer.getFPGATimestamp();
            if(controller.getRawButton(buttonnum));
            {
                if((now - latest) > debounce_period)
                {
                        latest = now;
                        return true;

                }
            }
            return false;
    }

        

}
