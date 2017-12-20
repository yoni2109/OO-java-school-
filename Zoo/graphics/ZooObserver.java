package graphics;

import java.util.Observable;
import java.util.Observer;

// TODO: Auto-generated Javadoc
/**
 * An asynchronous update interface for receiving notifications
 * about Zoo information as the Zoo is constructed.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class ZooObserver implements Observer {

	/** The pan. */
	private ZooPanel pan;
	
	/* (non-Javadoc)
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	@Override
	public void update(Observable arg0, Object arg1) {
		synchronized(this)
		{		
			pan.animaleatsanother();
			pan.repaint();
		}
	}		

	/**
	 * This method is called when information about an Zoo
	 * which was previously requested using an asynchronous
	 * interface becomes available.
	 *
	 * @param p the p
	 */
	public ZooObserver(ZooPanel p ){
		pan = p;
	}
}
