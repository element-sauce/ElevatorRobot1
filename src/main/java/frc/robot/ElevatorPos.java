package frc.robot;

import frc.robot.Constants;

public enum ElevatorPos {
    ZERO(0), 
    ZERO_ABOVE(Constants.SAFE_ELEVATOR_GAP),
    CARGO_LOW_BELOW(Constants.BOX-Constants.SAFE_ELEVATOR_GAP), 
    CARGO_LOW(Constants.BOX), 
    CARGO_LOW_ABOVE(Constants.BOX+Constants.SAFE_ELEVATOR_GAP), 
    CARGO_HIGH_BELOW(Constants.BALL-Constants.SAFE_ELEVATOR_GAP),
    CARGO_HIGH(Constants.BALL),
    CARGO_HIGH_ABOVE(Constants.BALL+Constants.SAFE_ELEVATOR_GAP);

    private final double val;
    
    /**
     * @param value refers to the number of encoder ticks of a certain position
     */
    private ElevatorPos(double value) {
        this.val = value;
    }

    public double getValue() {
        return val;
    }
}