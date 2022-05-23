package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DAO.TourSanPham_DAO;
import DTO.LoTrinh;
import GUI.TrangChinh;

public class TourSanPham_BUS {
		private TourSanPham_DAO tourDAO = new TourSanPham_DAO();
		private ArrayList<DTO.TourSanPham> dsTour = new ArrayList<DTO.TourSanPham>();
		private static int maTourMax;
		
		public static int getMaTourMax() {
			return maTourMax;
		}

		public static void setMaTourMax(int maNVMax) {
			TourSanPham_BUS.maTourMax = maNVMax;
		}
		
		public TourSanPham_BUS() {
		}

		public ArrayList<DTO.TourSanPham> getDsTour() {
			maTourMax = tourDAO.maxMaTourSanPham();
			return dsTour;
		}

		public void docDsTour() {
			this.dsTour = tourDAO.docDS();
		}
		
		public boolean themTour(DTO.TourSanPham tour) {
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
			
			if (tourDAO.xoaDV(x)) {
				return true;
			}
			
			return false;
		}
		
		public ArrayList<DTO.TourSanPham> timKiemTen(String ten) {
			
			ten = ten.trim().replaceAll("\\s+", " ");
			
			ArrayList<DTO.TourSanPham> dsTour = new ArrayList<DTO.TourSanPham>();
			dsTour = tourDAO.timKiem(ten);
			return dsTour;
		}
		
		public ArrayList<DTO.TourSanPham> timKiemLoai(String loaiHinh) {
			ArrayList<DTO.TourSanPham> dsTour = new ArrayList<DTO.TourSanPham>();
			dsTour = tourDAO.timKiemLoai(loaiHinh);
			return dsTour;
		}
		
		public ArrayList<DTO.TourSanPham> timKiemTrangThai(String trangThai) {
			ArrayList<DTO.TourSanPham> dsTour = new ArrayList<DTO.TourSanPham>();
			dsTour = tourDAO.timKiemTrangThai(trangThai);
			return dsTour;
		}
		
		public ArrayList<DTO.TourSanPham> timKiemLHVaTrangThai(String loaiHinh, String trangThai) {
			ArrayList<DTO.TourSanPham> dsTour = new ArrayList<DTO.TourSanPham>();
			dsTour = tourDAO.timKiemLHVaTrangThai(loaiHinh, trangThai);
			return dsTour;
		}
		
		public boolean themLT(LoTrinh lt) {
			
			int ma = tourDAO.maxMaTourSanPham() + 1;
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
		
		public boolean checkVe(int ma) {
			
			if (tourDAO.checkVe(ma)) {
				return true;
			}
			
			return false;
		}
}
