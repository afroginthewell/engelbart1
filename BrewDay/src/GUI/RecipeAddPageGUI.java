package GUI;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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

public class RecipeAddPageGUI extends JFrame{
	public RecipeAddPageGUI(Recipe m, RecipeController c,RecipeIngredient i,RecipeIngredientController ic) {
		this.setTitle("RecommendRecipePageGUI");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(1,0,0));
		
		JPanel name = new JPanel();
		name.setLayout(new BoxLayout(name, BoxLayout.PAGE_AXIS));
		JTextArea weight = new JTextArea("amount", 1,10);
		weight.setEditable(false);
		JTextArea water = new JTextArea("water", 1,10);
		water.setEditable(false);
		JTextArea malts = new JTextArea("malts", 1,10);
		malts.setEditable(false);
		JTextArea hops = new JTextArea("hops", 1,10);
		hops.setEditable(false);
		JTextArea yeasts = new JTextArea("yeasts", 1,10);
		yeasts.setEditable(false);
		JTextArea sugars = new JTextArea("sugars", 1,10);
		sugars.setEditable(false);
		JTextArea recipename = new JTextArea("note", 1,10);
		recipename.setEditable(false);
		name.add(weight);
		name.add(water);
		name.add(malts);
		name.add(hops);
		name.add(yeasts);
		name.add(sugars);
		name.add(recipename);
		p.add(name);

		
		JPanel input = new JPanel();
		input.setLayout(new BoxLayout(input, BoxLayout.PAGE_AXIS));
		JTextArea Iweight = new JTextArea("", 1,10);
		JTextArea Iwater = new JTextArea("", 1,10);
		JTextArea Imalts = new JTextArea("", 1,10);
		JTextArea Ihops = new JTextArea("", 1,10);
		JTextArea Iyeasts = new JTextArea("", 1,10);
		JTextArea Isugars = new JTextArea("", 1,10);
		JTextArea Inote = new JTextArea("", 1,10);
		input.add(Iweight);
		input.add(Iwater);
		input.add(Imalts);
		input.add(Ihops);
		input.add(Iyeasts);
		input.add(Isugars);
		input.add(Inote);
		p.add(input);
		
		JPanel unit = new JPanel();
		unit.setLayout(new BoxLayout(unit, BoxLayout.PAGE_AXIS));
		JTextArea uweight = new JTextArea("L", 1,5);
		uweight.setEditable(false);
		JTextArea uwater = new JTextArea("%", 1,5);
		uwater.setEditable(false);
		JTextArea umalts = new JTextArea("%", 1,5);
		umalts.setEditable(false);
		JTextArea uhops = new JTextArea("%", 1,5);
		uhops.setEditable(false);
		JTextArea uyeasts = new JTextArea("%", 1,5);
		uyeasts.setEditable(false);
		JTextArea usugars = new JTextArea("%", 1,5);
		usugars.setEditable(false);
		JTextArea unote = new JTextArea("  ", 1,5);
		unote.setEditable(false);
		unit.add(uweight);
		unit.add(uwater);
		unit.add(umalts);
		unit.add(uhops);
		unit.add(uyeasts);
		unit.add(usugars);
		unit.add(unote);
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
				String getIweight = Iweight.getText().toString();
				String getIwater = Iwater.getText().toString();
				String getImalts = Imalts.getText().toString();
				String getIhops = Ihops.getText().toString();
				String getIyeasts = Iyeasts.getText().toString();
				String getIsugars = Isugars.getText().toString();
				String getInote = Inote.getText().toString();
				double amount=Double.parseDouble(getIweight);
				
				System.out.println(amount*Double.parseDouble(getImalts));
				
				try {
					
					int recipid=c.addRecipe(getInote, amount*Double.parseDouble(getIweight), "L");
					
					
					ic.addRecipeIngredient("water", amount*Double.parseDouble(getIwater)/100, "L", recipid);
					ic.addRecipeIngredient("malts", amount*Double.parseDouble(getImalts), "g", recipid);
					ic.addRecipeIngredient("hops", amount*Double.parseDouble(getIhops), "g", recipid);
					ic.addRecipeIngredient("yeasts", amount*Double.parseDouble(getIyeasts), "g", recipid);
					ic.addRecipeIngredient("sugars", amount*Double.parseDouble(getIsugars), "g", recipid);
					
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
