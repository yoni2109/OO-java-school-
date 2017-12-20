package graphics;

// TODO: Auto-generated Javadoc
/**
 * The Interface IAnimalBehavior.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public interface IAnimalBehavior {
	 
 	/**
 	 * Gets the name.
 	 *
 	 * @return the name
 	 */
 	abstract public String getName();
	 
 	/**
 	 * Sets the suspend.
 	 */
 	abstract public void setSuspend();
	 
 	/**
 	 * Sets the resume.
 	 */
 	abstract public void setResume();
	 
 	/**
 	 * Gets the size.
 	 *
 	 * @return the size
 	 */
 	abstract public int getSize();
	 
 	/**
 	 * Eat inc.
 	 */
 	abstract public void eatInc();
	 
 	/**
 	 * Gets the eat count.
 	 *
 	 * @return the eat count
 	 */
 	abstract public int getEatCount();
	 
 	/**
 	 * Gets the changes.
 	 *
 	 * @return the changes
 	 */
 	abstract public boolean getChanges();
	 
 	/**
 	 * Sets the changes.
 	 *
 	 * @param state the new changes
 	 */
 	abstract public void setChanges(boolean state);
}

