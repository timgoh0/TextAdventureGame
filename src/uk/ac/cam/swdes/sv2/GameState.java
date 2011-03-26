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
	
	/**
	 * Set the current room of the statemachine
	 * 
	 * Useful when starting the game, or warping the player somewhere
	 * @param r A room
	 */
	public void setCurrentRoom(Room r){
		currentRoom = r;
	}
	
	/**
	 * Move statemachine to adjacent room given by d
	 * @param d A cardinal Direction
	 */
	public void moveDirection(Direction d){
		lastDirection = d;
		try {
			currentRoom = currentRoom.moveDirection(d);
			currentRoom.enterLook();
		} catch (RoomNotFoundException e) {
			System.out.println("You can't go that way.");
		}
		
	}
	
	/**
	 * Removes item from room, and places in inventory
	 * @param item Name of item as String
	 */
	public void take(String item){
		if(item.equals("all")){
			for(Item i: currentRoom.getItems()){
				inventory.add(i);
				System.out.println("Took "+i.getName());
			}
		}else{
			try {
				inventory.add(currentRoom.take(item));
				System.out.println("Took "+item);
			} catch (ItemNotFoundByNameException e) {
				System.out.println("There's no "+item+" here.");
			}
		}
	}
	
	/**
	 * Prints description of room
	 */
	public void look(){
		System.out.println(currentRoom.look());
	}
	
	/**
	 * Shows what the player is carrying
	 */
	public void listInventory(){
		System.out.println("You are carrying:");
		for(Item i : inventory){
			System.out.println(i.getName());
		}
	}
	
	/**
	 * Give item to person, not presently implemented
	 * @param item
	 * @param person
	 */
	public void give(String item, String person){
		//TODO: STUB, implement game logic
		System.out.println("Giving "+item+" to "+person);
	}
	
	/**
	 * Removes item from person and puts it in room
	 * @param item Name of item to be dropped
	 */
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
