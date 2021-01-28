package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LEDS extends SubsystemBase {
  public VictorSP SideBlinkin = new VictorSP(4);
  public VictorSP BackBlinkin = new VictorSP(5);
  double sideCurrent, backCurrent;
  boolean override = false;
  public LEDS() 
  {
    
  }
  public void setCustom(int blinkin,double value) 
  {
    if(blinkin == 1)
    {
      SideBlinkin.set(value);
      sideCurrent = value;
    }
    if(blinkin == 2)
    {
      BackBlinkin.set(value);
      backCurrent = value;
    }
    if(blinkin == 3)
    {
      SideBlinkin.set(value);
      BackBlinkin.set(value);
      sideCurrent = value;
      backCurrent = value;
    }
    
  }
  public void setBlue(int blinkin) 
  {
    override = true;

    if(blinkin == 1)
    {
      SideBlinkin.set(-0.41);
    }
    if(blinkin == 2)
    {
      BackBlinkin.set(-0.41);
    }
    if(blinkin == 3)
    {
      SideBlinkin.set(-0.41);
      BackBlinkin.set(-0.41);
    }
    override = false;

  }
  public void setYellow(int blinkin) 
  {
    override = true;

    if(blinkin == 1)
    {
      SideBlinkin.set(0.69);
    }
    if(blinkin == 2)
    {
      BackBlinkin.set(0.69);
    }
    if(blinkin == 3)
    {
      SideBlinkin.set(0.69);
      BackBlinkin.set(0.69);
    }
    override = false;

  }
  public void setRed(int blinkin) 
  {
    override = true;

    if(blinkin == 1)
    {
      SideBlinkin.set(-0.57);
    }
    if(blinkin == 2)
    {
      BackBlinkin.set(-0.57);
    }
    if(blinkin == 3)
    {
      SideBlinkin.set(-0.57);
      BackBlinkin.set(-0.57);
    }
    override = false;

  }
  public void setGreen(int blinkin) 
  {
    override = true;

    if(blinkin == 1)
    {
      SideBlinkin.set(-0.37);
    }
    if(blinkin == 2)
    {
      BackBlinkin.set(-0.37);
    }
    if(blinkin == 3)
    {
      SideBlinkin.set(-0.37);
      BackBlinkin.set(-0.37);
    }
    override = false;

  }
  public void setUnknown(int blinkin) 
  {
    override = true;
    if(blinkin == 1)
    {
      SideBlinkin.set(-0.79);
    }
    if(blinkin == 2)
    {
      BackBlinkin.set(-0.79);
    }
    if(blinkin == 3)
    {
      SideBlinkin.set(-0.79);
      BackBlinkin.set(-0.79);
    }
    override = false;

  }
  public void setCorrect(int blinkin) 
  {
    override = true;
    if(blinkin == 1)
    {
      SideBlinkin.set(-0.05);
    }
    if(blinkin == 2)
    {
      BackBlinkin.set(-0.05);
    }
    if(blinkin == 3)
    {
      SideBlinkin.set(-0.05);
      BackBlinkin.set(-0.05);

    }
    override = false;

  }
  public void setGearShift(boolean shifted){
    String gameData = DriverStation.getInstance().getAlliance().toString();
    SmartDashboard.putString("Team", gameData);

    if (gameData == "Red")
    {
      if(shifted)
      {
      SideBlinkin.set(0.59);
      sideCurrent = 0.59;

      }
      else
      {
        SideBlinkin.set(0.65);
        sideCurrent = 0.65;


      }
    }

    if (gameData == "Blue")
    {
      if(shifted)
      {
        SideBlinkin.set(0.85);
        sideCurrent = 0.85;

      }
      else
      {
        SideBlinkin.set(0.83);
        sideCurrent = 0.83;
      }
    }
    
  }
  public void WinchReset(int blinkin)
  {
    if(blinkin == 1)
    {
      override = true;
      Timer.delay(0.5);
      SideBlinkin.set(0.69);      
      Timer.delay(0.5);
      SideBlinkin.set(0.61);
      Timer.delay(0.5);
      SideBlinkin.set(0.87);
      Timer.delay(0.5);
      override = false;
    }
    if(blinkin == 2)
    {
      override = true;
      Timer.delay(0.5);
      BackBlinkin.set(0.69);
      Timer.delay(0.5);
      BackBlinkin.set(0.61);
      Timer.delay(0.5);
      BackBlinkin.set(0.87);
      Timer.delay(0.5);
      override = false;
    }
    if(blinkin == 3)
    {
      override = true;
      Timer.delay(0.5);
      SideBlinkin.set(0.69);      
      BackBlinkin.set(0.69);
      Timer.delay(0.5);
      SideBlinkin.set(0.61);
      BackBlinkin.set(0.61);
      Timer.delay(0.5);
      SideBlinkin.set(0.87);
      BackBlinkin.set(0.87);
      Timer.delay(0.5);
      override = false;
      
    }
  }
  public void WheelReset(int blinkin)
  {
    if(blinkin == 1)
    {
      override = true;
      Timer.delay(0.5);
      SideBlinkin.set(-0.07);      
      Timer.delay(1);
      override = false;
    }
    if(blinkin == 2)
    {
      override = true;
      Timer.delay(0.5);
      BackBlinkin.set(-0.07);
      Timer.delay(1);
      override = false;
    }
    if(blinkin == 3)
    {
      override = true;
      Timer.delay(0.5);
      SideBlinkin.set(-0.07);      
      BackBlinkin.set(-0.07);
      Timer.delay(1);
      override = false;
      
    }
  }
  public void Auto(boolean override)
  {
    this.override = override;
   
      override = true;
      Timer.delay(0.5);
      SideBlinkin.set(0.69);      
      BackBlinkin.set(0.69);
      Timer.delay(1);
      SideBlinkin.set(-0.07);
      BackBlinkin.set(-0.07);
      Timer.delay(1);
     
      
    
  }
  public void LimeLightTracking(boolean override)
  {
    this.override = override;
    if(override == true)
    {
    BackBlinkin.set(0.69);
    }
    
  }
  
  public void LimeLightFound(boolean override)
  {
    this.override = override;
    if(override == true)
    {
   BackBlinkin.set(0.75);
    }
  }
  public void ToClose(boolean override)
  {
    this.override = override;
    if(override == true)
    {
    BackBlinkin.set(-0.11);
    }
    
  }
  public void ShootNow (boolean override)
  {
    this.override = override;
    if(override == true)
    {
    BackBlinkin.set(-0.05);
    }  
  }
  @Override
  public void periodic() {
    if(!override)
    {
    SideBlinkin.set(sideCurrent);
    BackBlinkin.set(backCurrent);
    }
    // This method will be called once per scheduler run
  }
}
