package DTO;

public class LoTrinh {
private int MADVTOUR;
private String GIODI;
private String NGAYDI;
private String GIOVE;
private String NGAYVE;
private  String DIEMDON;
private String DIEMDEN;
public LoTrinh(int MADVTOUR,String GIODI,String NGAYDI, String GIOVE, String NGAYVE,String DIEMDON,String DIEMDEN)
{
super()	;
this.MADVTOUR=MADVTOUR;
this.GIODI=GIODI;
this.NGAYDI=NGAYDI;
this.GIOVE=GIOVE;
this.NGAYVE=NGAYVE;
this.DIEMDON=DIEMDON;
this.DIEMDEN=DIEMDEN;
}
public LoTrinh()
{
	super();
}
public int getMADVTOUR()
{
	return MADVTOUR;
}
public int setmadvtour(int Madvtour)
{
	return this.MADVTOUR = Madvtour;
}
public String getgiodi()
{
	return GIODI;
}
public String setgiodi(String GIODI)
{
	return this.GIODI=GIODI;
}
public String getngaydi()
{
	return NGAYDI;
}
public String setngaydi(String NGAYDI)
{
	return this.NGAYDI=NGAYDI;
}
public String getgiove()
{
	return GIOVE;
}
public String setgiove(String GIOVE)
{
	return this.GIOVE=GIOVE;
}

public String getngayve()
{
	return NGAYVE;
}
public String setngayve(String NGAYVE)
{
	return this.NGAYVE=NGAYVE;
}
public String getdiemdon()
{
	return DIEMDON;
}
public String setdiemdon(String DIEMDON)
{
	return this.DIEMDON=DIEMDON;
}
public String getdiemden()
{
	return DIEMDEN;
}
public String setdiemden(String DIEMDEN)
{
	return this.DIEMDEN=DIEMDEN;
}
}
