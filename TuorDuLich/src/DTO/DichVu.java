package DTO;

public class DichVu {
	private int maDV;
	private String tenDV;
	private String loaiDV;
	private String thoiGian;
	private String trangThai;
	
	public DichVu(int maDV, String tenDV, String loaiDV, String thoiGian, String trangThai) {
		super();
		this.maDV = maDV;
		this.tenDV = tenDV;
		this.loaiDV = loaiDV;
		this.thoiGian = thoiGian;
		this.trangThai = trangThai;
	}

	public DichVu() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getMaDV() {
		return maDV;
	}

	public void setMaDV(int maDV) {
		this.maDV = maDV;
	}

	public String getTenDV() {
		return tenDV;
	}

	public void setTenDV(String tenDV) {
		this.tenDV = tenDV;
	}

	public String getLoaiDV() {
		return loaiDV;
	}

	public void setLoaiDV(String loaiDV) {
		this.loaiDV = loaiDV;
	}

	public String getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(String thoiGian) {
		this.thoiGian = thoiGian;
	}

	public String getTrangThai() {
		return trangThai;
	}

	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	
}
