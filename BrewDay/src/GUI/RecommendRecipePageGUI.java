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
import javax.swing.JTextField;

public class RecommendRecipePageGUI extends JFrame{
	public RecommendRecipePageGUI() {
		this.setTitle("RecommendRecipePageGUI");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		//p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		
		JTextField BatchSize = new JTextField("Input Batach Size",20);
		BatchSize.setFont(new Font("Π³Με",Font.BOLD|Font.ITALIC,16));
		p.add(BatchSize);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(1,10,10));
		
		JButton GoToMain = new JButton("Go to main page");	
		GoToMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainpageGUI().setVisible(true);
				RecommendRecipePageGUI.this.dispose();
			}
		});
		JButton GetRecommend = new JButton("Get Recommend");	
		GetRecommend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResultListGUI().setVisible(true);
				RecommendRecipePageGUI.this.dispose();
				String getBatchSize = BatchSize.getText().toString();
			}
		});
		p2.add(GoToMain);
		p2.add(GetRecommend);
		p.add(p2);		
		this.add(p);
		this.setVisible(true);
	}
}
