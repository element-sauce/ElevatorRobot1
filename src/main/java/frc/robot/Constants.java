/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class Constants {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  // The ball intake port
  public static int kBallIntakePort = 0;

  // I added these two for the inputs of the Encoder constructor
  public static int encoderInputOne = 0;
  public static int encoderInputTwo = 1;

  // The position of where the ball mechanism is meant to be
  public static final double BALL = 20.0;

  //The position of where the box mechanism is meant to be
  public static final double BOX = 50.0;

  // The margin that should be maintained between the two elevators at all times. Whether the code actually does this rn is questionable.
  public static final double SAFE_ELEVATOR_GAP = 5.0;

  // The value defining slow power for the elevator talon
  public static final double ELEVATOR_SLOW_POWER = 0.5;

  private Constants()
  {
  }
}
