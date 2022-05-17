import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CTPXBUS {
	static ArrayList<CTPXDTO> CTPXList ;
	static ArrayList<CTPXDTO> dsctpx = new ArrayList<CTPXDTO>();
	CTPXBUS(){}
	void docDSCTPX() {
		 CTPXDAO data = new CTPXDAO();
		 if(CTPXList == null ) CTPXList = new ArrayList<CTPXDTO>();
		 CTPXList = data.docDSCTPX();
	}
	void them(CTPXDTO ctpx) {
		dsctpx.add(ctpx);
	}
	void xoa(CTPXDTO ctpx) {
		dsctpx.remove(ctpx);
	}
	void themCTPX() {
		CTPXDAO data = new CTPXDAO();
		try {			
				if(data.check1(CTPXList.get(CTPXList.size() - 1)) != true) data.them(CTPXList.get(CTPXList.size() - 1));
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
	void suaCTPX() {
		CTPXDAO data = new CTPXDAO();
		data.sua(CTPXGUI.ctpx);
	}
	void xoaCTPX() {
		CTPXDAO data = new CTPXDAO();
		for (CTPXDTO ctpx : CTPXBUS.CTPXList)
		{
			if(ctpx.getMaPX().equals(GUI.px.getMaPX())) data.xoa(ctpx);	
		}
	}
	void xoaCTPX2() {
		CTPXDAO data = new CTPXDAO();
		data.xoa2(CTPXGUI.ctpx);
	}
}
