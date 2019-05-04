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

public class IngredientMantainGUI extends JFrame{
	public IngredientMantainGUI() {
		this.setTitle("IngredientMantain page");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel p1 = new JPanel(); 
		p1.setLayout(new FlowLayout(1,10,10));
		JTextField title = new JTextField("Ingredient list");
		p1.add(title);
		title.setEditable(false);
		p.add(p1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3, 1, 20, 10)); 
		p2.add(new JTextField("Ingredient 1",30));
		p2.add(new JTextField("Ingredient 2",30));
		p2.add(new JTextField("Ingredient 3",30));
		p.add(p2); 
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(1,10,10));
		JButton Add = new JButton("Add"); 
		JButton Subtract = new JButton("Subtract"); 
		JButton Mainpage = new JButton("Main page"); 
		p3.add(Add);
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IngredientAddGUI().setVisible(true);
				IngredientMantainGUI.this.dispose();
			}
		});
		p3.add(Subtract);
		Subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IngredientSubtractGUI().setVisible(true);
				IngredientMantainGUI.this.dispose();
			}
		});
		p3.add(Mainpage);
		Mainpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainpageGUI().setVisible(true);
				IngredientMantainGUI.this.dispose();
			}
		});
;		p.add(p3);
	
		this.setVisible(true);
		
	}
}
