/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruct;

/**
 *
 * @author hgomez
 */
public class combustible {
    private String nemo,subComb;
    private double vol,prop,precio;

    public String getSubComb() {
        return subComb;
    }

    public void setSubComb(String subComb) {
        this.subComb = subComb;
    }
    
    

    public void setNemo(String nemo) {
        this.nemo = nemo;
    }

    public void setVol(double vol) {
        this.vol = vol;
    }

    public void setProp(double prop) {
        this.prop = prop;
    }

    public String getNemo() {
        return nemo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getVol() {
        return vol;
    }

    public double getProp() {
        return prop;
    }
    
    
}
