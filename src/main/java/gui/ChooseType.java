package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Employee;

import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.FlowLayout;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class ChooseType extends JFrame {

	private JPanel contentPane;
	private JPanel panel_1;
	private JButton btnType;
	private JButton btnProfilePage;
	private JLabel lblNewLabel_1;
	private Employee employee;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChooseType frame = new ChooseType();
					frame.setSize(850, 550);
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * Create the frame.
	 */
	public ChooseType() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 550);
		contentPane = new GradientPanel(Color.white, new Color(153, 204, 255), 4);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel_1 = new GradientPanel(Color.white, new Color(153, 204, 255), 4);
		panel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_1.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_1, BorderLayout.CENTER);

		ImageIcon employees = new ImageIcon(Main.class.getResource("/Images/information.png"), "employees");

		ImageIcon HR = new ImageIcon(Main.class.getResource("/Images/content-management-system.png"), "HR");
		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(this.getClass().getResource("/Images/logo.jpg"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		panel_1.setLayout(new BorderLayout(0, 0));

		panel_2 = new GradientPanel(Color.white, new Color(153, 204, 255), 4);
		panel_2.setBorder(new CompoundBorder(
				new CompoundBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 204)), new CompoundBorder(
						new EmptyBorder(10, 10, 10, 10), new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 204, 255)))),
				null));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setLayout(null);
		panel_1.add(panel_2);

		lblNewLabel = new JLabel("PLEASE SELECT USER TYPE");
		lblNewLabel.setBounds(162, 49, 549, 45);
		lblNewLabel.setForeground(new Color(0, 0, 153));
		lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 40));
		panel_2.add(lblNewLabel);
		
		btnProfilePage = new JButton("", employees);
		btnProfilePage.setBounds(200, 157, 133, 133);
		btnProfilePage
				.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 102), new Color(255, 204, 0)));
		btnProfilePage.setForeground(Color.BLACK);
		btnProfilePage.setBackground(Color.WHITE);
		panel_2.add(btnProfilePage);
		btnProfilePage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnProfilePageActionPerformed(e);
			}
		});
		btnProfilePage.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnProfilePage.setFocusable(false);

		btnType = new JButton("", HR);
		btnType.setBounds(496, 157, 133, 133);
		btnType.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 51), new Color(255, 204, 0)));
		btnType.setBackground(new Color(255, 255, 255));
		panel_2.add(btnType);
		btnType.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnType.setFocusable(false);

		lblNewLabel_1 = new JLabel("MY PAGE");
		lblNewLabel_1.setBounds(214, 317, 121, 32);
		panel_2.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(new Color(0, 0, 153));
		lblNewLabel_1.setFont(new Font("Sitka Subheading", Font.BOLD, 25));
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(0, 0, 153));
		lblNewLabel_2.setFont(new Font("Sitka Subheading", Font.BOLD, 25));
		lblNewLabel_2.setBounds(469, 317, 200, 32);
		panel_2.add(lblNewLabel_2);

	}

	public ChooseType(Employee employee) {
		this();
		this.employee = employee;
		if (employee.getTypeid().equals("ADO")) {
			btnType.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnTypeADOActionPerformed(e);
				}
			});
			showADO();
		} else {
			btnType.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					btnTypeHRActionPerformed(e);
				}
			});
			showHR();
		}
	}

	public void showHR() {
		lblNewLabel_2.setText("HR SYSTEM");
	}

	public void showADO() {
		lblNewLabel_2.setText("ADMIN OFFICER");
	}

	protected void btnTypeADOActionPerformed(ActionEvent e) {
		Admin admin = new Admin(employee);
		admin.getMyInstance();
		admin.pack();
		if (!admin.isVisible()) {
			this.setVisible(false);
			admin.setVisible(true);
		}
		;

	}

	protected void btnTypeHRActionPerformed(ActionEvent e) {
		HR hr = new HR(employee);
		this.setVisible(false);
		hr.setVisible(true);
	}

	protected void btnProfilePageActionPerformed(ActionEvent e) {
		ClientAdminHr client = new ClientAdminHr(employee);
		setVisible(false);
		client.setVisible(true);
	}
}
