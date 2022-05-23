package GUI;

import java.awt.Color;
import java.awt.GridBagConstraints;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Frame;
import javax.swing.JPanel;

import BUS.CheDo_BUS;

public class DialogThem extends JDialog {

	private int maNV = -1;
	private JComboBox chonNV = new JComboBox();
	private ButtonAmination btnOk = new ButtonAmination();
	private TextFielAmination txtNV = new TextFielAmination();
	private ButtonAmination btnCancel = new ButtonAmination();
	private ArrayList<DTO.NhanVien> dsnv = new ArrayList<DTO.NhanVien>();
	private Color background = new Color(111, 211, 178);
	
	private boolean cheDo = true;



	public ArrayList<DTO.NhanVien> getDsnv() {
		return dsnv;
	}

	public void setDsnv(ArrayList<DTO.NhanVien> dsnv) {
		this.dsnv = dsnv;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public DialogThem(Frame owner, String title) {
        super(owner, title, true);
        
        CheDo_BUS cdBUS = new CheDo_BUS();
		cheDo = cdBUS.readClientList();
		if (!cheDo) {
			CheDoMau mau = new CheDoMau();
			//background = mau.getMauPhuSang();
			background = mau.getMauPhuSang();
		}
        
		setSize(450, 250);
		setLocationRelativeTo(null);
		setResizable(false);
		getContentPane().setBackground(background);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0};
		gridBagLayout.rowWeights = new double[]{1.0, 0.2};
		getContentPane().setLayout(gridBagLayout);
		
		JLabel lblNewLabel_1 = new JLabel("Ch\u1ECDn nh\u00E2n vi\u00EAn:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		chonNV.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 15);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 0;
		getContentPane().add(chonNV, gbc_comboBox);
		
		JPanel panel = new JPanel();
		panel.setOpaque(false);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 0, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 1;
		getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0};
		gbl_panel.rowWeights = new double[]{1.0};
		panel.setLayout(gbl_panel);
		
		btnOk.setText("Ok");
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton.insets = new Insets(10, 25, 10, 25);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		panel.add(btnOk, gbc_btnNewButton);
		
		btnOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int manv = 0;
				String s = chonNV.getSelectedItem().toString();
				String temp[] = s.split(" - ");
				try {
					manv = Integer.parseInt(temp[0]);
				} catch (Exception ex) {
					manv = -1;
				}
				if (manv < 1)
					manv = -1;
				if (manv > 0) {
					setMaNV(manv);
					DialogThem.this.setVisible(false);
					DialogThem.this.dispose();
				} else {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
			                "Bạn chưa chọn nhân viên để thêm tài khoản!",
			                "Thông báo!!!",
			                JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		btnCancel.setText("Cancel");
		btnCancel.setBorderColor(new Color(110, 15, 0));
		btnCancel.setColorOver(new Color(255, 75, 46));
		btnCancel.setColorClick(new Color(251, 139, 121));
		GridBagConstraints gbc_btnNewButton1 = new GridBagConstraints();
		gbc_btnNewButton1.fill = GridBagConstraints.BOTH;
		gbc_btnNewButton1.insets = new Insets(10, 30, 10, 25);
		gbc_btnNewButton1.gridx = 1;
		gbc_btnNewButton1.gridy = 0;
		panel.add(btnCancel, gbc_btnNewButton1);
		
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setMaNV(-1);
				DialogThem.this.setVisible(false);
				DialogThem.this.dispose();
			}
		});
	}
	
	public ButtonAmination getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(ButtonAmination btnCancel) {
		this.btnCancel = btnCancel;
	}

	public void themNV() {
		chonNV.addItem("Tùy chọn");
		for (int i = 0; i < dsnv.size(); i++) {
			chonNV.addItem(dsnv.get(i).getMaNV() + " - " + dsnv.get(i).getTenNV());
		}
	}

}
