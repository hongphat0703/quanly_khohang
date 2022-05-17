public class NCCDTO {
	private String maNCC, tenNCC, dcNCC, dtNCC;
	public NCCDTO() {
		setMaNCC("");
		setTenNCC("");
		setDCNCC("");
		setDTNCC("");
	}
	public NCCDTO(String ma, String ten, String dc, String dt) {
		this.setMaNCC(ma);
		this.setTenNCC(ten);
		this.setDCNCC(dc);
		this.setDTNCC(dt);
	}
	public void setMaNCC(String ma) {
		this.maNCC = ma;
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setTenNCC(String ten) {
		this.tenNCC = ten;
	}
	public String getTenNCC() {
		return tenNCC;
	}
	public void setDCNCC(String dc) {
		this.dcNCC = dc;
	}
	public String getDCNCC() {
		return dcNCC;
	}
	public void setDTNCC(String dt) {
		this.dtNCC = dt;
	}
	public String getDTNCC() {
		return dtNCC;
	}
}
