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

public class DeleteRecipe extends JFrame{
	public DeleteRecipe() {
		this.setTitle("DeleteRecipe");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel p1 = new JPanel(); 
		p1.setLayout(new FlowLayout(1,10,10));
		JTextField title = new JTextField("Equipments recipes");
		title.setEditable(false);
		p1.add(title);
		p.add(p1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3, 3, 20, 10)); 
		JTextField equipment1 = new JTextField("Equipment 1");
		equipment1.setEditable(false);
		p2.add(equipment1);
		JButton deleteButton1 = new JButton("delete");
		p2.add(deleteButton1);
		deleteButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaintainRecipes().setVisible(true);
				DeleteRecipe.this.dispose();
			}
		});
		JTextField equipment2 = new JTextField("Equipment 1");
		equipment2.setEditable(false);
		p2.add(equipment2);
		JButton deleteButton2 = new JButton("delete");
		p2.add(deleteButton2);
		deleteButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaintainRecipes().setVisible(true);
				DeleteRecipe.this.dispose();
			}
		});
		JTextField equipment3 = new JTextField("Equipment 1");
		equipment3.setEditable(false);
		p2.add(equipment3);
		JButton deleteButton3 = new JButton("delete");
		p2.add(deleteButton3);
		
		deleteButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaintainRecipes().setVisible(true);
				DeleteRecipe.this.dispose();
			}
		});
		p.add(p2); 
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(1,10,10));
		JButton cancelButton = new JButton("Cancel"); 
		cancelButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaintainRecipes().setVisible(true);
				DeleteRecipe.this.dispose();
			}
		});
		p3.add(cancelButton);
		p.add(p3);
	
		this.setVisible(true);
		
	}
}
