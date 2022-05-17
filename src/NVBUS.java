import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class NVBUS {
	static ArrayList<NVDTO> NVList ;
	static ArrayList<NVDTO> dsnv ;
	NVBUS(){}
	void docDSNV() {
		 NVDAO data = new NVDAO();
		 if(NVList == null ) NVList = new ArrayList<NVDTO>();
		 NVList = data.docDSNV();
	}
	void themNV() {
		NVDAO data = new NVDAO();
		try {
			if(data.check1(GUI.nv)) JOptionPane.showMessageDialog(null, "Mã nhân viên bị trùng!!");
			else {
				data.them(GUI.nv);
				if(GUI.nv.getMaNV().equals("") != true ) {
				NVList.add(GUI.nv);
				JOptionPane.showMessageDialog(null, "Thêm nhân viên thành công!!");
				}
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
	void suaNV() {
		NVDAO data = new NVDAO();
		data.sua(GUI.nv);
	}
	void xoaNV() {
		NVDAO data = new NVDAO();
		data.xoa(GUI.nv);
	}
	void sxNV(String tt, String req) {
		NVDAO data = new NVDAO();
		dsnv = data.sx(tt, req);
	}
	ArrayList<NVDTO> TimNV(String tar) {
		ArrayList<NVDTO> kq = new ArrayList<NVDTO>();
		for(int i=0;i < NVList.size();i++ ) {
			NVDTO nv = new NVDTO();
			nv = NVList.get(i);
			if(nv.getMaNV().equals(tar)) kq.add(nv);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<NVDTO> TimNV2(String tar) {
		ArrayList<NVDTO> kq = new ArrayList<NVDTO>();
		for(int i=0;i < NVList.size();i++ ) {
			NVDTO nv = new NVDTO();
			nv = NVList.get(i);
			if(nv.getHoNV().equals(tar)) kq.add(nv);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<NVDTO> TimNV3(String tar) {
		ArrayList<NVDTO> kq = new ArrayList<NVDTO>();
		for(int i=0;i < NVList.size();i++ ) {
			NVDTO nv = new NVDTO();
			nv = NVList.get(i);
			if(nv.getTenNV().equals(tar)) kq.add(nv);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<NVDTO> TimNV4(String tar) {
		ArrayList<NVDTO> kq = new ArrayList<NVDTO>();
		for(int i=0;i < NVList.size();i++ ) {
			NVDTO nv = new NVDTO();
			nv = NVList.get(i);
			if(nv.getDTNV().equals(tar)) kq.add(nv);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<NVDTO> TimNV5(String tar) {
		ArrayList<NVDTO> kq = new ArrayList<NVDTO>();
		for(int i=0;i < NVList.size();i++ ) {
			NVDTO nv = new NVDTO();
			nv = NVList.get(i);
			if(nv.getLuongNV().equals(tar)) kq.add(nv);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
}
