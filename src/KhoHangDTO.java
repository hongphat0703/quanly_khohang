public class KhoHangDTO {
	private String maKho,tenKho,dcKho,dtKho;
	public KhoHangDTO() {
		maKho = "";
		tenKho = "";
		dcKho = "";
		dtKho = "";
	}
	public KhoHangDTO(String ma, String ten, String dc, String dt) {
		maKho = ma;
		tenKho = ten;
		dcKho = dc;
		dtKho = dt;
	}
	public String getMaKho() {
		return maKho;
	}
	public void setMaKho(String maKho) {
		this.maKho = maKho;
	}
	public String getTenKho() {
		return tenKho;
	}
	public void setTenKho(String tenKho) {
		this.tenKho = tenKho;
	}
	public String getDCKho() {
		return dcKho;
	}
	public void setDCKho(String dcKho) {
		this.dcKho = dcKho;
	}
	public String getDTKho() {
		return dtKho;
	}
	public void setDTKho(String dtKho) {
		this.dtKho = dtKho;
	}
}
