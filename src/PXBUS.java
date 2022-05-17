import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class PXBUS {
	static ArrayList<PXDTO> PXList ;
	static ArrayList<PXDTO> dspx ;
	PXBUS(){}
	void docDSPX() {
		 PXDAO data = new PXDAO();
		 if(PXList == null ) PXList = new ArrayList<PXDTO>();
		 PXList = data.docDSPX();
	}
	void themPX() {
		PXDAO data = new PXDAO();
		try {
			if(data.check1(PXGUI.px)) JOptionPane.showMessageDialog(null, "Mã phiếu nhập bị trùng!!");
			else {
				data.them(PXGUI.px);
				if(PXGUI.px.getMaPX().equals("") != true ) {
				PXList.add(PXGUI.px);
				JOptionPane.showMessageDialog(null, "Thêm phiếu nhập thành công!!");
				}
			}
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
	void suaPX() {
		PXDAO data = new PXDAO();
		data.sua(PXGUI.px);
	}
	void xoaPX() {
		PXDAO data = new PXDAO();
		data.xoa(GUI.px);
	}
	ArrayList<PXDTO> TimPX(String tar) {
		ArrayList<PXDTO> kq = new ArrayList<PXDTO>();
		for(int i=0;i < PXList.size();i++ ) {
			PXDTO px = new PXDTO();
			px = PXList.get(i);
			if(px.getMaPX().equals(tar)) kq.add(px);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<PXDTO> TimPX2(String tar) {
		ArrayList<PXDTO> kq = new ArrayList<PXDTO>();
		for(int i=0;i < PXList.size();i++ ) {
			PXDTO px = new PXDTO();
			px = PXList.get(i);
			if(px.getMaNV().equals(tar)) kq.add(px);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<PXDTO> TimPX3(String tar) {
		ArrayList<PXDTO> kq = new ArrayList<PXDTO>();
		for(int i=0;i < PXList.size();i++ ) {
			PXDTO px = new PXDTO();
			px = PXList.get(i);
			if(px.getMaKH().equals(tar)) kq.add(px);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
	ArrayList<PXDTO> TimPX4(String tar) {
		ArrayList<PXDTO> kq = new ArrayList<PXDTO>();
		for(int i=0;i < PXList.size();i++ ) {
			PXDTO px = new PXDTO();
			px = PXList.get(i);
			if(px.getNgay().equals(tar)) kq.add(px);
		}
		if (kq.size()==0) JOptionPane.showMessageDialog(null, "Không tìm thấy!!");
		return kq;
	}
}
