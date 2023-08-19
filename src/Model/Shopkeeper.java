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
public class Shopkeeper extends User{
    private int idshopkp;

    public Shopkeeper() {
    }

    public Shopkeeper(int idshopkp, String nama, String idNumber, String tanggalmasuk) {
        super(nama, idNumber, tanggalmasuk);
        this.idshopkp = idshopkp;
    }public Shopkeeper(int idshopkp,String idNumber){
        super(idNumber);
        this.idshopkp = idshopkp;
    }

   
    
    @Override
    public String Tampil() {
         return super.Tampil() +"\n"+
                "Id Shopkeeper         : "+getIdshopkp()+"\n"
               +
                "================================";
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
    
}
