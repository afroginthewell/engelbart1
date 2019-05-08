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
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Daoiml.storageingredientDaoiml;
import controller.StorageIngredientController;
import model.StorageIngredient;

public class IngredientAddGUI extends JFrame {

	public IngredientAddGUI(ArrayList<StorageIngredient> sIngredientList, StorageIngredientController c,
			StorageIngredient m) {

		this.setTitle("Ingredient add page");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		JTextArea t1 = new JTextArea("Which ingredient you want to add?");
		p.add(t1);
		JTextArea t2 = new JTextArea("Input how much you want to add?");
		p.add(t2);
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(1, 10, 10));
		JButton b1 = new JButton("Add");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
				boolean checkLegal = true;
				if (checkLegal == true) {
					String name = t1.getText().toString();
					String amount = t2.getText().toString();
					
					try {
						c.addNewIngredient(name, amount);
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
					// Alert successful information

					// Jump back to IngredientMaintain page
					m.getView().get(1).setvisible(0);
					IngredientAddGUI.this.dispose();
					m.getView().get(0).setvisible(1);
					try {
						m.notifyView();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					IngredientAddGUI.this.dispose();
				} else { // if illegal, return itself
					new EquipmentUpdateGUI().setVisible(true);
					IngredientAddGUI.this.dispose();
				}

			}
		});
		p1.add(b1);
		JButton b2 = new JButton("Cancel");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// new IngredientMantainGUI().setVisible(true);
				IngredientAddGUI.this.dispose();
			}
		});
		p1.add(b2);
		p.add(p1);

	}

	public void controlVisible(int flag) {
		if (flag == 1) {
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}

	}
}
