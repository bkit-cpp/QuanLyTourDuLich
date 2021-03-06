package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import BUS.CheDo_BUS;
import BUS.TourMoBan_BUS;
import javax.swing.DefaultComboBoxModel;

public class TourMoBan extends JPanel {

	private DefaultTableModel model;
	private static JTable table;
	private Object[] row = new Object[10];
	private JPanel panel_9;
	private Color bg_selected = new Color(111, 211, 178);
	private TextFielAmination txtTimKiem;
	private TourMoBan_BUS tourBUS = new TourMoBan_BUS();
	private ArrayList<DTO.TourMoBan> dsTour = new ArrayList<DTO.TourMoBan>();
	private ButtonAmination btnLamMoi;
	private JComboBox loaiTour_TimKiem, trangThai_TimKiem;
	private BtnXoa xoa;
	private int maTour = 0;
	private boolean duocXoa = true;
	private boolean cheDo = true;
	private Color bg_item = Color.white;
	private JPopupMenu popupMenu;
	private JMenuItem mntmNewMenuItem;
	private int maDVVE = 0;
	
	public JMenuItem getMntmNewMenuItem() {
		return mntmNewMenuItem;
	}


	public void setMntmNewMenuItem(JMenuItem mntmNewMenuItem) {
		this.mntmNewMenuItem = mntmNewMenuItem;
	}


	public int getMaDVVE() {
		return maDVVE;
	}


	public void setMaDVVE(int maDVVE) {
		this.maDVVE = maDVVE;
	}


	public boolean isCheDo() {
		return cheDo;
	}


	public void setCheDo(boolean cheDo) {
		this.cheDo = cheDo;
	}
	
	public boolean isDuocXoa() {
		return duocXoa;
	}

