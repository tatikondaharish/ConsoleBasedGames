package tetris;

public enum RotationState {
	ANGLE_0, ANGLE_90, ANGLE_180, ANGLE_270;

	public static RotationState getType(int i) {
		return values()[i];
	}
}