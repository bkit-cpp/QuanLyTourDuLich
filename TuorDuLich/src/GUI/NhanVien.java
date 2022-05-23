package GUI;


import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.CheDo_BUS;
import BUS.NguoiDung_BUS;
import BUS.NhanVien_BUS;
import BUS.PhanQuyen_BUS;
import DAO.NhanVien_DAO;
import DTO.PhanQuyen;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Panel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.border.LineBorder;
import javax.swing.border.CompoundBorder;


public class NhanVien extends JPanel {

	private TextFielAmination tenNV, maNV, diaChi, ngaySinh, sdt;
	private Color background = new Color(111, 211, 178);
	private BtnThem btnThem;
	private BtnSua btnSua;
	private BtnTimKiem btnTimKiem;
	private JTable table_1;
	private DefaultTableModel model;
	private Object[] row = new Object[9];
	private Object[] column = {"STT", "Tên nhân viên", "Mã nhân viên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ", "Chức vụ", "Trạng thái"};
	private JComboBox gioiTinh, trangThai;
	private JButton temp;
	private ButtonAmination btnDongY, btnHuy;
	private boolean selectedTable = true;
	private JPanel panel_1, panel_3, panel_4, thanhCong, thatBai, panel_12, panel_2;
	private JLabel lblContent, lblNewLabel_21, lblThatBai, lblThanhCong;
	private static int rowSelected = 0;
	private CardLayout card = new CardLayout();
	static boolean flagthem = false, flagthem_1 = false;
	static int i = 0;
	private NhanVien_BUS nvBUS = new NhanVien_BUS();
	private NguoiDung_BUS ndBUS = new NguoiDung_BUS();
	private PhanQuyen_BUS phanQuyenBUS = new PhanQuyen_BUS();
	private ArrayList<DTO.NhanVien> dsnv= new ArrayList<DTO.NhanVien>();
	
	private boolean duocThem =  true;
	private boolean duocSua = true;
	
	private boolean laAdmin = false;
	
	private boolean cheDo = true;
	private Color txtColor = Color.white;

	

	
	public boolean isCheDo() {
		return cheDo;
	}


	public void setCheDo(boolean cheDo) {
		this.cheDo = cheDo;
	}


	public NhanVien(int maNVDN) {
		
		
		
		if (ndBUS.admin(maNVDN)) {
			laAdmin = true;
		}
		
		CheDo_BUS cdBUS = new CheDo_BUS();
		cheDo = cdBUS.readClientList();
		
		if (!cheDo) {
			CheDoMau mau = new CheDoMau();
			//background = mau.getMauPhuSang();
			background = mau.getMauPhuSang();
			txtColor = new Color(230, 230, 230);
		}
		
		setBackground(background);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{70, 0, 33, 33, 33, 33, 75, 260};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.1, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.15, 0.15, 0.15, 0.15, 0.09, 1.4};
		setLayout(gridBagLayout);
		
		panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.gridwidth = 7;
		gbc_panel_1.insets = new Insets(4, 4, 20, 4);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{1.0};
		gbl_panel_1.rowWeights = new double[]{1.0};
		panel_1.setLayout(gbl_panel_1);
		
		panel_3 = new JPanel();
		panel_3.setBackground(background);
		panel_3.setLayout(null);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(4, 4, 4, 4);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		
		lblContent = new JLabel("Chào Mừng Bạn Đến Với Quản lý nhân viên");
		lblContent.setBounds(36, 2, 633, 33);
		lblContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		panel_3.add(lblContent);
		
		JLabel lblNewLabel_17 = new JLabel("Tên nhân viên: ");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_17.insets = new Insets(0, 20, 5, 20);
		gbc_lblNewLabel_17.gridx = 0;
		gbc_lblNewLabel_17.gridy = 2;
		add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		tenNV = new TextFielAmination();
		tenNV.setRadius(10);
		//tenNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenNV.setColumns(10);
		
