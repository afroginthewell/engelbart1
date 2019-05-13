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
		this.setSize(500, 500);
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
		p.setLayout(new FlowLayout(1, 0, 0));
		ArrayList<JTextArea> inputList = new ArrayList<JTextArea>();

		// Connected with Dao
		storageingredientDaoiml sidi = new storageingredientDaoiml();

		// Print the ingredients list fetched from database
		for (StorageIngredient si : sIngredientList) {
			JPanel information = new JPanel();
			information.setLayout(new BoxLayout(information, BoxLayout.X_AXIS));
			JTextArea ingredientType = new JTextArea(si.getName(), 1, 10);
			ingredientType.setEditable(false);
			ingredientType.setFont(new Font("Verdana",Font.ITALIC,15));
			ingredientType.setBorder(BorderFactory.createEmptyBorder());
			ingredientType.setOpaque(false);
			
			JTextArea input = new JTextArea("",1,10);
			input.setFont(new Font("Verdana",Font.ITALIC,15));
			input.setBorder(BorderFactory.createEmptyBorder());
			input.setOpaque(false);
			
			inputList.add(input);
			JTextArea unit = new JTextArea("g", 1, 5);
			information.add(ingredientType);
			information.add(input);
			information.add(unit);
			p.add(information);
		}

		JPanel p2 = new JPanel(new FlowLayout(1, 10, 10));
		JButton Subtract = new JButton("Update");
		Subtract.setContentAreaFilled(false);
		Subtract.setFont(new Font("Verdana",Font.ITALIC,15));
		Subtract.setOpaque(false);
		
		Subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkLegal = true;

				try {
					c.updateAmount(inputList, sIngredientList);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				// Alert successful information

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
		p.add(p2);
		
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);
		this.setVisible(true);
		
		emptyPanel.setOpaque(false);
		p2.setOpaque(false);
		p.setOpaque(false);
	}

	public void controlVisible(int flag) {
		if (flag == 1) {
			this.setVisible(true);
		} else {
			System.out.print(this.getClass());
			this.setVisible(false);
		}

	}

}
