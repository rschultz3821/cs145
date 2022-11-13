package uwstout.courses.cs145.projects.chessgame;

public class PieceFactory {

	private PieceFactory() {

	}

	public static ChessPiece createPiece(PieceType piece, boolean side) {
		switch (piece) {
		case BISHOP:
			return new Bishop(side);
		default:
			return new Knight(side);
		}
	}
}
