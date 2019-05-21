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

		///////////bg////////////
		JPanel bg = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon( "C:\\Users\\Jerry Zou\\Desktop\\JieLi\\Java workspace\\20190511\\brew.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};

		
		this.add(bg);
		

	}

	public void controlVisible(int flag) {
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
