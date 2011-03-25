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
		//TODO: Implement direction frobbage.
	}
	
	public void take(String item){
		//TODO: STUB, implement game logic
		System.out.println("Taking "+item);
	}
	
	public void give(String item, String person){
		//TODO: STUB, implement game logic
		System.out.println("Giving "+item+" to "+person);
	}
	
	public void drop(String item){
		//TODO: STUB, implement game logic
		System.out.println("Dropping "+item);
	}
}
