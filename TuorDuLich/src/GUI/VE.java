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

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import BUS.CheDo_BUS;
import BUS.ChietTinhTour_BUS;
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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class VE extends JPanel {

	private TextFielAmination MAVE;
	protected TextFielAmination NGAYTAO;
	private TextFielAmination GIA;
	private TextFielAmination MAKH;
	private TextFielAmination MADVTOUR;
	private JTable table_1;
	private DefaultTableModel model;
	private Color background =  new Color(111, 211, 178);
	private BtnThem btnthmThem;
	private BtnTimKiem btntmkmTimkiem;
	private BtnXoa btnxXoa;
	private Object[] row;
	private ArrayList<DTO.VE> dsVE = new ArrayList<DTO.VE>();
	private JButton temp;
	private ButtonAmination btnDongY;
	private boolean selectedTable = true;
	private ButtonAmination btnHuy;
	private JPanel panel_1;
	private JPanel panel_3;
	private JLabel lblContent;
	private Object[] column = { "STT", "Mã vé", "Ngày tạo", "Mã khách hàng", "Mã dịch vụ tour", "Giá", "Mã nhân viên" };
	private static int maVEMax = 0;
	private JPanel panel_4;
	private String ngayTaoVe;
	private BUS.VE veBUS = new BUS.VE();
	private long tongTien = 0;
	private int maNVDN = 0;
	private int maDVTourCT = 0;
	private NguoiDung_BUS ndBUS = new NguoiDung_BUS();

	private boolean duocThem =  true;
	private boolean duocXoa = true;
	private boolean laAdmin = false;
	private boolean cheDo = true;
	private Color txtColor = Color.white;

	
	public BtnThem getBtnthmThem() {
		return btnthmThem;
	}

	public void setBtnthmThem(BtnThem btnthmThem) {
		this.btnthmThem = btnthmThem;
	}

	private ChietTinhTour_BUS ctBUS = new ChietTinhTour_BUS();
	
	public int getMaDVTourCT() {
		return maDVTourCT;
	}

	public void setMaDVTourCT(int maDVTourCT) {
		this.maDVTourCT = maDVTourCT;
	}

	public VE(int manvDN) {
		
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
		
		maNVDN = manvDN;

		setBackground(background);

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 70, 0, 33, 33, 33, 33, 0, 70, 190 };
		gridBagLayout.columnWeights = new double[] { 0.0, 1.0, 0.2, 0.0, 1.0 };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.08, 0.08, 0.08, 0.08, 0.0, 0.07, 1.0 };
		setLayout(gridBagLayout);
		model = new DefaultTableModel();
		Object[] row = new Object[0];
		model.setColumnIdentifiers(column);
		dsVE = new DAO.VE().getdsVE();
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

		lblContent = new JLabel("Chào mừng bạn đến với giao diện quản lý vé");
		lblContent.setBounds(139, 11, 243, 33);
		lblContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		panel_3.add(lblContent);

		JLabel lblNewLabel_17 = new JLabel("Mã vé : ");
		GridBagConstraints gbc_lblNewLabel_17 = new GridBagConstraints();
		gbc_lblNewLabel_17.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_17.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_17.gridx = 0;
		gbc_lblNewLabel_17.gridy = 2;
		add(lblNewLabel_17, gbc_lblNewLabel_17);

		MAVE = new TextFielAmination();
		MAVE.setRadius(10);
		MAVE.setColumns(10);
		GridBagConstraints gbc_MAVE = new GridBagConstraints();
		gbc_MAVE.fill = GridBagConstraints.BOTH;
		gbc_MAVE.insets = new Insets(0, 20, 8, 20);
		gbc_MAVE.gridx = 1;
		gbc_MAVE.gridy = 2;
		add(MAVE, gbc_MAVE);

		JLabel lblNewLabel_21_3 = new JLabel("Mã dịch vụ tour : ");
		GridBagConstraints gbc_lblNewLabel_21_3 = new GridBagConstraints();
		gbc_lblNewLabel_21_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21_3.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21_3.gridx = 3;
		gbc_lblNewLabel_21_3.gridy = 2;
		add(lblNewLabel_21_3, gbc_lblNewLabel_21_3);

		MADVTOUR = new TextFielAmination();
		MADVTOUR.setRadius(10);
		MADVTOUR.setMinimumSize(new Dimension(68, 19));
		// MADVTOUR.setFont(new Font("Tahoma", Font.PLAIN, 15));
		MADVTOUR.setColumns(10);
		GridBagConstraints gbc_MADVTOUR = new GridBagConstraints();
		gbc_MADVTOUR.insets = new Insets(0, 0, 8, 10);
		gbc_MADVTOUR.fill = GridBagConstraints.BOTH;
		gbc_MADVTOUR.gridx = 4;
		gbc_MADVTOUR.gridy = 2;
		add(MADVTOUR, gbc_MADVTOUR);

		JLabel lblNewLabel_18 = new JLabel("Ngày tạo : ");
		GridBagConstraints gbc_lblNewLabel_18 = new GridBagConstraints();
		gbc_lblNewLabel_18.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_18.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_18.gridx = 0;
		gbc_lblNewLabel_18.gridy = 3;
		add(lblNewLabel_18, gbc_lblNewLabel_18);

		NGAYTAO = new TextFielAmination();
		NGAYTAO.setRadius(10);
		NGAYTAO.setColumns(10);
		GridBagConstraints gbc_NGAYTAO = new GridBagConstraints();
		gbc_NGAYTAO.fill = GridBagConstraints.BOTH;
		gbc_NGAYTAO.insets = new Insets(0, 20, 8, 20);
		gbc_NGAYTAO.gridx = 1;
		gbc_NGAYTAO.gridy = 3;
		add(NGAYTAO, gbc_NGAYTAO);

		JLabel lblNewLabel_21_1 = new JLabel("Tổng tiền : ");
		GridBagConstraints gbc_lblNewLabel_21_1 = new GridBagConstraints();
		gbc_lblNewLabel_21_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21_1.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21_1.gridx = 3;
		gbc_lblNewLabel_21_1.gridy = 3;
		add(lblNewLabel_21_1, gbc_lblNewLabel_21_1);

		GIA = new TextFielAmination();
		GIA.setRadius(10);
		GIA.setMinimumSize(new Dimension(0, 19));
		GIA.setColumns(10);
		GridBagConstraints gbc_GIA = new GridBagConstraints();
		gbc_GIA.fill = GridBagConstraints.BOTH;
		gbc_GIA.insets = new Insets(0, 0, 8, 10);
		gbc_GIA.gridx = 4;
		gbc_GIA.gridy = 3;
		add(GIA, gbc_GIA);
		GIA.setBorder(new EmptyBorder(0, 5, 0, 5));
		GIA.setBackground(txtColor);

		JLabel lblNewLabel_20 = new JLabel("Mã khách hàng : ");
		GridBagConstraints gbc_lblNewLabel_20 = new GridBagConstraints();
		gbc_lblNewLabel_20.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_20.insets = new Insets(0, 10, 5, 20);
		gbc_lblNewLabel_20.gridx = 0;
		gbc_lblNewLabel_20.gridy = 4;
		add(lblNewLabel_20, gbc_lblNewLabel_20);

		MAKH = new TextFielAmination();
		MAKH.setRadius(10);
		MAKH.setMinimumSize(new Dimension(68, 19));
		MAKH.setColumns(10);
		GridBagConstraints gbc_MAKH = new GridBagConstraints();
		gbc_MAKH.fill = GridBagConstraints.BOTH;
		gbc_MAKH.insets = new Insets(0, 20, 8, 20);
		gbc_MAKH.gridx = 1;
		gbc_MAKH.gridy = 4;
		add(MAKH, gbc_MAKH);
		MAKH.setBorder(new EmptyBorder(0, 5, 0, 5));
		MAKH.setBackground(txtColor);

		lblNewLabel_21 = new JLabel("Mã nhân viên : ");
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 5, 20);
		gbc_lblNewLabel_21.gridx = 3;
		gbc_lblNewLabel_21.gridy = 4;
		add(lblNewLabel_21, gbc_lblNewLabel_21);

		MANV = new TextFielAmination();
		MANV.setRadius(10);
		MANV.setMinimumSize(new Dimension(68, 19));
		MANV.setColumns(10);
		MANV.setBorder(new EmptyBorder(0, 5, 0, 5));
		MANV.setBackground(txtColor);
		GridBagConstraints gbc_MANV = new GridBagConstraints();
		gbc_MANV.insets = new Insets(0, 0, 8, 10);
		gbc_MANV.fill = GridBagConstraints.BOTH;
		gbc_MANV.gridx = 4;
		gbc_MANV.gridy = 4;
		add(MANV, gbc_MANV);

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
				
						btntmkmTimkiem = new BtnTimKiem();
						GridBagConstraints gbc_btntmkmTimkiem = new GridBagConstraints();
						gbc_btntmkmTimkiem.fill = GridBagConstraints.BOTH;
						gbc_btntmkmTimkiem.insets = new Insets(0, 0, 5, 5);
						gbc_btntmkmTimkiem.gridx = 2;
						gbc_btntmkmTimkiem.gridy = 0;
						panel.add(btntmkmTimkiem, gbc_btntmkmTimkiem);
		
				btnthmThem = new BtnThem();
				GridBagConstraints gbc_btnthmThem = new GridBagConstraints();
				gbc_btnthmThem.fill = GridBagConstraints.BOTH;
				gbc_btnthmThem.insets = new Insets(0, 0, 5, 5);
				gbc_btnthmThem.gridx = 3;
				gbc_btnthmThem.gridy = 0;
				panel.add(btnthmThem, gbc_btnthmThem);

		btnxXoa = new BtnXoa();
		GridBagConstraints gbc_btnxXoa = new GridBagConstraints();
		gbc_btnxXoa.insets = new Insets(0, 0, 5, 10);
		gbc_btnxXoa.fill = GridBagConstraints.BOTH;
		gbc_btnxXoa.gridx = 5;
		gbc_btnxXoa.gridy = 0;
		panel.add(btnxXoa, gbc_btnxXoa);

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
		MAVE.setBorder(new EmptyBorder(0, 5, 0, 5));
		NGAYTAO.setBorder(new EmptyBorder(0, 5, 0, 5));
		MADVTOUR.setBorder(new EmptyBorder(0, 5, 0, 5));

		MAVE.setBackground(txtColor);
		NGAYTAO.setBackground(txtColor);
		MADVTOUR.setBackground(txtColor);
		addController();
		addEvent();
		disableJTextField(GIA);
		disableJTextField(MAVE);
		disableJTextField(NGAYTAO);
		disableJTextField(MADVTOUR);

		if (table_1.getSelectedRow() == -1) {
			btnxXoa.setEnabled(false);
		}

		btnDongY.setEnabled(false);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 7; i++)
			table_1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

		table_1.getColumnModel().getColumn(0).setPreferredWidth(16);

		table_1.setDefaultEditor(Object.class, null);
		btnHuy.setEnabled(false);

		btnthmIn = new ButtonAmination();
		btnthmIn.setText("Xuất PDF");
		btnthmIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Document document = new Document();
					PdfWriter.getInstance(document, new FileOutputStream("./excel/ve.pdf"));
					document.open();
					document.add(new Paragraph("          Ve du lich sanh\n\n"));
					document.add(new Paragraph("Ma ve                  : "+ MAVE.getText()));
					document.add(new Paragraph("Ma khach hang   : "+ MAKH.getText()));
					document.add(new Paragraph("Ma nhan vien      : "+ MANV.getText()));
					document.add(new Paragraph("Ma dich vu tour   : "+ MADVTOUR.getText()));
					document.add(new Paragraph("Ngay tao             : "+ NGAYTAO.getText()));
					document.add(new Paragraph("--------------------"));
					document.add(new Paragraph("Tong tien            : "+ GIA.getText()));
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Xuất pdf thành công!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					document.close();
				} catch (Exception e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Xuất pdf thất bại!", "Thông báo",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		//btnthmIn.setBorderColor(new Color(238, 130, 238));
		GridBagConstraints gbc_btnthmIn = new GridBagConstraints();
		gbc_btnthmIn.fill = GridBagConstraints.BOTH;
		gbc_btnthmIn.insets = new Insets(0, 0, 0, 5);
		gbc_btnthmIn.gridx = 5;
		gbc_btnthmIn.gridy = 1;
		panel.add(btnthmIn, gbc_btnthmIn);
		table_1.setFocusable(false);

		scrollPane.getViewport().setBackground(Color.white);

		if (table_1.getRowCount() > 0)
			table_1.setRowSelectionInterval(0, 0);

		disableJTextField(MAKH);
		disableJTextField(MANV);
		
		t.start();
		pause();
		showtable();
		
		if (!laAdmin) {
			PhanQuyen_BUS phanQuyenBUS = new PhanQuyen_BUS();
			PhanQuyen phanQuyen = new PhanQuyen();
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Thêm vé");
			if (phanQuyen == null) {
				duocThem = false;
				btnthmThem.setEnabled(false);
			}
			
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Xóa vé");
			if (phanQuyen == null) 
				duocXoa = false;
		}

	}

	int i = 1;

	public void showtable() {
		model.setRowCount(0);
		dsVE.clear();
		dsVE = veBUS.getdsVE();
		for (DTO.VE ve : dsVE) {
			model.addRow(new Object[] { i++, ve.getMAVE(), ve.getNGAYTAO(), ve.getMAKH(), ve.getMADVTOUR(), ve.getGIA(),
					ve.getMANV() });
		}
		i = 1;
	}

	public void showtable_1(ArrayList<DTO.VE> dsVE) {
		model.setRowCount(0);
		for (DTO.VE ve : dsVE) {
			model.addRow(new Object[] { i++, ve.getMAVE(), ve.getNGAYTAO(), ve.getMAKH(), ve.getMADVTOUR(), ve.getGIA(),
					ve.getMANV() });
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

				if (i >= 0 && selectedTable) {

					try {
						MAVE.setText(model.getValueAt(i, 1).toString());
					} catch (Exception e1) {
						MAVE.setText("");
					}

					try {
						MAKH.setText(model.getValueAt(i, 3).toString());
					} catch (Exception e1) {
						MAKH.setText("");
					}

					try {
						GIA.setText(model.getValueAt(i, 5).toString());
					} catch (Exception e1) {
						GIA.setText("");
					}

					try {
						NGAYTAO.setText(model.getValueAt(i, 2).toString());
					} catch (Exception e1) {
						NGAYTAO.setText("");
					}

					try {
						MADVTOUR.setText(model.getValueAt(i, 4).toString());
					} catch (Exception e1) {
						MADVTOUR.setText("");
					}
					try {
						MANV.setText(model.getValueAt(i, 6).toString());
					} catch (Exception e1) {
						MANV.setText("");
					}

					if (duocXoa) {
						btnxXoa.setEnabled(true);
					}
				}
			}
		});
		
		MADVTOUR.addKeyListener(new KeyListener() {
			
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
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					int ma = 0;
					try {
						ma = Integer.parseInt(MADVTOUR.getText());
					} catch (Exception sa) {
						ma = 0;
					}
					
					maDVTourCT = ma;
					tongTien = ctBUS.tongGia(maDVTourCT);
	            }else if (e.getKeyCode() == KeyEvent.VK_TAB) {
					int ma = 0;
					try {
						ma = Integer.parseInt(MADVTOUR.getText());
					} catch (Exception sa) {
						ma = 0;
					}
					
					maDVTourCT = ma;
					tongTien = ctBUS.tongGia(maDVTourCT);
	            }
			}
		});
		
		MAKH.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				int ma = 0;
				try {
					ma = Integer.parseInt(MADVTOUR.getText());
				} catch (Exception sa) {
					ma = 0;
				}
				
				maDVTourCT = ma;
				tongTien = ctBUS.tongGia(maDVTourCT);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

				int ma = 0;
				try {
					ma = Integer.parseInt(MADVTOUR.getText());
				} catch (Exception sa) {
					ma = 0;
				}
				
				maDVTourCT = ma;
				tongTien = ctBUS.tongGia(maDVTourCT);
			}
		});

		btnthmThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trongForm();
				if (maDVTourCT != -1) {
					Calendar c = Calendar.getInstance();
					int year = c.get(Calendar.YEAR);
					int month = c.get(Calendar.MONTH) + 1;
					int day = c.get(Calendar.DAY_OF_MONTH);
					
					ngayTaoVe = day + "/" + month + "/" + year;
					
					NGAYTAO.setText(ngayTaoVe);
					
					MANV.setText(String.valueOf(maNVDN));
					
					MADVTOUR.setText(String.valueOf(maDVTourCT));
					
					tongTien = ctBUS.tongGia(maDVTourCT);
					
					GIA.setText(String.valueOf(tongTien));
					
					ableJTextField(MAKH);
					ableJTextField(MADVTOUR);

					btnxXoa.setEnabled(false);
					btnHuy.setEnabled(true);
					disableJTextField(MAVE);
					btnDongY.setEnabled(true);
					temp = btnthmThem;
				} else {
					trongForm();
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Dịch vụ đã được tạo vé!", "Thông báo",
							JOptionPane.INFORMATION_MESSAGE);
					maDVTourCT = 0;
				}

			}
		});

		btnxXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(MAVE.getText());
				
				if (veBUS.xoa(id)) {
					showtable();
				}
				
				trongForm();
				btnxXoa.setEnabled(false);
			}
		});

		btntmkmTimkiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				btnDongY.setEnabled(true);
				ableJTextField(MAVE);
				ableJTextField(MADVTOUR);

				disableJTextField(MAKH);
				disableJTextField(GIA);
				disableJTextField(MAVE);
				btnthmThem.setEnabled(false);
				btnHuy.setEnabled(true);
				temp = btntmkmTimkiem;
			}
		});

		btnHuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				trongForm();
				disableJTextField(MAKH);
				disableJTextField(GIA);
				disableJTextField(MAVE);
				disableJTextField(MADVTOUR);
				disableJTextField(MANV);
				disableJTextField(NGAYTAO);
				
				btnxXoa.setEnabled(false);
				btnHuy.setEnabled(false);
				btnDongY.setEnabled(false);
				btnthmThem.setEnabled(true);
				showtable();
				temp = null;
			}
		});

		btnDongY.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (temp == btnthmThem)
					xuLySuKienThem();

				if (temp == btntmkmTimkiem) {
					
					showtable_1(veBUS.timKiem(MADVTOUR.getText()));
				}

				selectedTable = true;
			}
		});
	}

	public void xuLySuKienThem() {

		DTO.VE ve = new DTO.VE();
		ve.setNGAYTAO(ngayTaoVe);
		
		int maKH = 0, maDVTour = 0;
		
		try {
			maKH = Integer.parseInt(MAKH.getText());
		} catch (NumberFormatException es) {
			maKH = 0;
		} catch (Exception a) {
			maKH = 0;
		}
		ve.setMAKH(maKH);
		
		try {
			maDVTour = Integer.parseInt(MADVTOUR.getText());
		} catch (NumberFormatException es) {
			maDVTour = 0;
		} catch (Exception a) {
			maDVTour = 0;
		}
		
		ve.setMADVTOUR(maDVTour);
		ve.setGIA(tongTien);
		ve.setMANV(maNVDN);
		
		if (veBUS.addVE(ve)) {
			trongForm();
			showtable();
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Tạo vé thành công!", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			disableJTextField(NGAYTAO);
			disableJTextField(MADVTOUR);
			disableJTextField(GIA);
			disableJTextField(MAKH);
			btnDongY.setEnabled(false);
			btnHuy.setEnabled(false);
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
		MAVE.setText("");
		NGAYTAO.setText("");
		GIA.setText("");
		MAKH.setText("");
		MADVTOUR.setText("");
		MANV.setText("");
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
	private ButtonAmination btnthmIn;
	private TextFielAmination MANV;
}