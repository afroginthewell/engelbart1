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

public class EquipmentUpdateGUI extends JFrame {
	public EquipmentUpdateGUI() {
		this.setTitle("Equipment update page");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		JTextArea t1 = new JTextArea("Input you want to update to how much?");
		p.add(t1);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(1, 10, 10));
		JButton b1 = new JButton("Cancel");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaintainRecipesGUI().setVisible(true);
				EquipmentUpdateGUI.this.dispose();
			}
		});
		p1.add(b1);
		JButton b2 = new JButton("Update");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkLegal = true;
				if (checkLegal == true) {
					String gett1 = t1.getText().toString();
					//System.out.println(gett1);
					new MaintainRecipesGUI().setVisible(true);  // if legal, move to Maintain page.
					EquipmentUpdateGUI.this.dispose();
				} else { // if illegal, return itself
					new EquipmentUpdateGUI();
					EquipmentUpdateGUI.this.dispose();
				}
			}
		});
		p1.add(b2);
		p.add(p1);

		this.setVisible(true);

	}
}
