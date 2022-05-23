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
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class LoTrinh extends JPanel {

	private TextFielAmination MADVTOUR;
	private TextFielAmination GIODI;
	private TextFielAmination DIEMDON;
	private TextFielAmination GIOVE;

	private TextFielAmination NGAYVE;
	private JTable table_1;
	private DefaultTableModel model;
	private Color background =  new Color(111, 211, 178);
	private BtnSua btnSua;
	private BtnTimKiem btnTimKiem;
	private Object[] row;
	private ArrayList<DTO.LoTrinh> dsLT = new ArrayList<DTO.LoTrinh>();
	private BUS.LoTrinh ltBUS = new BUS.LoTrinh();
	private JButton temp;
	private ButtonAmination btnDongY;
	private boolean selectedTable = true;
	private ButtonAmination btnHuy;
	private JPanel panel_1;
	private JPanel panel_3;
	private JLabel lblContent;
	private Object[] column = { "STT", "Mã dịch vụ tour", "Giờ đi", "Ngày đi", "Giờ về", "Ngày về", "Điểm đón",
			"Điểm đến" };
	private static int maLTMax = 0;
	private JPanel panel_4;
	private boolean duocSua = true;
	private boolean laAdmin = false;
	private boolean cheDo = true;
	private Color txtColor = Color.white;
	private NguoiDung_BUS ndBUS = new NguoiDung_BUS();


	public LoTrinh(int manvDN) {
		
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
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 70, 0, 33, 33, 33, 33, 0, 70, 200 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.2, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.1, 0.08, 0.08, 0.1, 0.0, 0.0, 1.3 };
		setLayout(gridBagLayout);
		model = new DefaultTableModel();
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
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
		gbl_panel_1.columnWidths = new int[] { 0 };
		gbl_panel_1.rowHeights = new int[] { 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0 };
		gbl_panel_1.rowWeights = new double[] { 1.0 };
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

		lblContent = new JLabel("Chào mừng bạn đến với giao diện quản lý lộ trình");
		lblContent.setBounds(139, 11, 243, 33);
		lblContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		panel_3.add(lblContent);

		JLabel lblNewLabel_17 = new JLabel("Mã dịch vụ tour : ");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_17.insets = new Insets(0, 10, 5, 20);
		gbc_lblNewLabel_17.gridx = 0;
		gbc_lblNewLabel_17.gridy = 2;
		add(lblNewLabel_17, gbc_lblNewLabel_17);

		MADVTOUR = new TextFielAmination();
		MADVTOUR.setRadius(10);
		MADVTOUR.setColumns(10);
		GridBagConstraints gbc_MADVTOUR = new GridBagConstraints();
		gbc_MADVTOUR.fill = GridBagConstraints.BOTH;
		gbc_MADVTOUR.insets = new Insets(0, 20, 8, 20);
		gbc_MADVTOUR.gridx = 1;
		gbc_MADVTOUR.gridy = 2;
		add(MADVTOUR, gbc_MADVTOUR);

		JLabel lblNewLabel_21_3 = new JLabel("Ngày Về : ");
		GridBagConstraints gbc_lblNewLabel_21_3 = new GridBagConstraints();
		gbc_lblNewLabel_21_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21_3.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21_3.gridx = 3;
		gbc_lblNewLabel_21_3.gridy = 2;
		add(lblNewLabel_21_3, gbc_lblNewLabel_21_3);

		NGAYVE = new TextFielAmination();
		NGAYVE.setRadius(10);
		NGAYVE.setMinimumSize(new Dimension(68, 19));
		NGAYVE.setColumns(10);
		GridBagConstraints gbc_NGAYVE = new GridBagConstraints();
		gbc_NGAYVE.insets = new Insets(0, 0, 8, 20);
		gbc_NGAYVE.fill = GridBagConstraints.BOTH;
		gbc_NGAYVE.gridx = 4;
		gbc_NGAYVE.gridy = 2;
		add(NGAYVE, gbc_NGAYVE);

		JLabel lblNewLabel_18 = new JLabel("Giờ đi : ");
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_18.gridx = 0;
		gbc_lblNewLabel_18.gridy = 3;
		add(lblNewLabel_18, gbc_lblNewLabel_18);

		GIODI = new TextFielAmination();
		GIODI.setRadius(10);
		GIODI.setColumns(10);
		GridBagConstraints gbc_GIODI = new GridBagConstraints();
		gbc_GIODI.fill = GridBagConstraints.BOTH;
		gbc_GIODI.insets = new Insets(0, 20, 8, 20);
		gbc_GIODI.gridx = 1;
		gbc_GIODI.gridy = 3;
		add(GIODI, gbc_GIODI);

		JLabel lblNewLabel_21_1 = new JLabel("Điểm đón : ");
		GridBagConstraints gbc_lblNewLabel_21_1 = new GridBagConstraints();
		gbc_lblNewLabel_21_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21_1.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21_1.gridx = 3;
		gbc_lblNewLabel_21_1.gridy = 3;
		add(lblNewLabel_21_1, gbc_lblNewLabel_21_1);

		DIEMDON = new TextFielAmination();
		DIEMDON.setRadius(10);
		DIEMDON.setMinimumSize(new Dimension(0, 19));
		DIEMDON.setColumns(10);
		GridBagConstraints gbc_DIEMDON = new GridBagConstraints();
		gbc_DIEMDON.fill = GridBagConstraints.BOTH;
		gbc_DIEMDON.insets = new Insets(0, 0, 8, 20);
		gbc_DIEMDON.gridx = 4;
		gbc_DIEMDON.gridy = 3;
		add(DIEMDON, gbc_DIEMDON);
		DIEMDON.setBorder(new EmptyBorder(0, 5, 0, 5));
		DIEMDON.setBackground(txtColor);

		JLabel lblNewLabel_19 = new JLabel("Ngày đi : ");
		GridBagConstraints gbc_lblNewLabel_19 = new GridBagConstraints();
		gbc_lblNewLabel_19.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_19.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_19.gridx = 0;
		gbc_lblNewLabel_19.gridy = 4;
		add(lblNewLabel_19, gbc_lblNewLabel_19);

		NGAYDI = new TextFielAmination();
		NGAYDI.setRadius(10);
		NGAYDI.setColumns(10);
		NGAYDI.setBorder(new EmptyBorder(0, 5, 0, 5));
		NGAYDI.setBackground(txtColor);
		GridBagConstraints gbc_NGAYDI = new GridBagConstraints();
		gbc_NGAYDI.insets = new Insets(0, 20, 8, 20);
		gbc_NGAYDI.fill = GridBagConstraints.BOTH;
		gbc_NGAYDI.gridx = 1;
		gbc_NGAYDI.gridy = 4;
		add(NGAYDI, gbc_NGAYDI);

		lblNewLabel_21 = new JLabel("Điểm đến : ");
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21.gridx = 3;
		gbc_lblNewLabel_21.gridy = 4;
		add(lblNewLabel_21, gbc_lblNewLabel_21);

		DIEMDEN = new TextFielAmination();
		DIEMDEN.setRadius(10);
		DIEMDEN.setMinimumSize(new Dimension(0, 19));
		DIEMDEN.setColumns(10);
		DIEMDEN.setBorder(new EmptyBorder(0, 5, 0, 5));
		DIEMDEN.setBackground(txtColor);
		GridBagConstraints gbc_DIEMDEN = new GridBagConstraints();
		gbc_DIEMDEN.insets = new Insets(0, 0, 8, 20);
		gbc_DIEMDEN.fill = GridBagConstraints.BOTH;
		gbc_DIEMDEN.gridx = 4;
		gbc_DIEMDEN.gridy = 4;
		add(DIEMDEN, gbc_DIEMDEN);

		JLabel lblNewLabel_20 = new JLabel("Giờ Về : ");
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_20.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_20.gridx = 0;
		gbc_lblNewLabel_20.gridy = 5;
		add(lblNewLabel_20, gbc_lblNewLabel_20);

		GIOVE = new TextFielAmination();
		GIOVE.setRadius(10);
		GIOVE.setMinimumSize(new Dimension(68, 19));
		GIOVE.setColumns(10);
		GridBagConstraints gbc_GIOVE = new GridBagConstraints();
		gbc_GIOVE.fill = GridBagConstraints.BOTH;
		gbc_GIOVE.insets = new Insets(0, 20, 8, 20);
		gbc_GIOVE.gridx = 1;
		gbc_GIOVE.gridy = 5;
		add(GIOVE, gbc_GIOVE);
		GIOVE.setBorder(new EmptyBorder(0, 5, 0, 5));
		GIOVE.setBackground(txtColor);

		disableJTextField(GIOVE);

		JPanel panel = new JPanel();
		panel.setBackground(background);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 5;
		gbc_panel.insets = new Insets(7, 7, 5, 7);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 7;
		add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 80, 99, 90, 95, 0, 90, 90 };
		gbl_panel.rowHeights = new int[] { 35, 30 };
		gbl_panel.columnWeights = new double[] { 0.1, 0.0, 0.07, 0.0, 1.0, 0.0, 0.0 };
		gbl_panel.rowWeights = new double[] { 0.4, 0.4 };
		panel.setLayout(gbl_panel);

		btnTimKiem = new BtnTimKiem();
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_3.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_3.gridx = 2;
		gbc_btnNewButton_3.gridy = 0;
		panel.add(btnTimKiem, gbc_btnNewButton_3);

		btnSua = new BtnSua();
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 3;
		gbc_btnNewButton_1.gridy = 0;
		panel.add(btnSua, gbc_btnNewButton_1);

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
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 8;
		add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0 };
		gbl_panel_4.rowHeights = new int[] { 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0 };
		gbl_panel_4.rowWeights = new double[] { 1.0 };
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
		MADVTOUR.setBorder(new EmptyBorder(0, 5, 0, 5));
		GIODI.setBorder(new EmptyBorder(0, 5, 0, 5));
		NGAYVE.setBorder(new EmptyBorder(0, 5, 0, 5));

		MADVTOUR.setBackground(txtColor);
		GIODI.setBackground(txtColor);
		NGAYVE.setBackground(txtColor);
		addController();
		addEvent();
		disableJTextField(DIEMDON);
		disableJTextField(MADVTOUR);
		disableJTextField(GIODI);
		disableJTextField(NGAYVE);

		if (table_1.getSelectedRow() == -1) {
			btnSua.setEnabled(false);
		}

		btnDongY.setEnabled(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 8; i++)
			table_1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

		table_1.getColumnModel().getColumn(0).setPreferredWidth(16);

		table_1.setDefaultEditor(Object.class, null);
		btnHuy.setEnabled(false);

		btnIN = new ButtonAmination();
		btnIN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					XSSFWorkbook wordkbook = new XSSFWorkbook();
					XSSFSheet sheet = wordkbook.createSheet("Danh sách lộ trình");
					XSSFRow row = null;
					Cell cell = null;
					row = sheet.createRow(2);
					cell = row.createCell(3, CellType.STRING);
					cell.setCellValue("Danh sách lộ trình");
					row = sheet.createRow(7);
					cell = row.createCell(0, CellType.STRING);
					cell.setCellValue("STT");
					cell = row.createCell(1, CellType.NUMERIC);
					cell.setCellValue("Mã dịch vụ tour");
					cell = row.createCell(2, CellType.STRING);
					cell.setCellValue("Giờ đi");
					cell = row.createCell(3, CellType.STRING);
					cell.setCellValue("Ngày đi");
					cell = row.createCell(4, CellType.STRING);
					cell.setCellValue("Giờ về");
					cell = row.createCell(5, CellType.NUMERIC);
					cell.setCellValue("Ngày về");
					cell = row.createCell(6, CellType.STRING);
					cell.setCellValue("Điểm đón");
					cell = row.createCell(7, CellType.STRING);
					cell.setCellValue("Điểm đến");
					for (int i = 0; i < dsLT.size(); i++) {

						row = sheet.createRow(8 + i);
						cell = row.createCell(0, CellType.NUMERIC);
						cell.setCellValue(i + 1);
						cell = row.createCell(1, CellType.NUMERIC);
						cell.setCellValue(dsLT.get(i).getMADVTOUR());
						cell = row.createCell(2, CellType.STRING);
						cell.setCellValue(dsLT.get(i).getgiodi());
						cell = row.createCell(3, CellType.STRING);
						cell.setCellValue(dsLT.get(i).getngaydi());
						cell = row.createCell(4, CellType.STRING);
						cell.setCellValue(dsLT.get(i).getgiove());
						cell = row.createCell(5, CellType.STRING);
						cell.setCellValue(dsLT.get(i).getngayve());
						cell = row.createCell(6, CellType.STRING);
						cell.setCellValue(dsLT.get(i).getdiemdon());
						cell = row.createCell(7, CellType.STRING);
						cell.setCellValue(dsLT.get(i).getdiemden());

					}
					File f = new File("./excel/LT.xlsx");
					try {
						FileOutputStream fo = new FileOutputStream(f);
						wordkbook.write(fo);
						fo.close();

					} catch (FileNotFoundException e1) {
						e1.printStackTrace();
					} catch (IOException e1) {
						e1.printStackTrace();
					} finally {
						try {

						} catch (Exception e1) {
							if (wordkbook != null) {
								wordkbook.close();
							}

						}
					}
					JOptionPane.showMessageDialog(null, "In thành công");

				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Lỗi in file");
				}

			}
		});
		btnIN.setText("IN");
		GridBagConstraints gbc_btnIN = new GridBagConstraints();
		gbc_btnIN.fill = GridBagConstraints.BOTH;
		gbc_btnIN.insets = new Insets(0, 0, 0, 5);
		gbc_btnIN.gridx = 5;
		gbc_btnIN.gridy = 1;
		panel.add(btnIN, gbc_btnIN);
		table_1.setFocusable(false);

		scrollPane.getViewport().setBackground(Color.white);

		if (table_1.getRowCount() > 0)
			table_1.setRowSelectionInterval(0, 0);

		t.start();
		pause();
		showtable();

		disableJTextField(NGAYDI);
		disableJTextField(DIEMDEN);
		
		if (!laAdmin) {
			PhanQuyen_BUS phanQuyenBUS = new PhanQuyen_BUS();
			PhanQuyen phanQuyen = new PhanQuyen();
			
			phanQuyen = phanQuyenBUS.timKiem(manvDN, "Sửa lộ trình");
			if (phanQuyen == null) 
				duocSua = false;
		}
	}

	int i = 1;

	public void showtable() {
		model.setRowCount(0);
		dsLT.clear();
		dsLT = ltBUS.getdsLoTrinh();
		for (DTO.LoTrinh lt : dsLT) {
			model.addRow(new Object[] { i++, lt.getMADVTOUR(), lt.getgiodi(), lt.getngaydi(), lt.getgiove(),
					lt.getngayve(), lt.getdiemdon(), lt.getdiemden() });
		}
		i = 1;
	}

	public void showtable_1(ArrayList<DTO.LoTrinh> dsLT) {
		model.setRowCount(0);
		for (DTO.LoTrinh lt : dsLT) {
			model.addRow(new Object[] { i++, lt.getMADVTOUR(), lt.getgiodi(), lt.getngaydi(), lt.getgiove(),
					lt.getngayve(), lt.getdiemdon(), lt.getdiemden() });
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
				if (i < 0)
					btnSua.setEnabled(false);
				else {
					if (duocSua)
						btnSua.setEnabled(true);
				}
					

				if (i >= 0 && selectedTable) {

					try {
						MADVTOUR.setText(model.getValueAt(i, 1).toString());
					} catch (Exception e1) {
						MADVTOUR.setText("");
					}

					try {
						GIOVE.setText(model.getValueAt(i, 4).toString());
					} catch (Exception e1) {
						GIOVE.setText("");
					}

					try {
						DIEMDON.setText(model.getValueAt(i, 6).toString());
					} catch (Exception e1) {
						DIEMDON.setText("");
					}

					try {
						GIODI.setText(model.getValueAt(i, 2).toString());
					} catch (Exception e1) {
						GIODI.setText("");
					}
					try {
						NGAYDI.setText(model.getValueAt(i, 3).toString());
					} catch (Exception e1) {
						NGAYDI.setText("");
					}

					try {
						NGAYVE.setText(model.getValueAt(i, 5).toString());
					} catch (Exception e1) {
						NGAYVE.setText("");
					}
					try {
						DIEMDEN.setText(model.getValueAt(i, 7).toString());
					} catch (Exception e1) {
						DIEMDEN.setText("");
					}

				}
			}
		});

		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ableJTextField(GIOVE);
				ableJTextField(DIEMDON);
				ableJTextField(GIODI);
				ableJTextField(NGAYVE);
				ableJTextField(NGAYDI);
				ableJTextField(DIEMDEN);

				btnDongY.setEnabled(true);

				btnHuy.setEnabled(true);
				temp = btnSua;

			}
		});

		btnTimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnDongY.setEnabled(true);
				ableJTextField(MADVTOUR);

				disableJTextField(GIOVE);
				disableJTextField(DIEMDON);

				btnHuy.setEnabled(true);
				temp = btnTimKiem;
			}
		});

		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				trongForm();
				disableJTextField(GIOVE);
				disableJTextField(DIEMDON);
				disableJTextField(GIODI);
				disableJTextField(NGAYVE);
				disableJTextField(NGAYDI);
				disableJTextField(DIEMDEN);
				disableJTextField(MADVTOUR);
				showtable();
				btnHuy.setEnabled(false);
				btnDongY.setEnabled(false);
				btnSua.setEnabled(false);
				temp = null;
			}
		});

		btnDongY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (temp == btnSua) {
					try {
						DTO.LoTrinh lt = new DTO.LoTrinh();
						lt.setmadvtour(Integer.parseInt(MADVTOUR.getText()));
						lt.setgiodi(GIODI.getText());
						lt.setngaydi(NGAYDI.getText());
						lt.setgiove(GIOVE.getText());
						lt.setngayve(NGAYVE.getText());
						lt.setdiemdon(DIEMDON.getText());
						lt.setdiemden(DIEMDEN.getText());

						if (ltBUS.suaLT(lt)) {
							disableJTextField(GIOVE);
							disableJTextField(DIEMDON);
							disableJTextField(GIODI);
							disableJTextField(NGAYVE);
							disableJTextField(NGAYDI);
							disableJTextField(DIEMDEN);
							btnHuy.setEnabled(false);
							btnSua.setEnabled(false);
							btnDongY.setEnabled(false);
							trongForm();
							showtable();
						}

					} catch (Exception ex) {
						ex.printStackTrace();
					}

					temp = null;
				}

				if (temp == btnTimKiem) {
					model.setRowCount(0);
					showtable_1(ltBUS.timKiem(MADVTOUR.getText()));
				}

				selectedTable = true;
			}
		});
	}

	public void xuLySuKienThem() {

		DTO.LoTrinh lt = new DTO.LoTrinh();
		lt.setmadvtour(maLTMax++);
		lt.setgiodi(GIODI.getText());
		lt.setngaydi(NGAYDI.getText());
		lt.setgiove(GIOVE.getText());
		lt.setngayve(NGAYVE.getText());
		lt.setdiemdon(DIEMDON.getText());
		lt.setdiemden(DIEMDEN.getText());
		DAO.Lotrinh LTDAO = new DAO.Lotrinh();
		LTDAO.addLT(lt);
		dsLT.add(lt);
		disableJTextField(GIODI);
		disableJTextField(NGAYVE);
		disableJTextField(DIEMDON);

	}

	public void addController() {
		row = new Object[8];
	}

	public void disableJTextField(TextFielAmination field) {
		field.setEnabled(false);
		field.setBackground(background);
		repaint();
	}

	public void ableJTextField(TextFielAmination field) {
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
		MADVTOUR.setText("");
		GIODI.setText("");
		DIEMDON.setText("");
		GIOVE.setText("");
		NGAYVE.setText("");
		NGAYDI.setText("");
		DIEMDEN.setText("");
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
				if (x + size.width == 0) {
					x = panel_3.getWidth();
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
	private JLabel lblNewLabel_21;
	private TextFielAmination DIEMDEN;
	private ButtonAmination btnIN;
	private TextFielAmination NGAYDI;

}