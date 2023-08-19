/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.*;
import static View.transaksi.formTransaksi.txt_totalharga2;
import java.sql.Connection;
import java.sql.DriverManager; 
import java.sql.ResultSet; 
import java.sql.Statement; 
import java.io.File;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author TS <TS.com>
 */
public class Dao {
     public static Connection con; 
             public static final String url = "jdbc:ucanaccess://"; 
            public static final String path = "D://dbfas.mdb";
 public static Connection getKoneksi(){
        try{
           
            
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            con = DriverManager.getConnection(url+path);
            System.out.println("Koneksi berhasil");
            
        }catch(Exception e){
            System.out.println("Koneksi Gagal");
        }return con;
    
    }
    public Dao() {
    }
            public void makeConnection(){ 
             System.out.println("Opening Database..."); try 
            { 
             con = DriverManager.getConnection(url+path); 
             System.out.println("Success !\n"); 
            }catch(Exception EX){ 
             System.out.println("Error opening the database..."); 
             System.out.println(EX); 
             } 
             } 
             public void closeConnection(){ 
             System.out.println("Closing database..."); 
             try{ 
             con.close(); 
             System.out.println("Success!\n"); 
            }catch(Exception EX){ 
             System.out.println("Error Closing the database..."); 
             System.out.println(EX); 
             } 
             }
             public boolean loginSh(int _Username, String _Password) { 
            boolean hasil=false; 
             Shopkeeper temp = new Shopkeeper(); 
             String sql="SELECT idshopkp, idNumber from Shopkeeper" 
             + " where idshopkp LIKE'%"+_Username+"%' and idNumber LIKE '%"+_Password+"%'"; try{ 
             Statement state = con.createStatement(); 
             ResultSet rs = state.executeQuery(sql); 
            if(rs!=null){ while (rs.next()){ 
             temp =new Shopkeeper(rs.getInt("idshopkp"), rs.getString("idNumber")); hasil = true; 
            } } rs.close(); state.close(); 
            }catch(Exception EX){ 
             System.out.println(".."); 
             System.out.println(EX); 
             } 
             return hasil; 
              } public boolean Admin(String _Username, String _Password) { 
            boolean hasil=false; 
             Admin temp = new Admin(); 
             String sql="SELECT idadmin, idNumber from Admin" 
             + " where idadmin LIKE'%"+_Username+"%' and idNumber LIKE '%"+_Password+"%'"; try{ 
             Statement state = con.createStatement(); 
             ResultSet rs = state.executeQuery(sql); 
            if(rs!=null){ while (rs.next()){ 
             temp =new Admin(rs.getString("idadmin"), rs.getString("idNumber")); 
             hasil = true; 
            } } rs.close(); state.close(); 
            }catch(Exception EX){ 
             System.out.println("."); 
             System.out.println(EX); 
             } 
             return hasil; 
              }
              public boolean login(int _Username, String _Password) { 
            boolean hasil=false; 
             Login temp = new Login(); 
             String sql="SELECT idshopkp, idNumber from Shopkeeper" 
             + " where idshopkp LIKE'%"+_Username+"%' and idNumber LIKE '%"+_Password+"%'"; try{ 
             Statement state = con.createStatement(); 
             ResultSet rs = state.executeQuery(sql); 
            if(rs!=null){ while (rs.next()){ 
             temp =new Login(rs.getInt("idshopkp"), rs.getString("idNumber")); hasil = true; 
            } } rs.close(); state.close(); 
            }catch(Exception EX){ 
             System.out.println(" ."); 
             System.out.println(EX); 
             } 
             return hasil; 
              }
              public void Pembelian(Pembelian pembelian){
                    String sql="INSERT INTO `transaksi` (`tgl_transaksi`, `id_transaksi`, `kode_barang`, `nama_barang`, `idshopkp`,`harga`, `jumlah_barang`, `total_harga`) VALUES('"+pembelian.getTgl_transaksi()+"','"+pembelian.getIdtransaksi()+"','"+pembelian.getKode_barang()+"','"+pembelian.getNama_barang()+"','"+pembelian.User()+"','"+pembelian.getKoleksi()+
                            "','"+pembelian.getHarga()+"','"+pembelian.getJumlah()+"','"+pembelian.getTotalharga()+"')";
             
               System.out.println("Tambah Pembelian"); try{ 
               Statement 
              statement=con.createStatement();
               int 
              result=statement.executeUpdate(sql);
               if(pembelian.getKoleksi().equalsIgnoreCase("man")){
                   
               }if(pembelian.getKoleksi().equalsIgnoreCase("woman")){
                   
               }if(pembelian.getKoleksi().equalsIgnoreCase("kid")){
                   
               }
              System.out.println("Tambah"+result+"Pembelian\n"); 
              statement.close(); 
               } 
              catch(Exception Ex){ 
               System.out.println("Gagal Menambah Pembelian \n"); 
               System.out.println(Ex); 
               } 
             }
              
