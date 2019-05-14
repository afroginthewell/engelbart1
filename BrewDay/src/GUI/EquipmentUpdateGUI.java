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
import view.EquipmentView;

public class EquipmentUpdateGUI extends JFrame {
	public EquipmentUpdateGUI(Equipment m,EquipmentController c) {
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
				m.getView().get(0).setvisible(1);
				
				m.getView().get(2).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				EquipmentUpdateGUI.this.dispose();
			}
		});
		p1.add(b1);
		
		
		JButton b2 = new JButton("Update");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String gett1 = t1.getText().toString();
				double batchSize=0;
				
				try {
					batchSize=Double.parseDouble(gett1);
				} catch (Exception exception) {			
					JOptionPane.showMessageDialog(null, "Invaild input!!!");
					EquipmentUpdateGUI.this.dispose();
					m.getView().get(0).setvisible(1);
					EquipmentUpdateGUI.this.dispose();
					m.getView().get(2).setvisible(0);
				
				}
				
				try {
							c.updateCapacity(batchSize);
							
						} catch (SQLException e2) {
							e2.printStackTrace();
							
							
						}
					
					m.getView().get(0).setvisible(1);
					EquipmentUpdateGUI.this.dispose();
					m.getView().get(2).setvisible(0);
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
// visible question canno solve
	}
	public void controlVisible(int flag) {
		if (flag == 1) {
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}

	}
}



//try {
//	Index = Double.parseDouble(BatchSizeText.getText().toString());
//} catch (Exception exception) {
//
//	JOptionPane.showMessageDialog(null, "Invaild input!!!");
//	RecommendRecipePageGUI.this.dispose();
//
//}
//
//
//if (Index < 0) {
//	JOptionPane.showMessageDialog(null, "Invaild input!!!");
//	RecommendRecipePageGUI.this.dispose();
//
//} else {
//	m.setBatchSize(Index);
//
//	m.getView().get(0).setvisible(0);
//	RecommendRecipePageGUI.this.dispose();
//	m.getView().get(1).setvisible(1);
//}
//

