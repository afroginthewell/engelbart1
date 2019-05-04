package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
public class MaintainRecipesGUI extends JFrame{
	public MaintainRecipesGUI() {
		this.setTitle("MaintainRecipes");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));

		JPanel p1 = new JPanel(); 

		
		p1.setLayout(new GridLayout(2, 2, 20, 10)); 
		JButton b1 = new JButton("Add");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RecipeAddPageGUI().setVisible(true);
				MaintainRecipesGUI.this.dispose();
			}
		});
		p1.add(b1);
		JButton b2 = new JButton("Delete");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DeleteRecipeGUI().setVisible(true);
				MaintainRecipesGUI.this.dispose();
			}
		});
		p1.add(b2);
		JButton b3 = new JButton("Update");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdataeRecipeGUI().setVisible(true);
				MaintainRecipesGUI.this.dispose();
			}
		});
		p1.add(b3);
		JButton b4 = new JButton("Recipes list");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RecipeListGUI().setVisible(true);
				MaintainRecipesGUI.this.dispose();
			}
		});
		p1.add(b4);
		p.add(p1); 
		
		JPanel p2 = new JPanel();
		JButton b5 = new JButton("Main page");
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainpageGUI().setVisible(true);
				MaintainRecipesGUI.this.dispose();
			}
		});
		p2.add(b5);
	
		p.add(p2);
		
		
		
		this.setVisible(true);
		
	}
}
