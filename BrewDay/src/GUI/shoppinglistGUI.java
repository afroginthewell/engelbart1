package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.BrewController;
import model.Brew;
import model.RecipeIngredient;

public class shoppinglistGUI extends JFrame{
	public shoppinglistGUI(Brew m, BrewController c) {
		this.setTitle("shopping list");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(m.getShopList().size(), 3, 20, 10)); 
		
		for (RecipeIngredient r: m.getShopList()) 
		{
			
			JTextField ingredient1 = new JTextField(r.getName());
			ingredient1.setEditable(false);
			p2.add(ingredient1);			
		
		}	
		for (double d: m.getShopingAmount()) 
		{
			if(d<0)
			{
				JTextArea ingredient1 = new JTextArea("enough", 2,10);	
				ingredient1.setEditable(false);
				p2.add(ingredient1);	
			}
			else {
				JTextArea ingredient1 = new JTextArea(String.valueOf(String.valueOf(d)), 2,10);	
				ingredient1.setEditable(false);
				p2.add(ingredient1);	
			}
					
			
		}	
		

		
		JButton backtopreviousButton = new JButton("Back to previous");
		p2.add(backtopreviousButton);
		backtopreviousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getView().get(3).setvisible(1);			
				m.getView().get(4).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				shoppinglistGUI.this.dispose();
			}
		});
		
		
		p.add(p2); 
		
		JPanel p3 = new JPanel();
		
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