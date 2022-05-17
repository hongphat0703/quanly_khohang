
public class RLDTO {
	private String username,gmail,pwd,confirm_pwd;
	private int status=0;
	public RLDTO() {
		setUsername("");
		setGmail("");
		setPwd("");
		setConfirm_pwd("");
	}
	public RLDTO(String username, String gmail, String pwd, String confirm_pwd) {
		super();
		this.username = username;
		this.gmail = gmail;
		this.pwd = pwd;
		this.confirm_pwd = confirm_pwd;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getConfirm_pwd() {
		return confirm_pwd;
	}

	public void setConfirm_pwd(String confirm_pwd) {
		this.confirm_pwd = confirm_pwd;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
}	
