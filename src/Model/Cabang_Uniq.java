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
public class Cabang_Uniq {
    private String nama;
    private String alamat;
    private Owner owner;
    private Admin admin[];
    private Shopkeeper shopkeeper[];
    private int jumlahpegawai;
    private int counter;

    public Cabang_Uniq() {
    }

    public Cabang_Uniq(String nama, String alamat, Owner owner, int jumlahpegawai) {
        this.nama = nama;
        this.alamat = alamat;
        this.owner = owner;
        this.admin = new Admin[counter];
        this.counter= counter;
        this.shopkeeper = new Shopkeeper[counter];
        this.jumlahpegawai = jumlahpegawai;
    }

    /**
     * @return the nama
     */
    public String getNama() {
        return nama;
    }

    /**
     * @param nama the nama to set
     */
    public void setNama(String nama) {
        this.nama = nama;
    }

    /**
     * @return the alamat
     */
    public String getAlamat() {
        return alamat;
    }

    /**
     * @param alamat the alamat to set
     */
    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    /**
     * @return the owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    /**
     * @return the admin
     */
    public Admin[] getAdmin() {
        return admin;
    }

    /**
     * @param admin the admin to set
     */
    public void setAdmin(Admin[] admin) {
        this.admin = admin;
    }

    /**
     * @return the shopkeeper
     */
    public Shopkeeper[] getShopkeeper() {
        return shopkeeper;
    }

    /**
     * @param shopkeeper the shopkeeper to set
     */
    public void setShopkeeper(Shopkeeper[] shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    /**
     * @return the jumlahpegawai
     */
    public int getJumlahpegawai() {
        return jumlahpegawai;
    }

    /**
     * @param jumlahpegawai the jumlahpegawai to set
     */
    public void setJumlahpegawai(int jumlahpegawai) {
        this.jumlahpegawai = jumlahpegawai;
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
     public void InsertShopkepeer(Shopkeeper shopkeeper){
        getShopkeeper()[counter]= shopkeeper;
        counter++;
    }
     public int Jumlah_pegawai(){
        int jumlah=0,j;
        counter = jumlah;
        return jumlah;
    }
}
