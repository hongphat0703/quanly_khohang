import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class CTPNDAO {
	static Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	MySQLConnect connect = new MySQLConnect();
	CTPNDAO(){
		if(con == null) {
			try {
				con = connect.getConnection();
				stmt = connect.getStatement();
			}
			catch(Exception e) {
				Logger.getLogger(CTPNDAO.class.getName());
			}
		}		
	}
	ArrayList<CTPNDTO> docDSCTPN() {
		ArrayList<CTPNDTO> dsctpn = new ArrayList<CTPNDTO>();
		try {
			String qry = "Select * from ct_phieu_nhap";
			res = stmt.executeQuery(qry);
			while(res.next()) {
				CTPNDTO ctpn = new CTPNDTO();
				ctpn.setMaPN(res.getString(1));
				ctpn.setMaSP(res.getString(2));
				ctpn.setSoluong(Integer.parseInt(res.getString(3)));
				ctpn.setDongia(Double.parseDouble(res.getString(4)));
				ctpn.setThanhtien(Double.parseDouble(res.getString(5)));
				dsctpn.add(ctpn);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!!");
		}
		return dsctpn;
	}
	boolean check1(CTPNDTO ctpn) {		
		try {
			String qry = "Select Ma_PN, Ma_SP from ct_phieu_nhap where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(ctpn.getMaPN()) && res.getString(2).equals(ctpn.getMaSP())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	void them(CTPNDTO ctpn) {
		try {
			String qry = "Insert into ct_phieu_nhap values(";
			qry = qry + "'" + ctpn.getMaPN() + "'";
			qry = qry + "," +"'" + ctpn.getMaSP() + "'";
			qry = qry + "," +"'" + ctpn.getSoluong()+ "'";
			qry = qry + "," +"'" + ctpn.getDongia() + "'";
			qry = qry + "," +"'" + ctpn.getThanhtien() + "'";
			qry = qry + ")";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin CTPN !!");
		}
	}
	void sua(CTPNDTO ctpn) {
		try {
			String qry = "UPDATE ct_phieu_nhap SET ";
			qry = qry + " Ma_SP = '" + ctpn.getMaSP() + "'";
			qry = qry + "," + " So_Luong = '" + ctpn.getSoluong() + "'";
			qry = qry + "," + " Don_Gia = '" + ctpn.getDongia() + "'";
			qry = qry + "," + " ThanhTien = '" + ctpn.getThanhtien() + "'";
			qry = qry + "WHERE MA_PN = '" + ctpn.getMaPN() + "'";
			qry = qry + "AND Ma_SP = '" + ctpn.getMaSP() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin CTPN!!");
		}
	}
	void xoa(CTPNDTO ctpn) {
		try {
			String qry = "DELETE FROM ct_phieu_nhap WHERE Ma_PN = '"+ ctpn.getMaPN() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin!!");
		}
	}
	void xoa2(CTPNDTO ctpn) {
		try {
			String qry = "DELETE FROM ct_phieu_nhap WHERE ct_phieu_nhap.Ma_PN = '"+ ctpn.getMaPN() + "'";
			qry = qry + "AND" + " ct_phieu_nhap.Ma_SP = '" + ctpn.getMaSP() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin!!");
		}
	}
}
