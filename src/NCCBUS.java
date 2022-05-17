import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class NCCBUS {
	static ArrayList<NCCDTO> NCCList ;
	static ArrayList<NCCDTO> dsncc ;
	NCCBUS(){}
	void docDSNCC() {
		 NCCDAO data = new NCCDAO();
		 if(NCCList == null ) NCCList = new ArrayList<NCCDTO>();
		 NCCList = data.docDSNCC();
	}
	void themNCC() {
		NCCDAO data = new NCCDAO();
		try {
			if(data.check(GUI.ncc)) JOptionPane.showMessageDialog(null, "Mã nhà cung cấp bị trùng!!");
			else {
			data.them(GUI.ncc);
				if(GUI.ncc.getMaNCC().equals("") != true ) {
					NCCList.add(GUI.ncc);
					JOptionPane.showMessageDialog(null, "Thêm nhà cung cấp thành công!!");
				}
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
		
	}
	void suaNCC() {
		NCCDAO data = new NCCDAO();
		data.sua(GUI.ncc);
	}
	void xoaNCC() {
		NCCDAO data = new NCCDAO();
		data.xoa(GUI.ncc);
	}
	void sxNCC(String tt, String req) {
		NCCDAO data = new NCCDAO();
		dsncc = data.sx(tt, req);
	}
	ArrayList<NCCDTO> TimNCC(String tar) {
		ArrayList<NCCDTO> kq = new ArrayList<NCCDTO>();
		for(int i=0;i < NCCList.size();i++ ) {
			NCCDTO ncc = new NCCDTO();
			ncc = NCCList.get(i);
			if(ncc.getMaNCC().equals(tar)) kq.add(ncc);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<NCCDTO> TimNCC2(String tar) {
		ArrayList<NCCDTO> kq = new ArrayList<NCCDTO>();
		for(int i=0;i < NCCList.size();i++ ) {
			NCCDTO ncc = new NCCDTO();
			ncc = NCCList.get(i);
			if(ncc.getTenNCC().equals(tar)) kq.add(ncc);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<NCCDTO> TimNCC3(String tar) {
		ArrayList<NCCDTO> kq = new ArrayList<NCCDTO>();
		for(int i=0;i < NCCList.size();i++ ) {
			NCCDTO ncc = new NCCDTO();
			ncc = NCCList.get(i);
			if(ncc.getDTNCC().equals(tar)) kq.add(ncc);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
}
