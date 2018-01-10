/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.ejb;

import gestionrepartidores.entity.Area;
import gestionrepartidores.exceptions.ExceptionGetAllAreaNames;
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
public class AreaEJB implements AreaEJBLocal {

    private static final Logger LOGGER= Logger.getLogger("gestionrepartidores.ejb");
    @PersistenceContext
    private EntityManager em;
     
    @Override
    public Collection getAllAreas() throws ExceptionGetAllAreaNames {
        Collection<Area> areas = new ArrayList <Area> ();
        LOGGER.info("get nombre de áreas");
        try{
          
          areas = em.createNamedQuery("findAllAreas").getResultList();
        }catch(Exception e){
            LOGGER.severe("error al obtener los nombres de las áreas"+e.getMessage());
            throw new ExceptionGetAllAreaNames(e.getMessage());
        }
        return  areas;
    }

    @Override
    public int getNumeroArea(String nombreArea) throws ExceptionGetNumeroArea {
        int numArea;
        LOGGER.info("get nombre de áreas");
        try{
          
          numArea =(Integer)em.createNamedQuery("findNumeroArea").setParameter("nombreArea",nombreArea).getResultList().get(0);
          
        }catch(Exception e){
            LOGGER.severe("error al obtener el cp del área"+e.getMessage());
            throw new ExceptionGetNumeroArea(e.getMessage());
        }
   
        LOGGER.info("cp de área obtenido "+numArea);
        return  numArea;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
