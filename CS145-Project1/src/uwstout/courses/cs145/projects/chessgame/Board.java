package uwstout.courses.cs145.projects.chessgame;

/**
 * Stores a number of Squares
 * 
 * Stores a number of Squares and allows access to them
 * 
 * @author SchultzRachel
 * @version 2022.10.18
 */
public class Board {
	private Square[][] board;
	private int maxRank;
	private char maxFile;

	/**
	 * Constructor for Board
	 * 
	 * Creates Checks if the rank parameter is between 1 and 26 and that the file
	 * parameter is between 'a' and 'z'. If valid, assigns them to the corresponding
	 * class variables. Creates a 2D Square array
	 * 
	 * @param maxRank takes in int maxRank
	 * @param maxFile takes in char maxFile
	 * @throws IllegalArgumentException "The rank must be between 1 and 26." and
	 *                                  "The file must be between lowercase a and
	 *                                  z."
	 */
	public Board(int maxRank, char maxFile) throws IllegalArgumentException {
//		// Checks if the rank parameter is between 1 and 26
//		if (maxRank < 1 || maxRank > 26) {
//			throw new IllegalArgumentException("The rank must be between 1 and 26.");
//		}
//		// Checks if the file parameter is between 'a' and 'z'
//		if (maxFile < 'a' || maxFile > 'z') {
//			throw new IllegalArgumentException("The file must be between lowercase a and z.");
//		}
//
//		// assigns them to the corresponding class variables
//		this.maxRank = maxRank;
//		this.maxFile = maxFile;
//		this.board = new Square[maxRank][maxFile - 'a' + 1];
//
//		for (int rank = 1; rank <= maxRank; rank++) {
//			for (char file = 'a'; file <= maxFile; file++) {
//				this.board[rank - 1][file - 'a'] = new Square(this, rank, file);
//			}
//		}
//	}
		if ((maxRank >= 1 && maxRank <= 26) && (maxFile >= 'a' && maxFile <= 'z')) {

			this.maxRank = maxRank;
			this.maxFile = maxFile;
			board = new Square[maxRank][maxFile];

			for (int rank = 0; rank < board.length; rank++) {
				for (int file = 0; file < board[rank].length; file++) {
					this.board[rank][file] = new Square(this, (rank + 1), (char) (file + 'a'));
				}
			}

		} else {
			throw new IllegalArgumentException();
		}

	}

	/**
	 * Getter for MaxRank
	 * 
	 * Gets the MaxRank
	 * 
	 * @return this.maxRank
	 */
	public int getMaxRank() {
		return this.maxRank;
	}

	/**
	 * Getter for MaxFile
	 * 
	 * Gets the MaxFile
	 * 
	 * @return this.maxFile
	 */
	public char getMaxFile() {
		return this.maxFile;
	}

	/**
	 * Getter for MinRank
	 * 
	 * Gets the MinRank
	 * 
	 * @return 1
	 */
	public int getMinRank() {
		return 1;
	}

	/**
	 * Getter for MinFile
	 * 
	 * Gets the MinFile
	 * 
	 * @return 'a'
	 */
	public char getMinFile() {
		return 'a';
	}

	/**
	 * Getter for Square
	 * 
	 * Checks if rank and file are valid. If not, returns null. If valid, calculates
	 * the correct position in the array and returns it.
	 * 
	 * @param rank takes in int rank
	 * @param file takes in char file
	 * @return Square 2D array
	 */
	public Square getSquare(int rank, char file) {
		if (rank < this.getMinRank() || rank > this.getMaxRank()) {
			return null;
		}
		if (file < this.getMinFile() || file > this.getMaxFile()) {
			return null;
		}
		// return this.board[rank][file - 'a' + 1];
		return this.board[rank - 1][file - 'a'];

	}

	/**
	 * Method to clear the board
	 * 
	 * Removes all of the ChessPieces from the Squares on the board
	 */
	public void clearBoard() {
//		for (int rank = 1; rank <= this.maxRank; rank++) {
//			for (char file = 'a'; file <= this.maxFile; file++) {
//				if (this.getSquare(rank, file).getPiece() != null) {
//					this.getSquare(rank, file).getPiece().moveTo(null);
//					this.getSquare(rank, file).setPiece(null);
//				}
//			}
//		}
//	}

		for (int rank = 0; rank < board.length; rank++) {
			for (int file = 0; file < board[rank].length; file++) {
				if (board[rank][file].getPiece() != null) {
					board[rank][file].getPiece().moveTo(null);

				}

			}
		}
	}

	/**
	 * toString for board
	 * 
	 * Creates a String str = str + String.format("PIECE %s %x %c\n", sSide, rank,
	 * file)
	 * 
	 * @return str
	 */
	public String toString() {
		String str = "";
		for (int rank = 1; rank <= this.maxRank; rank++) {
			for (char file = 'a'; file <= this.maxFile; file++) {
				ChessPiece piece = this.getSquare(rank, file).getPiece();
				if (piece != null) {
					String sSide = "";
					if (piece.isWhite()) {
						sSide = "white";
					} else {
						sSide = "black";
					}

					str = str + String.format("PIECE %s %d %c\n", sSide, rank, file);
				}
			}
		}
		return str;
	}
}
