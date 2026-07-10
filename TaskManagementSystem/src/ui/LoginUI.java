package ui;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.TaskDAO;

public class LoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginUI() {

		setTitle("Login");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(160, 20, 100, 30);
		contentPane.add(lblNewLabel);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(30, 60, 100, 20);
		contentPane.add(lblUsername);

		txtUsername = new JTextField();
		txtUsername.setBounds(30, 85, 180, 25);
		contentPane.add(txtUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(30, 120, 100, 20);
		contentPane.add(lblPassword);

		txtPassword = new JPasswordField();
		txtPassword.setBounds(30, 145, 180, 25);
		contentPane.add(txtPassword);

		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(30, 190, 100, 30);

		btnLogin.addActionListener(e -> {

			String username = txtUsername.getText();
			String password = new String(txtPassword.getPassword());

			TaskDAO dao = new TaskDAO();

			if (dao.login(username, password)) {

				JOptionPane.showMessageDialog(this, "Login Successful!");

				// Open Task Management Window
				TaskManagementUI taskUI = new TaskManagementUI();
				taskUI.setVisible(true);

				// Close Login Window
				dispose();

			} else {

				JOptionPane.showMessageDialog(this,
						"Invalid Username or Password!");

			}

		});

		contentPane.add(btnLogin);

	}
}