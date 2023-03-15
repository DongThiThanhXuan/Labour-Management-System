package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.BuiltinFormats;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.mindrot.jbcrypt.BCrypt;

import com.toedter.calendar.JDateChooser;

import bao.*;
import entities.*;
import java.awt.GridLayout;
import javax.swing.border.EtchedBorder;

public class HR extends JFrame {
	private JMenuBar menuBar;
	private JMenu mnMainMenu;
	private JMenuItem mntmLogout;
	private JSplitPane splitPane;
	private JPanel panel_ControlButton;
	private JButton btn_AddNew;
	private JButton btnEmployee;
	private JButton btn_Salary;
	private JPanel panel;
	private JPanel panel_Employee;
	private JPanel panel_AddNew;
	private JPanel panel_Salary;
	private JScrollPane scrollPane;
	private final ButtonGroup buttonGroup_gender = new ButtonGroup();
	private JButton btnReport;
	private JPanel panel_Report;
	private JMenuItem mntmMyProfile;
	private Login login = new Login();
	private JTable table;
	private DepartmentBao depb = new DepartmentBao();
	private EmployeeBao empb = new EmployeeBao();
	private RelativesBao relb = new RelativesBao();
	private TypeaccountBao typeb = new TypeaccountBao();
	private Employee emp;
	private JPanel panel_relative;
	private JTextField txtIdemp;
	private JTextField txtName;
	private JTextField txtRelativeName;
	private JTextField txtPhone_1;
	private JButton btnNext;
	private JLabel lblFullname;
	private JTextField txtFullname;
	private JLabel lblAddress;
	private JTextField txtAddress;
	private JLabel lblGender;
	private JRadioButton rdbtnFemale;
	private JRadioButton rdbtnMale;
	private JLabel lblDOB;
	private JDateChooser dateChooser_DOB;
	private JLabel lblPhone;
	private JTextField txtPhone;
	private JLabel lblEmail;
	private JTextField txtEmail;
	private JLabel lblOnboard;
	private JDateChooser dateChooser_Onboard;
	private JLabel lblDepartment;
	private JComboBox comboBox_Dept;
	private JLabel lblcheckName;
	private JLabel lblcheckAddress;
	private JLabel lblcheckPhone;
	private JButton btnInsert;
	private JLabel lblcheckDob;
	private JLabel lblIDEmp;
	private JLabel lblEmpName;
	private JLabel lblName;
	private JLabel lblPhone_1;
	private JLabel lblRelation_1;
	private JTextField txtRelation;
	private JLabel lblcheckName_1;
	private JLabel lblcheckPhone_1;
	private JLabel lblcheckRelation_1;
	private JLabel lblUser;
	private JTextField txtUserName;
	private JLabel lblPassWord;
	private JPasswordField passwordField_PassWord;
	private JLabel lblConfPass;
	private JPasswordField passwordField_ConfPass;
	private JLabel lblType;
	private JComboBox comboBox_Type;
	private JLabel lblcheckUserName;
	private JLabel lblcheckPassWord;
	private JLabel lblcheckConfWord;
	private JLabel lblcheckEmail;
	private JPanel panel_1;
	private JLabel lblNewLabel_3;
	private JPanel panel_3;
	private JLabel lblNewLabel_2;
	private JLabel lblno_1;
	private JLabel lblno;
	private JLabel lblAttendance;
	private JLabel lblSalary;
	private JPanel panel_detailInfo;
	private JPanel panel_8;
	private JPanel panel_9;
	private JLabel lblID;
	private JTextField txtID_Info;
	private JLabel lblINameEmp;
	private JTextField txtName_info;
	private JDateChooser dateChooser_Dob;
	private JLabel lblDob;
	private JLabel lblAddress_Info;
	private JLabel lblGender_Info;
	private JTextField txtAddress_info;
	private JLabel lblCheckName_Info;
	private JLabel lblCheckDob_Info;
	private JLabel lblCheckAdd_Info;
	private JLabel lblMail;
	private JTextField txtEmail_info;
	private JLabel lblCheckMail_Info;
	private JLabel lblPhone_2;
	private JTextField txtPhone_Info;
	private JLabel lblCheckPhone_Info;
	private JLabel lblUserName;
	private JTextField txtUsername_Info;
	private JLabel lblType_1;
	private JComboBox comboBox_type;
	private JLabel lblDept;
	private JComboBox comboBox_dept;
	private JButton btnSave;
	private JLabel lblGender_Info_1;
	private JRadioButton rdbtn_SttAct;
	private JRadioButton rdbtn_Stt_Block;
	private final ButtonGroup buttonGroup_Stt = new ButtonGroup();
	private JButton btnReset;
	private JPanel panel_11;
	private JPanel panel_12;
	private JRadioButton rdbtnFemale_Info;
	private JRadioButton rdbtnMale_Info;
	private JButton btnEdit;
	private JLabel lblRelName;
	private JTextField txtRelName;
	private JLabel lblRelationship;
	private JTextField txtRelRelation;
	private JLabel lblPhone_3;
	private JTextField txtRelPhone_Info;
	private JLabel lblCheckRelName_Info;
	private JLabel lblCheckRelRelation_Info;
	private JPanel panel_10;
	private JButton btnReset_Rel;
	private JButton btnEdit_Rel;
	private JButton btnSave_Rel;
	private JPanel panel_13;
	private JLabel lblAnnualDate;
	private JLabel lblUL;
	private JLabel lblSL;
	private JLabel lbl_showAL;
	private JLabel lbl_showUL;
	private JLabel lbl_showSL;
	private JButton btnChangDept;
	private JTextField txtShowDep;
	private JButton btnAccept;
	private JTextField txtShowType;
	private JButton btnChange_2;
	private JButton btnAccept_2;
	private JLabel lblPass;
	private JPasswordField passwordField_NewPass;
	private JPanel panel_14;
	private final ButtonGroup buttonGroup_Gender_Info = new ButtonGroup();
	private JLabel lblOnboard_Info;
	private JDateChooser dateChooser_Onboard_Info;
	private JLabel lblcheckNewPass_Info;
	private JLabel lblCheckOndate_Info;
	private JPanel panel_15;
	private JLabel lblConfirm;
	private JPasswordField passwordField_ConfPass_Info;
	private JLabel lblcheckConfPass_Info;
	private JButton btnSave_Pass;
	private JPanel panel_16;
	private JPanel panel_17;
	private JButton btnChangeMail;
	private JButton btncheckChangeMail;
	private JPanel panel_18;
	private JButton btnChangePhone;
	private JButton btncheckChangePhone;
	private JPanel panel_19;
	private JButton btnUpdateRelPhone;
	private JButton btnChangeRelPhone;
	private JLabel lblCheckRelPhone_Info;
	private JPanel panel_20;
	private JPanel panel_6;
	private JLabel lblNewLabel_4;
	private JPanel panel_5;
	private JLabel lblNewLabel_1;
	private JPanel panel_7;
	private JLabel lblNewLabel_5;
	private JButton btnbackType;
	private JLabel lblBack;
	private JButton btnRequest;
	private JLabel lblRequest;
	private JPanel panel_Request;
	private JPanel panel_21;
	private JLabel lblNewLabel_7;
	private JComboBox comboBox_SearchDept;
	private JButton btnSortDept;
	private JTextField txtKey;
	private JLabel lblNewLabel_9;
	private JButton btnSearch;
	private JComboBox comboBox_fieldSearch;
	private JLabel lblNewLabel_8;
	private JComboBox comboBox_SortGender;
	private JButton btnNewButton;
	private final ButtonGroup buttonGroup_SortGender = new ButtonGroup();
	private JLabel lblfillSearch;
	private JComboBox comboBox_SortGender_Dept;
	private JPanel panel_22;
	private JPanel panel_23;
	private JLabel lblNewLabel_10;
	private JPanel panel_24;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_27;
	private JComboBox comboBox_MonthRp;
	private JComboBox comboBox_DeptReport;
	private JLabel lblNewLabel_13;
	private JPanel panel_29;
	private JLabel lblTotalEmp;
	private JPanel panel_30;
	private JLabel lblNewLabel_31;
	private JLabel lblTotalResult;
	private JLabel lblNewLabel_34;
	private JLabel lblName_Leave;
	private JLabel lblNewLabel_35;
	private JLabel lblDept_Leave;
	private JPanel panel_32;
	private JLabel lblNewLabel_36;
	private JLabel lblNewLabel_37;
	private JLabel lblNewLabel_38;
	private JLabel lblNewLabel_39;
	private JButton btnUpdate_Leave;
	private JLabel lblShowOnboard_Leave;
	private JLabel lblNewLabel_40;
	private JLabel lblNewLabel_41;
	private JLabel lblNewLabel_42;
	private JLabel lblNewLabel_43;
	private JScrollPane scrollPane_1;
	private JTable table_Request;
	private JLabel lblSalary_1;
	private JTextField txtSalary_Insert;
	private JLabel lblNewLabel_44;
	private JLabel lblcheckSalary;
	private JLabel lblShowAL_Leave;
	private JLabel lblShowSL_Leave;
	private JLabel lblShowUL_Leave;
	private JPanel panel_34;
	private JLabel lblNewLabel_32;
	private JLabel lblNewLabel_45;
	private JLabel lblNewLabel_46;
	private JLabel lblNewLabel_47;
	private JLabel lblShowAL_RQ;
	private JLabel lblShowId_RQ;
	private JLabel lblShowFrom_RQ;
	private JLabel lblShowTo_RQ;
	private JLabel lblShowSL_RQ;
	private JLabel lblShowUL_RQ;
	private JLabel lblNewLabel_33;
	private JLabel lblShowNote_RQ;
	private JComboBox comboBox_Adchoice;
	private JLabel lblNewLabel_48;
	private JLabel lblNewLabel_49;
	private JButton btnLogout;
	private JLabel lblLogOut;
	private JLabel lblFieldSearch;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JPanel panel_4;
	private JLabel lblShowName_Ad;
	private JPanel panel_28;
	private JLabel lblNewLabel_50;
	private JScrollPane scrollPane_3;
	private JTable table_Payroll;
	private JPanel panel_31;
	private JLabel lblNewLabel_51;
	private JLabel lbl;
	private JLabel lblName_Salary;
	private JLabel lblDept_1;
	private JLabel lblDept_Salary;
	private JLabel lblMonth_Salary;
	private JLabel lblIdEmployee;
	private JLabel lblId_Salary;
	private JPanel panel_33;
	private JLabel lblNewLabel_52;
	private JLabel lblNewLabel_53;
	private JLabel lblNewLabel_54;
	private JLabel lblNewLabel_55;
	private JPanel panel_35;
	private JLabel lblNewLabel_56;
	private JLabel lblNewLabel_57;
	private JLabel lblNewLabel_58;
	private JLabel lblNewLabel_59;
	private JPanel panel_36;
	private JLabel lblNewLabel_60;
	private JLabel lblNewLabel_61;
	private JLabel lblShowSDay_Sal;
	private JLabel lblShowAL_Sal;
	private JLabel lblShowUL_Sal;
	private JLabel lblShowSL_Sal;
	private JLabel lblShowLunch_Sal;
	private JLabel lblShowNight_Sal;
	private JLabel lblShowOffday_Sal;
	private JLabel lblShowHoli_Sal;
	private JLabel lblShowOT_Sal;
	private JLabel lblShowOTOff_Sal;
	private JPanel panel_37;
	private JLabel lblNewLabel_62;
	private JLabel lblNewLabel_63;
	private JLabel lblShowWKday_Sal;
	private JLabel lblNewLabel_65;
	private JLabel lblNewLabel_66;
	private JLabel lblNewLabel_67;
	private JLabel lblBasicSal;
	private JLabel lblMeal;
	private JLabel lblNight;
	private JLabel lblOT;
	private JLabel lblNewLabel_70;
	private JLabel lblTotal;
	private JPanel panel_41;
	private JLabel lblNewLabel_71;
	private JLabel lblNewLabel_72;
	private JLabel lblNewLabel_73;
	private JLabel lblDeduction;
	private JLabel lblInsurance;
	private JLabel lblTotalDeduc;
	private JPanel panel_43;
	private JLabel lblNewLabel_74;
	private JLabel lblNetPay;
	private JPanel panel_44;
	private JLabel lblNewLabel_75;
	private JComboBox comboBox_monthSal;
	private JButton btnCalSalary;
	private JPanel panel_38;
	private JLabel lblNewLabel_64;
	private JTextField txtSearch_Sal;
	private JComboBox comboBox_Field_Sal;
	private JButton btnSearch_Sal;
	private JComboBox comboBox_Dept_Sal;
	private JLabel lblNewLabel_69;
	private JComboBox comboBox_SortmonthSal;
	private JLabel lblNewLabel_76;
	private JLabel lblShowOTHoli_Sal;
	private JLabel lblNewLabel_77;
	private JDateChooser dateChooser_payday;
	private JButton btnUpdate_Payday;
	private JLabel lblNewLabel_78;
	private JComboBox comboBox_monthSal_1;
	private JLabel lblPayday;
	private JLabel lblPayday_Salary;
	private JLabel lblOnboard_Info_1;
	private JTextField txtBasicSal_Info;
	private JLabel lblOnboard_Info_2;
	private JLabel lblCheckSalary_Info;
	private JLabel lblNewLabel_79;
	private JLabel lblShowOToffHL_Sal;
	private JButton btnSort_Sal;
	private JLabel lblCheckSearch_sal;
	private JLabel lblNewLabel_6;
	private JPanel panel_40;
	private JTextField txtSearch_Rq;
	private JButton btnSearch_RQ;
	private JPanel panel_25;
	private JLabel lblCheckName_rq;
	private JLabel lblShowName_report;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_21;
	private JLabel lblNewLabel_22;
	private JLabel lblNewLabel_23;
	private JLabel lblNewLabel_25;
	private JLabel lblMonth_Dept;
	private JLabel lblTotalEmp_rp;
	private JLabel lblTotalMeal_rp;
	private JLabel lblTotalNight_rp;
	private JLabel lblTotalOTSal_rp;
	private JLabel lblTotalSal_rp;
	private JLabel lblTotalDeduc_rp;
	private JLabel lblTotalInsurance_rp;
	private JLabel lblTotalNetpay_rp;
	private JLabel lblAvgNetpay_rp;
	private JLabel lblHighNetpay_rp;
	private JLabel lblLowNetpay_rp;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_42;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_24;
	private JLabel lblNewLabel_28;
	private JPanel panel_45;
	private JScrollPane scrollPane_Report;
	private JLabel lblNewLabel_12;
	private JComboBox comboBox_SortSal;
	private JTable table_Report;
	private JComboBox comboBox_SortSal_month;
	private JButton btnExport_Report;
	private JLabel lblcheckOnboard;

