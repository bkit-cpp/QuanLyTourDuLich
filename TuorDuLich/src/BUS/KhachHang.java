package BUS;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAO.KhachHangDAO;
import DTO.KhachHangDTO;
import GUI.TrangChinh;

public class KhachHang {
	KhachHangDAO khdao = new KhachHangDAO();

	public ArrayList<KhachHangDTO> getdsKhachHang() {
		return khdao.getdsKhachHang();
	}

	public boolean addKH(DTO.KhachHangDTO kh) {
		
		if (kh.gettenKH().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Tên khách hàng không được để trống", "Thống báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			kh.settenKH(kh.gettenKH().trim().replaceAll("\\s+", " "));
		}
		
		if (kh.getDiaChi().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Địa chỉ không được để trổng", "Thônng báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if (kh.getSDT() == 0) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "SDT không được để trống", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (kh.getSDT() == -1) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Vui lòng nhập số", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		String ngaySinh = kh.getNgaySinh().trim().replaceAll("\\s+", " ");
		String temp[] = ngaySinh.split("/");
		if (temp.length == 3) {
			ngaySinh = temp[2]+ "/" + temp [1]+ "/" + temp[0];
		} else {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Ngày tháng năm không hợp lệ (Định dạn dd/mm/yyy)!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		kh.setNgaySinh(ngaySinh);
		
		if (khdao.addKH(kh)) {
			JOptionPane.showMessageDialog(null, "Thêm thành công!");
			return true;
		}
		return false;

	}

	public boolean suaKH(DTO.KhachHangDTO kh) {
		if (kh.gettenKH().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Tên khách hàng không được để trống", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else {
			kh.settenKH(kh.gettenKH().trim().replaceAll("\\s+", " "));
		}
		
		if (kh.getDiaChi().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Địa chỉ không được để trống", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (kh.getSDT() == 0) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "SDT không được để trống", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (kh.getSDT() == -1) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Vui lòng nhập số", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		String ngaySinh = kh.getNgaySinh().trim().replaceAll("\\s+", " ");
		String temp[] = ngaySinh.split("/");
		if (temp.length == 3) {
			ngaySinh = temp[2]+ "/" + temp [1]+ "/" + temp[0];
			kh.setNgaySinh(ngaySinh);
		} else {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Ngày tháng năm không hợp lệ (Định dạn dd/mm/yyy)!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if (khdao.suaKH(kh)) {
			JOptionPane.showMessageDialog(null, "Sửa thành công");
			return true;
		}
		return false;
	}
	
	public boolean xoa(int ma) {
		if (khdao.xoaKH(ma)) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Xóa thành công!",
	                "Thông báo!!!",
	                JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		return false;
	}
	
	public ArrayList<KhachHangDTO> timKiem(String ma) {
		ArrayList<DTO.KhachHangDTO> dskh = new ArrayList<DTO.KhachHangDTO>();

		
		int maKH = 0;
		
		try {
			maKH = Integer.parseInt(ma);
		} catch (Exception s) {
			maKH = 0;
		}
		
		dskh = khdao.timKiemMa(maKH);
		
		return dskh;
	}
}