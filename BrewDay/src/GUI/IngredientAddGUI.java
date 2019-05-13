package GUI;

import java.awt.Color;
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

public class IngredientAddGUI extends JFrame {

	public IngredientAddGUI(ArrayList<StorageIngredient> sIngredientList, StorageIngredientController c,
			StorageIngredient m) {

		this.setTitle("Ingredient add page");
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
		emptyPanel.setPreferredSize(new Dimension(400, 120));
		///////////bg////////////
		
	
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 2, 20, 10)); 
		p1.setPreferredSize(new Dimension(400, 80));
		JTextArea addIngredient = new JTextArea("Which ingredient you want to add?");
		addIngredient.setFont(new Font("Verdana",Font.ITALIC,15));
		addIngredient.setBorder(BorderFactory.createEmptyBorder());
		addIngredient.setOpaque(false);
		JTextArea inputAddIngredient = new JTextArea("");
		inputAddIngredient.setFont(new Font("Verdana",Font.ITALIC,15));
		inputAddIngredient.setBorder(BorderFactory.createEmptyBorder());
		//inputAddIngredient.setOpaque(false);
		p1.add(addIngredient);
		p1.add(inputAddIngredient);
		
		
		JTextArea addAmount = new JTextArea("Input how much you want to add?");
		addAmount.setFont(new Font("Verdana",Font.ITALIC,15));
		addAmount.setBorder(BorderFactory.createEmptyBorder());
		addAmount.setOpaque(false);
		JTextArea inputaddAmount = new JTextArea("");
		inputaddAmount .setFont(new Font("Verdana",Font.ITALIC,15));
		inputaddAmount .setBorder(BorderFactory.createEmptyBorder());
		//inputaddAmount .setOpaque(false);
		p1.add(addAmount);
		p1.add(inputaddAmount );
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(1, 10, 10));
		JButton b1 = new JButton("Add");
		b1.setContentAreaFilled(false);
		b1.setFont(new Font("Verdana",Font.ITALIC,15));
		b1.setOpaque(false);
		
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				boolean checkLegal = true;
				if (checkLegal == true) {
					String name = inputAddIngredient.getText().toString();
					String amount = inputaddAmount.getText().toString();
					
					try {
						c.addNewIngredient(name, amount);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					// Alert successful information

					// Jump back to IngredientMaintain page
					m.getView().get(1).setvisible(0);
					IngredientAddGUI.this.dispose();
					m.getView().get(0).setvisible(1);
					try {
						m.notifyView();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					IngredientAddGUI.this.dispose();
				} else { // if illegal, return itself
					m.getView().get(0).setvisible(1);
					
					m.getView().get(2).setvisible(0);
					try {
						m.notifyView();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					IngredientAddGUI.this.dispose();
				}

			}
		});
		
		JButton b2 = new JButton("Cancel");
		b2.setContentAreaFilled(false);
		b2.setFont(new Font("Verdana",Font.ITALIC,15));
		b2.setOpaque(false);
		
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getView().get(0).setvisible(1);
				
				m.getView().get(2).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				IngredientAddGUI.this.dispose();
			}
		});
		p2.add(b1);
		p2.add(b2);
		p.add(p1);
		p.add(p2);
		
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);
		
		emptyPanel.setOpaque(false);
		p1.setOpaque(false);
		p2.setOpaque(false);
		p.setOpaque(false);
		
		IngredientAddGUI.this.setAlwaysOnTop(true);
	}

	public void controlVisible(int flag) {
		if (flag == 1) {
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}

	}
}
