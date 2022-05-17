import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class PXDAO {
	static Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	MySQLConnect connect = new MySQLConnect();
	PXDAO(){
		if(con == null) {
			try {
				con = connect.getConnection();
				stmt = connect.getStatement();
			}
			catch(Exception e) {
				Logger.getLogger(PXDAO.class.getName());
			}
		}		
	}
	ArrayList<PXDTO> docDSPX() {
		ArrayList<PXDTO> dspx = new ArrayList<PXDTO>();
		try {
			String qry = "Select * from phieuxuat";
			res = stmt.executeQuery(qry);
			while(res.next()) {
				PXDTO px = new PXDTO();
				px.setMaPX(res.getString(1));
				px.setMaNV(res.getString(2));
				px.setMaKH(res.getString(3));
				px.setMaKho(res.getString(4));
				px.setNgay(res.getString(5));
				px.setTongTien(res.getDouble(6));
				dspx.add(px);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!!");
		}
		return dspx;
	}
	boolean check1(PXDTO px) {		
		try {
			String qry = "Select Ma_PX from phieuxuat where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(px.getMaPX())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	void them(PXDTO px) {
		try {
			String qry = "Insert into phieuxuat values(";
			qry = qry + "'" + px.getMaPX() + "'";
			qry = qry + "," +"'" + px.getMaNV() + "'";
			qry = qry + "," +"'" + px.getMaKH()+ "'";
			qry = qry + "," +"'" + px.getMaKho() + "'";
			qry = qry + "," +"'" + px.getNgay() + "'";
			qry = qry + "," +"'" + px.getTongTien() + "'";
			qry = qry + ")";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
			GUI.px = new PXDTO();
		}
	}
	void sua(PXDTO px) {
		try {
			String qry = "UPDATE phieuxuat SET ";
			qry = qry + " Ma_NV = '" + px.getMaNV() + "'";
			qry = qry + "," + " Ma_KH = '" + px.getMaKH() + "'";
			qry = qry + "," + " Ma_Kho = '" + px.getMaKho() + "'";
			qry = qry + "," + " Ngay = '" + px.getNgay() + "'";
			qry = qry + "," + " TongTien = '" + px.getTongTien() + "'";
			qry = qry + "WHERE MA_PX = '" + px.getMaPX() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa thông tinPX!!");
		}
	}
	void xoa(PXDTO px) {
		try {
			String qry = "DELETE FROM phieuxuat WHERE Ma_PX = '"+ px.getMaPX() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin PX!!");
		}
	}
}
