package diet;

import animals.Animal;
import food.EFoodType;
import food.IEdible;

/**
 * @author Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 *
 */
public interface IDiet {

	/**
	 * @param food
	 * @return
	 */
	public boolean canEat(IEdible food);

	/**
	 * @param food
	 * @return
	 */
	public boolean eat(Animal animal, IEdible food);
	
	public boolean canEat(EFoodType food_type);

}
