/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estruct;

import java.util.Date;
import java.util.List;

/**
 *
 * @author hgomez
 */
public class grupo {
    private Date fecha;
    private int hora;
    private double en_n,en_b,pot_disp,pot_rec,pot_ind,pot_ind_forz;
    private List<combustible> comb;

    //a calcular
    private double ce_n,ce_b;
    
    public grupo(Date fecha,int hora,double en_n,double en_b,double pot_disp,double pot_rec,double pot_ind,double pot_ind_forz){
       this.fecha=fecha;
       this.hora = hora;
       this.en_n=en_n;
       this.en_b=en_b;
       this.pot_disp = pot_disp;
       this.pot_rec=pot_rec;
       this.pot_ind=pot_ind;
       this.pot_ind_forz=pot_ind_forz;
       
       //calculos();
    }
    public void calculos(){
//        ce_n = ;
//        ce_b = ;
    }
    public Date getFecha() {
        return fecha;
    }

    public int getHora() {
        return hora;
    }

    public double getEn_n() {
        return en_n;
    }

    public double getEn_b() {
        return en_b;
    }

    public double getPot_disp() {
        return pot_disp;
    }

    public double getPot_rec() {
        return pot_rec;
    }

    public double getPot_ind() {
        return pot_ind;
    }

    public double getPot_ind_forz() {
        return pot_ind_forz;
    }

    public List getCombustible() {
        return comb;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setEn_n(double en_n) {
        this.en_n = en_n;
    }

    public void setEn_b(double en_b) {
        this.en_b = en_b;
    }

    public void setPot_disp(double pot_disp) {
        this.pot_disp = pot_disp;
    }

    public void setPot_rec(double pot_rec) {
        this.pot_rec = pot_rec;
    }

    public void setPot_ind(double pot_ind) {
        this.pot_ind = pot_ind;
    }

    public void setPot_ind_forz(double pot_ind_forz) {
        this.pot_ind_forz = pot_ind_forz;
    }

    public void setCombustible(List combustible) {
        this.comb = combustible;
    }

    @Override
    public String toString() {
        return "grupo{" + "fecha=" + fecha + ", hora=" + hora + ", en_n=" + en_n + ", en_b=" + en_b + ", pot_disp=" + pot_disp + ", pot_rec=" + pot_rec + ", pot_ind=" + pot_ind + ", pot_ind_forz=" + pot_ind_forz + ", ce_n=" + ce_n + ", ce_b=" + ce_b + '}';
    }
    
    
}
