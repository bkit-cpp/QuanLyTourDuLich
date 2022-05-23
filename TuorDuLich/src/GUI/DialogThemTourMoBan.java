package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import BUS.TourMoBan_BUS;
import DTO.LoTrinh;
import DTO.TourMoBan;
import DTO.TourSanPham;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class DialogThemTourMoBan extends JDialog {

	private int maNV = -1;
	private JComboBox chonNV = new JComboBox();
	private ArrayList<DTO.NhanVien> dsnv = new ArrayList<DTO.NhanVien>();
	private Color background = new Color(111, 211, 178);
	private TextFielAmination textField_1, tenTour, soNgay, soCho, ngayKhoiHanh, giaDaiLy, giaKhachLe;
	private JTable table_1;
	private DefaultTableModel model;
	private Object[] row = new Object[6];
	private Object[] column = {"Ngày đi", "Giờ đi", "Ngày về", "Giờ về", "Điểm đón", "Điểm đến"};
	private JButton btnThemLT, btnDongY, btnXoa;
	private TourMoBan_BUS tourBUS = new TourMoBan_BUS();
	//private ArrayList<DTO.TourMoBan> dsTour= new ArrayList<DTO.TourMoBan>();
	private JComboBox loaiDV;

	public JButton getBtnDongY() {
		return btnDongY;
	}

	public void setBtnDongY(JButton btnDongY) {
		this.btnDongY = btnDongY;
	}

	public ArrayList<DTO.NhanVien> getDsnv() {
		return dsnv;
	}

	public void setDsnv(ArrayList<DTO.NhanVien> dsnv) {
		this.dsnv = dsnv;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public DialogThemTourMoBan(Frame owner, String title) {
        super(owner, title, true);
        
    	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height * 4 / 5;
		int screenWidth = screenSize.width * 5 / 7;
		
        
		setSize(screenWidth * 9 / 10, screenHeight * 9 / 10);
		setLocationRelativeTo(null);
		setResizable(false);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0};
		gridBagLayout.rowHeights = new int[]{0, 150, 0};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.5, 0.2};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(15, 15, 15, 15);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 20};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 1.0};
		gbl_panel.rowWeights = new double[]{1.0, 0.8, 1.0, 0.8, 1.0, 0.8, 1.0, 0.8, 1.0, 3.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Loại tour : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		loaiDV = new JComboBox();
		loaiDV.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loaiDV.setMinimumSize(new Dimension(30, 16));
		loaiDV.setModel(new DefaultComboBoxModel(new String[] {"Private", "S.I.C"}));
		GridBagConstraints gbc_loaiDV = new GridBagConstraints();
		gbc_loaiDV.anchor = GridBagConstraints.WEST;
		gbc_loaiDV.insets = new Insets(0, 0, 0, 5);
		gbc_loaiDV.gridx = 1;
		gbc_loaiDV.gridy = 0;
		panel.add(loaiDV, gbc_loaiDV);
		
		JLabel lblNewLabel_5 = new JLabel("Ngày khời hành : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_5.gridx = 3;
		gbc_lblNewLabel_5.gridy = 0;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		ngayKhoiHanh = new TextFielAmination();
		ngayKhoiHanh.setColumns(10);
		ngayKhoiHanh.setBackground(Color.white);
		ngayKhoiHanh.setBorder(new EmptyBorder(2, 4, 2, 4));
		ngayKhoiHanh.setRadius(10);
		GridBagConstraints gbc_ngayKhoiHanh = new GridBagConstraints();
		gbc_ngayKhoiHanh.insets = new Insets(0, 0, 5, 0);
		gbc_ngayKhoiHanh.fill = GridBagConstraints.BOTH;
		gbc_ngayKhoiHanh.gridx = 4;
		gbc_ngayKhoiHanh.gridy = 0;
		panel.add(ngayKhoiHanh, gbc_ngayKhoiHanh);
		
		JLabel lblNewLabel_1 = new JLabel("Mã tour : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		textField_1 = new TextFielAmination();
		textField_1.setEnabled(false);
		textField_1.setBackground(new Color(240, 240, 240));
		textField_1.setText(String.valueOf(tourBUS.getMaNVMax() + 1));
		textField_1.setColumns(10);
		textField_1.setBorder(new EmptyBorder(2, 4, 2, 4));
		textField_1.setRadius(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 1;
		gbc_textField_1.gridy = 2;
		panel.add(textField_1, gbc_textField_1);
		
		JLabel lblNewLabel_5_1 = new JLabel("Giá đại lý : ");
		lblNewLabel_5_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5_1.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_5_1.gridx = 3;
		gbc_lblNewLabel_5_1.gridy = 2;
		panel.add(lblNewLabel_5_1, gbc_lblNewLabel_5_1);
		
		giaDaiLy = new TextFielAmination();
		giaDaiLy.setColumns(10);
		giaDaiLy.setBackground(Color.white);
		giaDaiLy.setBorder(new EmptyBorder(2, 4, 2, 4));
		giaDaiLy.setRadius(10);
		GridBagConstraints gbc_giaDaiLy = new GridBagConstraints();
		gbc_giaDaiLy.insets = new Insets(0, 0, 5, 0);
		gbc_giaDaiLy.fill = GridBagConstraints.BOTH;
		gbc_giaDaiLy.gridx = 4;
		gbc_giaDaiLy.gridy = 2;
		panel.add(giaDaiLy, gbc_giaDaiLy);
		
		JLabel lblNewLabel_2 = new JLabel("Tên tour : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tenTour = new TextFielAmination();
		tenTour.setColumns(10);
		tenTour.setBackground(Color.white);
		tenTour.setBorder(new EmptyBorder(2, 4, 2, 4));
		tenTour.setRadius(10);
		GridBagConstraints gbc_tenTour = new GridBagConstraints();
		gbc_tenTour.insets = new Insets(0, 0, 5, 5);
		gbc_tenTour.fill = GridBagConstraints.BOTH;
		gbc_tenTour.gridx = 1;
		gbc_tenTour.gridy = 4;
		panel.add(tenTour, gbc_tenTour);
		
		JLabel lblNewLabel_5_2 = new JLabel("Giá khách lẻ : ");
		lblNewLabel_5_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5_2 = new GridBagConstraints();
		gbc_lblNewLabel_5_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5_2.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_5_2.gridx = 3;
		gbc_lblNewLabel_5_2.gridy = 4;
		panel.add(lblNewLabel_5_2, gbc_lblNewLabel_5_2);
		
		giaKhachLe = new TextFielAmination();
		giaKhachLe.setColumns(10);
		giaKhachLe.setBackground(Color.white);
		giaKhachLe.setBorder(new EmptyBorder(2, 4, 2, 4));
		giaKhachLe.setRadius(10);
		GridBagConstraints gbc_giaKhachLe = new GridBagConstraints();
		gbc_giaKhachLe.insets = new Insets(0, 0, 5, 0);
		gbc_giaKhachLe.fill = GridBagConstraints.BOTH;
		gbc_giaKhachLe.gridx = 4;
		gbc_giaKhachLe.gridy = 4;
		panel.add(giaKhachLe, gbc_giaKhachLe);
		
		JLabel lblNewLabel_3 = new JLabel("Số ngày : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 6;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		soNgay = new TextFielAmination();
		soNgay.setColumns(10);
		soNgay.setBackground(Color.white);
		soNgay.setBorder(new EmptyBorder(2, 4, 2, 4));
		soNgay.setRadius(10);
		GridBagConstraints gbc_soNgay = new GridBagConstraints();
		gbc_soNgay.insets = new Insets(0, 0, 5, 5);
		gbc_soNgay.fill = GridBagConstraints.BOTH;
		gbc_soNgay.gridx = 1;
		gbc_soNgay.gridy = 6;
		panel.add(soNgay, gbc_soNgay);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Trạng thái : ");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5_2_1.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_5_2_1.gridx = 3;
		gbc_lblNewLabel_5_2_1.gridy = 6;
		panel.add(lblNewLabel_5_2_1, gbc_lblNewLabel_5_2_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 13));
		comboBox.setEnabled(false);
		comboBox.setMinimumSize(new Dimension(30, 19));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Chưa chiết tính", "Đã chiết tính"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 0, 0, 0);
		gbc_comboBox.gridx = 4;
		gbc_comboBox.gridy = 6;
		panel.add(comboBox, gbc_comboBox);
		
		JLabel lblNewLabel_4 = new JLabel("Số chỗ : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 8;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		soCho = new TextFielAmination();
		soCho.setColumns(10);
		soCho.setBackground(Color.white);
		soCho.setBorder(new EmptyBorder(2, 4, 2, 4));
		soCho.setRadius(10);
		GridBagConstraints gbc_soCho = new GridBagConstraints();
		gbc_soCho.insets = new Insets(0, 0, 5, 5);
		gbc_soCho.fill = GridBagConstraints.BOTH;
		gbc_soCho.gridx = 1;
		gbc_soCho.gridy = 8;
		panel.add(soCho, gbc_soCho);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.gridwidth = 5;
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 9;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.2};
		gbl_panel_2.rowWeights = new double[]{1.0, 0.7};
		panel_2.setLayout(gbl_panel_2);
		
		btnXoa = new JButton("Xóa lộ trình");
		GridBagConstraints gbc_btnXoa = new GridBagConstraints();
		gbc_btnXoa.anchor = GridBagConstraints.EAST;
		gbc_btnXoa.fill = GridBagConstraints.VERTICAL;
		gbc_btnXoa.insets = new Insets(0, 0, 0, 10);
		gbc_btnXoa.gridx = 0;
		gbc_btnXoa.gridy = 1;
		panel_2.add(btnXoa, gbc_btnXoa);
		
		btnThemLT = new JButton("Thêm lộ trình");
		GridBagConstraints gbc_btnThemLT = new GridBagConstraints();
		gbc_btnThemLT.fill = GridBagConstraints.BOTH;
		gbc_btnThemLT.gridx = 1;
		gbc_btnThemLT.gridy = 1;
		panel_2.add(btnThemLT, gbc_btnThemLT);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0};
		gbl_panel_1.rowHeights = new int[]{0};
		gbl_panel_1.columnWeights = new double[]{1.0};
		gbl_panel_1.rowWeights = new double[]{1.0};
		panel_1.setLayout(gbl_panel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_1.add(scrollPane, gbc_scrollPane);
		
		model=new DefaultTableModel();
		model.setColumnIdentifiers(column);
		
		table_1 = new JTable();
		table_1.setSelectionBackground(new Color(0, 255, 127));
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 2;
		getContentPane().add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, 0.2};
		gbl_panel_3.rowWeights = new double[]{1.0, 1.0};
		panel_3.setLayout(gbl_panel_3);
		
		btnDongY = new JButton("Đồng ý thêm");
		GridBagConstraints gbc_btnDongY = new GridBagConstraints();
		gbc_btnDongY.fill = GridBagConstraints.BOTH;
		gbc_btnDongY.insets = new Insets(0, 0, 10, 10);
		gbc_btnDongY.gridx = 1;
		gbc_btnDongY.gridy = 1;
		panel_3.add(btnDongY, gbc_btnDongY);
		table_1.getTableHeader().setReorderingAllowed(false); 
		addEvent();
	}
	
	public void addEvent() {
		btnThemLT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addRow(row);
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.removeRow(table_1.getSelectedRow());
			}
		});
		
		btnDongY.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				LoTrinh lt = new LoTrinh();
				int sl = table_1.getRowCount();
				if (sl == 1) {
						if (model.getValueAt(0, 5) == null || model.getValueAt(0, 4) == null || model.getValueAt(0, 3) == null 
								|| model.getValueAt(0, 2) == null || model.getValueAt(0, 1) == null || model.getValueAt(0, 0) == null) {
							JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
					                "Thông tin lộ trình không được để trống!",
					                "Thông báo!!!",
					                JOptionPane.WARNING_MESSAGE);
						} else {
							lt.setdiemden(model.getValueAt(0, 5).toString());
							lt.setdiemdon(model.getValueAt(0, 4).toString());
							lt.setgiove(model.getValueAt(0, 3).toString());
							lt.setgiodi(model.getValueAt(0, 1).toString());
							lt.setngayve(model.getValueAt(0, 2).toString());
							lt.setngaydi(model.getValueAt(0, 0).toString());
							tourBUS.themLT(lt);
							
							TourMoBan tour = new TourMoBan();
							long x;
							try {
								x = Long.parseLong(giaDaiLy.getText());
							} catch (NumberFormatException ex) {
								x = -1;
							}
							tour.setGiaDaiLy(x);
							try {
								x = Long.parseLong(giaKhachLe.getText());
							} catch (NumberFormatException ex) {
								x = -1;
							}
							tour.setGiaKhachLe(x);
							tour.setLoaiDV(loaiDV.getItemAt(loaiDV.getSelectedIndex()).toString());
							tour.setNgayKhoiHanh(ngayKhoiHanh.getText());
							int s;
							try {
								s = Integer.parseInt(soCho.getText());
							} catch (NumberFormatException ex) {
								s = -1;
							}
							tour.setSoCho(s);
							tour.setThoiGian(soNgay.getText());
							tour.setTrangThai("Chưa chiết tính");
							tour.setTenDV(tenTour.getText());
							
							if (tourBUS.themTour(tour)) {
								JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
						                "Thêm tour thành công!",
						                "Thông báo!!!",
						                JOptionPane.INFORMATION_MESSAGE);
								DialogThemTourMoBan.this.setVisible(false);
								DialogThemTourMoBan.this.dispose();
							}
						}
						
				} else if (sl > 1) {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Mỗi dịch vụ chỉ có một lộ trình!",
			                "Thông báo!!!",
			                JOptionPane.WARNING_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Bạn chưa thêm lộ trình!",
			                "Thông báo!!!",
			                JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
	}

}
