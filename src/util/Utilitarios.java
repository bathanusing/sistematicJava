/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Jsanchez
 */
public class Utilitarios {
     SimpleDateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
     
     public String getFecha(JDateChooser jd){
         if(jd.getDate()!=null){
             return formateador.format(jd.getDate());
         }else{
             return null;
         }
     }
     public java.util.Date StringADate(String fecha){
         SimpleDateFormat formatoTexto = new SimpleDateFormat("dd-MM-yyyy");
         Date fechaE = null;
         try {
             fechaE= formatoTexto.parse(fecha);
             return fechaE;
         } catch (ParseException e) {
             return null;
         }
     }
}
