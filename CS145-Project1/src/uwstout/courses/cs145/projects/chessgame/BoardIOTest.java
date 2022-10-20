package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

/**
 * Test for BoardIO
 * 
 * Tests BoardIO class
 * 
 * @author SchultzRachel
 * @version 2022.10.18
 */
public class BoardIOTest {

	private int countPieces(Board board) throws ArrayIndexOutOfBoundsException {
		int count = 0;
		// check all of the squares
		for (int r = 1; r <= board.getMaxRank(); r++) {
			for (char f = 'a'; f <= board.getMaxFile(); f++) {
				// if there is a piece there, count it
				if (board.getSquare(r, f).getPiece() != null) {
					count++;
				}
			}
		}
		return count;
	}

	private void checkPiece(Board b, String type, boolean wSide, int rank, char file) {
		Square sq = b.getSquare(rank, file);
		ChessPiece p = sq.getPiece();
		assertNotNull("No chess piece was on the square " + file + rank + ".", p);
		// TODO uncomment this for project 2
		// assertEquals(type, p.getType().name());
		assertEquals(wSide, p.isWhite());
	}

	/**
	 * Test for loadBoardStateScanner
	 * 
	 * Makes sure loadBoardStateScanner is working and returning true
	 */
	@Test
	public void testLoadBoardStateBoardScanner() {
		// loads the data for the input
		// BISHOP and KNIGHT are okay since checkPiece
		// is not checking the type
		Scanner input = new Scanner("PIECE blue 1 d \n" + "PIECE white 0 g \n" + "PIECE white 27 g \n"
				+ "PIECE white 2 `\n" + "PIECE white 2 {\n" + "PIECE white\n" + "PIECE white 2 g\n"
				+ "PIECE black 5 a\n" + "PIECE black 6 d\n");
		BoardIO io = new BoardIO();
		Board board = new Board(8, 'h');

		// should read in 4 values
		boolean result = io.loadBoardState(board, input);

		// check if loaded
		assertTrue(result);
		// check the number of pieces on the board
		assertEquals(3, countPieces(board));
		// check each piece
		checkPiece(board, "PIECE", true, 2, 'g');
		checkPiece(board, "PIECE", false, 5, 'a');
		checkPiece(board, "PIECE", false, 6, 'd');
		input.close();
	}

	/**
	 * Test for loadBoardStateBoardString
	 * 
	 * Makes sure loadBoardStateBoardString is working Takes in an input and returns
	 * true
	 */
	@Test
	public void testLoadBoardStateBoardString() {
		// loads the data for the input
		// BISHOP and KNIGHT are okay since checkPiece
		// is not checking the type

		BoardIO io = new BoardIO();
		Board board = new Board(8, 'h');

		boolean result = io.loadBoardState(board, "input.txt");

		assertTrue(result);

		// check the number of pieces on the board
		assertEquals(4, countPieces(board));

		// check each piece
		checkPiece(board, "BISHOP", false, 1, 'd');
		checkPiece(board, "KNIGHT", true, 2, 'g');
		checkPiece(board, "KNIGHT", false, 5, 'a');
		checkPiece(board, "BISHOP", false, 6, 'd');
	}

	/**
	 * Test for saveBoardStateBoardPrintWriter
	 * 
	 * Makes sure saveBoardStateBoardPrintWriter is working Creates an output file
	 * with the correct information
	 */
	@Test
	public void testSaveBoardStateBoardPrintWriter() {
		Board board = new Board(8, 'h');
		// create pieces

		// pieces (i.e. Bishop or Knight)
		ChessPiece p1 = new ChessPiece(false);
		ChessPiece p2 = new ChessPiece(true);
		ChessPiece p3 = new ChessPiece(false);
		ChessPiece p4 = new ChessPiece(false);
		// place them on the board
		p1.moveTo(board.getSquare(1, 'd'));
		p2.moveTo(board.getSquare(2, 'g'));
		p3.moveTo(board.getSquare(5, 'a'));
		p4.moveTo(board.getSquare(6, 'd'));

		// create SpriteIO with some data
		BoardIO io = new BoardIO();
		// write it to a file
		PrintWriter pw = null;
		try {
			pw = new PrintWriter("output.txt");
		} catch (FileNotFoundException e2) {

			e2.printStackTrace();

		}
		// try {
		io.saveBoardState(board, pw);
		// } catch (FileNotFoundException e1) {
		// e1.printStackTrace();
		// }

		// now check file
		File file = new File("output.txt");
		try {
			Scanner in = new Scanner(file);
			String line;
			line = in.nextLine().trim();

			assertEquals("PIECE black 1 d", line);
			line = in.nextLine().trim();
			assertEquals("PIECE white 2 g", line);
			line = in.nextLine().trim();
			assertEquals("PIECE black 5 a", line);
			line = in.nextLine().trim();
			assertEquals("PIECE black 6 d", line);

			in.close();
		} catch (FileNotFoundException e) {
			fail("Couldn't open file");
		}
	}

