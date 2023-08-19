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
public class Owner extends User{
    private String nama;
    private String jeniskelamin;
    private int umur;

    public Owner() {
    }

    public Owner(String nama, String jeniskelamin, int umur) {
        this.nama = nama;
        this.jeniskelamin = jeniskelamin;
        this.umur = umur;
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
     * @return the jeniskelamin
     */
    public String getJeniskelamin() {
        return jeniskelamin;
    }

    /**
     * @param jeniskelamin the jeniskelamin to set
     */
    public void setJeniskelamin(String jeniskelamin) {
        this.jeniskelamin = jeniskelamin;
    }

    /**
     * @return the umur
     */
    public int getUmur() {
        return umur;
    }

    /**
     * @param umur the umur to set
     */
    public void setUmur(int umur) {
        this.umur = umur;
    }
    
}
