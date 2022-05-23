package BUS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.NguoiDung_DAO;
import DTO.NguoiDung;
import GUI.TrangChinh;

public class NguoiDung_BUS {
	
	private NguoiDung_DAO ndDAO = new NguoiDung_DAO();
	private ArrayList<DTO.NguoiDung> dsnd = new ArrayList<DTO.NguoiDung>();

	public NguoiDung_BUS() {
	}

	public ArrayList<DTO.NguoiDung> getDsnd() {
		return dsnd;
	}

	public void docDsnd() {
		this.dsnd = ndDAO.docDS();
		
	}
	
	public boolean themND(DTO.NguoiDung nd) {
		
		if (!nd.kiemTraHopLeTK()) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Tài khoản bắt đầu bằng chữ cái,\nchứa ít nhất 6 ký tự, không chứa ký tự khoảng trắng và ký tự đặc biệt!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if (!nd.kiemTraHopLeMK()) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Mật khẩu chứa ít nhất 6 ký tự, không chứa ký tự khoảng trắng\n và các ký tự đặc biệt ngoại trừ: ! @ # $ % ^ &*",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		
		if (!nd.getEmail().equals("")) {
			if (!nd.kiemTraHopLeEmail()) {
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
		                "Định dạng email không hợp lệ!",
		                "Thông báo!!!",
		                JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		
		
		if (!ndDAO.checkTK(nd.getTaiKhoan())) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Tài khoản đã tồn tại!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if (ndDAO.themVaoDS(nd))
			return true;
		
		return false;
	}
	
	public boolean suaND(DTO.NguoiDung nd) {
		
		if (!nd.getEmail().equals("")) {
			if (!nd.kiemTraHopLeEmail()) {
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
		                "Định dạng email không hợp lệ!",
		                "Thông báo!!!",
		                JOptionPane.WARNING_MESSAGE);
				return false;
			}
		}
		
		if (ndDAO.suaNV(nd))
			return true;
		
		return false;
	}
	
	public NguoiDung timKiemMa(String ma) {
		NguoiDung nd = new NguoiDung();
		int mand = 0;
		try {
			mand = Integer.parseInt(ma);
		} catch  (NumberFormatException exx){
			return null;
		}
		nd = ndDAO.timKiem(mand);
		return nd;
	}
	
	public ArrayList<DTO.NguoiDung> timKiemTK(String taiKhoan) {
		
		ArrayList<DTO.NguoiDung> dsnd = new ArrayList<DTO.NguoiDung>();
		dsnd = ndDAO.timKiem(taiKhoan.trim().replaceAll("\\s+", ""));
		
		return dsnd;
		
	}
	
	public ArrayList<DTO.NhanVien> dsNVHopLe() {
		
		ArrayList<DTO.NhanVien> dsnv = new ArrayList<DTO.NhanVien>();
		
		dsnv = ndDAO.dsNVHopLe();
		
		return dsnv;
	}
	
	public int dangNhap(String taiKhoan, String matKhau) {
		
		int manv = -1;
		
		manv = ndDAO.dangNhap(taiKhoan, matKhau);
		
		if (manv == -1) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Tài khoản hoặc mật khẩu không chính xác!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return -1;
		}
		
		return manv;
	}
	
	public boolean doiMK(DTO.NguoiDung nd) {
		
		if (ndDAO.doiMK(nd))
			return true;
		
		return false;
	}
	
	public boolean admin(int ma) {
		
		if (ndDAO.admin(ma))
			return true;
		
		return false;
	}
	
	public String matKhau(int ma) {
		
		String mk = "";

		mk = ndDAO.matKhau(ma);
		
		return mk;
	}
}



