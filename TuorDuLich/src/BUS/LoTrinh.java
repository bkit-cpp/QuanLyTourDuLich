package BUS;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import DAO.Lotrinh;
import DTO.KhachHangDTO;
import GUI.TrangChinh;

public class LoTrinh {
	Lotrinh ltdao = new Lotrinh();

	public ArrayList<DTO.LoTrinh> getdsLoTrinh() {
		return ltdao.getdsLoTrinh();
	}

	public boolean addLT(DTO.LoTrinh lt) {
		if (lt.getgiodi().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Giờ đi không được để trống", "Thống báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (lt.getgiove().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Giờ về không được để trống", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (lt.getngaydi().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Ngày đi không được để trống", "Thống báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (lt.getngayve().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Ngày về không được để trống", "Thống báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (ltdao.addLT(lt))
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Thêm thành công");
		return false;

	}

	public boolean suaLT(DTO.LoTrinh lt) {
		if (lt.getgiodi().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Giờ đi không được để trống", "Thống báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (lt.getgiove().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Giờ về không được để trống", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (lt.getngaydi().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Ngày đi không được để trống", "Thống báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (lt.getngayve().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Ngày về không được để trống", "Thống báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}
		if (ltdao.suaLT(lt)) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Sửa thành công");
			return true;
		}
		return false;
	}
	
	public ArrayList<DTO.LoTrinh> timKiem(String ma) {
		ArrayList<DTO.LoTrinh> dsLT = new ArrayList<DTO.LoTrinh>();
		
		int maLT = 0;
		
		try {
			maLT = Integer.parseInt(ma);
		} catch (Exception s) {
			maLT = 0;
		}
		
		dsLT = ltdao.timKiem(maLT);
		
		return dsLT;
	}
}