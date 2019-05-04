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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class IngredientUpdateGUI extends JFrame{
	public IngredientUpdateGUI() {
		this.setTitle("Ingredient update page");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		JTextArea amountText = new JTextArea("Input you want to update to how much");
		p.add(amountText);
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(1,10,10));
		JButton cancalButton = new JButton("Cancel");
		cancalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainpageGUI().setVisible(true);
				IngredientUpdateGUI.this.dispose();
			}
		});
		p1.add(cancalButton);
		JButton updateButton = new JButton("Update");
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkLegal = true;
				if(checkLegal == true) {
					String gett1 = amountText.getText().toString();
					//System.out.println(gett1);
					new MainpageGUI().setVisible(true);
					IngredientUpdateGUI.this.dispose();
				}else {
					new IngredientUpdateGUI().setVisible(true);
					IngredientUpdateGUI.this.dispose();
				}
			}
		});
		p1.add(updateButton);
		p.add(p1);
		
		this.setVisible(true);
		
	}
}
