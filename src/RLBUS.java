import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RLBUS {
	static ArrayList<RLDTO> RLList;
	static ArrayList<RLDTO> dstk;
	
	RLBUS(){}
	void docDSTK() {
		RLDAO data = new RLDAO();
		if(RLList == null ) RLList = new ArrayList<RLDTO>();
		RLList = data.docDSTK();
	}
	void dangki() {
		RLDAO data = new RLDAO();
		try {
			if(data.check2(Register.tk)) {
				JOptionPane.showMessageDialog(null, "Username is exist");
			}
			else {
				if(data.check1(Register.tk)) JOptionPane.showMessageDialog(null, "Gmail is exist");  
				else {
					data.reg(Register.tk);
					
			}			
			}
			
		}
		catch (HeadlessException e) {
			e.printStackTrace();
		}
	}
}


