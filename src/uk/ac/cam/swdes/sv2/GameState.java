package uk.ac.cam.swdes.sv2;

/**
 * @author timgoh0
 * Singleton representing the state of the world
 */
public class GameState {
	
	private static GameState instance = null;
	
	//Used for unit testing of direction parser
	protected Direction lastDirection;
	
	protected GameState(){
		//Empty to prevent instantiation
	}
	
	
	/**
	 * Singleton instance of gamestate
	 * 
	 * @return The singleton gamestate
	 */
	public static GameState getInstance(){
		if(instance == null){
			instance = new GameState();
		}
		return instance;
	}
	
	public void moveDirection(Direction d){
		lastDirection = d;
		//@TODO: Implement direction frobbage.
	}
}
