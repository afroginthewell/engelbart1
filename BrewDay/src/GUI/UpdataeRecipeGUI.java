
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

public class UpdataeRecipeGUI extends JFrame{
	public UpdataeRecipeGUI(ArrayList<RecipeIngredient> sIngredientList,Recipe m, RecipeController c,RecipeIngredient i,RecipeIngredientController ic) {
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
		
		
		for (RecipeIngredient r: sIngredientList) {
			JTextArea water = new JTextArea(r.getName(), 1,10);
			water.setEditable(false);
			name.add(water);
		}
		


		
		p.add(name);

		
		JPanel input = new JPanel();
		input.setLayout(new BoxLayout(input, BoxLayout.PAGE_AXIS));
		JTextArea Iweight = new JTextArea(String.valueOf(m.getQuantity()), 1,10);
		JTextArea Inote = new JTextArea(m.getName(), 1,10);
		JTextArea Iunit = new JTextArea(m.getUnit(), 1,10);
		input.add(Iunit);
		input.add(Inote);
		input.add(Iweight);
		
		
		
		for (RecipeIngredient r: sIngredientList) {
			JTextArea iwater = new JTextArea(String.valueOf(r.getAmount()), 1,10);			
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
		for (RecipeIngredient r: sIngredientList) {
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
				UpdataeRecipeGUI.this.dispose();
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
				System.out.println(text.get(0).getText().toString());
				
				try {
					
					//c.addRecipe(getInote, amount, getUnit);
					c.updateRecipes(getInote, amount, m.getRecipeIndex());
					

					int i=0;
					for (RecipeIngredient r: sIngredientList) {
						ic.updateAmount(Double.parseDouble(text.get(i).getText().toString()), r.getindex());
						i++;
						
					}		
				
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
				UpdataeRecipeGUI.this.dispose();
				m.getView().get(5).setvisible(0);
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

