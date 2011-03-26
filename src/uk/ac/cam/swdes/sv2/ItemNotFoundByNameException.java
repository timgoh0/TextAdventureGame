package uk.ac.cam.swdes.sv2;

/**
 * What happens when you can't find an item
 * @author timgoh0
 *
 */
public class ItemNotFoundByNameException extends Exception{

	public ItemNotFoundByNameException() {
		super();
	}

	public ItemNotFoundByNameException(String message, Throwable cause) {
		super(message, cause);
	}

	public ItemNotFoundByNameException(String message) {
		super(message);
	}

	public ItemNotFoundByNameException(Throwable cause) {
		super(cause);
	}

}
