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

public class DetailRecipeInformationGUI extends JFrame{
	public DetailRecipeInformationGUI(Brew m, BrewController c) {
		this.setTitle("Detail Recipe Information page");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(m.getdetailRecipe().size(), 3, 20, 10)); 
		
		for (RecipeIngredient r: m.getdetailRecipe()) 
		{
			JTextArea iwater = new JTextArea(String.valueOf(r.getAmount()), 1,10);	
			JTextField ingredient1 = new JTextField(r.getName()+String.valueOf(r.getAmount()*m.getBatchSize()));
			ingredient1.setEditable(false);
			p2.add(ingredient1);
			
		}	
		
		
		
		
		
		JButton chooseButton1 = new JButton("Implement");
		p2.add(chooseButton1);
		chooseButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					c.implement(m.getdetailindex(), m.getBatchSize());
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				m.getView().get(1).setvisible(1);
				m.getView().get(2).setvisible(0);
				try {
					m.notifyView();
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DetailRecipeInformationGUI.this.dispose();
				new ConfirmChooseRecipeGUI();
			}
		});
		
		JButton backtopreviousButton = new JButton("Back to previous");
		p2.add(backtopreviousButton);
		backtopreviousButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getView().get(1).setvisible(1);			
				m.getView().get(2).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DetailRecipeInformationGUI.this.dispose();
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
