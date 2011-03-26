package uk.ac.cam.swdes.sv2;

/**
 * An item
 * 
 * @author timgoh0
 *
 */
public class Item extends GameObject {

	private String description;
	private String name;

	/**
	 * Constructor for item
	 * @param name The canonical name
	 * @param description A longer description of the item
	 */
	public Item(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		super.addAlias(name);
	}

	@Override
	public String look() {
		return description;
	}
	
	public String getName(){
		return name;
	}

}
