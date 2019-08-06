package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.ElevatorPos;
import frc.robot.Constants;

/**
 * An example subsystem.  You can replace me with your own Subsystem.
 */
public class Elevator extends Subsystem {
  
  public WPI_TalonSRX talon  = new WPI_TalonSRX(0);
  protected Encoder encoder = new Encoder(Constants.encoderInputOne, Constants.encoderInputTwo, false, Encoder.EncodingType.k4X);
  
  private static Elevator instance;
  public ElevatorPos executingPosition;

  static {
    instance = new Elevator();
  }

  public void set(double speed) {
    talon.set(speed);
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

  public void stop() {
    talon.set(0);
  }

  /*
   * Real get encoder ticks
   */
  public synchronized int getEncoderTicks() {
    return talon.getSelectedSensorPosition(0); //assuming port 0 is associated with the talon encoder.
  }

  public ElevatorPos getElevatorPos() {
    return executingPosition;
  }

  public void setElevatorPos(ElevatorPos e) {
    executingPosition = e;

  }

  public boolean isMoving() {
    return Math.abs(talon.get()) > 0.01;
  }

  @Override
  protected void initDefaultCommand() {

  }

}