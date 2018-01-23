package voting.blockchain;

import java.awt.event.*;

import javax.swing.*;



public class Login extends JFrame{

	JButton loginbutton = new JButton("Login");
	JPanel panel = new JPanel();
	JTextField userfield = new JTextField(15);
	JPasswordField pwfield = new JPasswordField(15);
	
	
	Login(){
		super("Login Autentification");
		setSize(300,200);
		setLocation(500,280);
		panel.setLayout(null);
		
		userfield.setBounds(70,30,150,20);
		pwfield.setBounds(70,65,150,20);
		loginbutton.setBounds(110, 100, 80, 20);
		
		panel.add(loginbutton);
		panel.add(userfield);
		panel.add(pwfield);
		
		getContentPane().add(panel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		readInfo();
	}
	public void readInfo() {
		loginbutton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae) {
				String user = userfield.getText();
				String pw = pwfield.getText();
				boolean check = false;
				check = Main.verifyLogin(user, pw); 
				if (check) {
					dispose();
					System.out.println("Hi "+user+" . You are logged in.");
					Main.afterLogin();
				} else {
					JOptionPane.showMessageDialog(null, "Wrong Username or Password");
					userfield.setText("");
					pwfield.setText("");
					userfield.requestFocus();
				}
			}
	});
	}

	public boolean VerifyAccount(String user, String pw) {
		if (user.equals("user") && pw.equals("pw")) {
			System.out.println("Hi "+user+". You are logged in.");
			return true;
		}
		else {
			System.out.println("Invalid username or password.");
			return false;
		}
		
	}
	
}
