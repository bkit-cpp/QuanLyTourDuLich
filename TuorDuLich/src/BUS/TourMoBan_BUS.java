package BUS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.TourMoBan_DAO;
import DTO.LoTrinh;
import GUI.TrangChinh;

public class TourMoBan_BUS {
	private TourMoBan_DAO tourDAO = new TourMoBan_DAO();
	private ArrayList<DTO.TourMoBan> dsTour = new ArrayList<DTO.TourMoBan>();
	private static int maTourMax;
	
	public static int getMaNVMax() {
		return maTourMax;
	}

	public static void setMaNVMax(int maNVMax) {
		TourMoBan_BUS.maTourMax = maNVMax;
	}

	public TourMoBan_BUS() {
	}

	public ArrayList<DTO.TourMoBan> getDsTour() {
		maTourMax = tourDAO.maxMaTourMoBan();
		return dsTour;
	}

	public void docDsTour() {
		this.dsTour = tourDAO.docDS();
	}
	
	public boolean checkDay(String ds){
        Date pDob = null;
        SimpleDateFormat fm=new SimpleDateFormat("yyyy/MM/dd");
        try{
        	pDob=fm.parse(ds);
            return true;  
        }catch(ParseException ex1){
        	return false;
        }
	}
	
	public boolean themTour(DTO.TourMoBan tour) {
		maTourMax = maTourMax + 1;
		
		tour.setMaDV(maTourMax);
		
		if (!tour.getTenDV().equals(""))
			tour.setTenDV(tour.getTenDV().trim().replace("\\s+", " "));
		else {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Bạn chưa nhập tên dịch vụ tour!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		String ngaySinh = tour.getNgayKhoiHanh().trim().replaceAll("\\s+", " ");
		if (ngaySinh.equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Bạn chưa nhập ngày khởi hành(Định dạng dd/mm/yyy)",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		String temp[];
		try {
			temp = ngaySinh.split("/");
			ngaySinh = temp[2]+ "/" + temp [1]+ "/" + temp[0];
		} catch (Exception k) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Ngày khởi hành không hợp lệ (Định dạng dd/mm/yyy)",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		tour.setNgayKhoiHanh(ngaySinh);
		if (checkDay(tour.getNgayKhoiHanh()))
			tour.setNgayKhoiHanh(tour.getNgayKhoiHanh());
		else {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Ngày khởi hành không hợp lệ(Định dạng dd/mm/yyy)",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if (tourDAO.themVaoDS(tour)) {
			tourDAO.updateMaxMaTour(maTourMax);
			return true;
		}
		
		return false;
	}
	
	public boolean xoaTour(String ma) {
		int x;
		
		if (ma.equals(""))
			ma = "-1";
		
		try {
			x = Integer.parseInt(ma);
		} catch (NumberFormatException ex) {
			x = -1;
		} catch (Exception exx) {
			x = -1;
		}
		
		if (tourDAO.xoaDV(x))
			return true;
		
		return false;
	}
	
	public ArrayList<DTO.TourMoBan> timKiemLoai(String loaiHinh) {
		ArrayList<DTO.TourMoBan> dsTour = new ArrayList<DTO.TourMoBan>();
		dsTour = tourDAO.timKiemLH(loaiHinh);
		return dsTour;
	}
	
	public ArrayList<DTO.TourMoBan> timKiemTrangThai(String trangThai) {
		ArrayList<DTO.TourMoBan> dsTour = new ArrayList<DTO.TourMoBan>();
		dsTour = tourDAO.timKiemTrangThai(trangThai);
		return dsTour;
	}
	
	public ArrayList<DTO.TourMoBan> timKiemLHVaTrangThai(String loaiHinh, String trangThai) {
		ArrayList<DTO.TourMoBan> dsTour = new ArrayList<DTO.TourMoBan>();
		dsTour = tourDAO.timKiemLHVaTrangThai(loaiHinh, trangThai);
		return dsTour;
	}
	
	public ArrayList<DTO.TourMoBan> timKiemTen(String ten) {
		
		ten = ten.trim().replaceAll("\\s+", " ");
		
		ArrayList<DTO.TourMoBan> dsTour = new ArrayList<DTO.TourMoBan>();
		dsTour = tourDAO.timKiem(ten);
		return dsTour;
	}
	
	public boolean themLT(LoTrinh lt) {
		
		int ma = tourDAO.maxMaTourMoBan() + 1;
		lt.setmadvtour(ma);
		lt.setdiemden(lt.getdiemden().trim().replaceAll("\\s+", " "));
		lt.setdiemdon(lt.getdiemdon().trim().replaceAll("\\s+", " "));
		lt.setgiodi(lt.getgiodi().trim().replaceAll("\\s+", " "));
		lt.setgiove(lt.getgiove().trim().replaceAll("\\s+", " "));
		
		if (tourDAO.addLT(lt)) {
			tourDAO.updateMaxMaTour(ma);
			return true;
		}
		
		return false;
	}
	
	public ArrayList<DTO.LoTrinh> timKiemLT(int ma) {
		ArrayList<DTO.LoTrinh> dsLT = new ArrayList<DTO.LoTrinh>();
		dsLT = tourDAO.getLoTrinh(ma);
		return dsLT;
	}
	
	public DTO.NhaHang timKiemNH(int ma) {
		DTO.NhaHang dsNH = new DTO.NhaHang();
		dsNH = tourDAO.timKiemNH(ma);
		return dsNH;
	}
	
	public DTO.KhachSan timKiemKS(int ma) {
		DTO.KhachSan dsKS = new DTO.KhachSan();
		dsKS = tourDAO.timKiemKS(ma);
		return dsKS;
	}
	
	public ArrayList<DTO.ChietTinhTour> timKiemCT(int ma) {
		ArrayList<DTO.ChietTinhTour> dsLT = new ArrayList<DTO.ChietTinhTour>();
		dsLT = tourDAO.chietTinh(ma);
		return dsLT;
	}
}
