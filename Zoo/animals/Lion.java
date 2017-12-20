package animals;

import diet.Carnivore;


// TODO: Auto-generated Javadoc
/**
 * The Class Lion.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class Lion extends Animal {
	
	/**
	 * Instantiates a new lion.
	 */
	public Lion(){
		super();
		this.name = "Lion";
		setDiet(new Carnivore());
		this.animalimage = "lio";
		this.wFactor = (float)0.8;
		
	}

}
