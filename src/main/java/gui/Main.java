package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bao.EmployeeBao;
import entities.Employee;

import javax.swing.JDesktopPane;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.Icon;

public class Main extends JFrame {
	private Attendancerecordgui Attendancerecordgui = new Attendancerecordgui();
	private Login login = new Login();
	private JPanel contentPane;
	private JPanel panel;
	private JLabel picLabel;

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
					frame.setSize(850, 550);
					frame.setLocationRelativeTo(null);
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
	public Main() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 850, 600);
		contentPane = new GradientPanel(Color.white, new Color(0, 130, 255), 4);
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new GradientPanel(Color.white, new Color(0, 160, 255), 4);
		panel.setForeground(new Color(255, 255, 255));
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.CENTER);

		BufferedImage myPicture = null;
		try {
			myPicture = ImageIO.read(this.getClass().getResource("/Images/logo.png"));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		ImageIcon attendance = new ImageIcon(Main.class.getResource("/Images/calendar.png"), "attendance");

		ImageIcon MANAGERMENT = new ImageIcon(Main.class.getResource("/Images/settings.png"), "sas");
		panel.setLayout(null);

		JLabel picLabel = new JLabel(new ImageIcon(myPicture));
		picLabel.setBackground(Color.WHITE);
		picLabel.setBounds(28, 24, 770, 158);
		panel.add(picLabel);

		JButton btn_CallLogin = new JButton("", MANAGERMENT);
		btn_CallLogin.setBorder(null);
		btn_CallLogin.setRequestFocusEnabled(false);
		btn_CallLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_CallLoginActionPerformed(e);
			}
		});
		btn_CallLogin.setBounds(511, 225, 128, 131);
		panel.add(btn_CallLogin);
		btn_CallLogin.setBackground(Color.WHITE);

		JButton btn_CallTimekeeping = new JButton("", attendance);
		btn_CallTimekeeping.setBorder(null);
		btn_CallTimekeeping.setBounds(213, 225, 128, 131);
		panel.add(btn_CallTimekeeping);
		btn_CallTimekeeping.setBackground(Color.WHITE);

		JLabel lblNewLabel_10 = new JLabel("ATTENDANCE RECORD");
		lblNewLabel_10.setForeground(new Color(255, 255, 204));
		lblNewLabel_10.setBounds(196, 377, 186, 20);
		panel.add(lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("Sitka Banner", Font.BOLD, 18));

		JLabel lblNewLabel_5 = new JLabel("LABOUR MANAGEMENT");
		lblNewLabel_5.setForeground(new Color(255, 255, 204));
		lblNewLabel_5.setBounds(490, 377, 196, 20);
		panel.add(lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("Sitka Banner", Font.BOLD, 18));
		btn_CallTimekeeping.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_CallTimekeepingActionPerformed(e);
			}
		});

	}

	protected void btn_CallTimekeepingActionPerformed(ActionEvent e) {
		Attendancerecordgui.setVisible(true);
		setVisible(false);
	}
	protected void btn_CallLoginActionPerformed(ActionEvent e) {
		login.setVisible(true);
		this.setVisible(false);
	}
}
