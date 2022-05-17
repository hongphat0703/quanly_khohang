import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

public class PNGUI extends JFrame {
	DefaultTableModel modelPN = new DefaultTableModel();
	static PNDTO pn = new PNDTO();
	private JPanel contentPane;
	private JTable tblPN;
	private JComboBox cbMaNV;
	private JComboBox cbMaNCC;
	private JComboBox cbMakho;
	private JTextField txtMaPN;
	private JTextField txtTT;
	private JDateChooser dateChooser;
	public PNGUI() {
		setSize(800,600);
		setTitle("PHIẾU NHẬP");
		getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Mã phiếu nhập:");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl1.setBounds(10, 10, 120, 25);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Mã nhân viên:");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl2.setBounds(10, 90, 120, 25);
		getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Mã nhà cung cấp:");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl3.setBounds(400, 10, 150, 25);
		getContentPane().add(lbl3);
		
		JLabel lbl4 = new JLabel("Ngày:");
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl4.setBounds(400, 90, 150, 25);
		getContentPane().add(lbl4);
		
		JLabel lbl5 = new JLabel("Tổng tiền:");
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl5.setBounds(400, 170, 150, 25);
		getContentPane().add(lbl5);

		tblPN = new JTable();
		tblPN.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
			        {null, null, null, null, null},
			        {null, null, null, null, null}
				},
				new String[] {
					"Mã phiếu nhập", "Mã nhân viên", "Mã nhà cung cấp", "Mã kho", "Ngày", "Tổng tiền"
				}
			));
		JScrollPane jSPPN = new JScrollPane();
		jSPPN.setBounds(10, 300, 766, 253);
		jSPPN.setViewportView(tblPN);
		getContentPane().add(jSPPN);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(10, 250, 120, 25);
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("Icon/them.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}	
		Image dimg = img.getScaledInstance(20, 20,Image.SCALE_SMOOTH);
		ImageIcon IconThem = new ImageIcon(dimg);
		btnThem.setIcon(IconThem);
		getContentPane().add(btnThem);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSua.setBounds(140, 250, 120, 25);
		try {
		    img = ImageIO.read(new File("Icon/sua.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}	
		dimg = img.getScaledInstance(20, 20,Image.SCALE_SMOOTH);
		ImageIcon IconSua = new ImageIcon(dimg);
		btnSua.setIcon(IconSua);
		getContentPane().add(btnSua);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoa.setBounds(270, 250, 120, 25);
		try {
		    img = ImageIO.read(new File("Icon/xoa.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}	
		dimg = img.getScaledInstance(20, 20,Image.SCALE_SMOOTH);
		ImageIcon IconXoa = new ImageIcon(dimg);
		btnXoa.setIcon(IconXoa);
		getContentPane().add(btnXoa);
		
		JButton btnReset = new JButton("Làm mới");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBounds(400, 250, 120, 25);
		try {
		    img = ImageIO.read(new File("Icon/reset.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}	
		dimg = img.getScaledInstance(20, 20,Image.SCALE_SMOOTH);
		ImageIcon IconReset = new ImageIcon(dimg);
		btnReset.setIcon(IconReset);
		getContentPane().add(btnReset);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoat.setBounds(530, 250, 120, 25);
		try {
		    img = ImageIO.read(new File("Icon/thoat.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}	
		dimg = img.getScaledInstance(20, 20,Image.SCALE_SMOOTH);
		ImageIcon IconThoat = new ImageIcon(dimg);
		btnThoat.setIcon(IconThoat);
		getContentPane().add(btnThoat);
		
		JButton btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLuu.setBounds(660, 250, 120, 25);
		getContentPane().add(btnLuu);
		
		DefaultComboBoxModel nv = new DefaultComboBoxModel();
		for(int i=0;i < NVBUS.NVList.size();i++ )
			nv.addElement(NVBUS.NVList.get(i).getMaNV() + " - " + NVBUS.NVList.get(i).getTenNV());
		cbMaNV = new JComboBox(nv);
		cbMaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbMaNV.setSelectedIndex(0);
		cbMaNV.setBounds(150, 90, 200, 25);
		getContentPane().add(cbMaNV);
		
		txtMaPN = new JTextField();
		txtMaPN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaPN.setBounds(150, 10, 200, 25);
		getContentPane().add(txtMaPN);
		txtMaPN.setColumns(10);
		
		txtTT = new JTextField();
		txtTT.setEnabled(false);
		txtTT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTT.setBounds(560, 170, 200, 25);
		getContentPane().add(txtTT);
		txtTT.setColumns(10);
		
		DefaultComboBoxModel ncc = new DefaultComboBoxModel();
		for(int i=0;i < NCCBUS.NCCList.size();i++ )
			ncc.addElement(NCCBUS.NCCList.get(i).getMaNCC() + " - " + NCCBUS.NCCList.get(i).getTenNCC());
		cbMaNCC = new JComboBox(ncc);
		cbMaNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbMaNCC.setBounds(560, 10, 200, 25);
		getContentPane().add(cbMaNCC);
		
		dateChooser = new JDateChooser();
		dateChooser.setDateFormatString("yyyy-MM-dd");
		dateChooser.setBounds(560, 90, 200, 25);
		getContentPane().add(dateChooser);
		
		JLabel lbl6 = new JLabel("Mã kho:");
		lbl6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl6.setBounds(10, 170, 130, 25);
		getContentPane().add(lbl6);
		
		DefaultComboBoxModel kho = new DefaultComboBoxModel();
		for(int i=0;i < KhoHangBUS.KhoHangList.size();i++ )
			kho.addElement(KhoHangBUS.KhoHangList.get(i).getMaKho() + " - " + KhoHangBUS.KhoHangList.get(i).getTenKho());
		cbMakho = new JComboBox(kho);
		cbMakho.setBounds(150, 170, 200, 25);
		getContentPane().add(cbMakho);
		
		btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThemMouseClicked(evt);
            }
        });
		btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSuaMouseClicked(evt);
            }
        });
		btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnXoaMouseClicked(evt);
            }
        });
		btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMouseClicked(evt);
            }
        });
		btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnResetMouseClicked(evt);
            }
        });
		btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });
		
		Double tong = 0.0;
		for(CTPNDTO ctpn : CTPNBUS.dsctpn)
		{
			tong = tong + ctpn.getThanhtien();
		}
		txtTT.setText(String.valueOf(tong));
		PNBUS.dspn = PNBUS.PNList;      
		chenbangPN(PNBUS.dspn);
		if(GUI.pn.getMaPN().equals("") != true) setPN(GUI.pn);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {
		pn = new PNDTO();
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		int a = cbMaNV.getSelectedIndex();
		pn.setMaNV(NVBUS.NVList.get(a).getMaNV());
		int b = cbMaNCC.getSelectedIndex();
		pn.setMaNCC(NCCBUS.NCCList.get(b).getMaNCC());
		int c = cbMakho.getSelectedIndex();
		pn.setMaKho(KhoHangBUS.KhoHangList.get(c).getMaKho());
		if(txtMaPN.getText().equals("")) JOptionPane.showMessageDialog(this, "Chưa nhập mã phiếu nhập!!");
		else {
			if(dateChooser.getDate() == null) JOptionPane.showMessageDialog(this, "Chưa chọn ngày nhập sản phẩm!!");
			else {
				pn.setMaPN(txtMaPN.getText());
				pn.setNgay(date.format(dateChooser.getDate()));
				pn.setTongTien(Double.parseDouble(txtTT.getText()));
		       	PNBUS bus = new PNBUS();
		       	bus.themPN();
		       	PNBUS.dspn = PNBUS.PNList;
		       	chenbangPN(PNBUS.dspn);
		       	chenPN();
		       	for (CTPNDTO ctpn : CTPNBUS.dsctpn)
		       	{
		       		ctpn.setMaPN(txtMaPN.getText());
		       		CTPNBUS.CTPNList.add(ctpn);
		       		CTPNBUS bus1 = new CTPNBUS();
			       	bus1.themCTPN();
		       	}		       	
			}
		}
		defaultSet();
	}
	private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		int  i=tblPN.getSelectedRow();
    	if (i>=0){
    		pn = PNBUS.PNList.get(i);
    		PNDTO pn = new PNDTO();
    		pn = PNBUS.PNList.get(i);
    		pn.setMaPN(txtMaPN.getText());
    		int a = cbMaNV.getSelectedIndex();
    		pn.setMaNV(NVBUS.NVList.get(a).getMaNV());
    		int b = cbMaNV.getSelectedIndex();
    		pn.setMaKho(KhoHangBUS.KhoHangList.get(b).getMaKho());
    		int c = cbMaNCC.getSelectedIndex();
    		pn.setMaNCC(NCCBUS.NCCList.get(c).getMaNCC());
    		pn.setNgay(date.format(dateChooser.getDate()));
    		pn.setTongTien(Double.parseDouble(txtTT.getText()));
    			
    		PNDTO old = PNBUS.PNList.set(i, pn);
    		modelPN.setValueAt(pn.getMaPN(), i, 0);
            modelPN.setValueAt(pn.getMaNV(), i, 1);
            modelPN.setValueAt(pn.getMaNCC(), i, 2);
            modelPN.setValueAt(pn.getMaKho(), i, 3);
            modelPN.setValueAt(pn.getNgay(), i, 4);
            modelPN.setValueAt(pn.getTongTien(), i, 5);
            tblPN.setModel(modelPN);
            
            PNBUS bus = new PNBUS();
            bus.suaPN();   
            for (int u=0; u < CTPNBUS.dsctpn.size() ;u++)
            {
            	for (int v=0; v < CTPNBUS.dsctpn.size() ;v++)
                {
                	if((CTPNBUS.dsctpn.get(u).getMaPN().equals(CTPNBUS.dsctpn.get(v).getMaPN()) != true) && (CTPNBUS.dsctpn.get(u).getMaSP().equals(CTPNBUS.dsctpn.get(v).getMaSP()) != true))
                	{
                		CTPNDTO ctpn = CTPNBUS.dsctpn.get(v);
                		ctpn.setMaPN(txtMaPN.getText());
        	       		CTPNBUS.CTPNList.add(ctpn);
        	       		CTPNBUS bus1 = new CTPNBUS();
        		       	bus1.suaCTPN();
        		       	bus1.themCTPN();
                	}
                }   
            }
        }
        else JOptionPane.showMessageDialog(this, "Chọn phiếu nhập cần sửa!");
    	defaultSet();
	}
	private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {
		int  i=tblPN.getSelectedRow();	        
    	if (i>=0){
    		pn = PNBUS.PNList.get(i);
    		modelPN.removeRow(i);
    		PNBUS.PNList.remove(i);
    		tblPN.setModel(modelPN);
    		
    		CTPNBUS bus = new CTPNBUS();
    		bus.xoaCTPN();
    		PNBUS bus1 = new PNBUS();
    		bus1.xoaPN();
        }
        else JOptionPane.showMessageDialog(this, "Chọn phiếu nhập cần xóa!");
    	defaultSet();
	}
	private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {
		defaultSet();
	}
	private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {
		for(int i = 0; i < SanPhamBUS.SanPhamList.size();i++)
		{
			for(int j = 0;j < CTPNBUS.CTPNList.size();j++)
			{
				GUI.sp = SanPhamBUS.SanPhamList.get(i);
				String maPN = CTPNBUS.CTPNList.get(j).getMaPN();
				if(GUI.sp.getmaSP().equals(CTPNBUS.CTPNList.get(j).getMaSP()) && PNBUS.PNList.get(PNBUS.PNList.size()-1).getMaPN().equals(maPN)) 
					GUI.sp.setSoLuong(GUI.sp.getSoLuong() + CTPNBUS.CTPNList.get(j).getSoluong());
				SanPhamBUS bus = new SanPhamBUS();
				bus.suaSP();
			}
		}	
		dispose();
		GUI.main(null);
	}
	private void chenbangPN(ArrayList<PNDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã phiếu nhập");    
	    header.add("Mã nhân viên");
	    header.add("Mã nhà cung cấp");
	    header.add("Mã kho");
	    header.add("Ngày");
	    header.add("Tổng tiền");
	    modelPN = new DefaultTableModel(header, 0);
	    for(PNDTO pn : kq) {
			Vector<String> row=new Vector<String>();
			row.add(pn.getMaPN());
		    row.add(pn.getMaNV());
		    row.add(pn.getMaNCC());
		    row.add(pn.getMaKho());
		    row.add(pn.getNgay());
		    row.add(String.valueOf(pn.getTongTien()));
		    modelPN.addRow(row);
		    tblPN.setModel(modelPN);
		}
	}
	private void chenPN() {
		int i=tblPN.getRowCount();
		int size = PNBUS.PNList.size();
		if(i < size) {
			for(int j = 0; j < (size -i); j++) {
			    Vector<String> row=new Vector<String>();
			    row.add(pn.getMaPN());
		        row.add(pn.getMaNV());
		        row.add(pn.getMaNCC());
		        row.add(pn.getNgay());
		        row.add(String.valueOf(pn.getTongTien()));
		       	modelPN.addRow(row);
		       	tblPN.setModel(modelPN);
			}
		}
	}
	private void defaultSet() {
		txtMaPN.setText("");
		cbMaNV.setSelectedIndex(0);
		cbMakho.setSelectedIndex(0);
		cbMaNCC.setSelectedIndex(0);
		dateChooser.setDate(null);
		txtTT.setText("");
	}
	private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}
	private void setPN(PNDTO pn) {
		txtMaPN.setText(pn.getMaPN());
    	for(int j=0;j < NVBUS.NVList.size();j++ )
    		if(NVBUS.NVList.get(j).getMaNV().equals(pn.getMaNV())) cbMaNV.setSelectedIndex(j);
    	for(int j=0;j < NCCBUS.NCCList.size();j++ )
    		if(NCCBUS.NCCList.get(j).getMaNCC().equals(pn.getMaNCC())) cbMaNCC.setSelectedIndex(j);
    	for(int j=0;j < KhoHangBUS.KhoHangList.size();j++ )
    		if(KhoHangBUS.KhoHangList.get(j).getMaKho().equals(pn.getMaKho())) cbMakho.setSelectedIndex(j);
    	 Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(pn.getNgay());
			} catch (ParseException e) {
				e.printStackTrace();
			}
		    dateChooser.setDate(date);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NVBUS bus = new NVBUS();
	            	if(NVBUS.NVList == null) bus.docDSNV();
	            	NCCBUS bus1 = new NCCBUS();
	            	if(NCCBUS.NCCList == null) bus1.docDSNCC();
	            	PNBUS bus2 = new PNBUS();
	            	if(PNBUS.PNList == null) bus2.docDSPN();
	            	KhoHangBUS bus3 = new KhoHangBUS();
	            	if(KhoHangBUS.KhoHangList == null) bus3.docDSKho();
	            	
					PNGUI frame = new PNGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
