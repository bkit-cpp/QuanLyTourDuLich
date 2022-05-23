package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class NhaHang {
	public ArrayList<DTO.NhaHang> nhList = new ArrayList<>();
	ConnectCSDL connect = new ConnectCSDL();
	Connection con;

	public boolean addNhaHang(DTO.NhaHang nh) {
		if (connect.connectDB()) {
			con = connect.getCon();

			String url = "insert into NhaHang values(?,?,?,?)";
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, nh.getMaNH());
				ps.setString(2, nh.getTenNH());
				ps.setInt(3, nh.getMaNCC());
				ps.setLong(4, nh.getGia());
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

	public boolean suaNH(DTO.NhaHang nh) {
		boolean flag = false;
		if (connect.connectDB()) {
			con = connect.getCon();

			String url = "UPDATE NHAHANG SET TENNH = ? , GIA = ?  where MANH = ?";
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setString(1, nh.getTenNH());
				ps.setLong(2, nh.getGia());
				ps.setInt(3, nh.getMaNH());

				try {
					if (ps.executeUpdate() >= 0)
						flag = true;
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

	public boolean xoaNH(DTO.NhaHang nh, int maNH) {
		String url = "delete from NHAHANG where MANH='" + maNH + "'";
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement ps = con.prepareStatement(url);

				try {
					if (ps.executeUpdate() >= 0) {
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

	public ArrayList<DTO.NhaHang> getDanhSachNH() {
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
						nhList.add(nh);
					}
				} catch (SQLException ok) {
					System.out.println(ok);
				}

			} catch (Exception e) {
				System.out.print(e);
				;
			} finally {
				connect.closeConnection();
			}
		}
		return nhList;
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
					} else {
						nhDTO = null;
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

	public ArrayList<DTO.NhaHang> timKiemTen(String tenNH) {

		ArrayList<DTO.NhaHang> nhList = new ArrayList<>();
		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select * from NHAHANG where TENNH like N'%" + tenNH + "%'");

				try {
					while (rs.next()) {
						DTO.NhaHang a = new DTO.NhaHang();
						a.setMaNH(rs.getInt("MANH"));
						a.setTenNH(rs.getString("TENNH"));
						a.setMaNCC(rs.getInt("MANCC"));
						a.setGia(rs.getInt("GIA"));
						nhList.add(a);
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

		return nhList;
	}
}
