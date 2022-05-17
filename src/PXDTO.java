public class PXDTO {
	private String maPX, maNV, maKH, maKho, Ngay;
	private double TongTien;
	public PXDTO() {
		setMaPX("");
		setMaNV("");
		setMaKH("");
		setMaKho("");
		setNgay("");
		setTongTien(0);
	}
	public PXDTO(String maPX, String maNV, String maKH, String makho, String ngay, double tongtien) {
		setMaPX(maPX);
		setMaNV(maNV);
		setMaKH(maKH);
		setMaKho(makho);
		setNgay(ngay);
		setTongTien(tongtien);
	}
	public String getMaPX() {
		return maPX;
	}
	public void setMaPX(String maPX) {
		this.maPX = maPX;
	}
	public String getNgay() {
		return Ngay;
	}
	public void setNgay(String ngay) {
		Ngay = ngay;
	}
	public String getMaKH() {
		return maKH;
	}
	public void setMaKH(String maKH) {
		this.maKH = maKH;
	}
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public double getTongTien() {
		return TongTien;
	}
	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}
	public String getMaKho() {
		return maKho;
	}
	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}
}
