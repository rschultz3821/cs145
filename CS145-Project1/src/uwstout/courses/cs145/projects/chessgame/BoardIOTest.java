package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

import org.junit.Test;

public class BoardIOTest {

	private int countPieces(Board board) {
		int count = 0;
		// check all of the squares
		for (int r = 1; r <= board.getMaxRank(); r++) {
			// for (char f = 'a'; f <= board.getMaxFile(); f++) {
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

	@Test
	public void testLoadBoardStateBoardScanner() {
		// loads the data for the input
		// BISHOP and KNIGHT are okay since checkPiece
		// is not checking the type
		Scanner input = new Scanner("BISHOP black 1 d\n" + "KNIGHT white 2 g\n" + "BISHOP white 4\n"
				+ "KNIGHT black 5 a\n" + "KNIGHT 6 b\n" + "BISHOP black 6 d\n");
		BoardIO io = new BoardIO();
		Board board = new Board(8, 'h');
		// should read in 4 values
		boolean result = io.loadBoardState(board, input);
//		// tests
		// check if loaded
		assertTrue(result);
		// check the number of pieces on the board
		// System.out.println(countPieces(board));
		assertEquals(4, countPieces(board));
		// check each piece
		checkPiece(board, "BISHOP", false, 1, 'd');
		checkPiece(board, "KNIGHT", true, 2, 'g');
		checkPiece(board, "KNIGHT", false, 5, 'a');
		checkPiece(board, "BISHOP", false, 6, 'd');
		input.close();
	}

	@Test
	public void testLoadBoardStateBoardString() {
		// loads the data for the input
		// BISHOP and KNIGHT are okay since checkPiece
		// is not checking the type
		File file = new File("FileOutput.txt");

		BoardIO io = new BoardIO();
		Board board = new Board(8, 'h');
		// should read in 4 values
		boolean result = false;
		//try {
			result = io.loadBoardState(board, "FileOutput.txt");
		//} catch (FileNotFoundException e) {
			//e.printStackTrace();
		//}

		assertTrue(result);

		// check the number of pieces on the board
		assertEquals(4, countPieces(board));

		// check each piece
		checkPiece(board, "BISHOP", false, 1, 'd');
		checkPiece(board, "KNIGHT", true, 2, 'g');
		checkPiece(board, "KNIGHT", false, 5, 'a');
		checkPiece(board, "BISHOP", false, 6, 'd');
	}

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
			pw = new PrintWriter("FileOutput1.txt"); // FileOutput1.txt
		} catch (FileNotFoundException e2) {

			e2.printStackTrace();

		}
		// try {
		io.saveBoardState(board, pw);
		// } catch (FileNotFoundException e1) {
		// e1.printStackTrace();
		// }

		// now check file
		File file = new File("FileOutput1.txt"); // FileOutput1.txt
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
		io.saveBoardState(board, "testOut1.txt");
		// now check file
		File file = new File("testOut1.txt");

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
			System.out.println(line);
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

}
