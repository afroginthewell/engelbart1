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

import controller.BrewController;
import controller.NoteController;
import model.Brew;
import model.Note;
import view.NoteView;

public class ConfirmChooseRecipeGUI extends JFrame{
	public ConfirmChooseRecipeGUI(Brew m, BrewController c) {
		this.setTitle("RecommendRecipePageGUI");
		this.setSize(180,110);
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
		
		JTextField note = new JTextField("Are you sure to choose this recipe?",20);
		note.setFont(new Font("Verdana",Font.ITALIC,10));
		note.setOpaque(false);
		note.setBorder(BorderFactory.createEmptyBorder());
		note.setEditable(false);
		
		p.add(note);
		
		Dimension preferredSize = new Dimension(60,20);
		JPanel p2 = new JPanel(new FlowLayout(1,10,10));
		JButton yes = new JButton("yes");	
		yes.setContentAreaFilled(false);
		yes.setFont(new Font("Verdana",Font.ITALIC,13));
		yes.setOpaque(false);
		
		yes.setPreferredSize(preferredSize);
		
		yes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					c.implement(m.getdetailindex(), m.getBatchSize());
					c.addHistory();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String getnote = note.getText().toString();
				Note mm=new Note();
				NoteController c=new NoteController(mm);
				NoteView v=new NoteView(mm,c,1);
				mm.addView(v);
				m.getView().get(5).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				ConfirmChooseRecipeGUI.this.dispose();


			}
		});
		JButton no = new JButton("no");	
		no.setContentAreaFilled(false);
		no.setFont(new Font("Verdana",Font.ITALIC,13));
		no.setOpaque(false);
		no.setPreferredSize(preferredSize );
		
		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					
				m.getView().get(5).setvisible(0);
				try {
					m.notifyView();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				ConfirmChooseRecipeGUI.this.dispose();
			}
		});
		
		p2.setOpaque(false);
		p.setOpaque(false);
		
		p2.add(yes);
		p2.add(no);
		p.add(p2);
		bg.add(p);
		this.add(bg);


	}

	public void controlVisible(int flag) {
		if(flag==1)
		{
			this.setVisible(true);
		}
		else {
			System.out.print(this.getClass());
			this.setVisible(false);
		}

	}
}
