import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class PNDAO {
	static Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	MySQLConnect connect = new MySQLConnect();
	PNDAO(){
		if(con == null) {
			try {
				con = connect.getConnection();
				stmt = connect.getStatement();
			}
			catch(Exception e) {
				Logger.getLogger(PNDAO.class.getName());
			}
		}		
	}
	ArrayList<PNDTO> docDSPN() {
		ArrayList<PNDTO> dspn = new ArrayList<PNDTO>();
		try {
			String qry = "Select * from phieunhap";
			res = stmt.executeQuery(qry);
			while(res.next()) {
				PNDTO pn = new PNDTO();
				pn.setMaPN(res.getString(1));
				pn.setMaNV(res.getString(2));
				pn.setMaNCC(res.getString(3));
				pn.setMaKho(res.getString(4));
				pn.setNgay(res.getString(5));
				pn.setTongTien(res.getDouble(6));
				dspn.add(pn);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!!");
		}
		return dspn;
	}
	boolean check1(PNDTO pn) {		
		try {
			String qry = "Select Ma_PN from phieunhap where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(pn.getMaPN())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	void them(PNDTO pn) {
		try {
			String qry = "Insert into phieunhap values(";
			qry = qry + "'" + pn.getMaPN() + "'";
			qry = qry + "," +"'" + pn.getMaNV() + "'";
			qry = qry + "," +"'" + pn.getMaNCC()+ "'";
			qry = qry + "," +"'" + pn.getMaKho() + "'";
			qry = qry + "," +"'" + pn.getNgay() + "'";
			qry = qry + "," +"'" + pn.getTongTien() + "'";
			qry = qry + ")";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
			GUI.pn = new PNDTO();
		}
	}
	void sua(PNDTO pn) {
		try {
			String qry = "UPDATE phieunhap SET ";
			qry = qry + " Ma_NV = '" + pn.getMaNV() + "'";
			qry = qry + "," + " Ma_NCC = '" + pn.getMaNCC() + "'";
			qry = qry + "," + " Ma_Kho = '" + pn.getMaKho() + "'";
			qry = qry + "," + " Ngay = '" + pn.getNgay() + "'";
			qry = qry + "," + " TongTien = '" + pn.getTongTien() + "'";
			qry = qry + "WHERE MA_PN = '" + pn.getMaPN() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa thông tinPN!!");
		}
	}
	void xoa(PNDTO pn) {
		try {
			String qry = "DELETE FROM phieunhap WHERE Ma_PN = '"+ pn.getMaPN() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin PN!!");
		}
	}
}
