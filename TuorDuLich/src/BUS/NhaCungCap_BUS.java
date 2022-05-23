package BUS;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.NhanVien;
import GUI.TrangChinh;

public class NhaCungCap_BUS {
	  private DAO.NhaCungCap nhacungcapDAO=new DAO.NhaCungCap();
	  private static int maxmaNCC=3001;
	  private ArrayList<DTO.NhaCungCap> nccList=new ArrayList<>();
	  
	  public NhaCungCap_BUS() {
		  
	  }
	  
	  public ArrayList<DTO.NhaCungCap> getNCCList() {
			try {
				if (nccList.size() > 1)
					maxmaNCC = nccList.get(nccList.size() - 1).getMaNCC();
			} catch (Exception ex) {
				maxmaNCC = 1000;
			}
			return nccList;
		}
	  public void docDsNCC() {
		  nccList.clear();
			this.nccList = nhacungcapDAO.getDanhSachNCC();
			
		}
	  public String chuanHoa(String x) {
			if (x.length() >= 1) {
				x.trim().replaceAll("\\s+", " ").toLowerCase();
				String temp[] = x.split(" ");
				x = String.valueOf(temp[0].charAt(0)).toUpperCase() + temp[0].substring(1);
				for (int i = 1; i < temp.length; i++)
					x += " " + String.valueOf(temp[i].charAt(0)).toUpperCase() + temp[i].substring(1);
			}
			return x;
		}
	  public boolean themNCC(DTO.NhaCungCap ncc) {
			maxmaNCC++;
			ncc.setMaNCC(maxmaNCC);
			ncc.setTenNCC(chuanHoa(ncc.getTenNCC()));
			if (ncc.getTenNCC().equals("")) {
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
		                "Tên nhà cung cấp không được để trống",
		                "Thông báo!!!",
		                JOptionPane.WARNING_MESSAGE);
				return false;
			}
			
			if (ncc.getSoDT() == 0) {
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
		                "Số điện thoại không được để trống",
		                "Thông báo!!!",
		                JOptionPane.WARNING_MESSAGE);
				return false;
			} else if (ncc.getSoDT() == -1) {
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
		                "Chỉ được nhập số",
		                "Thông báo!!!",
		                JOptionPane.WARNING_MESSAGE);
				return false;
			}
			
			if(ncc.getDiachi().equals("")) {
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
		                "Địa chỉ không được để trống",
		                "Thông báo!!!",
		                JOptionPane.WARNING_MESSAGE);
				return false;
			}
			
			if (nhacungcapDAO.addNCC(ncc))
				return true;
			
			return false;
		}
	  
	  
	  public boolean suaNCC(DTO.NhaCungCap ncc) {
		  ncc.setTenNCC(chuanHoa(ncc.getTenNCC()));
		  if (ncc.getTenNCC().equals("")) {
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
		                "Tên nhà cung cấp không được để trống",
		                "Thông báo!!!",
		                JOptionPane.WARNING_MESSAGE);
				return false;
			}
		  if (ncc.getSoDT() == 0) {
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
		                "Số điện thoại không được để trống",
		                "Thông báo!!!",
		                JOptionPane.WARNING_MESSAGE);
				return false;
			} else if (ncc.getSoDT() == -1) {
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
		                "Chỉ được nhập số",
		                "Thông báo!!!",
		                JOptionPane.WARNING_MESSAGE);
				return false;
			}
		
		  if(ncc.getDiachi().equals("")) {
				JOptionPane.showMessageDialog(TrangChinh.getFrames()[0],
		                "Địa chỉ không được để trống",
		                "Thông báo!!!",
		                JOptionPane.WARNING_MESSAGE);
				return false;
			}
			
		   if (nhacungcapDAO.suaNCC(ncc)) {
			   return true;
		   }
			
			return false;
		  
	  }
	  
	  public DTO.NhaCungCap timKiemMa(String ma) {
			DTO.NhaCungCap nCC = new DTO.NhaCungCap();
			int mancc = 0;
			try {
				mancc = Integer.parseInt(ma);
			} catch  (NumberFormatException exx){
				return null;
			}
			nCC = nhacungcapDAO.timKiem(mancc);
			return nCC;
		}
		
		public ArrayList<DTO.NhaCungCap> timKiemTen(String ten) {
			ArrayList<DTO.NhaCungCap> nccList = new ArrayList<>();
			nccList = nhacungcapDAO.timKiem(ten.trim().replaceAll("\\s+", " "));
			
			return nccList;
			
		}

}

