package GUI;


import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.CheDo_BUS;
import BUS.NguoiDung_BUS;
import BUS.NhanVien_BUS;
import BUS.PhanQuyen_BUS;
import DAO.NguoiDung_DAO;
import DAO.NhanVien_DAO;
import DTO.NhanVien;
import DTO.PhanQuyen;

import java.awt.GridBagLayout;
import java.awt.Image;
import javax.swing.ImageIcon;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class NguoiDung extends JPanel {

	private TextFielAmination taiKhoan, tenNguoiDung, email, maNV, txtDiaChi, txtChucVu, txtNgaySinh, sdt, txtGioiTinh;
	private JTable table_1;
	private PassWordFielAmination  txtPswd;
	private DefaultTableModel model;
	private Color background = new Color(111, 211, 178);
	private BtnThem btnThem;
	private BtnSua btnSua;
	private BtnTimKiem btnTimKiem;
	private ButtonAmination btnPhanQuyen;
	private Object[] row = new Object[7];
	private JPanel panel_2, thanhCong, thatBai, panel_12;
	private JCheckBox chckMatKhau;
	private JButton temp;
	private ButtonAmination btnDongY;
	private boolean selectedTable = true;
	private ButtonAmination btnHuy;
	private JPanel panel_3;
	private ButtonAmination btnDoiMK;
	private JLabel lblNewLabel, lblThatBai, lblThanhCong;
	private Object[] column = {"STT", "Tài khoản", "Email", "Số điện thoại", "Tên người dùng", "Mã nhân viên", "Trạng thái"};
	private TextFielAmination txtTrangThai;
	private ArrayList<DTO.NguoiDung> dsNguoiDung = new ArrayList<DTO.NguoiDung>();
	private NguoiDung_BUS ndBUS = new NguoiDung_BUS();
	private NhanVien_BUS nvBUS = new NhanVien_BUS();
	private ArrayList<DTO.NhanVien> dsnv= new ArrayList<DTO.NhanVien>();
	private static int maNhanVien = 0;
	private static NhanVien nv = new NhanVien();
	private JPanel panel_4;
	private CardLayout card = new CardLayout();
	static boolean flagthem = false, flagthem_1 = false;
	static int i = 0;
	static int rowSelected = -1;
	private int maNVClick = 0;
	private boolean duocPhanQuyen = true;
	private boolean duocThemND = true;
	private boolean duocSua = true;
	private PhanQuyen_BUS phanQuyenBUS = new PhanQuyen_BUS();
	private static int maNVDNHT;
	private static String mkDN = "";
	private boolean cheDo = true;
	
	private Color txtColor = Color.white;

	public boolean isCheDo() {
		return cheDo;
	}


	public void setCheDo(boolean cheDo) {
		this.cheDo = cheDo;
	}
	public NguoiDung(int maNVDN) {
		
		CheDo_BUS cdBUS = new CheDo_BUS();
		cheDo = cdBUS.readClientList();
		
		maNVDNHT=maNVDN;
		
		ImageIcon scaledIcon_user= new ImageIcon(new ImageIcon(".\\img\\Daco_4363443.png")
				.getImage()
				.getScaledInstance(140, 140, Image.SCALE_DEFAULT));
		
		
		if (!cheDo) {
			CheDoMau mau = new CheDoMau();
			//background = mau.getMauPhuSang();
			background = mau.getMauPhuSang();
			txtColor = new Color(230, 230, 230);
		}
		
		setBackground(background);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 250, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{78, 30, 35, 35, 35, 35, 70, 250};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.2, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.09, 0.09, 0.09, 0.09, 0.08, 1.5};
		setLayout(gridBagLayout);
		
		JLabelAmination nguoi_dung_icon = new JLabelAmination(scaledIcon_user, JLabelAmination.CENTER);
		nguoi_dung_icon.setRaius(180);
		nguoi_dung_icon.setBackground(new Color(56, 207, 193));
		GridBagConstraints gbc_nguoi_dung_icon = new GridBagConstraints();
		gbc_nguoi_dung_icon.fill = GridBagConstraints.BOTH;
		gbc_nguoi_dung_icon.insets = new Insets(10, 10, 10, 5);
		gbc_nguoi_dung_icon.gridheight = 2;
		gbc_nguoi_dung_icon.gridx = 0;
		gbc_nguoi_dung_icon.gridy = 0;
		add(nguoi_dung_icon, gbc_nguoi_dung_icon);
		
		JLabel lblNewLabel_22 = new JLabel("Tài khoản: ");
		lblNewLabel_22.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
		gbc_lblNewLabel_22.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_22.insets = new Insets(0, 20, 5, 5);
		gbc_lblNewLabel_22.gridx = 1;
		gbc_lblNewLabel_22.gridy = 0;
		add(lblNewLabel_22, gbc_lblNewLabel_22);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(background);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 4;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 0.1};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0};
		panel_1.setLayout(gbl_panel_1);
		
		btnPhanQuyen = new ButtonAmination();
		btnPhanQuyen.setMinimumSize(new Dimension(240, 23));
		GridBagConstraints gbc_btnPhanQuyen = new GridBagConstraints();
		gbc_btnPhanQuyen.fill = GridBagConstraints.BOTH;
		gbc_btnPhanQuyen.insets = new Insets(10, 0, 5, 7);
		gbc_btnPhanQuyen.gridx = 1;
		gbc_btnPhanQuyen.gridy = 0;
		panel_1.add(btnPhanQuyen, gbc_btnPhanQuyen);
		btnPhanQuyen.setText("Phân quyền");
		
		JLabel lblNewLabel_23 = new JLabel("Mật khẩu:");
		lblNewLabel_23.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
		gbc_lblNewLabel_23.gridwidth = 2;
		gbc_lblNewLabel_23.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_23.gridx = 0;
		gbc_lblNewLabel_23.gridy = 1;
		panel_1.add(lblNewLabel_23, gbc_lblNewLabel_23);
		
		panel_3 = new JPanel();
		panel_3.setOpaque(false);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 10, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 1;
		add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 40};
		gbl_panel_3.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0};
		panel_3.setLayout(gbl_panel_3);
		
		taiKhoan = new TextFielAmination();
		taiKhoan.setRadius(10);
		taiKhoan.setMinimumSize(new Dimension(260, 30));
		taiKhoan.setColumns(10);
		
		GridBagConstraints gbc_taiKhoan = new GridBagConstraints();
		gbc_taiKhoan.gridwidth = 3;
		gbc_taiKhoan.fill = GridBagConstraints.BOTH;
		gbc_taiKhoan.insets = new Insets(0, 20, 0, 20);
		gbc_taiKhoan.gridx = 0;
		gbc_taiKhoan.gridy = 0;
		panel_3.add(taiKhoan, gbc_taiKhoan);
		
		panel_2 = new JPanel();
		panel_2.setBackground(background);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 4;
		gbc_panel_2.gridy = 1;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0};
		panel_2.setLayout(gbl_panel_2);
		
		txtPswd = new PassWordFielAmination();
		txtPswd.setRadius(10);
		disableJPassword(txtPswd);
		txtPswd.setMinimumSize(new Dimension(260, 32));
		txtPswd.setColumns(10);
		GridBagConstraints gbc_txtPswd = new GridBagConstraints();
		gbc_txtPswd.anchor = GridBagConstraints.NORTH;
		gbc_txtPswd.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtPswd.insets = new Insets(0, 20, 0, 20);
		gbc_txtPswd.gridx = 0;
		gbc_txtPswd.gridy = 0;
		panel_2.add(txtPswd, gbc_txtPswd);
		
		chckMatKhau = new JCheckBox("Hiện mật khẩu");
		chckMatKhau.setFocusable(false);
		chckMatKhau.setVisible(false);
		chckMatKhau.setBackground(background);
		GridBagConstraints gbc_chckMatKhau = new GridBagConstraints();
		gbc_chckMatKhau.fill = GridBagConstraints.VERTICAL;
		gbc_chckMatKhau.anchor = GridBagConstraints.WEST;
		gbc_chckMatKhau.gridx = 0;
		gbc_chckMatKhau.gridy = 1;
		panel_2.add(chckMatKhau, gbc_chckMatKhau);
		
		JLabel lblNewLabel_17 = new JLabel("Tên người dùng: ");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_17.gridx = 0;
		gbc_lblNewLabel_17.gridy = 2;
		add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		tenNguoiDung = new TextFielAmination();
		tenNguoiDung.setRadius(10);
		//tenNguoiDung.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenNguoiDung.setColumns(10);
		GridBagConstraints gbc_tenNguoiDung = new GridBagConstraints();
		gbc_tenNguoiDung.fill = GridBagConstraints.BOTH;
		gbc_tenNguoiDung.insets = new Insets(0, 20, 8, 20);
		gbc_tenNguoiDung.gridx = 1;
		gbc_tenNguoiDung.gridy = 2;
		add(tenNguoiDung, gbc_tenNguoiDung);
		
		JLabel lblNewLabel_21_3 = new JLabel("Số điện thoại: ");
		lblNewLabel_21_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_21_3 = new GridBagConstraints();
		gbc_lblNewLabel_21_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21_3.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21_3.gridx = 3;
		gbc_lblNewLabel_21_3.gridy = 2;
		add(lblNewLabel_21_3, gbc_lblNewLabel_21_3);
		
		sdt = new TextFielAmination();
		sdt.setRadius(10);
		sdt.setMinimumSize(new Dimension(0, 19));
		sdt.setMargin(new Insets(0, 4, 0, 0));
		//sdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sdt.setColumns(10);
		GridBagConstraints gbc_sdt = new GridBagConstraints();
		gbc_sdt.insets = new Insets(0, 20, 8, 20);
		gbc_sdt.fill = GridBagConstraints.BOTH;
		gbc_sdt.gridx = 4;
		gbc_sdt.gridy = 2;
		add(sdt, gbc_sdt);
		
		JLabel lblNewLabel_18 = new JLabel("Mã nhân viên: ");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_18.gridx = 0;
		gbc_lblNewLabel_18.gridy = 3;
		add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		maNV = new TextFielAmination();
		maNV.setRadius(10);
		maNV.setMargin(new Insets(0, 4, 0, 0));
		//maNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		maNV.setColumns(10);
		GridBagConstraints gbc_maNV = new GridBagConstraints();
		gbc_maNV.fill = GridBagConstraints.BOTH;
		gbc_maNV.insets = new Insets(0, 20, 8, 20);
		gbc_maNV.gridx = 1;
		gbc_maNV.gridy = 3;
		add(maNV, gbc_maNV);
		
		JLabel lblNewLabel_21 = new JLabel("Email: ");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21.gridx = 3;
		gbc_lblNewLabel_21.gridy = 3;
		add(lblNewLabel_21, gbc_lblNewLabel_21);
		
		email = new TextFielAmination();
		email.setRadius(10);
		email.setMinimumSize(new Dimension(0, 19));
		//email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email.setColumns(10);
		GridBagConstraints gbc_email = new GridBagConstraints();
		gbc_email.insets = new Insets(0, 20, 8, 20);
		gbc_email.fill = GridBagConstraints.BOTH;
		gbc_email.gridx = 4;
		gbc_email.gridy = 3;
		add(email, gbc_email);
		
		JLabel lblNewLabel_19 = new JLabel("Giới tính: ");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_19.insets = new Insets(0, 20, 5, 20);
		gbc_lblNewLabel_19.gridx = 0;
		gbc_lblNewLabel_19.gridy = 4;
		add(lblNewLabel_19, gbc_lblNewLabel_19);
		
		txtGioiTinh = new TextFielAmination();
		txtGioiTinh.setRadius(10);
		txtGioiTinh.setMinimumSize(new Dimension(0, 19));
		txtGioiTinh.setMargin(new Insets(0, 4, 0, 0));
		//txtGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtGioiTinh.setColumns(10);
		GridBagConstraints gbc_txtGioiTinh = new GridBagConstraints();
		gbc_txtGioiTinh.insets = new Insets(0, 20, 8, 20);
		gbc_txtGioiTinh.fill = GridBagConstraints.BOTH;
		gbc_txtGioiTinh.gridx = 1;
		gbc_txtGioiTinh.gridy = 4;
		add(txtGioiTinh, gbc_txtGioiTinh);
		txtGioiTinh.setColumns(10);
		
		JLabel lblNewLabel_21_1 = new JLabel("Địa chỉ: ");
		lblNewLabel_21_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_21_1 = new GridBagConstraints();
		gbc_lblNewLabel_21_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21_1.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21_1.gridx = 3;
		gbc_lblNewLabel_21_1.gridy = 4;
		add(lblNewLabel_21_1, gbc_lblNewLabel_21_1);
		
		txtDiaChi = new TextFielAmination();
		txtDiaChi.setRadius(10);
		txtDiaChi.setMinimumSize(new Dimension(0, 19));
		txtDiaChi.setMargin(new Insets(0, 4, 0, 0));
		//txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDiaChi.setColumns(10);
		GridBagConstraints gbc_txtDiaChi = new GridBagConstraints();
		gbc_txtDiaChi.fill = GridBagConstraints.BOTH;
		gbc_txtDiaChi.insets = new Insets(0, 20, 8, 20);
		gbc_txtDiaChi.gridx = 4;
		gbc_txtDiaChi.gridy = 4;
		add(txtDiaChi, gbc_txtDiaChi);
		
		JLabel lblNewLabel_20 = new JLabel("Ngày sinh: ");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_20.insets = new Insets(0, 20, 5, 20);
		gbc_lblNewLabel_20.gridx = 0;
		gbc_lblNewLabel_20.gridy = 5;
		add(lblNewLabel_20, gbc_lblNewLabel_20);
		
		txtNgaySinh = new TextFielAmination();
		txtNgaySinh.setRadius(10);
		txtNgaySinh.setMargin(new Insets(0, 4, 0, 0));
		txtNgaySinh.setColumns(10);
		GridBagConstraints gbc_txtNgaySinh = new GridBagConstraints();
		gbc_txtNgaySinh.fill = GridBagConstraints.BOTH;
		gbc_txtNgaySinh.insets = new Insets(0, 20, 8, 20);
		gbc_txtNgaySinh.gridx = 1;
		gbc_txtNgaySinh.gridy = 5;
		add(txtNgaySinh, gbc_txtNgaySinh);
		
		model=new DefaultTableModel();
		
		model.setColumnIdentifiers(column);
		
		JLabel lblNewLabel_21_2 = new JLabel("Chức vụ: ");
		lblNewLabel_21_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_21_2 = new GridBagConstraints();
		gbc_lblNewLabel_21_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21_2.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21_2.gridx = 3;
		gbc_lblNewLabel_21_2.gridy = 5;
		add(lblNewLabel_21_2, gbc_lblNewLabel_21_2);
		
		txtChucVu = new TextFielAmination();
		txtChucVu.setRadius(10);
		txtChucVu.setMinimumSize(new Dimension(0, 19));
		txtChucVu.setMargin(new Insets(0, 4, 0, 0));
		//txtChucVu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtChucVu.setColumns(10);
		GridBagConstraints gbc_txtChucVu = new GridBagConstraints();
		gbc_txtChucVu.fill = GridBagConstraints.BOTH;
		gbc_txtChucVu.insets = new Insets(0, 20, 8, 20);
		gbc_txtChucVu.gridx = 4;
		gbc_txtChucVu.gridy = 5;
		add(txtChucVu, gbc_txtChucVu);
		
		JPanel panel = new JPanel();
		panel.setBackground(background);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(7, 7, 5, 10);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{133, 140, 90, 85, 95, 80, 75};
		gbl_panel.rowHeights = new int[]{27, 23};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 1.0, 0.40, 0.37, 0.35};
		gbl_panel.rowWeights = new double[]{1.0, 1.0};
		panel.setLayout(gbl_panel);
		
		lblNewLabel = new JLabel("Trạng thái : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		txtTrangThai = new TextFielAmination();
		disableJTextField(txtTrangThai);
		//txtTrangThai.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_txtTrangThai = new GridBagConstraints();
		gbc_txtTrangThai.insets = new Insets(3, 40, 3, 5);
		gbc_txtTrangThai.fill = GridBagConstraints.BOTH;
		gbc_txtTrangThai.gridx = 1;
		gbc_txtTrangThai.gridy = 0;
		panel.add(txtTrangThai, gbc_txtTrangThai);
		txtTrangThai.setColumns(10);
		
		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridheight = 2;
		gbc_panel_4.gridwidth = 2;
		gbc_panel_4.gridheight = 2;
		gbc_panel_4.gridwidth = 2;
		gbc_panel_4.insets = new Insets(10, 10, 10, 10);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 0;
		panel.add(panel_4, gbc_panel_4);
		panel_4.setLayout(card);
		
		GridBagLayout gbl_thatBai_1 = new GridBagLayout();
		gbl_thatBai_1.columnWidths = new int[]{0};
		gbl_thatBai_1.rowHeights = new int[]{0};
		gbl_thatBai_1.columnWeights = new double[]{1.0};
		gbl_thatBai_1.rowWeights = new double[]{1.0};
		
		JPanel panel_12 = new JPanel();
		panel_12.setOpaque(false);
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.gridheight = 2;
		gbc_panel_12.gridwidth = 2;
		gbc_panel_12.insets = new Insets(0, 0, 0, 0);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 0;
		panel_4.add(panel_12, "khong");
		
		thanhCong = new JPanel();
		thanhCong.setBorder(new LineBorder(new Color(0, 128, 0), 2));
		thanhCong.setBackground(new Color(0, 255, 0));
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.gridheight = 2;
		gbc_panel_10.gridwidth = 2;
		gbc_panel_10.insets = new Insets(0, 0, 0, 0);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 0;
		panel_4.add(thanhCong, "themThanhCong");
		thanhCong.setLayout(gbl_thatBai_1);
		
		lblThanhCong = new JLabel("Thêm thành công!");
		lblThanhCong.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblThanhCong = new GridBagConstraints();
		gbc_lblThanhCong.gridx = 0;
		gbc_lblThanhCong.gridy = 0;
		thanhCong.add(lblThanhCong, gbc_lblThanhCong);
		
		
		thatBai = new JPanel();
		thatBai.setBorder(new LineBorder(new Color(178, 34, 34), 2));
		thatBai.setBackground(new Color(250, 128, 114));
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.gridheight = 2;
		gbc_panel_11.gridwidth = 2;
		gbc_panel_11.insets = new Insets(0, 0, 5, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		panel_4.add(thatBai, "themThatBai");
		GridBagLayout gbl_thatBai = new GridBagLayout();
		gbl_thatBai.columnWidths = new int[]{0};
		gbl_thatBai.rowHeights = new int[]{0};
		gbl_thatBai.columnWeights = new double[]{1.0};
		gbl_thatBai.rowWeights = new double[]{1.0};
		thatBai.setLayout(gbl_thatBai);
		
		lblThatBai = new JLabel("Thêm thất bại!");
		lblThatBai.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblThatBai = new GridBagConstraints();
		gbc_lblThatBai.gridx = 0;
		gbc_lblThatBai.gridy = 0;
		thatBai.add(lblThatBai, gbc_lblThatBai);
		
		card.show(panel_4, "khong");
		 
		
		btnTimKiem = new BtnTimKiem();
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 4;
		gbc_btnNewButton_3.gridy = 0;
		panel.add(btnTimKiem, gbc_btnNewButton_3);
		
		btnThem = new BtnThem();
		GridBagConstraints gbc_btnThem= new GridBagConstraints();
		gbc_btnThem.fill = GridBagConstraints.BOTH;
		gbc_btnThem.insets = new Insets(0, 0, 5, 5);
		gbc_btnThem.gridx = 5;
		gbc_btnThem.gridy = 0;
		panel.add(btnThem, gbc_btnThem);
		
		btnSua = new BtnSua();
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnSua, gbc_btnNewButton_1);
		
		panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.gridwidth = 5;
		gbc_panel_5.insets = new Insets(0, 0, 0, 2);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 7;
		add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0};
		gbl_panel_5.rowHeights = new int[]{0};
		gbl_panel_5.columnWeights = new double[]{1.0};
		gbl_panel_5.rowWeights = new double[]{1.0};
		panel_5.setLayout(gbl_panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new CompoundBorder(new LineBorder(new Color(196, 223, 215), 2), new LineBorder(new Color(170, 170, 170), 1)));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_5.add(scrollPane, gbc_scrollPane);
		
		table_1 = new JTable();
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		
		taiKhoan.setBorder(new EmptyBorder(5, 14, 5, 10));
		txtPswd.setBorder(new EmptyBorder(5, 14, 5, 20));
		tenNguoiDung.setBorder(new EmptyBorder(0, 11, 0, 5));
		email.setBorder(new EmptyBorder(0, 11, 0, 5));
		maNV.setBorder(new EmptyBorder(0, 11, 0, 5));
		txtDiaChi.setBorder(new EmptyBorder(0, 11, 0, 5));
		txtChucVu.setBorder(new EmptyBorder(0, 11, 0, 5));
		txtNgaySinh.setBorder(new EmptyBorder(0, 11, 0, 5));
		sdt.setBorder(new EmptyBorder(0, 11, 0, 5));
		txtGioiTinh.setBorder(new EmptyBorder(0, 11, 0, 5));
		
		taiKhoan.setBackground(txtColor);
		tenNguoiDung.setBackground(txtColor);
		email.setBackground(txtColor);
		maNV.setBackground(txtColor);
		txtDiaChi.setBackground(txtColor);
		txtChucVu.setBackground(txtColor);
		txtNgaySinh.setBackground(txtColor);
		sdt.setBackground(txtColor);
		txtGioiTinh.setBackground(txtColor);
		
		
		disableJTextField(txtNgaySinh);
		disableJTextField(txtChucVu);
		disableJTextField(txtDiaChi);
		disableJTextField(tenNguoiDung);
		disableJTextField(maNV);
		disableJTextField(sdt);
		disableJTextField(email);
		disableJTextField(taiKhoan);
		
		btnDoiMK = new ButtonAmination();
		btnDoiMK.setText("Đổi mật khẩu");
		GridBagConstraints gbc_btnDoiMK = new GridBagConstraints();
		gbc_btnDoiMK.fill = GridBagConstraints.BOTH;
		gbc_btnDoiMK.insets = new Insets(10, 20, 0, 5);
		gbc_btnDoiMK.gridx = 0;
		gbc_btnDoiMK.gridy = 1;
		panel_3.add(btnDoiMK, gbc_btnDoiMK);
		
		disableJTextField(txtGioiTinh);
		
		if (table_1.getSelectedRow() == -1) {
			btnSua.setEnabled(false);
		}
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		for (int i = 0; i < 7; i++)
			table_1.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		
		table_1.getColumnModel().getColumn(0).setPreferredWidth(40);
		table_1.getColumnModel().getColumn(0).setMinWidth(35);
		table_1.getColumnModel().getColumn(0).setMaxWidth(150);

		table_1.getColumnModel().getColumn(1).setPreferredWidth(70);
		table_1.getColumnModel().getColumn(2).setPreferredWidth(130);
		table_1.getColumnModel().getColumn(3).setPreferredWidth(125);
		table_1.getColumnModel().getColumn(3).setMinWidth(35);
		table_1.getColumnModel().getColumn(3).setMaxWidth(245);
		
		table_1.getColumnModel().getColumn(4).setPreferredWidth(55);
		table_1.getColumnModel().getColumn(5).setPreferredWidth(90);
		table_1.getColumnModel().getColumn(5).setMinWidth(35);
		table_1.getColumnModel().getColumn(5).setMaxWidth(200);
		
		table_1.getColumnModel().getColumn(6).setPreferredWidth(120);
		table_1.getColumnModel().getColumn(6).setMinWidth(35);
		table_1.getColumnModel().getColumn(6).setMaxWidth(255);


		table_1.setDefaultEditor(Object.class, null);
		
		btnHuy = new ButtonAmination();
		btnHuy.setText("Hủy");
		GridBagConstraints gbc_btnHuy = new GridBagConstraints();
		gbc_btnHuy.fill = GridBagConstraints.BOTH;
		gbc_btnHuy.insets = new Insets(0, 0, 0, 5);
		gbc_btnHuy.gridx = 5;
		gbc_btnHuy.gridy = 1;
		panel.add(btnHuy, gbc_btnHuy);
		btnHuy.setEnabled(false);
		
		btnDongY = new ButtonAmination();
		btnDongY.setText("Đồng ý");
		GridBagConstraints gbc_btnDongY = new GridBagConstraints();
		gbc_btnDongY.fill = GridBagConstraints.BOTH;
		gbc_btnDongY.gridx = 6;
		gbc_btnDongY.gridy = 1;
		panel.add(btnDongY, gbc_btnDongY);
		
		btnDongY.setEnabled(false);
		
		if (!ndBUS.admin(maNVDN)) {
			duocPhanQuyen = false;
			PhanQuyen phanQuyen = new PhanQuyen();
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Thêm người dùng");
			if (phanQuyen == null) {
				duocThemND = false;
				btnThem.setEnabled(false);
			}
			
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Sửa người dùng");
			if (phanQuyen == null) {
				duocSua = false;
			}
		}
		
		btnPhanQuyen.setEnabled(false);
		
		table_1.setFocusable(false);
		hienThiDS(dsNguoiDung);
		
		btnDoiMK.setEnabled(false);
		
		addEvent();
		t.start();
		pause();
	}
	
	public void hienThiDS(ArrayList<DTO.NguoiDung> dsnd) {
		dsNguoiDung.clear();
		dsnv.clear();
		ndBUS.docDsnd();
		nvBUS.docDsnv();
		dsnd = ndBUS.getDsnd();
		dsnv = nvBUS.getDsnv();
		model.setRowCount(0);
		
		int x = 0;
		try {
			x = dsnd.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row[0] = i + 1;
			row[1] = dsnd.get(i).getTaiKhoan();
			row[2] = dsnd.get(i).getEmail();
			if (dsnv.get(i).getSdt() > 0) {
				row[3] = "0" + dsnv.get(i).getSdt();
			} else {
				row[3] = "";

			}
			row[4] = dsnv.get(i).getTenNV();
			row[5] = dsnv.get(i).getMaNV();
			row[6] = dsnv.get(i).getTrangThai();
			model.addRow(row);
		}
	}
	
	public void hienThiDS_1(ArrayList<DTO.NguoiDung> dsnd) {
		model.setRowCount(0);
		int x = 0;
		try {
			x = dsnd.size();
		} catch (Exception ex) {
			x = 0;
		}
		for (int i = 0; i < x; i++) {
			nv = nvBUS.timKiemMa(String.valueOf(dsnd.get(i).getMaNV()));
			row[0] = i + 1;
			row[1] = dsnd.get(i).getTaiKhoan();
			row[2] = dsnd.get(i).getEmail();
			if (dsnv.get(i).getSdt() > 0) {
				row[3] = "0" + dsnv.get(i).getSdt();
			} else {
				row[3] = "";

			}
			row[4] = dsnv.get(i).getTenNV();
			row[5] = dsnv.get(i).getMaNV();
			row[6] = dsnv.get(i).getTrangThai();
			model.addRow(row);
		}
	}
	
	
	public void addEvent() {
		
		btnDoiMK.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogDoiMatKhau dialog = new DialogDoiMatKhau(null, "Đổi mật khẩu", maNVDNHT);
				dialog.setModal(true);
				dialog.setLocationRelativeTo(TrangChinh.getFrames()[0]);
				dialog.setVisible(true);
			}
		});
		
		table_1.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int i = table_1.getSelectedRow();
				if (i < 0 || temp == btnThem) 
					btnSua.setEnabled(false);
				else {
					if (duocSua) {
						btnSua.setEnabled(true);
					}
				}
				
				
				if (i >= 0 && selectedTable) {
					
					nv = nvBUS.timKiemMa(model.getValueAt(i, 5).toString());
					
					try {
						taiKhoan.setText(model.getValueAt(i, 1).toString());
						}catch (Exception e1) {
							taiKhoan.setText("");
					}
					
					try {
						tenNguoiDung.setText(model.getValueAt(i, 4).toString());
					}catch (Exception e1) {
						tenNguoiDung.setText("");
					}
					
					try {
						email.setText(model.getValueAt(i, 2).toString());
					}catch (Exception e1) {
						email.setText("");
					}
					
					try {
						txtChucVu.setText(nv.getChucVu());
					}catch (Exception e1) {
						txtChucVu.setText("");
					}
					
					try {
						txtNgaySinh.setText(nv.getNgaySinh());
					}catch (Exception e1) {
						txtNgaySinh.setText("");
					}
					
					try {
						sdt.setText("0"+model.getValueAt(i, 3).toString());
					}catch (Exception e1) {
						sdt.setText("");
					}
					
					try {
						txtDiaChi.setText(nv.getDiaChi());
					}catch (Exception e1) {
						txtDiaChi.setText("");
					}
					
					try {
						maNV.setText(model.getValueAt(i, 5).toString());
					}catch (Exception e1) {
						maNV.setText("");
					}
					
					try {
						txtPswd.setText("********");
					}catch (Exception e1) {
						txtPswd.setText("");
					}
					
					try {
						txtGioiTinh.setText(nv.getGioiTinh());
					}catch (Exception e1) {
						txtGioiTinh.setText("");
					}
					
					try {
						txtTrangThai.setText(nv.getTrangThai());
					}catch (Exception e1) {
						txtTrangThai.setText("");
					}
					
					maNVClick = Integer.parseInt(maNV.getText());
					
					if (duocPhanQuyen)
						btnPhanQuyen.setEnabled(true);
					
					if (maNVClick == maNVDNHT)
						btnDoiMK.setEnabled(true);
					else
						btnDoiMK.setEnabled(false);
				}
			}
		});
		
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogThem dialog = new DialogThem(null, "Chọn nhân viên");
				ArrayList<DTO.NhanVien> dsnv= new ArrayList<DTO.NhanVien>();
				dsnv = ndBUS.dsNVHopLe();
				
				trongForm();
				if (dsnv != null) {
				dialog.setDsnv(dsnv);
				dialog.themNV();
				dialog.setModal(true);
				dialog.setLocationRelativeTo(TrangChinh.getFrames()[0]);
				dialog.setVisible(true);
				
				if (dialog.getMaNV() != -1) {
					maNhanVien = Integer.parseInt(String.valueOf(dialog.getMaNV()));
					
					disableJTextField(taiKhoan);
					disableJTextField(email);
					disableJTextField(tenNguoiDung);
					disableJTextField(maNV);
					btnSua.setEnabled(false);
					selectedTable = false;
					ableJTextField(email);
					ableJTextField(taiKhoan);
					ableJPassword(txtPswd);
					chckMatKhau.setVisible(true);
					maNV.setText(String.valueOf(dialog.getMaNV()));
					
					nv = nvBUS.timKiemMa(String.valueOf(dialog.getMaNV()));
					
					tenNguoiDung.setText(nv.getTenNV());
					txtGioiTinh.setText(nv.getGioiTinh());
					txtNgaySinh.setText(nv.getNgaySinh());
					sdt.setText("0" + String.valueOf(nv.getSdt()));
					txtDiaChi.setText(nv.getDiaChi());
					txtChucVu.setText(nv.getChucVu());
					txtTrangThai.setText(nv.getTrangThai());
					
					btnThem.setEnabled(false);
					btnDongY.setEnabled(true);
					btnHuy.setEnabled(true);
					temp = btnThem;
				}
				dialog.getBtnCancel().addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						System.out.println("ok la");
						temp = null;
					}
				});
				}
			}
		});
		
		maNV.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (temp == btnTimKiem) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						btnDongY.doClick();
		            }
				}
			}
		});
		
		taiKhoan.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if (temp == btnTimKiem) {
					if (e.getKeyCode() == KeyEvent.VK_ENTER) {
						btnDongY.doClick();
		            }
				}
			}
		});
		
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				selectedTable = false;
				rowSelected = table_1.getSelectedRow();
				disableJTextField(taiKhoan);
				disableJTextField(maNV);
				ableJTextField(email);
				temp = btnSua;
				btnDongY.setEnabled(true);
				btnHuy.setEnabled(true);
			}
		});
		
		chckMatKhau.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				if(chckMatKhau.isSelected()){
					txtPswd.setEchoChar((char)0);
				    }else{
				    	txtPswd.setEchoChar('*');
				    }
				
			}
		});
		
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				trongForm();
				temp = btnTimKiem;
				disableJPassword(txtPswd);
				ableJTextField(taiKhoan);
				ableJTextField(maNV);

				btnDongY.setEnabled(true);
				btnHuy.setEnabled(true);
				btnThem.setEnabled(false);
				
			}
		});
		
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trongForm();
				selectedTable = true;
				hienThiDS(dsNguoiDung);
				disableJTextField(email);
				disableJTextField(taiKhoan);
				disableJPassword(txtPswd);
				disableJTextField(tenNguoiDung);
				disableJTextField(maNV);
				btnHuy.setEnabled(false);
				btnDongY.setEnabled(false);
				if (duocThemND) {
					btnThem.setEnabled(true);
				}
				chckMatKhau.setVisible(false);
				btnSua.setEnabled(false);
				temp = null;
			}
		});
		
		btnDongY.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				if (temp == btnThem)
					xuLySuKienThem();
				
				if (temp == btnSua) {
					DTO.NguoiDung nd = new DTO.NguoiDung();
					nd.setMaNV(Integer.parseInt(model.getValueAt(rowSelected, 5).toString()));
					nd.setEmail(email.getText());
					
					if (ndBUS.suaND(nd)) {
						resum();

						disableJTextField(email);
						
						hienThiDS(dsNguoiDung);
						
						temp = null;
						btnDongY.setEnabled(false);
						btnHuy.setEnabled(false);
						lblThanhCong.setText("Sửa thành công!");
						flagthem = true;
						trongForm();
						selectedTable = true;
						
						
						
					} else {
						flagthem_1 = true;
						lblThatBai.setText("Sửa thất bại!");
					}
				}
				
				if (temp == btnTimKiem) {
					
					model.setRowCount(0);
					if (maNV.getText().trim().equals("") && !taiKhoan.getText().trim().equals("")) {
						ArrayList<DTO.NguoiDung> dsnd_1= new ArrayList<DTO.NguoiDung>();
						dsnd_1 = ndBUS.timKiemTK(taiKhoan.getText());
						if (dsnd_1 != null) {
							taiKhoan.setText("");
							maNV.setText("");
							hienThiDS_1(dsnd_1);
						}
					} else  if (taiKhoan.getText().trim().equals("") && !maNV.getText().trim().equals("")) {
						DTO.NguoiDung nd = new DTO.NguoiDung();
						ArrayList<DTO.NguoiDung> dsnd_1= new ArrayList<DTO.NguoiDung>();
						nd = ndBUS.timKiemMa(maNV.getText());
						if (nd != null) {
							dsnd_1.add(nd);
							hienThiDS_1(dsnd_1);
						}
					} else {
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
				                "Chỉ nhập tối đa 1 ô để tìm kiếm!",
				                "Thông báo!!!",
				                JOptionPane.WARNING_MESSAGE);
					}
					
				} 
			}
		});
		
		btnPhanQuyen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DialogPhanQuyen dialog = new DialogPhanQuyen(null, "Phân quyền", maNVClick);
				dialog.setModal(true);
				dialog.setLocationRelativeTo(TrangChinh.getFrames()[0]);
				dialog.setVisible(true);
			}
		});
	}
	
	public void xuLySuKienThem() {
		DTO.NguoiDung nd = new DTO.NguoiDung();
		nd.setMaNV(maNhanVien);
		nd.setTaiKhoan(taiKhoan.getText());
		nd.setMatKhau(String.valueOf(txtPswd.getPassword()));
		nd.setEmail(email.getText());
		
		if (ndBUS.themND(nd)) {
			resum();
			hienThiDS(dsNguoiDung);
			chckMatKhau.setVisible(false);
			txtPswd.setText("");
			disableJTextField(email);
			disableJTextField(taiKhoan);
			disableJPassword(txtPswd);
			if (duocThemND) {
				btnThem.setEnabled(true);
			}
			trongForm();
			selectedTable = true;
			
			temp = null;
			btnDongY.setEnabled(false);
			btnHuy.setEnabled(false);
			flagthem = true;
		} 
		
		
	}
	
	public void disableJTextField(TextFielAmination field) {
		field.setEditable(false);
		field.setEnabled(false);
		field.setBackground(background);
	}
	
	public void ableJTextField(TextFielAmination field) {
		field.setEditable(true);
		field.setEnabled(true);
		field.setBackground(txtColor);
	}
	
	public void disableJPassword(PassWordFielAmination field) {
		field.setEditable(false);
		field.setDisabledTextColor(Color.black);
		field.setEnabled(false);
		field.setBackground(background);
	}
	
	public void ableJPassword(PassWordFielAmination field) {
		field.setEditable(true);
		field.setEnabled(true);
		field.setBackground(txtColor);
	}
	
	public void trongForm() {
		taiKhoan.setText("");
		tenNguoiDung.setText("");
		email.setText("");
		maNV.setText("");
		txtDiaChi.setText("");
		txtChucVu.setText("");
		txtGioiTinh.setText("");
		txtTrangThai.setText("");
		txtNgaySinh.setText("");
		sdt.setText("");
		txtPswd.setText("");
	}
	
	public void xuLyTimKiem(String taiKhoan) {
		
		taiKhoan = taiKhoan.trim().toLowerCase();
		taiKhoan = taiKhoan.replaceAll("\\s+", " ");
		
		int size = table_1.getRowCount();
		
		for (int i = 0; i < size; i++){
			String taikhoan1 = table_1.getValueAt(i,1).toString();
			taikhoan1 = taikhoan1.trim().toLowerCase();
			taikhoan1 = taikhoan1.replaceAll("\\s+", " ");
			if (taikhoan1.indexOf(taiKhoan) == -1) {
			}
		}
	}
	
	public void xuLyTimKiem1(int maNV) {
		String ma = String.valueOf(maNV);
		ma = ma.trim().toLowerCase();
		ma = ma.replaceAll("\\s+", " ");
		
		maNV = Integer.parseInt(ma);
		
		int size = table_1.getRowCount();
		
		for (int i = 0; i < size; i++){
			int manv = Integer.parseInt(table_1.getValueAt(i,5).toString());
			if (manv == maNV) {
				table_1.setRowSelectionInterval(i, i);
			}
		}
	}
	
	public void resum() {
		t.resume();
	}
	
	public void pause() {
		t.suspend();
	}
	
	
	Thread t=new Thread() {
		public void run(){
    		while(true){
    			if (flagthem) {
    				i++;
        			card.show(panel_4, "themThanhCong");
        			if (i == 50) {
            			card.show(panel_4, "khong");
        				flagthem = false;
        				i=0;
        				pause();
        			}
        		}
    			
    			if (flagthem_1) {
    				i++;
        			card.show(panel_4, "themThatBai");
        			if (i == 50) {
            			card.show(panel_4, "khong");
        				flagthem_1 = false;
        				i=0;
        				pause();
        			}
        		}
    			
    			 try {
 					t.sleep(20);
 				} catch (InterruptedException e) {
 					e.printStackTrace();
 				}
    		}
        }
	};
	private JPanel panel_5;
}