package AnimalFactory;

import animals.Animal;
import animals.Lion;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Carnivore objects.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class CarnivoreFactory implements AbstractZooFactory {

	/* 
	 * 
	 */
	/*get type and return the instance*/
	@Override
	public Animal produceAnimal(String type) {
		if(type == "Lion"){
			return new Lion();
		}
		return null;

	}

}
