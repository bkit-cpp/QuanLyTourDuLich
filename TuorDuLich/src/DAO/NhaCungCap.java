package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import DTO.NhanVien;

public class NhaCungCap {
	public ArrayList<DTO.NhaCungCap> nccList = new ArrayList<>();
	ConnectCSDL connect = new ConnectCSDL();
	Connection con;

	public boolean addNCC(DTO.NhaCungCap ncc) {
		String url = "insert into NHACUNGCAP values(?,?,?,?,?)";

		if (connect.connectDB()) {
			con = connect.getCon();
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, ncc.getMaNCC());
				ps.setString(2, ncc.getTenNCC());
				ps.setLong(3, ncc.getSoDT());
				ps.setString(4, ncc.getTrangthai());
				ps.setString(5, ncc.getDiachi());
				
				try {
					ps.executeUpdate();
				} catch (Exception ed) {
					connect.closeConnection();
					return false;
				}
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

	public boolean suaNCC(DTO.NhaCungCap ncc) {
		boolean flag = false;
		if (connect.connectDB()) {
			con = connect.getCon();
			String url = "UPDATE NHACUNGCAP SET TENCC=?,SODT=?,TRANGTHAI=?,DIACHI=? where MANCC=? ";
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setString(1, ncc.getTenNCC());
				ps.setLong(2, ncc.getSoDT());
				ps.setString(3, ncc.getTrangthai());
				ps.setString(4, ncc.getDiachi());
				ps.setInt(5, ncc.getMaNCC());
				
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

	public ArrayList<DTO.NhaCungCap> getDanhSachNCC() {
		if (connect.connectDB()) {
			con = connect.getCon();
			String url = "select * from NHACUNGCAP";
			try {
				PreparedStatement ps = con.prepareStatement(url);

				ResultSet rs = ps.executeQuery();
				
				try {
					while (rs.next()) {
						DTO.NhaCungCap ncc = new DTO.NhaCungCap();
						ncc.setMaNCC(rs.getInt("MANCC"));
						ncc.setTenNCC(rs.getString("TENCC"));
						ncc.setSoDT(rs.getLong("SODT"));
						ncc.setTrangthai(rs.getString("TRANGTHAI"));
						ncc.setDiachi(rs.getString("DIACHI"));
						nccList.add(ncc);
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
		return nccList;
	}

	public DTO.NhaCungCap timKiem(int maNCC) {

		DTO.NhaCungCap nccDTO = new DTO.NhaCungCap();

		if (connect.connectDB()) {
			con = connect.getCon();
			try {
				PreparedStatement prep = con.prepareStatement("Select * from NHACUNGCAP where MANCC = ?");
				prep.setInt(1, maNCC);
				ResultSet rs = prep.executeQuery();
				try {
					if (rs.next()) {
						nccDTO.setMaNCC(maNCC);
						nccDTO.setTenNCC(rs.getString(2));
						nccDTO.setSoDT((int) rs.getInt(3)); // ((int)rs.getInt(5));
						nccDTO.setTrangthai(rs.getString(4));
						nccDTO.setDiachi(rs.getString(5));
					} else {
						nccDTO = null;
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

		return nccDTO;
	}

	public ArrayList<DTO.NhaCungCap> timKiem(String tenNCC) {

		ArrayList<DTO.NhaCungCap> nccList = new ArrayList<>();
		if (connect.connectDB()) {
			con = connect.getCon();
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery("Select * from NHACUNGCAP where TENCC like N'%" + tenNCC + "%'");

				try {
					while (rs.next()) {
						DTO.NhaCungCap a = new DTO.NhaCungCap();
						a.setMaNCC(rs.getInt("MANCC"));
						a.setTenNCC(rs.getString("TENCC"));
						a.setSoDT(rs.getInt("SODT"));
						a.setDiachi(rs.getString("DIACHI"));
						a.setTrangthai(rs.getString("TRANGTHAI"));
						nccList.add(a);
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

		return nccList;
	}
}
