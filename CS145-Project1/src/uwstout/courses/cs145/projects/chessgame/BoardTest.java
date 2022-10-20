package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * Test for Board class
 * 
 * Tests for Board class
 * 
 * @author SchultzRachel
 * @version 2022.10.18
 */
public class BoardTest {

	/**
	 * Test for constructor Board
	 * 
	 * Tests getMaxRank, getMaxFile, getMinRank, getMinFile
	 */
	@Test
	public void testBoard() {
		Board b1 = new Board(8, 'h');
		assertEquals("1", 1, b1.getMinRank());
		assertEquals("a", 'a', b1.getMinFile());

		assertEquals("8", 8, b1.getMaxRank());
		assertEquals("h", 'h', b1.getMaxFile());

//		create loop to loop over an 8 x 'h' and see where the problem is in getSquare
		assertEquals("a1", b1.getSquare(1, 'a').toString());
		assertEquals("b1", b1.getSquare(1, 'b').toString());
		assertEquals("c1", b1.getSquare(1, 'c').toString());
		assertEquals("d1", b1.getSquare(1, 'd').toString());
		assertEquals("e1", b1.getSquare(1, 'e').toString());
		assertEquals("f1", b1.getSquare(1, 'f').toString());
		assertEquals("g1", b1.getSquare(1, 'g').toString());
		assertEquals("h1", b1.getSquare(1, 'h').toString());

		assertEquals("a2", b1.getSquare(2, 'a').toString());
		assertEquals("b2", b1.getSquare(2, 'b').toString());
		assertEquals("c2", b1.getSquare(2, 'c').toString());
		assertEquals("d2", b1.getSquare(2, 'd').toString());
		assertEquals("e2", b1.getSquare(2, 'e').toString());
		assertEquals("f2", b1.getSquare(2, 'f').toString());
		assertEquals("g2", b1.getSquare(2, 'g').toString());
		assertEquals("h2", b1.getSquare(2, 'h').toString());

		assertEquals("a3", b1.getSquare(3, 'a').toString());
		assertEquals("b3", b1.getSquare(3, 'b').toString());
		assertEquals("c3", b1.getSquare(3, 'c').toString());
		assertEquals("d3", b1.getSquare(3, 'd').toString());
		assertEquals("e3", b1.getSquare(3, 'e').toString());
		assertEquals("f3", b1.getSquare(3, 'f').toString());
		assertEquals("g3", b1.getSquare(3, 'g').toString());
		assertEquals("h3", b1.getSquare(3, 'h').toString());

		assertEquals("a4", b1.getSquare(4, 'a').toString());
		assertEquals("b4", b1.getSquare(4, 'b').toString());
		assertEquals("c4", b1.getSquare(4, 'c').toString());
		assertEquals("d4", b1.getSquare(4, 'd').toString());
		assertEquals("e4", b1.getSquare(4, 'e').toString());
		assertEquals("f4", b1.getSquare(4, 'f').toString());
		assertEquals("g4", b1.getSquare(4, 'g').toString());
		assertEquals("h4", b1.getSquare(4, 'h').toString());

		assertEquals(null, b1.getSquare(9, 'd'));
		assertEquals(null, b1.getSquare(3, 'l'));

	}

	/**
	 * Test for invalid rank
	 * 
	 * Test file less then 1
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testBoardRank() {
		Board b1 = new Board(-1, 'c');
		assertEquals("null", null, b1.getSquare(-1, 'b'));
	}

	/**
	 * Test for invalid rank
	 * 
	 * Test file great then 26
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testBoardRank2() {
		Board b2 = new Board(28, 'c');
		assertEquals("null", null, b2.getSquare(28, 'b'));
	}

	/**
	 * Test for invalid file
	 * 
	 * Test file less then 97
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testBoardFile() {
		Board b3 = new Board(1, '.');
		assertEquals("null", null, b3.getSquare(1, '.'));
	}

	/**
	 * Test for invalid file
	 * 
	 * Test file greater then 122
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testBoardFile2() {
		Board b4 = new Board(1, '}');
		assertEquals("null", null, b4.getSquare(1, '}'));
	}

	/**
	 * Test for getSquare
	 * 
	 * Returns null if not valid Gets the square
	 */
	@Test
	public void testGetSquare() {
		Board b1 = new Board(4, 'd');

		assertEquals(null, b1.getSquare(6, 'm'));
		assertEquals(null, b1.getSquare(-1, 'm'));
		assertEquals(null, b1.getSquare(3, 'm'));
		assertEquals(null, b1.getSquare(3, 'A'));

		Board b2 = new Board(4, 'd');
		Square s1 = b1.getSquare(3, 'b');
		assertEquals(s1.toString(), b2.getSquare(3, 'b').toString());
	}

	/**
	 * Test for clearBoard
	 * 
	 * Clears the board
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
		ChessPiece c7 = new ChessPiece(true);

		c1.moveTo(b1.getSquare(1, 'a'));
		c2.moveTo(b1.getSquare(26, 'a'));
		c3.moveTo(b1.getSquare(1, 'z'));
		c4.moveTo(b1.getSquare(26, 'z'));
		c5.moveTo(b1.getSquare(5, 'd'));
		c6.moveTo(b1.getSquare(4, 'f'));
		b1.clearBoard();

		// loop over to see if everything is null
		for (int rank = 0; rank < 26; rank++) {
			for (char file = 'a'; file < 'z'; file++) {
				assertEquals(null, b1.getSquare(rank, file));
			}
		}
	}

	/**
	 * Tests toString
	 * 
	 * Tests to String from Board Class
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
