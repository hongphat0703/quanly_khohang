import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PNBUS {
	static ArrayList<PNDTO> PNList ;
	static ArrayList<PNDTO> dspn ;
	PNBUS(){}
	void docDSPN() {
		 PNDAO data = new PNDAO();
		 if(PNList == null ) PNList = new ArrayList<PNDTO>();
		 PNList = data.docDSPN();
	}
	void themPN() {
		PNDAO data = new PNDAO();
		try {
			if(data.check1(PNGUI.pn)) JOptionPane.showMessageDialog(null, "Mã phiếu nhập bị trùng!!");
			else {
				data.them(PNGUI.pn);
				if(PNGUI.pn.getMaPN().equals("") != true ) {
				PNList.add(PNGUI.pn);
				JOptionPane.showMessageDialog(null, "Thêm phiếu nhập thành công!!");
				}
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
	void suaPN() {
		PNDAO data = new PNDAO();
		data.sua(PNGUI.pn);
	}
	void xoaPN() {
		PNDAO data = new PNDAO();
		data.xoa(GUI.pn);
	}
	ArrayList<PNDTO> TimPN(String tar) {
		ArrayList<PNDTO> kq = new ArrayList<PNDTO>();
		for(int i=0;i < PNList.size();i++ ) {
			PNDTO pn = new PNDTO();
			pn = PNList.get(i);
			if(pn.getMaPN().equals(tar)) kq.add(pn);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<PNDTO> TimPN2(String tar) {
		ArrayList<PNDTO> kq = new ArrayList<PNDTO>();
		for(int i=0;i < PNList.size();i++ ) {
			PNDTO pn = new PNDTO();
			pn = PNList.get(i);
			if(pn.getMaNV().equals(tar)) kq.add(pn);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<PNDTO> TimPN3(String tar) {
		ArrayList<PNDTO> kq = new ArrayList<PNDTO>();
		for(int i=0;i < PNList.size();i++ ) {
			PNDTO pn = new PNDTO();
			pn = PNList.get(i);
			if(pn.getMaNCC().equals(tar)) kq.add(pn);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<PNDTO> TimPN4(String tar) {
		ArrayList<PNDTO> kq = new ArrayList<PNDTO>();
		for(int i=0;i < PNList.size();i++ ) {
			PNDTO pn = new PNDTO();
			pn = PNList.get(i);
			if(pn.getNgay().equals(tar)) kq.add(pn);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
}
