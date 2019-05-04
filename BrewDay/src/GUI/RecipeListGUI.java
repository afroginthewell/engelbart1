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

public class RecipeListGUI extends JFrame{
	public RecipeListGUI() {
		this.setTitle("Recipes list page");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JTextField RecipeList = new JTextField("Recipe list",30);
		RecipeList.setEditable(false);
		p.add(RecipeList);
		p.add(new JTextField("Recipe 1",30));
		p.add(new JTextField("Recipe 2",30));
		p.add(new JTextField("Recipe 3",30));
		//p.add(new JButton("Main page"));
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(1,10,10));
		JButton b1 = new JButton("Main page");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainpageGUI().setVisible(true);
				RecipeListGUI.this.dispose();
			}
		});
		p1.add(b1);
		p.add(p1);
		
		this.setVisible(true);
		
	}
}
