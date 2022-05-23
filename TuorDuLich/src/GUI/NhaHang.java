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
import BUS.NguoiDung_BUS;
import BUS.NhaHang_Bus;
import BUS.PhanQuyen_BUS;
import DTO.PhanQuyen;

import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class NhaHang extends JPanel {
	private JLabel lblContent;
	private JButton btnNewButtonThem, btnNewButton_Sua, btnNewButton_Xoa, btnNewButton_TimKiem;
	private JPanel panel_33;
	private TextFielAmination gia, ma_nh, ten_nh, ma_ncc;
	private Object[] row = new Object[5];
	private Object[] colum = { "Mã nhà hàng", "Tên nhà cung cấp", "Mã nhà cung cấp", "Giá" };
	private DefaultTableModel model;
	private NhaHang_Bus nhahangBus = new NhaHang_Bus();
	private JTable table;
	private static int rowSelected = 0;
	private ArrayList<DTO.NhaHang> nhList = new ArrayList<>();
	private NguoiDung_BUS ndBUS = new NguoiDung_BUS();

	private boolean laAdmin = false;
	private PhanQuyen_BUS phanQuyenBUS = new PhanQuyen_BUS();
	
	private Color bg_menu_item = new Color(111, 211, 178);
	private boolean cheDo = true;

	private boolean duocThem = true;
	private boolean duocXoa = true;
	private boolean duocSua = true;
	private Color txtColor = Color.white;


	public NhaHang(int maNVDN) {
		
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
		gbl_panel.columnWidths = new int[] { 0 };
		gbl_panel.rowHeights = new int[] { 90, 120, 90, 290 };
		gbl_panel.columnWeights = new double[] { 1.0 };
		gbl_panel.rowWeights = new double[] { 0.25, 0.1, 0.5, 1.9 };
		setLayout(gbl_panel);

		JPanel panel_11 = new JPanel();
		GridBagConstraints gbc_panel_11 = new GridBagConstraints();
		gbc_panel_11.insets = new Insets(5, 5, 40, 5);
		gbc_panel_11.fill = GridBagConstraints.BOTH;
		gbc_panel_11.gridx = 0;
		gbc_panel_11.gridy = 0;
		add(panel_11, gbc_panel_11);
		GridBagLayout gbl_panel_11 = new GridBagLayout();
		gbl_panel_11.columnWidths = new int[] { 0 };
		gbl_panel_11.rowHeights = new int[] { 0 };
		gbl_panel_11.columnWeights = new double[] { 1.0 };
		gbl_panel_11.rowWeights = new double[] { 1.0 };
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

		lblContent = new JLabel("Chào mừng bạn đến với giao diện quản lý nhà hàng!");
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
		gbl_panel_1.columnWidths = new int[] { 0, 0, 100, 0, 0, 0, 100 };
		gbl_panel_1.rowHeights = new int[] { 0, 20, 0, 20 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.5, 1.0, 0.5, 0.0, 0.5, 1.0 };
		gbl_panel_1.rowWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel = new JLabel("Mã nhà hàng : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(5, 10, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);

		ma_nh = new TextFielAmination();
		ma_nh.setRadius(10);
		ma_nh.setMinimumSize(new Dimension(70, 25));
		ma_nh.setBorder(new EmptyBorder(2, 5, 2, 5));
		ma_nh.setBackground(txtColor);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		panel_1.add(ma_nh, gbc_textField);
		ma_nh.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Tên nhà hàng : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);

		ten_nh = new TextFielAmination();

		ten_nh.setRadius(10);

		ten_nh.setBackground(txtColor);
		ten_nh.setMinimumSize(new Dimension(70, 25));
		ten_nh.setBorder(new EmptyBorder(2, 5, 2, 5));

		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 6;
		gbc_textField_1.gridy = 0;
		panel_1.add(ten_nh, gbc_textField_1);
		ten_nh.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Mã nhà cung cấp : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(5, 10, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);

		ma_ncc = new TextFielAmination();

		ma_ncc.setRadius(10);

		ma_ncc.setBackground(txtColor);
		ma_ncc.setMinimumSize(new Dimension(70, 25));
		ma_ncc.setBorder(new EmptyBorder(2, 5, 2, 5));

		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 2;
		panel_1.add(ma_ncc, gbc_textField_3);
		ma_ncc.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Giá : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 2;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);

		gia = new TextFielAmination();
		gia.setBackground(txtColor);
		gia.setRadius(10);
		gia.setMinimumSize(new Dimension(70, 25));
		gia.setBorder(new EmptyBorder(2, 5, 2, 5));

		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 6;
		gbc_textField_2.gridy = 2;
		panel_1.add(gia, gbc_textField_2);
		gia.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(bg_menu_item);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 10, 0, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.08, 0.3, 0.1, 0.3, 0.08, 0.3, 0.08 };
		gbl_panel_2.rowWeights = new double[] { 0.1, 0.58 };
		panel_2.setLayout(gbl_panel_2);

		btnNewButtonThem = new BtnThem();
		btnNewButtonThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLiSuKienThem();
				ten_nh.setText("");
				ma_ncc.setText("");
				gia.setText("");
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
				ten_nh.setText("");
				ma_ncc.setText("");
				gia.setText("");
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
				xoa();
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
				ten_nh.setText("");
				ma_ncc.setText("");
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
		gbc_scrollpane.fill = GridBagConstraints.BOTH;
		gbc_scrollpane.gridx = 0;
		gbc_scrollpane.gridy = 0;

		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0 };
		gbl_panel_3.rowHeights = new int[] { 0 };
		gbl_panel_3.columnWeights = new double[] { 0.1 };
		gbl_panel_3.rowWeights = new double[] { 0.1 };
		panel_3.setLayout(gbl_panel_3);

		JScrollPane scollpane = new JScrollPane();
		GridBagConstraints gbc_scollpane = new GridBagConstraints();
		gbc_scollpane.fill = GridBagConstraints.BOTH;
		gbc_scollpane.gridx = 0;
		gbc_scollpane.gridy = 0;
		panel_3.add(scollpane, gbc_scollpane);

		table = new JTable();
		//table.setBackground(new Color(127, 211, 212));
		model = new DefaultTableModel();
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
  
  		for (int i = 0; i < 4; i++)
		table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		
		hienThiDS(nhList);
		
		if (!laAdmin) {
			PhanQuyen phanQuyen = new PhanQuyen();
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Thêm nhà hàng");
			if (phanQuyen == null) {
				btnNewButtonThem.setEnabled(false);
			}
			
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Sửa nhà hàng");
			if (phanQuyen == null) {
				btnNewButton_Sua.setEnabled(false);
			}
			
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Xóa nhà hàng");
			if (phanQuyen == null) {
				btnNewButton_Xoa.setEnabled(false);
			}
		}
		
		t.start();
	}

	private void tableMouseClickes(MouseEvent evt) {
		int i = table.getSelectedRow();
		if (i >= 0) {
			ma_nh.setText(model.getValueAt(i, 0).toString());
			ma_ncc.setText(model.getValueAt(i, 2).toString());
			ten_nh.setText(model.getValueAt(i, 1).toString());
			gia.setText(model.getValueAt(i, 3).toString());
		}
	}

	private void xuLiSuKienThem() {
		DTO.NhaHang nh = new DTO.NhaHang();
		nh.setTenNH(ten_nh.getText());
		int x = 0;
		try {
			x = Integer.parseInt(ma_ncc.getText());
		} catch (NumberFormatException ex) {

		} catch (Exception es) {

		}
		nh.setMaNCC(x);

		long s = 0;
		try {
			s = Integer.parseInt(gia.getText());
		} catch (NumberFormatException ex) {

		} catch (Exception es) {

		}
		
		
		nh.setGia(s);
		nhList.add(nh);
		if (nhahangBus.themNH(nh)) {
			model.addRow(new Object[] { nh.getMaNH(), nh.getTenNH(), nh.getMaNCC(), nh.getGia() });
		} else {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Thêm thất bại!", "Thông báo!!!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	private void xuLiSuKienSua() {

		DTO.NhaHang nh = new DTO.NhaHang();
		try {
			nh.setMaNH(Integer.parseInt(model.getValueAt(rowSelected, 0).toString()));
		} catch (Exception ex) {
			nh.setMaNH(0);
		}
		
		try {
			nh.setMaNCC(Integer.parseInt(model.getValueAt(rowSelected, 2).toString()));
		} catch(Exception ok) {
			nh.setMaNCC(0);
		}
		nh.setTenNH(ten_nh.getText());
		
		try {
			nh.setGia(Long.parseLong(gia.getText()));
		} catch(Exception ok) {
			nh.setGia(0);
		}
		
		int i = table.getSelectedRow();
		if (i >= 0) {
			if (nhahangBus.suaNH(nh)) {
				model.setValueAt(ma_nh.getText(), i, 0);
				model.setValueAt(ten_nh.getText(), i, 1);
				model.setValueAt(ma_ncc.getText(), i, 2);
				model.setValueAt(gia.getText(), i, 3);

			} else {
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Sửa thất bại!", "Thông báo!!!",
						JOptionPane.WARNING_MESSAGE);
			}
		}

	}

	private void xoa() {
		DTO.NhaHang nh = new DTO.NhaHang();
		int i = table.getSelectedRow();
		if (i >= 0) {
			nh.setMaNH(Integer.parseInt(model.getValueAt(rowSelected, 0).toString()));
			nhahangBus.xoaNH(nh);
			model.removeRow(i);
		}
	}

	private void hienThiDS(ArrayList<DTO.NhaHang> nhList) {
		nhList.clear();
		nhahangBus.docDsNH();
		nhList = nhahangBus.getNhList();
		model.setRowCount(0);

		int x = 0;
		try {
			x = nhList.size();
		} catch (Exception ex) {
			x = 0;
		}

		for (int i = 0; i < x; i++) {
			row[0] = nhList.get(i).getMaNH();
			row[1] = nhList.get(i).getTenNH();
			row[2] = nhList.get(i).getMaNCC();
			row[3] = nhList.get(i).getGia();
			model.addRow(row);
		}
	}

	private void hienThiDStimkiem(ArrayList<DTO.NhaHang> nhList) {
		model.setRowCount(0);

		int x = 0;
		try {
			x = nhList.size();
		} catch (Exception ex) {
			x = 0;
		}

		for (int i = 0; i < x; i++) {
			row[0] = nhList.get(i).getMaNH();
			row[1] = nhList.get(i).getTenNH();
			row[2] = nhList.get(i).getMaNCC();
			row[3] = nhList.get(i).getGia();
			model.addRow(row);
		}
	}

	private void timKiem() {
		model.setRowCount(0);
		if (ma_nh.getText().trim().equals("") && ten_nh.getText().trim().equals("")) {
			hienThiDS(nhList);
		}else if (!ma_nh.getText().trim().equals("") && ten_nh.getText().trim().equals("")) {
			DTO.NhaHang nh = new DTO.NhaHang();
			ArrayList<DTO.NhaHang> nhList = new ArrayList<>();
			nh = nhahangBus.timKiemMa(ma_nh.getText());
			if (nh != null) {
				nhList.add(nh);
				hienThiDStimkiem(nhList);
			}
		} else if (!ten_nh.getText().trim().equals("") && ma_nh.getText().trim().equals("")) {
			ArrayList<DTO.NhaHang> nhList = new ArrayList<>();
			nhList = nhahangBus.timKiemTen(ten_nh.getText());
			if (nhList != null) {
				hienThiDStimkiem(nhList);
			}
		} else {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Chỉ nhập tối đa 1 ô để tìm kiếm!", "Thông báo!!!",
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public void resum() {
		t.resume();
	}

	public void pause() {
		t.suspend();
	}

	Thread t = new Thread()

	{

		public void run() {

			Dimension size = lblContent.getPreferredSize();
			float x = size.width;

			while (true) {
				if (x + size.width <= 0) {
					x = panel_33.getWidth();
					lblContent.setBounds((int) x, 2, size.width, size.height);
				} else {
					x -= 0.5;
					lblContent.setBounds((int) x, 2, size.width, size.height);
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
