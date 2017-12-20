package AnimalFactory;

import animals.Animal;
import animals.Elephant;
import animals.Giraffe;
import animals.Turtle;

// TODO: Auto-generated Javadoc
/**
 * A factory for creating Herbivore objects.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class HerbivoreFactory implements AbstractZooFactory {

	/* (non-Javadoc)
	 * @see AnimalFactory.AbstractZooFactory#produceAnimal(java.lang.String)
	 */
	/*get the type of animal and return the instance Elephant/giraffe/turtle*/
	@Override
	public Animal produceAnimal(String type) {
		if (type == "Elephant")
			return new Elephant();
		else if(type == "Giraffe")
			return new Giraffe();
		else if(type=="Turtle")
			return new Turtle();
		return null;

	}

}
