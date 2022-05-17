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

public class CTPNGUI extends JFrame {
	DefaultTableModel modelCTPN = new DefaultTableModel();
	static CTPNDTO ctpn = new CTPNDTO();
	private JTextField txtSL;
	private JTextField txtDG;
	private JTextField txtTT;
	private JTable tblCTPN;
	private JComboBox comboBox;
	public CTPNGUI() {		
		setSize(800,600);
		setTitle("CHI TIẾT PHIẾU NHẬP");
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
		tblCTPN = new JTable();
		tblCTPN.setModel(new DefaultTableModel(
				new Object[][] {
					{null, null, null, null},
			        {null, null, null, null},
			        {null, null, null, null}
				},
				new String[] {
					"Mã sản phẩm", "Số lượng", "Đơn giá", "Thành tiền"
				}
			));
		JScrollPane jSPCTPN = new JScrollPane();
		jSPCTPN.setBounds(10, 185, 766, 295);
		jSPCTPN.setViewportView(tblCTPN);
		getContentPane().add(jSPCTPN);
		
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
		tblCTPN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTPNMouseClicked(evt);
            }
        });
		
		txtSL.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER)
					txtDG.requestFocus();
			}
		});
		txtDG.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					if(txtSL.getText().equals("") || txtDG.getText().equals("")) txtTT.setText("Lỗi!!");					
					else txtTT.setText(String.valueOf(Integer.parseInt(txtSL.getText()) * Double.parseDouble(txtDG.getText())));
			
				}
			}
		});	
		if(CTPNBUS.dsctpn.size() != 0) chenbangCTPN(CTPNBUS.dsctpn);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	private void btnThemMouseClicked(java.awt.event.MouseEvent evt) {
		ctpn = new CTPNDTO();
		int n = comboBox.getSelectedIndex();
		ctpn.setMaSP(SanPhamBUS.SanPhamList.get(n).getmaSP());
		if(txtSL.getText().equals("")) JOptionPane.showMessageDialog(this, "Chưa nhập số lượng!!");
		else {
			if(txtDG.getText().equals("")) JOptionPane.showMessageDialog(this, "Chưa nhập đơn giá!!");
			else {			
				ctpn.setSoluong(Integer.parseInt(txtSL.getText()));
				ctpn.setDongia(Double.parseDouble(txtDG.getText()));
				txtTT.setText(String.valueOf(Integer.parseInt(txtSL.getText()) * Double.parseDouble(txtDG.getText())));
				ctpn.setThanhtien(Double.parseDouble(txtTT.getText()));
				CTPNBUS bus = new CTPNBUS();
				bus.them(ctpn);
				chenbangCTPN(CTPNBUS.dsctpn);	
				chenCTPN();
			}
		}
		defaultSet();
	}
	private void btnSuaMouseClicked(java.awt.event.MouseEvent evt) {
		int  i=tblCTPN.getSelectedRow();
    	if (i>=0){
    		ctpn = CTPNBUS.dsctpn.get(i);
    		CTPNDTO ctpn = new CTPNDTO();
    		ctpn = CTPNBUS.dsctpn.get(i);
    		System.out.print(CTPNBUS.dsctpn.get(i).getMaSP());
    		int n = comboBox.getSelectedIndex();
    		ctpn.setMaSP(SanPhamBUS.SanPhamList.get(n).getmaSP());
    		ctpn.setSoluong(Integer.parseInt(txtSL.getText()));
    		ctpn.setDongia(Double.parseDouble(txtDG.getText()));
    		txtTT.setText(String.valueOf(Integer.parseInt(txtSL.getText()) * Double.parseDouble(txtDG.getText())));
			ctpn.setThanhtien(Double.parseDouble(txtTT.getText()));
    		
			CTPNDTO old = CTPNBUS.dsctpn.set(i, ctpn);
    		modelCTPN.setValueAt(ctpn.getMaSP(), i, 0);
            modelCTPN.setValueAt(ctpn.getSoluong(), i, 1);
            modelCTPN.setValueAt(ctpn.getDongia(), i, 2);
            modelCTPN.setValueAt(ctpn.getThanhtien(), i, 3);
            tblCTPN.setModel(modelCTPN);
            
            CTPNBUS bus = new CTPNBUS();
            bus.suaCTPN();
        }
        else JOptionPane.showMessageDialog(this, "Chọn chi tiết cần sửa!");
    	defaultSet();
	}
	private void btnXoaMouseClicked(java.awt.event.MouseEvent evt) {
		int  i=tblCTPN.getSelectedRow();
		if (i>=0){
    		ctpn = CTPNBUS.dsctpn.get(i);
    		modelCTPN.removeRow(i);
    		CTPNBUS.CTPNList.remove(ctpn);
    		tblCTPN.setModel(modelCTPN);
    		
    		CTPNBUS bus = new CTPNBUS();
			bus.xoa(ctpn);
			bus.xoaCTPN2();
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
	private void chenbangCTPN(ArrayList<CTPNDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã sản phẩm");    
	    header.add("Số lượng");
	    header.add("Đơn giá");
	    header.add("Thành tiền");
	    modelCTPN = new DefaultTableModel(header, 0);
	    for(CTPNDTO pn : kq) {
			Vector<String> row=new Vector<String>();
			row.add(pn.getMaSP());
		    row.add(String.valueOf(pn.getSoluong()));
		    row.add(String.valueOf(pn.getDongia()));
		    row.add(String.valueOf(pn.getThanhtien()));
		    modelCTPN.addRow(row);
		    tblCTPN.setModel(modelCTPN);
		}
	}
	private void chenCTPN() {
		int i=tblCTPN.getRowCount();
		int size = CTPNBUS.dsctpn.size();
		if(i < size) {
			for(int j = 0; j < (size -i); j++) {
			    Vector<String> row=new Vector<String>();
			    row.add(ctpn.getMaSP());
		        row.add(String.valueOf(ctpn.getSoluong()));
		        row.add(String.valueOf(ctpn.getDongia()));
		        row.add(String.valueOf(ctpn.getThanhtien()));
		       	modelCTPN.addRow(row);
		       	tblCTPN.setModel(modelCTPN);
			}
		}
	}
	private void tblCTPNMouseClicked(java.awt.event.MouseEvent evt) {
		int  i=tblCTPN.getSelectedRow();
	    if(i >= 0) {
	    	CTPNDTO ctpn = new CTPNDTO();
	    	ctpn = CTPNBUS.dsctpn.get(i);
	    	String str = ctpn.getMaSP();
	    	for(int j=0;j < SanPhamBUS.SanPhamList.size();j++ )
	    		if(SanPhamBUS.SanPhamList.get(j).getmaSP().equals(str)) comboBox.setSelectedIndex(j);
	    	txtSL.setText(String.valueOf(ctpn.getSoluong()));
	    	txtDG.setText(String.valueOf(ctpn.getDongia()));
	    	txtTT.setText(String.valueOf(ctpn.getThanhtien()));
	    }		    
	}
	private void btnLuuMouseClicked(java.awt.event.MouseEvent evt) {
		dispose();
		PNGUI.main(null);
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SanPhamBUS bus = new SanPhamBUS();
	            	if(SanPhamBUS.SanPhamList == null) bus.docDSSP();
	            	CTPNBUS bus1 = new CTPNBUS();
	            	if(CTPNBUS.CTPNList == null) bus1.docDSCTPN();
	            	
					CTPNGUI frame = new CTPNGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
