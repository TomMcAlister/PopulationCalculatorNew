//Created by Tom McAlister - u3187811
//Date created - 8/4/18
//Date last modifed - 23/4/18
//Description - This is a GUI application that will show data graphed from a list of presets
package u3187811.tom.com;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class Stage3Real {
	
	// Graph stuff
	private JFrame frameGUI;
	private Vector<Species> vecSpecies; 
	
	final static int gWidth = 15;  
	final static int[] xA = {25,55,85,115,145,175,205,235,265,295}; 

	//Variables
	int finalPop, 
		storedPop, 
		dead, 
		il;
	String finalPopInt, 
		   sdead;

	//Array
	int[] aVar = new int[20]; 
	String[] saLine = null; 
	
//More graph stuff
	private BufferedImage image;
	private Graphics2D gIM;
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stage3Real window = new Stage3Real();
					window.frameGUI.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	
	public Stage3Real() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	//Initiliazation and creating of elements
	private void initialize() throws IOException {
		frameGUI = new JFrame();
		frameGUI.getContentPane().setBackground(Color.GREEN);
		frameGUI.getContentPane().setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		frameGUI.setBounds(100, 100, 640, 499);
		frameGUI.setFont(new Font("Times New Roman", Font.BOLD, 16));
		frameGUI.setTitle("Java Stage 3 - IIT S1 2018");
		frameGUI.getContentPane().setForeground(Color.BLACK);
		frameGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameGUI.getContentPane().setLayout(null);
		
		JLabel 
		species = new JLabel("Select a Species ");
		species.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		species.setBounds(386, 29, 123, 16);
		frameGUI.getContentPane().add(species);
		
		JLabel 
		hab = new JLabel("Habitat :");
		hab.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		hab.setBounds(34, 300, 92, 16);
		frameGUI.getContentPane().add(hab);
		
		JLabel 
		sPop = new JLabel("Starting Population :");
		sPop.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		sPop.setBounds(257, 300, 177, 16);
		frameGUI.getContentPane().add(sPop);
		
		JLabel 
		iRate = new JLabel("Growth Rate :");
		iRate.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		iRate.setBounds(34, 325, 134, 16);
		frameGUI.getContentPane().add(iRate);
		
		JLabel 
		fPop = new JLabel("Final Population :");
		fPop.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		fPop.setBounds(34, 352, 148, 16);
		frameGUI.getContentPane().add(fPop);
		
		JLabel 
		died = new JLabel("Dead:");
		died.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		died.setBounds(34, 374, 112, 16);
		frameGUI.getContentPane().add(died);

		JLabel 
		hDis = new JLabel("");
		hDis.setForeground(Color.BLACK);
		hDis.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		hDis.setBounds(118, 300, 148, 16);
		frameGUI.getContentPane().add(hDis);

		JLabel 
		speciesDis = new JLabel("");
		speciesDis.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		speciesDis.setBounds(429, 300, 80, 16);
		frameGUI.getContentPane().add(speciesDis);

		JLabel 
		rateDis = new JLabel("");
		rateDis.setForeground(Color.BLACK);
		rateDis.setFont(new Font("Comic Sans MS", Font.ITALIC, 16));
		rateDis.setBounds(160, 327, 337, 16);
		frameGUI.getContentPane().add(rateDis);
		
		JLabel 
		finalpopDis = new JLabel("");
		finalpopDis.setForeground(Color.BLACK);
		finalpopDis.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		finalpopDis.setBounds(184, 352, 92, 16);
		frameGUI.getContentPane().add(finalpopDis);
		
		JLabel 
		deadDisplay = new JLabel("");
		deadDisplay.setForeground(Color.BLACK);
		deadDisplay.setFont(new Font("Comic Sans MS", Font.PLAIN, 16));
		deadDisplay.setBounds(95, 374, 92, 16);
		frameGUI.getContentPane().add(deadDisplay);
		
		JPanel 
		jpG = new graphJPanel();
		jpG.setBackground(Color.WHITE);
		jpG.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		jpG.setBounds(5, 35, 350, 250);
		frameGUI.getContentPane().add(jpG);

		JList 
		sDis = new JList();	
		sDis.setBackground(Color.PINK);
		sDis.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		
//	Setting the vector
		vecSpecies = new Vector<Species>();
		
        //Used to read text file
		BufferedReader in = new BufferedReader((new FileReader("growth.txt")));
			
			String sLine;
			while ((sLine = in.readLine()) != null)
				{
				 saLine = sLine.split(";");
				 vecSpecies.addElement(new Species(saLine[0],saLine[1], Integer.parseInt(saLine[2]), saLine[3]));
				}
			
			// Sorting names of species
			String[] saNames = new String[vecSpecies.size()];

			for (int i = 0; i < vecSpecies.size(); i++)
				{
				saNames[i] = vecSpecies.get(i).aName;
				sDis.setListData(saNames);
				sDis.setSelectedIndex(0);

				}
	
			

			
			in.close();
			
			// Code to display/set information
			sDis.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
			hDis.setText(vecSpecies.get(sDis.getSelectedIndex()).hab);
			speciesDis.setText(Integer.toString(vecSpecies.get(sDis.getSelectedIndex()).iPop));
			rateDis.setText(vecSpecies.get(sDis.getSelectedIndex()).sRate);
			
			//All storage code
			String sTemp = rateDis.getText();
			String[] saTempGrowthrate  = sTemp.split(",");
			
			for(int iI = 0; iI < saTempGrowthrate.length; iI++)
				{
			     aVar[iI] = Integer.parseInt(saTempGrowthrate[iI]);    
				}
			
			storedPop = Integer.parseInt(speciesDis.getText());
			finalPop = storedPop;
			
			//Calculations
			for (int iJ = 0; iJ < aVar.length; iJ++)
				{
				 finalPop = finalPop + (finalPop * aVar[iJ]/100);
				}
			
			finalPopInt = Integer.toString(finalPop);
			finalpopDis.setText(finalPopInt);
			
			if (finalPop > 5000)
				{
				 dead = finalPop - 5000;
				 deadDisplay.setText(dead + " ");
				}
			
			else
				{
				 deadDisplay.setText("0");
				}
			
			 	jpG.repaint(); 
			 	((graphJPanel) jpG).clear(jpG.getGraphics());
			 	
			}

		});
			
		sDis.setBounds(386, 46, 143, 243);
		frameGUI.getContentPane().add(sDis);
		
		JButton exit = new JButton("FINE, LEAVE");
		exit.setForeground(Color.BLACK);
		exit.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		exit.setBounds(460, 405, 134, 49);
		frameGUI.getContentPane().add(exit);
		
		JLabel lblPopulationCalcultor = new JLabel("Population Calculator!");
		lblPopulationCalcultor.setForeground(Color.RED);
		lblPopulationCalcultor.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblPopulationCalcultor.setBounds(34, 0, 325, 34);
		frameGUI.getContentPane().add(lblPopulationCalcultor);
		

		image = new BufferedImage(jpG.getWidth(), jpG.getHeight(), BufferedImage.TYPE_INT_RGB);
		
		gIM = (Graphics2D)image.getGraphics();
		 	
		gIM.setPaint(Color.BLACK);
		gIM.fill(new Rectangle2D.Double(0, 0, image.getWidth(), image.getHeight()));
		
	}
	

	//class to draw graph
	class graphJPanel extends JPanel 
	{
		private Rectangle2D.Double rectangle;
		private Line2D.Double line;
		
		public void paintComponent(Graphics g) 
		 {
			((Graphics2D) g).translate(0, 250);  
			((Graphics2D) g).scale(1, -1);
			
			super.paintComponent(g);
		
			for(int iI = 0; iI < xA.length; iI++)
			{
			 rectangle = new Rectangle2D.Double(xA[iI], 10, gWidth, aVar[iI]);
			 gIM.setPaint(Color.ORANGE);
			 gIM.fill(rectangle);
			}
			
//Calculate the Average of Growth rate
			il = (aVar[0] + aVar[1] + aVar[2] + aVar[3] + aVar[4] + aVar[5] + aVar[6] + aVar[7] + aVar[8] + aVar[9]) / 10; 
			
			line = new Line2D.Double(0,il,350,il);
			gIM.setPaint(Color.pink);
			gIM.draw(line);
			
			g.drawImage(image, 0, 0, null);
			
		 }
		protected void clear(Graphics g)
		 {
			super.paintComponent(g);
			
		  gIM.setPaint(Color.BLACK);
		  gIM.fill(new Rectangle2D.Double(0, 0, image.getWidth(), image.getHeight()));
		 }
		
	} 
} 
