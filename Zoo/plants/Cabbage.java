package plants;


// TODO: Auto-generated Javadoc
/**
 * The Class Cabbage.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class Cabbage extends Plant {
	
	/** The single. */
	private static Cabbage single = new Cabbage();
	
	/**
	 * Gets the instance.
	 *
	 * @return the instance
	 */
	public static Cabbage getinstance(){
		return single;
	}
	
	/**
	 * Instantiates a new cabbage.
	 */
	private Cabbage() {
		super();
		loadImages("cabbage");
	}
}
