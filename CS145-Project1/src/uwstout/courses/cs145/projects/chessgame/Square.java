package uwstout.courses.cs145.projects.chessgame;

/**
 * Represents a single square on the chess board
 * 
 * It has a Rank(row) and a file(column) for its position on the board, and it
 * keeps track of the board it is part of and the piece that it is on.
 * 
 * @author SchultzRachel
 * @version 2022.10.18
 */
public class Square {

	private int rank;
	private char file;
	private Board board;
	private ChessPiece piece;

	/**
	 * Constructor for Square
	 * 
	 * Stores a board, rank, and file
	 * 
	 * @param board takes in a Board board
	 * @param rank  takes in a int rank
	 * @param file  takes in a char file
	 */
	public Square(Board board, int rank, char file) {
		this.board = board;
		this.rank = rank;
		this.file = file;
		this.piece = null;
	}

	/**
	 * Constructor for Square
	 * 
	 * Stores a rank and file and sets board and piece to null
	 * 
	 * @param rank takes in a int rank
	 * @param file takes in a char file
	 */
	public Square(int rank, char file) {
		this.rank = rank;
		this.file = file;
		this.board = null;
		this.piece = null;
	}

	/**
	 * Getter for rank
	 * 
	 * Gets the rank
	 * 
	 * @return this.rank
	 */
	public int getRank() {
		return this.rank;
	}

	/**
	 * Getter for file
	 * 
	 * Gets the file
	 * 
	 * @return this.file
	 */
	public char getFile() {
		return this.file;
	}

	/**
	 * Getter for Board board
	 * 
	 * Gets the board
	 * 
	 * @return this.board
	 */
	public Board getBoard() {
		return this.board;
	}

	/**
	 * Getter for ChessPiece piece
	 * 
	 * Gets the piece
	 * 
	 * @return this.piece
	 */
	public ChessPiece getPiece() {
		return this.piece;
	}

	/**
	 * Sets the ChessPiece piece
	 * 
	 * Sets the piece
	 * 
	 * @param piece takes in ChessPiece piece
	 * @throws IllegalArgumentException "Chess pieces cannot share a square."
	 */
	public void setPiece(ChessPiece piece) {
		/*
		 * if (this.piece != null) { throw new
		 * IllegalArgumentException("Chess pieces cannot share a square."); }
		 */
		this.piece = piece;
	}

	/**
	 * toString method
	 * 
	 * Creates a toString for Square
	 * 
	 * @return String
	 */
	public String toString() {
		return String.format("%c%x", file, rank);
	}

}
