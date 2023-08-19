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
public class Man extends Collections{
    private String jenisman;
    
    public Man() {
    }

    public Man(String jenisman, String warna, String ukuran, int kode, String overview, String materials, int stok, float harga, String tanggal) {
        super(warna, ukuran, kode, overview, materials, stok, harga, tanggal);
        this.jenisman = jenisman;
    }

   


    

  

    /**
     * @return the jenisman
     */
    public String getJenisman() {
        return jenisman;
    }

    /**
     * @param jenisman the jenisman to set
     */
    public void setJenisman(String jenisman) {
        this.jenisman = jenisman;
    }

    /**
     *
     * @return
     */
    
    
   
    public String Tampils(){
        super.Tampil();
        return "\n"+
                "Jenis Koleksi Man         : "+getJenisman()+"\n"
               +
                "================================";
        
    }
    
}
