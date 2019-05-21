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
import javax.swing.JOptionPane;
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
		this.setTitle("Confirm window");
		this.setSize(700,500);// the biggest panel
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		///////////bg////////////
		JPanel bg = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon ii = new ImageIcon( "C:\\Users\\yuan\\Desktop\\SE\\2.jpg");
				g.drawImage(ii.getImage(), 0, 0, getWidth(), getHeight(), ii.getImageObserver());
			}
		};
		
		// make a empty to fill the font head
		JPanel emptyPanel = new JPanel(); 
		emptyPanel.setLayout(new FlowLayout(1,10,10));
		emptyPanel.setPreferredSize(new Dimension(400, 70));
		///////////bg////////////

		JPanel p = new JPanel();
		//p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		
		// this is the note test filed
		JTextField note = new JTextField("Are you sure to choose this recipe?",20);
		note.setFont(new Font("Verdana",Font.ITALIC,20));
		note.setOpaque(false);
		note.setBorder(BorderFactory.createEmptyBorder());
		note.setEditable(false);
		
		p.add(note);
		
		Dimension preferredSize = new Dimension(60,20);
		JPanel p2 = new JPanel(new FlowLayout(1,10,10));
		JButton yes = new JButton("yes");	
		yes.setContentAreaFilled(false);
		yes.setFont(new Font("Verdana",Font.ITALIC,15));
		yes.setOpaque(false);
		
		yes.setPreferredSize(preferredSize);
		
		// set the action listener to the user
		yes.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// show some alert to the user
				JOptionPane.showMessageDialog(null, "Do not drive after drinking!!!");
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
		
		// add a new button
		JButton no = new JButton("no");	
		no.setContentAreaFilled(false);
		no.setFont(new Font("Verdana",Font.ITALIC,15));
		no.setOpaque(false);
		no.setPreferredSize(preferredSize );
		
		// for the no button action listener
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
		emptyPanel.setOpaque(false);
		
		p2.add(yes);
		p2.add(no);
		p.add(p2);
		bg.add(emptyPanel);
		bg.add(p);
		this.add(bg);


	}

	
	// thisi sone is to control the visible
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
