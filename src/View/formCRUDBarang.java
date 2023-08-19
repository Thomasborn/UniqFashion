/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;
import com.toedter.calendar.JDateChooser;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.DefaultTableModel;

//new
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
//import report.*;
import DAO.*;
import Model.*;
import Controller.Controller;
/**
 *
 * @author TS <TS.com>
 */
public class formCRUDBarang extends javax.swing.JFrame {
    DefaultTableModel table = new DefaultTableModel();
 Dao conn = new Dao();
 Controller C= new Controller();
    /**
     * Creates new form formAddBarang
     */
    public formCRUDBarang() {
        initComponents();
        tanggal();
        
        Dao conn = new Dao();
        conn.getKoneksi();
        
        table_barang1.setModel(table);
        table.addColumn("Kode Barang");
        table.addColumn("Warna");
        table.addColumn("Ukuran");
        table.addColumn("Overview");
        table.addColumn("Materials");
        table.addColumn("Stok");
        table.addColumn("Harga");
        
        
        
        table.addColumn("Jenis Koleksi");
        table.addColumn("Tanggal Masuk");
            
        tampilData();
        
    }
private void tampilData(){
        //untuk mengahapus baris setelah input
        int row = table_barang1.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String query = "SELECT * FROM `Man` ";
        
        try{
            Connection connect = conn.getKoneksi();//memanggil conn
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("kode");
                    String warna = rslt.getString("warna");
                    String ukuran = rslt.getString("ukuran");
                    String overview = rslt.getString("overview");
                    String materials = rslt.getString("materials");
                    
                    String stok = rslt.getString("stok");
                    String harga = rslt.getString("harga");
                     String nama = rslt.getString("jenisman");
                    String tanggal = rslt.getString("tanggal");
//                   String arrays= C.showallMan();
//                   int kode1 = C.showallMans().getKode();
//                   String warna = C.showallMans().getWarna();
//                    String ukuran = C.showallMans().getWarna();
//                    String overview = C.showallMans().getOverview();
//                    String materials = C.showallMans().getMaterials();
//                    
//                    int stok1 = C.showallMans().getStok();
//                    float harga1 = C.showallMans().getHarga();
//                   String nama = C.showallMans().getJenismen();
//                  String tanggal = C.showallMans().getTanggal();
//                  String kode= String.valueOf(kode1);String stok= String.valueOf(stok1);String harga= String.valueOf(harga1);
                //masukan semua data kedalam array
                String[] data = {kode,warna,ukuran,overview,materials,stok,harga,nama,tanggal};
                //menambahkan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            
                //mengeset nilai yang ditampung agar muncul di table
                table_barang1.setModel(table);
            
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    private void clear(){
//        txt_kodebarang.setText(null);
        txt_namabarang.setText(null);
         txt_namabarang1.setText(null);
          txt_namabarang2.setText(null);
           txt_namabarang3.setText(null);
            txt_namabarang4.setText(null);
             txt_namabarang5.setText(null);
        txt_harga.setText(null);
        txt_stok.setText(null);
//        txt_tanggal.setDate(null);
        
    }
    private void tambahData(){
        int kode = Integer.parseInt(txt_namabarang2.getText());
        String jenisman = txt_namabarang.getText();
        String warna = txt_namabarang5.getText();
        String ukuran = txt_namabarang1.getText();
        String materials = txt_namabarang3.getText();
        String overview = txt_namabarang4.getText();
        
        float harga = Float.parseFloat(txt_harga.getText());
        int stok = Integer.parseInt(txt_stok.getText());
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy/MM/dd");
        String tanggal = date.format(txt_tanggal.getDate());
        
        C.setMan(jenisman, warna, ukuran, kode, overview, materials, stok, harga,tanggal);
        C.cekdataMan(kode);
        Man M = new Man(jenisman, warna, ukuran, kode, overview, materials, stok, harga,tanggal);
        C.addMan(M);
        System.out.println(C.TampilMan());
//        //panggil conn
//        Connection connect = conn.getKoneksi();
//        //query untuk memasukan data
//        String query = "INSERT INTO `Man` (kode, `warna`, `ukuran`, `overview`, `materials`,`stok`,`harga`,`jenisman`,`tanggal`) "
//                     + "VALUES ('"+kode+"', '"+warna+"', '"+ukuran+"', '"+overview+"', '"+materials+"', '"+stok+"', '"+harga+"', '"+jenisman+"','"+tanggal+"')";
//        System.out.println(tanggal);
//        try{
//            //menyiapkan statement untuk di eksekusi
//            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
//            ps.executeUpdate();
//            JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
//            
//        }catch(SQLException | HeadlessException e){
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan");
//            
//        }finally{
//            tampilData();
//            clear();
//            
//        }
//tampilData();
//            clear();
    }
    public void tanggal(){
        Date now = new Date();  
        txt_tanggal.setDate(now);    
    }
    private void hapusData(){
        //ambill data no pendaftaran
        int i = table_barang1.getSelectedRow();
        
       int kode = Integer.parseInt(table.getValueAt(i, 0).toString());
       C.deleteMan(kode);
        
//        Connection connect = conn.getKoneksi();
//        
//        String query = "DELETE FROM `Man` WHERE `Man`.`kode` = "+kode+" ";
//        try{
//            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
//            ps.execute();
//            JOptionPane.showMessageDialog(null , "Data Berhasil Dihapus");
//        }catch(SQLException | HeadlessException e){
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
//        }finally{
//            tampilData();
//            clear();
//        }
        tampilData();
            clear();
    }
    private void editData(){
        int i = table_barang1.getSelectedRow();
        
        int kode = Integer.parseInt(table.getValueAt(i, 0).toString());
        String jenisman = txt_namabarang.getText();
        String warna = txt_namabarang5.getText();
        String ukuran = txt_namabarang1.getText();
        String materials = txt_namabarang3.getText();
        String overview = txt_namabarang4.getText();
        
        float harga = Float.parseFloat(txt_harga.getText());
        int stok = Integer.parseInt(txt_stok.getText());
        
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = String.valueOf(date.format(txt_tanggal.getDate()));
        C.setMan(jenisman, warna, ukuran, kode, overview, materials, stok, harga,tanggal);
        Man M = new Man(jenisman, warna, ukuran, kode, overview, materials, stok, harga,tanggal);
        C.UpdateMan(M, kode);
//        
//        Connection connect = conn.getKoneksi();
//        
//        String query = "UPDATE `Man` SET `nama_barang` = '"+nama+"', `harga` = '"+harga+"', `stok` = '"+stok+"', `tanggal` = '"+tanggal+"' "
//                + "WHERE `Man`.`kode` = '"+kode+"';";
//
//        try{
//            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
//            ps.executeUpdate(query);
//            JOptionPane.showMessageDialog(null , "Data Update");
//        }catch(SQLException | HeadlessException e){
//            System.out.println(e);
//            JOptionPane.showMessageDialog(null, "Gagal Update");
//        }finally{
//            tampilData();
//            clear();
//        }
tampilData();
            clear();
    }
    private void cari(){
        int row = table_barang1.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
        String cari = txt_search.getText();
        
        String query = "SELECT * FROM `Man` WHERE `kode`  LIKE '%"+cari+"%' OR `jenisman` LIKE '%"+cari+"%' ";
                
       try{
           Connection connect = conn.getKoneksi();//memanggil conn
           Statement sttmnt = connect.createStatement();//membuat statement
           ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
           
           while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("kode");
                    String nama = rslt.getString("jenisman");
                    String harga = rslt.getString("harga");
                    String stok = rslt.getString("stok");
                    String tanggal = rslt.getString("tanggal");
                   
                    String warna = rslt.getString("warna");
                    String ukuran = rslt.getString("ukuran");
                    String overview = rslt.getString("overview");
                    String materials = rslt.getString("materials");
                    
                  
                    
                //masukan semua data kedalam array
                String[] data = {kode,warna,ukuran,overview,materials,stok,harga,nama,tanggal};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                table_barang1.setModel(table);
           
        
    }catch(Exception e){
           System.out.println(e);
    }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton5 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        txt_search = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txt_namabarang = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_harga = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txt_stok = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_tanggal = new com.toedter.calendar.JDateChooser();
        jButton6 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_barang1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        txt_namabarang1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txt_namabarang2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_namabarang3 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_namabarang4 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        txt_namabarang5 = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(980, 1200));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 102, 102));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("COLLECTIONS MAN");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 879, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 2, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, 0, 1050, 60);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/reload.png"))); // NOI18N
        jButton5.setText("  REFRESH");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(200, 721, 135, 33);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/chevron.png"))); // NOI18N
        jButton3.setText("  BACK");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);
        jButton3.setBounds(50, 721, 120, 33);

        txt_search.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        jPanel2.add(txt_search);
        txt_search.setBounds(500, 521, 275, 40);

        jButton7.setBackground(new java.awt.Color(255, 255, 255));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/find.png"))); // NOI18N
        jButton7.setText("  CARI");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(805, 520, 101, 40);

        jLabel9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel9.setText("Nama Jenis Koleksi");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(50, 30, 230, 19);

        txt_namabarang.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_namabarang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarangActionPerformed(evt);
            }
        });
        jPanel2.add(txt_namabarang);
        txt_namabarang.setBounds(50, 60, 400, 40);

        jLabel10.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel10.setText("Harga");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(50, 420, 60, 19);

        txt_harga.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_harga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_hargaActionPerformed(evt);
            }
        });
        jPanel2.add(txt_harga);
        txt_harga.setBounds(50, 450, 400, 40);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/plus.png"))); // NOI18N
        jButton1.setText("  ADD");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(50, 520, 120, 41);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/minus.png"))); // NOI18N
        jButton4.setText("CLEAR");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(190, 520, 120, 41);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel7.setText("Stok");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(500, 32, 31, 19);

        txt_stok.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_stok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_stokActionPerformed(evt);
            }
        });
        jPanel2.add(txt_stok);
        txt_stok.setBounds(500, 60, 400, 40);

        jLabel8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel8.setText("Tanggal Masuk");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(500, 304, 105, 19);

        txt_tanggal.setEnabled(false);
        txt_tanggal.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel2.add(txt_tanggal);
        txt_tanggal.setBounds(500, 334, 400, 40);

        jButton6.setBackground(new java.awt.Color(255, 255, 255));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/edit.png"))); // NOI18N
        jButton6.setText("  EDIT");
        jButton6.setPreferredSize(new java.awt.Dimension(117, 40));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(330, 520, 120, 40);

        table_barang1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        table_barang1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        table_barang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_barang1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table_barang1);

        jPanel2.add(jScrollPane3);
        jScrollPane3.setBounds(50, 591, 850, 100);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/trash-can (1).png"))); // NOI18N
        jButton2.setText("  DELETE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(779, 721, 121, 33);

        jButton8.setBackground(new java.awt.Color(255, 255, 255));
        jButton8.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/print.png"))); // NOI18N
        jButton8.setText("  PRINT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(640, 721, 109, 33);

        txt_namabarang1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_namabarang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarang1ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_namabarang1);
        txt_namabarang1.setBounds(50, 146, 400, 40);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Ukuran");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(50, 118, 110, 19);

        txt_namabarang2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_namabarang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarang2ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_namabarang2);
        txt_namabarang2.setBounds(500, 146, 400, 40);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Kode");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(500, 118, 110, 19);

        txt_namabarang3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_namabarang3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarang3ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_namabarang3);
        txt_namabarang3.setBounds(50, 248, 400, 40);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Materials");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(50, 220, 110, 19);

        txt_namabarang4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_namabarang4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarang4ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_namabarang4);
        txt_namabarang4.setBounds(500, 248, 400, 40);

        jLabel14.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel14.setText("Overview");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(500, 220, 110, 19);

        txt_namabarang5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_namabarang5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarang5ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_namabarang5);
        txt_namabarang5.setBounds(50, 334, 400, 40);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Warna");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(50, 306, 230, 19);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(10, 60, 950, 890);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        hapusData();txt_namabarang2.enable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tambahData();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_hargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_hargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_hargaActionPerformed

    private void txt_namabarangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarangActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        clear();txt_namabarang2.enable();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void table_barang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_barang1MouseClicked
        // TODO add your handling code here:
        int baris = table_barang1.getSelectedRow();
        
        String warna = table.getValueAt(baris,1).toString();
        txt_namabarang5.setText(warna);
        
        String ukuran = table.getValueAt(baris, 2).toString();
        txt_namabarang1.setText(ukuran);
        
        String kode = table.getValueAt(baris, 0).toString();
        txt_namabarang2.setText(kode);
        txt_namabarang2.disable();
        String overview = table.getValueAt(baris, 3).toString();
        txt_namabarang4.setText(overview);
        
        String materials = table.getValueAt(baris, 4).toString();
        txt_namabarang3.setText(materials);
        
        String stok = table.getValueAt(baris, 5).toString();
        txt_stok.setText(stok);
        String harga = table.getValueAt(baris, 6).toString();
        txt_harga.setText(harga);
        String jenisman = table.getValueAt(baris, 7).toString();
        txt_namabarang.setText(jenisman);
        
        String tanggal = table.getValueAt(baris, 8).toString();
        
        Date convert = null;
        try{
            convert = new SimpleDateFormat("yyyy/MM/dd").parse(tanggal);   
        }catch(Exception e){
            System.out.println(e);
        }
        txt_tanggal.setDate(convert);
        
        
