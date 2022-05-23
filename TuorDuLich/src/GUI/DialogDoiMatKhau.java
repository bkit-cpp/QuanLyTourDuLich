package GUI;


import javax.swing.JDialog;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.CheDo_BUS;
import BUS.NguoiDung_BUS;
import DTO.NguoiDung;

public class DialogDoiMatKhau extends JDialog {
	
	private PassWordFielAmination mkHienTai, mkNhapLai, mkMoi;
	private Color background = new Color(111, 211, 178);
	private int maNV = -1;
	private NguoiDung_BUS ndBUS = new NguoiDung_BUS();
	private String matKhauND;
	private boolean cheDo = true;
	private Color txtColor = Color.white;

	public String getMatKhauND() {
		return matKhauND;
	}

	public void setMatKhauND(String matKhauND) {
		this.matKhauND = matKhauND;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public DialogDoiMatKhau(Frame owner, String title, int maNVDN) {
        super(owner, title, true);
        setResizable(false);
        
        CheDo_BUS cdBUS = new CheDo_BUS();
		cheDo = cdBUS.readClientList();
		if (!cheDo) {
			CheDoMau mau = new CheDoMau();
			background = mau.getMauPhuSang();
			txtColor = new Color(230, 230, 230);

		}
        
        maNV = maNVDN;
        
        matKhauND = ndBUS.matKhau(maNVDN);
        
        getContentPane().setBackground(background);
		setSize(450, 250);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 0, 0, 0, 10};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 35};
		gridBagLayout.columnWeights = new double[]{0.2, 0.6, 1.0, 1.0, 0.2};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel = new JLabel("Mật khẩu hiện tại : ");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		mkHienTai = new PassWordFielAmination();
		mkHienTai.setBackground(txtColor);
		mkHienTai.setBorder(new EmptyBorder(4, 10, 4, 10));
		GridBagConstraints gbc_mkHienTai = new GridBagConstraints();
		gbc_mkHienTai.fill = GridBagConstraints.HORIZONTAL;
		gbc_mkHienTai.insets = new Insets(0, 0, 5, 0);
		gbc_mkHienTai.gridx = 3;
		gbc_mkHienTai.gridy = 1;
		getContentPane().add(mkHienTai, gbc_mkHienTai);
		mkHienTai.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu mới : ");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 3;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		mkMoi = new PassWordFielAmination();
		mkMoi.setBackground(txtColor);
		mkMoi.setBorder(new EmptyBorder(4, 10, 4, 10));
		GridBagConstraints gbc_mkMoi = new GridBagConstraints();
		gbc_mkMoi.fill = GridBagConstraints.HORIZONTAL;
		gbc_mkMoi.insets = new Insets(0, 0, 5, 0);
		gbc_mkMoi.gridx = 3;
		gbc_mkMoi.gridy = 3;
		getContentPane().add(mkMoi, gbc_mkMoi);
		mkMoi.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập lại mật khẩu mới : ");
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1_1.gridx = 1;
		gbc_lblNewLabel_1_1.gridy = 5;
		getContentPane().add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		mkNhapLai = new PassWordFielAmination();
		mkNhapLai.setColumns(10);
		mkNhapLai.setBackground(txtColor);
		mkNhapLai.setBorder(new EmptyBorder(4, 10, 4, 10));
		GridBagConstraints gbc_mkNhapLai = new GridBagConstraints();
		gbc_mkNhapLai.insets = new Insets(0, 0, 5, 0);
		gbc_mkNhapLai.fill = GridBagConstraints.HORIZONTAL;
		gbc_mkNhapLai.gridx = 3;
		gbc_mkNhapLai.gridy = 5;
		getContentPane().add(mkNhapLai, gbc_mkNhapLai);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(10, 0, 10, 10);
		gbc_panel.gridwidth = 3;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 6;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		
		ButtonAmination btnThoi = new ButtonAmination();
		btnThoi.setBorderColor(new Color(50, 52, 9));
		btnThoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThoi.setColorOver(new Color(154, 157, 0));
		btnThoi.setText("Thôi");
		GridBagConstraints gbc_btnThoi = new GridBagConstraints();
		gbc_btnThoi.fill = GridBagConstraints.BOTH;
		gbc_btnThoi.insets = new Insets(0, 0, 0, 5);
		gbc_btnThoi.gridx = 0;
		gbc_btnThoi.gridy = 0;
		panel.add(btnThoi, gbc_btnThoi);
		
		ButtonAmination btnDongY = new ButtonAmination();
		btnDongY.setText("Đồng ý");
		btnDongY.setFont(new Font("Tahoma", Font.BOLD, 14));
		GridBagConstraints gbc_btnDongY = new GridBagConstraints();
		gbc_btnDongY.fill = GridBagConstraints.BOTH;
		gbc_btnDongY.gridx = 2;
		gbc_btnDongY.gridy = 0;
		panel.add(btnDongY, gbc_btnDongY);
		
		mkHienTai.addKeyListener(new KeyListener() {
			
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
					btnDongY.doClick();
	            }
			}
		});
		
		mkMoi.addKeyListener(new KeyListener() {
			
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
					btnDongY.doClick();
	            }
			}
		});
		
		mkNhapLai.addKeyListener(new KeyListener() {
			
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
					btnDongY.doClick();
	            }
			}
		});
		
		btnDongY.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (String.valueOf(mkHienTai.getPassword()).equals(matKhauND)) {
					if (String.valueOf(mkMoi.getPassword()).equals(String.valueOf(mkNhapLai.getPassword()))) {
						boolean flagThem1 = false;
						
						DTO.NguoiDung nd = new NguoiDung();
						nd.setMaNV(maNV);
						nd.setMatKhau(String.valueOf(mkNhapLai.getPassword()));
					
						if (nd.kiemTraHopLeMK()) 
							flagThem1 = true;
						
						if (!flagThem1) {
							JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
					                "Mật khẩu chứa ít nhất 6 ký tự, không chứa ký tự khoảng trắng\n và các ký tự đặc biệt ngoại trừ: ! @ # $ % ^ &*",
					                "Thông báo!!!",
					                JOptionPane.WARNING_MESSAGE);
						} else {
							if (ndBUS.doiMK(nd)) {
								JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
						                "Đổi mật khẩu thành công!",
						                "Thông báo!!!",
						                JOptionPane.INFORMATION_MESSAGE);
								DialogDoiMatKhau.this.setVisible(false);
								DialogDoiMatKhau.this.dispose();
							}
						}
					} else {
						JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
				                "Mật khẩu nhập lại không khớp!",
				                "Thông báo!!!",
				                JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Mật khẩu hiện tại không đúng!",
			                "Thông báo!!!",
			                JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});
		
		btnThoi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DialogDoiMatKhau.this.setVisible(false);
				DialogDoiMatKhau.this.dispose();
			}
		});
	}

}
