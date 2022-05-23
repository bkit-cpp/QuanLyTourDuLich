package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import GUI.TrangChinh;

public class KhachSan_BUS {
	private DAO.KhachSan khaschsanDAO = new DAO.KhachSan();
	private static int maxmaKS = 4000;
	private ArrayList<DTO.KhachSan> ksList = new ArrayList<>();

	public KhachSan_BUS() {

	}

	public ArrayList<DTO.KhachSan> getKSList() {
		try {
			if (ksList.size() > 1)
				maxmaKS = ksList.get(ksList.size() - 1).getMaKS();
		} catch (Exception ex) {
			maxmaKS = 4000;
		}
		return ksList;
	}

	public void docDsKS() {
		ksList.clear();
		this.ksList = khaschsanDAO.getDanhSachKS();

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

	public boolean themKS(DTO.KhachSan ks) {
		maxmaKS++;
		ks.setMaKS(maxmaKS);
		ks.setTenKS(chuanHoa(ks.getTenKS()));
		if (ks.getTenKS().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Tên khach san không được để trống",
					"Thông báo!!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (ks.getMaNCC() == 0) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "ma nha cung cap khong được để trống",
					"Thông báo!!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (ks.getGia() == 0) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "gia khong được để trống", "Thông báo!!!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (khaschsanDAO.addKhachSan(ks))
			return true;

		return false;
	}

	public boolean xoaKS(DTO.KhachSan ks) {
		if (khaschsanDAO.xoaKS(ks, ks.getMaKS()))
			return true;
		return false;
	}

	public boolean suaKS(DTO.KhachSan ks) {
		ks.setTenKS(chuanHoa(ks.getTenKS()));
		if (ks.getTenKS().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Tên khach san không được để trống",
					"Thông báo!!!", JOptionPane.WARNING_MESSAGE);
			return false;
		}

		else if (ks.getGia() == 0) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "gia khong được để trống", "Thông báo!!!",
					JOptionPane.WARNING_MESSAGE);
			return false;
		}

		if (khaschsanDAO.suaKS(ks)) {

			return true;
		}

		return false;

	}

	public DTO.KhachSan timKiemMa(String ma) {
		DTO.KhachSan ks = new DTO.KhachSan();
		int ma_ks = 0;
		try {
			ma_ks = Integer.parseInt(ma);
		} catch (NumberFormatException exx) {
			return null;
		}
		ks = khaschsanDAO.timKiem(ma_ks);
		return ks;
	}

	public ArrayList<DTO.KhachSan> timKiemTen(String ten) {
		ArrayList<DTO.KhachSan> ksList = new ArrayList<>();
		ksList = khaschsanDAO.timKiem(ten.trim().replaceAll("\\s+", " "));

		return ksList;

	}
}
