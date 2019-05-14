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
import javax.swing.JOptionPane;
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
				
					String name = t1.getText().toString();
					
					Double Index=-100.0;
					try {
					Index = Double.parseDouble(t2.getText().toString());
				} catch (Exception exception) {
				
					JOptionPane.showMessageDialog(null, "Invaild input!!!");
					EquipmentAddGUI.this.dispose();
					m.getView().get(0).setvisible(1);
					EquipmentAddGUI.this.dispose();
					m.getView().get(1).setvisible(0);
					
				
				}
				
				
				if (Index < 0) {
					if(Index!=-100.0)
					{
					JOptionPane.showMessageDialog(null, "input bigger then 0!!!");
					EquipmentAddGUI.this.dispose();
					m.getView().get(0).setvisible(1);
					EquipmentAddGUI.this.dispose();
					m.getView().get(1).setvisible(0);
					}
				
				} else {
					try {
						c.addEquipment(name, Index);
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
