package DAO;

import java.sql.*;
import java.util.ArrayList;

public class VE {
	static Connection con;
	ArrayList<DTO.VE> dsVE = new ArrayList<DTO.VE>();
	int passVE = 0;

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
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("Select Max(MAVE) from VE");
			rs.next();
			passVE = rs.getInt(1) + 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addVE(DTO.VE ve) {
		String url = "insert into VE values(?,?,?,?,?,?)";
		if (connectDB()) {
			try {
				DemSoluong();
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, passVE);
				ps.setString(2, ve.getNGAYTAO());
				ps.setInt(3, ve.getMAKH());
				ps.setInt(4, ve.getMADVTOUR());
				ps.setLong(5, ve.getGIA());
				ps.setInt(6, ve.getMANV());
				try {
					if (ps.executeUpdate() > 0) {
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

	public ArrayList<DTO.VE> getdsVE() {
		String url = "select * from VE";
		ArrayList<DTO.VE> dsVE = new ArrayList<DTO.VE>();

		if (connectDB()) {
			try {
				PreparedStatement ps = con.prepareStatement(url);

				ResultSet rs = ps.executeQuery();
				try {
					while (rs.next()) {
						DTO.VE ve = new DTO.VE();
						ve.setMAVE(rs.getInt("MAVE"));

						String ngayTao = rs.getString("NGAYTAO");
						String temp[] = ngayTao.split("-");
						ngayTao = temp[2] + "/" + temp[1] + "/" + temp[0];
						ve.setNGAYTAO(ngayTao);

						ve.setMAKH(rs.getInt("MAKH"));
						ve.setMADVTOUR(rs.getInt("MADVTOUR"));
						ve.setGIA(rs.getInt("GIA"));
						ve.setMANV(rs.getInt("MANV"));

						dsVE.add(ve);

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
		return dsVE;
	}

	public ArrayList<DTO.VE> timKiem(int ma) {
		String url = "select * from VE where madvtour = ?";
		ArrayList<DTO.VE> dsVE = new ArrayList<DTO.VE>();

		if (connectDB()) {
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, ma);
				ResultSet rs = ps.executeQuery();
				try {
					while (rs.next()) {
						DTO.VE ve = new DTO.VE();
						ve.setMAVE(rs.getInt("MAVE"));
						String ngayTao = rs.getString("NGAYTAO");
						String temp[] = ngayTao.split("-");
						ngayTao = temp[2] + "/" + temp[1] + "/" + temp[0];
						ve.setNGAYTAO(ngayTao);
						ve.setMAKH(rs.getInt("MAKH"));
						ve.setMADVTOUR(rs.getInt("MADVTOUR"));
						ve.setGIA(rs.getInt("GIA"));
						ve.setMANV(rs.getInt("MANV"));
						dsVE.add(ve);
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
		return dsVE;
	}

	public boolean xoaVE(int MAVE) {

		String url = "delete from VE where MAVE='" + MAVE + "'";
		if (connectDB()) {
			try {
				PreparedStatement ps = con.prepareStatement(url);
				try {
					if (ps.executeUpdate() > 0) {
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