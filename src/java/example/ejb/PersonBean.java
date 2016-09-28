/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.ejb;

import example.dao.PersonDAO;
import example.model.Person;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author gustavosa
 */
@Stateless
public class PersonBean implements PersonRemote {

    @PersistenceContext(unitName = "PersonPU")
    private EntityManager em;
    
    @Override
    public Person save(Person p) throws Exception {
        PersonDAO dao = new PersonDAO(em);
        return dao.save(p);
    }

    @Override
    public Person getPerson(Long id) {
        PersonDAO dao = new PersonDAO(em);
        return dao.getPerson(id);
    }

    @Override
    public void delete(Long id) {
        PersonDAO dao = new PersonDAO(em);
        dao.delete(id);
    }
    
}
