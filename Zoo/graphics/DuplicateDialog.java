package graphics;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;






import mobility.Point;
import animals.*;

// TODO: Auto-generated Javadoc
/**
 * The Class DuplicateDialog.
 * Mark Rabayev 310356621 Yehonatan Simhon 301506465 beer sheva

 */
public class DuplicateDialog extends JDialog implements ItemListener, ActionListener{
	
	/** The okbutton. */
	private JButton okbutton ;
	
	/** The combox. */
	private JComboBox combox;
	
	/** The vs. */
	private JSlider hs,vs;
	
	/** The left. */
	private JPanel left;
	
	/** The right. */
	private JPanel right;
	
	/** The right HS. */
	private JPanel rightHS;
	
	/** The right VS. */
	private JPanel rightVS;
	
	/** The vsl. */
	private JLabel hsl,vsl;
	
	/** The new HS. */
	private int newHS;
	
	/** The new VS. */
	private int newVS;
	
	/** The pan. */
	private ZooPanel pan;
	
	/**
	 * Instantiates a new duplicate dialog.
	 *
	 * @param animals the animals
	 * @param pan the pan
	 */
	public DuplicateDialog(ArrayList<Animal> animals,ZooPanel pan)
	{
		super(new JFrame(),"DuplicateDialog",true);
		
		this.pan=pan;
		okbutton = new JButton("OK");
		combox = new JComboBox();
		hs = new JSlider(0,10);
		vs = new JSlider(0,10);
		left = new JPanel();
		right = new JPanel();
		rightHS = new JPanel();
		rightVS = new JPanel();
		hsl = new JLabel("Horizontal Speed");
		vsl = new JLabel("Vertical Speed");
		
		for (Animal a : animals)//get all animal to combox
		{
			if (a.getIsAlive())
			{
				combox.addItem(a);
			}
		}
		/*set and add to the dialog*/
		right.setLayout(new GridLayout(2,2,10,0));
		setLayout(new BorderLayout());
		hs = new JSlider(0,10);
		hs.setMajorTickSpacing(2);
		hs.setMinorTickSpacing(1);
		hs.setPaintTicks(true);
		hs.setPaintLabels(true);
		vs = new JSlider(0,10);
		vs.setMajorTickSpacing(2);
		vs.setMinorTickSpacing(1);
		vs.setPaintTicks(true);
		vs.setPaintLabels(true);
		right.add(hsl);
		right.add(vsl);
		right.add(hs);
		right.add(vs);
		left.add("North",combox);
		left.add("South",okbutton);
		add("East",right);
		add("West",left);
		
		
		okbutton.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				okbutton_click();
			}
		});
		
		
		
	}
	
	/**
	 * Okbutton click.
	 */
	public void okbutton_click()
	{
		/*get the speeds*/
		newHS=hs.getValue();
		newVS=vs.getValue();
		Animal a,b;
		a=b=null;
		try {//get the animal that we want to duplicate
			a=((Animal)combox.getSelectedItem());
			
		} catch (Exception e) {}
		try {
			b=(Animal) a.clone();//duplicate
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		if(b!=null && a!=null){
			try {
				b.location =(Point)a.location.clone();//get the loction
			} catch (CloneNotSupportedException e) {
				e.printStackTrace();
			}
			
			b.initialize(a.getSize(), newHS, newVS, a.getColor(), this.pan);//init b
			b.kill_animal();//change isalive to false
			this.pan.addAnimal(b);//add to panel
		}
		this.dispose();

	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	@Override
	public void itemStateChanged(ItemEvent e) {		
	}

}
