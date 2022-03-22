/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.persistencia;

import br.edu.ifpb.domain.Banda;
import br.edu.ifpb.domain.Gerente;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class BandaPersistencia {
    
    @PersistenceContext
    private EntityManager entityManager;

    public void add(Banda banda) {entityManager.persist(banda);}

    public void update(Banda banda) {entityManager.merge(banda);}

    public void delete(Banda banda) {entityManager.remove(entityManager.merge(banda));}

    public List<Banda> Bandas() {
        return entityManager
                .createQuery("FROM Banda bd", Banda.class)
                .getResultList();
    }

    public List<Gerente> Gerentes () {
       return entityManager
               .createQuery("FROM Gerente grt", Gerente.class)
               .getResultList();
   }
    
    public List<Banda> search(String local) {
        
        List<Banda> resultBandas = new ArrayList<>();       
        
        List<Banda> bandas = entityManager.createQuery("FROM Banda bd", Banda.class).getResultList();
        
        for ( Banda banda : bandas ) {
            
            if ( banda.getLocalDeOrigem().equals(local) ) {
                resultBandas.add(banda);
            }            
        }
        return resultBandas;
    }

}
