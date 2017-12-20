package graphics;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.*;

import AnimalFactory.AbstractZooFactory;
import AnimalFactory.CarnivoreFactory;
import AnimalFactory.HerbivoreFactory;
import AnimalFactory.OmnivoreFactory;
import animals.*;
//import animals.Bear;
//import animals.Elephant;
//import animals.Giraffe;
//import animals.Lion;
//import animals.Turtle;
import food.EFoodType;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// TODO: Auto-generated Javadoc
/**
 * The Class ZooPanel. Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer
 * sheva
 */
public class ZooPanel extends JPanel implements ActionListener/* , Runnable */{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The Constant MAX_ANIMAL_NUMBER. */
	private static final int MAX_ANIMAL_NUMBER = 10;

	/** The Constant MAX_QUEUE_ZISE. */
	public static final int MAX_QUEUE_ZISE = 15;

	/** The curr animals amount. */
	public static int CURR_ANIMALS_AMOUNT = 0;

	/**
	 * Inc animals amount.
	 */
	public void inc_animals_amount() {
		CURR_ANIMALS_AMOUNT++;
	}

	/**
	 * Dec animals amount.
	 */
	public void dec_animals_amount() {
		if (CURR_ANIMALS_AMOUNT > 0)
			CURR_ANIMALS_AMOUNT--;
	}

	/**
	 * Gets the animals amount.
	 *
	 * @return the animals amount
	 */
	public int get_animals_amount() {
		return CURR_ANIMALS_AMOUNT;
	}

	/** The savedstates. */
	private ZooMemento savedstates[];

	/** The single. */
	private static ZooPanel single = new ZooPanel();

	/** The threadpool. */
	private static ExecutorService threadpool;

	/** The background path. */
	private final String BACKGROUND_PATH = Animal.PICTURE_PATH + "savanna.jpg";

	/** The meat path. */
	private final String MEAT_PATH = Animal.PICTURE_PATH + "meat.gif";

	/** The frame. */
	private ZooFrame frame;

	/** The Food. */
	private EFoodType Food;

	/** The p 1. */
	private JPanel p1;

	/** The b num. */
	private JButton[] b_num;

	/** The b hm 4. */
	private JButton[] b_hm4;

	/** The names. */
	private String[] names = { "Add Animal", "Sleep", "Wake up", "Clear",
			"Food", "Info", "Exit" };

	/** The names HM 4. */
	private String[] namesHM4 = { "Decorator", "Duplicate", "Save State",
			"Restore State" };

	/** The animals. */
	public ArrayList<Animal> animals;

	/** The for food. */
	private Plant forFood = null;

	/** The scroll pane. */
	private JScrollPane scrollPane;

	/** The is table visible. */
	private boolean isTableVisible;

	/** The total count. */
	private int totalCount;

	/** The img m. */
	private BufferedImage img, img_m;

	/** The bgr. */
	private boolean bgr;

	/** The controller. */
	private ZooObserver controller;

	/** The curr. */
	protected AbstractZooFactory curr;

	/** The savedstate. */
	private int savedstate;

	/**
	 * Gets the instance.
	 *
	 * @return the instance
	 */
	public static ZooPanel getinstance() {
		return single;
	}

	/**
	 * Sets the zooframe.
	 *
	 * @param f
	 *            the new zooframe
	 */
	public void set_zooframe(ZooFrame f) {
		frame = f;
	}

