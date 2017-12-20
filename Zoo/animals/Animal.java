package animals;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;





//import AnimalFactory.AbstractZooFactory;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import graphics.ColoredAnimal;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
//import mobility.Mobile;
import mobility.Point;

// TODO: Auto-generated Javadoc
/**
 * The Class Animal.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public abstract class Animal extends Observable implements IEdible, IDrawable,
		IAnimalBehavior, Runnable,ColoredAnimal,Cloneable {

	/** The eat distance. */
	protected final int EAT_DISTANCE = 5;
	
	/** The animalimage. */
	protected String animalimage;
	
	/** The location. */
	public Point location;
	
	/** The diet. */
	private IDiet diet;
	
	/** The name. */
	protected String name;
	
	/** The weight. */
	private double weight;
	
	/** The size. */
	protected int size;
	
	/** The color. */
	protected String col;
	
	/** The horizontal speed. */
	protected int horSpeed;
	
	/** The vertical speed. */
	protected int verSpeed;
	
	/** The coord changed. */
	protected boolean coordChanged;
	
	/** The x dir. */
	protected int x_dir;
	
	/** The y dir. */
	protected int y_dir;
	
	/** The eat count. */
	protected int eatCount;
	
	/** The pan. */
	protected ZooPanel pan;
	
	/** The thread suspended. */
	protected boolean threadSuspended;
	
	/** The img 2. */
	protected BufferedImage img1, img2;
	
	/** The cor x 6. */
	protected int cor_x1, cor_x2, cor_x3, cor_x4, cor_x5, cor_x6;
	
	/** The cor y 6. */
	protected int cor_y1, cor_y2, cor_y3, cor_y4, cor_y5, cor_y6;
	
	/** The cor high and width. */
	protected int cor_w, cor_h;
	
	/** The isalive. */
	protected boolean isalive;
	
	/** The w factor. */
	protected float wFactor;
	
	/**
	 * Instantiates a new animal.
	 */
	public Animal(){
		location = new Point(0,0);
		isalive = false;
		coordChanged = false;
	}
	
	/**
	 * Gets the animal image.
	 *
	 * @return the animal image
	 */
	public String getanimalimage(){
		return animalimage;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#clone()
	 */
	/*clone the object (DP)*/
	@Override
	public Object clone()throws CloneNotSupportedException{
		return super.clone();
	}
	
	/* (non-Javadoc)
	 * @see graphics.ColoredAnimal#PaintAnimal(java.lang.String)
	 */
	@Override
	public void PaintAnimal(String col) {
		// TODO Auto-generated method stub
	}
	
	/**
	 * Instantiates a new animal.
	 *
	 * @param animal a the a
	 */
	public Animal(Animal a){
		location = new Point(a.location.getX(),a.location.getY());
		isalive=a.isalive;
		coordChanged=a.coordChanged;
		size=a.size;
		weight=a.weight;
		horSpeed=a.horSpeed;
		verSpeed=a.verSpeed;
		col=a.col;
		pan=a.pan;
		x_dir=a.x_dir;
		y_dir=a.y_dir;
		cor_x1 = cor_x3 = cor_x5 = cor_x6=a.cor_x1;
		cor_y1 = cor_y3 = cor_y5 = cor_y6 = a.cor_y1;
		cor_x2 = cor_y2 = cor_x4 = cor_y4 = a.cor_x2;
		cor_w = cor_h = a.cor_h;
		animalimage=a.animalimage;
		loadImages(animalimage);
		wFactor=a.wFactor;
		threadSuspended=a.threadSuspended;
		eatCount=a.eatCount;
		name=a.name;
		
	}
	
	/**
	 * Initialize.
	 *
	 * @param sz the sz
	 * @param hor the hor
	 * @param ver the ver
	 * @param c the c
	 * @param p the p
	 */
	public void initialize(int sz,int hor,int ver,String c,ZooPanel p){
		size = sz;
		weight = size*wFactor;
		horSpeed = hor;
		verSpeed = ver;
		col = c;
		pan = p;
		x_dir = 1;
		y_dir = 1;
		cor_x1 = cor_x3 = cor_x5 = cor_x6 = 0;
		cor_y1 = cor_y3 = cor_y5 = cor_y6 = 0;
		cor_x2 = cor_y2 = cor_x4 = cor_y4 = -1;
		cor_w = cor_h = size;
		loadImages(animalimage);
	}
	
	/**
	 * Dup.
	 *
	 * @param animal a the a
	 */
	public void dup(Animal a){
		try {
			a= (Animal) this.clone();//try to clone
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(String color){
		col = color;
	}
	
	/* (non-Javadoc)
	 * @see food.IEdible#getFoodtype()
	 */
	public EFoodType getFoodtype() {

		return EFoodType.MEAT;
	}
	
	/**
	 * Gets the diet.
	 *
	 * @return the diet
	 */
	public IDiet getDiet() {
		return diet;
	}
	
	/**
	 * Gets the checks if is alive.
	 *
	 * @return the checks if is alive
	 */
	public boolean getIsAlive()
	{
		return this.isalive;
	}

	/* (non-Javadoc)
	 * @see graphics.IAnimalBehavior#getName()
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public double getWeight() {
		return this.weight;
	}

	/**
	 * Sets the weight.
	 *
	 * @param w the new weight
	 */
	public void setWeight(double w) {
		weight = w;
	}

	/**
	 * Sets the diet.
	 *
	 * @param diet the new diet
	 */
	protected void setDiet(IDiet diet) {
		this.diet = diet;
	}

	/* (non-Javadoc)
	 * @see graphics.IAnimalBehavior#getSize()
	 */
	public int getSize() {
		return size;
	}

	/**
	 * Gets the hor speed.
	 *
	 * @return the hor speed
	 */
	public int getHorSpeed() {
		return horSpeed;
	}

	/**
	 * Sets the hor speed.
	 *
	 * @param hor the new hor speed
	 */
	public void setHorSpeed(int hor) {
		horSpeed = hor;
	}

	/**
	 * Gets the ver speed.
	 *
	 * @return the ver speed
	 */
	public int getVerSpeed() {
		return verSpeed;
	}

	/**
	 * Sets the ver speed.
	 *
	 * @param ver the new ver speed
	 */
	public void setVerSpeed(int ver) {
		verSpeed = ver;
	}

	/* (non-Javadoc)
	 * @see graphics.IAnimalBehavior#eatInc()
	 */
	public void eatInc() {
		eatCount++;
	}

	/* (non-Javadoc)
	 * @see graphics.IAnimalBehavior#getEatCount()
	 */
	public int getEatCount() {
		return eatCount;
	}

	/* (non-Javadoc)
	 * @see graphics.IAnimalBehavior#setSuspend()
	 */
	synchronized public void setSuspend() {
		threadSuspended = true;
	}

	/* (non-Javadoc)
	 * @see graphics.IAnimalBehavior#setResume()
	 */
	synchronized public void setResume() {
		threadSuspended = false;
		notify();
	}

	/* (non-Javadoc)
	 * @see graphics.IAnimalBehavior#getChanges()
	 */
	synchronized public boolean getChanges() {
		return coordChanged;
	}

	/* (non-Javadoc)
	 * @see graphics.IAnimalBehavior#setChanges(boolean)
	 */
	synchronized public void setChanges(boolean state) {
		coordChanged = state;
	}

	/* (non-Javadoc)
	 * @see graphics.IDrawable#getColor()
	 */
	public String getColor() {
		return col;
	}

	/* (non-Javadoc)
	 * @see graphics.IDrawable#loadImages(java.lang.String)
	 */
	public void loadImages(String nm) {
		switch (getColor()) {
		case "Red":
			try {
				img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_1.png"));
				img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_r_2.png"));
			} catch (IOException e) {
				System.out.println("Cannot load picture");
			}
			break;
		case "Blue":
			try {
				img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_1.png"));
				img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_b_2.png"));
			} catch (IOException e) {
				System.out.println("Cannot load picture");
			}
			break;
		default:
			try {
				img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_n_1.png"));
				img2 = ImageIO.read(new File(PICTURE_PATH + nm + "_n_2.png"));
			} catch (IOException e) {
				System.out.println("Cannot load picture");
			}
		}
	}

	/**
	 * Kill animal.
	 */
	public synchronized void kill_animal() {
		isalive = false;
	}
	
	/**
	 * Setlocation.
	 *
	 * @param x the x
	 * @param y the y
	 */
	public void setlocation(int x,int y){
		this.location = new Point(x,y);
	}
	public boolean is_awake(){
		return threadSuspended;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		synchronized (this) {
			
		//pan.addtoanimals(this);
		}
		isalive=true;
		while (isalive) {
			try {
				Thread.sleep(50);
				synchronized (this) {
					while (threadSuspended)
						wait();
				}
			} catch (InterruptedException e) {
				System.out.println(getName() + " dead...");
				return;
			}

			if (this.getDiet().canEat(pan.checkFood())) {
				double oldSpead = Math.sqrt(horSpeed * horSpeed + verSpeed
						* verSpeed);
				double newHorSpeed = oldSpead
						* (location.getX() - pan.getWidth() / 2)
						/ (Math.sqrt(Math.pow(location.getX() - pan.getWidth()
								/ 2, 2)
								+ Math.pow(location.getY() - pan.getHeight()
										/ 2, 2)));
				double newVerSpeed = oldSpead
						* (location.getY() - pan.getHeight() / 2)
						/ (Math.sqrt(Math.pow(location.getX() - pan.getWidth()
								/ 2, 2)
								+ Math.pow(location.getY() - pan.getHeight()
										/ 2, 2)));
				int v = 1;
				if (newVerSpeed < 0) {
					v = -1;
					newVerSpeed = -newVerSpeed;
				}
				if (newVerSpeed > 10)
					newVerSpeed = 10;
				else if (newVerSpeed < 1) {
					if (location.getY() != pan.getHeight() / 2)
						newVerSpeed = 1;
					else
						newVerSpeed = 0;
				}
				int h = 1;
				if (newHorSpeed < 0) {
					h = -1;
					newHorSpeed = -newHorSpeed;
				}
				if (newHorSpeed > 10)
					newHorSpeed = 10;
				else if (newHorSpeed < 1) {
					if (location.getX() != pan.getWidth() / 2)
						newHorSpeed = 1;
					else
						newHorSpeed = 0;
				}
				location.setX((int) (location.getX() - newHorSpeed * h));
				location.setY((int) (location.getY() - newVerSpeed * v));
				if (location.getX() < pan.getWidth() / 2)
					x_dir = 1;
				else
					x_dir = -1;
				if ((Math.abs(location.getX() - pan.getWidth() / 2) < EAT_DISTANCE)
						&& (Math.abs(location.getY() - pan.getHeight() / 2) < EAT_DISTANCE)) {
					pan.eatFood(this);
				}
			} 
			else {
				location.setX(location.getX() + horSpeed * x_dir);
				location.setY(location.getY() + verSpeed * y_dir);
			}

			if (location.getX() > pan.getWidth() + cor_x1) {
				x_dir = -1;
				if (cor_x2 != -1)
					location.setX(location.getX() + cor_x2);
			} else if (location.getX() < cor_x3) {
				x_dir = 1;
				if (cor_x4 != -1)
					location.setX(cor_x4);
			}

			if (location.getY() > (pan.getHeight() + cor_y1-size-35)) {
				y_dir = -1;
				if (cor_y2 != -1)
					location.setY(location.getY() + cor_y2);
			} else if (location.getY() < cor_y3) {
				y_dir = 1;
				if (cor_y4 != -1)
					location.setY(cor_y4);
			}
			setChanged();
			notifyObservers();
			//setChanges(true);
		}
		System.out.println(getName() + " dead...");

	}

	/* (non-Javadoc)
	 * @see graphics.IDrawable#drawObject(java.awt.Graphics)
	 */
	public void drawObject(Graphics g) {
		if (x_dir == 1) // an animal goes to right side
		{
			g.drawImage(img1, location.getX() + cor_x5-size, location.getY()
					+ cor_y5, cor_w, cor_h, pan);
		} else // an animal goes to left side
		{
			g.drawImage(img2, location.getX() + cor_x6, location.getY()
					+ cor_y6, cor_w, cor_h, pan);
		}

	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "[" + getName() + ": weight=" + weight + ", color=" + col + "]";
	}
}
