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
		Board b1 = new Board(5, 'c');
		assertEquals("5", 5, b1.getMaxRank());
		assertEquals("c", 'c', b1.getMaxFile());
		assertEquals("1", 1, b1.getMinRank());
		assertEquals("a", 'a', b1.getMinFile());
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
//		Board b1 = new Board(3, 'c');
//		ChessPiece p1 = new ChessPiece(true);
//		// call clear board
//		// loop get square.get piece (null)
//		Square s1 = b1.getSquare(2, 'b');
//		p1.moveTo(s1);
//		assertEquals(p1.toString(), s1.getPiece().toString());
//		b1.clearBoard();
//		assertEquals(null, s1.getPiece());
		
		Board b1 = new Board(26,'z');
		ChessPiece c1 = new ChessPiece(true);
		
		c1.moveTo(b1.getSquare(2, 'c'));
		b1.clearBoard();
		
		//loop over to see if everything is null
		for (int rank = 0; rank < 26; rank++) {
			for (char file = 'a'; file < 'z'; file++) {
				assertEquals(null, b1.getSquare(rank, file));
			}
		}
	}
}
