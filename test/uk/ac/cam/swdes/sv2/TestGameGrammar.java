package uk.ac.cam.swdes.sv2;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.cam.swdes.sv2.GameGrammar;
import uk.ac.cam.swdes.sv2.ParseException;

public class TestGameGrammar {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//Init the parser, non-standard behaviour because this is a static parser
		GameGrammar g = new GameGrammar(new StringReader(""));
	}

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
		
		GameGrammar.ReInit(new StringReader("North\n"));
		GameGrammar.Input();
		assertEquals(Direction.NORTH, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("n\n"));
		GameGrammar.Input();
		assertEquals(Direction.NORTH, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("East\n"));
		GameGrammar.Input();
		assertEquals(Direction.EAST, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("e\n"));
		GameGrammar.Input();
		assertEquals(Direction.EAST, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("South\n"));
		GameGrammar.Input();
		assertEquals(Direction.SOUTH, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("s\n"));
		GameGrammar.Input();
		assertEquals(Direction.SOUTH, s.lastDirection);
		s.lastDirection = null;

		GameGrammar.ReInit(new StringReader("West\n"));
		GameGrammar.Input();
		assertEquals(Direction.WEST, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("w\n"));
		GameGrammar.Input();
		assertEquals(Direction.WEST, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("up\n"));
		GameGrammar.Input();
		assertEquals(Direction.UP, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("u\n"));
		GameGrammar.Input();
		assertEquals(Direction.UP, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("Down\n"));
		GameGrammar.Input();
		assertEquals(Direction.DOWN, s.lastDirection);
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("d\n"));
		GameGrammar.Input();
		assertEquals(Direction.DOWN, s.lastDirection);
		s.lastDirection = null;
		
	}
	
	/**
	 * Tests for faulty token
	 */
	@Test(expected = TokenMgrError.class)
	public void testBadToken() throws ParseException {
		GameGrammar.ReInit(new StringReader("jfdksfkdnvcidsahfeoiuwfr"));
		GameGrammar.Input();
	}
	


}
