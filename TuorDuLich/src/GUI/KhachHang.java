package GUI;


import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import BUS.CheDo_BUS;
import BUS.NguoiDung_BUS;
import BUS.PhanQuyen_BUS;
import DTO.PhanQuyen;

import java.awt.GridBagLayout;
import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
public class KhachHang extends JPanel {

	private JPanel contentPane;
	
	private TextFielAmination tenKH;

	protected TextFielAmination maKH;

	private TextFielAmination diaChi;

	private TextFielAmination textField_6;

	private TextFielAmination ngaySinh;

	private TextFielAmination sdt;
	private JTable table_1;
	private DefaultTableModel model;
	private Color background =  new Color(111, 211, 178);
	private BtnThem btnThem;
	private BtnSua btnSua;
	private BtnTimKiem btnTimKiem;
	private BtnXoa btnXoa;
	private ButtonAmination btnPhanQuyen;
	private ButtonAmination btnPrint;
	private Object[] row;
	private JComboBox gioiTinh;
	private ArrayList<DTO.KhachHangDTO> dsKH = new ArrayList<DTO.KhachHangDTO>();
	
	private BUS.KhachHang khBUS = new BUS.KhachHang();
	
	private JButton temp;
	private ButtonAmination btnDongY;
	private boolean selectedTable = true;
	private ButtonAmination btnHuy;
	private JPanel panel_1;
	private JPanel panel_3;
	private JLabel lblContent;
	private Object[] column = {"STT", "Mã khách hàng", "Tên khách hàng", "Giới tính", "Ngày sinh", "SDT", "Địa chỉ"};
	private static int maKHMax = 1;
	private JPanel panel_4;
	private NguoiDung_BUS ndBUS = new NguoiDung_BUS();

	private boolean duocThem =  true;
	private boolean duocSua = true;
	private boolean duocXoa = true;
	private boolean laAdmin = false;
	private boolean cheDo = true;
	private Color txtColor = Color.white;
	
