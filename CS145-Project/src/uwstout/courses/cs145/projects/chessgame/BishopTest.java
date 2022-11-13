package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class BishopTest {

	private Board board;
	private Bishop bishopB1;
	private Bishop bishopB2;
	private Bishop bishopW1;
	private Bishop bishopW2;

	/**
	 * Creates a board with 4 bishops on it. Some of the bishops are blocking the
	 * paths of other bishops.
	 */
	@Before
	public void setUp() throws Exception {
		board = new Board(8, 'h');
		bishopB1 = new Bishop(false);
		bishopB2 = new Bishop(false);
		bishopW1 = new Bishop(true);
		bishopW2 = new Bishop(true);
		// TODO look at positions
		bishopB1.moveTo(board.getSquare(5, 'b'));
		bishopB2.moveTo(board.getSquare(2, 'e'));
		bishopW1.moveTo(board.getSquare(5, 'e'));
		bishopW2.moveTo(board.getSquare(4, 'g'));
	}

	@Test
	public void testGetPossibleMoves() {
		MoveList m = bishopB2.getPossibleMoves();
		// This list should have
		// going left and up: 3d, 4c (5b is a black bishop, so do not include)
		// going right and up: 3f, 4g, (4g is a white bishop, so include)
		// going left and down: 1d
		// going right and down: 1f
		// check if the right number of values
		assertEquals(6, m.getNumMoves());
		// check if the right squares exist
		assertNotNull(m.findMove(3, 'd'));
		assertNotNull(m.findMove(4, 'c'));
		assertNotNull(m.findMove(3, 'f'));
		assertNotNull(m.findMove(4, 'g'));
		assertNotNull(m.findMove(1, 'd'));
		assertNotNull(m.findMove(1, 'f'));
		// TODO test more
	}

	@Test
	public void testToString() {
		Bishop b1 = new Bishop(true);
		assertEquals("WB", b1.toString());

		Bishop b2 = new Bishop(false);
		assertEquals("BB", b2.toString());

		Square s1 = new Square(1, 'a');
		Bishop b3 = new Bishop(true);
		b3.moveTo(s1);
		assertEquals("WB@a1", b3.toString());

		Square s2 = new Square(1, 'a');
		Bishop b4 = new Bishop(false);
		b4.moveTo(s2);
		assertEquals("BB@a1", b4.toString());
	}

	@Test
	public void testGetType() {
		Bishop b1 = new Bishop(true);
		assertEquals("Bishop", b1.getType().toString());
	}

	@Test
	public void testBishop() {
		Bishop b1 = new Bishop(true);
		assertEquals("White = true", true, b1.isWhite());

		Bishop b2 = new Bishop(false);
		assertEquals("black = false", false, b2.isWhite());

		Bishop b3 = new Bishop(false);
		assertEquals("Black = true", true, b3.isBlack());

		Bishop b4 = new Bishop(true);
		assertEquals("white = false", false, b4.isBlack());
	}

}
