package uwstout.courses.cs145.projects.chessgame;

public class Knight extends ChessPiece {

	public Knight(boolean side) {
		super(side);
	}

	@Override
	public PieceType getType() {
		return PieceType.KNIGHT;
	}

	@Override
	public String toString() {
		// <side><type>[@<file><rank>]
		String str = "";

		if (this.isWhite()) {
			str = "WN";
		}

		if (this.isBlack()) {
			str = "BN";
		}

		if (this.mSquare != null) {
			str = String.format("%s@%s", str, this.mSquare);
		}

		return str;
	}

	@Override
	public MoveList getPossibleMoves() {
		if (this.mSquare != null) {
			MoveList moves = new MoveList();

			int[][] offsets = { { 1, 2 }, { 2, 1 }, { 2, -1 }, { 1, -2 },
					{ -1, -2 }, { -2, -1 }, { -2, 1 }, { -1, 2 } };

			int rank = mSquare.getRank();
			char file = mSquare.getFile();

			for (int i = 0; i < offsets.length; i++) {
				int newRank = rank + offsets[i][0];
				char newFile = (char) (file + offsets[i][1]);

				if (this.canMoveTo(newRank, newFile)) {
					moves.addMove(new Square(newRank, newFile));
				}
			}

			return moves;
		}

		return null;
	}
}
