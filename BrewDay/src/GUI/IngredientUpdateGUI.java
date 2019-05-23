package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Daoiml.storageingredientDaoiml;
import controller.StorageIngredientController;
import model.StorageIngredient;

public class IngredientUpdateGUI extends JFrame {
	public IngredientUpdateGUI(ArrayList<StorageIngredient> sIngredientList, StorageIngredient m,
			StorageIngredientController c) {
		this.setTitle("Ingredient Update GUI");
		this.setSize(600, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		///////////bg////////////
		JPanel bg = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon( "C:\\Users\\Jerry Zou\\Desktop\\JieLi\\Java workspace\\20190511\\brew.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};

		JPanel emptyPanel = new JPanel();
		emptyPanel.setLayout(new FlowLayout(1,10,10));
		emptyPanel.setPreferredSize(new Dimension(400, 80));
		///////////bg////////////

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		ArrayList<JTextArea> inputList = new ArrayList<JTextArea>();
		//list for all input text

		// Connected with Dao
		storageingredientDaoiml sidi = new storageingredientDaoiml();
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(sIngredientList.size(), 2, 20, 10)); 
		
		// Print the ingredients list fetched from database
		JPanel p3 = new JPanel();
		JTextField amount = new JTextField("Input how much you want add(+) or subtract(-)?");
		amount.setEditable(false);
		p3.add(amount);
		
		// dynamically to load the storage ingredient list
		
		for (StorageIngredient si : sIngredientList) {
			JPanel information = new JPanel();
			//information.setLayout(new BoxLayout(information, BoxLayout.X_AXIS));
			JTextArea ingredientType = new JTextArea(si.getName(), 1, 10);
			ingredientType.setEditable(false);
			ingredientType.setFont(new Font("Verdana",Font.ITALIC,15));

			// Identify the attribute of ingrdient want to update
			JTextArea input = new JTextArea("",1,10);
			input.setFont(new Font("Verdana",Font.ITALIC,15));

			
			inputList.add(input);
			
			JTextArea unit = new JTextArea("g", 1, 5);
			unit.setEditable(false);
			
			p1.add(ingredientType);
			p1.add(input);
			p1.add(unit);
		}
		
		// Set the panel 2 for update
		JPanel p2 = new JPanel(new FlowLayout(1, 10, 10));
		JButton Subtract = new JButton("Update");
		Subtract.setContentAreaFilled(false);
		Subtract.setFont(new Font("Verdana",Font.ITALIC,15));
		Subtract.setOpaque(false);
		
		// Set listenr
		Subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkLegal = true;
				
				try {
					c.updateAmount(inputList, sIngredientList);
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				
				// Jump back to IngredientMaintain page
				m.getView().get(1).setvisible(0);
				IngredientUpdateGUI.this.dispose();
				m.getView().get(0).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


			}
		});
		JButton Cancel = new JButton("Cancel");
		Cancel.setContentAreaFilled(false);
		Cancel.setFont(new Font("Verdana",Font.ITALIC,15));
		Cancel.setOpaque(false);
		
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Jump to IngredientMaintainGUI
				m.getView().get(1).setvisible(0);
				IngredientUpdateGUI.this.dispose();
				m.getView().get(0).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		p2.add(Subtract);
		p2.add(Cancel);
		p.add(p3);
		p.add(p1);
		p.add(p2);
		
		
		// Add component
		
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);
		this.setVisible(true);
		
		emptyPanel.setOpaque(false);
		p2.setOpaque(false);
		p.setOpaque(false);
	}
	
	// inverse the visibility
	public void controlVisible(int flag) {
		if (flag == 1) {
			this.setVisible(true);
		} else {
			System.out.print(this.getClass());
			this.setVisible(false);
		}

	}

}
