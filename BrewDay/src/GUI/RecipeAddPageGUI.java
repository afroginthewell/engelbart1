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

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.RecipeController;
import controller.RecipeIngredientController;
import model.Recipe;
import model.RecipeIngredient;
import model.StorageIngredient;

public class RecipeAddPageGUI extends JFrame{
	public RecipeAddPageGUI(ArrayList<StorageIngredient> sIngredientList,Recipe m, RecipeController c,RecipeIngredient i,RecipeIngredientController ic) {
		this.setTitle("RecommendRecipePageGUI");
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
		emptyPanel.setPreferredSize(new Dimension(400, 120));
		///////////bg////////////

		ArrayList<JTextArea> text=new ArrayList<JTextArea>();
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(1,0,0));
		
		JPanel name = new JPanel();
		name.setLayout(new BoxLayout(name, BoxLayout.PAGE_AXIS));
		JTextArea weight = new JTextArea("amount", 1,10);
		JTextArea recipename = new JTextArea("recipe name", 1,10);
		JTextArea unitt = new JTextArea("unit", 1,10);
		recipename.setEditable(false);
		weight.setEditable(false);
		name.add(weight);
		name.add(recipename);
		unitt.setEditable(false);
		name.add(unitt);


		for (StorageIngredient r: sIngredientList) {
			JTextArea water = new JTextArea(r.getName(), 1,10);
			water.setEditable(false);
			name.add(water);
		}

		//		JTextArea water = new JTextArea("water", 1,10);
		//		water.setEditable(false);
		//		JTextArea malts = new JTextArea("malts", 1,10);
		//		malts.setEditable(false);
		//		JTextArea hops = new JTextArea("hops", 1,10);
		//		hops.setEditable(false);
		//		JTextArea yeasts = new JTextArea("yeasts", 1,10);
		//		yeasts.setEditable(false);
		//		JTextArea sugars = new JTextArea("sugars", 1,10);
		//		sugars.setEditable(false);



		p1.add(name);


		JPanel input = new JPanel();
		input.setLayout(new BoxLayout(input, BoxLayout.PAGE_AXIS));
		JTextArea Iweight = new JTextArea("", 1,10);
		JTextArea Inote = new JTextArea("", 1,10);
		JTextArea Iunit = new JTextArea("L", 1,10);
		Iunit.setEditable(false);
		input.add(Iweight);
		input.add(Inote);

		input.add(Iunit);


		for (StorageIngredient r: sIngredientList) {
			JTextArea iwater = new JTextArea("0", 1,10);			
			input.add(iwater);
			text.add(iwater);

		}			
		p1.add(input);



		JPanel unit = new JPanel();
		unit.setLayout(new BoxLayout(unit, BoxLayout.PAGE_AXIS));
		JTextArea uweight = new JTextArea("", 1,5);
		uweight.setEditable(false);
		JTextArea uname = new JTextArea("", 1,5);
		uname.setEditable(false);
		JTextArea uunit = new JTextArea("", 1,5);
		uunit.setEditable(false);
		unit.add(uweight);
		unit.add(uname);
		unit.add(uunit);

		JTextArea uwater;
		for (StorageIngredient r: sIngredientList) {
			uwater = new JTextArea("g", 1,10);	
			uwater.setEditable(false);
			unit.add(uwater);		
		}			

		p1.add(unit);	


		JPanel p2 = new JPanel(new FlowLayout(1,10,10));
		
		JButton add = new JButton("Add");
		add.setContentAreaFilled(false);
		add.setFont(new Font("Verdana",Font.ITALIC,15));
		add.setOpaque(false);
		
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				m.getView().get(0).setvisible(1);
				RecipeAddPageGUI.this.dispose();
				m.getView().get(1).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String getUnit=Iunit.getText().toString();
				String getIweight = Iweight.getText().toString();
				String getInote = Inote.getText().toString();



				double amount=Double.parseDouble(getIweight);
				System.out.println(getIweight);

				try {

					int recipid=c.addRecipe(getInote, amount, "L");

					int i=0;

					for (StorageIngredient r: sIngredientList) {

						ic.addRecipeIngredient(r.getName(), Double.parseDouble(text.get(i).getText().toString()), "g", recipid);
						i++;
					}		
					//					ic.addRecipeIngredient("water", amount*Double.parseDouble(getIwater)/100, "L", recipid);
					//					ic.addRecipeIngredient("malts", amount*Double.parseDouble(getImalts), "g", recipid);
					//					ic.addRecipeIngredient("hops", amount*Double.parseDouble(getIhops), "g", recipid);
					//					ic.addRecipeIngredient("yeasts", amount*Double.parseDouble(getIyeasts), "g", recipid);
					//					ic.addRecipeIngredient("sugars", amount*Double.parseDouble(getIsugars), "g", recipid);
					//					
				} catch (NumberFormatException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}




			}
		});
		JButton cancel = new JButton("Cancel");	
		cancel.setContentAreaFilled(false);
		cancel.setFont(new Font("Verdana",Font.ITALIC,15));
		cancel.setOpaque(false);
		
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.getView().get(0).setvisible(1);
				RecipeAddPageGUI.this.dispose();
				m.getView().get(1).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		p2.add(add);
		p2.add(cancel);
		p.add(p1);
		p.add(p2);
		//p.add(p2);
		bg.add(emptyPanel);
		bg.add(p);
		//bg.add(p2);
		this.add(bg);
		
		emptyPanel.setOpaque(false);
		p2.setOpaque(false);
		p1.setOpaque(false);
		p.setOpaque(false);
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