//        String format = "yyyy-MM-dd";
//        SimpleDateFormat date = new SimpleDateFormat(format);
//        String tanggal = String.valueOf(date.format(txt_tanggal.getDate()));
//        txt_tanggal = setDateFormatString(tanggal);
        
    }//GEN-LAST:event_table_barang1MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        editData();txt_namabarang2.enable();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txt_stokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_stokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_stokActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        new Collections().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //        table_barang.setModel(table);
        tampilData();
txt_namabarang2.enable();
        //        dispose();
        //        new stok_barang().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
//        try{
//            String file = "src/report/report_barang.jasper";
//            JasperPrint print = JasperFillManager.fillReport(file,null,conn.getKoneksi());
//            JasperViewer view = new JasperViewer(print,false);
//            view.setVisible(true);
//            JasperViewer.viewReport(print, false);
//            
//        }catch(Exception e){
//            JOptionPane.showMessageDialog(rootPane, e);
//        }
        try{
            String file = "/report/report_Man.jasper";
            
            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file),null,conn.getKoneksi());
            JasperViewer.viewReport(print, false);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void txt_namabarang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarang1ActionPerformed

    private void txt_namabarang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarang2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarang2ActionPerformed

    private void txt_namabarang3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarang3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarang3ActionPerformed

    private void txt_namabarang4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarang4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarang4ActionPerformed

    private void txt_namabarang5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarang5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarang5ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(formCRUDBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formCRUDBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formCRUDBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formCRUDBarang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new formCRUDBarang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable table_barang1;
    private javax.swing.JTextField txt_harga;
    private javax.swing.JTextField txt_namabarang;
    private javax.swing.JTextField txt_namabarang1;
    private javax.swing.JTextField txt_namabarang2;
    private javax.swing.JTextField txt_namabarang3;
    private javax.swing.JTextField txt_namabarang4;
    private javax.swing.JTextField txt_namabarang5;
    private javax.swing.JTextField txt_search;
    private javax.swing.JTextField txt_stok;
    private com.toedter.calendar.JDateChooser txt_tanggal;
    // End of variables declaration//GEN-END:variables

    private JDateChooser setDateFormatString(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
