package uk.ac.cam.swdes.sv2;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.cam.swdes.sv2.GameGrammar;
import uk.ac.cam.swdes.sv2.ParseException;

public class GameGrammarTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public final void testInput() throws ParseException {
		GameGrammar g = new GameGrammar(new StringReader("North"));
		g.Input();
		GameState s = GameState.getInstance();
		
		//fail("Not yet implemented"); // TODO
	}

}
