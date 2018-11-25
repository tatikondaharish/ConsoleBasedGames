package tetris;


public enum MoveType {
	LEFT, RIGHT, COUNTER_CLOCK, CLOCK_WISE,DOWN;

	public static MoveType getType(int i) {
		return values()[i];
	}
}