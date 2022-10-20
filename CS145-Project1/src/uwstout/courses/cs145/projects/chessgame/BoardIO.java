package uwstout.courses.cs145.projects.chessgame;

//import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This class is able to read from input and write to output, including files.
 * 
 * This class does not store anything and does not need a constructor. *
 * 
 * @author SchultzRachel
 * @version 2022.10.18
 */
public class BoardIO {

	/**
	 * Creates a boolean readBoard
	 * 
	 * Checks if the board and scanner exists. Then reads each line in the format:
	 * <type> <side> <rank> <file> Next it finds the square and converts it to a
	 * boolean. Then sets the chess piece and square to each other. Lastly, it
	 * always closes lineScan.
	 * 
	 * @param board   takes in Board board
	 * @param scanner takes in Scanner scanner
	 * @return true or false
	 */
	private boolean readBoard(Board board, Scanner scanner) throws IllegalArgumentException {
		// board and scanner must exist
		if (board == null || scanner == null) {
			return false;
		}

		// clear the board
		board.clearBoard();

		// read new line
		while (scanner.hasNext()) {
			String line = scanner.nextLine();
			Scanner lineScan = new Scanner(line);
			lineScan.useDelimiter(" ");

			// read type, side, rank, file
			//// Each line has the format: <type> <side> <rank> <file>
			try {
				String type = lineScan.next();
				String side = lineScan.next();
				int rank = lineScan.nextInt();
				char file = lineScan.next().charAt(0);

				// find square
				Square square = board.getSquare(rank, file);

				// convert side to boolean
				boolean bSide;
				if (side.toLowerCase().equals("white")) {
					bSide = true;
				} else if (side.toLowerCase().equals("black")) {
					bSide = false;
				} else {
					throw new IllegalArgumentException("Side must be white or black.");
				}

				// sets the chess piece and square to each other
				ChessPiece piece = new ChessPiece(bSide);
				piece.moveTo(square);
				square.setPiece(piece);

			} catch (Exception e) {
				System.out.println(e);
			} finally {
				lineScan.close();
			}
		}
		scanner.close();
		return true;
	}

	/**
	 * Creates a boolean loadBoardState
	 * 
	 * Loads the board state
	 * 
	 * @param board   takes in Board board
	 * @param scanner takes in Scanner scanner
	 * @return readBoard(board, scanner)
	 */
	public boolean loadBoardState(Board board, Scanner scanner) {
		return readBoard(board, scanner);
	}

	/**
	 * Creates a boolean loadBoardState
	 * 
	 * Reads data from a file
	 * 
	 * @param board    takes in Board board
	 * @param fileName takes in String fileName
	 * @return true or false
	 */
	public boolean loadBoardState(Board board, String fileName) {
		try {
			File file = new File(fileName);
			Scanner scanner = new Scanner(file);
			return readBoard(board, scanner);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	/**
	 * Creates a boolean saveBoard
	 * 
	 * If either of the parameters is null, it returns false. Otherwise, it writes
	 * the data and returns true
	 * 
	 * @param board  takes in Board board
	 * @param writer takes in PrintWriter writer
	 * @return true or false
	 */
	private boolean saveBoard(Board board, PrintWriter writer) {
		if (board == null || writer == null) {
			return false;
		}

		writer.print(board);

		writer.close();
		return true;
	}

	/**
	 * Creates a boolean saveBoardState
	 * 
	 * Saves the board
	 * 
	 * @param board  takes in Board board
	 * @param writer takes in PrintWriter writer
	 * @return true or false
	 */
	public boolean saveBoardState(Board board, PrintWriter writer) {
		return saveBoard(board, writer);
	}

	/**
	 * Creates boolean saveBoardState
	 * 
	 * Opens and writes to a file. If the file is invalid it returns false.
	 * 
	 * @param board    takes in Board board
	 * @param fileName takes in String fileName
	 * @return true or false
	 */
	public boolean saveBoardState(Board board, String fileName) {
		try {
			File variableName = new File(fileName);
			PrintWriter writer = new PrintWriter(variableName);
			return saveBoard(board, writer);
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

}
