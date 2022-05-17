import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.toedter.calendar.*;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JScrollBar;


public class GUI extends JFrame {
	
	DefaultTableModel modelSP = new DefaultTableModel();
	DefaultTableModel modelKho = new DefaultTableModel();
	DefaultTableModel modelNCC = new DefaultTableModel();
	DefaultTableModel modelNSX = new DefaultTableModel();
	DefaultTableModel modelPN = new DefaultTableModel();
	DefaultTableModel modelCTPN = new DefaultTableModel();
	DefaultTableModel modelPX = new DefaultTableModel();
	DefaultTableModel modelCTPX = new DefaultTableModel();
	DefaultTableModel modelNV = new DefaultTableModel();
	DefaultTableModel modelKH = new DefaultTableModel();
	DefaultTableModel modelTK = new DefaultTableModel();
	static SanPhamDTO sp = new SanPhamDTO();
	static KhoHangDTO kho = new KhoHangDTO();
	static NCCDTO ncc = new NCCDTO();
	static NSXDTO nsx = new NSXDTO();
	static NVDTO nv = new NVDTO();
	static KHDTO kh = new KHDTO();
	static PNDTO pn = new PNDTO();
	static PXDTO px = new PXDTO();
	private JPanel pNorth;
	private JPanel pWest;
	private JPanel pCenter;
	private JPanel pQLKho;
	private JPanel pQLSP;
	private JPanel pQLNCC;
	private JPanel pQLNSX;
	private JPanel pQLPN;
	private JPanel pQLPX;
	private JPanel pQLNV;
	private JPanel pQLKH;
	private JTable tblKho;
	private JTable tblSP;
	private JTable tblNCC;
	private JTable tblNSX;
	private JTable tblPN;
	private JTable tblCTPN;
	private JTable tblPX;
	private JTable tblCTPX;
	private JTable tblNV;
	private JTable tblKH;
	private JLabel lbltitle;
	private CardLayout card;
	private JTextField txtMaSP_SP;
	private JTextField txtTenSP_SP;
	private JTextField txtDGSP_SP;
	private JTextField txtSLSP_SP;
	private JTextField txtMaNSX_SP;
	private JTextField txtTimSP_SP;
	private JTextField txtMaKho_Kho;
	private JTextField txtTenKho_Kho;
	private JTextField txtDCKho_Kho;
	private JTextField txtDTKho_Kho;
	private JTextField txtTimKho_Kho;
	private JTextField txtMaNCC_NCC;
	private JTextField txtTenNCC_NCC;
	private JTextField txtDCNCC_NCC;
	private JTextField txtDTNCC_NCC;
	private JTextField txtTimNCC_NCC;
	private JTextField txtMaNSX_NSX;
	private JTextField txtTenNSX_NSX;
	private JTextField txtDCNSX_NSX;
	private JTextField txtDTNSX_NSX;
	private JTextField txtTimNSX_NSX;
	private JTextField txtMaNV_NV;
	private JTextField txtHoNV_NV;
	private JTextField txtTenNV_NV;
	private JTextField txtDCNV_NV;
	private JTextField txtDTNV_NV;
	private JTextField txtLuongNV_NV;
	private JTextField txtTimNV_NV;
	private JTextField txtMaKH_KH;
	private JTextField txtHoKH_KH;
	private JTextField txtTenKH_KH;
	private JTextField txtDCKH_KH;
	private JTextField txtDTKH_KH;
	private JTextField txtTimKH_KH;
	private JTextField txtTimPN_PN;
	private JTextField txtTimPX_PX;
	private JComboBox<?> cbDVSP;
	private JComboBox<?> comboBoxSX;
	private JComboBox<?> comboBoxTim;
	private JComboBox<?> cbSXKho;
	private JComboBox<?> cbTimKho;
	private JComboBox<?> cbSXNCC;
	private JComboBox<?> cbTimNCC;
	private JComboBox<?> cbSXNSX;
	private JComboBox<?> cbTimNSX;
	private JComboBox<?> cbSXNV;
	private JComboBox<?> cbTimNV;
	private JComboBox<?> cbSXKH;
	private JComboBox<?> cbTimKH;
	private JComboBox<?> cbTimPN;
	private JComboBox<?> cbTimPX;
	private JDateChooser NSNV_NV;

	public GUI() {
		init();
		
	}

