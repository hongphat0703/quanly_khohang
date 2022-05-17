public class NVDTO {
	private String maNV, hoNV, tenNV, ngaysinh, dcNV, dtNV, luongNV;
	public NVDTO() {
		setMaNV("");
		setHoNV("");
		setTenNV("");
		setNgaysinh("");
		setDCNV("");
		setDTNV("");
		setLuongNV("");
	}
	public NVDTO(String ma, String ho, String ten,String ns, String dc, String dt, String luong) {
		setMaNV(ma);
		setHoNV(ho);
		setTenNV(ten);
		setNgaysinh(ns);
		setDCNV(dc);
		setDTNV(dt);
		setLuongNV(luong);
	}
	public void setMaNV(String ma) {
		this.maNV = ma;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setHoNV(String ho) {
		this.hoNV = ho;
	}
	public String getHoNV() {
		return hoNV;
	}
	public void setTenNV(String ten) {
		this.tenNV = ten;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setDCNV(String dc) {
		this.dcNV = dc;
	}
	public String getDCNV() {
		return dcNV;
	}
	public void setDTNV(String dt) {
		this.dtNV = dt;
	}
	public String getDTNV() {
		return dtNV;
	}
	public void setLuongNV(String luong) {
		this.luongNV = luong;
	}
	public String getLuongNV() {
		return luongNV;
	}
	public String getNgaysinh() {
		return ngaysinh;
	}
	public void setNgaysinh(String ngaysinh) {
		this.ngaysinh = ngaysinh;
	}
}
