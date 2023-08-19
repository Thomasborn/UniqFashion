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
public class Keranjang implements Transaksi{
    private Row row[];
    private int jumlahbarang;
    private float totalkeranjang;
    private String tgl_transaksi;
    public int counter;

    public Keranjang() {
    }

    public Keranjang( int jumlahbarang, String tgl_transaksi) {
        this.row = new Row[jumlahbarang];
        this.jumlahbarang = jumlahbarang;
       
        this.tgl_transaksi = tgl_transaksi;
    }

    /**
     * @return the row
     */
    public Row[] getRow() {
        return row;
    }

    /**
     * @param row the row to set
     */
    public void setRow(Row[] row) {
        this.row = row;
    }

    /**
     * @return the jumlahbarang
     */
    public int getJumlahbarang() {
        return jumlahbarang;
    }

    /**
     * @param jumlahbarang the jumlahbarang to set
     */
    public void setJumlahbarang(int jumlahbarang) {
        this.jumlahbarang = jumlahbarang;
    }

    /**
     * @return the totalkeranjang
     */
    public float getTotalkeranjang() {
        return totalkeranjang;
    }

    /**
     * @param totalkeranjang the totalkeranjang to set
     */
    public void setTotalkeranjang(float totalkeranjang) {
        this.totalkeranjang = totalkeranjang;
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
 public void insertRow(Row row){
        getRow()[jumlahbarang]= row;
        jumlahbarang++;
    }public int jumlk(){
        return jumlahbarang;
    }@Override
    public double total_harga(){
        double jumlah=0,j;
        for(int i =0;i<jumlahbarang;i++){
            
            jumlah += row[i].getTotal_harga();
            
        }
        return jumlah;
    }
}
