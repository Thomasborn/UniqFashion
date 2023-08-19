/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import DAO.Dao;
import Model.*;
/**
 *
 * @author TS <TS.com>
 */
public class Controller {
    protected Shopkeeper S = new Shopkeeper();
    protected Admin A = new Admin();
    protected Man M= new Man();
    protected Woman W = new Woman();
    protected Kid K = new Kid();
    protected pengaturan_stok P = new pengaturan_stok();
    protected Dao mydao = new Dao();

    public Controller() {
    }
    public void setShopkeeper(int idshopkp, String nama, String idNumber,String tanggalmasuk)
    {     S= new Shopkeeper(idshopkp, nama, idNumber,tanggalmasuk);
            
            }
     public void setAdmin(String idadmin, String nama, String idNumber,String tanggalmasuk)
    {     A= new Admin(idadmin, nama, idNumber,tanggalmasuk);
            
            }
      public void setMan(String jenismen, String warna, String ukuran, int kode, String overview, String materials, int stok, float harga,String tanggal)
    {     M= new Man(jenismen, warna, ukuran, kode, overview, materials, stok, harga,tanggal);
            
            }public void pengaturanstok(int kode,int jumlah,int stok){
                P = new pengaturan_stok(kode, jumlah,   stok);
            }
      public void setWoman(String jeniswomen, String warna, String ukuran, int kode, String overview, String materials, int stok, float harga,String tanggal)
    {     W= new Woman(jeniswomen, warna, ukuran, kode, overview, materials, stok, harga,tanggal);
            
            }public void setKid(String jeniskid, String warna, String ukuran, int kode, String overview, String materials, int stok, float harga,String tanggal)
    {     K= new Kid(jeniskid, warna, ukuran, kode, overview, materials, stok, harga,tanggal);
            
            }
             public boolean Login(int _Username,String _Password){
                 boolean hasil;
                 mydao.makeConnection();
                 hasil = mydao.loginSh(_Username, _Password);
                 mydao.closeConnection();
                 return hasil;
                 
             }
              public boolean Loginadmin(String _Username,String _Password){
                 boolean hasil;
                 mydao.makeConnection();
                 hasil = mydao.Admin(_Username, _Password);
                 mydao.closeConnection();
                 return hasil;
                 
             }
             public String TampilShopKeeper(){
                 return S.Tampil();
             }
              public String TampilAdmin(){
                 return A.Tampil();
             }
               public String TampilMan(){
                 return M.Tampils();
             }public String TampilWoman(){
                 return W.Tampils();
             }public String TampilKid(){
                 return K.Tampils();
             }
           public void addShopkeeper(Shopkeeper shopkeeper) 
                { 
               mydao.makeConnection(); 
               mydao.insertShopkeeper(shopkeeper); 
               mydao.closeConnection(); 
               }    public void addAdmin(Admin admin) 
                { 
               mydao.makeConnection(); 
               mydao.daftarAdmin(admin); 
               mydao.closeConnection(); 
               }  
           public void addMan(Man man) 
                { 
               mydao.makeConnection(); 
               mydao.insertMan(man); 
               mydao.closeConnection(); 
               }
           public void addWoman(Woman woman) 
                { 
               mydao.makeConnection(); 
               mydao.insertWoman(woman); 
               mydao.closeConnection(); 
               }
           public void addKid(Kid kid) 
                { 
               mydao.makeConnection(); 
               mydao.insertKid(kid);
               mydao.closeConnection(); 
               }
           public boolean cekdataSh(String id) 
                { 
                boolean temp=false; 
               mydao.makeConnection();
               temp = mydao.cekdataSh(id); 
               mydao.closeConnection(); 
               return temp;
                }
            public boolean cekdataMan(int id) 
                { 
                boolean temp=false; 
               mydao.makeConnection();
               temp = mydao.cekdataMan(id); 
               mydao.closeConnection(); 
               return temp;
                }
             public boolean cekdataWoman(String id) 
                { 
                boolean temp=false; 
               mydao.makeConnection();
               temp = mydao.cekdataWomen(id); 
               mydao.closeConnection(); 
               return temp;
                }
              public boolean cekdataKid(String id) 
                { 
                boolean temp=false; 
               mydao.makeConnection();
               temp = mydao.cekdataKid(id); 
               mydao.closeConnection(); 
               return temp;
                }
              public void showAdmin( String id) 
                { 
               mydao.makeConnection(); 
               mydao.showAdmin(id); 
               mydao.closeConnection(); 

               }public void showShopKepeer( String id) 
                { 
               mydao.makeConnection(); 
               mydao.showShopkeeper(id); 
               mydao.closeConnection(); 

               }
               public void showMan( String id) 
                { 
               mydao.makeConnection(); 
               mydao.showMan(id); 
               mydao.closeConnection(); 

               } public void showWoman( String id) 
                { 
               mydao.makeConnection(); 
               mydao.showWoman(id); 
               mydao.closeConnection(); 

               } public void showKid( String id) 
                { 
               mydao.makeConnection(); 
               mydao.showKid(id); 
               mydao.closeConnection(); 

               }
               public Shopkeeper DataSh(String id){ 
               mydao.makeConnection(); 
                Shopkeeper P = 
               mydao.dataShopkeeper(id); 
               mydao.closeConnection(); return P; 
               }
                public Admin Dataad(String id){ 
               mydao.makeConnection(); 
                Admin P = 
               mydao.dataAdmin(id); 
               mydao.closeConnection(); return P; 
               }
               public Man DataMan(String id){ 
               mydao.makeConnection(); 
                Man P = 
               mydao.dataMan(id); 
               mydao.closeConnection(); return P; 
               }
               public Woman DataWoman(String id){ 
               mydao.makeConnection(); 
                Woman P = 
               mydao.dataWoman(id); 
               mydao.closeConnection(); return P; 
               }
               public Kid DataKid(String id){ 
               mydao.makeConnection(); 
                Kid P = 
               mydao.dataKid(id); 
               mydao.closeConnection(); return P; 
               }
               public void UpdateShopkeeper(Shopkeeper shopkeeper, String id) 
                { 
               mydao.makeConnection(); 
               mydao.EditSh(shopkeeper, id); 
               mydao.closeConnection(); 

               }public void UpdateAdmin(Admin admin, String id) 
                { 
               mydao.makeConnection(); 
               mydao.EditAdmin(admin, id); 
               mydao.closeConnection(); 

               }public void UpdateMan(Man man, int id) 
                { 
               mydao.makeConnection(); 
               mydao.EditMan(man, id); 
               mydao.closeConnection(); 

               }
               public void UpdateWoman(Woman woman, int id) 
                { 
               mydao.makeConnection(); 
               mydao.EditWoman(woman, id); 
               mydao.closeConnection(); 

               }
               public void UpdateKid(Kid kid, int id) 
                { 
               mydao.makeConnection(); 
               mydao.EditKid(kid, id); 
               mydao.closeConnection(); 

               }
                public void deleteShopkeeper(String id){ 
               mydao.makeConnection(); 
               mydao.deleteShopkeeper(id); 
               mydao.closeConnection(); 

               } public void deleteAdmin(String id){ 
               mydao.makeConnection(); 
               mydao.deleteAdmin(id); 
               mydao.closeConnection(); } public void deleteMan(int id){ 
               mydao.makeConnection(); 
               mydao.deleteMan(id); 
               mydao.closeConnection(); 

               }
                public void deleteWoman(int id){ 
               mydao.makeConnection(); 
               mydao.deleteWoman(id); 
               mydao.closeConnection(); 

               }
                public void deleteKid(int id){ 
               mydao.makeConnection(); 
               mydao.deleteKid(id); 
               mydao.closeConnection(); 

               }
               public String showallShopkeeper(){ 
               String show;
                    mydao.makeConnection(); 
               
              show = mydao.showAllShopkeeper(); 
               mydao.closeConnection();
               return show;
               }public Report showallPembelian(){ 
              
                    mydao.makeConnection(); 
               
             Report show=  mydao.showAllKeranjang();
               mydao.closeConnection();
               return show;
              
               }public Report showal(){ 
              
                    mydao.makeConnection(); 
               
             Report show=  mydao.showtra();
               mydao.closeConnection();
               return show;
              
               }public Cabang_Uniq showall(){ 
              
                    mydao.makeConnection(); 
               
             Cabang_Uniq show=  mydao.showAllCabang();
               mydao.closeConnection();
               return show;
              
               }
               public String showallMan(){ 
               String show;
                    mydao.makeConnection(); 
               
              show = mydao.showAllMan(); 
               mydao.closeConnection();
               return show;
               }public String showallWoman(){ 
               String show;
                    mydao.makeConnection(); 
               
              show = mydao.showAllWoman(); 
               mydao.closeConnection();
               return show;
               }public void setstokwoman(pengaturan_stok P,int kode, int jumlah,int stok)
    {       mydao.makeConnection(); 
               mydao.stokwoman(P,kode, jumlah,stok); 
               mydao.closeConnection();
            
            }public void setstokman(pengaturan_stok P,int kode, int jumlah,int stok)
    {       mydao.makeConnection(); 
               mydao.stokman(P,kode, jumlah,stok); 
               mydao.closeConnection();
            
            }public void setstokkid(pengaturan_stok P,int kode, int jumlah,int stok)
    {       mydao.makeConnection(); 
               mydao.stokkid(P,kode, jumlah,stok); 
               mydao.closeConnection();
            
            }
               public String showallKid(){ 
               String show;
                    mydao.makeConnection(); 
               
              show = mydao.showAllKid(); 
               mydao.closeConnection();
               return show;
               }public Man showallMans(){ 
               
                    mydao.makeConnection(); 
               
            Man shows = mydao.showAllMans(); 
               mydao.closeConnection();
               return shows;
               }public void totalkeranjang(){ 
               
                    mydao.makeConnection(); 
               
              mydao.keranjang(); 
               mydao.closeConnection();
               
               }
               public double totaltransaksi(){ 
               double total=0;
                    mydao.makeConnection(); 
               
             total= mydao.totaltransaksi();
               mydao.closeConnection();
               return total;
               }
               public void hapuskeranjangan(){ 
               
                    mydao.makeConnection(); 
               
              mydao.hapus();
               mydao.closeConnection();
               
               }public int cekjumlahtransaksi(){ 
               int total=0;
                    mydao.makeConnection(); 
               
             total= mydao.cektransaksi();
               mydao.closeConnection();
               return total;
               }
               
               public void pindah(){ 
               
                    mydao.makeConnection(); 
               
              mydao.pindah();
               mydao.closeConnection();
               
               }
}