	/**
	 * Launch the application.
	 */

//	public Login getLogin() {
//		return login;
//	}
//
//	public void setLogin(Login login) {
//		this.login = login;
//	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HR frame = new HR();
					frame.setVisible(true);
					frame.setSize(1368, 900);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HR() {
		ImageIcon addEmp_HR = new ImageIcon(HR.class.getResource("/Images/addEmp.png"), "add_HR");
		ImageIcon employee_HR = new ImageIcon(HR.class.getResource("/Images/emp-hr.png"), "emp_HR");
		ImageIcon salary_HR = new ImageIcon(HR.class.getResource("/Images/salary-hr.png"), "salary_HR");
		ImageIcon logout = new ImageIcon(HR.class.getResource("/Images/logout.png"), "logout");
		ImageIcon report_HR = new ImageIcon(HR.class.getResource("/Images/report.png"), "report");
		ImageIcon request = new ImageIcon(HR.class.getResource("/Images/request.png"), "request");
		ImageIcon backType = new ImageIcon(HR.class.getResource("/Images/back.png"), "backType");
		ImageIcon reset = new ImageIcon(HR.class.getResource("/Images/refresh.png"), "reset");
		ImageIcon save = new ImageIcon(HR.class.getResource("/Images/save-hr.png"), "save");
		ImageIcon edit = new ImageIcon(HR.class.getResource("/Images/edit.png"), "edit");
		ImageIcon change = new ImageIcon(HR.class.getResource("/Images/exchange1.png"), "changepass");
		ImageIcon search = new ImageIcon(HR.class.getResource("/Images/Search1.png"), "search");
		ImageIcon sort = new ImageIcon(HR.class.getResource("/Images/sorthr.png"), "sort");
		ImageIcon accept = new ImageIcon(HR.class.getResource("/Images/check.png"), "accept");
		ImageIcon next = new ImageIcon(HR.class.getResource("/Images/next.png"), "next");
		ImageIcon done = new ImageIcon(HR.class.getResource("/Images/checked.png"), "done");
		ImageIcon report = new ImageIcon(HR.class.getResource("/Images/reporthr.png"), "report");
		ImageIcon updateDay = new ImageIcon(HR.class.getResource("/Images/change-stt.png"), "search");
		ImageIcon export = new ImageIcon(HR.class.getResource("/Images/export.png"), "export");

		setTitle("HR Management");
		setBounds(100, 100, 1500, 930);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		splitPane = new JSplitPane();
		splitPane.setDoubleBuffered(true);
		splitPane.setDividerSize(5);
		splitPane.setIgnoreRepaint(true);
		splitPane.setInheritsPopupMenu(true);
		getContentPane().add(splitPane, BorderLayout.CENTER);

		panel_ControlButton = new JPanel();
		panel_ControlButton
				.setBorder(new CompoundBorder(new EmptyBorder(10, 10, 10, 10), new BevelBorder(BevelBorder.RAISED,
						new Color(0, 51, 204), new Color(0, 153, 255), new Color(0, 0, 204), new Color(0, 0, 102))));
		panel_ControlButton.setBackground(new Color(255, 255, 255));
		splitPane.setLeftComponent(panel_ControlButton);
		GridBagLayout gbl_panel_ControlButton = new GridBagLayout();
		gbl_panel_ControlButton.columnWidths = new int[] { 122, 0 };
		gbl_panel_ControlButton.rowHeights = new int[] { 25, 0, 43, 72, 43, 0, 43, 0, 44, 0, 42, 0, 43, 0, 43, 0 };
		gbl_panel_ControlButton.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_ControlButton.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_ControlButton.setLayout(gbl_panel_ControlButton);

		btn_AddNew = new JButton("", addEmp_HR);
		btn_AddNew.setBorder(null);
		btn_AddNew.setBackground(new Color(255, 255, 255));
		btn_AddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_AddNewActionPerformed(e);
			}
		});
		btnEmployee = new JButton("", employee_HR);
		btnEmployee.setBorder(null);
		btnEmployee.setBackground(new Color(255, 255, 255));
		btnEmployee.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEmployeeActionPerformed(e);
			}
		});

		GridBagConstraints gbc_btnEmployee = new GridBagConstraints();
		gbc_btnEmployee.insets = new Insets(0, 0, 5, 0);
		gbc_btnEmployee.fill = GridBagConstraints.VERTICAL;
		gbc_btnEmployee.gridx = 0;
		gbc_btnEmployee.gridy = 1;
		panel_ControlButton.add(btnEmployee, gbc_btnEmployee);

		lblno_1 = new JLabel("Employee");
		lblno_1.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblno_1 = new GridBagConstraints();
		gbc_lblno_1.anchor = GridBagConstraints.NORTH;
		gbc_lblno_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblno_1.gridx = 0;
		gbc_lblno_1.gridy = 2;
		panel_ControlButton.add(lblno_1, gbc_lblno_1);
		GridBagConstraints gbc_btn_AddNew = new GridBagConstraints();
		gbc_btn_AddNew.fill = GridBagConstraints.VERTICAL;
		gbc_btn_AddNew.insets = new Insets(0, 0, 5, 0);
		gbc_btn_AddNew.gridx = 0;
		gbc_btn_AddNew.gridy = 3;
		panel_ControlButton.add(btn_AddNew, gbc_btn_AddNew);

		lblno = new JLabel("New Employee");
		lblno.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblno = new GridBagConstraints();
		gbc_lblno.anchor = GridBagConstraints.NORTH;
		gbc_lblno.insets = new Insets(0, 0, 5, 0);
		gbc_lblno.gridx = 0;
		gbc_lblno.gridy = 4;
		panel_ControlButton.add(lblno, gbc_lblno);
		btn_Salary = new JButton("", salary_HR);
		btn_Salary.setBorder(null);
		btn_Salary.setBackground(new Color(255, 255, 255));
		btn_Salary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_SalaryActionPerformed(e);
			}
		});

		btnRequest = new JButton("", request);
		btnRequest.setBorder(null);
		btnRequest.setBackground(new Color(255, 255, 255));
		btnRequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnRequestActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnRequest = new GridBagConstraints();
		gbc_btnRequest.insets = new Insets(0, 0, 5, 0);
		gbc_btnRequest.gridx = 0;
		gbc_btnRequest.gridy = 5;
		panel_ControlButton.add(btnRequest, gbc_btnRequest);

		lblRequest = new JLabel("Request");
		lblRequest.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblRequest = new GridBagConstraints();
		gbc_lblRequest.anchor = GridBagConstraints.NORTH;
		gbc_lblRequest.insets = new Insets(0, 0, 5, 0);
		gbc_lblRequest.gridx = 0;
		gbc_lblRequest.gridy = 6;
		panel_ControlButton.add(lblRequest, gbc_lblRequest);
		GridBagConstraints gbc_btn_Salary = new GridBagConstraints();
		gbc_btn_Salary.insets = new Insets(0, 0, 5, 0);
		gbc_btn_Salary.fill = GridBagConstraints.VERTICAL;
		gbc_btn_Salary.gridx = 0;
		gbc_btn_Salary.gridy = 7;
		panel_ControlButton.add(btn_Salary, gbc_btn_Salary);

		lblSalary = new JLabel("Payroll");
		lblSalary.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblSalary = new GridBagConstraints();
		gbc_lblSalary.insets = new Insets(0, 0, 5, 0);
		gbc_lblSalary.anchor = GridBagConstraints.NORTH;
		gbc_lblSalary.gridx = 0;
		gbc_lblSalary.gridy = 8;
		panel_ControlButton.add(lblSalary, gbc_lblSalary);

		btnbackType = new JButton("", backType);
		btnbackType.setBorder(null);
		btnbackType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnbackTypeActionPerformed(e);
			}
		});
		btnReport = new JButton("", report_HR);
		btnReport.setBorder(null);
		btnReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnreportActionPerformed(e);
			}
		});
		btnReport.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnReport = new GridBagConstraints();
		gbc_btnReport.fill = GridBagConstraints.VERTICAL;
		gbc_btnReport.insets = new Insets(0, 0, 5, 0);
		gbc_btnReport.gridx = 0;
		gbc_btnReport.gridy = 9;
		panel_ControlButton.add(btnReport, gbc_btnReport);

		lblAttendance = new JLabel("Report");
		lblAttendance.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblAttendance = new GridBagConstraints();
		gbc_lblAttendance.anchor = GridBagConstraints.NORTH;
		gbc_lblAttendance.insets = new Insets(0, 0, 5, 0);
		gbc_lblAttendance.gridx = 0;
		gbc_lblAttendance.gridy = 10;
		panel_ControlButton.add(lblAttendance, gbc_lblAttendance);
		btnbackType.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnbackType = new GridBagConstraints();
		gbc_btnbackType.insets = new Insets(0, 0, 5, 0);
		gbc_btnbackType.gridx = 0;
		gbc_btnbackType.gridy = 11;
		panel_ControlButton.add(btnbackType, gbc_btnbackType);

		lblBack = new JLabel("Back");
		lblBack.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblBack = new GridBagConstraints();
		gbc_lblBack.insets = new Insets(0, 0, 5, 0);
		gbc_lblBack.anchor = GridBagConstraints.NORTH;
		gbc_lblBack.gridx = 0;
		gbc_lblBack.gridy = 12;
		panel_ControlButton.add(lblBack, gbc_lblBack);

		btnLogout = new JButton("", logout);
		btnLogout.setBorder(null);
		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogoutActionPerformed(e);
			}
		});
		btnLogout.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_btnLogout = new GridBagConstraints();
		gbc_btnLogout.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogout.gridx = 0;
		gbc_btnLogout.gridy = 13;
		panel_ControlButton.add(btnLogout, gbc_btnLogout);

		lblLogOut = new JLabel("Log out");
		lblLogOut.setFont(new Font("Serif", Font.BOLD, 16));
		GridBagConstraints gbc_lblLogOut = new GridBagConstraints();
		gbc_lblLogOut.anchor = GridBagConstraints.NORTH;
		gbc_lblLogOut.gridx = 0;
		gbc_lblLogOut.gridy = 14;
		panel_ControlButton.add(lblLogOut, gbc_lblLogOut);

		panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(new CardLayout(0, 0));

		panel_Employee = new JPanel();
		panel_Employee.setBackground(new Color(255, 255, 255));
		panel.add(panel_Employee, "employee");
		GridBagLayout gbl_panel_Employee = new GridBagLayout();
		gbl_panel_Employee.columnWidths = new int[] { 61, 85, 219, 207, 315, 338, 71, 0 };
		gbl_panel_Employee.rowHeights = new int[] { 90, 71, 79, 52, 124, 47, 179, 131, 0, 0 };
		gbl_panel_Employee.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Employee.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_Employee.setLayout(gbl_panel_Employee);

		panel_6 = new GradientPanel(Color.white, new Color(0, 160, 255), 3);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.gridwidth = 7;
		gbc_panel_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_Employee.add(panel_6, gbc_panel_6);
		panel_6.setLayout(new BorderLayout(0, 0));

		lblNewLabel_4 = new JLabel("HR MANAGEMENT");
		lblNewLabel_4.setBorder(null);
		lblNewLabel_4.setForeground(new Color(255, 255, 204));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_6.add(lblNewLabel_4, BorderLayout.CENTER);

		panel_21 = new JPanel();
		panel_21.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_21 = new GridBagConstraints();
		gbc_panel_21.gridwidth = 5;
		gbc_panel_21.insets = new Insets(0, 0, 5, 5);
		gbc_panel_21.fill = GridBagConstraints.BOTH;
		gbc_panel_21.gridx = 1;
		gbc_panel_21.gridy = 2;
		panel_Employee.add(panel_21, gbc_panel_21);
		GridBagLayout gbl_panel_21 = new GridBagLayout();
		gbl_panel_21.columnWidths = new int[] { 86, 161, 118, 56, 73, 0, 24, 0, 130, 130, 0, 0 };
		gbl_panel_21.rowHeights = new int[] { 50, 0, 0 };
		gbl_panel_21.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_21.rowWeights = new double[] { 1.0, 0.0, Double.MIN_VALUE };
		panel_21.setLayout(gbl_panel_21);

		lblNewLabel_9 = new JLabel("Search:");
		lblNewLabel_9.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 0;
		panel_21.add(lblNewLabel_9, gbc_lblNewLabel_9);

		comboBox_fieldSearch = new JComboBox();
		comboBox_fieldSearch.setModel(new DefaultComboBoxModel(
				new String[] { "ID", "Fullname", "Username", "DOB (M & Y)", "Onboard (M & Y)", "Phone", "Address" }));
		comboBox_fieldSearch.setFont(new Font("Serif", Font.PLAIN, 18));

		GridBagConstraints gbc_comboBox_fieldSearch = new GridBagConstraints();
		gbc_comboBox_fieldSearch.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_fieldSearch.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_fieldSearch.gridx = 1;
		gbc_comboBox_fieldSearch.gridy = 0;
		panel_21.add(comboBox_fieldSearch, gbc_comboBox_fieldSearch);

		txtKey = new JTextField();
		txtKey.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 204), new Color(0, 51, 153)));
		txtKey.setFont(new Font("Serif", Font.PLAIN, 18));
		GridBagConstraints gbc_txtKey = new GridBagConstraints();
		gbc_txtKey.gridwidth = 3;
		gbc_txtKey.insets = new Insets(0, 0, 5, 5);
		gbc_txtKey.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKey.gridx = 2;
		gbc_txtKey.gridy = 0;
		panel_21.add(txtKey, gbc_txtKey);
		txtKey.setColumns(10);

		btnSearch = new JButton("", search);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch.gridx = 5;
		gbc_btnSearch.gridy = 0;
		panel_21.add(btnSearch, gbc_btnSearch);

		lblNewLabel_7 = new JLabel("Department:");
		lblNewLabel_7.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.gridx = 7;
		gbc_lblNewLabel_7.gridy = 0;
		panel_21.add(lblNewLabel_7, gbc_lblNewLabel_7);

		comboBox_SearchDept = new JComboBox();
		comboBox_SearchDept.setFont(new Font("Serif", Font.PLAIN, 18));
		loadDataDeptSearch();
		GridBagConstraints gbc_comboBox_SearchDept = new GridBagConstraints();
		gbc_comboBox_SearchDept.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_SearchDept.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_SearchDept.gridx = 8;
		gbc_comboBox_SearchDept.gridy = 0;
		panel_21.add(comboBox_SearchDept, gbc_comboBox_SearchDept);

		btnSortDept = new JButton("", sort);
		btnSortDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearchDeptActionPerformed(e);
			}
		});

		comboBox_SortGender_Dept = new JComboBox();
		comboBox_SortGender_Dept.setModel(new DefaultComboBoxModel(new String[] { "All", "Female", "Male" }));
		comboBox_SortGender_Dept.setFont(new Font("Serif", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBox_SortGender_Dept = new GridBagConstraints();
		gbc_comboBox_SortGender_Dept.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_SortGender_Dept.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_SortGender_Dept.gridx = 9;
		gbc_comboBox_SortGender_Dept.gridy = 0;
		panel_21.add(comboBox_SortGender_Dept, gbc_comboBox_SortGender_Dept);
		GridBagConstraints gbc_btnSortDept = new GridBagConstraints();
		gbc_btnSortDept.insets = new Insets(0, 0, 5, 0);
		gbc_btnSortDept.gridx = 10;
		gbc_btnSortDept.gridy = 0;
		panel_21.add(btnSortDept, gbc_btnSortDept);

		lblfillSearch = new JLabel("");
		lblfillSearch.setForeground(Color.RED);
		lblfillSearch.setFont(new Font("Sitka Text", Font.PLAIN, 18));
		GridBagConstraints gbc_lblfillSearch = new GridBagConstraints();
		gbc_lblfillSearch.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblfillSearch.gridwidth = 3;
		gbc_lblfillSearch.insets = new Insets(0, 0, 0, 5);
		gbc_lblfillSearch.gridx = 2;
		gbc_lblfillSearch.gridy = 1;
		panel_21.add(lblfillSearch, gbc_lblfillSearch);

		lblNewLabel_8 = new JLabel("Gender:");
		lblNewLabel_8.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.gridx = 7;
		gbc_lblNewLabel_8.gridy = 1;
		panel_21.add(lblNewLabel_8, gbc_lblNewLabel_8);

		comboBox_SortGender = new JComboBox();
		comboBox_SortGender.setModel(new DefaultComboBoxModel(new String[] { "All", "Female", "Male" }));
		comboBox_SortGender.setFont(new Font("Serif", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBox_SortGender = new GridBagConstraints();
		gbc_comboBox_SortGender.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_SortGender.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_SortGender.gridx = 8;
		gbc_comboBox_SortGender.gridy = 1;
		panel_21.add(comboBox_SortGender, gbc_comboBox_SortGender);

		btnNewButton = new JButton("", sort);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.WEST;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 9;
		gbc_btnNewButton.gridy = 1;
		panel_21.add(btnNewButton, gbc_btnNewButton);

		panel_29 = new JPanel();
		panel_29.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_29 = new GridBagConstraints();
		gbc_panel_29.gridwidth = 2;
		gbc_panel_29.insets = new Insets(0, 0, 5, 5);
		gbc_panel_29.fill = GridBagConstraints.BOTH;
		gbc_panel_29.gridx = 1;
		gbc_panel_29.gridy = 3;
		panel_Employee.add(panel_29, gbc_panel_29);
		GridBagLayout gbl_panel_29 = new GridBagLayout();
		gbl_panel_29.columnWidths = new int[] { 0, 102, 0 };
		gbl_panel_29.rowHeights = new int[] { 48, 0 };
		gbl_panel_29.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_29.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_29.setLayout(gbl_panel_29);

		lblNewLabel_13 = new JLabel("Total Employee:");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 0;
		panel_29.add(lblNewLabel_13, gbc_lblNewLabel_13);
		lblNewLabel_13.setFont(new Font("Serif", Font.BOLD, 20));

		lblTotalEmp = new JLabel("");
		lblTotalEmp.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTotalEmp = new GridBagConstraints();
		gbc_lblTotalEmp.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTotalEmp.gridx = 1;
		gbc_lblTotalEmp.gridy = 0;
		panel_29.add(lblTotalEmp, gbc_lblTotalEmp);

		panel_30 = new JPanel();
		panel_30.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_30 = new GridBagConstraints();
		gbc_panel_30.anchor = GridBagConstraints.SOUTHEAST;
		gbc_panel_30.insets = new Insets(0, 0, 5, 5);
		gbc_panel_30.gridx = 5;
		gbc_panel_30.gridy = 3;
		panel_Employee.add(panel_30, gbc_panel_30);
		GridBagLayout gbl_panel_30 = new GridBagLayout();
		gbl_panel_30.columnWidths = new int[] { 130, 62, 0 };
		gbl_panel_30.rowHeights = new int[] { 48, 0 };
		gbl_panel_30.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_30.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_30.setLayout(gbl_panel_30);

		lblNewLabel_31 = new JLabel("Total result:");
		lblNewLabel_31.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_31 = new GridBagConstraints();
		gbc_lblNewLabel_31.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_31.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_31.gridx = 0;
		gbc_lblNewLabel_31.gridy = 0;
		panel_30.add(lblNewLabel_31, gbc_lblNewLabel_31);

		lblTotalResult = new JLabel("");
		lblTotalResult.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTotalResult = new GridBagConstraints();
		gbc_lblTotalResult.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblTotalResult.gridx = 1;
		gbc_lblTotalResult.gridy = 0;
		panel_30.add(lblTotalResult, gbc_lblTotalResult);

		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 3;
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 4;
		panel_Employee.add(scrollPane, gbc_scrollPane);

		table = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(220, 220, 220);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		table.setForeground(Color.BLACK);
		TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		table.setFont(new Font("Serif", Font.PLAIN, 20));
		table.getTableHeader().setFont(new Font("Serif", Font.BOLD, 20));
		table.setRowHeight(table.getRowHeight() + 15);
		table.setShowGrid(true);
		table.setBackground(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tableMousePressed(e);
			}
		});
		scrollPane.setViewportView(table);
		table.setAutoCreateRowSorter(true);
		panel_detailInfo = new JPanel();
		panel_detailInfo.setBackground(new Color(255, 255, 255));
		panel.add(panel_detailInfo, "detailInfo");
		GridBagLayout gbl_panel_detailInfo = new GridBagLayout();
		gbl_panel_detailInfo.columnWidths = new int[] { 698, 114, 476, 0 };
		gbl_panel_detailInfo.rowHeights = new int[] { 80, 194, 251, 102, 0 };
		gbl_panel_detailInfo.columnWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_detailInfo.rowWeights = new double[] { 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel_detailInfo.setLayout(gbl_panel_detailInfo);

		panel_20 = new JPanel();
		panel_20 = new GradientPanel(Color.white, new Color(0, 160, 255), 3);
		panel_20.setBackground(new Color(0, 204, 255));
		GridBagConstraints gbc_panel_20 = new GridBagConstraints();
		gbc_panel_20.gridwidth = 3;
		gbc_panel_20.insets = new Insets(0, 0, 5, 0);
		gbc_panel_20.fill = GridBagConstraints.BOTH;
		gbc_panel_20.gridx = 0;
		gbc_panel_20.gridy = 0;
		panel_detailInfo.add(panel_20, gbc_panel_20);
		panel_20.setLayout(new BorderLayout(0, 0));

		lblNewLabel_6 = new JLabel("HR MANAGEMENT");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(new Color(255, 255, 204));
		panel_20.add(lblNewLabel_6, BorderLayout.CENTER);

		panel_8 = new JPanel();
		panel_8.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new TitledBorder(null, "Employee Info",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		panel_8.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.gridheight = 3;
		gbc_panel_8.insets = new Insets(0, 0, 0, 5);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 1;
		panel_detailInfo.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[] { 96, 186, 65, 160, 35, 0 };
		gbl_panel_8.rowHeights = new int[] { 45, 40, 25, 35, 35, 35, 35, 35, 30, 35, 35, 35, 35, 35, 35, 35, 35, 40, 40,
				30, 0 };
		gbl_panel_8.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_8.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_8.setLayout(gbl_panel_8);

		lblID = new JLabel("ID Emp:");
		lblID.setForeground(new Color(51, 51, 255));
		lblID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblID = new GridBagConstraints();
		gbc_lblID.insets = new Insets(0, 0, 5, 5);
		gbc_lblID.anchor = GridBagConstraints.EAST;
		gbc_lblID.gridx = 0;
		gbc_lblID.gridy = 0;
		panel_8.add(lblID, gbc_lblID);

		txtID_Info = new JTextField();
		txtID_Info.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		txtID_Info.setEditable(false);
		txtID_Info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_txtID_Info = new GridBagConstraints();
		gbc_txtID_Info.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtID_Info.insets = new Insets(0, 0, 5, 5);
		gbc_txtID_Info.gridx = 1;
		gbc_txtID_Info.gridy = 0;
		panel_8.add(txtID_Info, gbc_txtID_Info);
		txtID_Info.setColumns(10);

		lblDept = new JLabel("Dept:");
		lblDept.setForeground(new Color(51, 51, 255));
		lblDept.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblDept = new GridBagConstraints();
		gbc_lblDept.anchor = GridBagConstraints.EAST;
		gbc_lblDept.insets = new Insets(0, 0, 5, 5);
		gbc_lblDept.gridx = 2;
		gbc_lblDept.gridy = 0;
		panel_8.add(lblDept, gbc_lblDept);

		btnChangDept = new JButton("", change);
		btnChangDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChangDeptActionPerformed(e);
			}
		});

		txtShowDep = new JTextField();
		txtShowDep.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtShowDep.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_txtShowDep = new GridBagConstraints();
		gbc_txtShowDep.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowDep.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowDep.gridx = 3;
		gbc_txtShowDep.gridy = 0;
		panel_8.add(txtShowDep, gbc_txtShowDep);
		txtShowDep.setEditable(false);
		txtShowDep.setColumns(10);
		GridBagConstraints gbc_btnChangDept = new GridBagConstraints();
		gbc_btnChangDept.insets = new Insets(0, 0, 5, 0);
		gbc_btnChangDept.gridx = 4;
		gbc_btnChangDept.gridy = 0;
		panel_8.add(btnChangDept, gbc_btnChangDept);

		comboBox_dept = new JComboBox();
		comboBox_dept.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		loadDataDeptInfo();
		GridBagConstraints gbc_comboBox_dept = new GridBagConstraints();
		gbc_comboBox_dept.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_dept.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_dept.gridx = 3;
		gbc_comboBox_dept.gridy = 1;
		panel_8.add(comboBox_dept, gbc_comboBox_dept);
		comboBox_dept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_deptActionPerformed(e);
			}
		});

		btnAccept = new JButton("", accept);
		btnAccept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAccActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnAccept = new GridBagConstraints();
		gbc_btnAccept.insets = new Insets(0, 0, 5, 0);
		gbc_btnAccept.gridx = 4;
		gbc_btnAccept.gridy = 1;
		panel_8.add(btnAccept, gbc_btnAccept);

		lblOnboard_Info = new JLabel("Onboard date:");
		lblOnboard_Info.setForeground(new Color(51, 51, 255));
		lblOnboard_Info.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblOnboard_Info = new GridBagConstraints();
		gbc_lblOnboard_Info.anchor = GridBagConstraints.EAST;
		gbc_lblOnboard_Info.insets = new Insets(0, 0, 5, 5);
		gbc_lblOnboard_Info.gridx = 0;
		gbc_lblOnboard_Info.gridy = 2;
		panel_8.add(lblOnboard_Info, gbc_lblOnboard_Info);

		dateChooser_Onboard_Info = new JDateChooser();
		dateChooser_Onboard_Info.setDateFormatString("yyyy-MM-dd");
		dateChooser_Onboard_Info.setEnabled(false);
		dateChooser_Onboard_Info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_dateChooser_Onboard_Info = new GridBagConstraints();
		gbc_dateChooser_Onboard_Info.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_Onboard_Info.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_Onboard_Info.gridx = 1;
		gbc_dateChooser_Onboard_Info.gridy = 2;
		panel_8.add(dateChooser_Onboard_Info, gbc_dateChooser_Onboard_Info);

		lblCheckOndate_Info = new JLabel("");
		lblCheckOndate_Info.setForeground(new Color(255, 0, 0));
		lblCheckOndate_Info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCheckOndate_Info = new GridBagConstraints();
		gbc_lblCheckOndate_Info.anchor = GridBagConstraints.WEST;
		gbc_lblCheckOndate_Info.gridwidth = 3;
		gbc_lblCheckOndate_Info.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckOndate_Info.gridx = 1;
		gbc_lblCheckOndate_Info.gridy = 3;
		panel_8.add(lblCheckOndate_Info, gbc_lblCheckOndate_Info);

		lblINameEmp = new JLabel("Fullname:");
		lblINameEmp.setForeground(new Color(51, 51, 255));
		lblINameEmp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblINameEmp = new GridBagConstraints();
		gbc_lblINameEmp.anchor = GridBagConstraints.EAST;
		gbc_lblINameEmp.insets = new Insets(0, 0, 5, 5);
		gbc_lblINameEmp.gridx = 0;
		gbc_lblINameEmp.gridy = 4;
		panel_8.add(lblINameEmp, gbc_lblINameEmp);

		txtName_info = new JTextField();
		txtName_info.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtName_info.setEditable(false);
		txtName_info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtName_info.setColumns(10);
		GridBagConstraints gbc_txtName_info = new GridBagConstraints();
		gbc_txtName_info.insets = new Insets(0, 0, 5, 5);
		gbc_txtName_info.gridwidth = 2;
		gbc_txtName_info.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName_info.gridx = 1;
		gbc_txtName_info.gridy = 4;
		panel_8.add(txtName_info, gbc_txtName_info);

		lblCheckName_Info = new JLabel("");
		lblCheckName_Info.setForeground(new Color(255, 0, 0));
		lblCheckName_Info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCheckName_Info = new GridBagConstraints();
		gbc_lblCheckName_Info.gridwidth = 5;
		gbc_lblCheckName_Info.insets = new Insets(0, 0, 5, 0);
		gbc_lblCheckName_Info.gridx = 0;
		gbc_lblCheckName_Info.gridy = 5;
		panel_8.add(lblCheckName_Info, gbc_lblCheckName_Info);

		lblOnboard_Info_1 = new JLabel("Basic salary:");
		lblOnboard_Info_1.setForeground(new Color(51, 51, 255));
		lblOnboard_Info_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblOnboard_Info_1 = new GridBagConstraints();
		gbc_lblOnboard_Info_1.anchor = GridBagConstraints.EAST;
		gbc_lblOnboard_Info_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblOnboard_Info_1.gridx = 0;
		gbc_lblOnboard_Info_1.gridy = 6;
		panel_8.add(lblOnboard_Info_1, gbc_lblOnboard_Info_1);

		txtBasicSal_Info = new JTextField();
		txtBasicSal_Info.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtBasicSal_Info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtBasicSal_Info.setEditable(false);
		txtBasicSal_Info.setColumns(10);
		GridBagConstraints gbc_txtBasicSal_Info = new GridBagConstraints();
		gbc_txtBasicSal_Info.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtBasicSal_Info.insets = new Insets(0, 0, 5, 5);
		gbc_txtBasicSal_Info.gridx = 1;
		gbc_txtBasicSal_Info.gridy = 6;
		panel_8.add(txtBasicSal_Info, gbc_txtBasicSal_Info);

		lblOnboard_Info_2 = new JLabel("VND");
		lblOnboard_Info_2.setForeground(Color.BLACK);
		lblOnboard_Info_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblOnboard_Info_2 = new GridBagConstraints();
		gbc_lblOnboard_Info_2.anchor = GridBagConstraints.WEST;
		gbc_lblOnboard_Info_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblOnboard_Info_2.gridx = 2;
		gbc_lblOnboard_Info_2.gridy = 6;
		panel_8.add(lblOnboard_Info_2, gbc_lblOnboard_Info_2);

		lblCheckSalary_Info = new JLabel("");
		lblCheckSalary_Info.setForeground(Color.RED);
		lblCheckSalary_Info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCheckSalary_Info = new GridBagConstraints();
		gbc_lblCheckSalary_Info.anchor = GridBagConstraints.WEST;
		gbc_lblCheckSalary_Info.gridwidth = 2;
		gbc_lblCheckSalary_Info.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckSalary_Info.gridx = 1;
		gbc_lblCheckSalary_Info.gridy = 7;
		panel_8.add(lblCheckSalary_Info, gbc_lblCheckSalary_Info);

		lblDob = new JLabel("DOB:");
		lblDob.setForeground(new Color(51, 51, 255));
		lblDob.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblDob = new GridBagConstraints();
		gbc_lblDob.anchor = GridBagConstraints.EAST;
		gbc_lblDob.insets = new Insets(0, 0, 5, 5);
		gbc_lblDob.gridx = 0;
		gbc_lblDob.gridy = 8;
		panel_8.add(lblDob, gbc_lblDob);

		dateChooser_Dob = new JDateChooser();
		dateChooser_Dob.setDateFormatString("yyyy-MM-dd");
		dateChooser_Dob.setEnabled(false);
		dateChooser_Dob.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_dateChooser_Dob = new GridBagConstraints();
		gbc_dateChooser_Dob.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_Dob.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_Dob.gridx = 1;
		gbc_dateChooser_Dob.gridy = 8;
		panel_8.add(dateChooser_Dob, gbc_dateChooser_Dob);

		lblGender_Info = new JLabel("Gender:");
		lblGender_Info.setForeground(new Color(51, 51, 255));
		lblGender_Info.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblGender_Info = new GridBagConstraints();
		gbc_lblGender_Info.anchor = GridBagConstraints.EAST;
		gbc_lblGender_Info.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender_Info.gridx = 2;
		gbc_lblGender_Info.gridy = 8;
		panel_8.add(lblGender_Info, gbc_lblGender_Info);

		panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.gridwidth = 2;
		gbc_panel_12.insets = new Insets(0, 0, 5, 0);
		gbc_panel_12.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_12.gridx = 3;
		gbc_panel_12.gridy = 8;
		panel_8.add(panel_12, gbc_panel_12);
		GridBagLayout gbl_panel_12 = new GridBagLayout();
		gbl_panel_12.columnWidths = new int[] { 94, 78, 0 };
		gbl_panel_12.rowHeights = new int[] { 0, 0 };
		gbl_panel_12.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_12.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_12.setLayout(gbl_panel_12);

		rdbtnFemale_Info = new JRadioButton("Female");
		rdbtnFemale_Info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		buttonGroup_Gender_Info.add(rdbtnFemale_Info);
		GridBagConstraints gbc_rdbtnFemale_Info = new GridBagConstraints();
		gbc_rdbtnFemale_Info.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnFemale_Info.gridx = 0;
		gbc_rdbtnFemale_Info.gridy = 0;
		panel_12.add(rdbtnFemale_Info, gbc_rdbtnFemale_Info);

		rdbtnMale_Info = new JRadioButton("Male");
		rdbtnMale_Info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		buttonGroup_Gender_Info.add(rdbtnMale_Info);
		GridBagConstraints gbc_rdbtnMale_Info = new GridBagConstraints();
		gbc_rdbtnMale_Info.gridx = 1;
		gbc_rdbtnMale_Info.gridy = 0;
		panel_12.add(rdbtnMale_Info, gbc_rdbtnMale_Info);

		lblCheckDob_Info = new JLabel("");
		lblCheckDob_Info.setForeground(new Color(255, 0, 0));
		lblCheckDob_Info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCheckDob_Info = new GridBagConstraints();
		gbc_lblCheckDob_Info.anchor = GridBagConstraints.WEST;
		gbc_lblCheckDob_Info.gridwidth = 3;
		gbc_lblCheckDob_Info.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckDob_Info.gridx = 1;
		gbc_lblCheckDob_Info.gridy = 9;
		panel_8.add(lblCheckDob_Info, gbc_lblCheckDob_Info);

		lblAddress_Info = new JLabel("Address:");
		lblAddress_Info.setForeground(new Color(51, 51, 255));
		lblAddress_Info.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddress_Info = new GridBagConstraints();
		gbc_lblAddress_Info.anchor = GridBagConstraints.EAST;
		gbc_lblAddress_Info.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress_Info.gridx = 0;
		gbc_lblAddress_Info.gridy = 10;
		panel_8.add(lblAddress_Info, gbc_lblAddress_Info);

		txtAddress_info = new JTextField();
		txtAddress_info.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtAddress_info.setBackground(Color.WHITE);
		txtAddress_info.setEditable(false);
		txtAddress_info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtAddress_info.setColumns(10);
		GridBagConstraints gbc_txtAddress_info = new GridBagConstraints();
		gbc_txtAddress_info.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddress_info.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddress_info.gridwidth = 2;
		gbc_txtAddress_info.gridx = 1;
		gbc_txtAddress_info.gridy = 10;
		panel_8.add(txtAddress_info, gbc_txtAddress_info);

		lblCheckAdd_Info = new JLabel("");
		lblCheckAdd_Info.setForeground(new Color(255, 0, 0));
		lblCheckAdd_Info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCheckAdd_Info = new GridBagConstraints();
		gbc_lblCheckAdd_Info.insets = new Insets(0, 0, 5, 0);
		gbc_lblCheckAdd_Info.gridwidth = 5;
		gbc_lblCheckAdd_Info.gridx = 0;
		gbc_lblCheckAdd_Info.gridy = 11;
		panel_8.add(lblCheckAdd_Info, gbc_lblCheckAdd_Info);

		lblMail = new JLabel("E-mail:");
		lblMail.setForeground(new Color(51, 51, 255));
		lblMail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblMail = new GridBagConstraints();
		gbc_lblMail.anchor = GridBagConstraints.EAST;
		gbc_lblMail.insets = new Insets(0, 0, 5, 5);
		gbc_lblMail.gridx = 0;
		gbc_lblMail.gridy = 12;
		panel_8.add(lblMail, gbc_lblMail);

		txtEmail_info = new JTextField();
		txtEmail_info.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtEmail_info.setEditable(false);
		txtEmail_info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEmail_info.setColumns(10);
		GridBagConstraints gbc_txtEmail_info = new GridBagConstraints();
		gbc_txtEmail_info.gridwidth = 2;
		gbc_txtEmail_info.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail_info.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail_info.gridx = 1;
		gbc_txtEmail_info.gridy = 12;
		panel_8.add(txtEmail_info, gbc_txtEmail_info);

		panel_17 = new JPanel();
		panel_17.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.insets = new Insets(0, 0, 5, 5);
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 3;
		gbc_panel_17.gridy = 12;
		panel_8.add(panel_17, gbc_panel_17);
		GridBagLayout gbl_panel_17 = new GridBagLayout();
		gbl_panel_17.columnWidths = new int[] { 49, 0, 0 };
		gbl_panel_17.rowHeights = new int[] { 28, 0 };
		gbl_panel_17.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_17.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_17.setLayout(gbl_panel_17);
		btnChangeMail = new JButton("", change);
		btnChangeMail.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnChangeMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChangeMailActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnChangeMail = new GridBagConstraints();
		gbc_btnChangeMail.insets = new Insets(0, 0, 0, 5);
		gbc_btnChangeMail.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnChangeMail.gridx = 0;
		gbc_btnChangeMail.gridy = 0;
		panel_17.add(btnChangeMail, gbc_btnChangeMail);
		btncheckChangeMail = new JButton("", accept);
		btncheckChangeMail.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btncheckChangeMail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btncheckChangeMailActionPerformed(e);
			}
		});
		btncheckChangeMail.setVisible(false);
		GridBagConstraints gbc_btncheckChangeMail = new GridBagConstraints();
		gbc_btncheckChangeMail.gridx = 1;
		gbc_btncheckChangeMail.gridy = 0;
		panel_17.add(btncheckChangeMail, gbc_btncheckChangeMail);

		lblCheckMail_Info = new JLabel("");
		lblCheckMail_Info.setForeground(new Color(255, 0, 0));
		lblCheckMail_Info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCheckMail_Info = new GridBagConstraints();
		gbc_lblCheckMail_Info.anchor = GridBagConstraints.WEST;
		gbc_lblCheckMail_Info.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckMail_Info.gridwidth = 3;
		gbc_lblCheckMail_Info.gridx = 1;
		gbc_lblCheckMail_Info.gridy = 13;
		panel_8.add(lblCheckMail_Info, gbc_lblCheckMail_Info);

		lblPhone_2 = new JLabel("Phone:");
		lblPhone_2.setForeground(new Color(51, 51, 255));
		lblPhone_2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblPhone_2 = new GridBagConstraints();
		gbc_lblPhone_2.anchor = GridBagConstraints.EAST;
		gbc_lblPhone_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone_2.gridx = 0;
		gbc_lblPhone_2.gridy = 14;
		panel_8.add(lblPhone_2, gbc_lblPhone_2);

		txtPhone_Info = new JTextField();
		txtPhone_Info.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPhone_Info.setEditable(false);
		txtPhone_Info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPhone_Info.setColumns(10);
		GridBagConstraints gbc_txtPhone_Info = new GridBagConstraints();
		gbc_txtPhone_Info.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone_Info.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone_Info.gridx = 1;
		gbc_txtPhone_Info.gridy = 14;
		panel_8.add(txtPhone_Info, gbc_txtPhone_Info);

		panel_18 = new JPanel();
		panel_18.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.gridwidth = 2;
		gbc_panel_18.insets = new Insets(0, 0, 5, 5);
		gbc_panel_18.fill = GridBagConstraints.BOTH;
		gbc_panel_18.gridx = 2;
		gbc_panel_18.gridy = 14;
		panel_8.add(panel_18, gbc_panel_18);
		GridBagLayout gbl_panel_18 = new GridBagLayout();
		gbl_panel_18.columnWidths = new int[] { 49, 0, 0 };
		gbl_panel_18.rowHeights = new int[] { 28, 0 };
		gbl_panel_18.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_18.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_18.setLayout(gbl_panel_18);

		btnChangePhone = new JButton("", change);
		btnChangePhone.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btnChangePhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChangePhoneActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnChangePhone = new GridBagConstraints();
		gbc_btnChangePhone.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnChangePhone.insets = new Insets(0, 0, 0, 5);
		gbc_btnChangePhone.gridx = 0;
		gbc_btnChangePhone.gridy = 0;
		panel_18.add(btnChangePhone, gbc_btnChangePhone);

		btncheckChangePhone = new JButton("", accept);
		btncheckChangePhone.setFont(new Font("SansSerif", Font.PLAIN, 15));
		btncheckChangePhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btncheckChangePhoneActionPerformed(e);
			}
		});
		btncheckChangePhone.setVisible(false);
		GridBagConstraints gbc_btncheckChangePhone = new GridBagConstraints();
		gbc_btncheckChangePhone.gridx = 1;
		gbc_btncheckChangePhone.gridy = 0;
		panel_18.add(btncheckChangePhone, gbc_btncheckChangePhone);

		lblCheckPhone_Info = new JLabel("");
		lblCheckPhone_Info.setForeground(new Color(255, 0, 0));
		lblCheckPhone_Info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCheckPhone_Info = new GridBagConstraints();
		gbc_lblCheckPhone_Info.anchor = GridBagConstraints.WEST;
		gbc_lblCheckPhone_Info.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckPhone_Info.gridwidth = 3;
		gbc_lblCheckPhone_Info.gridx = 1;
		gbc_lblCheckPhone_Info.gridy = 15;
		panel_8.add(lblCheckPhone_Info, gbc_lblCheckPhone_Info);

		lblUserName = new JLabel("Username:");
		lblUserName.setForeground(new Color(51, 51, 255));
		lblUserName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblUserName = new GridBagConstraints();
		gbc_lblUserName.anchor = GridBagConstraints.EAST;
		gbc_lblUserName.insets = new Insets(0, 0, 5, 5);
		gbc_lblUserName.gridx = 0;
		gbc_lblUserName.gridy = 16;
		panel_8.add(lblUserName, gbc_lblUserName);

		txtUsername_Info = new JTextField();
		txtUsername_Info.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(192, 192, 192)));
		txtUsername_Info.setEditable(false);
		txtUsername_Info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtUsername_Info.setColumns(10);
		GridBagConstraints gbc_txtUsername_Info = new GridBagConstraints();
		gbc_txtUsername_Info.insets = new Insets(0, 0, 5, 5);
		gbc_txtUsername_Info.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUsername_Info.gridx = 1;
		gbc_txtUsername_Info.gridy = 16;
		panel_8.add(txtUsername_Info, gbc_txtUsername_Info);

		lblType_1 = new JLabel("Type:");
		lblType_1.setForeground(new Color(51, 51, 255));
		lblType_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblType_1 = new GridBagConstraints();
		gbc_lblType_1.anchor = GridBagConstraints.EAST;
		gbc_lblType_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblType_1.gridx = 2;
		gbc_lblType_1.gridy = 16;
		panel_8.add(lblType_1, gbc_lblType_1);

		txtShowType = new JTextField();
		txtShowType.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtShowType.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtShowType.setEditable(false);
		txtShowType.setColumns(10);
		GridBagConstraints gbc_txtShowType = new GridBagConstraints();
		gbc_txtShowType.insets = new Insets(0, 0, 5, 5);
		gbc_txtShowType.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtShowType.gridx = 3;
		gbc_txtShowType.gridy = 16;
		panel_8.add(txtShowType, gbc_txtShowType);

		btnChange_2 = new JButton("", change);
		btnChange_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChange_2ActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnChange_2 = new GridBagConstraints();
		gbc_btnChange_2.fill = GridBagConstraints.BOTH;
		gbc_btnChange_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnChange_2.gridx = 4;
		gbc_btnChange_2.gridy = 16;
		panel_8.add(btnChange_2, gbc_btnChange_2);

		comboBox_type = new JComboBox();
		comboBox_type.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		loadDataTypeInfo();
		comboBox_type.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_typeActionPerformed(e);
			}
		});
		GridBagConstraints gbc_comboBox_type = new GridBagConstraints();
		gbc_comboBox_type.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_type.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_type.gridx = 3;
		gbc_comboBox_type.gridy = 17;
		panel_8.add(comboBox_type, gbc_comboBox_type);

		btnAccept_2 = new JButton("", accept);
		btnAccept_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAccept_2ActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnAccept_2 = new GridBagConstraints();
		gbc_btnAccept_2.insets = new Insets(0, 0, 5, 0);
		gbc_btnAccept_2.gridx = 4;
		gbc_btnAccept_2.gridy = 17;
		panel_8.add(btnAccept_2, gbc_btnAccept_2);

		lblGender_Info_1 = new JLabel("Status:");
		GridBagConstraints gbc_lblGender_Info_1 = new GridBagConstraints();
		gbc_lblGender_Info_1.anchor = GridBagConstraints.EAST;
		gbc_lblGender_Info_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender_Info_1.gridx = 0;
		gbc_lblGender_Info_1.gridy = 18;
		panel_8.add(lblGender_Info_1, gbc_lblGender_Info_1);
		lblGender_Info_1.setForeground(new Color(51, 51, 255));
		lblGender_Info_1.setFont(new Font("Times New Roman", Font.BOLD, 20));

		panel_14 = new JPanel();
		panel_14.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.anchor = GridBagConstraints.WEST;
		gbc_panel_14.gridwidth = 2;
		gbc_panel_14.insets = new Insets(0, 0, 5, 5);
		gbc_panel_14.fill = GridBagConstraints.VERTICAL;
		gbc_panel_14.gridx = 1;
		gbc_panel_14.gridy = 18;
		panel_8.add(panel_14, gbc_panel_14);
		GridBagLayout gbl_panel_14 = new GridBagLayout();
		gbl_panel_14.columnWidths = new int[] { 93, 113, 0 };
		gbl_panel_14.rowHeights = new int[] { 30, 0 };
		gbl_panel_14.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_14.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_14.setLayout(gbl_panel_14);

		rdbtn_SttAct = new JRadioButton("Active");
		rdbtn_SttAct.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_rdbtn_SttAct = new GridBagConstraints();
		gbc_rdbtn_SttAct.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtn_SttAct.gridx = 0;
		gbc_rdbtn_SttAct.gridy = 0;
		panel_14.add(rdbtn_SttAct, gbc_rdbtn_SttAct);
		buttonGroup_Stt.add(rdbtn_SttAct);

		rdbtn_Stt_Block = new JRadioButton("Non-Active");
		rdbtn_Stt_Block.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_rdbtn_Stt_Block = new GridBagConstraints();
		gbc_rdbtn_Stt_Block.gridx = 1;
		gbc_rdbtn_Stt_Block.gridy = 0;
		panel_14.add(rdbtn_Stt_Block, gbc_rdbtn_Stt_Block);
		buttonGroup_Stt.add(rdbtn_Stt_Block);

		panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.anchor = GridBagConstraints.SOUTH;
		gbc_panel_11.gridwidth = 3;
		gbc_panel_11.gridx = 2;
		gbc_panel_11.gridy = 19;
		panel_8.add(panel_11, gbc_panel_11);
		panel_11.setBackground(new Color(255, 255, 255));
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[] { 90, 90, 90, 0 };
		gbl_panel_11.rowHeights = new int[] { 33, 0 };
		gbl_panel_11.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_11.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_11.setLayout(gbl_panel_11);
		btnSave = new JButton("Save", save);
		btnSave.setEnabled(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSaveActionPerformed(e);
			}
		});

		btnEdit = new JButton("Edit", edit);
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.gridx = 0;
		gbc_btnEdit.gridy = 0;
		panel_11.add(btnEdit, gbc_btnEdit);
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEditActionPerformed(e);
			}
		});

		btnEdit.setForeground(Color.BLACK);
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEdit.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new BevelBorder(BevelBorder.LOWERED,
				new Color(102, 255, 255), new Color(51, 153, 255), new Color(0, 51, 255), new Color(0, 51, 153))));
		btnEdit.setBackground(new Color(204, 255, 255));
		btnReset = new JButton("Reset", reset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnResetActionPerformed(e);
			}
		});
		btnReset.setEnabled(false);
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.anchor = GridBagConstraints.SOUTH;
		gbc_btnReset.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReset.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset.gridx = 1;
		gbc_btnReset.gridy = 0;
		panel_11.add(btnReset, gbc_btnReset);
		btnReset.setForeground(Color.BLACK);
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new BevelBorder(BevelBorder.LOWERED,
				new Color(102, 255, 255), new Color(51, 153, 255), new Color(0, 51, 255), new Color(0, 51, 153))));
		btnReset.setBackground(new Color(204, 255, 255));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave.anchor = GridBagConstraints.SOUTH;
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 0;
		panel_11.add(btnSave, gbc_btnSave);
		btnSave.setForeground(Color.BLACK);
		btnSave.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new BevelBorder(BevelBorder.LOWERED,
				new Color(102, 255, 255), new Color(51, 153, 255), new Color(0, 51, 255), new Color(0, 51, 153))));
		btnSave.setBackground(new Color(204, 255, 255));

		panel_15 = new JPanel();
		panel_15.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new TitledBorder(null, "Change Password",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		panel_15.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.gridwidth = 2;
		gbc_panel_15.insets = new Insets(0, 0, 5, 0);
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.gridx = 1;
		gbc_panel_15.gridy = 1;
		panel_detailInfo.add(panel_15, gbc_panel_15);
		GridBagLayout gbl_panel_15 = new GridBagLayout();
		gbl_panel_15.columnWidths = new int[] { 137, 107, 45, 133, 176, 0 };
		gbl_panel_15.rowHeights = new int[] { 40, 35, 40, 35, 30, 0 };
		gbl_panel_15.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_15.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_15.setLayout(gbl_panel_15);

		lblPass = new JLabel("New pass:");
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.anchor = GridBagConstraints.EAST;
		gbc_lblPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblPass.gridx = 1;
		gbc_lblPass.gridy = 0;
		panel_15.add(lblPass, gbc_lblPass);
		lblPass.setForeground(new Color(51, 51, 255));
		lblPass.setFont(new Font("Times New Roman", Font.BOLD, 20));

		passwordField_NewPass = new JPasswordField();
		passwordField_NewPass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		passwordField_NewPass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passwordField_NewPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				passwordField_NewPassKeyPressed(e);
			}
		});

		passwordField_NewPass.setToolTipText(
				"Password must at least 6 chars and 1 digit-1 lower-1 upper alpha, 1 special char and not contain space");
		GridBagConstraints gbc_passwordField_NewPass = new GridBagConstraints();
		gbc_passwordField_NewPass.gridwidth = 2;
		gbc_passwordField_NewPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_NewPass.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_NewPass.gridx = 2;
		gbc_passwordField_NewPass.gridy = 0;
		panel_15.add(passwordField_NewPass, gbc_passwordField_NewPass);

		lblcheckNewPass_Info = new JLabel("");
		lblcheckNewPass_Info.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblcheckNewPass_Info = new GridBagConstraints();
		gbc_lblcheckNewPass_Info.insets = new Insets(0, 0, 5, 0);
		gbc_lblcheckNewPass_Info.gridwidth = 5;
		gbc_lblcheckNewPass_Info.gridx = 0;
		gbc_lblcheckNewPass_Info.gridy = 1;
		panel_15.add(lblcheckNewPass_Info, gbc_lblcheckNewPass_Info);
		lblcheckNewPass_Info.setFont(new Font("Times New Roman", Font.PLAIN, 14));

		passwordField_ConfPass_Info = new JPasswordField();
		passwordField_ConfPass_Info.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		passwordField_ConfPass_Info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		passwordField_ConfPass_Info.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				passwordField_ConfPass_InfoKeyPressed(e);
			}
		});

		lblConfirm = new JLabel("Confirm:");
		lblConfirm.setForeground(new Color(51, 51, 255));
		lblConfirm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblConfirm = new GridBagConstraints();
		gbc_lblConfirm.anchor = GridBagConstraints.EAST;
		gbc_lblConfirm.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfirm.gridx = 1;
		gbc_lblConfirm.gridy = 2;
		panel_15.add(lblConfirm, gbc_lblConfirm);
		passwordField_ConfPass_Info.setToolTipText(
				"Password must at least 6 chars and 1 digit-1 lower-1 upper alpha, 1 special char and not contain space");
		GridBagConstraints gbc_passwordField_ConfPass_Info = new GridBagConstraints();
		gbc_passwordField_ConfPass_Info.gridwidth = 2;
		gbc_passwordField_ConfPass_Info.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_ConfPass_Info.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_ConfPass_Info.gridx = 2;
		gbc_passwordField_ConfPass_Info.gridy = 2;
		panel_15.add(passwordField_ConfPass_Info, gbc_passwordField_ConfPass_Info);

		lblcheckConfPass_Info = new JLabel("");
		lblcheckConfPass_Info.setForeground(new Color(255, 0, 0));
		lblcheckConfPass_Info.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcheckConfPass_Info = new GridBagConstraints();
		gbc_lblcheckConfPass_Info.insets = new Insets(0, 0, 5, 0);
		gbc_lblcheckConfPass_Info.gridwidth = 5;
		gbc_lblcheckConfPass_Info.gridx = 0;
		gbc_lblcheckConfPass_Info.gridy = 3;
		panel_15.add(lblcheckConfPass_Info, gbc_lblcheckConfPass_Info);

		panel_16 = new JPanel();
		panel_16.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.gridwidth = 2;
		gbc_panel_16.gridx = 3;
		gbc_panel_16.gridy = 4;
		panel_15.add(panel_16, gbc_panel_16);
		GridBagLayout gbl_panel_16 = new GridBagLayout();
		gbl_panel_16.columnWidths = new int[] { 90, 54, 0 };
		gbl_panel_16.rowHeights = new int[] { 0, 0 };
		gbl_panel_16.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_16.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_16.setLayout(gbl_panel_16);

		btnSave_Pass = new JButton("Save", save);
		btnSave_Pass.setEnabled(false);
		btnSave_Pass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave_PassActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnSave_Pass = new GridBagConstraints();
		gbc_btnSave_Pass.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave_Pass.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave_Pass.gridx = 0;
		gbc_btnSave_Pass.gridy = 0;
		panel_16.add(btnSave_Pass, gbc_btnSave_Pass);
		btnSave_Pass.setForeground(Color.BLACK);
		btnSave_Pass.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave_Pass.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new BevelBorder(BevelBorder.LOWERED,
				new Color(102, 255, 255), new Color(51, 153, 255), new Color(0, 51, 255), new Color(0, 51, 153))));
		btnSave_Pass.setBackground(new Color(204, 255, 255));

		panel_9 = new JPanel();
		panel_9.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new TitledBorder(null, "Relatives Info",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		panel_9.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.gridwidth = 2;
		gbc_panel_9.insets = new Insets(0, 0, 5, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 1;
		gbc_panel_9.gridy = 2;
		panel_detailInfo.add(panel_9, gbc_panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[] { 95, 132, 176, 54, 46, 36, 0 };
		gbl_panel_9.rowHeights = new int[] { 25, 40, 35, 40, 35, 40, 35, 0, 0 };
		gbl_panel_9.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_9.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_9.setLayout(gbl_panel_9);

		lblRelName = new JLabel("Relatives name:");
		lblRelName.setForeground(new Color(51, 51, 255));
		lblRelName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblRelName = new GridBagConstraints();
		gbc_lblRelName.insets = new Insets(0, 0, 5, 5);
		gbc_lblRelName.anchor = GridBagConstraints.EAST;
		gbc_lblRelName.gridx = 1;
		gbc_lblRelName.gridy = 1;
		panel_9.add(lblRelName, gbc_lblRelName);

		txtRelName = new JTextField();
		txtRelName.setToolTipText(
				"Fullname must be at least 5 to 50 characters, not include: Special characters, numbers, Unicode letters");
		txtRelName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRelName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtRelName.setEditable(false);
		txtRelName.setColumns(10);
		GridBagConstraints gbc_txtRelName = new GridBagConstraints();
		gbc_txtRelName.gridwidth = 2;
		gbc_txtRelName.insets = new Insets(0, 0, 5, 5);
		gbc_txtRelName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRelName.gridx = 2;
		gbc_txtRelName.gridy = 1;
		panel_9.add(txtRelName, gbc_txtRelName);

		lblCheckRelName_Info = new JLabel("");
		lblCheckRelName_Info.setForeground(new Color(255, 0, 0));
		lblCheckRelName_Info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCheckRelName_Info = new GridBagConstraints();
		gbc_lblCheckRelName_Info.anchor = GridBagConstraints.WEST;
		gbc_lblCheckRelName_Info.gridwidth = 4;
		gbc_lblCheckRelName_Info.insets = new Insets(0, 0, 5, 0);
		gbc_lblCheckRelName_Info.gridx = 2;
		gbc_lblCheckRelName_Info.gridy = 2;
		panel_9.add(lblCheckRelName_Info, gbc_lblCheckRelName_Info);

		lblRelationship = new JLabel("Relationship:");
		lblRelationship.setForeground(new Color(51, 51, 255));
		lblRelationship.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblRelationship = new GridBagConstraints();
		gbc_lblRelationship.anchor = GridBagConstraints.EAST;
		gbc_lblRelationship.insets = new Insets(0, 0, 5, 5);
		gbc_lblRelationship.gridx = 1;
		gbc_lblRelationship.gridy = 3;
		panel_9.add(lblRelationship, gbc_lblRelationship);

		txtRelRelation = new JTextField();
		txtRelRelation.setToolTipText(
				"Relationship must be at least 3 to 20 characters, not include: Special characters, numbers, Unicode letters");
		txtRelRelation.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRelRelation.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtRelRelation.setEditable(false);
		txtRelRelation.setColumns(10);
		GridBagConstraints gbc_txtRelRelation = new GridBagConstraints();
		gbc_txtRelRelation.gridwidth = 2;
		gbc_txtRelRelation.insets = new Insets(0, 0, 5, 5);
		gbc_txtRelRelation.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRelRelation.gridx = 2;
		gbc_txtRelRelation.gridy = 3;
		panel_9.add(txtRelRelation, gbc_txtRelRelation);

		lblCheckRelRelation_Info = new JLabel("");
		lblCheckRelRelation_Info.setForeground(new Color(255, 0, 0));
		lblCheckRelRelation_Info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCheckRelRelation_Info = new GridBagConstraints();
		gbc_lblCheckRelRelation_Info.anchor = GridBagConstraints.WEST;
		gbc_lblCheckRelRelation_Info.gridwidth = 4;
		gbc_lblCheckRelRelation_Info.insets = new Insets(0, 0, 5, 0);
		gbc_lblCheckRelRelation_Info.gridx = 2;
		gbc_lblCheckRelRelation_Info.gridy = 4;
		panel_9.add(lblCheckRelRelation_Info, gbc_lblCheckRelRelation_Info);

		lblPhone_3 = new JLabel("Phone:");
		lblPhone_3.setForeground(new Color(51, 51, 255));
		lblPhone_3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblPhone_3 = new GridBagConstraints();
		gbc_lblPhone_3.anchor = GridBagConstraints.EAST;
		gbc_lblPhone_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone_3.gridx = 1;
		gbc_lblPhone_3.gridy = 5;
		panel_9.add(lblPhone_3, gbc_lblPhone_3);

		txtRelPhone_Info = new JTextField();
		txtRelPhone_Info.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRelPhone_Info.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtRelPhone_Info.setEditable(false);
		txtRelPhone_Info.setColumns(10);
		GridBagConstraints gbc_txtRelPhone_Info = new GridBagConstraints();
		gbc_txtRelPhone_Info.insets = new Insets(0, 0, 5, 5);
		gbc_txtRelPhone_Info.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRelPhone_Info.gridx = 2;
		gbc_txtRelPhone_Info.gridy = 5;
		panel_9.add(txtRelPhone_Info, gbc_txtRelPhone_Info);

		panel_19 = new JPanel();
		panel_19.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_19 = new GridBagConstraints();
		gbc_panel_19.gridwidth = 2;
		gbc_panel_19.insets = new Insets(0, 0, 5, 5);
		gbc_panel_19.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_19.gridx = 3;
		gbc_panel_19.gridy = 5;
		panel_9.add(panel_19, gbc_panel_19);
		GridBagLayout gbl_panel_19 = new GridBagLayout();
		gbl_panel_19.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_19.rowHeights = new int[] { 0, 0 };
		gbl_panel_19.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_19.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_19.setLayout(gbl_panel_19);

		btnUpdateRelPhone = new JButton("", change);
		btnUpdateRelPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdateRelPhoneActionPerformed(e);
			}
		});

		GridBagConstraints gbc_btnUpdateRelPhone = new GridBagConstraints();
		gbc_btnUpdateRelPhone.insets = new Insets(0, 0, 0, 5);
		gbc_btnUpdateRelPhone.gridx = 0;
		gbc_btnUpdateRelPhone.gridy = 0;
		panel_19.add(btnUpdateRelPhone, gbc_btnUpdateRelPhone);

		btnChangeRelPhone = new JButton("", accept);
		btnChangeRelPhone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnChangeRelPhoneActionPerformed(e);
			}
		});
		btnChangeRelPhone.setVisible(false);
		GridBagConstraints gbc_btnChangeRelPhone = new GridBagConstraints();
		gbc_btnChangeRelPhone.gridx = 1;
		gbc_btnChangeRelPhone.gridy = 0;
		panel_19.add(btnChangeRelPhone, gbc_btnChangeRelPhone);

		lblCheckRelPhone_Info = new JLabel("");
		lblCheckRelPhone_Info.setForeground(new Color(255, 0, 0));
		lblCheckRelPhone_Info.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblCheckRelPhone_Info = new GridBagConstraints();
		gbc_lblCheckRelPhone_Info.anchor = GridBagConstraints.WEST;
		gbc_lblCheckRelPhone_Info.gridwidth = 4;
		gbc_lblCheckRelPhone_Info.insets = new Insets(0, 0, 5, 0);
		gbc_lblCheckRelPhone_Info.gridx = 2;
		gbc_lblCheckRelPhone_Info.gridy = 6;
		panel_9.add(lblCheckRelPhone_Info, gbc_lblCheckRelPhone_Info);

		panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 0, 5);
		gbc_panel_10.anchor = GridBagConstraints.NORTH;
		gbc_panel_10.gridwidth = 4;
		gbc_panel_10.gridx = 2;
		gbc_panel_10.gridy = 7;
		panel_9.add(panel_10, gbc_panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[] { 90, 90, 90, 0 };
		gbl_panel_10.rowHeights = new int[] { 41, 0 };
		gbl_panel_10.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_10.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_10.setLayout(gbl_panel_10);

		btnEdit_Rel = new JButton("Edit", edit);
		btnEdit_Rel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit_RelActionPerformed(e);
			}
		});
		btnEdit_Rel.setForeground(Color.BLACK);
		btnEdit_Rel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnEdit_Rel.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new BevelBorder(BevelBorder.LOWERED,
				new Color(102, 255, 255), new Color(51, 153, 255), new Color(0, 51, 255), new Color(0, 51, 153))));
		btnEdit_Rel.setBackground(new Color(204, 255, 255));
		GridBagConstraints gbc_btnEdit_Rel = new GridBagConstraints();
		gbc_btnEdit_Rel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEdit_Rel.anchor = GridBagConstraints.SOUTH;
		gbc_btnEdit_Rel.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit_Rel.gridx = 0;
		gbc_btnEdit_Rel.gridy = 0;
		panel_10.add(btnEdit_Rel, gbc_btnEdit_Rel);

		btnReset_Rel = new JButton("Reset", reset);
		btnReset_Rel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnReset_RelActionPerformed(e);
			}
		});
		btnReset_Rel.setEnabled(false);
		GridBagConstraints gbc_btnReset_Rel = new GridBagConstraints();
		gbc_btnReset_Rel.anchor = GridBagConstraints.SOUTH;
		gbc_btnReset_Rel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnReset_Rel.insets = new Insets(0, 0, 0, 5);
		gbc_btnReset_Rel.gridx = 1;
		gbc_btnReset_Rel.gridy = 0;
		panel_10.add(btnReset_Rel, gbc_btnReset_Rel);
		btnReset_Rel.setForeground(Color.BLACK);
		btnReset_Rel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnReset_Rel.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new BevelBorder(BevelBorder.LOWERED,
				new Color(102, 255, 255), new Color(51, 153, 255), new Color(0, 51, 255), new Color(0, 51, 153))));
		btnReset_Rel.setBackground(new Color(204, 255, 255));

		btnSave_Rel = new JButton("Save", save);
		btnSave_Rel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave_RelActionPerformed(e);
			}
		});
		btnSave_Rel.setEnabled(false);
		btnSave_Rel.setForeground(Color.BLACK);
		btnSave_Rel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		btnSave_Rel.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new BevelBorder(BevelBorder.LOWERED,
				new Color(102, 255, 255), new Color(51, 153, 255), new Color(0, 51, 255), new Color(0, 51, 153))));
		btnSave_Rel.setBackground(new Color(204, 255, 255));
		GridBagConstraints gbc_btnSave_Rel = new GridBagConstraints();
		gbc_btnSave_Rel.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSave_Rel.anchor = GridBagConstraints.SOUTH;
		gbc_btnSave_Rel.gridx = 2;
		gbc_btnSave_Rel.gridy = 0;
		panel_10.add(btnSave_Rel, gbc_btnSave_Rel);

		panel_13 = new JPanel();
		panel_13.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new TitledBorder(null, "Leave Information",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		panel_13.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.gridwidth = 2;
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 1;
		gbc_panel_13.gridy = 3;
		panel_detailInfo.add(panel_13, gbc_panel_13);
		GridBagLayout gbl_panel_13 = new GridBagLayout();
		gbl_panel_13.columnWidths = new int[] { 248, 0, 146, 165, 0 };
		gbl_panel_13.rowHeights = new int[] { 40, 40, 40, 0 };
		gbl_panel_13.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_13.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };
		panel_13.setLayout(gbl_panel_13);

		lblAnnualDate = new JLabel("Annual leave date:");
		lblAnnualDate.setForeground(new Color(51, 51, 255));
		lblAnnualDate.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAnnualDate = new GridBagConstraints();
		gbc_lblAnnualDate.anchor = GridBagConstraints.EAST;
		gbc_lblAnnualDate.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnnualDate.gridx = 0;
		gbc_lblAnnualDate.gridy = 0;
		panel_13.add(lblAnnualDate, gbc_lblAnnualDate);

		lbl_showAL = new JLabel("");
		lbl_showAL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lbl_showAL = new GridBagConstraints();
		gbc_lbl_showAL.anchor = GridBagConstraints.WEST;
		gbc_lbl_showAL.gridwidth = 2;
		gbc_lbl_showAL.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_showAL.gridx = 1;
		gbc_lbl_showAL.gridy = 0;
		panel_13.add(lbl_showAL, gbc_lbl_showAL);

		lblUL = new JLabel("Unpaid leave date:");
		lblUL.setForeground(new Color(51, 51, 255));
		lblUL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblUL = new GridBagConstraints();
		gbc_lblUL.anchor = GridBagConstraints.EAST;
		gbc_lblUL.insets = new Insets(0, 0, 5, 5);
		gbc_lblUL.gridx = 0;
		gbc_lblUL.gridy = 1;
		panel_13.add(lblUL, gbc_lblUL);

		lbl_showUL = new JLabel("");
		lbl_showUL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lbl_showUL = new GridBagConstraints();
		gbc_lbl_showUL.anchor = GridBagConstraints.WEST;
		gbc_lbl_showUL.gridwidth = 2;
		gbc_lbl_showUL.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_showUL.gridx = 1;
		gbc_lbl_showUL.gridy = 1;
		panel_13.add(lbl_showUL, gbc_lbl_showUL);

		lblSL = new JLabel("Sick leave date:");
		lblSL.setForeground(new Color(51, 51, 255));
		lblSL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblSL = new GridBagConstraints();
		gbc_lblSL.anchor = GridBagConstraints.EAST;
		gbc_lblSL.insets = new Insets(0, 0, 0, 5);
		gbc_lblSL.gridx = 0;
		gbc_lblSL.gridy = 2;
		panel_13.add(lblSL, gbc_lblSL);

		lbl_showSL = new JLabel("");
		lbl_showSL.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lbl_showSL = new GridBagConstraints();
		gbc_lbl_showSL.anchor = GridBagConstraints.WEST;
		gbc_lbl_showSL.gridwidth = 2;
		gbc_lbl_showSL.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_showSL.gridx = 1;
		gbc_lbl_showSL.gridy = 2;
		panel_13.add(lbl_showSL, gbc_lbl_showSL);

		panel_AddNew = new JPanel();
		panel_AddNew.setBackground(Color.WHITE);
		panel.add(panel_AddNew, "insertnew");
		GridBagLayout gbl_panel_AddNew = new GridBagLayout();
		gbl_panel_AddNew.columnWidths = new int[] { 75, 44, 105, 186, 244, 94, 59, 71, 180, 104, 76, 69, 0 };
		gbl_panel_AddNew.rowHeights = new int[] { 90, 106, 45, 40, 40, 40, 41, 40, 40, 40, 40, 40, 40, 40, 40, 36, 0 };
		gbl_panel_AddNew.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_AddNew.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_AddNew.setLayout(gbl_panel_AddNew);

		panel_5 = new JPanel();
		panel_5 = new GradientPanel(Color.white, new Color(0, 160, 255), 3);
		panel_5.setBackground(new Color(0, 204, 255));
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 12;
		gbc_panel_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_AddNew.add(panel_5, gbc_panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		lblNewLabel_1 = new JLabel("HR MANAGEMENT");
		lblNewLabel_1.setForeground(new Color(255, 255, 204));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_5.add(lblNewLabel_1, BorderLayout.CENTER);

		panel_3 = new JPanel();
		panel_3.setBorder(new CompoundBorder(null, new MatteBorder(0, 0, 2, 0, (Color) new Color(204, 204, 0))));
		panel_3.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.gridwidth = 8;
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_3.gridx = 2;
		gbc_panel_3.gridy = 1;
		panel_AddNew.add(panel_3, gbc_panel_3);

		lblNewLabel_2 = new JLabel("Employee Information");
		lblNewLabel_2.setForeground(new Color(153, 51, 102));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_3.add(lblNewLabel_2);

		lblFullname = new JLabel("Fullname:");
		lblFullname.setForeground(new Color(51, 51, 255));
		lblFullname.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblFullname = new GridBagConstraints();
		gbc_lblFullname.anchor = GridBagConstraints.EAST;
		gbc_lblFullname.insets = new Insets(0, 0, 5, 5);
		gbc_lblFullname.gridx = 2;
		gbc_lblFullname.gridy = 2;
		panel_AddNew.add(lblFullname, gbc_lblFullname);

		txtFullname = new JTextField();
		txtFullname.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtFullname.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_txtFullname = new GridBagConstraints();
		gbc_txtFullname.gridwidth = 2;
		gbc_txtFullname.insets = new Insets(0, 0, 5, 5);
		gbc_txtFullname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFullname.gridx = 3;
		gbc_txtFullname.gridy = 2;
		panel_AddNew.add(txtFullname, gbc_txtFullname);
		txtFullname.setColumns(10);

		lblGender = new JLabel("Gender:");
		lblGender.setForeground(new Color(51, 51, 255));
		lblGender.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblGender = new GridBagConstraints();
		gbc_lblGender.anchor = GridBagConstraints.EAST;
		gbc_lblGender.insets = new Insets(0, 0, 5, 5);
		gbc_lblGender.gridx = 7;
		gbc_lblGender.gridy = 2;
		panel_AddNew.add(lblGender, gbc_lblGender);

		panel_45 = new JPanel();
		panel_45.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_45 = new GridBagConstraints();
		gbc_panel_45.insets = new Insets(0, 0, 5, 5);
		gbc_panel_45.fill = GridBagConstraints.BOTH;
		gbc_panel_45.gridx = 8;
		gbc_panel_45.gridy = 2;
		panel_AddNew.add(panel_45, gbc_panel_45);
		GridBagLayout gbl_panel_45 = new GridBagLayout();
		gbl_panel_45.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_45.rowHeights = new int[] { 42, 0 };
		gbl_panel_45.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_45.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_45.setLayout(gbl_panel_45);

		rdbtnFemale = new JRadioButton("Female");
		GridBagConstraints gbc_rdbtnFemale = new GridBagConstraints();
		gbc_rdbtnFemale.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnFemale.gridx = 0;
		gbc_rdbtnFemale.gridy = 0;
		panel_45.add(rdbtnFemale, gbc_rdbtnFemale);
		rdbtnFemale.setSelected(true);
		buttonGroup_gender.add(rdbtnFemale);
		rdbtnFemale.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		rdbtnMale = new JRadioButton("Male");
		GridBagConstraints gbc_rdbtnMale = new GridBagConstraints();
		gbc_rdbtnMale.gridx = 2;
		gbc_rdbtnMale.gridy = 0;
		panel_45.add(rdbtnMale, gbc_rdbtnMale);
		buttonGroup_gender.add(rdbtnMale);
		rdbtnMale.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		lblcheckName = new JLabel("");
		lblcheckName.setForeground(new Color(255, 0, 0));
		lblcheckName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcheckName = new GridBagConstraints();
		gbc_lblcheckName.anchor = GridBagConstraints.WEST;
		gbc_lblcheckName.gridwidth = 4;
		gbc_lblcheckName.insets = new Insets(0, 0, 5, 5);
		gbc_lblcheckName.gridx = 3;
		gbc_lblcheckName.gridy = 3;
		panel_AddNew.add(lblcheckName, gbc_lblcheckName);

		lblAddress = new JLabel("Address:");
		lblAddress.setForeground(new Color(51, 51, 255));
		lblAddress.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblAddress = new GridBagConstraints();
		gbc_lblAddress.anchor = GridBagConstraints.EAST;
		gbc_lblAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblAddress.gridx = 2;
		gbc_lblAddress.gridy = 4;
		panel_AddNew.add(lblAddress, gbc_lblAddress);

		txtAddress = new JTextField();
		txtAddress.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtAddress.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_txtAddress = new GridBagConstraints();
		gbc_txtAddress.gridwidth = 2;
		gbc_txtAddress.insets = new Insets(0, 0, 5, 5);
		gbc_txtAddress.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtAddress.gridx = 3;
		gbc_txtAddress.gridy = 4;
		panel_AddNew.add(txtAddress, gbc_txtAddress);
		txtAddress.setColumns(10);

		lblDOB = new JLabel("DOB:");
		lblDOB.setForeground(new Color(51, 51, 255));
		lblDOB.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblDOB = new GridBagConstraints();
		gbc_lblDOB.anchor = GridBagConstraints.EAST;
		gbc_lblDOB.insets = new Insets(0, 0, 5, 5);
		gbc_lblDOB.gridx = 7;
		gbc_lblDOB.gridy = 4;
		panel_AddNew.add(lblDOB, gbc_lblDOB);

		dateChooser_DOB = new JDateChooser(null, "yyyy-MM-dd");
		dateChooser_DOB.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_dateChooser_DOB = new GridBagConstraints();
		gbc_dateChooser_DOB.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_DOB.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_DOB.gridx = 8;
		gbc_dateChooser_DOB.gridy = 4;
		panel_AddNew.add(dateChooser_DOB, gbc_dateChooser_DOB);

		lblcheckAddress = new JLabel("");
		lblcheckAddress.setForeground(Color.RED);
		lblcheckAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcheckAddress = new GridBagConstraints();
		gbc_lblcheckAddress.anchor = GridBagConstraints.WEST;
		gbc_lblcheckAddress.gridwidth = 4;
		gbc_lblcheckAddress.insets = new Insets(0, 0, 5, 5);
		gbc_lblcheckAddress.gridx = 3;
		gbc_lblcheckAddress.gridy = 5;
		panel_AddNew.add(lblcheckAddress, gbc_lblcheckAddress);

		lblcheckDob = new JLabel("");
		lblcheckDob.setForeground(new Color(255, 0, 0));
		lblcheckDob.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcheckDob = new GridBagConstraints();
		gbc_lblcheckDob.anchor = GridBagConstraints.WEST;
		gbc_lblcheckDob.gridwidth = 4;
		gbc_lblcheckDob.insets = new Insets(0, 0, 5, 0);
		gbc_lblcheckDob.gridx = 8;
		gbc_lblcheckDob.gridy = 5;
		panel_AddNew.add(lblcheckDob, gbc_lblcheckDob);

		lblUser = new JLabel("Username:");
		lblUser.setForeground(new Color(51, 51, 255));
		lblUser.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.EAST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 2;
		gbc_lblUser.gridy = 6;
		panel_AddNew.add(lblUser, gbc_lblUser);

		txtUserName = new JTextField();
		txtUserName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtUserName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_txtUserName = new GridBagConstraints();
		gbc_txtUserName.gridwidth = 2;
		gbc_txtUserName.insets = new Insets(0, 0, 5, 5);
		gbc_txtUserName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtUserName.gridx = 3;
		gbc_txtUserName.gridy = 6;
		panel_AddNew.add(txtUserName, gbc_txtUserName);
		txtUserName.setColumns(10);

		lblType = new JLabel("Type:");
		lblType.setForeground(new Color(51, 51, 255));
		lblType.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblType = new GridBagConstraints();
		gbc_lblType.anchor = GridBagConstraints.EAST;
		gbc_lblType.insets = new Insets(0, 0, 5, 5);
		gbc_lblType.gridx = 7;
		gbc_lblType.gridy = 6;
		panel_AddNew.add(lblType, gbc_lblType);

		comboBox_Type = new JComboBox();
		comboBox_Type.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		loadDataType();
		GridBagConstraints gbc_comboBox_Type = new GridBagConstraints();
		gbc_comboBox_Type.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Type.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Type.gridx = 8;
		gbc_comboBox_Type.gridy = 6;
		panel_AddNew.add(comboBox_Type, gbc_comboBox_Type);

		lblcheckUserName = new JLabel("");
		lblcheckUserName.setForeground(new Color(255, 0, 0));
		lblcheckUserName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcheckUserName = new GridBagConstraints();
		gbc_lblcheckUserName.anchor = GridBagConstraints.WEST;
		gbc_lblcheckUserName.gridwidth = 4;
		gbc_lblcheckUserName.insets = new Insets(0, 0, 5, 5);
		gbc_lblcheckUserName.gridx = 3;
		gbc_lblcheckUserName.gridy = 7;
		panel_AddNew.add(lblcheckUserName, gbc_lblcheckUserName);

		lblPassWord = new JLabel("Password:");
		lblPassWord.setForeground(new Color(51, 51, 255));
		lblPassWord.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblPassWord = new GridBagConstraints();
		gbc_lblPassWord.anchor = GridBagConstraints.EAST;
		gbc_lblPassWord.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassWord.gridx = 2;
		gbc_lblPassWord.gridy = 8;
		panel_AddNew.add(lblPassWord, gbc_lblPassWord);

		passwordField_PassWord = new JPasswordField();
		passwordField_PassWord.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		passwordField_PassWord.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_passwordField_PassWord = new GridBagConstraints();
		gbc_passwordField_PassWord.gridwidth = 2;
		gbc_passwordField_PassWord.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_PassWord.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_PassWord.gridx = 3;
		gbc_passwordField_PassWord.gridy = 8;
		panel_AddNew.add(passwordField_PassWord, gbc_passwordField_PassWord);

		lblDepartment = new JLabel("Department:");
		lblDepartment.setForeground(new Color(51, 51, 255));
		lblDepartment.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblDepartment = new GridBagConstraints();
		gbc_lblDepartment.anchor = GridBagConstraints.EAST;
		gbc_lblDepartment.insets = new Insets(0, 0, 5, 5);
		gbc_lblDepartment.gridx = 7;
		gbc_lblDepartment.gridy = 8;
		panel_AddNew.add(lblDepartment, gbc_lblDepartment);

		comboBox_Dept = new JComboBox();
		comboBox_Dept.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		loadData();
		GridBagConstraints gbc_comboBox_Dept = new GridBagConstraints();
		gbc_comboBox_Dept.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Dept.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Dept.gridx = 8;
		gbc_comboBox_Dept.gridy = 8;
		panel_AddNew.add(comboBox_Dept, gbc_comboBox_Dept);

		lblcheckPassWord = new JLabel("");
		lblcheckPassWord.setForeground(Color.RED);
		lblcheckPassWord.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcheckPassWord = new GridBagConstraints();
		gbc_lblcheckPassWord.anchor = GridBagConstraints.WEST;
		gbc_lblcheckPassWord.gridwidth = 4;
		gbc_lblcheckPassWord.insets = new Insets(0, 0, 5, 5);
		gbc_lblcheckPassWord.gridx = 3;
		gbc_lblcheckPassWord.gridy = 9;
		panel_AddNew.add(lblcheckPassWord, gbc_lblcheckPassWord);

		lblConfPass = new JLabel("Confirm:");
		lblConfPass.setForeground(new Color(51, 51, 255));
		lblConfPass.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblConfPass = new GridBagConstraints();
		gbc_lblConfPass.anchor = GridBagConstraints.EAST;
		gbc_lblConfPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblConfPass.gridx = 2;
		gbc_lblConfPass.gridy = 10;
		panel_AddNew.add(lblConfPass, gbc_lblConfPass);

		passwordField_ConfPass = new JPasswordField();
		passwordField_ConfPass.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		passwordField_ConfPass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_passwordField_ConfPass = new GridBagConstraints();
		gbc_passwordField_ConfPass.gridwidth = 2;
		gbc_passwordField_ConfPass.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField_ConfPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_ConfPass.gridx = 3;
		gbc_passwordField_ConfPass.gridy = 10;
		panel_AddNew.add(passwordField_ConfPass, gbc_passwordField_ConfPass);

		lblSalary_1 = new JLabel("Salary:");
		lblSalary_1.setForeground(new Color(51, 51, 255));
		lblSalary_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblSalary_1 = new GridBagConstraints();
		gbc_lblSalary_1.anchor = GridBagConstraints.EAST;
		gbc_lblSalary_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblSalary_1.gridx = 7;
		gbc_lblSalary_1.gridy = 10;
		panel_AddNew.add(lblSalary_1, gbc_lblSalary_1);

		txtSalary_Insert = new JTextField();
		txtSalary_Insert.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtSalary_Insert.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtSalary_Insert.setColumns(10);
		GridBagConstraints gbc_txtSalary_Insert = new GridBagConstraints();
		gbc_txtSalary_Insert.insets = new Insets(0, 0, 5, 5);
		gbc_txtSalary_Insert.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSalary_Insert.gridx = 8;
		gbc_txtSalary_Insert.gridy = 10;
		panel_AddNew.add(txtSalary_Insert, gbc_txtSalary_Insert);

		lblNewLabel_44 = new JLabel("VND");
		lblNewLabel_44.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_44 = new GridBagConstraints();
		gbc_lblNewLabel_44.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_44.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_44.gridx = 9;
		gbc_lblNewLabel_44.gridy = 10;
		panel_AddNew.add(lblNewLabel_44, gbc_lblNewLabel_44);

		lblcheckConfWord = new JLabel("");
		lblcheckConfWord.setForeground(Color.RED);
		lblcheckConfWord.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcheckConfWord = new GridBagConstraints();
		gbc_lblcheckConfWord.anchor = GridBagConstraints.WEST;
		gbc_lblcheckConfWord.gridwidth = 4;
		gbc_lblcheckConfWord.insets = new Insets(0, 0, 5, 5);
		gbc_lblcheckConfWord.gridx = 3;
		gbc_lblcheckConfWord.gridy = 11;
		panel_AddNew.add(lblcheckConfWord, gbc_lblcheckConfWord);

		lblcheckSalary = new JLabel("");
		lblcheckSalary.setForeground(Color.RED);
		lblcheckSalary.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcheckSalary = new GridBagConstraints();
		gbc_lblcheckSalary.anchor = GridBagConstraints.WEST;
		gbc_lblcheckSalary.gridwidth = 4;
		gbc_lblcheckSalary.insets = new Insets(0, 0, 5, 0);
		gbc_lblcheckSalary.gridx = 8;
		gbc_lblcheckSalary.gridy = 11;
		panel_AddNew.add(lblcheckSalary, gbc_lblcheckSalary);

		lblEmail = new JLabel("E-mail:");
		lblEmail.setForeground(new Color(51, 51, 255));
		lblEmail.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 2;
		gbc_lblEmail.gridy = 12;
		panel_AddNew.add(lblEmail, gbc_lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(192, 192, 192)));
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_txtEmail = new GridBagConstraints();
		gbc_txtEmail.gridwidth = 2;
		gbc_txtEmail.insets = new Insets(0, 0, 5, 5);
		gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEmail.gridx = 3;
		gbc_txtEmail.gridy = 12;
		panel_AddNew.add(txtEmail, gbc_txtEmail);
		txtEmail.setColumns(10);

		lblPhone = new JLabel("Phone:");
		lblPhone.setForeground(new Color(51, 51, 255));
		lblPhone.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblPhone = new GridBagConstraints();
		gbc_lblPhone.anchor = GridBagConstraints.EAST;
		gbc_lblPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone.gridx = 7;
		gbc_lblPhone.gridy = 12;
		panel_AddNew.add(lblPhone, gbc_lblPhone);

		txtPhone = new JTextField();
		txtPhone.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPhone.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_txtPhone = new GridBagConstraints();
		gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone.gridx = 8;
		gbc_txtPhone.gridy = 12;
		panel_AddNew.add(txtPhone, gbc_txtPhone);
		txtPhone.setColumns(10);

		lblcheckEmail = new JLabel("");
		lblcheckEmail.setForeground(Color.RED);
		lblcheckEmail.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcheckEmail = new GridBagConstraints();
		gbc_lblcheckEmail.anchor = GridBagConstraints.WEST;
		gbc_lblcheckEmail.gridwidth = 4;
		gbc_lblcheckEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblcheckEmail.gridx = 3;
		gbc_lblcheckEmail.gridy = 13;
		panel_AddNew.add(lblcheckEmail, gbc_lblcheckEmail);

		lblcheckPhone = new JLabel("");
		lblcheckPhone.setForeground(Color.RED);
		lblcheckPhone.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcheckPhone = new GridBagConstraints();
		gbc_lblcheckPhone.anchor = GridBagConstraints.WEST;
		gbc_lblcheckPhone.gridwidth = 3;
		gbc_lblcheckPhone.insets = new Insets(0, 0, 5, 5);
		gbc_lblcheckPhone.gridx = 8;
		gbc_lblcheckPhone.gridy = 13;
		panel_AddNew.add(lblcheckPhone, gbc_lblcheckPhone);

		lblOnboard = new JLabel("Onboard Date:");
		lblOnboard.setForeground(new Color(51, 51, 255));
		lblOnboard.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblOnboard = new GridBagConstraints();
		gbc_lblOnboard.anchor = GridBagConstraints.EAST;
		gbc_lblOnboard.insets = new Insets(0, 0, 5, 5);
		gbc_lblOnboard.gridx = 2;
		gbc_lblOnboard.gridy = 14;
		panel_AddNew.add(lblOnboard, gbc_lblOnboard);

		dateChooser_Onboard = new JDateChooser(new Date(), "yyyy-MM-dd");
		dateChooser_Onboard.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_dateChooser_Onboard = new GridBagConstraints();
		gbc_dateChooser_Onboard.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser_Onboard.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_Onboard.gridx = 3;
		gbc_dateChooser_Onboard.gridy = 14;
		panel_AddNew.add(dateChooser_Onboard, gbc_dateChooser_Onboard);

		btnInsert = new JButton("NEXT", next);
		btnInsert.setForeground(new Color(0, 0, 0));
		btnInsert.setBackground(new Color(204, 255, 255));
		btnInsert.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new BevelBorder(BevelBorder.LOWERED,
				new Color(102, 255, 255), new Color(51, 153, 255), new Color(0, 51, 255), new Color(0, 51, 153))));
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnInsertActionPerformed(e);
			}
		});

		lblcheckOnboard = new JLabel("");
		lblcheckOnboard.setForeground(Color.RED);
		lblcheckOnboard.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblcheckOnboard = new GridBagConstraints();
		gbc_lblcheckOnboard.anchor = GridBagConstraints.WEST;
		gbc_lblcheckOnboard.gridwidth = 2;
		gbc_lblcheckOnboard.insets = new Insets(0, 0, 0, 5);
		gbc_lblcheckOnboard.gridx = 3;
		gbc_lblcheckOnboard.gridy = 15;
		panel_AddNew.add(lblcheckOnboard, gbc_lblcheckOnboard);
		btnInsert.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_btnInsert = new GridBagConstraints();
		gbc_btnInsert.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnInsert.insets = new Insets(0, 0, 0, 5);
		gbc_btnInsert.gridx = 8;
		gbc_btnInsert.gridy = 15;
		panel_AddNew.add(btnInsert, gbc_btnInsert);

		panel_relative = new JPanel();
		panel_relative.setBackground(Color.WHITE);
		panel.add(panel_relative, "relatives");
		GridBagLayout gbl_panel_relative = new GridBagLayout();
		gbl_panel_relative.columnWidths = new int[] { 76, 392, 258, 171, 272, 69, 0 };
		gbl_panel_relative.rowHeights = new int[] { 90, 0, 60, 60, 57, 51, 60, 40, 50, 40, 50, 40, 35, 0 };
		gbl_panel_relative.columnWeights = new double[] { 1.0, 1.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_relative.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_relative.setLayout(gbl_panel_relative);

		panel_7 = new JPanel();
		panel_7 = new GradientPanel(Color.white, new Color(0, 160, 255), 3);
		panel_7.setBackground(new Color(0, 204, 255));
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.gridwidth = 6;
		gbc_panel_7.insets = new Insets(0, 0, 5, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 0;
		panel_relative.add(panel_7, gbc_panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));

		lblNewLabel_5 = new JLabel("HR MANAGEMENT");
		lblNewLabel_5.setForeground(new Color(255, 255, 204));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_7.add(lblNewLabel_5);

		lblIDEmp = new JLabel("ID Employee:");
		lblIDEmp.setForeground(new Color(51, 51, 255));
		lblIDEmp.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblIDEmp = new GridBagConstraints();
		gbc_lblIDEmp.insets = new Insets(0, 0, 5, 5);
		gbc_lblIDEmp.anchor = GridBagConstraints.EAST;
		gbc_lblIDEmp.gridx = 1;
		gbc_lblIDEmp.gridy = 2;
		panel_relative.add(lblIDEmp, gbc_lblIDEmp);

		txtIdemp = new JTextField();
		txtIdemp.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		txtIdemp.setEditable(false);
		txtIdemp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtIdemp.setColumns(10);
		GridBagConstraints gbc_txtIdemp = new GridBagConstraints();
		gbc_txtIdemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdemp.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdemp.gridx = 2;
		gbc_txtIdemp.gridy = 2;
		panel_relative.add(txtIdemp, gbc_txtIdemp);

		lblEmpName = new JLabel("Employee Name:");
		lblEmpName.setForeground(new Color(51, 51, 255));
		lblEmpName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblEmpName = new GridBagConstraints();
		gbc_lblEmpName.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmpName.anchor = GridBagConstraints.EAST;
		gbc_lblEmpName.gridx = 1;
		gbc_lblEmpName.gridy = 3;
		panel_relative.add(lblEmpName, gbc_lblEmpName);

		txtName = new JTextField();
		txtName.setBorder(new MatteBorder(0, 0, 0, 0, (Color) new Color(0, 0, 0)));
		txtName.setEditable(false);
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtName.setColumns(10);
		GridBagConstraints gbc_txtName = new GridBagConstraints();
		gbc_txtName.gridwidth = 2;
		gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtName.insets = new Insets(0, 0, 5, 5);
		gbc_txtName.gridx = 2;
		gbc_txtName.gridy = 3;
		panel_relative.add(txtName, gbc_txtName);

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new CompoundBorder(null, new MatteBorder(0, 0, 2, 0, (Color) new Color(204, 204, 0))));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.anchor = GridBagConstraints.SOUTH;
		gbc_panel_1.gridwidth = 4;
		gbc_panel_1.insets = new Insets(0, 0, 5, 5);
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.gridx = 1;
		gbc_panel_1.gridy = 4;
		panel_relative.add(panel_1, gbc_panel_1);

		lblNewLabel_3 = new JLabel("Relatives Information");
		lblNewLabel_3.setForeground(new Color(153, 51, 102));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_1.add(lblNewLabel_3);

		lblName = new JLabel("Fullname:");
		lblName.setForeground(new Color(51, 51, 255));
		lblName.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 6;
		panel_relative.add(lblName, gbc_lblName);

		txtRelativeName = new JTextField();
		txtRelativeName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRelativeName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtRelativeName.setColumns(10);
		GridBagConstraints gbc_txtRelativeName = new GridBagConstraints();
		gbc_txtRelativeName.gridwidth = 2;
		gbc_txtRelativeName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRelativeName.insets = new Insets(0, 0, 5, 5);
		gbc_txtRelativeName.gridx = 2;
		gbc_txtRelativeName.gridy = 6;
		panel_relative.add(txtRelativeName, gbc_txtRelativeName);

		lblcheckName_1 = new JLabel("");
		lblcheckName_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblcheckName_1.setForeground(new Color(255, 0, 0));
		GridBagConstraints gbc_lblcheckName_1 = new GridBagConstraints();
		gbc_lblcheckName_1.anchor = GridBagConstraints.WEST;
		gbc_lblcheckName_1.gridwidth = 4;
		gbc_lblcheckName_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblcheckName_1.gridx = 2;
		gbc_lblcheckName_1.gridy = 7;
		panel_relative.add(lblcheckName_1, gbc_lblcheckName_1);

		lblPhone_1 = new JLabel("Phone:");
		lblPhone_1.setForeground(new Color(51, 51, 255));
		lblPhone_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblPhone_1 = new GridBagConstraints();
		gbc_lblPhone_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblPhone_1.anchor = GridBagConstraints.EAST;
		gbc_lblPhone_1.gridx = 1;
		gbc_lblPhone_1.gridy = 8;
		panel_relative.add(lblPhone_1, gbc_lblPhone_1);

		txtPhone_1 = new JTextField();
		txtPhone_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtPhone_1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPhone_1.setColumns(10);
		GridBagConstraints gbc_txtPhone_1 = new GridBagConstraints();
		gbc_txtPhone_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPhone_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtPhone_1.gridx = 2;
		gbc_txtPhone_1.gridy = 8;
		panel_relative.add(txtPhone_1, gbc_txtPhone_1);

		lblcheckPhone_1 = new JLabel("");
		lblcheckPhone_1.setForeground(Color.RED);
		lblcheckPhone_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_lblcheckPhone_1 = new GridBagConstraints();
		gbc_lblcheckPhone_1.anchor = GridBagConstraints.WEST;
		gbc_lblcheckPhone_1.gridwidth = 2;
		gbc_lblcheckPhone_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblcheckPhone_1.gridx = 2;
		gbc_lblcheckPhone_1.gridy = 9;
		panel_relative.add(lblcheckPhone_1, gbc_lblcheckPhone_1);

		lblRelation_1 = new JLabel("Relationship:");
		lblRelation_1.setForeground(new Color(51, 51, 255));
		lblRelation_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_lblRelation_1 = new GridBagConstraints();
		gbc_lblRelation_1.anchor = GridBagConstraints.EAST;
		gbc_lblRelation_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblRelation_1.gridx = 1;
		gbc_lblRelation_1.gridy = 10;
		panel_relative.add(lblRelation_1, gbc_lblRelation_1);

		txtRelation = new JTextField();
		txtRelation.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		txtRelation.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_txtRelation = new GridBagConstraints();
		gbc_txtRelation.insets = new Insets(0, 0, 5, 5);
		gbc_txtRelation.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtRelation.gridx = 2;
		gbc_txtRelation.gridy = 10;
		panel_relative.add(txtRelation, gbc_txtRelation);
		txtRelation.setColumns(10);

		btnNext = new JButton("FINISH", done);
		btnNext.setForeground(new Color(0, 0, 0));
		btnNext.setBorder(new CompoundBorder(new EmptyBorder(2, 2, 2, 2), new BevelBorder(BevelBorder.LOWERED,
				new Color(51, 153, 255), new Color(102, 255, 255), new Color(0, 0, 255), new Color(0, 0, 204))));
		btnNext.setBackground(new Color(204, 255, 255));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNextActionPerformed(e);
			}
		});

		lblcheckRelation_1 = new JLabel("");
		lblcheckRelation_1.setForeground(Color.RED);
		lblcheckRelation_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		GridBagConstraints gbc_lblcheckRelation_1 = new GridBagConstraints();
		gbc_lblcheckRelation_1.anchor = GridBagConstraints.WEST;
		gbc_lblcheckRelation_1.gridwidth = 4;
		gbc_lblcheckRelation_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblcheckRelation_1.gridx = 2;
		gbc_lblcheckRelation_1.gridy = 11;
		panel_relative.add(lblcheckRelation_1, gbc_lblcheckRelation_1);
		btnNext.setFont(new Font("Times New Roman", Font.BOLD, 20));
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 0, 5);
		gbc_btnNext.fill = GridBagConstraints.BOTH;
		gbc_btnNext.gridx = 3;
		gbc_btnNext.gridy = 12;
		panel_relative.add(btnNext, gbc_btnNext);

		panel_Report = new JPanel();
		panel_Report.setBackground(Color.WHITE);
		panel.add(panel_Report, "report");
		GridBagLayout gbl_panel_Report = new GridBagLayout();
		gbl_panel_Report.columnWidths = new int[] { 64, 244, 148, 168, 109, 52, 393, 111, 70, 0 };
		gbl_panel_Report.rowHeights = new int[] { 90, 31, 45, 45, 41, 224, 55, 264, 60, 0 };
		gbl_panel_Report.columnWeights = new double[] { 1.0, 1.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_Report.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_Report.setLayout(gbl_panel_Report);

		panel_24 = new JPanel();
		panel_24 = new GradientPanel(Color.white, new Color(0, 160, 255), 3);
		panel_24.setBackground(new Color(0, 204, 255));
		GridBagConstraints gbc_panel_24 = new GridBagConstraints();
		gbc_panel_24.insets = new Insets(0, 0, 5, 0);
		gbc_panel_24.gridwidth = 9;
		gbc_panel_24.fill = GridBagConstraints.BOTH;
		gbc_panel_24.gridx = 0;
		gbc_panel_24.gridy = 0;
		panel_Report.add(panel_24, gbc_panel_24);
		panel_24.setLayout(new BorderLayout(0, 0));

		lblNewLabel_11 = new JLabel("HR MANAGEMENT");
		lblNewLabel_11.setForeground(new Color(255, 255, 204));
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_24.add(lblNewLabel_11, BorderLayout.CENTER);

		lblFieldSearch = new JLabel("");
		lblFieldSearch.setForeground(new Color(255, 0, 0));
		lblFieldSearch.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblFieldSearch = new GridBagConstraints();
		gbc_lblFieldSearch.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblFieldSearch.insets = new Insets(0, 0, 5, 5);
		gbc_lblFieldSearch.gridx = 3;
		gbc_lblFieldSearch.gridy = 1;
		panel_Report.add(lblFieldSearch, gbc_lblFieldSearch);

		lblNewLabel_12 = new JLabel("Salary report month:");
		lblNewLabel_12.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 1;
		gbc_lblNewLabel_12.gridy = 2;
		panel_Report.add(lblNewLabel_12, gbc_lblNewLabel_12);

		comboBox_MonthRp = new JComboBox();
		comboBox_MonthRp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_MonthRpActionPerformed(e);
			}
		});
		comboBox_MonthRp.setFont(new Font("Serif", Font.PLAIN, 18));
		comboBox_MonthRp.setModel(new DefaultComboBoxModel(new String[] { "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October", "November", "December" }));
		GridBagConstraints gbc_comboBox_MonthRp = new GridBagConstraints();
		gbc_comboBox_MonthRp.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_MonthRp.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_MonthRp.gridx = 2;
		gbc_comboBox_MonthRp.gridy = 2;
		panel_Report.add(comboBox_MonthRp, gbc_comboBox_MonthRp);

		comboBox_SortSal_month = new JComboBox();
		comboBox_SortSal_month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_SortSal_monthActionPerformed(e);
			}
		});
		comboBox_SortSal_month.setModel(new DefaultComboBoxModel(new String[] { "Highest", "Lowest" }));
		comboBox_SortSal_month.setFont(new Font("Serif", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBox_SortSal_month = new GridBagConstraints();
		gbc_comboBox_SortSal_month.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_SortSal_month.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_SortSal_month.gridx = 3;
		gbc_comboBox_SortSal_month.gridy = 2;
		panel_Report.add(comboBox_SortSal_month, gbc_comboBox_SortSal_month);

		lblNewLabel_27 = new JLabel("Department:");
		GridBagConstraints gbc_lblNewLabel_27 = new GridBagConstraints();
		gbc_lblNewLabel_27.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_27.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_27.gridx = 1;
		gbc_lblNewLabel_27.gridy = 3;
		panel_Report.add(lblNewLabel_27, gbc_lblNewLabel_27);
		lblNewLabel_27.setFont(new Font("Serif", Font.BOLD, 20));

		comboBox_DeptReport = new JComboBox();
		loadDataDeptAttend();
		comboBox_DeptReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_DeptReportActionPerformed(e);
			}
		});
		comboBox_DeptReport.setFont(new Font("Serif", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBox_DeptReport = new GridBagConstraints();
		gbc_comboBox_DeptReport.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_DeptReport.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_DeptReport.gridx = 2;
		gbc_comboBox_DeptReport.gridy = 3;
		panel_Report.add(comboBox_DeptReport, gbc_comboBox_DeptReport);

		comboBox_SortSal = new JComboBox();
		comboBox_SortSal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_SortSalActionPerformed(e);
			}
		});
		comboBox_SortSal.setModel(new DefaultComboBoxModel(new String[] { "Highest", "Lowest" }));
		comboBox_SortSal.setFont(new Font("Serif", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBox_SortSal = new GridBagConstraints();
		gbc_comboBox_SortSal.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_SortSal.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_SortSal.gridx = 3;
		gbc_comboBox_SortSal.gridy = 3;
		panel_Report.add(comboBox_SortSal, gbc_comboBox_SortSal);

		scrollPane_Report = new JScrollPane();

		GridBagConstraints gbc_scrollPane_Report = new GridBagConstraints();
		gbc_scrollPane_Report.gridwidth = 4;
		gbc_scrollPane_Report.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_Report.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_Report.gridx = 1;
		gbc_scrollPane_Report.gridy = 5;
		panel_Report.add(scrollPane_Report, gbc_scrollPane_Report);

		table_Report = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(220, 220, 220);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		TableCellRenderer headerReport = table_Report.getTableHeader().getDefaultRenderer();
		JLabel labelReport = (JLabel) headerReport;
		labelReport.setHorizontalAlignment(JLabel.CENTER);
		table_Report.setFont(new Font("Serif", Font.PLAIN, 15));
		table_Report.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
		table_Report.setRowHeight(table_Report.getRowHeight() + 10);
		table_Report.setShowGrid(true);
		table_Report.setBackground(Color.WHITE);

		table_Report.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table_ReportMousePressed(e);
			}
		});
		scrollPane_Report.setViewportView(table_Report);

		panel_25 = new JPanel();
		panel_25.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_25.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_25 = new GridBagConstraints();
		gbc_panel_25.gridheight = 6;
		gbc_panel_25.gridwidth = 2;
		gbc_panel_25.insets = new Insets(0, 0, 5, 5);
		gbc_panel_25.fill = GridBagConstraints.BOTH;
		gbc_panel_25.gridx = 6;
		gbc_panel_25.gridy = 2;
		panel_Report.add(panel_25, gbc_panel_25);
		GridBagLayout gbl_panel_25 = new GridBagLayout();
		gbl_panel_25.columnWidths = new int[] { 43, 204, 140, 127, 31, 0 };
		gbl_panel_25.rowHeights = new int[] { 55, 47, 45, 45, 45, 45, 45, 45, 45, 45, 45, 45, 30, 30, 0 };
		gbl_panel_25.columnWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_25.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		panel_25.setLayout(gbl_panel_25);

		lblNewLabel_24 = new JLabel("SALARY SUMMARY");
		lblNewLabel_24.setForeground(new Color(0, 51, 204));
		lblNewLabel_24.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 51, 153)));
		lblNewLabel_24.setFont(new Font("Sitka Heading", Font.BOLD, 25));
		GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
		gbc_lblNewLabel_24.gridwidth = 5;
		gbc_lblNewLabel_24.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_24.gridx = 0;
		gbc_lblNewLabel_24.gridy = 0;
		panel_25.add(lblNewLabel_24, gbc_lblNewLabel_24);

		lblMonth_Dept = new JLabel("");
		lblMonth_Dept.setFont(new Font("Serif", Font.BOLD, 23));
		GridBagConstraints gbc_lblMonth_Dept = new GridBagConstraints();
		gbc_lblMonth_Dept.gridwidth = 5;
		gbc_lblMonth_Dept.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonth_Dept.gridx = 0;
		gbc_lblMonth_Dept.gridy = 1;
		panel_25.add(lblMonth_Dept, gbc_lblMonth_Dept);

		lblShowName_report = new JLabel("Total Employee:");
		lblShowName_report.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblShowName_report = new GridBagConstraints();
		gbc_lblShowName_report.anchor = GridBagConstraints.EAST;
		gbc_lblShowName_report.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowName_report.gridx = 1;
		gbc_lblShowName_report.gridy = 2;
		panel_25.add(lblShowName_report, gbc_lblShowName_report);

		lblTotalEmp_rp = new JLabel("");
		lblTotalEmp_rp.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTotalEmp_rp = new GridBagConstraints();
		gbc_lblTotalEmp_rp.gridwidth = 2;
		gbc_lblTotalEmp_rp.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalEmp_rp.gridx = 2;
		gbc_lblTotalEmp_rp.gridy = 2;
		panel_25.add(lblTotalEmp_rp, gbc_lblTotalEmp_rp);

		lblNewLabel_18 = new JLabel("Total meal allowances:");
		lblNewLabel_18.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_18.gridx = 1;
		gbc_lblNewLabel_18.gridy = 3;
		panel_25.add(lblNewLabel_18, gbc_lblNewLabel_18);

		lblTotalMeal_rp = new JLabel("");
		lblTotalMeal_rp.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTotalMeal_rp = new GridBagConstraints();
		gbc_lblTotalMeal_rp.anchor = GridBagConstraints.EAST;
		gbc_lblTotalMeal_rp.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalMeal_rp.gridx = 2;
		gbc_lblTotalMeal_rp.gridy = 3;
		panel_25.add(lblTotalMeal_rp, gbc_lblTotalMeal_rp);

		lblNewLabel_19 = new JLabel("Total night allowances:");
		lblNewLabel_19.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 1;
		gbc_lblNewLabel_19.gridy = 4;
		panel_25.add(lblNewLabel_19, gbc_lblNewLabel_19);

		lblTotalNight_rp = new JLabel("");
		lblTotalNight_rp.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTotalNight_rp = new GridBagConstraints();
		gbc_lblTotalNight_rp.anchor = GridBagConstraints.EAST;
		gbc_lblTotalNight_rp.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalNight_rp.gridx = 2;
		gbc_lblTotalNight_rp.gridy = 4;
		panel_25.add(lblTotalNight_rp, gbc_lblTotalNight_rp);

		lblNewLabel_20 = new JLabel("Total overtime salary:");
		lblNewLabel_20.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_20.gridx = 1;
		gbc_lblNewLabel_20.gridy = 5;
		panel_25.add(lblNewLabel_20, gbc_lblNewLabel_20);

		lblTotalOTSal_rp = new JLabel("");
		lblTotalOTSal_rp.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTotalOTSal_rp = new GridBagConstraints();
		gbc_lblTotalOTSal_rp.anchor = GridBagConstraints.EAST;
		gbc_lblTotalOTSal_rp.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalOTSal_rp.gridx = 2;
		gbc_lblTotalOTSal_rp.gridy = 5;
		panel_25.add(lblTotalOTSal_rp, gbc_lblTotalOTSal_rp);

		panel_26 = new JPanel();
		panel_26.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_26.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_26 = new GridBagConstraints();
		gbc_panel_26.gridwidth = 3;
		gbc_panel_26.insets = new Insets(0, 0, 5, 5);
		gbc_panel_26.fill = GridBagConstraints.BOTH;
		gbc_panel_26.gridx = 1;
		gbc_panel_26.gridy = 6;
		panel_25.add(panel_26, gbc_panel_26);
		GridBagLayout gbl_panel_26 = new GridBagLayout();
		gbl_panel_26.columnWidths = new int[] { 206, 135, 0 };
		gbl_panel_26.rowHeights = new int[] { 39, 0 };
		gbl_panel_26.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_26.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_26.setLayout(gbl_panel_26);

		lblNewLabel_17 = new JLabel("Total salary:");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_17.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_17.gridx = 0;
		gbc_lblNewLabel_17.gridy = 0;
		panel_26.add(lblNewLabel_17, gbc_lblNewLabel_17);
		lblNewLabel_17.setFont(new Font("Serif", Font.BOLD, 20));

		lblTotalSal_rp = new JLabel("");
		GridBagConstraints gbc_lblTotalSal_rp = new GridBagConstraints();
		gbc_lblTotalSal_rp.anchor = GridBagConstraints.EAST;
		gbc_lblTotalSal_rp.gridx = 1;
		gbc_lblTotalSal_rp.gridy = 0;
		panel_26.add(lblTotalSal_rp, gbc_lblTotalSal_rp);
		lblTotalSal_rp.setFont(new Font("Serif", Font.PLAIN, 20));

		lblNewLabel_21 = new JLabel("Total salary deduction:");
		lblNewLabel_21.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_21.gridx = 1;
		gbc_lblNewLabel_21.gridy = 7;
		panel_25.add(lblNewLabel_21, gbc_lblNewLabel_21);

		lblTotalDeduc_rp = new JLabel("");
		lblTotalDeduc_rp.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTotalDeduc_rp = new GridBagConstraints();
		gbc_lblTotalDeduc_rp.anchor = GridBagConstraints.EAST;
		gbc_lblTotalDeduc_rp.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalDeduc_rp.gridx = 2;
		gbc_lblTotalDeduc_rp.gridy = 7;
		panel_25.add(lblTotalDeduc_rp, gbc_lblTotalDeduc_rp);

		lblNewLabel_22 = new JLabel("Total insurance:");
		lblNewLabel_22.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
		gbc_lblNewLabel_22.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_22.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_22.gridx = 1;
		gbc_lblNewLabel_22.gridy = 8;
		panel_25.add(lblNewLabel_22, gbc_lblNewLabel_22);

		lblTotalInsurance_rp = new JLabel("");
		lblTotalInsurance_rp.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTotalInsurance_rp = new GridBagConstraints();
		gbc_lblTotalInsurance_rp.anchor = GridBagConstraints.EAST;
		gbc_lblTotalInsurance_rp.insets = new Insets(0, 0, 5, 5);
		gbc_lblTotalInsurance_rp.gridx = 2;
		gbc_lblTotalInsurance_rp.gridy = 8;
		panel_25.add(lblTotalInsurance_rp, gbc_lblTotalInsurance_rp);

		panel_42 = new JPanel();
		panel_42.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_42.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_42 = new GridBagConstraints();
		gbc_panel_42.gridwidth = 3;
		gbc_panel_42.insets = new Insets(0, 0, 5, 5);
		gbc_panel_42.fill = GridBagConstraints.BOTH;
		gbc_panel_42.gridx = 1;
		gbc_panel_42.gridy = 9;
		panel_25.add(panel_42, gbc_panel_42);
		GridBagLayout gbl_panel_42 = new GridBagLayout();
		gbl_panel_42.columnWidths = new int[] { 205, 135, 0 };
		gbl_panel_42.rowHeights = new int[] { 40, 0 };
		gbl_panel_42.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_42.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_42.setLayout(gbl_panel_42);

		lblNewLabel_16 = new JLabel("Total net pay:");
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_16.gridx = 0;
		gbc_lblNewLabel_16.gridy = 0;
		panel_42.add(lblNewLabel_16, gbc_lblNewLabel_16);
		lblNewLabel_16.setFont(new Font("Times New Roman", Font.BOLD, 18));

		lblTotalNetpay_rp = new JLabel("");
		GridBagConstraints gbc_lblTotalNetpay_rp = new GridBagConstraints();
		gbc_lblTotalNetpay_rp.anchor = GridBagConstraints.EAST;
		gbc_lblTotalNetpay_rp.gridx = 1;
		gbc_lblTotalNetpay_rp.gridy = 0;
		panel_42.add(lblTotalNetpay_rp, gbc_lblTotalNetpay_rp);
		lblTotalNetpay_rp.setFont(new Font("Times New Roman", Font.BOLD, 20));

		lblNewLabel_14 = new JLabel("Highest net pay:");
		lblNewLabel_14.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 1;
		gbc_lblNewLabel_14.gridy = 10;
		panel_25.add(lblNewLabel_14, gbc_lblNewLabel_14);

		lblHighNetpay_rp = new JLabel("");
		lblHighNetpay_rp.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblHighNetpay_rp = new GridBagConstraints();
		gbc_lblHighNetpay_rp.anchor = GridBagConstraints.EAST;
		gbc_lblHighNetpay_rp.insets = new Insets(0, 0, 5, 5);
		gbc_lblHighNetpay_rp.gridx = 2;
		gbc_lblHighNetpay_rp.gridy = 10;
		panel_25.add(lblHighNetpay_rp, gbc_lblHighNetpay_rp);

		lblNewLabel_25 = new JLabel("Lowest net pay:");
		GridBagConstraints gbc_lblNewLabel_25 = new GridBagConstraints();
		gbc_lblNewLabel_25.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_25.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_25.gridx = 1;
		gbc_lblNewLabel_25.gridy = 11;
		panel_25.add(lblNewLabel_25, gbc_lblNewLabel_25);
		lblNewLabel_25.setFont(new Font("Serif", Font.BOLD, 20));

		lblLowNetpay_rp = new JLabel("");
		lblLowNetpay_rp.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblLowNetpay_rp = new GridBagConstraints();
		gbc_lblLowNetpay_rp.anchor = GridBagConstraints.EAST;
		gbc_lblLowNetpay_rp.insets = new Insets(0, 0, 5, 5);
		gbc_lblLowNetpay_rp.gridx = 2;
		gbc_lblLowNetpay_rp.gridy = 11;
		panel_25.add(lblLowNetpay_rp, gbc_lblLowNetpay_rp);

		panel_27 = new JPanel();
		panel_27.setBorder(new MatteBorder(1, 0, 1, 0, (Color) new Color(0, 0, 0)));
		panel_27.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_27 = new GridBagConstraints();
		gbc_panel_27.gridwidth = 3;
		gbc_panel_27.insets = new Insets(0, 0, 5, 5);
		gbc_panel_27.fill = GridBagConstraints.BOTH;
		gbc_panel_27.gridx = 1;
		gbc_panel_27.gridy = 12;
		panel_25.add(panel_27, gbc_panel_27);
		GridBagLayout gbl_panel_27 = new GridBagLayout();
		gbl_panel_27.columnWidths = new int[] { 205, 135, 0 };
		gbl_panel_27.rowHeights = new int[] { 45, 0 };
		gbl_panel_27.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_27.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel_27.setLayout(gbl_panel_27);

		lblNewLabel_23 = new JLabel("Average net pay:");
		GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
		gbc_lblNewLabel_23.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_23.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_23.gridx = 0;
		gbc_lblNewLabel_23.gridy = 0;
		panel_27.add(lblNewLabel_23, gbc_lblNewLabel_23);
		lblNewLabel_23.setFont(new Font("Serif", Font.BOLD, 20));

		lblAvgNetpay_rp = new JLabel("");
		GridBagConstraints gbc_lblAvgNetpay_rp = new GridBagConstraints();
		gbc_lblAvgNetpay_rp.anchor = GridBagConstraints.EAST;
		gbc_lblAvgNetpay_rp.gridx = 1;
		gbc_lblAvgNetpay_rp.gridy = 0;
		panel_27.add(lblAvgNetpay_rp, gbc_lblAvgNetpay_rp);
		lblAvgNetpay_rp.setFont(new Font("Serif", Font.PLAIN, 20));

		btnExport_Report = new JButton("", export);
		btnExport_Report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnExport_ReportActionPerformed(e);
			}
		});
		btnExport_Report.setVisible(false);
		GridBagConstraints gbc_btnExport_Report = new GridBagConstraints();
		gbc_btnExport_Report.anchor = GridBagConstraints.EAST;
		gbc_btnExport_Report.insets = new Insets(0, 0, 0, 5);
		gbc_btnExport_Report.gridx = 3;
		gbc_btnExport_Report.gridy = 13;
		panel_25.add(btnExport_Report, gbc_btnExport_Report);

		panel_Request = new JPanel();
		panel_Request.setBackground(Color.WHITE);
		panel.add(panel_Request, "request");
		GridBagLayout gbl_panel_Request = new GridBagLayout();
		gbl_panel_Request.columnWidths = new int[] { 73, 0, 412, 250, 69, 210, 253, 66, 0 };
		gbl_panel_Request.rowHeights = new int[] { 90, 30, 45, 188, 26, 289, 107, -12, 0 };
		gbl_panel_Request.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Request.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_Request.setLayout(gbl_panel_Request);

		panel_22 = new JPanel();
		panel_22 = new GradientPanel(Color.white, new Color(0, 160, 255), 3);
		panel_22.setBackground(new Color(0, 204, 255));
		GridBagConstraints gbc_panel_22 = new GridBagConstraints();
		gbc_panel_22.gridwidth = 8;
		gbc_panel_22.insets = new Insets(0, 0, 5, 0);
		gbc_panel_22.fill = GridBagConstraints.BOTH;
		gbc_panel_22.gridx = 0;
		gbc_panel_22.gridy = 0;
		panel_Request.add(panel_22, gbc_panel_22);
		panel_22.setLayout(new BorderLayout(0, 0));

		lblNewLabel_10 = new JLabel("HR MANAGEMENT");
		lblNewLabel_10.setForeground(new Color(255, 255, 204));
		lblNewLabel_10.setBackground(new Color(255, 255, 255));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_22.add(lblNewLabel_10, BorderLayout.CENTER);

		lblCheckName_rq = new JLabel("");
		lblCheckName_rq.setForeground(new Color(255, 0, 0));
		lblCheckName_rq.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		GridBagConstraints gbc_lblCheckName_rq = new GridBagConstraints();
		gbc_lblCheckName_rq.anchor = GridBagConstraints.SOUTH;
		gbc_lblCheckName_rq.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckName_rq.gridx = 2;
		gbc_lblCheckName_rq.gridy = 1;
		panel_Request.add(lblCheckName_rq, gbc_lblCheckName_rq);

		panel_40 = new JPanel();
		panel_40.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_40 = new GridBagConstraints();
		gbc_panel_40.insets = new Insets(0, 0, 5, 5);
		gbc_panel_40.fill = GridBagConstraints.BOTH;
		gbc_panel_40.gridx = 2;
		gbc_panel_40.gridy = 2;
		panel_Request.add(panel_40, gbc_panel_40);
		GridBagLayout gbl_panel_40 = new GridBagLayout();
		gbl_panel_40.columnWidths = new int[] { 113, 209, 0, 0 };
		gbl_panel_40.rowHeights = new int[] { 40, 0 };
		gbl_panel_40.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_40.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_40.setLayout(gbl_panel_40);

		lblNewLabel_28 = new JLabel("Search name:");
		GridBagConstraints gbc_lblNewLabel_28 = new GridBagConstraints();
		gbc_lblNewLabel_28.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_28.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_28.gridx = 0;
		gbc_lblNewLabel_28.gridy = 0;
		panel_40.add(lblNewLabel_28, gbc_lblNewLabel_28);
		lblNewLabel_28.setFont(new Font("Serif", Font.BOLD, 20));

		txtSearch_Rq = new JTextField();
		txtSearch_Rq.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 204), new Color(0, 51, 153)));
		txtSearch_Rq.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_txtSearch_Rq = new GridBagConstraints();
		gbc_txtSearch_Rq.insets = new Insets(0, 0, 0, 5);
		gbc_txtSearch_Rq.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearch_Rq.gridx = 1;
		gbc_txtSearch_Rq.gridy = 0;
		panel_40.add(txtSearch_Rq, gbc_txtSearch_Rq);
		txtSearch_Rq.setColumns(10);

		btnSearch_RQ = new JButton("", search);
		btnSearch_RQ.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearch_RQActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnSearch_RQ = new GridBagConstraints();
		gbc_btnSearch_RQ.gridx = 2;
		gbc_btnSearch_RQ.gridy = 0;
		panel_40.add(btnSearch_RQ, gbc_btnSearch_RQ);

		panel_23 = new JPanel();
		panel_23.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_23 = new GridBagConstraints();
		gbc_panel_23.insets = new Insets(0, 0, 5, 5);
		gbc_panel_23.gridwidth = 5;
		gbc_panel_23.fill = GridBagConstraints.BOTH;
		gbc_panel_23.gridx = 2;
		gbc_panel_23.gridy = 3;
		panel_Request.add(panel_23, gbc_panel_23);
		panel_23.setLayout(new BorderLayout(0, 0));

		scrollPane_1 = new JScrollPane();
		panel_23.add(scrollPane_1, BorderLayout.CENTER);

		table_Request = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(220, 220, 220);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};

		TableCellRenderer headerRequest = table_Request.getTableHeader().getDefaultRenderer();
		JLabel labelRequest = (JLabel) headerRequest;
		labelRequest.setHorizontalAlignment(JLabel.CENTER);
		table_Request.setFont(new Font("Serif", Font.PLAIN, 16));
		table_Request.getTableHeader().setFont(new Font("Serif", Font.BOLD, 18));
		table_Request.setRowHeight(table_Request.getRowHeight() + 10);
		table_Request.setShowGrid(true);
		table_Request.setBackground(Color.WHITE);

		table_Request.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table_RequestMousePressed(e);
			}
		});
		scrollPane_1.setViewportView(table_Request);

		panel_34 = new JPanel();
		panel_34.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(0, 0, 0)));
		panel_34.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_34 = new GridBagConstraints();
		gbc_panel_34.gridheight = 2;
		gbc_panel_34.gridwidth = 5;
		gbc_panel_34.insets = new Insets(0, 0, 5, 5);
		gbc_panel_34.fill = GridBagConstraints.BOTH;
		gbc_panel_34.gridx = 2;
		gbc_panel_34.gridy = 5;
		panel_Request.add(panel_34, gbc_panel_34);
		GridBagLayout gbl_panel_34 = new GridBagLayout();
		gbl_panel_34.columnWidths = new int[] { 105, 113, 172, 173, 66, 210, 91, 84, 102, 84, 0 };
		gbl_panel_34.rowHeights = new int[] { 64, 47, 48, 48, 48, 48, 48, 0, 32, 0 };
		gbl_panel_34.columnWeights = new double[] { 1.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0,
				Double.MIN_VALUE };
		gbl_panel_34.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_34.setLayout(gbl_panel_34);

		lblNewLabel_47 = new JLabel("Leave Information");
		lblNewLabel_47.setForeground(new Color(0, 51, 204));
		lblNewLabel_47.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		lblNewLabel_47.setFont(new Font("Sitka Banner", Font.BOLD, 28));
		GridBagConstraints gbc_lblNewLabel_47 = new GridBagConstraints();
		gbc_lblNewLabel_47.gridwidth = 5;
		gbc_lblNewLabel_47.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_47.gridx = 0;
		gbc_lblNewLabel_47.gridy = 0;
		panel_34.add(lblNewLabel_47, gbc_lblNewLabel_47);

		lblNewLabel_40 = new JLabel("Request Information");
		lblNewLabel_40.setForeground(new Color(0, 51, 204));
		lblNewLabel_40.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_lblNewLabel_40 = new GridBagConstraints();
		gbc_lblNewLabel_40.gridwidth = 5;
		gbc_lblNewLabel_40.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_40.gridx = 5;
		gbc_lblNewLabel_40.gridy = 0;
		panel_34.add(lblNewLabel_40, gbc_lblNewLabel_40);
		lblNewLabel_40.setFont(new Font("Sitka Banner", Font.BOLD, 28));

		lblNewLabel_34 = new JLabel("Fullname:");
		GridBagConstraints gbc_lblNewLabel_34 = new GridBagConstraints();
		gbc_lblNewLabel_34.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_34.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_34.gridx = 1;
		gbc_lblNewLabel_34.gridy = 1;
		panel_34.add(lblNewLabel_34, gbc_lblNewLabel_34);
		lblNewLabel_34.setFont(new Font("Serif", Font.BOLD, 20));

		lblName_Leave = new JLabel("");
		GridBagConstraints gbc_lblName_Leave = new GridBagConstraints();
		gbc_lblName_Leave.anchor = GridBagConstraints.WEST;
		gbc_lblName_Leave.gridwidth = 2;
		gbc_lblName_Leave.insets = new Insets(0, 0, 5, 5);
		gbc_lblName_Leave.gridx = 2;
		gbc_lblName_Leave.gridy = 1;
		panel_34.add(lblName_Leave, gbc_lblName_Leave);
		lblName_Leave.setFont(new Font("Serif", Font.PLAIN, 20));

		panel_32 = new JPanel();
		panel_32.setBorder(new MatteBorder(0, 2, 0, 0, (Color) new Color(0, 0, 0)));
		GridBagConstraints gbc_panel_32 = new GridBagConstraints();
		gbc_panel_32.gridwidth = 6;
		gbc_panel_32.anchor = GridBagConstraints.NORTH;
		gbc_panel_32.gridheight = 6;
		gbc_panel_32.insets = new Insets(0, 0, 5, 0);
		gbc_panel_32.gridx = 4;
		gbc_panel_32.gridy = 1;
		panel_34.add(panel_32, gbc_panel_32);
		panel_32.setBackground(Color.WHITE);
		GridBagLayout gbl_panel_32 = new GridBagLayout();
		gbl_panel_32.columnWidths = new int[] { 170, 124, 76, 81, 158, 0 };
		gbl_panel_32.rowHeights = new int[] { 40, 40, 40, 40, 40, 40, 40, 0 };
		gbl_panel_32.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_32.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_32.setLayout(gbl_panel_32);

		lblNewLabel_32 = new JLabel("ID Request:");
		lblNewLabel_32.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_32 = new GridBagConstraints();
		gbc_lblNewLabel_32.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_32.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_32.gridx = 0;
		gbc_lblNewLabel_32.gridy = 0;
		panel_32.add(lblNewLabel_32, gbc_lblNewLabel_32);

		lblShowId_RQ = new JLabel("");
		lblShowId_RQ.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblShowId_RQ = new GridBagConstraints();
		gbc_lblShowId_RQ.anchor = GridBagConstraints.WEST;
		gbc_lblShowId_RQ.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowId_RQ.gridx = 1;
		gbc_lblShowId_RQ.gridy = 0;
		panel_32.add(lblShowId_RQ, gbc_lblShowId_RQ);

		lblNewLabel_45 = new JLabel("From:");
		lblNewLabel_45.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_45 = new GridBagConstraints();
		gbc_lblNewLabel_45.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_45.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_45.gridx = 0;
		gbc_lblNewLabel_45.gridy = 1;
		panel_32.add(lblNewLabel_45, gbc_lblNewLabel_45);

		lblShowFrom_RQ = new JLabel("");
		lblShowFrom_RQ.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblShowFrom_RQ = new GridBagConstraints();
		gbc_lblShowFrom_RQ.anchor = GridBagConstraints.WEST;
		gbc_lblShowFrom_RQ.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowFrom_RQ.gridx = 1;
		gbc_lblShowFrom_RQ.gridy = 1;
		panel_32.add(lblShowFrom_RQ, gbc_lblShowFrom_RQ);

		lblNewLabel_46 = new JLabel("To:");
		lblNewLabel_46.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_46 = new GridBagConstraints();
		gbc_lblNewLabel_46.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_46.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_46.gridx = 2;
		gbc_lblNewLabel_46.gridy = 1;
		panel_32.add(lblNewLabel_46, gbc_lblNewLabel_46);

		lblShowTo_RQ = new JLabel("");
		lblShowTo_RQ.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblShowTo_RQ = new GridBagConstraints();
		gbc_lblShowTo_RQ.gridwidth = 2;
		gbc_lblShowTo_RQ.anchor = GridBagConstraints.WEST;
		gbc_lblShowTo_RQ.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowTo_RQ.gridx = 3;
		gbc_lblShowTo_RQ.gridy = 1;
		panel_32.add(lblShowTo_RQ, gbc_lblShowTo_RQ);

		lblNewLabel_33 = new JLabel("Note:");
		lblNewLabel_33.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_33 = new GridBagConstraints();
		gbc_lblNewLabel_33.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_33.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_33.gridx = 0;
		gbc_lblNewLabel_33.gridy = 2;
		panel_32.add(lblNewLabel_33, gbc_lblNewLabel_33);

		lblShowNote_RQ = new JLabel("");
		lblShowNote_RQ.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblShowNote_RQ = new GridBagConstraints();
		gbc_lblShowNote_RQ.gridwidth = 2;
		gbc_lblShowNote_RQ.anchor = GridBagConstraints.WEST;
		gbc_lblShowNote_RQ.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowNote_RQ.gridx = 1;
		gbc_lblShowNote_RQ.gridy = 2;
		panel_32.add(lblShowNote_RQ, gbc_lblShowNote_RQ);

		lblNewLabel_41 = new JLabel("Annual leave:");
		lblNewLabel_41.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_41 = new GridBagConstraints();
		gbc_lblNewLabel_41.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_41.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_41.gridx = 0;
		gbc_lblNewLabel_41.gridy = 3;
		panel_32.add(lblNewLabel_41, gbc_lblNewLabel_41);

		lblShowAL_RQ = new JLabel("");
		lblShowAL_RQ.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblShowAL_RQ = new GridBagConstraints();
		gbc_lblShowAL_RQ.anchor = GridBagConstraints.WEST;
		gbc_lblShowAL_RQ.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowAL_RQ.gridx = 1;
		gbc_lblShowAL_RQ.gridy = 3;
		panel_32.add(lblShowAL_RQ, gbc_lblShowAL_RQ);

		lblNewLabel_42 = new JLabel("Sick leave:");
		lblNewLabel_42.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_42 = new GridBagConstraints();
		gbc_lblNewLabel_42.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_42.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_42.gridx = 0;
		gbc_lblNewLabel_42.gridy = 4;
		panel_32.add(lblNewLabel_42, gbc_lblNewLabel_42);

		lblShowSL_RQ = new JLabel("");
		lblShowSL_RQ.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblShowSL_RQ = new GridBagConstraints();
		gbc_lblShowSL_RQ.anchor = GridBagConstraints.WEST;
		gbc_lblShowSL_RQ.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowSL_RQ.gridx = 1;
		gbc_lblShowSL_RQ.gridy = 4;
		panel_32.add(lblShowSL_RQ, gbc_lblShowSL_RQ);

		lblNewLabel_43 = new JLabel("Unpaid leave:");
		lblNewLabel_43.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_43 = new GridBagConstraints();
		gbc_lblNewLabel_43.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_43.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_43.gridx = 0;
		gbc_lblNewLabel_43.gridy = 5;
		panel_32.add(lblNewLabel_43, gbc_lblNewLabel_43);

		lblShowUL_RQ = new JLabel("");
		lblShowUL_RQ.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblShowUL_RQ = new GridBagConstraints();
		gbc_lblShowUL_RQ.anchor = GridBagConstraints.WEST;
		gbc_lblShowUL_RQ.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowUL_RQ.gridx = 1;
		gbc_lblShowUL_RQ.gridy = 5;
		panel_32.add(lblShowUL_RQ, gbc_lblShowUL_RQ);

		lblNewLabel_48 = new JLabel("Escalate:");
		lblNewLabel_48.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_48 = new GridBagConstraints();
		gbc_lblNewLabel_48.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_48.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_48.gridx = 0;
		gbc_lblNewLabel_48.gridy = 6;
		panel_32.add(lblNewLabel_48, gbc_lblNewLabel_48);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 6;
		panel_32.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 41, 52, 42, 0 };
		gbl_panel_2.rowHeights = new int[] { 43, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		lblNewLabel = new JLabel("ID Admin");
		lblNewLabel.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_2.add(lblNewLabel, gbc_lblNewLabel);

		comboBox_Adchoice = new JComboBox();
		GridBagConstraints gbc_comboBox_Adchoice = new GridBagConstraints();
		gbc_comboBox_Adchoice.gridwidth = 2;
		gbc_comboBox_Adchoice.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Adchoice.gridx = 2;
		gbc_comboBox_Adchoice.gridy = 0;
		panel_2.add(comboBox_Adchoice, gbc_comboBox_Adchoice);
		comboBox_Adchoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_AdchoiceActionPerformed(e);
			}
		});
		comboBox_Adchoice.setFont(new Font("Serif", Font.PLAIN, 20));

		panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 2;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 3;
		gbc_panel_4.gridy = 6;
		panel_32.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 51, 165, 0 };
		gbl_panel_4.rowHeights = new int[] { 40, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		lblNewLabel_49 = new JLabel("Name:");
		GridBagConstraints gbc_lblNewLabel_49 = new GridBagConstraints();
		gbc_lblNewLabel_49.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_49.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_49.gridx = 0;
		gbc_lblNewLabel_49.gridy = 0;
		panel_4.add(lblNewLabel_49, gbc_lblNewLabel_49);
		lblNewLabel_49.setFont(new Font("Serif", Font.BOLD, 20));

		lblShowName_Ad = new JLabel("");
		lblShowName_Ad.setFont(new Font("Serif", Font.PLAIN, 20));
		GridBagConstraints gbc_lblShowName_Ad = new GridBagConstraints();
		gbc_lblShowName_Ad.anchor = GridBagConstraints.WEST;
		gbc_lblShowName_Ad.gridx = 1;
		gbc_lblShowName_Ad.gridy = 0;
		panel_4.add(lblShowName_Ad, gbc_lblShowName_Ad);

		lblNewLabel_35 = new JLabel("Department:");
		GridBagConstraints gbc_lblNewLabel_35 = new GridBagConstraints();
		gbc_lblNewLabel_35.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_35.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_35.gridx = 1;
		gbc_lblNewLabel_35.gridy = 2;
		panel_34.add(lblNewLabel_35, gbc_lblNewLabel_35);
		lblNewLabel_35.setFont(new Font("Serif", Font.BOLD, 20));

		lblDept_Leave = new JLabel("");
		GridBagConstraints gbc_lblDept_Leave = new GridBagConstraints();
		gbc_lblDept_Leave.anchor = GridBagConstraints.WEST;
		gbc_lblDept_Leave.gridwidth = 2;
		gbc_lblDept_Leave.insets = new Insets(0, 0, 5, 5);
		gbc_lblDept_Leave.gridx = 2;
		gbc_lblDept_Leave.gridy = 2;
		panel_34.add(lblDept_Leave, gbc_lblDept_Leave);
		lblDept_Leave.setFont(new Font("Serif", Font.PLAIN, 20));

		lblNewLabel_39 = new JLabel("Onboard date:");
		GridBagConstraints gbc_lblNewLabel_39 = new GridBagConstraints();
		gbc_lblNewLabel_39.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_39.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_39.gridx = 1;
		gbc_lblNewLabel_39.gridy = 3;
		panel_34.add(lblNewLabel_39, gbc_lblNewLabel_39);
		lblNewLabel_39.setFont(new Font("Serif", Font.BOLD, 20));

		lblShowOnboard_Leave = new JLabel("");
		GridBagConstraints gbc_lblShowOnboard_Leave = new GridBagConstraints();
		gbc_lblShowOnboard_Leave.anchor = GridBagConstraints.WEST;
		gbc_lblShowOnboard_Leave.gridwidth = 2;
		gbc_lblShowOnboard_Leave.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowOnboard_Leave.gridx = 2;
		gbc_lblShowOnboard_Leave.gridy = 3;
		panel_34.add(lblShowOnboard_Leave, gbc_lblShowOnboard_Leave);
		lblShowOnboard_Leave.setFont(new Font("Serif", Font.PLAIN, 20));

		lblNewLabel_36 = new JLabel("Annual leave:");
		GridBagConstraints gbc_lblNewLabel_36 = new GridBagConstraints();
		gbc_lblNewLabel_36.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_36.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_36.gridx = 1;
		gbc_lblNewLabel_36.gridy = 4;
		panel_34.add(lblNewLabel_36, gbc_lblNewLabel_36);
		lblNewLabel_36.setFont(new Font("Serif", Font.BOLD, 20));

		lblShowAL_Leave = new JLabel("");
		GridBagConstraints gbc_lblShowAL_Leave = new GridBagConstraints();
		gbc_lblShowAL_Leave.anchor = GridBagConstraints.WEST;
		gbc_lblShowAL_Leave.gridwidth = 2;
		gbc_lblShowAL_Leave.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowAL_Leave.gridx = 2;
		gbc_lblShowAL_Leave.gridy = 4;
		panel_34.add(lblShowAL_Leave, gbc_lblShowAL_Leave);
		lblShowAL_Leave.setFont(new Font("Serif", Font.PLAIN, 20));

		lblNewLabel_37 = new JLabel("Sick leave:");
		GridBagConstraints gbc_lblNewLabel_37 = new GridBagConstraints();
		gbc_lblNewLabel_37.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_37.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_37.gridx = 1;
		gbc_lblNewLabel_37.gridy = 5;
		panel_34.add(lblNewLabel_37, gbc_lblNewLabel_37);
		lblNewLabel_37.setFont(new Font("Serif", Font.BOLD, 20));

		lblShowSL_Leave = new JLabel("");
		GridBagConstraints gbc_lblShowSL_Leave = new GridBagConstraints();
		gbc_lblShowSL_Leave.anchor = GridBagConstraints.WEST;
		gbc_lblShowSL_Leave.gridwidth = 2;
		gbc_lblShowSL_Leave.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowSL_Leave.gridx = 2;
		gbc_lblShowSL_Leave.gridy = 5;
		panel_34.add(lblShowSL_Leave, gbc_lblShowSL_Leave);
		lblShowSL_Leave.setFont(new Font("Serif", Font.PLAIN, 20));

		lblNewLabel_38 = new JLabel("Unpaid leave:");
		GridBagConstraints gbc_lblNewLabel_38 = new GridBagConstraints();
		gbc_lblNewLabel_38.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_38.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_38.gridx = 1;
		gbc_lblNewLabel_38.gridy = 6;
		panel_34.add(lblNewLabel_38, gbc_lblNewLabel_38);
		lblNewLabel_38.setFont(new Font("Serif", Font.BOLD, 20));

		lblShowUL_Leave = new JLabel("");
		GridBagConstraints gbc_lblShowUL_Leave = new GridBagConstraints();
		gbc_lblShowUL_Leave.anchor = GridBagConstraints.WEST;
		gbc_lblShowUL_Leave.gridwidth = 2;
		gbc_lblShowUL_Leave.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowUL_Leave.gridx = 2;
		gbc_lblShowUL_Leave.gridy = 6;
		panel_34.add(lblShowUL_Leave, gbc_lblShowUL_Leave);
		lblShowUL_Leave.setFont(new Font("Serif", Font.PLAIN, 20));

		btnUpdate_Leave = new JButton("Approve", done);
		GridBagConstraints gbc_btnUpdate_Leave = new GridBagConstraints();
		gbc_btnUpdate_Leave.anchor = GridBagConstraints.WEST;
		gbc_btnUpdate_Leave.insets = new Insets(0, 0, 5, 5);
		gbc_btnUpdate_Leave.gridx = 8;
		gbc_btnUpdate_Leave.gridy = 7;
		panel_34.add(btnUpdate_Leave, gbc_btnUpdate_Leave);
		btnUpdate_Leave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate_LeaveActionPerformed(e);
			}
		});
		btnUpdate_Leave.setFont(new Font("Serif", Font.BOLD, 20));

		panel_Salary = new JPanel();
		panel_Salary.setBackground(Color.WHITE);
		panel.add(panel_Salary, "salary");
		GridBagLayout gbl_panel_Salary = new GridBagLayout();
		gbl_panel_Salary.columnWidths = new int[] { 34, 585, 33, 107, 102, 382, 29, 0 };
		gbl_panel_Salary.rowHeights = new int[] { 124, -14, 116, 152, 219, 262, 65, 0 };
		gbl_panel_Salary.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_Salary.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_Salary.setLayout(gbl_panel_Salary);

		panel_28 = new JPanel();
		panel_28 = new GradientPanel(Color.white, new Color(0, 160, 255), 3);
		panel_28.setBackground(new Color(0, 204, 255));
		GridBagConstraints gbc_panel_28 = new GridBagConstraints();
		gbc_panel_28.gridwidth = 7;
		gbc_panel_28.insets = new Insets(0, 0, 5, 0);
		gbc_panel_28.fill = GridBagConstraints.BOTH;
		gbc_panel_28.gridx = 0;
		gbc_panel_28.gridy = 0;
		panel_Salary.add(panel_28, gbc_panel_28);
		panel_28.setLayout(new BorderLayout(0, 0));

		lblNewLabel_50 = new JLabel("HR MANAGEMENT");
		lblNewLabel_50.setForeground(new Color(255, 255, 204));
		lblNewLabel_50.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_50.setFont(new Font("Times New Roman", Font.BOLD, 30));
		panel_28.add(lblNewLabel_50, BorderLayout.CENTER);

		panel_44 = new JPanel();
		panel_44.setBorder(new CompoundBorder(new EmptyBorder(4, 4, 4, 4), new TitledBorder(null, "Salary Calculation",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		panel_44.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_44 = new GridBagConstraints();
		gbc_panel_44.insets = new Insets(0, 0, 5, 5);
		gbc_panel_44.fill = GridBagConstraints.BOTH;
		gbc_panel_44.gridx = 1;
		gbc_panel_44.gridy = 2;
		panel_Salary.add(panel_44, gbc_panel_44);
		GridBagLayout gbl_panel_44 = new GridBagLayout();
		gbl_panel_44.columnWidths = new int[] { 116, 71, 83, 102, 99, 0, 0 };
		gbl_panel_44.rowHeights = new int[] { 45, 40, 0 };
		gbl_panel_44.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_44.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_44.setLayout(gbl_panel_44);

		lblNewLabel_75 = new JLabel("Select a month:");
		lblNewLabel_75.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_75 = new GridBagConstraints();
		gbc_lblNewLabel_75.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_75.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_75.gridx = 0;
		gbc_lblNewLabel_75.gridy = 0;
		panel_44.add(lblNewLabel_75, gbc_lblNewLabel_75);

		comboBox_monthSal = new JComboBox();
		comboBox_monthSal.setModel(new DefaultComboBoxModel(new String[] { "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October", "November", "December" }));
		comboBox_monthSal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_comboBox_monthSal = new GridBagConstraints();
		gbc_comboBox_monthSal.gridwidth = 2;
		gbc_comboBox_monthSal.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_monthSal.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_monthSal.gridx = 1;
		gbc_comboBox_monthSal.gridy = 0;
		panel_44.add(comboBox_monthSal, gbc_comboBox_monthSal);

		btnCalSalary = new JButton("Get Payroll");
		btnCalSalary.setFont(new Font("Serif", Font.PLAIN, 17));
		btnCalSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCalSalaryActionPerformed(e);
			}
		});

		GridBagConstraints gbc_btnCalSalary = new GridBagConstraints();
		gbc_btnCalSalary.insets = new Insets(0, 0, 5, 5);
		gbc_btnCalSalary.gridx = 3;
		gbc_btnCalSalary.gridy = 0;
		panel_44.add(btnCalSalary, gbc_btnCalSalary);

		lblNewLabel_77 = new JLabel("Select payday:");
		GridBagConstraints gbc_lblNewLabel_77 = new GridBagConstraints();
		gbc_lblNewLabel_77.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_77.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_77.gridx = 0;
		gbc_lblNewLabel_77.gridy = 1;
		panel_44.add(lblNewLabel_77, gbc_lblNewLabel_77);
		lblNewLabel_77.setFont(new Font("Serif", Font.BOLD, 17));

		dateChooser_payday = new JDateChooser(new Date(), "yyyy-MM-dd");
		dateChooser_payday.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_dateChooser_payday = new GridBagConstraints();
		gbc_dateChooser_payday.fill = GridBagConstraints.HORIZONTAL;
		gbc_dateChooser_payday.gridwidth = 2;
		gbc_dateChooser_payday.insets = new Insets(0, 0, 0, 5);
		gbc_dateChooser_payday.gridx = 1;
		gbc_dateChooser_payday.gridy = 1;
		panel_44.add(dateChooser_payday, gbc_dateChooser_payday);

		lblNewLabel_78 = new JLabel("For month:");
		lblNewLabel_78.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_78 = new GridBagConstraints();
		gbc_lblNewLabel_78.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_78.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_78.gridx = 3;
		gbc_lblNewLabel_78.gridy = 1;
		panel_44.add(lblNewLabel_78, gbc_lblNewLabel_78);

		comboBox_monthSal_1 = new JComboBox();
		comboBox_monthSal_1.setModel(new DefaultComboBoxModel(new String[] { "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October", "November", "December" }));
		comboBox_monthSal_1.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_comboBox_monthSal_1 = new GridBagConstraints();
		gbc_comboBox_monthSal_1.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_monthSal_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_monthSal_1.gridx = 4;
		gbc_comboBox_monthSal_1.gridy = 1;
		panel_44.add(comboBox_monthSal_1, gbc_comboBox_monthSal_1);

		btnUpdate_Payday = new JButton("", updateDay);
		btnUpdate_Payday.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate_PaydayActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnUpdate_Payday = new GridBagConstraints();
		gbc_btnUpdate_Payday.gridx = 5;
		gbc_btnUpdate_Payday.gridy = 1;
		panel_44.add(btnUpdate_Payday, gbc_btnUpdate_Payday);

		panel_31 = new JPanel();
		panel_31.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		panel_31.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_31 = new GridBagConstraints();
		gbc_panel_31.gridheight = 4;
		gbc_panel_31.gridwidth = 3;
		gbc_panel_31.insets = new Insets(0, 0, 5, 5);
		gbc_panel_31.fill = GridBagConstraints.BOTH;
		gbc_panel_31.gridx = 3;
		gbc_panel_31.gridy = 2;
		panel_Salary.add(panel_31, gbc_panel_31);
		GridBagLayout gbl_panel_31 = new GridBagLayout();
		gbl_panel_31.columnWidths = new int[] { 136, 119, 71, 67, 181, 0 };
		gbl_panel_31.rowHeights = new int[] { 44, 33, 36, 34, 192, 193, 133, 22, 0, 0 };
		gbl_panel_31.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_31.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_31.setLayout(gbl_panel_31);

		lblNewLabel_51 = new JLabel("DETAIL SALARY");
		lblNewLabel_51.setForeground(new Color(0, 51, 153));
		lblNewLabel_51.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 51, 153)));
		lblNewLabel_51.setFont(new Font("Sitka Text", Font.BOLD, 23));
		GridBagConstraints gbc_lblNewLabel_51 = new GridBagConstraints();
		gbc_lblNewLabel_51.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_51.gridwidth = 5;
		gbc_lblNewLabel_51.gridx = 0;
		gbc_lblNewLabel_51.gridy = 0;
		panel_31.add(lblNewLabel_51, gbc_lblNewLabel_51);

		lblMonth_Salary = new JLabel("");
		lblMonth_Salary.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblMonth_Salary = new GridBagConstraints();
		gbc_lblMonth_Salary.gridwidth = 5;
		gbc_lblMonth_Salary.insets = new Insets(0, 0, 5, 0);
		gbc_lblMonth_Salary.gridx = 0;
		gbc_lblMonth_Salary.gridy = 1;
		panel_31.add(lblMonth_Salary, gbc_lblMonth_Salary);

		lblIdEmployee = new JLabel("ID Employee:");
		lblIdEmployee.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblIdEmployee = new GridBagConstraints();
		gbc_lblIdEmployee.anchor = GridBagConstraints.EAST;
		gbc_lblIdEmployee.insets = new Insets(0, 0, 5, 5);
		gbc_lblIdEmployee.gridx = 0;
		gbc_lblIdEmployee.gridy = 2;
		panel_31.add(lblIdEmployee, gbc_lblIdEmployee);

		lblId_Salary = new JLabel("");
		lblId_Salary.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblId_Salary = new GridBagConstraints();
		gbc_lblId_Salary.anchor = GridBagConstraints.WEST;
		gbc_lblId_Salary.insets = new Insets(0, 0, 5, 5);
		gbc_lblId_Salary.gridx = 1;
		gbc_lblId_Salary.gridy = 2;
		panel_31.add(lblId_Salary, gbc_lblId_Salary);

		lblDept_1 = new JLabel("Dept:");
		lblDept_1.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblDept_1 = new GridBagConstraints();
		gbc_lblDept_1.anchor = GridBagConstraints.EAST;
		gbc_lblDept_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblDept_1.gridx = 3;
		gbc_lblDept_1.gridy = 2;
		panel_31.add(lblDept_1, gbc_lblDept_1);

		lblDept_Salary = new JLabel("");
		lblDept_Salary.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblDept_Salary = new GridBagConstraints();
		gbc_lblDept_Salary.insets = new Insets(0, 0, 5, 0);
		gbc_lblDept_Salary.anchor = GridBagConstraints.WEST;
		gbc_lblDept_Salary.gridx = 4;
		gbc_lblDept_Salary.gridy = 2;
		panel_31.add(lblDept_Salary, gbc_lblDept_Salary);

		lbl = new JLabel("Fullname:");
		lbl.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lbl = new GridBagConstraints();
		gbc_lbl.anchor = GridBagConstraints.EAST;
		gbc_lbl.insets = new Insets(0, 0, 5, 5);
		gbc_lbl.gridx = 0;
		gbc_lbl.gridy = 3;
		panel_31.add(lbl, gbc_lbl);

		lblName_Salary = new JLabel("");
		lblName_Salary.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblName_Salary = new GridBagConstraints();
		gbc_lblName_Salary.anchor = GridBagConstraints.WEST;
		gbc_lblName_Salary.gridwidth = 2;
		gbc_lblName_Salary.insets = new Insets(0, 0, 5, 5);
		gbc_lblName_Salary.gridx = 1;
		gbc_lblName_Salary.gridy = 3;
		panel_31.add(lblName_Salary, gbc_lblName_Salary);

		lblPayday = new JLabel("Payday:");
		lblPayday.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblPayday = new GridBagConstraints();
		gbc_lblPayday.anchor = GridBagConstraints.EAST;
		gbc_lblPayday.insets = new Insets(0, 0, 5, 5);
		gbc_lblPayday.gridx = 3;
		gbc_lblPayday.gridy = 3;
		panel_31.add(lblPayday, gbc_lblPayday);

		lblPayday_Salary = new JLabel("");
		lblPayday_Salary.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblPayday_Salary = new GridBagConstraints();
		gbc_lblPayday_Salary.anchor = GridBagConstraints.WEST;
		gbc_lblPayday_Salary.insets = new Insets(0, 0, 5, 0);
		gbc_lblPayday_Salary.gridx = 4;
		gbc_lblPayday_Salary.gridy = 3;
		panel_31.add(lblPayday_Salary, gbc_lblPayday_Salary);

		panel_33 = new JPanel();
		panel_33.setBorder(new CompoundBorder(new EmptyBorder(4, 5, 4, 4), new TitledBorder(null, "ATTENDANCE",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		panel_33.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_33 = new GridBagConstraints();
		gbc_panel_33.insets = new Insets(0, 0, 5, 0);
		gbc_panel_33.gridwidth = 5;
		gbc_panel_33.fill = GridBagConstraints.BOTH;
		gbc_panel_33.gridx = 0;
		gbc_panel_33.gridy = 4;
		panel_31.add(panel_33, gbc_panel_33);
		GridBagLayout gbl_panel_33 = new GridBagLayout();
		gbl_panel_33.columnWidths = new int[] { 109, 59, 153, 34, 189, 0 };
		gbl_panel_33.rowHeights = new int[] { 38, 30, 30, 30, 26, 0 };
		gbl_panel_33.columnWeights = new double[] { 1.0, 1.0, 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_33.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_33.setLayout(gbl_panel_33);

		lblNewLabel_52 = new JLabel("Standard day:");
		lblNewLabel_52.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_52 = new GridBagConstraints();
		gbc_lblNewLabel_52.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_52.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_52.gridx = 0;
		gbc_lblNewLabel_52.gridy = 0;
		panel_33.add(lblNewLabel_52, gbc_lblNewLabel_52);

		lblShowSDay_Sal = new JLabel("");
		lblShowSDay_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblShowSDay_Sal = new GridBagConstraints();
		gbc_lblShowSDay_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowSDay_Sal.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowSDay_Sal.gridx = 1;
		gbc_lblShowSDay_Sal.gridy = 0;
		panel_33.add(lblShowSDay_Sal, gbc_lblShowSDay_Sal);

		panel_35 = new JPanel();
		panel_35.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		panel_35.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_35 = new GridBagConstraints();
		gbc_panel_35.gridheight = 5;
		gbc_panel_35.gridwidth = 2;
		gbc_panel_35.insets = new Insets(0, 0, 0, 5);
		gbc_panel_35.fill = GridBagConstraints.BOTH;
		gbc_panel_35.gridx = 2;
		gbc_panel_35.gridy = 0;
		panel_33.add(panel_35, gbc_panel_35);
		GridBagLayout gbl_panel_35 = new GridBagLayout();
		gbl_panel_35.columnWidths = new int[] { 123, 50, 0 };
		gbl_panel_35.rowHeights = new int[] { 30, 30, 30, 30, 30, 0 };
		gbl_panel_35.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_35.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_35.setLayout(gbl_panel_35);

		lblNewLabel_58 = new JLabel("Lunch:");
		lblNewLabel_58.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_58 = new GridBagConstraints();
		gbc_lblNewLabel_58.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_58.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_58.gridx = 0;
		gbc_lblNewLabel_58.gridy = 0;
		panel_35.add(lblNewLabel_58, gbc_lblNewLabel_58);

		lblShowLunch_Sal = new JLabel("");
		lblShowLunch_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblShowLunch_Sal = new GridBagConstraints();
		gbc_lblShowLunch_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowLunch_Sal.insets = new Insets(0, 0, 5, 0);
		gbc_lblShowLunch_Sal.gridx = 1;
		gbc_lblShowLunch_Sal.gridy = 0;
		panel_35.add(lblShowLunch_Sal, gbc_lblShowLunch_Sal);

		lblNewLabel_56 = new JLabel("Night shift:");
		lblNewLabel_56.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_56 = new GridBagConstraints();
		gbc_lblNewLabel_56.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_56.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_56.gridx = 0;
		gbc_lblNewLabel_56.gridy = 1;
		panel_35.add(lblNewLabel_56, gbc_lblNewLabel_56);

		lblShowNight_Sal = new JLabel("");
		lblShowNight_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblShowNight_Sal = new GridBagConstraints();
		gbc_lblShowNight_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowNight_Sal.insets = new Insets(0, 0, 5, 0);
		gbc_lblShowNight_Sal.gridx = 1;
		gbc_lblShowNight_Sal.gridy = 1;
		panel_35.add(lblShowNight_Sal, gbc_lblShowNight_Sal);

		lblNewLabel_57 = new JLabel("Offday work:");
		lblNewLabel_57.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_57 = new GridBagConstraints();
		gbc_lblNewLabel_57.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_57.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_57.gridx = 0;
		gbc_lblNewLabel_57.gridy = 2;
		panel_35.add(lblNewLabel_57, gbc_lblNewLabel_57);

		lblShowOffday_Sal = new JLabel("");
		lblShowOffday_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblShowOffday_Sal = new GridBagConstraints();
		gbc_lblShowOffday_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowOffday_Sal.insets = new Insets(0, 0, 5, 0);
		gbc_lblShowOffday_Sal.gridx = 1;
		gbc_lblShowOffday_Sal.gridy = 2;
		panel_35.add(lblShowOffday_Sal, gbc_lblShowOffday_Sal);

		lblNewLabel_59 = new JLabel("Holiday work:");
		lblNewLabel_59.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_59 = new GridBagConstraints();
		gbc_lblNewLabel_59.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_59.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_59.gridx = 0;
		gbc_lblNewLabel_59.gridy = 3;
		panel_35.add(lblNewLabel_59, gbc_lblNewLabel_59);

		lblShowHoli_Sal = new JLabel("");
		lblShowHoli_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblShowHoli_Sal = new GridBagConstraints();
		gbc_lblShowHoli_Sal.insets = new Insets(0, 0, 5, 0);
		gbc_lblShowHoli_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowHoli_Sal.gridx = 1;
		gbc_lblShowHoli_Sal.gridy = 3;
		panel_35.add(lblShowHoli_Sal, gbc_lblShowHoli_Sal);

		lblNewLabel_63 = new JLabel("Working day:");
		GridBagConstraints gbc_lblNewLabel_63 = new GridBagConstraints();
		gbc_lblNewLabel_63.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_63.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_63.gridx = 0;
		gbc_lblNewLabel_63.gridy = 4;
		panel_35.add(lblNewLabel_63, gbc_lblNewLabel_63);
		lblNewLabel_63.setFont(new Font("Serif", Font.BOLD, 17));

		lblShowWKday_Sal = new JLabel("");
		GridBagConstraints gbc_lblShowWKday_Sal = new GridBagConstraints();
		gbc_lblShowWKday_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowWKday_Sal.gridx = 1;
		gbc_lblShowWKday_Sal.gridy = 4;
		panel_35.add(lblShowWKday_Sal, gbc_lblShowWKday_Sal);
		lblShowWKday_Sal.setFont(new Font("Serif", Font.PLAIN, 17));

		panel_36 = new JPanel();
		panel_36.setBorder(new MatteBorder(0, 1, 0, 0, (Color) new Color(0, 0, 0)));
		panel_36.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_36 = new GridBagConstraints();
		gbc_panel_36.gridheight = 5;
		gbc_panel_36.fill = GridBagConstraints.BOTH;
		gbc_panel_36.gridx = 4;
		gbc_panel_36.gridy = 0;
		panel_33.add(panel_36, gbc_panel_36);
		GridBagLayout gbl_panel_36 = new GridBagLayout();
		gbl_panel_36.columnWidths = new int[] { 149, 41, 0 };
		gbl_panel_36.rowHeights = new int[] { 30, 30, 30, 30, 30, 0 };
		gbl_panel_36.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_36.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		panel_36.setLayout(gbl_panel_36);

		lblNewLabel_60 = new JLabel("OT hours:");
		lblNewLabel_60.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_60 = new GridBagConstraints();
		gbc_lblNewLabel_60.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_60.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_60.gridx = 0;
		gbc_lblNewLabel_60.gridy = 0;
		panel_36.add(lblNewLabel_60, gbc_lblNewLabel_60);

		lblShowOT_Sal = new JLabel("");
		lblShowOT_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblShowOT_Sal = new GridBagConstraints();
		gbc_lblShowOT_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowOT_Sal.insets = new Insets(0, 0, 5, 0);
		gbc_lblShowOT_Sal.gridx = 1;
		gbc_lblShowOT_Sal.gridy = 0;
		panel_36.add(lblShowOT_Sal, gbc_lblShowOT_Sal);

		lblNewLabel_61 = new JLabel("OT offday hours:");
		lblNewLabel_61.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_61 = new GridBagConstraints();
		gbc_lblNewLabel_61.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_61.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_61.gridx = 0;
		gbc_lblNewLabel_61.gridy = 1;
		panel_36.add(lblNewLabel_61, gbc_lblNewLabel_61);

		lblShowOTOff_Sal = new JLabel("");
		lblShowOTOff_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblShowOTOff_Sal = new GridBagConstraints();
		gbc_lblShowOTOff_Sal.insets = new Insets(0, 0, 5, 0);
		gbc_lblShowOTOff_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowOTOff_Sal.gridx = 1;
		gbc_lblShowOTOff_Sal.gridy = 1;
		panel_36.add(lblShowOTOff_Sal, gbc_lblShowOTOff_Sal);

		lblNewLabel_76 = new JLabel("OT holiday hours:");
		lblNewLabel_76.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_76 = new GridBagConstraints();
		gbc_lblNewLabel_76.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_76.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_76.gridx = 0;
		gbc_lblNewLabel_76.gridy = 2;
		panel_36.add(lblNewLabel_76, gbc_lblNewLabel_76);

		lblShowOTHoli_Sal = new JLabel("");
		lblShowOTHoli_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblShowOTHoli_Sal = new GridBagConstraints();
		gbc_lblShowOTHoli_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowOTHoli_Sal.insets = new Insets(0, 0, 5, 0);
		gbc_lblShowOTHoli_Sal.gridx = 1;
		gbc_lblShowOTHoli_Sal.gridy = 2;
		panel_36.add(lblShowOTHoli_Sal, gbc_lblShowOTHoli_Sal);

		lblNewLabel_79 = new JLabel("OTHL off hours:");
		lblNewLabel_79.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_79 = new GridBagConstraints();
		gbc_lblNewLabel_79.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_79.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_79.gridx = 0;
		gbc_lblNewLabel_79.gridy = 3;
		panel_36.add(lblNewLabel_79, gbc_lblNewLabel_79);

		lblShowOToffHL_Sal = new JLabel("");
		lblShowOToffHL_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblShowOToffHL_Sal = new GridBagConstraints();
		gbc_lblShowOToffHL_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowOToffHL_Sal.insets = new Insets(0, 0, 5, 0);
		gbc_lblShowOToffHL_Sal.gridx = 1;
		gbc_lblShowOToffHL_Sal.gridy = 3;
		panel_36.add(lblShowOToffHL_Sal, gbc_lblShowOToffHL_Sal);

		lblNewLabel_53 = new JLabel("Annual leave:");
		lblNewLabel_53.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_53 = new GridBagConstraints();
		gbc_lblNewLabel_53.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_53.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_53.gridx = 0;
		gbc_lblNewLabel_53.gridy = 1;
		panel_33.add(lblNewLabel_53, gbc_lblNewLabel_53);

		lblShowAL_Sal = new JLabel("");
		lblShowAL_Sal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblShowAL_Sal = new GridBagConstraints();
		gbc_lblShowAL_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowAL_Sal.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowAL_Sal.gridx = 1;
		gbc_lblShowAL_Sal.gridy = 1;
		panel_33.add(lblShowAL_Sal, gbc_lblShowAL_Sal);

		lblNewLabel_54 = new JLabel("Unpaid leave:");
		lblNewLabel_54.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_54 = new GridBagConstraints();
		gbc_lblNewLabel_54.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_54.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_54.gridx = 0;
		gbc_lblNewLabel_54.gridy = 2;
		panel_33.add(lblNewLabel_54, gbc_lblNewLabel_54);

		lblShowUL_Sal = new JLabel("");
		lblShowUL_Sal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblShowUL_Sal = new GridBagConstraints();
		gbc_lblShowUL_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowUL_Sal.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowUL_Sal.gridx = 1;
		gbc_lblShowUL_Sal.gridy = 2;
		panel_33.add(lblShowUL_Sal, gbc_lblShowUL_Sal);

		lblNewLabel_55 = new JLabel("Sick leave:");
		lblNewLabel_55.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_55 = new GridBagConstraints();
		gbc_lblNewLabel_55.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_55.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_55.gridx = 0;
		gbc_lblNewLabel_55.gridy = 3;
		panel_33.add(lblNewLabel_55, gbc_lblNewLabel_55);

		lblShowSL_Sal = new JLabel("");
		lblShowSL_Sal.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		GridBagConstraints gbc_lblShowSL_Sal = new GridBagConstraints();
		gbc_lblShowSL_Sal.anchor = GridBagConstraints.WEST;
		gbc_lblShowSL_Sal.insets = new Insets(0, 0, 5, 5);
		gbc_lblShowSL_Sal.gridx = 1;
		gbc_lblShowSL_Sal.gridy = 3;
		panel_33.add(lblShowSL_Sal, gbc_lblShowSL_Sal);

		panel_37 = new JPanel();
		panel_37.setBorder(new CompoundBorder(new EmptyBorder(4, 5, 4, 4),
				new TitledBorder(null, "SALARY", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		panel_37.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_37 = new GridBagConstraints();
		gbc_panel_37.insets = new Insets(0, 0, 5, 0);
		gbc_panel_37.gridwidth = 5;
		gbc_panel_37.fill = GridBagConstraints.BOTH;
		gbc_panel_37.gridx = 0;
		gbc_panel_37.gridy = 5;
		panel_31.add(panel_37, gbc_panel_37);
		GridBagLayout gbl_panel_37 = new GridBagLayout();
		gbl_panel_37.columnWidths = new int[] { 230, 99, 130, 0, 0 };
		gbl_panel_37.rowHeights = new int[] { 32, 32, 32, 32, 32, 0 };
		gbl_panel_37.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_37.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_37.setLayout(gbl_panel_37);

		lblNewLabel_62 = new JLabel("Basic salary:");
		lblNewLabel_62.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_62 = new GridBagConstraints();
		gbc_lblNewLabel_62.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_62.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_62.gridx = 0;
		gbc_lblNewLabel_62.gridy = 0;
		panel_37.add(lblNewLabel_62, gbc_lblNewLabel_62);

		lblBasicSal = new JLabel("");
		lblBasicSal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblBasicSal = new GridBagConstraints();
		gbc_lblBasicSal.anchor = GridBagConstraints.EAST;
		gbc_lblBasicSal.insets = new Insets(0, 0, 5, 5);
		gbc_lblBasicSal.gridx = 1;
		gbc_lblBasicSal.gridy = 0;
		panel_37.add(lblBasicSal, gbc_lblBasicSal);

		lblNewLabel_65 = new JLabel("Meal Allowances:");
		lblNewLabel_65.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_65 = new GridBagConstraints();
		gbc_lblNewLabel_65.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_65.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_65.gridx = 0;
		gbc_lblNewLabel_65.gridy = 1;
		panel_37.add(lblNewLabel_65, gbc_lblNewLabel_65);

		lblMeal = new JLabel("");
		lblMeal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblMeal = new GridBagConstraints();
		gbc_lblMeal.anchor = GridBagConstraints.EAST;
		gbc_lblMeal.insets = new Insets(0, 0, 5, 5);
		gbc_lblMeal.gridx = 1;
		gbc_lblMeal.gridy = 1;
		panel_37.add(lblMeal, gbc_lblMeal);

		lblNewLabel_66 = new JLabel("Night Allowances:");
		lblNewLabel_66.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_66 = new GridBagConstraints();
		gbc_lblNewLabel_66.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_66.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_66.gridx = 0;
		gbc_lblNewLabel_66.gridy = 2;
		panel_37.add(lblNewLabel_66, gbc_lblNewLabel_66);

		lblNight = new JLabel("");
		lblNight.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNight = new GridBagConstraints();
		gbc_lblNight.anchor = GridBagConstraints.EAST;
		gbc_lblNight.insets = new Insets(0, 0, 5, 5);
		gbc_lblNight.gridx = 1;
		gbc_lblNight.gridy = 2;
		panel_37.add(lblNight, gbc_lblNight);

		lblNewLabel_67 = new JLabel("OT salary:");
		GridBagConstraints gbc_lblNewLabel_67 = new GridBagConstraints();
		gbc_lblNewLabel_67.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_67.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_67.gridx = 0;
		gbc_lblNewLabel_67.gridy = 3;
		panel_37.add(lblNewLabel_67, gbc_lblNewLabel_67);
		lblNewLabel_67.setFont(new Font("Serif", Font.BOLD, 17));

		lblOT = new JLabel("");
		lblOT.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblOT = new GridBagConstraints();
		gbc_lblOT.anchor = GridBagConstraints.EAST;
		gbc_lblOT.insets = new Insets(0, 0, 5, 5);
		gbc_lblOT.gridx = 1;
		gbc_lblOT.gridy = 3;
		panel_37.add(lblOT, gbc_lblOT);

		lblNewLabel_70 = new JLabel("Total salary:");
		GridBagConstraints gbc_lblNewLabel_70 = new GridBagConstraints();
		gbc_lblNewLabel_70.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_70.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_70.gridx = 0;
		gbc_lblNewLabel_70.gridy = 4;
		panel_37.add(lblNewLabel_70, gbc_lblNewLabel_70);
		lblNewLabel_70.setFont(new Font("Serif", Font.BOLD, 17));

		lblTotal = new JLabel("");
		GridBagConstraints gbc_lblTotal = new GridBagConstraints();
		gbc_lblTotal.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotal.anchor = GridBagConstraints.EAST;
		gbc_lblTotal.gridx = 1;
		gbc_lblTotal.gridy = 4;
		panel_37.add(lblTotal, gbc_lblTotal);
		lblTotal.setFont(new Font("Serif", Font.PLAIN, 17));

		panel_41 = new JPanel();
		panel_41.setBackground(Color.WHITE);
		panel_41.setBorder(new CompoundBorder(new EmptyBorder(4, 5, 4, 4), new TitledBorder(null, "DEDUCTION",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		GridBagConstraints gbc_panel_41 = new GridBagConstraints();
		gbc_panel_41.insets = new Insets(0, 0, 5, 0);
		gbc_panel_41.gridwidth = 5;
		gbc_panel_41.fill = GridBagConstraints.BOTH;
		gbc_panel_41.gridx = 0;
		gbc_panel_41.gridy = 6;
		panel_31.add(panel_41, gbc_panel_41);
		GridBagLayout gbl_panel_41 = new GridBagLayout();
		gbl_panel_41.columnWidths = new int[] { 230, 100, 130, 0, 0 };
		gbl_panel_41.rowHeights = new int[] { 32, 32, 32, 0 };
		gbl_panel_41.columnWeights = new double[] { 1.0, 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_41.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_41.setLayout(gbl_panel_41);

		lblNewLabel_71 = new JLabel("Salary deduction:");
		lblNewLabel_71.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_71 = new GridBagConstraints();
		gbc_lblNewLabel_71.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_71.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_71.gridx = 0;
		gbc_lblNewLabel_71.gridy = 0;
		panel_41.add(lblNewLabel_71, gbc_lblNewLabel_71);

		lblDeduction = new JLabel("");
		lblDeduction.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblDeduction = new GridBagConstraints();
		gbc_lblDeduction.anchor = GridBagConstraints.EAST;
		gbc_lblDeduction.insets = new Insets(0, 0, 5, 5);
		gbc_lblDeduction.gridx = 1;
		gbc_lblDeduction.gridy = 0;
		panel_41.add(lblDeduction, gbc_lblDeduction);

		lblNewLabel_72 = new JLabel("Social insurance:");
		lblNewLabel_72.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_72 = new GridBagConstraints();
		gbc_lblNewLabel_72.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_72.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_72.gridx = 0;
		gbc_lblNewLabel_72.gridy = 1;
		panel_41.add(lblNewLabel_72, gbc_lblNewLabel_72);

		lblInsurance = new JLabel("");
		lblInsurance.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblInsurance = new GridBagConstraints();
		gbc_lblInsurance.anchor = GridBagConstraints.EAST;
		gbc_lblInsurance.insets = new Insets(0, 0, 5, 5);
		gbc_lblInsurance.gridx = 1;
		gbc_lblInsurance.gridy = 1;
		panel_41.add(lblInsurance, gbc_lblInsurance);

		lblNewLabel_73 = new JLabel("Total deduction:");
		GridBagConstraints gbc_lblNewLabel_73 = new GridBagConstraints();
		gbc_lblNewLabel_73.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_73.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_73.gridx = 0;
		gbc_lblNewLabel_73.gridy = 2;
		panel_41.add(lblNewLabel_73, gbc_lblNewLabel_73);
		lblNewLabel_73.setFont(new Font("Serif", Font.BOLD, 17));

		lblTotalDeduc = new JLabel("");
		GridBagConstraints gbc_lblTotalDeduc = new GridBagConstraints();
		gbc_lblTotalDeduc.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalDeduc.anchor = GridBagConstraints.EAST;
		gbc_lblTotalDeduc.gridx = 1;
		gbc_lblTotalDeduc.gridy = 2;
		panel_41.add(lblTotalDeduc, gbc_lblTotalDeduc);
		lblTotalDeduc.setFont(new Font("Serif", Font.PLAIN, 17));

		panel_43 = new JPanel();
		panel_43.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_43 = new GridBagConstraints();
		gbc_panel_43.insets = new Insets(0, 0, 5, 0);
		gbc_panel_43.gridwidth = 4;
		gbc_panel_43.fill = GridBagConstraints.BOTH;
		gbc_panel_43.gridx = 1;
		gbc_panel_43.gridy = 7;
		panel_31.add(panel_43, gbc_panel_43);
		GridBagLayout gbl_panel_43 = new GridBagLayout();
		gbl_panel_43.columnWidths = new int[] { 201, 121, 0 };
		gbl_panel_43.rowHeights = new int[] { 27, 0 };
		gbl_panel_43.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_43.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_43.setLayout(gbl_panel_43);

		lblNewLabel_74 = new JLabel("NET PAY:");
		lblNewLabel_74.setForeground(new Color(0, 0, 204));
		lblNewLabel_74.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 204)));
		lblNewLabel_74.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_74 = new GridBagConstraints();
		gbc_lblNewLabel_74.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_74.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_74.gridx = 0;
		gbc_lblNewLabel_74.gridy = 0;
		panel_43.add(lblNewLabel_74, gbc_lblNewLabel_74);

		lblNetPay = new JLabel("");
		lblNetPay.setForeground(new Color(0, 0, 204));
		lblNetPay.setFont(new Font("Serif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNetPay = new GridBagConstraints();
		gbc_lblNetPay.anchor = GridBagConstraints.WEST;
		gbc_lblNetPay.gridx = 1;
		gbc_lblNetPay.gridy = 0;
		panel_43.add(lblNetPay, gbc_lblNetPay);

		panel_38 = new JPanel();
		panel_38.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_38 = new GridBagConstraints();
		gbc_panel_38.insets = new Insets(0, 0, 5, 5);
		gbc_panel_38.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_38.gridx = 1;
		gbc_panel_38.gridy = 3;
		panel_Salary.add(panel_38, gbc_panel_38);
		GridBagLayout gbl_panel_38 = new GridBagLayout();
		gbl_panel_38.columnWidths = new int[] { 101, 110, 58, 114, 0, 132, 0 };
		gbl_panel_38.rowHeights = new int[] { 35, 0, 35, 0 };
		gbl_panel_38.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_38.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_38.setLayout(gbl_panel_38);

		lblCheckSearch_sal = new JLabel("");
		lblCheckSearch_sal.setForeground(new Color(255, 0, 0));
		lblCheckSearch_sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblCheckSearch_sal = new GridBagConstraints();
		gbc_lblCheckSearch_sal.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblCheckSearch_sal.gridwidth = 2;
		gbc_lblCheckSearch_sal.insets = new Insets(0, 0, 5, 5);
		gbc_lblCheckSearch_sal.gridx = 2;
		gbc_lblCheckSearch_sal.gridy = 0;
		panel_38.add(lblCheckSearch_sal, gbc_lblCheckSearch_sal);

		lblNewLabel_64 = new JLabel("Search:");
		lblNewLabel_64.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_64 = new GridBagConstraints();
		gbc_lblNewLabel_64.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_64.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_64.gridx = 0;
		gbc_lblNewLabel_64.gridy = 1;
		panel_38.add(lblNewLabel_64, gbc_lblNewLabel_64);

		comboBox_Field_Sal = new JComboBox();
		comboBox_Field_Sal.setModel(new DefaultComboBoxModel(new String[] { "ID", "Fullname", "Month" }));
		comboBox_Field_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_comboBox_Field_Sal = new GridBagConstraints();
		gbc_comboBox_Field_Sal.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_Field_Sal.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Field_Sal.gridx = 1;
		gbc_comboBox_Field_Sal.gridy = 1;
		panel_38.add(comboBox_Field_Sal, gbc_comboBox_Field_Sal);

		txtSearch_Sal = new JTextField();
		txtSearch_Sal.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(0, 255, 204), new Color(0, 51, 153)));
		txtSearch_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_txtSearch_Sal = new GridBagConstraints();
		gbc_txtSearch_Sal.gridwidth = 2;
		gbc_txtSearch_Sal.insets = new Insets(0, 0, 5, 5);
		gbc_txtSearch_Sal.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtSearch_Sal.gridx = 2;
		gbc_txtSearch_Sal.gridy = 1;
		panel_38.add(txtSearch_Sal, gbc_txtSearch_Sal);
		txtSearch_Sal.setColumns(10);

		btnSearch_Sal = new JButton("", search);
		btnSearch_Sal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSearch_SalActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnSearch_Sal = new GridBagConstraints();
		gbc_btnSearch_Sal.insets = new Insets(0, 0, 5, 5);
		gbc_btnSearch_Sal.gridx = 4;
		gbc_btnSearch_Sal.gridy = 1;
		panel_38.add(btnSearch_Sal, gbc_btnSearch_Sal);

		lblNewLabel_69 = new JLabel("Month:");
		lblNewLabel_69.setFont(new Font("Serif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_69 = new GridBagConstraints();
		gbc_lblNewLabel_69.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_69.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_69.gridx = 0;
		gbc_lblNewLabel_69.gridy = 2;
		panel_38.add(lblNewLabel_69, gbc_lblNewLabel_69);

		comboBox_SortmonthSal = new JComboBox();
		comboBox_SortmonthSal.setModel(new DefaultComboBoxModel(new String[] { "January", "February", "March", "April",
				"May", "June", "July", "August", "September", "October", "November", "December" }));
		comboBox_SortmonthSal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_comboBox_SortmonthSal = new GridBagConstraints();
		gbc_comboBox_SortmonthSal.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_SortmonthSal.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_SortmonthSal.gridx = 1;
		gbc_comboBox_SortmonthSal.gridy = 2;
		panel_38.add(comboBox_SortmonthSal, gbc_comboBox_SortmonthSal);

		comboBox_Dept_Sal = new JComboBox();
		comboBox_Dept_Sal.setFont(new Font("Serif", Font.PLAIN, 17));
		GridBagConstraints gbc_comboBox_Dept_Sal = new GridBagConstraints();
		gbc_comboBox_Dept_Sal.gridwidth = 2;
		gbc_comboBox_Dept_Sal.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_Dept_Sal.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Dept_Sal.gridx = 2;
		gbc_comboBox_Dept_Sal.gridy = 2;
		panel_38.add(comboBox_Dept_Sal, gbc_comboBox_Dept_Sal);

		btnSort_Sal = new JButton("", sort);
		btnSort_Sal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSort_SalActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnSort_Sal = new GridBagConstraints();
		gbc_btnSort_Sal.insets = new Insets(0, 0, 0, 5);
		gbc_btnSort_Sal.anchor = GridBagConstraints.WEST;
		gbc_btnSort_Sal.gridx = 4;
		gbc_btnSort_Sal.gridy = 2;
		panel_38.add(btnSort_Sal, gbc_btnSort_Sal);
		loadDataDeptSal();

		scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 1;
		gbc_scrollPane_3.gridy = 4;
		panel_Salary.add(scrollPane_3, gbc_scrollPane_3);

		table_Payroll = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(220, 220, 220);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		TableCellRenderer headerPayroll = table_Payroll.getTableHeader().getDefaultRenderer();
		JLabel labelPayroll = (JLabel) headerPayroll;
		labelPayroll.setHorizontalAlignment(JLabel.CENTER);
		table_Payroll.setFont(new Font("Serif", Font.PLAIN, 15));
		table_Payroll.getTableHeader().setFont(new Font("Serif", Font.BOLD, 15));
		table_Payroll.setRowHeight(table_Payroll.getRowHeight() + 10);
		table_Payroll.setShowGrid(true);
		table_Payroll.setBackground(Color.WHITE);
		table_Payroll.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table_PayrollMousePressed(e);
			}
		});
		table_Payroll.setAutoCreateRowSorter(true);
		scrollPane_3.setViewportView(table_Payroll);

		mnMainMenu = new JMenu("Welcome");
		mnMainMenu.setFont(new Font("Times New Roman", Font.BOLD, 14));
		menuBar.add(mnMainMenu);
	}

	// tab
	private void fillDataToJTable(List<Employee> employees) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("ID");
		model.addColumn("FULLNAME");
		model.addColumn("ADDRESS");
		model.addColumn("DOB");
		model.addColumn("STATUS");

		employees.forEach(emp -> model.addRow(new Object[] { emp.getIdemp(), emp.getFullname(), emp.getAddress(),
				emp.getDob(), emp.getSttemp() == 1 ? "Active" : "Non-active" }));
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
	}

	// ==============back to choose type======================
	public HR(Employee emp) throws HeadlessException {
		this();
		this.emp = emp;
		loadUser();
	}

	private void loadUser() {
		String username = emp.getUsername();
		mnMainMenu.setText("Welcome, " + username);
		lblTotalEmp.setText(Integer.toString(empb.AllEmp()));
	}

	protected void btnbackTypeActionPerformed(ActionEvent e) {
		var backType = new ChooseType(emp);
		this.setVisible(false);
		backType.setVisible(true);
		backType.showHR();
	}

	// =====================logout=================

	protected void btnLogoutActionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(HR.this, "Do you want to exit?", "Confirm Logout",
				JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(this, "See you later!");
			var main = new Main();
			main.setVisible(true);
			this.setVisible(false);
		}
	}

	// ===================EMPLOYEE TAB==================
	protected void btnEmployeeActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "employee");
	}

	protected void tableMousePressed(MouseEvent e) {
		JPopupMenu menu = new JPopupMenu("info");
		ImageIcon iconDel = new ImageIcon(HR.class.getResource("/images/Delete.png"), "icon delete");
		JMenuItem item1 = new JMenuItem("Delete", iconDel);
		ImageIcon iconInfo = new ImageIcon(HR.class.getResource("/images/Info.png"), "icon info");
		JMenuItem item2 = new JMenuItem("Show detail", iconInfo);
		ImageIcon iconStt = new ImageIcon(HR.class.getResource("/images/change-stt.png"), "icon stt");
		JMenuItem item3 = new JMenuItem("Change status", iconStt);

		menu.add(item1);
		menu.add(item2);
		menu.add(item3);

		if (e.getButton() == MouseEvent.BUTTON3) {
			int r = table.rowAtPoint(e.getPoint());
			table.setRowSelectionInterval(r, r);
			menu.show(table, e.getX(), e.getY());
		}

		// delete
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnDeleteActionPerformed(e);
			}

			private void btnDeleteActionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				String idemp = table.getValueAt(selectedRow, 0).toString();
				int result = JOptionPane.showConfirmDialog(HR.this,
						"Do you want to delete " + empb.getacc(Integer.parseInt(idemp)).getFullname() + " ?",
						"Confirm Delete", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					if (empb.deleteEmpolyee(Integer.parseInt(idemp))) {
						JOptionPane.showMessageDialog(HR.this, "Done");
						fillDataToJTable(empb.ShowListEmployeeFromDatabase());
					} else {
						JOptionPane.showMessageDialog(HR.this, "Delete failed!");
						fillDataToJTable(empb.ShowListEmployeeFromDatabase());
					}
				}
			}
		});

		// show info
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDetailActionPerformed(e);
			}

			private void btnDetailActionPerformed(ActionEvent e) {
				CardLayout card = (CardLayout) panel.getLayout();
				card.show(panel, "detailInfo");
				loaddata_detail();
			}

			private void loaddata_detail() {
				int selectedRow = table.getSelectedRow();
				String idemp = table.getValueAt(selectedRow, 0).toString();
				txtID_Info.setText(idemp);
				var emp = empb.getacc(Integer.parseInt(idemp));
				var rel = relb.findRel(Integer.parseInt(idemp));
				txtName_info.setText(emp.getFullname());
				txtBasicSal_Info.setText(String.valueOf(emp.getBasicsalary()));
				txtAddress_info.setText(emp.getAddress());
				dateChooser_Dob.setDate(emp.getDob());
				dateChooser_Onboard_Info.setDate(emp.getOnboarddate());
				txtEmail_info.setText(emp.getEmail());
				txtPhone_Info.setText(emp.getPhone());
				txtUsername_Info.setText(emp.getUsername());
				String gender = emp.getGender();
				if (gender.equalsIgnoreCase("female")) {
					rdbtnMale_Info.setSelected(false);
					rdbtnFemale_Info.setSelected(true);
				} else {
					rdbtnFemale_Info.setSelected(false);
					rdbtnMale_Info.setSelected(true);
				}
				String status = String.valueOf(emp.getSttemp());
				if (status.equals("1")) {
					rdbtn_Stt_Block.setSelected(false);
					rdbtn_SttAct.setSelected(true);
				} else {
					rdbtn_SttAct.setSelected(false);
					rdbtn_Stt_Block.setSelected(true);
				}
				String namedept = depb.getdep(emp.getIddep()).getNamedep();
				String typename = typeb.gettype(emp.getTypeid()).getTypename();
				txtShowDep.setText(namedept);
				txtShowType.setText(typename);
				comboBox_dept.setVisible(false);
				btnAccept.setVisible(false);
				comboBox_type.setVisible(false);
				btnAccept_2.setVisible(false);
				lbl_showAL.setText(String.valueOf(emp.getAnnualleave()));
				lbl_showUL.setText(String.valueOf(emp.getUnpaidleave()));
				lbl_showSL.setText(String.valueOf(emp.getSickleave()));
				txtRelName.setText(rel.getFullname());
				txtRelRelation.setText(rel.getRelationship());
				txtRelPhone_Info.setText(rel.getPhone());
			}
		});

		// change status
		item3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				btnUpdateStatusActionPerformed(e);
			}

			private void btnUpdateStatusActionPerformed(ActionEvent e) {
				int selectedRow = table.getSelectedRow();
				int idemp = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
				String[] options = { "Active", "Non-Active" };
				int status = JOptionPane.showOptionDialog(HR.this, "Please, choose status:", "Update Status",
						JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				if (status == 0) {
					empb.updateStatus(1, idemp);
					JOptionPane.showMessageDialog(HR.this, "Update status success");
					// fillDataToJTable(empb.ShowListEmployeeFromDatabase());
				} else if (status == 1) {
					empb.updateStatus(0, idemp);
					JOptionPane.showMessageDialog(HR.this, "Update status success");
					// fillDataToJTable(empb.ShowListEmployeeFromDatabase());
				}
			}
		});
	}

	// ===============search emp=========================
	// ==combo-box dept data (search)
	private void loadDataDeptSearch() {
		DepartmentBao deptbao = new DepartmentBao();
		fillDataToJComboboxDeptSearch(deptbao.getAllList());
	}

	private void fillDataToJComboboxDeptSearch(List<Department> dept) {
		DefaultComboBoxModel<Department> defaultComboBoxModel = new DefaultComboBoxModel<Department>();
		for (Department department : dept) {
			defaultComboBoxModel.addElement(department);
		}
		comboBox_SearchDept.setModel(defaultComboBoxModel);
		comboBox_SearchDept.setRenderer(new CategoryListCellRenderDeptSearch());
	}

	private class CategoryListCellRenderDeptSearch extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department dept = (Department) value;
			return super.getListCellRendererComponent(list, dept.getNamedep(), index, isSelected, cellHasFocus);
		}
	}

	// ------------------search------------------------------------

	protected void btnSearchActionPerformed(ActionEvent e) {
		var key = txtKey.getText();
		var select = comboBox_fieldSearch.getSelectedIndex();
		if (key.isEmpty()) {
			lblfillSearch.setText("Please, fill keyword!");
		} else {
			lblfillSearch.setText("");
			switch (select) {
			case 0 -> {
				lblfillSearch.setText(helper.Validation.MessErrorInputNumber(key));
				if (lblfillSearch.getText().equals("")) {
					fillDataToJTable(empb.showSearchEmpId(key));
					lblTotalResult.setText(String.valueOf(table.getRowCount()));
				}
			}
			case 1 -> {
				lblfillSearch.setText(helper.Validation.MessErrorSearchNameXuan(key));
				if (lblfillSearch.getText().equals("")) {
					fillDataToJTable(empb.showSearchEmpName(key));
					lblTotalResult.setText(String.valueOf(table.getRowCount()));
				}
			}
			case 2 -> {
				fillDataToJTable(empb.showSearchEmpUsername(key));
				lblTotalResult.setText(String.valueOf(table.getRowCount()));
			}
			case 3 -> {
				lblfillSearch.setText(helper.Validation.MessErrorInputNumber(key));
				if (lblfillSearch.getText().equals("")) {
					fillDataToJTable(empb.showEmpByDob(key));
					lblTotalResult.setText(String.valueOf(table.getRowCount()));
				}
			}
			case 4 -> {
				lblfillSearch.setText(helper.Validation.MessErrorInputNumber(key));
				if (lblfillSearch.getText().equals("")) {
					fillDataToJTable(empb.showEmpByOnboard(key));
					lblTotalResult.setText(String.valueOf(table.getRowCount()));
				}
			}
			case 5 -> {
				lblfillSearch.setText(helper.Validation.MessErrorInputNumber(key));
				if (lblfillSearch.getText().equals("")) {
					fillDataToJTable(empb.showEmpPhone(key));
					lblTotalResult.setText(String.valueOf(table.getRowCount()));
				}
			}
			case 6 -> {
				fillDataToJTable(empb.showEmpAdd(key));
				lblTotalResult.setText(String.valueOf(table.getRowCount()));
			}
			}
		}
	}

	// -----------------sort by dept--------------------------
	protected void btnSearchDeptActionPerformed(ActionEvent e) {
		Department dept = (Department) comboBox_SearchDept.getSelectedItem();
		var iddep = dept.getIddep();
		var key = txtKey.getText();
		var gender = comboBox_SortGender_Dept.getSelectedIndex();
		var gen = comboBox_SortGender_Dept.getSelectedItem().toString();
		var select = comboBox_fieldSearch.getSelectedIndex();
		if (key.isEmpty()) {
			lblfillSearch.setText("");
			switch (gender) {
			case 0 -> {
				fillDataToJTable(empb.showSearchEmpDept(iddep));
				lblTotalResult.setText(String.valueOf(table.getRowCount()));
			}
			case 1 -> {
				fillDataToJTable(empb.showEmpByDepGender(iddep, gen));
				lblTotalResult.setText(String.valueOf(table.getRowCount()));
			}
			case 2 -> {
				fillDataToJTable(empb.showEmpByDepGender(iddep, gen));
				lblTotalResult.setText(String.valueOf(table.getRowCount()));
			}
			}
		} else {
			if (lblfillSearch.getText().equals("")) {
				switch (select) {
				// fullname
				case 1 -> {
					if (gender == 0) {
						fillDataToJTable(empb.showSearchEmpNamebyDept(iddep, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					} else {
						fillDataToJTable(empb.showSearchEmpNamebyDeptGen(iddep, gen, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					}
				}
				// username
				case 2 -> {
					if (gender == 0) {
						fillDataToJTable(empb.showSearchEmpUseramebyDept(iddep, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					} else {
						fillDataToJTable(empb.showSearchEmpUseramebyDeptGen(iddep, gen, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					}
				}
				// dob
				case 3 -> {
					if (gender == 0) {
						fillDataToJTable(empb.showEmpByDeptDob(iddep, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					} else {
						fillDataToJTable(empb.showEmpByDeptDobGen(iddep, gen, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					}
				}
				// onboard date
				case 4 -> {
					if (gender == 0) {
						fillDataToJTable(empb.showEmpByDeptOnboard(iddep, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					} else {
						fillDataToJTable(empb.showEmpByDeptOnboardGen(iddep, gen, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					}
				}
				// address
				case 6 -> {
					if (gender == 0) {
						fillDataToJTable(empb.showEmpByDeptAdd(iddep, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					} else {
						fillDataToJTable(empb.showEmpByDeptAddGen(iddep, gen, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					}
				}
				}
			} else {
				JOptionPane.showMessageDialog(this, "Incorrect keyword!");
			}
		}
	}

	// ------------------sort gender----------------------------------
	protected void btnNewButtonActionPerformed(ActionEvent e) {
		var gender = comboBox_SortGender.getSelectedIndex();
		var key = txtKey.getText();
		var gen = comboBox_SortGender.getSelectedItem().toString();
		var select = comboBox_fieldSearch.getSelectedIndex();
		if (key.isEmpty()) {
			lblfillSearch.setText("");
			switch (gender) {
			case 0 -> {
				fillDataToJTable(empb.ShowListEmployeeFromDatabase());
				lblTotalResult.setText(String.valueOf(table.getRowCount()));
			}
			case 1 -> {
				fillDataToJTable(empb.showEmpGender(gen));
				lblTotalResult.setText(String.valueOf(table.getRowCount()));
			}
			case 2 -> {
				fillDataToJTable(empb.showEmpGender(gen));
				lblTotalResult.setText(String.valueOf(table.getRowCount()));
			}

			}
		} else {
			if (lblfillSearch.getText().equals("")) {
				switch (select) {
				// fullname
				case 1 -> {
					if (gender == 0) {
						fillDataToJTable(empb.showSearchEmpName(key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					} else {
						fillDataToJTable(empb.showEmpNameGender(gen, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					}
				}
				// username
				case 2 -> {
					if (gender == 0) {
						fillDataToJTable(empb.showSearchEmpUsername(key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					} else {
						fillDataToJTable(empb.showEmpUsernameGender(gen, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					}
				}
				// dob
				case 3 -> {
					if (gender == 0) {
						fillDataToJTable(empb.showEmpByDob(key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					} else {
						fillDataToJTable(empb.showEmpDobGender(gen, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					}
				}
				// oboard
				case 4 -> {
					if (gender == 0) {
						fillDataToJTable(empb.showEmpByOnboard(key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					} else {
						fillDataToJTable(empb.showEmpOnboardGender(gen, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					}
				}
				// address
				case 6 -> {
					if (gender == 0) {
						fillDataToJTable(empb.showEmpAdd(key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					} else {
						fillDataToJTable(empb.showEmpAddressGender(gen, key));
						lblTotalResult.setText(String.valueOf(table.getRowCount()));
					}
				}
				}

			} else {
				JOptionPane.showMessageDialog(this, "Incorrect keyword!");
			}
		}
	}
	// ================DETAIL INFO==================

	// -----------update e-mail--------------------
	protected void btnChangeMailActionPerformed(ActionEvent e) {
		txtEmail_info.setEditable(true);
		btncheckChangeMail.setVisible(true);
		btnChangeMail.setEnabled(false);
	}

	protected void btncheckChangeMailActionPerformed(ActionEvent e) {
		var emp = new Employee();
		String mail = txtEmail_info.getText().trim();
		int idemp = Integer.parseInt(txtID_Info.getText());
		emp.setEmail(mail);
		checkEmail(mail, lblCheckMail_Info);
		if (lblCheckMail_Info.getText().equals("")) {
			int result = JOptionPane.showConfirmDialog(this, "Do you want to update?", "Confirm Change",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				empb.updateMail(mail, idemp);
				JOptionPane.showMessageDialog(this, "Update e-mail success!");
				txtEmail_info.setEditable(false);
				btncheckChangeMail.setVisible(false);
				btnChangeMail.setEnabled(true);
			} else if (result == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(this, "Update cancel!");
				txtEmail_info.setText(empb.getacc(idemp).getEmail());
				txtEmail_info.setEditable(false);
				btncheckChangeMail.setVisible(false);
				btnChangeMail.setEnabled(true);
				lblCheckMail_Info.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Update fail!");
			txtEmail_info.setText(empb.getacc(idemp).getEmail());
			txtEmail_info.setEditable(false);
			btncheckChangeMail.setVisible(false);
			btnChangeMail.setEnabled(true);
			lblCheckMail_Info.setText("");
		}
	}

	// -----------update phone--------------------
	protected void btnChangePhoneActionPerformed(ActionEvent e) {
		txtPhone_Info.setEditable(true);
		btncheckChangePhone.setVisible(true);
		btnChangePhone.setEnabled(false);
	}

	protected void btncheckChangePhoneActionPerformed(ActionEvent e) {
		var emp = new Employee();
		String phone = txtPhone_Info.getText().trim();
		int idemp = Integer.parseInt(txtID_Info.getText());
		emp.setPhone(phone);
		checkPhone(phone, lblCheckPhone_Info);
		if (lblCheckPhone_Info.getText().equals("")) {
			int result = JOptionPane.showConfirmDialog(this, "Do you want to update?", "Confirm Change",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				empb.updatePhone(phone, idemp);
				JOptionPane.showMessageDialog(this, "Update phone success!");
				txtPhone_Info.setEditable(false);
				btncheckChangePhone.setVisible(false);
				btnChangePhone.setEnabled(true);
			} else if (result == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(this, "Update cancel!");
				txtPhone_Info.setText(empb.getacc(idemp).getPhone());
				txtPhone_Info.setEditable(false);
				btncheckChangePhone.setVisible(false);
				btnChangePhone.setEnabled(true);
				lblCheckPhone_Info.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Update fail!");
			txtPhone_Info.setText(empb.getacc(idemp).getPhone());
			txtPhone_Info.setEditable(false);
			btncheckChangePhone.setVisible(false);
			btnChangePhone.setEnabled(true);
			lblCheckPhone_Info.setText("");
		}
	}

	// ---------------update emp info-------------------------------------
	protected void btnEditActionPerformed(ActionEvent e) {
		btnSave.setEnabled(true);
		txtName_info.setEditable(true);
		txtBasicSal_Info.setEditable(true);
		dateChooser_Dob.setEnabled(true);
		dateChooser_Onboard_Info.setEnabled(true);
		txtAddress_info.setEditable(true);
		btnReset.setEnabled(true);
	}

	protected void btnResetActionPerformed(ActionEvent e) {
		loaddata_reset();
	}

	private void loaddata_reset() {
		int idemp = Integer.parseInt(txtID_Info.getText());
		var emp = empb.getacc(idemp);
		txtName_info.setText(emp.getFullname());
		txtBasicSal_Info.setText(String.valueOf(emp.getBasicsalary()));
		dateChooser_Dob.setDate(emp.getDob());
		dateChooser_Onboard_Info.setDate(emp.getOnboarddate());
		txtAddress_info.setText(emp.getAddress());
		String gender = emp.getGender();
		lblCheckName_Info.setText("");
		lblCheckAdd_Info.setText("");
		lblCheckDob_Info.setText("");
		lblCheckOndate_Info.setText("");
		lblCheckSalary_Info.setText("");
		if (gender.equalsIgnoreCase("female")) {
			rdbtnMale_Info.setSelected(false);
			rdbtnFemale_Info.setSelected(true);
		} else {
			rdbtnFemale_Info.setSelected(false);
			rdbtnMale_Info.setSelected(true);
		}
		String status = String.valueOf(emp.getSttemp());
		if (status.equals("1")) {
			rdbtn_Stt_Block.setSelected(false);
			rdbtn_SttAct.setSelected(true);
		} else {
			rdbtn_SttAct.setSelected(false);
			rdbtn_Stt_Block.setSelected(true);
		}
		comboBox_dept.setVisible(false);
		btnAccept.setVisible(false);
		comboBox_type.setVisible(false);
		btnAccept_2.setVisible(false);
		btnChangDept.setEnabled(true);
		btnChange_2.setEnabled(true);
	}

	protected void btnSaveActionPerformed(ActionEvent e) {
		var emp = new Employee();
		int idemp = Integer.parseInt(txtID_Info.getText());

		checkFullname(txtName_info.getText().trim(), lblCheckName_Info);
		checkSalary(txtBasicSal_Info.getText(), lblCheckSalary_Info);
		checkAddress(txtAddress_info.getText().trim(), lblCheckAdd_Info);
		checkDob(dateChooser_Dob.getDate(), lblCheckDob_Info);
		checkOnboard(dateChooser_Onboard_Info.getDate(), lblCheckOndate_Info);

		if (lblCheckName_Info.getText().equals("") && lblCheckAdd_Info.getText().equals("")
				&& lblCheckDob_Info.getText().equals("") && lblCheckOndate_Info.getText().equals("")
				&& lblCheckSalary_Info.getText().equals("")) {
			int result = JOptionPane.showConfirmDialog(this, "Do you want to update?", "Confirm Change",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				emp.setFullname(txtName_info.getText().trim());
				emp.setBasicsalary(Long.parseLong(txtBasicSal_Info.getText()));
				emp.setDob(dateChooser_Dob.getDate());
				emp.setAddress(txtAddress_info.getText().trim());
				var gender = "";
				var button = buttonGroup_Gender_Info.getElements();
				while (button.hasMoreElements()) {
					JRadioButton choose = (JRadioButton) button.nextElement();
					if (choose.isSelected()) {
						gender = choose.getText();
					}
				}
				var status = "";
				var button_stt = buttonGroup_Stt.getElements();
				while (button_stt.hasMoreElements()) {
					JRadioButton choose = (JRadioButton) button_stt.nextElement();
					if (choose.isSelected()) {
						if (choose.getText().equals("Active")) {
							status = "1";
						} else {
							status = "0";
						}
					}
				}
				emp.setGender(gender);
				emp.setSttemp(Integer.parseInt(status));
				emp.setOnboarddate(dateChooser_Onboard_Info.getDate());
				empb.updateInfo(emp, idemp);
				JOptionPane.showMessageDialog(this, "Update info success!");
				txtName_info.setEditable(false);
				txtBasicSal_Info.setEditable(false);
				dateChooser_Dob.setEnabled(false);
				dateChooser_Onboard_Info.setEnabled(false);
				txtAddress_info.setEditable(false);
				btnSave.setEnabled(false);
				btnReset.setEnabled(false);
			} else if (result == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(this, "Update cancel!");
				loaddata_reset();
				txtName_info.setEditable(false);
				txtBasicSal_Info.setEditable(false);
				dateChooser_Dob.setEnabled(false);
				dateChooser_Onboard_Info.setEnabled(false);
				txtAddress_info.setEditable(false);
				btnSave.setEnabled(false);
				btnReset.setEnabled(false);
			}
		}

		else {
			JOptionPane.showMessageDialog(this, "Insert fail!");
		}
	}

	// --------------update pass-----------------------------------
	// check pass

	protected void passwordField_NewPassKeyPressed(KeyEvent e) {
		btnSave_Pass.setEnabled(true);
	}

	protected void passwordField_ConfPass_InfoKeyPressed(KeyEvent e) {
		btnSave_Pass.setEnabled(true);
	}

	public void checkUpdatePass(String password, String confirm) {
		if (helper.Validation.MessErrorInputPass(password).equals("")) {
			lblcheckNewPass_Info.setText("");
		}
		if (!password.equals(confirm)) {
			lblcheckConfPass_Info.setText("Password not match!");
			lblcheckNewPass_Info.setText(helper.Validation.MessErrorInputPass(password));
		} else {
			lblcheckNewPass_Info.setText(helper.Validation.MessErrorInputPass(password));
			lblcheckConfPass_Info.setText("");
		}
	}

	public void checkUpdatePassScript(String password, String confirm) {
		if (helper.Validation.MessErrorInputPassScript(password).equals("")) {
			lblcheckNewPass_Info.setText("");
		}
		if (!password.equals(confirm)) {
			lblcheckConfPass_Info.setText("Password not match!");
			lblcheckNewPass_Info.setText(helper.Validation.MessErrorInputPassScript(password));
		} else {
			lblcheckNewPass_Info.setText(helper.Validation.MessErrorInputPassScript(password));
			lblcheckConfPass_Info.setText("");
		}
	}

	protected void btnSave_PassActionPerformed(ActionEvent e) {
		var password = new String(passwordField_NewPass.getPassword());
		var confirm = new String(passwordField_ConfPass_Info.getPassword());
		var hash = BCrypt.hashpw(password, BCrypt.gensalt());
		int idemp = Integer.parseInt(txtID_Info.getText());
		checkUpdatePassScript(password, confirm);
		if (lblcheckNewPass_Info.getText().equals("") && lblcheckConfPass_Info.getText().equals("")) {
			int result = JOptionPane.showConfirmDialog(this, "Do you want to update?", "Confirm Change",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				empb.updatePass(hash, idemp);
				try {
					sendMailChangPass();
				} catch (MessagingException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, "Update password success, mail has been sent!");
				passwordField_NewPass.setText("");
				passwordField_ConfPass_Info.setText("");
				btnSave_Pass.setEnabled(false);
			} else if (result == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(this, "Update cancel!");
				passwordField_NewPass.setText("");
				passwordField_ConfPass_Info.setText("");
				btnSave_Pass.setEnabled(false);
			}
		} else {
			btnSave_Pass.setEnabled(true);
			JOptionPane.showMessageDialog(this, "Update fail!");
		}
	}

	public void sendMailChangPass() throws AddressException, MessagingException {
		final String from = "roisiestore.hcm@gmail.com";
		final String pass = "roisiestore$1234";
		final String to = txtEmail_info.getText();
		final String subject = "Traveloto: Password change notification";
		final String body = "<h4>Hello " + txtName_info.getText() + "," + "</h4>"
				+ "<strong>This is your new information  to access Traveloto system: </strong>" + "<h5>Username: "
				+ txtUsername_Info.getText() + "</h5>" + "<h5> Your new password: "
				+ String.valueOf(passwordField_NewPass.getPassword()) + "</h5>"
				+ "<h5> You should be change your password after login." + "</h5>" + "<i>Thanks & Best Regards!</i>";
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(from, pass);
			}
		});
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from, "NoReply-Traveloto"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		message.setReplyTo(InternetAddress.parse(from, false));
		message.setSubject(subject, "text/html");
		message.setContent(body, "text/html");
		message.setSentDate(new Date());
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
		Transport.send(message);
	}

	// -------------update department---------------------------------
	protected void btnChangDeptActionPerformed(ActionEvent e) {
		comboBox_dept.setVisible(true);
		btnAccept.setVisible(true);
		btnChangDept.setEnabled(false);
	}

	protected void comboBox_deptActionPerformed(ActionEvent e) {
		String data = comboBox_dept.getSelectedItem().toString();
		txtShowDep.setText(data);
	}

	protected void btnAccActionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(this, "Do you want to update department?", "Confirm Change",
				JOptionPane.YES_NO_OPTION);
		int idemp = Integer.parseInt(txtID_Info.getText());
		var emp = empb.getacc(idemp);
		if (result == JOptionPane.YES_OPTION) {
			Department dept = (Department) comboBox_dept.getSelectedItem();
			String iddep = dept.getIddep();
			empb.updateDepart(iddep, idemp);
			JOptionPane.showMessageDialog(this, "Update department success!");
			comboBox_dept.setVisible(false);
			btnAccept.setVisible(false);
			btnChangDept.setEnabled(true);
		} else {
			String namedept = depb.getdep(emp.getIddep()).getNamedep();
			txtShowDep.setText(namedept);
			comboBox_dept.setVisible(false);
			btnAccept.setVisible(false);
			btnChangDept.setEnabled(true);
		}
	}

	// ------------------update type acc-----------------------------------
	protected void btnChange_2ActionPerformed(ActionEvent e) {
		comboBox_type.setVisible(true);
		btnAccept_2.setVisible(true);
		btnChange_2.setEnabled(false);
	}

	protected void comboBox_typeActionPerformed(ActionEvent e) {
		String data = comboBox_type.getSelectedItem().toString();
		txtShowType.setText(data);
	}

	protected void btnAccept_2ActionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(this, "Do you want to update type account?", "Confirm Change",
				JOptionPane.YES_NO_OPTION);
		int idemp = Integer.parseInt(txtID_Info.getText());
		var emp = empb.getacc(idemp);

		if (result == JOptionPane.YES_OPTION) {
			Typeaccount type = (Typeaccount) comboBox_type.getSelectedItem();
			String typeid = type.getTypeid();
			empb.updateType(typeid, idemp);
			JOptionPane.showMessageDialog(this, "Update type success!");
			comboBox_type.setVisible(false);
			btnAccept_2.setVisible(false);
			btnChange_2.setEnabled(true);
		} else {
			String typename = typeb.gettype(emp.getTypeid()).getTypename();
			txtShowType.setText(typename);
			comboBox_type.setVisible(false);
			btnAccept_2.setVisible(false);
			btnChange_2.setEnabled(true);
		}
	}

	// ==combo-box dept data (detail)
	private void loadDataDeptInfo() {
		DepartmentBao deptbao = new DepartmentBao();
		fillDataToJComboboxDeptInfo(deptbao.getAllList());
	}

	// ==combo-box type data (detail)
	private void loadDataTypeInfo() {
		TypeaccountBao typebao = new TypeaccountBao();
		fillDataToJComboboxTypeInfo(typebao.getListType());
	}

	private void fillDataToJComboboxDeptInfo(List<Department> dept) {
		DefaultComboBoxModel<Department> defaultComboBoxModel = new DefaultComboBoxModel<Department>();
		for (Department department : dept) {
			defaultComboBoxModel.addElement(department);
		}
		comboBox_dept.setModel(defaultComboBoxModel);
		comboBox_dept.setRenderer(new CategoryListCellRenderDeptInfo());
	}

	private class CategoryListCellRenderDeptInfo extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department dept = (Department) value;
			return super.getListCellRendererComponent(list, dept.getNamedep(), index, isSelected, cellHasFocus);
		}
	}

	private void fillDataToJComboboxTypeInfo(List<Typeaccount> emp) {
		DefaultComboBoxModel<Typeaccount> defaultComboBoxModelType = new DefaultComboBoxModel<Typeaccount>();
		for (Typeaccount emptype : emp) {
			defaultComboBoxModelType.addElement(emptype);
		}
		comboBox_type.setModel(defaultComboBoxModelType);
		comboBox_type.setRenderer(new CategoryListCellRenderTypeInfo());
	}

	private class CategoryListCellRenderTypeInfo extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Typeaccount type = (Typeaccount) value;
			return super.getListCellRendererComponent(list, type.getTypename(), index, isSelected, cellHasFocus);
		}
	}

	// ============update relatives======================
	protected void btnEdit_RelActionPerformed(ActionEvent e) {
		btnSave_Rel.setEnabled(true);
		btnReset_Rel.setEnabled(true);
		txtRelName.setEditable(true);
		txtRelRelation.setEditable(true);
	}

	protected void btnUpdateRelPhoneActionPerformed(ActionEvent e) {
		txtRelPhone_Info.setEditable(true);
		btnChangeRelPhone.setVisible(true);
		btnUpdateRelPhone.setEnabled(false);
	}

	// ----------update phone------------------
	public void checkPhoneScript(String phone, JLabel lb) {
		if (helper.Validation.MessErrorInputPhoneScript(phone, empb, relb).equals("")) {
			lb.setText("");
		} else {
			lb.setText(helper.Validation.MessErrorInputPhoneScript(phone, empb, relb));
		}
	}

	protected void btnChangeRelPhoneActionPerformed(ActionEvent e) {
		var rel = new Relatives();
		String phone = txtRelPhone_Info.getText().trim();
		int idemp = Integer.parseInt(txtID_Info.getText());
		rel.setPhone(phone);
		checkPhoneScript(phone, lblCheckRelPhone_Info);
		if (lblCheckRelPhone_Info.getText().equals("")) {
			int result = JOptionPane.showConfirmDialog(this, "Do you want to update?", "Confirm Change",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				relb.updatePhone(phone, idemp);
				JOptionPane.showMessageDialog(this, "Update phone success!");
				txtRelPhone_Info.setEditable(false);
				btnChangeRelPhone.setVisible(false);
				btnUpdateRelPhone.setEnabled(true);
			} else if (result == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(this, "Update cancel!");
				txtRelPhone_Info.setText(relb.getRelatives(idemp).getPhone());
				txtRelPhone_Info.setEditable(false);
				btnChangeRelPhone.setVisible(false);
				btnUpdateRelPhone.setEnabled(true);
				lblCheckRelPhone_Info.setText("");
			}
		} else {
			JOptionPane.showMessageDialog(this, "Update fail!");
			txtRelPhone_Info.setText(relb.getRelatives(idemp).getPhone());
			txtRelPhone_Info.setEditable(false);
			btnChangeRelPhone.setVisible(false);
			btnUpdateRelPhone.setEnabled(true);
			lblCheckRelPhone_Info.setText("");
		}
	}

	// --------------update info----------------------
	public void checkFullnameScript(String fullname, JLabel lb) {
		if (helper.Validation.MessErrorInputFullNameScript(fullname).equals("")) {
			lb.setText("");
		} else {
			lb.setText(helper.Validation.MessErrorInputFullNameScript(fullname));
		}
	}

	public void checkRelationScript(String relation, JLabel lb) {
		if (helper.Validation.MessErrorInputRelationshipScript(relation).equals("")) {
			lb.setText("");
		} else {
			lb.setText(helper.Validation.MessErrorInputRelationshipScript(relation));
		}
	}

	protected void btnSave_RelActionPerformed(ActionEvent e) {
		var rel = new Relatives();
		int idemp = Integer.parseInt(txtID_Info.getText());
		rel.setFullname(txtRelName.getText().trim());
		rel.setRelationship(txtRelRelation.getText().trim());

		checkFullnameScript(txtRelName.getText().trim(), lblCheckRelName_Info);
		checkRelationScript(txtRelRelation.getText().trim(), lblCheckRelRelation_Info);

		if (lblCheckRelName_Info.getText().equals("") && lblCheckRelRelation_Info.getText().equals("")) {
			int result = JOptionPane.showConfirmDialog(this, "Do you want to update?", "Confirm Change",
					JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				relb.updateInfo(rel, idemp);
				JOptionPane.showMessageDialog(this, "Update info relatives success!");
				txtRelName.setEditable(false);
				txtRelRelation.setEditable(false);
				btnSave_Rel.setEnabled(false);
				btnReset_Rel.setEnabled(false);
				btnChangeRelPhone.setVisible(false);
				btnUpdateRelPhone.setEnabled(true);
				txtRelPhone_Info.setText(relb.findRel(idemp).getPhone());

			} else if (result == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(this, "Update cancel!");
				txtRelName.setText(relb.getRelatives(idemp).getFullname());
				txtRelRelation.setText(relb.getRelatives(idemp).getRelationship());
				txtRelName.setEditable(false);
				txtRelRelation.setEditable(false);
				btnSave_Rel.setEnabled(false);
				btnReset_Rel.setEnabled(false);
				btnChangeRelPhone.setVisible(false);
				btnUpdateRelPhone.setEnabled(true);
				txtRelPhone_Info.setText(relb.findRel(idemp).getPhone());
			}
		}

		else {
			JOptionPane.showMessageDialog(this, "Update fail!");
		}
	}

	protected void btnReset_RelActionPerformed(ActionEvent e) {
		int idemp = Integer.parseInt(txtID_Info.getText());
		txtRelName.setText(relb.getRelatives(idemp).getFullname());
		txtRelRelation.setText(relb.getRelatives(idemp).getRelationship());
		lblCheckRelName_Info.setText("");
		lblCheckRelRelation_Info.setText("");
		btnChangeRelPhone.setVisible(false);
		btnUpdateRelPhone.setEnabled(true);
		txtRelPhone_Info.setText(relb.findRel(idemp).getPhone());
	}
	// ============ADD NEW=======================

	protected void btn_AddNewActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "insertnew");
	}

	// ==combo-box dept data (add new)
	private void loadData() {
		DepartmentBao deptbao = new DepartmentBao();
		fillDataToJCombobox(deptbao.getAllList());
	}

	// ==combo-box type data (add new)
	private void loadDataType() {
		TypeaccountBao typebao = new TypeaccountBao();
		fillDataToJComboboxType(typebao.getListType());
	}

	private void fillDataToJCombobox(List<Department> dept) {
		DefaultComboBoxModel<Department> defaultComboBoxModel = new DefaultComboBoxModel<Department>();
		for (Department department : dept) {
			defaultComboBoxModel.addElement(department);
		}
		comboBox_Dept.setModel(defaultComboBoxModel);
		comboBox_Dept.setRenderer(new CategoryListCellRenderDept());
	}

	private class CategoryListCellRenderDept extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department dept = (Department) value;
			return super.getListCellRendererComponent(list, dept.getNamedep(), index, isSelected, cellHasFocus);
		}
	}

	private void fillDataToJComboboxType(List<Typeaccount> emp) {
		DefaultComboBoxModel<Typeaccount> defaultComboBoxModelType = new DefaultComboBoxModel<Typeaccount>();
		for (Typeaccount emptype : emp) {
			defaultComboBoxModelType.addElement(emptype);
		}
		comboBox_Type.setModel(defaultComboBoxModelType);
		comboBox_Type.setRenderer(new CategoryListCellRenderType());
	}

	private class CategoryListCellRenderType extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Typeaccount type = (Typeaccount) value;
			return super.getListCellRendererComponent(list, type.getTypename(), index, isSelected, cellHasFocus);
		}
	}

	// check fullname
	public void checkFullname(String fullname, JLabel lb) {
		if (helper.Validation.MessErrorInputFullName(fullname).equals("")) {
			lb.setText("");
		} else {
			lb.setText(helper.Validation.MessErrorInputFullName(fullname));
		}
	}

	// check address
	public void checkAddress(String address, JLabel lb) {
		if (helper.Validation.MessErrorInputAddress(address).equals("")) {
			lb.setText("");
		} else {
			lb.setText(helper.Validation.MessErrorInputAddress(address));
		}
	}

	// check phone
	public void checkPhone(String phone, JLabel lb) {
		if (helper.Validation.MessErrorInputPhone(phone, empb, relb).equals("")) {
			lb.setText("");
		} else {
			lb.setText(helper.Validation.MessErrorInputPhone(phone, empb, relb));
		}
	}

	// check E-mail
	public void checkEmail(String email, JLabel lb) {
		if (helper.Validation.MessErrorInputMail(email, empb).equals("")) {
			lb.setText("");
		} else {
			lb.setText(helper.Validation.MessErrorInputMail(email, empb));
		}
	}

	// check dob
	public void checkDob(Date dob, JLabel lb) {
		if (dob == null) {
			lb.setText("Please, choose date of birth!");
		} else if (empb.checkAge(dob) < 18) {
			lb.setText("Minimum age is 18 year olds!");
		} else {
			lb.setText("");
		}
	}

	// check dob
	public void checkOnboard(Date dob, JLabel lb) {
		if (dob == null) {
			lb.setText("Please, choose Onboard date!");
		} else {
			lb.setText("");
		}
	}

	// check relationship
	public void checkRelation(String relation, JLabel lb) {
		if (helper.Validation.MessErrorInputRelationship(relation).equals("")) {
			lb.setText("");
		} else {
			lb.setText(helper.Validation.MessErrorInputRelationship(relation));
		}
	}

	// check username
	public void checkUsername(String username, JLabel lb) {
		if (helper.Validation.MessErrorInputUsername(username, empb).equals("")) {
			lb.setText("");
		} else {
			lb.setText(helper.Validation.MessErrorInputUsername(username, empb));
		}
	}

	// check pass
	public void checkPassword(String password, String confirm) {
		if (helper.Validation.MessErrorInputPass(password).equals("")) {
			lblcheckPassWord.setText("");
		}
		if (!password.equals(confirm)) {
			lblcheckConfWord.setText("Password not match!");
			lblcheckPassWord.setText(helper.Validation.MessErrorInputPass(password));
		} else {
			lblcheckPassWord.setText(helper.Validation.MessErrorInputPass(password));
			lblcheckConfWord.setText("");
		}
	}

	// check salary
	public void checkSalary(String salary, JLabel lb) {
		if (helper.Validation.MessErrosInputSalary(salary).equals("")) {
			lb.setText("");
		} else {
			lb.setText(helper.Validation.MessErrosInputSalary(salary));
		}
	}

	public void clearfields() {
		txtFullname.setText("");
		txtSalary_Insert.setText("");
		txtAddress.setText("");
		txtPhone.setText("");
		txtEmail.setText("");
		dateChooser_DOB.setDate(null);
		txtRelativeName.setText("");
		txtRelation.setText("");
		txtPhone_1.setText("");
		txtUserName.setText("");
		passwordField_PassWord.setText("");
		passwordField_ConfPass.setText("");
		loadData();
		loadDataType();
	}

	// insert employee
	protected void btnInsertActionPerformed(ActionEvent e) {
		var emp = new Employee();
		var password = new String(passwordField_PassWord.getPassword());
		var confirm = new String(passwordField_ConfPass.getPassword());
		var hash = BCrypt.hashpw(password, BCrypt.gensalt());
		var salary = txtSalary_Insert.getText().trim();
		Department dept = (Department) comboBox_Dept.getSelectedItem();
		Typeaccount type = (Typeaccount) comboBox_Type.getSelectedItem();

		checkFullname(txtFullname.getText().trim(), lblcheckName);
		checkAddress(txtAddress.getText().trim(), lblcheckAddress);
		checkPhone(txtPhone.getText().trim(), lblcheckPhone);
		checkEmail(txtEmail.getText().trim(), lblcheckEmail);
		checkDob(dateChooser_DOB.getDate(), lblcheckDob);
		checkOnboard(dateChooser_Onboard.getDate(), lblcheckOnboard);
		checkUsername(txtUserName.getText(), lblcheckUserName);
		checkPassword(password, confirm);
		checkSalary(salary, lblcheckSalary);

		if (lblcheckName.getText().equals("") && lblcheckAddress.getText().equals("")
				&& lblcheckDob.getText().equals("") && lblcheckPhone.getText().equals("")
				&& lblcheckEmail.getText().equals("") && lblcheckUserName.getText().equals("")
				&& lblcheckPassWord.getText().equals("") && lblcheckConfWord.getText().equals("")
				&& lblcheckSalary.getText().equals("")) {
			emp.setFullname(txtFullname.getText().trim());
			emp.setBasicsalary(Long.parseLong(txtSalary_Insert.getText()));
			emp.setDob(dateChooser_DOB.getDate());
			emp.setAddress(txtAddress.getText().trim());
			emp.setPhone(txtPhone.getText().trim());
			emp.setEmail(txtEmail.getText().trim());
			var gender = "";
			var button = buttonGroup_gender.getElements();
			while (button.hasMoreElements()) {
				JRadioButton choose = (JRadioButton) button.nextElement();
				if (choose.isSelected()) {
					gender = choose.getText();
				}
			}
			emp.setGender(gender);
			emp.setOnboarddate(dateChooser_Onboard.getDate());
			emp.setIddep(dept.getIddep());
			emp.setTypeid(type.getTypeid());
			emp.setUsername(txtUserName.getText());
			emp.setPass(hash);
			emp.setBasicsalary(Long.parseLong(salary));
			empb.addNewEmp(emp);
			CardLayout card = (CardLayout) panel.getLayout();
			card.show(panel, "relatives");
			String id = String.valueOf(empb.NewEmp().getIdemp());
			String name = empb.NewEmp().getFullname();
			txtIdemp.setText(id);
			txtName.setText(name);
		} else {
			JOptionPane.showMessageDialog(this, "Insert fail!");
		}
	}

	// insert relatives
	protected void btnNextActionPerformed(ActionEvent e) {
		var relatives = new Relatives();
		var relativesBao = new RelativesBao();
		relatives.setIdemp(Integer.parseInt(txtIdemp.getText()));
		relatives.setFullname(txtRelativeName.getText());
		relatives.setRelationship(txtRelation.getText());
		relatives.setPhone(txtPhone_1.getText());

		checkFullname(txtRelativeName.getText().trim(), lblcheckName_1);
		checkPhone(txtPhone_1.getText().trim(), lblcheckPhone_1);
		checkRelation(txtRelation.getText().trim(), lblcheckRelation_1);

		if (lblcheckName_1.getText().equals("") && lblcheckPhone_1.getText().equals("")
				&& lblcheckRelation_1.getText().equals("")) {
			relativesBao.insertRealatives(relatives);
			try {
				sendEmail();
			} catch (AddressException e1) {

				e1.printStackTrace();
			} catch (MessagingException e1) {

				e1.printStackTrace();
			}
			clearfields();
			JOptionPane.showMessageDialog(this, "Insert sucessfull, mail has been sent to employee!");
			CardLayout card = (CardLayout) panel.getLayout();
			card.show(panel, "employee");
			fillDataToJTable(empb.ShowNew());
		} else {
			JOptionPane.showMessageDialog(this, "Insert fail!");
		}
	}

	// =======send e-mail============
	public void sendEmail() throws AddressException, MessagingException {

		final String from = "roisiestore.hcm@gmail.com";
		final String pass = "roisiestore$1234";
		final String to = txtEmail.getText();
		final String subject = "Welcome to Traveloto!";
		final String body = "<h4>Hello " + txtFullname.getText() + "," + "</h4>"
				+ "<strong>This is your information  to access Traveloto system: </strong>" + "<h5>Username: "
				+ txtUserName.getText() + "</h5>" + "<h5> Password: "
				+ String.valueOf(passwordField_PassWord.getPassword()) + "</h5>"
				+ "<h5> You should be change your password after login." + "</h5>" + "<i>Thanks & Best Regards!</i>";

		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "465");
		properties.put("mail.smtp.ssl.enable", "true");
		properties.put("mail.smtp.auth", "true");
		Session session = Session.getDefaultInstance(properties, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(from, pass);
			}
		});
		MimeMessage message = new MimeMessage(session);

		try {
			message.setFrom(new InternetAddress(from, "NoReply-Traveloto"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		message.setReplyTo(InternetAddress.parse(from, false));
		message.setSubject(subject, "text/html");
		message.setContent(body, "text/html");
		message.setSentDate(new Date());
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));
		Transport.send(message);
	}

	// =================request tab===============================

	private void fillDataToJTableRequest(List<Requestleave> request) {

		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("Request No");
		model.addColumn("From Employee");
		model.addColumn("Status");

		request.forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
				empb.getacc(rql.getIdemp()).getFullname(), (switch (rql.getSttrequestleave()) {
				case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show ra stt 1
				case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok -> hr, admin doi tu 1-2
				case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
				case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
				default -> "Cancel";// admin hoac emp an cancel
				}), }));
		table_Request.setModel(model);
		table_Request.getTableHeader().setReorderingAllowed(false);
	}

	protected void btnRequestActionPerformed(ActionEvent e) {
		var rqb = new RequestleaveBao();
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "request");
		// test => run from HR
		// fillDataToJTableRequest((rqb.showRequestLeavebyADOrHR(1)));

		// official => run from main
		fillDataToJTableRequest(rqb.showRequestLeavebyADOrHR(emp.getIdemp()));
		empb.getADO().forEach(listAd -> comboBox_Adchoice.addItem(listAd.getIdemp()));
	}

	protected void comboBox_AdchoiceActionPerformed(ActionEvent e) {
		lblShowName_Ad
				.setText(empb.getacc(Integer.parseInt(comboBox_Adchoice.getSelectedItem().toString())).getFullname());
	}

	protected void table_RequestMousePressed(MouseEvent e) {
		int selectedRow = table_Request.getSelectedRow();
		int idrq = Integer.parseInt(table_Request.getValueAt(selectedRow, 0).toString());
		var rqb = new RequestleaveBao();
		var getrq = rqb.selectidemp(idrq);
		var getemp = empb.getacc(rqb.selectidemp(idrq).getIdemp());
		String namedept = depb.getdep(getemp.getIddep()).getNamedep();
		lblName_Leave.setText(getemp.getFullname());
		lblDept_Leave.setText(namedept);
		lblShowOnboard_Leave.setText(String.valueOf(getemp.getOnboarddate()));
		lblShowAL_Leave.setText((String.valueOf(getemp.getAnnualleave())));
		lblShowSL_Leave.setText((String.valueOf(getemp.getSickleave())));
		lblShowUL_Leave.setText((String.valueOf(getemp.getUnpaidleave())));
		lblShowId_RQ.setText((String.valueOf(getrq.getIdrqleave())));
		lblShowFrom_RQ.setText((String.valueOf(getrq.getFromdate())));
		lblShowTo_RQ.setText((String.valueOf(getrq.getTodate())));
		lblShowAL_RQ.setText((String.valueOf(getrq.getAnnualleave())));
		lblShowUL_RQ.setText((String.valueOf(getrq.getUnpaidleave())));
		lblShowSL_RQ.setText((String.valueOf(getrq.getSickleave())));
		lblShowNote_RQ.setText((String.valueOf(getrq.getNote())));
	}

	protected void btnUpdate_LeaveActionPerformed(ActionEvent e) {
		double rqALday = Double.parseDouble(lblShowAL_RQ.getText());
		double rqULday = Double.parseDouble(lblShowUL_RQ.getText());
		double rqSLday = Double.parseDouble(lblShowSL_RQ.getText());
		var rqb = new RequestleaveBao();
		var idrq = Integer.parseInt(lblShowId_RQ.getText());
		var idAd = Integer.parseInt(comboBox_Adchoice.getSelectedItem().toString());
		var idemp = empb.getacc(rqb.selectidemp(idrq).getIdemp()).getIdemp();
		var nameAd = lblShowName_Ad.getText();
		int result = JOptionPane.showConfirmDialog(this, "Do you want update leave and escalate to " + nameAd + "?",
				"Confirm Request Leave", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			empb.updateLeave(idemp, rqALday, rqULday, rqSLday);
			rqb.updateSTT(idAd, 3, idrq);
			JOptionPane.showMessageDialog(this, "succes");
			fillDataToJTableRequest(rqb.showRequestLeavebyADOrHR(emp.getIdemp()));
			lblName_Leave.setText("");
			lblDept_Leave.setText("");
			lblShowOnboard_Leave.setText("");
			lblShowAL_Leave.setText("");
			lblShowSL_Leave.setText("");
			lblShowUL_Leave.setText("");
			lblShowId_RQ.setText("");
			lblShowFrom_RQ.setText("");
			lblShowTo_RQ.setText("");
			lblShowAL_RQ.setText("");
			lblShowUL_RQ.setText("");
			lblShowSL_RQ.setText("");
			lblShowNote_RQ.setText("");
		}
	}

	protected void btnSearch_RQActionPerformed(ActionEvent e) {
		var key = txtSearch_Rq.getText();
		var rqb = new RequestleaveBao();
		lblCheckName_rq.setText(helper.Validation.MessErrorSearchNameXuan(key));
		if (key.equals("")) {
			fillDataToJTableRequest(rqb.showRequestLeavebyADOrHR(emp.getIdemp()));
			lblCheckName_rq.setText("");
		} else if (lblCheckName_rq.getText().equals("")) {
			fillDataToJTableRequest(rqb.searchRQbyName(key, emp.getIdemp()));
		}
	}

	// ========================REPORT TAB=======================
	protected void btnreportActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "report");
	}

	private void loadDataDeptAttend() {
		DepartmentBao deptbao = new DepartmentBao();
		fillDataToJComboboxDeptAttend(deptbao.getAllList());
	}

	private void fillDataToJComboboxDeptAttend(List<Department> dept) {
		DefaultComboBoxModel<Department> defaultComboBoxModel = new DefaultComboBoxModel<Department>();
		for (Department department : dept) {
			defaultComboBoxModel.addElement(department);
		}
		comboBox_DeptReport.setModel(defaultComboBoxModel);
		comboBox_DeptReport.setRenderer(new CategoryListCellRenderDeptAttend());
	}

	private class CategoryListCellRenderDeptAttend extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department dept = (Department) value;
			return super.getListCellRendererComponent(list, dept.getNamedep(), index, isSelected, cellHasFocus);
		}
	}

	private void fillDataToJTableReport(List<Salary> salary) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("MONTH");
		model.addColumn("DEPT");
		model.addColumn("TOTAL SALARY");
		model.addColumn("NET PAY");
		salary.forEach(sal -> model.addRow(new Object[] { sal.getIdemp(), empb.getacc(sal.getIdemp()).getFullname(),
				sal.getMonth(), depb.getdep(empb.getacc(sal.getIdemp()).getIddep()).getNamedep(), sal.getTotalsalary(),
				sal.getIncome() }));
		table_Report.setModel(model);
		table_Report.getTableHeader().setReorderingAllowed(false);
	}

	protected void comboBox_MonthRpActionPerformed(ActionEvent e) {
		var salb = new SalaryBao();
		var month = comboBox_MonthRp.getSelectedIndex();
		var MONTH = comboBox_MonthRp.getSelectedItem().toString();
		fillDataToJTableReport(salb.getSalByMonth(String.valueOf(month + 1)));
		btnExport_Report.setVisible(true);
		lblMonth_Dept.setText("MONTH: " + MONTH);
		lblShowName_report.setText("Total Employee:");
		;
		lblTotalEmp_rp.setText(String.valueOf(salb.totalEmp(month + 1)));
		lblTotalMeal_rp.setText(String.valueOf(salb.totalMeal(month + 1)));
		lblTotalNight_rp.setText(String.valueOf(salb.totalNight(month + 1)));
		lblTotalOTSal_rp.setText(String.valueOf(salb.totalOTSal(month + 1)));
		lblTotalSal_rp.setText(String.valueOf(salb.totaSal(month + 1)));
		lblTotalDeduc_rp.setText(String.valueOf(salb.totaSalDeduc(month + 1)));
		lblTotalInsurance_rp.setText(String.valueOf(salb.totaInsur(month + 1)));
		lblTotalNetpay_rp.setText(String.valueOf(salb.totaNetpay(month + 1)));
		lblHighNetpay_rp.setText(String.valueOf(salb.MaxNetpay(month + 1)));
		lblLowNetpay_rp.setText(String.valueOf(salb.MinNetpay(month + 1)));
		lblAvgNetpay_rp.setText(String.valueOf(salb.AvgNetpay(month + 1)));
	}

	protected void comboBox_SortSal_monthActionPerformed(ActionEvent e) {
		var salb = new SalaryBao();
		var month = comboBox_MonthRp.getSelectedIndex();
		var MONTH = comboBox_MonthRp.getSelectedItem().toString();
		var sort = comboBox_SortSal_month.getSelectedIndex();
		btnExport_Report.setVisible(true);
		switch (sort) {
		case 0 -> {
			fillDataToJTableReport(salb.getSalByMonthDesc(String.valueOf(month + 1)));
			lblMonth_Dept.setText("MONTH: " + MONTH);
			lblShowName_report.setText("Total Employee:");
			lblTotalEmp_rp.setText(String.valueOf(salb.totalEmp(month + 1)));
			lblTotalMeal_rp.setText(String.valueOf(salb.totalMeal(month + 1)));
			lblTotalNight_rp.setText(String.valueOf(salb.totalNight(month + 1)));
			lblTotalOTSal_rp.setText(String.valueOf(salb.totalOTSal(month + 1)));
			lblTotalSal_rp.setText(String.valueOf(salb.totaSal(month + 1)));
			lblTotalDeduc_rp.setText(String.valueOf(salb.totaSalDeduc(month + 1)));
			lblTotalInsurance_rp.setText(String.valueOf(salb.totaInsur(month + 1)));
			lblTotalNetpay_rp.setText(String.valueOf(salb.totaNetpay(month + 1)));
			lblHighNetpay_rp.setText(String.valueOf(salb.MaxNetpay(month + 1)));
			lblLowNetpay_rp.setText(String.valueOf(salb.MinNetpay(month + 1)));
			lblAvgNetpay_rp.setText(String.valueOf(salb.AvgNetpay(month + 1)));
		}
		case 1 -> {
			fillDataToJTableReport(salb.getSalByMonthAsc(String.valueOf(month + 1)));
			lblMonth_Dept.setText("MONTH: " + MONTH);
			lblShowName_report.setText("Total Employee:");
			lblTotalEmp_rp.setText(String.valueOf(salb.totalEmp(month + 1)));
			lblTotalMeal_rp.setText(String.valueOf(salb.totalMeal(month + 1)));
			lblTotalNight_rp.setText(String.valueOf(salb.totalNight(month + 1)));
			lblTotalOTSal_rp.setText(String.valueOf(salb.totalOTSal(month + 1)));
			lblTotalSal_rp.setText(String.valueOf(salb.totaSal(month + 1)));
			lblTotalDeduc_rp.setText(String.valueOf(salb.totaSalDeduc(month + 1)));
			lblTotalInsurance_rp.setText(String.valueOf(salb.totaInsur(month + 1)));
			lblTotalNetpay_rp.setText(String.valueOf(salb.totaNetpay(month + 1)));
			lblHighNetpay_rp.setText(String.valueOf(salb.MaxNetpay(month + 1)));
			lblLowNetpay_rp.setText(String.valueOf(salb.MinNetpay(month + 1)));
			lblAvgNetpay_rp.setText(String.valueOf(salb.AvgNetpay(month + 1)));
		}
		}
	}

	protected void comboBox_DeptReportActionPerformed(ActionEvent e) {
		Department dept = (Department) comboBox_DeptReport.getSelectedItem();
		String iddep = dept.getIddep();
		btnExport_Report.setVisible(false);
		var salb = new SalaryBao();
		var month = comboBox_MonthRp.getSelectedIndex();
		var MONTH = comboBox_MonthRp.getSelectedItem().toString();
		fillDataToJTableReport(salb.sortSalByDeptMonth(month + 1, iddep));
		lblMonth_Dept.setText("MONTH: " + MONTH + "  -  " + "DEPT: " + depb.getdep(iddep).getNamedep());
		lblShowName_report.setText("Total Employee:");
		lblTotalEmp_rp.setText(String.valueOf(salb.totalEmbyDept(iddep, month + 1)));
		lblTotalMeal_rp.setText(String.valueOf(salb.totalMealDept(iddep, month + 1)));
		lblTotalNight_rp.setText(String.valueOf(salb.totalNightDept(iddep, month + 1)));
		lblTotalOTSal_rp.setText(String.valueOf(salb.totalOTSalDept(iddep, month + 1)));
		lblTotalSal_rp.setText(String.valueOf(salb.totaSalDept(iddep, month + 1)));
		lblTotalDeduc_rp.setText(String.valueOf(salb.totaSalDeducDept(iddep, month + 1)));
		lblTotalInsurance_rp.setText(String.valueOf(salb.totaInsurDept(iddep, month + 1)));
		lblTotalNetpay_rp.setText(String.valueOf(salb.totaNetpayDept(iddep, month + 1)));
		lblHighNetpay_rp.setText(String.valueOf(salb.MaxNetpayDept(iddep, month + 1)));
		lblLowNetpay_rp.setText(String.valueOf(salb.MinNetpayDept(iddep, month + 1)));
		lblAvgNetpay_rp.setText(String.valueOf(salb.AvgNetpayDept(iddep, month + 1)));
	}

	protected void comboBox_SortSalActionPerformed(ActionEvent e) {
		Department dept = (Department) comboBox_DeptReport.getSelectedItem();
		String iddep = dept.getIddep();
		btnExport_Report.setVisible(false);
		var salb = new SalaryBao();
		var month = comboBox_MonthRp.getSelectedIndex();
		var MONTH = comboBox_MonthRp.getSelectedItem().toString();
		var sort = comboBox_SortSal.getSelectedIndex();
		switch (sort) {
		case 0 -> {
			fillDataToJTableReport(salb.sortSalByDeptMonthDesc(month + 1, iddep));
			lblMonth_Dept.setText("MONTH: " + MONTH + "  -  " + "DEPT: " + depb.getdep(iddep).getNamedep());
			lblShowName_report.setText("Total Employee:");
			lblTotalEmp_rp.setText(String.valueOf(salb.totalEmbyDept(iddep, month + 1)));
			lblTotalMeal_rp.setText(String.valueOf(salb.totalMealDept(iddep, month + 1)));
			lblTotalNight_rp.setText(String.valueOf(salb.totalNightDept(iddep, month + 1)));
			lblTotalOTSal_rp.setText(String.valueOf(salb.totalOTSalDept(iddep, month + 1)));
			lblTotalSal_rp.setText(String.valueOf(salb.totaSalDept(iddep, month + 1)));
			lblTotalDeduc_rp.setText(String.valueOf(salb.totaSalDeducDept(iddep, month + 1)));
			lblTotalInsurance_rp.setText(String.valueOf(salb.totaInsurDept(iddep, month + 1)));
			lblTotalNetpay_rp.setText(String.valueOf(salb.totaNetpayDept(iddep, month + 1)));
			lblHighNetpay_rp.setText(String.valueOf(salb.MaxNetpayDept(iddep, month + 1)));
			lblLowNetpay_rp.setText(String.valueOf(salb.MinNetpayDept(iddep, month + 1)));
			lblAvgNetpay_rp.setText(String.valueOf(salb.AvgNetpayDept(iddep, month + 1)));
		}

		case 1 -> {
			fillDataToJTableReport(salb.sortSalByDeptMonthAsc(month + 1, iddep));
			lblMonth_Dept.setText("MONTH: " + MONTH + "  -  " + "DEPT: " + depb.getdep(iddep).getNamedep());
			lblShowName_report.setText("Total Employee:");
			lblTotalEmp_rp.setText(String.valueOf(salb.totalEmbyDept(iddep, month + 1)));
			lblTotalMeal_rp.setText(String.valueOf(salb.totalMealDept(iddep, month + 1)));
			lblTotalNight_rp.setText(String.valueOf(salb.totalNightDept(iddep, month + 1)));
			lblTotalOTSal_rp.setText(String.valueOf(salb.totalOTSalDept(iddep, month + 1)));
			lblTotalSal_rp.setText(String.valueOf(salb.totaSalDept(iddep, month + 1)));
			lblTotalDeduc_rp.setText(String.valueOf(salb.totaSalDeducDept(iddep, month + 1)));
			lblTotalInsurance_rp.setText(String.valueOf(salb.totaInsurDept(iddep, month + 1)));
			lblTotalNetpay_rp.setText(String.valueOf(salb.totaNetpayDept(iddep, month + 1)));
			lblHighNetpay_rp.setText(String.valueOf(salb.MaxNetpayDept(iddep, month + 1)));
			lblLowNetpay_rp.setText(String.valueOf(salb.MinNetpayDept(iddep, month + 1)));
			lblAvgNetpay_rp.setText(String.valueOf(salb.AvgNetpayDept(iddep, month + 1)));
		}
		}
	}

	protected void table_ReportMousePressed(MouseEvent e) {
		int selectedRow = table_Report.getSelectedRow();
		int idemp = (int) table_Report.getValueAt(selectedRow, 0);
		var emp = empb.getacc(idemp);
		var salb = new SalaryBao();
		btnExport_Report.setVisible(true);
		lblMonth_Dept.setText("From month: 1" + " to " + salb.checkLastestMonthSal());
		lblShowName_report.setText("Employee Name:");
		lblTotalEmp_rp.setText(emp.getFullname());
		lblTotalMeal_rp.setText(String.valueOf(salb.totalMealEmp(idemp)));
		lblTotalNight_rp.setText(String.valueOf(salb.totalNightEmp(idemp)));
		lblTotalOTSal_rp.setText(String.valueOf(salb.totalOTSalEmp(idemp)));
		lblTotalSal_rp.setText(String.valueOf(salb.totaSalEmp(idemp)));
		lblTotalDeduc_rp.setText(String.valueOf(salb.totaSalDeducEmp(idemp)));
		lblTotalInsurance_rp.setText(String.valueOf(salb.totaInsurEmp(idemp)));
		lblTotalNetpay_rp.setText(String.valueOf(salb.totaNetpayEmp(idemp)));
		lblHighNetpay_rp.setText(String.valueOf(salb.MaxNetpayEmp(idemp)));
		lblLowNetpay_rp.setText(String.valueOf(salb.MinNetpayEmp(idemp)));
		lblAvgNetpay_rp.setText(String.valueOf(salb.AvgNetpayEmp(idemp)));
	}

	protected void btnExport_ReportActionPerformed(ActionEvent e) {
		var salb = new SalaryBao();
		int month = comboBox_MonthRp.getSelectedIndex();
		var MONTH = comboBox_MonthRp.getSelectedItem().toString();
		if (salb.checkMonth(month + 1)) {
			if (lblMonth_Dept.getText().equals("MONTH: " + MONTH)) {
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("Save file in ");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel File (*.xlsx)", "xlsx");
				jfc.setFileFilter(filter);
				jfc.setSelectedFile(new File("Payroll-" + MONTH));
				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					final List<Salary> listSalary = salb.getSalByMonth(String.valueOf(month + 1));
					final String excelFilePath = jfc.getSelectedFile().toString() + ".xlsx";
					try {
						writeExcel(listSalary, excelFilePath);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(this, "Export success!");
				}
			} else if (lblShowName_report.getText().equals("Employee Name:")) {
				int selectedRow = table_Report.getSelectedRow();
				int idemp = (int) table_Report.getValueAt(selectedRow, 0);
				var name = empb.getacc(idemp).getFullname();
				JFileChooser jfc = new JFileChooser();
				jfc.setDialogTitle("Save file in ");
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel File (*.xlsx)", "xlsx");
				jfc.setFileFilter(filter);
				jfc.setSelectedFile(new File("Payroll Summary-" + name));
				int returnValue = jfc.showSaveDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					final List<Salary> listSalary = salb.getSalById(String.valueOf(idemp));
					final String excelFilePath = jfc.getSelectedFile().toString() + ".xlsx";
					try {
						writeExcel(listSalary, excelFilePath);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
					JOptionPane.showMessageDialog(this, "Export success!");
				}
			}
		} else {
			JOptionPane.showMessageDialog(this, "This month not exist in payroll!");
		}
	}

	// ==============SALARY TAB==================================
	private void fillDataToJTableSalary(List<Salary> salary) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("ID");
		model.addColumn("NAME");
		model.addColumn("MONTH");
		model.addColumn("TOTAL SALARY");
		model.addColumn("NET PAY");
		salary.forEach(sal -> model.addRow(new Object[] { sal.getIdemp(), empb.getacc(sal.getIdemp()).getFullname(),
				sal.getMonth(), sal.getTotalsalary(), sal.getIncome() }));
		table_Payroll.setModel(model);
		table_Payroll.getTableHeader().setReorderingAllowed(false);
	}

	protected void btn_SalaryActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "salary");
	}

	public Date gettoday() {
		var date = new Date();
		return new java.sql.Date(date.getTime());
	}

	protected void btnCalSalaryActionPerformed(ActionEvent e) {
		var salb = new SalaryBao();
		var month = comboBox_monthSal.getSelectedIndex();
		if (salb.checkMonth(month + 1)) {
			int result = JOptionPane.showConfirmDialog(this, "This month exist in payroll. Do you want to replace? ",
					"Confirm delete", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				salb.updateSalary(month + 1);
				JOptionPane.showMessageDialog(this, "Get new payroll success");
				fillDataToJTableSalary(salb.getSalByMonth(String.valueOf(month + 1)));
			}
		} else if (salb.checkLastestMonth() < month + 1) {
			JOptionPane.showMessageDialog(this, "Attendance record not update");
		} else {
			salb.showSalary(month + 1);
			empb.updateLeaveMonth(gettoday());
			empb.updateLeaveYear(gettoday());
			JOptionPane.showMessageDialog(this, "Get payroll success");
			fillDataToJTableSalary(salb.getSalByMonth(String.valueOf(month + 1)));
		}
	}

	protected void table_PayrollMousePressed(MouseEvent e) {
		int selectedRow = table_Payroll.getSelectedRow();
		int idemp = Integer.parseInt(table_Payroll.getValueAt(selectedRow, 0).toString());
		int month = Integer.parseInt(table_Payroll.getValueAt(selectedRow, 2).toString());
		var emp = empb.getacc(idemp);
		var salb = new SalaryBao();
		var getsal = salb.showSalaryById(idemp, month);
		double nightshitf = getsal.getTotalshift3() + getsal.getTotalshift4();
		long deduction = getsal.getInsurance() + getsal.getSalarydeduction();
		String namedept = depb.getdep(emp.getIddep()).getNamedep();
		lblMonth_Salary.setText("MONTH " + String.valueOf(getsal.getMonth()));
		lblId_Salary.setText(String.valueOf(idemp));
		lblName_Salary.setText(empb.getacc(idemp).getFullname());
		lblDept_Salary.setText(namedept);
		if (getsal.getPayday() == null) {
			lblPayday_Salary.setText("No update yet");
		} else {
			lblPayday_Salary.setText(getsal.getPayday().toString());
		}
		lblShowSDay_Sal.setText(String.valueOf(getsal.getStandardday()));
		lblShowAL_Sal.setText(String.valueOf(getsal.getNumberAl()));
		lblShowUL_Sal.setText(String.valueOf(getsal.getNumberUL()));
		lblShowSL_Sal.setText(String.valueOf(getsal.getNumberSL()));
		lblShowLunch_Sal.setText(String.valueOf(getsal.getTotalworkfullday()));
		lblShowNight_Sal.setText(String.valueOf(nightshitf));
		lblShowOffday_Sal.setText(String.valueOf(getsal.getWorkingoffday()));
		lblShowHoli_Sal.setText(String.valueOf(getsal.getWorkingHL()));
		lblShowOT_Sal.setText(String.valueOf(getsal.getTotalOTonday()));
		lblShowOTOff_Sal.setText(String.valueOf(getsal.getTotalOToffday()));
		lblShowOTHoli_Sal.setText(String.valueOf(getsal.getTotalOTHLday()));
		lblShowOToffHL_Sal.setText(String.valueOf(getsal.getTotalOToffHL()));
		lblShowWKday_Sal.setText(String.valueOf(getsal.getWorkingday()));
		lblBasicSal.setText(String.valueOf(getsal.getBasicsalary()));
		lblMeal.setText(String.valueOf(getsal.getMealallowance()));
		lblNight.setText(String.valueOf(getsal.getNightshiftallowance()));
		lblOT.setText(String.valueOf(getsal.getOTsalary()));
		lblTotal.setText(String.valueOf(getsal.getTotalsalary()));
		lblDeduction.setText(String.valueOf(getsal.getSalarydeduction()));
		lblInsurance.setText(String.valueOf(getsal.getInsurance()));
		lblTotalDeduc.setText(String.valueOf(deduction));
		lblNetPay.setText(String.valueOf(getsal.getIncome()));
	}

	protected void btnUpdate_PaydayActionPerformed(ActionEvent e) {
		var salary = new Salary();
		var salb = new SalaryBao();
		int month = comboBox_monthSal_1.getSelectedIndex();
		String MONTH = comboBox_monthSal_1.getSelectedItem().toString();
		salary.setPayday(dateChooser_payday.getDate());
		if (salb.checkMonth(month + 1)) {
			int result = JOptionPane.showConfirmDialog(this, "Do you want to update payday for " + MONTH + "?",
					"Confirm Change", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				salb.updatePayday(salary, month + 1);
				JOptionPane.showMessageDialog(this, "Update success!");
				fillDataToJTableSalary(salb.getSalByMonth(String.valueOf(month + 1)));
			}
		} else {
			JOptionPane.showMessageDialog(this, "There's no payroll for this month!");
		}
	}

	private void loadDataDeptSal() {
		DepartmentBao deptbao = new DepartmentBao();
		fillDataToJComboboxDeptSal(deptbao.getAllList());
	}

	private void fillDataToJComboboxDeptSal(List<Department> dept) {
		DefaultComboBoxModel<Department> defaultComboBoxModel = new DefaultComboBoxModel<Department>();
		for (Department department : dept) {
			defaultComboBoxModel.addElement(department);
		}
		comboBox_Dept_Sal.setModel(defaultComboBoxModel);
		comboBox_Dept_Sal.setRenderer(new CategoryListCellRenderDeptSal());
	}

	private class CategoryListCellRenderDeptSal extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Department dept = (Department) value;
			return super.getListCellRendererComponent(list, dept.getNamedep(), index, isSelected, cellHasFocus);
		}
	}

	protected void btnSearch_SalActionPerformed(ActionEvent e) {
		var key = txtSearch_Sal.getText();
		var select = comboBox_Field_Sal.getSelectedIndex();
		var salb = new SalaryBao();
		if (key.isEmpty()) {
			lblCheckSearch_sal.setText("Please, fill keyword!");
		} else {
			lblCheckSearch_sal.setText("");
			switch (select) {
			case 0 -> {
				lblCheckSearch_sal.setText(helper.Validation.MessErrorInputNumber(key));
				if (lblCheckSearch_sal.getText().equals("")) {
					fillDataToJTableSalary(salb.getSalById(key));
				}
			}
			case 1 -> {
				lblCheckSearch_sal.setText(helper.Validation.MessErrorSearchNameXuan(key));
				if (lblCheckSearch_sal.getText().equals("")) {
					fillDataToJTableSalary(salb.getSalByName(key));
				}
			}
			case 2 -> {
				lblCheckSearch_sal.setText(helper.Validation.MessErrorInputNumber(key));
				if (lblCheckSearch_sal.getText().equals("")) {
					fillDataToJTableSalary(salb.getSalByMonth(key));
				}
			}
			}
		}
	}

	protected void btnSort_SalActionPerformed(ActionEvent e) {
		lblCheckSearch_sal.setText("");
		var month = comboBox_SortmonthSal.getSelectedIndex();
		Department dept = (Department) comboBox_Dept_Sal.getSelectedItem();
		var iddep = dept.getIddep();
		var salb = new SalaryBao();
		fillDataToJTableSalary(salb.sortSalByDeptMonth(month + 1, iddep));
	}

	public static void writeExcel(List<Salary> listSalary, String excelFilePath) throws IOException {
		Workbook workbook = getWorkbook(excelFilePath);
		Sheet sheet = workbook.createSheet("Payroll");
		int rowIndex = 0;
		// Write header
		writeHeader(sheet, rowIndex);
		// Write data
		rowIndex++;
		for (Salary list : listSalary) {
			// Create row
			Row row = sheet.createRow(rowIndex);
			// Write data on row
			writeBook(list, row, sheet);
			rowIndex++;
		}
		// Auto resize column witdth
		int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
		autosizeColumn(sheet, numberOfColumn);
		// Create file excel
		createOutputFile(workbook, excelFilePath);
	}

	// Create workbook
	private static Workbook getWorkbook(String excelFilePath) throws IOException {
		Workbook workbook = null;

		if (excelFilePath.endsWith("xlsx")) {
			workbook = new XSSFWorkbook();
		} else if (excelFilePath.endsWith("xls")) {
			workbook = new HSSFWorkbook();
		} else {
			throw new IllegalArgumentException("The specified file is not Excel file");
		}
		return workbook;
	}

	// Write header with format
	private static void writeHeader(Sheet sheet, int rowIndex) {
		// create CellStyle
		CellStyle cellStyle = createStyleForHeader(sheet);

		// Create row
		Row row = sheet.createRow(rowIndex);

		// Create cells
		Cell cell = row.createCell(0);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Month");

		cell = row.createCell(1);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("ID Emp");

		cell = row.createCell(2);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Fullname");

		cell = row.createCell(3);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Basic salary");

		cell = row.createCell(4);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Department");

		cell = row.createCell(5);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Number AL");

		cell = row.createCell(6);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Number UL");

		cell = row.createCell(7);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Number SL");

		cell = row.createCell(8);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Working holidays");

		cell = row.createCell(9);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Working offday");

		cell = row.createCell(10);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Working days");

		cell = row.createCell(11);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Lunch");

		cell = row.createCell(12);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Nightshift");

		cell = row.createCell(13);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("OT Ondays");

		cell = row.createCell(14);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("OT Offdays");

		cell = row.createCell(15);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("OT Holidays");

		cell = row.createCell(16);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("OT off holiday");

		cell = row.createCell(17);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("OT Ondays salary");

		cell = row.createCell(18);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("OT Offdays salary");

		cell = row.createCell(19);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("OT Holidays salary");

		cell = row.createCell(20);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("OT off holiday salary");

		cell = row.createCell(21);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Meal allowances");

		cell = row.createCell(22);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Night allowances");

		cell = row.createCell(23);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("OT salary");

		cell = row.createCell(24);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total salary");

		cell = row.createCell(25);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Salary deduction");

		cell = row.createCell(26);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Social insurance");

		cell = row.createCell(27);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Net pay");
	}

	// Write data
	private static void writeBook(Salary listSalary, Row row, Sheet sheet) {
		var empb = new EmployeeBao();
		var deptb = new DepartmentBao();

		CellStyle cellstyle = createStyleForRow(sheet);
		CellStyle cellstyleData = createStyleDataCell(sheet);
		CellStyle cellstyleCurrency = createStyleCurrency(sheet);

		Cell cell = row.createCell(0);
		cell.setCellValue(listSalary.getMonth());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(1);
		cell.setCellValue(listSalary.getIdemp());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(2);
		cell.setCellValue(empb.getacc(listSalary.getIdemp()).getFullname());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(3);
		cell.setCellValue(listSalary.getBasicsalary());
		cell.setCellStyle(cellstyleCurrency);

		cell = row.createCell(4);
		cell.setCellValue(deptb.getdep(empb.getacc(listSalary.getIdemp()).getIddep()).getNamedep());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(5);
		cell.setCellValue(listSalary.getNumberAl());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(6);
		cell.setCellValue(listSalary.getNumberUL());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(7);
		cell.setCellValue(listSalary.getNumberSL());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(8);
		cell.setCellValue(listSalary.getWorkingHL());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(9);
		cell.setCellValue(listSalary.getWorkingoffday());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(10);
		cell.setCellValue(listSalary.getWorkingday());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(11);
		cell.setCellValue(listSalary.getTotalworkfullday());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(12);
		cell.setCellValue(listSalary.getTotalshift3() + listSalary.getTotalshift4());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(13);
		cell.setCellValue(listSalary.getTotalOTonday());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(14);
		cell.setCellValue(listSalary.getTotalOToffday());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(15);
		cell.setCellValue(listSalary.getTotalOTHLday());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(16);
		cell.setCellValue(listSalary.getTotalOToffHL());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(17);
		cell.setCellValue(listSalary.getOTondaysalary());
		cell.setCellStyle(cellstyleCurrency);

		cell = row.createCell(18);
		cell.setCellValue(listSalary.getOToffdaysalary());
		cell.setCellStyle(cellstyleCurrency);

		cell = row.createCell(19);
		cell.setCellValue(listSalary.getOTHLsalary());
		cell.setCellStyle(cellstyleCurrency);

		cell = row.createCell(20);
		cell.setCellValue(listSalary.getOToffHLsalary());
		cell.setCellStyle(cellstyleCurrency);

		cell = row.createCell(21);
		cell.setCellValue(listSalary.getMealallowance());
		cell.setCellStyle(cellstyleCurrency);

		cell = row.createCell(22);
		cell.setCellValue(listSalary.getNightshiftallowance());
		cell.setCellStyle(cellstyleCurrency);

		cell = row.createCell(23);
		cell.setCellValue(listSalary.getOTsalary());
		cell.setCellStyle(cellstyleCurrency);

		cell = row.createCell(24);
		cell.setCellValue(listSalary.getTotalsalary());
		cell.setCellStyle(cellstyleCurrency);

		cell = row.createCell(25);
		cell.setCellValue(listSalary.getSalarydeduction());
		cell.setCellStyle(cellstyleCurrency);

		cell = row.createCell(26);
		cell.setCellValue(listSalary.getInsurance());
		cell.setCellStyle(cellstyleCurrency);

		cell = row.createCell(27);
		cell.setCellValue(listSalary.getIncome());
		cell.setCellStyle(cellstyleCurrency);
	}

	// Create CellStyle for header
	private static CellStyle createStyleForHeader(Sheet sheet) {
		// Create font
		org.apache.poi.ss.usermodel.Font font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman");
		font.setBold(true);
		font.setFontHeightInPoints((short) 14); // font size
		font.setColor(IndexedColors.BLACK.getIndex()); // text color

		// Create CellStyle
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setFillForegroundColor(IndexedColors.LIGHT_GREEN.getIndex());
		cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		cellStyle.setBorderBottom(BorderStyle.MEDIUM);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		return cellStyle;
	}

	// Create CellStyle for row
	private static CellStyle createStyleForRow(Sheet sheet) {
		// Create font
		org.apache.poi.ss.usermodel.Font font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short) 12); // font size
		font.setColor(IndexedColors.BLACK.getIndex()); // text color

		// Create CellStyle
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		cellStyle.setFont(font);
		cellStyle.setBorderBottom(BorderStyle.DASHED);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		return cellStyle;
	}

	// Create CellStyle for number cell
	private static CellStyle createStyleDataCell(Sheet sheet) {
		// Create font
		org.apache.poi.ss.usermodel.Font font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short) 12); // font size
		font.setColor(IndexedColors.BLACK.getIndex()); // text color

		// Create CellStyle
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		DataFormat format = sheet.getWorkbook().createDataFormat();
		cellStyle.setFont(font);
		cellStyle.setBorderBottom(BorderStyle.DASHED);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setDataFormat(format.getFormat("0.0"));
		return cellStyle;
	}

	// Create CellStyle for currency cell
	private static CellStyle createStyleCurrency(Sheet sheet) {
		// Create font
		org.apache.poi.ss.usermodel.Font font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short) 12); // font size
		font.setColor(IndexedColors.BLACK.getIndex()); // text color

		// Create CellStyle
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		DataFormat format = sheet.getWorkbook().createDataFormat();
		cellStyle.setFont(font);
		cellStyle.setBorderBottom(BorderStyle.DASHED);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setDataFormat(format.getFormat("#,###,##0"));

		return cellStyle;
	}

	// Auto resize column width
	private static void autosizeColumn(Sheet sheet, int lastColumn) {
		for (int columnIndex = 0; columnIndex < lastColumn; columnIndex++) {
			sheet.autoSizeColumn(columnIndex);
		}
	}

	// Create output file
	private static void createOutputFile(Workbook workbook, String excelFilePath) throws IOException {
		try (OutputStream os = new FileOutputStream(excelFilePath)) {
			workbook.write(os);
		}
	}
}
