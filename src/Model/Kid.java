/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author TS <TS.com>
 */
public class Kid extends Collections{
     private String jeniskid;

    public Kid() {
    }

    public Kid(String jeniskid, String warna, String ukuran, int kode, String overview, String materials, int stok, float harga, String tanggal) {
        super(warna, ukuran, kode, overview, materials, stok, harga, tanggal);
        this.jeniskid = jeniskid;
    }

   

   
  

    /**
     * @return the jeniskid
     */
    public String getJeniskid() {
        return jeniskid;
    }

    /**
     * @param jeniskid the jeniskid to set
     */
    public void setJeniskid(String jeniskid) {
        this.jeniskid = jeniskid;
    }
    public String Tampils(){
        super.Tampil();
        return "\n"+
                "Jenis Koleksi Anak/Kid         : "+getJeniskid()+"\n"
               +
                "================================";
        
    }
//     @Override
//    public void Tampil(){
//        super.Tampil();
//        System.out.println("Jenis koleksi Anak/ Kid    : "+getJeniskid());
//        
//    }
}
