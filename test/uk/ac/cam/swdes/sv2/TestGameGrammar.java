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
	}

	@Before
	public void setUp() throws Exception {
		//Init the parser, non-standard behaviour because this is a static parser
		GameGrammar g = new GameGrammar(new StringReader(""));
	}

	/**
	 * Tests for correct parsing of the cardinal directions
	 * @throws ParseException
	 */
	@Test
	public final void movementTest() throws ParseException {
		GameState s = GameState.getInstance();
		
		GameGrammar.ReInit(new StringReader("North"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.NORTH){
			fail("Parsing for North failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("n"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.NORTH){
			fail("Parsing for n failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("East"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.EAST){
			fail("Parsing for East failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		
		GameGrammar.ReInit(new StringReader("e"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.EAST){
			fail("Parsing for e failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("South"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.SOUTH){
			fail("Parsing for South failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("s"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.SOUTH){
			fail("Parsing for s failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("South"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.SOUTH){
			fail("Parsing for South failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("s"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.SOUTH){
			fail("Parsing for s failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("West"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.WEST){
			fail("Parsing for West failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("w"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.WEST){
			fail("Parsing for w failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("up"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.UP){
			fail("Parsing for Up failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("u"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.UP){
			fail("Parsing for u failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("Down"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.DOWN){
			fail("Parsing for DOWN failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
		GameGrammar.ReInit(new StringReader("d"));
		GameGrammar.Input();
		if(s.lastDirection != Direction.DOWN){
			fail("Parsing for d failed, got "+s.lastDirection);
		}
		s.lastDirection = null;
		
	}

}
