package graphics;

import java.awt.Graphics;

// TODO: Auto-generated Javadoc
/**
 * The Interface IDrawable.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public interface IDrawable {
	 
 	/** The Constant PICTURE_PATH. */
 	public final static String PICTURE_PATH = "C:\\Users\\yoni\\java workspace\\hw4\\src\\pictures\\";
	 
 	/**
 	 * Load images.
 	 *
 	 * @param nm the nm
 	 */
 	public void loadImages(String nm);
	 
 	/**
 	 * Draw object.
 	 *
 	 * @param g the g
 	 */
 	public void drawObject(Graphics g);
	 
 	/**
 	 * Gets the color.
 	 *
 	 * @return the color
 	 */
 	public String getColor();	 
}

