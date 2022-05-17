import java.awt.HeadlessException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class KhoHangBUS {
	static ArrayList<KhoHangDTO> KhoHangList ;
	static ArrayList<KhoHangDTO> dskho ;
	KhoHangBUS(){}
	void docDSKho() {
		 KhoHangDAO data = new KhoHangDAO();
		 if(KhoHangList == null ) KhoHangList = new ArrayList<KhoHangDTO>();
		 KhoHangList = data.docDSKho();
	}
	void themKho() {
		
		KhoHangDAO data = new KhoHangDAO();
		try {
			if(data.check(GUI.kho)) JOptionPane.showMessageDialog(null, "Mã kho bị trùng!!");
			else {
			data.them(GUI.kho);
			if(GUI.kho.getMaKho().equals("") != true ) {
				KhoHangList.add(GUI.kho);			
				JOptionPane.showMessageDialog(null, "Thêm kho thành công!!");
			}
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
	void suaKho() {
		KhoHangDAO data = new KhoHangDAO();
		data.sua(GUI.kho);
	}
	void xoaKho() {
		KhoHangDAO data = new KhoHangDAO();
		data.xoa(GUI.kho);
	}
	void sxKho(String tt, String req) {
		KhoHangDAO data = new KhoHangDAO();
		dskho = data.sx(tt, req);
	}
	ArrayList<KhoHangDTO> TimKho(String tar) {
		dskho = new ArrayList<KhoHangDTO>();
		ArrayList<KhoHangDTO> kq = new ArrayList<KhoHangDTO>();
		for(int i=0;i < KhoHangList.size();i++ ) {
			KhoHangDTO kho = new KhoHangDTO();
			kho = KhoHangList.get(i);
			if(kho.getMaKho().equals(tar)) kq.add(kho);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<KhoHangDTO> TimKho2(String tar) {
		dskho = new ArrayList<KhoHangDTO>();
		ArrayList<KhoHangDTO> kq = new ArrayList<KhoHangDTO>();
		for(int i=0;i < KhoHangList.size();i++ ) {
			KhoHangDTO kho = new KhoHangDTO();
			kho = KhoHangList.get(i);
			if(kho.getTenKho().equals(tar)) kq.add(kho);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<KhoHangDTO> TimKho3(String tar) {
		dskho = new ArrayList<KhoHangDTO>();
		ArrayList<KhoHangDTO> kq = new ArrayList<KhoHangDTO>();
		for(int i=0;i < KhoHangList.size();i++ ) {
			KhoHangDTO kho = new KhoHangDTO();
			kho = KhoHangList.get(i);
			if(kho.getDTKho().equals(tar)) kq.add(kho);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
}