   	public KhachHang(int manvDN) {
   		
   		if (ndBUS.admin(manvDN)) {
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
		gridBagLayout.rowHeights = new int[]{70, 0, 0, 0, 0, 0, 70, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.2, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[] {0.0, 0.0, 0.07, 0.07, 0.07, 0.07, 0.0, 1.0};
		setLayout(gridBagLayout);
		model=new DefaultTableModel();
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		dsKH=new DAO.KhachHangDAO().getdsKhachHang();
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
		
		lblContent = new JLabel("Chào mừng bạn đến với giao diện quản lý khách hàng");
		lblContent.setBounds(139, 11, 243, 33);
		lblContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		panel_3.add(lblContent);
		
		JLabel lblNewLabel_17 = new JLabel("Tên khách hàng : ");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_17.gridx = 0;
		gbc_lblNewLabel_17.gridy = 2;
		add(lblNewLabel_17, gbc_lblNewLabel_17);
		
		tenKH = new TextFielAmination();
		tenKH.setRadius(10);
		//tenKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tenKH.setColumns(10);
		GridBagConstraints gbc_tenKH = new GridBagConstraints();
		gbc_tenKH.fill = GridBagConstraints.BOTH;
		gbc_tenKH.insets = new Insets(0, 20, 8, 20);
		gbc_tenKH.gridx = 1;
		gbc_tenKH.gridy = 2;
		add(tenKH, gbc_tenKH);
		
		JLabel lblNewLabel_21_3 = new JLabel("Số điện thoại : ");
		lblNewLabel_21_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_21_3 = new GridBagConstraints();
		gbc_lblNewLabel_21_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21_3.insets = new Insets(0, 0, 5, 40);
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
		
		JLabel lblNewLabel_18 = new JLabel("Mã khách hàng : ");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_18.gridx = 0;
		gbc_lblNewLabel_18.gridy = 3;
		add(lblNewLabel_18, gbc_lblNewLabel_18);
		
		maKH = new TextFielAmination();
		maKH.setRadius(10);
		maKH.setMargin(new Insets(0, 4, 0, 0));
		//maKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		maKH.setColumns(10);
		GridBagConstraints gbc_maKH = new GridBagConstraints();
		gbc_maKH.fill = GridBagConstraints.BOTH;
		gbc_maKH.insets = new Insets(0, 20, 8, 20);
		gbc_maKH.gridx = 1;
		gbc_maKH.gridy = 3;
		add(maKH, gbc_maKH);
		
		JLabel lblNewLabel_21_1 = new JLabel("Địa chỉ : ");
		lblNewLabel_21_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_21_1 = new GridBagConstraints();
		gbc_lblNewLabel_21_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21_1.insets = new Insets(0, 0, 5, 40);
		gbc_lblNewLabel_21_1.gridx = 3;
		gbc_lblNewLabel_21_1.gridy = 3;
		add(lblNewLabel_21_1, gbc_lblNewLabel_21_1);
		
		diaChi = new TextFielAmination();
		diaChi.setRadius(10);
		diaChi.setMinimumSize(new Dimension(0, 19));
		diaChi.setMargin(new Insets(0, 4, 0, 0));
		//diaChi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		diaChi.setColumns(10);
		GridBagConstraints gbc_diaChi = new GridBagConstraints();
		gbc_diaChi.fill = GridBagConstraints.BOTH;
		gbc_diaChi.insets = new Insets(0, 0, 8, 20);
		gbc_diaChi.gridx = 4;
		gbc_diaChi.gridy = 3;
		add(diaChi, gbc_diaChi);
		diaChi.setBorder(new EmptyBorder(0, 5, 0, 5));
		diaChi.setBackground(txtColor);
		
		JLabel lblNewLabel_19 = new JLabel("Giới tính : ");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_19.gridx = 0;
		gbc_lblNewLabel_19.gridy = 4;
		add(lblNewLabel_19, gbc_lblNewLabel_19);
		
		gioiTinh = new JComboBox();
		gioiTinh.setEnabled(false);
		
		gioiTinh.setMinimumSize(new Dimension(68, 13));
		gioiTinh.setModel(new DefaultComboBoxModel(new String[] {"Nam", "Nữ"}));
		GridBagConstraints gbc_gioiTinh = new GridBagConstraints();
		gbc_gioiTinh.fill = GridBagConstraints.VERTICAL;
		gbc_gioiTinh.anchor = GridBagConstraints.WEST;
		gbc_gioiTinh.insets = new Insets(0, 20, 8, 5);
		gbc_gioiTinh.gridx = 1;
		gbc_gioiTinh.gridy = 4;
		add(gioiTinh, gbc_gioiTinh);
		
		JLabel lblNewLabel_20 = new JLabel("Ngày sinh : ");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 20);
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
		gbc_ngaySinh.insets = new Insets(0, 20, 8, 20);
		gbc_ngaySinh.gridx = 1;
		gbc_ngaySinh.gridy = 5;
		add(ngaySinh, gbc_ngaySinh);
		
		
		
		JPanel panel = new JPanel();
		panel.setBackground(background);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(7, 7, 5, 7);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 6;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{80, 99, 90, 95, 0, 90, 90};
		gbl_panel.rowHeights = new int[]{35, 30};
		gbl_panel.columnWeights = new double[]{0.1, 0.06, 0.0, 0.0, 1.0, 0.0, 0.0};
		gbl_panel.rowWeights = new double[]{0.4, 0.4};
		panel.setLayout(gbl_panel);
		
		btnTimKiem = new BtnTimKiem();
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 1;
		gbc_btnNewButton_3.gridy = 0;
		panel.add(btnTimKiem, gbc_btnNewButton_3);
		
		btnThem = new BtnThem();
		GridBagConstraints gbc_btnPrint = new GridBagConstraints();
		gbc_btnPrint.fill = GridBagConstraints.BOTH;
		gbc_btnPrint.insets = new Insets(0, 0, 5, 5);
		gbc_btnPrint.gridx = 2;
		gbc_btnPrint.gridy = 0;
		panel.add(btnThem, gbc_btnPrint);

		btnSua = new BtnSua();
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnSua, gbc_btnNewButton_1);
		
		btnXoa = new BtnXoa();
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 10);
		gbc_btnNewButton_2.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_2.gridx = 5;
		gbc_btnNewButton_2.gridy = 0;
		panel.add(btnXoa, gbc_btnNewButton_2);
		
		
		
		btnHuy = new ButtonAmination();
		btnHuy.setText("Hủy");
		GridBagConstraints gbc_btnHuy = new GridBagConstraints();
		gbc_btnHuy.fill = GridBagConstraints.BOTH;
		gbc_btnHuy.insets = new Insets(0, 0, 0, 5);
		gbc_btnHuy.gridx = 2;
		gbc_btnHuy.gridy = 1;
		panel.add(btnHuy, gbc_btnHuy);
		
