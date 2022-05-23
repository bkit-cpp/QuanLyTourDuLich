package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.PhanQuyen;

public class PhanQuyen_DAO {
	
	ConnectCSDL connect = new ConnectCSDL();
	Connection con;

	public boolean themVaoDS(PhanQuyen nv) {

		boolean flag = false;

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prt = con.prepareStatement("insert into QUYENQUANLY values (?, ?, ?)");
				prt.setInt(1, nv.getMaQuyen());
				prt.setInt(2, nv.getMaNV());
				prt.setString(3, nv.getTenQuyen());
				if (prt.executeUpdate() >= 0)
					flag = true;
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return flag;
	}

	public ArrayList<DTO.PhanQuyen> timKiem(int maNV) {

		ArrayList<DTO.PhanQuyen> dsnv = new ArrayList<DTO.PhanQuyen>();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prep = con.prepareStatement("Select * from QUYENQUANLY where manv = ?");
				prep.setInt(1, maNV);
				ResultSet rs = prep.executeQuery();
				try {
					while (rs.next()) {
						DTO.PhanQuyen a = new DTO.PhanQuyen();
						a.setMaQuyen(rs.getInt(1));
						a.setMaNV(rs.getInt(2));
						a.setTenQuyen(rs.getString(3));
						dsnv.add(a);
					}
				} catch (SQLException rr) {
					System.out.println(rr);
					dsnv = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return dsnv;
	}

	public ArrayList<DTO.PhanQuyen> timKiem(int maNV, String tenQuyen) {

		ArrayList<DTO.PhanQuyen> dsnv = new ArrayList<DTO.PhanQuyen>();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prep = con
						.prepareStatement("Select * from QUYENQUANLY where manv = ? and tenquyenql = ?");
				prep.setInt(1, maNV);
				prep.setString(2, tenQuyen);

				ResultSet rs = prep.executeQuery();
				try {
					if (rs.next()) {
						DTO.PhanQuyen a = new DTO.PhanQuyen();
						a.setMaQuyen(rs.getInt(1));
						a.setMaNV(rs.getInt(2));
						a.setTenQuyen(rs.getString(3));
						dsnv.add(a);
					}
				} catch (SQLException rr) {
					System.out.println(rr);
					dsnv = null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return dsnv;
	}

	public boolean xoaQuyen(String ten, int maNV) {
		boolean flag = false;
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prep = con
						.prepareStatement("delete from QUYENQUANLY where manv = ? and tenquyenql = ?");
				prep.setInt(1, maNV);
				prep.setString(2, ten);

				if (prep.executeUpdate() > 0)
					flag = true;
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
}
