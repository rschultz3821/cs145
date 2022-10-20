package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for ChessPiece Class
 * 
 * Test for ChessPiece Class
 * 
 * @author SchultzRachel
 * @version 2022.20.18
 */
public class ChessPieceTest {

	/**
	 * Test for getIsWhitw
	 * 
	 * Returns true if it's white and false if it's black
	 */
	@Test
	public void testGetIsWhite() {
		ChessPiece p1 = new ChessPiece(true);
		assertEquals("White = true", true, p1.isWhite());

		ChessPiece p2 = new ChessPiece(false);
		assertEquals("black = false", false, p2.isWhite());
	}

	/**
	 * Test for getIsBlack
	 * 
	 * Returns true if it's black and false if it's white
	 */
	@Test
	public void testGetIsBlack() {
		ChessPiece p1 = new ChessPiece(false);
		assertEquals("Black = true", true, p1.isBlack());

		ChessPiece p2 = new ChessPiece(true);
		assertEquals("white = false", false, p2.isBlack());
	}

	/**
	 * Test for getSquare
	 * 
	 * If the ChessPiece is true or false it returns null for getSquare
	 */
	@Test
	public void testGetSquare() {
		ChessPiece p1 = new ChessPiece(true);
		assertEquals("null", null, p1.getSquare());

		ChessPiece p2 = new ChessPiece(false);
		assertEquals("null", null, p2.getSquare());
	}

	/**
	 * Test for moveTo
	 * 
	 * Test for moving one piece onto an empty square Test for moving one piece onto
	 * another empty piece Test for moving one piece onto a square that is not empty
	 * Test for moving off of the square (null)
	 */
	@Test
	public void testMoveTo() {
		// move one piece onto an empty square
		ChessPiece p1 = new ChessPiece(true);
		ChessPiece p2 = new ChessPiece(true);
		ChessPiece p3 = new ChessPiece(false);

		Square s1 = new Square(3, 'c');
		Square s2 = new Square(4, 'd');

		p1.moveTo(s1);
		assertEquals("c3", p1.getSquare().toString());
		assertEquals(true, s1.getPiece().isWhite());

		// move one piece onto another empty piece
		p2.moveTo(s2);
		assertEquals("d4", p2.getSquare().toString());
		assertEquals(true, s2.getPiece().isWhite());

		// move one piece onto a square that is not empty
		// ChessPiece p2 = new ChessPiece(true);

		// f1.moveTo(null)
		p3.moveTo(s1);
		assertEquals("c3", p3.getSquare().toString());
		assertEquals(false, s1.getPiece().isWhite());

		// move off of the square
		// Square s3 = new Square(null, null);
		p3.moveTo(null);
		assertEquals(null, p3.getSquare());
	}

	/**
	 * Test for toString
	 * 
	 * Returns the string for location and side
	 */
	@Test
	public void testToString() {
		ChessPiece p1 = new ChessPiece(true);
		assertEquals("location:null side:true", p1.toString());
	}
}
