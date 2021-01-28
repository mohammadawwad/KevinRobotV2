package frc.robot.classes;


import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Button;

public class AxisButton extends Button
{
    public XboxController xbox;
    public int axis;
    public AxisButton(XboxController xbox, int axis)
    {
        this.xbox = xbox;
        this.axis = axis;
    }

    public boolean get()
    {
        return xbox.getRawAxis(axis) > 0;
    }

}
