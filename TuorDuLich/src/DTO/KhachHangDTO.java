package DTO;

public class KhachHangDTO {
private int MAKH;
private String TENKH;
private String GIOITINH;
private String NGAYSINH;
private int SDT;
private String DIACHI;

public KhachHangDTO(int MAKH,String TENKH,String GIOITINH, String NGAYSINH,int SDT, String DIACHI)
{
super()	;
this.MAKH=MAKH;
this.TENKH=TENKH;
this.GIOITINH=GIOITINH;
this.NGAYSINH=NGAYSINH;
this.SDT=SDT;
this.DIACHI=DIACHI;
}
public KhachHangDTO()
{
	super();
}
public int getmaKH()
{
	return MAKH;
}
public int setmaKH(int MAKH)
{
	return this.MAKH=MAKH;
}
public String gettenKH()
{
	return TENKH;
}
public String settenKH(String TENKH)
{
	return this.TENKH=TENKH;
}
public String getgioitinh()
{
	return GIOITINH;
}
public String setgioitinh(String GIOITINH)
{
	return this.GIOITINH=GIOITINH;
}
public String getNgaySinh()
{
	return NGAYSINH;
}
public String setNgaySinh(String NGAYSINH)
{
	return this.NGAYSINH=NGAYSINH;
}
public int getSDT()
{
	return SDT;
}
public int setsdt(int SDT)
{
	return this.SDT=SDT;
}
public String getDiaChi()
{
	return DIACHI;
}
public String setdiachi(String DIACHI)
{
	return this.DIACHI=DIACHI;
}
}
