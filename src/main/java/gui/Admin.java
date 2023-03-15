package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.border.EmptyBorder;

import bao.AttendancemonthlyreportBao;
import bao.AttendancerecordBao;
import bao.DepartmentBao;
import bao.EmployeeBao;
import bao.RequestchangeShiftBao;
import bao.RequestleaveBao;
import bao.SalaryBao;
import bao.ShiftBao;
import bao.TempsplittheteamBao;

import dao.TempsplittheteamDao;
import entities.Attendancemonthlyreport;
import entities.Attendancerecord;
import entities.Employee;
import entities.Requestleave;
import entities.Salary;

import java.awt.GridBagLayout;
import java.awt.HeadlessException;

import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.UIManager;
import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.CardLayout;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTabbedPane;
import java.awt.Component;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.border.CompoundBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;

public class Admin extends JFrame {
	private ChooseType ct = new ChooseType();
	private EmployeeBao empb = new EmployeeBao();
	private AttendancerecordBao atdbao = new AttendancerecordBao();
	private RequestleaveBao rqlbao = new RequestleaveBao();
	private AttendancemonthlyreportBao attendMonth = new AttendancemonthlyreportBao();
	private RequestchangeShiftBao rqsbao = new RequestchangeShiftBao();
	private Employee emp;
	private ShiftBao sb = new ShiftBao();
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel;
	private JPanel panel_trangchu;
	private JPanel panel_arrangeshifts;
	private JPanel panel_Request;
	private JPanel panel_4;
	private JLabel lblNewLabel_2;
	private JDateChooser dateChooser;
	private JButton btn_SearchTrangChu;
	private JPanel panel_5;
	private JTable table;
	private JButton btn_back;
	private JButton btn_callxepca;
	private JButton btn_callrequest;
	private JButton btn_logout;
	private JButton btn_report;
	private JPanel panel_reportbymonth;
	private JTextField tf_searchName;
	private JComboBox comboBox_searchShiftTrangchur;
	private JLabel lbl_ChiaCa_ShowMonth;
	private JLabel lbl_ChiaCa_ShowYear;
	private JPanel panel_RequestChangeShift;
	private JPanel panel_RequestLeave;
	private JPanel panel_3;
	private JButton btn_Chamconghangngay;
	private JLabel lbl_showtotal;
	private JPanel panel_6;
	private JLabel lblNewLabel_11;
	private JLabel lbl_ShowDate;
	private JLabel lbl_RQLeaveShowName;
	private JLabel lbl_RQLeaveShowDepart;
	private JLabel lblNewLabel_19;
	private JButton btn_RQLeaveSubmit;
	private JLabel lbl_RQLeaveShowreason;
	private JLabel lbl_RQLeaveShowFromDate;
	private JLabel lbl_RQLeaveShowtoDate;
	private JComboBox ccb_RQLeaveShowAction;
	private JComboBox ccb_RQLeaveShowHR;
	private JLabel lbl_RQLeaveShowNoteShift;
	private JLabel lblNewLabel_25;
	private final JLabel lblNewLabel_27 = new JLabel("Log Out");
	private JLabel lblNewLabel_21;
	private JPanel panel_8;
	private JLabel lbl_RQLShowIDRQ;
	private JScrollPane scrollPane_3;
	private JTable table_ShowLich;
	private JDateChooser dateChooser_1;
	private JDateChooser dateChooser_2;
	private JPanel giua;
	private JRadioButton rdbtnNewRadioButton;
	private JRadioButton rdbtnNewRadioButton_1;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblNewLabel_31;
	private JLabel lblNewLabel_32;
	private JTabbedPane tabbedPane_1;
	private JPanel panel_CreateReport;
	private JPanel panel_DetailsAtdEmployee;
	private final ButtonGroup buttonGroup_report = new ButtonGroup();
	private JLabel lblNewLabel_36;
	private JButton btn_createReport;
	private JLabel lblNewLabel_35;
	private JLabel lblNewLabel_37;
	private JLabel lblNewLabel_38;
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private JPanel panel_17;
	private JPanel panel_18;
	private JLabel lblNewLabel_39;
	private JDateChooser dateChooser_7;
	private JLabel lblNewLabel_40;
	private JRadioButton rdbtnNewRadioButton_2;
	private JRadioButton rdbtnNewRadioButton_4;
	private JDateChooser dateChooser_8;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JPanel duoi;
	private JButton btn_ChiaCa;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_13;
	private JScrollPane scrollPane_2;
	private JTable table_ShowChangeShift;
	private JLabel lblNewLabel_43;
	private JTextField textField_searchchangSHIFT;
	private JLabel lblNewLabel_44;
	private JComboBox cbb_changeshift;
	private JButton btnNewButton;
	private JLabel lblNewLabel_45;
	private JLabel lblNewLabel_46;
	private JLabel lblNewLabel_47;
	private JLabel lblNewLabel_48;
	private JLabel lblNewLabel_49;
	private JLabel lblNewLabel_50;
	private JLabel lblNewLabel_51;
	private JLabel lblNewLabel_52;
	private JLabel lblNewLabel_53;
	private JLabel lblNewLabel_54;
	private JLabel lblNewLabel_56;
	private JLabel lblNewLabel_55;
	private JComboBox comboBox_1;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_59;
	private JLabel lblNewLabel_60;
	private Admin myInstance;
	private JLabel lblNewLabel_61;
	private JComboBox cbb_boxChangeShift;
	private JPanel panel_20;
	private JPanel panel_7;
	private JTextField textField_SearnameLeaverq;
	private JLabel lblNewLabel_30;
	private JComboBox cbb_SearchLeaveRq;
	private JLabel lblNewLabel_62;
	private JComboBox cbb_boxleave;
	private JScrollPane scrollPane_4;
	private JTable table_LeaveRequest;
	private JLabel lblNewLabel_29;
	private JButton btn_searchLeaverq;
	private JScrollPane scrollPane_1;
	private JTable table_ShowRQShift;
	private JPanel panel_giua;
	private JComboBox cbb_report_showmonth;
	private JPanel panel_tren;
	private JScrollPane scrollPane_5;
	private JTable table_reportbymonthly;
	private JPanel panel_12;
	private JPanel panel_14;
	private JPanel panel_19;
	private JLabel lblNewLabel_34;
	private JScrollPane scrollPane_6;
	private JTable table_Show_Details_atdEmp;
	private JTextField textField_name_reportbyemp;
	private JButton btn_findEmp;
	private JScrollPane scrollPane_7;
	private JTable table_searchEmp;
	private JLabel lblNewLabel_41;
	private JComboBox cbb_details_attd_emp;
	private JPanel panel_21;
	private JPanel panel_22;
	private JButton btn_export_report_monthly;
	private JPanel panel_23;
	private JPanel panel_24;
	private JLabel lblNewLabel_42;
	private JPanel panel_25;
	private JButton btn_export_attd_monthly;
	private JComboBox comboBox_2;
	private JScrollPane scrollPane_8;
	private JTable table_show_atdby_month;
	private JPanel panel_26;
	private JButton btn_export_atdance_emp;
	private JLabel lbl_FromHL;
	private JLabel lbl_ToHL;
	private JLabel lbl_FromoffHL;
	private JLabel lbl_ToOffHL;
	private JLabel lblNewLabel_57;
	private JLabel lbl_AL;
	private JLabel lblNewLabel_58;
	private JLabel lbl_UL;
	private JLabel lblNewLabel_63;
	private JLabel lbl_SL;
	private JPanel panel_16;
	private JLabel lblNewLabel_65;
	private JLabel lblNewLabel_66;
	private JLabel lblNewLabel_67;
	private JLabel lblNewLabel_68;
	private JLabel lblNewLabel_69;
	private JLabel lblNewLabel_70;
	private JLabel lblNewLabel_71;
	private JLabel lblNewLabel_72;
	private JLabel lblNewLabel_73;
	private JLabel lblNewLabel_74;
	private JLabel lblNewLabel_75;
	private JLabel lblNewLabel_76;
	private JButton btn_callhomeadmin;
	private JPanel panel_15;
	private JLabel lblNewLabel_5;
	private JTextField tf_ChiaCa_Team3;
	private JLabel lbl_EMChiaCa_team4;
	private JLabel lblNewLabel_6;
	private JTextField tf_ChiaCa_Team4;
	private JLabel lbl_EMChiaCa_team5;
	private JLabel lblNewLabel_7;
	private JTextField tf_ChiaCa_Team5;
	private JLabel lbl_EMChiaCa_team1;
	private JLabel lblNewLabel_1;
	private JTextField tf_ChiaCa_Team1;
	private JLabel lbl_EMChiaCa_team2;
	private JLabel lblNewLabel_4;
	private JTextField tf_ChiaCa_Team2;
	private JLabel lbl_EMChiaCa_team3;

	/**
	 * Launch the application.
	 */

