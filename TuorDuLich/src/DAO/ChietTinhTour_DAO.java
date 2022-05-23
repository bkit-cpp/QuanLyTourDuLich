package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.ChietTinhTour;
import DTO.NhanVien;

public class ChietTinhTour_DAO {

	ConnectCSDL connect = new ConnectCSDL();
	Connection con;

	public boolean themVaoDS(ChietTinhTour ctTour) {
		boolean flag = false;

		if (connect.connectDB()) {
			con = connect.getCon();

			try {

				PreparedStatement prt = con
						.prepareStatement("insert into CHIETTINHTOUR values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
				prt.setInt(1, ctTour.getMaDVTour());
				prt.setInt(2, ctTour.getMaKS());
				prt.setInt(3, ctTour.getMaNH());
				prt.setInt(4, ctTour.getMaLT());
				prt.setLong(5, ctTour.getGiaKS());
				prt.setLong(6, ctTour.getGiaNH());
				prt.setLong(7, ctTour.getGiaDV());
				prt.setString(8, ctTour.getGhiChu());
				prt.setInt(9, ctTour.getMaNV());

				xoaCT(ctTour.getMaDVTour());

				try {
					if (prt.executeUpdate() >= 0)
						flag = true;
				} catch (SQLException e) {
					System.out.println(e);
					flag = false;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return flag;
	}

	public boolean xoaCT(int ma) {
		boolean flag = false;
		if (connect.connectDB()) {
			con = connect.getCon();

			try {

				PreparedStatement prep2 = con.prepareStatement("delete from CHIETTINHTOUR where madvtour = ?");
				prep2.setInt(1, ma);
				try {
					if (prep2.executeUpdate() >= 0) {
						flag = true;
					}
				} catch (SQLException exx) {
					System.out.println("Xóa chiết tính tour bị lỗi!");
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} 
		}
		return flag;

	}

	public ArrayList<DTO.LoTrinh> getdsLoTrinh(int ma) {
		String url = "select * from LOTRINH where MADVTOUR = " + ma + "";
		ArrayList<DTO.LoTrinh> dsLT = new ArrayList<DTO.LoTrinh>();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement ps = con.prepareStatement(url);

				ResultSet rs = ps.executeQuery();
				try {
					while (rs.next()) {
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
				} catch (SQLException es) {
					System.out.println(es);
				}

			} catch (SQLException e) {
				e.printStackTrace();
				return null;
			} finally {
				connect.closeConnection();
			}
		}

		return dsLT;
	}

	public ArrayList<DTO.NhaHang> getDanhSachNH() {
		ArrayList<DTO.NhaHang> dsNH = new ArrayList<DTO.NhaHang>();
		if (connect.connectDB()) {
			con = connect.getCon();

			String url = "select * from NHAHANG";
			try {
				PreparedStatement ps = con.prepareStatement(url);

				ResultSet rs = ps.executeQuery();

				try {
					while (rs.next()) {
						DTO.NhaHang nh = new DTO.NhaHang();
						nh.setMaNH(rs.getInt("MANH"));
						nh.setTenNH(rs.getString("TENNH"));
						nh.setGia(rs.getLong("GIA"));
						nh.setMaNCC(rs.getInt("MANCC"));
						dsNH.add(nh);

					}
				} catch (SQLException es) {
					System.out.println(es);
				}

			} catch (Exception e) {
				System.out.print(e);
				;
			} finally {
				connect.closeConnection();
			}
		}
		return dsNH;
	}

	public ArrayList<DTO.KhachSan> getDanhSachKS() {
		ArrayList<DTO.KhachSan> dsKS = new ArrayList<DTO.KhachSan>();
		if (connect.connectDB()) {
			con = connect.getCon();

			String url = "select * from KHACHSAN";
			try {
				PreparedStatement ps = con.prepareStatement(url);

				ResultSet rs = ps.executeQuery();

				try {
					while (rs.next()) {
						DTO.KhachSan ks = new DTO.KhachSan();
						ks.setMaKS(rs.getInt("MAKS"));
						ks.setLoaihinhKS(rs.getString("LOAIHINHKS"));
						ks.setTenKS(rs.getString("TENKS"));
						ks.setLoaiphong(rs.getString("LOAIPHONG"));
						ks.setGia(rs.getLong("GIA"));
						ks.setMaNCC(rs.getInt("MANCC"));
						dsKS.add(ks);

					}
				} catch (SQLException es) {
					System.out.println(es);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
			return dsKS;
		}
		return null;
	}

	public DTO.NhaHang timKiem(int maNH) {

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
				} catch (SQLException es) {
					System.out.println(es);
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
				} catch (SQLException es) {
					System.out.println(es);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}

		return ksDTO;
	}

	public long getGiaLT(int ma) {
		if (connect.connectDB()) {
			con = connect.getCon();

			String url = "select sum(giadvtour) from chiettinhtour where madvtour = " + ma + "";
			try {
				PreparedStatement ps = con.prepareStatement(url);

				ResultSet rs = ps.executeQuery();

				try {
					if (rs.next()) {
						long a = rs.getLong(1);
						connect.closeConnection();
						return a;
					}
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (SQLException es) {
				System.out.print(es);
			} finally {
				connect.closeConnection();
			}
		}
		return 0;
	}

	public boolean updateTourSP(int ma) {
		String url = "UPDATE TOURSANPHAM SET trangthai = N'Đã chiết tính' where madvtour = ?";
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
	
	public boolean updateTourMoBan(int ma) {
		String url = "UPDATE TOURMOBAN SET trangthai = N'Đã chiết tính' where madvtour = ?";
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
	
	public long tongGia(int ma) {
		if (connect.connectDB()) {
			con = connect.getCon();

			String url = "select (giaks + gianh + giadvtour) from chiettinhtour where madvtour = " + ma + "";
			try {
				PreparedStatement ps = con.prepareStatement(url);

				ResultSet rs = ps.executeQuery();

				try {
					if (rs.next()) {
						long a = rs.getLong(1);
						connect.closeConnection();
						return a;
					}
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (SQLException es) {
				System.out.print(es);
			} finally {
				connect.closeConnection();
			}
		}
		return 0;
	}
}
