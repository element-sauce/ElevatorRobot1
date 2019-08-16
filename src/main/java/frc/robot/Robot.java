/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.Autonomous;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.MoveElevator;
import frc.robot.subsystems.BallElevator;
import frc.robot.subsystems.BallIntake;
import frc.robot.subsystems.BoxElevator;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.ExampleSubsystem;


public class Robot extends TimedRobot {
  // I created a hypothetical autonomous routine that so far only tests the elevator functionality.
  Command autonomous;

  // The instances are created in the classes themselves
  public static BallIntake intake = BallIntake.getInstance();
  public static Elevator box = BoxElevator.getInstance();
  public static Elevator ball = BallElevator.getInstance();

  @Override
  public void robotInit() {
    box.resetEncoder();
    ball.resetEncoder();
    autonomous = new Autonomous();
  }


  @Override
  public void robotPeriodic() {
    
  }

  @Override
  public void disabledInit() {
    
  }

  @Override
  public void disabledPeriodic() {

  }

  @Override
  public void autonomousInit() {
    // ATTN: I am going resource leak errors right here!

    (new MoveElevator("ball", ElevatorPos.CARGO_HIGH, 0.9)).start();
    (new MoveElevator("box", ElevatorPos.CARGO_LOW, 0.9)).start();
    autonomous.start();
  }

  @Override
  public void autonomousPeriodic() {

  }

  @Override
  public void teleopInit() {
    
  }

  @Override
  public void teleopPeriodic() {

  }

  @Override
  public void testPeriodic() {

  }
}
