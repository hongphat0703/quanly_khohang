import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JOptionPane;

public class RLDAO {
	static Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	MySQLConnect connect = new MySQLConnect();
	RLDAO(){
		if(con == null) {
			try {
				con = connect.getConnection();
				stmt = connect.getStatement();
			}
			catch(Exception e) {
				Logger.getLogger(RLDAO.class.getName());
			}
		}		
	}
	ArrayList<RLDTO> docDSTK() {
		ArrayList<RLDTO> dstk = new ArrayList<RLDTO>();
		try {
			String qry = "Select * from account";
			res = stmt.executeQuery(qry);
			while(res.next()) {
				RLDTO tk = new RLDTO();
				tk.setUsername(res.getString(1));
				tk.setGmail(res.getString(2));
				tk.setPwd(res.getString(3));
				tk.setConfirm_pwd(res.getString(3));
				dstk.add(tk);
			} 
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!!");
		}
		return dstk;
	}
	boolean check1(RLDTO tk) {		
		try {
			String qry = "SELECT Gmail FROM account";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(tk.getGmail())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	boolean check2(RLDTO tk) {			
		try {
			String qry = "SELECT Username FROM account where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(tk.getUsername())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	void reg(RLDTO account) {
		try {
		String qry = "INSERT INTO account values (";
		qry = qry + "'" + account.getUsername() + "'";
		qry = qry + "," +"'" + account.getGmail() + "'";
		qry = qry + "," +"'" + account.getPwd() + "'";
		qry = qry + "," +"'" + account.getConfirm_pwd() + "'";
		qry = qry + ")";
		int N=0;
		N = connect.executeUpdate(qry); //Update database;
		if( N!=0) JOptionPane.showMessageDialog(null, "Register Success");
		else JOptionPane.showMessageDialog(null,"Registration failed");
		} catch (Exception E) {
			Register.tk = new RLDTO();
		}
	}
	


}