	public Admin getMyInstance() {

		if (myInstance == null) {
			myInstance = new Admin();
		}
		return myInstance;
	}

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setSize(1366, 744);
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1350, 744);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new CardLayout(0, 0));
		ImageIcon logout = new ImageIcon(Admin.class.getResource("/Images/logout.png"), "logout");
		ImageIcon home = new ImageIcon(Admin.class.getResource("/Images/home1.png"), "home1");
		ImageIcon chiaca = new ImageIcon(Admin.class.getResource("/Images/chiaca.png"), "chiaca");
		ImageIcon request = new ImageIcon(Admin.class.getResource("/Images/request.png"), "request");
		ImageIcon back = new ImageIcon(Admin.class.getResource("/Images/back.png"), "back");
		ImageIcon report = new ImageIcon(Admin.class.getResource("/Images/report.png"), "report");
		ImageIcon loupe = new ImageIcon(Admin.class.getResource("/Images/loupe.png"), "loupe");
		ImageIcon check1 = new ImageIcon(Admin.class.getResource("/Images/check1.png"), "check1");
		ImageIcon export = new ImageIcon(Admin.class.getResource("/Images/export.png"), "export");
		ImageIcon edit = new ImageIcon(Admin.class.getResource("/Images/edit.png"), "edit");
		panel_trangchu = new JPanel();
		panel_trangchu.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_trangchu.setBackground(Color.WHITE);
		panel.add(panel_trangchu, "panel_trangchu");
		panel_trangchu.setLayout(new BorderLayout(0, 0));

		panel_4 = new JPanel();
		panel_4.setBorder(new CompoundBorder(
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)),
				new EmptyBorder(10, 0, 10, 0)));
		panel_4.setBackground(new Color(255, 255, 255));
		panel_trangchu.add(panel_4, BorderLayout.NORTH);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 85, 196, 0, 118, 105, 0, 101, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 38, 42, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		lblNewLabel_2 = new JLabel("Date:");
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_4.add(lblNewLabel_2, gbc_lblNewLabel_2);

		dateChooser = new JDateChooser();

		dateChooser.getCalendarButton().setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooser.gridx = 1;
		gbc_dateChooser.gridy = 0;
		dateChooser.setDate(new Date());
		panel_4.add(dateChooser, gbc_dateChooser);

		btn_SearchTrangChu = new JButton("", loupe);
		btn_SearchTrangChu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_showlichtheongayActionPerformed(e);
			}
		});

		GridBagConstraints gbc_btn_SearchTrangChu = new GridBagConstraints();
		gbc_btn_SearchTrangChu.insets = new Insets(0, 0, 5, 5);
		gbc_btn_SearchTrangChu.gridx = 2;
		gbc_btn_SearchTrangChu.gridy = 0;
		panel_4.add(btn_SearchTrangChu, gbc_btn_SearchTrangChu);

		JLabel lblNewLabel_8 = new JLabel("Search By Employee' Name:");
		lblNewLabel_8.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 1;
		panel_4.add(lblNewLabel_8, gbc_lblNewLabel_8);

		tf_searchName = new JTextField();
		tf_searchName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tf_searchNameActionPerformed(e);
			}
		});
		tf_searchName.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		tf_searchName.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_tf_searchName = new GridBagConstraints();
		gbc_tf_searchName.insets = new Insets(0, 0, 0, 5);
		gbc_tf_searchName.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_searchName.gridx = 1;
		gbc_tf_searchName.gridy = 1;
		panel_4.add(tf_searchName, gbc_tf_searchName);
		tf_searchName.setColumns(10);

		JLabel lblNewLabel_9 = new JLabel("Sort By Shift:");
		lblNewLabel_9.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_9.gridx = 3;
		gbc_lblNewLabel_9.gridy = 1;
		panel_4.add(lblNewLabel_9, gbc_lblNewLabel_9);

		comboBox_searchShiftTrangchur = new JComboBox();
		comboBox_searchShiftTrangchur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_searchShiftTrangchurActionPerformed(e);
			}
		});
		comboBox_searchShiftTrangchur.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_comboBox_searchShiftTrangchur = new GridBagConstraints();
		gbc_comboBox_searchShiftTrangchur.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_searchShiftTrangchur.fill = GridBagConstraints.BOTH;
		gbc_comboBox_searchShiftTrangchur.gridx = 4;
		gbc_comboBox_searchShiftTrangchur.gridy = 1;
		panel_4.add(comboBox_searchShiftTrangchur, gbc_comboBox_searchShiftTrangchur);
		addListShitf();
		panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_trangchu.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		scrollPane.setOpaque(true);
		scrollPane.setBackground(Color.WHITE);
		panel_5.add(scrollPane, BorderLayout.CENTER);

		table = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(204, 204, 204);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		TableCellRenderer rendererFromHeader = table.getTableHeader().getDefaultRenderer();
		JLabel headerLabel = (JLabel) rendererFromHeader;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		table.setRowHeight(table.getRowHeight() + 15);
		table.setShowGrid(true);
		table.setFont(new Font("SansSerif", Font.PLAIN, 14));
		Showattendancebyday(getdatenow());
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tableMousePressed(e);
			}
		});
		table.setBackground(Color.WHITE);

		table.setAutoCreateRowSorter(true);
		scrollPane.setViewportView(table);

		panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_5.add(panel_3, BorderLayout.SOUTH);
		panel_3.setLayout(new BorderLayout(0, 0));

		panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		panel_3.add(panel_6, BorderLayout.EAST);

		lblNewLabel_11 = new JLabel("Timekeeping for Date:");
		lblNewLabel_11.setFont(new Font("SansSerif", Font.BOLD, 15));
		panel_6.add(lblNewLabel_11);

		lbl_ShowDate = new JLabel("");
		lbl_ShowDate.setFont(new Font("SansSerif", Font.BOLD, 15));
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		var string = dateFormat.format(date);
		lbl_ShowDate.setText(string);
		panel_6.add(lbl_ShowDate);

		btn_Chamconghangngay = new JButton("", check1);
		panel_6.add(btn_Chamconghangngay);
		btn_Chamconghangngay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_ChamconghangngayActionPerformed(e);
			}
		});

		panel_arrangeshifts = new JPanel();
		panel_arrangeshifts.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_arrangeshifts.setBackground(Color.WHITE);
		panel.add(panel_arrangeshifts, "arrangeshifts");
		panel_arrangeshifts.setLayout(new BorderLayout(0, 0));

		JPanel tren = new JPanel();
		tren.setBorder(new CompoundBorder(new EmptyBorder(5, 28, 5, 40), new TitledBorder(null, "General Information",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		tren.setBackground(Color.WHITE);
		panel_arrangeshifts.add(tren, BorderLayout.NORTH);
		GridBagLayout gbl_tren = new GridBagLayout();
		gbl_tren.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gbl_tren.rowHeights = new int[] { 26, 38, 38, 26, 0 };
		gbl_tren.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_tren.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		tren.setLayout(gbl_tren);

		JLabel lblNewLabel_10 = new JLabel("Arrange Shift Work For Month");
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 1;
		tren.add(lblNewLabel_10, gbc_lblNewLabel_10);
		lblNewLabel_10.setFont(new Font("SansSerif", Font.BOLD, 18));

		lbl_ChiaCa_ShowMonth = new JLabel("");
		GridBagConstraints gbc_lbl_ChiaCa_ShowMonth = new GridBagConstraints();
		gbc_lbl_ChiaCa_ShowMonth.anchor = GridBagConstraints.WEST;
		gbc_lbl_ChiaCa_ShowMonth.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_ChiaCa_ShowMonth.gridx = 1;
		gbc_lbl_ChiaCa_ShowMonth.gridy = 1;
		tren.add(lbl_ChiaCa_ShowMonth, gbc_lbl_ChiaCa_ShowMonth);
		lbl_ChiaCa_ShowMonth.setFont(new Font("SansSerif", Font.BOLD, 18));

		JLabel lblNewLabel_12 = new JLabel("Year");
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 2;
		gbc_lblNewLabel_12.gridy = 1;
		tren.add(lblNewLabel_12, gbc_lblNewLabel_12);
		lblNewLabel_12.setFont(new Font("SansSerif", Font.BOLD, 18));

		lbl_ChiaCa_ShowYear = new JLabel("");
		GridBagConstraints gbc_lbl_ChiaCa_ShowYear = new GridBagConstraints();
		gbc_lbl_ChiaCa_ShowYear.anchor = GridBagConstraints.WEST;
		gbc_lbl_ChiaCa_ShowYear.insets = new Insets(0, 0, 5, 0);
		gbc_lbl_ChiaCa_ShowYear.gridx = 3;
		gbc_lbl_ChiaCa_ShowYear.gridy = 1;
		tren.add(lbl_ChiaCa_ShowYear, gbc_lbl_ChiaCa_ShowYear);
		lbl_ChiaCa_ShowYear.setFont(new Font("SansSerif", Font.BOLD, 18));

		JLabel lblNewLabel_3 = new JLabel("Total Employee in Operations team:");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		tren.add(lblNewLabel_3, gbc_lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("SansSerif", Font.BOLD, 18));

		lbl_showtotal = new JLabel("");
		GridBagConstraints gbc_lbl_showtotal = new GridBagConstraints();
		gbc_lbl_showtotal.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_showtotal.gridx = 1;
		gbc_lbl_showtotal.gridy = 2;
		tren.add(lbl_showtotal, gbc_lbl_showtotal);
		lbl_showtotal.setFont(new Font("SansSerif", Font.BOLD, 18));

		giua = new JPanel();
		giua.setBorder(new EmptyBorder(20, 30, 20, 30));
		giua.setBackground(Color.WHITE);
		panel_arrangeshifts.add(giua, BorderLayout.CENTER);
		GridBagLayout gbl_giua = new GridBagLayout();
		gbl_giua.columnWidths = new int[] { 134, 419, 65, 541, 0 };
		gbl_giua.rowHeights = new int[] { 0, 13, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_giua.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_giua.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		giua.setLayout(gbl_giua);

		panel_16 = new JPanel();
		panel_16.setBorder(new CompoundBorder(new TitledBorder(null, "Holiday Infomation", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(59, 59, 59)), new EmptyBorder(20, 20, 20, 20)));
		panel_16.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.gridheight = 15;
		gbc_panel_16.gridwidth = 2;
		gbc_panel_16.insets = new Insets(0, 0, 5, 5);
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.gridx = 0;
		gbc_panel_16.gridy = 0;
		giua.add(panel_16, gbc_panel_16);
		GridBagLayout gbl_panel_16 = new GridBagLayout();
		gbl_panel_16.columnWidths = new int[] { 128, 0, 0 };
		gbl_panel_16.rowHeights = new int[] { 0, 24, 0, 0, 68, 0, 0, 0, 0 };
		gbl_panel_16.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_16.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_16.setLayout(gbl_panel_16);

		rdbtnNewRadioButton = new JRadioButton("Non Holiday");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnNewRadioButton.gridx = 0;
		gbc_rdbtnNewRadioButton.gridy = 1;
		panel_16.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButtonActionPerformed(e);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton);
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton.setFont(new Font("SansSerif", Font.BOLD, 18));

		rdbtnNewRadioButton_1 = new JRadioButton("Holiday");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.WEST;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_1.gridx = 1;
		gbc_rdbtnNewRadioButton_1.gridy = 1;
		panel_16.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_1ActionPerformed(e);
			}
		});
		buttonGroup.add(rdbtnNewRadioButton_1);
		rdbtnNewRadioButton_1.setFont(new Font("SansSerif", Font.BOLD, 18));

		panel_17 = new JPanel();
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.gridwidth = 2;
		gbc_panel_17.insets = new Insets(0, 0, 5, 0);
		gbc_panel_17.gridx = 0;
		gbc_panel_17.gridy = 3;
		panel_16.add(panel_17, gbc_panel_17);
		panel_17.setBackground(Color.WHITE);
		GridBagLayout gbl_panel_17 = new GridBagLayout();
		gbl_panel_17.columnWidths = new int[] { 198, 242, 0 };
		gbl_panel_17.rowHeights = new int[] { 41, 36, 0 };
		gbl_panel_17.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_17.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_17.setLayout(gbl_panel_17);

		lblNewLabel_31 = new JLabel("Holiday Starts From Day:");
		GridBagConstraints gbc_lblNewLabel_31 = new GridBagConstraints();
		gbc_lblNewLabel_31.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_31.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_31.gridx = 0;
		gbc_lblNewLabel_31.gridy = 0;
		panel_17.add(lblNewLabel_31, gbc_lblNewLabel_31);
		lblNewLabel_31.setFont(new Font("SansSerif", Font.BOLD, 18));

		dateChooser_1 = new JDateChooser();
		dateChooser_1.getCalendarButton().setBackground(Color.WHITE);
		GridBagConstraints gbc_dateChooser_1 = new GridBagConstraints();
		gbc_dateChooser_1.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_1.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser_1.gridx = 1;
		gbc_dateChooser_1.gridy = 0;
		panel_17.add(dateChooser_1, gbc_dateChooser_1);
		dateChooser_1.getCalendarButton().setFont(new Font("SansSerif", Font.PLAIN, 18));

		lblNewLabel_32 = new JLabel("To Day:");
		GridBagConstraints gbc_lblNewLabel_32 = new GridBagConstraints();
		gbc_lblNewLabel_32.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_32.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_32.gridx = 0;
		gbc_lblNewLabel_32.gridy = 1;
		panel_17.add(lblNewLabel_32, gbc_lblNewLabel_32);
		lblNewLabel_32.setFont(new Font("SansSerif", Font.BOLD, 18));

		dateChooser_2 = new JDateChooser();
		GridBagConstraints gbc_dateChooser_2 = new GridBagConstraints();
		gbc_dateChooser_2.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_2.gridx = 1;
		gbc_dateChooser_2.gridy = 1;
		panel_17.add(dateChooser_2, gbc_dateChooser_2);
		dateChooser_2.getCalendarButton().setFont(new Font("SansSerif", Font.PLAIN, 18));

		rdbtnNewRadioButton_2 = new JRadioButton("No Has Compensatory Day");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnNewRadioButton_2.gridx = 0;
		gbc_rdbtnNewRadioButton_2.gridy = 5;
		panel_16.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_2ActionPerformed(e);
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_2);
		rdbtnNewRadioButton_2.setSelected(true);
		rdbtnNewRadioButton_2.setFont(new Font("SansSerif", Font.BOLD, 18));

		rdbtnNewRadioButton_4 = new JRadioButton("Compensatory Day");
		GridBagConstraints gbc_rdbtnNewRadioButton_4 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_4.insets = new Insets(0, 0, 5, 0);
		gbc_rdbtnNewRadioButton_4.gridx = 1;
		gbc_rdbtnNewRadioButton_4.gridy = 5;
		panel_16.add(rdbtnNewRadioButton_4, gbc_rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnNewRadioButton_4ActionPerformed(e);
			}
		});
		buttonGroup_1.add(rdbtnNewRadioButton_4);
		rdbtnNewRadioButton_4.setFont(new Font("SansSerif", Font.BOLD, 18));

		panel_18 = new JPanel();
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.gridwidth = 2;
		gbc_panel_18.gridx = 0;
		gbc_panel_18.gridy = 7;
		panel_16.add(panel_18, gbc_panel_18);
		panel_18.setBackground(Color.WHITE);
		GridBagLayout gbl_panel_18 = new GridBagLayout();
		gbl_panel_18.columnWidths = new int[] { 195, 241, 0 };
		gbl_panel_18.rowHeights = new int[] { 44, 37, 0 };
		gbl_panel_18.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_18.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_18.setLayout(gbl_panel_18);

		lblNewLabel_39 = new JLabel("Holiday Starts From Day:");
		lblNewLabel_39.setFont(new Font("SansSerif", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_39 = new GridBagConstraints();
		gbc_lblNewLabel_39.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_39.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_39.gridx = 0;
		gbc_lblNewLabel_39.gridy = 0;
		panel_18.add(lblNewLabel_39, gbc_lblNewLabel_39);

		dateChooser_7 = new JDateChooser();
		dateChooser_7.getCalendarButton().setFont(new Font("SansSerif", Font.PLAIN, 18));
		GridBagConstraints gbc_dateChooser_7 = new GridBagConstraints();
		gbc_dateChooser_7.insets = new Insets(0, 0, 5, 0);
		gbc_dateChooser_7.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_7.gridx = 1;
		gbc_dateChooser_7.gridy = 0;
		panel_18.add(dateChooser_7, gbc_dateChooser_7);

		lblNewLabel_40 = new JLabel("To Day:");
		lblNewLabel_40.setFont(new Font("SansSerif", Font.BOLD, 18));
		GridBagConstraints gbc_lblNewLabel_40 = new GridBagConstraints();
		gbc_lblNewLabel_40.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_40.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_40.gridx = 0;
		gbc_lblNewLabel_40.gridy = 1;
		panel_18.add(lblNewLabel_40, gbc_lblNewLabel_40);

		dateChooser_8 = new JDateChooser();
		dateChooser_8.getCalendarButton().setFont(new Font("SansSerif", Font.PLAIN, 18));
		GridBagConstraints gbc_dateChooser_8 = new GridBagConstraints();
		gbc_dateChooser_8.fill = GridBagConstraints.BOTH;
		gbc_dateChooser_8.gridx = 1;
		gbc_dateChooser_8.gridy = 1;
		panel_18.add(dateChooser_8, gbc_dateChooser_8);

		panel_15 = new JPanel();
		panel_15.setBorder(new CompoundBorder(new TitledBorder(null, "The Number Employee In Team ",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59)), new EmptyBorder(20, 20, 20, 20)));
		panel_15.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.insets = new Insets(0, 0, 5, 0);
		gbc_panel_15.gridheight = 15;
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.gridx = 3;
		gbc_panel_15.gridy = 0;
		giua.add(panel_15, gbc_panel_15);
		GridBagLayout gbl_panel_15 = new GridBagLayout();
		gbl_panel_15.columnWidths = new int[] { 29, 0, 71, 318, 0, 0 };
		gbl_panel_15.rowHeights = new int[] { 0, 0, 24, 0, 41, 0, 50, -3, 0, 0, 36, 0 };
		gbl_panel_15.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_15.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_15.setLayout(gbl_panel_15);

		lbl_EMChiaCa_team1 = new JLabel("");
		lbl_EMChiaCa_team1.setForeground(new Color(255, 51, 102));
		GridBagConstraints gbc_lbl_EMChiaCa_team1 = new GridBagConstraints();
		gbc_lbl_EMChiaCa_team1.anchor = GridBagConstraints.WEST;
		gbc_lbl_EMChiaCa_team1.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_EMChiaCa_team1.gridx = 3;
		gbc_lbl_EMChiaCa_team1.gridy = 1;
		panel_15.add(lbl_EMChiaCa_team1, gbc_lbl_EMChiaCa_team1);

		JLabel lblNewLabel_1 = new JLabel("Team 1:");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 2;
		panel_15.add(lblNewLabel_1, gbc_lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 18));

		tf_ChiaCa_Team1 = new JTextField();
		GridBagConstraints gbc_tf_ChiaCa_Team1 = new GridBagConstraints();
		gbc_tf_ChiaCa_Team1.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ChiaCa_Team1.insets = new Insets(0, 0, 5, 5);
		gbc_tf_ChiaCa_Team1.gridx = 3;
		gbc_tf_ChiaCa_Team1.gridy = 2;
		panel_15.add(tf_ChiaCa_Team1, gbc_tf_ChiaCa_Team1);
		tf_ChiaCa_Team1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		tf_ChiaCa_Team1.setFont(new Font("SansSerif", Font.PLAIN, 18));
		tf_ChiaCa_Team1.setColumns(10);

		lbl_EMChiaCa_team2 = new JLabel("");
		GridBagConstraints gbc_lbl_EMChiaCa_team2 = new GridBagConstraints();
		gbc_lbl_EMChiaCa_team2.anchor = GridBagConstraints.WEST;
		gbc_lbl_EMChiaCa_team2.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_EMChiaCa_team2.gridx = 3;
		gbc_lbl_EMChiaCa_team2.gridy = 3;
		panel_15.add(lbl_EMChiaCa_team2, gbc_lbl_EMChiaCa_team2);
		lbl_EMChiaCa_team2.setForeground(new Color(255, 51, 102));

		JLabel lblNewLabel_4 = new JLabel("Team 2:");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 2;
		gbc_lblNewLabel_4.gridy = 4;
		panel_15.add(lblNewLabel_4, gbc_lblNewLabel_4);
		lblNewLabel_4.setFont(new Font("SansSerif", Font.BOLD, 18));

		tf_ChiaCa_Team2 = new JTextField();
		tf_ChiaCa_Team2.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		GridBagConstraints gbc_tf_ChiaCa_Team2 = new GridBagConstraints();
		gbc_tf_ChiaCa_Team2.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ChiaCa_Team2.insets = new Insets(0, 0, 5, 5);
		gbc_tf_ChiaCa_Team2.gridx = 3;
		gbc_tf_ChiaCa_Team2.gridy = 4;
		panel_15.add(tf_ChiaCa_Team2, gbc_tf_ChiaCa_Team2);
		tf_ChiaCa_Team2.setFont(new Font("SansSerif", Font.PLAIN, 18));
		tf_ChiaCa_Team2.setColumns(10);

		lbl_EMChiaCa_team3 = new JLabel("");
		GridBagConstraints gbc_lbl_EMChiaCa_team3 = new GridBagConstraints();
		gbc_lbl_EMChiaCa_team3.anchor = GridBagConstraints.WEST;
		gbc_lbl_EMChiaCa_team3.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_EMChiaCa_team3.gridx = 3;
		gbc_lbl_EMChiaCa_team3.gridy = 5;
		panel_15.add(lbl_EMChiaCa_team3, gbc_lbl_EMChiaCa_team3);
		lbl_EMChiaCa_team3.setForeground(new Color(255, 51, 102));

		lblNewLabel_5 = new JLabel("Team 3:");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 2;
		gbc_lblNewLabel_5.gridy = 6;
		panel_15.add(lblNewLabel_5, gbc_lblNewLabel_5);
		lblNewLabel_5.setFont(new Font("SansSerif", Font.BOLD, 18));

		tf_ChiaCa_Team3 = new JTextField();
		tf_ChiaCa_Team3.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		GridBagConstraints gbc_tf_ChiaCa_Team3 = new GridBagConstraints();
		gbc_tf_ChiaCa_Team3.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ChiaCa_Team3.insets = new Insets(0, 0, 5, 5);
		gbc_tf_ChiaCa_Team3.gridx = 3;
		gbc_tf_ChiaCa_Team3.gridy = 6;
		panel_15.add(tf_ChiaCa_Team3, gbc_tf_ChiaCa_Team3);
		tf_ChiaCa_Team3.setFont(new Font("SansSerif", Font.PLAIN, 18));
		tf_ChiaCa_Team3.setColumns(10);

		lbl_EMChiaCa_team4 = new JLabel("");
		GridBagConstraints gbc_lbl_EMChiaCa_team4 = new GridBagConstraints();
		gbc_lbl_EMChiaCa_team4.anchor = GridBagConstraints.WEST;
		gbc_lbl_EMChiaCa_team4.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_EMChiaCa_team4.gridx = 3;
		gbc_lbl_EMChiaCa_team4.gridy = 7;
		panel_15.add(lbl_EMChiaCa_team4, gbc_lbl_EMChiaCa_team4);
		lbl_EMChiaCa_team4.setForeground(new Color(255, 51, 102));

		JLabel lblNewLabel_6 = new JLabel("Team 4:");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 2;
		gbc_lblNewLabel_6.gridy = 8;
		panel_15.add(lblNewLabel_6, gbc_lblNewLabel_6);
		lblNewLabel_6.setFont(new Font("SansSerif", Font.BOLD, 18));

		tf_ChiaCa_Team4 = new JTextField();
		tf_ChiaCa_Team4.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		GridBagConstraints gbc_tf_ChiaCa_Team4 = new GridBagConstraints();
		gbc_tf_ChiaCa_Team4.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ChiaCa_Team4.insets = new Insets(0, 0, 5, 5);
		gbc_tf_ChiaCa_Team4.gridx = 3;
		gbc_tf_ChiaCa_Team4.gridy = 8;
		panel_15.add(tf_ChiaCa_Team4, gbc_tf_ChiaCa_Team4);
		tf_ChiaCa_Team4.setFont(new Font("SansSerif", Font.PLAIN, 18));
		tf_ChiaCa_Team4.setColumns(10);

		lbl_EMChiaCa_team5 = new JLabel("");
		GridBagConstraints gbc_lbl_EMChiaCa_team5 = new GridBagConstraints();
		gbc_lbl_EMChiaCa_team5.anchor = GridBagConstraints.WEST;
		gbc_lbl_EMChiaCa_team5.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_EMChiaCa_team5.gridx = 3;
		gbc_lbl_EMChiaCa_team5.gridy = 9;
		panel_15.add(lbl_EMChiaCa_team5, gbc_lbl_EMChiaCa_team5);
		lbl_EMChiaCa_team5.setForeground(new Color(255, 51, 102));

		lblNewLabel_7 = new JLabel("Team 5:");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_7.gridx = 2;
		gbc_lblNewLabel_7.gridy = 10;
		panel_15.add(lblNewLabel_7, gbc_lblNewLabel_7);
		lblNewLabel_7.setFont(new Font("SansSerif", Font.BOLD, 18));

		tf_ChiaCa_Team5 = new JTextField();
		tf_ChiaCa_Team5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		GridBagConstraints gbc_tf_ChiaCa_Team5 = new GridBagConstraints();
		gbc_tf_ChiaCa_Team5.insets = new Insets(0, 0, 0, 5);
		gbc_tf_ChiaCa_Team5.fill = GridBagConstraints.HORIZONTAL;
		gbc_tf_ChiaCa_Team5.gridx = 3;
		gbc_tf_ChiaCa_Team5.gridy = 10;
		panel_15.add(tf_ChiaCa_Team5, gbc_tf_ChiaCa_Team5);
		tf_ChiaCa_Team5.setFont(new Font("SansSerif", Font.PLAIN, 18));
		tf_ChiaCa_Team5.setColumns(10);

		duoi = new JPanel();
		duoi.setBackground(Color.WHITE);
		duoi.setBorder(new CompoundBorder(new EmptyBorder(5, 28, 5, 40),
				new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(59, 59, 59))));
		panel_arrangeshifts.add(duoi, BorderLayout.SOUTH);
		GridBagLayout gbl_duoi = new GridBagLayout();
		gbl_duoi.columnWidths = new int[] { 121, 0 };
		gbl_duoi.rowHeights = new int[] { 0, 32, 0 };
		gbl_duoi.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_duoi.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		duoi.setLayout(gbl_duoi);

		btn_ChiaCa = new JButton("Arrange Shift", check1);
		btn_ChiaCa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_ChiaCaActionPerformed(e);
			}
		});
		btn_ChiaCa.setForeground(new Color(0, 153, 204));
		btn_ChiaCa.setFont(new Font("SansSerif", Font.BOLD, 15));
		GridBagConstraints gbc_btn_ChiaCa = new GridBagConstraints();
		gbc_btn_ChiaCa.fill = GridBagConstraints.VERTICAL;
		gbc_btn_ChiaCa.gridheight = 2;
		gbc_btn_ChiaCa.anchor = GridBagConstraints.WEST;
		gbc_btn_ChiaCa.gridx = 0;
		gbc_btn_ChiaCa.gridy = 0;
		duoi.add(btn_ChiaCa, gbc_btn_ChiaCa);

		panel_Request = new JPanel();
		panel_Request.setBackground(Color.WHITE);
		panel_Request.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_Request, "Request");
		panel_Request.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("SansSerif", Font.PLAIN, 15));
		tabbedPane.setBackground(Color.WHITE);
		panel_Request.add(tabbedPane, BorderLayout.CENTER);

		panel_RequestChangeShift = new JPanel();
		panel_RequestChangeShift.setBackground(Color.WHITE);
		tabbedPane.addTab("Change Shift", null, panel_RequestChangeShift, null);
		tabbedPane.setEnabledAt(0, true);
		panel_RequestChangeShift.setLayout(new BorderLayout(0, 0));

		panel_9 = new JPanel();
		panel_RequestChangeShift.add(panel_9, BorderLayout.CENTER);
		panel_9.setLayout(new BorderLayout(0, 0));

		panel_11 = new JPanel();
		panel_11.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_11.setBackground(Color.WHITE);
		panel_9.add(panel_11, BorderLayout.NORTH);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[] { 89, 185, 0, 130, 0, 0 };
		gbl_panel_11.rowHeights = new int[] { 0, 35, 0 };
		gbl_panel_11.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_11.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_11.setLayout(gbl_panel_11);

		lblNewLabel_43 = new JLabel("Search By Name:");
		lblNewLabel_43.setFont(new Font("SansSerif", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_43 = new GridBagConstraints();
		gbc_lblNewLabel_43.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_43.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_43.gridx = 0;
		gbc_lblNewLabel_43.gridy = 0;
		panel_11.add(lblNewLabel_43, gbc_lblNewLabel_43);

		textField_searchchangSHIFT = new JTextField();
		textField_searchchangSHIFT.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		textField_searchchangSHIFT.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_textField_searchchangSHIFT = new GridBagConstraints();
		gbc_textField_searchchangSHIFT.insets = new Insets(0, 0, 5, 5);
		gbc_textField_searchchangSHIFT.fill = GridBagConstraints.BOTH;
		gbc_textField_searchchangSHIFT.gridx = 1;
		gbc_textField_searchchangSHIFT.gridy = 0;
		panel_11.add(textField_searchchangSHIFT, gbc_textField_searchchangSHIFT);
		textField_searchchangSHIFT.setColumns(10);

		btnNewButton = new JButton("", loupe);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButtonActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.fill = GridBagConstraints.VERTICAL;
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 0;
		panel_11.add(btnNewButton, gbc_btnNewButton);

		lblNewLabel_44 = new JLabel("Sort By Status:");
		lblNewLabel_44.setFont(new Font("SansSerif", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_44 = new GridBagConstraints();
		gbc_lblNewLabel_44.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_44.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_44.gridx = 0;
		gbc_lblNewLabel_44.gridy = 1;
		panel_11.add(lblNewLabel_44, gbc_lblNewLabel_44);

		cbb_changeshift = new JComboBox();
		cbb_changeshift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbb_changeshiftActionPerformed(e);
			}
		});
		cbb_changeshift.setModel(new DefaultComboBoxModel(
				new String[] { "All Status", "Waiting Admin Confirm", "Confirmed", "Refuse" }));
		cbb_changeshift.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_cbb_changeshift = new GridBagConstraints();
		gbc_cbb_changeshift.insets = new Insets(0, 0, 0, 5);
		gbc_cbb_changeshift.fill = GridBagConstraints.BOTH;
		gbc_cbb_changeshift.gridx = 1;
		gbc_cbb_changeshift.gridy = 1;
		panel_11.add(cbb_changeshift, gbc_cbb_changeshift);

		lblNewLabel_61 = new JLabel("On Box:");
		lblNewLabel_61.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_61 = new GridBagConstraints();
		gbc_lblNewLabel_61.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_61.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_61.gridx = 2;
		gbc_lblNewLabel_61.gridy = 1;
		panel_11.add(lblNewLabel_61, gbc_lblNewLabel_61);

		cbb_boxChangeShift = new JComboBox();
		cbb_boxChangeShift.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbb_boxChangeShiftActionPerformed(e);
			}
		});
		cbb_boxChangeShift.setFont(new Font("SansSerif", Font.PLAIN, 17));
		cbb_boxChangeShift.setModel(new DefaultComboBoxModel(new String[] { "My Case", "Admin's Box Case" }));
		GridBagConstraints gbc_cbb_boxChangeShift = new GridBagConstraints();
		gbc_cbb_boxChangeShift.insets = new Insets(0, 0, 0, 5);
		gbc_cbb_boxChangeShift.fill = GridBagConstraints.BOTH;
		gbc_cbb_boxChangeShift.gridx = 3;
		gbc_cbb_boxChangeShift.gridy = 1;
		panel_11.add(cbb_boxChangeShift, gbc_cbb_boxChangeShift);

		panel_13 = new JPanel();
		panel_13.setBackground(Color.WHITE);
		panel_13.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.add(panel_13, BorderLayout.CENTER);
		panel_13.setLayout(new BorderLayout(0, 0));

		scrollPane_2 = new JScrollPane();
		panel_13.add(scrollPane_2, BorderLayout.CENTER);

		table_ShowChangeShift = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(204, 204, 204);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		TableCellRenderer rendererFromHeader1 = table_ShowChangeShift.getTableHeader().getDefaultRenderer();
		JLabel headerLabel1 = (JLabel) rendererFromHeader1;
		headerLabel1.setHorizontalAlignment(JLabel.CENTER);
		table_ShowChangeShift.setRowHeight(table_ShowChangeShift.getRowHeight() + 15);
		table_ShowChangeShift.setShowGrid(true);
		table_ShowChangeShift.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table_ShowChangeShiftMousePressed(e);
			}
		});
		table_ShowChangeShift.setFont(new Font("SansSerif", Font.PLAIN, 14));
		table_ShowChangeShift.setBackground(Color.WHITE);
		table_ShowChangeShift.setAutoCreateRowSorter(true);
		scrollPane_2.setViewportView(table_ShowChangeShift);

		panel_10 = new JPanel();
		panel_10.setBackground(Color.WHITE);
		panel_10.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_RequestChangeShift.add(panel_10, BorderLayout.EAST);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[] { 55, 0, 0 };
		gbl_panel_10.rowHeights = new int[] { 63, 0, 0, 16, 0, 0, 0, 0, 0, 0, 42, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_10.columnWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel_10.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_10.setLayout(gbl_panel_10);

		lblNewLabel_47 = new JLabel("REQUEST CHANGE SHIFT INFO");
		lblNewLabel_47.setFont(new Font("SansSerif", Font.BOLD, 20));
		GridBagConstraints gbc_lblNewLabel_47 = new GridBagConstraints();
		gbc_lblNewLabel_47.gridwidth = 2;
		gbc_lblNewLabel_47.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_47.gridx = 0;
		gbc_lblNewLabel_47.gridy = 1;
		panel_10.add(lblNewLabel_47, gbc_lblNewLabel_47);

		lblNewLabel_59 = new JLabel("Request No:");
		lblNewLabel_59.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_59 = new GridBagConstraints();
		gbc_lblNewLabel_59.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_59.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_59.gridx = 0;
		gbc_lblNewLabel_59.gridy = 2;
		panel_10.add(lblNewLabel_59, gbc_lblNewLabel_59);

		lblNewLabel_60 = new JLabel("");
		lblNewLabel_60.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_60 = new GridBagConstraints();
		gbc_lblNewLabel_60.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_60.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_60.gridx = 1;
		gbc_lblNewLabel_60.gridy = 2;
		panel_10.add(lblNewLabel_60, gbc_lblNewLabel_60);

		lblNewLabel_45 = new JLabel("From Employee:");
		lblNewLabel_45.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_45 = new GridBagConstraints();
		gbc_lblNewLabel_45.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_45.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblNewLabel_45.gridx = 0;
		gbc_lblNewLabel_45.gridy = 3;
		panel_10.add(lblNewLabel_45, gbc_lblNewLabel_45);

		lblNewLabel_46 = new JLabel("");
		lblNewLabel_46.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_46 = new GridBagConstraints();
		gbc_lblNewLabel_46.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_46.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_46.gridx = 1;
		gbc_lblNewLabel_46.gridy = 3;
		panel_10.add(lblNewLabel_46, gbc_lblNewLabel_46);

		lblNewLabel_48 = new JLabel("From Shift:");
		lblNewLabel_48.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_48 = new GridBagConstraints();
		gbc_lblNewLabel_48.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_48.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_48.gridx = 0;
		gbc_lblNewLabel_48.gridy = 4;
		panel_10.add(lblNewLabel_48, gbc_lblNewLabel_48);

		lblNewLabel_49 = new JLabel("");
		lblNewLabel_49.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_49 = new GridBagConstraints();
		gbc_lblNewLabel_49.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_49.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_49.gridx = 1;
		gbc_lblNewLabel_49.gridy = 4;
		panel_10.add(lblNewLabel_49, gbc_lblNewLabel_49);

		lblNewLabel_50 = new JLabel("To Employee:");
		lblNewLabel_50.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_50 = new GridBagConstraints();
		gbc_lblNewLabel_50.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_50.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_50.gridx = 0;
		gbc_lblNewLabel_50.gridy = 5;
		panel_10.add(lblNewLabel_50, gbc_lblNewLabel_50);

		lblNewLabel_51 = new JLabel("");
		lblNewLabel_51.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_51 = new GridBagConstraints();
		gbc_lblNewLabel_51.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_51.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_51.gridx = 1;
		gbc_lblNewLabel_51.gridy = 5;
		panel_10.add(lblNewLabel_51, gbc_lblNewLabel_51);

		lblNewLabel_52 = new JLabel("To Shift:");
		lblNewLabel_52.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_52 = new GridBagConstraints();
		gbc_lblNewLabel_52.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_52.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_52.gridx = 0;
		gbc_lblNewLabel_52.gridy = 6;
		panel_10.add(lblNewLabel_52, gbc_lblNewLabel_52);

		lblNewLabel_53 = new JLabel("");
		lblNewLabel_53.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_53 = new GridBagConstraints();
		gbc_lblNewLabel_53.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_53.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_53.gridx = 1;
		gbc_lblNewLabel_53.gridy = 6;
		panel_10.add(lblNewLabel_53, gbc_lblNewLabel_53);

		lblNewLabel_75 = new JLabel("Expiry Date:");
		lblNewLabel_75.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_75 = new GridBagConstraints();
		gbc_lblNewLabel_75.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_75.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_75.gridx = 0;
		gbc_lblNewLabel_75.gridy = 7;
		panel_10.add(lblNewLabel_75, gbc_lblNewLabel_75);

		lblNewLabel_76 = new JLabel("");
		lblNewLabel_76.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_76 = new GridBagConstraints();
		gbc_lblNewLabel_76.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_76.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_76.gridx = 1;
		gbc_lblNewLabel_76.gridy = 7;
		panel_10.add(lblNewLabel_76, gbc_lblNewLabel_76);

		lblNewLabel_54 = new JLabel("Date Change:");
		lblNewLabel_54.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_54 = new GridBagConstraints();
		gbc_lblNewLabel_54.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_54.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_54.gridx = 0;
		gbc_lblNewLabel_54.gridy = 8;
		panel_10.add(lblNewLabel_54, gbc_lblNewLabel_54);

		lblNewLabel_56 = new JLabel("");
		lblNewLabel_56.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_56 = new GridBagConstraints();
		gbc_lblNewLabel_56.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_56.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_56.gridx = 1;
		gbc_lblNewLabel_56.gridy = 8;
		panel_10.add(lblNewLabel_56, gbc_lblNewLabel_56);

		lblNewLabel_55 = new JLabel("Status:");
		lblNewLabel_55.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_55 = new GridBagConstraints();
		gbc_lblNewLabel_55.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_55.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_55.gridx = 0;
		gbc_lblNewLabel_55.gridy = 9;
		panel_10.add(lblNewLabel_55, gbc_lblNewLabel_55);

		comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_1ActionPerformed(e);
			}
		});
		comboBox_1.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 1;
		gbc_comboBox_1.gridy = 9;
		panel_10.add(comboBox_1, gbc_comboBox_1);

		btnNewButton_1 = new JButton("Submit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_1ActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.gridwidth = 2;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 10;
		panel_10.add(btnNewButton_1, gbc_btnNewButton_1);

		scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.gridheight = 9;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 11;
		panel_10.add(scrollPane_1, gbc_scrollPane_1);

		table_ShowRQShift = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(204, 204, 204);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		TableCellRenderer rendererFromHeader2 = table_ShowRQShift.getTableHeader().getDefaultRenderer();
		JLabel headerLabel2 = (JLabel) rendererFromHeader2;
		headerLabel.setHorizontalAlignment(JLabel.CENTER);
		table_ShowRQShift.setRowHeight(table_ShowRQShift.getRowHeight() + 15);
		table_ShowRQShift.setShowGrid(true);
		table_ShowRQShift.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table_ShowRQShiftMousePressed(e);
			}
		});
		table_ShowRQShift.setFont(new Font("SansSerif", Font.PLAIN, 17));
		table_ShowRQShift.setAutoCreateRowSorter(true);
		scrollPane_1.setViewportView(table_ShowRQShift);

		panel_RequestLeave = new JPanel();
		panel_RequestLeave.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_RequestLeave.setFont(new Font("SansSerif", Font.PLAIN, 15));
		panel_RequestLeave.setBackground(Color.WHITE);
		tabbedPane.addTab("Leave Request", null, panel_RequestLeave, null);
		panel_RequestLeave.setLayout(new BorderLayout(0, 0));

		panel_8 = new JPanel();
		panel_8.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_RequestLeave.add(panel_8, BorderLayout.EAST);
		panel_8.setBackground(Color.WHITE);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[] { 30, 91, 30 };
		gbl_panel_8.rowHeights = new int[] { 30, 35, 30, 0, 30, 30, 30, 30, 30, 30, 30, 0 };
		gbl_panel_8.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panel_8.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_8.setLayout(gbl_panel_8);

		JLabel lblNewLabel_14 = new JLabel("Leave Request Information");
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.gridwidth = 2;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 1;
		panel_8.add(lblNewLabel_14, gbc_lblNewLabel_14);
		lblNewLabel_14.setFont(new Font("SansSerif", Font.BOLD, 24));

		JLabel lblNewLabel_28 = new JLabel("ID Request:");
		lblNewLabel_28.setFont(new Font("SansSerif", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_28 = new GridBagConstraints();
		gbc_lblNewLabel_28.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_28.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_28.gridx = 0;
		gbc_lblNewLabel_28.gridy = 2;
		panel_8.add(lblNewLabel_28, gbc_lblNewLabel_28);

		lbl_RQLShowIDRQ = new JLabel("");
		lbl_RQLShowIDRQ.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_lbl_RQLShowIDRQ = new GridBagConstraints();
		gbc_lbl_RQLShowIDRQ.anchor = GridBagConstraints.WEST;
		gbc_lbl_RQLShowIDRQ.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_RQLShowIDRQ.gridx = 1;
		gbc_lbl_RQLShowIDRQ.gridy = 2;
		panel_8.add(lbl_RQLShowIDRQ, gbc_lbl_RQLShowIDRQ);

		lblNewLabel_73 = new JLabel("Expiry Date:");
		lblNewLabel_73.setFont(new Font("SansSerif", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_73 = new GridBagConstraints();
		gbc_lblNewLabel_73.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_73.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_73.gridx = 0;
		gbc_lblNewLabel_73.gridy = 3;
		panel_8.add(lblNewLabel_73, gbc_lblNewLabel_73);

		lblNewLabel_74 = new JLabel("");
		lblNewLabel_74.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_lblNewLabel_74 = new GridBagConstraints();
		gbc_lblNewLabel_74.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_74.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_74.gridx = 1;
		gbc_lblNewLabel_74.gridy = 3;
		panel_8.add(lblNewLabel_74, gbc_lblNewLabel_74);

		JLabel lblNewLabel_13 = new JLabel("Request Name:");
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 4;
		panel_8.add(lblNewLabel_13, gbc_lblNewLabel_13);
		lblNewLabel_13.setFont(new Font("SansSerif", Font.BOLD, 15));

		lbl_RQLeaveShowName = new JLabel("");
		GridBagConstraints gbc_lbl_RQLeaveShowName = new GridBagConstraints();
		gbc_lbl_RQLeaveShowName.anchor = GridBagConstraints.WEST;
		gbc_lbl_RQLeaveShowName.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_RQLeaveShowName.gridx = 1;
		gbc_lbl_RQLeaveShowName.gridy = 4;
		panel_8.add(lbl_RQLeaveShowName, gbc_lbl_RQLeaveShowName);
		lbl_RQLeaveShowName.setFont(new Font("SansSerif", Font.PLAIN, 15));

		JLabel lblNewLabel_15 = new JLabel("Department:");
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 0;
		gbc_lblNewLabel_15.gridy = 5;
		panel_8.add(lblNewLabel_15, gbc_lblNewLabel_15);
		lblNewLabel_15.setFont(new Font("SansSerif", Font.BOLD, 15));

		lbl_RQLeaveShowDepart = new JLabel("");
		GridBagConstraints gbc_lbl_RQLeaveShowDepart = new GridBagConstraints();
		gbc_lbl_RQLeaveShowDepart.anchor = GridBagConstraints.WEST;
		gbc_lbl_RQLeaveShowDepart.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_RQLeaveShowDepart.gridx = 1;
		gbc_lbl_RQLeaveShowDepart.gridy = 5;
		panel_8.add(lbl_RQLeaveShowDepart, gbc_lbl_RQLeaveShowDepart);
		lbl_RQLeaveShowDepart.setFont(new Font("SansSerif", Font.PLAIN, 15));

		JLabel lblNewLabel_17 = new JLabel("Reason Leave:");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_17.gridx = 0;
		gbc_lblNewLabel_17.gridy = 6;
		panel_8.add(lblNewLabel_17, gbc_lblNewLabel_17);
		lblNewLabel_17.setFont(new Font("SansSerif", Font.BOLD, 15));

		lbl_RQLeaveShowreason = new JLabel("");
		GridBagConstraints gbc_lbl_RQLeaveShowreason = new GridBagConstraints();
		gbc_lbl_RQLeaveShowreason.anchor = GridBagConstraints.WEST;
		gbc_lbl_RQLeaveShowreason.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_RQLeaveShowreason.gridx = 1;
		gbc_lbl_RQLeaveShowreason.gridy = 6;
		panel_8.add(lbl_RQLeaveShowreason, gbc_lbl_RQLeaveShowreason);
		lbl_RQLeaveShowreason.setFont(new Font("SansSerif", Font.PLAIN, 15));

		JLabel lblNewLabel_18 = new JLabel("From The Date:");
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_18.gridx = 0;
		gbc_lblNewLabel_18.gridy = 7;
		panel_8.add(lblNewLabel_18, gbc_lblNewLabel_18);
		lblNewLabel_18.setFont(new Font("SansSerif", Font.BOLD, 15));

		lbl_RQLeaveShowFromDate = new JLabel("");
		GridBagConstraints gbc_lbl_RQLeaveShowFromDate = new GridBagConstraints();
		gbc_lbl_RQLeaveShowFromDate.anchor = GridBagConstraints.WEST;
		gbc_lbl_RQLeaveShowFromDate.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_RQLeaveShowFromDate.gridx = 1;
		gbc_lbl_RQLeaveShowFromDate.gridy = 7;
		panel_8.add(lbl_RQLeaveShowFromDate, gbc_lbl_RQLeaveShowFromDate);
		lbl_RQLeaveShowFromDate.setFont(new Font("SansSerif", Font.PLAIN, 15));

		lblNewLabel_19 = new JLabel("To The Date:");
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_19.gridx = 0;
		gbc_lblNewLabel_19.gridy = 8;
		panel_8.add(lblNewLabel_19, gbc_lblNewLabel_19);
		lblNewLabel_19.setFont(new Font("SansSerif", Font.BOLD, 15));

		lbl_RQLeaveShowtoDate = new JLabel("");
		GridBagConstraints gbc_lbl_RQLeaveShowtoDate = new GridBagConstraints();
		gbc_lbl_RQLeaveShowtoDate.anchor = GridBagConstraints.WEST;
		gbc_lbl_RQLeaveShowtoDate.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_RQLeaveShowtoDate.gridx = 1;
		gbc_lbl_RQLeaveShowtoDate.gridy = 8;
		panel_8.add(lbl_RQLeaveShowtoDate, gbc_lbl_RQLeaveShowtoDate);
		lbl_RQLeaveShowtoDate.setFont(new Font("SansSerif", Font.PLAIN, 15));

		JLabel lblNewLabel_16 = new JLabel("Note Shift Will leave:");
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 0;
		gbc_lblNewLabel_16.gridy = 9;
		panel_8.add(lblNewLabel_16, gbc_lblNewLabel_16);
		lblNewLabel_16.setFont(new Font("SansSerif", Font.BOLD, 15));

		lbl_RQLeaveShowNoteShift = new JLabel("");
		GridBagConstraints gbc_lbl_RQLeaveShowNoteShift = new GridBagConstraints();
		gbc_lbl_RQLeaveShowNoteShift.anchor = GridBagConstraints.WEST;
		gbc_lbl_RQLeaveShowNoteShift.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_RQLeaveShowNoteShift.gridx = 1;
		gbc_lbl_RQLeaveShowNoteShift.gridy = 9;
		panel_8.add(lbl_RQLeaveShowNoteShift, gbc_lbl_RQLeaveShowNoteShift);
		lbl_RQLeaveShowNoteShift.setFont(new Font("SansSerif", Font.PLAIN, 15));

		JLabel lblNewLabel_20 = new JLabel("Your Action:");
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_20.gridx = 0;
		gbc_lblNewLabel_20.gridy = 10;
		panel_8.add(lblNewLabel_20, gbc_lblNewLabel_20);
		lblNewLabel_20.setFont(new Font("SansSerif", Font.BOLD, 15));

		ccb_RQLeaveShowAction = new JComboBox();
		ccb_RQLeaveShowAction.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_ccb_RQLeaveShowAction = new GridBagConstraints();
		gbc_ccb_RQLeaveShowAction.fill = GridBagConstraints.HORIZONTAL;
		gbc_ccb_RQLeaveShowAction.insets = new Insets(0, 0, 5, 5);
		gbc_ccb_RQLeaveShowAction.gridx = 1;
		gbc_ccb_RQLeaveShowAction.gridy = 10;
		panel_8.add(ccb_RQLeaveShowAction, gbc_ccb_RQLeaveShowAction);

		lblNewLabel_21 = new JLabel("Escalate:");
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_21.gridx = 0;
		gbc_lblNewLabel_21.gridy = 11;
		panel_8.add(lblNewLabel_21, gbc_lblNewLabel_21);
		lblNewLabel_21.setFont(new Font("SansSerif", Font.BOLD, 15));

		ccb_RQLeaveShowHR = new JComboBox();
		ccb_RQLeaveShowHR.setFont(new Font("SansSerif", Font.PLAIN, 15));
		GridBagConstraints gbc_ccb_RQLeaveShowHR = new GridBagConstraints();
		gbc_ccb_RQLeaveShowHR.fill = GridBagConstraints.HORIZONTAL;
		gbc_ccb_RQLeaveShowHR.insets = new Insets(0, 0, 5, 5);
		gbc_ccb_RQLeaveShowHR.gridx = 1;
		gbc_ccb_RQLeaveShowHR.gridy = 11;
		panel_8.add(ccb_RQLeaveShowHR, gbc_ccb_RQLeaveShowHR);

		btn_RQLeaveSubmit = new JButton("Submit");
		btn_RQLeaveSubmit.setFont(new Font("SansSerif", Font.BOLD, 15));
		GridBagConstraints gbc_btn_RQLeaveSubmit = new GridBagConstraints();
		gbc_btn_RQLeaveSubmit.insets = new Insets(0, 0, 5, 5);
		gbc_btn_RQLeaveSubmit.fill = GridBagConstraints.BOTH;
		gbc_btn_RQLeaveSubmit.gridx = 1;
		gbc_btn_RQLeaveSubmit.gridy = 12;
		panel_8.add(btn_RQLeaveSubmit, gbc_btn_RQLeaveSubmit);

		scrollPane_3 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_3 = new GridBagConstraints();
		gbc_scrollPane_3.gridheight = 10;
		gbc_scrollPane_3.gridwidth = 3;
		gbc_scrollPane_3.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_3.gridx = 0;
		gbc_scrollPane_3.gridy = 13;
		panel_8.add(scrollPane_3, gbc_scrollPane_3);

		table_ShowLich = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(204, 204, 204);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		TableCellRenderer rendererFromHeader3 = table_ShowLich.getTableHeader().getDefaultRenderer();
		JLabel headerLabel3 = (JLabel) rendererFromHeader3;
		headerLabel3.setHorizontalAlignment(JLabel.CENTER);
		table_ShowLich.setRowHeight(table_ShowLich.getRowHeight() + 15);
		table_ShowLich.setShowGrid(true);
		table_ShowLich.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table_ShowLichMousePressed(e);
			}
		});
		table_ShowLich.setAlignmentY(Component.BOTTOM_ALIGNMENT);
		table_ShowLich.setShowHorizontalLines(true);
		table_ShowLich.setFont(new Font("SansSerif", Font.PLAIN, 15));
		table_ShowLich.setAutoCreateRowSorter(true);
		scrollPane_3.setViewportView(table_ShowLich);

		panel_20 = new JPanel();
		panel_RequestLeave.add(panel_20, BorderLayout.CENTER);
		panel_20.setLayout(new BorderLayout(0, 0));

		panel_7 = new JPanel();
		panel_7.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBackground(Color.WHITE);
		panel_20.add(panel_7, BorderLayout.NORTH);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[] { 150, 120, 46, 133, 0 };
		gbl_panel_7.rowHeights = new int[] { 0, 43, 0 };
		gbl_panel_7.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_7.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_7.setLayout(gbl_panel_7);

		lblNewLabel_29 = new JLabel("Search By Name");
		lblNewLabel_29.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_29 = new GridBagConstraints();
		gbc_lblNewLabel_29.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_29.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_29.gridx = 0;
		gbc_lblNewLabel_29.gridy = 0;
		panel_7.add(lblNewLabel_29, gbc_lblNewLabel_29);

		textField_SearnameLeaverq = new JTextField();
		textField_SearnameLeaverq.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		textField_SearnameLeaverq.setFont(new Font("SansSerif", Font.PLAIN, 17));
		textField_SearnameLeaverq.setColumns(10);
		GridBagConstraints gbc_textField_SearnameLeaverq = new GridBagConstraints();
		gbc_textField_SearnameLeaverq.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_SearnameLeaverq.insets = new Insets(0, 0, 5, 5);
		gbc_textField_SearnameLeaverq.gridx = 1;
		gbc_textField_SearnameLeaverq.gridy = 0;
		panel_7.add(textField_SearnameLeaverq, gbc_textField_SearnameLeaverq);

		btn_searchLeaverq = new JButton("", loupe);
		btn_searchLeaverq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_searchLeaverqActionPerformed(e);
			}
		});
		btn_searchLeaverq.setBackground(Color.WHITE);
		GridBagConstraints gbc_btn_searchLeaverq = new GridBagConstraints();
		gbc_btn_searchLeaverq.fill = GridBagConstraints.VERTICAL;
		gbc_btn_searchLeaverq.insets = new Insets(0, 0, 5, 5);
		gbc_btn_searchLeaverq.gridx = 2;
		gbc_btn_searchLeaverq.gridy = 0;
		panel_7.add(btn_searchLeaverq, gbc_btn_searchLeaverq);

		lblNewLabel_30 = new JLabel("Sort By Status");
		lblNewLabel_30.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_30 = new GridBagConstraints();
		gbc_lblNewLabel_30.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_30.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_30.gridx = 0;
		gbc_lblNewLabel_30.gridy = 1;
		panel_7.add(lblNewLabel_30, gbc_lblNewLabel_30);

		cbb_SearchLeaveRq = new JComboBox();
		cbb_SearchLeaveRq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbb_SearchLeaveRqActionPerformed(e);
			}
		});
		cbb_SearchLeaveRq.setModel(new DefaultComboBoxModel(
				new String[] { "All Status", "Cancel", "Complete", "New Request", "Waiting Update Calendar" }));
		cbb_SearchLeaveRq.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_cbb_SearchLeaveRq = new GridBagConstraints();
		gbc_cbb_SearchLeaveRq.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbb_SearchLeaveRq.insets = new Insets(0, 0, 0, 5);
		gbc_cbb_SearchLeaveRq.gridx = 1;
		gbc_cbb_SearchLeaveRq.gridy = 1;
		panel_7.add(cbb_SearchLeaveRq, gbc_cbb_SearchLeaveRq);

		lblNewLabel_62 = new JLabel("On Box");
		lblNewLabel_62.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_62 = new GridBagConstraints();
		gbc_lblNewLabel_62.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_62.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_62.gridx = 2;
		gbc_lblNewLabel_62.gridy = 1;
		panel_7.add(lblNewLabel_62, gbc_lblNewLabel_62);

		cbb_boxleave = new JComboBox();
		cbb_boxleave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbb_boxleaveActionPerformed(e);
			}
		});
		cbb_boxleave.setModel(new DefaultComboBoxModel(new String[] { "My Case", "All Case" }));
		cbb_boxleave.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_cbb_boxleave = new GridBagConstraints();
		gbc_cbb_boxleave.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbb_boxleave.gridx = 3;
		gbc_cbb_boxleave.gridy = 1;
		panel_7.add(cbb_boxleave, gbc_cbb_boxleave);

		scrollPane_4 = new JScrollPane();
		panel_20.add(scrollPane_4, BorderLayout.CENTER);

		table_LeaveRequest = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(204, 204, 204);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		TableCellRenderer rendererFromHeader4 = table_LeaveRequest.getTableHeader().getDefaultRenderer();
		JLabel headerLabel4 = (JLabel) rendererFromHeader4;
		headerLabel4.setHorizontalAlignment(JLabel.CENTER);
		table_LeaveRequest.setRowHeight(table_LeaveRequest.getRowHeight() + 15);
		table_LeaveRequest.setShowGrid(true);
		table_LeaveRequest.setAutoCreateRowSorter(true);
		table_LeaveRequest.setFont(new Font("SansSerif", Font.PLAIN, 14));
		table_LeaveRequest.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table_LeaveRequestMousePressed(e);
			}
		});
		table_LeaveRequest.setBackground(Color.WHITE);
		scrollPane_4.setViewportView(table_LeaveRequest);
		btn_RQLeaveSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_RQLeaveSubmitActionPerformed(e);
			}
		});
		ccb_RQLeaveShowAction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ccb_RQLeaveShowActionActionPerformed(e);
			}
		});

		panel_reportbymonth = new JPanel();
		panel_reportbymonth.setBackground(Color.WHITE);
		panel_reportbymonth.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(panel_reportbymonth, "reportbymonth");
		panel_reportbymonth.setLayout(new BorderLayout(0, 0));

		tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setFont(new Font("SansSerif", Font.PLAIN, 15));
		tabbedPane_1.setBackground(Color.WHITE);
		panel_reportbymonth.add(tabbedPane_1, BorderLayout.CENTER);

		panel_CreateReport = new JPanel();
		panel_CreateReport.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Create Attendance Monthly Report", null, panel_CreateReport, null);
		panel_CreateReport.setLayout(new BorderLayout(0, 0));

		panel_giua = new JPanel();
		panel_giua.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_giua.setBackground(Color.WHITE);
		panel_CreateReport.add(panel_giua, BorderLayout.CENTER);
		panel_giua.setLayout(new BorderLayout(0, 0));

		scrollPane_5 = new JScrollPane();
		panel_giua.add(scrollPane_5, BorderLayout.CENTER);

		table_reportbymonthly = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(204, 204, 204);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		TableCellRenderer rendererFromHeader5 = table_reportbymonthly.getTableHeader().getDefaultRenderer();
		JLabel headerLabel5 = (JLabel) rendererFromHeader5;
		headerLabel5.setHorizontalAlignment(JLabel.CENTER);
		table_reportbymonthly.setRowHeight(table_reportbymonthly.getRowHeight() + 15);
		table_reportbymonthly.setShowGrid(true);
		table_reportbymonthly.setAutoCreateRowSorter(true);
		scrollPane_5.setViewportView(table_reportbymonthly);

		panel_tren = new JPanel();
		panel_tren.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_tren.setBackground(Color.WHITE);
		panel_CreateReport.add(panel_tren, BorderLayout.NORTH);
		GridBagLayout gbl_panel_tren = new GridBagLayout();
		gbl_panel_tren.columnWidths = new int[] { 336, 120, 107, 101, 0, 0, 0 };
		gbl_panel_tren.rowHeights = new int[] { 0, 0, 0, 20, 0 };
		gbl_panel_tren.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_tren.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_tren.setLayout(gbl_panel_tren);

		JLabel lblNewLabel_33 = new JLabel("Create Attendance Monthly Report For Month:");
		GridBagConstraints gbc_lblNewLabel_33 = new GridBagConstraints();
		gbc_lblNewLabel_33.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_33.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_33.gridx = 0;
		gbc_lblNewLabel_33.gridy = 0;
		panel_tren.add(lblNewLabel_33, gbc_lblNewLabel_33);
		lblNewLabel_33.setFont(new Font("SansSerif", Font.BOLD, 17));

		cbb_report_showmonth = new JComboBox();
		cbb_report_showmonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbb_report_showmonthActionPerformed(e);
			}
		});
		cbb_report_showmonth.setFont(new Font("SansSerif", Font.BOLD, 17));
		cbb_report_showmonth.setModel(new DefaultComboBoxModel(
				new String[] { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" }));
		GridBagConstraints gbc_cbb_report_showmonth = new GridBagConstraints();
		gbc_cbb_report_showmonth.anchor = GridBagConstraints.WEST;
		gbc_cbb_report_showmonth.insets = new Insets(0, 0, 5, 5);
		gbc_cbb_report_showmonth.gridx = 1;
		gbc_cbb_report_showmonth.gridy = 0;
		panel_tren.add(cbb_report_showmonth, gbc_cbb_report_showmonth);

		lblNewLabel_35 = new JLabel("Holiday Start From Date:");
		GridBagConstraints gbc_lblNewLabel_35 = new GridBagConstraints();
		gbc_lblNewLabel_35.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_35.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_35.gridx = 0;
		gbc_lblNewLabel_35.gridy = 1;
		panel_tren.add(lblNewLabel_35, gbc_lblNewLabel_35);
		lblNewLabel_35.setFont(new Font("SansSerif", Font.BOLD, 15));

		lbl_FromHL = new JLabel("");
		lbl_FromHL.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_FromHL = new GridBagConstraints();
		gbc_lbl_FromHL.anchor = GridBagConstraints.WEST;
		gbc_lbl_FromHL.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_FromHL.gridx = 1;
		gbc_lbl_FromHL.gridy = 1;
		panel_tren.add(lbl_FromHL, gbc_lbl_FromHL);

		lblNewLabel_36 = new JLabel("To Date:");
		GridBagConstraints gbc_lblNewLabel_36 = new GridBagConstraints();
		gbc_lblNewLabel_36.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_36.gridx = 2;
		gbc_lblNewLabel_36.gridy = 1;
		panel_tren.add(lblNewLabel_36, gbc_lblNewLabel_36);
		lblNewLabel_36.setFont(new Font("SansSerif", Font.BOLD, 15));

		lbl_ToHL = new JLabel("");
		lbl_ToHL.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_ToHL = new GridBagConstraints();
		gbc_lbl_ToHL.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_ToHL.gridx = 3;
		gbc_lbl_ToHL.gridy = 1;
		panel_tren.add(lbl_ToHL, gbc_lbl_ToHL);

		lblNewLabel_37 = new JLabel("Compensatory Day Off Starts From");
		GridBagConstraints gbc_lblNewLabel_37 = new GridBagConstraints();
		gbc_lblNewLabel_37.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_37.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_37.gridx = 0;
		gbc_lblNewLabel_37.gridy = 2;
		panel_tren.add(lblNewLabel_37, gbc_lblNewLabel_37);
		lblNewLabel_37.setFont(new Font("SansSerif", Font.BOLD, 15));

		lbl_FromoffHL = new JLabel("");
		lbl_FromoffHL.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_FromoffHL = new GridBagConstraints();
		gbc_lbl_FromoffHL.anchor = GridBagConstraints.WEST;
		gbc_lbl_FromoffHL.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_FromoffHL.gridx = 1;
		gbc_lbl_FromoffHL.gridy = 2;
		panel_tren.add(lbl_FromoffHL, gbc_lbl_FromoffHL);

		lblNewLabel_38 = new JLabel("To Date:");
		GridBagConstraints gbc_lblNewLabel_38 = new GridBagConstraints();
		gbc_lblNewLabel_38.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_38.gridx = 2;
		gbc_lblNewLabel_38.gridy = 2;
		panel_tren.add(lblNewLabel_38, gbc_lblNewLabel_38);
		lblNewLabel_38.setFont(new Font("SansSerif", Font.BOLD, 15));

		lbl_ToOffHL = new JLabel("");
		lbl_ToOffHL.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_ToOffHL = new GridBagConstraints();
		gbc_lbl_ToOffHL.insets = new Insets(0, 0, 5, 5);
		gbc_lbl_ToOffHL.gridx = 3;
		gbc_lbl_ToOffHL.gridy = 2;
		panel_tren.add(lbl_ToOffHL, gbc_lbl_ToOffHL);

		btn_createReport = new JButton("Generate Report");
		GridBagConstraints gbc_btn_createReport = new GridBagConstraints();
		gbc_btn_createReport.anchor = GridBagConstraints.WEST;
		gbc_btn_createReport.insets = new Insets(0, 0, 0, 5);
		gbc_btn_createReport.gridx = 0;
		gbc_btn_createReport.gridy = 3;
		panel_tren.add(btn_createReport, gbc_btn_createReport);
		btn_createReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_createReportActionPerformed(e);
			}
		});
		btn_createReport.setFont(new Font("SansSerif", Font.BOLD, 15));

		panel_22 = new JPanel();
		panel_22.setBackground(Color.WHITE);
		panel_CreateReport.add(panel_22, BorderLayout.SOUTH);
		panel_22.setLayout(new BorderLayout(0, 0));

		btn_export_report_monthly = new JButton("", export);
		btn_export_report_monthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_export_report_monthlyActionPerformed(e);
			}
		});
		btn_export_report_monthly.setBackground(Color.WHITE);
		panel_22.add(btn_export_report_monthly, BorderLayout.EAST);

		panel_DetailsAtdEmployee = new JPanel();
		panel_DetailsAtdEmployee.setBackground(Color.WHITE);
		tabbedPane_1.addTab("Details  Attendance Employee", null, panel_DetailsAtdEmployee, null);
		panel_DetailsAtdEmployee.setLayout(new BorderLayout(0, 0));

		panel_14 = new JPanel();
		panel_14.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_14.setBackground(Color.WHITE);
		panel_DetailsAtdEmployee.add(panel_14, BorderLayout.WEST);
		GridBagLayout gbl_panel_14 = new GridBagLayout();
		gbl_panel_14.columnWidths = new int[] { 0, 134, 78, 0 };
		gbl_panel_14.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_14.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_14.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		panel_14.setLayout(gbl_panel_14);

		lblNewLabel_34 = new JLabel("Search Employee By Name:");
		lblNewLabel_34.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_34 = new GridBagConstraints();
		gbc_lblNewLabel_34.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_34.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_34.gridx = 0;
		gbc_lblNewLabel_34.gridy = 1;
		panel_14.add(lblNewLabel_34, gbc_lblNewLabel_34);

		textField_name_reportbyemp = new JTextField();
		textField_name_reportbyemp.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		textField_name_reportbyemp.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_textField_name_reportbyemp = new GridBagConstraints();
		gbc_textField_name_reportbyemp.gridwidth = 2;
		gbc_textField_name_reportbyemp.insets = new Insets(0, 0, 5, 5);
		gbc_textField_name_reportbyemp.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_name_reportbyemp.gridx = 0;
		gbc_textField_name_reportbyemp.gridy = 2;
		panel_14.add(textField_name_reportbyemp, gbc_textField_name_reportbyemp);
		textField_name_reportbyemp.setColumns(10);

		btn_findEmp = new JButton("", loupe);
		btn_findEmp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_findEmpActionPerformed(e);
			}
		});
		GridBagConstraints gbc_btn_findEmp = new GridBagConstraints();
		gbc_btn_findEmp.anchor = GridBagConstraints.WEST;
		gbc_btn_findEmp.insets = new Insets(0, 0, 5, 0);
		gbc_btn_findEmp.gridx = 2;
		gbc_btn_findEmp.gridy = 2;
		panel_14.add(btn_findEmp, gbc_btn_findEmp);

		scrollPane_7 = new JScrollPane();
		scrollPane_7.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_scrollPane_7 = new GridBagConstraints();
		gbc_scrollPane_7.gridheight = 11;
		gbc_scrollPane_7.gridwidth = 3;
		gbc_scrollPane_7.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_7.gridx = 0;
		gbc_scrollPane_7.gridy = 3;
		panel_14.add(scrollPane_7, gbc_scrollPane_7);

		table_searchEmp = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(204, 204, 204);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		TableCellRenderer rendererFromHeader6 = table_searchEmp.getTableHeader().getDefaultRenderer();
		JLabel headerLabel6 = (JLabel) rendererFromHeader6;
		headerLabel4.setHorizontalAlignment(JLabel.CENTER);
		table_searchEmp.setRowHeight(table_searchEmp.getRowHeight() + 15);
		table_searchEmp.setShowGrid(true);
		table_searchEmp.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table_searchEmpMousePressed(e);
			}
		});
		table_searchEmp.setFont(new Font("SansSerif", Font.PLAIN, 17));
		table_searchEmp.setAutoCreateRowSorter(true);
		scrollPane_7.setViewportView(table_searchEmp);

		panel_19 = new JPanel();
		panel_19.setBackground(Color.WHITE);
		panel_19.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_DetailsAtdEmployee.add(panel_19, BorderLayout.CENTER);
		panel_19.setLayout(new BorderLayout(0, 0));

		scrollPane_6 = new JScrollPane();
		panel_19.add(scrollPane_6, BorderLayout.CENTER);

		table_Show_Details_atdEmp = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(204, 204, 204);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		TableCellRenderer rendererFromHeader7 = table_Show_Details_atdEmp.getTableHeader().getDefaultRenderer();
		JLabel headerLabel7 = (JLabel) rendererFromHeader7;
		headerLabel4.setHorizontalAlignment(JLabel.CENTER);
		table_Show_Details_atdEmp.setRowHeight(table_Show_Details_atdEmp.getRowHeight() + 15);
		table_Show_Details_atdEmp.setShowGrid(true);
		table_Show_Details_atdEmp.setBackground(Color.WHITE);
		table_Show_Details_atdEmp.setFont(new Font("SansSerif", Font.PLAIN, 14));
		table_Show_Details_atdEmp.setAutoCreateRowSorter(true);
		scrollPane_6.setViewportView(table_Show_Details_atdEmp);

		panel_21 = new JPanel();
		panel_21.setBackground(Color.WHITE);
		panel_19.add(panel_21, BorderLayout.NORTH);
		GridBagLayout gbl_panel_21 = new GridBagLayout();
		gbl_panel_21.columnWidths = new int[] { 75, 90, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_21.rowHeights = new int[] { 33, 0, 0 };
		gbl_panel_21.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel_21.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_21.setLayout(gbl_panel_21);

		lblNewLabel_41 = new JLabel("Month:");
		GridBagConstraints gbc_lblNewLabel_41 = new GridBagConstraints();
		gbc_lblNewLabel_41.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_41.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_41.gridx = 0;
		gbc_lblNewLabel_41.gridy = 0;
		panel_21.add(lblNewLabel_41, gbc_lblNewLabel_41);
		lblNewLabel_41.setFont(new Font("SansSerif", Font.BOLD, 17));

		cbb_details_attd_emp = new JComboBox();
		cbb_details_attd_emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cbb_details_attd_empActionPerformed(e);
			}
		});
		cbb_details_attd_emp.setModel(new DefaultComboBoxModel(
				new String[] { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" }));
		cbb_details_attd_emp.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_cbb_details_attd_emp = new GridBagConstraints();
		gbc_cbb_details_attd_emp.insets = new Insets(0, 0, 5, 5);
		gbc_cbb_details_attd_emp.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbb_details_attd_emp.gridx = 1;
		gbc_cbb_details_attd_emp.gridy = 0;
		panel_21.add(cbb_details_attd_emp, gbc_cbb_details_attd_emp);

		lblNewLabel_57 = new JLabel("Total Days To Apply For AL:");
		lblNewLabel_57.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_57 = new GridBagConstraints();
		gbc_lblNewLabel_57.gridwidth = 2;
		gbc_lblNewLabel_57.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_57.gridx = 0;
		gbc_lblNewLabel_57.gridy = 1;
		panel_21.add(lblNewLabel_57, gbc_lblNewLabel_57);

		lbl_AL = new JLabel("");
		lbl_AL.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_AL = new GridBagConstraints();
		gbc_lbl_AL.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_AL.gridx = 2;
		gbc_lbl_AL.gridy = 1;
		panel_21.add(lbl_AL, gbc_lbl_AL);

		lblNewLabel_58 = new JLabel("UL:");
		lblNewLabel_58.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_58 = new GridBagConstraints();
		gbc_lblNewLabel_58.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_58.gridx = 3;
		gbc_lblNewLabel_58.gridy = 1;
		panel_21.add(lblNewLabel_58, gbc_lblNewLabel_58);

		lbl_UL = new JLabel("");
		lbl_UL.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_UL = new GridBagConstraints();
		gbc_lbl_UL.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_UL.gridx = 4;
		gbc_lbl_UL.gridy = 1;
		panel_21.add(lbl_UL, gbc_lbl_UL);

		lblNewLabel_63 = new JLabel("SL:");
		lblNewLabel_63.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_63 = new GridBagConstraints();
		gbc_lblNewLabel_63.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_63.gridx = 5;
		gbc_lblNewLabel_63.gridy = 1;
		panel_21.add(lblNewLabel_63, gbc_lblNewLabel_63);

		lbl_SL = new JLabel("");
		lbl_SL.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lbl_SL = new GridBagConstraints();
		gbc_lbl_SL.insets = new Insets(0, 0, 0, 5);
		gbc_lbl_SL.gridx = 6;
		gbc_lbl_SL.gridy = 1;
		panel_21.add(lbl_SL, gbc_lbl_SL);

		panel_26 = new JPanel();
		panel_26.setBackground(Color.WHITE);
		panel_26.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_DetailsAtdEmployee.add(panel_26, BorderLayout.SOUTH);
		panel_26.setLayout(new BorderLayout(0, 0));

		btn_export_atdance_emp = new JButton("", export);
		btn_export_atdance_emp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_export_atdance_empActionPerformed(e);
			}
		});
		btn_export_atdance_emp.setBackground(Color.WHITE);
		panel_26.add(btn_export_atdance_emp, BorderLayout.EAST);

		panel_12 = new JPanel();
		tabbedPane_1.addTab("Show Attendance Record", null, panel_12, null);
		panel_12.setLayout(new BorderLayout(0, 0));

		panel_23 = new JPanel();
		panel_23.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_23.setBackground(Color.WHITE);
		panel_12.add(panel_23, BorderLayout.NORTH);
		GridBagLayout gbl_panel_23 = new GridBagLayout();
		gbl_panel_23.columnWidths = new int[] { 55, 126, 0, 0, 0 };
		gbl_panel_23.rowHeights = new int[] { 0, 0, 0, 32, 0 };
		gbl_panel_23.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_23.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_23.setLayout(gbl_panel_23);

		lblNewLabel_42 = new JLabel("Show Attendance Record For Month");
		lblNewLabel_42.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_42 = new GridBagConstraints();
		gbc_lblNewLabel_42.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_42.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_42.gridx = 0;
		gbc_lblNewLabel_42.gridy = 0;
		panel_23.add(lblNewLabel_42, gbc_lblNewLabel_42);

		comboBox_2 = new JComboBox();
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox_2ActionPerformed(e);
			}
		});
		comboBox_2.setModel(new DefaultComboBoxModel(
				new String[] { "Jan", "Feb", "Mar", "Apr", "May", "June", "July", "Aug", "Sep", "Oct", "Nov", "Dec" }));
		comboBox_2.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_2.anchor = GridBagConstraints.NORTHWEST;
		gbc_comboBox_2.gridx = 1;
		gbc_comboBox_2.gridy = 0;
		panel_23.add(comboBox_2, gbc_comboBox_2);

		lblNewLabel_65 = new JLabel("Holiday From:");
		lblNewLabel_65.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_65 = new GridBagConstraints();
		gbc_lblNewLabel_65.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_65.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_65.gridx = 0;
		gbc_lblNewLabel_65.gridy = 1;
		panel_23.add(lblNewLabel_65, gbc_lblNewLabel_65);

		lblNewLabel_66 = new JLabel("");
		lblNewLabel_66.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_66 = new GridBagConstraints();
		gbc_lblNewLabel_66.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_66.gridx = 1;
		gbc_lblNewLabel_66.gridy = 1;
		panel_23.add(lblNewLabel_66, gbc_lblNewLabel_66);

		lblNewLabel_67 = new JLabel("To Date:");
		lblNewLabel_67.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_67 = new GridBagConstraints();
		gbc_lblNewLabel_67.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_67.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_67.gridx = 2;
		gbc_lblNewLabel_67.gridy = 1;
		panel_23.add(lblNewLabel_67, gbc_lblNewLabel_67);

		lblNewLabel_68 = new JLabel("");
		lblNewLabel_68.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_68 = new GridBagConstraints();
		gbc_lblNewLabel_68.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_68.gridx = 3;
		gbc_lblNewLabel_68.gridy = 1;
		panel_23.add(lblNewLabel_68, gbc_lblNewLabel_68);

		lblNewLabel_69 = new JLabel("Compensatory Day Off Starts From:");
		lblNewLabel_69.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_69 = new GridBagConstraints();
		gbc_lblNewLabel_69.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_69.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_69.gridx = 0;
		gbc_lblNewLabel_69.gridy = 2;
		panel_23.add(lblNewLabel_69, gbc_lblNewLabel_69);

		lblNewLabel_70 = new JLabel("");
		lblNewLabel_70.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_70 = new GridBagConstraints();
		gbc_lblNewLabel_70.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_70.gridx = 1;
		gbc_lblNewLabel_70.gridy = 2;
		panel_23.add(lblNewLabel_70, gbc_lblNewLabel_70);

		lblNewLabel_71 = new JLabel("To Date:");
		lblNewLabel_71.setFont(new Font("SansSerif", Font.BOLD, 17));
		GridBagConstraints gbc_lblNewLabel_71 = new GridBagConstraints();
		gbc_lblNewLabel_71.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_71.gridx = 2;
		gbc_lblNewLabel_71.gridy = 2;
		panel_23.add(lblNewLabel_71, gbc_lblNewLabel_71);

		lblNewLabel_72 = new JLabel("");
		lblNewLabel_72.setFont(new Font("SansSerif", Font.PLAIN, 17));
		GridBagConstraints gbc_lblNewLabel_72 = new GridBagConstraints();
		gbc_lblNewLabel_72.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_72.gridx = 3;
		gbc_lblNewLabel_72.gridy = 2;
		panel_23.add(lblNewLabel_72, gbc_lblNewLabel_72);

		panel_24 = new JPanel();
		panel_24.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_24.setBackground(Color.WHITE);
		panel_12.add(panel_24, BorderLayout.SOUTH);
		panel_24.setLayout(new BorderLayout(0, 0));

		btn_export_attd_monthly = new JButton("", export);
		btn_export_attd_monthly.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_export_attd_monthlyActionPerformed(e);
			}
		});
		btn_export_attd_monthly.setBackground(Color.WHITE);
		panel_24.add(btn_export_attd_monthly, BorderLayout.EAST);

		panel_25 = new JPanel();
		panel_25.setBackground(Color.WHITE);
		panel_25.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_12.add(panel_25, BorderLayout.CENTER);
		panel_25.setLayout(new BorderLayout(0, 0));

		scrollPane_8 = new JScrollPane();
		scrollPane_8.setBackground(Color.WHITE);
		panel_25.add(scrollPane_8, BorderLayout.CENTER);

		table_show_atdby_month = new JTable() {
			public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
				Component returnComp = super.prepareRenderer(renderer, row, column);
				Color alternateColor = new Color(204, 204, 204);
				Color whiteColor = Color.WHITE;
				if (!returnComp.getBackground().equals(getSelectionBackground())) {
					Color bg = (row % 2 == 0 ? alternateColor : whiteColor);
					returnComp.setBackground(bg);
					bg = null;
				}
				return returnComp;
			}
		};
		TableCellRenderer rendererFromHeader8 = table_show_atdby_month.getTableHeader().getDefaultRenderer();
		JLabel headerLabel8 = (JLabel) rendererFromHeader8;
		headerLabel4.setHorizontalAlignment(JLabel.CENTER);
		table_show_atdby_month.setRowHeight(table_show_atdby_month.getRowHeight() + 15);
		table_show_atdby_month.setShowGrid(true);
		table_show_atdby_month.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				table_show_atdby_monthMousePressed(e);
			}
		});
		table_show_atdby_month.setBackground(Color.WHITE);
		table_show_atdby_month.setAutoCreateRowSorter(true);
		scrollPane_8.setViewportView(table_show_atdby_month);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBackground(Color.WHITE);
		contentPane.add(panel_1, BorderLayout.WEST);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 90, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		btn_callhomeadmin = new JButton("", home);
		btn_callhomeadmin.setBorder(null);
		btn_callhomeadmin.setBackground(Color.WHITE);
		btn_callhomeadmin.setToolTipText("Admin Ofiicer home");
		btn_callhomeadmin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_callhomeadminActionPerformed(e);
			}

		});
		GridBagConstraints gbc_btn_callhomeadmin = new GridBagConstraints();
		gbc_btn_callhomeadmin.insets = new Insets(0, 0, 5, 0);
		gbc_btn_callhomeadmin.gridx = 0;
		gbc_btn_callhomeadmin.gridy = 2;
		panel_1.add(btn_callhomeadmin, gbc_btn_callhomeadmin);

		btn_callxepca = new JButton("", chiaca);
		btn_callxepca.setBorder(null);
		btn_callxepca.setBackground(Color.WHITE);
		btn_callxepca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_callxepcaActionPerformed(e);
			}
		});

		JLabel lblNewLabel_22 = new JLabel("Admin Home");
		lblNewLabel_22.setFont(new Font("SansSerif", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
		gbc_lblNewLabel_22.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_22.gridx = 0;
		gbc_lblNewLabel_22.gridy = 3;
		panel_1.add(lblNewLabel_22, gbc_lblNewLabel_22);
		btn_callxepca.setToolTipText("Arrange Shifts");
		GridBagConstraints gbc_btn_callxepca = new GridBagConstraints();
		gbc_btn_callxepca.insets = new Insets(0, 0, 5, 0);
		gbc_btn_callxepca.gridx = 0;
		gbc_btn_callxepca.gridy = 4;
		panel_1.add(btn_callxepca, gbc_btn_callxepca);

		btn_callrequest = new JButton("", request);
		btn_callrequest.setBorder(null);
		btn_callrequest.setBackground(Color.WHITE);
		btn_callrequest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_callrequestActionPerformed(e);
			}
		});

		JLabel lblNewLabel_23 = new JLabel("Arrange Shift");
		lblNewLabel_23.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
		gbc_lblNewLabel_23.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_23.gridx = 0;
		gbc_lblNewLabel_23.gridy = 5;
		panel_1.add(lblNewLabel_23, gbc_lblNewLabel_23);
		btn_callrequest.setToolTipText("Request from Employyee");
		GridBagConstraints gbc_btn_callrequest = new GridBagConstraints();
		gbc_btn_callrequest.insets = new Insets(0, 0, 5, 0);
		gbc_btn_callrequest.gridx = 0;
		gbc_btn_callrequest.gridy = 6;
		panel_1.add(btn_callrequest, gbc_btn_callrequest);

		btn_back = new JButton("", back);
		btn_back.setBorder(null);
		btn_back.setBackground(Color.WHITE);
		btn_back.setToolTipText("Back To Choose Type Pages");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_backActionPerformed(e);
			}
		});

		btn_report = new JButton("", report);
		btn_report.setBorder(null);
		btn_report.setBackground(Color.WHITE);
		btn_report.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_reportActionPerformed(e);
			}
		});

		lblNewLabel_25 = new JLabel("Request");
		lblNewLabel_25.setFont(new Font("Dialog", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_25 = new GridBagConstraints();
		gbc_lblNewLabel_25.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_25.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_25.gridx = 0;
		gbc_lblNewLabel_25.gridy = 7;
		panel_1.add(lblNewLabel_25, gbc_lblNewLabel_25);
		btn_report.setToolTipText("Report");
		GridBagConstraints gbc_btn_report = new GridBagConstraints();
		gbc_btn_report.insets = new Insets(0, 0, 5, 0);
		gbc_btn_report.gridx = 0;
		gbc_btn_report.gridy = 8;
		panel_1.add(btn_report, gbc_btn_report);

		JLabel lblNewLabel_24 = new JLabel("Report");
		lblNewLabel_24.setFont(new Font("SansSerif", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
		gbc_lblNewLabel_24.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_24.gridx = 0;
		gbc_lblNewLabel_24.gridy = 9;
		panel_1.add(lblNewLabel_24, gbc_lblNewLabel_24);
		GridBagConstraints gbc_btn_back = new GridBagConstraints();
		gbc_btn_back.insets = new Insets(0, 0, 5, 0);
		gbc_btn_back.gridx = 0;
		gbc_btn_back.gridy = 10;
		panel_1.add(btn_back, gbc_btn_back);

		btn_logout = new JButton("", logout);
		btn_logout.setBorder(null);
		btn_logout.setBackground(Color.WHITE);
		btn_logout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btn_logoutActionPerformed(e);
			}
		});

		JLabel lblNewLabel_26 = new JLabel("Back");
		lblNewLabel_26.setFont(new Font("SansSerif", Font.BOLD, 13));
		GridBagConstraints gbc_lblNewLabel_26 = new GridBagConstraints();
		gbc_lblNewLabel_26.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_26.gridx = 0;
		gbc_lblNewLabel_26.gridy = 11;
		panel_1.add(lblNewLabel_26, gbc_lblNewLabel_26);
		btn_logout.setToolTipText("Log Out");
		GridBagConstraints gbc_btn_logout = new GridBagConstraints();
		gbc_btn_logout.insets = new Insets(0, 0, 5, 0);
		gbc_btn_logout.gridx = 0;
		gbc_btn_logout.gridy = 12;
		panel_1.add(btn_logout, gbc_btn_logout);
		GridBagConstraints gbc_lblNewLabel_27 = new GridBagConstraints();
		gbc_lblNewLabel_27.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_27.gridx = 0;
		gbc_lblNewLabel_27.gridy = 13;
		lblNewLabel_27.setFont(new Font("Dialog", Font.BOLD, 13));
		panel_1.add(lblNewLabel_27, gbc_lblNewLabel_27);

		panel_2 = new GradientPanel(Color.white, new Color(0, 160, 255), 3);
		panel_2.setBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(0, 204, 204)));
		panel_2.setBackground(new Color(0, 204, 255));
		contentPane.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		lblNewLabel = new JLabel("ADMIN OFFICER PAGE");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(255, 255, 204));
		panel_2.add(lblNewLabel);

	}
	public Admin(Employee emp) throws HeadlessException {
		this();
		this.emp = emp;

	}

	private void addListShitf() {
		comboBox_searchShiftTrangchur.addItem("All Shift");
		sb.getListShift().forEach(shift -> comboBox_searchShiftTrangchur.addItem(Integer.toString(shift.getIdShift())));
		comboBox_searchShiftTrangchur.addItem("OFF");
	}

	private void addListMonth() {
		Calendar cal = Calendar.getInstance();
		int thismonth = cal.get(Calendar.MONTH) + 1;
		int nextmonth = cal.get(Calendar.MONTH) + 2;
		int next2month = cal.get(Calendar.MONTH) + 3;
		int thisyear = cal.get(Calendar.YEAR);
		int nextyear = cal.get(Calendar.YEAR) + 1;
		int checkngay = atdbao.showmonth(getdatenow());

		if (checkngay > 7) {
			lbl_ChiaCa_ShowMonth.setText(Integer.toString(nextmonth));
			if (nextmonth == 1) {
				lbl_ChiaCa_ShowYear.setText(Integer.toString(nextyear));
			} else {
				lbl_ChiaCa_ShowYear.setText(Integer.toString(thisyear));
			}

		} else if (checkngay <= 7) {
			lbl_ChiaCa_ShowMonth.setText(Integer.toString(next2month));
			if (next2month == 1) {
				lbl_ChiaCa_ShowYear.setText(Integer.toString(nextyear));
			} else {
				lbl_ChiaCa_ShowYear.setText(Integer.toString(thisyear));
			}
		}

	}

	public Date getdatefromcarender() {
		return new java.sql.Date(dateChooser.getDate().getTime());
	}

	public Date getdatenow() {
		Date date = new Date();
		return new java.sql.Date(date.getTime());
	}

	public void Showattendancebyday(Date day) {
		if (this.table != null) {
			DefaultTableModel model = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};
			model.addColumn("ID EMPLOYEE");
			model.addColumn("NAME EMPLOYEE");
			model.addColumn("SEASON");
			model.addColumn("DATE");
			model.addColumn("SHIFT");
			model.addColumn("CHECK IN TIME");
			model.addColumn("CHECK OUT TIME");
			model.addColumn("REASON CHECK IN");
			model.addColumn("REASON CHECK OUT");
			model.addColumn("VALIDREASON");
			model.addColumn("OT");
			model.addColumn("TIMEKEEPING BY DAY");

			atdbao.Showbyday(day).forEach(atd -> model.addRow(new Object[] { atd.getIdemp(),
					empb.getacc(atd.getIdemp()).getFullname(), (switch (atd.getSeasondate()) {
					case 0 -> "";
					case 1 -> "Work HL";
					case 2 -> "Work on Compensatory HL";
					case 3 -> "AL";
					case 4 -> "SL";
					case 5 -> "UL";
					case 6 -> "AL+SL";
					case 7 -> "AL+UL";
					case 8 -> "SL+AL";
					case 9 -> "SL+UL";
					case 10 -> "UL+AL";
					default -> "UL+SL";
					}), atd.getDate(), (atd.getIdShift() == 0 ? "OFF" : (Integer.toString(atd.getIdShift()))),
					atd.getCheckin(), atd.getCheckout(), atd.getReasoncheckin(), atd.getReasoncheckout(),
					(switch (atd.getValidreason()) {
					case 0 -> (atd.getReasoncheckin() != null || atd.getReasoncheckout() != null) ? "Waiting Check"
							: "";
					case 1 -> "Person Reson";
					case 2 -> "Will Charge";
					case 3 -> "Work Reason";
					default -> "Checked";
					}),

					atd.getOT(), atd.getTimekeepingbyday() }));

			table.setModel(model);
			table.getTableHeader().setReorderingAllowed(false);
		}

	}

	private void btn_backActionPerformed(ActionEvent e) {
		ChooseType choose = new ChooseType(emp);
		choose.setVisible(true);
		this.setVisible(false);
		clearrequestlevaepage();
	}

	private void btn_callhomeadminActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "panel_trangchu");
		SearchHomeAdmin();
	}

	private void btn_callxepcaActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "arrangeshifts");
		lbl_showtotal.setText(Integer.toString(empb.countempopteam()));
		addListMonth();
		showpanelholiday();
		showpanel18();
		clearrequestlevaepage();
	}

	private void btn_callrequestActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "Request");
		ShowLeave(idemp());
		clearrequestlevaepage();
		showpanel10(0);
		searchRequestShift();
		cbb_boxChangeShift.setSelectedIndex(0);
		cbb_boxChangeShift.setSelectedIndex(0);
		showpanel19();
		textField_searchchangSHIFT.setText(null);
	}

	private void btn_reportActionPerformed(ActionEvent e) {
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "reportbymonth");
		show_table_show_atdby_month();
		ShowpanelHLDreport();
		clearreport();
		showrcbm();
	}

	private void btn_logoutActionPerformed(ActionEvent e) {
		Main main = new Main();
		main.setVisible(true);
		this.setVisible(false);

	}

	private void showbuttonchamcong(Date date) {
		int i = atdbao.differenceDate(getdatefromcarender());
		if (i >= 0) {
			btn_Chamconghangngay.setVisible(true);
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String day = dateFormat.format(date);
			lbl_ShowDate.setText(day);
			lblNewLabel_11.setVisible(true);
		} else {
			btn_Chamconghangngay.setVisible(false);
			lbl_ShowDate.setText(null);
			lblNewLabel_11.setVisible(false);
		}
	}

	protected void tf_searchNameActionPerformed(ActionEvent e) {
		SearchHomeAdmin();
		showbuttonchamcong(getdatefromcarender());
	}

	private void tableMousePressed(MouseEvent e) {
		JPopupMenu menu = new JPopupMenu("menu");
		String text = lbl_ShowDate.getText();
		if (text != null) {
			JMenuItem item4 = new JMenuItem("Change Shift ", 'S');
			item4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					updateShiftonTableAdmin(e);
				}
			});
			menu.add(item4);

			JMenuItem item = new JMenuItem("Set Check In Time ", 'I');
			item.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					updateCheckin(e);
				}
			});
			menu.add(item);

			JMenuItem item3 = new JMenuItem("Set Check Out Time ", 'I');
			item3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					updateCheckout(e);
				}
			});
			menu.add(item3);

			JMenuItem item1 = new JMenuItem("Set Validreason ", 'V');
			item1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					updateValidreason(e);
				}
			});
			menu.add(item1);

			JMenuItem item2 = new JMenuItem("Set OT ", 'O');
			item2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					updateOT(e);
				}
			});
			menu.add(item2);

			JMenuItem item5 = new JMenuItem("Unpaid Leave", 'U');
			item5.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					setUL(e);
				}
			});
			menu.add(item5);

		} else {
			JMenuItem item4 = new JMenuItem("Change Shift ", 'S');
			item4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					updateShiftonTableAdmin(e);
				}
			});
			menu.add(item4);

			JMenuItem item2 = new JMenuItem("Set OT ", 'O');
			item2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					updateOT(e);
				}
			});
			menu.add(item2);
		}

		if (e.getButton() == MouseEvent.BUTTON3) {
			int r = table.rowAtPoint(e.getPoint());
			table.setRowSelectionInterval(r, r);
			menu.show(table, e.getX(), e.getY());
		}
	}

	private Attendancerecord getatdempfromtable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.getDataVector();
		var id = (Integer) model.getValueAt(table.getSelectedRow(), 0);
		var date = (Date) model.getValueAt(table.getSelectedRow(), 3);

		var idshift1 = 0;
		String getidshift = (String) model.getValueAt(table.getSelectedRow(), 4);
		if (getidshift.equals("OFF")) {
			idshift1 = 0;

		} else {
			idshift1 = Integer.parseInt(getidshift);
		}
		var checkintime = (LocalTime) model.getValueAt(table.getSelectedRow(), 5);
		var checkouttime = (LocalTime) model.getValueAt(table.getSelectedRow(), 6);
		var Reasoncheckin = (String) model.getValueAt(table.getSelectedRow(), 7);
		var Reasoncheckout = (String) model.getValueAt(table.getSelectedRow(), 8);
		var validreason = 0;
		var Strvalidreason = (String) model.getValueAt(table.getSelectedRow(), 9);
		if (Strvalidreason.equals("Waiting Check") || Strvalidreason.equals("Null")) {
			validreason = 0;
		} else if (Strvalidreason.equals("Person Reson")) {
			validreason = 1;
		} else if (Strvalidreason.equals("Will Charge")) {
			validreason = 2;
		} else if (Strvalidreason.equals("Work Reason")) {
			validreason = 3;
		} else if (Strvalidreason.equals("Checked")) {
			validreason = 4;
		}

		var OT = (Double) model.getValueAt(table.getSelectedRow(), 10);
		var Timekeepingbyday = (Double) model.getValueAt(table.getSelectedRow(), 11);

		return new Attendancerecord(id, idshift1, date, checkintime, checkouttime, OT, Reasoncheckin, Reasoncheckout,
				validreason, Timekeepingbyday);
	}

	private void updateShiftonTableAdmin(ActionEvent e) {
		var idemp = getatdempfromtable().getIdemp();
		var fullname=empb.getacc(idemp).getFullname();
		var date = getatdempfromtable().getDate();
		String[] optionsconfirm = { "Confirm", "Cancel" };
		var x = JOptionPane.showOptionDialog(this, "Are you sure you want to change "+fullname+"'s shift?",
				"Warning Box", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				optionsconfirm, optionsconfirm[0]);
		if(x==0) {
			updateShift(idemp, date);
			Showattendancebyday(date);
			JOptionPane.showMessageDialog(this, "Success!");
		}else {
			JOptionPane.showMessageDialog(this, "Nothing changed!");
		}

		
	}

	private void updateShift(int idemp, Date date) {
		String[] options = { "OFF", "Shift 1 : From 08:00 to 17:00", "Shift 11: From 08:00 to 12:00 ",
				"Shift 12: From 12:00 to 17:00", "Shift 2 : From 06:00 to 15:00", "Shift 21: From 06:00 to 10:00",
				"Shift 22: From 11:00 to 15:00", "Shift 3 : From 11:00 to 20:00", "Shift 31: From 11:00 to 14:00",
				"Shift 32: From 15:00 to 20:00", "Shift 4 : From 14:00 to 23:00", "Shift 41: From 14:00 to 18:00",
				"Shift 42: From 19:00 to 23:00" };
		String shift = (String) JOptionPane.showInputDialog(this, "Kindly Choose:", "New Shift",
				JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
		if (shift != null) {
			switch (shift) {
			case "OFF" -> {
				atdbao.updatShift(0, idemp, date);
				var i = atdbao.checkhl(date);
				if (i > 0) {
					atdbao.updateseasondate(idemp, date, 0);
				}
			}
			case "Shift 1 : From 08:00 to 17:00" -> atdbao.updatShift(1, idemp, date);
			case "Shift 11: From 08:00 to 12:00 " -> atdbao.updatShift(11, idemp, date);
			case "Shift 12: From 12:00 to 17:00" -> atdbao.updatShift(12, idemp, date);
			case "Shift 2 : From 06:00 to 15:00" -> atdbao.updatShift(2, idemp, date);
			case "Shift 21: From 06:00 to 10:00" -> atdbao.updatShift(21, idemp, date);
			case "Shift 22: From 11:00 to 15:00" -> atdbao.updatShift(22, idemp, date);
			case "Shift 3 : From 11:00 to 20:00" -> atdbao.updatShift(3, idemp, date);
			case "Shift 31: From 11:00 to 14:00" -> atdbao.updatShift(31, idemp, date);
			case "Shift 32: From 15:00 to 20:00" -> atdbao.updatShift(32, idemp, date);
			case "Shift 4 : From 14:00 to 23:00" -> atdbao.updatShift(4, idemp, date);
			case "Shift 41: From 14:00 to 18:00" -> atdbao.updatShift(41, idemp, date);
			case "Shift 42: From 19:00 to 23:00" -> atdbao.updatShift(42, idemp, date);

			}

			JOptionPane.showMessageDialog(this, "Update Shift successfully");
		}

	}

	private void setUL(ActionEvent e) {
		var idemp = getatdempfromtable().getIdemp();
		var fullname = empb.getacc(idemp).getFullname();
		var date = getatdempfromtable().getDate();
		var shift = getatdempfromtable().getIdShift();
		if(shift==0) {
			JOptionPane.showMessageDialog(this, "Can not set Unpai leave for "+ fullname+"\n This employee does not have a schedule" );
		}else {
			String[] optionsconfirm = { "Confirm", "Cancel" };
			var x = JOptionPane.showOptionDialog(this,
					"Are you sure you want to create an unpaid leave case" + "\n for " + fullname + "?", "Warning Box",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, optionsconfirm, optionsconfirm[0]);

			if (x == 0) {
				setULcon(idemp, date, shift);
				Showattendancebyday(date);
			}
		} 
		
	}

	private void setULcon(int idemp, Date date, int shift) {
		RequestleaveBao bao = new RequestleaveBao();
		Requestleave requestleave = null;
		if (shift == 1 || shift == 2 || shift == 3 || shift == 4) {
			String[] options = { "UNPAID LEAVE FULL SHIFT DEFAULTS", "UNPAID LEAVE HALF SHIFT" };
			String setUL = (String) JOptionPane.showInputDialog(this, "Kindly Choose:", "UNPAID LEAVE",
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (setUL != null) {
				switch (setUL) {
				case "UNPAID LEAVE FULL SHIFT DEFAULTS" -> {
					requestleave = new Requestleave(idemp, date, date, 0, 1, 0, idemp(), 1, 0);
					bao.insertReLeave(requestleave);

				}
				case "UNPAID LEAVE HALF SHIFT" -> {

					if (shift == 1) {
						String[] optionsshift = { "UL SHIFT 11: From 08:00 to 12:00",
								"UL SHIFT 12: From 12:00 to 17:00" };
						String sul = (String) JOptionPane.showInputDialog(this, "Kindly Choose shift unpaid:",
								"UNPAID LEAVE", JOptionPane.QUESTION_MESSAGE, null, optionsshift, optionsshift[0]);
						if (sul != null) {
							switch (sul) {
							case "UL SHIFT 11: From 08:00 to 12:00" -> {
								requestleave = new Requestleave(idemp, date, date, 0, 0.5, 0, idemp(), 1, 11);
								bao.insertReLeave(requestleave);
							}
							case "UL SHIFT 12: From 12:00 to 17:00" -> {
								requestleave = new Requestleave(idemp, date, date, 0, 0.5, 0, idemp(), 1, 12);
								bao.insertReLeave(requestleave);
							}
							}
						}
					}
					if (shift == 2) {
						String[] optionsshift = { "UL SHIFT 21: From 06:00 to 10:00",
								"UL SHIFT 22: From 11:00 to 15:00" };
						String sul = (String) JOptionPane.showInputDialog(this, "Kindly Choose shift unpaid:",
								"UNPAID LEAVE", JOptionPane.QUESTION_MESSAGE, null, optionsshift, optionsshift[0]);
						if (sul != null) {
							switch (sul) {
							case "UL SHIFT 21: From 06:00 to 10:00" -> {
								requestleave = new Requestleave(idemp, date, date, 0, 0.5, 0, idemp(), 1, 21);
								bao.insertReLeave(requestleave);
							}
							case "UL SHIFT 22: From 11:00 to 15:00" -> {
								requestleave = new Requestleave(idemp, date, date, 0, 0.5, 0, idemp(), 1, 22);
								bao.insertReLeave(requestleave);
							}
							}
						}
					}
					if (shift == 3) {

						String[] optionsshift = { "UL SHIFT 31: From 11:00 to 14:00",
								"UL SHIFT 32: From 15:00 to 20:00" };
						String sul = (String) JOptionPane.showInputDialog(this, "Kindly Choose shift unpaid:",
								"UNPAID LEAVE", JOptionPane.QUESTION_MESSAGE, null, optionsshift, optionsshift[0]);
						if (sul != null) {
							switch (sul) {
							case "UL SHIFT 31: From 11:00 to 14:00" -> {
								requestleave = new Requestleave(idemp, date, date, 0, 0.5, 0, idemp(), 1, 31);
								bao.insertReLeave(requestleave);
							}
							case "UL SHIFT 32: From 15:00 to 20:00" -> {
								requestleave = new Requestleave(idemp, date, date, 0, 0.5, 0, idemp(), 1, 32);
								bao.insertReLeave(requestleave);
							}
							}
						}
					}
					if (shift == 4) {
						String[] optionsshift = { "UL SHIFT 41: From 14:00 to 18:00",
								"UL SHIFT 42: From 19:00 to 23:00" };
						String sul = (String) JOptionPane.showInputDialog(this, "Kindly Choose shift unpaid:",
								"UNPAID LEAVE", JOptionPane.QUESTION_MESSAGE, null, optionsshift, optionsshift[0]);
						if (sul != null) {
							switch (sul) {
							case "UL SHIFT 41: From 14:00 to 18:00" -> {
								requestleave = new Requestleave(idemp, date, date, 0, 0.5, 0, idemp(), 1, 41);
								bao.insertReLeave(requestleave);
							}
							case "UL SHIFT 42: From 19:00 to 23:00" -> {
								requestleave = new Requestleave(idemp, date, date, 0, 0.5, 0, idemp(), 1, 42);
								bao.insertReLeave(requestleave);
							}
							}
						}
					}

				}

				}
			}
		} else {
			requestleave = new Requestleave(idemp, date, date, 0, 0.5, 0, idemp(), 1, shift);
			bao.insertReLeave(requestleave);

		}

		JOptionPane.showMessageDialog(this,
				"Successful Request Creation" + "\n" + "Kindly Follow Request Tab For This Case");

	}

	private void updateCheckin(ActionEvent e) {
		int i = 0;
		if (getatdempfromtable().getIdShift() != 0 || getatdempfromtable().getOT() != 0) {
			if (getatdempfromtable().getValidreason() != 0) {
				String[] optionsconfirm = { "Confirm", "Cancel" };
				var x = JOptionPane.showOptionDialog(this, "Looks like this employee has been timed for this day."
						+ "\n" + " Do you really want to change the information?" + "\n"
						+ "You will need to reschedule all employees for this day after changing the information",
						"Warning Box", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						optionsconfirm, optionsconfirm[0]);

				if (x == 0) {
					atdbao.updatevalidreasonForOneEmp(0, getatdempfromtable().getDate(),
							getatdempfromtable().getIdemp());
					do {
						String checkintimeinput = JOptionPane.showInputDialog(this,
								"Input CheckInTime with format HH:mm");
						if (checkintimeinput != null) {
							if (helper.Validation.MessErrorInputtime(checkintimeinput).equals("")) {
								LocalTime checkin = LocalTime.parse(checkintimeinput,
										DateTimeFormatter.ofPattern("HH:mm"));
								var checkout = getatdempfromtable().getCheckout();
								if (checkout != null) {
									int a = atdbao.differencetime(checkin, checkout);
									if (a > 0) {
										String[] options = { "Forgot check In reason person",
												"Forgot check In reason company work" };
										var stt = JOptionPane.showInputDialog(this, "Kindly Choose:", "Update Status",
												JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
										if (stt != null) {
											if (stt.equals("Forgot check In reason person")) {
												var j=0;
												do {
													String reason = JOptionPane.showInputDialog(this,
															"Input in the reason Forgot check-in");
													if (reason != null && !reason.isEmpty()) {
														if (helper.Validation.MessErrorSearchNameXuan(reason).equals("")) {
															atdbao.updatereasonCheckin(reason,
																	getatdempfromtable().getIdemp(),
																	getatdempfromtable().getDate());
															atdbao.updatecheckin(checkin, getatdempfromtable().getIdemp(),
																	getatdempfromtable().getDate());
															JOptionPane.showMessageDialog(this,
																	"Update Check in time  and reason successfully");
															j=0;
															JOptionPane.showMessageDialog(this,
																	"Kindy re-check Timekeeping for this day because something changed!!");
															Showattendancebyday(getdatefromcarender());
															i = 0;
														} else {
															JOptionPane.showMessageDialog(this,
																	helper.Validation.MessErrorSearchNameXuan(reason));
															j = 1;
															
														}
													} else {
														JOptionPane.showMessageDialog(this, "Update Unsuccessfully");
														i = 0;
														j=0;
													}
												}while(j==1);
												
											} else if (stt.equals("Forgot check In reason company work")) {
												atdbao.updatereasonCheckin("Company Work",
														getatdempfromtable().getIdemp(),
														getatdempfromtable().getDate());
												atdbao.updatecheckin(checkin, getatdempfromtable().getIdemp(),
														getatdempfromtable().getDate());
												JOptionPane.showMessageDialog(this,
														"Update Check in time successfully");
												JOptionPane.showMessageDialog(this,
														"Kindy re-check Timekeeping for this day because something changed!!");
												Showattendancebyday(getdatefromcarender());
												i = 0;
											}
											
										}
										
									} else if (a <= 0) {
										JOptionPane.showMessageDialog(this,
												"Check-in time needs to be earlier than check-out time");
										i = 1;
									}
								}

							} else {
								JOptionPane.showMessageDialog(this,
										helper.Validation.MessErrorInputtime(checkintimeinput));
								i = 1;
							}

						} else {
							i = 0;
						}
					} while (i == 1);

				}

			} else {
				do {
					String checkintimeinput = JOptionPane.showInputDialog(this, "Input CheckInTime with format HH:mm");
					if (checkintimeinput != null) {
						if (helper.Validation.MessErrorInputtime(checkintimeinput).equals("")) {
							LocalTime checkin = LocalTime.parse(checkintimeinput, DateTimeFormatter.ofPattern("HH:mm"));
							var checkout = getatdempfromtable().getCheckout();
							if (checkout != null) {
								int a = atdbao.differencetime(checkin, checkout);
								if (a > 0) {
									String[] options = { "Forgot check In reason person",
											"Forgot check In reason company work" };
									var stt = JOptionPane.showInputDialog(this, "Kindly Choose:", "Update Status",
											JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
									if (stt != null) {
										if (stt.equals("Forgot check In reason person")) {
											var j = 0;
											do {
												String reason = JOptionPane.showInputDialog(this,
														"Input in the reason Forgot check-in");
												if (reason != null && !reason.isEmpty()) {
													if (helper.Validation.MessErrorSearchNameXuan(reason).equals("")) {
														atdbao.updatereasonCheckin(reason,
																getatdempfromtable().getIdemp(),
																getatdempfromtable().getDate());
														atdbao.updatecheckin(checkin, getatdempfromtable().getIdemp(),
																getatdempfromtable().getDate());
														JOptionPane.showMessageDialog(this,
																"Update Check in time  and reason successfully");
														j = 0;
													} else {
														JOptionPane.showMessageDialog(this,
																helper.Validation.MessErrorSearchNameXuan(reason));
														j = 1;
													}

												} else {
													JOptionPane.showMessageDialog(this, "Update Unsuccessfully");
													i = 0;
													j=0;

												}
											} while (j == 1);

										} else if (stt.equals("Forgot check In reason company work")) {
											atdbao.updatereasonCheckin("Company Work", getatdempfromtable().getIdemp(),
													getatdempfromtable().getDate());
											atdbao.updatecheckin(checkin, getatdempfromtable().getIdemp(),
													getatdempfromtable().getDate());
											JOptionPane.showMessageDialog(this, "Update Check in time successfully");
										}

									}

									Showattendancebyday(getdatefromcarender());
									i = 0;
								} else if (a <= 0) {
									JOptionPane.showMessageDialog(this,
											"Check-in time needs to be earlier than check-out time");
									i = 1;
								}
							}

						} else {
							JOptionPane.showMessageDialog(this, helper.Validation.MessErrorInputtime(checkintimeinput));
							i = 1;
						}

					} else {
						i = 0;
					}
				} while (i == 1);
			}
		} else if (getatdempfromtable().getIdShift() == 0 && getatdempfromtable().getOT() == 0) {
			JOptionPane.showMessageDialog(this,
					"this Employee off this day and no has OT" + "\n" + "Can not update checkin time");
		}
	}

	private void updateCheckout(ActionEvent e) {
		int i = 0;
		if (getatdempfromtable().getIdShift() != 0 || getatdempfromtable().getOT() != 0) {
			if (getatdempfromtable().getValidreason() != 0) {
				String[] optionsconfirm = { "Confirm", "Cancel" };
				var x = JOptionPane.showOptionDialog(this, "Looks like this employee has been timed for this day."
						+ "\n" + " Do you really want to change the information?" + "\n"
						+ "You will need to reschedule all employees for this day after changing the information",
						"Warning Box", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
						optionsconfirm, optionsconfirm[0]);

				if (x == 0) {
					atdbao.updatevalidreasonForOneEmp(0, getatdempfromtable().getDate(),
							getatdempfromtable().getIdemp());
					do {
						String checkOuttimeinput = JOptionPane.showInputDialog(this,
								"Input Check Out Time with format HH:mm");
						if (checkOuttimeinput != null) {
							if (helper.Validation.MessErrorInputtime(checkOuttimeinput).equals("")) {
								LocalTime checkOut = LocalTime.parse(checkOuttimeinput,
										DateTimeFormatter.ofPattern("HH:mm"));
								var checkin = getatdempfromtable().getCheckin();
								if (checkin != null) {
									int a = atdbao.differencetime(checkin, checkOut);
									if (a > 0) {
										String[] options1 = { "Forgot check out reason person",
												"Forgot check out reason Company work" };
										String stt1 = (String) JOptionPane.showInputDialog(this, "Kindly Choose:",
												"Update Status", JOptionPane.QUESTION_MESSAGE, null, options1,
												options1[0]);
										if (stt1 != null) {
											switch (stt1) {
											case "Forgot check out reason person" -> {
												var j = 0;
												do {
													String reason = JOptionPane.showInputDialog(this,
															"Input in the reason Forgot check out");
													if (reason != null && !reason.isEmpty()) {
														if (helper.Validation.MessErrorSearchNameXuan(reason)
																.equals("")) {
															atdbao.updatereasonCheckout(reason,
																	getatdempfromtable().getIdemp(),
																	getatdempfromtable().getDate());
															atdbao.updatecheckout(checkOut,
																	getatdempfromtable().getIdemp(),
																	getatdempfromtable().getDate());
															JOptionPane.showMessageDialog(this,
																	"Update Check Out time and reason successfully");
															j = 0;
														} else {
															JOptionPane.showMessageDialog(this,
																	helper.Validation.MessErrorSearchNameXuan(reason));
															j = 1;
														}
													}
												} while (j == 1);

											}
											case "Forgot check out reason Company work" -> {
												atdbao.updatereasonCheckout("Company Work",
														getatdempfromtable().getIdemp(),
														getatdempfromtable().getDate());
												atdbao.updatecheckout(checkOut, getatdempfromtable().getIdemp(),
														getatdempfromtable().getDate());
												JOptionPane.showMessageDialog(this,
														"Update Check Out time successfully");
											}
											}
											JOptionPane.showMessageDialog(this,
													"Kindy re-check Timekeeping for this day because something changed!!");
										}

										Showattendancebyday(getdatefromcarender());
										i = 0;
									} else if (a <= 0) {
										JOptionPane.showMessageDialog(this,
												"Check-in time needs to be earlier than check-out time");
										i = 1;
									}
								}

							} else {
								JOptionPane.showMessageDialog(this,
										helper.Validation.MessErrorInputtime(checkOuttimeinput));
								i = 1;
							}

						}
					} while (i == 1);

				}

			} else {
				do {
					String checkOuttimeinput = JOptionPane.showInputDialog(this,
							"Input Check Out Time with format HH:mm");
					if (checkOuttimeinput != null) {
						if (helper.Validation.MessErrorInputtime(checkOuttimeinput).equals("")) {
							LocalTime checkOut = LocalTime.parse(checkOuttimeinput,
									DateTimeFormatter.ofPattern("HH:mm"));
							var checkin = getatdempfromtable().getCheckin();
							if (checkin != null) {
								int a = atdbao.differencetime(checkin, checkOut);
								if (a > 0) {
									String[] options1 = { "Forgot check out reason person",
											"Forgot check out reason Company work" };
									String stt1 = (String) JOptionPane.showInputDialog(this, "Kindly Choose:",
											"Update Status", JOptionPane.QUESTION_MESSAGE, null, options1, options1[0]);
									if (stt1 != null) {
										switch (stt1) {
										case "Forgot check out reason person" -> {
											var j = 0;
											do {
												String reason = JOptionPane.showInputDialog(this,
														"Input in the reason Forgot check out");
												if (reason != null && !reason.isEmpty()) {
													if (helper.Validation.MessErrorSearchNameXuan(reason).equals("")) {
														atdbao.updatereasonCheckout(reason,
																getatdempfromtable().getIdemp(),
																getatdempfromtable().getDate());
														atdbao.updatecheckout(checkOut, getatdempfromtable().getIdemp(),
																getatdempfromtable().getDate());
														JOptionPane.showMessageDialog(this,
																"Update Check Out time and reason successfully");
														j = 0;
													} else {
														JOptionPane.showMessageDialog(this,
																helper.Validation.MessErrorSearchNameXuan(reason));
														j = 1;
													}
												}
											} while (j == 1);

										}
										case "Forgot check out reason Company work" -> {
											atdbao.updatereasonCheckout("Company Work", getatdempfromtable().getIdemp(),
													getatdempfromtable().getDate());
											atdbao.updatecheckout(checkOut, getatdempfromtable().getIdemp(),
													getatdempfromtable().getDate());
											JOptionPane.showMessageDialog(this, "Update Check Out time successfully");
										}
										}
									}
									Showattendancebyday(getdatefromcarender());
									i = 0;
								} else if (a <= 0) {
									JOptionPane.showMessageDialog(this,
											"Check-in time needs to be earlier than check-out time");
									i = 1;
								}
							}

						} else {
							JOptionPane.showMessageDialog(this,
									helper.Validation.MessErrorInputtime(checkOuttimeinput));
							i = 1;
						}

					}
				} while (i == 1);
			}

		} else if (getatdempfromtable().getIdShift() == 0 && getatdempfromtable().getOT() == 0) {
			JOptionPane.showMessageDialog(this,
					"this Employee off this day and no has OT" + "\n" + "Can not update checkin time");
		}

	}

	private void updateValidreason(ActionEvent e) {
		var attendance = getatdempfromtable();
		if (attendance.getReasoncheckin() == null && attendance.getReasoncheckout() == null) {
			JOptionPane.showMessageDialog(this, "Could not update Valid Reason for this Employee" + "\n"
					+ "due Reason check in and reason check out is empty");
		} else {
			String[] options = { "Accept Personal Reasons", "Do Not Accept Personal Reasons", "Accept Work Reasons" };
			var validReason = (String) JOptionPane.showInputDialog(this, "Kindly Choose:", "Update Validreason",
					JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
			if (validReason != null) {
				if (validReason.equals("Accept Personal Reasons")) {
					atdbao.validreason(1, attendance.getIdemp(), getatdempfromtable().getDate());
				} else if (validReason.equals("Do Not Accept Personal Reasons")) {
					atdbao.validreason(2, attendance.getIdemp(), getatdempfromtable().getDate());
				} else if (validReason.equals("Accept Work Reasons")) {
					atdbao.validreason(3, attendance.getIdemp(), getatdempfromtable().getDate());
				}
				JOptionPane.showMessageDialog(this, "Update Status successfully");
				Showattendancebyday(getdatefromcarender());
			}

		}

	}

	private void updateOT(ActionEvent e) {
		int i = 0;
		var id = getatdempfromtable().getIdemp();
		var shift = getatdempfromtable().getIdShift();
		var date = getatdempfromtable().getDate();
		do {
			String OT = JOptionPane.showInputDialog(this,
					"Input the total number of overtime hours worked by the employee");
			if (OT != null) {
				if (!(OT.isEmpty())) {
					if (helper.Validation.MessErrorInputOT(OT).equals("")) {
						double ot = Double.parseDouble(OT);
						var oldTotalOT = atdbao.sumOT(id, date);
						var newTotalOT = oldTotalOT + ot;
						if (oldTotalOT < 40) {
							if (newTotalOT <= 40) {
								if (shift == 0) {
									if (ot <= 12) {
										atdbao.updateOT(ot, id, date);
										Showattendancebyday(date);
										i = 1;

									} else {
										JOptionPane.showMessageDialog(this,
												"Employees whose overtime hours do not exceed 12 hours a day");
										i = 0;

									}
								} else if(shift == 1 || shift == 2 || shift == 3|| shift == 4){
									if (ot <= 4) {
										atdbao.updateOT(ot, id, date);
										Showattendancebyday(date);
										i = 1;

									} else {
										JOptionPane.showMessageDialog(this,
												"This employee works overtime for no more than 4 hours a day");
										i = 0;

									}
								}else{
									if (ot <= 8) {
										atdbao.updateOT(ot, id, date);
										Showattendancebyday(date);
										i = 1;

									} else {
										JOptionPane.showMessageDialog(this,
												"This employee works overtime for no more than 8 hours a day");
										i = 0;

									}
								}
							} else {
								JOptionPane.showMessageDialog(this, "This employee has a total of " + oldTotalOT
										+ "this month" + "\n"
										+ " Please reset as the total OT due for the month cannot exceed 40 hours");
								i = 0;

							}
						} else {
							JOptionPane.showMessageDialog(this,
									"Can not set OT for this employee due total OT is 40 hours");
							i = 1;

						}
					} else {
						JOptionPane.showMessageDialog(this, helper.Validation.MessErrorInputOT(OT));
						i = 0;
					}
				} else {
					i = 1;
				}
			} else {
				i = 1;
			}

		} while (i != 1);
	}

	private void showtablesearchAll(Date day, String name, int idshift) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("ID EMPLOYEE");
		model.addColumn("NAME EMPLOYEE");
		model.addColumn("SEASON");
		model.addColumn("DATE");
		model.addColumn("SHIFT");
		model.addColumn("CHECK IN TIME");
		model.addColumn("CHECK OUT TIME");
		model.addColumn("REASON CHECK IN");
		model.addColumn("REASON CHECK OUT");
		model.addColumn("VALIDREASON");
		model.addColumn("OT");
		model.addColumn("TIMEKEEPING BY DAY");

		atdbao.Searchallonday(day, name, idshift).forEach(atd -> model.addRow(new Object[] { atd.getIdemp(),
				empb.getacc(atd.getIdemp()).getFullname(), (switch (atd.getSeasondate()) {
				case 0 -> "";
				case 1 -> "Work HL";
				case 2 -> "Work onCompensatory HL";
				case 3 -> "AL";
				case 4 -> "SL";
				case 5 -> "UL";
				case 6 -> "AL+SL";
				case 7 -> "AL+UL";
				case 8 -> "SL+AL";
				case 9 -> "SL+UL";
				case 10 -> "UL+AL";
				default -> "UL+SL";
				}), atd.getDate(), (atd.getIdShift() == 0 ? "OFF" : (Integer.toString(atd.getIdShift()))),
				atd.getCheckin(), atd.getCheckout(), atd.getReasoncheckin(), atd.getReasoncheckout(),
				(switch (atd.getValidreason()) {
				case 0 -> (atd.getReasoncheckin() != null || atd.getReasoncheckout() != null) ? "Waiting Check" : "";
				case 1 -> "Person Reson";
				case 2 -> "Will Charge";
				case 3 -> "Work Reason";
				default -> "Checked";
				}),

				atd.getOT(), atd.getTimekeepingbyday() }));

		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
	}

	private void showTableSearchDateAndName(Date day, String name) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("ID EMPLOYEE");
		model.addColumn("NAME EMPLOYEE");
		model.addColumn("SEASON");
		model.addColumn("DATE");
		model.addColumn("SHIFT");
		model.addColumn("CHECK IN TIME");
		model.addColumn("CHECK OUT TIME");
		model.addColumn("REASON CHECK IN");
		model.addColumn("REASON CHECK OUT");
		model.addColumn("VALIDREASON");
		model.addColumn("OT");
		model.addColumn("TIMEKEEPING BY DAY");

		atdbao.SearchDateAndName(day, name).forEach(atd -> model.addRow(new Object[] { atd.getIdemp(),
				empb.getacc(atd.getIdemp()).getFullname(), (switch (atd.getSeasondate()) {
				case 0 -> "";
				case 1 -> "Work HL";
				case 2 -> "Work onCompensatory HL";
				case 3 -> "AL";
				case 4 -> "SL";
				case 5 -> "UL";
				case 6 -> "AL+SL";
				case 7 -> "AL+UL";
				case 8 -> "SL+AL";
				case 9 -> "SL+UL";
				case 10 -> "UL+AL";
				default -> "UL+SL";
				}), atd.getDate(), (atd.getIdShift() == 0 ? "OFF" : (Integer.toString(atd.getIdShift()))),
				atd.getCheckin(), atd.getCheckout(), atd.getReasoncheckin(), atd.getReasoncheckout(),
				(switch (atd.getValidreason()) {
				case 0 -> (atd.getReasoncheckin() != null || atd.getReasoncheckout() != null) ? "Waiting Check" : "";
				case 1 -> "Person Reson";
				case 2 -> "Will Charge";
				case 3 -> "Work Reason";
				default -> "Checked";
				}),

				atd.getOT(), atd.getTimekeepingbyday() }));

		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
	}

	private void showTableSearchDateAndShift(Date day, int idShift) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("ID EMPLOYEE");
		model.addColumn("NAME EMPLOYEE");
		model.addColumn("SEASON");
		model.addColumn("DATE");
		model.addColumn("SHIFT");
		model.addColumn("CHECK IN TIME");
		model.addColumn("CHECK OUT TIME");
		model.addColumn("REASON CHECK IN");
		model.addColumn("REASON CHECK OUT");
		model.addColumn("VALIDREASON");
		model.addColumn("OT");
		model.addColumn("TIMEKEEPING BY DAY");

		atdbao.SearchDateAndShift(day, idShift).forEach(atd -> model.addRow(new Object[] { atd.getIdemp(),
				empb.getacc(atd.getIdemp()).getFullname(), (switch (atd.getSeasondate()) {
				case 0 -> "";
				case 1 -> "Work HL";
				case 2 -> "Work onCompensatory HL";
				case 3 -> "AL";
				case 4 -> "SL";
				case 5 -> "UL";
				case 6 -> "AL+SL";
				case 7 -> "AL+UL";
				case 8 -> "SL+AL";
				case 9 -> "SL+UL";
				case 10 -> "UL+AL";
				default -> "UL+SL";
				}), atd.getDate(), (atd.getIdShift() == 0 ? "OFF" : (Integer.toString(atd.getIdShift()))),
				atd.getCheckin(), atd.getCheckout(), atd.getReasoncheckin(), atd.getReasoncheckout(),
				(switch (atd.getValidreason()) {
				case 0 -> (atd.getReasoncheckin() != null || atd.getReasoncheckout() != null) ? "Waiting Check" : "";
				case 1 -> "Person Reson";
				case 2 -> "Will Charge";
				case 3 -> "Work Reason";
				default -> "Checked";
				}),

				atd.getOT(), atd.getTimekeepingbyday() }));

		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
	}

	private void btn_showlichtheongayActionPerformed(ActionEvent e) {
		SearchHomeAdmin();
		showbuttonchamcong(getdatefromcarender());

	}

	public void SearchHomeAdmin() {
		Date datechoose = getdatefromcarender();
		String searchFullName = tf_searchName.getText().trim();
		var getidshift = (String) comboBox_searchShiftTrangchur.getSelectedItem();
		int i = atdbao.differenceMonth(datechoose);
		if (i < -2 || i > 1) {
			JOptionPane.showMessageDialog(this,
					"Only display information last month, this month, next month and next 2 month" + "\n"
							+ "Please Try Again!!",
					"OPS!!!", JOptionPane.ERROR_MESSAGE);
			dateChooser.setDate(new Date());
			tf_searchName.setText(null);
			comboBox_searchShiftTrangchur.setSelectedIndex(0);
			Showattendancebyday(getdatenow());
		} else {
			var mes = helper.Validation.MessErrorSearchNameXuan(searchFullName);
			if (mes.equals("")) {
				if (searchFullName.isEmpty()) {
					if (getidshift.equals("All Shift")) {
						Showattendancebyday(datechoose);
					} else if (getidshift.equals("OFF")) {
						showTableSearchDateAndShift(datechoose, 0);
					} else {
						var ids = Integer.parseInt(getidshift);
						showTableSearchDateAndShift(datechoose, ids);
					}

				} else {
					if (getidshift.equals("All Shift")) {
						showTableSearchDateAndName(datechoose, searchFullName);
					} else if (getidshift.equals("OFF")) {
						showtablesearchAll(datechoose, searchFullName, 0);
					} else {
						var ids = Integer.parseInt(getidshift);
						showtablesearchAll(datechoose, searchFullName, ids);
					}
				}

			} else {
				JOptionPane.showMessageDialog(this, mes + "\n" + "Please Try Again!!", "OPS!!!",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

	private Date getdatefromtable() {
		Date day = null;
		try {
			day = new SimpleDateFormat("yyyy-MM-dd").parse(lbl_ShowDate.getText());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return new java.sql.Date(day.getTime());
	}

	private void btn_ChamconghangngayActionPerformed(ActionEvent e) {
		var day = getdatefromtable();

		atdbao.updatevalidreason(4, day);
		atdbao.updatetimekeepingbyday(day);
		tf_searchName.setText(null);
		dateChooser.setDate(getdatefromtable());
		comboBox_searchShiftTrangchur.setSelectedIndex(0);
		JOptionPane.showMessageDialog(this, "timekeeping this day successfully");
		Showattendancebyday(day);
	}

	protected void comboBox_searchShiftTrangchurActionPerformed(ActionEvent e) {
		SearchHomeAdmin();
	}

	// ====================== chia ca
	private void rdbtnNewRadioButtonActionPerformed(ActionEvent e) {
		showpanelholiday();
	}

	private void rdbtnNewRadioButton_1ActionPerformed(ActionEvent e) {
		showpanelholiday();
	}

	protected void btn_ChiaCaActionPerformed(ActionEvent e) {
		chiaca(e);

	}

	private void chiaca(ActionEvent e) {
		int month = Integer.parseInt(lbl_ChiaCa_ShowMonth.getText());
		if (atdbao.checkMonth(month)) {
			String[] options = { "Confirm", "Cancel" };
			var x = JOptionPane.showOptionDialog(this,
					"This month's shift table has been created. Do you want to delete the old board and create a new one??",
					"Confirm box", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
					options[0]);

			if (x == 0) {
				atdbao.delete(month);
				InserttoAttendance();
			}
		} else {
			InserttoAttendance();
		}
		rdbtnNewRadioButton.setSelected(true);
		rdbtnNewRadioButton_2.setSelected(true);
		tf_ChiaCa_Team1.setText(null);
		tf_ChiaCa_Team2.setText(null);
		tf_ChiaCa_Team3.setText(null);
		tf_ChiaCa_Team4.setText(null);
		tf_ChiaCa_Team5.setText(null);
		showpanelholiday();
	}

	private void showpanelholiday() {
		int month = Integer.parseInt(lbl_ChiaCa_ShowMonth.getText());
		var showhld = "";
		var control = buttonGroup.getElements();
		while (control.hasMoreElements()) {
			JRadioButton jRadio = (JRadioButton) control.nextElement();
			if (jRadio.isSelected()) {
				showhld = jRadio.getText();
			}
		}
		if (showhld.equals("Non Holiday")) {
			panel_17.setVisible(false);
			lblNewLabel_31.setVisible(false);
			lblNewLabel_32.setVisible(false);
			dateChooser_1.setVisible(false);
			dateChooser_2.setVisible(false);
		} else {
			panel_17.setVisible(true);
			lblNewLabel_31.setVisible(true);
			lblNewLabel_32.setVisible(true);
			dateChooser_1.setVisible(true);
			dateChooser_2.setVisible(true);
			dateChooser_1.getJCalendar().getDayChooser().setMinSelectableDate(mindate(month));
			dateChooser_2.getJCalendar().getDayChooser().setMinSelectableDate(mindate(month));
			dateChooser_1.getJCalendar().getDayChooser().setMaxSelectableDate(maxdate(month));
			dateChooser_2.getJCalendar().getDayChooser().setMaxSelectableDate(maxdate(month));

		}
	}

	private void showpanel18() {
		int month = Integer.parseInt(lbl_ChiaCa_ShowMonth.getText());
		var showhld = "";
		var control = buttonGroup_1.getElements();
		while (control.hasMoreElements()) {
			JRadioButton jRadio = (JRadioButton) control.nextElement();
			if (jRadio.isSelected()) {
				showhld = jRadio.getText();
			}
		}
		if (showhld.equals("No Has Compensatory Day")) {
			panel_18.setVisible(false);
			lblNewLabel_39.setVisible(false);
			lblNewLabel_40.setVisible(false);
			dateChooser_7.setVisible(false);
			dateChooser_8.setVisible(false);
		} else {
			panel_18.setVisible(true);
			lblNewLabel_39.setVisible(true);
			lblNewLabel_40.setVisible(true);
			dateChooser_7.setVisible(true);
			dateChooser_8.setVisible(true);
			dateChooser_7.getJCalendar().getDayChooser().setMinSelectableDate(mindate(month));
			dateChooser_8.getJCalendar().getDayChooser().setMinSelectableDate(mindate(month));
			dateChooser_7.getJCalendar().getDayChooser().setMaxSelectableDate(maxdate(month));
			dateChooser_8.getJCalendar().getDayChooser().setMaxSelectableDate(maxdate(month));
		}
	}

	public void InserttoAttendance() {
		int thang = Integer.parseInt(lbl_ChiaCa_ShowMonth.getText());
		int nam = Integer.parseInt(lbl_ChiaCa_ShowYear.getText());
		int cfnhuan = checknamnhuan(nam);
		var Stringtem1 = tf_ChiaCa_Team1.getText();
		var Stringtem2 = tf_ChiaCa_Team2.getText();
		var Stringtem3 = tf_ChiaCa_Team3.getText();
		var Stringtem4 = tf_ChiaCa_Team4.getText();
		var Stringtem5 = tf_ChiaCa_Team5.getText();
		inputnum(Stringtem1, lbl_EMChiaCa_team1);
		inputnum(Stringtem2, lbl_EMChiaCa_team2);
		inputnum(Stringtem3, lbl_EMChiaCa_team3);
		inputnum(Stringtem4, lbl_EMChiaCa_team4);
		inputnum(Stringtem5, lbl_EMChiaCa_team5);

		if (lbl_EMChiaCa_team1.getText().equals("") && lbl_EMChiaCa_team2.getText().equals("")
				&& lbl_EMChiaCa_team3.getText().equals("") && lbl_EMChiaCa_team4.getText().equals("")
				&& lbl_EMChiaCa_team5.getText().equals("")) {
			int numteam1 = Integer.parseInt(Stringtem1);
			int numteam2 = Integer.parseInt(Stringtem2);
			int numteam3 = Integer.parseInt(Stringtem3);
			int numteam4 = Integer.parseInt(Stringtem4);
			int numteam5 = Integer.parseInt(Stringtem5);
			var total = numteam1 + numteam2 + numteam3 + numteam4 + numteam5;
			int totalOTemp = Integer.parseInt(lbl_showtotal.getText());
			if (total != totalOTemp) {
				JOptionPane.showMessageDialog(
						this, "Total Emplooyee you input: " + total + "\n"
								+ "the total number of inputs should be equal to " + totalOTemp,
						"Erros", JOptionPane.ERROR_MESSAGE);
			} else {// --NEU TONG SO NV NHAP VAO BANG TONG SO NV DANG CO
				if (numteam1 != 0 && numteam2 != 0 && numteam3 != 0 && numteam4 != 0 && numteam5 != 0) {
					var showhld = "";
					var control = buttonGroup.getElements();
					while (control.hasMoreElements()) {
						JRadioButton jRadio = (JRadioButton) control.nextElement();
						if (jRadio.isSelected()) {
							showhld = jRadio.getText();
						}
					}
					var showhld1 = "";
					var control1 = buttonGroup_1.getElements();
					while (control1.hasMoreElements()) {
						JRadioButton jRadio1 = (JRadioButton) control1.nextElement();
						if (jRadio1.isSelected()) {
							showhld1 = jRadio1.getText();
						}
					}

					if (showhld.equals("Holiday") && showhld1.equals("Compensatory Day")) {
						if (dateChooser_1.getDate() != null && dateChooser_2.getDate() != null
								&& dateChooser_7.getDate() != null && dateChooser_8.getDate() != null) {
							var fromHL = new java.sql.Date(dateChooser_1.getDate().getTime());
							var toHL = new java.sql.Date(dateChooser_2.getDate().getTime());
							var fromnghibu = new java.sql.Date(dateChooser_7.getDate().getTime());
							var tonghibu = new java.sql.Date(dateChooser_8.getDate().getTime());
							int checkfdattodat = atdbao.chenhlechgiua2ngay(fromHL, toHL);
							int checknghibu = atdbao.chenhlechgiua2ngay(fromnghibu, tonghibu);
							int checktrungngay1 = atdbao.chenhlechgiua2ngay(fromHL, fromnghibu);
							int checktrungngay2 = atdbao.chenhlechgiua2ngay(fromHL, tonghibu);
							int checktrungngay3 = atdbao.chenhlechgiua2ngay(toHL, fromnghibu);
							int checktrungngay4 = atdbao.chenhlechgiua2ngay(toHL, tonghibu);
							if (checktrungngay1 != 0 && checktrungngay2 != 0 && checktrungngay3 != 0
									&& checktrungngay4 != 0) {

								if (checkfdattodat >= 0) {
									if (checknghibu >= 0) {

										insertdts(thang, nam, cfnhuan, numteam1, numteam2, numteam3, numteam4,
												numteam5);
										atdbao.insertshiftofoffice(thang, nam, cfnhuan);
										atdbao.updatehlforOF(fromHL, toHL);
										atdbao.updatenghibuhlforOF(fromnghibu, tonghibu);
										atdbao.updatehlforOP(fromHL, toHL, 1);
										atdbao.updatehlforOP(fromnghibu, tonghibu, 2);
										JOptionPane.showMessageDialog(this, "Successfully Arrange Shift");
									} else {
										JOptionPane.showMessageDialog(this,
												"Compensatory day end Date needs to be greater than or equal to to date start Compensatory day",
												"Erros", JOptionPane.ERROR_MESSAGE);
									}
								} else {
									JOptionPane.showMessageDialog(this,
											"Holiday end Date needs to be greater than or equal to to date start holiday date",
											"Erros", JOptionPane.ERROR_MESSAGE);
								}
							} else {
								JOptionPane.showMessageDialog(this,
										"Kindly Input Public Holidays Difference With Compensatory Days Off", "Erros",
										JOptionPane.ERROR_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(this, "Kindly Input Date ", "Erros",
									JOptionPane.ERROR_MESSAGE);
						}
					} else if (showhld.equals("Holiday") && showhld1.equals("No Has Compensatory Day")) {
						if (dateChooser_1.getDate() != null && dateChooser_2.getDate() != null) {
							var fromHL = new java.sql.Date(dateChooser_1.getDate().getTime());
							var toHL = new java.sql.Date(dateChooser_2.getDate().getTime());
							int checkfdattodat = atdbao.chenhlechgiua2ngay(fromHL, toHL);
							if (checkfdattodat >= 0) {
								insertdts(thang, nam, cfnhuan, numteam1, numteam2, numteam3, numteam4, numteam5);

								atdbao.insertshiftofoffice(thang, nam, cfnhuan);
								atdbao.updatehlforOF(fromHL, toHL);
								atdbao.updatehlforOP(fromHL, toHL, 1);
								JOptionPane.showMessageDialog(this, "Successfully Arrange Shift");
							} else {
								JOptionPane.showMessageDialog(this,
										"Holiday end Date needs to be greater than or equal to to date start holiday date",
										"Erros", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(this, "Kindly Input Date", "Erros",
									JOptionPane.ERROR_MESSAGE);
						}

					} else if (showhld.equals("Non Holiday") && showhld1.equals("Compensatory Day")) {
						if (dateChooser_7.getDate() != null && dateChooser_8.getDate() != null) {
							var fromnghibu = new java.sql.Date(dateChooser_7.getDate().getTime());
							var tonghibu = new java.sql.Date(dateChooser_8.getDate().getTime());
							int checknghibu = atdbao.chenhlechgiua2ngay(fromnghibu, tonghibu);

							if (checknghibu >= 0) {

								insertdts(thang, nam, cfnhuan, numteam1, numteam2, numteam3, numteam4, numteam5);
								atdbao.insertshiftofoffice(thang, nam, cfnhuan);
								atdbao.updatenghibuhlforOF(fromnghibu, tonghibu);
								atdbao.updatehlforOP(fromnghibu, tonghibu, 2);
								JOptionPane.showMessageDialog(this, "Successfully Arrange Shift");
							} else {
								JOptionPane.showMessageDialog(this,
										"Compensatory day end Date needs to be greater than or equal to to date start Compensatory day",
										"Erros", JOptionPane.ERROR_MESSAGE);
							}

						} else {
							JOptionPane.showMessageDialog(this, "Kindly Input Date", "Erros",
									JOptionPane.ERROR_MESSAGE);
						}
					} else if (showhld.equals("Non Holiday") && showhld1.equals("No Has Compensatory Day")) {

						insertdts(thang, nam, cfnhuan, numteam1, numteam2, numteam3, numteam4, numteam5);
						atdbao.insertshiftofoffice(thang, nam, cfnhuan);
						JOptionPane.showMessageDialog(this, "Successfully Arrange Shift");
					}

				} else {
					JOptionPane.showMessageDialog(this, "The number Employee needs to be greater than 0", "Erros",
							JOptionPane.ERROR_MESSAGE);
				}

			}

		}
	}

	public void insertdts(int thang, int nam, int cfnhuan, int numtem1, int numtem2, int numtem3, int numtem4,
			int numtem5) {
		TempsplittheteamBao tstBao = new TempsplittheteamBao();
		tstBao.inserttodab(numtem1, numtem2, numtem3, numtem4, numtem5);
		atdbao.insertteam1(thang, nam, cfnhuan);
		atdbao.insertteam2(thang, nam, cfnhuan);
		atdbao.insertteam3(thang, nam, cfnhuan);
		atdbao.insertteam4(thang, nam, cfnhuan);
		atdbao.insertteam5(thang, nam, cfnhuan);

	}

	private int checknamnhuan(int year) {

		if ((((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0))) {
			return 1;
		}
		return 0;

	}

	public void inputnum(String num, JLabel lb) {
		if (helper.Validation.MessErrorInputNumber(num).equals("")) {
			lb.setText("");
		} else {
			lb.setText(helper.Validation.MessErrorInputNumber(num));
		}
	}

	private void rdbtnNewRadioButton_2ActionPerformed(ActionEvent e) {
		showpanel18();
	}

	private void rdbtnNewRadioButton_4ActionPerformed(ActionEvent e) {
		showpanel18();
	}

	// ==========================Chang Shift
	private void showpanel10(int idrq) {
		if (idrq == 0) {
			panel_10.setVisible(true);
			lblNewLabel_47.setVisible(true);
			lblNewLabel_45.setVisible(true);
			lblNewLabel_48.setVisible(true);
			lblNewLabel_50.setVisible(true);
			lblNewLabel_52.setVisible(true);
			lblNewLabel_54.setVisible(true);
			lblNewLabel_55.setVisible(true);
			lblNewLabel_75.setVisible(true);
			lblNewLabel_76.setText(null);
			lblNewLabel_46.setText(null);
			lblNewLabel_49.setText(null);
			lblNewLabel_51.setText(null);
			lblNewLabel_53.setText(null);
			lblNewLabel_56.setText(null);
			lblNewLabel_60.setText(null);
			comboBox_1.setVisible(false);
			btnNewButton_1.setVisible(false);
		} else {
			comboBox_1.removeAllItems();
			panel_10.setVisible(true);
			lblNewLabel_47.setVisible(true);
			lblNewLabel_45.setVisible(true);
			lblNewLabel_48.setVisible(true);
			lblNewLabel_50.setVisible(true);
			lblNewLabel_52.setVisible(true);
			lblNewLabel_54.setVisible(true);
			lblNewLabel_55.setVisible(true);
			lblNewLabel_76.setVisible(true);
			var fromemp = empb.getacc(rqsbao.ShowRequestchangeShift(idrq).getFromidemp()).getFullname();
			var fromshifr = rqsbao.ShowRequestchangeShift(idrq).getFromidShift();
			var toemp = empb.getacc(rqsbao.ShowRequestchangeShift(idrq).getToidemp()).getFullname();
			var toshifr = rqsbao.ShowRequestchangeShift(idrq).getToidShift();
			var date = rqsbao.ShowRequestchangeShift(idrq).getDatechange();
			var stt = rqsbao.ShowRequestchangeShift(idrq).getSttrequestchangeShift();
			lblNewLabel_60.setText(Integer.toString(idrq));
			lblNewLabel_46.setText(fromemp);
			lblNewLabel_49.setText(Integer.toString(fromshifr));
			lblNewLabel_51.setText(toemp);
			lblNewLabel_53.setText(Integer.toString(toshifr));
			lblNewLabel_56.setText(date.toString());
			lblNewLabel_76.setText(rqsbao.ShowRequestchangeShift(idrq).getDeadline().toString());
			switch (stt) {
			case 1 -> {
				comboBox_1.setVisible(true);
				comboBox_1.addItem("New Request");
			}
			case 2 -> {
				comboBox_1.setVisible(true);
				comboBox_1.addItem("Waitting Admin Confrim");
				comboBox_1.addItem("Admin Confirm");
				comboBox_1.addItem("Admin Refuse");
			}
			case 3 -> {
				comboBox_1.setVisible(true);
				comboBox_1.addItem("Admin Confirmed");
			}
			case 4 -> {
				comboBox_1.setVisible(true);
				comboBox_1.addItem("Admin Refused");
			}
			default -> {
				comboBox_1.setVisible(true);
				comboBox_1.addItem("Out Of Deadline");
			}
			}
			btnNewButton_1.setVisible(false);
		}
	}

	private void comboBox_1ActionPerformed(ActionEvent e) {
		if (comboBox_1.getSelectedItem() != null) {
			String str = (String) comboBox_1.getSelectedItem();
			if (str.equals("Admin Confirm") || str.equals("Admin Refuse")) {
				btnNewButton_1.setVisible(true);
			} else {
				btnNewButton_1.setVisible(false);
			}
		}

	}

	private void table_ShowChangeShiftMousePressed(MouseEvent e) {
		int selectedRow = table_ShowChangeShift.getSelectedRow();
		var idrequest = (Integer) table_ShowChangeShift.getValueAt(selectedRow, 0);
		showpanel10(idrequest);
		showpanel19();
	}

	private void actionadminrequestshift(int idrqs) {
		var date = rqsbao.ShowRequestchangeShift(idrqs).getDatechange();
		var fromide = rqsbao.ShowRequestchangeShift(idrqs).getFromidemp();
		var fromshift = rqsbao.ShowRequestchangeShift(idrqs).getFromidShift();
		var toide = rqsbao.ShowRequestchangeShift(idrqs).getToidemp();
		var toshift = rqsbao.ShowRequestchangeShift(idrqs).getToidShift();

		if (comboBox_1.getSelectedItem() != null) {
			String str = (String) comboBox_1.getSelectedItem();
			if (str.equals("Admin Confirm")) {
				atdbao.updatShift(toshift, fromide, date);
				atdbao.updatShift(fromshift, toide, date);
				rqsbao.updateSTT(3, idrqs);
			} else if (str.equals("Admin Refuse")) {
				rqsbao.updateSTT(4, idrqs);
			}
		}
	}

	private void showpanel19() {
		var str = lblNewLabel_60.getText();
		if (str != null) {
			var idrqs = Integer.parseInt(str);
			var fromemp = atdbao.getvaluefromemprqs(idrqs);
			var toemp = atdbao.getvaluetoemprqs(idrqs);
			DefaultTableModel model = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			model.addColumn("NAME");
			model.addColumn("CURRENT SHIFT");

			model.addRow(new Object[] { empb.getacc(fromemp.getIdemp()).getFullname(),
					Integer.toString(fromemp.getIdShift()) });
			model.addRow(
					new Object[] { empb.getacc(toemp.getIdemp()).getFullname(), Integer.toString(toemp.getIdShift()) });

			table_ShowRQShift.setModel(model);
			table_ShowRQShift.getTableHeader().setReorderingAllowed(false);

		} else {
			DefaultTableModel model = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			model.addColumn("NAME");
			model.addColumn("CURRENT SHIFT");
			table_ShowRQShift.setModel(model);
			table_ShowRQShift.getTableHeader().setReorderingAllowed(false);
		}

	}

	protected void btnNewButton_1ActionPerformed(ActionEvent e) {
		var idrqs = Integer.parseInt(lblNewLabel_60.getText());
		showpanel19();
		actionadminrequestshift(idrqs);
		showpanel10(idrqs);
		showpanel19();
		searchRequestShift();

	}

	protected void table_ShowRQShiftMousePressed(MouseEvent e) {
		JPopupMenu menu2 = new JPopupMenu("menu");

		JMenuItem item4 = new JMenuItem("Open", 'O');
		item4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				table_ShowRQShiftactionPerformed(e);
			}
		});
		menu2.add(item4);

		if (e.getButton() == MouseEvent.BUTTON3) {
			int r = table_ShowRQShift.rowAtPoint(e.getPoint());
			table_ShowRQShift.setRowSelectionInterval(r, r);
			menu2.show(table_ShowRQShift, e.getX(), e.getY());
		}
	}

	private void table_ShowRQShiftactionPerformed(ActionEvent e) {
		Date date1 = null;
		try {
			date1 = new SimpleDateFormat("yyyy-MM-dd").parse(lblNewLabel_56.getText());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		var date = new java.sql.Date(date1.getTime());
		Opendate(date);

	}

	protected void cbb_changeshiftActionPerformed(ActionEvent e) {
		searchRequestShift();
	}

	protected void cbb_boxChangeShiftActionPerformed(ActionEvent e) {
		searchRequestShift();
	}

	private void hamconsearchRequestShift(String KeyNaemrqs, int stt, int box) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("ID REQUEST");
		model.addColumn("LEVEL");
		model.addColumn("DATE");
		model.addColumn("FROM EMPLOYEE NAME");
		model.addColumn("TO EMPLOYEE NAME");
		model.addColumn("STATUS");
		switch (box) {
		case 0 -> {
			if (KeyNaemrqs.isEmpty()) {
				switch (stt) {
				case 0 -> {
					rqsbao.ShowAllRequestchangeShift(idemp())
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(), ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3)? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 1 -> {
					rqsbao.showrqcshiftbystt(idemp(), 2)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 2 -> {
					rqsbao.showrqcshiftbystt(idemp(), 3)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 3 -> {
					rqsbao.showrqcshiftbystt(idemp(), 4)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}

				}
			} else {
				switch (stt) {
				case 0 -> {
					rqsbao.showrqcshiftsearch(idemp(), KeyNaemrqs)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 1 -> {
					rqsbao.showrqcshiftbysttandnamekey(idemp(), 2, KeyNaemrqs)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 2 -> {
					rqsbao.showrqcshiftbysttandnamekey(idemp(), 3, KeyNaemrqs)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 3 -> {
					rqsbao.showrqcshiftbysttandnamekey(idemp(), 4, KeyNaemrqs)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3)? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}

				}
			}
		}
		case 1 -> {
			if (KeyNaemrqs.isEmpty()) {
				switch (stt) {
				case 0 -> {
					rqsbao.ShowAllRequestchangeShift()
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 1 -> {
					rqsbao.showrqcshiftbystt(2)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 2 -> {
					rqsbao.showrqcshiftbystt(3)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 3 -> {
					rqsbao.showrqcshiftbystt(4)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}

				}
			} else {
				switch (stt) {
				case 0 -> {
					rqsbao.showrqcshiftsearch(KeyNaemrqs)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 1 -> {
					rqsbao.showrqcshiftbysttandnamekey(2, KeyNaemrqs)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 2 -> {
					rqsbao.showrqcshiftbysttandnamekey(3, KeyNaemrqs)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}
				case 3 -> {
					rqsbao.showrqcshiftbysttandnamekey(4, KeyNaemrqs)
							.forEach(rqs -> model.addRow(
									new Object[] { rqs.getIdrqcShift(),  ((rqs.getSttrequestchangeShift() == 5) || (rqs.getSttrequestchangeShift() == 4) || (rqs.getSttrequestchangeShift() == 3) ? ""
											: switch (rqlbao.differenceDate(rqs.getDeadline())) {
											case 1 -> "Urgent";
											case 2 -> "High";
											case 3 -> "Normal";
											default -> "Urgent";
											}), rqs.getDatechange(), empb.getacc(rqs.getFromidemp()).getFullname(),
											empb.getacc(rqs.getToidemp()).getFullname(),
											(switch (rqs.getSttrequestchangeShift()) {
											
											case 4 -> "Refuse";
											case 2 -> "New Request";
											case 3 -> "Completed";
											default -> "Out of Deadline";
											}) }));
				}

				}

			}
		}
		}

		table_ShowChangeShift.setModel(model);
		table_ShowChangeShift.getTableHeader().setReorderingAllowed(false);
	}

	private void searchRequestShift() {
		var KeyNaemrqs = textField_searchchangSHIFT.getText().trim();
		int stt = cbb_changeshift.getSelectedIndex();
		int box = cbb_boxChangeShift.getSelectedIndex();
		var mes = helper.Validation.MessErrorSearchNameXuan(KeyNaemrqs);
		if (mes.equals("")) {
			hamconsearchRequestShift(KeyNaemrqs, stt, box);
		} else {
			JOptionPane.showMessageDialog(this, mes + "\n" + "Please Try Again!!", "OPS!!!", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void btnNewButtonActionPerformed(ActionEvent e) {
		searchRequestShift();
	}

	// ==================request leave=====================================

	public int idemp() {
		return emp.getIdemp();
	}

	private void ShowLeave(int idemp) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("REQUEST NO");
		model.addColumn("LEVEL");
		model.addColumn("FROM EMPLOYEE");
		model.addColumn("FROM DATE");
		model.addColumn("STATUS");

		rqlbao.showRequestLeavebyADOrHR(idemp).forEach(rql -> model
				.addRow(new Object[] { rql.getIdrqleave(), ((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0)? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
				case 1 -> "Urgent";
				case 2 -> "Urgent";
				case 3 -> "Urgent";
				case 4 -> "High";
				case 5 -> "High";
				case 6 -> "Normal";
				case 7 -> "Normal";
				default -> "Normal";
				}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(), (switch (rql.getSttrequestleave()) {
				case 0 -> "Cancel by Admin";// admin hoac emp an cancel
				case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show ra stt 1
				case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok -> hr, admin doi tu 1-2
				case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
				case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
				default -> "Out of Deadline";
				}) }));

		table_LeaveRequest.setModel(model);
		table_LeaveRequest.getTableHeader().setReorderingAllowed(false);
	}

	private void ccb_RQLeaveShowActionActionPerformed(ActionEvent e) {
		actioncbbrqleave();

	}

	private void loaddatatoShowlic() {
		var str = lbl_RQLShowIDRQ.getText();
		if (str != null) {
			var idrequest = Integer.parseInt(str);
			DefaultTableModel model = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			model.addColumn("DATE");
			model.addColumn("SHIFT");

			atdbao.loaddatatoShowlic(idrequest)
					.forEach(atd -> model.addRow(new Object[] { atd.getDate(), atd.getIdShift() }));

			table_ShowLich.setModel(model);
			table_ShowLich.getTableHeader().setReorderingAllowed(false);
		} else {
			DefaultTableModel model = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			model.addColumn("DATE");
			model.addColumn("SHIFT");

			table_ShowLich.setModel(model);
			table_ShowLich.getTableHeader().setReorderingAllowed(false);
		}

	}

	private void actionLeave() {

		var idrequest = Integer.parseInt(lbl_RQLShowIDRQ.getText());
		var action = (String) ccb_RQLeaveShowAction.getSelectedItem();
		var rownum = ccb_RQLeaveShowHR.getSelectedIndex();
		var idhr = empb.selectEmpHR(rownum);
		var myid = idemp();
		var rql = rqlbao.selectidemp(idrequest);
		var idemp = rql.getIdemp();
		var fromdate = convertdate(lbl_RQLeaveShowFromDate.getText());
		var todate = convertdate(lbl_RQLeaveShowtoDate.getText());
		var reasonleave = lbl_RQLeaveShowreason.getText();
		switch (action) {
		case "Reject This Request" -> rqlbao.updateSTT(myid, 0, idrequest);
		case "Confirm And Escalate To HR" -> {
			rqlbao.updateSTT(idhr, 2, idrequest);
			clearrequestlevaepage();
		}
		case "Waiting Update Calendar" -> rqlbao.updateSTT(myid, 3, idrequest);
		case "Update in Calendar" -> {
			var nstr = lbl_RQLeaveShowNoteShift.getText();
			if (!nstr.equals("0")) {
				int i = rqlbao.checksubmithalfshift(idemp, fromdate);
				if (i == 0) {
					atdbao.updateleaveforemp2(idemp, fromdate, Integer.parseInt(nstr));
					switch (reasonleave) {
					case "Annual Leave" -> atdbao.updateseason(3, idemp, fromdate, todate);
					case "Sick Leave" -> atdbao.updateseason(4, idemp, fromdate, todate);
					case "Unpaid Leave" -> atdbao.updateseason(5, idemp, fromdate, todate);
					}
				}

				else if (i == 1) {
					atdbao.updateleaveforemp(idemp, fromdate, todate);
					var rqlhs = rqlbao.submithalfshift(idemp, fromdate);

					String loainghi = "";
					if (rqlhs.getAnnualleave() != 0) {
						loainghi = "Annual Leave";
					}
					if (rqlhs.getSickleave() != 0) {
						loainghi = "Sick Leave";
					}
					if (rqlhs.getUnpaidleave() != 0) {
						loainghi = "Unpaid Leave";
					}
					switch (reasonleave) {

					case "Annual Leave" -> {
						switch (loainghi) {

						case "Annual Leave" -> atdbao.updateseason(3, idemp, fromdate, todate);
						case "Sick Leave" -> atdbao.updateseason(6, idemp, fromdate, todate);
						case "Unpaid Leave" -> atdbao.updateseason(7, idemp, fromdate, todate);
						}
					}

					case "Sick Leave" -> {
						switch (loainghi) {
						case "Annual Leave" -> atdbao.updateseason(8, idemp, fromdate, todate);
						case "Sick Leave" -> atdbao.updateseason(4, idemp, fromdate, todate);
						case "Unpaid Leave" -> atdbao.updateseason(9, idemp, fromdate, todate);
						}
					}

					case "Unpaid Leave" -> {
						switch (loainghi) {
						case "Annual Leave" -> atdbao.updateseason(10, idemp, fromdate, todate);
						case "Sick Leave" -> atdbao.updateseason(11, idemp, fromdate, todate);
						case "Unpaid Leave" -> atdbao.updateseason(5, idemp, fromdate, todate);
						}
					}
					}
				}

			} else {
				atdbao.updateleaveforemp(idemp, fromdate, todate);
				switch (reasonleave) {
				case "Annual Leave" -> atdbao.updateseason(3, idemp, fromdate, todate);
				case "Sick Leave" -> atdbao.updateseason(4, idemp, fromdate, todate);
				case "Unpaid Leave" -> atdbao.updateseason(5, idemp, fromdate, todate);
				}
			}

			rqlbao.updateSTT(myid, 4, idrequest);
			btn_RQLeaveSubmit.setVisible(false);
			ccb_RQLeaveShowAction.removeAllItems();
			ccb_RQLeaveShowAction.addItem("Complete");
			loaddatatoShowlic();

		}
		}
		searchRQLeave();

	}

	private void btn_RQLeaveSubmitActionPerformed(ActionEvent e) {
		actionLeave();
		JOptionPane.showMessageDialog(this, "Success");
	}

	private void Opendate(Date date) {
		dateChooser.setDate(date);
		Showattendancebyday(date);
		showbuttonchamcong(date);
		CardLayout card = (CardLayout) panel.getLayout();
		card.show(panel, "panel_trangchu");

	}

	private void table_ShowLichactionPerformed(ActionEvent e) {
		DefaultTableModel model = (DefaultTableModel) table_ShowLich.getModel();
		model.getDataVector();
		var date = (Date) model.getValueAt(table_ShowLich.getSelectedRow(), 0);
		Opendate(date);
	}

	private void clearrequestlevaepage() {
		lbl_RQLShowIDRQ.setText(null);
		lbl_RQLeaveShowName.setText(null);
		lbl_RQLeaveShowDepart.setText(null);
		lbl_RQLeaveShowFromDate.setText(null);
		lbl_RQLeaveShowtoDate.setText(null);
		lbl_RQLeaveShowNoteShift.setText(null);
		ccb_RQLeaveShowAction.setSelectedItem(null);
		ccb_RQLeaveShowHR.setSelectedItem(null);
		textField_SearnameLeaverq.setText(null);
		lbl_RQLeaveShowreason.setText(null);
		lblNewLabel_74.setText(null);
		cbb_SearchLeaveRq.setSelectedIndex(0);
		cbb_boxleave.setSelectedIndex(0);
		loaddatatoShowlic();
	}

	protected void table_ShowLichMousePressed(MouseEvent e) {
		JPopupMenu menu2 = new JPopupMenu("menu");

		JMenuItem item4 = new JMenuItem("Open", 'O');
		item4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				table_ShowLichactionPerformed(e);
			}
		});
		menu2.add(item4);

		if (e.getButton() == MouseEvent.BUTTON3) {
			int r = table_ShowLich.rowAtPoint(e.getPoint());
			table_ShowLich.setRowSelectionInterval(r, r);
			menu2.show(table_ShowLich, e.getX(), e.getY());
		}
	}

	protected void btn_searchLeaverqActionPerformed(ActionEvent e) {
		searchRQLeave();
	}

	protected void cbb_SearchLeaveRqActionPerformed(ActionEvent e) {
		searchRQLeave();
	}

	protected void cbb_boxleaveActionPerformed(ActionEvent e) {
		searchRQLeave();
	}

	private void hamconsearchRQLeave(String name, int action, int box) {
		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		model.addColumn("REQUEST NO");
		model.addColumn("LEVEL");
		model.addColumn("FROM EMPLOYEE");
		model.addColumn("FROM DATE");
		model.addColumn("STATUS");

		switch (box) {
		case 0 -> {
			if (name.isEmpty()) {
				if (action == 0) {
					rqlbao.showRequestLeavebyADOrHR1(idemp()).forEach(rql -> model.addRow(new Object[] {
							rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 1) {
					rqlbao.Sort(0, idemp()).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 2) {
					rqlbao.Sort(4, idemp()).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 3) {
					rqlbao.Sort(1, idemp()).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0)? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 4) {
					rqlbao.Sort(3, idemp()).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}

			} else {

				if (action == 0) {
					rqlbao.search(name, idemp()).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 1) {
					rqlbao.searchandsort(name, 0, idemp()).forEach(rql -> model.addRow(new Object[] {
							rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 2) {
					rqlbao.searchandsort(name, 4, idemp()).forEach(rql -> model.addRow(new Object[] {
							rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0)? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 3) {
					rqlbao.searchandsort(name, 1, idemp()).forEach(rql -> model.addRow(new Object[] {
							rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 4) {
					rqlbao.searchandsort(name, 3, idemp()).forEach(rql -> model.addRow(new Object[] {
							rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), (switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok -> hr, admin
																		// doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}

			}

		}
		case 1 -> {
			if (name.isEmpty()) {

				if (action == 0) {
					rqlbao.showAllRequestLeave1().forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 1) {
					rqlbao.Sort(0).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 2) {
					rqlbao.Sort(4).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 3) {
					rqlbao.Sort(1).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0)? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 4) {
					rqlbao.Sort(3).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}

			} else {

				if (action == 0) {
					rqlbao.search(name).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 1) {
					rqlbao.searchandsort(name, 0).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 2) {
					rqlbao.searchandsort(name, 4).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}
				if (action == 3) {
					rqlbao.searchandsort(name, 1).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), rql.getFromdate(),
							(switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show
													// ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok ->
																		// hr, admin doi tu 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));

				}
				if (action == 4) {
					rqlbao.searchandsort(name, 3).forEach(rql -> model.addRow(new Object[] { rql.getIdrqleave(),
							((rql.getSttrequestleave() == 5)||(rql.getSttrequestleave() == 4) ||(rql.getSttrequestleave() == 0) ? "" : switch (rqlbao.differenceDate(rql.getDeadline())) {
							case 1 -> "Urgent";
							case 2 -> "Urgent";
							case 3 -> "Urgent";
							case 4 -> "High";
							case 5 -> "High";
							case 6 -> "Normal";
							case 7 -> "Normal";
							default -> "Normal";
							}), empb.getacc(rql.getIdemp()).getFullname(), (switch (rql.getSttrequestleave()) {
							case 0 -> "Cancel by Admin";// admin hoac emp an cancel
							case 1 -> "New Request";// --tao request ra se ack rs -> admin , admin show ra stt 1
							case 2 -> "Waiting Update Employee's leave";// admin check lich, neu ok -> hr, admin doi tu
																		// 1-2
							case 3 -> "Waiting Update Calendar";// -hr lam xong, doi tu 2-3 va -> admin
							case 4 -> "Complete";// admin set lich xong-> tra ve cho employee
							default -> "Out of Deadline";
							}) }));
				}

			}
		}

		}

		table_LeaveRequest.setModel(model);
		table_LeaveRequest.getTableHeader().setReorderingAllowed(false);
	}

	private void searchRQLeave() {
		var name = textField_SearnameLeaverq.getText().trim();
		int action = cbb_SearchLeaveRq.getSelectedIndex();
		int box = cbb_boxleave.getSelectedIndex();
		var mes = helper.Validation.MessErrorSearchNameXuan(name);
		if (mes.equals("")) {
			hamconsearchRQLeave(name, action, box);
		} else {
			JOptionPane.showMessageDialog(this, mes + "\n" + "Please Try Again!!", "OPS!!!", JOptionPane.ERROR_MESSAGE);
		}
	}

	protected void table_LeaveRequestMousePressed(MouseEvent e) {
		table_LeaveRequest_MousePressed(e);
	}

	private void table_LeaveRequest_MousePressed(MouseEvent e) {
		ccb_RQLeaveShowAction.removeAllItems();
		ccb_RQLeaveShowHR.removeAllItems();
		int selectedRow = table_LeaveRequest.getSelectedRow();
		var idrequest = (Integer) table_LeaveRequest.getValueAt(selectedRow, 0);
		int idemp = rqlbao.selectidemp(idrequest).getIdemp();
		var rql = rqlbao.selectidemp(idrequest);
		var emp = empb.getacc(idemp);
		lbl_RQLShowIDRQ.setText(Integer.toString(idrequest));
		lbl_RQLeaveShowName.setText(emp.getFullname());
		var depbao = new DepartmentBao();
		lbl_RQLeaveShowDepart.setText(depbao.getdep(emp.getIddep()).getNamedep());
		lbl_RQLeaveShowFromDate.setText(rql.getFromdate().toString());
		lbl_RQLeaveShowtoDate.setText(rql.getTodate().toString());
		lbl_RQLeaveShowNoteShift.setText(Integer.toString(rql.getNote()));
		lblNewLabel_74.setText(rql.getDeadline().toString());
		String reason = null;
		if (rql.getAnnualleave() != 0) {
			reason = "Annual Leave";
		}
		if (rql.getSickleave() != 0) {
			reason = "Sick Leave";
		}
		if (rql.getUnpaidleave() != 0) {
			reason = "Unpaid Leave";
		}
		lbl_RQLeaveShowreason.setText(reason);
		switch (rql.getSttrequestleave()) {
		case 0 -> {
			ccb_RQLeaveShowAction.addItem("Admin Refused");
		}

		case 1 -> {
			ccb_RQLeaveShowAction.addItem("Confirm And Escalate To HR");
			ccb_RQLeaveShowAction.addItem("Reject This Request");
		}
		case 2 -> {
			ccb_RQLeaveShowAction.addItem("Waiting Update Employee's leave");
		}
		case 3 -> {
			ccb_RQLeaveShowAction.addItem("Waiting Update Calendar");
			ccb_RQLeaveShowAction.addItem("Update in Calendar");
		}
		case 4 -> ccb_RQLeaveShowAction.addItem("Complete");
		default -> ccb_RQLeaveShowAction.addItem("Out Of Deadline");
		}
		empb.getHR().forEach(emplhr -> ccb_RQLeaveShowHR.addItem(emplhr.getFullname()));
		loaddatatoShowlic();
	}

	private void actioncbbrqleave() {
		var action = (String) ccb_RQLeaveShowAction.getSelectedItem();
		if (action != null) {
			if (action.equals("Admin Refused") || action.equals("Complete")
					|| action.equals("Waiting Update Employee's leave") || action.equals("Waiting Update Calendar")
					|| action.equals("Out Of Deadline")) {
				ccb_RQLeaveShowHR.setVisible(false);
				lblNewLabel_21.setVisible(false);
				btn_RQLeaveSubmit.setVisible(false);
			} else if (action.equals("Update in Calendar") || action.equals("Reject This Request")) {
				btn_RQLeaveSubmit.setVisible(true);
				ccb_RQLeaveShowHR.setVisible(false);
				lblNewLabel_21.setVisible(false);
			} else {
				ccb_RQLeaveShowHR.setVisible(true);
				lblNewLabel_21.setVisible(true);
				btn_RQLeaveSubmit.setVisible(true);
			}
		}
	}
	// ================== report===================

	private void ShowpanelHLDreport() {
		int month = cbb_report_showmonth.getSelectedIndex() + 1;
		var i = atdbao.checkexist(month, 1);
		var j = atdbao.checkexist(month, 2);
		if (i == 0 && j == 0) {
			lblNewLabel_35.setVisible(false);
			lblNewLabel_36.setVisible(false);
			lblNewLabel_37.setVisible(false);
			lblNewLabel_38.setVisible(false);
			lbl_FromHL.setVisible(false);
			lbl_ToHL.setVisible(false);
			lbl_FromoffHL.setVisible(false);
			lbl_ToOffHL.setVisible(false);
		}
		if (i > 0 && j == 0) {

			lblNewLabel_35.setVisible(true);
			lblNewLabel_36.setVisible(true);
			lbl_FromHL.setVisible(true);
			lbl_ToHL.setVisible(true);
			lblNewLabel_37.setVisible(false);
			lblNewLabel_38.setVisible(false);
			lbl_FromoffHL.setVisible(false);
			lbl_ToOffHL.setVisible(false);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			lbl_FromHL.setText(formatter.format(atdbao.getFromDate(month, 1)));
			lbl_ToHL.setText(formatter.format(atdbao.getToDate(month, 1)));
		}
		if (i == 0 && j > 0) {
			lblNewLabel_35.setVisible(true);
			lblNewLabel_36.setVisible(true);
			lbl_FromHL.setVisible(false);
			lbl_ToHL.setVisible(false);
			lblNewLabel_37.setVisible(true);
			lblNewLabel_38.setVisible(true);
			lbl_FromoffHL.setVisible(true);
			lbl_ToOffHL.setVisible(true);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			lbl_FromoffHL.setText(formatter.format(atdbao.getFromDate(month, 2)));
			lbl_ToOffHL.setText(formatter.format(atdbao.getToDate(month, 2)));
		}
		if (i > 0 && j > 0) {
			lblNewLabel_35.setVisible(true);
			lblNewLabel_36.setVisible(true);
			lblNewLabel_37.setVisible(true);
			lblNewLabel_38.setVisible(true);
			lbl_FromHL.setVisible(true);
			lbl_ToHL.setVisible(true);
			lbl_FromoffHL.setVisible(true);
			lbl_ToOffHL.setVisible(true);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			lbl_FromoffHL.setText(formatter.format(atdbao.getFromDate(month, 2)));
			lbl_ToOffHL.setText(formatter.format(atdbao.getToDate(month, 2)));
			lbl_FromHL.setText(formatter.format(atdbao.getFromDate(month, 1)));
			lbl_ToHL.setText(formatter.format(atdbao.getToDate(month, 1)));
		}
	}

	private static Date mindate(int month) {
		Calendar cal = Calendar.getInstance();
		int thisyear = cal.get(Calendar.YEAR);
		var strd = thisyear + "-" + month + "-" + 01;
		Date mindate = null;
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			mindate = formatter1.parse(strd);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mindate;
	}

	private static Date maxdate(int month) {
		Calendar cal = Calendar.getInstance();
		int thisyear = cal.get(Calendar.YEAR);
		String y = Integer.toString(thisyear);
		String m = Integer.toString(month);
		String d = Integer.toString(01);
		var strd = (y + "-" + m + "-" + d);
		Date date = null;
		SimpleDateFormat formatter1 = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = formatter1.parse(strd);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		cal.setTime(date);
		cal.set(Calendar.DATE, cal.getActualMaximum(Calendar.DATE));
		Date maxdate = cal.getTime();
		return maxdate;
	}

	public Date convertdate(String dateInString) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = formatter.parse(dateInString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new java.sql.Date(date.getTime());
	}

	private void insertMonthlyReport() {
		int month = cbb_report_showmonth.getSelectedIndex() + 1;

		var nghile = atdbao.checkexist(month, 1);
		var nghibu = atdbao.checkexist(month, 2);
		if (nghile == 0 && nghibu == 0) {
			attendMonth.inserttotableNoHL(month);
			attendMonth.update(month);
			JOptionPane.showMessageDialog(this, "Generate Report Successfully");

		}
		if (nghile > 0 && nghibu == 0) {
			var fromHL = convertdate(lbl_FromHL.getText());
			var toHL = convertdate(lbl_ToHL.getText());
			attendMonth.inserttotableOnlyHL(month, fromHL, toHL);
			attendMonth.update(month);
			JOptionPane.showMessageDialog(this, "Generate Report Successfully");
		}
		if (nghile == 0 && nghibu > 0) {
			var fromnghibu = convertdate(lbl_FromoffHL.getText());
			var tonghibu = convertdate(lbl_ToOffHL.getText());
			attendMonth.inserttotableOnlyNghiBu(month, fromnghibu, tonghibu);
			attendMonth.update(month);
			JOptionPane.showMessageDialog(this, "Generate Report Successfully");
		}
		if (nghile > 0 && nghibu > 0) {
			var fromHL = convertdate(lbl_FromHL.getText());
			var toHL = convertdate(lbl_ToHL.getText());
			var fromnghibu = convertdate(lbl_FromoffHL.getText());
			var tonghibu = convertdate(lbl_ToOffHL.getText());
			attendMonth.inserttotableHL(month, fromHL, toHL, fromnghibu, tonghibu);
			attendMonth.update(month);
			JOptionPane.showMessageDialog(this, "Generate Report Successfully");
		}

	}

	protected void cbb_report_showmonthActionPerformed(ActionEvent e) {
		ShowpanelHLDreport();
	}

	private void btn_createReportActionPerformed(ActionEvent e) {
		int month = cbb_report_showmonth.getSelectedIndex() + 1;
		attendMonth.deletereport(month);
		insertMonthlyReport();
		show_table_reportbymonthly(month);

	}

	private void show_table_reportbymonthly(int month) {

		DefaultTableModel model = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model.addColumn("IDEMP");
		model.addColumn("FULLNAME");
		model.addColumn("MONTH");
		model.addColumn("TL TIMEKEEPING");
		model.addColumn("TL WORK HL");
		model.addColumn("TL WORK OFF DAY");
		model.addColumn("TL SHIFT 3");
		model.addColumn("TL SHIFT 4");
		model.addColumn("TL WORK FULL DAY");
		model.addColumn("TL OT ON DAY");
		model.addColumn("TL OT OFF DAY");
		model.addColumn("TL OT HL");
		model.addColumn("TL OT OFF HL");
		model.addColumn("VALIDREASON1");
		model.addColumn("VALIDREASON2");
		model.addColumn("TL SALARY DEDUCTION");

		attendMonth.getListAttend(month)
				.forEach(atd -> model.addRow(new Object[] { atd.getIdemp(), empb.getacc(atd.getIdemp()).getFullname(),
						atd.getMonth(), atd.getTotaltimekeeping(), atd.getTotalworkHL(), atd.getTotalworkoffday(),
						atd.getTotalshift3(), atd.getTotalshift4(), atd.getTotalworkfullday(), atd.getTotalOTonday(),
						atd.getTotalOToffday(), atd.getTotalOTHL(), atd.getTotalOToffHL(), atd.getValidreason1(),
						atd.getValidreason2(), atd.getTotalsalarydeduction() }));

		table_reportbymonthly.setModel(model);
		table_reportbymonthly.getTableHeader().setReorderingAllowed(false);

	}

	// ================================= attendace employee

	private void searname() {
		var Stringname = textField_name_reportbyemp.getText().trim();
		var mes = helper.Validation.MessErrorSearchNameXuan(Stringname);
		if (mes.equals("")) {
			var depbao = new DepartmentBao();
			DefaultTableModel model = new DefaultTableModel() {
				@Override
				public boolean isCellEditable(int row, int column) {
					return false;
				}
			};

			model.addColumn("ID EMP");
			model.addColumn("FULL NAME");
			model.addColumn("DEPARTMENT");

			empb.showSearchEmpName(Stringname).forEach(emp -> model.addRow(
					new Object[] { emp.getIdemp(), emp.getFullname(), depbao.getdep(emp.getIddep()).getNamedep() }));

			table_searchEmp.setModel(model);
			table_searchEmp.getTableHeader().setReorderingAllowed(false);

		} else {
			JOptionPane.showMessageDialog(this, mes + "\n" + "Please Try Again!!", "OPS!!!", JOptionPane.ERROR_MESSAGE);
		}

	}

	protected void btn_findEmpActionPerformed(ActionEvent e) {
		searname();
	}

	private void loaddatatotable_Show_Details_atdEmp() {
		if (table_searchEmp.getColumnCount() != 0) {
			DefaultTableModel model = (DefaultTableModel) table_searchEmp.getModel();
			model.getDataVector();
			var idemp = (Integer) model.getValueAt(table_searchEmp.getSelectedRow(), 0);
			var month = cbb_details_attd_emp.getSelectedIndex() + 1;
			datatotable_Show_Details_atdEmp(idemp, month);
			var slrbao = new SalaryBao();
			lbl_AL.setText(String.valueOf(slrbao.numberAL(idemp, month)));
			lbl_UL.setText(String.valueOf(slrbao.numberUL(idemp, month)));
			lbl_SL.setText(String.valueOf(slrbao.numberSL(idemp, month)));
		}

	}

	private void datatotable_Show_Details_atdEmp(int idemp, int month) {
		DefaultTableModel model1 = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model1.addColumn("IDEMP");
		model1.addColumn("FULLNAME");
		model1.addColumn("DATE");
		model1.addColumn("SEASON");
		model1.addColumn("SHIFT");
		model1.addColumn("CHECKIN TIME");
		model1.addColumn("CHECKOUT TIME");
		model1.addColumn("OT");
		model1.addColumn("REASON CHECKIN");
		model1.addColumn("REASON CHECKOUT");
		model1.addColumn("VALIDREASON");
		model1.addColumn("TIMEKEEPING BY DAY");

		atdbao.showDetailsAtdEmpbyMonth(idemp, month).forEach(atd -> model1.addRow(new Object[] { atd.getIdemp(),
				empb.getacc(atd.getIdemp()).getFullname(), atd.getDate(), (switch (atd.getSeasondate()) {
				case 0 -> "";
				case 1 -> "Work HL";
				case 2 -> "Work onCompensatory HL";
				case 3 -> "AL";
				case 4 -> "SL";
				case 5 -> "UL";
				case 6 -> "AL+SL";
				case 7 -> "AL+UL";
				case 8 -> "SL+AL";
				case 9 -> "SL+UL";
				case 10 -> "UL+AL";
				default -> "UL+SL";
				}),

				(atd.getIdShift() == 0 ? "OFF" : (Integer.toString(atd.getIdShift()))), atd.getCheckin(),
				atd.getCheckout(), atd.getReasoncheckin(), atd.getReasoncheckout(), (switch (atd.getValidreason()) {
				case 0 -> (atd.getReasoncheckin() != null || atd.getReasoncheckout() != null) ? "Waiting Check"
						: "Null";
				case 1 -> "Person Reson";
				case 2 -> "Will Charge";
				case 3 -> "Work Reason";
				default -> "Checked";
				}), atd.getOT(), atd.getTimekeepingbyday() }));

		table_Show_Details_atdEmp.setModel(model1);
		table_Show_Details_atdEmp.getTableHeader().setReorderingAllowed(false);

	}

	protected void table_searchEmpMousePressed(MouseEvent e) {
		loaddatatotable_Show_Details_atdEmp();
	}

	protected void cbb_details_attd_empActionPerformed(ActionEvent e) {
		loaddatatotable_Show_Details_atdEmp();
	}

	// ===========================
	protected void comboBox_2ActionPerformed(ActionEvent e) {
		show_table_show_atdby_month();
		showrcbm();
	}

	private void showrcbm() {
		int month = comboBox_2.getSelectedIndex() + 1;
		var i = atdbao.checkexist(month, 1);
		var j = atdbao.checkexist(month, 2);
		if (i == 0 && j == 0) {
			lblNewLabel_65.setVisible(false);
			lblNewLabel_66.setVisible(false);
			lblNewLabel_67.setVisible(false);
			lblNewLabel_68.setVisible(false);
			lblNewLabel_69.setVisible(false);
			lblNewLabel_70.setVisible(false);
			lblNewLabel_71.setVisible(false);
			lblNewLabel_72.setVisible(false);
		}
		if (i > 0 && j == 0) {

			lblNewLabel_65.setVisible(true);
			lblNewLabel_66.setVisible(true);
			lblNewLabel_67.setVisible(true);
			lblNewLabel_68.setVisible(true);
			lblNewLabel_69.setVisible(false);
			lblNewLabel_70.setVisible(false);
			lblNewLabel_71.setVisible(false);
			lblNewLabel_72.setVisible(false);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			lblNewLabel_66.setText(formatter.format(atdbao.getFromDate(month, 1)));
			lblNewLabel_68.setText(formatter.format(atdbao.getToDate(month, 1)));
		}
		if (i == 0 && j > 0) {
			lblNewLabel_65.setVisible(false);
			lblNewLabel_66.setVisible(false);
			lblNewLabel_67.setVisible(false);
			lblNewLabel_68.setVisible(false);
			lblNewLabel_69.setVisible(true);
			lblNewLabel_70.setVisible(true);
			lblNewLabel_71.setVisible(true);
			lblNewLabel_72.setVisible(true);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			lblNewLabel_70.setText(formatter.format(atdbao.getFromDate(month, 2)));
			lblNewLabel_72.setText(formatter.format(atdbao.getToDate(month, 2)));
		}
		if (i > 0 && j > 0) {
			lblNewLabel_65.setVisible(true);
			lblNewLabel_66.setVisible(true);
			lblNewLabel_67.setVisible(true);
			lblNewLabel_68.setVisible(true);
			lblNewLabel_69.setVisible(true);
			lblNewLabel_70.setVisible(true);
			lblNewLabel_71.setVisible(true);
			lblNewLabel_72.setVisible(true);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			lblNewLabel_66.setText(formatter.format(atdbao.getFromDate(month, 1)));
			lblNewLabel_68.setText(formatter.format(atdbao.getToDate(month, 1)));
			lblNewLabel_70.setText(formatter.format(atdbao.getFromDate(month, 2)));
			lblNewLabel_72.setText(formatter.format(atdbao.getToDate(month, 2)));
		}
	}

	private void show_table_show_atdby_month() {
		var month = comboBox_2.getSelectedIndex() + 1;
		DefaultTableModel model1 = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		model1.addColumn("ID EMP");
		model1.addColumn("FULLNAME");
		model1.addColumn("DATE");
		model1.addColumn("SEASON");
		model1.addColumn("SHIFT");
		model1.addColumn("CHECK IN TIME");
		model1.addColumn("CHECK OUT TIME");
		model1.addColumn("OT");
		model1.addColumn("REASON CHECK IN");
		model1.addColumn("REASON CHECK OUT");
		model1.addColumn("VALIDREASON");
		model1.addColumn("TIMEKEPING BY DAY");
		model1.addColumn("WARNING");
		atdbao.showDetailsAtdEmpbyMonth(month).forEach(atd -> model1.addRow(new Object[] { atd.getIdemp(),
				empb.getacc(atd.getIdemp()).getFullname(), atd.getDate(), (switch (atd.getSeasondate()) {
				case 0 -> "";
				case 1 -> "Work HL";
				case 2 -> "Work onCompensatory HL";
				case 3 -> "AL";
				case 4 -> "SL";
				case 5 -> "UL";
				case 6 -> "AL+SL";
				case 7 -> "AL+UL";
				case 8 -> "SL+AL";
				case 9 -> "SL+UL";
				case 10 -> "UL+AL";
				default -> "UL+SL";
				}),

				(atd.getIdShift() == 0 ? "OFF" : (Integer.toString(atd.getIdShift()))), atd.getCheckin(),
				atd.getCheckout(), atd.getReasoncheckin(), atd.getReasoncheckout(), (switch (atd.getValidreason()) {
				case 0 -> (atd.getReasoncheckin() != null || atd.getReasoncheckout() != null) ? "Waiting Check" : "";
				case 1 -> "Person Reson";
				case 2 -> "Will Charge";
				case 3 -> "Work Reason";
				default -> "Checked";
				}), atd.getOT(), atd.getTimekeepingbyday(),
				atdbao.checkattd(atd.getDate()) == 0 ? "Not yet timekeeping " : ""

		}));

		table_show_atdby_month.setModel(model1);
		table_show_atdby_month.getTableHeader().setReorderingAllowed(false);
	}

	private void table_show_atdby_month(ActionEvent e) {
		DefaultTableModel model = (DefaultTableModel) table_show_atdby_month.getModel();
		model.getDataVector();
		var date = (Date) model.getValueAt(table_show_atdby_month.getSelectedRow(), 2);
		Opendate(date);
	}

	protected void table_show_atdby_monthMousePressed(MouseEvent e) {
		JPopupMenu menu2 = new JPopupMenu("menu");

		JMenuItem item4 = new JMenuItem("Open", 'O');
		item4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				table_show_atdby_month(e);
			}
		});
		menu2.add(item4);

		if (e.getButton() == MouseEvent.BUTTON3) {
			int r = table_show_atdby_month.rowAtPoint(e.getPoint());
			table_show_atdby_month.setRowSelectionInterval(r, r);
			menu2.show(table_show_atdby_month, e.getX(), e.getY());
		}
	}

	private void clearreport() {
		cbb_report_showmonth.setSelectedIndex(0);
		textField_name_reportbyemp.setText(null);
		cbb_details_attd_emp.setSelectedIndex(0);
		comboBox_2.setSelectedIndex(0);
		// ===
		DefaultTableModel m = (DefaultTableModel) table_reportbymonthly.getModel();
		m.getDataVector().removeAllElements();
		m.fireTableDataChanged();

		// ===
		DefaultTableModel m1 = (DefaultTableModel) table_searchEmp.getModel();
		m1.getDataVector().removeAllElements();
		m1.fireTableDataChanged();

		// ===

		DefaultTableModel m2 = (DefaultTableModel) table_Show_Details_atdEmp.getModel();
		m2.getDataVector().removeAllElements();
		m2.fireTableDataChanged();

		// ====
		DefaultTableModel m3 = (DefaultTableModel) table_show_atdby_month.getModel();
		m3.getDataVector().removeAllElements();
		m3.fireTableDataChanged();

	}

	// ================================XUAT RA EXCEL========================

	// ================================ATTENDANCE MONTHLY
	// REPORT========================

	// export Attendancemonthlyreport
	protected void btn_export_report_monthlyActionPerformed(ActionEvent e) {
		var attb = new AttendancemonthlyreportBao();
		var month = cbb_report_showmonth.getSelectedIndex();
		var MONTH = cbb_report_showmonth.getSelectedItem().toString();
		if (attb.checkMonth(month + 1)) {
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("Save file in ");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel File (*.xlsx)", "xlsx");
			jfc.setFileFilter(filter);
			jfc.setSelectedFile(new File("Attendancemonthlyreport-" + MONTH));
			int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				final List<Attendancemonthlyreport> listAttend = attb.getListAttend(month + 1);
				final String excelFilePath = jfc.getSelectedFile().toString() + ".xlsx";
				try {
					writeExcel_AttMonth(listAttend, excelFilePath);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, "Export success!");
			}
		} else {
			JOptionPane.showMessageDialog(this, "This month not exist in attendance record!");
		}
	}

	// export Attendance record detail employee
	protected void btn_export_atdance_empActionPerformed(ActionEvent e) {
		var attb = new AttendancerecordBao();
		DefaultTableModel model = (DefaultTableModel) table_searchEmp.getModel();
		model.getDataVector();
		var idemp = (Integer) model.getValueAt(table_searchEmp.getSelectedRow(), 0);
		var name = model.getValueAt(table_searchEmp.getSelectedRow(), 1);
		var month = cbb_details_attd_emp.getSelectedIndex();
		var MONTH = cbb_details_attd_emp.getSelectedItem().toString();
		if (attb.checkMonth(month + 1)) {
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("Save file in ");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel File (*.xlsx)", "xlsx");
			jfc.setFileFilter(filter);
			jfc.setSelectedFile(new File("Attendance detail-" + MONTH + "-" + name));
			int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				final List<Attendancerecord> detailAtt = attb.showDetailsAtdEmpbyMonth(idemp, month + 1);
				final String excelFilePath = jfc.getSelectedFile().toString() + ".xlsx";
				try {
					writeExcel_DetailAttEmp(detailAtt, excelFilePath);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, "Export success!");
			}
		} else {
			JOptionPane.showMessageDialog(this, "This month not exist in attendance record!");
		}
	}

	// export Attendance record detail month
	protected void btn_export_attd_monthlyActionPerformed(ActionEvent e) {
		var attb = new AttendancerecordBao();
		var month = comboBox_2.getSelectedIndex();
		var MONTH = comboBox_2.getSelectedItem().toString();
		if (attb.checkMonth(month + 1)) {
			JFileChooser jfc = new JFileChooser();
			jfc.setDialogTitle("Save file in ");
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel File (*.xlsx)", "xlsx");
			jfc.setFileFilter(filter);
			jfc.setSelectedFile(new File("Attendancemonthlyreport detail-" + MONTH));
			int returnValue = jfc.showSaveDialog(null);
			if (returnValue == JFileChooser.APPROVE_OPTION) {
				final List<Attendancerecord> detailAtt = attb.showDetailsAtdEmpbyMonth(month + 1);
				final String excelFilePath = jfc.getSelectedFile().toString() + ".xlsx";
				try {
					writeExcel_DetailAttEmp(detailAtt, excelFilePath);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(this, "Export success!");
			}
		} else {
			JOptionPane.showMessageDialog(this, "This month not exist in attendance record!");
		}
	}

	// Attendancemonthlyreport
	public static void writeExcel_AttMonth(List<Attendancemonthlyreport> listAttend, String excelFilePath)
			throws IOException {
		Workbook workbook = getWorkbook(excelFilePath);
		Sheet sheet = workbook.createSheet("Attendancemonthlyreport");
		int rowIndex = 0;
		// Write header
		writeHeader_AttMonth(sheet, rowIndex);
		// Write data
		rowIndex++;
		for (Attendancemonthlyreport list : listAttend) {
			// Create row
			Row row = sheet.createRow(rowIndex);
			// Write data on row
			writeBook_AttMonth(list, row, sheet);
			rowIndex++;
		}
		// Auto resize column witdth
		int numberOfColumn = sheet.getRow(0).getPhysicalNumberOfCells();
		autosizeColumn(sheet, numberOfColumn);
		// Create file excel
		createOutputFile(workbook, excelFilePath);
	}

	// Attendance record detail
	public static void writeExcel_DetailAttEmp(List<Attendancerecord> detailAtt, String excelFilePath)
			throws IOException {
		Workbook workbook = getWorkbook(excelFilePath);
		Sheet sheet = workbook.createSheet("Attendance record detail");
		int rowIndex = 0;
		// Write header
		writeHeader_DetailAttEmp(sheet, rowIndex);
		// Write data
		rowIndex++;
		for (Attendancerecord list : detailAtt) {
			// Create row
			Row row = sheet.createRow(rowIndex);
			// Write data on row
			writeBook_DetailAttEmp(list, row, sheet);
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

	// Write header Attendancemonthlyreport
	private static void writeHeader_AttMonth(Sheet sheet, int rowIndex) {
		// create CellStyle
		CellStyle cellStyle = createStyleForHeader(sheet);

		// Create row
		Row row = sheet.createRow(rowIndex);

		// Create cells
		Cell cell = row.createCell(0);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("ID Emp");

		cell = row.createCell(1);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Fullname");

		cell = row.createCell(2);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Department");

		cell = row.createCell(3);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Month");

		cell = row.createCell(4);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total timekeeping");

		cell = row.createCell(5);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total work Holiday");

		cell = row.createCell(6);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total work offay");

		cell = row.createCell(7);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total shift 3");

		cell = row.createCell(8);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total shift 4");

		cell = row.createCell(9);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total work fullday");

		cell = row.createCell(10);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total OT onday");

		cell = row.createCell(11);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total OT offday");

		cell = row.createCell(12);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total OT Holiday");

		cell = row.createCell(13);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total OT off Holiday");

		cell = row.createCell(14);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Valid reason 1");

		cell = row.createCell(15);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Valid reason 2");

		cell = row.createCell(16);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Total salary deduction");
	}

	// Write data Attendancemonthlyreport
	private static void writeBook_AttMonth(Attendancemonthlyreport listAttend, Row row, Sheet sheet) {
		var empb = new EmployeeBao();
		var deptb = new DepartmentBao();

		CellStyle cellstyle = createStyleForRow(sheet);
		CellStyle cellStyleData = createStyleDataCell(sheet);
		CellStyle cellStyleCurrency = createStyleCurrency(sheet);

		Cell cell = row.createCell(0);
		cell.setCellValue(listAttend.getIdemp());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(1);
		cell.setCellValue(empb.getacc(listAttend.getIdemp()).getFullname());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(2);
		cell.setCellValue(deptb.getdep(empb.getacc(listAttend.getIdemp()).getIddep()).getNamedep());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(3);
		cell.setCellValue(listAttend.getMonth());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(4);
		cell.setCellValue(listAttend.getTotaltimekeeping());
		cell.setCellStyle(cellStyleData);

		cell = row.createCell(5);
		cell.setCellValue(listAttend.getTotalworkHL());
		cell.setCellStyle(cellStyleData);

		cell = row.createCell(6);
		cell.setCellValue(listAttend.getTotalworkoffday());
		cell.setCellStyle(cellStyleData);

		cell = row.createCell(7);
		cell.setCellValue(listAttend.getTotalshift3());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(8);
		cell.setCellValue(listAttend.getTotalshift4());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(9);
		cell.setCellValue(listAttend.getTotalworkfullday());
		cell.setCellStyle(cellStyleData);

		cell = row.createCell(10);
		cell.setCellValue(listAttend.getTotalOTonday());
		cell.setCellStyle(cellStyleData);

		cell = row.createCell(11);
		cell.setCellValue(listAttend.getTotalOToffday());
		cell.setCellStyle(cellStyleData);

		cell = row.createCell(12);
		cell.setCellValue(listAttend.getTotalOTHL());
		cell.setCellStyle(cellStyleData);

		cell = row.createCell(13);
		cell.setCellValue(listAttend.getTotalOToffHL());
		cell.setCellStyle(cellStyleData);

		cell = row.createCell(14);
		cell.setCellValue(listAttend.getValidreason1());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(15);
		cell.setCellValue(listAttend.getValidreason2());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(16);
		cell.setCellValue(listAttend.getTotalsalarydeduction());
		cell.setCellStyle(cellStyleCurrency);
	}

	// Write header DetailAttEmp
	private static void writeHeader_DetailAttEmp(Sheet sheet, int rowIndex) {
		// create CellStyle
		CellStyle cellStyle = createStyleForHeader(sheet);

		// Create row
		Row row = sheet.createRow(rowIndex);

		// Create cells
		Cell cell = row.createCell(0);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("ID Emp");

		cell = row.createCell(1);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Fullname");

		cell = row.createCell(2);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Department");

		cell = row.createCell(3);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Date");

		cell = row.createCell(4);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Season date");

		cell = row.createCell(5);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Shift");

		cell = row.createCell(6);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Check in");

		cell = row.createCell(7);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Check out");

		cell = row.createCell(8);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Overtime");

		cell = row.createCell(9);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Reason check-in");

		cell = row.createCell(10);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Reason check-out");

		cell = row.createCell(11);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Valid reason");

		cell = row.createCell(12);
		cell.setCellStyle(cellStyle);
		cell.setCellValue("Timekeeping by day");
	}

	// Write data DetailAttEmp
	private static void writeBook_DetailAttEmp(Attendancerecord detailAtt, Row row, Sheet sheet) {
		var empb = new EmployeeBao();
		var deptb = new DepartmentBao();

		CellStyle cellstyle = createStyleForRow(sheet);
		CellStyle cellstyleDate = createStyleDateCell(sheet);
		CellStyle cellstyleData = createStyleDataCell(sheet);

		Cell cell = row.createCell(0);
		cell.setCellValue(detailAtt.getIdemp());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(1);
		cell.setCellValue(empb.getacc(detailAtt.getIdemp()).getFullname());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(2);
		cell.setCellValue(deptb.getdep(empb.getacc(detailAtt.getIdemp()).getIddep()).getNamedep());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(3);
		cell.setCellValue(detailAtt.getDate());
		cell.setCellStyle(cellstyleDate);

		cell = row.createCell(4);
		cell.setCellValue((switch (detailAtt.getSeasondate()) {
		case 0 -> "";
		case 1 -> "Work HL";
		case 2 -> "Work on Compensatory HL";
		case 3 -> "AL";
		case 4 -> "SL";
		case 5 -> "UL";
		case 6 -> "AL+SL";
		case 7 -> "AL+UL";
		case 8 -> "SL+AL";
		case 9 -> "SL+UL";
		case 10 -> "UL+AL";
		default -> "UL+SL";
		}));
		cell.setCellStyle(cellstyle);

		cell = row.createCell(5);
		cell.setCellValue(detailAtt.getIdShift() == 0 ? "OFF" : (Integer.toString(detailAtt.getIdShift())));
		cell.setCellStyle(cellstyle);

		cell = row.createCell(6);
		cell.setCellValue(String.valueOf(detailAtt.getCheckin()));
		cell.setCellStyle(cellstyle);

		cell = row.createCell(7);
		cell.setCellValue(String.valueOf(detailAtt.getCheckout()));
		cell.setCellStyle(cellstyle);

		cell = row.createCell(8);
		cell.setCellValue(detailAtt.getOT());
		cell.setCellStyle(cellstyleData);

		cell = row.createCell(9);
		cell.setCellValue(detailAtt.getReasoncheckin());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(10);
		cell.setCellValue(detailAtt.getReasoncheckout());
		cell.setCellStyle(cellstyle);

		cell = row.createCell(11);
		cell.setCellValue(switch (detailAtt.getValidreason()) {
		case 0 -> (detailAtt.getReasoncheckin() != null || detailAtt.getReasoncheckout() != null) ? "Waiting Check"
				: "Null";
		case 1 -> "Person Reson";
		case 2 -> "Will Charge";
		case 3 -> "Work Reason";
		default -> "Checked";
		});
		cell.setCellStyle(cellstyle);

		cell = row.createCell(12);
		cell.setCellValue(detailAtt.getTimekeepingbyday());
		cell.setCellStyle(cellstyleData);
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
		CreationHelper createHelper = sheet.getWorkbook().getCreationHelper();
		cellStyle.setFont(font);
		cellStyle.setBorderBottom(BorderStyle.DASHED);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		return cellStyle;
	}

	// Create CellStyle for date cell
	private static CellStyle createStyleDateCell(Sheet sheet) {
		// Create font
		org.apache.poi.ss.usermodel.Font font = sheet.getWorkbook().createFont();
		font.setFontName("Times New Roman");
		font.setFontHeightInPoints((short) 12); // font size
		font.setColor(IndexedColors.BLACK.getIndex()); // text color

		// Create CellStyle
		CellStyle cellStyle = sheet.getWorkbook().createCellStyle();
		CreationHelper createHelper = sheet.getWorkbook().getCreationHelper();
		cellStyle.setFont(font);
		cellStyle.setBorderBottom(BorderStyle.DASHED);
		cellStyle.setBorderRight(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-MM-dd"));
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
