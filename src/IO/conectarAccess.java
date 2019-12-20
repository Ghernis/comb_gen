/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IO;

import estruct.cmb_transp;
import estruct.grupo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author hgomez
 */
public class conectarAccess {

    HashMap<String, HashMap<Date, List<cmb_transp>>> data_comb = new HashMap<>();

    public HashMap getData() {

        // variables
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        ResultSet resultSet2 = null;

        // Step 1: Loading or 
        // registering Oracle JDBC driver class
        try {

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        } catch (ClassNotFoundException cnfex) {

            System.out.println("Problem in loading or "
                    + "registering MS Access JDBC driver");
            cnfex.printStackTrace();
        }
        // Step 2: Opening database connection
        try {
            //hubicacion archivos
            String msAccDB = "D:\\Users\\hgomez.OLIMPUS\\Documents\\SSEE\\BD Electrica\\post Operatorio\\2019\\Originales\\PO190801.MDB";
            String dbURL = "jdbc:ucanaccess://"
                    + msAccDB;

            // Step 2.A: Create and 
            // get connection using DriverManager class
            connection = DriverManager.getConnection(dbURL);

            // Step 2.B: Creating JDBC Statement 
            statement = connection.createStatement();

            // Step 2.C: Executing SQL and 
            // retrieve data into ResultSet
            String query = "SELECT * FROM VALORES_GENERADORES";
            String queryComb = "SELECT * FROM COMB_QUEMADOS_SCOM";

            //query toda la tabla de combustible
            resultSet = statement.executeQuery(queryComb);

            while (resultSet.next()) {
                String nemo = resultSet.getString("GRUPO");
                String unidad = resultSet.getString("UNIDAD");
                String sub_cmb = resultSet.getString("SUB_CMB");
                String cmb = resultSet.getString("CMB");
                Date fecha = resultSet.getDate("FECHA");
                double precio = resultSet.getDouble("PRECIO");

                if (data_comb.containsKey(nemo)) {
                    if (data_comb.get(nemo).containsKey(fecha)) {
                        List aux = data_comb.get(nemo).get(fecha);
                        Iterator it = aux.iterator();
                        int sent = 0;
                        int sent2 = 0;//no existe en el while
                        while (it.hasNext() && sent == 0) {
                            cmb_transp obj_cmb = (cmb_transp) it.next();

                            if (obj_cmb.getSubComb().equals(sub_cmb)) {
                                sent2 = 1;
                                /*
                                si ya existe el nemo, y ya existe la entrada de ese dia y el
                                subcombustible es el de la entrada cargada, hay dos opciones
                                que sea la proporcion o el vol de combustible
                                Despues de completarlo lo reemplaza en la BD
                                 */
                                //----------------
                                if (unidad.equals("%")) {
                                    double[] comp = new double[24];//comp = composicion
                                    for (int i = 1; i < 25; i++) {
                                        comp[i - 1] = resultSet.getDouble("H" + i);
                                    }
                                    obj_cmb.setProp(comp);
                                } else {
                                    obj_cmb.setUnidad(unidad);
                                    double[] vol = new double[24];
                                    for (int i = 1; i < 25; i++) {
                                        vol[i - 1] = resultSet.getDouble("H" + i);
                                    }
                                    obj_cmb.setVol(vol);
                                }
                                //-----------

                                data_comb.get(nemo).replace(fecha, aux);
                                sent = 1;
                            } else {
                            }
                        }
                        if (sent2 == 0) {
                            cmb_transp obj_cmb_nuevo = new cmb_transp();
                            obj_cmb_nuevo.setNemo(cmb);//nemo de combustible
                            obj_cmb_nuevo.setSubComb(sub_cmb);
                            obj_cmb_nuevo.setPrecio(precio);

                            //----------------
                            if (unidad.equals("%")) {
                                double[] comp = new double[24];//comp = composicion %
                                for (int i = 1; i < 25; i++) {
                                    comp[i - 1] = resultSet.getDouble("H" + i);
                                }
                                obj_cmb_nuevo.setProp(comp);
                            } else {
                                obj_cmb_nuevo.setUnidad(unidad);

                                double[] vol = new double[24];
                                for (int i = 1; i < 25; i++) {
                                    vol[i - 1] = resultSet.getDouble("H" + i);
                                }
                                obj_cmb_nuevo.setVol(vol);
                            }
                            //-----------
                            data_comb.get(nemo).get(fecha).add(obj_cmb_nuevo);
                            sent = 1;
                        }

                    } else {
                        cmb_transp obj_cmb = new cmb_transp();
                        obj_cmb.setNemo(cmb);//nemo de combustible
                        obj_cmb.setSubComb(sub_cmb);
                        obj_cmb.setPrecio(precio);
                        //----------------
                        if (unidad.equals("%")) {
                            double[] comp = new double[24];//comp = composicion %
                            for (int i = 1; i < 25; i++) {
                                comp[i - 1] = resultSet.getDouble("H" + i);
                            }
                            obj_cmb.setProp(comp);
                        } else {
                            obj_cmb.setUnidad(unidad);
                            double[] vol = new double[24];
                            for (int i = 1; i < 25; i++) {
                                vol[i - 1] = resultSet.getDouble("H" + i);
                            }
                            obj_cmb.setVol(vol);
                        }
                        //-----------
                        List entrada_nueva = new ArrayList();
                        entrada_nueva.add(obj_cmb);
                        data_comb.get(nemo).put(fecha, entrada_nueva);

                    }
                } else {
                    cmb_transp obj_cmb = new cmb_transp();
                    obj_cmb.setNemo(cmb);//nemo de combustible
                    obj_cmb.setSubComb(sub_cmb);
                    obj_cmb.setPrecio(precio);
                    //----------------
                    if (unidad.equals("%")) {
                        double[] comp = new double[24];//comp = composicion %
                        for (int i = 1; i < 25; i++) {
                            comp[i - 1] = resultSet.getDouble("H" + i);
                        }
                        obj_cmb.setProp(comp);
                    } else {
                        obj_cmb.setUnidad(unidad);
                        double[] vol = new double[24];
                        for (int i = 1; i < 25; i++) {
                            vol[i - 1] = resultSet.getDouble("H" + i);
                        }
                        obj_cmb.setVol(vol);
                    }
                    //-----------
                    List nemo_nuevo = new ArrayList();
                    nemo_nuevo.add(obj_cmb);

                    HashMap<Date, List<cmb_transp>> aux = new HashMap<>();
                    aux.put(fecha, nemo_nuevo);
                    data_comb.put(nemo, aux);

                }

            }
            
            //System.out.println(data_comb.toString());
            HashMap<String, List<grupo>> data = new HashMap<>();

            ///
            resultSet2 = statement.executeQuery(query);

            // processing returned data and printing into console
            //System.out.println("grupo\tfecha\thora\tvolumen\tcombustible\tenergia");
            while (resultSet2.next()) {
                String nemo = resultSet2.getString("GRUPO");
                Date fecha = resultSet2.getDate("VALORES_GENERADORES.FECHA");
                int hora = resultSet2.getInt("VALORES_GENERADORES.HORA");
                double en = resultSet2.getDouble("VALORES_GENERADORES.ENERGIA");
                double en_b = resultSet2.getDouble("VALORES_GENERADORES.ENERG_OPERADA");
                double pot_disp = resultSet2.getDouble("POT_DISP");
                double pot_rec = resultSet2.getDouble("POT_RECONOC");
                double pot_ind = resultSet2.getDouble("PIND");
                double pot_ind_forz = resultSet2.getDouble("PINDFORZ");

                
                
                grupo aux = new grupo(fecha, hora, en, en_b, pot_disp, pot_rec, pot_ind, pot_ind_forz);
                if (data_comb.containsKey(nemo)) {

                    //System.out.println("Existe: " + nemo + "\t" + fecha);
                    if (data_comb.get(nemo).containsKey(fecha)) {

                        List<cmb_transp> aux_cmb = (List) data_comb.get(nemo).get(fecha);
                        Iterator it = aux_cmb.iterator();
                        
                        while(it.hasNext()){
                            cmb_transp obj_cmb = (cmb_transp)it.next();
                            double volu = obj_cmb.getVol()[hora - 1];
                            System.out.println(nemo + "\t" + fecha + "\t" + hora + "\t" +obj_cmb.getSubComb()+"\t"+ volu+"\t"+en);
                        }
                        
                        if (data.containsKey(nemo)) {
                            data.get(nemo).add(aux);
                        } else {
                            List<grupo> listaNueva = new ArrayList();
                            listaNueva.add(aux);
                            data.put(nemo, listaNueva);
                        }
                    } else {
                        System.out.println("No existe la fecha: " + fecha+" en tabla combustible para\t"+nemo);
                    }
                } else {
                    //System.out.println(nemo + "\tNO EXISTE EN CMB ESE GRUPO");
                }
            }
            //resultSet2.close();
            return data_comb;

        } catch (SQLException sqlex) {
            sqlex.printStackTrace();
        } finally {
            // Step 3: Closing database connection
            try {
                if (null != connection) {
                    // cleanup resources, once after processing
                    resultSet.close();
                    resultSet2.close();
                    statement.close();

                    // and then finally close connection
                    connection.close();
                }
            } catch (SQLException sqlex) {
                sqlex.printStackTrace();
            }
        }
        return null;
    }
}
