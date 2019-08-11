package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.ElevatorPos;
import frc.robot.Robot;

public class MoveElevator extends Command {
    private double speed;
    private String elevator;
    private ElevatorPos pos;
    private int initTickDelta;
    private double executingLocation;

    public MoveElevator(String elevator, ElevatorPos pos, double speed) {
        requires(Robot.box);
        requires(Robot.ball);
        this.speed = speed;
        this.elevator = elevator;
        this.pos = pos;
    }

    @Override
    protected void initialize() {
        if (pos != ElevatorPos.CARGO_HIGH && pos != ElevatorPos.CARGO_LOW && pos != ElevatorPos.ZERO) return;

        int ballPosition = Robot.ball.getEncoderTicks(); //unsure if the initial will be 0 or SAFE_ELEVATOR_GAP, will need to check
        int boxPosition = Robot.box.getEncoderTicks(); 

        if (elevator.equals("box")) {
            Robot.box.setElevatorPos(pos);
            executingLocation = Robot.box.executingPosition.getValue();

            if (ballPosition <= executingLocation) {
                if (Robot.box.executingPosition == ElevatorPos.CARGO_LOW) {
                    MoveElevator e = new MoveElevator("ball", ElevatorPos.CARGO_LOW_ABOVE, 0.5);
                    e.start();
                } else if (Robot.box.executingPosition == ElevatorPos.CARGO_HIGH) {
                    MoveElevator e = new MoveElevator("ball", ElevatorPos.CARGO_HIGH_ABOVE, 0.5);
                    e.start();
                }
            }
            initTickDelta = (int)executingLocation - boxPosition;
        } else if (elevator.equals("ball")) {
            Robot.ball.setElevatorPos(pos);
            executingLocation = Robot.ball.executingPosition.getValue();

            if (boxPosition >= executingLocation) {
                if (Robot.ball.executingPosition == ElevatorPos.ZERO_ABOVE) {
                    MoveElevator e = new MoveElevator("box", ElevatorPos.ZERO, 0.5);
                    e.start();
                } else if (Robot.ball.executingPosition == ElevatorPos.CARGO_LOW) {
                    MoveElevator e = new MoveElevator("box", ElevatorPos.CARGO_LOW_BELOW, 0.5);
                    e.start();
                } else if (Robot.ball.executingPosition == ElevatorPos.CARGO_HIGH) {
                    MoveElevator e = new MoveElevator("box", ElevatorPos.CARGO_HIGH_BELOW, 0.5);
                    e.start();
                } 
            }
            initTickDelta = (int)executingLocation - Robot.ball.getEncoderTicks();
        }    
    }

    @Override 
    protected void execute() {
        //TODO: decrease the speed of the motor once it reaches some range within the specified target.

        if (elevator.equals("box")) {
            Robot.box.set(speed);
        } else if (elevator.equals("ball")) {
            Robot.ball.set(speed);
        }
    }

    @Override
    protected void end() {

    }

    @Override
    protected boolean isFinished() {
        double currentTicks = 0;
        if (elevator.equals("box")) {
           currentTicks = Robot.box.getEncoderTicks();
        } else if (elevator.equals("ball")) {
            currentTicks = Robot.ball.getEncoderTicks();
        }

        if (initTickDelta > 0) {
            return (executingLocation - 2) < currentTicks;
        } else {
            return (executingLocation + 2) > currentTicks;
        }
    }

    @Override
    protected void interrupted() {
        
    }
    
 }