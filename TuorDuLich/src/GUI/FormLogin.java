package GUI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BUS.NguoiDung_BUS;

import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.ImageIcon;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	private TextFielAmination txtTaiKhoan;
	private ButtonAmination btnDangNhap;
	private PassWordFielAmination txtPassWord;
	private JLabel label;
	private JLabel label_1;
	private JPanel panel_1;
	static Color backgroundColor = new Color(255, 255, 255);
	private JLabel lblNewLabel_3;
	private NguoiDung_BUS ndBUS = new NguoiDung_BUS();
	private int maNV = 0;

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setLocationRelativeTo(null); 
					frame.getContentPane().setBackground(backgroundColor);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	public FormLogin() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		int screenHeight = screenSize.height * 4 / 7;
		int screenWidth = screenSize.width * 3 / 6;
		
		setSize(screenWidth, screenHeight);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{120, 100};
		gbl_contentPane.rowHeights = new int[]{0, 100};
		gbl_contentPane.columnWeights = new double[]{1.2, 1.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 1.0};
		contentPane.setLayout(gbl_contentPane);
		ImageIcon icon = new ImageIcon(".\\img\\kisspng-tourism-travel-sports-image-design-5d2eab5fcc3163.1352116415633396158364 (1).png");
		Image img = icon.getImage();
		Image imgScale = img.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
		ImageIcon scaledIcon = new ImageIcon(imgScale);
		
		JButton btnNewButton_1 = new JButton("  X  ");
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(backgroundColor);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setFocusable(false);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.anchor = GridBagConstraints.EAST;
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 1;
		gbc_btnNewButton_1.gridy = 0;
		contentPane.add(btnNewButton_1, gbc_btnNewButton_1);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(13, 225, 195));
		panel_1.setLayout(null);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridheight = 2;
		gbc_panel_1.insets = new Insets(0, 0, 0, 0);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 0;
		contentPane.add(panel_1, gbc_panel_1);
		
		JLabelAmination lblNewLabel_1 = new JLabelAmination();
		lblNewLabel_1.setBounds(64, 124, 224, 201);
		lblNewLabel_1.setBackground(new Color(225, 225, 225));
		lblNewLabel_1.setRaius(lblNewLabel_1.getHeight() + 6);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(scaledIcon);
		
		JLabel lblNewLabel_2 = new JLabel("Liên hệ : 0999999999");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2.setBounds(258, 415, 95, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Bản quyền thuộc về nhóm của chúng tôi!");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNewLabel_2_1.setBounds(10, 415, 158, 14);
		panel_1.add(lblNewLabel_2_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(backgroundColor);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(20, 0, 20, 20);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 1;
		contentPane.add(panel, gbc_panel);
		
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{100};
		gbl_panel.rowHeights = new int[]{100, 50, 70, 50, 70, 70, 70};
		gbl_panel.columnWeights = new double[]{1.0};
		gbl_panel.rowWeights = new double[]{1.0, 0.5, 0.5, 0.7, 0.5, 0.4, 0.4};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Đăng nhập");
		lblNewLabel.setFont(new Font("Serif", Font.PLAIN, 22));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(10, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		label = new JLabel("Tài khoản:");
		label.setFont(new Font("Serif", Font.BOLD, 14));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.WEST;
		gbc_label.insets = new Insets(0, 30, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 1;
		panel.add(label, gbc_label);
		
		txtTaiKhoan = new TextFielAmination();
		txtTaiKhoan.setFontt(true);
		txtTaiKhoan.setBackground(new Color(225, 225, 225));
		txtTaiKhoan.setBorder(new EmptyBorder(4, 20, 4, 30));
		GridBagConstraints gbc_txtTaiKhoan = new GridBagConstraints();
		gbc_txtTaiKhoan.fill = GridBagConstraints.BOTH;
		gbc_txtTaiKhoan.insets = new Insets(10, 30, 10, 30);
		gbc_txtTaiKhoan.gridx = 0;
		gbc_txtTaiKhoan.gridy = 2;
		panel.add(txtTaiKhoan, gbc_txtTaiKhoan);
		
		label_1 = new JLabel("Mật khẩu:");
		label_1.setFont(new Font("Serif", Font.BOLD, 14));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 30, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		panel.add(label_1, gbc_label_1);
		
		txtPassWord = new PassWordFielAmination();
		txtPassWord.setBackground(new Color(225, 225, 225));
		txtPassWord.setFontt(true);
		txtPassWord.setBorder(new EmptyBorder(4, 20, 4, 30));
		GridBagConstraints gbc_txtPassWord = new GridBagConstraints();
		gbc_txtPassWord.insets = new Insets(10, 30, 10, 30);
		gbc_txtPassWord.fill = GridBagConstraints.BOTH;
		gbc_txtPassWord.gridx = 0;
		gbc_txtPassWord.gridy = 4;
		panel.add(txtPassWord, gbc_txtPassWord);
		
		btnDangNhap = new ButtonAmination();
		btnDangNhap.setText("Đăng nhập");
		GridBagConstraints gbc_btnDangNhap = new GridBagConstraints();
		gbc_btnDangNhap.fill = GridBagConstraints.BOTH;
		gbc_btnDangNhap.insets = new Insets(15, 18, 5, 18);
		gbc_btnDangNhap.gridx = 0;
		gbc_btnDangNhap.gridy = 5;
		panel.add(btnDangNhap, gbc_btnDangNhap);
		
		lblNewLabel_3 = new JLabel("Liên hệ: 0999999999");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 6;
		panel.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		setEvent();
	}
	
	
	
	
	public void setEvent() {
		
		txtTaiKhoan.addKeyListener(new KeyListener() {
			
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
					btnDangNhap.doClick();
	            }
			}
		});
		
		txtPassWord.addKeyListener(new KeyListener() {
			
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
					btnDangNhap.doClick();
	            }
			}
		});
		
		btnDangNhap.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean flagThem = false;
				boolean flagThem1 = false;
				
				
				if (kiemTraHopLeMK()) 
					flagThem1 = true;
				
				if (kiemTraHopLeTK()) 
					flagThem = true;
				
				if (!flagThem) {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Tài khoản bắt đầu bằng chữ cái,\nchứa ít nhất 6 ký tự, không chứa ký tự khoảng trắng và ký tự đặc biệt!",
			                "Thông báo!!!",
			                JOptionPane.WARNING_MESSAGE);
				}
				
				if (!flagThem1) {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Mật khẩu chứa ít nhất 6 ký tự, không chứa ký tự khoảng trắng\n và các ký tự đặc biệt ngoại trừ: ! @ # $ % ^ &*",
			                "Thông báo!!!",
			                JOptionPane.WARNING_MESSAGE);
				}
				
				if (flagThem && flagThem1) {
					String mk = String.valueOf(txtPassWord.getPassword());
					maNV= ndBUS.dangNhap(txtTaiKhoan.getText(), mk);
					if(maNV != -1) {
						setVisible(false);
						TrangChinh b= new TrangChinh(maNV);
						FormLogin.this.dispose();
						b.setVisible(true);
						b.setLocationRelativeTo(null); 
					} else 
						maNV = -1;
				}
				
			}
		});
	}
	
	public boolean kiemTraHopLeTK() {
		
		String taiKhoan = txtTaiKhoan.getText();
		
		if (taiKhoan.length() > 6) {
			Pattern p = Pattern.compile("^[A-Za-z]+[A-Za-z0-9]+$");
			Matcher pp = p.matcher(taiKhoan);
			
			return pp.find();
		}
		
		return false;
		
	}
	
	public boolean kiemTraHopLeMK() {
		
		String matKhau = txtPassWord.getText();
		
		if(matKhau.length()>=8)
	    {
	        Pattern letter = Pattern.compile("[a-zA-z]");
	        Pattern digit = Pattern.compile("[0-9]");
	        Pattern special = Pattern.compile ("[!@#$%&*]");
	 
	        Matcher hasLetter = letter.matcher(matKhau);
	        Matcher hasDigit = digit.matcher(matKhau);
	        Matcher hasSpecial = special.matcher(matKhau);
	 
	        return hasLetter.find() || hasDigit.find() || hasSpecial.find();
	 
	    }
		
		return false;
		
	}
}
