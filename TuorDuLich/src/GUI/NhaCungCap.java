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

import BUS.NhaHang_Bus;
import BUS.PhanQuyen_BUS;
import DTO.PhanQuyen;
import BUS.CheDo_BUS;
import BUS.NguoiDung_BUS;
import BUS.NhaCungCap_BUS;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class NhaCungCap extends JPanel{
	private JLabel lblContent;
	private JButton btnNewButtonThem,btnNewButton_Sua,btnNewButton_TimKiem;
	private JPanel panel_33;
	private TextFielAmination diachi, tenNCC, SDT, maNCC;
    private JComboBox trangthai;
    private DefaultTableModel model;
    private JTable table;
    private Object[] row = new Object[5];
    private ArrayList<DTO.NhaCungCap> nccList=new ArrayList<>();
    private static int rowSelected=0;
    private NhaCungCap_BUS nhacungcapBus=new NhaCungCap_BUS();
	
	private Color bg_menu_item = new Color(111, 211, 178);
	
	private NguoiDung_BUS ndBUS = new NguoiDung_BUS();
	private PhanQuyen_BUS phanQuyenBUS = new PhanQuyen_BUS();

	private boolean cheDo = true;

	private boolean laAdmin = false;

	private Color txtColor = Color.white;

	private boolean duocThem = true;
	private boolean duocSua = true;

	public NhaCungCap(int maNVDN) {
		
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
		
	    lblContent = new JLabel("Chào mừng bạn đến với giao diện quản lý nhà cung cấp!");
		lblContent.setBounds(21, 0, 633, 33);
		lblContent.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 27));
		panel_33.add(lblContent);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(bg_menu_item);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 15);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 100, 0, 0, 0, 100};
		gbl_panel_1.rowHeights = new int[]{0, 20, 0, 20};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.3, 1.0, 0.5, 0.0, 0.3, 1.0};
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel = new JLabel("Tên nhà cung cấp : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(5, 10, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel_1.add(lblNewLabel, gbc_lblNewLabel);
		
		tenNCC = new TextFielAmination();
		tenNCC.setRadius(10);
		tenNCC.setMinimumSize(new Dimension(70, 25));
		tenNCC.setBackground(txtColor);
		tenNCC.setBorder(new EmptyBorder(2, 5, 2, 5));

		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 0;
		panel_1.add(tenNCC, gbc_textField);
		tenNCC.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 0;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		SDT = new TextFielAmination();
		SDT.setRadius(10);

		SDT.setBackground(txtColor);
		SDT.setMinimumSize(new Dimension(70, 25));
		SDT.setBorder(new EmptyBorder(2, 5, 2, 5));

		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.BOTH;
		gbc_textField_1.gridx = 6;
		gbc_textField_1.gridy = 0;
		panel_1.add(SDT, gbc_textField_1);
		SDT.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhà cung cấp : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(5, 10, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 2;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		maNCC = new TextFielAmination();
		maNCC.setRadius(10);

		maNCC.setBackground(txtColor);
		//disableJTextField(maNCC);
		maNCC.setMinimumSize(new Dimension(70, 25));
		maNCC.setBorder(new EmptyBorder(2, 5, 2, 5));

		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.BOTH;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 2;
		panel_1.add(maNCC, gbc_textField_3);
		maNCC.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Địa chỉ : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 4;
		gbc_lblNewLabel_4.gridy = 2;
		panel_1.add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		diachi = new TextFielAmination();
		diachi.setRadius(10);

		diachi.setBackground(txtColor);
		diachi.setMinimumSize(new Dimension(70, 25));
		diachi.setBorder(new EmptyBorder(2, 5, 2, 5));

		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.BOTH;
		gbc_textField_2.gridx = 6;
		gbc_textField_2.gridy = 2;
		panel_1.add(diachi, gbc_textField_2);
		diachi.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(bg_menu_item);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.insets = new Insets(0, 10, 0, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 2;
		add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{106, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{0.15, 0.26, 0.1, 0.26, 0.08, 0.05, 0.06, 0.58};
		gbl_panel_2.rowWeights = new double[] {0.1, 0.7};
		panel_2.setLayout(gbl_panel_2);
		
		btnNewButtonThem = new BtnThem();
		btnNewButtonThem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				xuLiSuKienThem();
				tenNCC.setText("");
				diachi.setText("");
				SDT.setText("");
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
				tenNCC.setText("");
				diachi.setText("");
				SDT.setText("");
			}
		});
		GridBagConstraints gbc_btnNewButton_Sua = new GridBagConstraints();
		gbc_btnNewButton_Sua.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_Sua.insets = new Insets(0, 0, 5, 15);
		gbc_btnNewButton_Sua.gridx = 2;
		gbc_btnNewButton_Sua.gridy = 0;
		panel_2.add(btnNewButton_Sua, gbc_btnNewButton_Sua);
		
		btnNewButton_TimKiem = new BtnTimKiem();
		btnNewButton_TimKiem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				timKiem();
				tenNCC.setText("");
				diachi.setText("");
			}
		});
		GridBagConstraints gbc_btnNewButton_TimKiem = new GridBagConstraints();
		gbc_btnNewButton_TimKiem.insets = new Insets(0, 0, 5, 20);
		gbc_btnNewButton_TimKiem.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton_TimKiem.gridx = 4;
		gbc_btnNewButton_TimKiem.gridy = 0;
		panel_2.add(btnNewButton_TimKiem, gbc_btnNewButton_TimKiem);
		
		JLabel lblNewLabel_2 = new JLabel("Trạng thái :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_2.insets = new Insets(0, 20, 5, 5);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 5;
		gbc_lblNewLabel_2.gridy = 0;
		panel_2.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		String[] combo= {"Hoạt động","Không hoạt động"};
		trangthai = new JComboBox(combo);
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.VERTICAL;
		gbc_comboBox.anchor = GridBagConstraints.WEST;
		gbc_comboBox.insets = new Insets(0, 20, 5, 0);
		gbc_comboBox.gridx = 7;
		gbc_comboBox.gridy = 0;
		panel_2.add(trangthai, gbc_comboBox);
		
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
		table.setBackground(Color.white);
		model=new DefaultTableModel();
		Object[] colum= {"Mã nhà cung cấp","Tên nhà cung cấp","Số điện thoại","Trạng thái","Địa chỉ"};
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
	    
	    for (int i = 0; i < 5; i++)
			table.getColumnModel().getColumn(i).setCellRenderer( centerRenderer );
	    
	    hienThiDS(nccList);
	    
	    if (!laAdmin) {
			PhanQuyen phanQuyen = new PhanQuyen();
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Thêm nhà cung cấp");
			if (phanQuyen == null) {
				btnNewButtonThem.setEnabled(false);
			}
			
			phanQuyen = phanQuyenBUS.timKiem(maNVDN, "Sửa nhà cung cấp");
			if (phanQuyen == null) {
				btnNewButton_Sua.setEnabled(false);
			}
		}
	    
	    t.start();
	}
	
	private void tableMouseClickes(MouseEvent evt) {
		int i=table.getSelectedRow();
		if(i>=0) {
			maNCC.setText(model.getValueAt(i, 0).toString());
			tenNCC.setText(model.getValueAt(i, 1).toString());
			SDT.setText(model.getValueAt(i, 2).toString());
			if(model.getValueAt(i, 3).toString().equals("Hoạt động"))
				trangthai.setSelectedIndex(0);
			else
				trangthai.setSelectedIndex(1);
			diachi.setText(model.getValueAt(i, 4).toString());
		}
	}
	
	private void trongForm() {
			maNCC.setText("");
			tenNCC.setText("");
			SDT.setText("");
			trangthai.setSelectedIndex(0);
			diachi.setText("");
	}
	
	private void xuLiSuKienThem() {
		DTO.NhaCungCap ncc = new DTO.NhaCungCap();
		ncc.setTenNCC(tenNCC.getText());
		long s=0;
		try {
			s=Long.parseLong(SDT.getText());
		}catch(NumberFormatException rf) {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		ncc.setSoDT(s);
		ncc.setTrangthai(trangthai.getItemAt(trangthai.getSelectedIndex()).toString());
		ncc.setDiachi(diachi.getText());
		nccList.add(ncc);
		if(nhacungcapBus.themNCC(ncc)) {
			model.addRow(new Object[] {ncc.getMaNCC(),ncc.getTenNCC(),ncc.getSoDT(),ncc.getTrangthai(),ncc.getDiachi()});
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Thêm thành công!",
	                "Thông báo!!!",
	                JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Thêm thất bại!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
		}
	}
	private void xuLiSuKienSua() {
		
			DTO.NhaCungCap ncc = new DTO.NhaCungCap();
			try {
				ncc.setMaNCC(Integer.parseInt(model.getValueAt(rowSelected, 0).toString()));
			} catch (Exception ex) {
				ncc.setMaNCC(0);
			}
			ncc.setTenNCC(tenNCC.getText());
			long s=0;
			try {
				s=Long.parseLong(SDT.getText());
			}catch(NumberFormatException rf) {
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			ncc.setSoDT(s);
			ncc.setTrangthai(trangthai.getItemAt(trangthai.getSelectedIndex()).toString());
			ncc.setDiachi(diachi.getText());
			int i=table.getSelectedRow();
			if(i>=0) {
				if(nhacungcapBus.suaNCC(ncc)) {
					model.setValueAt(maNCC.getText(),i,0);
					model.setValueAt(tenNCC.getText(),i,1);
					model.setValueAt(SDT.getText(),i,2);
					model.setValueAt(trangthai.getItemAt(trangthai.getSelectedIndex()).toString(),i,3);
					model.setValueAt(diachi.getText(),i,4);;
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Sửa thành công!",
			                "Thông báo!!!",
			                JOptionPane.INFORMATION_MESSAGE);
				} else {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Sửa thất bại!",
			                "Thông báo!!!",
			                JOptionPane.WARNING_MESSAGE);
				}	
			}
			trongForm();
		}
	
	private void hienThiDS(ArrayList<DTO.NhaCungCap> nccList) {
		nccList.clear();
		nhacungcapBus.docDsNCC();;
		nccList=nhacungcapBus.getNCCList();
		model.setRowCount(0);
		
		int x = 0;
		try {
			x=nccList.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row[0]= nccList.get(i).getMaNCC();
			row[1] = nccList.get(i).getTenNCC();//nccList.get(i).getTenNCC();
			row[2] = nccList.get(i).getSoDT();
			row[3] = nccList.get(i).getTrangthai();
			row[4] = nccList.get(i).getDiachi();
			model.addRow(row);
		}
	}
		
	private void hienThiDStimkiem(ArrayList<DTO.NhaCungCap> nccList) {
		model.setRowCount(0);
		
		int x = 0;
		try {
			x=nccList.size();
		} catch (Exception ex) {
			x = 0;
		}
		
		for (int i = 0; i < x; i++) {
			row[0]= nccList.get(i).getMaNCC();
			row[1] = nccList.get(i).getTenNCC();//nccList.get(i).getTenNCC();
			row[2] = nccList.get(i).getSoDT();
			row[3] = nccList.get(i).getTrangthai();
			row[4] = nccList.get(i).getDiachi();
			model.addRow(row);
		}
	}
		
	private void timKiem() {
		model.setRowCount(0);
		if (maNCC.getText().trim().equals("") && tenNCC.getText().trim().equals("")) {
			hienThiDS(nccList);
		}else if (!maNCC.getText().trim().equals("") && tenNCC.getText().trim().equals("")) {
			DTO.NhaCungCap ncc = new DTO.NhaCungCap();
			ArrayList<DTO.NhaCungCap> nccList= new ArrayList<>();
			ncc = nhacungcapBus.timKiemMa(maNCC.getText());
			if (ncc != null) {
				nccList.add(ncc);
				hienThiDStimkiem(nccList);
			}
		} else  if (!tenNCC.getText().trim().equals("") && maNCC.getText().trim().equals("")) {
			ArrayList<DTO.NhaCungCap> nccList= new ArrayList<>();
			nccList = nhacungcapBus.timKiemTen(tenNCC.getText());
			if (nccList != null) {
				hienThiDStimkiem(nccList);
			}
		} else {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Chỉ nhập tối đa 1 ô (Mã nhà cung cấp hoặc Tên nhà cung cấp) để tìm kiếm!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
		}
		
		trongForm();
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