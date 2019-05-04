
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


public class WriteNotePageGUI extends JFrame{
	public WriteNotePageGUI() {
		this.setTitle("RecommendRecipePageGUI");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		//p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		
		JTextArea note = new JTextArea("Note", 5,25);
		p.add(note);
		
		JButton submit = new JButton("submit");		
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new MainpageGUI().setVisible(true);
				WriteNotePageGUI.this.dispose();
				String getInote = note.getText().toString();
				//System.out.println(getInote);
			}
		});
		p.add(submit);
		this.add(p);
		this.setVisible(true);
	}
}