	/**
	 * Test for saveBoardStateBoardString
	 * 
	 * Makes sure saveBoardStateBoardString is working Creates an output file with
	 * the correct information
	 */
	@Test
	public void testSaveBoardStateBoardString() {
		// fail("Not yet implemented");
		Board board = new Board(8, 'h');
		// create pieces
		// TODO for Project 2, make these specific
		// pieces (i.e. Bishop or Knight)
		ChessPiece p1 = new ChessPiece(false);
		ChessPiece p2 = new ChessPiece(true);
		ChessPiece p3 = new ChessPiece(false);
		ChessPiece p4 = new ChessPiece(false);
		// place them on the board
		p1.moveTo(board.getSquare(1, 'd'));
		p2.moveTo(board.getSquare(2, 'g'));
		p3.moveTo(board.getSquare(5, 'a'));
		p4.moveTo(board.getSquare(6, 'd'));
		// create SpriteIO with some data
		BoardIO io = new BoardIO();
		// write it to a file
		io.saveBoardState(board, "output.txt");
		// now check file
		File file = new File("output.txt");

		try {
			Scanner in = new Scanner(file);
			String line;
			// read in a line and remove some
			// whitespace are the beginning and end (just in case)
			// may need to be careful about the spacing between
			// values on each line put the expected values in
			// an array instead? Then I could use a loop
			line = in.nextLine().trim();
			// TODO update these for project 2
			// PIECE will need to be a specific
			// type (i.e. BISHOP or KNIGHT)
			// TODO order may be different depending
			// on the order the board is searched
			assertEquals("PIECE black 1 d", line);
			line = in.nextLine().trim();
			assertEquals("PIECE white 2 g", line);
			line = in.nextLine().trim();
			assertEquals("PIECE black 5 a", line);
			line = in.nextLine().trim();
			assertEquals("PIECE black 6 d", line);
			in.close();
		} catch (FileNotFoundException e) {
			fail("Couldn't open file");
		}
		// remove the file. Comment it out if you want
		// to examine the file by hand
		file.delete();
	}

	/**
	 * Test for a bad file name
	 * 
	 * Takes in a bad file name and returns false
	 */
	@Test
	public void testLoadBoardBadFilename() {
		BoardIO io = new BoardIO();
		Board board = new Board(8, 'h');

		boolean result = io.loadBoardState(board, "dne.txt");

		assertFalse(result);
	}

	/**
	 * Test for a bad string
	 * 
	 * Takes in a bad string and skips it
	 */
	@Test
	public void testLoadBoardBadString() {
		BoardIO io = new BoardIO();
		Board board = new Board(8, 'h');

		boolean result = io.loadBoardState(board, "bad-input.txt");

		assertTrue(result);

		// check the number of pieces on the board
		assertEquals(3, countPieces(board));
	}

	/**
	 * Test for null scanner
	 * 
	 * Takes null for scanner and returns false
	 */
	@Test
	public void testLoadBoardNullScanner() {
		BoardIO io = new BoardIO();
		Board board = new Board(8, 'h');

		boolean result = io.loadBoardState(board, (Scanner) null);

		assertFalse(result);
	}

	/**
	 * Test for a null board
	 * 
	 * Takes in null for board and returns false
	 */
	@Test
	public void testLoadBoardNullBoard() {
		BoardIO io = new BoardIO();
		boolean result = io.loadBoardState(null, "input.txt");

		assertFalse(result);
	}

	/**
	 * Test for a null PrintWriter
	 * 
	 * Takes in null for PrintWriter and returns false
	 */
	@Test
	public void testSaveBoardNullPrintWriter() {
		BoardIO io = new BoardIO();
		Board board = new Board(8, 'h');

		boolean result = io.saveBoardState(board, (PrintWriter) null);

		assertFalse(result);
	}

	/**
	 * Test for a null board
	 * 
	 * Takes in a null board and returns false
	 */
	@Test
	public void testSaveBoardNullBoard() {
		BoardIO io = new BoardIO();

		boolean result = io.saveBoardState(null, "output.txt");

		assertFalse(result);
	}

	/**
	 * Test for a null string
	 * 
	 * Takes in a null string and returns false
	 */
	@Test
	public void testSaveBoardBadFileName() {
		BoardIO io = new BoardIO();
		Board board = new Board(8, 'h');

		boolean result = io.saveBoardState(board, (String) null);
		assertFalse(result);
	}

	/**
	 * Test for a null board and null PrintWriter name
	 * 
	 * Takes in a null board and null PrintWriter and returns false
	 */
	@Test
	public void testSaveBoardPrintWriterBadFileName() {
		BoardIO io = new BoardIO();

		boolean result = io.saveBoardState(null, (PrintWriter) null);
		assertFalse(result);
	}

}
