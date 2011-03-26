package uk.ac.cam.swdes.sv2;

/**
 * @author timgoh0
 * Singleton representing the state of the world
 */
public class GameState {
	
	private static GameState instance = null;
	
	//Used for unit testing of direction parser
	protected Direction lastDirection;
	protected Room currentRoom = null;
	protected GameObjectList<Item> inventory = new GameObjectList<Item>();
	
	
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
	
	public void setCurrentRoom(Room r){
		currentRoom = r;
	}
	
	public void moveDirection(Direction d){
		lastDirection = d;
		currentRoom = currentRoom.moveDirection(d);
		look();
	}
	
	public void take(String item){
		try {
			inventory.add(currentRoom.take(item));
			System.out.println("Taken.");
		} catch (ItemNotFoundByNameException e) {
			System.out.println("There's no "+item+" here.");
		}
	}
	
	public void look(){
		System.out.println(currentRoom.look());
	}
	
	public void listInventory(){
		System.out.println("You are carrying:");
		for(Item i : inventory){
			System.out.println(i.getName());
		}
	}
	
	public void give(String item, String person){
		//TODO: STUB, implement game logic
		System.out.println("Giving "+item+" to "+person);
	}
	
	public void drop(String item){
		try {
			Item i = inventory.getFirstObjectByName(item);
			currentRoom.addItem(i);
			inventory.remove(i);
			System.out.println("Dropped "+item);
		} catch (ItemNotFoundByNameException e) {
			System.out.println("You're not carrying "+item);
		}
	}
}
