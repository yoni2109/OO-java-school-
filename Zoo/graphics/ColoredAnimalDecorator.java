package graphics;

import animals.Animal;

// TODO: Auto-generated Javadoc
/**
 * The Class ColoredAnimalDecorator.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class ColoredAnimalDecorator implements ColoredAnimal {

	/** The animal. */
	private Animal animal;
	
	/**
	 * Instantiates a new colored animal decorator.
	 *
	 * @param a the a
	 */
	public ColoredAnimalDecorator(Animal a){
		animal = a;
	}
	
	/* (non-Javadoc)
	 * @see graphics.ColoredAnimal#PaintAnimal(java.lang.String)
	 */
	//private ColoredAnimal var;
	@Override
	public void PaintAnimal(String col) {
		// TODO Auto-generated method stub
		animal.setColor(col);//set new color
		animal.loadImages(animal.getanimalimage());//get new picture

	}

}
