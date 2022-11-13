package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;


import org.junit.Before;
import org.junit.Test;

public class BoardControllerTest {
//	private Board board;
//	private BoardController control;
//
//	/**
//	 * Set up board and controller
//	 * 
//	 * @throws Exception On error
//	 */
//	@Before
//	public void setUp() throws Exception {
//		board = new Board(8, 'h');
//		control = new BoardController(board);
//	}
//
//	/**
//	 * Test constructor
//	 */
//	@Test
//	public void testBoardController() {
//		// check if nothing selected
//		assertNull(control.getSelected());
//		assertNull(control.getPossibleMoves());
//		// check board
//		assertEquals(board, control.getBoard());
//	}
//
//	@Test
//	public void testGetBoard() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetSelected() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetPossibleMoves() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Uses addPiece to add a few pieces to the board
//	 */
//	private void addPieces() {
//		control.addPiece(PieceType.BISHOP, false, 3, 'e');
//		control.addPiece(PieceType.BISHOP, true, 7, 'e');
//		control.addPiece(PieceType.KNIGHT, true, 4, 'c');
//		control.addPiece(PieceType.KNIGHT, false, 2, 'd');
//		// TODO add move pieces, as needed
//	}
//
//	/**
//	 * Tests if pieces added correctly
//	 */
//	@Test
//	public void testAddPiece() {
//		addPieces();
//		// check if pieces exist
//		ChessPiece p;
//		p = board.getSquare(3, 'e').getPiece();
//		assertNotNull(p); // it was added
//		assertEquals(PieceType.BISHOP, p.getType());
//		assertEquals(false, p.isWhite());
//		p = board.getSquare(7, 'e').getPiece();
//		assertNotNull(p); // it was added
//		assertEquals(PieceType.BISHOP, p.getType());
//		assertEquals(true, p.isWhite());
//		p = board.getSquare(4, 'c').getPiece();
//		assertNotNull(p); // it was added
//		assertEquals(PieceType.KNIGHT, p.getType());
//		assertEquals(true, p.isWhite());
//		p = board.getSquare(2, 'd').getPiece();
//		assertNotNull(p); // it was added
//		assertEquals(PieceType.KNIGHT, p.getType());
//		assertEquals(false, p.isWhite());
//	}
//
//	@Test
//	public void testClearSelected() {
//		fail("Not yet implemented");
//	}
//
//	/**
//	 * Test if selection works
//	 */
//	@Test
//	public void testSelect() {
//		addPieces();
//		// select something
//		control.select(7, 'e');
//		// see if right square was selected
//		assertEquals(board.getSquare(7, 'e'), control.getSelected());
//		// see if there is a move list
//		assertNotNull(control.getPossibleMoves());
//		// TODO test selecting different piece
//		// TODO test selecting same piece twice
//		// TODO test trying to select empty square
//		// TODO test trying to select an invalid rank/file
//	}
//
//	/**
//	 * Tests if piece can be moved
//	 */
//	@Test
//	public void testMoveSelected() {
//		boolean result;
//		ChessPiece p;
//		addPieces();
//		p = board.getSquare(7, 'e').getPiece();
//		assertNotNull(p); // check if board was set up
//		control.select(7, 'e'); // select it
//		result = control.moveSelected(5, 'g'); // move it
//		// test piece in new location
//		assertEquals(p, board.getSquare(5, 'g').getPiece());
//		// test old location empty
//		assertNull(board.getSquare(7, 'e').getPiece());
//		// test result
//		assertTrue(result);
//		// test selected, should be cleared
//		assertNull(control.getSelected());
//		assertNull(control.getPossibleMoves());
//		// TODO try moving on to other pieces (same side, different side)
//		// TODO try invalid moves
//	}
//
//	@Test
//	public void testRemoveSelected() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testResetBoard() {
//		fail("Not yet implemented");
//	}

}