		GridBagConstraints gbc_tenNguoiDung = new GridBagConstraints();
		gbc_tenNguoiDung.fill = GridBagConstraints.BOTH;
		gbc_tenNguoiDung.insets = new Insets(0, 0, 8, 20);
		gbc_tenNguoiDung.gridx = 1;
		gbc_tenNguoiDung.gridy = 2;
		add(tenNV, gbc_tenNguoiDung);
		
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
		sdt.setMinimumSize(new Dimension(68, 19));
		sdt.setMargin(new Insets(0, 4, 0, 0));
		//sdt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sdt.setColumns(10);
		GridBagConstraints gbc_sdt = new GridBagConstraints();
		gbc_sdt.insets = new Insets(0, 0, 8, 20);
		gbc_sdt.fill = GridBagConstraints.BOTH;
		gbc_sdt.gridx = 4;
		gbc_sdt.gridy = 2;
		add(sdt, gbc_sdt);
		
		JLabel lblNewLabel_18 = new JLabel("Mã nhân viên: ");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_18.insets = new Insets(0, 20, 5, 20);
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
		gbc_maNV.insets = new Insets(0, 0, 8, 20);
		gbc_maNV.gridx = 1;
		gbc_maNV.gridy = 3;
		add(maNV, gbc_maNV);
		
		JLabel lblNewLabel_21_1 = new JLabel("Địa chỉ: ");
		lblNewLabel_21_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_21_1 = new GridBagConstraints();
		gbc_lblNewLabel_21_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21_1.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21_1.gridx = 3;
		gbc_lblNewLabel_21_1.gridy = 3;
		add(lblNewLabel_21_1, gbc_lblNewLabel_21_1);
		
		diaChi = new TextFielAmination();
		diaChi.setRadius(10);
		diaChi.setMinimumSize(new Dimension(0, 19));
		//diaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		diaChi.setColumns(10);
		GridBagConstraints gbc_diaChi = new GridBagConstraints();
		gbc_diaChi.fill = GridBagConstraints.BOTH;
		gbc_diaChi.insets = new Insets(0, 0, 8, 20);
		gbc_diaChi.gridx = 4;
		gbc_diaChi.gridy = 3;
		add(diaChi, gbc_diaChi);
		diaChi.setBorder(new EmptyBorder(0, 5, 0, 5));
		diaChi.setBackground(Color.white);
		
		JLabel lblNewLabel_19 = new JLabel("Giới tính: ");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_19.gridx = 0;
		gbc_lblNewLabel_19.gridy = 4;
		add(lblNewLabel_19, gbc_lblNewLabel_19);
		
		gioiTinh = new JComboBox();
		gioiTinh.setMinimumSize(new Dimension(65, 19));
		gioiTinh.setEnabled(false);
		gioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		GridBagConstraints gbc_gioiTinh = new GridBagConstraints();
		gbc_gioiTinh.fill = GridBagConstraints.VERTICAL;
		gbc_gioiTinh.anchor = GridBagConstraints.WEST;
		gbc_gioiTinh.insets = new Insets(0, 0, 5, 5);
		gbc_gioiTinh.gridx = 1;
		gbc_gioiTinh.gridy = 4;
		add(gioiTinh, gbc_gioiTinh);
		
		JLabel lblNewLabel_21_2 = new JLabel("Chức vụ: ");
		lblNewLabel_21_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_21_2 = new GridBagConstraints();
		gbc_lblNewLabel_21_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21_2.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21_2.gridx = 3;
		gbc_lblNewLabel_21_2.gridy = 4;
		add(lblNewLabel_21_2, gbc_lblNewLabel_21_2);
		
