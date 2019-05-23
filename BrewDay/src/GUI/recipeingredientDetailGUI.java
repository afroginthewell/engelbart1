
package GUI;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.RecipeController;
import controller.RecipeIngredientController;
import model.Recipe;
import model.RecipeIngredient;
import model.StorageIngredient;
//the detail information of recipe
public class recipeingredientDetailGUI extends JFrame{
	public recipeingredientDetailGUI(ArrayList<RecipeIngredient> sIngredientList,Recipe m, RecipeController c,RecipeIngredient i,RecipeIngredientController ic) {
		this.setTitle("RecipeIngredientDetail");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ArrayList<JTextArea> text=new ArrayList<JTextArea>();

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
		emptyPanel.setPreferredSize(new Dimension(400, 60));
		///////////bg////////////
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));



		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(1, 3, 50, 40)); 
		
		JPanel name = new JPanel();
		name.setLayout(new BoxLayout(name, BoxLayout.PAGE_AXIS));
		
		for (RecipeIngredient r: sIngredientList) {
			JTextArea water = new JTextArea(r.getName(), 1,10);
			water.setEditable(false);
			name.add(water);
		}






		JPanel input = new JPanel(new FlowLayout(1,10,10));
		input.setLayout(new BoxLayout(input, BoxLayout.PAGE_AXIS));
		
		for (RecipeIngredient r: sIngredientList) {
			JTextArea iwater = new JTextArea(String.valueOf(r.getAmount()), 1,10);		
			iwater.setEditable(false);
			input.add(iwater);
			text.add(iwater);

		}			

		JPanel unit = new JPanel();
		unit.setLayout(new BoxLayout(unit, BoxLayout.PAGE_AXIS));
		
		JTextArea uwater;
		for (RecipeIngredient r: sIngredientList) {
			uwater = new JTextArea("g", 1,10);	
			uwater.setEditable(false);
			unit.add(uwater);		
		}			
		
		p1.add(name);
		p1.add(input);
		p1.add(unit);
		p.add(p1);	


		JPanel p2 = new JPanel(new FlowLayout(1,10,10));
		
		JButton cancel = new JButton("back to previous");	
		cancel.setContentAreaFilled(false);
		cancel.setOpaque(false);
		cancel.setFont(new Font("Verdana",Font.ITALIC,15));
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getView().get(3).setvisible(1);
				recipeingredientDetailGUI.this.dispose();
				m.getView().get(6).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		emptyPanel.setOpaque(false);
		p.setOpaque(false);
		p1.setOpaque(false);
		p2.setOpaque(false);
	
		cancel.setOpaque(false);
		
		
		
		p2.add(cancel);
		p.add(p2);
		
		
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

