package DTO;

public class TourMoBan extends DichVu{
	private long giaDaiLy;
	private long giaKhachLe;
	private String ngayKhoiHanh;
	private int soCho;
	
	public TourMoBan() {
		super();
	}
	public TourMoBan(int maDV, String tenDV, String loaiDV, String thoiGian, String trangThai) {
	}
	
	public long getGiaDaiLy() {
		return giaDaiLy;
	}
	public void setGiaDaiLy(long giaDaiLy) {
		this.giaDaiLy = giaDaiLy;
	}
	public long getGiaKhachLe() {
		return giaKhachLe;
	}
	public void setGiaKhachLe(long giaKhachLe) {
		this.giaKhachLe = giaKhachLe;
	}
	public String getNgayKhoiHanh() {
		return ngayKhoiHanh;
	}
	public void setNgayKhoiHanh(String ngayKhoiHanh) {
		this.ngayKhoiHanh = ngayKhoiHanh;
	}
	public int getSoCho() {
		return soCho;
	}
	public void setSoCho(int soCho) {
		this.soCho = soCho;
	}
	
	
	
}
