import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class KHDAO {
	static Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	MySQLConnect connect = new MySQLConnect();
	KHDAO(){
		if(con == null) {
			try {
				con = connect.getConnection();
				stmt = connect.getStatement();
			}
			catch(Exception e) {
				Logger.getLogger(KHDAO.class.getName());
			}
		}		
	}
	ArrayList<KHDTO> docDSKH() {
		ArrayList<KHDTO> dskh = new ArrayList<KHDTO>();
		try {
			String qry = "Select * from khach_hang";
			res = stmt.executeQuery(qry);
			while(res.next()) {
				KHDTO kh = new KHDTO();
				kh.setMaKH(res.getString(1));
				kh.setHoKH(res.getString(2));
				kh.setTenKH(res.getString(3));
				kh.setDCKH(res.getString(4));
				kh.setDTKH(res.getString(5));
				dskh.add(kh);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!!");
		}
		return dskh;
	}
	boolean check1(KHDTO kh) {		
		try {
			String qry = "Select Ma_KH from khach_hang where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(kh.getMaKH())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	void them(KHDTO kh) {
		try {
			
			String qry = "Insert into khach_hang values(";
			qry = qry + "'" + kh.getMaKH() + "'";
			qry = qry + "," +"'" + kh.getHoKH() + "'";
			qry = qry + "," +"'" + kh.getTenKH()+ "'";
			qry = qry + "," +"'" + kh.getDCKH() + "'";
			qry = qry + "," +"'" + kh.getDTKH() + "'";

			qry = qry + ")";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
			GUI.kh = new KHDTO();
		}
	}
	void sua(KHDTO kh) {
		try {
			String qry = "UPDATE khach_hang SET ";
			qry = qry + " Ho_KH = '" + kh.getHoKH() + "'";
			qry = qry + "," + " Ten_KH = '" + kh.getTenKH() + "'";
			qry = qry + "," + " Dia_Chi = '" + kh.getDCKH() + "'";
			qry = qry + "," + " Dien_Thoai = '" + kh.getDTKH() + "'";
			qry = qry + "WHERE MA_KH = '" + kh.getMaKH() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin!!");
		}
	}
	void xoa(KHDTO kh) {
		try {
			String qry = "DELETE FROM khach_hang WHERE Ma_KH = '"+ kh.getMaKH() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin!!");
		}
	}
	ArrayList<KHDTO> sx(String tt,String req) {	
		ArrayList<KHDTO> KHList = new ArrayList<KHDTO>();
		try {
			String qry = "Select * from khach_hang ORDER BY khach_hang." + tt + " " + req;
			res = connect.executeQuery(qry);
			while(res.next()) {
				KHDTO kh = new KHDTO();
				kh.setMaKH(res.getString(1));
				kh.setHoKH(res.getString(2));
				kh.setTenKH(res.getString(3));
				kh.setDCKH(res.getString(4));
				kh.setDTKH(res.getString(5));
				KHList.add(kh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return KHList;
	}
}
