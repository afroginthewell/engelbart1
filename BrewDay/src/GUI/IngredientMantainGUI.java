package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
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
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel p1 = new JPanel(); 
		p1.setLayout(new FlowLayout(1,10,10));
		JTextField title = new JTextField("Ingredient list");
		p1.add(title);
		title.setEditable(false);
		p.add(p1);
		
		// 
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(sIngredientList.size(), 1, 20, 10)); 
		for (StorageIngredient si : sIngredientList) {
			p2.add(new JTextField(si.getName(),30));
		}
		p.add(p2); 
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(1,10,10));
		JButton Add = new JButton("Add"); 
		JButton update = new JButton("update"); 
		JButton Mainpage = new JButton("Main page");
		
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
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		// Control the jump between pages (Maintain TO Main page)
		p3.add(Mainpage);
		Mainpage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainpageGUI().setVisible(true);
				IngredientMantainGUI.this.dispose();
			}
		});
;		p.add(p3);
	
		this.setVisible(true);
		
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
