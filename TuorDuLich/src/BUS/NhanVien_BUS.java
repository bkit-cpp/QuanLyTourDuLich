package BUS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DAO.NhanVien_DAO;
import DTO.NhanVien;
import GUI.TrangChinh;

public class NhanVien_BUS {
	
	private NhanVien_DAO nvDAO = new NhanVien_DAO();
	private ArrayList<DTO.NhanVien> dsnv = new ArrayList<DTO.NhanVien>();
	private NguoiDung_BUS ndBUS = new NguoiDung_BUS();
	private static int maNVMax = 2000;
	private int maNVDN = 0;
	
	public static int getMaNVMax() {
		return maNVMax;
	}

	public static void setMaNVMax(int maNVMax) {
		NhanVien_BUS.maNVMax = maNVMax;
	}

	public NhanVien_BUS() {
	}

	public int getMaNVDN() {
		getDsnv();
		return maNVDN;
	}



	public void setMaNVDN(int maNVDN) {
		this.maNVDN = maNVDN;
	}

	public ArrayList<DTO.NhanVien> getDsnv() {
		docDsnv();
		try {
			if (dsnv.size() > 1)
				maNVMax = dsnv.get(dsnv.size() - 1).getMaNV();
		} catch (Exception ex) {
			maNVMax = 2000;
		}
		return dsnv;
	}

	public void docDsnv() {
		this.dsnv = nvDAO.docDS();
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
	
	public boolean themNV(DTO.NhanVien nv) {
		maNVMax++;
		nv.setMaNV(maNVMax);
		nv.setTenNV(chuanHoa(nv.getTenNV()));
		if (nv.getTenNV().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Tên nhân viên không được để trống",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		nv.setChucVu(nv.getChucVu().trim().replaceAll("\\s+", " "));
		nv.setDiaChi(nv.getDiaChi().trim().replaceAll("\\s+", " "));
		
		nv.setSdt(nv.getSdt());
		if (nv.getSdt() == 0) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Số điện thoại không được để trống",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (nv.getSdt() == -1) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Chỉ được nhập số",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		} 
		
		nv.setTrangThai(nv.getTrangThai());
		nv.setGioiTinh(nv.getGioiTinh());
		String ngaySinh = nv.getNgaySinh().trim().replaceAll("\\s+", " ");
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
		
		if (nv.getChucVu().toLowerCase().equals("admin") && !ndBUS.admin(maNVDN)) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Chỉ có admin mới được thêm nhân viên là admin!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
			
		
		nv.setNgaySinh(ngaySinh);
		if (!checkDay(nv.getNgaySinh())) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Ngày tháng năm không hợp lệ(Định dạn dd/mm/yyy)!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if (nvDAO.themVaoDS(nv))
			return true;
		
		return false;
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
	
	public boolean suaNV(DTO.NhanVien nv) {
		nv.setTenNV(chuanHoa(nv.getTenNV()));
		if (nv.getTenNV().equals("")) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Tên nhân viên không được để trống",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		nv.setChucVu(nv.getChucVu().trim().replaceAll("\\s+", " "));
		nv.setDiaChi(nv.getDiaChi().trim().replaceAll("\\s+", " "));
		
		nv.setSdt(nv.getSdt());
		if (nv.getSdt() == 0) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Số điện thoại không được để trống",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		} else if (nv.getSdt() == -1) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Chỉ được nhập số",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		nv.setTrangThai(nv.getTrangThai());
		nv.setGioiTinh(nv.getGioiTinh());
		String ngaySinh = nv.getNgaySinh().trim().replaceAll("\\s+", " ");
		String temp[] = ngaySinh.split("/");
		ngaySinh = temp[2]+ "/" + temp [1]+ "/" + temp[0];
		nv.setNgaySinh(ngaySinh);
		if (!checkDay(nv.getNgaySinh())) {
			JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
	                "Ngày tháng năm không hợp lệ(Định dạn dd/mm/yyy)!",
	                "Thông báo!!!",
	                JOptionPane.WARNING_MESSAGE);
			return false;
		}
		
		if (nvDAO.suaNV(nv))
			return true;
		
		return false;
	}
	
	public NhanVien timKiemMa(String ma) {
		NhanVien nv = new NhanVien();
		int manv = 0;
		try {
			manv = Integer.parseInt(ma);
		} catch  (NumberFormatException exx){
			return null;
		}
		nv = nvDAO.timKiem(manv);
		return nv;
	}
	
	public ArrayList<DTO.NhanVien> timKiemTen(String ten) {
		ArrayList<DTO.NhanVien> dsnv = new ArrayList<DTO.NhanVien>();
		dsnv = nvDAO.timKiem(ten.trim().replaceAll("\\s+", " "));
		
		return dsnv;
		
	}
}



