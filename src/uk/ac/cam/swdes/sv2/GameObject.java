package uk.ac.cam.swdes.sv2;

import java.util.HashSet;

/**
 * Provides an abstract class to all game objects
 * 
 * Intended to be subclassed for things like items, rooms
 * 
 * @author timgoh0
 *
 */
public abstract class GameObject {
	
	protected final HashSet<String> objectNames = new HashSet<String>();
	
	public abstract String look();
	
	public void addAlias(String s){
		objectNames.add(s);
	}
	
	public boolean getObjectByName(String name){
		boolean contains = objectNames.contains(name);
		return contains;
	}
}
