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
import model.Equipment;

public class EquipmentGUI extends JFrame{
	public EquipmentGUI(Equipment m, EquipmentController c) throws SQLException {
		this.setTitle("Equipment");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel p1 = new JPanel(); 
		p1.setLayout(new FlowLayout(1,10,10));
		JTextField title = new JTextField("Equipments recipes");
		p1.add(title);
		title.setEditable(false);
		p.add(p1);
		
		JPanel p2 = new JPanel();
		
		ArrayList<Equipment> equipList = new ArrayList<Equipment>();
		equipList = c.updateView();
		p2.setLayout(new GridLayout(3, 3, 20, 10)); 
		for (Equipment i: equipList) {
			// Name
			JTextField equipmentName = new JTextField(i.getName());
			equipmentName.setEditable(false);
			p2.add(equipmentName);
			// Button
			JButton updateButton = new JButton("Update Equipment");
			updateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					boolean checkLegal = true;
						new EquipmentUpdateGUI().setVisible(true);
						EquipmentGUI.this.dispose();
				}
			});
			p2.add(updateButton);
			
		}
		
//		p2.setLayout(new GridLayout(3, 3, 20, 10)); 
//		JTextField equipment1 = new JTextField("Equipment 1");
//		equipment1.setEditable(false);
//		p2.add(equipment1);
//		// b1
//		JButton updatebutton1 = new JButton("update");
//		updatebutton1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				boolean checkLegal = true;
//					new EquipmentUpdateGUI().setVisible(true);
//					EquipmentGUI.this.dispose();
//
//			}
//		});
//		
//		p2.add(updatebutton1);
		// b2
//		JTextField equipment2 = new JTextField("Equipment 2");
//		equipment2.setEditable(false);
//		p2.add(equipment2);
//		
//		JButton updatebutton2 = new JButton("update");
//		
//		updatebutton1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				boolean checkLegal = true;
//					new EquipmentUpdateGUI().setVisible(true);
//					EquipmentGUI.this.dispose();
//
//			}
//		});
//		p2.add(updatebutton2);
//		JTextField equipment3 = new JTextField("Equipment 3");
//		equipment3.setEditable(false);
//		p2.add(equipment3);
//		// b3
//		JButton updatebutton3 = new JButton("update");
//		updatebutton1.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				boolean checkLegal = true;
//					new EquipmentUpdateGUI().setVisible(true);
//					EquipmentGUI.this.dispose();
//
//			}
//		});
//		p2.add(updatebutton3);
//		p.add(p2); 
		
		// Add list of equipments to p2, fetch data from controller
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(1,10,10));
		JButton mainpagebutton = new JButton("Main page"); 
		mainpagebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkLegal = true;
					new MainpageGUI().setVisible(true);
					EquipmentGUI.this.dispose();

			}
		});
		p3.add(mainpagebutton);
		JButton addButton = new JButton("Add"); 
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					new EquipmentAddGUI().setVisible(true);
					EquipmentGUI.this.dispose();
			}
		});
		p3.add(addButton);
		p.add(p3);
	
		this.setVisible(true);
		
	}
	
	public void update() {
		repaint();// repaint all the thing
	}
}
