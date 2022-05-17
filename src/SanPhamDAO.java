import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
public class SanPhamDAO {
	static Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	MySQLConnect connect = new MySQLConnect();
	SanPhamDAO(){
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
	ArrayList<SanPhamDTO> docDSSP() {
		ArrayList<SanPhamDTO> dssp = new ArrayList<SanPhamDTO>();
		try {
			String qry = "Select * from sanpham";
			res = stmt.executeQuery(qry);
			while(res.next()) {
				SanPhamDTO sp = new SanPhamDTO();
				sp.setmaSP(res.getString(1));
				sp.settenSP(res.getString(2));
				sp.setDonGia(Double.parseDouble(res.getString(3)));
				sp.setSoLuong(Integer.parseInt(res.getString(4)));
				sp.setDvTinh(res.getString(5));
				sp.setMaNSX(res.getString(6));
				dssp.add(sp);
			}
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi đọc thông tin!!");
		}
		return dssp;
	}
	boolean check1(SanPhamDTO sp) {		
		try {
			String qry = "Select Ma_SP from sanpham where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(sp.getmaSP())) return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return false;
	}
	boolean check2(SanPhamDTO sp) {		
		try {
			String qry = "Select Ma_NSX from sanpham where 1";
			res = connect.executeQuery(qry);
			while(res.next()) {
				if(res.getString(1).equals(sp.getMaNSX())) return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}	
		return true;
	}
	void them(SanPhamDTO sp) {
		try {
			String qry = "Insert into sanpham values(";
			qry = qry + "'" + sp.getmaSP() + "'";
			qry = qry + "," +"'" + sp.gettenSP() + "'";
			qry = qry + "," +"'" + sp.getDonGia()+ "'";
			qry = qry + "," +"'" + sp.getSoLuong() + "'";
			qry = qry + "," +"'" + sp.getDvTinh() + "'";
			qry = qry + "," +"'" + sp.getMaNSX() + "'";
			qry = qry + ")";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi ghi thông tin!!");
			GUI.sp = new SanPhamDTO();
		}
	}
	void sua(SanPhamDTO sp) {
		try {
			String qry = "UPDATE sanpham SET ";
			qry = qry + " Ten_SP = '" + sp.gettenSP() + "'";
			qry = qry + "," + " Don_Gia = '" + sp.getDonGia() + "'";
			qry = qry + "," + " So_Luong = '" + sp.getSoLuong() + "'";
			qry = qry + "," + " DV_Tinh = '" + sp.getDvTinh() + "'";
			qry = qry + "," + " Ma_NSX = '" + sp.getMaNSX() + "'";
			qry = qry + "WHERE MA_SP = '" + sp.getmaSP() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi sửa thông tin!!");
		}
	}
	void xoa(SanPhamDTO sp) {
		try {
			String qry = "DELETE FROM sanpham WHERE Ma_SP = '"+ sp.getmaSP() + "'";
			int rs = connect.executeUpdate(qry);
		}
		catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Lỗi xóa thông tin!!");
		}
	}
	ArrayList<SanPhamDTO> sx(String tt,String req) {	
		ArrayList<SanPhamDTO> SPList = new ArrayList<SanPhamDTO>();
		try {
			String qry = "Select * from sanpham ORDER BY sanpham." + tt + " " + req;
			res = connect.executeQuery(qry);
			while(res.next()) {
				SanPhamDTO sp = new SanPhamDTO();
				sp.setmaSP(res.getString(1));
				sp.settenSP(res.getString(2));
				sp.setDonGia(Double.parseDouble(res.getString(3)));
				sp.setSoLuong(Integer.parseInt(res.getString(4)));
				sp.setDvTinh(res.getString(5));
				sp.setMaNSX(res.getString(6));
				SPList.add(sp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SPList;
	}
}
