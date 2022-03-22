/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.controller;

import br.edu.ifpb.domain.Integrante;
import br.edu.ifpb.persistencia.IntegrantePersistencia;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@SessionScoped
@Named
public class IntegranteController implements Serializable {
    
    @Inject
    private IntegrantePersistencia persistencia;
    private Integrante integrante = new Integrante();
    private String resultIntegrante = "";

    public String getResultIntegrante() {
        return resultIntegrante;
    }

    public void setResultIntegrante(String resultIntegrante) {
        this.resultIntegrante = resultIntegrante;
    }

    public IntegrantePersistencia getPersistencia() {
        return persistencia;
    }

    public void setPersistencia(IntegrantePersistencia persistencia) {
        this.persistencia = persistencia;
    }

    public Integrante getIntegrante() {
        return integrante;
    }

    public void setIntegrante(Integrante integrante) {
        this.integrante = integrante;
    }

    public String add() {
        if(this.integrante.getId() > 0){
            this.persistencia.updateIntegrante(this.integrante);
        } else {
            this.persistencia.addIntegrante(
                    this.integrante
            );
        }
        this.integrante = new Integrante();
        return "/integrante/list?faces-redirect=true";
    }

    public String update(Integrante integrante) {
        this.integrante = integrante;
        return "/integrante/edit?faces-redirect=true";
        
    }

    public String delete(Integrante integrante) {
        this.persistencia.deleteIntegrante(integrante);
        return "/integrante/list";
    }

    public List<Integrante> list() {
        return this.persistencia.listIntegrantes();
    }

    public String listCpf() {
        Integrante resultInt = this.persistencia.searchCpf(this.integrante.getCpf());
        
        if(resultInt.getNome().equals("Integrante Não encontrado, tente novamente")){
            this.resultIntegrante = resultInt.getNome() +  "não esta cadastrado";
        } else{
            this.resultIntegrante = "Integrante: " + resultInt.getNome() + " id: " + resultInt.getId() +" CPF:" + resultInt.getCpf() + " Data de Nascimento:" + resultInt.getDataDeNascimento();
        }
        this.integrante = new Integrante();
        return "/integrante/search";
    }

    public List<Integrante> listNascimento() {
        return this.persistencia.Nascimento();
    }
    
}