package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;


import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Elevator {
  
  public WPI_TalonSRX talon  = new WPI_TalonSRX(0);
  protected Encoder encoder = new Encoder(Constants.encoderInputOne, Constants.encoderInputTwo, false, Encoder.EncodingType.k4X);
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

  public double getPosition() {
    return encoder.get();
  }



}