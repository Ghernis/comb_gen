/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scrapeopo;

import IO.conectarAccess;
import estruct.cmb_transp;
import estruct.grupo;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 *
 * @author hgomez
 */
public class ScrapeoPO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        conectarAccess cA = new conectarAccess();
//        HashMap<String,HashMap<Date,List<cmb_transp>>> data = cA.getData();
        HashMap data = cA.getData();
//        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse("21/08/2019");  
//        System.out.println(date1.getTime());
//        
//        //---------------------tostring
//        
//        List lista = data.get("NPUETV06").get(date1);
//        Iterator it = lista.iterator();
//        while(it.hasNext()){
//            cmb_transp cmb = (cmb_transp)it.next();
//            System.out.println(cmb.getNemo()+"\t"+cmb.getSubComb()+"\t"+cmb.getPrecio()+"\t"+cmb.getUnidad());
//            for (int i = 0; i < 24; i++) {
//                System.out.println(cmb.getProp()[i]+"\t"+cmb.getVol()[i]);
//            }
//        }
//        HashMap dats = data.get("CEPUTG12");
//        Iterator it = dats.entrySet().iterator();
//        while(it.hasNext()){
//            Map.Entry pair = (Map.Entry)it.next();
//            Date fecha = (Date)pair.getKey();
//            Calendar fechaTest = Calendar.getInstance();
//            fechaTest.setTime(fecha);
//            System.out.print(fecha+"\t"+fechaTest);
//            List horaria = (List)pair.getValue();
////            System.out.println("\t"+horaria.toString());
//            Iterator it2 = horaria.iterator();
//            while(it2.hasNext()){
//                cmb_transp aux =(cmb_transp)it2.next();
//                System.out.print("\t"+aux.toString());
//            }
//            System.out.println("");
//        }
        //
    }
    
}
