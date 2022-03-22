/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.infra.converter;

import java.time.LocalDate;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import javax.faces.convert.Converter;

@FacesConverter(value = "conversor.data", forClass=LocalDate.class)
public class ConversorDataNascimento implements Converter{
    
    @Override
    public String getAsString(FacesContext fc, UIComponent ui, Object object) {
       if (object == null) {
           return null;
       }
       LocalDate dataDeAniversario = (LocalDate) object;
       return dataDeAniversario.getYear() + "/" + dataDeAniversario.getMonthValue()+ "/" + dataDeAniversario.getDayOfMonth();
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent ui, String string) {
        if(string == null) {
            return null;
        }
        LocalDate dataDeNascimento = LocalDate.of(
                Integer.parseInt(string.substring(0, 4)), 
                Integer.parseInt(string.substring(5, 7)),
                Integer.parseInt(string.substring(8, 10)) 
        );
        return dataDeNascimento;
    }

}
