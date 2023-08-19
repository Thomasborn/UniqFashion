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
public class Collections {
    private String warna;
    private String ukuran;
    private int kode;
    private String overview;
    private String materials;
    private int stok;
    private float harga;
    private String tanggal;
    public Collections() {
    }

    public Collections(String warna, String ukuran, int kode, String overview, String materials, int stok, float harga, String tanggal) {
        this.warna = warna;
        this.ukuran = ukuran;
        this.kode = kode;
        this.overview = overview;
        this.materials = materials;
        this.stok = stok;
        this.harga = harga;
        this.tanggal = tanggal;
    }

    

   
public void Tampil(){
        System.out.println("Kode pakaian    : "+getKode());
        System.out.println("Warna pakaian   : "+getWarna());
        System.out.println("Kode pakaian    : "+getOverview());
        System.out.println("Warna pakaian   : "+getMaterials()); 
        System.out.println("Stok pakaian   : "+getStok()); System.out.println("Harga pakaian   : "+getHarga());
        
        System.out.println("Stok pakaian   : "+getHarga());
    }

    /**
     * @return the warna
     */
    public String getWarna() {
        return warna;
    }

    /**
     * @param warna the warna to set
     */
    public void setWarna(String warna) {
        this.warna = warna;
    }

    /**
     * @return the ukuran
     */
    public String getUkuran() {
        return ukuran;
    }

    /**
     * @param ukuran the ukuran to set
     */
    public void setUkuran(String ukuran) {
        this.ukuran = ukuran;
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
     * @return the overview
     */
    public String getOverview() {
        return overview;
    }

    /**
     * @param overview the overview to set
     */
    public void setOverview(String overview) {
        this.overview = overview;
    }

    /**
     * @return the materials
     */
    public String getMaterials() {
        return materials;
    }

    /**
     * @param materials the materials to set
     */
    public void setMaterials(String materials) {
        this.materials = materials;
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

    /**
     * @return the harga
     */
    public float getHarga() {
        return harga;
    }

    /**
     * @param harga the harga to set
     */
    public void setHarga(float harga) {
        this.harga = harga;
    }

    /**
     * @return the tanggal
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

   
}
