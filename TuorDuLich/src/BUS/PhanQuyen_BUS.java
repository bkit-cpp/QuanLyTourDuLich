package BUS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.PhanQuyen_DAO;
import DTO.PhanQuyen;
import GUI.TrangChinh;

public class PhanQuyen_BUS {
	
	private PhanQuyen_DAO nvDAO = new PhanQuyen_DAO();
	private ArrayList<DTO.PhanQuyen> dsnv = new ArrayList<DTO.PhanQuyen>();
	private static int maNVMax = 110000;

	public PhanQuyen_BUS() {
	}

	public ArrayList<DTO.PhanQuyen> getDsnv() {
		try {
			if (dsnv.size() > 1)
				maNVMax = dsnv.get(dsnv.size() - 1).getMaQuyen();
		} catch (Exception ex) {
			maNVMax = 110000;
		}
		return dsnv;
	}

	public void docDsnv(int ma) {
		this.dsnv = nvDAO.timKiem(ma);
	}
	
	public boolean themNV(DTO.PhanQuyen nv) {
		maNVMax++;
		nv.setMaQuyen(maNVMax);
		if (nvDAO.themVaoDS(nv))
			return true;
		return false;
	}
	
	public boolean xoaQuyen(String ten, int ma) {
		if (nvDAO.xoaQuyen(ten, ma))
			return true;
		return false;
	}
	
	public DTO.PhanQuyen timKiem(int ma, String ten) {
		
		ArrayList<DTO.PhanQuyen> dsnv = new ArrayList<DTO.PhanQuyen>();

		dsnv = nvDAO.timKiem(ma, ten);
		if (dsnv.size() == 0)
			return null;
		
		return dsnv.get(0);
	}
	
	public boolean admin(int ma) {
		
		if (nvDAO.admin(ma))
			return true;
		
		return false;
	}
}



