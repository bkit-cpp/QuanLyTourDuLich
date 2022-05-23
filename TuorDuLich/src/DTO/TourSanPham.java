package DTO;

public class TourSanPham extends DichVu{
	private String loaiHinhTour;
	private int booking;
	
	public TourSanPham(int maDV, String tenDV, String loaiDV, String thoiGian, String trangThai, String loaiHinhTour,
			int booking) {
		super(maDV, tenDV, loaiDV, thoiGian, trangThai);
		this.loaiHinhTour = loaiHinhTour;
		this.booking = booking;
	}
	
	public TourSanPham() {
		super();
	}
	
	public TourSanPham(int maDV, String tenDV, String loaiDV, String thoiGian, String trangThai) {
		super(maDV, tenDV, loaiDV, thoiGian, trangThai);
	}

	public String getLoaiHinhTour() {
		return loaiHinhTour;
	}

	public void setLoaiHinhTour(String loaiHinhTour) {
		this.loaiHinhTour = loaiHinhTour;
	}

	public int getBooking() {
		return booking;
	}

	public void setBooking(int booking) {
		this.booking = booking;
	}
	
}
