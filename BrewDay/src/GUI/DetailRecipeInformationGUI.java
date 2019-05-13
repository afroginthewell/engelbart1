package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
		this.setSize(600,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		///////////bg////////////
		JPanel bg = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon( "C:\\Users\\Jerry Zou\\Desktop\\JieLi\\Java workspace\\20190511\\brew.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};

		JPanel emptyPanel = new JPanel();
		emptyPanel.setLayout(new FlowLayout(1,10,10));
		emptyPanel.setPreferredSize(new Dimension(400, 80));
		///////////bg////////////

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		//p.setPreferredSize(new Dimension(400, 100));

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(m.getdetailRecipe().size(), 3, 20, 10)); 

		for (RecipeIngredient r: m.getdetailRecipe()) 
		{
			JTextArea iwater = new JTextArea(String.valueOf(r.getAmount()), 1,10);	
			JTextField ingredient1 = new JTextField(r.getName()+"/"+String.valueOf(r.getAmount()*m.getBatchSize()+"g"));
			ingredient1.setEditable(false);
			p2.add(ingredient1);

		}	





		JButton chooseButton1 = new JButton("Implement");
		chooseButton1.setFont(new Font("Verdana",Font.ITALIC,15));
		chooseButton1.setContentAreaFilled(false);
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
		backtopreviousButton.setFont(new Font("Verdana",Font.ITALIC,15));
		backtopreviousButton.setContentAreaFilled(false);
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
		
		emptyPanel.setOpaque(false);
		p3.setOpaque(false);
		p2.setOpaque(false);
		p.setOpaque(false);
		
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);
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
