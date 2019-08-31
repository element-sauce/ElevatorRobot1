/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class PTOSubsystem extends Subsystem {
  
  public TalonSRX talon;
  private final Solenoid solenoid;
  
  public enum Mode {
    ARM,
    CLIMBER
  }

  private Mode shiftingTranmissionMode;

  private static PTOSubsystem instance;
  private static Object solenoidLock = new Object();
  
  static {
    instance = new PTOSubsystem();
  }

  private PTOSubsystem() {
    super();
    talon = new TalonSRX(0);
    solenoid = new Solenoid(1);
    shiftingTranmissionMode = Mode.ARM;
  }

  public Mode getMode() {
    return shiftingTranmissionMode;
  }

  public static PTOSubsystem getInstance() {
    synchronized(PTOSubsystem.class) {
      return instance;
    }
	}

  public void actuate() {
    synchronized (solenoidLock) {
      if (shiftingTranmissionMode == Mode.ARM) {
        solenoid.set(true);
        shiftingTranmissionMode = Mode.CLIMBER;
      } else {
        solenoid.set(false);
        shiftingTranmissionMode = Mode.ARM;
      }
    }
  }

  public void stop() {
    talon.set(ControlMode.PercentOutput, 0);
  }

  @Override
  public void initDefaultCommand() {
    
  }
}
