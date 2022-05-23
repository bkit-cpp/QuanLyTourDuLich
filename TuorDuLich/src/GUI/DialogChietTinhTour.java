package GUI;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.ChietTinhTour_BUS;
import DAO.ChietTinhTour_DAO;
import DTO.ChietTinhTour;

import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JTextPane;
import javax.swing.JEditorPane;
import javax.swing.JTextArea;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

public class DialogChietTinhTour extends JDialog {

	private TextFielAmination giaLT, giaNH, giaKS;
	private JTextField maNV, maTour;
	private Color background = new Color(111, 211, 178);
	
	
	private int maDVTourChietTinh = 0;
	private TextFielAmination txtGhiChu;
	private DefaultComboBoxModel modelLT;
	private DefaultComboBoxModel modelNH;
	private DefaultComboBoxModel modelKS;
	private DAO.ChietTinhTour_DAO ctDAO = new ChietTinhTour_DAO();
	private ChietTinhTour_BUS ctBUS = new ChietTinhTour_BUS();
	private int maNVChietTinh = 0;
	private ButtonAmination btnDongY;
	
	
	public ButtonAmination getBtnDongY() {
		return btnDongY;
	}

	public void setBtnDongY(ButtonAmination btnDongY) {
		this.btnDongY = btnDongY;
	}

	public int getmaNVChietTinh() {
		return maDVTourChietTinh;
	}

	public void setmaNVChietTinh(int maNVChietTinh) {
		this.maNVChietTinh = maNVChietTinh;
	}

	public int getMaDVTourChietTinh() {
		return maDVTourChietTinh;
	}

	public void setMaDVTourChietTinh(int maDVTourChietTinh) {
		this.maDVTourChietTinh = maDVTourChietTinh;
	}


