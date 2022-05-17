import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class NCCDAO {
	static Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	MySQLConnect connect = new MySQLConnect();
	NCCDAO(){
		if(con == null) {
			try {
				con = connect.getConnection();
				stmt = connect.getStatement();
			}
			catch(Exception e) {
				Logger.getLogger(NCCDAO.class.getName());
			}
		}		
	}
	ArrayList<NCCDTO> docDSNCC() {
		ArrayList<NCCDTO> dsncc = new ArrayList<NCCDTO>();
		try {
			String qry = "Select * from NCC";
			res = stmt.executeQuery(qry);
			while(res.next()) {
				NCCDTO ncc = new NCCDTO();
				ncc.setMaNCC(res.getString(1));
				ncc.setTenNCC(res.getString(2));
				ncc.setDCNCC(res.getString(3));
				ncc.setDTNCC(res.getString(4));
				dsncc.add(ncc);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!!");
		}
		return dsncc;
	}
	boolean check(NCCDTO ncc) {		
		try {
			String qry = "Select Ma_NCC from NCC where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(ncc.getMaNCC())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	void them(NCCDTO ncc) {
		try {
			String qry = "Insert into ncc values(";
			qry = qry + "'" + ncc.getMaNCC() + "'";
			qry = qry + "," +"'" + ncc.getTenNCC() + "'";
			qry = qry + "," +"'" + ncc.getDCNCC() + "'";
			qry = qry + "," +"'" + ncc.getDTNCC() + "'";
			qry = qry + ")";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
			GUI.ncc = new NCCDTO();
		}
	}
	void sua(NCCDTO ncc) {
		try {
			String qry = "UPDATE NCC SET ";
			qry = qry + " Ten_NCC = '" + ncc.getTenNCC() + "'";
			qry = qry + "," + " Dia_Chi = '" + ncc.getDCNCC() + "'";
			qry = qry + "," + " Dien_Thoai = '" + ncc.getDTNCC() + "'";
			qry = qry + "WHERE MA_NCC = '" + ncc.getMaNCC() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin!!");
		}
	}
	void xoa(NCCDTO ncc) {
		try {
			String qry = "DELETE FROM NCC WHERE Ma_NCC = '"+ ncc.getMaNCC() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin!!");
		}
	}
	ArrayList<NCCDTO> sx(String tt,String req) {	
		ArrayList<NCCDTO> nccList = new ArrayList<NCCDTO>();
		try {
			String qry = "Select * from NCC ORDER BY NCC." + tt + " " + req;
			res = connect.executeQuery(qry);
			while(res.next()) {
				NCCDTO ncc = new NCCDTO();
				ncc.setMaNCC(res.getString(1));
				ncc.setTenNCC(res.getString(2));
				ncc.setDCNCC(res.getString(3));
				ncc.setDTNCC(res.getString(4));
				nccList.add(ncc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nccList;
	}
}
