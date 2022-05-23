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
import BUS.TourSanPham_BUS;
import DTO.LoTrinh;
import DTO.TourMoBan;
import DTO.TourSanPham;

import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class DialogThemTourSanPham extends JDialog {

	private int maNV = -1;
	private JComboBox chonNV = new JComboBox();
	private ArrayList<DTO.NhanVien> dsnv = new ArrayList<DTO.NhanVien>();
	private Color background = new Color(111, 211, 178);
	private TextFielAmination maDV, txtTenTour, soNgay, booking;
	private JTable table_1;
	private DefaultTableModel model;
	private Object[] row = new Object[6];
	private Object[] column = {"Ngày đi", "Giờ đi", "Ngày về", "Giờ về", "Điểm đón", "Điểm đến"};
	private JButton btnThemLT, btnDongY, btnXoa;
	private JComboBox trangThai, loaiHinhTour, loaiTour;
	
	private TourSanPham_BUS tourBUS = new TourSanPham_BUS();

	
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

	public DialogThemTourSanPham(Frame owner, String title) {
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
		
		loaiTour = new JComboBox();
		loaiTour.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loaiTour.setMinimumSize(new Dimension(30, 16));
		loaiTour.setModel(new DefaultComboBoxModel(new String[] {"Private", "S.I.C"}));
		GridBagConstraints gbc_loaiTour = new GridBagConstraints();
		gbc_loaiTour.anchor = GridBagConstraints.WEST;
		gbc_loaiTour.insets = new Insets(0, 0, 5, 5);
		gbc_loaiTour.gridx = 1;
		gbc_loaiTour.gridy = 0;
		panel.add(loaiTour, gbc_loaiTour);
		
		JLabel lblNewLabel_5_2_1 = new JLabel("Loại hình tour : ");
		lblNewLabel_5_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5_2_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_2_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5_2_1.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_5_2_1.gridx = 3;
		gbc_lblNewLabel_5_2_1.gridy = 0;
		panel.add(lblNewLabel_5_2_1, gbc_lblNewLabel_5_2_1);
		
		loaiHinhTour = new JComboBox();
		loaiHinhTour.setFont(new Font("Tahoma", Font.PLAIN, 13));
		loaiHinhTour.setMinimumSize(new Dimension(30, 19));
		loaiHinhTour.setModel(new DefaultComboBoxModel(new String[] {"Du lịch xanh", "Du lịch tham quan", "Du lịch ẩm thực"}));
		GridBagConstraints gbc_loaiHinhTour = new GridBagConstraints();
		gbc_loaiHinhTour.anchor = GridBagConstraints.WEST;
		gbc_loaiHinhTour.insets = new Insets(0, 0, 5, 0);
		gbc_loaiHinhTour.gridx = 4;
		gbc_loaiHinhTour.gridy = 0;
		panel.add(loaiHinhTour, gbc_loaiHinhTour);
		
		JLabel lblNewLabel_1 = new JLabel("Mã tour : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		maDV = new TextFielAmination();
		maDV.setEnabled(false);
		maDV.setBackground(new Color(240, 240, 240));
		maDV.setText(String.valueOf(tourBUS.getMaTourMax() + 1));
		maDV.setColumns(10);
		maDV.setBorder(new EmptyBorder(2, 4, 2, 4));
		maDV.setRadius(10);
		GridBagConstraints gbc_maDV = new GridBagConstraints();
		gbc_maDV.insets = new Insets(0, 0, 5, 5);
		gbc_maDV.fill = GridBagConstraints.BOTH;
		gbc_maDV.gridx = 1;
		gbc_maDV.gridy = 2;
		panel.add(maDV, gbc_maDV);
		
		JLabel lblNewLabel_5_2_1_1 = new JLabel("Trạng thái : ");
		lblNewLabel_5_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5_2_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_2_1_1.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_5_2_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5_2_1_1.gridx = 3;
		gbc_lblNewLabel_5_2_1_1.gridy = 2;
		panel.add(lblNewLabel_5_2_1_1, gbc_lblNewLabel_5_2_1_1);
		
		trangThai = new JComboBox();
		trangThai.setModel(new DefaultComboBoxModel(new String[] {"Chưa chiết tính", "Đã chiết tính"}));
		trangThai.setMinimumSize(new Dimension(30, 19));
		trangThai.setFont(new Font("Tahoma", Font.PLAIN, 13));
		trangThai.setEnabled(false);
		GridBagConstraints gbc_trangThai = new GridBagConstraints();
		gbc_trangThai.fill = GridBagConstraints.VERTICAL;
		gbc_trangThai.anchor = GridBagConstraints.WEST;
		gbc_trangThai.insets = new Insets(0, 0, 0, 0);
		gbc_trangThai.gridx = 4;
		gbc_trangThai.gridy = 2;
		panel.add(trangThai, gbc_trangThai);
		
		JLabel lblNewLabel_2 = new JLabel("Tên tour : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_2.gridx = 0;
		gbc_lblNewLabel_2.gridy = 4;
		panel.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		txtTenTour = new TextFielAmination();
		txtTenTour.setColumns(10);
		txtTenTour.setBackground(Color.white);
		txtTenTour.setBorder(new EmptyBorder(2, 4, 2, 4));
		txtTenTour.setRadius(10);
		GridBagConstraints gbc_txtTenTour = new GridBagConstraints();
		gbc_txtTenTour.insets = new Insets(0, 0, 5, 5);
		gbc_txtTenTour.fill = GridBagConstraints.BOTH;
		gbc_txtTenTour.gridx = 1;
		gbc_txtTenTour.gridy = 4;
		panel.add(txtTenTour, gbc_txtTenTour);
		
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
		
		JLabel lblNewLabel_4 = new JLabel("Booking : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 25);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 8;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		booking = new TextFielAmination();
		booking.setColumns(10);
		booking.setBackground(Color.white);
		booking.setBorder(new EmptyBorder(2, 4, 2, 4));
		booking.setRadius(10);
		GridBagConstraints gbc_booking = new GridBagConstraints();
		gbc_booking.insets = new Insets(0, 0, 5, 5);
		gbc_booking.fill = GridBagConstraints.BOTH;
		gbc_booking.gridx = 1;
		gbc_booking.gridy = 8;
		panel.add(booking, gbc_booking);
		
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
							
							TourSanPham tour = new TourSanPham();
							tour.setLoaiDV(loaiTour.getItemAt(loaiTour.getSelectedIndex()).toString());
							tour.setLoaiHinhTour(loaiHinhTour.getItemAt(loaiHinhTour.getSelectedIndex()).toString());
							tour.setTenDV(txtTenTour.getText());
							tour.setThoiGian(soNgay.getText());
							tour.setTrangThai("Chưa chiết tính");
							
							int x = 0;
							try {
								x = Integer.parseInt(booking.getText());
							} catch (NumberFormatException ex) {
								x = -1;
							}
							
							if (x != -1) {
								tour.setBooking(x);
								if (tourBUS.themTour(tour)) {
									JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
							                "Thêm tour thành công!",
							                "Thông báo!!!",
							                JOptionPane.INFORMATION_MESSAGE);
									DialogThemTourSanPham.this.setVisible(false);
									DialogThemTourSanPham.this.dispose();
								}
							} else {
								JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
						                "Nhập Booking không hợp lệ (Chỉ nhập số)",
						                "Thông báo!!!",
						                JOptionPane.WARNING_MESSAGE);
							}
						}
						
				} else if (sl > 1) {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Mỗi dịch vụ chỉ có một lộ trình!",
			                "Thông báo!!!",
			                JOptionPane.WARNING_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Bạn chưa thêm lộ trình!",
			                "Thông báo!!!",
			                JOptionPane.WARNING_MESSAGE);
				}
				
				
				
			}
		});
	}

}
