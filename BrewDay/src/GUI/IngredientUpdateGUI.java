package GUI;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import Daoiml.storageingredientDaoiml;
import controller.StorageIngredientController;
import model.StorageIngredient;

public class IngredientUpdateGUI extends JFrame {
	public IngredientUpdateGUI(ArrayList<StorageIngredient> sIngredientList, StorageIngredient m,
			StorageIngredientController c) {
		this.setTitle("Ingredient Update GUI");
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(1, 0, 0));
		ArrayList<JTextArea> inputList = new ArrayList<JTextArea>();
		
		// Connected with Dao
		storageingredientDaoiml sidi = new storageingredientDaoiml();
		
		// Print the ingredients list fetched from database
		for (StorageIngredient si : sIngredientList) {
			JPanel information = new JPanel();
			information.setLayout(new BoxLayout(information, BoxLayout.X_AXIS));
			JTextArea ingredientType = new JTextArea(si.getName(), 1, 10);
			ingredientType.setEditable(false);
			JTextArea input = new JTextArea("",1,10);
			inputList.add(input);
			JTextArea unit = new JTextArea("g", 1, 5);
			information.add(ingredientType);
			information.add(input);
			information.add(unit);
			p.add(information);
		}

		JPanel p2 = new JPanel(new FlowLayout(1, 10, 10));
		JButton Subtract = new JButton("Update");
		Subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkLegal = true;
				
				try {
					c.updateAmount(inputList, sIngredientList);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				// Alert successful information
				
				// Jump back to IngredientMaintain page
				m.getView().get(1).setvisible(0);
				IngredientUpdateGUI.this.dispose();
				m.getView().get(0).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Jump to IngredientMaintainGUI
				m.getView().get(1).setvisible(0);
				IngredientUpdateGUI.this.dispose();
				m.getView().get(0).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		p2.add(Subtract);
		p2.add(Cancel);
		p.add(p2);
		this.add(p);
		this.setVisible(true);
	}

	public void controlVisible(int flag) {
		if (flag == 1) {
			this.setVisible(true);
		} else {
			System.out.print(this.getClass());
			this.setVisible(false);
		}

	}

}
