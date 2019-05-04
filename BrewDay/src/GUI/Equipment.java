package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Equipment extends JFrame{
	public Equipment() {
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
		p2.setLayout(new GridLayout(3, 3, 20, 10)); 
		JTextField equipment1 = new JTextField("Equipment 1");
		equipment1.setEditable(false);
		p2.add(equipment1);
		
		JButton updatebutton1 = new JButton("update");
		p2.add(updatebutton1);
		JTextField equipment2 = new JTextField("Equipment 2");
		equipment2.setEditable(false);
		p2.add(equipment2);
		JButton updatebutton2 = new JButton("update");
		p2.add(updatebutton2);
		JTextField equipment3 = new JTextField("Equipment 3");
		equipment3.setEditable(false);
		p2.add(equipment3);
		JButton updatebutton3 = new JButton("update");
		p2.add(updatebutton3);
		p.add(p2); 
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(1,10,10));
		JButton mainpagebutton = new JButton("Main page"); 
		mainpagebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkLegal = true;
					new MainpageGUI().setVisible(true);
					Equipment.this.dispose();

			}
		});
		p3.add(mainpagebutton);
		JButton addButton = new JButton("Add"); 
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					new EquipmentAdd().setVisible(true);
					Equipment.this.dispose();
			}
		});
		p3.add(addButton);
		p.add(p3);
	
		this.setVisible(true);
		
	}
}
