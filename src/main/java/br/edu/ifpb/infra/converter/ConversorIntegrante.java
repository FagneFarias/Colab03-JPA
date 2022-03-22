/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.infra.converter;

import br.edu.ifpb.domain.Integrante;
import java.time.LocalDate;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

public class ConversorIntegrante implements Converter{
    
    @Override
    public String getAsString(FacesContext fc, UIComponent ui, Object obj) {
        if (obj == null) return null;
        Integrante integrante = new Integrante("", LocalDate.of(1, 1, 1), "");
        return integrante.getCpf();
        
    }
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent ui, String string) {
        if (string == null) return null;
        Integrante integrante = new Integrante("", LocalDate.of(1, 1, 1), "");
        return integrante;
        
    }
    
}
