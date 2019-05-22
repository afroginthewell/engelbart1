package GUI;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.NoteController;
import model.Note;


public class WriteNotePageGUI extends JFrame{
	public WriteNotePageGUI(Note m, NoteController c) {
		
		//this is the main panel
		this.setTitle("RecommendRecipePageGUI");
		this.setSize(500,500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		///////////background////////////
		JPanel bg = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon( "C:\\Users\\Jerry Zou\\Desktop\\JieLi\\Java workspace\\20190511\\brew.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		
		JPanel emptyPanel = new JPanel();
		emptyPanel.setLayout(new FlowLayout(1,10,10));
		emptyPanel.setPreferredSize(new Dimension(400, 80));
		///////////bg////////////

		//make a new panel
		JPanel p = new JPanel();
		//p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		// make a new text field
		JTextField noteTitle = new JTextField("Write note in the following:", 15);
		noteTitle.setFont(new Font("Verdana",Font.ITALIC,13));
		noteTitle.setOpaque(false);
		noteTitle.setBorder(BorderFactory.createEmptyBorder());
		noteTitle.setEditable(false);// make it cannot be edit
		
		// this is a text note
		JTextArea note = new JTextArea("", 5,25);
		p.add(noteTitle);
		p.add(note);
		JPanel p1 = new JPanel();
		
		//add a new button
		JButton submit = new JButton("submit");	
		submit.setOpaque(false);
		submit.setFont(new Font("Verdana", Font.ITALIC, 15));
		submit.setContentAreaFilled(false);
		
		//add a new action listener
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WriteNotePageGUI.this.dispose();// make it disappear
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
		
		// add all the thing to the same panel
		p1.add(submit);
		p.add(p1);
		emptyPanel.setOpaque(false);
		p.setOpaque(false);
		p1.setOpaque(false);
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);

	}

	// this is control the visible
	public void controlVisible(int flag) {
		if (flag == 1) {
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}

	}
}
