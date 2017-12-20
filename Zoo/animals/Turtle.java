package animals;

import diet.Herbivore;


// TODO: Auto-generated Javadoc
/**
 * The Class Turtle.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 *
 */
public class Turtle extends Animal {
	
	/**
	 * Instantiates a new turtle.
	 */
	public Turtle(){
		super();
		this.name = "Turtle";
		setDiet(new Herbivore());
		this.animalimage = "trt";
		this.wFactor = (float)0.5;
		
	}

}
