import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class CTPXDAO {
	static Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	MySQLConnect connect = new MySQLConnect();
	CTPXDAO(){
		if(con == null) {
			try {
				con = connect.getConnection();
				stmt = connect.getStatement();
			}
			catch(Exception e) {
				Logger.getLogger(CTPXDAO.class.getName());
			}
		}		
	}
	ArrayList<CTPXDTO> docDSCTPX() {
		ArrayList<CTPXDTO> dsctpx = new ArrayList<CTPXDTO>();
		try {
			String qry = "Select * from ct_phieu_xuat";
			res = stmt.executeQuery(qry);
			while(res.next()) {
				CTPXDTO ctpx = new CTPXDTO();
				ctpx.setMaPX(res.getString(1));
				ctpx.setMaSP(res.getString(2));
				ctpx.setSoluong(Integer.parseInt(res.getString(3)));
				ctpx.setDongia(Double.parseDouble(res.getString(4)));
				ctpx.setThanhtien(Double.parseDouble(res.getString(5)));
				dsctpx.add(ctpx);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!!");
		}
		return dsctpx;
	}
	boolean check1(CTPXDTO ctpx) {		
		try {
			String qry = "Select Ma_PX, Ma_SP from ct_phieu_xuat where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(ctpx.getMaPX()) && res.getString(2).equals(ctpx.getMaSP())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	void them(CTPXDTO ctpx) {
		try {
			String qry = "Insert into ct_phieu_xuat values(";
			qry = qry + "'" + ctpx.getMaPX() + "'";
			qry = qry + "," +"'" + ctpx.getMaSP() + "'";
			qry = qry + "," +"'" + ctpx.getSoluong()+ "'";
			qry = qry + "," +"'" + ctpx.getDongia() + "'";
			qry = qry + "," +"'" + ctpx.getThanhtien() + "'";
			qry = qry + ")";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin CTPX !!");
		}
	}
	void sua(CTPXDTO ctpx) {
		try {
			String qry = "UPDATE ct_phieu_xuat SET ";
			qry = qry + " Ma_SP = '" + ctpx.getMaSP() + "'";
			qry = qry + "," + " So_Luong = '" + ctpx.getSoluong() + "'";
			qry = qry + "," + " Don_Gia = '" + ctpx.getDongia() + "'";
			qry = qry + "," + " ThanhTien = '" + ctpx.getThanhtien() + "'";
			qry = qry + "WHERE MA_PX = '" + ctpx.getMaPX() + "'";
			qry = qry + "AND Ma_SP = '" + ctpx.getMaSP() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin CTPX!!");
		}
	}
	void xoa(CTPXDTO ctpx) {
		try {
			String qry = "DELETE FROM ct_phieu_xuat WHERE Ma_PX = '"+ ctpx.getMaPX() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin!!");
		}
	}
	void xoa2(CTPXDTO ctpx) {
		try {
			String qry = "DELETE FROM ct_phieu_xuat WHERE ct_phieu_xuat.Ma_PX = '"+ ctpx.getMaPX() + "'";
			qry = qry + "AND" + " ct_phieu_xuat.Ma_SP = '" + ctpx.getMaSP() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin!!");
		}
	}
}
