package mobility;

/**
 * @author Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 *
 */
public interface ILocatable {
	/**
	 * @return the current location
	 */
	public Point getLocation();

	/**
	 * 
	 * @param location
	 *            the new location
	 * @return true if location is valid, false if not
	 */
	public boolean setLocation(Point location);
}
