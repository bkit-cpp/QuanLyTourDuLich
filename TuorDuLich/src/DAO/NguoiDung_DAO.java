package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.NguoiDung;
import DTO.NhanVien;

public class NguoiDung_DAO {

	ConnectCSDL connect = new ConnectCSDL();
	Connection con;

	public ArrayList<DTO.NguoiDung> docDS() {
		String query = "select * from NGUOIDUNG";
		ArrayList<DTO.NguoiDung> dsnd = new ArrayList<DTO.NguoiDung>();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);

				try {
					while (rs.next()) {
						DTO.NguoiDung a = new DTO.NguoiDung();
						a.setMaNV(rs.getInt(1));
						a.setTaiKhoan(rs.getString(2));
						a.setMatKhau(rs.getString(3));
						a.setEmail(rs.getString(4));
						dsnd.add(a);
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

		return dsnd;

	}

	public boolean themVaoDS(NguoiDung nd) {

		boolean flag = false;

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prt = con.prepareStatement("insert into NGUOIDUNG values (?, ?, ?, ?)");
				prt.setInt(1, nd.getMaNV());
				prt.setString(2, nd.getTaiKhoan());
				prt.setString(3, nd.getMatKhau());
				prt.setString(4, nd.getEmail());
				try {
					if (prt.executeUpdate() >= 1)
						flag = true;
				} catch (Exception ec) {
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

	public boolean suaNV(NguoiDung nd) {

		boolean flag = false;

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				String query = "UPDATE NGUOIDUNG SET email = ? where manv = ?";
				PreparedStatement prt = con.prepareStatement(query);
				prt.setString(1, nd.getEmail());
				prt.setInt(2, nd.getMaNV());

				try {
					if (prt.executeUpdate() >= 0)
						flag = true;
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return flag;
	}

	public NguoiDung timKiem(int maND) {

		NguoiDung nd = new NguoiDung();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prep = con.prepareStatement("Select * from NGUOIDUNG where manv = ?");
				prep.setInt(1, maND);
				ResultSet rs = prep.executeQuery();

				try {
					if (rs.next()) {
						nd.setMaNV(rs.getInt(1));
						nd.setTaiKhoan(rs.getString(2));
						nd.setEmail(rs.getString(4));

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

		return nd;
	}

	public ArrayList<DTO.NguoiDung> timKiem(String taiKhoan) {

		ArrayList<DTO.NguoiDung> dsnd_1 = new ArrayList<DTO.NguoiDung>();
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select * from NGUOIDUNG where taikhoan like '%" + taiKhoan + "%'");

				try {
					while (rs.next()) {
						DTO.NguoiDung a = new DTO.NguoiDung();
						a.setMaNV(rs.getInt(1));
						a.setTaiKhoan(rs.getString(2));
						a.setEmail(rs.getString(4));
						dsnd_1.add(a);
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

		return dsnd_1;
	}

	public ArrayList<DTO.NhanVien> dsNVHopLe() {
		String query = "select * from NHANVIEN where manv not in (select NHANVIEN.MANV from NHANVIEN \r\n"
				+ "inner join NGUOIDUNG\r\n" + "on NHANVIEN.MANV = NGUOIDUNG.MANV)";
		ArrayList<DTO.NhanVien> dsnv = new ArrayList<DTO.NhanVien>();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);

				try {
					while (rs.next()) {
						DTO.NhanVien a = new DTO.NhanVien();
						a.setMaNV(rs.getInt("MANV"));
						a.setTenNV(rs.getString("TENNV"));
						a.setNgaySinh(rs.getString("NGAYSINH"));
						a.setDiaChi(rs.getString("DIACHI"));
						a.setGioiTinh(rs.getString("GIOITINH"));
						a.setChucVu(rs.getString("CHUCVU"));
						a.setTrangThai(rs.getString("TRANGTHAI"));
						a.setSdt(rs.getInt("SODT"));
						dsnv.add(a);
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

		return dsnv;
	}

	public int dangNhap(String taiKhoan, String matKhau) {

		int ma = -1;

		String query = "select * from NGUOIDUNG where taiKhoan = ? and matKhau = ?";

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prep = con.prepareStatement(query);
				prep.setString(1, taiKhoan);
				prep.setString(2, matKhau);

				ResultSet rs = prep.executeQuery();

				try {
					if (rs.next())
						ma = rs.getInt("MANV");
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return ma;
	}
	
	public String matKhau(int ma) {

		String mk = "";

		String query = "select matkhau from NGUOIDUNG where manv = ?";

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prep = con.prepareStatement(query);
				prep.setInt(1, ma);

				ResultSet rs = prep.executeQuery();

				try {
					if (rs.next())
						mk = rs.getString("MATKHAU");
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return mk;
	}

	public boolean doiMK(DTO.NguoiDung nd) {
		boolean flag = false;

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				String query = "UPDATE NGUOIDUNG SET matkhau = ? where manv = ?";
				PreparedStatement prt = con.prepareStatement(query);
				prt.setString(1, nd.getMatKhau());
				prt.setInt(2, nd.getMaNV());

				try {
					if (prt.executeUpdate() >= 0)
						flag = true;
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return flag;
	}

	public boolean admin(int ma) {
		boolean flag = false;

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				String query = "select * from NHANVIEN where manv = ? and chucvu = 'Admin'";
				PreparedStatement prt = con.prepareStatement(query);
				prt.setInt(1, ma);
				ResultSet rs = prt.executeQuery();
				try {
					if (rs.next())
						flag = true;
				} catch (SQLException e) {
					System.out.println("0k la");
					System.out.println(e);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return flag;
	}

	public boolean checkTK(String tk) {
		boolean flag = true;

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				String query = "select * from NGUOIDUNG where taikhoan = ?";
				PreparedStatement prt = con.prepareStatement(query);
				prt.setString(1, tk);
				ResultSet rs = prt.executeQuery();
				try {
					if (rs.next()) {
						flag = false;
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
		return flag;
	}
}
