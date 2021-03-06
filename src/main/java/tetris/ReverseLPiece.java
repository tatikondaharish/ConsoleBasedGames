package tetris;

public class ReverseLPiece extends PieceBase {

	public ReverseLPiece(PieceType type, int x, Board board) {
		super(type, board);
		for (int i = 0; i < numPoints - 1; i++) {
			this.points[i] = new Point(x + 1, i);
		}
		this.points[numPoints - 1] = new Point(x, 2);
	}

	@Override
	protected void moveCounterClock(Point[] pts) {
		switch (posture) {
		case ANGLE_0:
			pts[0].x--;
			pts[0].y++;
			pts[2].x++;
			pts[2].y--;
			pts[3].x += 2;
			// pts[3].y -= 2;
			break;
		case ANGLE_90:
			pts[0].x++;
			pts[0].y++;
			pts[2].x--;
			pts[2].y--;
			// pts[3].x -= 2;
			pts[3].y -= 2;
			break;
		case ANGLE_180:
			pts[0].x++;
			pts[0].y--;
			pts[2].x--;
			pts[2].y++;
			pts[3].x -= 2;
			// pts[3].y += 2;
			break;
		case ANGLE_270:
			pts[0].x--;
			pts[0].y--;
			pts[2].x++;
			pts[2].y++;
			// pts[3].x += 2;
			pts[3].y += 2;
			break;
		}
	}

	@Override
	protected void moveClockWise(Point[] pts) {
		switch (posture) {
		case ANGLE_0:
			pts[0].x++;
			pts[0].y++;
			pts[2].x--;
			pts[2].y--;
			// pts[3].x -= 2;
			pts[3].y -= 2;
			break;
		case ANGLE_90:
			pts[0].x++;
			pts[0].y--;
			pts[2].x--;
			pts[2].y++;
			pts[3].x -= 2;
			// pts[3].y += 2;
			break;
		case ANGLE_180:
			pts[0].x--;
			pts[0].y--;
			pts[2].x++;
			pts[2].y++;
			// pts[3].x += 2;
			pts[3].y += 2;
			break;
		case ANGLE_270:
			pts[0].x--;
			pts[0].y++;
			pts[2].x++;
			pts[2].y--;
			pts[3].x += 2;
			// pts[3].y -= 2;
			break;
		}
	}

}