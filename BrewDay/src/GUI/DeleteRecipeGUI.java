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
import javax.swing.JTextField;

import controller.RecipeController;
import controller.RecipeIngredientController;
import model.Equipment;
import model.Recipe;
import model.RecipeIngredient;

public class DeleteRecipeGUI extends JFrame{
	public DeleteRecipeGUI(ArrayList<Recipe> recipeList,Recipe m, RecipeController c,RecipeIngredient i,RecipeIngredientController ic) {
		//the basic setting for the whole panel
		this.setTitle("DeleteRecipe");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		///////////background////////////
		JPanel bg = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon( "C:\\Users\\Jerry Zou\\Desktop\\JieLi\\Java workspace\\20190511\\brew.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};

		JPanel emptyPanel = new JPanel();
		emptyPanel.setLayout(new FlowLayout(1,10,10));
		emptyPanel.setPreferredSize(new Dimension(400, 20));
		///////////bg////////////
		
		//for the first panel which is to palce the title
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));

		JPanel p1 = new JPanel(); 
		p1.setLayout(new FlowLayout(1,10,10));

		JTextField title = new JTextField("Recipes");
		title.setFont(new Font("Verdana",Font.ITALIC,20));
		title.setBorder(BorderFactory.createEmptyBorder());
		title.setOpaque(false);
		title.setEditable(false);
		p1.add(title);
		
		p.add(p1);

		//for each recipe, we will add the delete buttons
		JPanel p2 = new JPanel(); 	
		p2.setLayout(new GridLayout(recipeList.size(), 3, 20, 10)); 
		for (Recipe r: recipeList) {
			// Name
			JTextField equipmentName = new JTextField(r.getName());
			equipmentName.setForeground(Color.RED);
			equipmentName.setFont(new Font("Verdana",Font.ITALIC,20));
			equipmentName.setBorder(BorderFactory.createEmptyBorder());
			equipmentName.setOpaque(false);
			equipmentName.setEditable(false);
			p2.add(equipmentName);
			
			JButton deleteButton1 = new JButton("delete");
			deleteButton1.setContentAreaFilled(false);
			deleteButton1.setFont(new Font("Verdana",Font.ITALIC,15));
			p2.add(deleteButton1);
			deleteButton1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int targetIndex=r.getRecipeIndex();

					try {
						c.deleteRecipe(targetIndex);
						ic.deleteRecipeIngredient(targetIndex);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					m.getView().get(0).setvisible(1);
					DeleteRecipeGUI.this.dispose();
					m.getView().get(2).setvisible(0);
					try {
						m.notifyView();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
		}

		p.add(p2); 

		// for the panel 3
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(1,10,10));
		JButton cancelButton = new JButton("Cancel"); 
		cancelButton.setFont(new Font("Verdana",Font.ITALIC,15));
		cancelButton.setContentAreaFilled(false);
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getView().get(0).setvisible(1);
				DeleteRecipeGUI.this.dispose();
				m.getView().get(2).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		
		p3.add(cancelButton);
		p.add(p3);
		
		emptyPanel.setOpaque(false);
		p1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);
		p.setOpaque(false);
		
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);

	}
	
	//this is set the visible
	public void controlVisible(int flag) {
		if(flag==1)
		{
			this.setVisible(true);
		}
		else {
			System.out.print(this.getClass());
			this.setVisible(false);
		}

	}
}
