package GUI;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Cursor;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;

import BUS.CheDo_BUS;
import BUS.PhanQuyen_BUS;
import BUS.TourSanPham_BUS;
import DTO.ChietTinhTour;
import DTO.KhachSan;
import DTO.NhaHang;
import DTO.PhanQuyen;

import javax.swing.JEditorPane;
import javax.swing.Action;
import javax.swing.JButton;

public class DichVu extends JPanel implements MouseListener {
	private JPanel   panel_10;
	private TourSanPham tourSanPham;
	private TourMoBan tourMoBan;
	private JPanelAmination panel_1, panel_2;
	private CardLayout card = new CardLayout();
	private Color background = new Color(111, 211, 178);
	private Color bg_default = new Color(78, 161, 134);
	private Color bg_selected = new Color(111, 211, 178);
	private BtnThem btnThem;
	private JLabel lblContent;
	private JPanel panel_6, panel_3, thongTinLoTrinh, thongTinNHKS, thongTinChietTinh, panel_12, panel_18;
	private ButtonAmination btnChietTinh;
	private JPanelAmination panel_13, panel_14, panel_15;
	private CardLayout card_1 = new CardLayout();
	static boolean flag = false;
	private Object[] column1 = {"Ngày đi", "Giờ đi", "Ngày về", "Giờ về", "Điểm đón", "Điểm đến"};
	private static int maDVTourChietTinh = 0;
	private TourSanPham_BUS tourBUS = new TourSanPham_BUS();
	private static int kkk = 0;
	private static boolean flag_2 = false;
	private int maNVDN = 0;
	private PhanQuyen_BUS phanQuyenBUS = new PhanQuyen_BUS();
	private boolean duocThem = true;
	private boolean cheDo = true;
	private Color txtColor = Color.white;
	private Color colorPanel = new Color(235, 235, 235);
	
	public TourSanPham getTourSanPham() {
		return tourSanPham;
	}

	public void setTourSanPham(TourSanPham tourSanPham) {
		this.tourSanPham = tourSanPham;
	}

	public TourMoBan getTourMoBan() {
		return tourMoBan;
	}

	public void setTourMoBan(TourMoBan tourMoBan) {
		this.tourMoBan = tourMoBan;
	}

	public int getMaNVDN() {
		return maNVDN;
	}

	public void setMaNVDN(int maNVDN) {
		this.maNVDN = maNVDN;
	}

	public int getMaDVTourChietTinh() {
		return maDVTourChietTinh;
	}

	public boolean isCheDo() {
		return cheDo;
	}


	public void setCheDo(boolean cheDo) {
		this.cheDo = cheDo;
	}
	
	public void setMaDVTourChietTinh(int maDVTourChietTinh) {
		this.maDVTourChietTinh = maDVTourChietTinh;
	}

