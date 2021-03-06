/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class LinearSlideSubsystem extends Subsystem {
  
  private final Solenoid sliderPusher;
  private static LinearSlideSubsystem instance;

  static {
    instance = new LinearSlideSubsystem();
  }

  private LinearSlideSubsystem() {
    super();
    sliderPusher = new Solenoid(2);
  }

  @Override
  public void initDefaultCommand() {
    
  }
}
