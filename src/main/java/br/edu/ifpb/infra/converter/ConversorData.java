/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.infra.converter;

import java.time.LocalDate;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ConversorData implements Converter{
    
    public Object getAsObject(FacesContext fc, UIComponent ui, String obj) {
         if(obj == null) {
             return null;
         }
            LocalDate data = LocalDate.of(
                Integer.parseInt(obj.substring(0, 4)),
                Integer.parseInt(obj.substring(5, 7)),
                Integer.parseInt(obj.substring(8, 10))
        );
        return data;
    }

    public String getAsString(FacesContext fc, UIComponent uic, Object obj) {
        if (obj == null) {
            return null;
        }
        LocalDate date = (LocalDate) obj;
        return date.getYear() + "/" + date.getMonthValue() + "/" + date.getDayOfMonth();
        
    }
    
}
