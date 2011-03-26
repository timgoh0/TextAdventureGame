package uk.ac.cam.swdes.sv2;

import java.util.LinkedHashMap;

public class Room extends GameObject {
	
	private String shortDescription;
	private String longDescription;
	private boolean visited = false;
	
	private LinkedHashMap<Direction, Room> adjacentRooms =
		new LinkedHashMap<Direction, Room>();
	
	private GameObjectList<Item> items = new GameObjectList<Item>();
	
	public Room(String shortDescription, String longDescription) {
		super();
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public void addItem(Item i){
		items.add(i);
	}

	public void addAdjacentRoom(Room r, Direction d){
		adjacentRooms.put(d, r);
	}
	
	@Override
	public String look() {
		if(visited){
			return shortDescription;
		}else{
			visited = true;
			return longDescription;
		}
	}

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
	
	public Room moveDirection(Direction d){
		return adjacentRooms.get(d);
	}

}
