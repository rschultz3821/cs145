package uwstout.courses.cs145.projects.chessgame;

public class Bishop extends ChessPiece {

	public Bishop(boolean side) {
		super(side);
	}

	@Override
	public PieceType getType() {
		return PieceType.BISHOP;
	}

	@Override
	public String toString() {
		// <side><type>[@<file><rank>]
		String str = "";

		if (this.isWhite()) {
			str = "WB";
		}

		if (this.isBlack()) {
			str = "BB";
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

			int[][] offsets = { { 1, 1 }, { 1, -1 }, { -1, -1 }, { -1, 1 } };

			int rank = mSquare.getRank();
			char file = mSquare.getFile();

			for (int[] offset : offsets) {
				int newRank = rank + offset[0];
				char newFile = (char) (file + offset[1]);

				while (this.canMoveTo(newRank, newFile)) {
					moves.addMove(new Square(newRank, newFile));
					newRank += offset[0];
					newFile += offset[1];
				}
			}

			return moves;
		}

		return null;
	}

}
