/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backup;

import View.transaksi.*;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
//NEW
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import DAO.*;
import View.*;
import Model.*;
import Controller.Controller;
import static DAO.Dao.con;
import java.util.prefs.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
/**
 *
 * @author TS <TS.com>
 */
public class formTransa extends javax.swing.JFrame {
    DefaultTableModel table = new DefaultTableModel();
    DefaultTableModel table1 = new DefaultTableModel();
    Dao conn = new Dao();
 Controller C = new Controller();
 login_shopkeeper Shp= new login_shopkeeper();
 Keranjang K = new Keranjang();
 Row r = new Row();
 pengaturan_stok P = new pengaturan_stok();
int jumlahbarang=0;

    /**
     * Creates new form formTransaksi
     */
    public formTransa() {
        initComponents();
        Shopkeeper Shp = new Shopkeeper();
        Dao conn = new Dao();
        conn.getKoneksi();
        totalnya();
        txtkoleksi.disable();
        txtkstok.disable();
        
   table_barang1.setModel(table1);
        table1.addColumn("Kode Barang");
      table1.addColumn("Warna");
        table1.addColumn("Ukuran");
        table1.addColumn("Harga");
         table1 .addColumn("Jenis Koleksi");
          table1.addColumn("Stok");
         
          
        tb_keranjang.setModel(table);
        table.addColumn("ID");
        table.addColumn("Nama Collection");
        table.addColumn("Harga");
        
        table.addColumn("Jumlah");
        table.addColumn("Total Harga");
        
        tampilData();
         tanggal();
    }
     public void tanggal(){
        Date now = new Date();  
        tgl_transaksi.setDate(now);    
    }private void tampilDataMan(){
        //untuk mengahapus baris setelah input
        int row = table_barang1.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table1.removeRow(0);
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
                   
                    
                   
                    String harga = rslt.getString("harga");
                     String nama = rslt.getString("jenisman");
                      String stok = rslt.getString("stok");
                  
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
                String[] data1 = {kode,warna,ukuran,harga,nama,stok};
                //menambahkan baris sesuai dengan data yang tersimpan diarray
                table1.addRow(data1);
            
                //mengeset nilai yang ditampung agar muncul di table
                table_barang1.setModel(table1);
            
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }private void tampilDataKid(){
        //untuk mengahapus baris setelah input
        int row = table_barang1.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table1.removeRow(0);
        }
        
        String query = "SELECT * FROM `Kid` ";
        
