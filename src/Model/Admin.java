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
public class Admin extends User{
    private String idadmin;

    public Admin() {
    }

    public Admin(String idadmin, String nama, String idNumber, String tanggalmasuk) {
        super(nama, idNumber, tanggalmasuk);
        this.idadmin = idadmin;
    }
    public Admin(String idadmin,String idNumber){
        super(idNumber);
        this.idadmin = idadmin;
    }

    
    
    /**
     * @return the idadmin
     */
    public String getIdadmin() {
        return idadmin;
    }

    /**
     * @param idadmin the idadmin to set
     */
    public void setIdadmin(String idadmin) {
        this.idadmin = idadmin;
    }
     public String Tampil() {
         return super.Tampil() +"\n"+
                "Id Admin         : "+getIdadmin()+"\n"
               +
                "================================";
    }
}