             public void insertShopkeeper(Shopkeeper shopkeeper){
                 String sql="INSERT INTO Shopkeeper (idshopkp, nama, idNumber,tanggalmasuk) VALUES('"+shopkeeper.getIdshopkp()+"','"+shopkeeper.getNama()+"','"+shopkeeper.getIdNumber()+"','"+shopkeeper.getTanggalmasuk()+"')";
             
               System.out.println("Tambah Shopkeeper"); try{ 
               Statement 
              statement=con.createStatement();
               int 
              result=statement.executeUpdate(sql); 
              System.out.println("Tambah"+result+"Shopkeeper\n"); 
              statement.close(); 
               } 
              catch(Exception Ex){ 
               System.out.println("Gagal Menambah Shopkeeper \n"); 
               System.out.println(Ex); 
               } 
             }public void daftarAdmin(Admin admin){
                 String sql="INSERT INTO Admin (idadmin, nama, idNumber,tanggalmasuk) VALUES('"+admin.getIdadmin()+"','"+admin.getNama()+"','"+admin.getIdNumber()+"','"+admin.getTanggalmasuk()+"')";
             
               System.out.println("Tambah Admin"); try{ 
               Statement 
              statement=con.createStatement();
               int 
              result=statement.executeUpdate(sql); 
              System.out.println("Tambah"+result+"Admin\n"); 
              statement.close(); 
               } 
              catch(Exception Ex){ 
               System.out.println("Gagal Daftar Admin \n"); 
               System.out.println(Ex); 
               }}
               public boolean cekdataSh(String idshopkp){ 
                    boolean temp=false; 
                     String sql="SELECT  idshopkp,  nama, idNumber,tanggalmasuk FROM Shopkeeper where idshopkp='"+idshopkp+"'";
                     try{ 
                     Statement 
                    statement=con.createStatement(); 
                    ResultSet rs=statement.executeQuery(sql); 
                    if(rs!=null){ 
                    while(rs.next()){ 
                    temp=true; 
                    } } 
                    rs.close(); 
                    statement.close();
                                } 
            catch(Exception Ex){ 
             System.out.println("Error reading database information...\n"); 
             System.out.println(Ex); 
            } 
            return temp; 

            }public boolean cekdataAdmin(String idadmin){ 
                    boolean temp=false; 
                     String sql="SELECT  idadmin,  nama, idNumber,tanggalmasuk FROM Shopkeeper where idadmin='"+idadmin+"'";
                     try{ 
                     Statement 
                    statement=con.createStatement(); 
                    ResultSet rs=statement.executeQuery(sql); 
                    if(rs!=null){ 
                    while(rs.next()){ 
                    temp=true; 
                    } } 
                    rs.close(); 
                    statement.close();
                                } 
            catch(Exception Ex){ 
             System.out.println("Error reading database information...\n"); 
             System.out.println(Ex); 
            } 
            return temp; 

            }
            