        try{
            Connection connect = conn.getKoneksi();//memanggil conn
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("kode");
                    String warna = rslt.getString("warna");
                    String ukuran = rslt.getString("ukuran");
                   
                    String harga = rslt.getString("harga");
                     String nama = rslt.getString("jeniskid");
                     String stok = rslt.getString("stok");
//                   String arrays= C.showallKid();
//                   int kode1 = C.showallKids().getKode();
//                   String warna = C.showallKids().getWarna();
//                    String ukuran = C.showallKids().getWarna();
//                    String overview = C.showallKids().getOverview();
//                    String materials = C.showallKids().getMaterials();
//                    
//                    int stok1 = C.showallKids().getStok();
//                    float harga1 = C.showallKids().getHarga();
//                   String nama = C.showallKids().getJenismen();
//                  String tanggal = C.showallKids().getTanggal();
//                  String kode= String.valueOf(kode1);String stok= String.valueOf(stok1);String harga= String.valueOf(harga1);
                //masukan semua data kedalam array
                String[] data2 = {kode,warna,ukuran,harga,nama,stok};
                //menambahkan baris sesuai dengan data yang tersimpan diarray
                table1.addRow(data2);
            
                //mengeset nilai yang ditampung agar muncul di table
                table_barang1.setModel(table1);
            
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
     private void tampilDataWoman(){
        //untuk mengahapus baris setelah input
        int row = table_barang1.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table1.removeRow(0);
        }
        
        String query = "SELECT * FROM `Woman` ";
        
        try{
            Connection connect = conn.getKoneksi();//memanggil conn
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("kode");
                    String warna = rslt.getString("warna");
                    String ukuran = rslt.getString("ukuran");
                    
                    String harga = rslt.getString("harga");
                     String nama = rslt.getString("jeniswoman");
                     String stok = rslt.getString("stok");
//                   String arrays= C.showallWoman();
//                   int kode1 = C.showallWomans().getKode();
//                   String warna = C.showallWomans().getWarna();
//                    String ukuran = C.showallWomans().getWarna();
//                    String overview = C.showallWomans().getOverview();
//                    String materials = C.showallWomans().getMaterials();
//                    
//                    int stok1 = C.showallWomans().getStok();
//                    float harga1 = C.showallWomans().getHarga();
//                   String nama = C.showallWomans().getJenismen();
//                  String tanggal = C.showallWomans().getTanggal();
//                  String kode= String.valueOf(kode1);String stok= String.valueOf(stok1);String harga= String.valueOf(harga1);
                //masukan semua data kedalam array
                String[] data3 = {kode,warna,ukuran,harga,nama,stok};
                //menambahkan baris sesuai dengan data yang tersimpan diarray
                table1.addRow(data3);
            
                //mengeset nilai yang ditampung agar muncul di table
                table_barang1.setModel(table1);
            
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
     private void tampilData(){
        //untuk mengahapus baris setelah input
//        int row = tb_keranjang.getRowCount();
//        for(int a = 0 ; a < row ; a++){
//            table.removeRow(0);
//        }
        
        String query = "SELECT * FROM `tb_keranjang11` ";

        
        try{
            Connection connect = conn.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("id_transaksi");
                    String nama = rslt.getString("nama_barang");
//                    String kodebarang = rslt.getString("kode_barang");
                    String harga = rslt.getString("harga");
//                    String idshopkp = rslt.getString("id_shopkp");
//                    String tgl = rslt.getString("tanggal_transaksi");
//                    
//                    String koleksi = rslt.getString("koleksi");
//                    String shopkp = rslt.getString("idshopkp");
                    String jumlah = rslt.getString("jumlah_barang");
                    String total = rslt.getString("total_harga");
                    
                //masukan semua data kedalam array
                String[] data = {kode,nama,harga,jumlah,total};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tb_keranjang.setModel(table);
                
            
        }catch(Exception e){
            System.out.println(e);
        }
       
    }
    private void clear(){
        carikr.setText(null);
        txt_namabarang2.setText(null);
        txt_harga2.setText(null);
        txt_jumlah2.setText(null);
        txt_totalharga.setText(null);
    }
    public void keranjang(){
        
        int kode = Integer.parseInt(kodet.getText());
        String nama = txt_namabarang2.getText();
        float harga = Float.parseFloat(txt_harga2.getText());
        int shopkp = new Shopkeeper().getIdshopkp();
        
        int jumlah = Integer.parseInt(txt_jumlah2.getText());
        float total = Float.parseFloat(txt_totalharga.getText());
         int stok = Integer.parseInt(txtkstok.getText());
         String  koleksi= txtkoleksi.getText();
        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
        String tanggal = String.valueOf(date.format(tgl_transaksi.getDate()));
         if(stok >= jumlah){
        if(txtkoleksi.getText().equalsIgnoreCase("woman")){
          P = new pengaturan_stok(kode, jumlah, stok);
             C.setstokwoman(P, kode, jumlah, stok);
        }if(txtkoleksi.getText().equalsIgnoreCase("man")){
           C.pengaturanstok(kode, jumlah, stok);
            P = new pengaturan_stok(kode, jumlah, stok);
            C.setstokman(P, kode, jumlah, stok);
        }if(txtkoleksi.getText().equalsIgnoreCase("kid")){
           C.pengaturanstok(kode, jumlah, stok);
            P = new pengaturan_stok(kode, jumlah, stok);
            C.setstokkid(P,kode, jumlah, stok);
        }
        
        
       
//       r= new Row(0, kode, nama, harga, jumlah ,total,tanggal);
//             
//             
//             
//             
//             
//             
//            K= new Keranjang(jumlahbarang, tanggal);
//             K.insertRow(r);
            
        //panggil koneksi
        Connection connect = conn.getKoneksi();
        //query untuk memasukan data
        String query = "INSERT INTO `tb_keranjang11` (`tgl_transaksi`, `id_transaksi`, `kode_barang`, `nama_barang`, `idshopkp`,`koleksi`,`harga`, `jumlah_barang`, `total_harga`) "
                + "VALUES ('"+tanggal+"', NULL, '"+kode+"', '"+nama+"', '"+shopkp+"', '"+koleksi+"','"+harga+"', '"+jumlah+"', '"+total+"')";
        Pembelian pe=new Pembelian(koleksi, stok, jumlahbarang, nama, shopkp, koleksi, harga, jumlah, total);
        
        pe.beli();
        try{
            //menyiapkan statement untuk di eksekusi
           Statement 
              statement=con.createStatement();
               int 
                       
              result=statement.executeUpdate(query); 
            JOptionPane.showMessageDialog(null,"Data Masuk Ke Keranjang");
             
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan");
            
        }finally{
            tampilData();
            clear();
            
        }
        totalnya();}else
                   JOptionPane.showMessageDialog(null,"Jumlah melebihi stok");
    }
    private void hapusData(){
        //ambill data no pendaftaran
        int i = tb_keranjang.getSelectedRow();
        
        String kode = table.getValueAt(i, 0).toString();
        
        Connection connect = conn.getKoneksi();
        
        String query = "DELETE FROM `tb_keranjang11` WHERE `tb_keranjang11`.`id_transaksi` = '"+kode+"' ";
        try{
            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
            ps.execute();
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
        }finally{
            tampilData();
            clear();
        }
        totalnya();
    }private void hapuskeranjang(){
      
                   String clear = "DELETE FROM tb_keranjang11";

        try{
             Statement 
              statement=con.createStatement();
                
                       
              statement.execute(clear);
//            Connection connect = conn.getKoneksi();
//            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(clear);
//            ps.execute();
//            keranjang();
            
            
        }catch(Exception e){
            System.out.println(e);
        }finally{
            tampilData();
            totalnya();
            txt_uang.setText(null);
            txt_kembalian.setText(null);
       
        } 
    }
    private void totalnya(){
//        String total = "SELECT SUM(total_harga) FROM tb_keranjang;";
//        
//        try{
//            Connection connect = conn.getKoneksi();//memanggil koneksi
//            Statement sttmnt = connect.createStatement();//membuat statement
//            ResultSet rslt = sttmnt.executeQuery(total);//menjalanakn query\
//                while(rslt.next()){
//                 double ha=   rslt.getDouble(1);
//                    System.out.println(ha);
//                    
//                    txt_totalharga2.setText(String.valueOf(rslt.getFloat(1)));
//                }
//                
//        }catch(Exception e){
////            System.out.println(e);
//        }
        C.totalkeranjang();

//txt_harga2.setText(String.valueOf(K.total_harga()));
    }
    private void total(){
        String harga = txt_harga2.getText();
        String jumlah = txt_jumlah2.getText();
        
        int hargaa = Integer.parseInt(harga);
        try{
        int jumlahh = Integer.parseInt(jumlah);
        
        int total = hargaa * jumlahh;
        String total_harga = Integer.toString(total);
        
        txt_totalharga.setText(total_harga);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Only Number");
            txt_jumlah2.setText(null);
        }
    }
    private void reset(){
        txt_uang.setText(null);
    }
    private void kembalian(){
        String total = txt_totalharga2.getText();
        String uang = txt_uang.getText();
        
        float totals = Float.parseFloat(total);
        try{
            int uangs = Integer.parseInt(uang);     
            float kembali = (uangs - totals);
            String fix = Float.toString(kembali);
            txt_kembalian.setText(fix);
            JOptionPane.showMessageDialog(null, "Transaksi Berhasil!");
        }catch(NumberFormatException | HeadlessException e){
            JOptionPane.showMessageDialog(null, "Invalid Payment");
        }
    }
    public void bayar(){
         Connection connect = conn.getKoneksi();
        //query untuk memasukan data
        String query = "INSERT INTO transaksi SELECT * FROM tb_keranjang11";
        
        try{
            //menyiapkan statement untuk di eksekusi
           Statement 
              statement=con.createStatement();
               int 
                       
              result=statement.executeUpdate(query); 
            JOptionPane.showMessageDialog(null,"Data Masuk Ke Transaksi");
             
        }catch(SQLException | HeadlessException e){
            System.out.println(e);
            JOptionPane.showMessageDialog(null,"Data Gagal Disimpan");
            
        }finally{
            tampilData();
            clear();
            
        }
        
    }
    public void cari(){
     //untuk mengahapus baris setelah input
        int row = tb_keranjang.getRowCount();
        for(int a = 0 ; a < row ; a++){
            table.removeRow(0);
        }
        
       String cari = carikr.getText();
        
        String query = "SELECT * FROM `tb_keranjang11` WHERE `id_transaksi`  LIKE '%"+cari+"%' OR `nama_barang` LIKE '%"+cari+"%' OR `koleksi` LIKE '%"+cari+"%' ";
                
        try{
            Connection connect = conn.getKoneksi();//memanggil koneksi
            Statement sttmnt = connect.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(query);//menjalanakn query
            
            while (rslt.next()){
                //menampung data sementara
                   
                    String kode = rslt.getString("id_transaksi");
                    String nama = rslt.getString("nama_barang");
//                    String kodebarang = rslt.getString("kode_barang");
                    String harga = rslt.getString("harga");
//                    String idshopkp = rslt.getString("id_shopkp");
//                    String tgl = rslt.getString("tanggal_transaksi");
//                    
//                    String koleksi = rslt.getString("koleksi");
//                    String shopkp = rslt.getString("idshopkp");
                    String jumlah = rslt.getString("jumlah_barang");
                    String total = rslt.getString("total_harga");
                    
                //masukan semua data kedalam array
                String[] data = {kode,nama,harga,jumlah,total};
                //menambahakan baris sesuai dengan data yang tersimpan diarray
                table.addRow(data);
            }
                //mengeset nilai yang ditampung agar muncul di table
                tb_keranjang.setModel(table);
                
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
//    private void tambahData(){
//        String kode = txt_kodebarang2.getText();
//        String nama = txt_namabarang2.getText();
//        String harga = txt_harga2.getText();
//        String jumlah = txt_jumlah2.getText();
//        String total = txt_totalharga.getText();
//        SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
//        String tanggal = String.valueOf(date.format(tgl_transaksi.getDate()));
//        
//        //panggil koneksi
//        Connection connect = koneksi.getKoneksi();
//        //query untuk memasukan data
//        String query = "INSERT INTO `transaksi` (`tgl_transaksi`, `id_transaksi`, `kode_barang`, `nama_barang`, `harga`, `jumlah_barang`, `total_harga`) "
//                     + "VALUES ( '"+tanggal+"', NULL, '"+kode+"', '"+nama+"', '"+harga+"', '"+jumlah+"', '"+total+"')";
//        
//        try{
//            //menyiapkan statement untuk di eksekusi
//            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(query);
//            ps.executeUpdate(query);
//            
//            
//        }catch(SQLException | HeadlessException e){
//            System.out.println(e);
//            
//            
//        }finally{
//            
//            
//            
//        }
//    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar2 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jPanel2 = new javax.swing.JPanel();
        txt_jumlah2 = new javax.swing.JTextField();
        carikr = new javax.swing.JTextField();
        txt_namabarang2 = new javax.swing.JTextField();
        txt_totalharga = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        txt_harga2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_uang = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_kembalian = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        tgl_transaksi = new com.toedter.calendar.JDateChooser();
        jButton2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_keranjang = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        txt_totalharga2 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        table_barang1 = new javax.swing.JTable();
        jButton8 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        warnat = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        ukurantxt = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        kodet = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtkoleksi = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtkstok = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        jMenuBar2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jMenu3.setText("File");
        jMenuBar2.add(jMenu3);

        jMenu4.setText("Edit");
        jMenuBar2.add(jMenu4);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1800, 789));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(null);

        txt_jumlah2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_jumlah2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_jumlah2ActionPerformed(evt);
            }
        });
        txt_jumlah2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_jumlah2KeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_jumlah2KeyTyped(evt);
            }
        });
        jPanel2.add(txt_jumlah2);
        txt_jumlah2.setBounds(12, 323, 380, 40);

        carikr.setEditable(true);
        carikr.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        carikr.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        carikr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carikrActionPerformed(evt);
            }
        });
        jPanel2.add(carikr);
        carikr.setBounds(200, 100, 520, 33);

        txt_namabarang2.setEditable(false);
        txt_namabarang2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_namabarang2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_namabarang2ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_namabarang2);
        txt_namabarang2.setBounds(12, 179, 380, 40);

        txt_totalharga.setEditable(false);
        txt_totalharga.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_totalharga.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_totalhargaMouseReleased(evt);
            }
        });
        txt_totalharga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalhargaActionPerformed(evt);
            }
        });
        jPanel2.add(txt_totalharga);
        txt_totalharga.setBounds(12, 394, 380, 40);

        jButton1.setBackground(new java.awt.Color(255, 51, 102));
        jButton1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/credit-card.png"))); // NOI18N
        jButton1.setText("  PAYMENT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(840, 410, 442, 33);

        txt_harga2.setEditable(false);
        txt_harga2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_harga2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_harga2ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_harga2);
        txt_harga2.setBounds(12, 251, 380, 40);

        jPanel3.setBackground(new java.awt.Color(51, 51, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1853, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel3);
        jPanel3.setBounds(0, 54, 1853, 0);

        jPanel4.setBackground(new java.awt.Color(255, 0, 51));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("TRANSAKSI");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 1395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 365, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel2.add(jPanel4);
        jPanel4.setBounds(0, 0, 1760, 0);

        txt_uang.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_uang.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_uang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_uangActionPerformed(evt);
            }
        });
        txt_uang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_uangKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_uangKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_uangKeyTyped(evt);
            }
        });
        jPanel2.add(txt_uang);
        txt_uang.setBounds(840, 350, 442, 49);

        jLabel3.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel3.setText("Nama Jenis Koleksi");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(12, 153, 160, 19);

        jLabel4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel4.setText("Harga");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(12, 226, 41, 19);

        jLabel5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel5.setText("Jumlah");
        jPanel2.add(jLabel5);
        jLabel5.setBounds(12, 298, 50, 19);

        jLabel11.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel11.setText("Total Harga");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(12, 369, 79, 19);

        jLabel7.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("KEMBALIAN");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(840, 450, 442, 32);

        txt_kembalian.setEditable(false);
        txt_kembalian.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        txt_kembalian.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_kembalian.setEnabled(false);
        txt_kembalian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_kembalianActionPerformed(evt);
            }
        });
        jPanel2.add(txt_kembalian);
        txt_kembalian.setBounds(840, 490, 442, 33);

        jButton4.setBackground(new java.awt.Color(255, 51, 102));
        jButton4.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/chevron.png"))); // NOI18N
        jButton4.setText("  BACK");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);
        jButton4.setBounds(12, 530, 107, 33);

        tgl_transaksi.setDateFormatString("dd-MM-yyyy");
        tgl_transaksi.setEnabled(false);
        tgl_transaksi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jPanel2.add(tgl_transaksi);
        tgl_transaksi.setBounds(697, 61, 201, 22);

        jButton2.setBackground(new java.awt.Color(255, 51, 102));
        jButton2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/print.png"))); // NOI18N
        jButton2.setText("  PRINT");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);
        jButton2.setBounds(1170, 550, 109, 33);

        tb_keranjang.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        tb_keranjang.setModel(new javax.swing.table.DefaultTableModel(
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
        tb_keranjang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_keranjangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_keranjang);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(630, 170, 650, 120);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/che2ck.png"))); // NOI18N
        jButton5.setText("  ADD");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5);
        jButton5.setBounds(12, 467, 380, 33);

        txt_totalharga2.setEditable(false);
        txt_totalharga2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txt_totalharga2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txt_totalharga2.setEnabled(false);
        txt_totalharga2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txt_totalharga2MouseReleased(evt);
            }
        });
        txt_totalharga2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_totalharga2ActionPerformed(evt);
            }
        });
        jPanel2.add(txt_totalharga2);
        txt_totalharga2.setBounds(632, 300, 370, 39);

        jButton6.setBackground(new java.awt.Color(255, 51, 102));
        jButton6.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/trash-can (1).png"))); // NOI18N
        jButton6.setText("  DELETE");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6);
        jButton6.setBounds(1140, 300, 121, 39);

        jButton7.setBackground(new java.awt.Color(255, 51, 102));
        jButton7.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/refresh.png"))); // NOI18N
        jButton7.setText("  RESET");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7);
        jButton7.setBounds(1010, 300, 121, 38);

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
        jScrollPane3.setBounds(1320, 160, 419, 420);

        jButton8.setText("Pilih");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8);
        jButton8.setBounds(1670, 130, 69, 25);

        jRadioButton1.setText("Woman");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jRadioButton1);
        jRadioButton1.setBounds(1320, 130, 73, 25);

        jRadioButton2.setText("Man");
        jPanel2.add(jRadioButton2);
        jRadioButton2.setBounds(1440, 130, 53, 25);

        jRadioButton3.setText("Kid");
        jPanel2.add(jRadioButton3);
        jRadioButton3.setBounds(1550, 130, 45, 25);

        warnat.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        warnat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warnatActionPerformed(evt);
            }
        });
        jPanel2.add(warnat);
        warnat.setBounds(420, 320, 160, 40);

        jLabel15.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel15.setText("Warna");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(190, 330, 230, 19);

        jLabel12.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel12.setText("Ukuran");
        jPanel2.add(jLabel12);
        jLabel12.setBounds(420, 150, 110, 19);

        ukurantxt.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ukurantxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ukurantxtActionPerformed(evt);
            }
        });
        jPanel2.add(ukurantxt);
        ukurantxt.setBounds(420, 180, 160, 40);

        jLabel13.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel13.setText("Kode");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(420, 220, 110, 19);

        kodet.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        kodet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kodetActionPerformed(evt);
            }
        });
        jPanel2.add(kodet);
        kodet.setBounds(420, 250, 160, 40);

        jLabel16.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel16.setText("Warna");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(420, 290, 230, 19);

        txtkoleksi.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtkoleksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkoleksiActionPerformed(evt);
            }
        });
        jPanel2.add(txtkoleksi);
        txtkoleksi.setBounds(420, 400, 160, 40);

        jLabel17.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel17.setText("Tipe Koleksi");
        jPanel2.add(jLabel17);
        jLabel17.setBounds(420, 370, 230, 19);

        txtkstok.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        txtkstok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtkstokActionPerformed(evt);
            }
        });
        jPanel2.add(txtkstok);
        txtkstok.setBounds(420, 490, 160, 40);

        jLabel18.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel18.setText("Stok");
        jPanel2.add(jLabel18);
        jLabel18.setBounds(420, 460, 230, 19);

        jButton9.setBackground(new java.awt.Color(255, 204, 204));
        jButton9.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/asset/find.png"))); // NOI18N
        jButton9.setText("  CARI KOLEKSI");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9);
        jButton9.setBounds(10, 100, 180, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 0, 1760, 660);

        jMenuBar1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_harga2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_harga2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_harga2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        kembalian();
        bayar();
       C.hapuskeranjangan();
