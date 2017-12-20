package animals;

import diet.Omnivore;


// TODO: Auto-generated Javadoc
/**
 * The Class Bear.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class Bear extends Animal {
	
	/**
	 * Instantiates a new bear.
	 */
	public Bear(){
		super();
		this.name = "Bear";
		setDiet(new Omnivore());
		this.animalimage = "bea";
		this.wFactor = (float)1.5;
		
	}

}
