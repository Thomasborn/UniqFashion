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
public class pengaturan_stok {
    private int kode;
    private int jumlah;
    private int stok;

    public pengaturan_stok() {
    }

    public pengaturan_stok(int kode, int jumlah, int stok) {
        this.kode = kode;
        this.jumlah = jumlah;
        this.stok = stok;
    }

    /**
     * @return the kode
     */
    public int getKode() {
        return kode;
    }

    /**
     * @param kode the kode to set
     */
    public void setKode(int kode) {
        this.kode = kode;
    }

    /**
     * @return the jumlah
     */
    public int getJumlah() {
        return jumlah;
    }

    /**
     * @param jumlah the jumlah to set
     */
    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    /**
     * @return the stok
     */
    public int getStok() {
        return stok;
    }

    /**
     * @param stok the stok to set
     */
    public void setStok(int stok) {
        this.stok = stok;
    }

   public double stoksekarang(){
       return stok-jumlah;
   }
}
