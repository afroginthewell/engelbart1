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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class EquipmentAdd extends JFrame{
	public EquipmentAdd() {
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
					String gett1 = t1.getText().toString();
					String gett2 = t2.getText().toString();
					//System.out.println(gett1);
					//System.out.println(gett2);
					new Equipment().setVisible(true);
					EquipmentAdd.this.dispose();
				}else {
					new EquipmentAdd().setVisible(true);
					EquipmentAdd.this.dispose();
				}
			}
		});
		
		p1.add(addButton);
		JButton b2 = new JButton("Cancel");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Equipment().setVisible(true);
				EquipmentAdd.this.dispose();
			}
		});
		p1.add(b2);
		p.add(p1);
		
		this.setVisible(true);
		
	}
}
