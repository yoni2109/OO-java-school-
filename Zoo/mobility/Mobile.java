package mobility;

// TODO: Auto-generated Javadoc
/**
 * The Class Mobile.
 *
 * @author Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public abstract class Mobile implements ILocatable {
	
	/** The location. */
	protected Point location;

	/**
	 * Instantiates a new mobile.
	 *
	 * @param location the location
	 */
	public Mobile(Point location) {
		this.setLocation(location);
	}
	
	/* (non-Javadoc)
	 * @see mobility.ILocatable#getLocation()
	 */
	public Point getLocation() {
		return location;
	}

	/* (non-Javadoc)
	 * @see mobility.ILocatable#setLocation(mobility.Point)
	 */
	public boolean setLocation(Point newLocation) {
		this.location = newLocation;
		return true;

	}
}
