package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import bao.EmployeeBao;
import entities.Employee;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;

public class Login extends JFrame {
	private Employee emp;
	private EmployeeBao empBao;
	private JPanel contentPane;
	private JButton btnNewButton;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JPasswordField passwordField;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_1;
	private JLabel lblUserError;
	private JLabel lblPassError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.pack();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login(Employee emp) throws HeadlessException {
		super();
		this.emp = emp;
	}

	public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 508);
		contentPane = new GradientPanel(Color.white, new Color(0, 130, 255), 2);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new GradientPanel(Color.white, new Color(0, 130, 255), 2);
		panel.setBackground(new Color(153, 153, 255));
		contentPane.add(panel, BorderLayout.CENTER);

		BufferedImage login1 = null;
		try {
			login1 = ImageIO.read(this.getClass().getResource("/Images/login1.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage user = null;
		try {
			user = ImageIO.read(this.getClass().getResource("/Images/login2.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		BufferedImage pass = null;
		try {
			pass = ImageIO.read(this.getClass().getResource("/Images/login.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel.setLayout(null);

		lblNewLabel_3 = new JLabel("Employee Login");
		lblNewLabel_3.setBounds(64, 2, 276, 53);
		lblNewLabel_3.setForeground(new Color(255, 255, 204));
		lblNewLabel_3.setBackground(new Color(255, 255, 204));
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Sitka Banner", Font.BOLD, 42));

		lblNewLabel = new JLabel(new ImageIcon(user));
		lblNewLabel.setBounds(81, 74, 24, 24);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(129, 72, 167, 29);
		textField.setForeground(new Color(0, 0, 51));
		textField.setBackground(new Color(153, 204, 255));
		panel.add(textField);
		textField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 204)));
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setFont(new Font("Serif", Font.PLAIN, 20));
		textField.setColumns(10);

		ImageIcon enter = new ImageIcon(Main.class.getResource("/Images/enter.png"), "attendance");

		lblNewLabel_2 = new JLabel(new ImageIcon(pass));
		lblNewLabel_2.setBounds(81, 124, 24, 24);
		panel.add(lblNewLabel_2);

		passwordField = new JPasswordField();
		passwordField.setBounds(129, 119, 167, 29);
		passwordField.setForeground(new Color(0, 0, 51));
		passwordField.setBackground(new Color(153, 204, 255));
		panel.add(passwordField);
		passwordField.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(255, 255, 204)));
		passwordField.setHorizontalAlignment(SwingConstants.LEFT);
		passwordField.setFont(new Font("Serif", Font.PLAIN, 20));
		btnNewButton = new JButton("", enter);
		btnNewButton.setBounds(165, 160, 91, 35);
		btnNewButton.setBackground(new Color(255, 255, 204));
		panel.add(btnNewButton);
		btnNewButton.setFont(new Font("Serif", Font.BOLD, 16));

		lblNewLabel_1 = new JLabel(new ImageIcon(login1));
		lblNewLabel_1.setBounds(2, 259, 400, 210);
		panel.add(lblNewLabel_1);

		lblUserError = new JLabel("");
		lblUserError.setFont(new Font("Serif", Font.PLAIN, 12));
		lblUserError.setForeground(Color.RED);
		lblUserError.setBounds(129, 52, 167, 18);
		panel.add(lblUserError);

		lblPassError = new JLabel("");
		lblPassError.setForeground(Color.RED);
		lblPassError.setFont(new Font("Serif", Font.PLAIN, 12));
		lblPassError.setBounds(129, 101, 167, 18);
		panel.add(lblPassError);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
	}

	public int chooseoption(String mess, ActionEvent e, String luachon1, String luachon2) {

		String[] options = { luachon1, luachon2 };
		var x = JOptionPane.showOptionDialog(this, mess + " !", "Confirm box", JOptionPane.DEFAULT_OPTION,
				JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

		return x;
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		lblUserError.setText("");
		lblPassError.setText("");

		var username = textField.getText();
		var password = String.valueOf(passwordField.getPassword());

		var check1 = nullUserPass(username, "Please enter username", lblUserError);
		var check2 = nullUserPass(password, "Please enter password", lblPassError);

		if (check1 && check2) {
			empBao = new EmployeeBao();
			var emp = empBao.getEmployeeByUser(username);
			login(emp, username, password);
		}

	}

	private boolean nullUserPass(String text, String error, JLabel label) {
		if (!(text.equals(""))) {
			return true;
		} else {
			label.setText(error);
			return false;
		}
	}

	private void login(Employee emp, String username, String password) {
		if (emp != null) {
			if (emp.getSttemp() == 1) {

				if (BCrypt.checkpw(password, emp.getPass())) {
					var type = emp.getTypeid();
					switch (type) {
					case "HR" -> {
						ChooseType hr = new ChooseType(emp);
						hr.setVisible(true);
						this.setVisible(false);
					}
					case "ADO" -> {
						ChooseType admin = new ChooseType(emp);
						admin.setVisible(true);
						this.setVisible(false);
					}
					case "EMP" -> {
						Client cli = new Client(emp);
						cli.setVisible(true);
						this.setVisible(false);
					}
					}
				} else {
					lblPassError.setText("Wrong Password");
				}
			} else {
				lblUserError.setText("Wrong Username");
			}
		} else {
			lblUserError.setText("Wrong Username");
		}

	}
}
