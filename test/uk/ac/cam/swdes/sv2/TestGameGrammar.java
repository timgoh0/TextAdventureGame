package uk.ac.cam.swdes.sv2;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.cam.swdes.sv2.GameGrammar;
import uk.ac.cam.swdes.sv2.ParseException;

public class TestGameGrammar {

	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Tests for correct parsing of the cardinal directions
	 * @throws ParseException
	 */
	@Test
	public final void movementTest() throws ParseException {
		GameState s = GameState.getInstance();
		
		GameGrammar.ParseString("North");
		assertEquals(Direction.NORTH, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ParseString("n");
		assertEquals(Direction.NORTH, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ParseString("East");
		assertEquals(Direction.EAST, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ParseString("e");
		assertEquals(Direction.EAST, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ParseString("South");
		assertEquals(Direction.SOUTH, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ParseString("s");
		assertEquals(Direction.SOUTH, s.lastDirection);
		s.lastDirection = null;

		GameGrammar.ParseString("West");
		assertEquals(Direction.WEST, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ParseString("w");
		assertEquals(Direction.WEST, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ParseString("up");
		assertEquals(Direction.UP, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ParseString("u");
		assertEquals(Direction.UP, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ParseString("Down");
		assertEquals(Direction.DOWN, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ParseString("d");
		assertEquals(Direction.DOWN, s.lastDirection);
		s.lastDirection = null;
		
	}
	
	/**
	 * Tests for faulty token
	 */
	@Test(expected = TokenMgrError.class)
	public void testBadToken() throws ParseException {
		GameGrammar.ParseString("jfdksfkdnvcidsahfeoiuwfr");
	}
	


}
