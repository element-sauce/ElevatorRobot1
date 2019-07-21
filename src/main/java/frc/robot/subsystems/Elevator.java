package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Elevator {

  protected Encoder encoder = new Encoder(0, 1, false, Encoder.EncodingType.k4X);
  private static Elevator instance;

  static {
    instance = new Elevator();
  }

  public static Elevator getInstance() {
		return instance;
	}
  
  public void resetEncoder() {
    encoder.reset();
  }
}