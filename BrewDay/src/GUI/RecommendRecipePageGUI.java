package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Daoiml.equipDaoiml;
import controller.BrewController;
import model.Brew;

public class RecommendRecipePageGUI extends JFrame {
	public RecommendRecipePageGUI(Brew m, BrewController c) {
		this.setTitle("RecommendRecipePageGUI");
		this.setSize(550, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/////////// bg////////////
		JPanel bg = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon(
						"C:\\Users\\Jerry Zou\\Desktop\\JieLi\\Java workspace\\20190511\\brew.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};

		JPanel emptyPanel = new JPanel();
		emptyPanel.setLayout(new FlowLayout(1, 10, 10));
		emptyPanel.setPreferredSize(new Dimension(400, 80));
		/////////// bg////////////

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));

		JPanel p1 = new JPanel();
//		p1.setLayout(new FlowLayout(2, 10, 10));
		p1.setLayout(new GridLayout(2, 2, 20, 10)); 
		
		JTextField BatchSize = new JTextField("Input Batach Size: ");//this for input batch size
		BatchSize.setFont(new Font("Verdana", Font.ITALIC, 15));
		BatchSize.setBorder(BorderFactory.createEmptyBorder());
		BatchSize.setOpaque(false);
		BatchSize.setEditable(false);
		p1.add(BatchSize);
		JTextField BatchSizeText = new JTextField("", 18);
		p1.add(BatchSizeText);
		
		JTextField search = new JTextField("search by year-month-day: ");//this for input date to search
		search.setFont(new Font("Verdana", Font.ITALIC, 15));
		search.setBorder(BorderFactory.createEmptyBorder());
		search.setOpaque(false);
		search.setEditable(false);
		p1.add(search);
		JTextField searchtext = new JTextField("xxxx-xx-xx", 18);
		p1.add(searchtext);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(1, 10, 10));
		
		JButton GoToMain = new JButton("Go to main page");
		GoToMain.setFont(new Font("Verdana", Font.ITALIC, 15));
		GoToMain.setContentAreaFilled(false);
		GoToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				RecommendRecipePageGUI.this.dispose();
			}
		});
		
		JButton GoTosearch = new JButton("Go to search ");
		GoTosearch.setFont(new Font("Verdana", Font.ITALIC, 15));
		GoTosearch.setContentAreaFilled(false);
		GoTosearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String getDate = searchtext.getText().toString();
				try {
					c.SearchByDate(getDate);//search by date
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				m.getView().get(0).setvisible(0);
				RecommendRecipePageGUI.this.dispose();
				m.getView().get(6).setvisible(1);

				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}


				RecommendRecipePageGUI.this.dispose();
			}
		});

		JButton GetRecommend = new JButton("Get Recommend");
		GetRecommend.setFont(new Font("Verdana", Font.ITALIC, 15));
		GetRecommend.setContentAreaFilled(false);
		GetRecommend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String getBatchSizeText = BatchSizeText.getText().toString();
			
				double Index = -100.0;
				try {
					Index = Double.parseDouble(BatchSizeText.getText().toString());
				} catch (Exception exception) {

					JOptionPane.showMessageDialog(null, "Invaild input!!!");
					//alert when wrong input
					RecommendRecipePageGUI.this.dispose();
					

				}
				
				equipDaoiml edi = new equipDaoiml();
				try {
					if (Index < 0 || Index >edi.getTotalCapacity()) {
						if(Index!=-100.0)
						{
							if(Index >edi.getTotalCapacity())
							{
								JOptionPane.showMessageDialog(null, "lager than equipment capacity");
							}else {
								JOptionPane.showMessageDialog(null, "Invaild input!!!");
							}
						
						RecommendRecipePageGUI.this.dispose();
						
						}

					} else {
						m.setBatchSize(Index);
						//set the batch size for recoomend

						m.getView().get(0).setvisible(0);
						RecommendRecipePageGUI.this.dispose();
						m.getView().get(1).setvisible(1);
					}
				} catch (HeadlessException | SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		

		
		p2.add(GoToMain);
		p2.add(GoTosearch);
		p2.add(GetRecommend);
	//	p2.add(back);
		p.add(p1);
		p.add(p2);
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);

		p1.setOpaque(false);
		p2.setOpaque(false);
		p.setOpaque(false);
		GetRecommend.setOpaque(false);
		GoToMain.setOpaque(false);
		emptyPanel.setOpaque(false);

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
