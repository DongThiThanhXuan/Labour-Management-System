package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bao.AttendancerecordBao;
import bao.DepartmentBao;
import bao.EmployeeBao;
import bao.ShiftBao;
import entities.Employee;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.MatteBorder;

public class Attendancerecordgui extends JFrame {
	private EmployeeBao empbao = new EmployeeBao();
	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JTextField textField;
	private JPanel panel_3;
	private JPanel panel_4;
	private JButton btnNewButton;
	private JLabel lbl_showfullname;
	private JLabel lblNewLabel_5;
	private JLabel lbl_showdep;
	private JLabel lbl_showshift;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_6;
	private JLabel lbl_shiftin;
	private JLabel lbl_shiftout;
	private JButton btnNewButton_1;

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
					Attendancerecordgui frame = new Attendancerecordgui();
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
	public Attendancerecordgui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 423, 487);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new GradientPanel(Color.white, new Color(0, 160, 255), 3);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel, BorderLayout.NORTH);

		lblNewLabel = new JLabel("ATTENDANCE RECORD");
		lblNewLabel.setForeground(new Color(0, 51, 102));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 26));
		panel.add(lblNewLabel);

		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_1.add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 163, 195, 100, 0 };
		gbl_panel_2.rowHeights = new int[] { 20, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JLabel lblNewLabel_1 = new JLabel("Search by Phone:");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Serif", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Serif", Font.PLAIN, 15));
		textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));

		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		panel_2.add(textField, gbc_textField);
		textField.setColumns(10);

		ImageIcon loupe = new ImageIcon(Main.class.getResource("/Images/loupe.png"), "loupe");

		btnNewButton_1 = new JButton("", loupe);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton_1.gridx = 2;
		gbc_btnNewButton_1.gridy = 0;
		panel_2.add(btnNewButton_1, gbc_btnNewButton_1);

		panel_3 = new JPanel();
		panel_3.setBorder(
				new TitledBorder(null, "Your Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.WHITE);
		panel_1.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0, 0, 50, 103, 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 44, 39, 0, 39, 0, 40, 0, 39, 0, 39, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		lblNewLabel_2 = new JLabel("Full Name");
		lblNewLabel_2.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		panel_3.add(lblNewLabel_2, gbc_lblNewLabel_2);
		lblNewLabel_2.setVisible(false);

		lbl_showfullname = new JLabel("");
		lbl_showfullname.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_showfullname = new GridBagConstraints();
		gbc_lbl_showfullname.anchor = GridBagConstraints.WEST;
		gbc_lbl_showfullname.gridwidth = 2;
		gbc_lbl_showfullname.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_showfullname.gridx = 2;
		gbc_lbl_showfullname.gridy = 2;
		panel_3.add(lbl_showfullname, gbc_lbl_showfullname);

		lblNewLabel_3 = new JLabel("Department");
		lblNewLabel_3.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 4;
		panel_3.add(lblNewLabel_3, gbc_lblNewLabel_3);
		lblNewLabel_3.setVisible(false);

		lbl_showdep = new JLabel("");
		lbl_showdep.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_showdep = new GridBagConstraints();
		gbc_lbl_showdep.anchor = GridBagConstraints.WEST;
		gbc_lbl_showdep.gridwidth = 2;
		gbc_lbl_showdep.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_showdep.gridx = 2;
		gbc_lbl_showdep.gridy = 4;
		panel_3.add(lbl_showdep, gbc_lbl_showdep);

		lblNewLabel_5 = new JLabel("Shift");
		lblNewLabel_5.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 6;
		panel_3.add(lblNewLabel_5, gbc_lblNewLabel_5);
		lblNewLabel_5.setVisible(false);

		lbl_showshift = new JLabel("");
		lbl_showshift.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_showshift = new GridBagConstraints();
		gbc_lbl_showshift.anchor = GridBagConstraints.WEST;
		gbc_lbl_showshift.gridwidth = 2;
		gbc_lbl_showshift.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_showshift.gridx = 2;
		gbc_lbl_showshift.gridy = 6;
		panel_3.add(lbl_showshift, gbc_lbl_showshift);

		lblNewLabel_4 = new JLabel("Working Hours Start From");
		lblNewLabel_4.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 8;
		panel_3.add(lblNewLabel_4, gbc_lblNewLabel_4);
		lblNewLabel_4.setVisible(false);

		lbl_shiftin = new JLabel("");
		lbl_shiftin.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_shiftin = new GridBagConstraints();
		gbc_lbl_shiftin.anchor = GridBagConstraints.WEST;
		gbc_lbl_shiftin.gridwidth = 2;
		gbc_lbl_shiftin.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_shiftin.gridx = 2;
		gbc_lbl_shiftin.gridy = 8;
		panel_3.add(lbl_shiftin, gbc_lbl_shiftin);

		lblNewLabel_6 = new JLabel("Working Hours End At");
		lblNewLabel_6.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 10;
		panel_3.add(lblNewLabel_6, gbc_lblNewLabel_6);

		lblNewLabel_6.setVisible(false);

		lbl_shiftout = new JLabel("");
		lbl_shiftout.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_shiftout = new GridBagConstraints();
		gbc_lbl_shiftout.anchor = GridBagConstraints.WEST;
		gbc_lbl_shiftout.gridwidth = 2;
		gbc_lbl_shiftout.gridx = 2;
		gbc_lbl_shiftout.gridy = 10;
		panel_3.add(lbl_shiftout, gbc_lbl_shiftout);

		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		contentPane.add(panel_4, BorderLayout.SOUTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 30, 30, 100, 30 };
		gbl_panel_4.rowHeights = new int[] { 40, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		btnNewButton = new JButton("Timekeeping");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		btnNewButton.setFont(new Font("Sitka Text", Font.BOLD, 15));
		btnNewButton.setForeground(new Color(255, 255, 204));
		btnNewButton.setBackground(new Color(0, 160, 255));
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.gridwidth = 2;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 0;
		panel_4.add(btnNewButton, gbc_btnNewButton);
	}

	public LocalTime getnowtime() {
		return java.time.LocalTime.now();

	}

	public Date getdatenow() {
		Date date = new Date();
		return new java.sql.Date(date.getTime());
	}

	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		var atdbao = new AttendancerecordBao();
		var depbao = new DepartmentBao();
		var phone = textField.getText();
		long millis = System.currentTimeMillis();
		Date date = getdatenow();

		if (empbao.checkPhone(phone)) {
			lblNewLabel_2.setVisible(true);
			lblNewLabel_3.setVisible(true);
			lblNewLabel_5.setVisible(true);
			lblNewLabel_6.setVisible(true);
			lblNewLabel_4.setVisible(true);
			// lay ra ten theo so phone
			var emp = employee();
			lbl_showfullname.setText(emp.getFullname());
			var idemp = emp.getIdemp();
			lbl_showdep.setText(depbao.getdep(emp.getIddep()).getNamedep());

			int shift = atdbao.getshift(idemp, date);

			var sbao = new ShiftBao();
			if (shift != 0) {
				lbl_showshift.setText(Integer.toString(shift));
				var timein = sbao.gettimecheckin(shift);
				lbl_shiftin.setText(timein.toString());
				var timeout = sbao.gettimecheckout(shift);
				lbl_shiftout.setText(timeout.toString());
			} else {
				lbl_showshift.setText("OFF");
				lbl_shiftin.setText("No Info");
				lbl_shiftout.setText("No Info");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Phone number does not exist");
		}
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		if (lbl_showshift.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this, "kindly show your infomation");
		} else {
			timekeping(e);
		}

	}

	private Employee employee() {
		var phone = textField.getText();
		return empbao.XuansearchonAttendancerecord(phone);

	}

	private void timekeping(ActionEvent e) {
		var idemp = employee().getIdemp();
		var atdbao = new AttendancerecordBao();
		var nowtime = getnowtime();
		var today = getdatenow();
		var sbao = new ShiftBao();
		int shift = atdbao.getshift(idemp, today);
		if (shift != 0) {
			var checkintime = atdbao.checkcheckintime(idemp, today);
			DateTimeFormatter dateFormatter1 = DateTimeFormatter.ofPattern("HH");
			String a = checkintime.format(dateFormatter1);

			var checkouttime = atdbao.checkcheckouttime(idemp, today);
			String b = checkouttime.format(dateFormatter1);
			int chenhlech = sbao.checkchenhlech(shift, nowtime);

			if (a.equals("00") && b.equals("00")) {
				if (chenhlech <= 0) {
					atdbao.updatecheckin(nowtime, idemp, today);
					JOptionPane.showMessageDialog(this, "Attendance \"Check In\" successful");
					Main main = new Main();
					main.setVisible(true);
					this.setVisible(false);
				} else if (0 < chenhlech && chenhlech <= 120) {
					String[] options = { "late work due to personal reasons", "late work due to company work" };
					var stt = JOptionPane.showInputDialog(this, "Kindly Choose:", "Update Status",
							JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
					if (stt != null) {
						if (stt.equals("late work due to personal reasons")) {
							String reason = JOptionPane.showInputDialog(this, "Input in the reason for late check-in");
							if (reason != null && !reason.isEmpty()) {
								atdbao.updatereasonCheckin(reason, idemp, today);
								atdbao.updatecheckin(nowtime, idemp, today);
								JOptionPane.showMessageDialog(this, "Attendance \"Check In\" successful");
								Main main = new Main();
								main.setVisible(true);
								this.setVisible(false);
							}
						} else if (stt.equals("late work due to company work")) {
							atdbao.updatereasonCheckin("Company work", idemp, today);
							atdbao.updatecheckin(nowtime, idemp, today);
							JOptionPane.showMessageDialog(this, "Attendance \"Check In\" successful");
							Main main = new Main();
							main.setVisible(true);
							this.setVisible(false);
						}
					}

				} else if (chenhlech > 120 && chenhlech <540) {
					String[] options2 = { "Confirm Check Out", "Cancel" };
					var x = JOptionPane.showOptionDialog(this,
							"It's too late to check in! kindly contact to Admin Officer team to record the shift" + "\n"
									+ "Do you want to check out?",
							"Confirm box", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2,
							options2[0]);
					if (x == 0) {
						String[] options1 = { "leave work early for personal reasons",
								"leave work due to company work" };
						String stt1 = (String) JOptionPane.showInputDialog(this, "Kindly Choose:", "Update Status",
								JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
						if (stt1 != null) {
							switch (stt1) {
							case "leave work early for personal reasons" -> {
								String reason = JOptionPane.showInputDialog(this, "Input in the reason for leave work");
								if (!reason.isEmpty()) {
									atdbao.updatereasonCheckout(reason, idemp, today);
									atdbao.updatecheckout(nowtime, idemp, today);
									JOptionPane.showMessageDialog(this, "Attendance \"Check out\" successful");
									Main main = new Main();
									main.setVisible(true);
									this.setVisible(false);
								}
							}
							case "leave work due to company work" -> {
								atdbao.updatereasonCheckout("Company work", idemp, today);
								atdbao.updatecheckout(nowtime, idemp, today);
								JOptionPane.showMessageDialog(this, "Attendance \"Check out\" successful");
								Main main = new Main();
								main.setVisible(true);
								this.setVisible(false);
							}
							}
						}
					}
					if (x != 0) {
						Main main = new Main();
						main.setVisible(true);
						this.setVisible(false);
					}
				}else if(chenhlech >540) {
					JOptionPane.showMessageDialog(this, "You forgot to check in! kindly contact to Admin Officer team to record the shift");
					atdbao.updatecheckout(nowtime, idemp, today);
					JOptionPane.showMessageDialog(this, "Attendance \"Check out\" successful");
					Main main = new Main();
					main.setVisible(true);
					this.setVisible(false);
				}
			} else if (b.equals("00") && !a.equals("00")) {
				if (chenhlech >= 540) {
					atdbao.updatecheckout(nowtime, idemp, today);
					JOptionPane.showMessageDialog(this, "Attendance \"Check Out\" successful");
					Main main = new Main();
					main.setVisible(true);
					this.setVisible(false);
				} else if (chenhlech < 540) {
					String[] options2 = { "Confirm", "Cancel" };
					var x = JOptionPane.showOptionDialog(this,
							"Work hours are not over yet" + "\n" + "Do you want to check out early?", "Confirm box",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options2, options2[0]);
					if (x == 0) {
						String[] options1 = { "leave work early for personal reasons",
								"leave work due to company work" };
						String stt1 = (String) JOptionPane.showInputDialog(this, "Kindly Choose:", "Update Status",
								JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
						if (stt1 != null) {
							switch (stt1) {

							case "leave work early for personal reasons" -> {
								String reason = JOptionPane.showInputDialog(this, "Input in the reason for leave work");
								if (!reason.isEmpty()) {
									atdbao.updatereasonCheckout(reason, idemp, today);
									atdbao.updatecheckout(nowtime, idemp, today);
									JOptionPane.showMessageDialog(this, "Attendance \"Check out\" successful");
									Main main = new Main();
									main.setVisible(true);
									this.setVisible(false);
								}
							}
							case "leave work due to company work" -> {
								atdbao.updatereasonCheckout("Company work", idemp, today);
								atdbao.updatecheckout(nowtime, idemp, today);
								JOptionPane.showMessageDialog(this, "Attendance \"Check out\" successful");
								Main main = new Main();
								main.setVisible(true);
								this.setVisible(false);
							}
							}
						}

					}
					if (x != 0) {
						Main main = new Main();
						main.setVisible(true);
						this.setVisible(false);
					}

				}

			} else if (!b.equals("00") && !a.equals("00")) {
				JOptionPane.showMessageDialog(this, "You Did Timekeeping Today");
				Main main = new Main();
				main.setVisible(true);
				this.setVisible(false);
			}

		} else if (shift == 0) {

			var checkintime1 = atdbao.checkcheckintime(idemp, today);
			DateTimeFormatter dateFormatter11 = DateTimeFormatter.ofPattern("HH");
			String a1 = checkintime1.format(dateFormatter11);
			var checkouttime1 = atdbao.checkcheckouttime(idemp, today);
			String b1 = checkouttime1.format(dateFormatter11);
			if (a1.equals("00") && b1.equals("00")) {
				atdbao.updatecheckin(nowtime, idemp, today);
				JOptionPane.showMessageDialog(this, "Attendance \"Check In\" successful");
				Main main = new Main();
				main.setVisible(true);
				this.setVisible(false);
			} else if (b1.equals("00") && !a1.equals("00")) {
				atdbao.updatecheckout(nowtime, idemp, today);
				JOptionPane.showMessageDialog(this, "Attendance \"Checked Out\" successful");
				Main main = new Main();
				main.setVisible(true);
				this.setVisible(false);
			} else if (!b1.equals("00") && !a1.equals("00")) {
				JOptionPane.showMessageDialog(this, "Attendance Checked Out");
				Main main = new Main();
				main.setVisible(true);
				this.setVisible(false);
			}
		}

	}
}
