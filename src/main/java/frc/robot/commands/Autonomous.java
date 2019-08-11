/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.ElevatorPos;

public class Autonomous extends CommandGroup {
  /**
   * Add your docs here.
   */
  public Autonomous() {
    // Add Commands here:
    // e.g. addSequential(new Command1());
    // addSequential(new Command2());
    // these will run in order.

    // To run multiple commands at the same time,
    // use addParallel()
    // e.g. addParallel(new Command1());
    // addSequential(new Command2());
    // Command1 and Command2 will run in parallel.

    // A command group will require all of the subsystems that each member
    // would require.
    // e.g. if Command1 requires chassis, and Command2 requires arm,
    // a CommandGroup containing them would require both the chassis and the
    // arm.

    /**
     * This hypothetical series of sequential commands is intended to sufficiently test the 
     * correctness of the code. I just set all the power to 0.9.
     * 
     * 1. The ball elevator first moves to the low cargo position intended 
     * normally for the box
     * 
     * 2. The box elevator moves to the low cargo position and the ball elevator is expected to move up to 
     * make way with the box elevator.
     * 
     * 3. The ball elevator moves to the "zero position", where the box elevator moves down to compensate, meaning 
     * the ball elevator's final position is below even the ball elevator under it.
     */

    addSequential(new MoveElevator("ball", ElevatorPos.CARGO_LOW, 0.9));
    addSequential(new MoveElevator("box", ElevatorPos.CARGO_LOW, 0.9));
    addSequential(new MoveElevator("ball", ElevatorPos.ZERO, 0.9));
  }
}
