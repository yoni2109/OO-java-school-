package animals;

import diet.Herbivore;


// TODO: Auto-generated Javadoc
/**
 * The Class Elephant.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class Elephant extends Animal {
	
	/**
	 * Instantiates a new elephant.
	 */
	public Elephant(){
		super();
		this.name = "Elephant";
		setDiet(new Herbivore());
		this.animalimage = "elf";
		this.wFactor = (float)10;
		
	}
	 
}