		chucVu = new JComboBox();
		chucVu.setModel(new DefaultComboBoxModel(new String[] {"Nhân viên", "Admin"}));
		GridBagConstraints gbc_chucVu = new GridBagConstraints();
		gbc_chucVu.fill = GridBagConstraints.VERTICAL;
		gbc_chucVu.anchor = GridBagConstraints.WEST;
		gbc_chucVu.insets = new Insets(0, 0, 5, 5);
		gbc_chucVu.gridx = 4;
		gbc_chucVu.gridy = 4;
		add(chucVu, gbc_chucVu);
		
		JLabel lblNewLabel_20 = new JLabel("Ngày sinh: ");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_20.insets = new Insets(0, 20, 5, 20);
		gbc_lblNewLabel_20.gridx = 0;
		gbc_lblNewLabel_20.gridy = 5;
		add(lblNewLabel_20, gbc_lblNewLabel_20);
		
		ngaySinh = new TextFielAmination();
		ngaySinh.setRadius(10);
		ngaySinh.setMinimumSize(new Dimension(68, 19));
		ngaySinh.setMargin(new Insets(0, 4, 0, 0));
		//ngaySinh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ngaySinh.setColumns(10);
		GridBagConstraints gbc_ngaySinh = new GridBagConstraints();
		gbc_ngaySinh.fill = GridBagConstraints.BOTH;
		gbc_ngaySinh.insets = new Insets(0, 0, 8, 20);
		gbc_ngaySinh.gridx = 1;
		gbc_ngaySinh.gridy = 5;
		add(ngaySinh, gbc_ngaySinh);
		
		model=new DefaultTableModel();
		model.setColumnIdentifiers(column);
		
		lblNewLabel_21 = new JLabel("Trạng thái : ");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21.gridx = 3;
		gbc_lblNewLabel_21.gridy = 5;
		add(lblNewLabel_21, gbc_lblNewLabel_21);
		
		trangThai = new JComboBox();
		trangThai.setFont(new Font("Tahoma", Font.BOLD, 14));
		trangThai.setModel(new DefaultComboBoxModel(new String[] {"Không hoạt động", "Hoạt động"}));
		trangThai.setMinimumSize(new Dimension(115, 19));
		GridBagConstraints gbc_trangThai = new GridBagConstraints();
		gbc_trangThai.fill = GridBagConstraints.VERTICAL;
		gbc_trangThai.anchor = GridBagConstraints.WEST;
		gbc_trangThai.insets = new Insets(0, 0, 5, 5);
		gbc_trangThai.gridx = 4;
		gbc_trangThai.gridy = 5;
		add(trangThai, gbc_trangThai);
		
