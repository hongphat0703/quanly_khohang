import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class NSXDAO {
	static Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	MySQLConnect connect = new MySQLConnect();
	NSXDAO(){
		if(con == null) {
			try {
				con = connect.getConnection();
				stmt = connect.getStatement();
			}
			catch(Exception e) {
				Logger.getLogger(NSXDAO.class.getName());
			}
		}		
	}
	ArrayList<NSXDTO> docDSNSX() {
		ArrayList<NSXDTO> dsnsx = new ArrayList<NSXDTO>();
		try {
			String qry = "Select * from NSX";
			res = stmt.executeQuery(qry);
			while(res.next()) {
				NSXDTO nsx = new NSXDTO();
				nsx.setMaNSX(res.getString(1));
				nsx.setTenNSX(res.getString(2));
				nsx.setDCNSX(res.getString(3)); 
				nsx.setDTNSX(res.getString(4));
				dsnsx.add(nsx);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!!");
		}
		return dsnsx;
	}
	boolean check(NSXDTO nsx) {		
		try {
			String qry = "Select Ma_NSX from NSX where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(nsx.getMaNSX())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	void them(NSXDTO nsx) {
		try {
			String qry = "Insert into NSX values(";
			qry = qry + "'" + nsx.getMaNSX() + "'";
			qry = qry + "," +"'" + nsx.getTenNSX() + "'";
			qry = qry + "," +"'" + nsx.getDCNSX()+ "'";
			qry = qry + "," +"'" + nsx.getDTNSX() + "'";
			qry = qry + ")";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
			GUI.nsx = new NSXDTO();
		}
	}
	void sua(NSXDTO nsx) {
		try {
			String qry = "UPDATE NSX SET ";
			qry = qry + " Ten_NSX = '" + nsx.getTenNSX() + "'";
			qry = qry + "," + " Dia_Chi = '" + nsx.getDCNSX() + "'";
			qry = qry + "," + " Dien_Thoai = '" + nsx.getDTNSX() + "'";
			qry = qry + "WHERE MA_NSX = '" + nsx.getMaNSX() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin!!");
		}
	}
	void xoa(NSXDTO nsx) {
		try {
			String qry = "DELETE FROM NSX WHERE Ma_NSX = '"+ nsx.getMaNSX() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin!!");
		}
	}
	ArrayList<NSXDTO> sx(String tt,String req) {	
		ArrayList<NSXDTO> nsxList = new ArrayList<NSXDTO>();
		try {
			String qry = "Select * from NSX ORDER BY NSX." + tt + " " + req;
			res = connect.executeQuery(qry);
			while(res.next()) {
				NSXDTO nsx = new NSXDTO();
				nsx.setMaNSX(res.getString(1));
				nsx.setTenNSX(res.getString(2));
				nsx.setDCNSX(res.getString(3));
				nsx.setDTNSX(res.getString(4));
				nsxList.add(nsx);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nsxList;
	}
}
