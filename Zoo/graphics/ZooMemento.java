package graphics;
import java.util.ArrayList;

import mobility.Point;
import plants.Plant;
import food.EFoodType;
import animals.*;

// TODO: Auto-generated Javadoc
/**
 * The Class ZooMemento.
 *  Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class ZooMemento {
	
	/** The states. */
	private static int states=0;
	
	/** The current state. */
	private int currState;
	
	/** The state animals. */
	private ArrayList <Animal> state_animals;
	
	/** The state food. */
	private EFoodType state_food;
	
	/** The state forfood. */
	private Plant state_forfood;
	private int totaleatcount;
	
	/**
	 * Instantiates a new zoo memento.
	 *
	 * @param animals the animals
	 * @param food the food
	 * @param forfood the forfood
	 */
	public ZooMemento(ArrayList <Animal> animals,EFoodType food,Plant forfood,int eatcount) {
        state_animals = new ArrayList<Animal>();//animal in saved state
        for(Animal a:animals){//clone all animals
        	try {
				state_animals.add((Animal)a.clone());
				state_animals.get(state_animals.size()-1).location = (Point) a.location.clone();//clone loction animal
			} catch (CloneNotSupportedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	state_food = food;//if there is food
        	if (forfood!=null){
        	state_forfood = forfood;
        	}
        	else{
        		forfood=null;//if there is no food change to null
        	}
        }
        IncState();//increase the saved states
        currState=states;
        this.totaleatcount = eatcount;
    }
	public int get_total_eat_count(){
		return this.totaleatcount;
	}
	
	/**
	 * Gets the state animals.
	 *
	 * @return the state animals
	 */
	public ArrayList<Animal> get_state_animals(){//get saved animals
		return state_animals;
	}
	
	/**
	 * Restore.
	 *
	 * @param animals the animals
	 * @param food the food
	 * @param forfood the forfood
	 */
	public void restore(ArrayList <Animal> animals,EFoodType food,Plant forfood){//get back saved animals and food
		forfood = this.state_forfood;
		food = this.state_food;
		animals=this.state_animals;
	}
	
	/**
	 * Increase state.
	 */
	public static void IncState(){
		states++;
	}
	
	/**
	 * Decrease state.
	 */
	public static void DecState(){
		states--;
	}

	/**
	 * Gets the state food.
	 *
	 * @return the state food
	 */
	public EFoodType getState_food() {
		return state_food;
	}

	/**
	 * Sets the state food.
	 *
	 * @param state_food the new state food
	 */
	public void setState_food(EFoodType state_food) {
		this.state_food = state_food;
	}

	/**
	 * Gets the state forfood.
	 *
	 * @return the state forfood
	 */
	public Plant getState_forfood() {
		return state_forfood;
	}

	/**
	 * Sets the state forfood.
	 *
	 * @param state_forfood the new state forfood
	 */
	public void setState_forfood(Plant state_forfood) {
		this.state_forfood = state_forfood;
	}

	/**
	 * Gets the curr state.
	 *
	 * @return the curr state
	 */
	public int getCurrState() {
		return currState;
	}

	/**
	 * Sets the curr state.
	 *
	 * @param currState the new curr state
	 */
	public void setCurrState(int currState) {
		this.currState = currState;
	}
	


}
