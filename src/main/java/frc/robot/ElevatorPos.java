public enum ElevatorPos {
    // ZERO(0), RELEASE_CARGO_MECH(7), CARGO_LOW(2.4), CARGO_MID(98.6), CARGO_HIGH(191), CARGO_PICKUP(0), CARGO_GROUND(0), HATCH_LOW(22.4), HATCH_MID(118.6), HATCH_HIGH(197), HATCH_PICKUP(0);
    ZERO(0), CARGO_LOW(10.0), CARGO_HIGH(30.0);

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