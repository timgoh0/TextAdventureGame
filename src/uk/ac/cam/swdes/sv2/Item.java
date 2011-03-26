package uk.ac.cam.swdes.sv2;

public class Item extends GameObject {
	
	public Item(String name, String description) {
		super();
		this.name = name;
		this.description = description;
		super.addAlias(name);
	}

	private String description;
	private String name;

	@Override
	public String look() {
		return description;
	}
	
	public String getName(){
		return name;
	}

}
