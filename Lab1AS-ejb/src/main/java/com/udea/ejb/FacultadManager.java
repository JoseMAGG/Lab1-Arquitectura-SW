/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.udea.ejb;

import com.udea.modelo.Facultad;
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
public class FacultadManager implements FacultadManagerLocal {

    @PersistenceContext(unitName = "com.udea_Lab1AS-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;
    
    // listar todas las facultades

    @Override
    public List<Facultad> getFacultades() {
        Query query=em.createNamedQuery("Facultad.findAll");
        return query.getResultList();
    }
    
    
    
    
}
