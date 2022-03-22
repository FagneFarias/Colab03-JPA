/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.persistencia;

import br.edu.ifpb.domain.Integrante;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class IntegrantePersistencia {
    
    @PersistenceContext
    private EntityManager entityManager;

    public void addIntegrante(Integrante integrante) {
        entityManager.persist(integrante);   
    }

    public void updateIntegrante (Integrante integrante) {
      entityManager.merge(integrante); 
    }

    public void deleteIntegrante (Integrante integrante) {
        entityManager.remove(entityManager.merge(integrante));
    }

    public List<Integrante>  listIntegrantes() {
        return entityManager.createQuery("FROM Integrante i", Integrante.class).getResultList();
    }

    public List<Integrante> Nascimento () {
        List<Integrante> integrantes = new ArrayList<>();
        
        integrantes = entityManager
                .createQuery("FROM Integrante i WHERE i.dataDeNascimento BETWEEN :dataInicial and :dataFinal", Integrante.class)
                .setParameter("dataInicial", LocalDate.of(2000, 1, 1))
                .setParameter("dataFinal", LocalDate.of(2022,1,20))
                .getResultList();
        return integrantes;
    }

    public Integrante searchCpf(String cpf) {
        
        List<Integrante> integrantes = entityManager.createQuery("FROM Integrante t", Integrante.class).getResultList();
        
        for ( Integrante integrante : integrantes ) {
            
            if ( integrante.getCpf().equals(cpf) ) {
                return integrante;
            }
            
        }
        return null;
    }
    
}
