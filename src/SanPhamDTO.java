public class SanPhamDTO {
	private String maSP,tenSP,dvTinh,maNSX;
	private double soluong;
	private double donGia;
	public SanPhamDTO() {
		setmaSP("");
		settenSP("");
		setDonGia(0.0);
		setSoLuong(0);
		setDvTinh("");
		setMaNSX("");
	}
	public SanPhamDTO(String maSP, String tenSP, double donGia, double soLuong, String dvTinh, String maNSX) {
		this.setmaSP(maSP);
		this.settenSP(tenSP);
		this.setDonGia(donGia);
		this.setSoLuong(soLuong);
		this.setDvTinh(dvTinh);
		this.setMaNSX(maNSX);
	}
	public void setmaSP(String maSP) {
		this.maSP = maSP;
	}
	public String getmaSP() {
		return maSP;
	}
	public String gettenSP() {
		return tenSP;
	}
	public void settenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public double getDonGia() {
		return donGia;
	}
	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	public String getDvTinh() {
		return dvTinh;
	}
	public void setDvTinh(String dvTinh) {
		this.dvTinh = dvTinh;
	}
	public double getSoLuong() {
		return soluong;
	}
	public void setSoLuong(double d) {
		this.soluong = d;
	}
	public String getMaNSX() {
		return maNSX;
	}
	public void setMaNSX(String maNSX) {
		this.maNSX = maNSX;
	}
}
