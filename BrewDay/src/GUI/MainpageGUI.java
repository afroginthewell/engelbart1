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

import view.EquipmentView;

public class MainpageGUI extends JFrame{
	public MainpageGUI() {
		this.setTitle("Mainpage");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));

		JPanel p1 = new JPanel(); 

		
		p1.setLayout(new GridLayout(2, 2, 20, 10)); 
		JButton b1 = new JButton("Recommended a recipe");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RecommendRecipePageGUI().setVisible(true);
				MainpageGUI.this.dispose();
			}
		});
		p1.add(b1);
		//p1.add(new JTextField("Input Batach Size",30));
		JButton b2 = new JButton("Maintain recipe");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaintainRecipesGUI().setVisible(true);
				MainpageGUI.this.dispose();
			}
		});
		p1.add(b2);
		JButton b3 = new JButton("Maintain equipment");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EquipmentView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MainpageGUI.this.dispose();
			}
		});
		p1.add(b3);
		JButton b4 = new JButton("Maintain ingredient");
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new EquipmentView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MainpageGUI.this.dispose();
			}
		});
		p1.add(b4);
		p.add(p1); 
		
		JPanel p2 = new JPanel();
		p2.add(new JButton("Logout"));
		p.add(p2);
		
		
		
		this.setVisible(true);
		
	}
}
