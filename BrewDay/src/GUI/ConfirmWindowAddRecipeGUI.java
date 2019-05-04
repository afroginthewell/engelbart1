package GUI;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConfirmWindowAddRecipeGUI extends JFrame{
	public ConfirmWindowAddRecipeGUI() {
		this.setTitle("RecommendRecipePageGUI");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		//p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		
		JTextArea note = new JTextArea("You don't have any recipe, \n do you want to add recipe?", 5,25);
		note.setFont(new Font("Π³Με",Font.BOLD|Font.ITALIC,16));
		p.add(note);
		
		JPanel p2 = new JPanel(new FlowLayout(1,10,10));
		JButton yes = new JButton("yes");
		yes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MaintainRecipes().setVisible(true);
				ConfirmWindowAddRecipeGUI.this.dispose();
			}
		});
		JButton no = new JButton("no");	
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainpageGUI().setVisible(true);
				ConfirmWindowAddRecipeGUI.this.dispose();
			}
		});
		p2.add(yes);
		p2.add(no);
		p.add(p2);
		this.add(p);
		this.setVisible(true);
	}
}
