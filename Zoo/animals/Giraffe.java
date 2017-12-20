package animals;

import diet.Herbivore;

// TODO: Auto-generated Javadoc
/**
 * The Class Giraffe.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class Giraffe extends Animal {
	
	/**
	 * Instantiates a new giraffe.
	 */
	public Giraffe(){
		super();
		this.name = "Giraffe";
		setDiet(new Herbivore());
		this.animalimage = "grf";
		this.wFactor = (float)2.2;
		
	}

}
