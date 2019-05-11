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

import controller.EquipmentController;
import model.Equipment;
import view.EquipmentAddView;
import view.EquipmentView;

public class EquipmentAddGUI extends JFrame{
	
	public EquipmentAddGUI(Equipment m, EquipmentController c) {
		
		this.setTitle("EquipmentAdd page");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		
		this.add(p);
		
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JTextArea t1 = new JTextArea("Input equipment name(text box)");
		p.add(t1);
		
		JTextArea t2 = new JTextArea("how much you want to add?(text box)");
		p.add(t2);
		JPanel p1 = new JPanel();
		
		p1.setLayout(new FlowLayout(1,10,10));
		
		JButton addButton = new JButton("Add");
		addButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				boolean checkLegal = true;
				if(checkLegal == true) {
					String name = t1.getText().toString();
					String capacity = t2.getText().toString();
					try {
						c.addEquipment(name, Double.parseDouble(capacity));
					} catch (NumberFormatException | SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					m.getView().get(0).setvisible(1);
					EquipmentAddGUI.this.dispose();
					m.getView().get(1).setvisible(0);
					try {
						m.notifyView();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}}
					
			
		});
		
		p1.add(addButton);
		JButton b2 = new JButton("Cancel");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getView().get(0).setvisible(1);
				EquipmentAddGUI.this.dispose();
				m.getView().get(1).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		p1.add(b2);
		p.add(p1);
		
		
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
}
