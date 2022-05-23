package GUI;


import javax.swing.JDialog;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Frame;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import java.awt.Insets;
import java.awt.Font;
import javax.swing.border.CompoundBorder;
import javax.swing.border.MatteBorder;

import BUS.CheDo_BUS;
import BUS.PhanQuyen_BUS;
import DTO.PhanQuyen;

import java.awt.Color;
import javax.swing.JButton;

public class DialogPhanQuyen extends JDialog {

	private ButtonAmination btnOk = new ButtonAmination();
	private Color bg_default = new Color(78, 161, 134);
	private Color bg_selected = new Color(111, 211, 178);
	private PhanQuyen_BUS pqBUS = new PhanQuyen_BUS();
	private ArrayList<PhanQuyen> dspq = new ArrayList<PhanQuyen>();
	private static int maNV = 0;
	private boolean cheDo = true;
	
	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}



	public DialogPhanQuyen(Frame owner, String title, int ma) {
        super(owner, title, true);
        
        CheDo_BUS cdBUS = new CheDo_BUS();
		cheDo = cdBUS.readClientList();
		setResizable(false);

		if (!cheDo) {
			CheDoMau mau = new CheDoMau();
			//background = mau.getMauPhuSang();
			bg_selected = mau.getMauPhuSang();
			bg_default = mau.getMauChinhSang();
		}
        
        maNV = ma;
		setSize(800, 600);
		setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{784, 0};
		gridBagLayout.rowHeights = new int[]{49, 49, 49, 49, 49, 49, 49, 49, 49, 80};
		gridBagLayout.columnWeights = new double[]{1.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		getContentPane().setLayout(gridBagLayout);
		
		JPanel panel = new JPanel();
		panel.setBackground(bg_selected);
		panel.setBorder(new CompoundBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)), new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128))));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 0.5, 1.0};
		gbl_panel.rowWeights = new double[]{0.0, 1.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("Khách hàng : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JCheckBox themKH = new JCheckBox("Thêm");
		themKH.setOpaque(false);
		themKH.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themKH = new GridBagConstraints();
		gbc_themKH.insets = new Insets(0, 0, 0, 5);
		gbc_themKH.gridx = 1;
		gbc_themKH.gridy = 1;
		panel.add(themKH, gbc_themKH);
		
		JCheckBox suaKH = new JCheckBox("Sửa");
		suaKH.setOpaque(false);
		suaKH.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_suaKH = new GridBagConstraints();
		gbc_suaKH.insets = new Insets(0, 0, 0, 5);
		gbc_suaKH.gridx = 3;
		gbc_suaKH.gridy = 1;
		panel.add(suaKH, gbc_suaKH);
		
		JCheckBox xoaKH = new JCheckBox("Xóa");
		xoaKH.setOpaque(false);
		xoaKH.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_xoaKH = new GridBagConstraints();
		gbc_xoaKH.insets = new Insets(0, 0, 0, 5);
		gbc_xoaKH.gridx = 5;
		gbc_xoaKH.gridy = 1;
		panel.add(xoaKH, gbc_xoaKH);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new CompoundBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)), new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128))));
		panel_1.setBackground(bg_default);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 0.5, 1.0 };
		gbl_panel_1.rowWeights = new double[]{1.0, 1.0 };
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_1 = new JLabel("Nhân viên : ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JCheckBox themNV = new JCheckBox("Thêm");
		themNV.setForeground(Color.WHITE);
		themNV.setOpaque(false);
		themNV.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themNV = new GridBagConstraints();
		gbc_themNV.insets = new Insets(0, 0, 0, 5);
		gbc_themNV.gridx = 1;
		gbc_themNV.gridy = 1;
		panel_1.add(themNV, gbc_themNV);
		
		JCheckBox suaNV = new JCheckBox("Sửa");
		suaNV.setForeground(Color.WHITE);
		suaNV.setOpaque(false);
		suaNV.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_suaNV = new GridBagConstraints();
		gbc_suaNV.insets = new Insets(0, 0, 0, 5);
		gbc_suaNV.gridx = 3;
		gbc_suaNV.gridy = 1;
		panel_1.add(suaNV, gbc_suaNV);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new CompoundBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)), new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128))));
		panel_1_1.setBackground(bg_selected);
		GridBagConstraints gbc_panel_1_1 = new GridBagConstraints();
		gbc_panel_1_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_1.gridx = 0;
		gbc_panel_1_1.gridy = 2;
		getContentPane().add(panel_1_1, gbc_panel_1_1);
		GridBagLayout gbl_panel_1_1 = new GridBagLayout();
		gbl_panel_1_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1_1.rowHeights = new int[]{0, 0};
		gbl_panel_1_1.columnWeights = new double[]{1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 0.5, 1.0 };
		gbl_panel_1_1.rowWeights = new double[]{1.0, 1.0 };
		panel_1_1.setLayout(gbl_panel_1_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Người dùng : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 1;
		panel_1_1.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		JCheckBox themND = new JCheckBox("Thêm");
		themND.setOpaque(false);
		themND.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themND = new GridBagConstraints();
		gbc_themND.insets = new Insets(0, 0, 0, 5);
		gbc_themND.gridx = 1;
		gbc_themND.gridy = 1;
		panel_1_1.add(themND, gbc_themND);
		
		JCheckBox suaND = new JCheckBox("Sửa");
		suaND.setOpaque(false);
		suaND.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_suaND = new GridBagConstraints();
		gbc_suaND.insets = new Insets(0, 0, 0, 5);
		gbc_suaND.gridx = 3;
		gbc_suaND.gridy = 1;
		panel_1_1.add(suaND, gbc_suaND);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setBorder(new CompoundBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)), new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128))));
		panel_1_2.setBackground(bg_default);
		GridBagConstraints gbc_panel_1_2 = new GridBagConstraints();
		gbc_panel_1_2.fill = GridBagConstraints.BOTH;
		gbc_panel_1_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_2.gridx = 0;
		gbc_panel_1_2.gridy = 3;
		getContentPane().add(panel_1_2, gbc_panel_1_2);
		GridBagLayout gbl_panel_1_2 = new GridBagLayout();
		gbl_panel_1_2.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1_2.rowHeights = new int[]{0, 0};
		gbl_panel_1_2.columnWeights = new double[]{1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 0.5, 1.0 };
		gbl_panel_1_2.rowWeights = new double[]{1.0, 1.0 };
		panel_1_2.setLayout(gbl_panel_1_2);
		
		JLabel lblNewLabel_1_2 = new JLabel("Dịch vụ : ");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_2.gridx = 0;
		gbc_lblNewLabel_1_2.gridy = 1;
		panel_1_2.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		JCheckBox themDV = new JCheckBox("Thêm");
		themDV.setForeground(Color.WHITE);
		themDV.setOpaque(false);
		themDV.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themDV = new GridBagConstraints();
		gbc_themDV.insets = new Insets(0, 0, 0, 5);
		gbc_themDV.gridx = 1;
		gbc_themDV.gridy = 1;
		panel_1_2.add(themDV, gbc_themDV);
		
		JCheckBox xoaDV = new JCheckBox("Xóa");
		xoaDV.setForeground(Color.WHITE);
		xoaDV.setOpaque(false);
		xoaDV.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_xoaDV = new GridBagConstraints();
		gbc_xoaDV.insets = new Insets(0, 0, 0, 5);
		gbc_xoaDV.gridx = 5;
		gbc_xoaDV.gridy = 1;
		panel_1_2.add(xoaDV, gbc_xoaDV);
		
		JPanel panel_1_3 = new JPanel();
		panel_1_3.setBorder(new CompoundBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)), new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128))));
		panel_1_3.setBackground(bg_selected);
		GridBagConstraints gbc_panel_1_3 = new GridBagConstraints();
		gbc_panel_1_3.fill = GridBagConstraints.BOTH;
		gbc_panel_1_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_3.gridx = 0;
		gbc_panel_1_3.gridy = 4;
		getContentPane().add(panel_1_3, gbc_panel_1_3);
		GridBagLayout gbl_panel_1_3 = new GridBagLayout();
		gbl_panel_1_3.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1_3.rowHeights = new int[]{0, 0};
		gbl_panel_1_3.columnWeights = new double[]{1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 0.5, 1.0 };
		gbl_panel_1_3.rowWeights = new double[]{1.0, 1.0 };
		panel_1_3.setLayout(gbl_panel_1_3);
		
		JLabel lblNewLabel_1_3 = new JLabel("Lộ trình : ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_3.gridx = 0;
		gbc_lblNewLabel_1_3.gridy = 1;
		panel_1_3.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		JCheckBox suaLT = new JCheckBox("Sửa");
		suaLT.setOpaque(false);
		suaLT.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_suaLT = new GridBagConstraints();
		gbc_suaLT.insets = new Insets(0, 0, 0, 5);
		gbc_suaLT.gridx = 3;
		gbc_suaLT.gridy = 1;
		panel_1_3.add(suaLT, gbc_suaLT);
		
		JPanel panel_1_4 = new JPanel();
		panel_1_4.setBorder(new CompoundBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)), new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128))));
		panel_1_4.setBackground(bg_default);
		GridBagConstraints gbc_panel_1_4 = new GridBagConstraints();
		gbc_panel_1_4.fill = GridBagConstraints.BOTH;
		gbc_panel_1_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_4.gridx = 0;
		gbc_panel_1_4.gridy = 5;
		getContentPane().add(panel_1_4, gbc_panel_1_4);
		GridBagLayout gbl_panel_1_4 = new GridBagLayout();
		gbl_panel_1_4.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1_4.rowHeights = new int[]{0, 0};
		gbl_panel_1_4.columnWeights = new double[]{1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 0.5, 1.0 };
		gbl_panel_1_4.rowWeights = new double[]{1.0, 1.0 };
		panel_1_4.setLayout(gbl_panel_1_4);
		
		JLabel lblNewLabel_1_4 = new JLabel("Vé : ");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_1_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_4.gridx = 0;
		gbc_lblNewLabel_1_4.gridy = 1;
		panel_1_4.add(lblNewLabel_1_4, gbc_lblNewLabel_1_4);
		
		JCheckBox themVe = new JCheckBox("Thêm");
		themVe.setForeground(Color.WHITE);
		themVe.setOpaque(false);
		themVe.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themVe = new GridBagConstraints();
		gbc_themVe.insets = new Insets(0, 0, 0, 5);
		gbc_themVe.gridx = 1;
		gbc_themVe.gridy = 1;
		panel_1_4.add(themVe, gbc_themVe);
		
		JCheckBox xoaVe = new JCheckBox("Xóa");
		xoaVe.setForeground(Color.WHITE);
		xoaVe.setOpaque(false);
		xoaVe.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_xoaVe = new GridBagConstraints();
		gbc_xoaVe.insets = new Insets(0, 0, 0, 5);
		gbc_xoaVe.gridx = 5;
		gbc_xoaVe.gridy = 1;
		panel_1_4.add(xoaVe, gbc_xoaVe);
		
		JPanel panel_1_5 = new JPanel();
		panel_1_5.setBorder(new CompoundBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)), new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128))));
		panel_1_5.setBackground(bg_selected);
		GridBagConstraints gbc_panel_1_5 = new GridBagConstraints();
		gbc_panel_1_5.fill = GridBagConstraints.BOTH;
		gbc_panel_1_5.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_5.gridx = 0;
		gbc_panel_1_5.gridy = 6;
		getContentPane().add(panel_1_5, gbc_panel_1_5);
		GridBagLayout gbl_panel_1_5 = new GridBagLayout();
		gbl_panel_1_5.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1_5.rowHeights = new int[]{0, 0};
		gbl_panel_1_5.columnWeights = new double[]{1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 0.5, 1.0 };
		gbl_panel_1_5.rowWeights = new double[]{1.0, 1.0 };
		panel_1_5.setLayout(gbl_panel_1_5);
		
		JLabel lblNewLabel_1_5 = new JLabel("Khách sạn : ");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_5 = new GridBagConstraints();
		gbc_lblNewLabel_1_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_5.gridx = 0;
		gbc_lblNewLabel_1_5.gridy = 1;
		panel_1_5.add(lblNewLabel_1_5, gbc_lblNewLabel_1_5);
		
		JCheckBox themKS = new JCheckBox("Thêm");
		themKS.setOpaque(false);
		themKS.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themKS = new GridBagConstraints();
		gbc_themKS.insets = new Insets(0, 0, 0, 5);
		gbc_themKS.gridx = 1;
		gbc_themKS.gridy = 1;
		panel_1_5.add(themKS, gbc_themKS);
		
		JCheckBox suaKS = new JCheckBox("Sửa");
		suaKS.setOpaque(false);
		suaKS.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_suaKS = new GridBagConstraints();
		gbc_suaKS.insets = new Insets(0, 0, 0, 5);
		gbc_suaKS.gridx = 3;
		gbc_suaKS.gridy = 1;
		panel_1_5.add(suaKS, gbc_suaKS);
		
		JCheckBox xoaKS = new JCheckBox("Xóa");
		xoaKS.setOpaque(false);
		xoaKS.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_xoaKS = new GridBagConstraints();
		gbc_xoaKS.insets = new Insets(0, 0, 0, 5);
		gbc_xoaKS.gridx = 5;
		gbc_xoaKS.gridy = 1;
		panel_1_5.add(xoaKS, gbc_xoaKS);
		
		JPanel panel_1_6 = new JPanel();
		panel_1_6.setBorder(new CompoundBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)), new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128))));
		panel_1_6.setBackground(bg_default);
		GridBagConstraints gbc_panel_1_6 = new GridBagConstraints();
		gbc_panel_1_6.fill = GridBagConstraints.BOTH;
		gbc_panel_1_6.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_6.gridx = 0;
		gbc_panel_1_6.gridy = 7;
		getContentPane().add(panel_1_6, gbc_panel_1_6);
		GridBagLayout gbl_panel_1_6 = new GridBagLayout();
		gbl_panel_1_6.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1_6.rowHeights = new int[]{0, 0};
		gbl_panel_1_6.columnWeights = new double[]{1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 0.5, 1.0 };
		gbl_panel_1_6.rowWeights = new double[]{1.0, 1.0 };
		panel_1_6.setLayout(gbl_panel_1_6);
		
		JLabel lblNewLabel_1_6 = new JLabel("Nhà hàng : ");
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_6 = new GridBagConstraints();
		gbc_lblNewLabel_1_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_6.gridx = 0;
		gbc_lblNewLabel_1_6.gridy = 1;
		panel_1_6.add(lblNewLabel_1_6, gbc_lblNewLabel_1_6);
		
		JCheckBox themNH = new JCheckBox("Thêm");
		themNH.setForeground(Color.WHITE);
		themNH.setOpaque(false);
		themNH.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themNH = new GridBagConstraints();
		gbc_themNH.insets = new Insets(0, 0, 0, 5);
		gbc_themNH.gridx = 1;
		gbc_themNH.gridy = 1;
		panel_1_6.add(themNH, gbc_themNH);
		
		JCheckBox suaNH = new JCheckBox("Sửa");
		suaNH.setForeground(Color.WHITE);
		suaNH.setOpaque(false);
		suaNH.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_suaNH = new GridBagConstraints();
		gbc_suaNH.insets = new Insets(0, 0, 0, 5);
		gbc_suaNH.gridx = 3;
		gbc_suaNH.gridy = 1;
		panel_1_6.add(suaNH, gbc_suaNH);
		
		JCheckBox xoaNH = new JCheckBox("Xóa");
		xoaNH.setForeground(Color.WHITE);
		xoaNH.setOpaque(false);
		xoaNH.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_xoaNH = new GridBagConstraints();
		gbc_xoaNH.insets = new Insets(0, 0, 0, 5);
		gbc_xoaNH.gridx = 5;
		gbc_xoaNH.gridy = 1;
		panel_1_6.add(xoaNH, gbc_xoaNH);
		
		JPanel panel_1_5_1 = new JPanel();
		panel_1_5_1.setBorder(new CompoundBorder(new MatteBorder(0, 0, 3, 0, (Color) new Color(192, 192, 192)), new MatteBorder(0, 0, 2, 0, (Color) new Color(128, 128, 128))));
		panel_1_5_1.setBackground(bg_selected);
		GridBagConstraints gbc_panel_1_5_1 = new GridBagConstraints();
		gbc_panel_1_5_1.insets = new Insets(0, 0, 5, 0);
		gbc_panel_1_5_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1_5_1.gridx = 0;
		gbc_panel_1_5_1.gridy = 8;
		getContentPane().add(panel_1_5_1, gbc_panel_1_5_1);
		GridBagLayout gbl_panel_1_5_1 = new GridBagLayout();
		gbl_panel_1_5_1.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1_5_1.rowHeights = new int[]{0, 0, 0};
		gbl_panel_1_5_1.columnWeights = new double[]{1.0, 1.0, 0.5, 1.0, 0.5, 1.0, 0.5, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1_5_1.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_1_5_1.setLayout(gbl_panel_1_5_1);
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Nhà cung cấp : ");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_5_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_5_1.gridx = 0;
		gbc_lblNewLabel_1_5_1.gridy = 1;
		panel_1_5_1.add(lblNewLabel_1_5_1, gbc_lblNewLabel_1_5_1);
		
		JCheckBox themNCC = new JCheckBox("Thêm");
		themNCC.setOpaque(false);
		themNCC.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themNCC = new GridBagConstraints();
		gbc_themNCC.insets = new Insets(0, 0, 0, 5);
		gbc_themNCC.gridx = 1;
		gbc_themNCC.gridy = 1;
		panel_1_5_1.add(themNCC, gbc_themNCC);
		
		JCheckBox suaNCC = new JCheckBox("Sửa");
		suaNCC.setOpaque(false);
		suaNCC.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_suaNCC = new GridBagConstraints();
		gbc_suaNCC.insets = new Insets(0, 0, 0, 5);
		gbc_suaNCC.gridx = 3;
		gbc_suaNCC.gridy = 1;
		panel_1_5_1.add(suaNCC, gbc_suaNCC);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(bg_default);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 9;
		getContentPane().add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, 0.2};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0};
		panel_2.setLayout(gbl_panel_2);
		
		btnOk = new ButtonAmination();
		btnOk.setText("Thôi");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(0, 0, 10, 10);
		gbc_btnNewButton.gridx = 1;
		gbc_btnNewButton.gridy = 1;
		panel_2.add(btnOk, gbc_btnNewButton);
		
		pqBUS.docDsnv(maNV);
		dspq = pqBUS.getDsnv();
		
		if (dspq != null) {
			for (PhanQuyen x : dspq) {
				if (x.getTenQuyen().indexOf("Thêm") != -1) {
					if (x.getTenQuyen().equals("Thêm nhân viên")) {
						themNV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Thêm khách hàng")) {
						themKH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Thêm người dùng")) {
						themND.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Thêm dịch vụ")) {
						themDV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Thêm vé")) {
						themVe.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Thêm khách sạn")) {
						themKS.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Thêm nhà hàng")) {
						themNH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Thêm nhà cung cấp")) {
						themNCC.setSelected(true);
						continue;
					}
				}
				
				if (x.getTenQuyen().indexOf("Sửa") != -1) {
					if (x.getTenQuyen().equals("Sửa nhân viên")) {
						suaNV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Sửa khách hàng")) {
						suaKH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Sửa người dùng")) {
						suaND.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Sửa dịch vụ")) {
					//	suaDV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Sửa lộ trình")) {
						suaLT.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Sửa khách sạn")) {
						suaKS.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Sửa nhà hàng")) {
						suaNH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Sửa nhà cung cấp")) {
						suaNCC.setSelected(true);
						continue;
					}
				}
				
				if (x.getTenQuyen().indexOf("Xóa") != -1) {
					if (x.getTenQuyen().equals("Xóa nhân viên")) {
						//xoaNV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Xóa khách hàng")) {
						xoaKH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Xóa người dùng")) {
					//	xoaND.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Xóa dịch vụ")) {
						xoaDV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Xóa lộ trình")) {
					//	xoaLT.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Xóa vé")) {
						xoaVe.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Xóa khách sạn")) {
						xoaKS.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Xóa nhà hàng")) {
						xoaNH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Xóa nhà cung cấp")) {
					//	xoaNCC.setSelected(true);
						continue;
					}
				}
			}
		}
		
		themNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themNV.isSelected()) {
					pqBUS.xoaQuyen("Thêm nhân viên", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Thêm nhân viên");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themKH.isSelected()) {
					pqBUS.xoaQuyen("Thêm khách hàng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Thêm khách hàng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themND.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themND.isSelected()) {
					pqBUS.xoaQuyen("Thêm người dùng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Thêm người dùng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themDV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themDV.isSelected()) {
					pqBUS.xoaQuyen("Thêm dịch vụ", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Thêm dịch vụ");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themVe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themVe.isSelected()) {
					pqBUS.xoaQuyen("Thêm vé", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Thêm vé");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themKS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themKS.isSelected()) {
					pqBUS.xoaQuyen("Thêm khách sạn", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Thêm khách sạn");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themNH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themNH.isSelected()) {
					pqBUS.xoaQuyen("Thêm nhà hàng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Thêm nhà hàng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themNCC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themNCC.isSelected()) {
					pqBUS.xoaQuyen("Thêm nhà cung cấp", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Thêm nhà cung cấp");
					pqBUS.themNV(pq);
				}
			}
		});
		
		
		
		suaNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaNV.isSelected()) {
					pqBUS.xoaQuyen("Sửa nhân viên", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Sửa nhân viên");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaND.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaND.isSelected()) {
					pqBUS.xoaQuyen("Sửa người dùng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Sửa người dùng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaKH.isSelected()) {
					pqBUS.xoaQuyen("Sửa khách hàng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Sửa khách hàng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaLT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaLT.isSelected()) {
					pqBUS.xoaQuyen("Sửa lộ trình", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Sửa lộ trình");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaKS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaKS.isSelected()) {
					pqBUS.xoaQuyen("Sửa khách sạn", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Sửa khách sạn");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaNH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaNH.isSelected()) {
					pqBUS.xoaQuyen("Sửa nhà hàng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Sửa nhà hàng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaNCC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaNCC.isSelected()) {
					pqBUS.xoaQuyen("Sửa nhà cung cấp", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Sửa nhà cung cấp");
					pqBUS.themNV(pq);
				}
			}
		});
		
		xoaKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!xoaKH.isSelected()) {
					pqBUS.xoaQuyen("Xóa khách hàng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Xóa khách hàng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		xoaDV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!xoaDV.isSelected()) {
					pqBUS.xoaQuyen("Xóa dịch vụ", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Xóa dịch vụ");
					pqBUS.themNV(pq);
				}
			}
		});
		
		xoaVe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!xoaVe.isSelected()) {
					pqBUS.xoaQuyen("Xóa vé", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Xóa vé");
					pqBUS.themNV(pq);
				}
			}
		});
		
		xoaKS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!xoaKS.isSelected()) {
					pqBUS.xoaQuyen("Xóa khách sạn", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Xóa khách sạn");
					pqBUS.themNV(pq);
				}
			}
		});
		
		xoaNH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!xoaNH.isSelected()) {
					pqBUS.xoaQuyen("Xóa nhà hàng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Xóa nhà hàng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		btnOk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DialogPhanQuyen.this.setVisible(false);
				DialogPhanQuyen.this.dispose();
			}
		});
	}

}
