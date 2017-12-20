package mobility;

// TODO: Auto-generated Javadoc
/**
 * The Class Point.
 *
 * @author Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class Point implements Cloneable {

	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	@Override
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
	
	/** The x. */
	private int x; // the x value
	
	/** The y. */
	private int y; // the y value
	
	/**
	 * Instantiates a new point.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * Sets the X.
	 *
	 * @param x the x
	 * @return true, if successful
	 */
	public boolean setX(int x) {
		this.x = x;
		return true;
	}
	
	/**
	 * Sets the Y.
	 *
	 * @param y the y
	 * @return true, if successful
	 */
	public boolean setY(int y) {
		this.y = y;
		return true;
	}
}
