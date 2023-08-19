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
public class Pembelian implements Transaksi{
     private int idshopkp;
     private String tgl_transaksi;
     private String nama_barang;
     private int kode_barang;
    private int jumlah;
    private float harga;
    private float totalharga;
    private int idtransaksi;
    private Man man;
    private Woman woman;
    private Kid kid;
    private Shopkeeper shopkeeper;
    private String koleksi;
    
    
    public Pembelian(){}

    public Pembelian( String tgl_transaksi, int idtransaksi, int kode_barang,String nama_barang, int idshopkp, String koleksi, float harga,int jumlah, float totalharga) {
        this.idshopkp = idshopkp;
        this.tgl_transaksi = tgl_transaksi;
        this.nama_barang = nama_barang;
        this.kode_barang = kode_barang;
        this.jumlah = jumlah;
        this.harga = harga;
        this.totalharga = totalharga;
        this.idtransaksi = idtransaksi;
        this.man = man;
        this.woman = woman;
        this.kid = kid;
        this.shopkeeper = shopkeeper;
        this.koleksi = koleksi;
    }

    

    
  
  
    public int User(){
        return getShopkeeper().getIdshopkp();
    }
     public int kode(){
         int kode=0;
         if(getKoleksi().equalsIgnoreCase(getMan().getJenisman())){
           kode=getMan().getKode();
        }if(getKoleksi().equalsIgnoreCase(getWoman().getJeniswo())){
           kode=getWoman().getKode();
        }if(getKoleksi().equalsIgnoreCase(getKid().getJeniskid())){
           kode=getKid().getKode();
        }
        return kode;
    }
    public double harga(){
        
        double harga=0;
        if(getKoleksi().equalsIgnoreCase(getMan().getJenisman())){
           harga=getMan().getHarga();
        }if(getKoleksi().equalsIgnoreCase(getWoman().getJeniswo())){
           harga=getWoman().getHarga();
        }if(getKoleksi().equalsIgnoreCase(getKid().getJeniskid())){
           harga=getKid().getHarga();
        }
        return harga;
    }
      public double total_harga(){
        
        return getJumlah()*harga();
    }
      
    public void beli(){
      
        System.out.println("Jumlah  : "+getJumlah());
//        System.out.println("Harga   : "+harga());
//         System.out.println("total Harga   : "+total_harga());
    }

    /**
     * @return the idshopkp
     */
    public int getIdshopkp() {
        return idshopkp;
    }

    /**
     * @param idshopkp the idshopkp to set
     */
    public void setIdshopkp(int idshopkp) {
        this.idshopkp = idshopkp;
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
     * @return the totalharga
     */
    public float getTotalharga() {
        return totalharga;
    }

    /**
     * @param totalharga the totalharga to set
     */
    public void setTotalharga(float totalharga) {
        this.totalharga = totalharga;
    }

    /**
     * @return the idtransaksi
     */
    public int getIdtransaksi() {
        return idtransaksi;
    }

    /**
     * @param idtransaksi the idtransaksi to set
     */
    public void setIdtransaksi(int idtransaksi) {
        this.idtransaksi = idtransaksi;
    }

    /**
     * @return the man
     */
    public Man getMan() {
        return man;
    }

    /**
     * @param man the man to set
     */
    public void setMan(Man man) {
        this.man = man;
    }

    /**
     * @return the woman
     */
    public Woman getWoman() {
        return woman;
    }

    /**
     * @param woman the woman to set
     */
    public void setWoman(Woman woman) {
        this.woman = woman;
    }

    /**
     * @return the kid
     */
    public Kid getKid() {
        return kid;
    }

    /**
     * @param kid the kid to set
     */
    public void setKid(Kid kid) {
        this.kid = kid;
    }

    /**
     * @return the shopkeeper
     */
    public Shopkeeper getShopkeeper() {
        return shopkeeper;
    }

    /**
     * @param shopkeeper the shopkeeper to set
     */
    public void setShopkeeper(Shopkeeper shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    /**
     * @return the koleksi
     */
    public String getKoleksi() {
        return koleksi;
    }

    /**
     * @param koleksi the koleksi to set
     */
    public void setKoleksi(String koleksi) {
        this.koleksi = koleksi;
    }


    
}
