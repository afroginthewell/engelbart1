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

public class DetailRecipeInformation extends JFrame{
	public DetailRecipeInformation() {
		this.setTitle("Detail Recipe Information page");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel p1 = new JPanel(); 
		p1.setLayout(new FlowLayout(1,10,10));
		JTextField title = new JTextField("Recipes A");
		title.setEditable(false);
		p1.add(title);
		p.add(p1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3, 3, 20, 10)); 
		JTextField ingredient1 = new JTextField("Ingredient 1 400g");
		ingredient1.setEditable(false);
		p2.add(ingredient1);
		JButton chooseButton1 = new JButton("Choose");
		p2.add(chooseButton1);
		chooseButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new  ConfirmWindowAddRecipeGUI().setVisible(true);
				DetailRecipeInformation.this.dispose();
			}
		});
		JTextField ingredient2 = new JTextField("Ingredient 2 300g");
		ingredient2.setEditable(false);
		p2.add(ingredient2);
		JButton backtopreviousButton = new JButton("Back to previous");
		p2.add(backtopreviousButton);
		backtopreviousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResultList().setVisible(true);
				DetailRecipeInformation.this.dispose();
			}
		});
		JTextField equipment3 = new JTextField("Ingredient 3 200g");
		equipment3.setEditable(false);
		p2.add(equipment3);
		
		p.add(p2); 
		
		JPanel p3 = new JPanel();

		this.setVisible(true);
		
	}
}
