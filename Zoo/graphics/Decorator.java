package graphics;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import animals.*;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

// TODO: Auto-generated Javadoc
/**
 * The Class Decorator.
 *  * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva
 */
public class Decorator extends JDialog implements ItemListener, ActionListener {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The left. */
	private JPanel left;
	
	/** The right. */
	private JPanel right;
	
	/** The okbutton. */
	private JButton okbutton ;
	
	/** The combox. */
	private JComboBox combox;
	
	/** The jrb. */
	protected JRadioButton[] jrb;
	
	/** The new color. */
	protected String newColor;
	
	/** The rbg. */
	private ButtonGroup rbg ;
	
	/**
	 * Instantiates a new decorator.
	 *
	 * @param animals the animals
	 */
	public Decorator(ArrayList<Animal> animals){
		super(new JFrame(),"Decorator",true);
		/*gui for the decorator*/
		/*left panel for button and combox and right panel for radio buttons*/
		okbutton = new JButton("OK");
		combox = new JComboBox();
		jrb = new JRadioButton[2];
		jrb[0] = new JRadioButton("red");
		jrb[1] = new JRadioButton("blue");
		rbg = new ButtonGroup();
		rbg.add(jrb[0]);
		rbg.add(jrb[1]);
		
		left = new JPanel();
		right = new JPanel();
		for (Animal a : animals)//loop to get all animal with natural color
		{
			if (a.getColor() == "Natural" && a.getIsAlive())
			{
				combox.addItem(a);//add to combox
			}
		}
		/*set and add the button and radio buttons*/
		setLayout(new BorderLayout());
		left.add("North",combox);
		left.add("South",okbutton);
		right.add("South",jrb[0]);
		right.add("South",jrb[1]);
		add("East",right);
		add("West",left);
		
		okbutton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				okbutton_click();//call the func to change the animal
			}
		});
	}

	/**
	 * Okbutton click.
	 */
	protected void okbutton_click(){
		boolean colorselected=false;
		if (jrb[0].isSelected()){//if we choose red
			newColor="Red";
			colorselected = true;
		}
		else if (jrb[1].isSelected()){//if we choose blue
			newColor="Blue";
			colorselected=true;
		}
		else
			JOptionPane.showMessageDialog(this, "no color was selected");//if there was not color
		if(colorselected){
			Animal a= (Animal) combox.getSelectedItem();
			ColoredAnimalDecorator dec = new ColoredAnimalDecorator(a);
			dec.PaintAnimal(newColor);//paint the animal
		}
		this.dispose();
		
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
	}

}
