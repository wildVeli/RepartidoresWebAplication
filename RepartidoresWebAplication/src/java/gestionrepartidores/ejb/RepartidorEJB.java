/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.ejb;

import gestionrepartidores.entity.Area;
import gestionrepartidores.entity.Repartidor;
import gestionrepartidores.exceptions.ExceptionGetAllAreaNames;
import gestionrepartidores.exceptions.ExceptionGetAllRepartidores;
import gestionrepartidores.exceptions.ExceptionGetNumeroArea;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sergio López Fuentefría
 */
@Stateless
public class RepartidorEJB implements RepartidorEJBLocal {

    private static final Logger LOGGER= Logger.getLogger("gestionrepartidores.ejb");
    @PersistenceContext
    private EntityManager em;
     
    @Override
    public Collection getAllRepartidores() throws ExceptionGetAllRepartidores {
        Collection<Repartidor> repartidores = new ArrayList <Repartidor> ();
        LOGGER.info("get repartidores");
        try{
          
          repartidores = em.createNamedQuery("findAllRepartidores").getResultList();
          
        }catch(Exception e){
            LOGGER.severe("error al obtener los repartidores"+e.getMessage());
            throw new ExceptionGetAllRepartidores(e.getMessage());
        }
        return  repartidores;
    }

  
}
