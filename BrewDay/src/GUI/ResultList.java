package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ResultList extends JFrame{
	public ResultList() {
		this.setTitle("Result list page");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel p1 = new JPanel(); 
		JTextField title = new JTextField("Able to brew recipes",30);
		title.setEditable(false);
		p1.add(title);
		p.add(p1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new GridLayout(3, 3, 20, 10)); 
		JTextField ARecipe = new JTextField("1. Recipe A",30);
		ARecipe.setEditable(false);
		p2.add(ARecipe);
		JTextField ARecipeQ = new JTextField("1 L",30);
		ARecipeQ.setEditable(false);
		p2.add(ARecipeQ);
		JButton AButton = new JButton("detail");
		AButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DetailRecipeInformation().setVisible(true);
				ResultList.this.dispose();
			}
		});
		p2.add(AButton);
		
		JTextField BRecipe = new JTextField("2. Recipe B",30);
		BRecipe.setEditable(false);
		p2.add(BRecipe);
		JTextField BRecipeQ = new JTextField("0.8 L",30);
		BRecipeQ.setEditable(false);
		p2.add(BRecipeQ);
		JButton BButton = new JButton("detail");
		BButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DetailRecipeInformation().setVisible(true);
				ResultList.this.dispose();
			}
		});
		p2.add(BButton);
		
		JTextField CRecipe = new JTextField("3. Recipe C",30);
		CRecipe.setEditable(false);
		p2.add(CRecipe);
		JTextField CRecipeQ = new JTextField("1.5 L",30);
		CRecipeQ.setEditable(false);
		p2.add(CRecipeQ);
		JButton CButton = new JButton("detail");
		CButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new DetailRecipeInformation().setVisible(true);
				ResultList.this.dispose();
			}
		});
		p2.add(CButton);

		p.add(p2); 
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(1,10,10));
		JButton b3 = new JButton("Non-executable recipes");
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new NotavailableList().setVisible(true);
				ResultList.this.dispose();
			}
		});
		p3.add(b3);
		p.add(p3);
	
		this.setVisible(true);
		
	}
}