	/**
	 * Instantiates a new zoo panel.
	 */
	private ZooPanel() {
		savedstate = 0;
		savedstates = new ZooMemento[3];
		threadpool = Executors.newFixedThreadPool(MAX_ANIMAL_NUMBER);
		Food = EFoodType.NOTFOOD;
		totalCount = 0;
		isTableVisible = false;
		animals = new ArrayList<Animal>();
		controller = new ZooObserver(this);
		setBackground(new Color(255, 255, 255));
		p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 7, 0, 0));
		p1.setBackground(new Color(0, 150, 255));
		b_num = new JButton[names.length];
		for (int i = 0; i < names.length; i++) {
			b_num[i] = new JButton(names[i]);
			b_num[i].addActionListener(this);
			b_num[i].setBackground(Color.lightGray);
			p1.add(b_num[i]);
		}
		b_hm4 = new JButton[namesHM4.length];
		for (int i = 0; i < namesHM4.length; i++) {
			b_hm4[i] = new JButton(namesHM4[i]);
			b_hm4[i].addActionListener(this);
			p1.add(b_hm4[i]);
		}

		setLayout(new BorderLayout());
		add("South", p1);

		img = img_m = null;
		bgr = false;
		try {
			img = ImageIO.read(new File(BACKGROUND_PATH));
		} catch (IOException e) {
			System.out.println("Cannot load background");
		}
		try {
			img_m = ImageIO.read(new File(MEAT_PATH));
		} catch (IOException e) {
			System.out.println("Cannot load meat");
		}
	}

	/**
	 * Addtoanimals.
	 *
	 * @param addthis
	 *            the addthis
	 */
	public synchronized void addtoanimals(Animal addthis) {
		animals.add(addthis);
		animals.get(animals.indexOf(addthis)).addObserver(controller);
	}

	/**
	 * Creates the animal factory.
	 *
	 * @param type
	 *            the type
	 * @return the abstract zoo factory
	 */
	public AbstractZooFactory create_animal_factory(String type) {
		switch (type) {
		case "Carnivore":
			return new CarnivoreFactory();
		case "Omnivore":
			return new OmnivoreFactory();
		case "Herbivore":
			return new HerbivoreFactory();
		default:
			return null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (bgr && (img != null))
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

		if (Food == EFoodType.MEAT)
			g.drawImage(img_m, getWidth() / 2 - 20, getHeight() / 2 - 20, 40,
					40, this);

		if ((Food == EFoodType.VEGETABLE) && (forFood != null))
			forFood.drawObject(g);

		synchronized (this) {
			for (Animal an : animals)
				if (an.getIsAlive()) {
					an.drawObject(g);
				}
		}
	}

	/**
	 * Sets the backgr.
	 *
	 * @param num
	 *            the new backgr
	 */
	public void setBackgr(int num) {
		switch (num) {
		case 0:
			setBackground(new Color(255, 255, 255));
			bgr = false;
			break;
		case 1:
			setBackground(new Color(0, 155, 0));
			bgr = false;
			break;
		default:
			bgr = true;
		}
		repaint();
	}

	/**
	 * Check food.
	 *
	 * @return the e food type
	 */
	synchronized public EFoodType checkFood() {
		return Food;
	}

	/**
	 * CallBack function.
	 *
	 * @param an
	 *            the an
	 */
	synchronized public void eatFood(Animal an) {
		if (Food != EFoodType.NOTFOOD) {
			if (Food == EFoodType.VEGETABLE)
				forFood = null;
			Food = EFoodType.NOTFOOD;
			an.eatInc();
			totalCount++;
			System.out.println("The " + an.getName() + " with " + an.getColor()
					+ " color and size " + an.getSize() + " ate food.");
		} else {
			System.out.println("The " + an.getName() + " with " + an.getColor()
					+ " color and size " + an.getSize() + " missed food.");
		}
	}

	/**
	 * Choose.
	 */
	public void choose() {
		if (animals.size() < 15) {
			String type[] = { "Carnivore", "Omnivore", "Herbivore" };

			String carni[] = { "Lion" };
			String omni[] = { "Bear" };
			String herbi[] = { "Giraffe", "Elephant", "Turtle" };
			String Animals[][] = { carni, omni, herbi };
			int selecttype = JOptionPane.showOptionDialog(frame,
					"choose Animal Factory", "new animal",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, type, type[0]);
			if (selecttype < 0) {
				return;
			}
			curr = create_animal_factory(type[selecttype]);
			int selectanimal = JOptionPane.showOptionDialog(frame,
					"choose Animal Factory", "new animal",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, Animals[selecttype],
					null);
			if (selectanimal < 0) {
				return;
			}
			Animal temp = curr.produceAnimal(Animals[selecttype][selectanimal]);
			AddAnimalDialog dial = new AddAnimalDialog(this,
					"Add an animal to aquarium", temp);
			dial.setVisible(true);
		} else {
			JOptionPane.showMessageDialog(frame, "max animals amount");
		}

	}

	/**
	 * Adds the dialog.
	 */
	public void addDialog() {
		if (animals.size() < MAX_QUEUE_ZISE) {
			choose();

		}

	}

	/**
	 * Decorator
	 */
	public void deco() {
		if (animals.size() > 0) {// if there is animals
			Decorator deco = new Decorator(animals);
			deco.pack();
			deco.setVisible(true);
		}

	}

	/**
	 * Duplicate.
	 */
	public void duplicate() {
		if (animals.size() > 0 && animals.size() < MAX_QUEUE_ZISE) {// if there is animals
			DuplicateDialog dup = new DuplicateDialog(animals, this);
			dup.pack();
			dup.setVisible(true);
		}
	}

	/**
	 * Save state.
	 */
	public void save_state() {
		if (savedstate >= 0 && savedstate < 3) {// max 3 saved states

			this.savedstate++;// increase the saved states
			savedstates[savedstate - 1] = new ZooMemento(animals, Food, forFood,totalCount);

		} else
			JOptionPane.showMessageDialog(frame, "you already saved 3 states");
	}

	/**
	 * Restore state.
	 */
	public void restore_state() {
		String states[] = { "State 1", "State 2", "State 3", "cancel" };// the
																		// buttns

		if (savedstate == 0) // if there is no saved states
		{
			JOptionPane.showMessageDialog(frame, "There is not saved states");
			return;
		}
		/* get the saved state */
		int selectState = JOptionPane.showOptionDialog(frame,
				"Please Choose state for restore", "Saved states",
				JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE,
				null, states, states[0]);
		if (selectState > savedstate) {
			JOptionPane.showMessageDialog(frame,
					"There is not state to restore");
			return;
		}

		switch (selectState) {// check which state chosen
		case 0:
			if (savedstates[0] != null) {
				/* retore all the animals and food */
				animals = savedstates[0].get_state_animals();
				forFood = savedstates[0].getState_forfood();
				Food = savedstates[0].getState_food();
				totalCount = savedstates[0].get_total_eat_count();
				ZooMemento.DecState();
				savedstates[0] = null;
				execute();
				savedstate--;
				savedstates[0] = savedstates[1];
				savedstates[1] = savedstates[2];
				savedstates[2] = null;
			}
			break;
		case 1:
			if (savedstates[1] != null) {
				animals = savedstates[1].get_state_animals();
				forFood = savedstates[1].getState_forfood();
				Food = savedstates[1].getState_food();
				totalCount = savedstates[1].get_total_eat_count();
				ZooMemento.DecState();
				savedstates[1] = null;
				execute();
				savedstate--;
				savedstates[1] = savedstates[2];
				savedstates[2] = null;
			} else {
				JOptionPane.showMessageDialog(frame, "This state is empty");
			}
			break;
		case 2:
			if (savedstates[2] != null) {
				animals = savedstates[2].get_state_animals();
				forFood = savedstates[2].getState_forfood();
				Food = savedstates[2].getState_food();
				totalCount = savedstates[2].get_total_eat_count();
				ZooMemento.DecState();
				savedstates[2] = null;
				execute();
				savedstate--;
				savedstates[2] = null;
			} else {
				JOptionPane.showMessageDialog(frame, "This state is empty");
			}
			break;

		default:
			break;
		}
		repaint();

	}

	/**
	 * Adds the animal.
	 *
	 * @param animal
	 *            the animal
	 */
	public void addAnimal(Animal animal) {
		if (animal == null) {
			return;
		}

		addtoanimals(animal);
		threadpool.execute(animal);

	}

	/**
	 * Start.
	 */
	public void start() {
		for (Animal an : animals)
			an.setResume();
	}

	/**
	 * Stop.
	 */
	public void stop() {
		for (Animal an : animals)
			an.setSuspend();
	}

	/**
	 * Clear.
	 */
	synchronized public void clear() {
		int count_kill = 0;
		for (Animal an : animals)
			if (an.getIsAlive()) {
				count_kill++;
				an.kill_animal();
				an.setResume();
			}
		for (int i = 0; i < count_kill; i++) {
			animals.remove(0);
		}
		Food = EFoodType.NOTFOOD;
		forFood = null;
		totalCount = 0;
		repaint();
	}

	/**
	 * Prey eating.
	 *
	 * @param predator
	 *            the predator
	 * @param prey
	 *            the prey
	 */
	synchronized public void preyEating(Animal predator, Animal prey) {
		predator.eatInc();
		totalCount -= (prey.getEatCount() - 1);
	}

	/**
	 * Adds the food.
	 */
	synchronized public void addFood() {
		if (Food == EFoodType.NOTFOOD) {
			Object[] options = { "Meat", "Cabbage", "Lettuce" };
			int n = JOptionPane.showOptionDialog(frame, "Please choose food",
					"Food for animals", JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
			switch (n) {
			case 0: // Meat
				Food = EFoodType.MEAT;
				break;
			case 1: // Cabbage
				Food = EFoodType.VEGETABLE;
				forFood = Cabbage.getinstance();
				forFood.setpanel(this);
				break;
			default: // Lettuce
				Food = EFoodType.VEGETABLE;
				forFood = Lettuce.getinstance();
				forFood.setpanel(this);
				break;
			}
		} else {
			Food = EFoodType.NOTFOOD;
			forFood = null;
		}
		repaint();
	}

	/**
	 * Info.
	 */
	public void info() {
		if (isTableVisible == false) {
			int i = 0;
			int sz = animals.size();

			String[] columnNames = { "Animal", "Color", "Weight", "Hor. speed",
					"Ver. speed", "Eat counter" };
			String[][] data = new String[sz + 1][columnNames.length];
			for (Animal an : animals) {
				data[i][0] = an.getName();
				data[i][1] = an.getColor();
				data[i][2] = new Integer((int) (an.getWeight())).toString();
				data[i][3] = new Integer(an.getHorSpeed()).toString();
				data[i][4] = new Integer(an.getVerSpeed()).toString();
				data[i][5] = new Integer(an.getEatCount()).toString();
				i++;
			}
			data[i][0] = "Total";
			data[i][5] = new Integer(totalCount).toString();

			JTable table = new JTable(data, columnNames);
			scrollPane = new JScrollPane(table);
			scrollPane.setSize(450, table.getRowHeight() * (sz + 1) + 24);
			add(scrollPane, BorderLayout.CENTER);
			isTableVisible = true;
		} else {
			isTableVisible = false;
		}
		scrollPane.setVisible(isTableVisible);
		repaint();
	}

	/**
	 * Destroy.
	 */
	public void destroy() {
		for (Animal an : animals)
			an.kill_animal();
		System.exit(0);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == b_num[0]) // "Add Animal"
			addDialog();
		else if (e.getSource() == b_num[1]) // "Sleep"
			stop();
		else if (e.getSource() == b_num[2]) // "Wake up"
			start();
		else if (e.getSource() == b_num[3]) // "Clear"
			clear();
		else if (e.getSource() == b_num[4]) // "Food"
			addFood();
		else if (e.getSource() == b_num[5]) // "Info"
			info();
		else if (e.getSource() == b_num[6]) // "Exit"
			destroy();
		else if (e.getSource() == b_hm4[0]) // decorator
			deco();
		else if (e.getSource() == b_hm4[1]) // Duplicate
			duplicate();
		else if (e.getSource() == b_hm4[2])// Save State
			save_state();
		else if (e.getSource() == b_hm4[3])// Restore State
			restore_state();
	}

	/**
	 * Execute.
	 */
	public void execute() {
		threadpool.shutdownNow();
		threadpool = Executors.newFixedThreadPool(MAX_ANIMAL_NUMBER);
		for (Animal an : animals)
			threadpool.execute(an);
	}

	/**
	 * Animaleatsanother.
	 */
	public void animaleatsanother() {
		boolean prey_eaten = false;
		synchronized (this) {
			for (Animal predator : animals) {
				if (!predator.is_awake()) {
					for (Animal prey : animals) {
						if (predator != prey
								&& prey.getIsAlive()
								&& predator.getDiet().canEat(prey)
								&& predator.getWeight() / prey.getWeight() >= 2
								&& (Math.abs(predator.location.getX()
										- prey.location.getX()) < prey
											.getSize())
								&& (Math.abs(predator.location.getY()
										- prey.location.getY()) < prey
											.getSize())) {
							preyEating(predator, prey);
							System.out.print("The " + predator
									+ " cought up the " + prey + " ==> ");
							animals.get(animals.indexOf(prey)).kill_animal();
							animals.remove(prey);
							repaint();
							prey_eaten = true;
							break;
						}
					}
				}
				if (prey_eaten)
					break;
			}
		}
	}

}