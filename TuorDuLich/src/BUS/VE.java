package BUS;

import java.util.ArrayList;
import javax.swing.JOptionPane;

import DTO.KhachHangDTO;
import GUI.TrangChinh;

public class VE {
	DAO.VE vedao = new DAO.VE();

	public ArrayList<DTO.VE> getdsVE() {
		return vedao.getdsVE();
	}

	public boolean addVE(DTO.VE ve) {
		if (ve.getNGAYTAO().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Lỗi khi tạo vé", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		String ngaytao = ve.getNGAYTAO().trim().replaceAll("\\s+", " ");
		String temp[] = ngaytao.split("/");
		ngaytao = temp[2] + "/" + temp[1] + "/" + temp[0];
		ve.setNGAYTAO(ngaytao);

		if (ve.getGIA() == 0) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Lỗi khi tạo vé", "Thông báo",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (vedao.addVE(ve))
			return true;
		return false;
	}

	public boolean xoa(int ma) {
		if (vedao.xoaVE(ma)) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Xóa thành công!", "Thông báo!!!",
					JOptionPane.INFORMATION_MESSAGE);
			return true;
		}
		return false;
	}

	public ArrayList<DTO.VE> timKiem(String ma) {
		ArrayList<DTO.VE> dsve = new ArrayList<DTO.VE>();

		int maDV = 0;

		try {
			maDV = Integer.parseInt(ma);
		} catch (Exception s) {
			maDV = 0;
		}

		dsve = vedao.timKiem(maDV);

		return dsve;
	}
}