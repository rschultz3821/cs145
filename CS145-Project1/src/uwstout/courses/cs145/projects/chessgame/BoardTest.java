package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Tests for Board class
 * 
 * @author SchultzRachel
 * @version 2022.10.18
 */
public class BoardTest {

	/**
	 * Tests the Board constructor, getMaxRank, getMaxFile, getMinRank, getMinFile, getSquare
	 */
	@Test
	public void testConstructorAndGetSquare() {
		// Test every possible board size
		for (int maxRank = 1; maxRank <= 26; maxRank++) {
			for (char maxFile = 'a'; maxFile <= 'z'; maxFile++) {
				Board board = new Board(maxRank, maxFile);

				// Test getMin
				assertEquals(1, board.getMinRank());
				assertEquals('a', board.getMinFile());

				// Test getMax
				assertEquals(maxRank, board.getMaxRank());
				assertEquals(maxFile, board.getMaxFile());

				// Test every square on the board and one square outside of the board
				for (int rank = board.getMinRank() - 1; rank <= board.getMaxRank() + 1; rank++) {
					for (char file = (char)(board.getMinFile() - 1); file <= board.getMaxFile() + 1; file++) {
						Square square = board.getSquare(rank, file);

						// Test out of bound squares
						if (rank < board.getMinRank() || rank > board.getMaxRank() || file < board.getMinFile() || file > board.getMaxFile()) {
							assertEquals(null, square);
						} 
						// Test in bound squares
						else {
							// Test getRank
							assertEquals(rank, square.getRank());

							// Test getFile
							assertEquals(file, square.getFile());

							// Test getBoard
							assertEquals(board, square.getBoard());

							// Test getPiece
							assertEquals(null, square.getPiece());

							// Test Square toString
							assertEquals(String.format("%c%d", file, rank), square.toString());
						}
					}
				}
			}
		}
	}

	/**
	 * Test for invalid board rank less than 1
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorRankLessThan() {
		Board b1 = new Board(0, 'a');
		assertEquals(null, b1.getSquare(0, 'a'));
	}

	/**
	 * Test for invalid board rank greater than 26
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorRankGreaterThan() {
		Board b2 = new Board(27, 'a');
		assertEquals(null, b2.getSquare(27, 'a'));
	}

	/**
	 * Test for invalid board file less than 'a'
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorFileLessThan() {
		Board b3 = new Board(1, (char)('a' - 1));
		assertEquals(null, b3.getSquare(1, (char)('a' - 1)));
	}

	/**
	 * Test for invalid board file greater then 'z'
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testConstructorFileGreaterThan() {
		Board b4 = new Board(1, (char)('z' + 1));
		assertEquals(null, b4.getSquare(1, (char)('z' + 1)));
	}

	/**
	 * Tests Board clearBoard
	 */
	@Test
	public void testClearBoard() {

		Board b1 = new Board(26, 'z');
		ChessPiece c1 = new ChessPiece(true);
		ChessPiece c2 = new ChessPiece(true);
		ChessPiece c3 = new ChessPiece(true);
		ChessPiece c4 = new ChessPiece(true);
		ChessPiece c5 = new ChessPiece(true);
		ChessPiece c6 = new ChessPiece(true);

		c1.moveTo(b1.getSquare(1, 'a'));
		c2.moveTo(b1.getSquare(26, 'a'));
		c3.moveTo(b1.getSquare(1, 'z'));
		c4.moveTo(b1.getSquare(26, 'z'));
		c5.moveTo(b1.getSquare(5, 'd'));
		c6.moveTo(b1.getSquare(4, 'f'));
		b1.clearBoard();

		// loop over to see if everything is null
		for (int rank = b1.getMinRank(); rank <= b1.getMaxRank(); rank++) {
			for (char file = b1.getMinFile(); file < b1.getMaxFile(); file++) {
				assertEquals(null, b1.getSquare(rank, file).getPiece());
			}
		}
	}

	/**
	 * Tests Board toString
	 */
	@Test
	public void testToString() {
		Board b1 = new Board(3, 'c');
		ChessPiece p1 = new ChessPiece(true);
		ChessPiece p2 = new ChessPiece(false);
		b1.getSquare(1, 'a').setPiece(p1);
		b1.getSquare(3, 'c').setPiece(p2);

		assertEquals("PIECE white 1 a\nPIECE black 3 c\n", b1.toString());
	}
}
