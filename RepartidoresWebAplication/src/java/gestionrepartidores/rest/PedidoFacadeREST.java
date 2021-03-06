/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.rest;

import gestionrepartidores.ejb.PedidoEJBLocal;
import gestionrepartidores.entity.Pedido;
import gestionrepartidores.exceptions.ExceptionAddPedido;
import gestionrepartidores.exceptions.ExceptionFindNumeroSeguimiento;
import gestionrepartidores.exceptions.ExceptionGetAllPedidos;
import gestionrepartidores.exceptions.ExceptionGetDatosNuevoPedido;
import gestionrepartidores.exceptions.ExceptionGetPedidosBusquedaAvanzada;
import gestionrepartidores.exceptions.ExceptionGetPedidosBusquedaSimple;
import gestionrepartidores.exceptions.ExceptionRemovePedido;
import gestionrepartidores.exceptions.ExceptionUpdatePedido;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
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
@Path("pedido")
public class PedidoFacadeREST {

    private static final Logger LOGGER= Logger.getLogger("gestionrepartidores.ejb");
    
    @EJB
    private PedidoEJBLocal ejb;
    

    @POST
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Pedido pedido) {
       
        try {
            ejb.addPedido(pedido);
        } catch (ExceptionAddPedido ex) {
            LOGGER.log(Level.SEVERE,null, ex);
        }
    }

    @PUT
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void update( Pedido pedido) {
        try {
            ejb.updatePedido(pedido);
        } catch (ExceptionUpdatePedido ex) {
            LOGGER.log(Level.SEVERE,null, ex);
        }
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer nSeguimiento) {
        try {
            ejb.removePedido(ejb.findPedidoByNumeroSeguimiento(nSeguimiento));
        } catch (ExceptionFindNumeroSeguimiento ex) {
           LOGGER.log(Level.SEVERE,null, ex); 
        } catch (ExceptionRemovePedido ex) {
           LOGGER.log(Level.SEVERE,null, ex);
        }
    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Pedido findnSeguimiento(@PathParam("id") Integer nSeguimiento) {
        Pedido x = null;
        try {
             x = ejb.findPedidoByNumeroSeguimiento(nSeguimiento);
        } catch (ExceptionFindNumeroSeguimiento ex) {
           LOGGER.log(Level.SEVERE,null, ex); 
        }
        return x;
    }
    
    //Recoge los datos de el ultimo pedido de los datos para generar el nuevo pedido
    @GET
    @Path("nuevoPedido")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Pedido getDatosNuevoPedido() {
        Pedido x = null;
        try {
             x = ejb.getDatosNuevoPedido();
        } catch (ExceptionGetDatosNuevoPedido ex) {
           LOGGER.log(Level.SEVERE,null, ex); 
        }
        return x;
    }
    
    @GET
    @Path("filtrar/{selectedItem}/{tfBuscarSimple}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Pedido> busquedaSimple(@PathParam("selectedItem") String selectedItem, @PathParam("tfBuscarSimple")String tfBuscarSimple) {
        Collection<Pedido> x = null ;
        try {
            x = ejb.getPedidosBusquedaSimple(selectedItem, tfBuscarSimple);
        } catch (ExceptionGetPedidosBusquedaSimple ex) {
            LOGGER.log(Level.SEVERE,null, ex);
        }
        return x;
    }
    
    @GET
    @Path("filtrar/{selectedItem}/{fechaEntrada}/{fechaSalida}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Pedido> busquedaAvanzada(@PathParam("selectedItem") String selectedItem, @PathParam("fechaEntrada")String fechaEntrada,@PathParam("fechaSalida")String fechaSalida) {
        Collection<Pedido> x = null ;
        try {
            x = ejb.getPedidosBusquedaAvanzada(selectedItem, fechaEntrada,fechaSalida);
        } catch (ExceptionGetPedidosBusquedaAvanzada ex) {
            LOGGER.log(Level.SEVERE,null, ex);
        }
        return x;
    }

    @GET
    @Path("findAll")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Pedido> findAll() {
        Collection x = null;
        try {
            x = ejb.getAllPedidos();
        } catch (ExceptionGetAllPedidos ex) {
           LOGGER.log(Level.SEVERE,null, ex);
        }
        return x;
    }
}
