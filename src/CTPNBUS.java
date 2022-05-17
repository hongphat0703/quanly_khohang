import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class CTPNBUS {
	static ArrayList<CTPNDTO> CTPNList ;
	static ArrayList<CTPNDTO> dsctpn = new ArrayList<CTPNDTO>();
	CTPNBUS(){}
	void docDSCTPN() {
		 CTPNDAO data = new CTPNDAO();
		 if(CTPNList == null ) CTPNList = new ArrayList<CTPNDTO>();
		 CTPNList = data.docDSCTPN();
	}
	void them(CTPNDTO ctpn) {
		dsctpn.add(ctpn);
	}
	void xoa(CTPNDTO ctpn) {
		dsctpn.remove(ctpn);
	}
	void themCTPN() {
		CTPNDAO data = new CTPNDAO();
		try {			
				if(data.check1(CTPNList.get(CTPNList.size() - 1)) != true) data.them(CTPNList.get(CTPNList.size() - 1));
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
	void suaCTPN() {
		CTPNDAO data = new CTPNDAO();
		data.sua(CTPNGUI.ctpn);
	}
	void xoaCTPN() {
		CTPNDAO data = new CTPNDAO();
		for (CTPNDTO ctpn : CTPNBUS.CTPNList)
		{
			if(ctpn.getMaPN().equals(GUI.pn.getMaPN())) data.xoa(ctpn);	
		}
	}
	void xoaCTPN2() {
		CTPNDAO data = new CTPNDAO();
		data.xoa2(CTPNGUI.ctpn);
	}
}
