package DTO;

public class KhachSan {
	private int maKS;
	private String tenKS;
	private String loaihinhKS;
	private int maNCC;
	private String loaiphong;
	private long gia;
	public KhachSan(){
		
	}
	public KhachSan(int maKS,String tenKS,String loaihinhKS,int maNCC,String loaiphong,long gia){
		this.maKS=maKS;
		this.tenKS=tenKS;
		this.loaihinhKS=loaihinhKS;
		this.maNCC=maNCC;
		this.loaiphong=loaiphong;
		this.gia=gia;
	}
	public int getMaKS() {
		return maKS;
	}
	public void setMaKS(int maKS) {
		this.maKS = maKS;
	}
	public String getTenKS() {
		return tenKS;
	}
	public void setTenKS(String tenKS) {
		this.tenKS = tenKS;
	}
	public String getLoaihinhKS() {
		return loaihinhKS;
	}
	public void setLoaihinhKS(String loaihinhKS) {
		this.loaihinhKS = loaihinhKS;
	}
	public int getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(int maNCC) {
		this.maNCC = maNCC;
	}
	public String getLoaiphong() {
		return loaiphong;
	}
	public void setLoaiphong(String loaiphong) {
		this.loaiphong = loaiphong;
	}
	public long getGia() {
		return gia;
	}
	public void setGia(long gia) {
		this.gia = gia;
	}
	
}
