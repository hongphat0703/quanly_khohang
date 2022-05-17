import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class CTPXGUI extends JFrame {
	DefaultTableModel modelCTPX = new DefaultTableModel();
	static CTPXDTO ctpx = new CTPXDTO();
	private JTextField txtSL;
	private JTextField txtDG;
	private JTextField txtTT;
	private JTable tblCTPX;
	private JComboBox comboBox;
	public CTPXGUI() {		
		setSize(800,600);
		setTitle("CHI TIẾT PHIẾU XUẤT");
		getContentPane().setLayout(null);
		
		JLabel lbl1 = new JLabel("Mã sản phẩm:");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl1.setBounds(10, 10, 130, 25);
		getContentPane().add(lbl1);
		
		JLabel lbl3 = new JLabel("Số lượng:");
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl3.setBounds(10, 45, 100, 25);
		getContentPane().add(lbl3);
		
		txtSL = new JTextField();
		txtSL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSL.setBounds(150, 45, 200, 25);
		getContentPane().add(txtSL);
		txtSL.setColumns(15);
		
		JLabel lbl4 = new JLabel("Đơn giá:");
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl4.setBounds(10, 80, 100, 25);
		getContentPane().add(lbl4);
		
		txtDG = new JTextField();
		txtDG.setEnabled(false);
		txtDG.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDG.setBounds(150, 80, 200, 25);
		getContentPane().add(txtDG);
		txtDG.setColumns(15);
		
		JLabel lbl5 = new JLabel("Thành tiền:");
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl5.setBounds(10, 115, 100, 25);
		getContentPane().add(lbl5);
		
		txtTT = new JTextField();
		txtTT.setEnabled(false);
		txtTT.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTT.setBounds(150, 115, 200, 25);
		getContentPane().add(txtTT);
		txtTT.setColumns(15);
		tblCTPX = new JTable();
		tblCTPX.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null}
				},
				new String[] {
					"Mã sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
				}
			));
		JScrollPane jSPCTPX = new JScrollPane();
		jSPCTPX.setBounds(10, 185, 766, 295);
		jSPCTPX.setViewportView(tblCTPX);
		getContentPane().add(jSPCTPX);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThem.setBounds(560, 10, 120, 25);
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
		btnSua.setBounds(560, 45, 120, 25);
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
		btnXoa.setBounds(560, 80, 120, 25);
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
		btnReset.setBounds(560, 115, 120, 25);
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
		btnThoat.setBounds(560, 150, 120, 25);
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
		btnLuu.setBounds(676, 490, 100, 25);
		getContentPane().add(btnLuu);
		
		DefaultComboBoxModel sp = new DefaultComboBoxModel();
		for(int i=0;i < SanPhamBUS.SanPhamList.size();i++ )
			sp.addElement(SanPhamBUS.SanPhamList.get(i).getmaSP() + " - " + SanPhamBUS.SanPhamList.get(i).gettenSP());
		comboBox = new JComboBox(sp);
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 15));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(150, 10, 200, 25);
		getContentPane().add(comboBox);
		
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
		btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMouseClicked(evt);
            }
        });
		tblCTPX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPXMouseClicked(evt);
            }
        });
		
		txtSL.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
				{
				int n = comboBox.getSelectedIndex();
				txtDG.setText(String.valueOf(SanPhamBUS.SanPhamList.get(n).getDonGia()));
				if(txtSL.getText().equals("") || txtDG.getText().equals("")) txtTT.setText("Lỗi!!");					
				else txtTT.setText(String.valueOf(Integer.parseInt(txtSL.getText()) * Double.parseDouble(txtDG.getText())));
				}
			}
		});
		if(CTPXBUS.dsctpx.size() != 0) chenbangCTPX(CTPXBUS.dsctpx);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {
		ctpx = new CTPXDTO();
		int n = comboBox.getSelectedIndex();
		ctpx.setMaSP(SanPhamBUS.SanPhamList.get(n).getmaSP());
		txtDG.setText(String.valueOf(SanPhamBUS.SanPhamList.get(n).getDonGia()));
		ctpx.setDongia(Double.parseDouble(txtDG.getText()));
		if(txtSL.getText().equals("")) JOptionPane.showMessageDialog(this, "Chưa nhập số lượng!!");
		else {
			if(txtDG.getText().equals("")) JOptionPane.showMessageDialog(this, "Chưa nhập đơn giá!!");
			else {			
				ctpx.setSoluong(Integer.parseInt(txtSL.getText()));
				txtTT.setText(String.valueOf(Integer.parseInt(txtSL.getText()) * Double.parseDouble(txtDG.getText())));
				ctpx.setThanhtien(Double.parseDouble(txtTT.getText()));
				CTPXBUS bus = new CTPXBUS();
				bus.them(ctpx);
				chenbangCTPX(CTPXBUS.dsctpx);	
				chenCTPX();
			}
		}
		defaultSet();
	}
	private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {
		int  i=tblCTPX.getSelectedRow();
    	if (i>=0){
    		ctpx = CTPXBUS.dsctpx.get(i);
    		CTPXDTO ctpx = new CTPXDTO();
    		ctpx = CTPXBUS.dsctpx.get(i);
    		System.out.print(CTPXBUS.dsctpx.get(i).getMaSP());
    		int n = comboBox.getSelectedIndex();
    		ctpx.setMaSP(SanPhamBUS.SanPhamList.get(n).getmaSP());
    		ctpx.setSoluong(Integer.parseInt(txtSL.getText()));
    		ctpx.setDongia(Double.parseDouble(txtDG.getText()));
    		txtTT.setText(String.valueOf(Integer.parseInt(txtSL.getText()) * Double.parseDouble(txtDG.getText())));
			ctpx.setThanhtien(Double.parseDouble(txtTT.getText()));
    		
			CTPXDTO old = CTPXBUS.dsctpx.set(i, ctpx);
    		modelCTPX.setValueAt(ctpx.getMaSP(), i, 0);
            modelCTPX.setValueAt(ctpx.getSoluong(), i, 1);
            modelCTPX.setValueAt(ctpx.getDongia(), i, 2);
            modelCTPX.setValueAt(ctpx.getThanhtien(), i, 3);
            tblCTPX.setModel(modelCTPX);
            
            CTPXBUS bus = new CTPXBUS();
            bus.suaCTPX();
        }
        else JOptionPane.showMessageDialog(this, "Chọn chi tiết cần sửa!");
    	defaultSet();
	}
	private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {
		int  i=tblCTPX.getSelectedRow();
		if (i>=0){
    		ctpx = CTPXBUS.dsctpx.get(i);
    		modelCTPX.removeRow(i);
    		CTPXBUS.CTPXList.remove(ctpx);
    		tblCTPX.setModel(modelCTPX);
    		
    		CTPXBUS bus = new CTPXBUS();
			bus.xoa(ctpx);
			bus.xoaCTPX2();
        }
        else JOptionPane.showMessageDialog(this, "Chọn chi tiết cần xóa!");
    	defaultSet();
	}
	private void btnResetMouseClicked(java.awt.event.MouseEvent evt) {
		defaultSet();
	}
	private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}
	private void defaultSet() {
		comboBox.setSelectedIndex(0);
		txtSL.setText("");
	    txtDG.setText("");
	    txtTT.setText("");
	}
	private void chenbangCTPX(ArrayList<CTPXDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã sản phẩm");    
	    header.add("Số lượng");
	    header.add("Đơn giá");
	    header.add("Thành tiền");
	    modelCTPX = new DefaultTableModel(header, 0);
	    for(CTPXDTO pn : kq) {
			Vector<String> row=new Vector<String>();
			row.add(pn.getMaSP());
		    row.add(String.valueOf(pn.getSoluong()));
		    row.add(String.valueOf(pn.getDongia()));
		    row.add(String.valueOf(pn.getThanhtien()));
		    modelCTPX.addRow(row);
		    tblCTPX.setModel(modelCTPX);
		}
	}
	private void chenCTPX() {
		int i=tblCTPX.getRowCount();
		int size = CTPXBUS.dsctpx.size();
		if(i < size) {
			for(int j = 0; j < (size -i); j++) {
			    Vector<String> row=new Vector<String>();
			    row.add(ctpx.getMaSP());
		        row.add(String.valueOf(ctpx.getSoluong()));
		        row.add(String.valueOf(ctpx.getDongia()));
		        row.add(String.valueOf(ctpx.getThanhtien()));
		       	modelCTPX.addRow(row);
		       	tblCTPX.setModel(modelCTPX);
			}
		}
	}
	private void tblCTPXMouseClicked(java.awt.event.MouseEvent evt) {
		int  i=tblCTPX.getSelectedRow();
	    if(i >= 0) {
	    	CTPXDTO ctpx = new CTPXDTO();
	    	ctpx = CTPXBUS.dsctpx.get(i);
	    	String str = ctpx.getMaSP();
	    	for(int j=0;j < SanPhamBUS.SanPhamList.size();j++ )
	    		if(SanPhamBUS.SanPhamList.get(j).getmaSP().equals(str)) comboBox.setSelectedIndex(j);
	    	txtSL.setText(String.valueOf(ctpx.getSoluong()));
	    	txtDG.setText(String.valueOf(ctpx.getDongia()));
	    	txtTT.setText(String.valueOf(ctpx.getThanhtien()));
	    }		    
	}
	private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {
		dispose();
		PXGUI.main(null);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanPhamBUS bus = new SanPhamBUS();
	            	if(SanPhamBUS.SanPhamList == null) bus.docDSSP();
	            	CTPXBUS bus1 = new CTPXBUS();
	            	if(CTPXBUS.CTPXList == null) bus1.docDSCTPX();
	            	
					CTPXGUI frame = new CTPXGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
