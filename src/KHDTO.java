public class KHDTO {
	private String maKH, hoKH, tenKH, dcKH, dtKH;
	public KHDTO() {
		setMaKH("");
		setHoKH("");
		setTenKH("");
		setDCKH("");
		setDTKH("");
	}
	public KHDTO(String ma, String ho, String ten, String dc, String dt) {
		setMaKH(ma);
		setHoKH(ho);
		setTenKH(ten);
		setDCKH(dc);
		setDTKH(dt);
	}
	public void setMaKH(String ma) {
		this.maKH = ma;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setHoKH(String ho) {
		this.hoKH = ho;
	}
	public String getHoKH() {
		return hoKH;
	}
	public void setTenKH(String ten) {
		this.tenKH = ten;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setDCKH(String dc) {
		this.dcKH = dc;
	}
	public String getDCKH() {
		return dcKH;
	}
	public void setDTKH(String dt) {
		this.dtKH = dt;
	}
	public String getDTKH() {
		return dtKH;
	}
}
