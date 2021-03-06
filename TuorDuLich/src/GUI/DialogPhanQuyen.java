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
		
		JLabel lblNewLabel = new JLabel("Kh??ch h??ng : ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JCheckBox themKH = new JCheckBox("Th??m");
		themKH.setOpaque(false);
		themKH.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themKH = new GridBagConstraints();
		gbc_themKH.insets = new Insets(0, 0, 0, 5);
		gbc_themKH.gridx = 1;
		gbc_themKH.gridy = 1;
		panel.add(themKH, gbc_themKH);
		
		JCheckBox suaKH = new JCheckBox("S???a");
		suaKH.setOpaque(false);
		suaKH.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_suaKH = new GridBagConstraints();
		gbc_suaKH.insets = new Insets(0, 0, 0, 5);
		gbc_suaKH.gridx = 3;
		gbc_suaKH.gridy = 1;
		panel.add(suaKH, gbc_suaKH);
		
		JCheckBox xoaKH = new JCheckBox("X??a");
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
		
		JLabel lblNewLabel_1 = new JLabel("Nh??n vi??n : ");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_1.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JCheckBox themNV = new JCheckBox("Th??m");
		themNV.setForeground(Color.WHITE);
		themNV.setOpaque(false);
		themNV.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themNV = new GridBagConstraints();
		gbc_themNV.insets = new Insets(0, 0, 0, 5);
		gbc_themNV.gridx = 1;
		gbc_themNV.gridy = 1;
		panel_1.add(themNV, gbc_themNV);
		
		JCheckBox suaNV = new JCheckBox("S???a");
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
		
		JLabel lblNewLabel_1_1 = new JLabel("Ng?????i d??ng : ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_1.gridx = 0;
		gbc_lblNewLabel_1_1.gridy = 1;
		panel_1_1.add(lblNewLabel_1_1, gbc_lblNewLabel_1_1);
		
		JCheckBox themND = new JCheckBox("Th??m");
		themND.setOpaque(false);
		themND.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themND = new GridBagConstraints();
		gbc_themND.insets = new Insets(0, 0, 0, 5);
		gbc_themND.gridx = 1;
		gbc_themND.gridy = 1;
		panel_1_1.add(themND, gbc_themND);
		
		JCheckBox suaND = new JCheckBox("S???a");
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
		
		JLabel lblNewLabel_1_2 = new JLabel("D???ch v??? : ");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_2 = new GridBagConstraints();
		gbc_lblNewLabel_1_2.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_2.gridx = 0;
		gbc_lblNewLabel_1_2.gridy = 1;
		panel_1_2.add(lblNewLabel_1_2, gbc_lblNewLabel_1_2);
		
		JCheckBox themDV = new JCheckBox("Th??m");
		themDV.setForeground(Color.WHITE);
		themDV.setOpaque(false);
		themDV.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themDV = new GridBagConstraints();
		gbc_themDV.insets = new Insets(0, 0, 0, 5);
		gbc_themDV.gridx = 1;
		gbc_themDV.gridy = 1;
		panel_1_2.add(themDV, gbc_themDV);
		
		JCheckBox xoaDV = new JCheckBox("X??a");
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
		
		JLabel lblNewLabel_1_3 = new JLabel("L??? tr??nh : ");
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_3 = new GridBagConstraints();
		gbc_lblNewLabel_1_3.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_3.gridx = 0;
		gbc_lblNewLabel_1_3.gridy = 1;
		panel_1_3.add(lblNewLabel_1_3, gbc_lblNewLabel_1_3);
		
		JCheckBox suaLT = new JCheckBox("S???a");
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
		
		JLabel lblNewLabel_1_4 = new JLabel("V?? : ");
		lblNewLabel_1_4.setForeground(Color.WHITE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_4 = new GridBagConstraints();
		gbc_lblNewLabel_1_4.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_4.gridx = 0;
		gbc_lblNewLabel_1_4.gridy = 1;
		panel_1_4.add(lblNewLabel_1_4, gbc_lblNewLabel_1_4);
		
		JCheckBox themVe = new JCheckBox("Th??m");
		themVe.setForeground(Color.WHITE);
		themVe.setOpaque(false);
		themVe.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themVe = new GridBagConstraints();
		gbc_themVe.insets = new Insets(0, 0, 0, 5);
		gbc_themVe.gridx = 1;
		gbc_themVe.gridy = 1;
		panel_1_4.add(themVe, gbc_themVe);
		
		JCheckBox xoaVe = new JCheckBox("X??a");
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
		
		JLabel lblNewLabel_1_5 = new JLabel("Kh??ch s???n : ");
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_5 = new GridBagConstraints();
		gbc_lblNewLabel_1_5.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_5.gridx = 0;
		gbc_lblNewLabel_1_5.gridy = 1;
		panel_1_5.add(lblNewLabel_1_5, gbc_lblNewLabel_1_5);
		
		JCheckBox themKS = new JCheckBox("Th??m");
		themKS.setOpaque(false);
		themKS.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themKS = new GridBagConstraints();
		gbc_themKS.insets = new Insets(0, 0, 0, 5);
		gbc_themKS.gridx = 1;
		gbc_themKS.gridy = 1;
		panel_1_5.add(themKS, gbc_themKS);
		
		JCheckBox suaKS = new JCheckBox("S???a");
		suaKS.setOpaque(false);
		suaKS.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_suaKS = new GridBagConstraints();
		gbc_suaKS.insets = new Insets(0, 0, 0, 5);
		gbc_suaKS.gridx = 3;
		gbc_suaKS.gridy = 1;
		panel_1_5.add(suaKS, gbc_suaKS);
		
		JCheckBox xoaKS = new JCheckBox("X??a");
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
		
		JLabel lblNewLabel_1_6 = new JLabel("Nh?? h??ng : ");
		lblNewLabel_1_6.setForeground(Color.WHITE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_6 = new GridBagConstraints();
		gbc_lblNewLabel_1_6.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_6.gridx = 0;
		gbc_lblNewLabel_1_6.gridy = 1;
		panel_1_6.add(lblNewLabel_1_6, gbc_lblNewLabel_1_6);
		
		JCheckBox themNH = new JCheckBox("Th??m");
		themNH.setForeground(Color.WHITE);
		themNH.setOpaque(false);
		themNH.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themNH = new GridBagConstraints();
		gbc_themNH.insets = new Insets(0, 0, 0, 5);
		gbc_themNH.gridx = 1;
		gbc_themNH.gridy = 1;
		panel_1_6.add(themNH, gbc_themNH);
		
		JCheckBox suaNH = new JCheckBox("S???a");
		suaNH.setForeground(Color.WHITE);
		suaNH.setOpaque(false);
		suaNH.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_suaNH = new GridBagConstraints();
		gbc_suaNH.insets = new Insets(0, 0, 0, 5);
		gbc_suaNH.gridx = 3;
		gbc_suaNH.gridy = 1;
		panel_1_6.add(suaNH, gbc_suaNH);
		
		JCheckBox xoaNH = new JCheckBox("X??a");
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
		
		JLabel lblNewLabel_1_5_1 = new JLabel("Nh?? cung c???p : ");
		lblNewLabel_1_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_1_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_1_5_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1_5_1.gridx = 0;
		gbc_lblNewLabel_1_5_1.gridy = 1;
		panel_1_5_1.add(lblNewLabel_1_5_1, gbc_lblNewLabel_1_5_1);
		
		JCheckBox themNCC = new JCheckBox("Th??m");
		themNCC.setOpaque(false);
		themNCC.setFont(new Font("Tahoma", Font.ITALIC, 14));
		GridBagConstraints gbc_themNCC = new GridBagConstraints();
		gbc_themNCC.insets = new Insets(0, 0, 0, 5);
		gbc_themNCC.gridx = 1;
		gbc_themNCC.gridy = 1;
		panel_1_5_1.add(themNCC, gbc_themNCC);
		
		JCheckBox suaNCC = new JCheckBox("S???a");
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
		btnOk.setText("Th??i");
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
				if (x.getTenQuyen().indexOf("Th??m") != -1) {
					if (x.getTenQuyen().equals("Th??m nh??n vi??n")) {
						themNV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Th??m kh??ch h??ng")) {
						themKH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Th??m ng?????i d??ng")) {
						themND.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Th??m d???ch v???")) {
						themDV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Th??m v??")) {
						themVe.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Th??m kh??ch s???n")) {
						themKS.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Th??m nh?? h??ng")) {
						themNH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("Th??m nh?? cung c???p")) {
						themNCC.setSelected(true);
						continue;
					}
				}
				
				if (x.getTenQuyen().indexOf("S???a") != -1) {
					if (x.getTenQuyen().equals("S???a nh??n vi??n")) {
						suaNV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("S???a kh??ch h??ng")) {
						suaKH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("S???a ng?????i d??ng")) {
						suaND.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("S???a d???ch v???")) {
					//	suaDV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("S???a l??? tr??nh")) {
						suaLT.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("S???a kh??ch s???n")) {
						suaKS.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("S???a nh?? h??ng")) {
						suaNH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("S???a nh?? cung c???p")) {
						suaNCC.setSelected(true);
						continue;
					}
				}
				
				if (x.getTenQuyen().indexOf("X??a") != -1) {
					if (x.getTenQuyen().equals("X??a nh??n vi??n")) {
						//xoaNV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("X??a kh??ch h??ng")) {
						xoaKH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("X??a ng?????i d??ng")) {
					//	xoaND.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("X??a d???ch v???")) {
						xoaDV.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("X??a l??? tr??nh")) {
					//	xoaLT.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("X??a v??")) {
						xoaVe.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("X??a kh??ch s???n")) {
						xoaKS.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("X??a nh?? h??ng")) {
						xoaNH.setSelected(true);
						continue;
					}
					if (x.getTenQuyen().equals("X??a nh?? cung c???p")) {
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
					pqBUS.xoaQuyen("Th??m nh??n vi??n", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Th??m nh??n vi??n");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themKH.isSelected()) {
					pqBUS.xoaQuyen("Th??m kh??ch h??ng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Th??m kh??ch h??ng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themND.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themND.isSelected()) {
					pqBUS.xoaQuyen("Th??m ng?????i d??ng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Th??m ng?????i d??ng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themDV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themDV.isSelected()) {
					pqBUS.xoaQuyen("Th??m d???ch v???", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Th??m d???ch v???");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themVe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themVe.isSelected()) {
					pqBUS.xoaQuyen("Th??m v??", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Th??m v??");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themKS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themKS.isSelected()) {
					pqBUS.xoaQuyen("Th??m kh??ch s???n", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Th??m kh??ch s???n");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themNH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themNH.isSelected()) {
					pqBUS.xoaQuyen("Th??m nh?? h??ng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Th??m nh?? h??ng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		themNCC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!themNCC.isSelected()) {
					pqBUS.xoaQuyen("Th??m nh?? cung c???p", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("Th??m nh?? cung c???p");
					pqBUS.themNV(pq);
				}
			}
		});
		
		
		
		suaNV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaNV.isSelected()) {
					pqBUS.xoaQuyen("S???a nh??n vi??n", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("S???a nh??n vi??n");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaND.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaND.isSelected()) {
					pqBUS.xoaQuyen("S???a ng?????i d??ng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("S???a ng?????i d??ng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaKH.isSelected()) {
					pqBUS.xoaQuyen("S???a kh??ch h??ng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("S???a kh??ch h??ng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaLT.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaLT.isSelected()) {
					pqBUS.xoaQuyen("S???a l??? tr??nh", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("S???a l??? tr??nh");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaKS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaKS.isSelected()) {
					pqBUS.xoaQuyen("S???a kh??ch s???n", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("S???a kh??ch s???n");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaNH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaNH.isSelected()) {
					pqBUS.xoaQuyen("S???a nh?? h??ng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("S???a nh?? h??ng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		suaNCC.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!suaNCC.isSelected()) {
					pqBUS.xoaQuyen("S???a nh?? cung c???p", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("S???a nh?? cung c???p");
					pqBUS.themNV(pq);
				}
			}
		});
		
		xoaKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!xoaKH.isSelected()) {
					pqBUS.xoaQuyen("X??a kh??ch h??ng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("X??a kh??ch h??ng");
					pqBUS.themNV(pq);
				}
			}
		});
		
		xoaDV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!xoaDV.isSelected()) {
					pqBUS.xoaQuyen("X??a d???ch v???", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("X??a d???ch v???");
					pqBUS.themNV(pq);
				}
			}
		});
		
		xoaVe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!xoaVe.isSelected()) {
					pqBUS.xoaQuyen("X??a v??", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("X??a v??");
					pqBUS.themNV(pq);
				}
			}
		});
		
		xoaKS.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!xoaKS.isSelected()) {
					pqBUS.xoaQuyen("X??a kh??ch s???n", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("X??a kh??ch s???n");
					pqBUS.themNV(pq);
				}
			}
		});
		
		xoaNH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!xoaNH.isSelected()) {
					pqBUS.xoaQuyen("X??a nh?? h??ng", maNV);
				} else {
					PhanQuyen pq = new PhanQuyen();
					pq.setMaNV(maNV);
					pq.setTenQuyen("X??a nh?? h??ng");
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
