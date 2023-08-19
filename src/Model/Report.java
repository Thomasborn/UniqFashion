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
public class Report {
    private Pembelian pembelian[];
//    private Pembelian =[];
    private int jumlahtransaksi;
    private int counter;
    public Report() {
    }

 
//
    public Report(Pembelian[] pembelian ,int jumlahtransaksi) {
        this.pembelian = new Pembelian[jumlahtransaksi];
        this.jumlahtransaksi = jumlahtransaksi;
        this.counter = counter;
    }

    public Report(int jumlahtransaksi) {
       this.pembelian = new Pembelian[jumlahtransaksi];
        this.jumlahtransaksi = jumlahtransaksi;
        this.counter = counter;
    }

    

    
     
     public void insertRow(Pembelian pembelian,int counte){
          getPembelian()[counte]= pembelian;
        counter = counte;
        
       
    }public int jumlk(){
        return counter;
    }

    /**
     * @return the pembelian
     */
    public Pembelian[] getPembelian() {
        return pembelian;
    }

    /**
     * @param pembelian the pembelian to set
     */
    public void setPembelian(Pembelian[] pembelian) {
        this.pembelian = pembelian;
    }

    /**
     * @return the jumlahtransaksi
     */
    public int getJumlahtransaksi() {
        return jumlahtransaksi;
    }

    /**
     * @param jumlahtransaksi the jumlahtransaksi to set
     */
    public void setJumlahtransaksi(int jumlahtransaksi) {
        this.jumlahtransaksi = jumlahtransaksi;
    }

    /**
     * @return the counter
     */
    public int getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(int counter) {
        this.counter = counter;
    }

    public void setPembelian(Pembelian P) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
