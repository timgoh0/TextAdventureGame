package uk.ac.cam.swdes.sv2;

/**
 * What happens if there are no adjacent rooms
 * @author timgoh0
 *
 */
public class RoomNotFoundException extends Exception {

	public RoomNotFoundException() {
		super();
	}

	public RoomNotFoundException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public RoomNotFoundException(String arg0) {
		super(arg0);
	}

	public RoomNotFoundException(Throwable arg0) {
		super(arg0);
	}

}