            public void insertMan(Man man){
                 String sql="INSERT INTO Man (`kode`, `warna`, `ukuran`, `overview`, `materials`,`stok`,`harga`,`jenisman`,`tanggal`)  VALUES('"+man.getKode()+"','"+man.getWarna()+"','"+man.getUkuran()+"','"+man.getOverview()+"','"+man.getMaterials()+"','"+man.getStok()+"','"+man.getHarga()+"','"+man.getJenisman()+"','"+man.getTanggal()+"')";
             
               System.out.println("Tambah Koleksi Man"); try{ 
               Statement 
              statement=con.createStatement();
               int 
                       
              result=statement.executeUpdate(sql); 
              System.out.println("Tambah"+result+"Koleksi Man\n"); 
              statement.close();
              JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
               } 
              catch(Exception Ex){ 
               System.out.println("Gagal Menambah Man \n"); 
               System.out.println(Ex); 
               JOptionPane.showMessageDialog(null,"Data Gagal Disimpan");
               } 
             } public void insertWoman(Woman woman){
                 String sql="INSERT INTO Woman (`kode`, `warna`, `ukuran`, `overview`, `materials`,`stok`,`harga`,`jeniswoman`,`tanggal`)  VALUES('"+woman.getKode()+"','"+woman.getWarna()+"','"+woman.getUkuran()+"','"+woman.getOverview()+"','"+woman.getMaterials()+"','"+woman.getStok()+"','"+woman.getHarga()+"','"+woman.getJeniswo()+"','"+woman.getTanggal()+"')";
             
               System.out.println("Tambah Koleksi Woman"); try{ 
               Statement 
              statement=con.createStatement();
               int 
              result=statement.executeUpdate(sql); 
              System.out.println("Tambah"+result+"Koleksi Woman\n"); 
              statement.close(); 
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
               } 
              catch(Exception Ex){ 
               System.out.println("Gagal Menambah Woman \n"); 
               System.out.println(Ex); 
               } 
             }public void insertKid(Kid kid){
                 String sql="INSERT INTO Kid (`kode`, `warna`, `ukuran`, `overview`, `materials`,`stok`,`harga`,`jeniskid`,`tanggal`)  VALUES('"+kid.getKode()+"','"+kid.getWarna()+"','"+kid.getUkuran()+"','"+kid.getOverview()+"','"+kid.getMaterials()+"','"+kid.getStok()+"','"+kid.getHarga()+"','"+kid.getJeniskid()+"','"+kid.getTanggal()+"')";
             
               System.out.println("Tambah Koleksi Kid"); try{ 
               Statement 
              statement=con.createStatement();
               int 
              result=statement.executeUpdate(sql); 
              System.out.println("Tambah"+result+"Koleksi Kid\n"); 
                JOptionPane.showMessageDialog(null,"Data Berhasil Disimpan");
              statement.close(); 
               } 
              catch(Exception Ex){ 
               System.out.println("Gagal Menambah Kid \n"); 
               System.out.println(Ex); 
               } 
             }
//             public void insertBaby(Baby baby){
//                 String sql="INSERT INTO Baby (warna, ukuran, kode, overview, materials, stok,jenisbaby) VALUES('"+baby.getWarna()+"','"+baby.getUkuran()+"','"+baby.getKode()+"','"+baby.getOverview()+"','"+baby.getMaterials()+"','"+baby.getStok()+"','"+baby.getJenisbaby()+"')";
//             
//               System.out.println("Tambah Koleksi Baby"); try{ 
//               Statement 
//              statement=con.createStatement();
//               int 
//              result=statement.executeUpdate(sql); 
//              System.out.println("Tambah"+result+"Koleksi Baby\n"); 
//              statement.close(); 
//               } 
//              catch(Exception Ex){ 
//               System.out.println("Gagal Menambah Baby \n"); 
//               System.out.println(Ex); 
//               } 
//             }
             public boolean cekdataMan(int kode){ 
                    boolean temp=false; 
                     String sql="SELECT  kode,  warna, ukuran,overview,materials,stok,,harga,jenisman FROM Man where kode='"+kode+"'";
                     try{ 
                     Statement 
                    statement=con.createStatement(); 
                    ResultSet rs=statement.executeQuery(sql); 
                    if(rs!=null){ 
                    while(rs.next()){ 
                    temp=true; 
                    } } 
                    rs.close(); 
                    statement.close();
                                } 
            catch(Exception Ex){ 
             System.out.println("Error reading database information...\n"); 
             System.out.println(Ex); 
            } 
            return temp; 

            }
             public boolean cekdataWomen(String kode){ 
                    boolean temp=false; 
                     String sql="SELECT  kode,  warna, ukuran,overview,materials,,stok,,harga,jeniswoman FROM Women where kode='"+kode+"'";
                     try{ 
                     Statement 
                    statement=con.createStatement(); 
                    ResultSet rs=statement.executeQuery(sql); 
                    if(rs!=null){ 
                    while(rs.next()){ 
                    temp=true; 
                    } } 
                    rs.close(); 
                    statement.close();
                                } 
            catch(Exception Ex){ 
             System.out.println("Error reading database information...\n"); 
             System.out.println(Ex); 
            } 
            return temp; 

            } public boolean cekdataKid(String kode){ 
                    boolean temp=false; 
                     String sql="SELECT  kode,  warna, ukuran,overview,materials,,stok,,harga,jeniskid FROM Kid where kode='"+kode+"'";
                     try{ 
                     Statement 
                    statement=con.createStatement(); 
                    ResultSet rs=statement.executeQuery(sql); 
                    if(rs!=null){ 
                    while(rs.next()){ 
                    temp=true; 
                    } } 
                    rs.close(); 
                    statement.close();
                                } 
            catch(Exception Ex){ 
             System.out.println("Error reading database information...\n"); 
             System.out.println(Ex); 
            } 
            return temp; 

            }
//            public boolean cekdataBaby(String kode){ 
//                    boolean temp=false; 
//                     String sql="SELECT  kode,  warna, ukuran,overview,materials,,stok,jenisbaby FROM Baby where kode='"+kode+"'";
//                     try{ 
//                     Statement 
//                    statement=con.createStatement(); 
//                    ResultSet rs=statement.executeQuery(sql); 
//                    if(rs!=null){ 
//                    while(rs.next()){ 
//                    temp=true; 
//                    } } 
//                    rs.close(); 
//                    statement.close();
//                                } 
//            catch(Exception Ex){ 
//             System.out.println("Error reading database information...\n"); 
//             System.out.println(Ex); 
//            } 
//            return temp; 
//
//            }
             public String 
                        showShopkeeper(String idshopkp){ String 
                        Hasil = ""; 
                         String sql="SELECT idshopkp,  nama,  idNumber, tanggalmasuk FROM Shopkeeper where idshopkp='"+idshopkp+"'"; 
                         
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
                 Shopkeeper S;
                    S = new
                        Shopkeeper(rs.getInt("idshopkp"), rs.getString("nama"), rs.getString("idNumber"), rs.getString("tanggalmasuk"));
                 Hasil += 
                S.Tampil(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return Hasil; 

                } public String 
                        showAdmin(String idadmin){ String 
                        Hasil = ""; 
                         String sql="SELECT idadmin,  nama,  idNumber, tanggalmasuk FROM Admin where idadmin='"+idadmin+"'"; 
                         
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
               Admin A;
                    A = new
                        Admin(rs.getString("idadmin"), rs.getString("nama"), rs.getString("idNumber"), rs.getString("tanggalmasuk"));
                 Hasil += 
                A.Tampil(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return Hasil; 

                } public String 
                        showMan(String kode){ String 
                        Hasil = ""; 
                         String sql="SELECT warna,  ukuran,  kode,overview,materials,,harga,jenisman FROM Man where kode='"+kode+"'"; 
                         
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
                 Man M;
                    M = new
                        Man(rs.getString("jenisman"), rs.getString("warna"), rs.getString("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"),  rs.getInt("stok"),rs.getFloat("harga"),rs.getString("tanggal"));
                 Hasil += 
                M.Tampils(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return Hasil; 

                }
                        public String 
                        showWoman(String kode){ String 
                        Hasil = ""; 
                         String sql="SELECT warna,  ukuran,  kode,overview,materials,,harga,jeniswoman FROM Woman where kode='"+kode+"'"; 
                         
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
                 Woman W;
                    W = new
                        Woman(rs.getString("jeniswoman"), rs.getString("warna"), rs.getString("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"), rs.getInt("stok"),rs.getFloat("harga"),rs.getString("tanggal"));
                 Hasil += 
                W.Tampils(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return Hasil; 

                } public String 
                        showKid(String kode){ String 
                        Hasil = ""; 
                         String sql="SELECT warna,  ukuran,  kode,overview,materials,,harga,jeniskid FROM Kid where kode='"+kode+"'"; 
                         
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
                 Kid K;
                    K = new
                        Kid(rs.getString("jeniskid"), rs.getString("warna"), rs.getString("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"), rs.getInt("stok"),rs.getFloat("harga"),rs.getString("tanggal"));
                 Hasil += 
                K.Tampils(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return Hasil; 

                }
//                         public String 
//                        showBaby(String kode){ String 
//                        Hasil = ""; 
//                         String sql="SELECT warna,  ukuran,  kode,overview,materials,jenisbaby FROM Baby where kode='"+kode+"'"; 
//                         
//                         try{ 
//                         Statement 
//                        statement=con.createStatement(); 
//                        ResultSet rs=statement.executeQuery(sql);
//               
//                      
//                if(rs!=null){ 
//                while(rs.next()){ 
//                 Baby W;
//                    W = new
//                        Baby(rs.getString("jeniswoman"), rs.getString("warna"), rs.getInt("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"), rs.getInt("stok"));
//                 Hasil += 
//                W.Tampils(); 
//                } } 
//                rs.close(); 
//                statement.close(); 
//
//                } 
//                catch(Exception Ex){ 
//                 System.out.println("Error reading database information...\n"); 
//                 System.out.println(Ex); 
//                } 
//                return Hasil; 
//
//                }
                        public Shopkeeper dataShopkeeper(String id){ 
                      Shopkeeper D = new Shopkeeper(); 
                      String sql="SELECT idshopkp,  nama,  idNumber,tanggalmasuk FROM Shopkeeper where idshopkp='"+id+"'"; 
                      try{ 
                      Statement 
                     statement=con.createStatement(); 
                     ResultSet rs=statement.executeQuery(sql); 
                     if(rs!=null){ 
                     while(rs.next()){ 
                      D = new Shopkeeper(rs.getInt("idshopkp"), rs.getString("nama"), 
                    rs.getString("idNumber"), rs.getString("tanggalmasuk")); 
                     } } 
                     rs.close(); 
                     statement.close(); 

                     } 
                     catch(Exception Ex){ 
                      System.out.println("Error reading database information...\n"); 
                      System.out.println(Ex); 
                     } 
                     return D; 

                     }public Admin dataAdmin(String id){ 
                      Admin D = new Admin(); 
                      String sql="SELECT idadmin,  nama,  idNumber,tanggalmasuk FROM Admin where idadmin='"+id+"'"; 
                      try{ 
                      Statement 
                     statement=con.createStatement(); 
                     ResultSet rs=statement.executeQuery(sql); 
                     if(rs!=null){ 
                     while(rs.next()){ 
                      D = new Admin(rs.getString("idadmin"), rs.getString("nama"), 
                    rs.getString("idNumber"), rs.getString("tanggalmasuk")); 
                     } } 
                     rs.close(); 
                     statement.close(); 

                     } 
                     catch(Exception Ex){ 
                      System.out.println("Error reading database information...\n"); 
                      System.out.println(Ex); 
                     } 
                     return D; 

                     }public Man dataMan(String id){ 
                      Man D = new Man(); 
                      String sql="SELECT warna,  ukuran,  kode,overview,materials,stok,,harga,jenisman FROM Man where kode='"+id+"'"; 
                      try{ 
                      Statement 
                     statement=con.createStatement(); 
                     ResultSet rs=statement.executeQuery(sql); 
                     if(rs!=null){ 
                     while(rs.next()){ 
                      D = new  Man(rs.getString("jenisman"), rs.getString("warna"), rs.getString("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"), rs.getInt("stok"),rs.getFloat("harga"),rs.getString("tanggal"));
      
                     } } 
                     rs.close(); 
                     statement.close(); 

                     } 
                     catch(Exception Ex){ 
                      System.out.println("Error reading database information...\n"); 
                      System.out.println(Ex); 
                     } 
                     return D; 

                     }public Woman dataWoman(String id){ 
                      Woman D = new Woman(); 
                      String sql="SELECT warna,  ukuran,  kode,overview,materials,stok,,harga,jeniswoman FROM Woman where kode='"+id+"'"; 
                      try{ 
                      Statement 
                     statement=con.createStatement(); 
                     ResultSet rs=statement.executeQuery(sql); 
                     if(rs!=null){ 
                     while(rs.next()){ 
                      D = new  Woman(rs.getString("jeniswoman"), rs.getString("warna"), rs.getString("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"), rs.getInt("stok"),rs.getFloat("harga"),rs.getString("tanggal"));
      
                     } } 
                     rs.close(); 
                     statement.close(); 

                     } 
                     catch(Exception Ex){ 
                      System.out.println("Error reading database information...\n"); 
                      System.out.println(Ex); 
                     } 
                     return D; 

                     }public Kid dataKid(String id){ 
                      Kid D = new Kid(); 
                      String sql="SELECT warna,  ukuran,  kode,overview,materials,stok,,harga,jeniskid FROM Kid where kode='"+id+"'"; 
                      try{ 
                      Statement 
                     statement=con.createStatement(); 
                     ResultSet rs=statement.executeQuery(sql); 
                     if(rs!=null){ 
                     while(rs.next()){ 
                      D = new  Kid(rs.getString("jeniskid"), rs.getString("warna"), rs.getString("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"), rs.getInt("stok"),rs.getFloat("harga"),rs.getString("tanggal"));
      
                     } } 
                     rs.close(); 
                     statement.close(); 

                     } 
                     catch(Exception Ex){ 
                      System.out.println("Error reading database information...\n"); 
                      System.out.println(Ex); 
                     } 
                     return D; 

                     }
//                     public Baby dataBaby(String id){ 
//                      Baby D = new Baby(); 
//                      String sql="SELECT warna,  ukuran,  kode,overview,materials,stok,jenisman FROM Baby where kode='"+id+"'"; 
//                      try{ 
//                      Statement 
//                     statement=con.createStatement(); 
//                     ResultSet rs=statement.executeQuery(sql); 
//                     if(rs!=null){ 
//                     while(rs.next()){ 
//                      D = new  Baby(rs.getString("jenisbaby"), rs.getString("warna"), rs.getInt("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"), rs.getInt("stok"));
//      
//                     } } 
//                     rs.close(); 
//                     statement.close(); 
//
//                     } 
//                     catch(Exception Ex){ 
//                      System.out.println("Error reading database information...\n"); 
//                      System.out.println(Ex); 
//                     } 
//                     return D; 
//
//                     }
                    public void EditSh(Shopkeeper shopkeeper,String id){ 
                     String sql="UPDATE Shopkeeper SET idshopkp='"+shopkeeper.getIdshopkp()+"',nama='"+shopkeeper.getNama()+"',idNumber='"+shopkeeper.getIdNumber()+"' where idNumber='" +id+"'"; 
                    System.out.println("Edit Shopkeeper"); try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql); 
                     System.out.println("Edit"+result+"Shopkeeper\n"+id); 
                    statement.close(); 
                     } 
                    catch(Exception Ex){ 
                     System.out.println("Error edit a Shopkeeper...\n"); 
                    System.out.println(Ex); 
                    } 
                    }  public void EditAdmin(Admin admin,String id){ 
                     String sql="UPDATE Admin SET idadmin='"+admin.getIdadmin()+"',nama='"+admin.getNama()+"',idNumber='"+admin.getIdNumber()+"' where idNumber='" +id+"'"; 
                    System.out.println("Edit Admin"); try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql); 
                     System.out.println("Edit"+result+"Admin\n"+id); 
                    statement.close(); 
                     } 
                    catch(Exception Ex){ 
                     System.out.println("Error edit a Admin...\n"); 
                    System.out.println(Ex); 
                    } 
                    } public void EditMan(Man man,int id){ 
                     String sql="UPDATE Man SET warna='"+man.getWarna()+"',ukuran='"+man.getUkuran()+"',kode='"+man.getKode()+"',overview='"+man.getOverview()+"' ,materials='"+man.getMaterials()+"',stok='"+man.getStok()+"',harga='"+man.getHarga()+"',jenisman='"+man.getJenisman()+"'where kode='" +id+"'"; 
                    System.out.println("Edit Man"); try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql); 
                     System.out.println("Edit"+result+"Man\n"+id); 
                    statement.close(); 
                     } 
                    catch(Exception Ex){ 
                     System.out.println("Error edit a Man...\n"); 
                    System.out.println(Ex); 
                    } 
                    } public void EditWoman(Woman man,int id){ 
                     String sql="UPDATE Woman SET warna='"+man.getWarna()+"',ukuran='"+man.getUkuran()+"',kode='"+man.getKode()+"',overview='"+man.getOverview()+"' ,materials='"+man.getMaterials()+"',stok='"+man.getStok()+"',harga='"+man.getHarga()+"',jeniswoman='"+man.getJeniswo()+"'where kode='" +id+"'"; 
                    System.out.println("Edit Man"); try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql); 
                     System.out.println("Edit"+result+"WoMan\n"+id); 
                    statement.close(); 
                     } 
                    catch(Exception Ex){ 
                     System.out.println("Error edit a WoMan...\n"); 
                    System.out.println(Ex); 
                    } 
                    }public void EditKid(Kid kid,int id){ 
                     String sql="UPDATE Kid SET warna='"+kid.getWarna()+"',ukuran='"+kid.getUkuran()+"',kode='"+kid.getKode()+"',overview='"+kid.getOverview()+"' ,materials='"+kid.getMaterials()+"',stok='"+kid.getStok()+"',harga='"+kid.getHarga()+"',jeniskid='"+kid.getJeniskid()+"'where kode='" +id+"'"; 
                    System.out.println("Edit Man"); try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql); 
                     System.out.println("Edit"+result+"Kid\n"+id); 
                    statement.close(); 
                     } 
                    catch(Exception Ex){ 
                     System.out.println("Error edit a Kid...\n"); 
                    System.out.println(Ex); 
                    } 
                    }
                    public void deleteShopkeeper(String id){ 
                     String sql="DELETE FROM Shopkeeper WHERE idNumber = '" 
                    +id+"'"; System.out.println("Delete Shopkeeper "); 
                    try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql);
                    } 
            catch(Exception Ex){ 
             System.out.println("Error edit a Shopkeeper...\n"); 
             System.out.println(Ex); 
            }} public void deleteAdmin(String id){ 
                     String sql="DELETE FROM Admin WHERE idNumber = '" 
                    +id+"'"; System.out.println("Delete Admin "); 
                    try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql);
                    } 
            catch(Exception Ex){ 
             System.out.println("Error edit a Admin...\n"); 
             System.out.println(Ex); 
            }}
                    public void deleteMan(int id){ 
                     String sql="DELETE FROM Man WHERE kode = '" 
                    +id+"'"; System.out.println("Delete Man "); 
                    try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql);
                    } 
            catch(Exception Ex){ 
             System.out.println("Error edit a Man...\n"); 
             System.out.println(Ex); 
            }}  public void deleteWoman(int id){ 
                     String sql="DELETE FROM Woman WHERE kode = '" 
                    +id+"'"; System.out.println("Delete Woman "); 
                    try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql);
                    } 
            catch(Exception Ex){ 
             System.out.println("Error edit a Woman...\n"); 
             System.out.println(Ex); 
            }}
            public void deleteKid(int id){ 
                     String sql="DELETE FROM Kid WHERE kode = '" 
                    +id+"'"; System.out.println("Delete Kid "); 
                    try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql);
                    } 
            catch(Exception Ex){ 
             System.out.println("Error delete a Kid...\n"); 
             System.out.println(Ex); 
            }}
            public String 
                        showAllShopkeeper(){ String 
                        Hasil = ""; 
                         String sql="SELECT idshopkp,  nama,  idNumber,tanggalmasuk FROM Shopkeeper"; 
                         System.out.println("Daftar Shopkeeper...");
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
                 Shopkeeper D;
                    D = new
                        Shopkeeper(rs.getInt("idshopkp"), rs.getString("nama"), 
                    rs.getString("idNumber"), rs.getString("tanggalmasuk")); 
                 Hasil += 
                D.Tampil(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return Hasil; 

                } public Report 
                        showAllKeranjang(){ 
                            
                            int counter=0;
                            Report R = new Report();
                        Pembelian P = new Pembelian();
                         String sql="SELECT * FROM transaksi"; 
                         System.out.println("Daftar Pembelian...");
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
                 
                    P = new
                        Pembelian( rs.getString("tgl_transaksi"),rs.getInt("id_transaksi"),  rs.getInt("kode_barang"),
                      rs.getString("nama_barang"), rs.getInt("idshopkp"),rs.getString("koleksi"),
//                   
                    rs.getFloat("harga"),
//                  
//                   
//                    
//                    
//                    rs.getString("idshopkp"),
                   rs.getInt("jumlah_barang"),
                    rs.getFloat("total_harga"));
//                 Hasil += 
//                D.Tampil(); 
R = new Report(cektransaksi());
R.setJumlahtransaksi(counter);
                    R.insertRow(P,counter);
                 counter++;   
                    System.out.println(counter+"COUNTER");
                } } 
                rs.close(); 
                statement.close(); 
 System.out.println(R.getPembelian()[1].getKode_barang());
                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                        
               
