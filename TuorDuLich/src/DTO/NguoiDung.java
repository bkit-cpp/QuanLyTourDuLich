package DTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NguoiDung {
	private String taiKhoan;
	private String matKhau;
	private String email;
	private int maNV;
	
	public String getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMaNV() {
		return maNV;
	}

	public void setMaNV(int maNV) {
		this.maNV = maNV;
	}

	public NguoiDung() {
	}

	public boolean kiemTraHopLeTK() {
		
		if (taiKhoan.length() > 6) {
			Pattern p = Pattern.compile("^[A-Za-z]+[A-Za-z0-9]+$");
			Matcher pp = p.matcher(taiKhoan);
			
			return pp.find();
		}
		
		return false;
		
	}
	
	public boolean kiemTraHopLeMK() {
		
		if(matKhau.length()>=8)
	    {
	        Pattern letter = Pattern.compile("[a-zA-z]");
	        Pattern digit = Pattern.compile("[0-9]");
	        Pattern special = Pattern.compile ("[!@#$%&*]");
	 
	        Matcher hasLetter = letter.matcher(matKhau);
	        Matcher hasDigit = digit.matcher(matKhau);
	        Matcher hasSpecial = special.matcher(matKhau);
	 
	        return hasLetter.find() || hasDigit.find() || hasSpecial.find();
	 
	    }
		
		return false;
		
	}
	
	public boolean kiemTraHopLeEmail() {
		Pattern letter = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher hasLetter = letter.matcher(email);

		return hasLetter.find();    
	}
	
}
