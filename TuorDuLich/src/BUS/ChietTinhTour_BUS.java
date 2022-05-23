package BUS;

import DAO.ChietTinhTour_DAO;

public class ChietTinhTour_BUS {
	private ChietTinhTour_DAO ctDAO = new ChietTinhTour_DAO();
	
	public ChietTinhTour_BUS() {
	}
	
	public boolean themCT(DTO.ChietTinhTour ct) {
		
		ct.setGhiChu(ct.getGhiChu().trim().replaceAll("\\s+", " "));

		if (ct.getMaKS() == -1) {
			ct.setMaKS(0);
			ct.setGiaKS(0);
		}
		
		if (ct.getMaNH() == -1) {
			ct.setMaNH(0);

			ct.setGiaNH(0);
		}
		
		if (ctDAO.themVaoDS(ct)) {
			return true;
		}
		
		return false;
	}
	
	public boolean updateTourSP(int ma) {
		
		if (ctDAO.updateTourSP(ma))
			return true;
		
		return false;
	}
	
	public boolean updateTourMoBan(int ma) {
		
		if (ctDAO.updateTourMoBan(ma))
			return true;
		
		return false;
	}
	
	public long tongGia(int ma) {
		long tongGia = 0;
		tongGia = ctDAO.tongGia(ma);
		
		return tongGia;
	}
}
