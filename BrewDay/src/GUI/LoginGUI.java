package GUI;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginGUI extends JFrame{
	public LoginGUI() {
		this.setTitle("Login");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		
		JTextField UserName = new JTextField("User Name",30);
		JTextField Password = new JTextField("Password",30);
		
		BoxLayout layout = new BoxLayout(p,BoxLayout.Y_AXIS);
		p.setLayout(layout);
		Box b1=Box.createVerticalBox();
		p.add(b1);
		b1.add(Box.createVerticalStrut(40));
		b1.add(UserName);
		b1.add(Box.createVerticalStrut(40));
		b1.add(Password);
		JPanel p2 = new JPanel();
		JButton Login = new JButton("Login");
		Login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new WriteNotePageGUI().setVisible(true);
				String getUserName = UserName.getText().toString();
				String getPassword = Password.getText().toString();
				LoginGUI.this.dispose();
			}
		});
		p2.add(Login);
		p.add(p2);
		this.add(p);
		this.setVisible(true);
	}
}
