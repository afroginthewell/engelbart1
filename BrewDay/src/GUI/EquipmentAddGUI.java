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

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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
		
		JTextField name = new JTextField("Input equipment name");
		name.setEditable(false);
		name.setFont(new Font("Verdana",Font.ITALIC,13));
		name.setBorder(BorderFactory.createEmptyBorder());
		name.setOpaque(false);
		
		JTextArea nameText = new JTextArea("");
		
		
		p.add(name);
		p.add(nameText);
		
		JTextField amount = new JTextField("How much capacity you want to add?");
		amount.setEditable(false);
		amount.setFont(new Font("Verdana",Font.ITALIC,13));
		amount.setBorder(BorderFactory.createEmptyBorder());
		amount.setOpaque(false);
		
		JTextArea amountText = new JTextArea("");
		
		p.add(amount);
		p.add(amountText);
		
		JPanel p1 = new JPanel();
		
		p1.setLayout(new FlowLayout(1,10,10));
		
		JButton addButton = new JButton("Add");
		addButton.setContentAreaFilled(false);
		addButton.setFont(new Font("Verdana",Font.ITALIC,15));
		addButton.setOpaque(false);
		
		addButton.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent e) {
				
					String name = nameText.getText().toString();
					
					Double Index=-100.0;
					try {
					Index = Double.parseDouble(amountText.getText().toString());
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
					JOptionPane.showMessageDialog(null, "Input should be bigger than 0!!!");
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
		JButton Cancel = new JButton("Cancel");
		Cancel.setContentAreaFilled(false);
		Cancel.setFont(new Font("Verdana",Font.ITALIC,15));
		Cancel.setOpaque(false);
		
		Cancel.addActionListener(new ActionListener() {
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
		
		emptyPanel.setOpaque(false);
		p1.setOpaque(false);
		p.setOpaque(false);
		
		p1.add(Cancel);
		p.add(p1);
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
			this.setVisible(false);
		}
		
	}
}
