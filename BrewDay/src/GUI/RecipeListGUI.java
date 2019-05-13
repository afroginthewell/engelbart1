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
import model.Recipe;

public class RecipeListGUI extends JFrame{
	public RecipeListGUI(ArrayList<Recipe> recipeList,Recipe m, RecipeController c) {
		this.setTitle("Recipes list page");
		this.setSize(500,500);
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
		p.setPreferredSize(new Dimension(400, 200));
		
		JPanel p1 = new JPanel(); 
		p1.setLayout(new FlowLayout(1,10,10));
		JTextField title = new JTextField("Recipe list",30);
		title.setFont(new Font("Verdana",Font.ITALIC,20));
		title.setBorder(BorderFactory.createEmptyBorder());
		title.setOpaque(false);
		title.setEditable(false);
		//p1.add(title);
		//p.add(p1);

		for (Recipe r: recipeList) {
			//p.add(new JTextField(r.getName(),30));
			JTextField equipmentName = new JTextField(r.getName(),30);
			equipmentName.setForeground(Color.RED);
			equipmentName.setFont(new Font("Verdana",Font.ITALIC,20));
			equipmentName.setBorder(BorderFactory.createEmptyBorder());
			equipmentName.setOpaque(false);
			equipmentName.setEditable(false);
			p.add(equipmentName);
		}
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(1,10,10));

		JButton b1 = new JButton("Maintain page");
		b1.setContentAreaFilled(false);
		b1.setFont(new Font("Verdana",Font.ITALIC,15));
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getView().get(0).setvisible(1);

				m.getView().get(3).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				RecipeListGUI.this.dispose();
			}
		});
		
		p1.add(title);
		p2.add(b1);
		p.add(p1);
		p.add(p2);

		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);

		emptyPanel.setOpaque(false);
		b1.setOpaque(false);
		p1.setOpaque(false);
		p2.setOpaque(false);
		p.setOpaque(false);


	}
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
