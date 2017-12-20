/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.rest;

import gestionrepartidores.ejb.AreaEJBLocal;
import gestionrepartidores.entity.Area;
import gestionrepartidores.exceptions.ExceptionGetAllAreaNames;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Sergio López Fuentefría
 */


@Path("area")
public class AreaFacadeREST {

    private static final Logger LOGGER= Logger.getLogger("gestionrepartidores.ejb");
            
    @EJB
    private AreaEJBLocal ejb;

    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Area> findAll() {
        Collection<Area> x = null;
        try {
            LOGGER.info("obteniendo todas las áreas");
            x = ejb.getAllAreaNames();
            
        } catch (ExceptionGetAllAreaNames ex) {
            LOGGER.log(Level.SEVERE,null, ex);
        }
        LOGGER.info("tamaño array devuelto "+x.size());
        return x;

    }



    
}
