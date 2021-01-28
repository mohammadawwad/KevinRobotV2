package frc.robot.classes;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Timer;

public class JoystickDebouncer 
{
        Joystick joystick;
        int buttonnum;
        double latest;
        double debounce_period;
 
        public JoystickDebouncer(Joystick joystick, int buttonnum)
        {
            this.joystick = joystick;
            this.buttonnum = buttonnum;
            this.latest = 0;
            this.debounce_period = 0.5;
        }


        public void setDebouncePeriod(float period)
        {
            this.debounce_period = period;
        }

        public boolean get()
        {
            double now = Timer.getFPGATimestamp();
            if(joystick.getRawButton(buttonnum));
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
