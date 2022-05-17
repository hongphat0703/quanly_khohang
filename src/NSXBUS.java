import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class NSXBUS {
	static ArrayList<NSXDTO> NSXList ;
	static ArrayList<NSXDTO> dsnsx ;
	NSXBUS(){}
	void docDSNSX() {
		 NSXDAO data = new NSXDAO();
		 if(NSXList == null ) NSXList = new ArrayList<NSXDTO>();
		 NSXList = data.docDSNSX();
	}
	void themNSX() {
		NSXDAO data = new NSXDAO();
		try {
			if(data.check(GUI.nsx)) JOptionPane.showMessageDialog(null, "Mã nhà sản xuất bị trùng!!");
			else {
			data.them(GUI.nsx);
			if(GUI.nsx.getMaNSX().equals("") != true ) {
				NSXList.add(GUI.nsx);
				JOptionPane.showMessageDialog(null, "Thêm nhà sản xuất thành công!!");
			}
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
	void suaNSX() {
		NSXDAO data = new NSXDAO();
		data.sua(GUI.nsx);
	}
	void xoaNSX() {
		NSXDAO data = new NSXDAO();
		data.xoa(GUI.nsx);
	}
	void sxNSX(String tt, String req) {
		NSXDAO data = new NSXDAO();
		dsnsx = data.sx(tt, req);
	}
	ArrayList<NSXDTO> TimNSX(String tar) {
		ArrayList<NSXDTO> kq = new ArrayList<NSXDTO>();
		for(int i=0;i < NSXList.size();i++ ) {
			NSXDTO nsx = new NSXDTO();
			nsx = NSXList.get(i);
			if(nsx.getMaNSX().equals(tar)) kq.add(nsx);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<NSXDTO> TimNSX2(String tar) {
		ArrayList<NSXDTO> kq = new ArrayList<NSXDTO>();
		for(int i=0;i < NSXList.size();i++ ) {
			NSXDTO nsx = new NSXDTO();
			nsx = NSXList.get(i);
			if(nsx.getTenNSX().equals(tar)) kq.add(nsx);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<NSXDTO> TimNSX3(String tar) {
		ArrayList<NSXDTO> kq = new ArrayList<NSXDTO>();
		for(int i=0;i < NSXList.size();i++ ) {
			NSXDTO nsx = new NSXDTO();
			nsx = NSXList.get(i);
			if(nsx.getDTNSX().equals(tar)) kq.add(nsx);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
}
