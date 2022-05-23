package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.NhanVien;

public class NhanVien_DAO {
	
	ConnectCSDL connect = new ConnectCSDL();
	Connection con;

	public ArrayList<DTO.NhanVien> docDS() {
		String query = "select * from NHANVIEN";
		ArrayList<DTO.NhanVien> dsnv = new ArrayList<DTO.NhanVien>();

		if (connect.connectDB()) {
			con = connect.getCon();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				while (rs.next()) {
					DTO.NhanVien a = new DTO.NhanVien();
					a.setMaNV(rs.getInt("MANV"));
					a.setTenNV(rs.getString("TENNV"));

					String ngaySinh = rs.getString("NGAYSINH");
					String temp[] = ngaySinh.split("-");
					ngaySinh = temp[2] + "/" + temp[1] + "/" + temp[0];
					a.setNgaySinh(ngaySinh);

					a.setDiaChi(rs.getString("DIACHI"));
					a.setGioiTinh(rs.getString("GIOITINH"));
					a.setChucVu(rs.getString("CHUCVU"));
					a.setTrangThai(rs.getString("TRANGTHAI"));
					a.setSdt(rs.getInt("SODT"));
					dsnv.add(a);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}

		return dsnv;

	}

	public boolean themVaoDS(NhanVien nv) {

		boolean flag = false;

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prt = con.prepareStatement("insert into NHANVIEN values (?, ?, ?, ?, ?, ?, ?, ?)");
				prt.setInt(1, nv.getMaNV());
				prt.setString(2, nv.getTenNV());
				prt.setString(3, nv.getNgaySinh());
				prt.setString(4, nv.getGioiTinh());
				prt.setLong(5, nv.getSdt());
				prt.setString(6, nv.getDiaChi());
				prt.setString(7, nv.getTrangThai());
				prt.setString(8, nv.getChucVu());

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

	public boolean suaNV(NhanVien nv) {

		boolean flag = false;

		if (connect.connectDB()) {
			con = connect.getCon();
			try {
				String query = "UPDATE NHANVIEN SET tennv = ?, ngaysinh = ?, gioitinh = ?, sodt = ?, diachi = ?, trangthai = ?, chucvu = ? where manv = ?";
				PreparedStatement prt = con.prepareStatement(query);
				prt.setString(1, nv.getTenNV());
				prt.setString(2, nv.getNgaySinh());
				prt.setString(3, nv.getGioiTinh());
				prt.setLong(4, nv.getSdt());
				prt.setString(5, nv.getDiaChi());
				prt.setString(6, nv.getTrangThai());
				prt.setString(7, nv.getChucVu());
				prt.setInt(8, nv.getMaNV());

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

	public NhanVien timKiem(int maNV) {

		NhanVien nv = new NhanVien();

		if (connect.connectDB()) {
			con = connect.getCon();
			try {
				PreparedStatement prep = con.prepareStatement("Select * from NHANVIEN where manv = ?");
				prep.setInt(1, maNV);
				ResultSet rs = prep.executeQuery();
				if (rs.next()) {
					nv.setMaNV(maNV);
					nv.setTenNV(rs.getString(2));

					String ngaySinh = rs.getString(3);
					String temp[] = ngaySinh.split("-");
					ngaySinh = temp[2] + "/" + temp[1] + "/" + temp[0];
					nv.setNgaySinh(ngaySinh);

					nv.setGioiTinh(rs.getString(4));
					nv.setSdt((int) rs.getInt(5));
					nv.setDiaChi(rs.getString(6));
					nv.setTrangThai(rs.getString(7));
					nv.setChucVu(rs.getString(8));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();			}
		}

		return nv;
	}

	public ArrayList<DTO.NhanVien> timKiem(String tenNV) {

		ArrayList<DTO.NhanVien> dsnv_1 = new ArrayList<DTO.NhanVien>();
		if (connect.connectDB()) {
			con = connect.getCon();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select * from NHANVIEN where tennv like N'%" + tenNV + "%'");

				while (rs.next()) {
					DTO.NhanVien a = new DTO.NhanVien();
					a.setMaNV(rs.getInt("MANV"));
					a.setTenNV(rs.getString("TENNV"));

					String ngaySinh = rs.getString("NGAYSINH");
					String temp[] = ngaySinh.split("-");
					ngaySinh = temp[2] + "/" + temp[1] + "/" + temp[0];
					a.setNgaySinh(ngaySinh);

					a.setDiaChi(rs.getString("DIACHI"));
					a.setGioiTinh(rs.getString("GIOITINH"));
					a.setChucVu(rs.getString("CHUCVU"));
					a.setTrangThai(rs.getString("TRANGTHAI"));
					a.setSdt(rs.getInt("SODT"));
					dsnv_1.add(a);
				}

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();			}
		}

		return dsnv_1;
	}
}
