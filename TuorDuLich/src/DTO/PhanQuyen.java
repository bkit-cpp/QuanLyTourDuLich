package DTO;

public class PhanQuyen {
	private int maQuyen;
	private int maNV;
	private String tenQuyen;
	
	public PhanQuyen() {}
	
	public PhanQuyen(int maQuyen, int maNV, String tenQuyen) {
		this.maQuyen = maQuyen;
		this.maNV = maNV;
		this.tenQuyen = tenQuyen;
	}

	public int getMaQuyen() {
		return maQuyen;
	}

	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public String getTenQuyen() {
		return tenQuyen;
	}

	public void setTenQuyen(String tenQuyen) {
		this.tenQuyen = tenQuyen;
	}
	
	
	
}
