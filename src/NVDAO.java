import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class NVDAO {
	static Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	MySQLConnect connect = new MySQLConnect();
	NVDAO(){
		if(con == null) {
			try {
				con = connect.getConnection();
				stmt = connect.getStatement();
			}
			catch(Exception e) {
				Logger.getLogger(NVDAO.class.getName());
			}
		}		
	}
	ArrayList<NVDTO> docDSNV() {
		ArrayList<NVDTO> dsnv = new ArrayList<NVDTO>();
		try {
			String qry = "Select * from nhanvien";
			res = stmt.executeQuery(qry);
			while(res.next()) {
				NVDTO nv = new NVDTO();
				nv.setMaNV(res.getString(1));
				nv.setHoNV(res.getString(2));
				nv.setTenNV(res.getString(3));
				nv.setNgaysinh(res.getString(4));
				nv.setDCNV(res.getString(5));
				nv.setDTNV(res.getString(6));
				nv.setLuongNV(res.getString(7));
				dsnv.add(nv);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!!");
		}
		return dsnv;
	}
	boolean check1(NVDTO nv) {		
		try {
			String qry = "Select Ma_NV from nhanvien where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(nv.getMaNV())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	void them(NVDTO nv) {
		try {
			
			String qry = "Insert into nhanvien values(";
			qry = qry + "'" + nv.getMaNV() + "'";
			qry = qry + "," +"'" + nv.getHoNV() + "'";
			qry = qry + "," +"'" + nv.getTenNV()+ "'";
			qry = qry + "," +"'" + nv.getNgaysinh() + "'";
			qry = qry + "," +"'" + nv.getDCNV() + "'";
			qry = qry + "," +"'" + nv.getDTNV() + "'";
			qry = qry + "," +"'" + nv.getLuongNV() + "'";
			qry = qry + ")";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
			GUI.nv = new NVDTO();
		}
	}
	void sua(NVDTO nv) {
		try {
			String qry = "UPDATE nhanvien SET ";
			qry = qry + " Ho_NV = '" + nv.getHoNV() + "'";
			qry = qry + "," + " Ten_NV = '" + nv.getTenNV() + "'";
			qry = qry + "," + " Ngay_Sinh = '" + nv.getNgaysinh() + "'";
			qry = qry + "," + " Dia_Chi = '" + nv.getDCNV() + "'";
			qry = qry + "," + " Dien_Thoai = '" + nv.getDTNV() + "'";
			qry = qry + "," + " Luong = '" + nv.getLuongNV() + "'";
			qry = qry + "WHERE MA_NV = '" + nv.getMaNV() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin!!");
		}
	}
	void xoa(NVDTO nv) {
		try {
			String qry = "DELETE FROM nhanvien WHERE Ma_NV = '"+ nv.getMaNV() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin!!");
		}
	}
	ArrayList<NVDTO> sx(String tt,String req) {	
		ArrayList<NVDTO> NVList = new ArrayList<NVDTO>();
		try {
			String qry = "Select * from nhanvien ORDER BY nhanvien." + tt + " " + req;
			res = connect.executeQuery(qry);
			while(res.next()) {
				NVDTO nv = new NVDTO();
				nv.setMaNV(res.getString(1));
				nv.setHoNV(res.getString(2));
				nv.setTenNV(res.getString(3));
				nv.setNgaysinh(res.getString(4));
				nv.setDCNV(res.getString(5));
				nv.setDTNV(res.getString(6));
				nv.setLuongNV(res.getString(7));
				NVList.add(nv);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return NVList;
	}
}
