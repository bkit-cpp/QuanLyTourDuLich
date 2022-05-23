package DTO;

public class VE {
	private int MAVE;
	private String NGAYTAO;
	private int MAKH;
	private int MADVTOUR;
	private long GIA;
	private int MANV;

	public VE(int MAVE, String NGAYTAO, int MAKH, int MALOTRINH, long GIA, int MANV) {
		this.MAVE = MAVE;
		this.NGAYTAO = NGAYTAO;
		this.MAKH = MAKH;
		this.MADVTOUR = MADVTOUR;
		this.GIA = GIA;
		this.MANV = MANV;
	}

	public VE() {
		super();
	}

	public int getMAVE() {
		return MAVE;
	}

	public int setMAVE(int MAVE) {
		return this.MAVE = MAVE;
	}

	public String getNGAYTAO() {
		return NGAYTAO;
	}

	public String setNGAYTAO(String NGAYTAO) {
		return this.NGAYTAO = NGAYTAO;
	}

	public int getMAKH() {
		return MAKH;
	}

	public int setMAKH(int MAKH) {
		return this.MAKH = MAKH;
	}

	public int getMADVTOUR() {
		return MADVTOUR;
	}

	public int setMADVTOUR(int MADVTOUR) {
		return this.MADVTOUR = MADVTOUR;
	}

	public long getGIA() {
		return GIA;
	}

	public long setGIA(long GIA) {
		return this.GIA = GIA;
	}

	public int getMANV() {
		return MANV;
	}

	public int setMANV(int MANV) {
		return this.MANV = MANV;
	}

}