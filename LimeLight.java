
package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LimeLight extends SubsystemBase {
  public boolean held, done;
  private NetworkTable table;
  public NetworkTableEntry pipeline, ledMode, camMode, txvalue, tyvalue;
  public double kP, tx, ty, heading_error,distance_error,steering_adjust,distance_adjust, steering, kpAim, kpDistance;

  
  public LimeLight(boolean isHeld) {
    held = isHeld;
    table = NetworkTableInstance.getDefault().getTable("limelight");
    ledMode = table.getEntry("ledMode");
    camMode = table.getEntry("camMode");
    txvalue = table.getEntry("tx");
    tyvalue = table.getEntry("ty");
    pipeline = table.getEntry("pipeline");
  }
  public void ChangePipeline(int Pipeline)
  {
    pipeline.setDouble(Pipeline);
    
  }

  @Override
  public void periodic() 
  {
    
  }
}
