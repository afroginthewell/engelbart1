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
import view.EquipmentAddView;

public class EquipmentGUI extends JFrame{
	
	public EquipmentGUI(ArrayList<Equipment> equipList, EquipmentController c,Equipment m) throws SQLException {
	
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
		
//		ArrayList<Equipment> equipList = new ArrayList<Equipment>();
//		equipList = c.updateView();
		p2.setLayout(new GridLayout(equipList.size(), 3, 20, 10)); 
		for (Equipment i: equipList) {
			// Name
			JTextField equipmentName = new JTextField(i.getName());
			equipmentName.setEditable(false);
			p2.add(equipmentName);
			// Button
			JButton updateButton = new JButton("Update Equipment");
			updateButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					m.getView().get(0).setvisible(0);
					EquipmentGUI.this.dispose();
					m.getView().get(2).setvisible(1);
					m.setupdateindex(i.getEquipmentIndex());
					
					try {
						m.notifyView();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					EquipmentGUI.this.dispose();
				}
			});
			p2.add(updateButton);
			
		}
		

		p.add(p2); 
		
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

				m.getView().get(0).setvisible(0);
				EquipmentGUI.this.dispose();
				m.getView().get(1).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		p3.add(addButton);
		p.add(p3);
	
		
		
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
	
	public void update() {
		repaint();// repaint all the thing
	}
}
