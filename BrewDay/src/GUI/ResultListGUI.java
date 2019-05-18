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
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.BrewController;
import model.Brew;
import model.Recipe;

public class ResultListGUI extends JFrame{
	public ResultListGUI(Brew m, BrewController c) {
		this.setTitle("Result list page");
		this.setSize(600,500);
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
		emptyPanel.setPreferredSize(new Dimension(400, 70));
		///////////bg////////////

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		//p.setPreferredSize(new Dimension(350, 100));
		
		JPanel p1 = new JPanel(); 
		//p1.setLayout(new BoxLayout(p1, BoxLayout.PAGE_AXIS));
		p1.setLayout(new FlowLayout(1, 10, 10));
		JTextField title = new JTextField("Able to brew recipes",15);
		//title.setEditable(false);
		title.setFont(new Font("Verdana",Font.ITALIC,20));
		title.setBorder(BorderFactory.createEmptyBorder());
		title.setOpaque(false);
		title.setEditable(false);
		
		p1.add(title);
		p.add(p1);

		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(m.getRecommendedRecipeIndex().size(), 3, 50, 10)); 
		//p2.setLayout(new FlowLayout(1, 50, 20));

		for(Recipe r:m.getRecommendedRecipeIndex())
		{
			JTextField ARecipe = new JTextField(r.getName(),13);
			ARecipe.setEditable(false);
			p2.add(ARecipe);
			
			JTextField ARecipeQ = new JTextField(String.valueOf(m.getBatchSize()),1);
			ARecipeQ.setForeground(Color.RED);
			ARecipeQ.setFont(new Font("Verdana",Font.ITALIC,18));
			ARecipeQ.setBorder(BorderFactory.createEmptyBorder());
			ARecipeQ.setOpaque(false);
			ARecipeQ.setEditable(false);
			p2.add(ARecipeQ);
			
			
			JButton AButton = new JButton("Detail"); 
			AButton.setFont(new Font("Verdana",Font.ITALIC,14));
			AButton.setContentAreaFilled(false);
			AButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					m.setdetailindex(r.getRecipeIndex());

					m.getView().get(1).setvisible(0);

					m.getView().get(2).setvisible(1);
					try {
						m.notifyView();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					ResultListGUI.this.dispose();
				}
			});
			//AButton.setPreferredSize(new Dimension(50,15));
			p2.add(AButton);
		}



		p.add(p2); 

		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(1,10,10));
		JButton b3 = new JButton("Non-executable recipes");
		b3.setFont(new Font("Verdana",Font.ITALIC,14));
		b3.setContentAreaFilled(false);
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				m.getView().get(1).setvisible(0);

				m.getView().get(3).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				ResultListGUI.this.dispose();
			}
		});
		p3.add(b3);
		p.add(p3);
	
		JButton b4 = new JButton("Back to previous");
		b4.setFont(new Font("Verdana",Font.ITALIC,14));
		b4.setContentAreaFilled(false);
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				m.getView().get(1).setvisible(0);

				m.getView().get(0).setvisible(1);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				ResultListGUI.this.dispose();
			}
		});
		p3.add(b4);
		
		
		
		
		emptyPanel.setOpaque(false);
		p3.setOpaque(false);
		p2.setOpaque(false);
		p1.setOpaque(false);
		p.setOpaque(false);
		
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

}