	public DichVu(int maNVOk) {	
		
		maNVDN = maNVOk;
		
		CheDo_BUS cdBUS = new CheDo_BUS();
		cheDo = cdBUS.readClientList();
		
		if (!cheDo) {
			CheDoMau mau = new CheDoMau();
			//background = mau.getMauPhuSang();
			background = mau.getMauPhuSang();
			bg_selected = mau.getMauPhuSang();
			bg_default = mau.getMauChinhSang();
			txtColor = Color.black;
			colorPanel = Color.white;
		}
		
		setBackground(colorPanel);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{59, 30, 270, 180};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0};
		setLayout(gridBagLayout);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(background);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{0};
		gbl_panel_4.rowHeights = new int[]{0};
		gbl_panel_4.columnWeights = new double[]{1.0};
		gbl_panel_4.rowWeights = new double[]{1.0};
		panel_4.setLayout(gbl_panel_4);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.insets = new Insets(4, 4, 4, 4);
		gbc_panel_5.gridx = 0;
		gbc_panel_5.gridy = 0;
		panel_4.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0};
		gbl_panel_5.rowHeights = new int[]{0};
		gbl_panel_5.columnWeights = new double[]{1.0};
		gbl_panel_5.rowWeights = new double[]{1.0};
		panel_5.setLayout(gbl_panel_5);
		
		panel_6 = new JPanel();
		panel_6.setBackground(background);
		panel_6.setLayout(null);
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.insets = new Insets(4, 4, 4, 4);
		gbc_panel_6.gridx = 0;
		gbc_panel_6.gridy = 0;
		panel_5.add(panel_6, gbc_panel_6);
		
		lblContent = new JLabel("Quản lý dịch vụ");
		lblContent.setBounds(116, 0, 208, 33);
		lblContent.setFont(new Font("Tahoma", Font.BOLD, 27));
		panel_6.add(lblContent);
		
		panel_10 = new JPanel();
		panel_10.setBackground(colorPanel);
		GridBagConstraints gbc_panel_10 = new GridBagConstraints();
		gbc_panel_10.fill = GridBagConstraints.BOTH;
		gbc_panel_10.insets = new Insets(0, 0, 0, 0);
		gbc_panel_10.gridx = 0;
		gbc_panel_10.gridy = 1;
		add(panel_10, gbc_panel_10);
		
		GridBagLayout gbl_panel_10 = new GridBagLayout();
		gbl_panel_10.columnWidths = new int[]{432, 95};
		gbl_panel_10.rowHeights = new int[]{35};
		gbl_panel_10.columnWeights = new double[]{1.0, 0.0};
		gbl_panel_10.rowWeights = new double[]{1.0};
		panel_10.setLayout(gbl_panel_10);
		
		JPanelAmination panel = new JPanelAmination();
		panel.setRadiusTopLeft(4);
		panel.setRadiusTopRighht(4);
		panel.setBackgroundColor(bg_default);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.WEST;
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.VERTICAL;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel_10.add(panel, gbc_panel);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		
		panel_1 = new JPanelAmination();
		panel_1.setBackgroundColor(bg_selected);
		panel_1.setRadiusTopRighht(20);
		panel_1.setRadiusTopLeft(20);
		panel_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(2, 7, 0, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{1.0};
		gbl_panel_1.rowWeights = new double[]{1.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Tour sản phẩm");
		lblNewLabel.setForeground(txtColor);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		panel_2 = new JPanelAmination();
		panel_2.setRadiusTopRighht(20);
		panel_2.setRadiusTopLeft(20);
		panel_2.setBackgroundColor(bg_default);
		panel_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(2, 0, 0, 7);
		gbc_panel_2.fill = GridBagConstraints.VERTICAL;
		gbc_panel_2.gridx = 1;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0};
		gbl_panel_2.columnWeights = new double[]{1.0, 1.0};
		gbl_panel_2.rowWeights = new double[]{1.0};
		panel_2.setLayout(gbl_panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("Tour mở bán");
		lblNewLabel_1.setForeground(txtColor);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(5, 5, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		panel_2.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(colorPanel);
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 2, 0);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 1;
		gbc_panel_7.gridy = 0;
		panel_10.add(panel_7, gbc_panel_7);
		
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{130, 130, 100};
		gbl_panel_7.rowHeights = new int[]{0};
		gbl_panel_7.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_panel_7.rowWeights = new double[]{1.0};
		panel_7.setLayout(gbl_panel_7);
		Dimension size= panel_10.getPreferredSize();
		
		btnChietTinh = new ButtonAmination();
		btnChietTinh.setText("Chiết tính tour");
		btnChietTinh.setRadius((size.height + 2) * 3 / 7);
		btnChietTinh.setFont(new Font("Tahoma", Font.PLAIN, size.height / 2));
		GridBagConstraints gbc_btnChietTinh = new GridBagConstraints();
		gbc_btnChietTinh.fill = GridBagConstraints.BOTH;
		gbc_btnChietTinh.insets = new Insets(0, 0, 0, 5);
		gbc_btnChietTinh.gridx = 1;
		gbc_btnChietTinh.gridy = 0;
		panel_7.add(btnChietTinh, gbc_btnChietTinh);
		
		
		
		btnThem = new BtnThem();
		GridBagConstraints gbc_btnThem = new GridBagConstraints();
		gbc_btnThem.fill = GridBagConstraints.BOTH;
		gbc_btnThem.insets = new Insets(0, 0, 0, 10);
		gbc_btnThem.gridx = 2;
		gbc_btnThem.gridy = 0;
		panel_7.add(btnThem, gbc_btnThem);
		
		panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		add(panel_3, gbc_panel_3);
		panel_3.setLayout(card);
		
		
		tourSanPham = new TourSanPham();
		panel_3.add(tourSanPham, "tourSanPham");
		
		tourSanPham.getTable().addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub

				if (maDVTourChietTinh != tourSanPham.getMaTourSP() ) {
    				ArrayList<DTO.LoTrinh> dsLT = new ArrayList<DTO.LoTrinh>();
    				maDVTourChietTinh = tourSanPham.getMaTourSP();
    				dsLT = tourBUS.timKiemLT(tourSanPham.getMaTourSP());
    				try {
    					txtNgayDi.setText(dsLT.get(0).getngaydi());
    				} catch (Exception df) {
    					txtNgayDi.setText("");
    				}
    				
    				try {
    					txtNgayVe.setText(dsLT.get(0).getngayve());
    				} catch (Exception df) {
    					txtNgayVe.setText("");
    				}
    				
    				try {
    					txtGioDi.setText(dsLT.get(0).getgiodi());
    				} catch (Exception df) {
    					txtGioDi.setText("");

    				}
    				
    				try {
    					txtGioVe.setText(dsLT.get(0).getgiove());
    				} catch (Exception df) {
    					txtGioVe.setText("");

    				}
    				
    				try {
    					txtDiemDon.setText(dsLT.get(0).getdiemdon());
    				} catch (Exception df) {
    					txtDiemDon.setText("");
    				}
    				
    				try {
    					txtDiemDen.setText(dsLT.get(0).getdiemden());
    				} catch (Exception df) {
    					txtDiemDen.setText("");
    				}
    				
    				ArrayList<DTO.ChietTinhTour> dsCT= new ArrayList<DTO.ChietTinhTour>();
    				dsCT = tourBUS.timKiemCT(maDVTourChietTinh);
    				int ma;
    				try {
    					ma = dsCT.get(0).getMaDVTour();
    				} catch (Exception ex) {
    					ma = 0;
    				}
    				if (ma == maDVTourChietTinh) {
    					try {
        					txtGiaNH_1.setText(String.valueOf(dsCT.get(0).getGiaNH()));
        				} catch (Exception df) {
        					txtGiaNH_1.setText("");
        				}
        				
        				try {
        					txtGiaKS_1.setText(String.valueOf(dsCT.get(0).getGiaKS()));
        				} catch (Exception df) {
        					txtGiaNH_1.setText("");
        				}
        				
        				try {
        					txtGiaDVTour.setText(String.valueOf(dsCT.get(0).getGiaDV()));
        				} catch (Exception df) {
        					txtGiaNH_1.setText("");
        				}
        				
        				try {
        					txtGhiChu.setText(String.valueOf(dsCT.get(0).getGhiChu()));
        				} catch (Exception df) {
        					txtGiaNH_1.setText("");
        				}
        				
        				NhaHang nh = new NhaHang();
        				
        				try {
            				nh = tourBUS.timKiemNH(dsCT.get(0).getMaNH());
        				} catch (Exception exx) {
        					nh = null;
        				}
        				
        				if (nh != null) {
        					try {
            					txtTenNH.setText(nh.getTenNH());
            				} catch (Exception df) {
            					txtTenNH.setText("");
            				}
        					
        					try {
            					txtMaNCCNH.setText(String.valueOf(nh.getMaNCC()));
            				} catch (Exception df) {
            					txtMaNCCNH.setText("");
            				}
        					
        					try {
            					txtGiaNH.setText(String.valueOf(nh.getGia()));
            				} catch (Exception df) {
            					txtGiaNH.setText("");
            				}
        				}
        				
        				KhachSan ks = new KhachSan();
        				try {
        					ks = tourBUS.timKiemKS(dsCT.get(0).getMaKS());
        				} catch (Exception exx) {
        					ks = null;
        				}
        				
        				if (ks != null) {
        					try {
            					txtTenKS.setText(ks.getTenKS());
            				} catch (Exception df) {
            					txtTenKS.setText("");
            				}
        					
        					try {
            					txtNCCKS.setText(String.valueOf(ks.getMaNCC()));
            				} catch (Exception df) {
            					txtNCCKS.setText("");
            				}
        					
        					try {
            					txtGiaKS.setText(String.valueOf(ks.getGia()));
            				} catch (Exception df) {
            					txtGiaKS.setText("");
            				}
        					
        					try {
            					txtLoaiHinhKS.setText(ks.getLoaihinhKS());
            				} catch (Exception df) {
            					txtLoaiHinhKS.setText("");
            				}
        					
        					try {
            					txtLoaiPhong.setText(ks.getLoaiphong());
            				} catch (Exception df) {
            					txtLoaiPhong.setText("");
            				}
        				}
        				
    				} else {
    					trongThongTinNHCT();
    				}

    			} 
			}
		});
		
		
		
		tourMoBan = new TourMoBan();
		panel_3.add(tourMoBan, "tourMoBan");
		
		tourMoBan.getTable().addMouseListener(new MouseListener() {
			
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
				// TODO Auto-generated method stub
				if (maDVTourChietTinh != tourMoBan.getMaTour()) {
    				ArrayList<DTO.LoTrinh> dsLT = new ArrayList<DTO.LoTrinh>();
    				maDVTourChietTinh = tourMoBan.getMaTour();
    				dsLT = tourBUS.timKiemLT(tourMoBan.getMaTour());
    				try {
    					txtNgayDi.setText(dsLT.get(0).getngaydi());
    				} catch (Exception df) {
    					txtNgayDi.setText("");
    				}
    				
    				try {
    					txtNgayVe.setText(dsLT.get(0).getngayve());
    				} catch (Exception df) {
    					txtNgayVe.setText("");
    				}
    				
    				try {
    					txtGioDi.setText(dsLT.get(0).getgiodi());
    				} catch (Exception df) {
    					txtGioDi.setText("");

    				}
    				
    				try {
    					txtGioVe.setText(dsLT.get(0).getgiove());
    				} catch (Exception df) {
    					txtGioVe.setText("");

    				}
    				
    				try {
    					txtDiemDon.setText(dsLT.get(0).getdiemdon());
    				} catch (Exception df) {
    					txtDiemDon.setText("");
    				}
    				
    				try {
    					txtDiemDen.setText(dsLT.get(0).getdiemden());
    				} catch (Exception df) {
    					txtDiemDen.setText("");
    				}
    				
    				ArrayList<DTO.ChietTinhTour> dsCT= new ArrayList<DTO.ChietTinhTour>();
    				dsCT = tourBUS.timKiemCT(maDVTourChietTinh);
    				int ma;
    				try {
    					ma = dsCT.get(0).getMaDVTour();
    				} catch (Exception ex) {
    					ma = 0;
    				}
    				if (ma == maDVTourChietTinh) {
    					try {
        					txtGiaNH_1.setText(String.valueOf(dsCT.get(0).getGiaNH()));
        				} catch (Exception df) {
        					txtGiaNH_1.setText("");
        				}
        				
        				try {
        					txtGiaKS_1.setText(String.valueOf(dsCT.get(0).getGiaKS()));
        				} catch (Exception df) {
        					txtGiaNH_1.setText("");
        				}
        				
        				try {
        					txtGiaDVTour.setText(String.valueOf(dsCT.get(0).getGiaDV()));
        				} catch (Exception df) {
        					txtGiaNH_1.setText("");
        				}
        				
        				try {
        					txtGhiChu.setText(String.valueOf(dsCT.get(0).getGhiChu()));
        				} catch (Exception df) {
        					txtGiaNH_1.setText("");
        				}
        				
        				NhaHang nh = new NhaHang();
        				
        				try {
            				nh = tourBUS.timKiemNH(dsCT.get(0).getMaNH());
        				} catch (Exception exx) {
        					nh = null;
        				}
        				
        				if (nh != null) {
        					try {
            					txtTenNH.setText(nh.getTenNH());
            				} catch (Exception df) {
            					txtTenNH.setText("");
            				}
        					
        					try {
            					txtMaNCCNH.setText(String.valueOf(nh.getMaNCC()));
            				} catch (Exception df) {
            					txtMaNCCNH.setText("");
            				}
        					
        					try {
            					txtGiaNH.setText(String.valueOf(nh.getGia()));
            				} catch (Exception df) {
            					txtGiaNH.setText("");
            				}
        				}
        				
        				KhachSan ks = new KhachSan();
        				try {
        					ks = tourBUS.timKiemKS(dsCT.get(0).getMaKS());
        				} catch (Exception exx) {
        					ks = null;
        				}
        				
        				if (ks != null) {
        					try {
            					txtTenKS.setText(ks.getTenKS());
            				} catch (Exception df) {
            					txtTenKS.setText("");
            				}
        					
        					try {
            					txtNCCKS.setText(String.valueOf(ks.getMaNCC()));
            				} catch (Exception df) {
            					txtNCCKS.setText("");
            				}
        					
        					try {
            					txtGiaKS.setText(String.valueOf(ks.getGia()));
            				} catch (Exception df) {
            					txtGiaKS.setText("");
            				}
        					
        					try {
            					txtLoaiHinhKS.setText(ks.getLoaihinhKS());
            				} catch (Exception df) {
            					txtLoaiHinhKS.setText("");
            				}
        					
        					try {
            					txtLoaiPhong.setText(ks.getLoaiphong());
            				} catch (Exception df) {
            					txtLoaiPhong.setText("");
            				}
        				}
        				
    				} else {
    					trongThongTinNHCT();
    				}

    			} 
			}
		});
		
		//panel_3.add(scrollPane, gbc_scrollPane);
		
		JPanel panel_8 = new JPanel();
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 3;
		add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_8 = new GridBagLayout();
		gbl_panel_8.columnWidths = new int[]{0};
		gbl_panel_8.rowHeights = new int[]{0, 0};
		gbl_panel_8.columnWeights = new double[]{1.0};
		gbl_panel_8.rowWeights = new double[]{0.1, 1.0};
		panel_8.setLayout(gbl_panel_8);
		
		JPanelAmination panel_11 = new JPanelAmination();
		panel_11.setBackgroundColor(bg_default);
		panel_11.setRadiusTopLeft(7);
		panel_11.setRadiusTopRighht(7);
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(0, 0, 0, 0);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		panel_8.add(panel_11, gbc_panel_11);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{0, 1, 0, 1, 0, 0};
		gbl_panel_11.rowHeights = new int[]{0};
		gbl_panel_11.columnWeights = new double[]{1.0, 0.0, 1.0, 0.0, 1.0, 1.0};
		gbl_panel_11.rowWeights = new double[]{1.0};
		panel_11.setLayout(gbl_panel_11);
		
		panel_13 = new JPanelAmination();
		panel_13.setRadiusTopLeft(20);
		panel_13.setRadiusTopRighht(20);
		panel_13.setBackgroundColor(bg_selected);

		GridBagConstraints gbc_panel_13 = new GridBagConstraints();
		gbc_panel_13.insets = new Insets(4, 4, 0, 0);
		gbc_panel_13.fill = GridBagConstraints.BOTH;
		gbc_panel_13.gridx = 0;
		gbc_panel_13.gridy = 0;
		panel_11.add(panel_13, gbc_panel_13);
		GridBagLayout gbl_panel_13 = new GridBagLayout();
		gbl_panel_13.columnWidths = new int[]{0};
		gbl_panel_13.rowHeights = new int[]{0};
		gbl_panel_13.columnWeights = new double[]{1.0};
		gbl_panel_13.rowWeights = new double[]{1.0};
		panel_13.setLayout(gbl_panel_13);
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin lộ trình");
		lblNewLabel_2.setForeground(txtColor);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 0;
		panel_13.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		panel_16 = new JPanel();
		panel_16.setBackground(bg_default);
		panel_16.setMinimumSize(new Dimension(3, 10));
		GridBagConstraints gbc_panel_16 = new GridBagConstraints();
		gbc_panel_16.fill = GridBagConstraints.BOTH;
		gbc_panel_16.insets = new Insets(8, 0, 2, 0);
		gbc_panel_16.gridx = 1;
		gbc_panel_16.gridy = 0;
		panel_11.add(panel_16, gbc_panel_16);
		GridBagLayout gbl_panel_16 = new GridBagLayout();
		gbl_panel_16.columnWidths = new int[]{0};
		gbl_panel_16.rowHeights = new int[]{0};
		gbl_panel_16.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_16.rowWeights = new double[]{Double.MIN_VALUE};
		panel_16.setLayout(gbl_panel_16);
		
		panel_14 = new JPanelAmination();
		panel_14.setRadiusTopLeft(20);
		panel_14.setRadiusTopRighht(20);
		panel_14.setBackgroundColor(bg_default);
		GridBagConstraints gbc_panel_14 = new GridBagConstraints();
		gbc_panel_14.fill = GridBagConstraints.BOTH;
		gbc_panel_14.insets = new Insets(4, 0, 0, 0);
		gbc_panel_14.gridx = 2;
		gbc_panel_14.gridy = 0;
		panel_11.add(panel_14, gbc_panel_14);
		GridBagLayout gbl_panel_14 = new GridBagLayout();
		gbl_panel_14.columnWidths = new int[]{0};
		gbl_panel_14.rowHeights = new int[]{0};
		gbl_panel_14.columnWeights = new double[]{1.0};
		gbl_panel_14.rowWeights = new double[]{1.0};
		panel_14.setLayout(gbl_panel_14);
		
		JLabel lblNewLabel_3 = new JLabel("Thông tin nhà hàng, khách sạn");
		lblNewLabel_3.setForeground(txtColor);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 0;
		panel_14.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		panel_17 = new JPanel();
		panel_17.setMinimumSize(new Dimension(3, 10));
		panel_17.setBackground(bg_selected);
		GridBagConstraints gbc_panel_17 = new GridBagConstraints();
		gbc_panel_17.insets = new Insets(8, 0, 2, 0);
		gbc_panel_17.fill = GridBagConstraints.BOTH;
		gbc_panel_17.gridx = 3;
		gbc_panel_17.gridy = 0;
		panel_11.add(panel_17, gbc_panel_17);
		GridBagLayout gbl_panel_17 = new GridBagLayout();
		gbl_panel_17.columnWidths = new int[]{0};
		gbl_panel_17.rowHeights = new int[]{0};
		gbl_panel_17.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_17.rowWeights = new double[]{Double.MIN_VALUE};
		panel_17.setLayout(gbl_panel_17);
		
		panel_15 = new JPanelAmination();
		panel_15.setRadiusTopLeft(20);
		panel_15.setRadiusTopRighht(20);
		panel_15.setBackgroundColor(bg_default);
		GridBagConstraints gbc_panel_15 = new GridBagConstraints();
		gbc_panel_15.insets = new Insets(4, 0, 0, 0);
		gbc_panel_15.fill = GridBagConstraints.BOTH;
		gbc_panel_15.gridx = 4;
		gbc_panel_15.gridy = 0;
		
		panel_11.add(panel_15, gbc_panel_15);
		
		GridBagLayout gbl_panel_15 = new GridBagLayout();
		gbl_panel_15.columnWidths = new int[]{0};
		gbl_panel_15.rowHeights = new int[]{0};
		gbl_panel_15.columnWeights = new double[]{1.0};
		gbl_panel_15.rowWeights = new double[]{1.0};
		panel_15.setLayout(gbl_panel_15);
		
		JLabel lblNewLabel_4 = new JLabel("Thông tin chiết tính");
		lblNewLabel_4.setForeground(txtColor);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel_15.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		panel_12 = new JPanel();
		GridBagConstraints gbc_panel_12 = new GridBagConstraints();
		gbc_panel_12.fill = GridBagConstraints.BOTH;
		gbc_panel_12.gridx = 0;
		gbc_panel_12.gridy = 1;
		panel_8.add(panel_12, gbc_panel_12);
		panel_12.setLayout(card_1);
		
		thongTinLoTrinh = new JPanel();
		thongTinLoTrinh.setBackground(bg_selected);
		panel_12.add(thongTinLoTrinh, "thongTinLoTrinh");
		GridBagLayout gbl_thongTinLoTrinh = new GridBagLayout();
		gbl_thongTinLoTrinh.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_thongTinLoTrinh.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_thongTinLoTrinh.columnWeights = new double[]{0.0, 1.0, 0.2, 0.0, 1.0};
		gbl_thongTinLoTrinh.rowWeights = new double[]{0.5, 1.0, 1.0, 1.0, 0.5};
		thongTinLoTrinh.setLayout(gbl_thongTinLoTrinh);
		
		lblNewLabel_19 = new JLabel("Ngày đi : ");
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_19.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_19.gridx = 0;
		gbc_lblNewLabel_19.gridy = 1;
		thongTinLoTrinh.add(lblNewLabel_19, gbc_lblNewLabel_19);
		
		txtNgayDi = new JTextField();
		disableTxtField(txtNgayDi);
		GridBagConstraints gbc_txtNgayDi = new GridBagConstraints();
		gbc_txtNgayDi.insets = new Insets(0, 0, 5, 10);
		gbc_txtNgayDi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNgayDi.gridx = 1;
		gbc_txtNgayDi.gridy = 1;
		thongTinLoTrinh.add(txtNgayDi, gbc_txtNgayDi);
		txtNgayDi.setColumns(10);
		
		JLabel lblNewLabel_22 = new JLabel("Ngày về : ");
		GridBagConstraints gbc_lblNewLabel_22 = new GridBagConstraints();
		gbc_lblNewLabel_22.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_22.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_22.gridx = 3;
		gbc_lblNewLabel_22.gridy = 1;
		thongTinLoTrinh.add(lblNewLabel_22, gbc_lblNewLabel_22);
		
		txtNgayVe = new JTextField();
		disableTxtField(txtNgayVe);

		GridBagConstraints gbc_txtNgayVe = new GridBagConstraints();
		gbc_txtNgayVe.insets = new Insets(0, 0, 5, 10);
		gbc_txtNgayVe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNgayVe.gridx = 4;
		gbc_txtNgayVe.gridy = 1;
		thongTinLoTrinh.add(txtNgayVe, gbc_txtNgayVe);
		txtNgayVe.setColumns(10);
		
		lblNewLabel_20 = new JLabel("Giờ đi : ");
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_20.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_20.gridx = 0;
		gbc_lblNewLabel_20.gridy = 2;
		thongTinLoTrinh.add(lblNewLabel_20, gbc_lblNewLabel_20);
		
		txtGioDi = new JTextField();
		disableTxtField(txtGioDi);

		GridBagConstraints gbc_txtGioDi = new GridBagConstraints();
		gbc_txtGioDi.insets = new Insets(0, 0, 5, 10);
		gbc_txtGioDi.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGioDi.gridx = 1;
		gbc_txtGioDi.gridy = 2;
		thongTinLoTrinh.add(txtGioDi, gbc_txtGioDi);
		txtGioDi.setColumns(10);
		
		JLabel lblNewLabel_23 = new JLabel("Giờ về : ");
		GridBagConstraints gbc_lblNewLabel_23 = new GridBagConstraints();
		gbc_lblNewLabel_23.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_23.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_23.gridx = 3;
		gbc_lblNewLabel_23.gridy = 2;
		thongTinLoTrinh.add(lblNewLabel_23, gbc_lblNewLabel_23);
		
		txtGioVe = new JTextField();
		disableTxtField(txtGioVe);

		GridBagConstraints gbc_txtGioVe = new GridBagConstraints();
		gbc_txtGioVe.insets = new Insets(0, 0, 5, 10);
		gbc_txtGioVe.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGioVe.gridx = 4;
		gbc_txtGioVe.gridy = 2;
		thongTinLoTrinh.add(txtGioVe, gbc_txtGioVe);
		txtGioVe.setColumns(10);
		
		JLabel lblNewLabel_21 = new JLabel("Điểm đón : ");
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_21.gridx = 0;
		gbc_lblNewLabel_21.gridy = 3;
		thongTinLoTrinh.add(lblNewLabel_21, gbc_lblNewLabel_21);
		
		txtDiemDon = new JTextField();
		disableTxtField(txtDiemDon);

		GridBagConstraints gbc_txtDiemDon = new GridBagConstraints();
		gbc_txtDiemDon.insets = new Insets(0, 0, 5, 10);
		gbc_txtDiemDon.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiemDon.gridx = 1;
		gbc_txtDiemDon.gridy = 3;
		thongTinLoTrinh.add(txtDiemDon, gbc_txtDiemDon);
		txtDiemDon.setColumns(10);
		
		lblNewLabel_24 = new JLabel("Điểm đến : ");
		GridBagConstraints gbc_lblNewLabel_24 = new GridBagConstraints();
		gbc_lblNewLabel_24.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_24.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_24.gridx = 3;
		gbc_lblNewLabel_24.gridy = 3;
		thongTinLoTrinh.add(lblNewLabel_24, gbc_lblNewLabel_24);
		
		txtDiemDen = new JTextField();
		disableTxtField(txtDiemDen);

		GridBagConstraints gbc_txtDiemDen = new GridBagConstraints();
		gbc_txtDiemDen.insets = new Insets(0, 0, 5, 10);
		gbc_txtDiemDen.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDiemDen.gridx = 4;
		gbc_txtDiemDen.gridy = 3;
		thongTinLoTrinh.add(txtDiemDen, gbc_txtDiemDen);
		txtDiemDen.setColumns(10);
		
		thongTinNHKS = new JPanel();		
		thongTinNHKS.setBackground(bg_selected);
		panel_12.add(thongTinNHKS, "thongTinNHKS");
		
		GridBagLayout gbl_thongTinNHKS = new GridBagLayout();
		gbl_thongTinNHKS.columnWidths = new int[]{0, 2, 200};
		gbl_thongTinNHKS.rowHeights = new int[]{0};
		gbl_thongTinNHKS.columnWeights = new double[]{0.4, 0.0, 1.0};
		gbl_thongTinNHKS.rowWeights = new double[]{1.0};
		thongTinNHKS.setLayout(gbl_thongTinNHKS);
		
		panel_18 = new JPanel();
		panel_18.setOpaque(false);
		GridBagConstraints gbc_panel_18 = new GridBagConstraints();
		gbc_panel_18.insets = new Insets(0, 7, 0, 7);
		gbc_panel_18.fill = GridBagConstraints.BOTH;
		gbc_panel_18.gridx = 0;
		gbc_panel_18.gridy = 0;
		thongTinNHKS.add(panel_18, gbc_panel_18);
		GridBagLayout gbl_panel_18 = new GridBagLayout();
		gbl_panel_18.columnWidths = new int[]{0, 0, 0};
		gbl_panel_18.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_18.columnWeights = new double[]{0.0, 0.0, 1.0};
		gbl_panel_18.rowWeights = new double[]{0.8, 0.0, 0.0, 0.0, 1.0};
		panel_18.setLayout(gbl_panel_18);
		
		lblNewLabel_6 = new JLabel("Thông tin nhà hàng");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_6.gridwidth = 2;
		gbc_lblNewLabel_6.insets = new Insets(10, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 0;
		panel_18.add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		lblNewLabel_5 = new JLabel("Tên nhà hàng: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 1;
		panel_18.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		txtTenNH = new JTextField();
		
		GridBagConstraints gbc_txtTenNH = new GridBagConstraints();
		gbc_txtTenNH.insets = new Insets(0, 0, 5, 0);
		gbc_txtTenNH.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenNH.gridx = 2;
		gbc_txtTenNH.gridy = 1;
		panel_18.add(txtTenNH, gbc_txtTenNH);
		txtTenNH.setColumns(10);
		
		lblNewLabel_7 = new JLabel("Mã nhà cung cấp: ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 2;
		panel_18.add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		txtMaNCCNH = new JTextField();
		GridBagConstraints gbc_txtMaNCCNH = new GridBagConstraints();
		gbc_txtMaNCCNH.insets = new Insets(0, 0, 5, 0);
		gbc_txtMaNCCNH.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMaNCCNH.gridx = 2;
		gbc_txtMaNCCNH.gridy = 2;
		panel_18.add(txtMaNCCNH, gbc_txtMaNCCNH);
		txtMaNCCNH.setColumns(10);
		
		lblNewLabel_8 = new JLabel("Giá: ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_8.gridx = 1;
		gbc_lblNewLabel_8.gridy = 3;
		panel_18.add(lblNewLabel_8, gbc_lblNewLabel_8);
		
		txtGiaNH = new JTextField();
		GridBagConstraints gbc_txtGiaNH = new GridBagConstraints();
		gbc_txtGiaNH.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGiaNH.gridx = 2;
		gbc_txtGiaNH.gridy = 3;
		panel_18.add(txtGiaNH, gbc_txtGiaNH);
		txtGiaNH.setColumns(10);
		
		panel_20 = new JPanel();
		GridBagConstraints gbc_panel_20 = new GridBagConstraints();
		gbc_panel_20.insets = new Insets(7, 0, 10, 0);
		gbc_panel_20.fill = GridBagConstraints.BOTH;
		gbc_panel_20.gridx = 1;
		gbc_panel_20.gridy = 0;
		thongTinNHKS.add(panel_20, gbc_panel_20);
		GridBagLayout gbl_panel_20 = new GridBagLayout();
		gbl_panel_20.columnWidths = new int[]{0};
		gbl_panel_20.rowHeights = new int[]{0};
		gbl_panel_20.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_20.rowWeights = new double[]{Double.MIN_VALUE};
		panel_20.setLayout(gbl_panel_20);
		
		panel_19 = new JPanel();
		panel_19.setOpaque(false);
		GridBagConstraints gbc_panel_19 = new GridBagConstraints();
		gbc_panel_19.fill = GridBagConstraints.BOTH;
		gbc_panel_19.insets = new Insets(0, 7, 0, 4);

		gbc_panel_19.gridx = 2;
		gbc_panel_19.gridy = 0;
		thongTinNHKS.add(panel_19, gbc_panel_19);
		GridBagLayout gbl_panel_19 = new GridBagLayout();
		gbl_panel_19.columnWidths = new int[]{0, 0, 0, 2, 0, 0};
		gbl_panel_19.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_19.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0};
		gbl_panel_19.rowWeights = new double[]{0.8, 0.0, 0.0, 0.0, 1.0};
		panel_19.setLayout(gbl_panel_19);
		
		lblNewLabel_9 = new JLabel("Thông tin khách sạn");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_9 = new GridBagConstraints();
		gbc_lblNewLabel_9.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_9.gridwidth = 5;
		gbc_lblNewLabel_9.insets = new Insets(10, 0, 5, 0);
		gbc_lblNewLabel_9.gridx = 1;
		gbc_lblNewLabel_9.gridy = 0;
		panel_19.add(lblNewLabel_9, gbc_lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("Tên khách sạn: ");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 1;
		gbc_lblNewLabel_10.gridy = 1;
		panel_19.add(lblNewLabel_10, gbc_lblNewLabel_10);
		
		txtTenKS = new JTextField();
		GridBagConstraints gbc_txtTenKS = new GridBagConstraints();
		gbc_txtTenKS.insets = new Insets(0, 0, 5, 5);
		gbc_txtTenKS.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtTenKS.gridx = 2;
		gbc_txtTenKS.gridy = 1;
		panel_19.add(txtTenKS, gbc_txtTenKS);
		txtTenKS.setColumns(10);
		
		lblNewLabel_12 = new JLabel("Loại phòng: ");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_12 = new GridBagConstraints();
		gbc_lblNewLabel_12.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_12.gridx = 4;
		gbc_lblNewLabel_12.gridy = 1;
		panel_19.add(lblNewLabel_12, gbc_lblNewLabel_12);
		
		txtLoaiPhong = new JTextField();
		txtLoaiPhong.setColumns(10);
		GridBagConstraints gbc_txtLoaiPhong = new GridBagConstraints();
		gbc_txtLoaiPhong.insets = new Insets(0, 0, 5, 0);
		gbc_txtLoaiPhong.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLoaiPhong.gridx = 5;
		gbc_txtLoaiPhong.gridy = 1;
		panel_19.add(txtLoaiPhong, gbc_txtLoaiPhong);
		
		lblNewLabel_11 = new JLabel("Loại hình khách sạn: ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_11 = new GridBagConstraints();
		gbc_lblNewLabel_11.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_11.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_11.gridx = 1;
		gbc_lblNewLabel_11.gridy = 2;
		panel_19.add(lblNewLabel_11, gbc_lblNewLabel_11);
		
		txtLoaiHinhKS = new JTextField();
		txtLoaiHinhKS.setColumns(10);
		GridBagConstraints gbc_txtLoaiHinhKS = new GridBagConstraints();
		gbc_txtLoaiHinhKS.insets = new Insets(0, 0, 5, 5);
		gbc_txtLoaiHinhKS.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtLoaiHinhKS.gridx = 2;
		gbc_txtLoaiHinhKS.gridy = 2;
		panel_19.add(txtLoaiHinhKS, gbc_txtLoaiHinhKS);
		
		panel_21 = new JPanel();
		GridBagConstraints gbc_panel_21 = new GridBagConstraints();
		gbc_panel_21.gridheight = 3;
		gbc_panel_21.insets = new Insets(0, 0, 0, 0);
		gbc_panel_21.fill = GridBagConstraints.BOTH;
		gbc_panel_21.gridx = 3;
		gbc_panel_21.gridy = 1;
		panel_19.add(panel_21, gbc_panel_21);
		GridBagLayout gbl_panel_21 = new GridBagLayout();
		gbl_panel_21.columnWidths = new int[]{0};
		gbl_panel_21.rowHeights = new int[]{0};
		gbl_panel_21.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_21.rowWeights = new double[]{Double.MIN_VALUE};
		panel_21.setLayout(gbl_panel_21);
		
		lblNewLabel_13 = new JLabel("Mã nhà cung cấp: ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_13.insets = new Insets(0, 4, 5, 5);
		gbc_lblNewLabel_13.gridx = 4;
		gbc_lblNewLabel_13.gridy = 2;
		panel_19.add(lblNewLabel_13, gbc_lblNewLabel_13);
		
		txtNCCKS = new JTextField();
		txtNCCKS.setColumns(10);
		GridBagConstraints gbc_txtNCCKS = new GridBagConstraints();
		gbc_txtNCCKS.insets = new Insets(0, 0, 5, 0);
		gbc_txtNCCKS.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNCCKS.gridx = 5;
		gbc_txtNCCKS.gridy = 2;
		panel_19.add(txtNCCKS, gbc_txtNCCKS);
		
		lblNewLabel_14 = new JLabel("Giá: ");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_14 = new GridBagConstraints();
		gbc_lblNewLabel_14.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_14.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_14.gridx = 1;
		gbc_lblNewLabel_14.gridy = 3;
		panel_19.add(lblNewLabel_14, gbc_lblNewLabel_14);
		
		txtGiaKS = new JTextField();
		txtGiaKS.setColumns(10);
		GridBagConstraints gbc_txtGiaKS = new GridBagConstraints();
		gbc_txtGiaKS.insets = new Insets(0, 0, 5, 5);
		gbc_txtGiaKS.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGiaKS.gridx = 2;
		gbc_txtGiaKS.gridy = 3;
		panel_19.add(txtGiaKS, gbc_txtGiaKS);
		
		thongTinChietTinh = new JPanel();
		thongTinChietTinh.setBackground(bg_selected);
		panel_12.add(thongTinChietTinh, "thongTinChietTinh");
		GridBagLayout gbl_thongTinChietTinh = new GridBagLayout();
		gbl_thongTinChietTinh.columnWidths = new int[]{30, 130, 250, 50, 100, 250};
		gbl_thongTinChietTinh.rowHeights = new int[]{0, 0, 0, 0};
		gbl_thongTinChietTinh.columnWeights = new double[]{0.4, 0.0, 1.0, 0.5, 0.0, 0.01};
		gbl_thongTinChietTinh.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		thongTinChietTinh.setLayout(gbl_thongTinChietTinh);
		
		lblNewLabel_15 = new JLabel("Giá nhà hàng: ");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_15 = new GridBagConstraints();
		gbc_lblNewLabel_15.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_15.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_15.gridx = 1;
		gbc_lblNewLabel_15.gridy = 1;
		thongTinChietTinh.add(lblNewLabel_15, gbc_lblNewLabel_15);
		
		txtGiaNH_1 = new JTextField();
		GridBagConstraints gbc_txtGiaNH_1 = new GridBagConstraints();
		gbc_txtGiaNH_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtGiaNH_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGiaNH_1.gridx = 2;
		gbc_txtGiaNH_1.gridy = 1;
		thongTinChietTinh.add(txtGiaNH_1, gbc_txtGiaNH_1);
		txtGiaNH_1.setColumns(10);
		
		lblNewLabel_18 = new JLabel("Ghi chú: ");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_18.gridx = 4;
		gbc_lblNewLabel_18.gridy = 1;
		thongTinChietTinh.add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		txtGhiChu = new JEditorPane() {
			@Override
		     protected void paintComponent(Graphics g) {
		        super.paintComponent(g);
		        Dimension arcs = new Dimension(15,15);
		        int width = getWidth();
		        int height = getHeight();
		        Graphics2D graphics = (Graphics2D) g;
		        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);


		        //Draws the rounded panel with borders.
		        graphics.setColor(getBackground());
		        graphics.fillRoundRect(0, 0, width-1, height-1, arcs.width, arcs.height);//paint background
		     }
		};
		txtGhiChu.setOpaque(false);
		txtGhiChu.setEnabled(false);
		txtGhiChu.setBackground(new Color(240, 240, 240));
		GridBagConstraints gbc_txtGhiChu = new GridBagConstraints();
		gbc_txtGhiChu.gridheight = 3;
		gbc_txtGhiChu.insets = new Insets(0, 0, 5, 40);
		gbc_txtGhiChu.fill = GridBagConstraints.BOTH;
		gbc_txtGhiChu.gridx = 5;
		gbc_txtGhiChu.gridy = 1;
		thongTinChietTinh.add(txtGhiChu, gbc_txtGhiChu);
		
		lblNewLabel_16 = new JLabel("Giá khách sạn: ");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_16 = new GridBagConstraints();
		gbc_lblNewLabel_16.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_16.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_16.gridx = 1;
		gbc_lblNewLabel_16.gridy = 2;
		thongTinChietTinh.add(lblNewLabel_16, gbc_lblNewLabel_16);
		
		txtGiaKS_1 = new JTextField();
		GridBagConstraints gbc_txtGiaKS_1 = new GridBagConstraints();
		gbc_txtGiaKS_1.insets = new Insets(0, 0, 5, 5);
		gbc_txtGiaKS_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGiaKS_1.gridx = 2;
		gbc_txtGiaKS_1.gridy = 2;
		thongTinChietTinh.add(txtGiaKS_1, gbc_txtGiaKS_1);
		txtGiaKS_1.setColumns(10);
		
		lblNewLabel_17 = new JLabel("Giá dịch vụ tour: ");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_17.gridx = 1;
		gbc_lblNewLabel_17.gridy = 3;
		thongTinChietTinh.add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		txtGiaDVTour = new JTextField();
		GridBagConstraints gbc_txtGiaDVTour = new GridBagConstraints();
		gbc_txtGiaDVTour.insets = new Insets(0, 0, 0, 5);
		gbc_txtGiaDVTour.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGiaDVTour.gridx = 2;
		gbc_txtGiaDVTour.gridy = 3;
		thongTinChietTinh.add(txtGiaDVTour, gbc_txtGiaDVTour);
		txtGiaDVTour.setColumns(10);
		
		AddEvents();
		
		panel_1.addMouseListener(this);
		panel_2.addMouseListener(this);
		panel_13.addMouseListener(this);
		panel_14.addMouseListener(this);
		panel_15.addMouseListener(this);
		
		
		disableTxtField(txtTenNH);
		disableTxtField(txtTenKS);
		disableTxtField(txtMaNCCNH);
		disableTxtField(txtNCCKS);
		disableTxtField(txtGiaNH);
		disableTxtField(txtGiaKS);
		disableTxtField(txtLoaiPhong);
		disableTxtField(txtLoaiHinhKS);
		
		disableTxtField(txtGiaNH_1);
		disableTxtField(txtGiaKS_1);
		disableTxtField(txtGiaDVTour);
		
		tourMoBan.getBtnLamMoi().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				maDVTourChietTinh = -1;
				trongThongTin();
			}
		});
		
		tourSanPham.getBtnLamMoi().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				maDVTourChietTinh = -1;
				trongThongTin();
			}
		});
		
		
		
		t.start();
		pause();
		
		if (!phanQuyenBUS.admin(maNVDN)) {
			PhanQuyen phanQuyen = new PhanQuyen();
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Thêm dịch vụ");
			if (phanQuyen == null) 
				duocThem = false;
			
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Xóa dịch vụ");
			if (phanQuyen == null)  {
				tourMoBan.setDuocXoa(false);
				tourSanPham.setDuocXoa(false);
			}
		}
		
		if (!duocThem) {
			btnThem.setEnabled(false);
			btnChietTinh.setEnabled(false);
		}
		
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if (e.getSource() == panel_1) {
			panel_1.setBackgroundColor(bg_selected);
			panel_2.setBackgroundColor(bg_default);
			flag = false;
			card.show(panel_3, "tourSanPham");
		}else if (e.getSource() == panel_2) {
			panel_2.setBackgroundColor(bg_selected);
			panel_1.setBackgroundColor(bg_default);
			flag = true;
			card.show(panel_3, "tourMoBan");
		} else if (e.getSource() == panel_13) {
			panel_13.setBackgroundColor(bg_selected);
			panel_14.setBackgroundColor(bg_default);
			panel_15.setBackgroundColor(bg_default);
			panel_17.setBackground(bg_selected);
			panel_16.setBackground(bg_default);
			
			card_1.show(panel_12, "thongTinLoTrinh");
		} else if (e.getSource() == panel_14) {
			panel_14.setBackgroundColor(bg_selected);
			panel_13.setBackgroundColor(bg_default);
			panel_15.setBackgroundColor(bg_default);
			
			panel_17.setBackground(bg_default);
			panel_16.setBackground(bg_default);
			card_1.show(panel_12, "thongTinNHKS");
		} else if (e.getSource() == panel_15) {
			panel_15.setBackgroundColor(bg_selected);
			panel_14.setBackgroundColor(bg_default);
			panel_13.setBackgroundColor(bg_default);
			
			panel_16.setBackground(bg_selected);
			panel_17.setBackground(bg_default);
			card_1.show(panel_12, "thongTinChietTinh");
		}
	}
	
	public void trongThongTin() {
		txtDiemDen.setText("");
		txtDiemDon.setText("");
		txtGhiChu.setText("");
		txtGiaDVTour.setText("");
		txtGiaKS.setText("");
		txtGiaKS_1.setText("");
		txtGiaNH.setText("");
		txtGiaNH_1.setText("");
		txtGioDi.setText("");
		txtGioVe.setText("");
		txtLoaiHinhKS.setText("");
		txtLoaiPhong.setText("");
		txtMaNCCNH.setText("");
		txtNCCKS.setText("");
		txtNgayDi.setText("");
		txtNgayVe.setText("");
		txtTenKS.setText("");
		txtTenNH.setText("");
	}
	
	public void trongThongTinNHCT() {
		txtGhiChu.setText("");
		txtGiaDVTour.setText("");
		txtGiaKS.setText("");
		txtGiaKS_1.setText("");
		txtGiaNH.setText("");
		txtGiaNH_1.setText("");
		txtLoaiHinhKS.setText("");
		txtLoaiPhong.setText("");
		txtMaNCCNH.setText("");
		txtNCCKS.setText("");
		txtTenKS.setText("");
		txtTenNH.setText("");
	}
	
	public void resum() {
		t.resume();
	}
	
	public void pause() {
		t.suspend();
	}
	
	public void AddEvents() {
		
		btnThem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					
					DialogThemTourMoBan dialog = new DialogThemTourMoBan(null, "Thêm tour mở bán");
					dialog.getBtnDongY().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							flag_2 = true;	
						}
					});
					dialog.setModal(true);
					dialog.setLocationRelativeTo(TrangChinh.getFrames()[0]);
					dialog.setVisible(true);
					
					
					
				} else {
					DialogThemTourSanPham dialogThemTourSP = new DialogThemTourSanPham(null, "Thêm tour sản phẩm");

					dialogThemTourSP.getBtnDongY().addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							flag_2 = true;
						}
					});
					dialogThemTourSP.setModal(true);
					dialogThemTourSP.setLocationRelativeTo(TrangChinh.getFrames()[0]);
					dialogThemTourSP.setVisible(true);
					
				}
			}
		});
		
		btnChietTinh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (flag) {
					if (tourMoBan.getMaTour() != 0) {
						DialogChietTinhTour dialog = new DialogChietTinhTour(null, "Chiết tính", tourMoBan.getMaTour(), maNVDN);
						dialog.getBtnDongY().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								flag_2 = true;
							}
						});
						dialog.setModal(true);
						dialog.setLocationRelativeTo(TrangChinh.getFrames()[0]);
						dialog.setVisible(true);
						
					} else {
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
				                "Bạn chưa chọn dịch vụ để chiết tinh!",
				                "Thông báo!!!",
				                JOptionPane.WARNING_MESSAGE);
					}
				} else {
					if (tourSanPham.getMaTourSP() !=0 ) {
						DialogChietTinhTour dialog = new DialogChietTinhTour(null, "Chiết tính", tourSanPham.getMaTourSP(), maNVDN);
						dialog.getBtnDongY().addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub
								flag_2 = true;
							}
						});
						dialog.setModal(true);
						dialog.setLocationRelativeTo(TrangChinh.getFrames()[0]);
						dialog.setVisible(true);
						
						
						
					} else {
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
				                "Bạn chưa chọn dịch vụ để chiết tinh!",
				                "Thông báo!!!",
				                JOptionPane.WARNING_MESSAGE);
					}
				}
			}
		});
	}
	

	public void disableTxtField(JTextField txt) {
		txt.setBackground(bg_selected);
		txt.setBorder(null);
		txt.setDisabledTextColor(Color.BLACK);
		txt.setFont(new Font("Tahoma", Font.BOLD, 14));
		txt.setEnabled(false);
	}
	
	
	Thread t=new Thread()

	{

		public void run(){
            
    		Dimension size= lblContent.getPreferredSize();
    		float x = size.width * 3 /2;
    		while(true){
    			
    			if (flag_2) {
    				if (!flag) {
    					kkk++;
    					if (kkk == 30) {
    						trongThongTin();
    						tourSanPham.getBtnLamMoi().doClick();
    						kkk = 0;
    						flag_2 = false;
    					}
    				} else {
    					kkk++;
    					if (kkk == 30) {
    						trongThongTin();
    						tourMoBan.getBtnLamMoi().doClick();
    						kkk = 0;
    						flag_2 = false;
    					}
    				}
    			}
    			
    			 if(x + size.width == 0){
                 	x = panel_3.getWidth();
                 	lblContent.setBounds((int)x, 2,size.width,size.height);
                 }else{
                 	x-=1.0;
                 	lblContent.setBounds((int)x, 2,size.width,size.height);
                     try {
     					t.sleep(30);
     				} catch (InterruptedException e) {
     					// TODO Auto-generated catch block
     					e.printStackTrace();
     				}
                 }
                
            }
        }

	};
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_19;
	private JLabel lblNewLabel_5;
	private JPanel panel_20;
	private JLabel lblNewLabel_6;
	private JTextField txtTenNH;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JTextField txtMaNCCNH;
	private JTextField txtGiaNH;
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JLabel lblNewLabel_14;
	private JTextField txtTenKS;
	private JTextField txtLoaiHinhKS;
	private JTextField txtLoaiPhong;
	private JTextField txtNCCKS;
	private JTextField txtGiaKS;
	private JPanel panel_21;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JTextField txtGiaNH_1;
	private JTextField txtGiaKS_1;
	private JTextField txtGiaDVTour;
	private JLabel lblNewLabel_18;
	private JEditorPane txtGhiChu;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JLabel lblNewLabel_24;
	private JTextField txtNgayDi;
	private JTextField txtGioDi;
	private JTextField txtDiemDon;
	private JTextField txtNgayVe;
	private JTextField txtGioVe;
	private JTextField txtDiemDen;


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
}
