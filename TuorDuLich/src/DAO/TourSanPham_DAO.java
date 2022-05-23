package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.TourMoBan;
import DTO.TourSanPham;

public class TourSanPham_DAO {
	ConnectCSDL connect = new ConnectCSDL();
	Connection con;

	public ArrayList<DTO.TourSanPham> docDS() {
		String query = "select * from TOURSANPHAM";
		ArrayList<DTO.TourSanPham> dstour = new ArrayList<DTO.TourSanPham>();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);

				try {
					while (rs.next()) {
						DTO.TourSanPham a = new DTO.TourSanPham();
						a.setMaDV(rs.getInt(1));
						a.setLoaiDV(rs.getString(2));
						a.setTenDV(rs.getString(3));
						a.setThoiGian(rs.getString(4));
						a.setTrangThai(rs.getString(5));
						a.setLoaiHinhTour(rs.getString(6));
						a.setBooking(rs.getInt(7));
						dstour.add(a);
					}
				} catch (SQLException sq) {
					System.out.println(sq);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				connect.closeConnection();
			}
		}
		return dstour;
	}

	public boolean themVaoDS(TourSanPham dvTour) {

		boolean flag = false;

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prt = con.prepareStatement("insert into TOURSANPHAM values (?, ?, ?, ?, ?, ?, ?)");
				prt.setInt(1, dvTour.getMaDV());
				prt.setString(2, dvTour.getLoaiDV());
				prt.setString(3, dvTour.getTenDV());
				prt.setString(4, dvTour.getThoiGian());
				prt.setString(5, dvTour.getTrangThai());
				prt.setString(6, dvTour.getLoaiHinhTour());
				prt.setInt(7, dvTour.getBooking());

				try {
					if (prt.executeUpdate() >= 0)
						flag = true;
				} catch (SQLException sq) {
					System.out.println(sq);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return flag;
	}

	public boolean xoaDV(int ma) {
		boolean flag = false;
		if (connect.connectDB()) {
			con = connect.getCon();

			try {

				PreparedStatement prep2 = con.prepareStatement("delete from LOTRINH where madvtour = ?");
				prep2.setInt(1, ma);
				try {
					if (prep2.executeUpdate() >= 0) {
						PreparedStatement prep1 = con.prepareStatement("delete from CHIETTINHTOUR where madvtour = ?");
						prep1.setInt(1, ma);
						try {
							if (prep1.executeUpdate() >= 0) {
								PreparedStatement prep = con
										.prepareStatement("delete from TourSanPham where madvtour = ?");
								prep.setInt(1, ma);

								try {
									if (prep.executeUpdate() >= 0)
										flag = true;
								} catch (SQLException ex) {
									System.out.println("Xóa tour sản phẩm bị lỗi!");
								}
							}
						} catch (SQLException exx) {
							System.out.println("Xóa chiết tính tour bị lỗi!");
						}
					}
				} catch (SQLException exx) {
					System.out.println("Xóa lộ trình tour bị lỗi!");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return flag;

	}

	public ArrayList<DTO.TourSanPham> timKiem(String ten) {

		ArrayList<DTO.TourSanPham> dsTour = new ArrayList<DTO.TourSanPham>();
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				int x;
				try {
					x = Integer.parseInt(ten);
				} catch (NumberFormatException ex) {
					x = 0;
				} catch (Exception xs) {
					x = 0;
				}
				PreparedStatement prep = con
						.prepareStatement("select * from TourSanPham where madvtour = ? or tendvtour like ?");
				prep.setInt(1, x);
				prep.setString(2, "%" + ten + "%");

				ResultSet rs = prep.executeQuery();

				try {
					while (rs.next()) {
						DTO.TourSanPham a = new DTO.TourSanPham();
						a.setMaDV(rs.getInt(1));
						a.setLoaiDV(rs.getString(2));
						a.setTenDV(rs.getString(3));
						a.setThoiGian(rs.getString(4));
						a.setTrangThai(rs.getString(5));
						a.setLoaiHinhTour(rs.getString(6));
						a.setBooking(rs.getInt(7));
						dsTour.add(a);
					}
				} catch (SQLException sq) {
					System.out.println(sq);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}

		return dsTour;
	}

	public ArrayList<DTO.TourSanPham> timKiemLoai(String ten) {

		ArrayList<DTO.TourSanPham> dsTour = new ArrayList<DTO.TourSanPham>();
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prep = con.prepareStatement("select * from TourSanPham where loaitour = ?");
				prep.setString(1, ten);

				ResultSet rs = prep.executeQuery();

				try {
					while (rs.next()) {
						DTO.TourSanPham a = new DTO.TourSanPham();
						a.setMaDV(rs.getInt(1));
						a.setLoaiDV(rs.getString(2));
						a.setTenDV(rs.getString(3));
						a.setThoiGian(rs.getString(4));
						a.setTrangThai(rs.getString(5));
						a.setLoaiHinhTour(rs.getString(6));
						a.setBooking(rs.getInt(7));
						dsTour.add(a);
					}
				} catch (SQLException sq) {
					System.out.println(sq);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}

		return dsTour;
	}

	public ArrayList<DTO.TourSanPham> timKiemTrangThai(String ten) {

		ArrayList<DTO.TourSanPham> dsTour = new ArrayList<DTO.TourSanPham>();
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prep = con.prepareStatement("select * from TourSanPham where trangthai = ?");
				prep.setString(1, ten);

				ResultSet rs = prep.executeQuery();

				try {
					while (rs.next()) {
						DTO.TourSanPham a = new DTO.TourSanPham();
						a.setMaDV(rs.getInt(1));
						a.setLoaiDV(rs.getString(2));
						a.setTenDV(rs.getString(3));
						a.setThoiGian(rs.getString(4));
						a.setTrangThai(rs.getString(5));
						a.setLoaiHinhTour(rs.getString(6));
						a.setBooking(rs.getInt(7));
						dsTour.add(a);
					}
				} catch (SQLException sq) {
					System.out.println(sq);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}

		return dsTour;
	}

	public ArrayList<DTO.TourSanPham> timKiemLHVaTrangThai(String ten, String tt) {

		ArrayList<DTO.TourSanPham> dsTour = new ArrayList<DTO.TourSanPham>();
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prep = con
						.prepareStatement("select * from TourSanPham where loaitour = ? and trangthai = ?");
				prep.setString(1, ten);
				prep.setString(2, tt);

				ResultSet rs = prep.executeQuery();

				try {
					while (rs.next()) {
						DTO.TourSanPham a = new DTO.TourSanPham();
						a.setMaDV(rs.getInt(1));
						a.setLoaiDV(rs.getString(2));
						a.setTenDV(rs.getString(3));
						a.setThoiGian(rs.getString(4));
						a.setTrangThai(rs.getString(5));
						a.setLoaiHinhTour(rs.getString(6));
						a.setBooking(rs.getInt(7));

						dsTour.add(a);
					}
				} catch (SQLException sq) {
					System.out.println(sq);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}

		return dsTour;
	}

	public int maxMaLoTrinh() {
		String url = "select malt from maxma";
		int ma = 0;
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement ps = con.prepareStatement(url);

				ResultSet rs = ps.executeQuery();
				try {
					if (rs.next()) {
						ma = rs.getInt(1);
					}
				} catch (SQLException ok) {
					System.out.println(ok);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return ma;
	}

	public int maxMaTourSanPham() {
		String url = "select matoursanpham from maxma";
		int ma = 0;
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement ps = con.prepareStatement(url);

				ResultSet rs = ps.executeQuery();

				try {
					if (rs.next()) {
						ma = rs.getInt(1);
					}
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return ma;
	}

	public boolean addLT(DTO.LoTrinh lt) {
		String url = "insert into LOTRINH values(?,?,?,?,?,?,?)";
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, lt.getMADVTOUR());
				ps.setString(2, lt.getgiodi());
				ps.setString(3, lt.getngaydi());
				ps.setString(4, lt.getgiove());
				ps.setString(5, lt.getngayve());
				ps.setString(6, lt.getdiemdon());
				ps.setString(7, lt.getdiemden());
				ps.executeUpdate();
				connect.closeConnection();
				return true;

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}

		return false;
	}

	public boolean updateMaxMaTour(int ma) {
		String url = "UPDATE MAXMA SET matoursanpham = ? where ma = 1";
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, ma);
				ps.executeUpdate();
				connect.closeConnection();
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return false;
	}

	public ArrayList<DTO.LoTrinh> getLoTrinh(int ma) {
		String url = "select * from LOTRINH where madvtour = ?";
		ArrayList<DTO.LoTrinh> dsLT = new ArrayList<DTO.LoTrinh>();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, ma);
				ResultSet rs = ps.executeQuery();

				try {
					if (rs.next()) {
						DTO.LoTrinh lt = new DTO.LoTrinh();
						lt.setmadvtour(rs.getInt("MADVTOUR"));
						lt.setgiodi(rs.getNString("GIODI"));
						lt.setngaydi(rs.getString("NGAYDI"));
						lt.setgiove(rs.getString("GIOVE"));
						lt.setngayve(rs.getString("NGAYVE"));
						lt.setdiemdon(rs.getString("DIEMDON"));
						lt.setdiemden(rs.getString("DIEMDEN"));
						dsLT.add(lt);
					}
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return dsLT;
	}

	public DTO.NhaHang timKiemNH(int maNH) {

		DTO.NhaHang nhDTO = new DTO.NhaHang();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prep = con.prepareStatement("Select * from NHAHANG where MANH = ?");
				prep.setInt(1, maNH);
				ResultSet rs = prep.executeQuery();

				try {
					if (rs.next()) {
						nhDTO.setMaNH(maNH);
						nhDTO.setTenNH(rs.getString(2));
						nhDTO.setMaNCC(Integer.parseInt(rs.getString(3)));
						nhDTO.setGia(Integer.parseInt(rs.getString(4)));
					}
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return nhDTO;
	}

	public DTO.KhachSan timKiemKS(int maKS) {

		DTO.KhachSan ksDTO = new DTO.KhachSan();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prep = con.prepareStatement("Select * from KHACHSAN where MAKS = ?");
				prep.setInt(1, maKS);
				ResultSet rs = prep.executeQuery();

				try {
					if (rs.next()) {
						ksDTO.setMaKS(maKS);
						ksDTO.setLoaihinhKS(rs.getString(2));
						ksDTO.setTenKS(rs.getString(3));
						ksDTO.setMaNCC(Integer.parseInt(rs.getString(4)));
						ksDTO.setLoaiphong(rs.getString(5));
						ksDTO.setGia(Integer.parseInt(rs.getString(6)));

					}
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}

		return ksDTO;
	}

	public ArrayList<DTO.ChietTinhTour> chietTinh(int ma) {

		String query = "select * from CHIETTINHTOUR where madvtour = " + ma + "";
		ArrayList<DTO.ChietTinhTour> dsChietTinh = new ArrayList<DTO.ChietTinhTour>();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);

				try {
					while (rs.next()) {
						DTO.ChietTinhTour a = new DTO.ChietTinhTour();

						a.setGhiChu(rs.getString("GHICHU"));
						a.setGiaDV(rs.getLong("GIADVTOUR"));
						a.setGiaKS(rs.getLong("GIAKS"));
						a.setGiaNH(rs.getLong("GIANH"));
						a.setMaDVTour(rs.getInt("MADVTOUR"));
						a.setMaKS(rs.getInt("MAKS"));
						a.setMaLT(rs.getInt("MALOTRINH"));
						a.setMaNH(rs.getInt("MANH"));
						a.setMaNV(rs.getInt("MANH"));

						dsChietTinh.add(a);
					}
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				connect.closeConnection();
			}
		}
		return dsChietTinh;
	}
	
	public boolean checkVe(int ma) {
		String url = "select mave from ve where madvtour = ?";
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, ma);
				ResultSet rs = ps.executeQuery();
				try {
					if (rs.next()) {
						connect.closeConnection();
						return true;
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return false;
	}
}
