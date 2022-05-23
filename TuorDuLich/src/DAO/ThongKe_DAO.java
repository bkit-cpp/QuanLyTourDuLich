package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import DTO.ThongKe;
import GUI.TrangChinh;

public class ThongKe_DAO {
	ConnectCSDL connect = new ConnectCSDL();
	Connection con;

	public ArrayList<ThongKe> thongKeThangNam(Date date1, Date date2) {

		ArrayList<ThongKe> tk = new ArrayList<ThongKe>();

		String ngay1 = String.valueOf(date1.getYear()) + "/" + String.valueOf(date1.getMonth()) + "/"
				+ String.valueOf(date1.getDate());
		String ngay2 = String.valueOf(date2.getYear()) + "/" + String.valueOf(date2.getMonth()) + "/"
				+ String.valueOf(date2.getDate());

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prt = con
						.prepareStatement("select madvtour, tenkh, sum(gia), ngaytao from ve, khachhang "
								+ "where ve.makh = khachhang.makh and (ngaytao >= ? and ngaytao < ?) "
								+ "group by madvtour, tenkh, ngaytao");
				prt.setString(1, ngay1);
				prt.setString(2, ngay2);
				ResultSet rs = prt.executeQuery();
				try {
					while (rs.next()) {
						ThongKe a = new ThongKe();
						a.setMadvTour(rs.getInt(1));
						a.setTenKH(rs.getString(2));
						a.setDoanhThu(rs.getLong(3));
						a.setThoiGian(rs.getString(4));
						tk.add(a);
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Ngày tháng năm không hợp lệ!",
							"Thông báo!", JOptionPane.ERROR_MESSAGE);
					connect.closeConnection();
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return tk;
	}
	
	public ArrayList<ThongKe> thongKeThangNam() {

		ArrayList<ThongKe> tk = new ArrayList<ThongKe>();

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prt = con
						.prepareStatement("select madvtour, tenkh, sum(gia), ngaytao from ve, khachhang "
								+ "where ve.makh = khachhang.makh "
								+ "group by madvtour, tenkh, ngaytao");
				ResultSet rs = prt.executeQuery();
				try {
					while (rs.next()) {
						ThongKe a = new ThongKe();
						a.setMadvTour(rs.getInt(1));
						a.setTenKH(rs.getString(2));
						a.setDoanhThu(rs.getLong(3));
						a.setThoiGian(rs.getString(4));
						tk.add(a);
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Ngày tháng năm không hợp lệ!",
							"Thông báo!", JOptionPane.ERROR_MESSAGE);
					connect.closeConnection();
					return null;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return tk;
	}

	public long thongKeThang(Date date1, Date date2) {

		ArrayList<ThongKe> tk = new ArrayList<ThongKe>();

		String ngay1 = String.valueOf(date1.getYear()) + "/" + String.valueOf(date1.getMonth()) + "/"
				+ String.valueOf(date1.getDate());

		String ngay2 = String.valueOf(date2.getYear()) + "/" + String.valueOf(date2.getMonth()) + "/"
				+ String.valueOf(date2.getDate());

		long gia = 0;

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prt = con
						.prepareStatement("select sum(gia) from ve where ngaytao >= ? and ngaytao < ? ");
				prt.setString(1, ngay1);
				prt.setString(2, ngay2);
				ResultSet rs = prt.executeQuery();
				try {
					if (rs.next()) {
						gia = rs.getLong(1);
					}
				} catch (SQLException ex) {
					JOptionPane.showMessageDialog(TrangChinh.getFrames()[0], "Ngày tháng năm không hợp lệ!",
							"Thông báo!", JOptionPane.ERROR_MESSAGE);
					connect.closeConnection();
					return 0;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return gia;
	}

	public String tenDV(int ma) {

		ArrayList<ThongKe> tk = new ArrayList<ThongKe>();

		String ten = "";

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prt = con.prepareStatement("select tendvtour from tourmoban where madvtour = ? ");
				prt.setInt(1, ma);
				ResultSet rs = prt.executeQuery();
				try {
					if (rs.next()) {
						ten = rs.getString(1);
					}
				} catch (SQLException ex) {
					System.out.println("Mã dv không hợp lệ!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return ten;
	}

	public String tenDVSP(int ma) {

		ArrayList<ThongKe> tk = new ArrayList<ThongKe>();

		String ten = "";

		if (connect.connectDB()) {
			con = connect.getCon();

			try {
				PreparedStatement prt = con.prepareStatement("select tendvtour from toursanpham where madvtour = ? ");
				prt.setInt(1, ma);
				ResultSet rs = prt.executeQuery();
				try {
					if (rs.next()) {
						ten = rs.getString(1);
					}
				} catch (SQLException ex) {
					System.out.println("Mã dvsp không hợp lệ!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				connect.closeConnection();
			}
		}
		return ten;
	}

}
