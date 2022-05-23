package DAO;

import java.sql.*;
import java.util.ArrayList;

public class Lotrinh {
	static Connection con;
	ArrayList<DTO.LoTrinh> dsLT = new ArrayList<DTO.LoTrinh>();
	int maLTMax = 0;
	int passLT = 0;

	public boolean connectDB() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=TOURDULICH4";
			String username = "sa";
			String password = "sa";
			con = DriverManager.getConnection(dbUrl, username, password);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	public void closeConnection() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	public void DemSoluong() {
		if (connectDB()) {
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select Max(MADVTOUR) from LOTRINH");
				rs.next();
				passLT = rs.getInt(1) + 1;

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public boolean addLT(DTO.LoTrinh lt) {
		String url = "insert into LOTRINH values(?,?,?,?,?,?,?)";
		if (connectDB()) {
			try {
				DemSoluong();
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, passLT);
				ps.setString(2, lt.getgiodi());
				ps.setString(3, lt.getngaydi());
				ps.setString(4, lt.getgiove());
				ps.setString(5, lt.getngayve());
				ps.setString(6, lt.getdiemdon());
				ps.setString(7, lt.getdiemden());
				try {
					if (ps.executeUpdate() >= 0) {
						closeConnection();

						return true;
					}
				} catch (SQLException e) {
					System.out.println(e);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return false;
	}

	public ArrayList<DTO.LoTrinh> getdsLoTrinh() {
		String url = "select * from LOTRINH";
		ArrayList<DTO.LoTrinh> dsLT = new ArrayList<DTO.LoTrinh>();
		if (connectDB()) {
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
				} catch (SQLException e) {
					System.out.println(e);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dsLT;
	}
	
	public ArrayList<DTO.LoTrinh> timKiem(int ma) {
		String url = "select * from LOTRINH where madvtour = ?";
		ArrayList<DTO.LoTrinh> dsLT = new ArrayList<DTO.LoTrinh>();
		if (connectDB()) {
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, ma);
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
				} catch (SQLException e) {
					System.out.println(e);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return dsLT;
	}

	public boolean xoaLT(DTO.LoTrinh nv, int MADVTOUR) {

		String url = "delete from LOTRINH where MADVTOUR='" + MADVTOUR + "'";
		if (connectDB()) {
			try {
				PreparedStatement ps = con.prepareStatement(url);
				try {
					if (ps.executeUpdate() >= 0) {
						closeConnection();

						return true;
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
			} catch (Exception e) {

				e.printStackTrace();

			} finally {
				closeConnection();
			}
		}
		return false;

	}

	public boolean suaLT(DTO.LoTrinh lt) {
		String url = "UPDATE LOTRINH SET GIODI=?, NGAYDI=?, GIOVE=?, NGAYVE=?, DIEMDON=?, DIEMDEN=? where MADVTOUR = ? ";
		if (connectDB()) {
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setString(1, lt.getgiodi());
				ps.setString(2, lt.getngaydi());
				ps.setString(3, lt.getgiove());
				ps.setString(4, lt.getngayve());
				ps.setString(5, lt.getdiemdon());
				ps.setString(6, lt.getdiemden());
				ps.setInt(7, lt.getMADVTOUR());
				try {
					if (ps.executeUpdate() >= 0) {
						closeConnection();
						return true;
					}
				} catch (SQLException e) {
					System.out.println(e);
				}
			} catch (Exception e) {

				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return false;
	}

}