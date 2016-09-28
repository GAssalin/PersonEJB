/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.dao;

import example.model.Person;
import javax.persistence.EntityManager;

/**
 *
 * @author gustavosa
 */
public class PersonDAO {
    private EntityManager em;

    public PersonDAO(EntityManager em) {
        this.em = em;
    }
    
    public Person save(Person p) throws Exception {
        if(p.getId() == null) {
            em.persist(p);
        } else {
            if(!em.contains(p)) {
                if(em.find(Person.class, p.getId()) == null) {
                    throw new Exception("Erro ao atualizar os dados");
                }
            }
            p = em.merge(p);
        }
        
        return p;
    }
    
    public Person getPerson(Long id) {
        return em.find(Person.class, id);
    }
    
    public void delete(Long id) {
        Person p = getPerson(id);
        em.remove(p);
    }
}
