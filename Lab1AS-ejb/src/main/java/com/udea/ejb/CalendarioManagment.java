
package com.udea.ejb;

import com.udea.modelo.Calendario;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author saxss
 */
@Stateless
public class CalendarioManagment implements CalendarioManagmentLocal {
    //ver los calendarios de las facultades
    //actualizar los calendarios
    
    
    @PersistenceContext(unitName = "com.udea_Lab1AS-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    public List<Calendario> getAllCalendarios() {
        //uso una consulta creada y copio el parametro de busqueda
        Query query=em.createNamedQuery("Calendario.findAll");
        //el resultado en forma de lista
        return query.getResultList();
    }

    @Override
    public Calendario update(Calendario calendario) {
        return em.merge(calendario);
    }
    
    
    
    

    
    
    
    
    
    
}
