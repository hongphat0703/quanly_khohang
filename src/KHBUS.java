import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class KHBUS {
	static ArrayList<KHDTO> KHList ;
	static ArrayList<KHDTO> dskh ;
	KHBUS(){}
	void docDSKH() {
		 KHDAO data = new KHDAO();
		 if(KHList == null ) KHList = new ArrayList<KHDTO>();
		 KHList = data.docDSKH();
	}
	void themKH() {
		KHDAO data = new KHDAO();
		try {
			if(data.check1(GUI.kh)) JOptionPane.showMessageDialog(null, "Mã khách hàng bị trùng!!");
			else {
				data.them(GUI.kh);
				if(GUI.kh.getMaKH().equals("") != true ) {
				KHList.add(GUI.kh);
				JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công!!");
				}
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
	void suaKH() {
		KHDAO data = new KHDAO();
		data.sua(GUI.kh);
	}
	void xoaKH() {
		KHDAO data = new KHDAO();
		data.xoa(GUI.kh);
	}
	void sxKH(String tt, String req) {
		KHDAO data = new KHDAO();
		dskh = data.sx(tt, req);
	}
	ArrayList<KHDTO> TimKH(String tar) {
		ArrayList<KHDTO> kq = new ArrayList<KHDTO>();
		for(int i=0;i < KHList.size();i++ ) {
			KHDTO kh = new KHDTO();
			kh = KHList.get(i);
			if(kh.getMaKH().equals(tar)) kq.add(kh);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<KHDTO> TimKH2(String tar) {
		ArrayList<KHDTO> kq = new ArrayList<KHDTO>();
		for(int i=0;i < KHList.size();i++ ) {
			KHDTO kh = new KHDTO();
			kh = KHList.get(i);
			if(kh.getHoKH().equals(tar)) kq.add(kh);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<KHDTO> TimKH3(String tar) {
		ArrayList<KHDTO> kq = new ArrayList<KHDTO>();
		for(int i=0;i < KHList.size();i++ ) {
			KHDTO kh = new KHDTO();
			kh = KHList.get(i);
			if(kh.getTenKH().equals(tar)) kq.add(kh);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<KHDTO> TimKH4(String tar) {
		ArrayList<KHDTO> kq = new ArrayList<KHDTO>();
		for(int i=0;i < KHList.size();i++ ) {
			KHDTO kh = new KHDTO();
			kh = KHList.get(i);
			if(kh.getDTKH().equals(tar)) kq.add(kh);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
}
