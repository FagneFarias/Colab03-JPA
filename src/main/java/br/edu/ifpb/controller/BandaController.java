/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.persistencia.BandaPersistencia;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class BandaController implements Serializable{
    @Inject
    private BandaPersistencia bandas;
    private Banda banda = new Banda();
    private List<Banda> resultBandas = new ArrayList<>();

    public List<Banda> getResultBandas() {
        return resultBandas;
    }

    public void setResultBandas(List<Banda> resultBandas) {
        this.resultBandas = resultBandas;
    }

    public BandaPersistencia getBandas() {
        return bandas;
    }

    public void setBandas(BandaPersistencia bandas) {
        this.bandas = bandas;
    }

    public Banda getBanda() {
        return banda;
    }

    public void setBanda(Banda banda) {
        this.banda = banda;
    }
    
    public String adicionar () {
        if ( this.banda.getId() > 0 ) {
            this.bandas.update(banda);
        } else {
            this.bandas.add(this.banda);
        }
        this.banda = new Banda();
        return "/banda/list?faces-redirect=true";
    }
        
    public String update(Banda banda) {
        this.banda = banda;
        return "/banda/edit?faces-redirect=true";
    }
    
    public String remover (Banda banda) {
        this.bandas.delete(banda);
        return "/banda/edit?faces-redirect=true";
    }
    
    public List<Banda> listar() {
        return this.bandas.Bandas();
    }
    
    public String search(){        
        this.resultBandas = this.bandas.search(this.banda.getLocalDeOrigem());
        this.banda = new Banda();
        return "/banda/search?faces-redirect=true";
    }
        
    
}
