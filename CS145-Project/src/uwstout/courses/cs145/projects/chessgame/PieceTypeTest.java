package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test for PieceType
 *
 * Test for PieceType
 *
 * @author SchultzRachel
 * @version 22.11.15
 *
 */
public class PieceTypeTest {

	/**
	 * Test for toString method
	 *
	 * Returns Bishop or Knight based on pieceType entered
	 */
	@Test
	public void testToString() {
		assertEquals("BISHOP", PieceType.BISHOP.toString());
		assertEquals("KNIGHT", PieceType.KNIGHT.toString());
	}

}
