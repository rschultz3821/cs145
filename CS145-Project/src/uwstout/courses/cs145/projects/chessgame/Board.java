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
	private static final int MIN_RANK = 1;
	private static final int MAX_RANK = 26;
	private static final char MIN_FILE = 'a';
	private static final char MAX_FILE = 'z';

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
		if ((maxRank >= MIN_RANK && maxRank <= MAX_RANK) && (maxFile >= MIN_FILE && maxFile <= MAX_FILE)) {

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
					String sideString = "";
					if (piece.isWhite()) {
						sideString = "white";
					} else {
						sideString = "black";
					}

					PieceType type = piece.getType();
					String typeString = "";
					if (type != null) {
						typeString = type.toString();
					} else {
						typeString = "PIECE";
					}

					str = str + String.format("%s %s %d %c\n", typeString, sideString, rank, file);
				}
			}
		}
		return str;
	}

}
