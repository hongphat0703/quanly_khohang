import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class SanPhamBUS {
	static ArrayList<SanPhamDTO> SanPhamList ;
	static ArrayList<SanPhamDTO> dssp ;
	SanPhamBUS(){}
	void docDSSP() {
		 SanPhamDAO data = new SanPhamDAO();
		 if(SanPhamList == null ) SanPhamList = new ArrayList<SanPhamDTO>();
		 SanPhamList = data.docDSSP();
	}
	void themSP() {
		SanPhamDAO data = new SanPhamDAO();
		try {
			if(data.check1(GUI.sp)) JOptionPane.showMessageDialog(null, "Mã sản phẩm bị trùng!!");
			else {
				if(data.check2(GUI.sp)) JOptionPane.showMessageDialog(null, "Mã NSX không tồn tại!!");  
				else {
					data.them(GUI.sp);
					if(GUI.sp.getmaSP().equals("") != true ) {
						SanPhamList.add(GUI.sp);
						JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công!!");
					}
				}
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
	void suaSP() {
		SanPhamDAO data = new SanPhamDAO();
		data.sua(GUI.sp);
	}
	void xoaSP() {
		SanPhamDAO data = new SanPhamDAO();
		data.xoa(GUI.sp);
	}
	void sxSP(String tt, String req) {
		SanPhamDAO data = new SanPhamDAO();
		dssp = data.sx(tt, req);
	}
	ArrayList<SanPhamDTO> TimSP(String tar) {
		ArrayList<SanPhamDTO> kq = new ArrayList<SanPhamDTO>();
		for(int i=0;i < SanPhamList.size();i++ ) {
			SanPhamDTO sp = new SanPhamDTO();
			sp = SanPhamList.get(i);
			if(sp.getmaSP().equals(tar)) kq.add(sp);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<SanPhamDTO> TimSP2(String tar) {
		ArrayList<SanPhamDTO> kq = new ArrayList<SanPhamDTO>();
		for(int i=0;i < SanPhamList.size();i++ ) {
			SanPhamDTO sp = new SanPhamDTO();
			sp = SanPhamList.get(i);
			if(sp.gettenSP().equals(tar)) kq.add(sp);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<SanPhamDTO> TimSP3(String tar) {
		ArrayList<SanPhamDTO> kq = new ArrayList<SanPhamDTO>();
		for(int i=0;i < SanPhamList.size();i++ ) {
			SanPhamDTO sp = new SanPhamDTO();
			sp = SanPhamList.get(i);
			if(sp.getMaNSX().equals(tar)) kq.add(sp);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
}