		btnDongY = new ButtonAmination();
		btnDongY.setText("Đồng ý");
		GridBagConstraints gbc_btnDongY = new GridBagConstraints();
		gbc_btnDongY.insets = new Insets(0, 0, 0, 5);
		gbc_btnDongY.fill = GridBagConstraints.BOTH;
		gbc_btnDongY.gridx = 3;
		gbc_btnDongY.gridy = 1;
		panel.add(btnDongY, gbc_btnDongY);
		
	
		
		panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.gridwidth = 7;
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
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
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_4.add(scrollPane, gbc_scrollPane);
		
		
		table_1 = new JTable(model);
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);
		tenKH.setBorder(new EmptyBorder(0, 5, 0, 5));
		maKH.setBorder(new EmptyBorder(0, 5, 0, 5));
		ngaySinh.setBorder(new EmptyBorder(0, 5, 0, 5));
		sdt.setBorder(new EmptyBorder(0, 5, 0, 5));
		
		tenKH.setBackground(txtColor);
		maKH.setBackground(txtColor);
		ngaySinh.setBackground(txtColor);
		sdt.setBackground(txtColor);
		
		disableJTextField(ngaySinh);
		disableJTextField(diaChi);
		disableJTextField(tenKH);
		disableJTextField(maKH);
		disableJTextField(sdt);
		
		if (table_1.getSelectedRow() == -1) {
			btnSua.setEnabled(false);
			btnXoa.setEnabled(false);
		}
		
		btnDongY.setEnabled(false);
		
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		for (int i = 0; i < 7; i++)
			table_1.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
		
		table_1.getColumnModel().getColumn(0).setPreferredWidth(16);

		table_1.setDefaultEditor(Object.class, null);
		btnHuy.setEnabled(false);
		
		btnPrint = new ButtonAmination();
		btnPrint.setText("Print");
		
		btnPrint.addActionListener(new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e) {
				
				try {
				
					XSSFWorkbook wordkbook = new XSSFWorkbook();
					XSSFSheet sheet=wordkbook.createSheet("Danh sách khách hàng");
					XSSFRow row=null;
					Cell cell=null;
					row=sheet.createRow(5);
			        cell=row.createCell(3,CellType.STRING);
			        cell.setCellValue("Danh sách khách hàng");
					row=sheet.createRow(6);
					cell=row.createCell(0, CellType.STRING);
					cell.setCellValue("STT");
					cell=row.createCell(1, CellType.NUMERIC);
					cell.setCellValue("Mã khách hàng");
					cell=row.createCell(2, CellType.STRING);
					cell.setCellValue("Tên khách hàng");
					cell=row.createCell(3, CellType.STRING);
					cell.setCellValue("Giới tính");
					cell=row.createCell(4, CellType.STRING);
					cell.setCellValue("Ngày sinh");
					cell=row.createCell(5, CellType.NUMERIC);
					cell.setCellValue("SĐT");
					cell=row.createCell(6, CellType.STRING);
					cell.setCellValue("Địa chỉ");
					for(int i=0;i<dsKH.size();i++)
					{
				
						row=sheet.createRow(7+i);
						cell=row.createCell(0, CellType.NUMERIC);
						cell.setCellValue(i+1);
						cell=row.createCell(1,CellType.NUMERIC);
						cell.setCellValue(dsKH.get(i).getmaKH());
						cell=row.createCell(2,CellType.STRING);
						cell.setCellValue(dsKH.get(i).gettenKH());
						cell=row.createCell(3,CellType.STRING);
						cell.setCellValue(dsKH.get(i).getgioitinh());
						cell=row.createCell(4,CellType.STRING);
						cell.setCellValue(dsKH.get(i).getNgaySinh());
						cell=row.createCell(5,CellType.NUMERIC);
						cell.setCellValue(dsKH.get(i).getSDT());
						cell=row.createCell(6,CellType.STRING);
						cell.setCellValue(dsKH.get(i).getDiaChi());
					}
					File f=new File("./excel/KH.xlsx");
					try {
						FileOutputStream fo=new FileOutputStream(f);
						wordkbook.write(fo);
						fo.close();
						
					}catch(FileNotFoundException e1)
					{
					  e1.printStackTrace();	
					}
					catch(IOException e1)
					{
						e1.printStackTrace();
					}
					finally {
						try {
							
						}catch(Exception e1)
						{
							if(wordkbook!=null)
							{
								wordkbook.close();
							}
							
						}
					}
					JOptionPane.showMessageDialog(null, "In thành công");
					
			}catch(Exception e1)
				{
				e1.printStackTrace();
				JOptionPane.showMessageDialog(null, "Lỗi in file");
				}
				
			}
		});
		
		GridBagConstraints gbc_btnPrint1 = new GridBagConstraints();
		gbc_btnPrint1.fill = GridBagConstraints.BOTH;
		gbc_btnPrint1.insets = new Insets(0, 0, 5, 10);
		gbc_btnPrint1.gridx = 5;
		gbc_btnPrint1.gridy = 1;
		panel.add(btnPrint, gbc_btnPrint1);
		table_1.setFocusable(false);
		
		scrollPane.getViewport().setBackground(Color.white);
		
		if (table_1.getRowCount() > 0)
		table_1.setRowSelectionInterval(0, 0);
		
		t.start();
		pause();
		
		gioiTinh.setRenderer(new DefaultListCellRenderer() {
	        @Override
	        public void paint(Graphics g) {
	            setForeground(Color.DARK_GRAY);
	            super.paint(g);
	        }
	    });
		showtable();
		
		addController();
		addEvent();
		
		if (!laAdmin) {
			PhanQuyen_BUS phanQuyenBUS = new PhanQuyen_BUS();
			PhanQuyen phanQuyen = new PhanQuyen();
			phanQuyen = phanQuyenBUS.timKiem(manvDN, "Thêm khách hàng");
			if (phanQuyen == null) {
				duocThem = false;
				btnThem.setEnabled(false);
			}
			
			phanQuyen = phanQuyenBUS.timKiem(manvDN, "Xóa khách hàng");
			if (phanQuyen == null) 
				duocXoa = false;
			
			phanQuyen = phanQuyenBUS.timKiem(manvDN, "Sửa khách hàng");
			if (phanQuyen == null) 
				duocSua = false;
		}

		
	}
	int i=1;
	public void showtable()
	{
		model.setRowCount(0);
		dsKH.clear();
		dsKH = khBUS.getdsKhachHang();
		for(DTO.KhachHangDTO kh:dsKH)
		{
			model.addRow
			(new Object[] {i++,kh.getmaKH(),kh.gettenKH(),kh.getgioitinh(),kh.getNgaySinh(),kh.getSDT(),kh.getDiaChi()});
		}
		i = 1;
	}
	
	public void showtable_1(ArrayList<DTO.KhachHangDTO> dsKH1)
	{
		model.setRowCount(0);
		for(DTO.KhachHangDTO kh:dsKH1)
		{
			model.addRow
			(new Object[] {i++,kh.getmaKH(),kh.gettenKH(),kh.getgioitinh(),kh.getNgaySinh(),kh.getSDT(),kh.getDiaChi()});
		}
		i = 1;
	}
	  
	
	public void addEvent() {
		
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
					if (duocSua) {
						btnSua.setEnabled(true);
					}
				
				if (i >= 0 && selectedTable) {
					
					try {
						tenKH.setText(model.getValueAt(i, 2).toString());
					}catch (Exception e1) {
						tenKH.setText("");
					}
					
					
					try {
						ngaySinh.setText(model.getValueAt(i, 4).toString());
					}catch (Exception e1) {
						ngaySinh.setText("");
					}
					
					try {
						diaChi.setText(model.getValueAt(i, 6).toString());
					}catch (Exception e1) {
						diaChi.setText("");
					}
					
					try {
						maKH.setText(model.getValueAt(i, 1).toString());
					}catch (Exception e1) {
						maKH.setText("");
					}
					
					try {
						sdt.setText(model.getValueAt(i, 5).toString());
					}catch (Exception e1) {
						sdt.setText("");
					}
					
					try {
						if (model.getValueAt(i, 3).toString().equals("Nam"))
							gioiTinh.setSelectedIndex(0);
						else 
							gioiTinh.setSelectedIndex(1);
					}catch (Exception e1) {
						e1.printStackTrace();
					}
					
					if (duocXoa) {
						btnXoa.setEnabled(true);
					}
				}
			}
		});
		
		
		btnThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trongForm();
              //  ableJTextField(maKH);
				ableJTextField(tenKH);
				ableJTextField(ngaySinh);
				ableJTextField(diaChi);
				ableJTextField(sdt);
				btnSua.setEnabled(false);
				btnXoa.setEnabled(false);
				btnHuy.setEnabled(true);
				gioiTinh.setEnabled(true);
				btnDongY.setEnabled(true);
				temp = btnThem;
			}
		});
		
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ableJTextField(ngaySinh);
				ableJTextField(diaChi);
				ableJTextField(tenKH);
				ableJTextField(sdt);
				
				btnThem.setEnabled(false);
				btnXoa.setEnabled(false);
				gioiTinh.setEnabled(true);
				
				btnDongY.setEnabled(true);
				
				btnHuy.setEnabled(true);
				temp = btnSua;
				
				
			}
		});
		
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id=Integer.parseInt(maKH.getText());
				DTO.KhachHangDTO kh=new DTO.KhachHangDTO();
				btnSua.setEnabled(false);
				int i=table_1.getSelectedRow();
				if(i>=0)
					khBUS.xoa(id);
				showtable();
				btnXoa.setEnabled(false);
				trongForm();
			}
		});
		
		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				btnDongY.setEnabled(true);
				ableJTextField(maKH);
				
				disableJTextField(ngaySinh);
				disableJTextField(diaChi);

				gioiTinh.setEnabled(false);
				btnThem.setEnabled(false);
				btnHuy.setEnabled(true);
				temp = btnTimKiem;
			}
		});
		
		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				trongForm();
				disableJTextField(ngaySinh);
				disableJTextField(diaChi);
				disableJTextField(tenKH);
				disableJTextField(maKH);

				disableJTextField(sdt);
				gioiTinh.setEnabled(false);
				btnHuy.setEnabled(false);
				btnDongY.setEnabled(false);
				if (duocThem) {
					btnThem.setEnabled(true);
				}
				btnSua.setEnabled(false);
				
				if (temp == btnTimKiem) {
					showtable();
					
				}
				
				temp = null;
			}
		});
		
		btnDongY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (temp == btnThem)
					xuLySuKienThem();
				
				
				if (temp == btnSua) {
					try {
						DTO.KhachHangDTO kh = new DTO.KhachHangDTO();
					kh.setmaKH(Integer.parseInt(maKH.getText()));
					kh.settenKH(tenKH.getText());
					kh.setNgaySinh(ngaySinh.getText());
					kh.setgioitinh(gioiTinh.getItemAt(gioiTinh.getSelectedIndex()).toString());
					kh.setsdt(Integer.parseInt(sdt.getText()));
					kh.setdiachi(diaChi.getText());
					
					trongForm();
					
					if (khBUS.suaKH(kh)) {
						showtable();
						disableJTextField(tenKH);
						disableJTextField(ngaySinh);
						disableJTextField(maKH);
						disableJTextField(sdt);
						disableJTextField(diaChi);
						gioiTinh.setEnabled(false);
						btnHuy.setEnabled(true);
						if (duocSua) {
							btnSua.setEnabled(true);
						}
						btnDongY.setEnabled(true);
						btnXoa.setEnabled(false);
						temp = null;
					}
					
					
					} catch(Exception ex) {
						ex.printStackTrace();
					}
					
					
				}
				
				if (temp == btnTimKiem) {
					ArrayList<DTO.KhachHangDTO> dsKH1 = new ArrayList<DTO.KhachHangDTO>();
					dsKH1 = khBUS.timKiem(maKH.getText());
					model.setRowCount(0);
					showtable_1(dsKH1);
					trongForm();
				}
				if (duocThem) {
					btnThem.setEnabled(true);
				}
				selectedTable = true;
			}
		});
	}
	
	public void xuLySuKienThem() {
		
		DTO.KhachHangDTO kh = new DTO.KhachHangDTO();
		
		kh.setmaKH(maKHMax++);
		kh.settenKH(tenKH.getText());
		kh.setgioitinh(gioiTinh.getItemAt(gioiTinh.getSelectedIndex()).toString());
		kh.setNgaySinh(ngaySinh.getText());
		
		int s = 0;
		
		try {
			s = Integer.parseInt(sdt.getText());
		} catch (Exception l) {
			System.out.println(l);
		}
		
		kh.setsdt(s);
		kh.setdiachi(diaChi.getText());
		if (khBUS.addKH(kh)) {
			showtable();
			trongForm();
			disableJTextField(tenKH);
			disableJTextField(ngaySinh);
			disableJTextField(maKH);
			disableJTextField(sdt);
			disableJTextField(diaChi);
			gioiTinh.setEnabled(false);
		}
			
	}
	
	
	public void addController() {
		row = new Object[7];
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
		tenKH.setText("");
		maKH.setText("");
		diaChi.setText("");
		ngaySinh.setText("");
		sdt.setText("");
	}
	
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
                if(x + size.width == 0){
                	x = panel_3.getWidth();
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