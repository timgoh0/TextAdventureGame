package uk.ac.cam.swdes.sv2;

import java.util.HashMap;

/**
 * A room
 * @author timgoh0
 *
 */
public class Room extends GameObject {
	
	private String shortDescription;
	private String longDescription;
	private boolean visited = false;
	
	private HashMap<Direction, Room> adjacentRooms =
		new HashMap<Direction, Room>();
	
	private GameObjectList<Item> items = new GameObjectList<Item>();
	
	/**
	 * Constructor for the room.
	 * A room has a long and short description. 
	 * The long description is shown the first time or if the player explicitly looks,
	 * and the short one is shown on subsequent entrances.
	 * @param shortDescription A short description string
	 * @param longDescription A long description string
	 */
	public Room(String shortDescription, String longDescription) {
		super();
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	/**
	 * Adds an item to the room
	 * Intended for use by the methods building the world
	 * @param i An item
	 */
	public void addItem(Item i){
		items.add(i);
	}

	/**
	 * Connects room to adjacent room
	 * Note that this is not symmetric, and the opposite room needs to be connected
	 * @param r The room
	 * @param d The direction
	 */
	public void addAdjacentRoom(Room r, Direction d){
		adjacentRooms.put(d, r);
	}
	
	
	/**
	 * The look method to be shown if the player hasn't issued an explicit "look"
	 * @return Description of room
	 */
	public String enterLook() {
		if(visited){
			return shortDescription;
		}else{
			visited = true;
			return longDescription;
		}
	}
	
	@Override
	public String look(){
		return longDescription;
	}

	/**
	 * Take an item from the room, removes it from the room
	 * @param s Item to take
	 * @return Item, if found
	 * @throws ItemNotFoundByNameException if not found
	 */
	public Item take(String s) throws ItemNotFoundByNameException {
		Item i = items.getFirstObjectByName(s);
		items.remove(i);
		return i;
	}

	@Override
	public boolean getObjectByName(String name) {
		// Not going to get room, so not doing this
		return false;
	}
	
	/**
	 * Moves player to room in direction d
	 * @param d Direction to move to
	 * @return New room that player's moved to
	 * @throws RoomNotFoundException If not found
	 */
	public Room moveDirection(Direction d) throws RoomNotFoundException{
		Room r = adjacentRooms.get(d);
		if(r == null){
			throw new RoomNotFoundException("No room in "+d);
		}
		return r;
	}

	/**
	 * @return All items in room
	 */
	public GameObjectList<Item> getItems() {
		return items;
	}

}
