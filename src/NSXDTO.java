public class NSXDTO {
	private String maNSX, tenNSX, dcNSX, dtNSX;
	public NSXDTO() {
		setMaNSX("");
		setTenNSX("");
		setDCNSX("");
		setDTNSX("");
	}
	public NSXDTO(String ma, String ten, String dc, String dt) {
		this.setMaNSX(ma);
		this.setTenNSX(ten);
		this.setDCNSX(dc);
		this.setDTNSX(dt);
	}
	public void setMaNSX(String ma) {
		this.maNSX = ma;
	}
	public String getMaNSX() {
		return maNSX;
	}
	public void setTenNSX(String ten) {
		this.tenNSX = ten;
	}
	public String getTenNSX() {
		return tenNSX;
	}
	public void setDCNSX(String dc) {
		this.dcNSX = dc;
	}
	public String getDCNSX() {
		return dcNSX;
	}
	public void setDTNSX(String dt) {
		this.dtNSX = dt;
	}
	public String getDTNSX() {
		return dtNSX;
	}
}
