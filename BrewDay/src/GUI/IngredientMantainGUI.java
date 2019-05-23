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
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.EquipmentController;
import controller.StorageIngredientController;
import model.Equipment;
import model.StorageIngredient;

public class IngredientMantainGUI extends JFrame{
	public IngredientMantainGUI(ArrayList<StorageIngredient> sIngredientList, StorageIngredientController c,StorageIngredient m) {
		this.setTitle("IngredientMantain page");
		this.setSize(500,800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		///////////UISetting////////////
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
		///////////UIsetting////////////

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel p1 = new JPanel(); 
		p1.setLayout(new FlowLayout(1,10,10));
		JTextField title = new JTextField("Ingredient list");
		title.setFont(new Font("Verdana",Font.ITALIC,20));
		title.setBorder(BorderFactory.createEmptyBorder());
		title.setOpaque(false);
		title.setEditable(false);
		
		p1.add(title);
		title.setEditable(false);
		p.add(p1);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(sIngredientList.size(), 1, 20, 10)); 
		//p2.setLayout(new FlowLayout(1,0,0));
		
		// Dynamically load the list into the GUI
		for (StorageIngredient si : sIngredientList) {
			JTextField listName = new JTextField(si.getName(),1);
			JTextField listAmount = new JTextField(""+si.getAmount(),1);
			p2.add(listName);
			
			// Set the component parameter
			listName.setForeground(Color.RED);
			listName.setFont(new Font("Verdana",Font.ITALIC,20));
			listName.setBorder(BorderFactory.createEmptyBorder());
			listName.setOpaque(false);
			listName.setEditable(false);
			
			p2.add(listAmount);
			listAmount.setForeground(Color.RED);
			listAmount.setFont(new Font("Verdana",Font.ITALIC,20));
			listAmount.setBorder(BorderFactory.createEmptyBorder());
			listAmount.setOpaque(false);
			listAmount.setEditable(false);
		}
		p.add(p2); 
		
		// Setting all the button inside
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(1,10,10));
		JButton Add = new JButton("Add"); 
		Add.setContentAreaFilled(false);
		Add.setFont(new Font("Verdana",Font.ITALIC,15));
		Add.setOpaque(false);
		
		JButton update = new JButton("update"); 
		update.setContentAreaFilled(false);
		update.setFont(new Font("Verdana",Font.ITALIC,15));
		update.setOpaque(false);
		
		JButton Mainpage = new JButton("Main page");
		Mainpage.setContentAreaFilled(false);
		Mainpage.setFont(new Font("Verdana",Font.ITALIC,15));
		Mainpage.setOpaque(false);
		
		// Control the jump between pages (Maintain TO Add)
		p3.add(Add);
		Add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Hidde the maintain Page
				m.getView().get(0).setvisible(0);
				IngredientMantainGUI.this.dispose();
				// Show the add page
				m.getView().get(2).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		// Control the jump between pages (Maintain TO update)
		////////////////  UPDATE
		p3.add(update);
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Hidde the maintain Page
				m.getView().get(0).setvisible(0);
				IngredientMantainGUI.this.dispose();
				// Show the update page
				m.getView().get(1).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});

		// Control the jump between pages (Maintain TO Main page)
		p3.add(Mainpage);
		Mainpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				IngredientMantainGUI.this.dispose();
			}
		});
		p.add(p3);
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);
		
		emptyPanel.setOpaque(false);
		p3.setOpaque(false);
		p2.setOpaque(false);
		p1.setOpaque(false);
		p.setOpaque(false);

	}

	public void controlVisible(int flag) {
		// INverse the visibility currently 
		if(flag==1)
		{
			this.setVisible(true);
		}
		else {
			this.setVisible(false);
		}

	}

	public void update() {
		System.out.println("Hello");
		repaint();// repaint all the thing
	}
}