return R;
                } public String 
                        showAllMan(){ String 
                        Hasil = ""; 
                         String sql="SELECT * FROM Man"; 
                         System.out.println("Daftar Man...");
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
                 Man D;
                    D = new
                        Man(rs.getString("jenisman"), rs.getString("warna"), rs.getString("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"), rs.getInt("stok"), rs.getFloat("harga"),rs.getString("tanggal"));
       
                 Hasil += 
                D.Tampils(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return Hasil; 

                }public String 
                        showAllWoman(){ String 
                        Hasil = ""; 
                         String sql="SELECT warna,  ukuran,  kode,overview,materials,stok,jeniswoman FROM Woman"; 
                         System.out.println("Daftar Woman...");
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
                 Woman D;
                    D = new
                        Woman(rs.getString("jeniswoman"), rs.getString("warna"), rs.getString("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"), rs.getInt("stok"), rs.getFloat("harga"),rs.getString("tanggal"));
       
                 Hasil += 
                D.Tampils(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return Hasil; 

                }
                        public String 
                        showAllKid(){ String 
                        Hasil = ""; 
                         String sql="SELECT * FROM Kid"; 
                         System.out.println("Daftar Man...");
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
                 Kid D;
                    D = new
                        Kid(rs.getString("jenisman"), rs.getString("warna"), rs.getString("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"), rs.getInt("stok"), rs.getFloat("harga"), rs.getString("tanggal"));
       
                 Hasil += 
                D.Tampils(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return Hasil; 

                }
                  public Man 
                        showAllMans(){ 
                        Man D = new Man();
                         String sql="SELECT * FROM Man"; 
                         System.out.println("Daftar Man...");
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
               
                    D = new
                        Man(rs.getString("jenisman"), rs.getString("warna"), rs.getString("ukuran"),rs.getInt("kode"), rs.getString("overview"), rs.getString("materials"), rs.getInt("stok"), rs.getFloat("harga"), rs.getString("tanggal"));
       
//                 Hasil += 
//                D.Tampils(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return D; 

                }  public Owner 
                        showAllowner(){ 
                        Owner D = new Owner();
                         String sql="SELECT * FROM Owner"; 
                         System.out.println("Daftar Man...");
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
               
                    D = new
                        Owner(rs.getString("nama"), rs.getString("jeniskelamin"),
                    rs.getInt("umur")); 
//                 Hasil += 
//                D.Tampils(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return D; 

                } 
                        public Cabang_Uniq
                        showAllCabang(){ 
                            Cabang_Uniq C = new Cabang_Uniq();
//                        Shopkeeper D = new Shopkeeper();
//                        Admin A = new Admin();
//                        Owner O = new Owner();
//                        String sqls="SELECT * FROM Owner";
                         String sql="SELECT COUNT(*) FROM Shopkeeper";
//                          String sql1="SELECT COUNT(*) FROM Admin";
                         System.out.println("Daftar Man...");
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
                        
                        
//                        ResultSet rss=statement.executeQuery(sql1); ResultSet rss1=statement.executeQuery(sqls);
                
                      
                if(rs!=null){ 
                while(rs.next()){ 
                    int jumlah = jumlahadmin()+rs.getInt(1);
                  C = new Cabang_Uniq("Uniq","Jalan Ahmad Yani Timur SOU, Silicon Valey", showAllowner(),jumlah);
                    
               
//                      Hasil += 
//                D.Tampils(); 
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                return C; 

                } 
                         public int jumlahadmin()
                {
                    int ha=0;
                     String total = "SELECT COUNT(*) FROM Admin;";
        
        try{
//            Connection connect = con.getKoneksi();//memanggil koneksi
            Statement sttmnt = con.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(total);//menjalanakn query\
                while(rslt.next()){
                  ha=   rslt.getInt(1);
                    System.out.println(ha);
                    
                    
                }
                
        }catch(Exception e){
            System.out.println(e);
            
        }return ha;
                }
       public void 
                        stokwoman(pengaturan_stok P ,int kode,int jumlah,int stok){
                 
                   
                        String sql="UPDATE Woman SET stok='"+P.stoksekarang()+"' where kode='" +kode+"'"; 
                    System.out.println("Edit WoMan"); try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql); 
                     System.out.println("Edit"+result+"WoMan\n"+kode); 
                    statement.close(); 
                     } 
                    catch(Exception Ex){ 
                     System.out.println("Error edit a WoMan...\n"); 
                    System.out.println(Ex); 
                }}public void 
                        stokman(pengaturan_stok P ,int kode,int jumlah,int stok){
                 
                   
                        String sql="UPDATE Man SET stok='"+P.stoksekarang()+"' where kode='" +kode+"'"; 
                    System.out.println("Edit WoMan"); try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql); 
                     System.out.println("Edit"+result+"Man\n"+kode); 
                    statement.close(); 
                     } 
                    catch(Exception Ex){ 
                     System.out.println("Error edit a Man...\n"); 
                    System.out.println(Ex); 
                }}public void 
                        stokkid(pengaturan_stok P ,int kode,int jumlah,int stok){
                 
                   
                        String sql="UPDATE Kid SET stok='"+P.stoksekarang()+"' where kode='" +kode+"'"; 
                    System.out.println("Edit Kid"); try{ 
                     Statement 
                    statement=con.createStatement(); int 
                    result=statement.executeUpdate(sql); 
                     System.out.println("Edit"+result+"Kid\n"+kode); 
                    statement.close(); 
                     } 
                    catch(Exception Ex){ 
                     System.out.println("Error edit a Kid...\n"); 
                    System.out.println(Ex); 
                }}public void keranjang()
                {
                     String total = "SELECT SUM(total_harga) FROM tb_keranjang;";
        
        try{
//            Connection connect = con.getKoneksi();//memanggil koneksi
            Statement sttmnt = con.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(total);//menjalanakn query\
                while(rslt.next()){
                 double ha=   rslt.getDouble(1);
                    System.out.println(ha);
                    
                    txt_totalharga2.setText(String.valueOf(rslt.getFloat(1)));
                }
                
        }catch(Exception e){
            System.out.println(e);
        }
                }
                
     public double totaltransaksi()
                {
                    double ha=0;
                     String total = "SELECT SUM(total_harga) FROM transaksi;";
        
        try{
//            Connection connect = con.getKoneksi();//memanggil koneksi
            Statement sttmnt = con.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(total);//menjalanakn query\
                while(rslt.next()){
                  ha=   rslt.getDouble(1);
                    System.out.println(ha);
                    
                    
                }
                
        }catch(Exception e){
            System.out.println(e);
            
        }return ha;
                }     public void 
                        hapus(){
                 
                      String clear = "DELETE FROM tb_keranjang";

        try{
             Statement 
              statement=con.createStatement();
                
                       
              statement.execute(clear);
//           
            
            
        }catch(Exception e){
            System.out.println(e);
        }}  
                         public int cektransaksi()
                {
                    int ha=0;
                     String total = "SELECT COUNT(*) FROM transaksi;";
        
        try{
//            Connection connect = con.getKoneksi();//memanggil koneksi
            Statement sttmnt = con.createStatement();//membuat statement
            ResultSet rslt = sttmnt.executeQuery(total);//menjalanakn query\
                while(rslt.next()){
                  ha=   rslt.getInt(1);
                    System.out.println(ha);
                    
                    
                }
                
        }catch(Exception e){
            System.out.println(e);
            
        }return ha;
                }
                           public Report
                        showtra(){ 
                            int i=0;
                            Report R = new Report();
                        Pembelian[] D = new Pembelian[cektransaksi()];
                         String sql="SELECT * FROM transaksi"; 
                         System.out.println("Daftar Man...");
                         try{ 
                         Statement 
                        statement=con.createStatement(); 
                        ResultSet rs=statement.executeQuery(sql);
               
                      
                if(rs!=null){ 
                while(rs.next()){ 
               
                    D[i] = new
                       Pembelian( rs.getString("tgl_transaksi"),rs.getInt("id_transaksi"),  rs.getInt("kode_barang"),
                      rs.getString("nama_barang"), rs.getInt("idshopkp"),rs.getString("koleksi"),
//                   
                    rs.getFloat("harga"),
//                  
//                   
//                    
//                    
//                    rs.getString("idshopkp"),
                   rs.getInt("jumlah_barang"),
                    rs.getFloat("total_harga"));
//                 Hasil += 
//                D.Tampils(); 
//R.insertRow(D[i], i);
R = new Report(cektransaksi());
R.setPembelian(D[i]);
i++;
                } } 
                rs.close(); 
                statement.close(); 

                } 
                catch(Exception Ex){ 
                 System.out.println("Error reading database information...\n"); 
                 System.out.println(Ex); 
                } 
                               System.out.println(D[i]);
                return R; 

                } 
                         public void 
                        pindah(){
                 
                      String clear = "INSERT INTO transaksi SELECT * FROM tb_keranjang";

        try{
             Statement 
              statement=con.createStatement();
                
                       
              statement.execute(clear);
//           
            
            
        }catch(Exception e){
            System.out.println(e);
        }} 
}
