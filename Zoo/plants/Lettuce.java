package plants;


// TODO: Auto-generated Javadoc
/**
 * The Class Lettuce.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class Lettuce extends Plant {
	
	/** The single. */
	private static Lettuce single = new Lettuce();
	
	/**
	 * Gets the instance.
	 *
	 * @return the instance
	 */
	public static Lettuce getinstance(){
		return single;
	}
	
	/**
	 * Instantiates a new lettuce.
	 */
	private Lettuce() {
		super();
		loadImages("lettuce");
	}
}
