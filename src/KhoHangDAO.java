import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class KhoHangDAO {
	static Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	MySQLConnect connect = new MySQLConnect();
	KhoHangDAO(){
		if(con == null) {
			try {
				con = connect.getConnection();
				stmt = connect.getStatement();
			}
			catch(Exception e) {
				Logger.getLogger(SanPhamDAO.class.getName());
			}
		}		
	}
	ArrayList<KhoHangDTO> docDSKho() {
		ArrayList<KhoHangDTO> dskh = new ArrayList<KhoHangDTO>();
		try {
			String qry = "Select * from kho";
			res = stmt.executeQuery(qry);
			while(res.next()) {
				KhoHangDTO kho = new KhoHangDTO();
				kho.setMaKho(res.getString(1));
				kho.setTenKho(res.getString(2));
				kho.setDCKho(res.getString(3));
				kho.setDTKho(res.getString(4));
				dskh.add(kho);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!!");
		}
		return dskh;
	}
	boolean check(KhoHangDTO kho) {		
		try {
			String qry = "Select Ma_Kho from kho where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(kho.getMaKho())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	void them(KhoHangDTO kho) {
		try {
			String qry = "Insert into kho values(";
			qry = qry + "'" + kho.getMaKho() + "'";
			qry = qry + "," +"'" + kho.getTenKho() + "'";
			qry = qry + "," +"'" + kho.getDCKho() + "'";
			qry = qry + "," +"'" + kho.getDTKho() + "'";
			qry = qry + ")";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
			GUI.kho = new KhoHangDTO();
		}
	}
	void sua(KhoHangDTO kho) {
		try {
			String qry = "UPDATE kho SET ";
			qry = qry + " Ten_Kho = '" + kho.getTenKho() + "'";
			qry = qry + "," + " Dia_Chi = '" + kho.getDCKho() + "'";
			qry = qry + "," + " Dien_Thoai = '" + kho.getDTKho() + "'";
			qry = qry + "WHERE MA_Kho = '" + kho.getMaKho() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin!!");
		}
	}
	void xoa(KhoHangDTO kho) {
		try {
			String qry = "DELETE FROM kho WHERE Ma_Kho = '"+ kho.getMaKho() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin!!");
		}
	}
	ArrayList<KhoHangDTO> sx(String tt,String req) {	
		ArrayList<KhoHangDTO> KhoList = new ArrayList<KhoHangDTO>();
		try {
			String qry = "Select * from kho ORDER BY kho." + tt + " " + req;
			res = connect.executeQuery(qry);
			while(res.next()) {
				KhoHangDTO kho = new KhoHangDTO();
				kho.setMaKho(res.getString(1));
				kho.setTenKho(res.getString(2));
				kho.setDCKho(res.getString(3));
				kho.setDTKho(res.getString(4));
				KhoList.add(kho);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return KhoList;
	}
}
