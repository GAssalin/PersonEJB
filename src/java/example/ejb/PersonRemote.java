/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package example.ejb;

import example.model.Person;
import javax.ejb.Remote;

/**
 *
 * @author gustavosa
 */
@Remote
public interface PersonRemote {
    public Person save(Person p) throws Exception;
    public Person getPerson(Long id);
    public void delete(Long id);
}
