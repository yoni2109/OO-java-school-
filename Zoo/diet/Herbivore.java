package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

// TODO: Auto-generated Javadoc
/**
 * The Class Herbivore.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class Herbivore implements IDiet {

	/* (non-Javadoc)
	 * @see diet.IDiet#canEat(food.IEdible)
	 */
	@Override
	public boolean canEat(IEdible food) {
		return (food.getFoodtype() == EFoodType.VEGETABLE);
	}

	/* (non-Javadoc)
	 * @see diet.IDiet#canEat(food.EFoodType)
	 */
	public boolean canEat(EFoodType food_type) {
		return food_type == EFoodType.VEGETABLE;
	}
	
	/* (non-Javadoc)
	 * @see diet.IDiet#eat(animals.Animal, food.IEdible)
	 */
	@Override
	public boolean eat(Animal animal, IEdible food) {
		boolean isSuccess = canEat(food);
		if (isSuccess) {
			animal.setWeight(animal.getWeight() * 1.07);
		}
		return isSuccess;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "[" + this.getClass().getSimpleName() + "]";
	}
}
