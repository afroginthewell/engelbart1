package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		///////////bg////////////
		JPanel bg = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon( "C:\\Users\\Jerry Zou\\Desktop\\JieLi\\Java workspace\\20190511\\brew.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};

		JPanel emptyPanel = new JPanel();
		emptyPanel.setLayout(new FlowLayout(1,10,10));
		emptyPanel.setPreferredSize(new Dimension(400, 80));
		///////////bg////////////

		JPanel p = new JPanel();

		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));

		JPanel p1 = new JPanel(); 
		p1.setLayout(new FlowLayout(1,10,10));
		JTextField title = new JTextField("Equipments");
		title.setFont(new Font("Verdana",Font.ITALIC,20));
		title.setBorder(BorderFactory.createEmptyBorder());
		title.setOpaque(false);
		title.setEditable(false);
		
		p1.add(title);
		p.add(p1);

		JPanel p2 = new JPanel();

		//		ArrayList<Equipment> equipList = new ArrayList<Equipment>();
		//		equipList = c.updateView();
		p2.setLayout(new GridLayout(equipList.size(), 3, 20, 10)); 
		for (Equipment i: equipList) {
			// Name
			JTextField equipmentName = new JTextField(i.getName()+i.getCapacity()+"L");
			equipmentName.setEditable(false);
			p2.add(equipmentName);
			// Button
			JButton updateButton = new JButton("Update Equipment");
			updateButton.setContentAreaFilled(false);
			updateButton.setFont(new Font("Verdana",Font.ITALIC,15));
			updateButton.setOpaque(false);
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
		mainpagebutton.setContentAreaFilled(false);
		mainpagebutton.setFont(new Font("Verdana",Font.ITALIC,15));
		mainpagebutton.setOpaque(false);
		mainpagebutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkLegal = true;

				EquipmentGUI.this.dispose();
			}
		});

		p3.add(mainpagebutton);
		JButton addButton = new JButton("Add"); 
		addButton.setContentAreaFilled(false);
		addButton.setFont(new Font("Verdana",Font.ITALIC,15));
		addButton.setOpaque(false);
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
		
		p1.setOpaque(false);
		p2.setOpaque(false);
		p3.setOpaque(false);
		p.setOpaque(false);
		emptyPanel.setOpaque(false);
		
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);


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
