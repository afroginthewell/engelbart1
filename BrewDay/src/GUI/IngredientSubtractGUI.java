package GUI;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class IngredientSubtractGUI extends JFrame{
	public IngredientSubtractGUI() {
		this.setTitle("IngredientSubtractGUI");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(1,0,0));
		
		JPanel name = new JPanel();
		name.setLayout(new BoxLayout(name, BoxLayout.PAGE_AXIS));
		JTextArea water = new JTextArea("water", 1,10);
		water.setEditable(false);
		JTextArea malts = new JTextArea("malts", 1,10);
		malts.setEditable(false);
		JTextArea hops = new JTextArea("hops", 1,10);
		hops.setEditable(false);
		JTextArea yeasts = new JTextArea("yeasts", 1,10);
		yeasts.setEditable(false);
		JTextArea sugars = new JTextArea("sugars", 1,10);
		malts.setEditable(false);
		name.add(water);
		name.add(malts);
		name.add(hops);
		name.add(yeasts);
		name.add(sugars);
		p.add(name);
		
		JPanel input = new JPanel();
		input.setLayout(new BoxLayout(input, BoxLayout.PAGE_AXIS));
		JTextArea Iwater = new JTextArea("", 1,10);
		JTextArea Imalts = new JTextArea("", 1,10);
		JTextArea Ihops = new JTextArea("", 1,10);
		JTextArea Iyeasts = new JTextArea("", 1,10);
		JTextArea Isugars = new JTextArea("", 1,10);
		
		input.add(Iwater);
		input.add(Imalts);
		input.add(Ihops);
		input.add(Iyeasts);
		input.add(Isugars);
		p.add(input);
		
		JPanel unit = new JPanel();
		unit.setLayout(new BoxLayout(unit, BoxLayout.PAGE_AXIS));
		JTextArea uwater = new JTextArea("g", 1,5);
		uwater.setEditable(false);
		JTextArea umalts = new JTextArea("g", 1,5);
		umalts.setEditable(false);
		JTextArea uhops = new JTextArea("g", 1,5);
		uhops.setEditable(false);
		JTextArea uyeasts = new JTextArea("g", 1,5);
		uyeasts.setEditable(false);
		JTextArea usugars = new JTextArea("g", 1,5);
		usugars.setEditable(false);
		unit.add(uwater);
		unit.add(umalts);
		unit.add(uhops);           
		unit.add(uyeasts);   
		unit.add(usugars);
		p.add(unit);	
		
		
		JPanel p2 = new JPanel(new FlowLayout(1,10,10));
		JButton Subtract = new JButton("Subtract");
		Subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean checkLegal = true;
				String getIwater = Iwater.getText().toString();
				String getImalts = Imalts.getText().toString();
				String getIhops = Ihops.getText().toString();
				String getIyeasts = Iyeasts.getText().toString();
				String getIsugars = Iyeasts.getText().toString();
				System.out.println(getIwater);
				System.out.println(getImalts);
				System.out.println(getIhops);
				System.out.println(getIyeasts);
				System.out.println(getIsugars);
				if(checkLegal == true) {
					new IngredientMantainGUI().setVisible(true);
					IngredientSubtractGUI.this.dispose();	
				}else {
					new IngredientSubtractGUI().setVisible(true);
					IngredientSubtractGUI.this.dispose();
				}
			}
		});
		JButton Cancel = new JButton("Cancel");	
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new IngredientMantainGUI().setVisible(true);
				IngredientSubtractGUI.this.dispose();
			}
		});
		p2.add(Subtract);
		p2.add(Cancel);
		p.add(p2);
		this.add(p);
		this.setVisible(true);
	}
}
