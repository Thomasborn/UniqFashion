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
public class Row {
    private int id_transaksi;
    private int kode_barang;
    private String nama_barang;
    private float harga;
    private int jumlah;
    private float total_harga;
    private String tgl_transaksi;

    public Row() {
    }

    public Row(int id_transaksi, int kode_barang, String nama_barang, float harga, int jumlah, float total_harga, String tgl_transaksi) {
        this.id_transaksi = id_transaksi;
        this.kode_barang = kode_barang;
        this.nama_barang = nama_barang;
        this.harga = harga;
        this.jumlah = jumlah;
        this.total_harga = total_harga;
        this.tgl_transaksi = tgl_transaksi;
    }

    /**
     * @return the id_transaksi
     */
    public int getId_transaksi() {
        return id_transaksi;
    }

    /**
     * @param id_transaksi the id_transaksi to set
     */
    public void setId_transaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    /**
     * @return the kode_barang
     */
    public int getKode_barang() {
        return kode_barang;
    }

    /**
     * @param kode_barang the kode_barang to set
     */
    public void setKode_barang(int kode_barang) {
        this.kode_barang = kode_barang;
    }

    /**
     * @return the nama_barang
     */
    public String getNama_barang() {
        return nama_barang;
    }

    /**
     * @param nama_barang the nama_barang to set
     */
    public void setNama_barang(String nama_barang) {
        this.nama_barang = nama_barang;
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
     * @return the total_harga
     */
    public float getTotal_harga() {
        return total_harga;
    }

    /**
     * @param total_harga the total_harga to set
     */
    public void setTotal_harga(float total_harga) {
        this.total_harga = total_harga;
    }

    /**
     * @return the tgl_transaksi
     */
    public String getTgl_transaksi() {
        return tgl_transaksi;
    }

    /**
     * @param tgl_transaksi the tgl_transaksi to set
     */
    public void setTgl_transaksi(String tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }
    
}
