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
		// <side><type>[@<file><rank>
		String str = "";

		String sSideType = "";

		if (isWhite()) {
			sSideType = "WB";
		} else {
			sSideType = "BB";
		}
		if (mLocation != null) {
			sSideType = sSideType + "@" + mLocation;
		}
		str = sSideType;

		return str;
	}

//	@Override
//	public MoveList getPossibleMoves() {
//		if (mLocation != null) {
//			MoveList moves = new MoveList();
//
//		}
//
//		return null;
//	}

}
