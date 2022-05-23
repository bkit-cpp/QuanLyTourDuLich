package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class KhachSan {
	ArrayList<DTO.KhachSan> ksList = new ArrayList<>();

	public KhachSan() {

	}

	ConnectCSDL connect = new ConnectCSDL();
	Connection con;

	public boolean addKhachSan(DTO.KhachSan ks) {
		if (connect.connectDB()) {
			con = connect.getCon();
			String url = "insert into KHACHSAN values(?,?,?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, ks.getMaKS());
				ps.setString(2, ks.getLoaihinhKS());
				ps.setString(3, ks.getTenKS());
				ps.setInt(4, ks.getMaNCC());
				ps.setString(5, ks.getLoaiphong());
				ps.setLong(6, ks.getGia());
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

	public boolean suaKS(DTO.KhachSan ks) {
		boolean flag = false;
		if (connect.connectDB()) {
			con = connect.getCon();
			String url = "UPDATE KHACHSAN SET LOAIHINHKS=?, TENKS=?,LOAIPHONG=?,GIA=? where MAKS=? ";
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setString(1, ks.getLoaihinhKS());
				ps.setString(2, ks.getTenKS());
				ps.setString(3, ks.getLoaiphong());
				ps.setLong(4, ks.getGia());
				ps.setInt(5, ks.getMaKS());

				try {
					if (ps.executeUpdate() >= 0) {
						flag = true;
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
		return flag;
	}

	public boolean xoaKS(DTO.KhachSan ks, int maKS) {
		String url = "delete from KHACHSAN where MAKS='" + maKS + "'";
		if (connect.connectDB()) {
			con = connect.getCon();
			try {
				PreparedStatement ps = con.prepareStatement(url);

				try {
					if (ps.executeUpdate() > 0) {
						connect.closeConnection();
						return true;
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
		
		return false;
	}

	public ArrayList<DTO.KhachSan> getDanhSachKS() {
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
						ksList.add(ks);
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
		return ksList;
	}

	public DTO.KhachSan timKiem(int maKS) {

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
					} else {
						ksDTO = null;
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

	public ArrayList<DTO.KhachSan> timKiem(String tenKS) {

		ArrayList<DTO.KhachSan> ksList = new ArrayList<>();
		if (connect.connectDB()) {
			con = connect.getCon();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select * from KHACHSAN where TENKS like N'%" + tenKS + "%'");

				try {
					while (rs.next()) {
						DTO.KhachSan a = new DTO.KhachSan();
						a.setMaKS(rs.getInt("MAKS"));
						a.setLoaihinhKS(rs.getString("LOAIHINHKS"));
						a.setTenKS(rs.getString("TENKS"));
						a.setMaNCC(rs.getInt("MANCC"));
						a.setLoaiphong(rs.getString("LOAIPHONG"));
						a.setGia(rs.getInt("GIA"));
						ksList.add(a);
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

		return ksList;
	}
}
