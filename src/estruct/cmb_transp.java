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
public class cmb_transp {
    private String nemo,subComb,unidad;
    private double[] vol,prop;
    private double precio;

    public void setNemo(String nemo) {
        this.nemo = nemo;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setSubComb(String subComb) {
        this.subComb = subComb;
    }

    public void setVol(double[] vol) {
        this.vol = vol;
    }

    @Override
    public String toString() {
        return "cmb_transp{" + "nemo=" + nemo + ", subComb=" + subComb + ", vol=" + vol + ", prop=" + prop + ", precio=" + precio + '}';
    }

    public void setProp(double[] prop) {
        this.prop = prop;
    }

   

    public String getNemo() {
        return nemo;
    }

    public String getSubComb() {
        return subComb;
    }

    public double[] getVol() {
        return vol;
    }

    public double[] getProp() {
        return prop;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

   
    
}
