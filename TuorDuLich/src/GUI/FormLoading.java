package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Dialog.ModalExclusionType;

public class FormLoading extends JFrame {

	private JPanel contentPane;
	private JProgressBar progressBar;
	private JLabel lblNewLabel_2 ;
    int i=0;
	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public FormLoading() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 153, 51));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(0, 204, 51));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\air-tickets-icon1.png"));
		lblNewLabel.setBounds(101, 0, 234, 138);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("H\u1EC7 Th\u1ED1ng Qu\u1EA3n L\u00FD Tour Du L\u1ECBch");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(82, 160, 313, 26);
		panel.add(lblNewLabel_1);
		
		 lblNewLabel_2 = new JLabel("%");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(255, 255, 255));
		lblNewLabel_2.setBounds(177, 191, 62, 14);
		panel.add(lblNewLabel_2);
		
		 progressBar = new JProgressBar();
		progressBar.setBackground(new Color(255, 255, 255));
		progressBar.setBounds(0, 216, 424, 35);
		panel.add(progressBar);
		
	}
	public static void main(String[] args) {
		FormLoading frame=new FormLoading();
		frame.setVisible(true);
		try {
			for(int i=0;i<=100;i++)
			{
				Thread.sleep(50);
				frame.progressBar.setValue(i);
				frame.lblNewLabel_2.setText(Integer.toString(i)+"%");
			}
		}catch(Exception e)
		{
			
		}
		new FormLogin().setVisible(true);
		frame.dispose();
		
	}

}
