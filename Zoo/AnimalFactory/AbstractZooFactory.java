package AnimalFactory;

import animals.Animal;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating AbstractZoo objects.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public interface AbstractZooFactory {
	
	/**
	 * Produce animal.
	 *
	 * @param type the type
	 * @return the animal
	 */
	public Animal produceAnimal(String type);
	
}
