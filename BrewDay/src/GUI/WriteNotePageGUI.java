package GUI;
import java.awt.FlowLayout;
import java.awt.Font;
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

import controller.NoteController;
import model.Note;


public class WriteNotePageGUI extends JFrame{
	public WriteNotePageGUI(Note m, NoteController c) {
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
				
				WriteNotePageGUI.this.dispose();
				String getInote = note.getText().toString();
				try {
					if(c.editNode(getInote)==true) {
						System.out.println("Successfully add the note");
					}else {
						System.out.println("Fail to add the note");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				};
				//System.out.println(getInote);
			}
		});
		p.add(submit);
		this.add(p);
		
	}
	
	
	public void controlVisible(int flag) {
		if (flag == 1) {
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}

	}
}
