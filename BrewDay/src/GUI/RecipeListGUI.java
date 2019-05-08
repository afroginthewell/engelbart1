package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.RecipeController;
import model.Recipe;

public class RecipeListGUI extends JFrame{
	public RecipeListGUI(ArrayList<Recipe> recipeList,Recipe m, RecipeController c) {
		this.setTitle("Recipes list page");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JTextField RecipeList = new JTextField("Recipe list",30);
		RecipeList.setEditable(false);
		p.add(RecipeList);
		for (Recipe r: recipeList) {
		p.add(new JTextField(r.getName(),30));
		}
		//p.add(new JButton("Main page"));
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(1,10,10));
		JButton b1 = new JButton("Maintain page");
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
		p1.add(b1);
		p.add(p1);
		
		
		
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
