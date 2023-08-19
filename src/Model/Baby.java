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
public class Baby extends Collections{
     private String jenisbaby;

    public Baby() {
    }

    public Baby(String jenisbaby, String warna, String ukuran, int kode, String overview, String materials, int stok, float harga, String tanggal) {
        super(warna, ukuran, kode, overview, materials, stok, harga, tanggal);
        this.jenisbaby = jenisbaby;
    }

  
   

   
    public String Tampils(){
        super.Tampil();
        return "\n"+
                "Jenis Koleksi Bayi         : "+getJenisbaby()+"\n"
               +
                "================================";
        
    }
//    @Override
//    public void Tampil(){
//        super.Tampil();
//        System.out.println("Jenis koleksi Baby    : "+getJenisbaby());
//        
//    }

    /**
     * @return the jenisbaby
     */
    public String getJenisbaby() {
        return jenisbaby;
    }

    /**
     * @param jenisbaby the jenisbaby to set
     */
    public void setJenisbaby(String jenisbaby) {
        this.jenisbaby = jenisbaby;
    }
     
}
