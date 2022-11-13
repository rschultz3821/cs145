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
		// <side><type>[@<file><rank>
		String str = "";

		String sSideType = "";

		if (isWhite()) {
			sSideType = "WN";
		} else {
			sSideType = "BN";
		}
		if (mLocation != null) {
			sSideType = sSideType + "@" + mLocation;
		}
		str = sSideType;

		return str;
	}

	@Override
	public MoveList getPossibleMoves() {
		if (mLocation != null) {
			MoveList moves = new MoveList();
			// rank + 2, file + 1
			Square sqr = new Square(rank, file);
			if(canMoveTo(sqr.getRank() + 2, (char)(sqr.getFile() + 1)) ) {
				addMove(moves, rank + 2, (char)(file + 1));
			}
			
			// rank + 1, file + 2
		
			
			// rank - 1, file + 2
			
			// rank - 2, file + 1
			// rank - 2, file - 1
			// rank - 1, file - 2
			// rank + 1, file - 2
			// rank + 2, file - 1

		}

		return null;
	}
}
