package GUI;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;
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

import controller.RecipeController;
import controller.RecipeIngredientController;
import model.Recipe;
import model.RecipeIngredient;
import model.StorageIngredient;

public class RecipeAddPageGUI extends JFrame{
	public RecipeAddPageGUI(ArrayList<StorageIngredient> sIngredientList,Recipe m, RecipeController c,RecipeIngredient i,RecipeIngredientController ic) {
		this.setTitle("RecommendRecipePageGUI");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ArrayList<JTextArea> text=new ArrayList<JTextArea>();
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(1,0,0));
		
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
		

		
		p.add(name);

		
		JPanel input = new JPanel();
		input.setLayout(new BoxLayout(input, BoxLayout.PAGE_AXIS));
		JTextArea Iweight = new JTextArea("", 1,10);
		JTextArea Inote = new JTextArea("", 1,10);
		JTextArea Iunit = new JTextArea("", 1,10);
		input.add(Iweight);
		input.add(Inote);
		
		input.add(Iunit);
		
		
		for (StorageIngredient r: sIngredientList) {
			JTextArea iwater = new JTextArea("0", 1,10);			
			input.add(iwater);
			text.add(iwater);
			
		}			
		p.add(input);
		
		
		
		JPanel unit = new JPanel();
		unit.setLayout(new BoxLayout(unit, BoxLayout.PAGE_AXIS));
		JTextArea uweight = new JTextArea("", 1,5);
		uweight.setEditable(false);
		JTextArea uname = new JTextArea("", 1,5);
		uname.setEditable(false);
		JTextArea uunit = new JTextArea("g", 1,5);
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
		
		p.add(unit);	
		
		
		JPanel p2 = new JPanel(new FlowLayout(1,10,10));
		JButton add = new JButton("Add");
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
					
					int recipid=c.addRecipe(getInote, amount, getUnit);
					
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
		p.add(p2);
		this.add(p);
		
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
