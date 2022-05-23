package GUI;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Cursor;
import javax.swing.border.MatteBorder;

import BUS.CheDo_BUS;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class TrangChinh extends JFrame implements MouseListener {
	
	private Color bg_menu = new Color(78, 161, 134);
	private Color bg_menu_item = new Color(111, 211, 178);
	//private Color txtColor = Color.white;
	static private JPanel temp = null;
	private CardLayout card = new CardLayout();
	JPanel panel_3, panel_4, panel_5, panel_6, panel_7, panel_8, panel_9, panel_10, panel_11, panel_12, panel_13, panel_17;
	private NguoiDung nguoi_dung;
	private JPanel contentPane;
	private NhanVien nhan_vien;
	private DichVu dich_vu;
	private KhachSan khach_san;
	private KhachHang khach_hang;
	private NhaHang nha_hang;
	private NhaCungCap nha_cung_cap;
	private LoTrinh lo_trinh;
	private static ThongKe doanh_thu;
	private static ThongKe doanh_thu1;

	private VE ve;
	private boolean cheDo = true;
	private Color txtColor = Color.white;
	private Color colorPanel = new Color(235, 235, 235);
	
	private Color border1 = new Color(143, 189, 172);
	private Color border2 = new Color(91, 129, 115);
	
	private int maDVVe = 0;

	private int manvDangNhap = 0;
	
	private static String mkDN = "";
	
	public int getManvDangNhap() {
		return manvDangNhap;
	}

	public void setManvDangNhap(int manvDangNhap) {
		this.manvDangNhap = manvDangNhap;
	}
	
	public boolean isCheDo() {
		return cheDo;
	}


	public void setCheDo(boolean cheDo) {
		this.cheDo = cheDo;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChinh frame = new TrangChinh(0);
					frame.setVisible(true);
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
	public TrangChinh(int manv) {
		manvDangNhap = manv;
		setLocationByPlatform(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CheDo_BUS cdBUS = new CheDo_BUS();
		cheDo = cdBUS.readClientList();
		
		if (!cheDo) {
			CheDoMau mau = new CheDoMau();
			//background = mau.getMauPhuSang();
			bg_menu_item = mau.getMauPhuSang();
			bg_menu = mau.getMauChinhSang();
			txtColor = Color.black;
			colorPanel = Color.white;
			border1 = new Color(220, 220, 220);
			border2 = new Color(190, 190, 190);
		}
		
		setLocationRelativeTo(null); 
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height * 4 / 5;
		int screenWidth = screenSize.width * 5 / 7;
		
		setMinimumSize(new Dimension(screenWidth * 9 / 10, screenHeight * 9 / 10));
		
		//setMaSize(new Dimension(1380, 1080));
		setMaximumSize(new Dimension(1380, 1080));
		
		setSize(screenWidth, screenHeight);		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(bg_menu_item);
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Tài khoản");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Đổi mật khẩu");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DialogDoiMatKhau dialog = new DialogDoiMatKhau(null, "Đổi mật khẩu", manvDangNhap);
				dialog.setModal(true);
				dialog.setLocationRelativeTo(TrangChinh.getFrames()[0]);
				dialog.setVisible(true);
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Đăng xuất");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main main = new Main();
				main.main(null);
				TrangChinh.this.dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenu mnNewMenu_1 = new JMenu("Cài đặt chế độ");
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Chế độ sáng");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheDo_BUS cheDoBUS = new CheDo_BUS();
				cheDoBUS.writeClientList(false);
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Bạn hãy đăng xuất hoặc khởi động lại chương trình \nđể thao tác trên giao diện chế độ sáng", "Thông báo!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Chế độ màu");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheDo_BUS cheDoBUS = new CheDo_BUS();
				cheDoBUS.writeClientList(true);
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Bạn hãy đăng xuất hoặc khởi động lại chương trình \nđể thao tác trên giao diện chế độ màu", "Thông báo!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		contentPane = new JPanel();
		contentPane.setBackground(Color.white);
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0};
		gbl_contentPane.columnWeights = new double[]{0.05, 1.4};
		gbl_contentPane.rowWeights = new double[]{1.0};
		contentPane.setLayout(gbl_contentPane);
		
		//icon
		ImageIcon scaledIcon_staff = new ImageIcon(new ImageIcon(".\\img\\icons8-staff-64.png")
				.getImage()
				.getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		ImageIcon scaledIcon_kh = new ImageIcon(new ImageIcon(".\\img\\icons8-customer-insights-manager-50.png")
				.getImage()
				.getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		ImageIcon scaledIcon_nd= new ImageIcon(new ImageIcon(".\\img\\icons8-user-48.png")
				.getImage()
				.getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		ImageIcon scaledIcon_dv= new ImageIcon(new ImageIcon(".\\img\\icons8-traveler-50.png")
				.getImage()
				.getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		ImageIcon scaledIcon_lt= new ImageIcon(new ImageIcon(".\\img\\icons8-itinerary-24.png")
				.getImage()
				.getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		ImageIcon scaledIcon_ve= new ImageIcon(new ImageIcon(".\\img\\icons8-ticket-60.png")
				.getImage()
				.getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		ImageIcon scaledIcon_dt= new ImageIcon(new ImageIcon(".\\img\\icons8-revenue-64.png")
				.getImage()
				.getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		ImageIcon scaledIcon_ks= new ImageIcon(new ImageIcon(".\\img\\icons8-hotel-50.png")
				.getImage()
				.getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		ImageIcon scaledIcon_nh= new ImageIcon(new ImageIcon(".\\img\\icons8-restaurant-50.png")
				.getImage()
				.getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		ImageIcon scaledIcon_ncc= new ImageIcon(new ImageIcon(".\\img\\icons8-manufacture-64.png")
				.getImage()
				.getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		ImageIcon scaledIcon_thoat= new ImageIcon(new ImageIcon(".\\img\\icons8-doodle-91.png")
				.getImage()
				.getScaledInstance(35, 35, Image.SCALE_DEFAULT));
		
		
		JPanel panel = new JPanel();
		panel.setBorder(new CompoundBorder(new MatteBorder(0, 0, 0, 3, (Color) border1), new MatteBorder(0, 0, 0, 2, (Color) border2)));
		panel.setBackground(bg_menu);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0};
		gbl_panel.rowWeights = new double[]{1.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 0.2, 1.6};
		panel.setLayout(gbl_panel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(bg_menu);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridheight = 2;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Du lịch Sanh");
		lblNewLabel_3.setForeground(txtColor);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 30));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(10, 10, 0, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_2.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.ORANGE);
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.fill = GridBagConstraints.HORIZONTAL;
		gbc_separator.insets = new Insets(0, 40, 0, 0);
		gbc_separator.anchor = GridBagConstraints.NORTH;
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 1;
		panel_2.add(separator, gbc_separator);
		
		panel_3 = new JPanel();
		panel_3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_3.setBackground(bg_menu);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 0, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		panel.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0};
		gbl_panel_3.columnWeights = new double[]{0.5, 0.4};
		gbl_panel_3.rowWeights = new double[]{1.0};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setIcon(scaledIcon_kh);
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel_3.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("Khách hàng");
		lblNewLabel.setForeground(txtColor);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 45);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 0;
		panel_3.add(lblNewLabel, gbc_lblNewLabel);
		
		panel_4 = new JPanel();
		panel_4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_4.setBackground(bg_menu);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 0, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 3;
		panel.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0, 0};
		gbl_panel_4.rowHeights = new int[]{0};
		gbl_panel_4.columnWeights = new double[]{0.5, 0.4};
		gbl_panel_4.rowWeights = new double[]{1.0};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setIcon(scaledIcon_staff);
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		panel_4.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JLabel lblNewLabel_1 = new JLabel("Nhân viên");
		lblNewLabel_1.setForeground(txtColor);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 45);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		panel_5 = new JPanel();
		panel_5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_5.setBackground(bg_menu);
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 0, 0);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 4;
		panel.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0};
		gbl_panel_5.rowHeights = new int[]{0};
		gbl_panel_5.columnWeights = new double[]{0.5, 0.4};
		gbl_panel_5.rowWeights = new double[]{1.0};
		panel_5.setLayout(gbl_panel_5);
		
		JLabel lblNewLabel_14 = new JLabel();
		lblNewLabel_14.setIcon(scaledIcon_nd);
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_14.gridx = 0;
		gbc_lblNewLabel_14.gridy = 0;
		panel_5.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Người dùng");
		lblNewLabel_2_1_2.setForeground(txtColor);
		lblNewLabel_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_2.insets = new Insets(0, 0, 0, 45);
		gbc_lblNewLabel_2_1_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1_2.gridx = 1;
		gbc_lblNewLabel_2_1_2.gridy = 0;
		panel_5.add(lblNewLabel_2_1_2, gbc_lblNewLabel_2_1_2);
		
		 panel_6 = new JPanel();
		 panel_6.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_6.setBackground(bg_menu);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 0, 0);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 5;
		panel.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0};
		gbl_panel_6.rowHeights = new int[]{0};
		gbl_panel_6.columnWeights = new double[]{0.5, 0.4};
		gbl_panel_6.rowWeights = new double[]{1.0};
		panel_6.setLayout(gbl_panel_6);
		
		JLabel lblNewLabel_13 = new JLabel();
		lblNewLabel_13.setIcon(scaledIcon_dv);
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_13.gridx = 0;
		gbc_lblNewLabel_13.gridy = 0;
		panel_6.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Dịch vụ");
		lblNewLabel_2_1_1.setForeground(txtColor);
		lblNewLabel_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_1.insets = new Insets(0, 0, 0, 45);
		gbc_lblNewLabel_2_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1_1.gridx = 1;
		gbc_lblNewLabel_2_1_1.gridy = 0;
		panel_6.add(lblNewLabel_2_1_1, gbc_lblNewLabel_2_1_1);
		
		panel_7 = new JPanel();
		panel_7.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_7.setBackground(bg_menu);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 0, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 6;
		panel.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0};
		gbl_panel_7.rowHeights = new int[]{0};
		gbl_panel_7.columnWeights = new double[]{0.5, 0.4};
		gbl_panel_7.rowWeights = new double[]{1.0};
		panel_7.setLayout(gbl_panel_7);
		
		JLabel lblNewLabel_12 = new JLabel();
		lblNewLabel_12.setIcon(scaledIcon_lt);
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_12.gridx = 0;
		gbc_lblNewLabel_12.gridy = 0;
		panel_7.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		JLabel lblNewLabel_2 = new JLabel("Lộ trình");
		lblNewLabel_2.setForeground(txtColor);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 45);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 0;
		panel_7.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		panel_8 = new JPanel();
		panel_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_8.setBackground(bg_menu);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 0, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 7;
		panel.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0, 0};
		gbl_panel_8.rowHeights = new int[]{0};
		gbl_panel_8.columnWeights = new double[]{0.5, 0.4};
		gbl_panel_8.rowWeights = new double[]{1.0};
		panel_8.setLayout(gbl_panel_8);
		
		JLabel lblNewLabel_11 = new JLabel();
		lblNewLabel_11.setIcon(scaledIcon_ve);
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_11.gridx = 0;
		gbc_lblNewLabel_11.gridy = 0;
		panel_8.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		JLabel lblNewLabel_2_2 = new JLabel("Vé");
		lblNewLabel_2_2.setForeground(txtColor);
		lblNewLabel_2_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2_2 = new GridBagConstraints();
		gbc_lblNewLabel_2_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_2.insets = new Insets(0, 0, 0, 45);
		gbc_lblNewLabel_2_2.gridx = 1;
		gbc_lblNewLabel_2_2.gridy = 0;
		panel_8.add(lblNewLabel_2_2, gbc_lblNewLabel_2_2);
		
		 panel_9 = new JPanel();
		 panel_9.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_9.setBackground(bg_menu);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.insets = new Insets(0, 0, 0, 0);
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 8;
		panel.add(panel_9, gbc_panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0, 0};
		gbl_panel_9.rowHeights = new int[]{0};
		gbl_panel_9.columnWeights = new double[]{0.5, 0.4};
		gbl_panel_9.rowWeights = new double[]{1.0};
		panel_9.setLayout(gbl_panel_9);
		
		JLabel lblNewLabel_10 = new JLabel();
		lblNewLabel_10.setIcon(scaledIcon_dt);
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_10.gridx = 0;
		gbc_lblNewLabel_10.gridy = 0;
		panel_9.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Thống kê");
		lblNewLabel_2_1.setForeground(txtColor);
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_2_1.insets = new Insets(0, 0, 0, 45);

		gbc_lblNewLabel_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1.gridx = 1;
		gbc_lblNewLabel_2_1.gridy = 0;
		panel_9.add(lblNewLabel_2_1, gbc_lblNewLabel_2_1);
		
		 panel_10 = new JPanel();
		 panel_10.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_10.setBackground(bg_menu);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.insets = new Insets(0, 0, 0, 0);
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 9;
		panel.add(panel_10, gbc_panel_10);
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{0, 0};
		gbl_panel_10.rowHeights = new int[]{0};
		gbl_panel_10.columnWeights = new double[]{0.5, 0.4};
		gbl_panel_10.rowWeights = new double[]{1.0};
		panel_10.setLayout(gbl_panel_10);
		
		JLabel lblNewLabel_9 = new JLabel();
		lblNewLabel_9.setIcon(scaledIcon_ks);
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_9.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_9.gridx = 0;
		gbc_lblNewLabel_9.gridy = 0;
		panel_10.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Khách sạn");
		lblNewLabel_2_1_3.setForeground(txtColor);
		lblNewLabel_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_3.insets = new Insets(0, 0, 0, 45);

		gbc_lblNewLabel_2_1_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1_3.gridx = 1;
		gbc_lblNewLabel_2_1_3.gridy = 0;
		panel_10.add(lblNewLabel_2_1_3, gbc_lblNewLabel_2_1_3);
		
		panel_11 = new JPanel();
		panel_11.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_11.setBackground(bg_menu);
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 0, 0);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 10;
		panel.add(panel_11, gbc_panel_11);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{0, 0};
		gbl_panel_11.rowHeights = new int[]{0};
		gbl_panel_11.columnWeights = new double[]{0.5, 0.4};
		gbl_panel_11.rowWeights = new double[]{1.0};
		panel_11.setLayout(gbl_panel_11);
		
		JLabel lbNH = new JLabel();
		lbNH.setIcon(scaledIcon_nh);
		GridBagConstraints bgl_lbNH = new GridBagConstraints();
		bgl_lbNH.anchor = GridBagConstraints.EAST;
		bgl_lbNH.insets = new Insets(0, 0, 0 ,0);
		bgl_lbNH.gridx = 0;
		bgl_lbNH.gridy = 0;
		panel_11.add(lbNH, bgl_lbNH);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Nhà hàng");
		lblNewLabel_2_1_4.setForeground(txtColor);
		lblNewLabel_2_1_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_4.insets = new Insets(0, 0, 0, 45);

		gbc_lblNewLabel_2_1_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1_4.gridx = 1;
		gbc_lblNewLabel_2_1_4.gridy = 0;
		panel_11.add(lblNewLabel_2_1_4, gbc_lblNewLabel_2_1_4);
		
		 panel_12 = new JPanel();
		 panel_12.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_12.setBackground(bg_menu);
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.insets = new Insets(0, 0, 0, 0);
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 11;
		panel.add(panel_12, gbc_panel_12);
		GridBagLayout gbl_panel_12 = new GridBagLayout();
		gbl_panel_12.columnWidths = new int[]{0, 0};
		gbl_panel_12.rowHeights = new int[]{0};
		gbl_panel_12.columnWeights = new double[]{0.5, 0.4};
		gbl_panel_12.rowWeights = new double[]{1.0};
		panel_12.setLayout(gbl_panel_12);
		
		JLabel lblNewLabel_8 = new JLabel();
		lblNewLabel_8.setIcon(scaledIcon_ncc);
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_8.gridx = 0;
		gbc_lblNewLabel_8.gridy = 0;
		panel_12.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		JLabel lblNewLabel_2_1_5 = new JLabel("Nhà cung cấp");
		lblNewLabel_2_1_5.setForeground(txtColor);
		lblNewLabel_2_1_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2_1_5 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_5.insets = new Insets(0, 0, 0, 45);

		gbc_lblNewLabel_2_1_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1_5.gridx = 1;
		gbc_lblNewLabel_2_1_5.gridy = 0;
		panel_12.add(lblNewLabel_2_1_5, gbc_lblNewLabel_2_1_5);
		
		 panel_13 = new JPanel();
		 panel_13.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		panel_13.setBackground(bg_menu);
		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.insets = new Insets(0, 0, 0, 0);
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 0;
		gbc_panel_13.gridy = 12;
		panel.add(panel_13, gbc_panel_13);
		GridBagLayout gbl_panel_13 = new GridBagLayout();
		gbl_panel_13.columnWidths = new int[]{0, 0};
		gbl_panel_13.rowHeights = new int[]{0};
		gbl_panel_13.columnWeights = new double[]{0.5, 0.4};
		gbl_panel_13.rowWeights = new double[]{1.0};
		panel_13.setLayout(gbl_panel_13);
		
		JLabel lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setIcon(scaledIcon_thoat);
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 0, 0);
		gbc_lblNewLabel_7.gridx = 0;
		gbc_lblNewLabel_7.gridy = 0;
		panel_13.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		JLabel lblNewLabel_2_1_6 = new JLabel("Thoát/Nghỉ");
		lblNewLabel_2_1_6.setForeground(txtColor);
		lblNewLabel_2_1_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2_1_6 = new GridBagConstraints();
		gbc_lblNewLabel_2_1_6.insets = new Insets(0, 0, 0, 45);

		gbc_lblNewLabel_2_1_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2_1_6.gridx = 1;
		gbc_lblNewLabel_2_1_6.gridy = 0;
		panel_13.add(lblNewLabel_2_1_6, gbc_lblNewLabel_2_1_6);
		
		temp = panel;
		
		JLabel lblNewLabel_4 = new JLabel("  Bản quyền thuộc nhóm chúng tôi!");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 9));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 13;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		panel_17 = new JPanel();
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 1;
		gbc_panel_17.gridy = 0;
		contentPane.add(panel_17, gbc_panel_17);
		panel_17.setLayout(card);
		
		JPanel trangChu = new JPanel();
		
		
		
		panel_17.add(trangChu, "trang_chu");
		
		JLabel lblNewLabel_15 = new JLabel("Chào mừng bạn đến với phần mềm quản lý tour du lịch!");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 24));
		
		JLabel lblNewLabel_16 = new JLabel("Nếu gặp rắc rối hoặc bất kỳ lỗi gì về phầm mềm, hãy liên hệ với chúng thôi theo số điện thoại: 09988998899");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GroupLayout gl_trangChu = new GroupLayout(trangChu);
		gl_trangChu.setHorizontalGroup(
			gl_trangChu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_trangChu.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_trangChu.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_15, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 741, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_16, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 741, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		gl_trangChu.setVerticalGroup(
			gl_trangChu.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_trangChu.createSequentialGroup()
					.addGap(233)
					.addComponent(lblNewLabel_15, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(33)
					.addComponent(lblNewLabel_16, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
					.addGap(209))
		);
		trangChu.setLayout(gl_trangChu);
		
		khach_hang = new KhachHang(manv);
		panel_17.add(khach_hang, "khachhang");
		
		nhan_vien = new NhanVien(manv);
		panel_17.add(nhan_vien, "nhanvien");
		
		nguoi_dung = new NguoiDung(manv);
		panel_17.add(nguoi_dung, "nguoidung");
		
		lo_trinh = new LoTrinh(manv);
		panel_17.add(lo_trinh, "lotrinh");
		
		ve = new VE(manv);
		panel_17.add(ve, "ve");
		
		dich_vu = new DichVu(manv);
		panel_17.add(dich_vu, "dichvu");
		
		dich_vu.getTourSanPham().getMntmNewMenuItem().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ve.resum();

				flag_Ve = true;
				panel_8.setBackground(bg_menu_item);
				if (temp != panel_8)
				temp.setBackground(bg_menu);
				temp = panel_8;
				resum();
			}
		});
		
		dich_vu.getTourMoBan().getMntmNewMenuItem().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ve.resum();
				flag_Ve_1 = true;
				panel_8.setBackground(bg_menu_item);
				if (temp != panel_8)
				temp.setBackground(bg_menu);
				temp = panel_8;
				resum();
				
			}
		});
		
		doanh_thu = new ThongKe();
		panel_17.add(doanh_thu, "thongke");
		
		
		khach_san = new KhachSan(manv);
		panel_17.add(khach_san, "khachsan");
		nha_hang = new NhaHang(manv);
		panel_17.add(nha_hang, "nhahang");
		
		nha_cung_cap = new NhaCungCap(manv);
		panel_17.add(nha_cung_cap, "nhacungcap");
		
		panel_3.addMouseListener(this);
		panel_4.addMouseListener(this);
		panel_5.addMouseListener(this);
		panel_6.addMouseListener(this);
		panel_7.addMouseListener(this);
		panel_8.addMouseListener(this);
		panel_9.addMouseListener(this);
		panel_10.addMouseListener(this);
		panel_11.addMouseListener(this);
		panel_12.addMouseListener(this);
		panel_13.addMouseListener(this);
		
		t.start();
		pause();
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() != panel_6) {
			dich_vu.pause();
		}
		
		if (e.getSource() != panel_4) {
			nhan_vien.pause();
		}
		
		if (e.getSource() != panel_3) {
			khach_hang.pause();
		}
		
		if (e.getSource() != panel_7) {
			lo_trinh.pause();
		}
		
		if (e.getSource() != panel_8) {
			ve.pause();
		}
		
		if (e.getSource() != panel_10) {
			khach_san.pause();
		}
		
		if (e.getSource() != panel_11) {
			nha_hang.pause();
		}
		
		if (e.getSource() != panel_12) {
			nha_cung_cap.pause();
		}
		
		if (e.getSource() == panel_3) {
			card.show(panel_17, "khachhang");
			khach_hang.resum();
			panel_3.setBackground(bg_menu_item);
			if (temp != panel_3)
				temp.setBackground(bg_menu);
			temp = panel_3;
		} else if (e.getSource() == panel_4) {
			card.show(panel_17, "nhanvien");
			panel_4.setBackground(bg_menu_item);
			nhan_vien.resum();
			if (temp != panel_4)
			temp.setBackground(bg_menu);
			temp = panel_4;
		} else if (e.getSource() == panel_5) {
			card.show(panel_17, "nguoidung");
			panel_5.setBackground(bg_menu_item);
			if (temp != panel_5)
			temp.setBackground(bg_menu);
			temp = panel_5;
		} else if (e.getSource() == panel_6) {
			card.show(panel_17, "dichvu");
			dich_vu.resum();
			panel_6.setBackground(bg_menu_item);
			if (temp != panel_6)
			temp.setBackground(bg_menu);
			temp = panel_6;
		} else if (e.getSource() == panel_7) {
			card.show(panel_17, "lotrinh");
			lo_trinh.resum();
			panel_7.setBackground(bg_menu_item);
			if (temp != panel_7)
			temp.setBackground(bg_menu);
			temp = panel_7;
		} else if (e.getSource() == panel_8) {
			card.show(panel_17, "ve");
			ve.setMaDVTourCT(maDVVe);
			ve.resum();
			panel_8.setBackground(bg_menu_item);
			if (temp != panel_8)
			temp.setBackground(bg_menu);
			temp = panel_8;
		} else if (e.getSource() == panel_9) {
			
			doanh_thu = new ThongKe();
			panel_17.add(doanh_thu, "thongke");
			
			card.show(panel_17, "thongke");
			panel_9.setBackground(bg_menu_item);
			if (temp != panel_9)
			temp.setBackground(bg_menu);
			temp = panel_9;
		} else if (e.getSource() == panel_10) {
			card.show(panel_17, "khachsan");
			panel_10.setBackground(bg_menu_item);
			khach_san.resum();
			if (temp != panel_10)
			temp.setBackground(bg_menu);
			temp = panel_10;
		} else if (e.getSource() == panel_11) {
			card.show(panel_17, "nhahang");
			panel_11.setBackground(bg_menu_item);
			nha_hang.resum();
			if (temp != panel_11)
			temp.setBackground(bg_menu);
			temp = panel_11;
		} else if (e.getSource() == panel_12) {
			card.show(panel_17, "nhacungcap");
			panel_12.setBackground(bg_menu_item);
			nha_cung_cap.resum();
			if (temp != panel_12)
			temp.setBackground(bg_menu);
			temp = panel_12;
		} else if (e.getSource() == panel_13) {
			panel_13.setBackground(bg_menu_item);
			if (temp != panel_13)
			temp.setBackground(bg_menu);
			temp = panel_13;
			update(getGraphics());
			try {
				Thread.sleep(100);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			System.exit(0);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void resum() {
		t.resume();
	}
	
	public void pause() {
		t.suspend();
	}
	
	static int k = 0;
	boolean flag_Ve = false;
	boolean flag_Ve_1 = false;
	
	Thread t=new Thread()

	{

		public void run(){
    		while(true){
    			
    			if (flag_Ve) {
    				k++;
    				if (k == 9) {
    					card.show(panel_17, "ve");
        				maDVVe = dich_vu.getTourSanPham().getMaDVVe();
    					ve.setMaDVTourCT(maDVVe);
    					ve.getBtnthmThem().doClick();
    					k = 0;
    					flag_Ve = false;
    					pause();
        			}
    			} else if (flag_Ve_1) {
    				k++;
    				if (k == 9) {
    					card.show(panel_17, "ve");
        				maDVVe = dich_vu.getTourMoBan().getMaDVVE();
    					ve.setMaDVTourCT(maDVVe);
    					ve.getBtnthmThem().doClick();
    					k = 0;
    					flag_Ve_1 = false;
    					pause();
        			}
    			}
    			
    			try {
					t.sleep(20);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    		}
        }

	};
}
