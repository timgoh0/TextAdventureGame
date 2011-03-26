package uk.ac.cam.swdes.sv2;

import java.util.LinkedList;

/**
 * Provides a way of gameobjects to be retrieved by value
 * @author timgoh0
 *
 */
public class GameObjectList<V extends GameObject> extends LinkedList<V> {

	public V getFirstObjectByName(String s) throws ItemNotFoundByNameException{
		for(V o: this){
			if(o.getObjectByName(s)){
				return o;
			}
		}
		throw new ItemNotFoundByNameException("Item "+s+"not found here.");
	}
}
