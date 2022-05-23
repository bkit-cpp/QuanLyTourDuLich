package DTO;

public class NhaCungCap {
	private int maNCC;
	private String tenNCC;
	private long soDT;
	private String diachi;
	private String trangthai;
	public NhaCungCap(){
		
	}
	public NhaCungCap(int maNCC,String tenNCC,long soDT,String diachi,String trangthai){
		this.maNCC=maNCC;
		this.tenNCC=tenNCC;
		this.soDT=soDT;
		this.diachi=diachi;
		this.trangthai=trangthai;
	}
	public int getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setTenNCC(String tenNCC) {
		this.tenNCC = tenNCC;
	}
	public long getSoDT() {
		return soDT;
	}
	public void setSoDT(long soDT) {
		this.soDT = soDT;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}
	public String getTrangthai() {
		return trangthai;
	}
	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

}