	public DialogChietTinhTour(Frame owner, String title, int ma, int maNVCT) {
        super(owner, title, true);
        
        maDVTourChietTinh = ma;
        maNVChietTinh = maNVCT;
        
        getContentPane().setBackground(background);
        getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int screenHeight = screenSize.height * 4 / 5;
		int screenWidth = screenSize.width * 5 / 7;
		
        
        setResizable(false);
		setSize(screenWidth * 6 /10, screenHeight * 6 / 10);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{20, 0, 10, 0, 0, 200};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 1.0};
		gridBagLayout.rowWeights = new double[]{0.6, 0.3, 0.05, 0.05, 0.05, 0.05, 0.2, 0.2};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Mã nhân viên : ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 0;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		maNV = new JTextField(String.valueOf(maNVCT));
		maNV.setDisabledTextColor(Color.black);
		maNV.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		maNV.setEnabled(false);
		maNV.setOpaque(false);
		maNV.setBorder(null);
		GridBagConstraints gbc_maNV = new GridBagConstraints();
		gbc_maNV.anchor = GridBagConstraints.SOUTH;
		gbc_maNV.insets = new Insets(0, 0, 5, 5);
		gbc_maNV.fill = GridBagConstraints.HORIZONTAL;
		gbc_maNV.gridx = 2;
		gbc_maNV.gridy = 0;
		getContentPane().add(maNV, gbc_maNV);
		maNV.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Mã dịch vụ tour : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTHEAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 4;
		gbc_lblNewLabel.gridy = 0;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		maTour = new JTextField();
		maTour.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		maTour.setText(String.valueOf(maDVTourChietTinh));
		maTour.setEditable(false);
		maTour.setOpaque(false);
		maTour.setBorder(null);
		GridBagConstraints gbc_maTour = new GridBagConstraints();
		gbc_maTour.anchor = GridBagConstraints.SOUTH;
		gbc_maTour.insets = new Insets(0, 0, 5, 10);
		gbc_maTour.fill = GridBagConstraints.HORIZONTAL;
		gbc_maTour.gridx = 5;
		gbc_maTour.gridy = 0;
		getContentPane().add(maTour, gbc_maTour);
		maTour.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Lộ trình : ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 10);
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 2;
		getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		ArrayList<DTO.LoTrinh> dsLT = new ArrayList<DTO.LoTrinh>();
		
		dsLT = ctDAO.getdsLoTrinh(maDVTourChietTinh);
		
		String[] lt = new String[dsLT.size()+1];
		
		lt[0] ="Chọn lộ trình";
		
		int i = 1;
		for (DTO.LoTrinh x : dsLT) {
			lt[i] = x.getdiemden() +" - "+ x.getdiemdon();
			i++;
		}
		
		modelLT = new DefaultComboBoxModel(lt);
		JComboBox loTrinh = new JComboBox();
		loTrinh.setModel(modelLT);
		GridBagConstraints gbc_loTrinh = new GridBagConstraints();
		gbc_loTrinh.insets = new Insets(0, 0, 5, 5);
		gbc_loTrinh.fill = GridBagConstraints.HORIZONTAL;
		gbc_loTrinh.gridx = 2;
		gbc_loTrinh.gridy = 2;
		getContentPane().add(loTrinh, gbc_loTrinh);
		
		JLabel lblNewLabel_3 = new JLabel("Giá : ");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 2;
		getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		giaLT = new TextFielAmination();
		giaLT.setBackground(Color.white);
		giaLT.setBorder(new EmptyBorder(4, 10, 4, 10));
		GridBagConstraints gbc_giaLT = new GridBagConstraints();
		gbc_giaLT.insets = new Insets(5, 0, 5, 10);
		gbc_giaLT.fill = GridBagConstraints.BOTH;
		gbc_giaLT.gridx = 5;
		gbc_giaLT.gridy = 2;
		getContentPane().add(giaLT, gbc_giaLT);
		giaLT.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Nhà hàng : ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 10);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 3;
		getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		ArrayList<DTO.NhaHang> dsNH = new ArrayList<DTO.NhaHang>();
		
		dsNH = ctDAO.getDanhSachNH();
		
		String[] nh = new String[dsNH.size()+1];
		nh[0] = "Chọn nhà hàng";
		int j = 1;
		for (DTO.NhaHang x : dsNH) {
			nh[j] = x.getMaNH()+" - "+ x.getTenNH();
			j++;
		}
		
		modelNH = new DefaultComboBoxModel(nh);
		
		JComboBox nhaHang = new JComboBox();
		nhaHang.setModel(modelNH);
		GridBagConstraints gbc_nhaHang = new GridBagConstraints();
		gbc_nhaHang.insets = new Insets(0, 0, 5, 5);
		gbc_nhaHang.fill = GridBagConstraints.HORIZONTAL;
		gbc_nhaHang.gridx = 2;
		gbc_nhaHang.gridy = 3;
		getContentPane().add(nhaHang, gbc_nhaHang);
		
		JLabel lblNewLabel_5 = new JLabel("Giá : ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 3;
		getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		giaNH = new TextFielAmination();

		giaNH.setBackground(Color.white);
		giaNH.setBorder(new EmptyBorder(4, 10, 4, 10));
		GridBagConstraints gbc_giaNH = new GridBagConstraints();
		gbc_giaNH.insets = new Insets(5, 0, 5, 10);
		gbc_giaNH.fill = GridBagConstraints.BOTH;
		gbc_giaNH.gridx = 5;
		gbc_giaNH.gridy = 3;
		getContentPane().add(giaNH, gbc_giaNH);
		giaNH.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Khách sạn : ");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 10);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 4;
		getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		
		ArrayList<DTO.KhachSan> dsKS = new ArrayList<DTO.KhachSan>();
		
		dsKS = ctDAO.getDanhSachKS();
		
		String[] ks = new String[dsKS.size()+1];
		ks[0] = "Chọn khách sạn";
		int k = 1;
		for (DTO.KhachSan x : dsKS) {
			ks[k] = x.getMaKS()+" - "+x.getTenKS();
			k++;
		}
		
		modelKS = new DefaultComboBoxModel(ks);
		JComboBox khachSan = new JComboBox();
		khachSan.setModel(modelKS);
		
		GridBagConstraints gbc_khachSan = new GridBagConstraints();
		gbc_khachSan.insets = new Insets(0, 0, 5, 5);
		gbc_khachSan.fill = GridBagConstraints.HORIZONTAL;
		gbc_khachSan.gridx = 2;
		gbc_khachSan.gridy = 4;
		getContentPane().add(khachSan, gbc_khachSan);
		
		JLabel lblNewLabel_7 = new JLabel("Giá : ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 4;
		gbc_lblNewLabel_7.gridy = 4;
		getContentPane().add(lblNewLabel_7, gbc_lblNewLabel_7);
		
		giaKS = new TextFielAmination();
		giaKS.setBackground(Color.white);
		giaKS.setBorder(new EmptyBorder(4, 10, 4, 10));
		GridBagConstraints gbc_giaKS = new GridBagConstraints();
		gbc_giaKS.insets = new Insets(5, 0, 5, 10);
		gbc_giaKS.fill = GridBagConstraints.BOTH;
		gbc_giaKS.gridx = 5;
		gbc_giaKS.gridy = 4;
		getContentPane().add(giaKS, gbc_giaKS);
		giaKS.setColumns(10);
		
		JLabel lblNewLabel_6_1 = new JLabel("Ghi chú : ");
		lblNewLabel_6_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_lblNewLabel_6_1 = new GridBagConstraints();
		gbc_lblNewLabel_6_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6_1.gridx = 1;
		gbc_lblNewLabel_6_1.gridy = 5;
		getContentPane().add(lblNewLabel_6_1, gbc_lblNewLabel_6_1);
		
		txtGhiChu = new TextFielAmination();
		txtGhiChu.setBackground(Color.white);
		txtGhiChu.setBorder(new EmptyBorder(4, 10, 4, 10));
		GridBagConstraints gbc_txtGhiChu = new GridBagConstraints();
		gbc_txtGhiChu.insets = new Insets(0, 0, 5, 5);
		gbc_txtGhiChu.fill = GridBagConstraints.BOTH;
		gbc_txtGhiChu.gridx = 2;
		gbc_txtGhiChu.gridy = 5;
		getContentPane().add(txtGhiChu, gbc_txtGhiChu);
		txtGhiChu.setColumns(10);
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 10);
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 6;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		
		ButtonAmination btnThoi = new ButtonAmination();
		btnThoi.setBorderColor(new Color(50, 52, 9));
		btnThoi.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThoi.setColorOver(new Color(154, 157, 0));
		btnThoi.setText("Thôi");
		GridBagConstraints gbc_btnThoi = new GridBagConstraints();
		gbc_btnThoi.fill = GridBagConstraints.BOTH;
		gbc_btnThoi.insets = new Insets(10, 0, 0, 5);
		gbc_btnThoi.gridx = 0;
		gbc_btnThoi.gridy = 0;
		panel.add(btnThoi, gbc_btnThoi);
		
		btnDongY = new ButtonAmination();
		btnDongY.setText("Đồng ý");
		btnDongY.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_btnDongY = new GridBagConstraints();
		gbc_btnDongY.fill = GridBagConstraints.BOTH;
		gbc_btnDongY.insets = new Insets(10, 0, 0, 5);
		gbc_btnDongY.gridx = 1;
		gbc_btnDongY.gridy = 0;
		panel.add(btnDongY, gbc_btnDongY);
		
		nhaHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int nh;
				DTO.NhaHang nhDTO = new DTO.NhaHang();
				String[] nhaH = nhaHang.getItemAt(nhaHang.getSelectedIndex()).toString().split(" - ");
				try {
					nh = Integer.parseInt(nhaH[0]);
				} catch(Exception nhad) {
					nh = 0;
					
				}
				
				nhDTO = ctDAO.timKiem(nh);
				giaNH.setText(String.valueOf(nhDTO.getGia()));
			}
		});
		
		loTrinh.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				giaLT.setText(String.valueOf(ctDAO.getGiaLT(maDVTourChietTinh)));
			}
		});
		
		
		khachSan.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int ks;
				DTO.KhachSan ksDTO = new DTO.KhachSan();
				String[] nhaK = khachSan.getItemAt(khachSan.getSelectedIndex()).toString().split(" - ");
				try {
					ks = Integer.parseInt(nhaK[0]);
				} catch(Exception nhad) {
					ks = 0;
					
				}
				
				ksDTO = ctDAO.timKiemKS(ks);
				giaKS.setText(String.valueOf(ksDTO.getGia()));
			}
		});
		
		
		btnDongY.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				if (!loTrinh.getItemAt(loTrinh.getSelectedIndex()).toString().equals("Chọn lộ trình")) {
					
					ChietTinhTour a = new ChietTinhTour();
					a.setGhiChu(txtGhiChu.getText());
					long nh, ks, lt;
					try {
						nh = Long.parseLong(giaNH.getText());
					} catch(Exception nhad) {
						nh = 0;
						
					}
					
					try {
						ks = Long.parseLong(giaKS.getText());
					} catch(Exception nhad) {
						ks = 0;
						
					}
					
					try {
						lt = Long.parseLong(giaLT.getText());
					} catch(Exception nhad) {
						lt = -1;
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
				                "Bạn chưa nhập giá lộ trình dịch vụ!",
				                "Thông báo!!!",
				                JOptionPane.WARNING_MESSAGE);
					}
					
					a.setGiaNH(nh);
					a.setGiaKS(ks);
					a.setGiaDV(lt);
					a.setMaDVTour(maDVTourChietTinh);
					a.setMaNV(maNVChietTinh);
					int maNH, maKS;
					if (!khachSan.getItemAt(khachSan.getSelectedIndex()).toString().equals("")) {
						String[] nhaK = khachSan.getItemAt(khachSan.getSelectedIndex()).toString().split(" - ");
						try {
							maKS = Integer.parseInt(nhaK[0]);
						} catch(Exception nhad) {
							maKS = -1;
							
						}
					} else {
						maKS = -1;
					}
					
					if (!nhaHang.getItemAt(nhaHang.getSelectedIndex()).toString().equals("")) {
						String[] nhaK = nhaHang.getItemAt(nhaHang.getSelectedIndex()).toString().split(" - ");
						try {
							maNH = Integer.parseInt(nhaK[0]);
						} catch(Exception nhad) {
							maNH = -1;
							
						}
					} else {
						maNH = -1;
					}
					a.setMaNH(maNH);
					a.setMaKS(maKS);
					a.setMaLT(maDVTourChietTinh);
					if (lt != -1 && !loTrinh.getItemAt(loTrinh.getSelectedIndex()).toString().equals("Chọn lộ trình")) {
						if (ctBUS.themCT(a)) {
							if (maDVTourChietTinh >= 40000) {
								ctBUS.updateTourSP(maDVTourChietTinh);
							} else {
								ctBUS.updateTourMoBan(maDVTourChietTinh);
							}
							
							JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
					                "Chiết tính thành công!",
					                "Thông báo!!!",
					                JOptionPane.INFORMATION_MESSAGE);
							DialogChietTinhTour.this.setVisible(false);
							DialogChietTinhTour.this.dispose();
						} else {
							JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
					                "Chiết tính thất bại!",
					                "Thông báo!!!",
					                JOptionPane.WARNING_MESSAGE);
						}
					}
				}else {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Bạn chưa chọn lộ trình để chiết tính!",
			                "Thông báo!!!",
			                JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnThoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DialogChietTinhTour.this.setVisible(false);
				DialogChietTinhTour.this.dispose();

			}
		});
	}

}
