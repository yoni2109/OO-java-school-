package AnimalFactory;

import animals.Animal;
import animals.Bear;


// TODO: Auto-generated Javadoc
/**
 * A factory for creating Omnivore objects.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class OmnivoreFactory implements AbstractZooFactory {

	/* (non-Javadoc)
	 * @see AnimalFactory.AbstractZooFactory#produceAnimal(java.lang.String)
	 */
	/*get type and return the instance*/
	@Override
	public Animal produceAnimal(String type) {
		if(type == "Bear")
			return new Bear();
		return null;
			
	}

}
