package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;


import org.junit.Test;

public class KnightTest {

	@Test
	public void testToString() {
		Knight n1 = new Knight(true);
		assertEquals("WN", n1.toString());
		
		Knight n2 = new Knight(false);
		assertEquals("BN", n2.toString());
		
		Square s1 = new Square(1, 'a');
		Knight n3 = new Knight(true);
		n3.moveTo(s1);
		assertEquals("WN@a1", n3.toString());
		
		Square s2 = new Square(1, 'a');
		Knight n4 = new Knight(false);
		n4.moveTo(s2);
		assertEquals("BN@a1", n4.toString());
	}

	@Test
	public void testGetType() {
		Knight n1 = new Knight(true);
		assertEquals("Knight", n1.getType().toString());
	}

	@Test
	public void testKnight() {
		Knight n1 = new Knight(true);
		assertEquals("White = true", true, n1.isWhite());

		Knight n2 = new Knight(false);
		assertEquals("black = false", false, n2.isWhite());

		Knight n3 = new Knight(false);
		assertEquals("Black = true", true, n3.isBlack());

		Knight n4 = new Knight(true);
		assertEquals("white = false", false, n4.isBlack());
	}

}
