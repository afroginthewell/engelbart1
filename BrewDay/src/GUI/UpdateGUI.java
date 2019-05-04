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
import javax.swing.JTextField;


public class UpdateGUI extends JFrame{
	public UpdateGUI() {
		this.setTitle("Update page");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		this.add(p);
		
		JPanel p3 = new JPanel();
		JTextField RecipeL = new JTextField("Recipes list");
		RecipeL.setEditable(false);
		p3.add(RecipeL);
		p.add(p3);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(3, 3, 20, 10)); 
		p1.add(new JTextField("Recipe 1",30));
		JButton b1 = new JButton("update");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdataeRecipeGUI().setVisible(true);
				UpdateGUI.this.dispose();
			}
		});
		p1.add(b1);
		p1.add(new JTextField("Recipe 2",30));
		JButton b2 = new JButton("update");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdataeRecipeGUI().setVisible(true);
				UpdateGUI.this.dispose();
			}
		});
		p1.add(b2);
		p1.add(new JTextField("Recipe 2",30));
		JButton b3 = new JButton("update");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UpdataeRecipeGUI().setVisible(true);
				UpdateGUI.this.dispose();
			}
		});
		p1.add(b3);
		p.add(p1); 
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(1,10,10));
		JButton b4 = new JButton("Cancel");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaintainRecipesGUI().setVisible(true);
				UpdateGUI.this.dispose();
			}
		});
		p2.add(b4);
		p.add(p2);
	
		this.setVisible(true);
		
	}
}