//        tambahData();
//        JOptionPane.showMessageDialog(null, "Transaksi Berhasil !");
//        new struk.struk().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txt_totalhargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalhargaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalhargaActionPerformed

    private void txt_namabarang2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_namabarang2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_namabarang2ActionPerformed

    private void carikrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carikrActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_carikrActionPerformed

    private void txt_jumlah2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_jumlah2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlah2ActionPerformed

    private void txt_totalhargaMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_totalhargaMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalhargaMouseReleased

    private void txt_jumlah2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlah2KeyReleased
        // TODO add your handling code here:
        total();
    }//GEN-LAST:event_txt_jumlah2KeyReleased

    private void txt_uangKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_uangKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_uangKeyReleased

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new View.menu_shopkeeper().setVisible(true);
        dispose();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txt_kembalianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_kembalianActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_kembalianActionPerformed

    private void txt_uangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_uangKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_uangKeyTyped

    private void txt_jumlah2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_jumlah2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_jumlah2KeyTyped

    private void txt_uangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_uangKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_uangKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        keranjang();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void txt_uangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_uangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_uangActionPerformed

    private void txt_totalharga2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txt_totalharga2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalharga2MouseReleased

    private void txt_totalharga2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_totalharga2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_totalharga2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        hapusData();
        txt_uang.setText(null);
        txt_kembalian.setText(null);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tb_keranjangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_keranjangMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tb_keranjangMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try{
            String file = "/struk/struk.jasper";
            
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            HashMap param = new HashMap();
            
            param.put("total",txt_totalharga2.getText());
            param.put("uang",txt_uang.getText());
            param.put("kembalian",txt_kembalian.getText());
            
            JasperPrint print = JasperFillManager.fillReport(getClass().getResourceAsStream(file),param,conn.getKoneksi());
            JasperViewer.viewReport(print, false);
            
        }catch(ClassNotFoundException | InstantiationException | IllegalAccessException | JRException e){
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
//          Connection connect = conn.getKoneksi();
//                   String clear = "DELETE FROM tb_keranjang";
//
//        try{
//             Statement 
//              statement=con.createStatement();
//                
//                       
//              statement.execute(clear);
////            Connection connect = conn.getKoneksi();
////            PreparedStatement ps = (PreparedStatement) connect.prepareStatement(clear);
////            ps.execute();
////            keranjang();
//            
//            
//        }catch(Exception e){
//            System.out.println(e);
C.hapuskeranjangan();
//        }finally{
            tampilData();
            totalnya();
            txt_uang.setText(null);
            txt_kembalian.setText(null);
       
//        } 
    }//GEN-LAST:event_jButton7ActionPerformed

    private void table_barang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_barang1MouseClicked
        // TODO add your handling code here:
        int baris = table_barang1.getSelectedRow();

        String warna = table1.getValueAt(baris,1).toString();
        warnat.setText(warna);

        String ukuran = table1.getValueAt(baris, 2).toString();
        ukurantxt.setText(ukuran);

        String kode = table1.getValueAt(baris, 0).toString();
        kodet.setText(kode);

        
        String harga = table1.getValueAt(baris, 3).toString();
        txt_harga2.setText(harga);
        String jenisman = table1.getValueAt(baris, 4).toString();
        txt_namabarang2.setText(jenisman);
         String stok = table1.getValueAt(baris, 5).toString();
        txtkstok.setText(stok);

       