	public void setDuocXoa(boolean duocXoa) {
		this.duocXoa = duocXoa;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ButtonAmination getBtnLamMoi() {
		return btnLamMoi;
	}

	public void setBtnLamMoi(ButtonAmination btnLamMoi) {
		this.btnLamMoi = btnLamMoi;
	}

	public int getMaTour() {
		return maTour;
	}

	public void setMaTour(int maTour) {
		this.maTour = maTour;
	}

	public TourMoBan() {
		
		CheDo_BUS cdBUS = new CheDo_BUS();
		cheDo = cdBUS.readClientList();
		
		if (!cheDo) {
			CheDoMau mau = new CheDoMau();
			//background = mau.getMauPhuSang();
			bg_selected = mau.getMauPhuSang();
			bg_item = mau.getMauChinhSang();
		}

		model = new DefaultTableModel();
		Object[] column = { "STT", "Lo???i tour", "M?? tour", "T??n tour", "S??? ng??y", "Gi?? ?????i l??", "Gi?? kh??ch l???",
				"S??? ch???", "Ng??y kh???i h??nh", "Tr???ng th??i" };
		model.setColumnIdentifiers(column);

		setBackground(bg_selected);

		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0 };
		gbl_panel_4.rowHeights = new int[] { 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0 };
		gbl_panel_4.rowWeights = new double[] { 0.0, 1.0 };
		setLayout(gbl_panel_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);

		table = new JTable();
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		popupMenu = new JPopupMenu();
		addPopup(table, popupMenu);
		
		mntmNewMenuItem = new JMenuItem("T???o v??		");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int i = table.getSelectedRow();
				maDVVE = Integer.parseInt(model.getValueAt(i, 2).toString());
			}
		});
		popupMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Th??i		");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		popupMenu.add(mntmNewMenuItem_1);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);

		table.setDefaultEditor(Object.class, null);

		for (int i = 0; i < 10; i++)
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);

		GridBagConstraints gbc_scrollPane_11 = new GridBagConstraints();
		gbc_scrollPane_11.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_11.insets = new Insets(7, 2, 2, 2);
		gbc_scrollPane_11.gridx = 0;
		gbc_scrollPane_11.gridy = 1;
		add(scrollPane, gbc_scrollPane_11);

		table.getColumnModel().getColumn(0).setPreferredWidth(23);

		panel_9 = new JPanel();
		panel_9.setBackground(bg_selected);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.insets = new Insets(8, 0, 0, 0);
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 0;
		add(panel_9, gbc_panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[] { 0, 0, 0, 35, 35, 0, 30 };
		gbl_panel_9.rowHeights = new int[] { 0 };
		gbl_panel_9.columnWeights = new double[] { 0.4, 0.2, 0.2, 0.1, 0.1, 1.0, 0.1 };
		gbl_panel_9.rowWeights = new double[] { 1.0 };
		panel_9.setLayout(gbl_panel_9);

		txtTimKiem = new TextFielAmination();
		txtTimKiem.setBackground(bg_item);
		txtTimKiem.setRadius(5);
		txtTimKiem.setBorder(new EmptyBorder(2, 6, 2, 4));
		//txtTimKiem.setBackground(Color.WHITE);

		GridBagConstraints gbc_txtTimKiem = new GridBagConstraints();
		gbc_txtTimKiem.fill = GridBagConstraints.BOTH;
		gbc_txtTimKiem.insets = new Insets(0, 10, 0, 5);
		gbc_txtTimKiem.gridx = 0;
		gbc_txtTimKiem.gridy = 0;
		panel_9.add(txtTimKiem, gbc_txtTimKiem);
		txtTimKiem.setColumns(10);

		loaiTour_TimKiem = new JComboBox();
		loaiTour_TimKiem.setModel(new DefaultComboBoxModel(new String[] { "Lo???i tour", "PRIVATE", "S.I.C" }));
		GridBagConstraints gbc_loaiTour_TimKiem = new GridBagConstraints();
		gbc_loaiTour_TimKiem.insets = new Insets(0, 0, 0, 5);
		gbc_loaiTour_TimKiem.fill = GridBagConstraints.BOTH;
		gbc_loaiTour_TimKiem.gridx = 1;
		gbc_loaiTour_TimKiem.gridy = 0;
		panel_9.add(loaiTour_TimKiem, gbc_loaiTour_TimKiem);

		trangThai_TimKiem = new JComboBox();
		trangThai_TimKiem
				.setModel(new DefaultComboBoxModel(new String[] { "Tr???ng th??i", "???? chi???t t??nh", "Ch??a chi???t t??nh" }));
		GridBagConstraints gbc_trangThai_TimKiem = new GridBagConstraints();
		gbc_trangThai_TimKiem.insets = new Insets(0, 0, 0, 5);
		gbc_trangThai_TimKiem.fill = GridBagConstraints.BOTH;
		gbc_trangThai_TimKiem.gridx = 2;
		gbc_trangThai_TimKiem.gridy = 0;
		panel_9.add(trangThai_TimKiem, gbc_trangThai_TimKiem);

		xoa = new BtnXoa();
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_1.gridx = 4;
		gbc_btnNewButton_1.gridy = 0;
		panel_9.add(xoa, gbc_btnNewButton_1);

		btnLamMoi = new ButtonAmination();
		btnLamMoi.setText("L??m m???i");
		GridBagConstraints gbc_btnLamMoi = new GridBagConstraints();
		gbc_btnLamMoi.fill = GridBagConstraints.BOTH;
		gbc_btnLamMoi.gridx = 6;
		gbc_btnLamMoi.gridy = 0;
		panel_9.add(btnLamMoi, gbc_btnLamMoi);

		table.getColumnModel().getColumn(0).setPreferredWidth(16);
		table.getColumnModel().getColumn(1).setPreferredWidth(18);
		table.getColumnModel().getColumn(2).setPreferredWidth(18);
		table.getColumnModel().getColumn(7).setPreferredWidth(18);
		table.getColumnModel().getColumn(9).setPreferredWidth(18);

		hienThi();
		xoa.setEnabled(false);

		AddEvents();
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					Point point = e.getPoint();
			        int currentRow = table.rowAtPoint(point);
			        table.setRowSelectionInterval(currentRow, currentRow);
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void AddEvents() {

		loaiTour_TimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (loaiTour_TimKiem.getSelectedIndex() == 0) {
					if (trangThai_TimKiem.getSelectedIndex() != 0) {
						if (trangThai_TimKiem.getSelectedIndex() == 1) {
							hienThi(tourBUS.timKiemTrangThai("???? chi???t t??nh"));
						} else if (trangThai_TimKiem.getSelectedIndex() == 2)
							hienThi(tourBUS.timKiemTrangThai("Ch??a chi???t t??nh"));
					} else {
						hienThi();
					}
					txtTimKiem.setText("");
				} else {
					if (loaiTour_TimKiem.getSelectedIndex() != 0 && trangThai_TimKiem.getSelectedIndex() == 0) {
						if (loaiTour_TimKiem.getSelectedIndex() == 1) {
							hienThi(tourBUS.timKiemLoai("PRIVATE"));
						} else if (loaiTour_TimKiem.getSelectedIndex() == 2)
							hienThi(tourBUS.timKiemLoai("S.I.C"));
						txtTimKiem.setText("");
					} else {
						if (loaiTour_TimKiem.getSelectedIndex() == 1 && trangThai_TimKiem.getSelectedIndex() == 1) {
							hienThi(tourBUS.timKiemLHVaTrangThai("PRIVATE", "???? chi???t t??nh"));
						} else if (loaiTour_TimKiem.getSelectedIndex() == 1
								&& trangThai_TimKiem.getSelectedIndex() == 2) {
							hienThi(tourBUS.timKiemLHVaTrangThai("PRIVATE", "Ch??a chi???t t??nh"));
						} else if (loaiTour_TimKiem.getSelectedIndex() == 2
								&& trangThai_TimKiem.getSelectedIndex() == 1) {
							hienThi(tourBUS.timKiemLHVaTrangThai("S.I.C", "???? chi???t t??nh"));
						} else {
							hienThi(tourBUS.timKiemLHVaTrangThai("S.I.C", "Ch??a chi???t t??nh"));
						}
						txtTimKiem.setText("");
					}
				}

			}
		});

		trangThai_TimKiem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (trangThai_TimKiem.getSelectedIndex() == 0) {
					if (loaiTour_TimKiem.getSelectedIndex() != 0) {
						if (loaiTour_TimKiem.getSelectedIndex() == 1) {
							hienThi(tourBUS.timKiemLoai("PRIVATE"));
						} else if (loaiTour_TimKiem.getSelectedIndex() == 2)
							hienThi(tourBUS.timKiemLoai("S.I.C"));
					} else
						hienThi();

					txtTimKiem.setText("");
				} else {
					if (loaiTour_TimKiem.getSelectedIndex() == 0) {
						if (trangThai_TimKiem.getSelectedIndex() == 1) {
							hienThi(tourBUS.timKiemTrangThai("???? chi???t t??nh"));
						} else if (trangThai_TimKiem.getSelectedIndex() == 2)
							hienThi(tourBUS.timKiemTrangThai("Ch??a chi???t t??nh"));
						txtTimKiem.setText("");

					} else if (loaiTour_TimKiem.getSelectedIndex() != 0) {
						if (loaiTour_TimKiem.getSelectedIndex() == 1 && trangThai_TimKiem.getSelectedIndex() == 1) {
							hienThi(tourBUS.timKiemLHVaTrangThai("PRIVATE", "???? chi???t t??nh"));
						} else if (loaiTour_TimKiem.getSelectedIndex() == 1
								&& trangThai_TimKiem.getSelectedIndex() == 2) {
							hienThi(tourBUS.timKiemLHVaTrangThai("PRIVATE", "Ch??a chi???t t??nh"));
						} else if (loaiTour_TimKiem.getSelectedIndex() == 2
								&& trangThai_TimKiem.getSelectedIndex() == 1) {
							hienThi(tourBUS.timKiemLHVaTrangThai("S.I.C", "???? chi???t t??nh"));
						} else {
							hienThi(tourBUS.timKiemLHVaTrangThai("S.I.C", "Ch??a chi???t t??nh"));
						}
						txtTimKiem.setText("");
					}
				}
			}
		});

		txtTimKiem.addKeyListener(new KeyListener() {

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
					hienThi(tourBUS.timKiemTen(txtTimKiem.getText()));
				}
			}
		});

		txtTimKiem.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				hienThi();
			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				loaiTour_TimKiem.setSelectedIndex(0);
				trangThai_TimKiem.setSelectedIndex(0);
			}
		});

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

				int i = table.getSelectedRow();

				if (i >= 0) {

					if (duocXoa)
						xoa.setEnabled(true);

					maTour = Integer.parseInt(model.getValueAt(i, 2).toString());

				}
			}
		});

		btnLamMoi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loaiTour_TimKiem.setSelectedIndex(0);
				trangThai_TimKiem.setSelectedIndex(0);
				xoa.setEnabled(false);
			}
		});

		xoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				boolean flag = false;

				int output = JOptionPane.showConfirmDialog(TrangChinh.getFrames()[0],
						"B???n c?? ch???c ch???n x??a d???ch v??? n??y?", "Th??ng b??o!!!", JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					flag = true;
				}
				if (flag) {
					if (tourBUS.xoaTour(model.getValueAt(table.getSelectedRow(), 2).toString())) {
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "X??a th??nh c??ng!", "Th??ng b??o!!!",
								JOptionPane.INFORMATION_MESSAGE);
						hienThi();
					} else {
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "X??a th???t b???i!", "Th??ng b??o!!!",
								JOptionPane.WARNING_MESSAGE);
					}
				}
				xoa.setEnabled(false);
			}
		});
	}

	public void hienThi() {
		dsTour.clear();
		tourBUS.docDsTour();
		dsTour = tourBUS.getDsTour();
		model.setRowCount(0);

		int x = 0;
		try {
			x = dsTour.size();
		} catch (Exception ex) {
			x = 0;
		}

		for (int i = 0; i < x; i++) {
			row[0] = i + 1;
			row[1] = dsTour.get(i).getLoaiDV();
			row[2] = dsTour.get(i).getMaDV();
			row[3] = dsTour.get(i).getTenDV();
			row[4] = dsTour.get(i).getThoiGian();
			row[5] = dsTour.get(i).getGiaDaiLy();
			row[6] = dsTour.get(i).getGiaKhachLe();
			row[7] = dsTour.get(i).getSoCho();
			row[8] = dsTour.get(i).getNgayKhoiHanh();
			row[9] = dsTour.get(i).getTrangThai();

			model.addRow(row);
		}
	}

	public void hienThi(ArrayList<DTO.TourMoBan> dsTour) {
		model.setRowCount(0);
		int x = 0;
		try {
			x = dsTour.size();
		} catch (Exception ex) {
			x = 0;
		}
		for (int i = 0; i < x; i++) {
			row[0] = i + 1;
			row[1] = dsTour.get(i).getLoaiDV();
			row[2] = dsTour.get(i).getMaDV();
			row[3] = dsTour.get(i).getTenDV();
			row[4] = dsTour.get(i).getThoiGian();
			row[5] = dsTour.get(i).getGiaDaiLy();
			row[6] = dsTour.get(i).getGiaKhachLe();
			row[7] = dsTour.get(i).getSoCho();
			row[8] = dsTour.get(i).getNgayKhoiHanh();
			row[9] = dsTour.get(i).getTrangThai();

			model.addRow(row);
		}
	}
}
