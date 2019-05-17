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
		this.setTitle("RecommendRecipePageGUI");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		///////////bg////////////
		JPanel bg = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon( "C:\\Users\\Jerry Zou\\Desktop\\JieLi\\Java workspace\\20190511\\brew.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};

		///////////bg////////////

		JPanel p = new JPanel();
		//p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		JTextField noteTitle = new JTextField("Write note in the following:", 15);
		noteTitle.setFont(new Font("Verdana",Font.ITALIC,13));
		noteTitle.setOpaque(false);
		noteTitle.setBorder(BorderFactory.createEmptyBorder());
		noteTitle.setEditable(false);
		
		JTextArea note = new JTextArea("", 5,25);
		p.add(noteTitle);
		p.add(note);
		JPanel p1 = new JPanel();
		
		JButton submit = new JButton("submit");		
		submit.setFont(new Font("Verdana", Font.ITALIC, 15));
		submit.setContentAreaFilled(false);
		
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
		
		p1.add(submit);
		p.add(p1);
		p.setOpaque(false);
		bg.add(p);
		this.add(bg);

	}


	public void controlVisible(int flag) {
		if (flag == 1) {
			this.setVisible(true);
		} else {
			this.setVisible(false);
		}

	}
}
