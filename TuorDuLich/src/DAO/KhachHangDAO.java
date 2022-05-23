package DAO;

import java.sql.*;
import java.util.ArrayList;

public class KhachHangDAO {
	static Connection con;
	ArrayList<DTO.KhachHangDTO> dsKhachHang = new ArrayList<DTO.KhachHangDTO>();
	int passKH = 0;

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
			ResultSet rs = st.executeQuery("Select Max(MAKH) from KHACHHANG");
			rs.next();
			passKH = rs.getInt(1) + 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addKH(DTO.KhachHangDTO kh) {
		String url = "insert into KHACHHANG values(?,?,?,?,?,?)";
		if (connectDB()) {
			DemSoluong();
			try {
				DemSoluong();
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, passKH);
				ps.setString(2, kh.gettenKH());
				ps.setString(3, kh.getgioitinh());
				ps.setString(4, kh.getNgaySinh());
				ps.setInt(5, kh.getSDT());
				ps.setString(6, kh.getDiaChi());
				ps.executeUpdate();

				return true;

			} catch (Exception e) {
				e.printStackTrace();

			} finally {
				closeConnection();
			}
		}
		return false;
	}

	public ArrayList<DTO.KhachHangDTO> getdsKhachHang() {
		String url = "select * from KHACHHANG";
		ArrayList<DTO.KhachHangDTO> dsKhachHang = new ArrayList<DTO.KhachHangDTO>();
		if (connectDB()) {
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					DTO.KhachHangDTO kh = new DTO.KhachHangDTO();
					kh.setmaKH(rs.getInt("MaKH"));
					kh.settenKH(rs.getString("TenKH"));
					kh.setgioitinh(rs.getString("GioiTinh"));
					
					String ngaySinh = rs.getString("NgaySinh");
					String temp[] = ngaySinh.split("-");
					ngaySinh = temp[2] + "/" + temp[1] + "/" + temp[0];
					kh.setNgaySinh(ngaySinh);
					kh.setsdt(rs.getInt("SODT"));
					kh.setdiachi(rs.getString("DiaChi"));

					dsKhachHang.add(kh);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}

		return dsKhachHang;
	}
	
	public ArrayList<DTO.KhachHangDTO> timKiemMa(int ma) {
		String url = "select * from KHACHHANG where makh = ?";
		if (connectDB()) {
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setInt(1, ma);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					DTO.KhachHangDTO kh = new DTO.KhachHangDTO();
					kh.setmaKH(rs.getInt("MaKH"));
					kh.settenKH(rs.getString("TenKH"));
					kh.setgioitinh(rs.getString("GioiTinh"));
					String ngaySinh = rs.getString("NgaySinh");
					String temp[] = ngaySinh.split("-");
					ngaySinh = temp[2] + "/" + temp[1] + "/" + temp[0];
					kh.setNgaySinh(ngaySinh);
					kh.setsdt(rs.getInt("SODT"));
					kh.setdiachi(rs.getString("DiaChi"));

					dsKhachHang.add(kh);
				}

			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}

		return dsKhachHang;
	}

	public boolean xoaKH(int MaKH) {

		String url = "delete from KHACHHANG where maKH='" + MaKH + "'";
		if (connectDB()) {
			try {
				PreparedStatement ps = con.prepareStatement(url);
				if (ps.executeUpdate() > 0) {
					closeConnection();
					return true;
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				closeConnection();
			}
		}
		return false;

	}

	public boolean suaKH(DTO.KhachHangDTO kh) {
		String url = "UPDATE KHACHHANG SET TENKH=?, GIOITINH=?,NGAYSINH=?,SODT=?,DIACHI=? where MAKH=? ";
		if (connectDB()) {
			try {
				PreparedStatement ps = con.prepareStatement(url);
				ps.setString(1, kh.gettenKH());
				ps.setString(2, kh.getgioitinh());
				ps.setString(3, kh.getNgaySinh());
				ps.setInt(4, kh.getSDT());
				ps.setString(5, kh.getDiaChi());
				ps.setInt(6, kh.getmaKH());
				if (ps.executeUpdate() > 0) {
					closeConnection();
					return true;
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