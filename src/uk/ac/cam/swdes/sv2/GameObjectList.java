package uk.ac.cam.swdes.sv2;

import java.util.LinkedList;

/**
 * Provides a way of gameobjects to be retrieved by value
 * @author timgoh0
 * @param <V> must be of type subclassing GameObject
 */
public class GameObjectList<V extends GameObject> extends LinkedList<V> {

	
	/**
	 * Finds an object by its names or aliases
	 * @param s A name
	 * @return GameObject if found
	 * @throws ItemNotFoundByNameException if it's not found
	 */
	public V getFirstObjectByName(String s) throws ItemNotFoundByNameException{
		for(V o: this){
			if(o.getObjectByName(s)){
				return o;
			}
		}
		throw new ItemNotFoundByNameException("Item "+s+"not found here.");
	}
}
