package GUI;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class NotavailableList extends JFrame{
	public NotavailableList() {
		this.setTitle("NotavailableList");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		
		this.add(p);
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JPanel p1 = new JPanel(); 
		p1.add(new JTextField("Non-executable recipes",30));
		p.add(p1);
		
		JPanel p2 = new JPanel();
		p2.setLayout(new FlowLayout(1,10,20));
		JTextArea t1 = new JTextArea("Recipes missing ingredient 1 400g; missing ingredient 2 400g");
		//t1.setSize(200, 100);
		//t1.setSize(200);;
		p2.add(t1);
		
		JTextArea t2 = new JTextArea("Recipes missing ingredient 2 400g");
		//t2.setSize(200, 100);
		p2.add(t2);
		p.add(p2);
		
		JPanel p3 = new JPanel();
		p3.setLayout(new FlowLayout(1,10,10));
		JButton b1 = new JButton("Back to previous");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ResultList().setVisible(true);
				NotavailableList.this.dispose();
			}
		});
		p3.add(b1);
		JButton b2 = new JButton("Back to main page");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainpageGUI().setVisible(true);
				NotavailableList.this.dispose();
			}
		});
		p3.add(b2);
		p.add(p3);
		/*
		p2.setLayout(new GridLayout(2, 2, 20, 10)); 
		p2.add(new TextArea("Recipes missing ingredient 1 400g; missing ingredient 2 400g"));
		p2.add(new JButton("Back to previous"));
		p2.add(new TextArea("Recipes missing ingredient 2 400g"));
		p2.add(new JButton("Back to main page"));
		p.add(p2); 
		
		JPanel p3 = new JPanel();
		p.add(p3);
		*/
		this.setVisible(true);
		
	}
}
