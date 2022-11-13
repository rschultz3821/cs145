package uwstout.courses.cs145.projects.chessgame;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveListTest {

	@Test
	public void testMoveList() {
		MoveList ml= new MoveList();
		assertEquals(0, ml.getNumMoves());

	}

	@Test
	public void testAddMove() {
		Square s = new Square(1, 'a');
		MoveList ml2 = new MoveList();
		ml2.getMove(2);
		assertEquals(2, ml2.getNumMoves());
	}

	@Test
	public void testGetNumMoves() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testFindMove() {
		fail("Not yet implemented");
	}

	@Test
	public void testReset() {
		fail("Not yet implemented");
	}

}
