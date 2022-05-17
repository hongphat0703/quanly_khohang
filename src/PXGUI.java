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

public class PXGUI extends JFrame {
	DefaultTableModel modelPX = new DefaultTableModel();
	static PXDTO px = new PXDTO();
	private JPanel contentPane;
	private JTable tblPX;
	private JComboBox cbMaNV;
	private JComboBox cbMaKH;
	private JComboBox cbMakho;
	private JTextField txtMaPX;
	private JTextField txtTT;
	private JDateChooser dateChooser;
	public PXGUI() {
		setSize(800,600);
		setTitle("PHIẾU XUẤT");
		getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Mã phiếu xuất:");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl1.setBounds(10, 10, 120, 25);
		getContentPane().add(lbl1);
		
		JLabel lbl2 = new JLabel("Mã nhân viên:");
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl2.setBounds(10, 90, 120, 25);
		getContentPane().add(lbl2);
		
		JLabel lbl3 = new JLabel("Mã khách hàng:");
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

		tblPX = new JTable();
		tblPX.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null, null},
			        {null, null, null, null, null},
			        {null, null, null, null, null}
				},
				new String[] {
					"Mã phiếu xuất", "Mã nhân viên", "Mã khách hàng", "Mã kho", "Ngày", "Tổng tiền"
				}
			));
		JScrollPane jSPPX = new JScrollPane();
		jSPPX.setBounds(10, 300, 766, 253);
		jSPPX.setViewportView(tblPX);
		getContentPane().add(jSPPX);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(10, 250, 120, 25);
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("C:\\Icon\\them.png"));
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
		    img = ImageIO.read(new File("C:\\Icon\\sua.png"));
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
		    img = ImageIO.read(new File("C:\\Icon\\xoa.png"));
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
		    img = ImageIO.read(new File("C:\\Icon\\reset.png"));
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
		    img = ImageIO.read(new File("C:\\Icon\\thoat.png"));
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
		
		txtMaPX = new JTextField();
		txtMaPX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaPX.setBounds(150, 10, 200, 25);
		getContentPane().add(txtMaPX);
		txtMaPX.setColumns(10);
		
		txtTT = new JTextField();
		txtTT.setEnabled(false);
		txtTT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTT.setBounds(560, 170, 200, 25);
		getContentPane().add(txtTT);
		txtTT.setColumns(10);
		
		DefaultComboBoxModel kh = new DefaultComboBoxModel();
		for(int i=0;i < KHBUS.KHList.size();i++ )
			kh.addElement(KHBUS.KHList.get(i).getMaKH() + " - " + KHBUS.KHList.get(i).getTenKH());
		cbMaKH = new JComboBox(kh);
		cbMaKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		cbMaKH.setBounds(560, 10, 200, 25);
		getContentPane().add(cbMaKH);
		
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
		for(CTPXDTO ctpx : CTPXBUS.dsctpx)
		{
			tong = tong + ctpx.getThanhtien();
		}
		txtTT.setText(String.valueOf(tong));
		PXBUS.dspx = PXBUS.PXList;      
		chenbangPX(PXBUS.dspx);
		if(GUI.px.getMaPX().equals("") != true) setPX(GUI.px);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {
		px = new PXDTO();
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		int a = cbMaNV.getSelectedIndex();
		px.setMaNV(NVBUS.NVList.get(a).getMaNV());
		int b = cbMaKH.getSelectedIndex();
		px.setMaKH(KHBUS.KHList.get(b).getMaKH());
		int c = cbMakho.getSelectedIndex();
		px.setMaKho(KhoHangBUS.KhoHangList.get(c).getMaKho());
		if(txtMaPX.getText().equals("")) JOptionPane.showMessageDialog(this, "Chưa nhập mã phiếu nhập!!");
		else {
			if(dateChooser.getDate() == null) JOptionPane.showMessageDialog(this, "Chưa chọn ngày nhập sản phẩm!!");
			else {
				px.setMaPX(txtMaPX.getText());
				px.setNgay(date.format(dateChooser.getDate()));
				px.setTongTien(Double.parseDouble(txtTT.getText()));
		       	PXBUS bus = new PXBUS();
		       	bus.themPX();
		       	PXBUS.dspx = PXBUS.PXList;
		       	chenbangPX(PXBUS.dspx);
		       	chenPX();
		       	for (CTPXDTO ctpx : CTPXBUS.dsctpx)
		       	{
		       		ctpx.setMaPX(txtMaPX.getText());
		       		CTPXBUS.CTPXList.add(ctpx);
		       		CTPXBUS bus1 = new CTPXBUS();
			       	bus1.themCTPX();
		       	}		       	
			}
		}
		defaultSet();
	}
	private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		int  i=tblPX.getSelectedRow();
    	if (i>=0){
    		px = PXBUS.PXList.get(i);
    		PXDTO px = new PXDTO();
    		px = PXBUS.PXList.get(i);
    		px.setMaPX(txtMaPX.getText());
    		int a = cbMaNV.getSelectedIndex();
    		px.setMaNV(NVBUS.NVList.get(a).getMaNV());
    		int b = cbMaNV.getSelectedIndex();
    		px.setMaKho(KhoHangBUS.KhoHangList.get(b).getMaKho());
    		int c = cbMaKH.getSelectedIndex();
    		px.setMaKH(KHBUS.KHList.get(c).getMaKH());
    		px.setNgay(date.format(dateChooser.getDate()));
    		px.setTongTien(Double.parseDouble(txtTT.getText()));
    			
    		PXDTO old = PXBUS.PXList.set(i, px);
    		modelPX.setValueAt(px.getMaPX(), i, 0);
            modelPX.setValueAt(px.getMaNV(), i, 1);
            modelPX.setValueAt(px.getMaKH(), i, 2);
            modelPX.setValueAt(px.getMaKho(), i, 3);
            modelPX.setValueAt(px.getNgay(), i, 4);
            modelPX.setValueAt(px.getTongTien(), i, 5);
            tblPX.setModel(modelPX);
            
            PXBUS bus = new PXBUS();
            bus.suaPX();   
            for (int u=0; u < CTPXBUS.dsctpx.size() ;u++)
            {
            	for (int v=0; v < CTPXBUS.dsctpx.size() ;v++)
                {
                	if((CTPXBUS.dsctpx.get(u).getMaPX().equals(CTPXBUS.dsctpx.get(v).getMaPX()) != true) && (CTPXBUS.dsctpx.get(u).getMaSP().equals(CTPXBUS.dsctpx.get(v).getMaSP()) != true))
                	{
                		CTPXDTO ctpx = CTPXBUS.dsctpx.get(v);
                		ctpx.setMaPX(txtMaPX.getText());
        	       		CTPXBUS.CTPXList.add(ctpx);
        	       		CTPXBUS bus1 = new CTPXBUS();
        		       	bus1.suaCTPX();
        		       	bus1.themCTPX();
                	}
                }   
            }
        }
        else JOptionPane.showMessageDialog(this, "Chọn phiếu nhập cần sửa!");
    	defaultSet();
	}
	private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {
		int  i=tblPX.getSelectedRow();	        
    	if (i>=0){
    		px = PXBUS.PXList.get(i);
    		modelPX.removeRow(i);
    		PXBUS.PXList.remove(i);
    		tblPX.setModel(modelPX);
    		
    		CTPXBUS bus = new CTPXBUS();
    		bus.xoaCTPX();
    		PXBUS bus1 = new PXBUS();
    		bus1.xoaPX();
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
			for(int j = 0;j < CTPXBUS.CTPXList.size();j++)
			{
				GUI.sp = SanPhamBUS.SanPhamList.get(i);
				String maPX = CTPXBUS.CTPXList.get(j).getMaPX();
				if(GUI.sp.getmaSP().equals(CTPXBUS.CTPXList.get(j).getMaSP()) && PXBUS.PXList.get(PXBUS.PXList.size()-1).getMaPX().equals(maPX)) 
					GUI.sp.setSoLuong(GUI.sp.getSoLuong() - CTPXBUS.CTPXList.get(j).getSoluong());
				SanPhamBUS bus = new SanPhamBUS();
				bus.suaSP();
			}
		}	
		dispose();
		GUI.main(null);
	}
	private void chenbangPX(ArrayList<PXDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã phiếu nhập");    
	    header.add("Mã nhân viên");
	    header.add("Mã khách hàng");
	    header.add("Mã kho");
	    header.add("Ngày");
	    header.add("Tổng tiền");
	    modelPX = new DefaultTableModel(header, 0);
	    for(PXDTO px : kq) {
			Vector<String> row=new Vector<String>();
			row.add(px.getMaPX());
		    row.add(px.getMaNV());
		    row.add(px.getMaKH());
		    row.add(px.getMaKho());
		    row.add(px.getNgay());
		    row.add(String.valueOf(px.getTongTien()));
		    modelPX.addRow(row);
		    tblPX.setModel(modelPX);
		}
	}
	private void chenPX() {
		int i=tblPX.getRowCount();
		int size = PXBUS.PXList.size();
		if(i < size) {
			for(int j = 0; j < (size -i); j++) {
			    Vector<String> row=new Vector<String>();
			    row.add(px.getMaPX());
		        row.add(px.getMaNV());
		        row.add(px.getMaKH());
		        row.add(px.getNgay());
		        row.add(String.valueOf(px.getTongTien()));
		       	modelPX.addRow(row);
		       	tblPX.setModel(modelPX);
			}
		}
	}
	private void defaultSet() {
		txtMaPX.setText("");
		cbMaNV.setSelectedIndex(0);
		cbMakho.setSelectedIndex(0);
		cbMaKH.setSelectedIndex(0);
		dateChooser.setDate(null);
		txtTT.setText("");
	}
	private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}
	private void setPX(PXDTO px) {
		txtMaPX.setText(px.getMaPX());
    	for(int j=0;j < NVBUS.NVList.size();j++ )
    		if(NVBUS.NVList.get(j).getMaNV().equals(px.getMaNV())) cbMaNV.setSelectedIndex(j);
    	for(int j=0;j < KHBUS.KHList.size();j++ )
    		if(KHBUS.KHList.get(j).getMaKH().equals(px.getMaKH())) cbMaKH.setSelectedIndex(j);
    	for(int j=0;j < KhoHangBUS.KhoHangList.size();j++ )
    		if(KhoHangBUS.KhoHangList.get(j).getMaKho().equals(px.getMaKho())) cbMakho.setSelectedIndex(j);
    	 Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(px.getNgay());
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
	            	KHBUS bus1 = new KHBUS();
	            	if(KHBUS.KHList == null) bus1.docDSKH();
	            	PXBUS bus2 = new PXBUS();
	            	if(PXBUS.PXList == null) bus2.docDSPX();
	            	KhoHangBUS bus3 = new KhoHangBUS();
	            	if(KhoHangBUS.KhoHangList == null) bus3.docDSKho();
	            	
					PXGUI frame = new PXGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
