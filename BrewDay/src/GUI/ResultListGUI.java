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
import javax.swing.JTextField;

import controller.BrewController;
import model.Brew;
import model.Recipe;

public class ResultListGUI extends JFrame{
	public ResultListGUI(Brew m, BrewController c) {
		this.setTitle("Result list page");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel p1 = new JPanel(); 
		JTextField title = new JTextField("Able to brew recipes",30);
		title.setEditable(false);
		p1.add(title);
		p.add(p1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(m.getRecommendedRecipeIndex().size(), 3, 20, 10)); 
		
		
		for(Recipe r:m.getRecommendedRecipeIndex())
		{
		JTextField ARecipe = new JTextField(r.getName(),30);
		ARecipe.setEditable(false);
		p2.add(ARecipe);
		JTextField ARecipeQ = new JTextField(String.valueOf(m.getBatchSize()),30);
		ARecipeQ.setEditable(false);
		p2.add(ARecipeQ);
		JButton AButton = new JButton("detail");
		AButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				m.setdetailindex(r.getRecipeIndex());
				
				m.getView().get(1).setvisible(0);
				
				m.getView().get(2).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ResultListGUI.this.dispose();
			}
		});
		p2.add(AButton);
		}

	

		p.add(p2); 
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(1,10,10));
		JButton b3 = new JButton("Non-executable recipes");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				m.getView().get(1).setvisible(0);
				
				m.getView().get(3).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ResultListGUI.this.dispose();
			}
		});
		p3.add(b3);
		p.add(p3);
		
		JPanel p4 = new JPanel();
		p4.setLayout(new FlowLayout(1,10,10));
		JButton b4 = new JButton("back to previous");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				m.getView().get(1).setvisible(0);
				
				m.getView().get(0).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				ResultListGUI.this.dispose();
			}
		});
		p4.add(b4);
		p.add(p4);
	
		
		
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
