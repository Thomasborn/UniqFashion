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
public class Woman extends Collections{
     private String jeniswo;

    public Woman() {
    }

    public Woman(String jeniswo, String warna, String ukuran, int kode, String overview, String materials, int stok, float harga, String tanggal) {
        super(warna, ukuran, kode, overview, materials, stok, harga, tanggal);
        this.jeniswo = jeniswo;
    }

    
  
  

    /**
     * @return the jeniswo
     */
    public String getJeniswo() {
        return jeniswo;
    }

    /**
     * @param jeniswo the jeniswo to set
     */
    public void setJeniswo(String jeniswo) {
        this.jeniswo = jeniswo;
    }
    public String Tampils(){
        super.Tampil();
        return "\n"+
                "Jenis Koleksi Woman         : "+getJeniswo()+"\n"
               +
                "================================";
        
    }
     @Override
    public void Tampil(){
        super.Tampil();
        System.out.println("Jenis koleksi Women    : "+getJeniswo());
        
    }
}
