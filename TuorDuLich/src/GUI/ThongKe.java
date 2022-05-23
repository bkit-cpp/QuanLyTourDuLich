package GUI;

import java.awt.BasicStroke;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import BUS.CheDo_BUS;
import BUS.ThongKe_BUS;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JTextField;
import java.awt.Font;

public class ThongKe extends JPanel {

	private Color background = new Color(111, 211, 178);
	private JPanel panel_3;
	private DefaultTableModel model = new DefaultTableModel();
	Object[] column = { "STT", "Tên khách hàng", "Tên dịch vụ tour", "Thời gian", "Doanh thu" };
	Object[] row = new Object[5];
	private JTable table_1;
	private JTextField txtTongDT;
	private TextFielAmination txtnam, txtthang;
	private ThongKe_BUS tkBUS = new ThongKe_BUS();
	private boolean flag = true;
	
	private boolean cheDo = true;
	private Color bg_item = Color.white;
	private Color bg_Chart = new Color(142, 193, 203);


	private ButtonAmination btnNewButton;
	
	public ThongKe() {
		CheDo_BUS cdBUS = new CheDo_BUS();
		cheDo = cdBUS.readClientList();
		
		if (!cheDo) {
			CheDoMau mau = new CheDoMau();
			//background = mau.getMauPhuSang();
			background = mau.getMauPhuSang();
			bg_item = mau.getMauChinhSang();
			bg_Chart = new Color (230, 230, 230);

		}

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0 };
		gridBagLayout.rowHeights = new int[] { 0 };
		gridBagLayout.columnWeights = new double[] { 1.0 };
		gridBagLayout.rowWeights = new double[] { 1.0 };
		setLayout(gridBagLayout);