		JPanel panel = new JPanel();
		panel.setBackground(background);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(7, 7, 5, 20);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{90, 90, 90, 90, 105, 90, 90};
		gbl_panel.rowHeights = new int[]{27, 23};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 0.3, 0.3, 0.3};
		gbl_panel.rowWeights = new double[]{1.0, 1.0};
		panel.setLayout(gbl_panel);
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.gridwidth = 2;
		gbc_panel_2.insets = new Insets(10, 10, 10, 10);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		panel_2.setLayout(card);
		
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
		gbc_panel_12.insets = new Insets(0, 0, 5, 5);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 0;
		panel_2.add(panel_12, "khong");
		
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
		panel_2.add(thanhCong, "themThanhCong");
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
		panel_2.add(thatBai, "themThatBai");
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
		
		card.show(panel_2, "khong");
		
		btnTimKiem = new BtnTimKiem();
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 4;
		gbc_btnNewButton_3.gridy = 0;
		panel.add(btnTimKiem, gbc_btnNewButton_3);
		
		btnThem = new BtnThem();
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnThem, gbc_btnNewButton);
		
		btnSua = new BtnSua();
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnSua, gbc_btnNewButton_1);
		
		panel_4 = new JPanel();
		//panel_4.setBorder(new CompoundBorder(new LineBorder(new Color(223, 255, 246), 2), new LineBorder(new Color(207, 235, 227), 2)));
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 0, 0);
		gbc_panel_4.gridwidth = 7;
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 7;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0};
		gbl_panel_4.rowHeights = new int[]{0};
		gbl_panel_4.columnWeights = new double[]{1.0};
		gbl_panel_4.rowWeights = new double[]{1.0};
		panel_4.setLayout(gbl_panel_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new CompoundBorder(new LineBorder(new Color(196, 223, 215), 2), new LineBorder(new Color(170, 170, 170), 1)));
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_panel_4.insets = new Insets(0, 0, 0, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_4.add(scrollPane, gbc_scrollPane);
		
		table_1 = new JTable();
		//table_1.setSelectionBackground(new Color(0, 255, 127));
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		
		tenNV.setBorder(new EmptyBorder(0, 5, 0, 5));
		maNV.setBorder(new EmptyBorder(0, 5, 0, 5));
		ngaySinh.setBorder(new EmptyBorder(0, 5, 0, 5));
		sdt.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		tenNV.setBackground(txtColor);
		maNV.setBackground(txtColor);
		ngaySinh.setBackground(txtColor);
		sdt.setBackground(txtColor);
		
		disableJTextField(ngaySinh);
		disableJTextField(diaChi);
		disableJTextField(tenNV);
		disableJTextField(maNV);
		disableJTextField(sdt);
		
		if (table_1.getSelectedRow() == -1) {
			btnSua.setEnabled(false);
		}
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for (int i = 0; i < 9; i++)
			table_1.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		
		table_1.getColumnModel().getColumn(0).setPreferredWidth(16);

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
		table_1.setFocusable(false);
		
		//scrollPane.getViewport().setBackground(Color.white);
		//table_1.setGridColor(background);
		
		if (table_1.getRowCount() > 0)
		table_1.setRowSelectionInterval(0, 0);
		
		gioiTinh.setRenderer(new DefaultListCellRenderer() {
	        @Override
	        public void paint(Graphics g) {
	            setForeground(Color.BLACK);
	            setFocusable(false);
	            super.paint(g);
	        }
	    });
		
		trangThai.setRenderer(new DefaultListCellRenderer() {
	        @Override
	        public void paint(Graphics g) {
	            setForeground(Color.BLACK);
	            setFocusable(false);
	            super.paint(g);
	        }
	    });
		
		chucVu.setRenderer(new DefaultListCellRenderer() {
	        @Override
	        public void paint(Graphics g) {
	            setForeground(Color.BLACK);
	            setFocusable(false);
	            super.paint(g);
	        }
	    });
		
		trangThai.setEnabled(false);
		table_1.setDragEnabled(false);
		
		if (!laAdmin) {
			PhanQuyen phanQuyen = new PhanQuyen();
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Thêm nhân viên");
			if (phanQuyen == null) {
				duocThem = false;
				btnThem.setEnabled(false);
			}
			
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Sửa nhân viên");
			if (phanQuyen == null) 
				duocSua = false;
		}

		hienThiDS(dsnv);
		addEvent();
		
		chucVu.setEnabled(false);
		
		nvBUS.setMaNVDN(maNVDN);
		
		t.start();
		pause();
	}
	
	
	public void hienThiDS(ArrayList<DTO.NhanVien> dsnv) {
		dsnv.clear();
		nvBUS.docDsnv();
		dsnv = nvBUS.getDsnv();
		model.setRowCount(0);
		
		int x = 0;
		try {
			x = dsnv.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row[0] = i + 1;
			row[1] = dsnv.get(i).getTenNV();
			row[2] = dsnv.get(i).getMaNV();
			row[3] = dsnv.get(i).getNgaySinh();
			row[4] = dsnv.get(i).getGioiTinh();
			if (dsnv.get(i).getSdt() > 0) {
				row[5] = "0" + dsnv.get(i).getSdt();
			} else {
				row[5] = "";

			}
			row[6] = dsnv.get(i).getDiaChi();
			row[7] = dsnv.get(i).getChucVu();
			row[8] = dsnv.get(i).getTrangThai();
			model.addRow(row);
		}
	}
	
	public void hienThiDS_1(ArrayList<DTO.NhanVien> dsnv) {
		model.setRowCount(0);
		
		int x = 0;
		try {
			x = dsnv.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row[0] = i + 1;
			row[1] = dsnv.get(i).getTenNV();
			row[2] = dsnv.get(i).getMaNV();
			row[3] = dsnv.get(i).getNgaySinh();
			row[4] = dsnv.get(i).getGioiTinh();
			if (dsnv.get(i).getSdt() > 0) {
				row[5] = "0" + dsnv.get(i).getSdt();
			} else {
				row[5] = "";

			}
			row[6] = dsnv.get(i).getDiaChi();
			row[7] = dsnv.get(i).getChucVu();
			row[8] = dsnv.get(i).getTrangThai();
			model.addRow(row);
		}
	}
	
	public void addEvent() {
		
		tenNV.addKeyListener(new KeyListener() {
			
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
				else
					btnSua.setEnabled(true);
				
				if (i >= 0 && selectedTable) {
					
					if (!duocSua)
						btnSua.setEnabled(false);
					
					try {
						tenNV.setText(model.getValueAt(i, 1).toString());
					}catch (Exception e1) {
						tenNV.setText("");
					}
					
					try {
						//chucVu.setText(model.getValueAt(i, 7).toString());
						
						if (model.getValueAt(i, 7).toString().equals("Admin")) {
							chucVu.setSelectedIndex(1);
						} else
							chucVu.setSelectedIndex(0);
					}catch (Exception e1) {
						
						chucVu.setSelectedIndex(1);
					}
					
					try {
						ngaySinh.setText(model.getValueAt(i, 3).toString());
					}catch (Exception e1) {
						ngaySinh.setText("");
					}
					
					try {
						diaChi.setText(model.getValueAt(i, 6).toString());
					}catch (Exception e1) {
						diaChi.setText("");
					}
					
					try {
						maNV.setText(model.getValueAt(i, 2).toString());
					}catch (Exception e1) {
						maNV.setText("");
					}
					
					try {
						sdt.setText(model.getValueAt(i, 5).toString());
					}catch (Exception e1) {
						sdt.setText("");
					}
					
					try {
						if (model.getValueAt(i, 4).toString().equals("Nam"))
							gioiTinh.setSelectedIndex(0);
						else 
							gioiTinh.setSelectedIndex(1);
					}catch (Exception e1) {
						
					}
					
					try {
						if (model.getValueAt(i, 8).toString().equals("Không hoạt động"))
							trangThai.setSelectedIndex(0);
						else 
							trangThai.setSelectedIndex(1);
					}catch (Exception e1) {
						
					}
					
				}
			}
		});
		
		
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trongForm();
				ableJTextField(ngaySinh);
				//ableJTextField(chucVu);
				chucVu.setEnabled(true);
				ableJTextField(diaChi);
				ableJTextField(tenNV);
				ableJTextField(sdt);
				maNV.setText(String.valueOf(nvBUS.getMaNVMax()+1));
				
				btnSua.setEnabled(false);
				btnHuy.setEnabled(true);
				gioiTinh.setEnabled(true);
				trangThai.setEnabled(true);
				btnDongY.setEnabled(true);
				temp = btnThem;
				selectedTable = false;
			}
		});
		
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ableJTextField(ngaySinh);
				//ableJTextField(chucVu);
				chucVu.setEnabled(true);
				ableJTextField(diaChi);
				ableJTextField(tenNV);
				ableJTextField(sdt);
				selectedTable = false;
				disableJTextField(maNV);

				rowSelected = table_1.getSelectedRow();
				
				btnThem.setEnabled(false);
				gioiTinh.setEnabled(true);
				trangThai.setEnabled(true);
				btnDongY.setEnabled(true);
				btnHuy.setEnabled(true);
				temp = btnSua;
			}
		});
		
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnTimKiem.setEnabled(false);
				trongForm();
				btnDongY.setEnabled(true);
				ableJTextField(maNV);
				ableJTextField(tenNV);

				btnThem.setEnabled(false);
				disableJTextField(ngaySinh);
				disableJTextField(diaChi);
				gioiTinh.setEnabled(false);
				trangThai.setEnabled(false);
				btnHuy.setEnabled(true);
				temp = btnTimKiem;
			}
		});
		
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				trongForm();
				disableJTextField(ngaySinh);
				//disableJTextField(chucVu);
				chucVu.setEnabled(false);
				disableJTextField(diaChi);
				disableJTextField(tenNV);
				disableJTextField(maNV);

				disableJTextField(sdt);
				gioiTinh.setEnabled(false);
				trangThai.setEnabled(false);
				btnHuy.setEnabled(false);
				btnDongY.setEnabled(false);
				if (duocThem)
					btnThem.setEnabled(true);
				btnSua.setEnabled(false);
				btnTimKiem.setEnabled(true);
				if (temp == btnTimKiem) {
					hienThiDS(dsnv);
				}
				
				selectedTable = true;
				temp = null;
			}
		});
		
		btnDongY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (temp == btnThem)
					xuLySuKienThem();
				
				if (temp == btnSua) {
					
					DTO.NhanVien x = new DTO.NhanVien();
					x.setMaNV(Integer.parseInt(model.getValueAt(rowSelected, 2).toString()));
					x.setTenNV(tenNV.getText());
					x.setNgaySinh(ngaySinh.getText());
					x.setGioiTinh(gioiTinh.getItemAt(gioiTinh.getSelectedIndex()).toString());
					
					try {
						x.setSdt(Long.parseLong(sdt.getText()));
					} catch (NumberFormatException n) {
						x.setSdt(-1);
					} catch (Exception e1) {
						x.setSdt(0);
					}
					x.setDiaChi(diaChi.getText());
					x.setTrangThai(trangThai.getItemAt(trangThai.getSelectedIndex()).toString());
					x.setChucVu(chucVu.getItemAt(chucVu.getSelectedIndex()).toString());
					
					if (nvBUS.suaNV(x)) {
						
						disableJTextField(ngaySinh);
						//disableJTextField(chucVu);
						chucVu.setEnabled(false);
						disableJTextField(diaChi);
						disableJTextField(tenNV);
						disableJTextField(sdt);
						gioiTinh.setEnabled(false);
						trangThai.setEnabled(false);
						btnHuy.setEnabled(false);
						btnDongY.setEnabled(false);
						btnThem.setEnabled(true);
						btnSua.setEnabled(false);
						btnTimKiem.setEnabled(true);

						temp = null;
						hienThiDS(dsnv);
						lblThanhCong.setText("Sửa thành công!");
						flagthem = true;
					} else {
						flagthem_1 = true;
						lblThatBai.setText("Sửa thất bại!");
					}
				}
				
				if (temp == btnTimKiem) {
					
					model.setRowCount(0);
					if (!maNV.getText().trim().equals("") && tenNV.getText().trim().equals("")) {
						DTO.NhanVien nv = new DTO.NhanVien();
						ArrayList<DTO.NhanVien> dsnv_1= new ArrayList<DTO.NhanVien>();
						nv = nvBUS.timKiemMa(maNV.getText());
						if (nv != null) {
							dsnv_1.add(nv);
							hienThiDS_1(dsnv_1);
						}
					} else  if (!tenNV.getText().trim().equals("") && maNV.getText().trim().equals("")) {
						ArrayList<DTO.NhanVien> dsnv_1= new ArrayList<DTO.NhanVien>();
						dsnv_1 = nvBUS.timKiemTen(tenNV.getText());
						if (dsnv_1 != null) {
							hienThiDS_1(dsnv_1);
						}
					} else {
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
				                "Chỉ nhập tối đa 1 ô để tìm kiếm!",
				                "Thông báo!!!",
				                JOptionPane.WARNING_MESSAGE);
					}
				}
				selectedTable = true;
			}
		});
	}
	
	
	
	public void xuLySuKienThem() {
		DTO.NhanVien x = new DTO.NhanVien();
		x.setTenNV(tenNV.getText());
		x.setNgaySinh(ngaySinh.getText());
		x.setGioiTinh(gioiTinh.getItemAt(gioiTinh.getSelectedIndex()).toString());
		
		try {
			x.setSdt(Long.parseLong(sdt.getText()));
		} catch (Exception e) {
			x.setSdt(0);
		}
		
		x.setDiaChi(diaChi.getText());
		x.setTrangThai(trangThai.getItemAt(trangThai.getSelectedIndex()).toString());
		x.setChucVu(chucVu.getItemAt(chucVu.getSelectedIndex()).toString());
		
		if (nvBUS.themNV(x)) {
			hienThiDS(dsnv);
			
			temp = null;
			btnDongY.setEnabled(false);
			btnHuy.setEnabled(false);
			trangThai.setEnabled(false);
			disableJTextField(ngaySinh);
			//disableJTextField(chucVu);
			chucVu.setEnabled(false);
			disableJTextField(diaChi);
			disableJTextField(tenNV);
			disableJTextField(sdt);
			gioiTinh.setEnabled(false);
			lblThanhCong.setText("Thêm thành công!");
			flagthem = true;
		} else {
			flagthem_1 = true;
			lblThatBai.setText("Thêm thất bại!");
		}
		
	}
	
	public void disableJTextField(TextFielAmination field) {
		field.setEditable(false);
		field.setEnabled(false);
		field.setBackground(background);
		repaint();
	}
	
	public void ableJTextField(TextFielAmination field) {
		field.setEditable(true);
		field.setEnabled(true);
		field.setBackground(txtColor);
		repaint();
	}
	
	public void disableJPassword(PassWordFielAmination field) {
		field.setEditable(false);
		field.setEnabled(false);
		field.setBackground(background);
		repaint();
	}
	
	public void ableJPassword(PassWordFielAmination field) {
		field.setEditable(true);
		field.setEnabled(true);
		field.setBackground(txtColor);
		repaint();
	}
	
	public void trongForm() {
		tenNV.setText("");
		maNV.setText("");
		diaChi.setText("");
		//chucVu.setText("");
		chucVu.setSelectedIndex(0);
		ngaySinh.setText("");
		sdt.setText("");
	}
	public void resum() {
		t.resume();
	}
	
	public void pause() {
		t.suspend();
	}
	
	
	Thread t=new Thread() {
		public void run(){
			
    		Dimension size= lblContent.getPreferredSize();
    		float x = size.width;
    		while(true){
    			if (flagthem) {
    				i++;
        			card.show(panel_2, "themThanhCong");
        			if (i == 50) {
            			card.show(panel_2, "khong");
        				flagthem = false;
        				i=0;
        			}
        		}
    			
    			if (flagthem_1) {
    				i++;
        			card.show(panel_2, "themThatBai");
        			if (i == 50) {
            			card.show(panel_2, "khong");
        				flagthem_1 = false;
        				i=0;
        			}
        		}
    			
    			if(x + size.width <= 0){
                	x = panel_3.getWidth();
                	lblContent.setBounds((int)x, 2,size.width,size.height);
                } else {
                	x-=0.5;
                	lblContent.setBounds((int)x, 2,size.width,size.height);
                    try {
    					t.sleep(20);
    				} catch (InterruptedException e) {
    					e.printStackTrace();
    				}
                }
    		}
        }
	};
	private JComboBox chucVu;
	
}