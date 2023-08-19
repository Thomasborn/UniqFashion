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
public abstract class User {
     private String nama; 
    private String idNumber;
    private String tanggalmasuk;

    public User() {
    }

    public User(String nama, String idNumber, String tanggalmasuk) {
        this.nama = nama;
        this.idNumber = idNumber;
        this.tanggalmasuk = tanggalmasuk;
    }
    public User(String idNumber){
            this.idNumber = idNumber;
    
    }

  
    public String Tampil(){
     return "Id Pekerja              : "+getIdNumber()+"\n"
              +"Nama            : "+getNama()+"\n"
            
              ;}

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
     * @return the idNumber
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * @param idNumber the idNumber to set
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    /**
     * @return the tanggalmasuk
     */
    public String getTanggalmasuk() {
        return tanggalmasuk;
    }

    /**
     * @param tanggalmasuk the tanggalmasuk to set
     */
    public void setTanggalmasuk(String tanggalmasuk) {
        this.tanggalmasuk = tanggalmasuk;
    }
}
