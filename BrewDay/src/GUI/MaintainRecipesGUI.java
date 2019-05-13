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

import controller.RecipeController;
import model.Recipe;
public class MaintainRecipesGUI extends JFrame{
	public MaintainRecipesGUI(Recipe m, RecipeController c) {
		this.setTitle("MaintainRecipes");
		this.setSize(500,500);
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

		JPanel p1 = new JPanel(); 


		p1.setLayout(new GridLayout(2, 2, 20, 10)); 
		JButton b1 = new JButton("Add");
		b1.setFont(new Font("Verdana",Font.ITALIC,15));
		b1.setContentAreaFilled(false);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				m.getView().get(0).setvisible(0);
				MaintainRecipesGUI.this.dispose();
				m.getView().get(1).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		p1.add(b1);
		JButton b2 = new JButton("Delete");
		b2.setFont(new Font("Verdana",Font.ITALIC,15));
		b2.setContentAreaFilled(false);
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getView().get(0).setvisible(0);
				MaintainRecipesGUI.this.dispose();
				m.getView().get(2).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		p1.add(b2);
		JButton b3 = new JButton("Update");
		b3.setFont(new Font("Verdana",Font.ITALIC,15));
		b3.setContentAreaFilled(false);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getView().get(0).setvisible(0);
				MaintainRecipesGUI.this.dispose();
				m.getView().get(4).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		p1.add(b3);
		JButton b4 = new JButton("Recipes list");
		b4.setFont(new Font("Verdana",Font.ITALIC,15));
		b4.setContentAreaFilled(false);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getView().get(0).setvisible(0);
				MaintainRecipesGUI.this.dispose();
				m.getView().get(3).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		p1.add(b4);

		JPanel p2 = new JPanel();
		JButton b5 = new JButton("Main page");
		b5.setFont(new Font("Verdana",Font.ITALIC,15));
		b5.setContentAreaFilled(false);
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MaintainRecipesGUI.this.dispose();
			}
		});
		p2.add(b5);
		p.add(p1); 
		p.add(p2);
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);
		
		p1.setOpaque(false);
		p2.setOpaque(false);
		p.setOpaque(false);
		b5.setOpaque(false);
		b4.setOpaque(false);
		b3.setOpaque(false);
		b2.setOpaque(false);
		b1.setOpaque(false);
		emptyPanel.setOpaque(false);

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
