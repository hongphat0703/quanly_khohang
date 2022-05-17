public class PNDTO {
	private String maPN, maNV, maNCC, maKho, Ngay;
	private double TongTien;
	public PNDTO() {
		setMaPN("");
		setMaNV("");
		setMaNCC("");
		setMaKho("");
		setNgay("");
		setTongTien(0);
	}
	public PNDTO(String maPN, String maNV, String maNCC, String makho, String ngay, double tongtien) {
		setMaPN(maPN);
		setMaNV(maNV);
		setMaNCC(maNCC);
		setMaKho(makho);
		setNgay(ngay);
		setTongTien(tongtien);
	}
	public String getMaPN() {
		return maPN;
	}
	public void setMaPN(String maPN) {
		this.maPN = maPN;
	}
	public String getNgay() {
		return Ngay;
	}
	public void setNgay(String ngay) {
		Ngay = ngay;
	}
	public String getMaNCC() {
		return maNCC;
	}
	public void setMaNCC(String maNCC) {
		this.maNCC = maNCC;
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
