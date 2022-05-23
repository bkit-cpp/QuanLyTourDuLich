package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import GUI.TrangChinh;

public class NhaHang_Bus {
	private DAO.NhaHang nhahangDAO = new DAO.NhaHang();
	private static int maxmaNH = 1000;
	private ArrayList<DTO.NhaHang> nhList = new ArrayList<>();

	public NhaHang_Bus() {

	}

	public ArrayList<DTO.NhaHang> getNhList() {
		try {
			if (nhList.size() > 1)
				maxmaNH = nhList.get(nhList.size() - 1).getMaNH();
		} catch (Exception ex) {
			maxmaNH = 1000;
		}
		return nhList;
	}

	public void docDsNH() {
		nhList.clear();
		this.nhList = nhahangDAO.getDanhSachNH();

	}

	public String chuanHoa(String x) {
		if (x.length() >= 1) {
			x.trim().replaceAll("\\s+", " ").toLowerCase();
			String temp[] = x.split(" ");
			x = String.valueOf(temp[0].charAt(0)).toUpperCase() + temp[0].substring(1);
			for (int i = 1; i < temp.length; i++)
				x += " " + String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
		}
		return x;
	}

	public boolean themNH(DTO.NhaHang nh) {
		maxmaNH++;
		nh.setMaNH(maxmaNH);
		nh.setTenNH(chuanHoa(nh.getTenNH()));
		if (nh.getTenNH().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Tên nha hang không được để trống", "Thông báo!!!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (nh.getMaNCC() == 0) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "ma nha cung cap khong được để trống",
					"Thông báo!!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (nh.getGia() == 0) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "gia khong được để trống", "Thông báo!!!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (nhahangDAO.addNhaHang(nh))
			return true;

		return false;
	}

	public boolean suaNH(DTO.NhaHang nh) {
		nh.setTenNH(chuanHoa(nh.getTenNH()));
		if (nh.getTenNH().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Tên nha hang không được để trống", "Thông báo!!!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		else if (nh.getGia() == 0) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "gia khong được để trống", "Thông báo!!!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (nhahangDAO.suaNH(nh)) {

			return true;
		}

		return false;

	}

	public boolean xoaNH(DTO.NhaHang nh) {
		if (nhahangDAO.xoaNH(nh, nh.getMaNH()))
			return true;
		return false;
	}

	public DTO.NhaHang timKiemMa(String ma) {
		DTO.NhaHang nh = new DTO.NhaHang();
		int ma_nh = 0;
		try {
			ma_nh = Integer.parseInt(ma);
		} catch (NumberFormatException exx) {
			return null;
		}
		nh = nhahangDAO.timKiem(ma_nh);
		return nh;
	}

	public ArrayList<DTO.NhaHang> timKiemTen(String ten) {
		ArrayList<DTO.NhaHang> nhList = new ArrayList<>();
		nhList = nhahangDAO.timKiemTen(ten.trim().replaceAll("\\s+", " "));

		return nhList;
	}
}
