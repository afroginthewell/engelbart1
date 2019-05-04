package GUI;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class UpdataeRecipeGUI extends JFrame{
	public UpdataeRecipeGUI() {
		this.setTitle("UpdataeRecipeGUI");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(1,0,0));
		
		JPanel name = new JPanel();
		name.setLayout(new BoxLayout(name, BoxLayout.PAGE_AXIS));
		JTextArea weight = new JTextArea("Total Weight", 1,10);
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
		JTextArea additives= new JTextArea("additives", 1,10);
		additives.setEditable(false);
		name.add(weight);
		name.add(water);
		name.add(malts);
		name.add(hops);
		name.add(yeasts);
		name.add(sugars);
		name.add(additives);
		p.add(name);
		
		JPanel input = new JPanel();
		input.setLayout(new BoxLayout(input, BoxLayout.PAGE_AXIS));
		JTextArea Iweight = new JTextArea("", 1,10);
		JTextArea Iwater = new JTextArea("", 1,10);
		JTextArea Imalts = new JTextArea("", 1,10);
		JTextArea Ihops = new JTextArea("", 1,10);
		JTextArea Iyeasts = new JTextArea("", 1,10);
		JTextArea Isugars = new JTextArea("", 1,10);
		JTextArea Iadditives= new JTextArea("", 1,10);
		input.add(Iweight);
		input.add(Iwater);
		input.add(Imalts);
		input.add(Ihops);
		input.add(Iyeasts);
		input.add(Isugars);
		input.add(Iadditives);
		p.add(input);
		
		JPanel unit = new JPanel();
		unit.setLayout(new BoxLayout(unit, BoxLayout.PAGE_AXIS));
		JTextArea uweight = new JTextArea("kg", 1,5);
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
		JTextArea uadditives= new JTextArea("%", 1,5);
		uadditives.setEditable(false);
		unit.add(uweight);
		unit.add(uwater);
		unit.add(umalts);
		unit.add(uhops);
		unit.add(uyeasts);
		unit.add(usugars);
		unit.add(uadditives);
		p.add(unit);	
		
		JPanel checkbox = new JPanel();
		checkbox.setLayout(new BoxLayout(checkbox, BoxLayout.PAGE_AXIS));
		JCheckBox cwater = new JCheckBox();
		JCheckBox cmalts = new JCheckBox();
		JCheckBox chops = new JCheckBox();
		JCheckBox cyeasts = new JCheckBox();
		JCheckBox csugars = new JCheckBox();
		JCheckBox cadditives = new JCheckBox();
		checkbox.add(cwater);
		checkbox.add(cmalts);
		checkbox.add(chops);
		checkbox.add(cyeasts);
		checkbox.add(csugars);
		checkbox.add(cadditives);
		p.add(checkbox);
		
		JPanel p2 = new JPanel(new FlowLayout(1,10,10));
		JButton update = new JButton("update");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaintainRecipes().setVisible(true);
				String getIweight = Iweight.getText().toString();
				String getIwater = Iwater.getText().toString();
				String getImalts = Imalts.getText().toString();
				String getIhops = Ihops.getText().toString();
				String getIyeasts = Iyeasts.getText().toString();
				String getIsugars = Isugars.getText().toString();
				String getIadditives = Iadditives.getText().toString();
				UpdataeRecipeGUI.this.dispose();// here we need some judgment conditions 
			}
		});
		
		JButton cancel = new JButton("Cancel");	
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Update().setVisible(true);
				UpdataeRecipeGUI.this.dispose();
			}
		});
		p2.add(update);
		p2.add(cancel);
		p.add(p2);
		this.add(p);
		this.setVisible(true);
	}
}

