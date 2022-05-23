package DTO;

public class NhaHang {
	private int maNH;
	private String tenNH;
	private int maNCC;
	private long gia;
	public NhaHang(){
		
	}
	public NhaHang(int maNH,String tenNH,int maNCC,long gia){
		this.maNH=maNH;
		this.tenNH=tenNH;
		this.maNCC=maNCC;
		this.gia=gia;
	}
	public int getMaNH() {
		return maNH;
	}
	public void setMaNH(int maNH) {
		this.maNH = maNH;
	}
	public String getTenNH() {
		return tenNH;
	}
	public void setTenNH(String tenNH) {
		this.tenNH = tenNH;
	}
	public int getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	

}