	public void init() {
		setSize(1200, 800);
		setTitle("Admin");
		getContentPane().setLayout(new BorderLayout());
		pNorth = new JPanel();
		pNorth.setBackground(new Color(72, 209, 204));
		pNorth.setForeground(new Color(0, 0, 0));
		getContentPane().add(pNorth, BorderLayout.NORTH);
		pWest = new JPanel();
		getContentPane().add(pWest, BorderLayout.WEST);
		pCenter = new JPanel();
		pCenter.setBackground(new Color(72, 209, 204));
		JButton btnQLKho = new JButton("Quản lí kho hàng");
		btnQLKho.setFont(new Font("Times New Roman", Font.BOLD, 10));
		JButton btnQLSP = new JButton("Quản lí sản phẩm");
		btnQLSP.setFont(new Font("Times New Roman", Font.BOLD, 10));
		JButton btnQLNCC = new JButton("Nhà cung cấp");
		btnQLNCC.setFont(new Font("Times New Roman", Font.BOLD, 10));
		JButton btnQLNSX = new JButton("Nhà sản xuất");
		btnQLNSX.setFont(new Font("Times New Roman", Font.BOLD, 10));
		JButton btnQLPN = new JButton("Quản lí phiếu nhập");
		btnQLPN.setFont(new Font("Times New Roman", Font.BOLD, 10));
		JButton btnQLPX = new JButton("Quản lí phiếu xuất");
		btnQLPX.setFont(new Font("Times New Roman", Font.BOLD, 10));
		JButton btnQLNV = new JButton("Quản lí nhân viên");
		btnQLNV.setFont(new Font("Times New Roman", Font.BOLD, 10));
		JButton btnQLKH = new JButton("Quản lí khách hàng");
		btnQLKH.setFont(new Font("Times New Roman", Font.BOLD, 10));
		tblKho = new JTable();
		tblSP = new JTable();
		tblNCC = new JTable();
		tblNSX = new JTable();
		tblPN = new JTable();
		tblCTPN = new JTable();
		tblPX = new JTable();
		tblCTPX = new JTable();
		tblNV = new JTable();
		tblKH = new JTable();
		tblSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbltitle = new JLabel("QUẢN LÝ KHO HÀNG");
		lbltitle.setBackground(new Color(255, 255, 255));
		lbltitle.setForeground(new Color(0, 0, 0));
		lbltitle.setFont(new Font("Times New Roman", Font.BOLD, 40));
		lbltitle.setHorizontalAlignment(SwingConstants.CENTER);
		pNorth.add(lbltitle);
		pNorth.setPreferredSize(new Dimension(0, 120));
		pWest.setPreferredSize(new Dimension(150, 0));
		pWest.setLayout(new GridLayout(8, 1));
		pWest.add(btnQLKho);
		pWest.add(btnQLSP);
		pWest.add(btnQLNCC);
		pWest.add(btnQLNSX);
		pWest.add(btnQLPN);
		pWest.add(btnQLPX);
		pWest.add(btnQLNV);
		pWest.add(btnQLKH);

		card = new CardLayout();
		pQLKho = new JPanel();
		pQLSP = new JPanel();
		pQLNCC = new JPanel();
		pQLNSX = new JPanel();
		pQLPN = new JPanel();
		pQLPX = new JPanel();
		pQLNV = new JPanel();
		pQLKH = new JPanel();
		getContentPane().add(pCenter, BorderLayout.CENTER);
		pCenter.setLayout(card);
		pCenter.add("pQLKho", pQLKho);
		pCenter.add("pQLSP", pQLSP);
		pCenter.add("pQLNCC", pQLNCC);
		pQLNCC.setLayout(null);
		pCenter.add("pQLNSX", pQLNSX);
		pQLNSX.setLayout(null);

		pCenter.add("pQLPN", pQLPN);
		pCenter.add("pQLPX", pQLPX);
		pCenter.add("pQLNV", pQLNV);
		pQLNV.setLayout(null);
		pCenter.add("pQLKH", pQLKH);
		// SẢN PHẨM
		tblSP.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Mã sản phẩm", "Tên sản phẩm", "Đơn giá", "Số lượng", "Đơn vị tính", "Mã NSX" }));
		JScrollPane jSPSP = new JScrollPane();
		jSPSP.setBounds(10, 84, 794, 226);
		jSPSP.setViewportView(tblSP);

		JPanel p1 = new JPanel();
		p1.setBounds(10, 313, 794, 328);

		JPanel p2 = new JPanel();
		p2.setBounds(822, 313, 204, 328);

		comboBoxSX = new JComboBox();
		comboBoxSX.setBounds(801, 41, 225, 25);
		comboBoxSX.setModel(new DefaultComboBoxModel(
				new String[] { "Sắp xếp theo.........", "Mã sản phẩm: từ trên xuống", "Mã sản phẩm: từ dưới lên",
						"Đơn giá: từ thấp tới cao", "Đơn giá: từ cao tới thấp", "Tên: A-Z", "Tên: Z-A" }));
		comboBoxSX.setSelectedIndex(0);
		comboBoxSX.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl2 = new JLabel("Tìm kiếm:");
		lbl2.setBounds(10, 44, 85, 19);
		lbl2.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtTimSP_SP = new JTextField();
		txtTimSP_SP.setBounds(99, 41, 201, 25);
		txtTimSP_SP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimSP_SP.setColumns(15);

		comboBoxTim = new JComboBox();
		comboBoxTim.setBounds(318, 41, 166, 25);
		comboBoxTim.setModel(
				new DefaultComboBoxModel(new String[] { "Tìm kiếm theo:", "Mã sản phẩm", "Tên sản phẩm", "Mã NSX" }));
		comboBoxTim.setSelectedIndex(0);
		comboBoxTim.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl1 = new JLabel("QUẢN LÝ SẢN PHẨM");
		lbl1.setBounds(10, 10, 1016, 25);
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 20));

		
		
		JButton btnThemSP = new JButton("Thêm");
		btnThemSP.setBounds(46, 33, 122, 29);
		BufferedImage img = null;
		try {
			img = ImageIO.read(new File("Icon/them.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		Image dimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon IconThem = new ImageIcon(dimg);
		btnThemSP.setIcon(IconThem);
		btnThemSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
	
		JButton btn_export = new JButton("Export");
		btn_export.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_export.setBounds(650, 387, 128, 30);
		try {
			img = ImageIO.read(new File("Icon/export.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		dimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon IconExport = new ImageIcon(dimg);
		btn_export.setIcon(IconExport);
		btn_export.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btnSuaSP = new JButton("Sửa");
		btnSuaSP.setBounds(46, 94, 122, 29);
		try {
			img = ImageIO.read(new File("Icon/sua.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		dimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon IconSua = new ImageIcon(dimg);
		btnSuaSP.setIcon(IconSua);
		btnSuaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnXoaSP = new JButton("Xóa");
		btnXoaSP.setBounds(46, 161, 122, 29);
		try {
			img = ImageIO.read(new File("Icon/xoa.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		dimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon IconXoa = new ImageIcon(dimg);
		btnXoaSP.setIcon(IconXoa);
		btnXoaSP.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JButton btnThoatSP = new JButton("Thoát");
		btnThoatSP.setBounds(46, 286, 122, 29);
		try {
			img = ImageIO.read(new File("Icon/thoat.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		dimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon IconThoat = new ImageIcon(dimg);
		btnThoatSP.setIcon(IconThoat);
		btnThoatSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
	
		JButton btnResetSP = new JButton("Làm mới");
		btnResetSP.setBounds(46, 226, 122, 29);
		try {
			img = ImageIO.read(new File("Icon/reset.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		dimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon IconReset = new ImageIcon(dimg);
		btnResetSP.setIcon(IconReset);
		btnResetSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		try {
			img = ImageIO.read(new File("Icon/import.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		dimg = img.getScaledInstance(20, 20, Image.SCALE_SMOOTH);
		ImageIcon IconImport= new ImageIcon(dimg);
		
		JLabel lbl3 = new JLabel("Mã sản phẩm:");
		lbl3.setBounds(10, 66, 137, 25);
		lbl3.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl4 = new JLabel("Tên sản phẩm:");
		lbl4.setBounds(10, 137, 137, 25);
		lbl4.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl5 = new JLabel("Đơn giá:");
		lbl5.setBounds(10, 206, 134, 25);
		lbl5.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtMaSP_SP = new JTextField();
		txtMaSP_SP.setBounds(157, 66, 201, 25);
		txtMaSP_SP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaSP_SP.setColumns(15);

		txtTenSP_SP = new JTextField();
		txtTenSP_SP.setBounds(157, 134, 201, 25);
		txtTenSP_SP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenSP_SP.setText("");
		txtTenSP_SP.setColumns(15);

		txtDGSP_SP = new JTextField();
		txtDGSP_SP.setBounds(154, 203, 201, 25);
		txtDGSP_SP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDGSP_SP.setColumns(15);

		JLabel lbl6 = new JLabel("Số lượng:");
		lbl6.setBounds(362, 69, 104, 25);
		lbl6.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtSLSP_SP = new JTextField();
		txtSLSP_SP.setBounds(476, 66, 208, 25);
		txtSLSP_SP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSLSP_SP.setColumns(15);

		JLabel lbl7 = new JLabel("Đơn vị tính:");
		lbl7.setBounds(362, 137, 104, 25);
		lbl7.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cbDVSP = new JComboBox();
		cbDVSP.setBounds(476, 134, 208, 25);
		cbDVSP.setModel(new DefaultComboBoxModel(
				new String[] { "Đơn vị tính ...............", "Thùng", "Lon ", "Chai", "Kg", "Cái", "Lốc", "Hộp" }));
		cbDVSP.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl8 = new JLabel("Mã NSX:");
		lbl8.setBounds(359, 206, 108, 25);
		lbl8.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtMaNSX_SP = new JTextField();
		txtMaNSX_SP.setBounds(477, 203, 208, 25);
		txtMaNSX_SP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaNSX_SP.setColumns(15);
		pQLSP.setLayout(null);
		pQLSP.add(lbl1);
		pQLSP.add(p1);
		p1.setLayout(null);
		p1.add(lbl5);
		p1.add(txtDGSP_SP);
		p1.add(lbl8);
		p1.add(txtMaNSX_SP);
		p1.add(lbl3);
		p1.add(txtMaSP_SP);
		p1.add(lbl4);
		p1.add(txtTenSP_SP);
		p1.add(lbl7);
		p1.add(lbl6);
		p1.add(txtSLSP_SP);
		p1.add(cbDVSP);

		pQLSP.add(p2);
		p2.setLayout(null);
		p2.add(btnThoatSP);
		p2.add(btnResetSP);
		p2.add(btnXoaSP);
		p2.add(btnSuaSP);
		p2.add(btnThemSP);

		pQLSP.add(jSPSP);
		pQLSP.add(lbl2);
		pQLSP.add(txtTimSP_SP);
		pQLSP.add(comboBoxTim);
		pQLSP.add(comboBoxSX);
		
		JButton btn_importSP = new JButton("Import");
		btn_importSP.setIcon(IconImport);
		btn_importSP.setBounds(866, 281, 128, 30);
		pQLSP.add(btn_importSP);
		btn_importSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File excelFile;
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelJTableImport = new XSSFWorkbook();
				String defaultCurrentDirectoryPath = "./excel";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {
					try {
						excelFile = excelFileChooser.getSelectedFile();
						excelFIS = new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);
						excelJTableImport = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
						for (int row = 0;row<=excelSheet.getLastRowNum();row++) {
							XSSFRow excelRow = excelSheet.getRow(row);
							XSSFCell excelMSP = excelRow.getCell(0);
							XSSFCell excelTSP = excelRow.getCell(1);
							XSSFCell excelDG = excelRow.getCell(2);
							XSSFCell excelSL = excelRow.getCell(3);
							XSSFCell excelDVT = excelRow.getCell(4);
							XSSFCell excelNSX = excelRow.getCell(5);

							sp = new SanPhamDTO();
							sp.setmaSP(String.valueOf(excelMSP));
							sp.settenSP(String.valueOf(excelTSP));
							sp.setDonGia(Double.valueOf(String.valueOf(excelDG)));
							sp.setSoLuong(Double.parseDouble(String.valueOf(excelSL)));
							sp.setDvTinh(String.valueOf(excelDVT));
							sp.setMaNSX(String.valueOf(excelNSX));
							
							SanPhamBUS bus = new SanPhamBUS();
							bus.themSP();
							SanPhamBUS.dssp = SanPhamBUS.SanPhamList;
							
							modelSP.addRow(new Object[] {excelMSP,excelTSP,excelDG,excelSL,excelDVT,excelNSX});
							tblSP.setModel(modelSP);
				
						}
						JOptionPane.showMessageDialog(null,"Imported SuccessFully.. !!");
					} catch (IOException ex) {
						 JOptionPane.showMessageDialog(null, ex.getMessage());
					} finally {
		                try {
		                    if (excelFIS != null) {
		                        excelFIS.close();
		                    }
		                    if (excelBIS != null) {
		                        excelBIS.close();
		                    }
		                    if (excelJTableImport != null) {
		                    	excelJTableImport.close();
		                    }
		                } catch (IOException iOException) {
		                    JOptionPane.showMessageDialog(null, iOException.getMessage());
		                }
					
				}
				
			}
			}
		});
		btn_importSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JButton btn_exportSP = new JButton("Export");
		btn_exportSP.setIcon(IconExport);
		btn_exportSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream excelFOU = null;
				BufferedOutputStream excelBOU  = null;
				XSSFWorkbook excelJTableExporter = null;
				JFileChooser excelFileChooser = new JFileChooser("./export");
				excelFileChooser.setDialogTitle("Save As");
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showSaveDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {

					try {
					excelJTableExporter = new XSSFWorkbook();
					XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
					for(int i = 0; i<modelSP.getRowCount(); i++) {
						XSSFRow excelRow = excelSheet.createRow(i);
						for(int j=0;j<modelSP.getColumnCount();j++) {
							XSSFCell excelCell = excelRow.createCell(j);
							excelCell.setCellValue(modelSP.getValueAt(i, j).toString());
						}
					}
					
					excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+".xlsx");
					excelBOU = new BufferedOutputStream(excelFOU);
					excelJTableExporter.write(excelBOU);
					JOptionPane.showMessageDialog(null, "Success");
					} catch (IOException ex) {
						ex.printStackTrace();
				
					} finally {
						try {
							if(excelBOU !=null) {
								excelBOU.close();
							}
							if (excelFOU !=null) {
								excelFOU.close();
							}
							if(excelJTableExporter !=null) {
								excelJTableExporter.close();
							}
						} catch	(IOException ex) {
							ex.printStackTrace();
						}
					}
					
				
			}
			}
		});
		btn_exportSP.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_exportSP.setBounds(866, 223, 128, 30);
		pQLSP.add(btn_exportSP);
	
		// KHO HÀNG
		tblKho.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null }, { null, null, null, null }, { null, null, null, null } },
				new String[] { "Mã kho", "Tên kho", "Địa chỉ", "Điện thoại" }));
		JScrollPane jSPKho = new JScrollPane();
		jSPKho.setBounds(10, 84, 1016, 226);
		jSPKho.setViewportView(tblKho);

		JPanel p3 = new JPanel();
		p3.setBounds(10, 316, 512, 317);

		JPanel p4 = new JPanel();
		p4.setBounds(806, 316, 220, 317);

		JLabel lbl9 = new JLabel("QUẢN LÝ KHO HÀNG");
		lbl9.setBounds(10, 10, 1016, 25);
		lbl9.setHorizontalAlignment(SwingConstants.CENTER);
		lbl9.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl11 = new JLabel("Mã kho:");
		lbl11.setBounds(37, 57, 124, 19);
		lbl11.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl12 = new JLabel("Tên kho:");
		lbl12.setBounds(37, 127, 124, 19);
		lbl12.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl13 = new JLabel("Địa chỉ:");
		lbl13.setBounds(37, 198, 130, 19);
		lbl13.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl14 = new JLabel("Điện thoại:");
		lbl14.setBounds(37, 272, 130, 19);
		lbl14.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtMaKho_Kho = new JTextField();
		txtMaKho_Kho.setBounds(171, 54, 266, 25);
		txtMaKho_Kho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaKho_Kho.setColumns(20);

		txtTenKho_Kho = new JTextField();
		txtTenKho_Kho.setBounds(171, 124, 266, 25);
		txtTenKho_Kho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenKho_Kho.setColumns(20);

		txtDCKho_Kho = new JTextField();
		txtDCKho_Kho.setBounds(171, 195, 266, 25);
		txtDCKho_Kho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDCKho_Kho.setColumns(20);

		txtDTKho_Kho = new JTextField();
		txtDTKho_Kho.setBounds(171, 269, 266, 25);
		txtDTKho_Kho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDTKho_Kho.setColumns(20);

		JButton btnThemKho = new JButton("Thêm");
		btnThemKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		JButton btn_import = new JButton("Import");
		btn_import.setBounds(650, 318, 128, 30);
		btn_import.setIcon(IconImport);
		btn_import.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnThemKho.setBounds(60, 0, 128, 30);
		btnThemKho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemKho.setIcon(IconThem);

		JButton btnSuaKho = new JButton("Sửa");
		btnSuaKho.setBounds(60, 70, 128, 30);
		btnSuaKho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaKho.setIcon(IconSua);

		JButton btnXoaKho = new JButton("Xóa");
		btnXoaKho.setBounds(60, 140, 128, 30);
		btnXoaKho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaKho.setIcon(IconXoa);

		JButton btnResetKho = new JButton("Làm mới");
		btnResetKho.setBounds(60, 210, 128, 30);
		btnResetKho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResetKho.setIcon(IconReset);

		JButton btnThoatKho = new JButton("Thoát");
		btnThoatKho.setBounds(60, 280, 128, 30);
		btnThoatKho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoatKho.setIcon(IconThoat);
		

		JLabel lbl10 = new JLabel("Tìm kiếm:");
		lbl10.setBounds(10, 56, 92, 19);
		lbl10.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtTimKho_Kho = new JTextField();
		txtTimKho_Kho.setBounds(120, 53, 266, 25);
		txtTimKho_Kho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKho_Kho.setColumns(20);

		cbSXKho = new JComboBox();
		cbSXKho.setBounds(830, 53, 196, 25);
		cbSXKho.setModel(new DefaultComboBoxModel(new String[] { "Sắp xếp theo..........", "Mã kho: từ trên xuống",
				"Mã kho: từ dưới lên", "Tên kho: A-Z", "Tên kho: Z-A" }));
		cbSXKho.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cbTimKho = new JComboBox();
		cbTimKho.setBounds(404, 53, 189, 25);
		cbTimKho.setModel(new DefaultComboBoxModel(
				new String[] { "Tìm kiếm theo: ...........", "Mã kho", "Tên kho", "Điện thoại" }));
		cbTimKho.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pQLKho.setLayout(null);
		pQLKho.add(p3);
		p3.setLayout(null);
		p3.add(lbl11);
		p3.add(txtMaKho_Kho);
		p3.add(lbl13);
		p3.add(lbl14);
		p3.add(txtDTKho_Kho);
		p3.add(txtDCKho_Kho);
		p3.add(lbl12);
		p3.add(txtTenKho_Kho);
		pQLKho.add(p4);
		p4.setLayout(null);
		p4.add(btnThoatKho);
		p4.add(btnResetKho);
		p4.add(btnXoaKho);
		p4.add(btnSuaKho);
		p4.add(btnThemKho);
		pQLKho.add(cbSXKho);
		pQLKho.add(lbl9);
		pQLKho.add(lbl10);
		pQLKho.add(txtTimKho_Kho);
		pQLKho.add(cbTimKho);
		pQLKho.add(jSPKho);
		pQLKho.add(btn_import);
		pQLKho.add(btn_export);
	
		btn_import.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File excelFile;
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelJTableImport = new XSSFWorkbook();
				String defaultCurrentDirectoryPath = "./excel";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {
					try {
						excelFile = excelFileChooser.getSelectedFile();
						excelFIS = new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);
						excelJTableImport = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
						for (int row = 0;row<=excelSheet.getLastRowNum();row++) {
							XSSFRow excelRow = excelSheet.getRow(row);
							XSSFCell excelMK = excelRow.getCell(0);
							XSSFCell excelTK = excelRow.getCell(1);
							XSSFCell excelDC = excelRow.getCell(2);
							XSSFCell excelDT = excelRow.getCell(3);
							kho = new KhoHangDTO();
							kho.setMaKho(String.valueOf(excelMK));
							kho.setTenKho(String.valueOf(excelTK));
							kho.setDCKho(String.valueOf(excelDC));
							kho.setDTKho(String.valueOf(excelDT));
							KhoHangBUS bus = new KhoHangBUS();
							bus.themKho();
							KhoHangBUS.dskho = KhoHangBUS.KhoHangList;
							
							modelKho.addRow(new Object[] {excelMK,excelTK,excelDC,excelDT});
							tblKho.setModel(modelKho);
				
						}
						JOptionPane.showMessageDialog(null,"Imported SuccessFully.. !!");
					} catch (IOException ex) {
						 JOptionPane.showMessageDialog(null, ex.getMessage());
					} finally {
		                try {
		                    if (excelFIS != null) {
		                        excelFIS.close();
		                    }
		                    if (excelBIS != null) {
		                        excelBIS.close();
		                    }
		                    if (excelJTableImport != null) {
		                    	excelJTableImport.close();
		                    }
		                } catch (IOException iOException) {
		                    JOptionPane.showMessageDialog(null, iOException.getMessage());
		                }
					
				}
				}
			}
		});

	

		btn_export.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream excelFOU = null;
				BufferedOutputStream excelBOU  = null;
				XSSFWorkbook excelJTableExporter = null;
				JFileChooser excelFileChooser = new JFileChooser("./export");
				excelFileChooser.setDialogTitle("Save As");
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showSaveDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {

					try {
					excelJTableExporter = new XSSFWorkbook();
					XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
					for(int i = 0; i<modelKho.getRowCount(); i++) {
						XSSFRow excelRow = excelSheet.createRow(i);
						for(int j=0;j<modelKho.getColumnCount();j++) {
							XSSFCell excelCell = excelRow.createCell(j);
							excelCell.setCellValue(modelKho.getValueAt(i, j).toString());
						}
					}
					
					excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+".xlsx");
					excelBOU = new BufferedOutputStream(excelFOU);
					excelJTableExporter.write(excelBOU);
					JOptionPane.showMessageDialog(null, "Success");
					} catch (IOException ex) {
						ex.printStackTrace();
				
					} finally {
						try {
							if(excelBOU !=null) {
								excelBOU.close();
							}
							if (excelFOU !=null) {
								excelFOU.close();
							}
							if(excelJTableExporter !=null) {
								excelJTableExporter.close();
							}
						} catch	(IOException ex) {
							ex.printStackTrace();
						}
					}
					
				
			}
			}
		});
		// NHÀ CUNG CẤP
		tblNCC.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null } },
				new String[] { "Mã NCC", "Tên NCC", "Địa chỉ", "Điện thoại" }));
		JScrollPane jSPNCC = new JScrollPane();
		jSPNCC.setBounds(10, 84, 773, 226);
		jSPNCC.setViewportView(tblNCC);

		JPanel p5 = new JPanel();
		p5.setBounds(10, 316, 773, 340);

		JPanel p6 = new JPanel();
		p6.setBounds(793, 316, 233, 340);

		JLabel lbl15 = new JLabel("QUẢN LÝ NHÀ CUNG CẤP");
		lbl15.setBounds(10, 10, 1016, 25);
		lbl15.setHorizontalAlignment(SwingConstants.CENTER);
		lbl15.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl16 = new JLabel("Mã nhà cung cấp:");
		lbl16.setBounds(37, 57, 124, 19);
		lbl16.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl17 = new JLabel("Tên nhà cung cấp:");
		lbl17.setBounds(37, 127, 140, 19);
		lbl17.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl18 = new JLabel("Địa chỉ:");
		lbl18.setBounds(37, 198, 130, 19);
		lbl18.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl19 = new JLabel("Điện thoại:");
		lbl19.setBounds(37, 272, 130, 19);
		lbl19.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtMaNCC_NCC = new JTextField();
		txtMaNCC_NCC.setBounds(190, 54, 266, 25);
		txtMaNCC_NCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaNCC_NCC.setColumns(20);

		txtTenNCC_NCC = new JTextField();
		txtTenNCC_NCC.setBounds(190, 124, 266, 25);
		txtTenNCC_NCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenNCC_NCC.setColumns(20);

		txtDCNCC_NCC = new JTextField();
		txtDCNCC_NCC.setBounds(190, 195, 266, 25);
		txtDCNCC_NCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDCNCC_NCC.setColumns(20);

		txtDTNCC_NCC = new JTextField();
		txtDTNCC_NCC.setBounds(190, 269, 266, 25);
		txtDTNCC_NCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDTNCC_NCC.setColumns(20);

		JButton btnThemNCC = new JButton("Thêm");
		btnThemNCC.setBounds(60, 0, 128, 30);
		btnThemNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemNCC.setIcon(IconThem);

		JButton btnSuaNCC = new JButton("Sửa");
		btnSuaNCC.setBounds(60, 70, 128, 30);
		btnSuaNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaNCC.setIcon(IconSua);

		JButton btnXoaNCC = new JButton("Xóa");
		btnXoaNCC.setBounds(60, 140, 128, 30);
		btnXoaNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaNCC.setIcon(IconXoa);

		JButton btnResetNCC = new JButton("Làm mới");
		btnResetNCC.setBounds(60, 210, 128, 30);
		btnResetNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResetNCC.setIcon(IconReset);

		JButton btnThoatNCC = new JButton("Thoát");
		btnThoatNCC.setBounds(60, 280, 128, 30);
		btnThoatNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoatNCC.setIcon(IconThoat);

		JLabel lbl20 = new JLabel("Tìm kiếm:");
		lbl20.setBounds(10, 56, 92, 19);
		lbl20.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtTimNCC_NCC = new JTextField();
		txtTimNCC_NCC.setBounds(120, 53, 266, 25);
		txtTimNCC_NCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimNCC_NCC.setColumns(20);

		cbSXNCC = new JComboBox();
		cbSXNCC.setBounds(830, 53, 196, 25);
		cbSXNCC.setModel(new DefaultComboBoxModel(new String[] { "Sắp xếp theo..........", "Mã NCC: từ trên xuống",
				"Mã NCC: từ dưới lên", "Tên NCC: A-Z", "Tên NCC: Z-A" }));
		cbSXNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cbTimNCC = new JComboBox();
		cbTimNCC.setBounds(404, 53, 189, 25);
		cbTimNCC.setModel(new DefaultComboBoxModel(
				new String[] { "Tìm kiếm theo: ...........", "Mã NCC", "Tên NCC", "Điện thoại" }));
		cbTimNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pQLNCC.setLayout(null);
		pQLNCC.add(p5);
		p5.setLayout(null);
		p5.add(lbl16);
		p5.add(txtMaNCC_NCC);
		p5.add(lbl17);
		p5.add(lbl18);
		p5.add(txtDTNCC_NCC);
		p5.add(txtDCNCC_NCC);
		p5.add(lbl19);
		p5.add(txtTenNCC_NCC);
		pQLNCC.add(p6);
		p6.setLayout(null);
		p6.add(btnThoatNCC);
		p6.add(btnResetNCC);
		p6.add(btnXoaNCC);
		p6.add(btnSuaNCC);
		p6.add(btnThemNCC);

		pQLNCC.add(cbSXNCC);
		pQLNCC.add(lbl20);
		pQLNCC.add(lbl15);
		pQLNCC.add(txtTimNCC_NCC);
		pQLNCC.add(cbTimNCC);
		pQLNCC.add(jSPNCC);
		
		JButton btn_importNCC = new JButton("Import");
		btn_importNCC.setIcon(IconImport);
		btn_importNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File excelFile;
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelJTableImport = new XSSFWorkbook();
				String defaultCurrentDirectoryPath = "./excel";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {
					try {
						excelFile = excelFileChooser.getSelectedFile();
						excelFIS = new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);
						excelJTableImport = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
						for (int row = 0;row<=excelSheet.getLastRowNum();row++) {
							XSSFRow excelRow = excelSheet.getRow(row);
							XSSFCell excelMNCC = excelRow.getCell(0);
							XSSFCell excelTNCC = excelRow.getCell(1);
							XSSFCell excelDCNCC = excelRow.getCell(2);
							XSSFCell excelDTNCC = excelRow.getCell(3);
		
							ncc = new NCCDTO();
							ncc.setMaNCC(String.valueOf( excelMNCC));
							ncc.setTenNCC(String.valueOf(excelTNCC));
							ncc.setDCNCC(String.valueOf(excelDCNCC));
							ncc.setDTNCC(String.valueOf(excelDTNCC));
							
							NCCBUS bus = new NCCBUS();
							bus.themNCC();
							NCCBUS.dsncc= NCCBUS.NCCList;
							
							modelNCC.addRow(new Object[] {excelMNCC,excelTNCC,excelDCNCC,excelDTNCC});
							tblNCC.setModel(modelNCC);
				
						}
						JOptionPane.showMessageDialog(null,"Imported SuccessFully.. !!");
					} catch (IOException ex) {
						 JOptionPane.showMessageDialog(null, ex.getMessage());
					} finally {
		                try {
		                    if (excelFIS != null) {
		                        excelFIS.close();
		                    }
		                    if (excelBIS != null) {
		                        excelBIS.close();
		                    }
		                    if (excelJTableImport != null) {
		                    	excelJTableImport.close();
		                    }
		                } catch (IOException iOException) {
		                    JOptionPane.showMessageDialog(null, iOException.getMessage());
		                }
					
				}
				
			}
			}
		});
		btn_importNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_importNCC.setBounds(854, 250, 128, 30);
		pQLNCC.add(btn_importNCC);
		
		JButton btn_exportNCC = new JButton("Export");
		btn_exportNCC.setIcon(IconExport);
		btn_exportNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream excelFOU = null;
				BufferedOutputStream excelBOU  = null;
				XSSFWorkbook excelJTableExporter = null;
				JFileChooser excelFileChooser = new JFileChooser("./export");
				excelFileChooser.setDialogTitle("Save As");
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showSaveDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {

					try {
					excelJTableExporter = new XSSFWorkbook();
					XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
					for(int i = 0; i<modelNCC.getRowCount(); i++) {
						XSSFRow excelRow = excelSheet.createRow(i);
						for(int j=0;j<modelNCC.getColumnCount();j++) {
							XSSFCell excelCell = excelRow.createCell(j);
							excelCell.setCellValue(modelNCC.getValueAt(i, j).toString());
						}
					}
					
					excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+".xlsx");
					excelBOU = new BufferedOutputStream(excelFOU);
					excelJTableExporter.write(excelBOU);
					JOptionPane.showMessageDialog(null, "Success");
					} catch (IOException ex) {
						ex.printStackTrace();
				
					} finally {
						try {
							if(excelBOU !=null) {
								excelBOU.close();
							}
							if (excelFOU !=null) {
								excelFOU.close();
							}
							if(excelJTableExporter !=null) {
								excelJTableExporter.close();
							}
						} catch	(IOException ex) {
							ex.printStackTrace();
						}
					}
					
			}
			}
		});
		btn_exportNCC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_exportNCC.setBounds(854, 185, 128, 30);
		pQLNCC.add(btn_exportNCC);
		// NHÀ SẢN XUẤT
		tblNSX.setModel(new javax.swing.table.DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null, null, null, null } },
				new String[] { "Mã NSX", "Tên NSX", "Địa chỉ", "Điện thoại" }));
		JScrollPane jSPNSX = new JScrollPane();
		jSPNSX.setBounds(10, 84, 773, 226);
		jSPNSX.setViewportView(tblNSX);
		JPanel p7 = new JPanel();
		p7.setBounds(10, 316, 773, 340);

		JPanel p8 = new JPanel();
		p8.setBounds(793, 316, 233, 340);

		JLabel lbl21 = new JLabel("QUẢN LÝ NHÀ SẢN XUẤT");
		lbl21.setBounds(10, 10, 1016, 25);
		lbl21.setHorizontalAlignment(SwingConstants.CENTER);
		lbl21.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl22 = new JLabel("Mã nhà sản xuất:");
		lbl22.setBounds(37, 57, 124, 19);
		lbl22.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl23 = new JLabel("Tên nhà sản xuất:");
		lbl23.setBounds(37, 127, 140, 19);
		lbl23.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl24 = new JLabel("Địa chỉ:");
		lbl24.setBounds(37, 198, 130, 19);
		lbl24.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl25 = new JLabel("Điện thoại:");
		lbl25.setBounds(37, 272, 130, 19);
		lbl25.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtMaNSX_NSX = new JTextField();
		txtMaNSX_NSX.setBounds(190, 54, 266, 25);
		txtMaNSX_NSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaNSX_NSX.setColumns(20);

		txtTenNSX_NSX = new JTextField();
		txtTenNSX_NSX.setBounds(190, 124, 266, 25);
		txtTenNSX_NSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenNSX_NSX.setColumns(20);

		txtDCNSX_NSX = new JTextField();
		txtDCNSX_NSX.setBounds(190, 195, 266, 25);
		txtDCNSX_NSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDCNSX_NSX.setColumns(20);

		txtDTNSX_NSX = new JTextField();
		txtDTNSX_NSX.setBounds(190, 269, 266, 25);
		txtDTNSX_NSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDTNSX_NSX.setColumns(20);

		JButton btnThemNSX = new JButton("Thêm");
		btnThemNSX.setBounds(60, 0, 128, 30);
		btnThemNSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemNSX.setIcon(IconThem);

		JButton btnSuaNSX = new JButton("Sửa");
		btnSuaNSX.setBounds(60, 70, 128, 30);
		btnSuaNSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaNSX.setIcon(IconSua);

		JButton btnXoaNSX = new JButton("Xóa");
		btnXoaNSX.setBounds(60, 140, 128, 30);
		btnXoaNSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaNSX.setIcon(IconXoa);

		JButton btnResetNSX = new JButton("Làm mới");
		btnResetNSX.setBounds(60, 210, 128, 30);
		btnResetNSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResetNSX.setIcon(IconReset);

		JButton btnThoatNSX = new JButton("Thoát");
		btnThoatNSX.setBounds(60, 280, 128, 30);
		btnThoatNSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoatNSX.setIcon(IconThoat);

		JLabel lbl26 = new JLabel("Tìm kiếm:");
		lbl26.setBounds(10, 56, 92, 19);
		lbl26.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtTimNSX_NSX = new JTextField();
		txtTimNSX_NSX.setBounds(120, 53, 266, 25);
		txtTimNSX_NSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimNSX_NSX.setColumns(20);

		cbSXNSX = new JComboBox();
		cbSXNSX.setBounds(830, 53, 196, 25);
		cbSXNSX.setModel(new DefaultComboBoxModel(new String[] { "Sắp xếp theo..........", "Mã NSX: từ trên xuống",
				"Mã NSX: từ dưới lên", "Tên NSX: A-Z", "Tên NSX: Z-A" }));
		cbSXNSX.setFont(new Font("Tahoma", Font.PLAIN, 15));

		cbTimNSX = new JComboBox();
		cbTimNSX.setBounds(404, 53, 189, 25);
		cbTimNSX.setModel(new DefaultComboBoxModel(
				new String[] { "Tìm kiếm theo: ...........", "Mã NSX", "Tên NSX", "Điện thoại" }));
		cbTimNSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pQLNSX.setLayout(null);
		pQLNSX.add(p7);
		p7.setLayout(null);
		p7.add(lbl22);
		p7.add(txtMaNSX_NSX);
		p7.add(lbl23);
		p7.add(lbl24);
		p7.add(txtDTNSX_NSX);
		p7.add(txtDCNSX_NSX);
		p7.add(lbl25);
		p7.add(txtTenNSX_NSX);
		pQLNSX.add(p8);
		p8.setLayout(null);
		p8.add(btnThoatNSX);
		p8.add(btnResetNSX);
		p8.add(btnXoaNSX);
		p8.add(btnSuaNSX);
		p8.add(btnThemNSX);
		pQLNSX.add(cbSXNSX);
		pQLNSX.add(lbl21);
		pQLNSX.add(lbl26);
		pQLNSX.add(txtTimNSX_NSX);
		pQLNSX.add(cbTimNSX);
		pQLNSX.add(jSPNSX);
		
		JButton btn_importNSX = new JButton("Import");
		btn_importNSX.setIcon(IconImport);
		btn_importNSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File excelFile;
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelJTableImport = new XSSFWorkbook();
				String defaultCurrentDirectoryPath = "./excel";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {
					try {
						excelFile = excelFileChooser.getSelectedFile();
						excelFIS = new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);
						excelJTableImport = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
						for (int row = 0;row<=excelSheet.getLastRowNum();row++) {
							XSSFRow excelRow = excelSheet.getRow(row);
							XSSFCell excelMNSX = excelRow.getCell(0);
							XSSFCell excelTNSX = excelRow.getCell(1);
							XSSFCell excelDCNSX = excelRow.getCell(2);
							XSSFCell excelDTNSX = excelRow.getCell(3);
		
							nsx = new NSXDTO();
							nsx.setMaNSX(String.valueOf(excelMNSX));
							nsx.setTenNSX(String.valueOf(excelTNSX));
							nsx.setDCNSX(String.valueOf(excelDCNSX));
							nsx.setDTNSX(String.valueOf(excelDTNSX));
							
							NSXBUS bus = new NSXBUS();
							bus.themNSX();
							NSXBUS.dsnsx = NSXBUS.NSXList;
							
							modelNSX.addRow(new Object[] {excelMNSX,excelTNSX,excelDCNSX,excelDTNSX});
							tblNSX.setModel(modelNSX);
				
						}
						JOptionPane.showMessageDialog(null,"Imported SuccessFully.. !!");
					} catch (IOException ex) {
						 JOptionPane.showMessageDialog(null, ex.getMessage());
					} finally {
		                try {
		                    if (excelFIS != null) {
		                        excelFIS.close();
		                    }
		                    if (excelBIS != null) {
		                        excelBIS.close();
		                    }
		                    if (excelJTableImport != null) {
		                    	excelJTableImport.close();
		                    }
		                } catch (IOException iOException) {
		                    JOptionPane.showMessageDialog(null, iOException.getMessage());
		                }
					
				}
				
			}
			}
		});
		btn_importNSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_importNSX.setBounds(854, 250, 128, 30);
		pQLNSX.add(btn_importNSX);
		
		JButton btn_exportNSX = new JButton("Export");
		btn_exportNSX.setIcon(IconExport);
		btn_exportNSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream excelFOU = null;
				BufferedOutputStream excelBOU  = null;
				XSSFWorkbook excelJTableExporter = null;
				JFileChooser excelFileChooser = new JFileChooser("./export");
				excelFileChooser.setDialogTitle("Save As");
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showSaveDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {

					try {
					excelJTableExporter = new XSSFWorkbook();
					XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
					for(int i = 0; i<modelNSX.getRowCount(); i++) {
						XSSFRow excelRow = excelSheet.createRow(i);
						for(int j=0;j<modelNSX.getColumnCount();j++) {
							XSSFCell excelCell = excelRow.createCell(j);
							excelCell.setCellValue(modelNSX.getValueAt(i, j).toString());
						}
					}
					
					excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+".xlsx");
					excelBOU = new BufferedOutputStream(excelFOU);
					excelJTableExporter.write(excelBOU);
					JOptionPane.showMessageDialog(null, "Success");
					} catch (IOException ex) {
						ex.printStackTrace();
				
					} finally {
						try {
							if(excelBOU !=null) {
								excelBOU.close();
							}
							if (excelFOU !=null) {
								excelFOU.close();
							}
							if(excelJTableExporter !=null) {
								excelJTableExporter.close();
							}
						} catch	(IOException ex) {
							ex.printStackTrace();
						}
					}
					
			}
			}
		});
		btn_exportNSX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_exportNSX.setBounds(853, 185, 128, 30);
		pQLNSX.add(btn_exportNSX);
		// NHÂN VIÊN
		tblNV.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Mã nhân viên", "Họ", "Tên", "Ngày sinh", "Địa chỉ", "Điện thoại", "Lương" }));
		JScrollPane jSPNV = new JScrollPane();
		jSPNV.setBounds(10, 84, 794, 226);
		jSPNV.setViewportView(tblNV);

		JPanel p9 = new JPanel();
		p9.setBounds(10, 313, 794, 328);

		JPanel p10 = new JPanel();
		p10.setBounds(822, 313, 204, 328);

		cbSXNV = new JComboBox();
		cbSXNV.setBounds(801, 41, 225, 25);
		cbSXNV.setModel(new DefaultComboBoxModel(new String[] { "Sắp xếp theo.........", "Mã nhân viên: từ trên xuống",
				"Mã nhân viên: từ dưới lên", "Họ: A-Z", "Họ: Z-A", "Tên: A-Z", "Tên: Z-A", "Lương: từ thấp tới cao",
				"Lương: từ cao tới thấp" }));
		cbSXNV.setSelectedIndex(0);
		cbSXNV.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl27 = new JLabel("Tìm kiếm:");
		lbl27.setBounds(10, 44, 85, 19);
		lbl27.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtTimNV_NV = new JTextField();
		txtTimNV_NV.setBounds(99, 41, 201, 25);
		txtTimNV_NV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimNV_NV.setColumns(15);

		cbTimNV = new JComboBox();
		cbTimNV.setBounds(318, 41, 166, 25);
		cbTimNV.setModel(new DefaultComboBoxModel(
				new String[] { "Tìm kiếm theo:", "Mã nhân viên", "Họ", "Tên", "Điện thoại", "Lương" }));
		cbTimNV.setSelectedIndex(0);
		cbTimNV.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl28 = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lbl28.setBounds(10, 10, 1016, 25);
		lbl28.setHorizontalAlignment(SwingConstants.CENTER);
		lbl28.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnThemNV = new JButton("Thêm");
		btnThemNV.setBounds(46, 33, 122, 29);
		btnThemNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemNV.setIcon(IconThem);

		JButton btnSuaNV = new JButton("Sửa");
		btnSuaNV.setBounds(46, 94, 122, 29);
		btnSuaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaNV.setIcon(IconSua);

		JButton btnXoaNV = new JButton("Xóa");
		btnXoaNV.setBounds(46, 161, 122, 29);
		btnXoaNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaNV.setIcon(IconXoa);

		JButton btnThoatNV = new JButton("Thoát");
		btnThoatNV.setBounds(46, 286, 122, 29);
		btnThoatNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoatNV.setIcon(IconThoat);

		JButton btnResetNV = new JButton("Làm mới");
		btnResetNV.setBounds(46, 226, 122, 29);
		btnResetNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResetNV.setIcon(IconReset);

		JLabel lbl29 = new JLabel("Mã nhân viên:");
		lbl29.setBounds(10, 66, 137, 25);
		lbl29.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl30 = new JLabel("Họ:");
		lbl30.setBounds(10, 134, 137, 25);
		lbl30.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl31 = new JLabel("Tên:");
		lbl31.setBounds(10, 202, 137, 25);
		lbl31.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtMaNV_NV = new JTextField();
		txtMaNV_NV.setBounds(157, 66, 201, 25);
		txtMaNV_NV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaNV_NV.setColumns(15);

		txtHoNV_NV = new JTextField();
		txtHoNV_NV.setBounds(157, 134, 201, 25);
		txtHoNV_NV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHoNV_NV.setColumns(15);

		txtTenNV_NV = new JTextField();
		txtTenNV_NV.setBounds(154, 202, 201, 25);
		txtTenNV_NV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenNV_NV.setColumns(15);

		JLabel lbl32 = new JLabel("Địa chỉ:");
		lbl32.setBounds(362, 66, 104, 25);
		lbl32.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtDCNV_NV = new JTextField();
		txtDCNV_NV.setBounds(476, 66, 208, 25);
		txtDCNV_NV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDCNV_NV.setColumns(15);

		JLabel lbl33 = new JLabel("Điện thoại:");
		lbl33.setBounds(362, 134, 104, 25);
		lbl33.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtDTNV_NV = new JTextField();
		txtDTNV_NV.setBounds(476, 134, 208, 25);
		txtDTNV_NV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDCNV_NV.setColumns(15);

		JLabel lbl34 = new JLabel("Lương:");
		lbl34.setBounds(359, 202, 108, 25);
		lbl34.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtLuongNV_NV = new JTextField();
		txtLuongNV_NV.setBounds(477, 202, 208, 25);
		txtLuongNV_NV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtLuongNV_NV.setColumns(15);

		JLabel lbl35 = new JLabel("Ngày sinh:");
		lbl35.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl35.setBounds(10, 270, 137, 25);
		p9.add(lbl35);

		pQLNV.setLayout(null);
		pQLNV.add(lbl28);
		pQLNV.add(p9);
		p9.setLayout(null);
		p9.add(lbl29);
		p9.add(txtMaNV_NV);
		p9.add(lbl30);
		p9.add(txtHoNV_NV);
		p9.add(lbl31);
		p9.add(txtTenNV_NV);
		p9.add(lbl32);
		p9.add(txtDCNV_NV);
		p9.add(lbl33);
		p9.add(lbl34);
		p9.add(txtDTNV_NV);
		p9.add(txtLuongNV_NV);

		NSNV_NV = new JDateChooser();
		NSNV_NV.setDateFormatString("yyyy-MM-dd");
		NSNV_NV.getCalendarButton().setFont(new Font("Tahoma", Font.PLAIN, 15));
		NSNV_NV.setBounds(154, 270, 201, 25);
		p9.add(NSNV_NV);
		pQLNV.add(p10);
		p10.setLayout(null);
		p10.add(btnThoatNV);
		p10.add(btnResetNV);
		p10.add(btnXoaNV);
		p10.add(btnSuaNV);
		p10.add(btnThemNV);
		pQLNV.add(jSPNV);
		pQLNV.add(lbl27);
		pQLNV.add(txtTimNV_NV);
		pQLNV.add(cbTimNV);
		pQLNV.add(cbSXNV);
		
		JButton btn_importNV = new JButton("Import");
		btn_importNV.setIcon(IconImport);
		btn_importNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File excelFile;
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelJTableImport = new XSSFWorkbook();
				String defaultCurrentDirectoryPath = "./excel";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {
					try {
						excelFile = excelFileChooser.getSelectedFile();
						excelFIS = new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);
						excelJTableImport = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
						for (int row = 0;row<=excelSheet.getLastRowNum();row++) {
							XSSFRow excelRow = excelSheet.getRow(row);
							XSSFCell excelMNV = excelRow.getCell(0);
							XSSFCell excelHNV = excelRow.getCell(1);
							XSSFCell excelTNV = excelRow.getCell(2);
							XSSFCell excelNSNV = excelRow.getCell(3);
							XSSFCell excelDCNV = excelRow.getCell(4);
							XSSFCell excelDTNV = excelRow.getCell(5);
							XSSFCell excelLNV = excelRow.getCell(6);
							nv = new NVDTO();
							nv.setMaNV(String.valueOf(excelMNV));
							nv.setHoNV(String.valueOf(excelHNV));
							nv.setTenNV(String.valueOf(excelTNV));
							nv.setNgaysinh(String.valueOf(excelNSNV));
							nv.setDCNV(String.valueOf(excelDCNV));
							nv.setDTNV(String.valueOf(excelDTNV));
							nv.setLuongNV(String.valueOf(excelLNV));
							NVBUS bus = new NVBUS();
							bus.themNV();
							NVBUS.dsnv = NVBUS.NVList;
							
							modelNV.addRow(new Object[] {excelMNV,excelHNV,excelTNV,excelNSNV,excelDCNV,excelDTNV,excelLNV});
							tblNV.setModel(modelNV);
				
						}
						JOptionPane.showMessageDialog(null,"Imported SuccessFully.. !!");
					} catch (IOException ex) {
						 JOptionPane.showMessageDialog(null, ex.getMessage());
					} finally {
		                try {
		                    if (excelFIS != null) {
		                        excelFIS.close();
		                    }
		                    if (excelBIS != null) {
		                        excelBIS.close();
		                    }
		                    if (excelJTableImport != null) {
		                    	excelJTableImport.close();
		                    }
		                } catch (IOException iOException) {
		                    JOptionPane.showMessageDialog(null, iOException.getMessage());
		                }
					
				}
				
			}
			}
		});
		btn_importNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_importNV.setBounds(868, 280, 122, 29);
		pQLNV.add(btn_importNV);
		
		JButton btn_exportNV = new JButton("Export");
		btn_exportNV.setIcon(IconExport);
		btn_exportNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream excelFOU = null;
				BufferedOutputStream excelBOU  = null;
				XSSFWorkbook excelJTableExporter = null;
				JFileChooser excelFileChooser = new JFileChooser("./export");
				excelFileChooser.setDialogTitle("Save As");
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showSaveDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {

					try {
					excelJTableExporter = new XSSFWorkbook();
					XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
					for(int i = 0; i<modelNV.getRowCount(); i++) {
						XSSFRow excelRow = excelSheet.createRow(i);
						for(int j=0;j<modelNV.getColumnCount();j++) {
							XSSFCell excelCell = excelRow.createCell(j);
							excelCell.setCellValue(modelNV.getValueAt(i, j).toString());
						}
					}
					
					excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+".xlsx");
					excelBOU = new BufferedOutputStream(excelFOU);
					excelJTableExporter.write(excelBOU);
					JOptionPane.showMessageDialog(null, "Success");
					} catch (IOException ex) {
						ex.printStackTrace();
				
					} finally {
						try {
							if(excelBOU !=null) {
								excelBOU.close();
							}
							if (excelFOU !=null) {
								excelFOU.close();
							}
							if(excelJTableExporter !=null) {
								excelJTableExporter.close();
							}
						} catch	(IOException ex) {
							ex.printStackTrace();
						}
					}
					
				}	
			}
		});
		btn_exportNV.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_exportNV.setBounds(868, 229, 122, 29);
		pQLNV.add(btn_exportNV);
		// KHÁCH HÀNG
		tblKH.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null }, },
				new String[] { "Mã khách hàng", "Họ", "Tên", "Địa chỉ", "Điện thoại" }));
		JScrollPane jSPKH = new JScrollPane();
		jSPKH.setBounds(10, 84, 794, 226);
		jSPKH.setViewportView(tblKH);

		JPanel p11 = new JPanel();
		p11.setBounds(10, 313, 794, 328);

		JPanel p12 = new JPanel();
		p12.setBounds(822, 313, 204, 328);

		cbSXKH = new JComboBox();
		cbSXKH.setBounds(801, 41, 225, 25);
		cbSXKH.setModel(new DefaultComboBoxModel(new String[] { "Sắp xếp theo.........", "Mã khách hàng: từ trên xuống",
				"Mã khách hàng: từ dưới lên", "Họ: A-Z", "Họ: Z-A", "Tên: A-Z", "Tên: Z-A" }));
		cbSXKH.setSelectedIndex(0);
		cbSXKH.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl36 = new JLabel("Tìm kiếm:");
		lbl36.setBounds(10, 44, 85, 19);
		lbl36.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtTimKH_KH = new JTextField();
		txtTimKH_KH.setBounds(99, 41, 201, 25);
		txtTimKH_KH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimKH_KH.setColumns(15);

		cbTimKH = new JComboBox();
		cbTimKH.setBounds(318, 41, 166, 25);
		cbTimKH.setModel(new DefaultComboBoxModel(
				new String[] { "Tìm kiếm theo:", "Mã khách hàng", "Họ", "Tên", "Điện thoại" }));
		cbTimKH.setSelectedIndex(0);
		cbTimKH.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl37 = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		lbl37.setBounds(10, 10, 1016, 25);
		lbl37.setHorizontalAlignment(SwingConstants.CENTER);
		lbl37.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnThemKH = new JButton("Thêm");
		btnThemKH.setBounds(46, 33, 122, 29);
		btnThemKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemKH.setIcon(IconThem);

		JButton btnSuaKH = new JButton("Sửa");
		btnSuaKH.setBounds(46, 94, 122, 29);
		btnSuaKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaKH.setIcon(IconSua);

		JButton btnXoaKH = new JButton("Xóa");
		btnXoaKH.setBounds(46, 161, 122, 29);
		btnXoaKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaKH.setIcon(IconXoa);

		JButton btnThoatKH = new JButton("Thoát");
		btnThoatKH.setBounds(46, 286, 122, 29);
		btnThoatKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoatKH.setIcon(IconThoat);

		JButton btnResetKH = new JButton("Làm mới");
		btnResetKH.setBounds(46, 226, 122, 29);
		btnResetKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResetKH.setIcon(IconReset);

		JLabel lbl38 = new JLabel("Mã khách hàng:");
		lbl38.setBounds(10, 66, 137, 25);
		lbl38.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl39 = new JLabel("Họ:");
		lbl39.setBounds(10, 134, 137, 25);
		lbl39.setFont(new Font("Tahoma", Font.PLAIN, 15));

		JLabel lbl40 = new JLabel("Tên:");
		lbl40.setBounds(10, 202, 137, 25);
		lbl40.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtMaKH_KH = new JTextField();
		txtMaKH_KH.setBounds(157, 66, 201, 25);
		txtMaKH_KH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMaKH_KH.setColumns(15);

		txtHoKH_KH = new JTextField();
		txtHoKH_KH.setBounds(157, 134, 201, 25);
		txtHoKH_KH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtHoKH_KH.setColumns(15);

		txtTenKH_KH = new JTextField();
		txtTenKH_KH.setBounds(154, 202, 201, 25);
		txtTenKH_KH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTenKH_KH.setColumns(15);

		JLabel lbl41 = new JLabel("Địa chỉ:");
		lbl41.setBounds(362, 66, 104, 25);
		lbl41.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtDCKH_KH = new JTextField();
		txtDCKH_KH.setBounds(476, 66, 208, 25);
		txtDCKH_KH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDCKH_KH.setColumns(15);

		JLabel lbl42 = new JLabel("Điện thoại:");
		lbl42.setBounds(362, 134, 104, 25);
		lbl42.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtDTKH_KH = new JTextField();
		txtDTKH_KH.setBounds(476, 134, 208, 25);
		txtDTKH_KH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDCKH_KH.setColumns(15);

		pQLKH.setLayout(null);
		pQLKH.add(lbl37);
		pQLKH.add(p11);
		p11.setLayout(null);
		p11.add(lbl38);
		p11.add(txtMaKH_KH);
		p11.add(lbl39);
		p11.add(txtHoKH_KH);
		p11.add(lbl40);
		p11.add(txtTenKH_KH);
		p11.add(lbl41);
		p11.add(txtDCKH_KH);
		p11.add(lbl42);
		p11.add(txtDTKH_KH);

		pQLKH.add(p12);
		p12.setLayout(null);
		p12.add(btnThoatKH);
		p12.add(btnResetKH);
		p12.add(btnXoaKH);
		p12.add(btnSuaKH);
		p12.add(btnThemKH);
		pQLKH.add(jSPKH);
		pQLKH.add(lbl36);
		pQLKH.add(txtTimKH_KH);
		pQLKH.add(cbTimKH);
		pQLKH.add(cbSXKH);
		
		JButton btn_importKH = new JButton("Import");
		btn_importKH.setIcon(IconImport);
		btn_importKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				File excelFile;
				FileInputStream excelFIS = null;
				BufferedInputStream excelBIS = null;
				XSSFWorkbook excelJTableImport = new XSSFWorkbook();
				String defaultCurrentDirectoryPath = "./excel";
				JFileChooser excelFileChooser = new JFileChooser(defaultCurrentDirectoryPath);
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showOpenDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {
					try {
						excelFile = excelFileChooser.getSelectedFile();
						excelFIS = new FileInputStream(excelFile);
						excelBIS = new BufferedInputStream(excelFIS);
						excelJTableImport = new XSSFWorkbook(excelBIS);
						XSSFSheet excelSheet = excelJTableImport.getSheetAt(0);
						for (int row = 0;row<=excelSheet.getLastRowNum();row++) {
							XSSFRow excelRow = excelSheet.getRow(row);
							XSSFCell excelMKH = excelRow.getCell(0);
							XSSFCell excelHKH = excelRow.getCell(1);
							XSSFCell excelTKH = excelRow.getCell(2);
							XSSFCell excelDC = excelRow.getCell(3);
							XSSFCell excelDT = excelRow.getCell(4);

							kh = new KHDTO();
							kh.setMaKH(String.valueOf(excelMKH));
							kh.setHoKH(String.valueOf(excelHKH));
							kh.setTenKH(String.valueOf(excelTKH));
							kh.setDCKH(String.valueOf(excelDC));	
							kh.setDTKH(String.valueOf(excelDT));
							KHBUS bus = new KHBUS();
							bus.themKH();
							KHBUS.dskh = KHBUS.KHList;
							
							modelKH.addRow(new Object[] {excelMKH,excelHKH,excelTKH,excelDC,excelDT});
							tblKH.setModel(modelKH);
				
						}
						JOptionPane.showMessageDialog(null,"Imported SuccessFully.. !!");
					} catch (IOException ex) {
						 JOptionPane.showMessageDialog(null, ex.getMessage());
					} finally {
		                try {
		                    if (excelFIS != null) {
		                        excelFIS.close();
		                    }
		                    if (excelBIS != null) {
		                        excelBIS.close();
		                    }
		                    if (excelJTableImport != null) {
		                    	excelJTableImport.close();
		                    }
		                } catch (IOException iOException) {
		                    JOptionPane.showMessageDialog(null, iOException.getMessage());
		                }
					
				}
				
			}
			}
		});
		btn_importKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_importKH.setBounds(867, 281, 122, 29);
		pQLKH.add(btn_importKH);
		
		JButton btn_exportKH = new JButton("Export");
		btn_exportKH.setIcon(IconExport);
		btn_exportKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream excelFOU = null;
				BufferedOutputStream excelBOU  = null;
				XSSFWorkbook excelJTableExporter = null;
				JFileChooser excelFileChooser = new JFileChooser("./export");
				excelFileChooser.setDialogTitle("Save As");
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showSaveDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {

					try {
					excelJTableExporter = new XSSFWorkbook();
					XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
					for(int i = 0; i<modelKH.getRowCount(); i++) {
						XSSFRow excelRow = excelSheet.createRow(i);
						for(int j=0;j<modelKH.getColumnCount();j++) {
							XSSFCell excelCell = excelRow.createCell(j);
							excelCell.setCellValue(modelKH.getValueAt(i, j).toString());
						}
					}
					
					excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+".xlsx");
					excelBOU = new BufferedOutputStream(excelFOU);
					excelJTableExporter.write(excelBOU);
					JOptionPane.showMessageDialog(null, "Success");
					} catch (IOException ex) {
						ex.printStackTrace();
				
					} finally {
						try {
							if(excelBOU !=null) {
								excelBOU.close();
							}
							if (excelFOU !=null) {
								excelFOU.close();
							}
							if(excelJTableExporter !=null) {
								excelJTableExporter.close();
							}
						} catch	(IOException ex) {
							ex.printStackTrace();
						}
					}
					
				
			}
			}
		});
		btn_exportKH.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_exportKH.setBounds(867, 232, 122, 29);
		pQLKH.add(btn_exportKH);
		// PHIẾU NHẬP
		tblPN.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null } },
				new String[] { "Mã phiếu nhập", "Mã nhân viên", "Mã nhà cung cấp", "Mã kho", "Ngày", "Tổng tiền" }));
		JScrollPane jSPPN = new JScrollPane();
		jSPPN.setBounds(10, 84, 585, 160);
		jSPPN.setViewportView(tblPN);

		tblCTPN.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null } },
				new String[] { "Mã sản phẩm", "Số lượng", "Đơn giá", "Thành tiền" }));
		JScrollPane jSPCTPN = new JScrollPane();
		jSPCTPN.setBounds(10, 254, 1016, 379);
		jSPCTPN.setViewportView(tblCTPN);

		JLabel lbl43 = new JLabel("QUẢN LÝ PHIẾU NHẬP");
		lbl43.setBounds(10, 10, 1016, 25);
		lbl43.setHorizontalAlignment(SwingConstants.CENTER);
		lbl43.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl44 = new JLabel("Tìm kiếm:");
		lbl44.setBounds(10, 56, 92, 19);
		lbl44.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtTimPN_PN = new JTextField();
		txtTimPN_PN.setBounds(120, 53, 266, 25);
		txtTimPN_PN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimPN_PN.setColumns(20);

		cbTimPN = new JComboBox();
		cbTimPN.setBounds(404, 53, 189, 25);
		cbTimPN.setModel(new DefaultComboBoxModel(new String[] { "Tìm kiếm theo: ...........", "Mã phiếu nhập",
				"Mã nhân viên", "Mã nhà cung cấp", "Ngày" }));
		cbTimPN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pQLPN.setLayout(null);
		pQLPN.add(lbl43);
		pQLPN.add(lbl44);
		pQLPN.add(txtTimPN_PN);
		pQLPN.add(cbTimPN);
		pQLPN.add(jSPPN);
		pQLPN.add(jSPCTPN);

		JButton btnThemPN = new JButton("Tạo mới");
		btnThemPN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemPN.setBounds(833, 70, 120, 25);
		btnThemPN.setIcon(IconThem);
		pQLPN.add(btnThemPN);

		JButton btnSuaPN = new JButton("Sửa");
		btnSuaPN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaPN.setBounds(833, 105, 120, 25);
		btnSuaPN.setIcon(IconSua);
		pQLPN.add(btnSuaPN);

		JButton btnXoaPN = new JButton("Xóa");
		btnXoaPN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaPN.setBounds(833, 140, 120, 25);
		btnXoaPN.setIcon(IconXoa);
		pQLPN.add(btnXoaPN);

		JButton btnThoatPN = new JButton("Thoát");
		btnThoatPN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoatPN.setBounds(833, 210, 120, 25);
		btnThoatPN.setIcon(IconThoat);
		pQLPN.add(btnThoatPN);

		JButton btnResetPN = new JButton("Làm mới");
		btnResetPN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResetPN.setBounds(833, 175, 120, 25);
		btnResetPN.setIcon(IconReset);
		pQLPN.add(btnResetPN);
		
		JButton btn_exportPN = new JButton("Export");
		btn_exportPN.setIcon(IconExport);
		btn_exportPN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream excelFOU = null;
				BufferedOutputStream excelBOU  = null;
				XSSFWorkbook excelJTableExporter = null;
				JFileChooser excelFileChooser = new JFileChooser("./export");
				excelFileChooser.setDialogTitle("Save As");
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showSaveDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {

					try {
					excelJTableExporter = new XSSFWorkbook();
					XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
					for(int i = 0; i<modelPN.getRowCount(); i++) {
						XSSFRow excelRow = excelSheet.createRow(i);
						for(int j=0;j<modelPN.getColumnCount();j++) {
							XSSFCell excelCell = excelRow.createCell(j);
							excelCell.setCellValue(modelPN.getValueAt(i, j).toString());
						}
					}
					
					excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+".xlsx");
					excelBOU = new BufferedOutputStream(excelFOU);
					excelJTableExporter.write(excelBOU);
					JOptionPane.showMessageDialog(null, "Success");
					} catch (IOException ex) {
						ex.printStackTrace();
				
					} finally {
						try {
							if(excelBOU !=null) {
								excelBOU.close();
							}
							if (excelFOU !=null) {
								excelFOU.close();
							}
							if(excelJTableExporter !=null) {
								excelJTableExporter.close();
							}
						} catch	(IOException ex) {
							ex.printStackTrace();
						}
					}
					
				
			}
			}
		});
		btn_exportPN.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_exportPN.setBounds(687, 70, 120, 25);
		pQLPN.add(btn_exportPN);
	
		// PHIẾU XUẤT
		tblPX.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null } },
				new String[] { "Mã phiếu xuất", "Mã nhân viên", "Mã khách hàng", "Mã kho", "Ngày", "Tổng tiền" }));
		JScrollPane jSPPX = new JScrollPane();
		jSPPX.setBounds(10, 84, 583, 160);
		jSPPX.setViewportView(tblPX);

		tblCTPX.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null }, { null, null, null, null, null },
						{ null, null, null, null, null } },
				new String[] { "Mã sản phẩm", "Số lượng", "Đơn giá", "Thành tiền" }));
		JScrollPane jSPCTPX = new JScrollPane();
		jSPCTPX.setBounds(10, 254, 1016, 379);
		jSPCTPX.setViewportView(tblCTPX);

		JLabel lbl45 = new JLabel("QUẢN LÝ PHIẾU XUẤT");
		lbl45.setBounds(10, 10, 1016, 25);
		lbl45.setHorizontalAlignment(SwingConstants.CENTER);
		lbl45.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lbl46 = new JLabel("Tìm kiếm:");
		lbl46.setBounds(10, 56, 92, 19);
		lbl46.setFont(new Font("Tahoma", Font.PLAIN, 15));

		txtTimPX_PX = new JTextField();
		txtTimPX_PX.setBounds(120, 53, 266, 25);
		txtTimPX_PX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtTimPX_PX.setColumns(20);

		cbTimPX = new JComboBox();
		cbTimPX.setBounds(404, 53, 189, 25);
		cbTimPX.setModel(new DefaultComboBoxModel(new String[] { "Tìm kiếm theo: ...........", "Mã phiếu xuất",
				"Mã nhân viên", "Mã khách hàng", "Ngày" }));
		cbTimPX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pQLPX.setLayout(null);
		pQLPX.add(lbl45);
		pQLPX.add(lbl46);
		pQLPX.add(txtTimPX_PX);
		pQLPX.add(cbTimPX);
		pQLPX.add(jSPPX);
		pQLPX.add(jSPCTPX);

		JButton btnThemPX = new JButton("Tạo mới");
		btnThemPX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThemPX.setBounds(833, 70, 120, 25);
		btnThemPX.setIcon(IconThem);
		pQLPX.add(btnThemPX);

		JButton btnSuaPX = new JButton("Sửa");
		btnSuaPX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuaPX.setBounds(833, 105, 120, 25);
		btnSuaPX.setIcon(IconSua);
		pQLPX.add(btnSuaPX);

		JButton btnXoaPX = new JButton("Xóa");
		btnXoaPX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnXoaPX.setBounds(833, 140, 120, 25);
		btnXoaPX.setIcon(IconXoa);
		pQLPX.add(btnXoaPX);

		JButton btnThoatPX = new JButton("Thoát");
		btnThoatPX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnThoatPX.setBounds(833, 210, 120, 25);
		btnThoatPX.setIcon(IconThoat);
		pQLPX.add(btnThoatPX);

		JButton btnResetPX = new JButton("Làm mới");
		btnResetPX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnResetPX.setBounds(833, 175, 120, 25);
		btnResetPX.setIcon(IconReset);
		pQLPX.add(btnResetPX);
		
		JButton btn_exportPX = new JButton("Export");
		btn_exportPX.setIcon(IconExport);
		btn_exportPX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileOutputStream excelFOU = null;
				BufferedOutputStream excelBOU  = null;
				XSSFWorkbook excelJTableExporter = null;
				JFileChooser excelFileChooser = new JFileChooser("./export");
				excelFileChooser.setDialogTitle("Save As");
				FileNameExtensionFilter fnef = new FileNameExtensionFilter("EXCEL FILES","xls","xlsx","xlsm");
				excelFileChooser.setFileFilter(fnef);
				int excelChooser = excelFileChooser.showSaveDialog(null);
				if(excelChooser == JFileChooser.APPROVE_OPTION) {

					try {
					excelJTableExporter = new XSSFWorkbook();
					XSSFSheet excelSheet = excelJTableExporter.createSheet("JTable Sheet");
					for(int i = 0; i<modelPX.getRowCount(); i++) {
						XSSFRow excelRow = excelSheet.createRow(i);
						for(int j=0;j<modelPX.getColumnCount();j++) {
							XSSFCell excelCell = excelRow.createCell(j);
							excelCell.setCellValue(modelPX.getValueAt(i, j).toString());
						}
					}
					
					excelFOU = new FileOutputStream(excelFileChooser.getSelectedFile()+".xlsx");
					excelBOU = new BufferedOutputStream(excelFOU);
					excelJTableExporter.write(excelBOU);
					JOptionPane.showMessageDialog(null, "Success");
					} catch (IOException ex) {
						ex.printStackTrace();
				
					} finally {
						try {
							if(excelBOU !=null) {
								excelBOU.close();
							}
							if (excelFOU !=null) {
								excelFOU.close();
							}
							if(excelJTableExporter !=null) {
								excelJTableExporter.close();
							}
						} catch	(IOException ex) {
							ex.printStackTrace();
						}
					}
					
				
			}

			}
		});
		btn_exportPX.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btn_exportPX.setBounds(681, 70, 120, 25);
		pQLPX.add(btn_exportPX);

		btnQLKho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnQLKhoActionPerformed(evt);
			}
		});
		btnQLSP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnQLSPActionPerformed(evt);
			}
		});
		btnQLNCC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnQLNCCActionPerformed(evt);
			}
		});
		btnQLNSX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnQLNSXActionPerformed(evt);
			}
		});
		btnQLPN.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnQLPNActionPerformed(evt);
			}
		});
		btnQLPX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnQLPXActionPerformed(evt);
			}
		});
		btnQLNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnQLNVActionPerformed(evt);
			}
		});
		btnQLKH.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				btnQLKHActionPerformed(evt);
			}
		});
		btnThemSP.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThemSPMouseClicked(evt);
			}
		});
		btnSuaSP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaSPActionPerformed(evt);
			}
		});
		btnXoaSP.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaSPActionPerformed(evt);
			}
		});
		btnThoatSP.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThoatSPMouseClicked(evt);
			}
		});
		btnResetSP.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnResetSPMouseClicked(evt);
			}
		});
		tblSP.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblSPMouseClicked(evt);
			}
		});
		comboBoxSX.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboBoxSXActionPerformed(evt);
			}
		});
		comboBoxTim.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				comboBoxTimActionPerformed(evt);
			}
		});
		btnThemKho.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThemKhoMouseClicked(evt);
			}
		});
		btnSuaKho.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaKhoActionPerformed(evt);
			}
		});
		btnXoaKho.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaKhoActionPerformed(evt);
			}
		});
		btnThoatKho.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThoatKhoMouseClicked(evt);
			}
		});
		btnResetKho.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnResetKhoMouseClicked(evt);
			}
		});
		cbSXKho.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbSXKhoActionPerformed(evt);
			}
		});
		cbTimKho.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbTimKhoActionPerformed(evt);
			}
		});
		tblKho.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblKhoMouseClicked(evt);
			}
		});
		btnThemNCC.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThemNCCMouseClicked(evt);
			}
		});
		btnSuaNCC.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaNCCActionPerformed(evt);
			}
		});
		btnXoaNCC.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaNCCActionPerformed(evt);
			}
		});
		btnThoatNCC.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThoatNCCMouseClicked(evt);
			}
		});
		btnResetNCC.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnResetNCCMouseClicked(evt);
			}
		});
		cbSXNCC.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbSXNCCActionPerformed(evt);
			}
		});
		cbTimNCC.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbTimNCCActionPerformed(evt);
			}
		});
		tblNCC.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblNCCMouseClicked(evt);
			}
		});
		btnThemNSX.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThemNSXMouseClicked(evt);
			}
		});
		btnSuaNSX.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaNSXActionPerformed(evt);
			}
		});
		btnXoaNSX.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaNSXActionPerformed(evt);
			}
		});
		btnThoatNSX.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThoatNSXMouseClicked(evt);
			}
		});
		btnResetNSX.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnResetNSXMouseClicked(evt);
			}
		});
		cbSXNSX.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbSXNSXActionPerformed(evt);
			}
		});
		cbTimNSX.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbTimNSXActionPerformed(evt);
			}
		});
		tblNSX.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblNSXMouseClicked(evt);
			}
		});
		btnThemNV.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThemNVMouseClicked(evt);
			}
		});
		btnSuaNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaNVActionPerformed(evt);
			}
		});
		btnXoaNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaNVActionPerformed(evt);
			}
		});
		btnThoatNV.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThoatNVMouseClicked(evt);
			}
		});
		btnResetNV.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnResetNVMouseClicked(evt);
			}
		});
		cbSXNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbSXNVActionPerformed(evt);
			}
		});
		cbTimNV.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbTimNVActionPerformed(evt);
			}
		});
		tblNV.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblNVMouseClicked(evt);
			}
		});
		btnThemKH.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThemKHMouseClicked(evt);
			}
		});
		btnSuaKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnSuaKHActionPerformed(evt);
			}
		});
		btnXoaKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnXoaKHActionPerformed(evt);
			}
		});
		btnThoatKH.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThoatKHMouseClicked(evt);
			}
		});
		btnResetKH.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnResetKHMouseClicked(evt);
			}
		});
		cbSXKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbSXKHActionPerformed(evt);
			}
		});
		cbTimKH.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbTimKHActionPerformed(evt);
			}
		});
		tblKH.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblKHMouseClicked(evt);
			}
		});
		//
		btnThemPN.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThemPNMouseClicked(evt);
			}
		});
		btnXoaPN.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnXoaPNMouseClicked(evt);
			}
		});
		btnSuaPN.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnSuaPNMouseClicked(evt);
			}
		});
		btnThoatPN.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThoatPNMouseClicked(evt);
			}
		});
		btnResetPN.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnResetPNMouseClicked(evt);
			}
		});
		tblPN.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblPNMouseClicked(evt);
			}
		});
		cbTimPN.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbTimPNActionPerformed(evt);
			}
		});
		//
		btnThemPX.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThemPXMouseClicked(evt);
			}
		});
		btnXoaPX.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnXoaPXMouseClicked(evt);
			}
		});
		btnSuaPX.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnSuaPXMouseClicked(evt);
			}
		});
		btnThoatPX.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnThoatPXMouseClicked(evt);
			}
		});
		btnResetPX.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				btnResetPXMouseClicked(evt);
			}
		});
		tblPX.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				tblPXMouseClicked(evt);
			}
		});
		cbTimPX.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cbTimPXActionPerformed(evt);
			}
		});

		txtMaSP_SP.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtTenSP_SP.requestFocus();
			}
		});
		txtTenSP_SP.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtDGSP_SP.requestFocus();
			}
		});
		txtDGSP_SP.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtSLSP_SP.requestFocus();
			}
		});
		txtSLSP_SP.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					cbDVSP.requestFocus();
			}
		});
		cbDVSP.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtMaNSX_SP.requestFocus();
			}
		});
		txtMaKho_Kho.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtTenKho_Kho.requestFocus();
			}
		});
		txtTenKho_Kho.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtDCKho_Kho.requestFocus();
			}
		});
		txtDCKho_Kho.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtDTKho_Kho.requestFocus();
			}
		});
		txtMaNCC_NCC.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtTenNCC_NCC.requestFocus();
			}
		});
		txtTenNCC_NCC.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtDCNCC_NCC.requestFocus();
			}
		});
		txtDCNCC_NCC.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtDTNCC_NCC.requestFocus();
			}
		});
		txtMaNSX_NSX.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtTenNSX_NSX.requestFocus();
			}
		});
		txtTenNSX_NSX.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtDCNSX_NSX.requestFocus();
			}
		});
		txtDCNSX_NSX.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtDTNSX_NSX.requestFocus();
			}
		});
		txtMaNV_NV.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtHoNV_NV.requestFocus();
			}
		});
		txtHoNV_NV.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtTenNV_NV.requestFocus();
			}
		});
		txtTenNV_NV.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					NSNV_NV.requestFocus();
			}
		});
		NSNV_NV.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtDCNV_NV.requestFocus();
			}
		});
		txtDCNV_NV.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtDTNV_NV.requestFocus();
			}
		});
		txtDTNV_NV.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtLuongNV_NV.requestFocus();
			}
		});
		txtMaKH_KH.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtHoKH_KH.requestFocus();
			}
		});
		txtHoKH_KH.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtTenKH_KH.requestFocus();
			}
		});
		txtTenKH_KH.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtDCKH_KH.requestFocus();
			}
		});
		txtDTKH_KH.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER)
					txtDTKH_KH.requestFocus();
			}
		});

		SanPhamBUS.dssp = SanPhamBUS.SanPhamList;
		chenbangSP(SanPhamBUS.dssp);
		KhoHangBUS.dskho = KhoHangBUS.KhoHangList;
		chenbangKho(KhoHangBUS.dskho);
		NCCBUS.dsncc = NCCBUS.NCCList;
		chenbangNCC(NCCBUS.dsncc);
		NSXBUS.dsnsx = NSXBUS.NSXList;
		chenbangNSX(NSXBUS.dsnsx);
		NVBUS.dsnv = NVBUS.NVList;
		chenbangNV(NVBUS.dsnv);
		KHBUS.dskh = KHBUS.KHList;
		chenbangKH(KHBUS.dskh);
		PNBUS.dspn = PNBUS.PNList;
		chenbangPN(PNBUS.dspn);
		PXBUS.dspx = PXBUS.PXList;
		chenbangPX(PXBUS.dspx);

		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	
		
	

	private void btnQLKhoActionPerformed(ActionEvent evt) {
		card.show(pCenter, "pQLKho");
	}

	private void btnQLSPActionPerformed(ActionEvent evt) {
		card.show(pCenter, "pQLSP");
	}

	private void btnQLNCCActionPerformed(ActionEvent evt) {
		card.show(pCenter, "pQLNCC");
	}

	private void btnQLNSXActionPerformed(ActionEvent evt) {
		card.show(pCenter, "pQLNSX");
	}

	private void btnQLPNActionPerformed(ActionEvent evt) {
		card.show(pCenter, "pQLPN");
	}

	private void btnQLPXActionPerformed(ActionEvent evt) {
		card.show(pCenter, "pQLPX");
	}

	private void btnQLNVActionPerformed(ActionEvent evt) {
		card.show(pCenter, "pQLNV");
	}

	private void btnQLKHActionPerformed(ActionEvent evt) {
		card.show(pCenter, "pQLKH");
	}
	private void btnThemSPMouseClicked(MouseEvent evt) {
		sp = new SanPhamDTO();
		if (txtMaSP_SP.getText().isEmpty())
			JOptionPane.showMessageDialog(this, "Chưa nhập mã sản phẩm!!");
		else {
			if (txtTenSP_SP.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Chưa nhập tên sản phẩm!!");
			else {
				if (txtDGSP_SP.getText().isEmpty())
					JOptionPane.showMessageDialog(this, "Chưa nhập đơn giá!!");
				else {
					if (txtSLSP_SP.getText().isEmpty())
						JOptionPane.showMessageDialog(this, "Chưa nhập số lượng!!");
					else {
						if (cbDVSP.getSelectedIndex() == 0)
							JOptionPane.showMessageDialog(this, "Chưa chọn đơn vị tính!!");
						else {
							if (txtMaNSX_SP.getText().isEmpty())
								JOptionPane.showMessageDialog(this, "Chưa nhập mã nhà sản xuất!!");
							else {
								sp.setmaSP(txtMaSP_SP.getText());
								sp.settenSP(txtTenSP_SP.getText());
								sp.setDonGia(Double.parseDouble(txtDGSP_SP.getText()));
								sp.setSoLuong(Integer.parseInt(txtSLSP_SP.getText()));
								switch (cbDVSP.getSelectedIndex()) {
								case 1:
									sp.setDvTinh("Thùng");
									break;
								case 2:
									sp.setDvTinh("Lon");
									break;
								case 3:
									sp.setDvTinh("Chai");
									break;
								case 4:
									sp.setDvTinh("Kg");
									break;
								case 5:
									sp.setDvTinh("Cái");
									break;
								case 6:
									sp.setDvTinh("Lốc");
									break;
								case 7:
									sp.setDvTinh("Hộp");
									break;
								}
								sp.setMaNSX(txtMaNSX_SP.getText());
								SanPhamBUS bus = new SanPhamBUS();
								bus.themSP();
								SanPhamBUS.dssp = SanPhamBUS.SanPhamList;
								chenbangSP(SanPhamBUS.dssp);
								chenSP();
							}
						}
					}
				}
			}
		}
		defaultSetSP();
	}

	private void chenSP() {
		int i = tblSP.getRowCount();
		int size = SanPhamBUS.SanPhamList.size();
		if (i < size) {
			for (int j = 0; j < (size - i); j++) {
				Vector<String> row = new Vector<String>();
				row.add(sp.getmaSP());
				row.add(sp.gettenSP());
				row.add(txtDGSP_SP.getText());
				row.add(txtSLSP_SP.getText());
				row.add(sp.getDvTinh());
				row.add(sp.getMaNSX());
				modelSP.addRow(row);
				tblSP.setModel(modelSP);
			}
		}
	}

	private void btnSuaSPActionPerformed(ActionEvent evt) {
		int i = tblSP.getSelectedRow();
		if (i >= 0) {
			sp = SanPhamBUS.SanPhamList.get(i);
			SanPhamDTO sp = new SanPhamDTO();
			sp = SanPhamBUS.SanPhamList.get(i);
			sp.setmaSP(txtMaSP_SP.getText());
			sp.settenSP(txtTenSP_SP.getText());
			sp.setDonGia(Double.parseDouble(txtDGSP_SP.getText()));
			sp.setSoLuong(Double.parseDouble(txtSLSP_SP.getText()));
			switch (cbDVSP.getSelectedIndex()) {
			case 1:
				sp.setDvTinh("Thùng");
				break;
			case 2:
				sp.setDvTinh("Lon");
				break;
			case 3:
				sp.setDvTinh("Chai");
				break;
			case 4:
				sp.setDvTinh("Kg");
				break;
			case 5:
				sp.setDvTinh("Cái");
				break;
			case 6:
				sp.setDvTinh("Lốc");
				break;
			case 7:
				sp.setDvTinh("Hộp");
				break;
			}
			sp.setMaNSX(txtMaNSX_SP.getText());
			SanPhamDTO old = SanPhamBUS.SanPhamList.set(i, sp);
			modelSP.setValueAt(sp.getmaSP(), i, 0);
			modelSP.setValueAt(sp.gettenSP(), i, 1);
			modelSP.setValueAt(sp.getDonGia(), i, 2);
			modelSP.setValueAt(sp.getSoLuong(), i, 3);
			modelSP.setValueAt(sp.getDvTinh(), i, 4);
			modelSP.setValueAt(sp.getMaNSX(), i, 5);
			tblSP.setModel(modelSP);

			SanPhamBUS bus = new SanPhamBUS();
			bus.suaSP();
		} else
			JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần sửa!");
		defaultSetSP();
	}

	private void btnXoaSPActionPerformed(java.awt.event.ActionEvent evt) {
		int i = tblSP.getSelectedRow();
		if (i >= 0) {
			sp = SanPhamBUS.SanPhamList.get(i);
			modelSP.removeRow(i);
			SanPhamBUS.SanPhamList.remove(i);
			tblSP.setModel(modelSP);

			SanPhamBUS bus = new SanPhamBUS();
			bus.xoaSP();
		} else
			JOptionPane.showMessageDialog(this, "Chọn sản phẩm cần xóa!");
		defaultSetSP();
	}

	private void btnThoatSPMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void btnResetSPMouseClicked(java.awt.event.MouseEvent evt) {
		defaultSetSP();
	}

	private void tblSPMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblSP.getSelectedRow();
		if (i >= 0) {
			SanPhamDTO sp = new SanPhamDTO();
			sp = SanPhamBUS.dssp.get(i);
			txtMaSP_SP.setText(sp.getmaSP());
			txtTenSP_SP.setText(sp.gettenSP());
			txtDGSP_SP.setText(String.valueOf(sp.getDonGia()));
			txtSLSP_SP.setText(String.valueOf(sp.getSoLuong()));
			txtMaNSX_SP.setText(sp.getMaNSX());
			String str = sp.getDvTinh();
			switch (str) {
			case "Thùng":
				cbDVSP.setSelectedIndex(1);
				break;
			case "Lon":
				cbDVSP.setSelectedIndex(2);
				break;
			case "Chai":
				cbDVSP.setSelectedIndex(3);
				break;
			case "Kg":
				cbDVSP.setSelectedIndex(4);
				break;
			case "Cái":
				cbDVSP.setSelectedIndex(5);
				break;
			case "Lốc":
				cbDVSP.setSelectedIndex(6);
				break;
			case "Hộp":
				cbDVSP.setSelectedIndex(7);
				break;
			}
		}
	}

	private void comboBoxSXActionPerformed(ActionEvent evt) {
		SanPhamBUS bus = new SanPhamBUS();
		switch (comboBoxSX.getSelectedIndex()) {
		case 0:
			bus.sxSP("Ma_SP", "ASC");
			chenbangSP(SanPhamBUS.dssp);
			break;
		case 1:
			bus.sxSP("Ma_SP", "ASC");
			chenbangSP(SanPhamBUS.dssp);
			break;
		case 2:
			bus.sxSP("Ma_SP", "DESC");
			chenbangSP(SanPhamBUS.dssp);
			break;
		case 3:
			bus.sxSP("Don_Gia", "ASC");
			chenbangSP(SanPhamBUS.dssp);
			break;
		case 4:
			bus.sxSP("Don_Gia", "DESC");
			chenbangSP(SanPhamBUS.dssp);
			break;
		case 5:
			bus.sxSP("Ten_SP", "ASC");
			chenbangSP(SanPhamBUS.dssp);
			break;
		case 6:
			bus.sxSP("Ten_SP", "DESC");
			chenbangSP(SanPhamBUS.dssp);
			break;
		}
	}

	private void comboBoxTimActionPerformed(ActionEvent evt) {
		SanPhamBUS bus = new SanPhamBUS();
		switch (comboBoxTim.getSelectedIndex()) {
		case 1:
			SanPhamBUS.dssp = bus.TimSP(txtTimSP_SP.getText());
			chenbangSP(SanPhamBUS.dssp);
			txtTimSP_SP.setText("");
			comboBoxTim.setSelectedIndex(0);
			break;
		case 2:
			SanPhamBUS.dssp = bus.TimSP2(txtTimSP_SP.getText());
			chenbangSP(SanPhamBUS.dssp);
			txtTimSP_SP.setText("");
			comboBoxTim.setSelectedIndex(0);
			break;
		case 3:
			SanPhamBUS.dssp = bus.TimSP3(txtTimSP_SP.getText());
			chenbangSP(SanPhamBUS.dssp);
			txtTimSP_SP.setText("");
			comboBoxTim.setSelectedIndex(0);
			break;
		}
	}

	private void defaultSetSP() {
		txtMaSP_SP.setText("");
		txtTenSP_SP.setText("");
		txtDGSP_SP.setText("");
		txtSLSP_SP.setText("");
		cbDVSP.setSelectedIndex(0);
		txtMaNSX_SP.setText("");
	}

	private void chenbangSP(ArrayList<SanPhamDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã sản phẩm");
		header.add("Tên sản phẩm");
		header.add("Đơn giá");
		header.add("Số Lượng");
		header.add("Đơn vị tính");
		header.add("Mã NSX");
		modelSP = new DefaultTableModel(header, 0);
		for (SanPhamDTO sp : kq) {
			Vector<String> row = new Vector<String>();
			row.add(sp.getmaSP());
			row.add(sp.gettenSP());
			row.add(String.valueOf(sp.getDonGia()));
			row.add(String.valueOf(sp.getSoLuong()));
			row.add(sp.getDvTinh());
			row.add(sp.getMaNSX());
			modelSP.addRow(row);
			tblSP.setModel(modelSP);
		}
	}

	private void chenbangKho(ArrayList<KhoHangDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã kho");
		header.add("Tên kho");
		header.add("Địa chỉ");
		header.add("Điện thoại");
		modelKho = new DefaultTableModel(header, 0);
		for (KhoHangDTO kho : kq) {
			Vector<String> row = new Vector<String>();
			row.add(kho.getMaKho());
			row.add(kho.getTenKho());
			row.add(kho.getDCKho());
			row.add(kho.getDTKho());
			modelKho.addRow(row);
			tblKho.setModel(modelKho);
		}
	}

	private void btnThemKhoMouseClicked(MouseEvent evt) {
		kho = new KhoHangDTO();
		if (txtMaKho_Kho.getText().isEmpty())
			JOptionPane.showMessageDialog(this, "Chưa nhập mã kho!!");
		else {
			if (txtTenKho_Kho.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Chưa nhập tên kho!!");
			else {
				if (txtDCKho_Kho.getText().isEmpty())
					JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ kho!!");
				else {
					if (txtDTKho_Kho.getText().isEmpty())
						JOptionPane.showMessageDialog(this, "Chưa nhập điện thoại!!");
					else {
						kho.setMaKho(txtMaKho_Kho.getText());
						kho.setTenKho(txtTenKho_Kho.getText());
						kho.setDCKho(txtDCKho_Kho.getText());
						kho.setDTKho(txtDTKho_Kho.getText());
						KhoHangBUS bus = new KhoHangBUS();
						bus.themKho();
						KhoHangBUS.dskho = KhoHangBUS.KhoHangList;
						chenbangKho(KhoHangBUS.dskho);
						chenKho();
					}
				}
			}
		}
		defaultSetKho();
	}

	private void btnSuaKhoActionPerformed(ActionEvent evt) {
		int i = tblKho.getSelectedRow();
		if (i >= 0) {
			kho = KhoHangBUS.KhoHangList.get(i);
			KhoHangDTO kho = new KhoHangDTO();
			kho = KhoHangBUS.KhoHangList.get(i);
			kho.setMaKho(txtMaKho_Kho.getText());
			kho.setTenKho(txtTenKho_Kho.getText());
			kho.setDCKho(txtDCKho_Kho.getText());
			kho.setDTKho(txtDTKho_Kho.getText());

			KhoHangDTO old = KhoHangBUS.KhoHangList.set(i, kho);
			modelKho.setValueAt(kho.getMaKho(), i, 0);
			modelKho.setValueAt(kho.getTenKho(), i, 1);
			modelKho.setValueAt(kho.getDCKho(), i, 2);
			modelKho.setValueAt(kho.getDTKho(), i, 3);
			tblSP.setModel(modelKho);

			KhoHangBUS bus = new KhoHangBUS();
			bus.suaKho();
		} else
			JOptionPane.showMessageDialog(this, "Chọn kho cần sửa!");
		defaultSetKho();
	}

	private void btnXoaKhoActionPerformed(java.awt.event.ActionEvent evt) {
		int i = tblKho.getSelectedRow();
		if (i >= 0) {
			kho = KhoHangBUS.KhoHangList.get(i);
			modelKho.removeRow(i);
			KhoHangBUS.KhoHangList.remove(i);
			tblKho.setModel(modelKho);

			KhoHangBUS bus = new KhoHangBUS();
			bus.xoaKho();
		} else
			JOptionPane.showMessageDialog(this, "Chọn kho cần xóa!");
		defaultSetKho();
	}

	private void btnThoatKhoMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void btnResetKhoMouseClicked(java.awt.event.MouseEvent evt) {
		defaultSetKho();
	}

	private void cbSXKhoActionPerformed(ActionEvent evt) {
		KhoHangBUS bus = new KhoHangBUS();
		switch (cbSXKho.getSelectedIndex()) {
		case 0:
			bus.sxKho("Ma_Kho", "ASC");
			chenbangKho(KhoHangBUS.dskho);
			break;
		case 1:
			bus.sxKho("Ma_Kho", "ASC");
			chenbangKho(KhoHangBUS.dskho);
			break;
		case 2:
			bus.sxKho("Ma_Kho", "DESC");
			chenbangKho(KhoHangBUS.dskho);
			break;
		case 3:
			bus.sxKho("Ten_Kho", "ASC");
			chenbangKho(KhoHangBUS.dskho);
			break;
		case 4:
			bus.sxKho("Ten_Kho", "DESC");
			chenbangKho(KhoHangBUS.dskho);
			break;
		}
	}

	private void cbTimKhoActionPerformed(ActionEvent evt) {
		KhoHangBUS bus = new KhoHangBUS();
		switch (cbTimKho.getSelectedIndex()) {
		case 1:
			KhoHangBUS.dskho = bus.TimKho(txtTimKho_Kho.getText());
			chenbangKho(KhoHangBUS.dskho);
			txtTimKho_Kho.setText("");
			cbTimKho.setSelectedIndex(0);
			break;
		case 2:
			KhoHangBUS.dskho = bus.TimKho2(txtTimKho_Kho.getText());
			chenbangKho(KhoHangBUS.dskho);
			txtTimKho_Kho.setText("");
			cbTimKho.setSelectedIndex(0);
			break;
		case 3:
			KhoHangBUS.dskho = bus.TimKho3(txtTimKho_Kho.getText());
			chenbangKho(KhoHangBUS.dskho);
			txtTimKho_Kho.setText("");
			cbTimKho.setSelectedIndex(0);
			break;
		}
	}

	private void chenKho() {
		int i = tblKho.getRowCount();
		int size = KhoHangBUS.KhoHangList.size();
		if (i < size) {
			for (int j = 0; j < (size - i); j++) {
				Vector<String> row = new Vector<String>();
				row.add(kho.getMaKho());
				row.add(kho.getTenKho());
				row.add(kho.getDCKho());
				row.add(kho.getDTKho());
				modelKho.addRow(row);
				tblKho.setModel(modelKho);
			}
		}
	}

	private void tblKhoMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblKho.getSelectedRow();
		if (i >= 0) {
			KhoHangDTO kho = new KhoHangDTO();
			kho = KhoHangBUS.dskho.get(i);
			txtMaKho_Kho.setText(kho.getMaKho());
			txtTenKho_Kho.setText(kho.getTenKho());
			txtDCKho_Kho.setText(kho.getDCKho());
			txtDTKho_Kho.setText(kho.getDTKho());
		}
	}

	private void defaultSetKho() {
		txtMaKho_Kho.setText("");
		txtTenKho_Kho.setText("");
		txtDCKho_Kho.setText("");
		txtDTKho_Kho.setText("");
	}

	private void chenbangNCC(ArrayList<NCCDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã NCC");
		header.add("Tên NCC");
		header.add("Địa chỉ");
		header.add("Điện thoại");
		modelNCC = new DefaultTableModel(header, 0);
		for (NCCDTO ncc : kq) {
			Vector<String> row = new Vector<String>();
			row.add(ncc.getMaNCC());
			row.add(ncc.getTenNCC());
			row.add(ncc.getDCNCC());
			row.add(ncc.getDTNCC());
			modelNCC.addRow(row);
			tblNCC.setModel(modelNCC);
		}
	}

	private void btnThemNCCMouseClicked(MouseEvent evt) {
		ncc = new NCCDTO();
		if (txtMaNCC_NCC.getText().isEmpty())
			JOptionPane.showMessageDialog(this, "Chưa nhập mã nhà cung cấp!!");
		else {
			if (txtTenNCC_NCC.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Chưa nhập tên nhà cung cấp!!");
			else {
				if (txtDCNCC_NCC.getText().isEmpty())
					JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ nhà cung cấp!!");
				else {
					if (txtDTNCC_NCC.getText().isEmpty())
						JOptionPane.showMessageDialog(this, "Chưa nhập điện thoại!!");
					else {
						ncc.setMaNCC(txtMaNCC_NCC.getText());
						ncc.setTenNCC(txtTenNCC_NCC.getText());
						ncc.setDCNCC(txtDCNCC_NCC.getText());
						ncc.setDTNCC(txtDTNCC_NCC.getText());
						NCCBUS bus = new NCCBUS();
						bus.themNCC();
						NCCBUS.dsncc = NCCBUS.NCCList;
						chenbangNCC(NCCBUS.dsncc);
						chenNCC();
					}
				}
			}
		}
		defaultSetNCC();
	}

	private void btnSuaNCCActionPerformed(ActionEvent evt) {
		int i = tblNCC.getSelectedRow();
		if (i >= 0) {
			ncc = NCCBUS.NCCList.get(i);
			NCCDTO ncc = new NCCDTO();
			ncc = NCCBUS.NCCList.get(i);
			ncc.setMaNCC(txtMaNCC_NCC.getText());
			ncc.setTenNCC(txtTenNCC_NCC.getText());
			ncc.setDCNCC(txtDCNCC_NCC.getText());
			ncc.setDTNCC(txtDTNCC_NCC.getText());

			NCCDTO old = NCCBUS.NCCList.set(i, ncc);
			modelNCC.setValueAt(ncc.getMaNCC(), i, 0);
			modelNCC.setValueAt(ncc.getTenNCC(), i, 1);
			modelNCC.setValueAt(ncc.getDCNCC(), i, 2);
			modelNCC.setValueAt(ncc.getDTNCC(), i, 3);
			tblNCC.setModel(modelNCC);

			NCCBUS bus = new NCCBUS();
			bus.suaNCC();
		} else
			JOptionPane.showMessageDialog(this, "Chọn nhà cung cấp cần sửa!");
		defaultSetNCC();
	}

	private void btnXoaNCCActionPerformed(java.awt.event.ActionEvent evt) {
		int i = tblNCC.getSelectedRow();
		if (i >= 0) {
			ncc = NCCBUS.NCCList.get(i);
			modelNCC.removeRow(i);
			NCCBUS.NCCList.remove(i);
			tblNCC.setModel(modelNCC);

			NCCBUS bus = new NCCBUS();
			bus.xoaNCC();
		} else
			JOptionPane.showMessageDialog(this, "Chọn nhà cung cấp cần xóa!");
		defaultSetNCC();
	}

	private void btnThoatNCCMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void btnResetNCCMouseClicked(java.awt.event.MouseEvent evt) {
		defaultSetNCC();
	}

	private void cbSXNCCActionPerformed(ActionEvent evt) {
		NCCBUS bus = new NCCBUS();
		switch (cbSXNCC.getSelectedIndex()) {
		case 0:
			bus.sxNCC("Ma_NCC", "ASC");
			chenbangNCC(NCCBUS.dsncc);
			break;
		case 1:
			bus.sxNCC("Ma_NCC", "ASC");
			chenbangNCC(NCCBUS.dsncc);
			break;
		case 2:
			bus.sxNCC("Ma_NCC", "DESC");
			chenbangNCC(NCCBUS.dsncc);
			break;
		case 3:
			bus.sxNCC("Ten_NCC", "ASC");
			chenbangNCC(NCCBUS.dsncc);
			break;
		case 4:
			bus.sxNCC("Ten_NCC", "DESC");
			chenbangNCC(NCCBUS.dsncc);
			break;
		}
	}

	private void cbTimNCCActionPerformed(ActionEvent evt) {
		NCCBUS bus = new NCCBUS();
		switch (cbTimNCC.getSelectedIndex()) {
		case 1:
			NCCBUS.dsncc = bus.TimNCC(txtTimNCC_NCC.getText());
			chenbangNCC(NCCBUS.dsncc);
			txtTimNCC_NCC.setText("");
			cbTimNCC.setSelectedIndex(0);
			break;
		case 2:
			NCCBUS.dsncc = bus.TimNCC2(txtTimNCC_NCC.getText());
			chenbangNCC(NCCBUS.dsncc);
			txtTimNCC_NCC.setText("");
			cbTimNCC.setSelectedIndex(0);
			break;
		case 3:
			NCCBUS.dsncc = bus.TimNCC3(txtTimNCC_NCC.getText());
			chenbangNCC(NCCBUS.dsncc);
			txtTimNCC_NCC.setText("");
			cbTimNCC.setSelectedIndex(0);
			break;
		}
	}

	private void chenNCC() {
		int i = tblNCC.getRowCount();
		int size = NCCBUS.NCCList.size();
		if (i < size) {
			for (int j = 0; j < (size - i); j++) {
				Vector<String> row = new Vector<String>();
				row.add(ncc.getMaNCC());
				row.add(ncc.getTenNCC());
				row.add(ncc.getDCNCC());
				row.add(ncc.getDTNCC());
				modelNCC.addRow(row);
				tblNCC.setModel(modelNCC);
			}
		}
	}

	private void tblNCCMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblNCC.getSelectedRow();
		if (i >= 0) {
			NCCDTO ncc = new NCCDTO();
			ncc = NCCBUS.dsncc.get(i);
			txtMaNCC_NCC.setText(ncc.getMaNCC());
			txtTenNCC_NCC.setText(ncc.getTenNCC());
			txtDCNCC_NCC.setText(ncc.getDCNCC());
			txtDTNCC_NCC.setText(ncc.getDTNCC());
		}
	}

	private void defaultSetNCC() {
		txtMaNCC_NCC.setText("");
		txtTenNCC_NCC.setText("");
		txtDCNCC_NCC.setText("");
		txtDTNCC_NCC.setText("");
	}

	private void chenbangNSX(ArrayList<NSXDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã NSX");
		header.add("Tên NSX");
		header.add("Địa chỉ");
		header.add("Điện thoại");
		modelNSX = new DefaultTableModel(header, 0);
		for (NSXDTO nsx : kq) {
			Vector<String> row = new Vector<String>();
			row.add(nsx.getMaNSX());
			row.add(nsx.getTenNSX());
			row.add(nsx.getDCNSX());
			row.add(nsx.getDTNSX());
			modelNSX.addRow(row);
			tblNSX.setModel(modelNSX);
		}
	}

	private void btnThemNSXMouseClicked(MouseEvent evt) {
		nsx = new NSXDTO();
		if (txtMaNSX_NSX.getText().isEmpty())
			JOptionPane.showMessageDialog(this, "Chưa nhập mã nhà sản xuất!!");
		else {
			if (txtTenNSX_NSX.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Chưa nhập tên nhà sản xuất!!");
			else {
				if (txtDCNSX_NSX.getText().isEmpty())
					JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ nhà sản xuất!!");
				else {
					if (txtDTNSX_NSX.getText().isEmpty())
						JOptionPane.showMessageDialog(this, "Chưa nhập điện thoại!!");
					else {
						nsx.setMaNSX(txtMaNSX_NSX.getText());
						nsx.setTenNSX(txtTenNSX_NSX.getText());
						nsx.setDCNSX(txtDCNSX_NSX.getText());
						nsx.setDTNSX(txtDTNSX_NSX.getText());
						NSXBUS bus = new NSXBUS();
						bus.themNSX();
						NSXBUS.dsnsx = NSXBUS.NSXList;
						chenbangNSX(NSXBUS.dsnsx);
						chenNSX();
					}
				}
			}
		}
		defaultSetNSX();
	}

	private void btnSuaNSXActionPerformed(ActionEvent evt) {
		int i = tblNSX.getSelectedRow();
		if (i >= 0) {
			nsx = NSXBUS.NSXList.get(i);
			NSXDTO nsx = new NSXDTO();
			nsx = NSXBUS.NSXList.get(i);
			nsx.setMaNSX(txtMaNSX_NSX.getText());
			nsx.setTenNSX(txtTenNSX_NSX.getText());
			nsx.setDCNSX(txtDCNSX_NSX.getText());
			nsx.setDTNSX(txtDTNSX_NSX.getText());

			NSXDTO old = NSXBUS.NSXList.set(i, nsx);
			modelNSX.setValueAt(nsx.getMaNSX(), i, 0);
			modelNSX.setValueAt(nsx.getTenNSX(), i, 1);
			modelNSX.setValueAt(nsx.getDCNSX(), i, 2);
			modelNSX.setValueAt(nsx.getDTNSX(), i, 3);
			tblNSX.setModel(modelNSX);

			NSXBUS bus = new NSXBUS();
			bus.suaNSX();
		} else
			JOptionPane.showMessageDialog(this, "Chọn nhà sản xuất cần sửa!");
		defaultSetNSX();
	}

	private void btnXoaNSXActionPerformed(java.awt.event.ActionEvent evt) {
		int i = tblNSX.getSelectedRow();
		if (i >= 0) {
			nsx = NSXBUS.NSXList.get(i);
			modelNSX.removeRow(i);
			NSXBUS.NSXList.remove(i);
			tblNSX.setModel(modelNSX);

			NSXBUS bus = new NSXBUS();
			bus.xoaNSX();
		} else
			JOptionPane.showMessageDialog(this, "Chọn nhà sản xuất cần xóa!");
		defaultSetNSX();
	}

	private void btnThoatNSXMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void btnResetNSXMouseClicked(java.awt.event.MouseEvent evt) {
		defaultSetNSX();
	}

	private void cbSXNSXActionPerformed(ActionEvent evt) {
		NSXBUS bus = new NSXBUS();
		switch (cbSXNSX.getSelectedIndex()) {
		case 0:
			bus.sxNSX("Ma_NSX", "ASC");
			chenbangNSX(NSXBUS.dsnsx);
			break;
		case 1:
			bus.sxNSX("Ma_NSX", "ASC");
			chenbangNSX(NSXBUS.dsnsx);
			break;
		case 2:
			bus.sxNSX("Ma_NSX", "DESC");
			chenbangNSX(NSXBUS.dsnsx);
			break;
		case 3:
			bus.sxNSX("Ten_NSX", "ASC");
			chenbangNSX(NSXBUS.dsnsx);
			break;
		case 4:
			bus.sxNSX("Ten_NSX", "DESC");
			chenbangNSX(NSXBUS.dsnsx);
			break;
		}
	}

	private void cbTimNSXActionPerformed(ActionEvent evt) {
		NSXBUS bus = new NSXBUS();
		switch (cbTimNSX.getSelectedIndex()) {
		case 1:
			NSXBUS.dsnsx = bus.TimNSX(txtTimNSX_NSX.getText());
			chenbangNSX(NSXBUS.dsnsx);
			txtTimNSX_NSX.setText("");
			cbTimNSX.setSelectedIndex(0);
			break;
		case 2:
			NSXBUS.dsnsx = bus.TimNSX2(txtTimNSX_NSX.getText());
			chenbangNSX(NSXBUS.dsnsx);
			txtTimNSX_NSX.setText("");
			cbTimNSX.setSelectedIndex(0);
			break;
		case 3:
			NSXBUS.dsnsx = bus.TimNSX3(txtTimNSX_NSX.getText());
			chenbangNSX(NSXBUS.dsnsx);
			txtTimNSX_NSX.setText("");
			cbTimNSX.setSelectedIndex(0);
			break;
		}
	}

	private void chenNSX() {
		int i = tblNSX.getRowCount();
		int size = NSXBUS.NSXList.size();
		if (i < size) {
			for (int j = 0; j < (size - i); j++) {
				Vector<String> row = new Vector<String>();
				row.add(nsx.getMaNSX());
				row.add(nsx.getTenNSX());
				row.add(nsx.getDCNSX());
				row.add(nsx.getDTNSX());
				modelNSX.addRow(row);
				tblNSX.setModel(modelNSX);
			}
		}
	}

	private void tblNSXMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblNSX.getSelectedRow();
		if (i >= 0) {
			NSXDTO nsx = new NSXDTO();
			nsx = NSXBUS.dsnsx.get(i);
			txtMaNSX_NSX.setText(nsx.getMaNSX());
			txtTenNSX_NSX.setText(nsx.getTenNSX());
			txtDCNSX_NSX.setText(nsx.getDCNSX());
			txtDTNSX_NSX.setText(nsx.getDTNSX());
		}
	}

	private void defaultSetNSX() {
		txtMaNSX_NSX.setText("");
		txtTenNSX_NSX.setText("");
		txtDCNSX_NSX.setText("");
		txtDTNSX_NSX.setText("");
	}

	private void btnThemNVMouseClicked(MouseEvent evt) {
		nv = new NVDTO();
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		if (txtMaNV_NV.getText().isEmpty())
			JOptionPane.showMessageDialog(this, "Chưa nhập mã nhân viên!!");
		else {
			if (txtHoNV_NV.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Chưa nhập họ nhân viên!!");
			else {
				if (txtTenNV_NV.getText().isEmpty())
					JOptionPane.showMessageDialog(this, "Chưa nhập tên nhân viên!!");
				else {
					if (NSNV_NV.getDate() == null)
						JOptionPane.showMessageDialog(this, "Chưa nhập ngày sinh nhân viên!!");
					else {
						if (txtDCNV_NV.getText().isEmpty())
							JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ nhân viên!!");
						else {
							if (txtDTNV_NV.getText().isEmpty())
								JOptionPane.showMessageDialog(this, "Chưa nhập điện thoại nhân viên!!");
							else {
								if (txtLuongNV_NV.getText().isEmpty())
									JOptionPane.showMessageDialog(this, "Chưa nhập lương nhân viên!!");
								else {
									nv.setMaNV(txtMaNV_NV.getText());
									nv.setHoNV(txtHoNV_NV.getText());
									nv.setTenNV(txtTenNV_NV.getText());
									nv.setNgaysinh(date.format(NSNV_NV.getDate()));
									nv.setDCNV(txtDCNV_NV.getText());
									nv.setDTNV(txtDTNV_NV.getText());
									nv.setLuongNV(txtLuongNV_NV.getText());
									NVBUS bus = new NVBUS();
									bus.themNV();
									NVBUS.dsnv = NVBUS.NVList;
									chenbangNV(NVBUS.dsnv);
									chenNV();
								}
							}
						}
					}
				}
			}
		}
		defaultSetNV();
	}

	private void chenNV() {
		int i = tblNV.getRowCount();
		int size = NVBUS.NVList.size();
		if (i < size) {
			for (int j = 0; j < (size - i); j++) {
				Vector<String> row = new Vector<String>();
				row.add(nv.getMaNV());
				row.add(nv.getHoNV());
				row.add(nv.getTenNV());
				row.add(nv.getNgaysinh());
				row.add(nv.getDCNV());
				row.add(nv.getDTNV());
				row.add(nv.getLuongNV());
				modelNV.addRow(row);
				tblNV.setModel(modelNV);
			}
		}
	}

	private void btnSuaNVActionPerformed(ActionEvent evt) {
		DateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		int i = tblNV.getSelectedRow();
		if (i >= 0) {
			nv = NVBUS.NVList.get(i);
			NVDTO nv = new NVDTO();
			nv = NVBUS.NVList.get(i);
			nv.setMaNV(txtMaNV_NV.getText());
			nv.setHoNV(txtHoNV_NV.getText());
			nv.setTenNV(txtTenNV_NV.getText());
			nv.setNgaysinh(date.format(NSNV_NV.getDate()));
			nv.setDCNV(txtDCNV_NV.getText());
			nv.setDTNV(txtDTNV_NV.getText());
			nv.setLuongNV(txtLuongNV_NV.getText());

			NVDTO old = NVBUS.NVList.set(i, nv);
			modelNV.setValueAt(nv.getMaNV(), i, 0);
			modelNV.setValueAt(nv.getHoNV(), i, 1);
			modelNV.setValueAt(nv.getTenNV(), i, 2);
			modelNV.setValueAt(nv.getNgaysinh(), i, 3);
			modelNV.setValueAt(nv.getDCNV(), i, 4);
			modelNV.setValueAt(nv.getDTNV(), i, 5);
			modelNV.setValueAt(nv.getLuongNV(), i, 6);
			tblNV.setModel(modelNV);

			NVBUS bus = new NVBUS();
			bus.suaNV();
		} else
			JOptionPane.showMessageDialog(this, "Chọn nhân viên cần sửa!");
		defaultSetNV();
	}

	private void btnXoaNVActionPerformed(java.awt.event.ActionEvent evt) {
		int i = tblNV.getSelectedRow();
		if (i >= 0) {
			nv = NVBUS.NVList.get(i);
			modelNV.removeRow(i);
			NVBUS.NVList.remove(i);
			tblNV.setModel(modelNV);

			NVBUS bus = new NVBUS();
			bus.xoaNV();
		} else
			JOptionPane.showMessageDialog(this, "Chọn nhân viên cần xóa!");
		defaultSetNV();
	}

	private void btnThoatNVMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void btnResetNVMouseClicked(java.awt.event.MouseEvent evt) {
		defaultSetNV();
	}

	private void tblNVMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblNV.getSelectedRow();
		if (i >= 0) {
			NVDTO nv = new NVDTO();
			nv = NVBUS.dsnv.get(i);
			txtMaNV_NV.setText(nv.getMaNV());
			txtHoNV_NV.setText(nv.getHoNV());
			txtTenNV_NV.setText(nv.getTenNV());
			Date date = null;
			try {
				date = new SimpleDateFormat("yyyy-MM-dd").parse(nv.getNgaysinh());
			} catch (ParseException e) {
				e.printStackTrace();
			}
			NSNV_NV.setDate(date);
			txtDCNV_NV.setText(nv.getDCNV());
			txtDTNV_NV.setText(nv.getDTNV());
			txtLuongNV_NV.setText(nv.getLuongNV());
		}
	}

	private void cbSXNVActionPerformed(ActionEvent evt) {
		NVBUS bus = new NVBUS();
		switch (cbSXNV.getSelectedIndex()) {
		case 0:
			bus.sxNV("Ma_NV", "ASC");
			chenbangNV(NVBUS.dsnv);
			break;
		case 1:
			bus.sxNV("Ma_NV", "ASC");
			chenbangNV(NVBUS.dsnv);
			break;
		case 2:
			bus.sxNV("Ma_NV", "DESC");
			chenbangNV(NVBUS.dsnv);
			break;
		case 3:
			bus.sxNV("Ho_NV", "ASC");
			chenbangNV(NVBUS.dsnv);
			break;
		case 4:
			bus.sxNV("Ho_NV", "DESC");
			chenbangNV(NVBUS.dsnv);
			break;
		case 5:
			bus.sxNV("Ten_NV", "ASC");
			chenbangNV(NVBUS.dsnv);
			break;
		case 6:
			bus.sxNV("Ten_NV", "DESC");
			chenbangNV(NVBUS.dsnv);
			break;
		case 7:
			bus.sxNV("Luong", "ASC");
			chenbangNV(NVBUS.dsnv);
			break;
		case 8:
			bus.sxNV("Luong", "DESC");
			chenbangNV(NVBUS.dsnv);
			break;
		}
	}

	private void cbTimNVActionPerformed(ActionEvent evt) {
		NVBUS bus = new NVBUS();
		switch (cbTimNV.getSelectedIndex()) {
		case 1:
			NVBUS.dsnv = bus.TimNV(txtTimNV_NV.getText());
			chenbangNV(NVBUS.dsnv);
			txtTimNV_NV.setText("");
			cbTimNV.setSelectedIndex(0);
			break;
		case 2:
			NVBUS.dsnv = bus.TimNV2(txtTimNV_NV.getText());
			chenbangNV(NVBUS.dsnv);
			txtTimNV_NV.setText("");
			cbTimNV.setSelectedIndex(0);
			break;
		case 3:
			NVBUS.dsnv = bus.TimNV3(txtTimNV_NV.getText());
			chenbangNV(NVBUS.dsnv);
			txtTimNV_NV.setText("");
			cbTimNV.setSelectedIndex(0);
			break;
		case 4:
			NVBUS.dsnv = bus.TimNV4(txtTimNV_NV.getText());
			chenbangNV(NVBUS.dsnv);
			txtTimNV_NV.setText("");
			cbTimNV.setSelectedIndex(0);
			break;
		case 5:
			NVBUS.dsnv = bus.TimNV5(txtTimNV_NV.getText());
			chenbangNV(NVBUS.dsnv);
			txtTimNV_NV.setText("");
			cbTimNV.setSelectedIndex(0);
			break;
		}
	}

	private void defaultSetNV() {
		txtMaNV_NV.setText("");
		txtHoNV_NV.setText("");
		txtTenNV_NV.setText("");
		NSNV_NV.setDate(null);
		txtDCNV_NV.setText("");
		txtDTNV_NV.setText("");
		txtLuongNV_NV.setText("");
	}

	private void chenbangNV(ArrayList<NVDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã nhân viên");
		header.add("Họ");
		header.add("Tên");
		header.add("Ngày sinh");
		header.add("Địa chỉ");
		header.add("Điện thoại");
		header.add("Lương");
		modelNV = new DefaultTableModel(header, 0);
		for (NVDTO nv : kq) {
			Vector<String> row = new Vector<String>();
			row.add(nv.getMaNV());
			row.add(nv.getHoNV());
			row.add(nv.getTenNV());
			row.add(nv.getNgaysinh());
			row.add(nv.getDCNV());
			row.add(nv.getDTNV());
			row.add(nv.getLuongNV());
			modelNV.addRow(row);
			tblNV.setModel(modelNV);
		}
	}

	private void btnThemKHMouseClicked(MouseEvent evt) {
		kh = new KHDTO();
		if (txtMaKH_KH.getText().isEmpty())
			JOptionPane.showMessageDialog(this, "Chưa nhập mã khách hàng!!");
		else {
			if (txtHoKH_KH.getText().isEmpty())
				JOptionPane.showMessageDialog(this, "Chưa nhập họ khách hàng!!");
			else {
				if (txtTenKH_KH.getText().isEmpty())
					JOptionPane.showMessageDialog(this, "Chưa nhập tên khách hàng!!");
				else {
					if (txtDCKH_KH.getText().isEmpty())
						JOptionPane.showMessageDialog(this, "Chưa nhập địa chỉ khách hàng!!");
					else {
						if (txtDTKH_KH.getText().isEmpty())
							JOptionPane.showMessageDialog(this, "Chưa nhập điện thoại khách hàng!!");
						else {
							kh.setMaKH(txtMaKH_KH.getText());
							kh.setHoKH(txtHoKH_KH.getText());
							kh.setTenKH(txtTenKH_KH.getText());
							kh.setDCKH(txtDCKH_KH.getText());
							kh.setDTKH(txtDTKH_KH.getText());
							KHBUS bus = new KHBUS();
							bus.themKH();
							KHBUS.dskh = KHBUS.KHList;
							chenbangKH(KHBUS.dskh);
							chenKH();
						}
					}
				}
			}
		}
		defaultSetKH();
	}

	private void chenKH() {
		int i = tblKH.getRowCount();
		int size = KHBUS.KHList.size();
		if (i < size) {
			for (int j = 0; j < (size - i); j++) {
				Vector<String> row = new Vector<String>();
				row.add(kh.getMaKH());
				row.add(kh.getHoKH());
				row.add(kh.getTenKH());
				row.add(kh.getDCKH());
				row.add(kh.getDTKH());
				modelKH.addRow(row);
				tblKH.setModel(modelKH);
			}
		}
	}

	private void btnSuaKHActionPerformed(ActionEvent evt) {
		int i = tblKH.getSelectedRow();
		if (i >= 0) {
			kh = KHBUS.KHList.get(i);
			KHDTO kh = new KHDTO();
			kh = KHBUS.KHList.get(i);
			kh.setMaKH(txtMaKH_KH.getText());
			kh.setHoKH(txtHoKH_KH.getText());
			kh.setTenKH(txtTenKH_KH.getText());
			kh.setDCKH(txtDCKH_KH.getText());
			kh.setDTKH(txtDTKH_KH.getText());

			KHDTO old = KHBUS.KHList.set(i, kh);
			modelKH.setValueAt(kh.getMaKH(), i, 0);
			modelKH.setValueAt(kh.getHoKH(), i, 1);
			modelKH.setValueAt(kh.getTenKH(), i, 2);
			modelKH.setValueAt(kh.getDCKH(), i, 3);
			modelKH.setValueAt(kh.getDTKH(), i, 4);
			tblKH.setModel(modelKH);

			KHBUS bus = new KHBUS();
			bus.suaKH();
		} else
			JOptionPane.showMessageDialog(this, "Chọn khách hàng cần sửa!");
		defaultSetKH();
	}

	private void btnXoaKHActionPerformed(java.awt.event.ActionEvent evt) {
		int i = tblKH.getSelectedRow();
		if (i >= 0) {
			kh = KHBUS.KHList.get(i);
			modelKH.removeRow(i);
			KHBUS.KHList.remove(i);
			tblKH.setModel(modelKH);

			KHBUS bus = new KHBUS();
			bus.xoaKH();
		} else
			JOptionPane.showMessageDialog(this, "Chọn khách hàng cần xóa!");
		defaultSetKH();
	}

	private void btnThoatKHMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void btnResetKHMouseClicked(java.awt.event.MouseEvent evt) {
		defaultSetKH();
	}

	private void tblKHMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblKH.getSelectedRow();
		if (i >= 0) {
			KHDTO kh = new KHDTO();
			kh = KHBUS.dskh.get(i);
			txtMaKH_KH.setText(kh.getMaKH());
			txtHoKH_KH.setText(kh.getHoKH());
			txtTenKH_KH.setText(kh.getTenKH());
			txtDCKH_KH.setText(kh.getDCKH());
			txtDTKH_KH.setText(kh.getDTKH());
		}
	}

	private void cbSXKHActionPerformed(ActionEvent evt) {
		KHBUS bus = new KHBUS();
		switch (cbSXKH.getSelectedIndex()) {
		case 0:
			bus.sxKH("Ma_KH", "ASC");
			chenbangKH(KHBUS.dskh);
			break;
		case 1:
			bus.sxKH("Ma_KH", "ASC");
			chenbangKH(KHBUS.dskh);
			break;
		case 2:
			bus.sxKH("Ma_KH", "DESC");
			chenbangKH(KHBUS.dskh);
			break;
		case 3:
			bus.sxKH("Ho_KH", "ASC");
			chenbangKH(KHBUS.dskh);
			break;
		case 4:
			bus.sxKH("Ho_KH", "DESC");
			chenbangKH(KHBUS.dskh);
			break;
		case 5:
			bus.sxKH("Ten_KH", "ASC");
			chenbangKH(KHBUS.dskh);
			break;
		case 6:
			bus.sxKH("Ten_KH", "DESC");
			chenbangKH(KHBUS.dskh);
			break;
		}
	}

	private void cbTimKHActionPerformed(ActionEvent evt) {
		KHBUS bus = new KHBUS();
		switch (cbTimKH.getSelectedIndex()) {
		case 1:
			KHBUS.dskh = bus.TimKH(txtTimKH_KH.getText());
			chenbangKH(KHBUS.dskh);
			txtTimKH_KH.setText("");
			cbTimKH.setSelectedIndex(0);
			break;
		case 2:
			KHBUS.dskh = bus.TimKH2(txtTimKH_KH.getText());
			chenbangKH(KHBUS.dskh);
			txtTimKH_KH.setText("");
			cbTimKH.setSelectedIndex(0);
			break;
		case 3:
			KHBUS.dskh = bus.TimKH3(txtTimKH_KH.getText());
			chenbangKH(KHBUS.dskh);
			txtTimKH_KH.setText("");
			cbTimKH.setSelectedIndex(0);
			break;
		case 4:
			KHBUS.dskh = bus.TimKH4(txtTimKH_KH.getText());
			chenbangKH(KHBUS.dskh);
			txtTimKH_KH.setText("");
			cbTimKH.setSelectedIndex(0);
			break;
		}
	}

	private void defaultSetKH() {
		txtMaKH_KH.setText("");
		txtHoKH_KH.setText("");
		txtTenKH_KH.setText("");
		txtDCKH_KH.setText("");
		txtDTKH_KH.setText("");
	}

	private void chenbangKH(ArrayList<KHDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã khách hàng");
		header.add("Họ");
		header.add("Tên");
		header.add("Địa chỉ");
		header.add("Điện thoại");
		modelKH = new DefaultTableModel(header, 0);
		for (KHDTO kh : kq) {
			Vector<String> row = new Vector<String>();
			row.add(kh.getMaKH());
			row.add(kh.getHoKH());
			row.add(kh.getTenKH());
			row.add(kh.getDCKH());
			row.add(kh.getDTKH());
			modelKH.addRow(row);
			tblKH.setModel(modelKH);
		}
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
		for (PNDTO pn : kq) {
			Vector<String> row = new Vector<String>();
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

	private void chenbangCTPN(ArrayList<CTPNDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã sản phẩm");
		header.add("Số lượng");
		header.add("Đơn giá");
		header.add("Thành tiền");
		modelCTPN = new DefaultTableModel(header, 0);
		for (CTPNDTO ctpn : kq) {
			Vector<String> row = new Vector<String>();
			row.add(ctpn.getMaSP());
			row.add(String.valueOf(ctpn.getSoluong()));
			row.add(String.valueOf(ctpn.getDongia()));
			row.add(String.valueOf(ctpn.getThanhtien()));
			modelCTPN.addRow(row);
			tblCTPN.setModel(modelCTPN);
		}
	}

	private void tblPNMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblPN.getSelectedRow();
		if (i >= 0) {
			PNDTO pn = new PNDTO();
			pn = PNBUS.dspn.get(i);
			ArrayList<CTPNDTO> ds = new ArrayList<CTPNDTO>();
			for (int j = 0; j < CTPNBUS.CTPNList.size(); j++) {
				if (CTPNBUS.CTPNList.get(j).getMaPN().equals(pn.getMaPN()))
					ds.add(CTPNBUS.CTPNList.get(j));
			}
			chenbangCTPN(ds);
		}
	}

	private void btnThemPNMouseClicked(java.awt.event.MouseEvent evt) {
		dispose();
		CTPNGUI.main(null);
	}

	private void btnSuaPNMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblPN.getSelectedRow();
		if (i >= 0) {
			pn = new PNDTO();
			pn = PNBUS.dspn.get(i);
			CTPNBUS.dsctpn = new ArrayList<CTPNDTO>();
			for (int j = 0; j < CTPNBUS.CTPNList.size(); j++) {
				if (CTPNBUS.CTPNList.get(j).getMaPN().equals(pn.getMaPN()))
					CTPNBUS.dsctpn.add(CTPNBUS.CTPNList.get(j));
			}
			dispose();
			CTPNGUI.main(null);
		} else
			JOptionPane.showMessageDialog(this, "Chọn phiếu nhập cần sửa!");
	}

	private void btnXoaPNMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblPN.getSelectedRow();
		if (i >= 0) {
			pn = PNBUS.PNList.get(i);
			modelPN.removeRow(i);
			PNBUS.PNList.remove(i);
			tblPN.setModel(modelPN);

			CTPNBUS bus = new CTPNBUS();
			bus.xoaCTPN();
			PNBUS bus1 = new PNBUS();
			bus1.xoaPN();
		} else
			JOptionPane.showMessageDialog(this, "Chọn phiếu nhập cần xóa!");
	}

	private void btnThoatPNMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void btnResetPNMouseClicked(java.awt.event.MouseEvent evt) {
		PNBUS.dspn = PNBUS.PNList;
		chenbangPN(PNBUS.dspn);
	}

	private void cbTimPNActionPerformed(ActionEvent evt) {
		PNBUS bus = new PNBUS();
		switch (cbTimPN.getSelectedIndex()) {
		case 1:
			PNBUS.dspn = bus.TimPN(txtTimPN_PN.getText());
			chenbangPN(PNBUS.dspn);
			txtTimPN_PN.setText("");
			cbTimPN.setSelectedIndex(0);
			break;
		case 2:
			PNBUS.dspn = bus.TimPN2(txtTimPN_PN.getText());
			chenbangPN(PNBUS.dspn);
			txtTimPN_PN.setText("");
			cbTimPN.setSelectedIndex(0);
			break;
		case 3:
			PNBUS.dspn = bus.TimPN3(txtTimPN_PN.getText());
			chenbangPN(PNBUS.dspn);
			txtTimPN_PN.setText("");
			cbTimPN.setSelectedIndex(0);
			break;
		case 4:
			PNBUS.dspn = bus.TimPN4(txtTimPN_PN.getText());
			chenbangPN(PNBUS.dspn);
			txtTimPN_PN.setText("");
			cbTimPN.setSelectedIndex(0);
			break;
		}
	}

	private void chenbangPX(ArrayList<PXDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã phiếu xuất");
		header.add("Mã nhân viên");
		header.add("Mã khách hàng");
		header.add("Mã kho");
		header.add("Ngày");
		header.add("Tổng tiền");
		modelPX = new DefaultTableModel(header, 0);
		for (PXDTO px : kq) {
			Vector<String> row = new Vector<String>();
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

	private void chenbangCTPX(ArrayList<CTPXDTO> kq) {
		Vector<String> header = new Vector<String>();
		header.add("Mã sản phẩm");
		header.add("Số lượng");
		header.add("Đơn giá");
		header.add("Thành tiền");
		modelCTPX = new DefaultTableModel(header, 0);
		for (CTPXDTO ctpx : kq) {
			Vector<String> row = new Vector<String>();
			row.add(ctpx.getMaSP());
			row.add(String.valueOf(ctpx.getSoluong()));
			row.add(String.valueOf(ctpx.getDongia()));
			row.add(String.valueOf(ctpx.getThanhtien()));
			modelCTPX.addRow(row);
			tblCTPX.setModel(modelCTPX);
		}
	}

	private void tblPXMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblPX.getSelectedRow();
		if (i >= 0) {
			PXDTO px = new PXDTO();
			px = PXBUS.dspx.get(i);
			ArrayList<CTPXDTO> ds = new ArrayList<CTPXDTO>();
			for (int j = 0; j < CTPXBUS.CTPXList.size(); j++) {
				if (CTPXBUS.CTPXList.get(j).getMaPX().equals(px.getMaPX()))
					ds.add(CTPXBUS.CTPXList.get(j));
			}
			chenbangCTPX(ds);
		}
	}

	private void btnThemPXMouseClicked(java.awt.event.MouseEvent evt) {
		dispose();
		CTPXGUI.main(null);
	}

	private void btnSuaPXMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblPX.getSelectedRow();
		if (i >= 0) {
			px = new PXDTO();
			px = PXBUS.dspx.get(i);
			CTPXBUS.dsctpx = new ArrayList<CTPXDTO>();
			for (int j = 0; j < CTPXBUS.CTPXList.size(); j++) {
				if (CTPXBUS.CTPXList.get(j).getMaPX().equals(px.getMaPX()))
					CTPXBUS.dsctpx.add(CTPXBUS.CTPXList.get(j));
			}
			dispose();
			CTPXGUI.main(null);
		} else
			JOptionPane.showMessageDialog(this, "Chọn phiếu xuất cần sửa!");
	}

	private void btnXoaPXMouseClicked(java.awt.event.MouseEvent evt) {
		int i = tblPX.getSelectedRow();
		if (i >= 0) {
			px = PXBUS.PXList.get(i);
			modelPX.removeRow(i);
			PXBUS.PXList.remove(i);
			tblPX.setModel(modelPX);

			CTPXBUS bus = new CTPXBUS();
			bus.xoaCTPX();
			PXBUS bus1 = new PXBUS();
			bus1.xoaPX();
		} else
			JOptionPane.showMessageDialog(this, "Chọn phiếu xuất cần xóa!");
	}

	private void btnThoatPXMouseClicked(java.awt.event.MouseEvent evt) {
		System.exit(0);
	}

	private void btnResetPXMouseClicked(java.awt.event.MouseEvent evt) {
		PXBUS.dspx = PXBUS.PXList;
		chenbangPX(PXBUS.dspx);
	}

	private void cbTimPXActionPerformed(ActionEvent evt) {
		PXBUS bus = new PXBUS();
		switch (cbTimPX.getSelectedIndex()) {
		case 1:
			PXBUS.dspx = bus.TimPX(txtTimPX_PX.getText());
			chenbangPX(PXBUS.dspx);
			txtTimPX_PX.setText("");
			cbTimPX.setSelectedIndex(0);
			break;
		case 2:
			PXBUS.dspx = bus.TimPX2(txtTimPX_PX.getText());
			chenbangPX(PXBUS.dspx);
			txtTimPX_PX.setText("");
			cbTimPX.setSelectedIndex(0);
			break;
		case 3:
			PXBUS.dspx = bus.TimPX3(txtTimPX_PX.getText());
			chenbangPX(PXBUS.dspx);
			txtTimPX_PX.setText("");
			cbTimPX.setSelectedIndex(0);
			break;
		case 4:
			PXBUS.dspx = bus.TimPX4(txtTimPX_PX.getText());
			chenbangPX(PXBUS.dspx);
			txtTimPX_PX.setText("");
			cbTimPX.setSelectedIndex(0);
			break;
		}
	}

	public static void main(String args[]) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				SanPhamBUS bus = new SanPhamBUS();
				if (SanPhamBUS.SanPhamList == null)
					bus.docDSSP();
				KhoHangBUS bus1 = new KhoHangBUS();
				if (KhoHangBUS.KhoHangList == null)
					bus1.docDSKho();
				NCCBUS bus2 = new NCCBUS();
				if (NCCBUS.NCCList == null)
					bus2.docDSNCC();
				NSXBUS bus3 = new NSXBUS();
				if (NSXBUS.NSXList == null)
					bus3.docDSNSX();
				NVBUS bus4 = new NVBUS();
				if (NVBUS.NVList == null)
					bus4.docDSNV();
				KHBUS bus5 = new KHBUS();
				if (KHBUS.KHList == null)
					bus5.docDSKH();
				PNBUS bus6 = new PNBUS();
				if (PNBUS.PNList == null)
					bus6.docDSPN();
				CTPNBUS bus7 = new CTPNBUS();
				if (CTPNBUS.CTPNList == null)
					bus7.docDSCTPN();
				PXBUS bus8 = new PXBUS();
				if (PXBUS.PXList == null)
					bus8.docDSPX();
				CTPXBUS bus9 = new CTPXBUS();
				if (CTPXBUS.CTPXList == null)
					bus9.docDSCTPX();
				if (Login.acc.getStatus() == 0) {
					JOptionPane.showInternalMessageDialog(null, "Please login !");
					Login.main(null);
				}
				else new GUI().setVisible(true);
			}
		});
	}
}