		panel_3 = new JPanel();
		panel_3.setBackground(background);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		add(panel_3, gbc_panel_3);

		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 0 };
		gbl_panel_3.rowHeights = new int[] { 0, 0 };
		gbl_panel_3.columnWeights = new double[] { 1.0 };
		gbl_panel_3.rowWeights = new double[] { 0.7, 0.3 };
		panel_3.setLayout(gbl_panel_3);

		veThongKeDoanhThu();
		addController();
		addEvent();
		hienThiDS(tkBUS.dsTK());
	}

	private void veThongKeDoanhThu() {
		JPanel panel_8 = new JPanel();
		panel_8.setOpaque(false);
		GridBagConstraints gbc_panel_8 = new GridBagConstraints();
		gbc_panel_8.insets = new Insets(0, 0, 5, 0);
		gbc_panel_8.fill = GridBagConstraints.BOTH;
		gbc_panel_8.gridx = 0;
		gbc_panel_8.gridy = 0;
		panel_3.add(panel_8, gbc_panel_8);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[] { 0 };
		gbl_panel_6.rowHeights = new int[] { 0 };
		gbl_panel_6.columnWeights = new double[] { 1.0 };
		gbl_panel_6.rowWeights = new double[] { 1.0 };
		panel_8.setLayout(gbl_panel_6);

		JFreeChart lineChart = ChartFactory.createLineChart("Thống kê doanh thu", "Năm", "Số tiền ( VND )",
				createDataset(), PlotOrientation.VERTICAL, true, true, false);
		lineChart.getPlot().setBackgroundPaint(bg_Chart);
		ChartPanel chartPanel = new ChartPanel(lineChart);
		chartPanel.setBorder(new CompoundBorder(new LineBorder(new Color(196, 223, 215), 2),
				new LineBorder(new Color(170, 170, 170), 1)));

		CategoryPlot plot = lineChart.getCategoryPlot();

		LineAndShapeRenderer renderer = new LineAndShapeRenderer();
		renderer.setSeriesPaint(0, Color.RED);
		renderer.setSeriesPaint(1, Color.ORANGE);
		renderer.setSeriesPaint(2, Color.BLUE);

		renderer.setSeriesStroke(0, new BasicStroke(2.0f));
		renderer.setSeriesStroke(1, new BasicStroke(2.0f));
		renderer.setSeriesStroke(2, new BasicStroke(2.0f));
		plot.setRenderer(renderer);

		GridBagConstraints gbc_panel_chart = new GridBagConstraints();
		gbc_panel_chart.insets = new Insets(10, 10, 10, 10);
		gbc_panel_chart.fill = GridBagConstraints.BOTH;
		gbc_panel_chart.gridx = 0;
		gbc_panel_chart.gridy = 0;
		panel_8.add(chartPanel, gbc_panel_chart);

		JPanel panel_9 = new JPanel();
		panel_9.setOpaque(false);
		GridBagConstraints gbc_panel_9 = new GridBagConstraints();
		gbc_panel_9.fill = GridBagConstraints.BOTH;
		gbc_panel_9.gridx = 0;
		gbc_panel_9.gridy = 1;
		panel_3.add(panel_9, gbc_panel_9);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[] { 0 };
		gbl_panel_9.rowHeights = new int[] { 0, 0 };
		gbl_panel_9.columnWeights = new double[] { 1.0 };
		gbl_panel_9.rowWeights = new double[] { 1.0, 0.2 };
		panel_9.setLayout(gbl_panel_9);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(4, 4, 5, 4);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel_9.add(scrollPane, gbc_scrollPane);

		table_1 = new JTable();
		table_1.setModel(model);
		scrollPane.setViewportView(table_1);

		table_1.setDefaultEditor(Object.class, null);
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		panel_9.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 0, 50, 0, 0, 100, 110, 0, };
		gbl_panel.rowHeights = new int[] { 27 };
		gbl_panel.columnWeights = new double[] { 0.0, 1.0, 0.2, 0.0, 1.0, 0.5, 0.0, 1.0 };
		gbl_panel.rowWeights = new double[] { 0.0 };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel_4 = new JLabel("Tháng: ");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 0;
		panel.add(lblNewLabel_4, gbc_lblNewLabel_4);

		txtthang = new TextFielAmination();
		txtthang.setBackground(bg_item);
		txtthang.setBorder(new EmptyBorder(4, 10, 4, 4));
		GridBagConstraints gbc_txtthang = new GridBagConstraints();
		gbc_txtthang.insets = new Insets(0, 0, 0, 5);
		gbc_txtthang.fill = GridBagConstraints.BOTH;
		gbc_txtthang.gridx = 1;
		gbc_txtthang.gridy = 0;
		panel.add(txtthang, gbc_txtthang);
		txtthang.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Năm: ");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 0;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);

		txtnam = new TextFielAmination();
		txtnam.setBackground(bg_item);
		txtnam.setBorder(new EmptyBorder(4, 10, 4, 4));
		GridBagConstraints gbc_txtnam = new GridBagConstraints();
		gbc_txtnam.insets = new Insets(0, 0, 0, 5);
		gbc_txtnam.fill = GridBagConstraints.BOTH;
		gbc_txtnam.gridx = 4;
		gbc_txtnam.gridy = 0;
		panel.add(txtnam, gbc_txtnam);
		txtnam.setColumns(10);

		btnNewButton = new ButtonAmination();
		btnNewButton.setText("Tổng doanh thu");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnNewButton, gbc_btnNewButton);

		txtTongDT = new JTextField();
		txtTongDT.setFont(new Font("Tahoma", Font.BOLD, 14));
		txtTongDT.setDisabledTextColor(Color.BLACK);
		txtTongDT.setEnabled(false);
		txtTongDT.setOpaque(false);
		GridBagConstraints gbc_txtTongDT = new GridBagConstraints();
		gbc_txtTongDT.fill = GridBagConstraints.BOTH;
		gbc_txtTongDT.insets = new Insets(0, 0, 0, 5);
		gbc_txtTongDT.gridx = 7;
		gbc_txtTongDT.gridy = 0;
		panel.add(txtTongDT, gbc_txtTongDT);
		txtTongDT.setColumns(10);

		txtnam.addKeyListener(new KeyListener() {

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
					btnNewButton.doClick();
				}
			}
		});

		txtthang.addKeyListener(new KeyListener() {

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
					btnNewButton.doClick();
				}
			}
		});

		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (txtthang.getText().equals("")) {
					int nam = 0;

					if (txtnam.getText().equals("")) {
						hienThiDS(tkBUS.dsTK());
					} else {
						try {
							nam = Integer.parseInt(txtnam.getText());
							flag = true;
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Năm không hợp lệ!", "Thông báo!",
									JOptionPane.ERROR_MESSAGE);
							flag = false;
						} catch (Exception sd) {
							JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Năm không hợp lệ!", "Thông báo!",
									JOptionPane.ERROR_MESSAGE);
							flag = false;
						}

						if (flag) {
							Date date1 = new Date();
							date1.setDate(1);
							date1.setMonth(1);
							date1.setYear(nam);

							Date date2 = new Date();
							date2.setDate(1);
							date2.setMonth(1);
							date2.setYear(nam + 1);

							ArrayList<DTO.ThongKe> dstk = new ArrayList<DTO.ThongKe>();
							dstk = tkBUS.dsTK(date1, date2);

							if (dstk != null) {
								hienThiDS(dstk);
							}
							
						}
						
					}
				} else if (txtnam.getText().equals("")) {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Bạn chưa nhập tháng, năm!", "Thông báo!",
							JOptionPane.ERROR_MESSAGE);
				} else {

					int thang = 0, nam = 0;

					try {
						thang = Integer.parseInt(txtthang.getText());
						flag = true;
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Tháng không hợp lệ!", "Thông báo!",
								JOptionPane.ERROR_MESSAGE);
						flag = false;
					} catch (Exception sd) {
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Tháng không hợp lệ!", "Thông báo!",
								JOptionPane.ERROR_MESSAGE);
						flag = false;
					}

					try {
						nam = Integer.parseInt(txtnam.getText());
						flag = true;
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Năm không hợp lệ!", "Thông báo!",
								JOptionPane.ERROR_MESSAGE);
						flag = false;
					} catch (Exception sd) {
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Năm không hợp lệ!", "Thông báo!",
								JOptionPane.ERROR_MESSAGE);
						flag = false;
					}

					if (flag) {
						Date date1 = new Date();
						date1.setDate(1);
						date1.setMonth(thang);
						date1.setYear(nam);

						Date date2 = new Date();
						date2.setDate(1);
						date2.setMonth(thang + 1);
						date2.setYear(nam);

						ArrayList<DTO.ThongKe> dstk = new ArrayList<DTO.ThongKe>();
						dstk = tkBUS.dsTK(date1, date2);

						if (dstk != null) {
							hienThiDS(dstk);
						}
					}
				}

			}
		});
		
	}

	private void addEvent() {

	}

	public void hienThiDS(ArrayList<DTO.ThongKe> dstk) {
		model.setRowCount(0);
		int x = 0;
		try {
			x = dstk.size();
		} catch (Exception ex) {
			x = 0;
		}
		long tongDT = 0;
		for (int i = 0; i < x; i++) {

			row[0] = i + 1;
			row[1] = dstk.get(i).getTenKH();
			int ma = dstk.get(i).getMadvTour();

			if (ma >= 40000) {
				row[2] = tkBUS.tenDVSP(ma);
			} else {
				row[2] = tkBUS.tenDV(ma);
			}

			row[3] = dstk.get(i).getThoiGian();
			row[4] = dstk.get(i).getDoanhThu();
			model.addRow(row);
			tongDT += dstk.get(i).getDoanhThu();
		}
		txtTongDT.setText(String.valueOf(tongDT));

	}

	private DefaultCategoryDataset createDataset() {

		Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH) + 1;

		Date date1 = new Date();
		date1.setDate(1);
		date1.setMonth(month - 3);
		date1.setYear(year);

		Date date2 = new Date();
		date2.setDate(1);
		date2.setMonth(month - 2);
		date2.setYear(year);
		// --------------------
		Date date11 = new Date();
		date11.setDate(1);
		date11.setMonth(month - 3);
		date11.setYear(year - 1);

		Date date12 = new Date();
		date12.setDate(1);
		date12.setMonth(month - 2);
		date12.setYear(year - 1);
		// ====================
		Date date111 = new Date();
		date111.setDate(1);
		date111.setMonth(month - 3);
		date111.setYear(year - 2);

		Date date112 = new Date();
		date112.setDate(1);
		date112.setMonth(month - 2);
		date112.setYear(year - 2);

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		dataset.addValue(tkBUS.tkThang(date1, date2), String.valueOf(year), "Tháng " + String.valueOf(month - 3));

		date1.setMonth(month - 2);
		date2.setMonth(month - 1);
		dataset.addValue(tkBUS.tkThang(date1, date2), String.valueOf(year), "Tháng " + String.valueOf(month - 2));

		date1.setMonth(month - 1);
		date2.setMonth(month);
		dataset.addValue(tkBUS.tkThang(date1, date2), String.valueOf(year), "Tháng " + String.valueOf(month - 1));

		date1.setMonth(month);
		date2.setMonth(month + 1);
		dataset.addValue(tkBUS.tkThang(date1, date2), String.valueOf(year), "Tháng " + String.valueOf(month));

		// ----------------------
		dataset.addValue(tkBUS.tkThang(date11, date12), String.valueOf(year - 1), "Tháng " + String.valueOf(month - 3));

		date11.setMonth(month - 2);
		date12.setMonth(month - 1);
		dataset.addValue(tkBUS.tkThang(date11, date12), String.valueOf(year - 1), "Tháng " + String.valueOf(month - 2));

		date11.setMonth(month - 1);
		date12.setMonth(month);
		dataset.addValue(tkBUS.tkThang(date11, date12), String.valueOf(year - 1), "Tháng " + String.valueOf(month - 1));

		date11.setMonth(month);
		date12.setMonth(month + 1);
		dataset.addValue(tkBUS.tkThang(date11, date12), String.valueOf(year - 1), "Tháng " + String.valueOf(month));
		// ---------------------
		dataset.addValue(tkBUS.tkThang(date111, date112), String.valueOf(year - 2),
				"Tháng " + String.valueOf(month - 3));

		date111.setMonth(month - 2);
		date112.setMonth(month - 1);
		dataset.addValue(tkBUS.tkThang(date111, date112), String.valueOf(year - 2),
				"Tháng " + String.valueOf(month - 2));

		date111.setMonth(month - 1);
		date112.setMonth(month);
		dataset.addValue(tkBUS.tkThang(date111, date112), String.valueOf(year - 2),
				"Tháng " + String.valueOf(month - 1));

		date111.setMonth(month);
		date112.setMonth(month + 1);
		dataset.addValue(tkBUS.tkThang(date111, date112), String.valueOf(year - 2), "Tháng " + String.valueOf(month));

		return dataset;

	}

	private void addController() {
		model.setColumnIdentifiers(column);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 5; i++)
			table_1.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	}

}
