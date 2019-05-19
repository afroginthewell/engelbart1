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
import view.EquipmentView;

public class EquipmentUpdateGUI extends JFrame {
	public EquipmentUpdateGUI(Equipment m,EquipmentController c) {
		this.setTitle("Equipment update page");
		this.setSize(500, 500);
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
		JTextField amount = new JTextField("Input how much you want add(+) or subtract(-)?");
		amount.setEditable(false);
		amount.setFont(new Font("Verdana",Font.ITALIC,13));
		amount.setBorder(BorderFactory.createEmptyBorder());
		amount.setOpaque(false);
		
		JTextArea amountText = new JTextArea("");
		
		p.add(amount);
		p.add(amountText);

		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(1, 10, 10));
		JButton cancel = new JButton("Cancel");
		cancel.setContentAreaFilled(false);
		cancel.setFont(new Font("Verdana",Font.ITALIC,15));
		cancel.setOpaque(false);
		
		cancel.addActionListener(new ActionListener() {
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
		p1.add(cancel);


		JButton update = new JButton("Update");
		update.setContentAreaFilled(false);
		update.setFont(new Font("Verdana",Font.ITALIC,15));
		update.setOpaque(false);
		
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getamountText = amountText.getText().toString();
				double batchSize=0;

				try {
					batchSize=Double.parseDouble(getamountText);
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
		
		p1.setOpaque(false);
		p.setOpaque(false);
		emptyPanel.setOpaque(false);
		
		p1.add(update);
		p.add(p1);
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);
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

