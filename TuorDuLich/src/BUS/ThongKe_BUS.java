package BUS;

import java.util.ArrayList;
import java.util.Date;

import DAO.ThongKe_DAO;
import DTO.ThongKe;

public class ThongKe_BUS {
	private ThongKe_DAO tkDAO = new ThongKe_DAO();
	private ArrayList<DTO.ThongKe> dsTK = new ArrayList<DTO.ThongKe>();
	
	public ArrayList<ThongKe> dsTK() {
		ArrayList<DTO.ThongKe> dsTK = new ArrayList<DTO.ThongKe>();

		try {
			dsTK = tkDAO.thongKeThangNam();
		} catch (Exception df) {
			dsTK = null;
		}

		return dsTK;
	}

	public ArrayList<ThongKe> dsTK(Date date1, Date date2) {
		ArrayList<DTO.ThongKe> dsTK = new ArrayList<DTO.ThongKe>();

		try {
			dsTK = tkDAO.thongKeThangNam(date1, date2);
		} catch (Exception df) {
			dsTK = null;
		}

		return dsTK;
	}

	public long tkThang(Date date1, Date date2) {

		long gia = 0;
		try {
			gia = tkDAO.thongKeThang(date1, date2);
		} catch (Exception df) {
			gia = 0;
		}

		return gia;
	}

	public String tenDV(int ma) {

		String ten = "";
		try {
			ten = tkDAO.tenDV(ma);
		} catch (Exception df) {
			ten = "";
		}

		return ten;
	}

	public String tenDVSP(int ma) {

		String ten = "";
		try {
			ten = tkDAO.tenDVSP(ma);
		} catch (Exception df) {
			ten = "";
		}

		return ten;
	}

}
