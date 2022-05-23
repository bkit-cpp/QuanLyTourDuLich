package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.CheDo_BUS;
import BUS.KhachSan_BUS;
import BUS.NguoiDung_BUS;
import BUS.NhaCungCap_BUS;
import BUS.PhanQuyen_BUS;
import DTO.PhanQuyen;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class KhachSan extends JPanel{
	private JLabel lblContent;
	private JButton btnNewButtonThem,btnNewButton_Sua,btnNewButton_Xoa,btnNewButton_TimKiem;
	private JPanel panel_33;
	private TextFielAmination tfgia, tftenks, tfmaks, tfmancc;
	private JTable table;
	private Object[] row = new Object[6];
	private static int rowSelected=0;
	private DefaultTableModel model;
	 private KhachSan_BUS khachsanBus=new KhachSan_BUS();
    private ArrayList<DTO.KhachSan> ksList=new ArrayList<>();
	private NguoiDung_BUS ndBUS = new NguoiDung_BUS();

	private boolean laAdmin = false;
	
	private Color bg_menu_item = new Color(111, 211, 178);

	private boolean cheDo = true;
	private Color txtColor = Color.white;

	private PhanQuyen_BUS phanQuyenBUS = new PhanQuyen_BUS();
    private boolean duocThem = true;
	private boolean duocXoa = true;
	private boolean duocSua = true;
    
	public KhachSan(int maNVDN) {
		
		CheDo_BUS cdBUS = new CheDo_BUS();
		cheDo = cdBUS.readClientList();
		
		if (!cheDo) {
			CheDoMau mau = new CheDoMau();
			bg_menu_item = mau.getMauPhuSang();
			txtColor = new Color(230, 230, 230);

		}
		setBackground(bg_menu_item);
		initialize(maNVDN);
	}

	private void initialize(int maNVDN) {
		
		
		
		if (ndBUS.admin(maNVDN)) {
			laAdmin = true;
		}
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0};
		gbl_panel.rowHeights = new int[]{90, 120, 90, 290};
		gbl_panel.columnWeights = new double[]{1.0};
		gbl_panel.rowWeights = new double[]{0.25, 0.1, 0.5, 1.9};
		setLayout(gbl_panel);
		
		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(5, 5, 40, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		add(panel_11, gbc_panel_11);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[]{0};
		gbl_panel_11.rowHeights = new int[]{0};
		gbl_panel_11.columnWeights = new double[]{1.0};
		gbl_panel_11.rowWeights = new double[]{1.0};
		panel_11.setLayout(gbl_panel_11);
		add(panel_11, gbc_panel_11);
		
		panel_33 = new JPanel();
		panel_33.setBackground(bg_menu_item);
		panel_33.setLayout(null);
		GridBagConstraints gbc_panel_33 = new GridBagConstraints();
		gbc_panel_33.fill = GridBagConstraints.BOTH;
		gbc_panel_33.insets = new Insets(4, 4, 4, 4);
		gbc_panel_33.gridx = 0;
		gbc_panel_33.gridy = 0;
		panel_11.add(panel_33, gbc_panel_33);
		
	    lblContent = new JLabel("Chào mừng bạn đến với giao diện quản lý khách sạn!");
		lblContent.setBounds(21, 0, 633, 33);
		lblContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		panel_33.add(lblContent);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(bg_menu_item);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 10);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 100, 0, 0, 0, 100};
		gbl_panel_1.rowHeights = new int[]{30, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.5, 1.0, 0.5, 0.0, 0.5, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.7, 0.6};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Tên khách sạn : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		tftenks = new TextFielAmination();
		tftenks.setRadius(10);
		tftenks.setMinimumSize(new Dimension(70, 25));
		tftenks.setBackground(txtColor);
		tftenks.setBorder(new EmptyBorder(0, 5, 0, 5));
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 12, 0);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		panel_1.add(tftenks, gbc_textField);
		tftenks.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mã khách sạn : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tfmaks = new TextFielAmination();
		tfmaks.setRadius(10);
		tfmaks.setBackground(txtColor);
		tfmaks.setMinimumSize(new Dimension(70, 25));
		tfmaks.setBorder(new EmptyBorder(0, 5, 0, 5));
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 12, 0);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 6;
		gbc_textField_1.gridy = 0;
		panel_1.add(tfmaks, gbc_textField_1);
		tfmaks.setColumns(10);
		
		lblNewLabel_5 = new JLabel("Loại hình khách sạn : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 1;
		panel_1.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		String[] comboloaihinh= {"Khách sạn bình dân","Khách sạn căn hộ"};
		comboBoxloaihinh = new JComboBox(comboloaihinh);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 8, 0);
		gbc_comboBox.fill = GridBagConstraints.VERTICAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 1;
		panel_1.add(comboBoxloaihinh, gbc_comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhà cung cấp : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 10, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfmancc = new TextFielAmination();
		tfmancc.setRadius(10);
		tfmancc.setBackground(txtColor);
		tfmancc.setMinimumSize(new Dimension(70, 25));
		tfmancc.setBorder(new EmptyBorder(0, 5, 0, 5));
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 12, 0);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 6;
		gbc_textField_3.gridy = 1;
		panel_1.add(tfmancc, gbc_textField_3);
		tfmancc.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Loại phòng : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 2;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		String[] loaiphong= {"Thường","VIP"};
		comboBoxloaiphong = new JComboBox(loaiphong);
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.anchor = GridBagConstraints.WEST;
		gbc_comboBox_1.insets = new Insets(0, 0, 8, 0);
		gbc_comboBox_1.fill = GridBagConstraints.VERTICAL;
		gbc_comboBox_1.gridx = 2;
		gbc_comboBox_1.gridy = 2;
		panel_1.add(comboBoxloaiphong, gbc_comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Giá : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 2;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		tfgia = new TextFielAmination();
		tfgia.setRadius(10);
		tfgia.setBackground(txtColor);
		tfgia.setMinimumSize(new Dimension(70, 25));
		tfgia.setBorder(new EmptyBorder(0, 5, 0, 5));
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 12, 0);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 6;
		gbc_textField_2.gridy = 2;
		panel_1.add(tfgia, gbc_textField_2);
		tfgia.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(bg_menu_item);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(10, 0, 0, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.08, 0.3, 0.1, 0.2, 0.08, 0.3, 0.08};
		gbl_panel_2.rowWeights = new double[] {0.1, 0.5};
		panel_2.setLayout(gbl_panel_2);
		
		btnNewButtonThem = new BtnThem();
		btnNewButtonThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLiSuKienThem();
				tfgia.setText("");
				tftenks.setText("");
				tfmancc.setText("");
			}
		});
		GridBagConstraints gbc_btnNewButtonThem = new GridBagConstraints();
		gbc_btnNewButtonThem.fill = GridBagConstraints.BOTH;
		gbc_btnNewButtonThem.insets = new Insets(0, 20, 5, 15);
		gbc_btnNewButtonThem.gridx = 0;
		gbc_btnNewButtonThem.gridy = 0;
		panel_2.add(btnNewButtonThem, gbc_btnNewButtonThem);
		
		btnNewButton_Sua = new BtnSua();
		btnNewButton_Sua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLiSuKienSua();
				tfgia.setText("");
				tftenks.setText("");
				tfmancc.setText("");
			}
		});
		GridBagConstraints gbc_btnNewButton_Sua = new GridBagConstraints();
		gbc_btnNewButton_Sua.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_Sua.insets = new Insets(0, 0, 5, 15);
		gbc_btnNewButton_Sua.gridx = 2;
		gbc_btnNewButton_Sua.gridy = 0;
		panel_2.add(btnNewButton_Sua, gbc_btnNewButton_Sua);
		
		btnNewButton_Xoa = new BtnXoa();
		btnNewButton_Xoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLiSuKienXoa();
			}
		});
		GridBagConstraints gbc_btnNewButton_Xoa = new GridBagConstraints();
		gbc_btnNewButton_Xoa.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_Xoa.insets = new Insets(0, 0, 5, 15);
		gbc_btnNewButton_Xoa.gridx = 4;
		gbc_btnNewButton_Xoa.gridy = 0;
		panel_2.add(btnNewButton_Xoa, gbc_btnNewButton_Xoa);
		
		btnNewButton_TimKiem = new BtnTimKiem();
		btnNewButton_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiem();
				tfgia.setText("");
				tftenks.setText("");
			}
		});
		GridBagConstraints gbc_btnNewButton_TimKiem = new GridBagConstraints();
		gbc_btnNewButton_TimKiem.insets = new Insets(0, 0, 5, 20);
		gbc_btnNewButton_TimKiem.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_TimKiem.gridx = 6;
		gbc_btnNewButton_TimKiem.gridy = 0;
		panel_2.add(btnNewButton_TimKiem, gbc_btnNewButton_TimKiem);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 3;
		add(panel_3, gbc_panel_3);
		
		GridBagConstraints gbc_scrollpane = new GridBagConstraints();
		gbc_scrollpane .fill = GridBagConstraints.BOTH;
		gbc_scrollpane .gridx = 0;
		gbc_scrollpane .gridy = 0;
		
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0};
		gbl_panel_3.rowHeights = new int[]{0};
		gbl_panel_3.columnWeights = new double[]{0.1};
		gbl_panel_3.rowWeights = new double[]{0.1};
		panel_3.setLayout(gbl_panel_3);
		
		JScrollPane scollpane=new JScrollPane();
		GridBagConstraints gbc_scollpane = new GridBagConstraints();
		gbc_scollpane.fill = GridBagConstraints.BOTH;
		gbc_scollpane.gridx = 0;
		gbc_scollpane.gridy = 0;
		panel_3.add(scollpane, gbc_scollpane );
		
		table =new JTable();
		//table.setBackground(new Color(127, 211, 212));
		model=new DefaultTableModel();
		Object[] colum= {"Mã khách sạn","Loại hình khách sạn","Tên khách sạn","Mã nhà cung cấp","Loại phòng","Giá"};
		model.setColumnIdentifiers(colum);
		table.setModel(model);
	    scollpane.setViewportView(table);
		
	    table.addMouseListener(new MouseListener() {
			
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
				tableMouseClickes(e);
				
			}
		});
	    
  		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
  		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
  
  		for (int i = 0; i < 6; i++)
		table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
  
	    hienThiDS(ksList);
	    
	    if (!laAdmin) {
			PhanQuyen phanQuyen = new PhanQuyen();
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Thêm khách sạn");
			if (phanQuyen == null) {
				btnNewButtonThem.setEnabled(false);
			}
			
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Sửa khách sạn");
			if (phanQuyen == null) {
				btnNewButton_Sua.setEnabled(false);
			}
			
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Xóa khách sạn");
			if (phanQuyen == null) {
				btnNewButton_Xoa.setEnabled(false);
			}
		}
	    
	    t.start();
	}
	
	
	private void tableMouseClickes(MouseEvent evt) {
		int i=table.getSelectedRow();
		if(i>=0) {
			tfmaks.setText(model.getValueAt(i, 0).toString());
			//.setText(model.getValueAt(i, 2).toString());
			if(model.getValueAt(i, 1).toString().equals("Khách sạn bình dân")) //"Khach San Binh Dan","Khach san can ho"
				comboBoxloaihinh.setSelectedIndex(0);
			else
				comboBoxloaihinh.setSelectedIndex(1);
			tftenks.setText(model.getValueAt(i, 2).toString());
			tfmancc.setText(model.getValueAt(i, 3).toString());
			if(model.getValueAt(i, 4).toString().equals("Thường")) //"Khach San Binh Dan","Khach san can ho"
				comboBoxloaiphong.setSelectedIndex(0);
			else
				comboBoxloaiphong.setSelectedIndex(1);
			tfgia.setText(model.getValueAt(i, 5).toString());
			
		}
	}
	private void xuLiSuKienThem() {
		DTO.KhachSan ks = new DTO.KhachSan();
		ks.setTenKS(tftenks.getText());
		ks.setLoaihinhKS(comboBoxloaihinh.getItemAt(comboBoxloaihinh.getSelectedIndex()).toString());
		ks.setLoaiphong(comboBoxloaiphong.getItemAt(comboBoxloaiphong.getSelectedIndex()).toString());
		ks.setMaNCC(Integer.parseInt(tfmancc.getText()));
		long gia = 0;
		try {
			gia = Long.parseLong(tfgia.getText());
		} catch (NumberFormatException ex) {
			gia = 0;
		} catch (Exception s) {
			gia = 0;
		}
		
		ks.setGia(gia);
		//ksDAO.addKhachSan(ks);
		ksList.add(ks);
		if(khachsanBus.themKS(ks)) {
			model.addRow(new Object[] {ks.getMaKS(),ks.getLoaihinhKS(),ks.getTenKS(),ks.getMaNCC(),ks.getLoaiphong(),ks.getGia()});
		}
		else {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Thêm thất bại!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
		}
		
	}
	private void xuLiSuKienXoa(){
		DTO.KhachSan ks=new DTO.KhachSan();
		int i=table.getSelectedRow();
		if(i>=0) {
			ks.setMaKS(Integer.parseInt(model.getValueAt(rowSelected, 0).toString()));
			khachsanBus.xoaKS(ks);
			model.removeRow(i);
		}
	}
	private void xuLiSuKienSua() {
			
			DTO.KhachSan ks = new DTO.KhachSan();
			try {
				ks.setMaKS(Integer.parseInt(model.getValueAt(rowSelected, 0).toString()));
			} catch (Exception ex) {
				ks.setMaKS(0);
			}
			ks.setLoaihinhKS(comboBoxloaihinh.getItemAt(comboBoxloaihinh.getSelectedIndex()).toString());
			ks.setTenKS(tftenks.getText());
			try {
				ks.setMaNCC(Integer.parseInt(model.getValueAt(rowSelected, 3).toString()));
			} catch(Exception ok) {
				ks.setMaNCC(0);
			}
			ks.setLoaiphong(comboBoxloaiphong.getItemAt(comboBoxloaiphong.getSelectedIndex()).toString());
			
			try {
				ks.setGia(Long.parseLong(tfgia.getText()));
			} catch(Exception ok) {
				ks.setGia(0);
			}
			
			int i=table.getSelectedRow();
			if(i>=0) {
				if(khachsanBus.suaKS(ks)) {
					model.setValueAt(tfmaks.getText(),i,0);
					model.setValueAt(comboBoxloaihinh.getItemAt(comboBoxloaihinh.getSelectedIndex()).toString(),i,1);
					model.setValueAt(tftenks.getText(),i,2);
					model.setValueAt(tfmancc.getText(),i,3);
					model.setValueAt(comboBoxloaiphong.getItemAt(comboBoxloaiphong.getSelectedIndex()).toString(),i,4);
					model.setValueAt(tfgia.getText(),i,5);;
				
				} else {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Sửa thất bại!",
			                "Thông báo!!!",
			                JOptionPane.WARNING_MESSAGE);
				}	
			}
			
	}
	
	private void hienThiDS(ArrayList<DTO.KhachSan> ksList) {
		ksList.clear();
		khachsanBus.docDsKS();
		ksList=khachsanBus.getKSList();
		model.setRowCount(0);
		
		int x = 0;
		try {
			x = ksList.size();
		} catch (Exception ex) {
			x = 0;
		}
		for (int i = 0; i < x; i++) {
			row[0] = ksList.get(i).getMaKS();
			row[1]=ksList.get(i).getLoaihinhKS();
			row[2]=ksList.get(i).getTenKS();
			row[3] = ksList.get(i).getMaNCC();
			row[4]=ksList.get(i).getLoaiphong();
			row[5] = ksList.get(i).getGia();
			model.addRow(row);
		}
	}
	private void hienThiDStimkiem(ArrayList<DTO.KhachSan> ksList) {
		model.setRowCount(0);
		
		int x = 0;
		try {
			x = ksList.size();
		} catch (Exception ex) {
			x = 0;
		}
		for (int i = 0; i < x; i++) {
			row[0] = ksList.get(i).getMaKS();
			row[1]=ksList.get(i).getLoaihinhKS();
			row[2]=ksList.get(i).getTenKS();
			row[3] = ksList.get(i).getMaNCC();
			row[4]=ksList.get(i).getLoaiphong();
			row[5] = ksList.get(i).getGia();
			model.addRow(row);
		}
}
	private void timKiem() {
		model.setRowCount(0);
		if (tfmaks.getText().trim().equals("") && tftenks.getText().trim().equals("")) {
			hienThiDS(ksList);

		}else if (!tfmaks.getText().trim().equals("") && tftenks.getText().trim().equals("")) {
			DTO.KhachSan ks = new DTO.KhachSan();
			ArrayList<DTO.KhachSan> ksList= new ArrayList<>();
			ks = khachsanBus.timKiemMa(tfmaks.getText());
			if (ks != null) {
				ksList.add(ks);
				hienThiDStimkiem(ksList);
			}
		} else  if (!tftenks.getText().trim().equals("") && tfmaks.getText().trim().equals("")) {
			ArrayList<DTO.KhachSan> ksList= new ArrayList<>();
			ksList = khachsanBus.timKiemTen(tftenks.getText());
			if (ksList != null) {
				hienThiDStimkiem(ksList);
			}
		} else {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Chỉ nhập tối đa 1 ô để tìm kiếm!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
		}
	}

	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_5;
	private JComboBox comboBoxloaihinh;
	private JComboBox comboBoxloaiphong;
	
	public void resum() {
		t.resume();
	}
	
	public void pause() {
		t.suspend();
	}
	
	Thread t=new Thread()
	{

		public void run(){
            
    		Dimension size= lblContent.getPreferredSize();
    		float x = size.width;
    		
    		while(true){
                if(x + size.width <= 0){
                	x = panel_33.getWidth();
                	lblContent.setBounds((int)x, 2,size.width,size.height);
                }else{
                	x-=0.5;
                	lblContent.setBounds((int)x, 2,size.width,size.height);
                    try {
    					t.sleep(20);
    				} catch (InterruptedException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				}
                }
            }
        }

	};
	
}