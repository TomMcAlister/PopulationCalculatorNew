//Created by Tom McAlister - u3187811
//Date created - 8/4/18
//Date last modifed - 23/4/18
//Description - This is a GUI application that will calculate either decay or growth of a fixed or variable rate
package u3187811.tom.com;

import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class Stage2 {

	private JFrame frame;
	private JTextField species;
	private JTextField iPop;
	private JTextField iGen;
	private JTextField oRate;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField txtHab;
	float gRate[] = new float[10];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stage2 window = new Stage2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Stage2() {
		initialize();
	}

	/**
	 * Initialization of the contents of the frame.
	 */
	private void initialize() {
		
		int died = 0;
		frame = new JFrame();
		frame.setBounds(100, 100, 556, 402);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSpecies = new JLabel("Species:");
		lblSpecies.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblSpecies.setBounds(10, 84, 81, 14);
		frame.getContentPane().add(lblSpecies);
		
		JLabel lblStartingPopulation = new JLabel("Starting population:");
		lblStartingPopulation.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblStartingPopulation.setBounds(11, 109, 140, 17);
		frame.getContentPane().add(lblStartingPopulation);
		
		JLabel lblGenerations = new JLabel("Generations:");
		lblGenerations.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblGenerations.setBounds(11, 134, 102, 14);
		frame.getContentPane().add(lblGenerations);
		
		JLabel lblM = new JLabel("Growth Rate (%):");
		lblM.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblM.setBounds(11, 159, 140, 14);
		frame.getContentPane().add(lblM);
		
		//Code to enable/disable relevent or active components
		ButtonGroup group = new ButtonGroup();
		
		JRadioButton rdbtnFixed = new JRadioButton("Fixed:");
		rdbtnFixed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField_4.setEditable(false);
				textField_5.setEditable(false);
				textField_6.setEditable(false);
				textField_7.setEditable(false);
				textField_8.setEditable(false);
				textField_9.setEditable(false);
				textField_10.setEditable(false);
				textField_11.setEditable(false);
				textField_12.setEditable(false);
				textField_13.setEditable(false);		
				
				oRate.setEditable(true);
				iGen.setEditable(true);
				
			}
		});
		rdbtnFixed.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		rdbtnFixed.setBounds(21, 180, 109, 23);
		frame.getContentPane().add(rdbtnFixed);
		group.add(rdbtnFixed);
		JRadioButton rdbtnVariable = new JRadioButton("Variable:");
		rdbtnVariable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_4.setEditable(true);
				textField_5.setEditable(true);
				textField_6.setEditable(true);
				textField_7.setEditable(true);
				textField_8.setEditable(true);
				textField_9.setEditable(true);
				textField_10.setEditable(true);
				textField_11.setEditable(true);
				textField_12.setEditable(true);
				textField_13.setEditable(true);
				
				oRate.setEditable(false);
				iGen.setEditable(false);

			}
		});
		//Creating elements on GUI (JTextFields, radio buttons, etc)
		rdbtnVariable.setFont(new Font("Comic Sans MS", Font.BOLD, 12));
		rdbtnVariable.setBounds(21, 208, 109, 23);
		frame.getContentPane().add(rdbtnVariable);
		group.add(rdbtnVariable);
		species = new JTextField();
		species.setBounds(151, 81, 86, 20);
		frame.getContentPane().add(species);
		species.setColumns(10);
		
		iPop = new JTextField();
		iPop.setBounds(151, 106, 86, 20);
		frame.getContentPane().add(iPop);
		iPop.setColumns(10);
		
		iGen = new JTextField();
		iGen.setBounds(151, 131, 86, 20);
		frame.getContentPane().add(iGen);
		iGen.setColumns(10);
		
		oRate = new JTextField();
		oRate.setBounds(136, 181, 46, 20);
		frame.getContentPane().add(oRate);
		oRate.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setBounds(20, 242, 41, 20);
		frame.getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(71, 242, 41, 20);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(122, 242, 41, 20);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(173, 242, 41, 20);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(224, 242, 41, 20);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setColumns(10);
		textField_9.setBounds(275, 242, 41, 20);
		frame.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(326, 242, 41, 20);
		frame.getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(377, 242, 41, 20);
		frame.getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEditable(false);
		textField_12.setColumns(10);
		textField_12.setBounds(430, 242, 41, 20);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(481, 242, 41, 20);
		frame.getContentPane().add(textField_13);
		
		//Actual math algorithms
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//For the fixed algorithms
				if(rdbtnFixed.isSelected()) {
					String oRate1 = oRate.getText();	
					float aRate = Integer.parseInt(oRate1);
					aRate = aRate /100 + 1;
				    
					String iGen2 = iGen.getText();	
					int aGen = Integer.parseInt(iGen2);
					
					String iPop2 = iPop.getText();	
					int aPop = Integer.parseInt(iPop2);					
					
						for(int i = 0; i < aGen; i++) {
							aPop = (int)aPop;
							aPop *= aRate;
						}				
						String habitat = txtHab.getText();
						String Fspecies = species.getText();
						int died = 0;
						//Displaying answers
						if(aPop > 5000) {
							died = aPop - 5000;
							
							JOptionPane.showMessageDialog(null, "The total number of "+ Fspecies + " from " + habitat + " is " + aPop + " and " + died + " died due to overpopulation.");
						
						}
						else {
							JOptionPane.showMessageDialog(null, "The total number of "+ Fspecies + " from " + habitat + " is " + aPop + ".");

						}
						//for the variable algorithms
				} else if(rdbtnVariable.isSelected()) {
					String Svar1 = textField_4.getText();
					float var1 = Integer.parseInt(Svar1);
					gRate[0] = var1;
				
					String Svar2 = textField_5.getText();
					float var2 = Integer.parseInt(Svar2);
					gRate[1] = var2;
					
					String Svar3 = textField_6.getText();
					float var3 = Integer.parseInt(Svar3);
					gRate[2] = var3;
					
					String Svar4 = textField_7.getText();
					float var4 = Integer.parseInt(Svar4);
					gRate[3] = var4;
					
					String Svar5 = textField_8.getText();
					float var5 = Integer.parseInt(Svar5);
					gRate[4] = var5;
					
					String Svar6 = textField_9.getText();
					float var6 = Integer.parseInt(Svar6);
					gRate[5] = var6;
					
					String Svar7 = textField_10.getText();
					float var7 = Integer.parseInt(Svar7);
					gRate[6] = var7;
					
					String Svar8 = textField_11.getText();
					float var8 = Integer.parseInt(Svar8);
					gRate[7] = var8;
					
					String Svar9 = textField_12.getText();
					float var9= Integer.parseInt(Svar9);
					gRate[8] = var9;
					
					String Svar10 = textField_13.getText();
					float var10 = Integer.parseInt(Svar10);
					gRate[9] = var10;
									
					//Setting variables based on answers
					String iPop2 = iPop.getText();	
					int aPop = Integer.parseInt(iPop2);	
					int died = 0;
					for(int d = 0; d < 10; d++) {
						aPop = (int)aPop;
						gRate[d]=(gRate[d]/100) + 1;
						aPop *= gRate[d];
						System.out.println(aPop);
					}
					String habitat = txtHab.getText();
					String Fspecies = species.getText();
					//Displaying answer
				if(aPop > 5000) {
					died = aPop - 5000;
					
					JOptionPane.showMessageDialog(null, "The total number of "+ Fspecies + " from " + habitat + " is " + aPop + " and " + died + " died due to overpopulation.");
				}
			}
		}
		});
		btnCalculate.setBounds(80, 302, 157, 50);
		frame.getContentPane().add(btnCalculate);
		
		JButton btnExit = new JButton("Quit");
		btnExit.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnExit.setBounds(272, 302, 157, 50);
		frame.getContentPane().add(btnExit);
		
		JLabel lblHabbitat = new JLabel("Habitat:");
		lblHabbitat.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		lblHabbitat.setBounds(272, 84, 59, 14);
		frame.getContentPane().add(lblHabbitat);
		
		txtHab = new JTextField();
		txtHab.setBounds(341, 81, 86, 20);
		frame.getContentPane().add(txtHab);
		txtHab.setColumns(10);
		
		JLabel lblPopulationCalculator = new JLabel("Population Calculator");
		lblPopulationCalculator.setFont(new Font("Comic Sans MS", Font.BOLD, 39));
		lblPopulationCalculator.setForeground(Color.RED);
		lblPopulationCalculator.setBounds(67, 11, 473, 50);
		frame.getContentPane().add(lblPopulationCalculator);
					
		}
	}

