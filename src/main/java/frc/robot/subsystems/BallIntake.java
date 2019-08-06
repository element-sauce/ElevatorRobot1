/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.Constants;

/**
 * Add your docs here.
 */
public class BallIntake extends Subsystem {
  DigitalInput ball_in = new DigitalInput(Constants.kBallIntakePort);
  //some servo initialized here

  private static BallIntake instance;

  static {
    instance = new BallIntake();
  }

  public static BallIntake getInstance() {
    return instance;
  }

  public boolean isIn() {
    return ball_in.get();
  }

  public void closeBallIntake() {
    // servo.setPosition in the right direction to close
  }

  @Override
  protected void initDefaultCommand() {

  }

}