//                String format = "yyyy-MM-dd";
//                SimpleDateFormat date = new SimpleDateFormat(format);
//                String tanggal = String.valueOf(date.format(txt_tanggal.getDate()));
//                txt_tanggal = setDateFormatString(tanggal);

    }//GEN-LAST:event_table_barang1MouseClicked

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        if(jRadioButton2.isSelected()==true){
            tampilDataMan();
            jRadioButton2.setSelected(false);
            jRadioButton3.setSelected(false);
            txtkoleksi.setText("man");
       }
        if(jRadioButton1.isSelected()==true){
            tampilDataWoman();
            jRadioButton1.setSelected(false);
            jRadioButton3.setSelected(false);
             txtkoleksi.setText("woman");
        }
        if(jRadioButton3.isSelected()==true){
            tampilDataKid();
            jRadioButton1.setSelected(false);
            jRadioButton2.setSelected(false);
             txtkoleksi.setText("kid");
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void warnatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warnatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_warnatActionPerformed

    private void ukurantxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ukurantxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ukurantxtActionPerformed

    private void kodetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kodetActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kodetActionPerformed

    private void txtkoleksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkoleksiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkoleksiActionPerformed

    private void txtkstokActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtkstokActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtkstokActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        cari();
    }//GEN-LAST:event_jButton9ActionPerformed

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
            java.util.logging.Logger.getLogger(formTransa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formTransa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formTransa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formTransa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new formTransa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField carikr;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField kodet;
    private javax.swing.JTable table_barang1;
    private javax.swing.JTable tb_keranjang;
    private com.toedter.calendar.JDateChooser tgl_transaksi;
    public javax.swing.JTextField txt_harga2;
    public javax.swing.JTextField txt_jumlah2;
    public static javax.swing.JTextField txt_kembalian;
    public javax.swing.JTextField txt_namabarang2;
    public javax.swing.JTextField txt_totalharga;
    public static javax.swing.JTextField txt_totalharga2;
    public static javax.swing.JTextField txt_uang;
    private javax.swing.JTextField txtkoleksi;
    private javax.swing.JTextField txtkstok;
    private javax.swing.JTextField ukurantxt;
    private javax.swing.JTextField warnat;
    // End of variables declaration//GEN-END:variables

    static class dispose {

        public dispose() {
        }
    }

}