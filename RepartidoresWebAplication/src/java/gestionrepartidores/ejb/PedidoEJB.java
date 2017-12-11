/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.ejb;

import gestionrepartidores.entity.Pedido;
import gestionrepartidores.exceptions.ExceptionAddPedido;
import gestionrepartidores.exceptions.ExceptionGetAllPedidos;
import gestionrepartidores.exceptions.ExceptionGetDatosNuevoPedido;
import gestionrepartidores.exceptions.ExceptionGetPedidosBusquedaAvanzada;
import gestionrepartidores.exceptions.ExceptionGetPedidosBusquedaSimple;
import gestionrepartidores.exceptions.ExceptionRemovePedido;
import gestionrepartidores.exceptions.ExceptionUpdatePedido;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ubuntu
 */
@Stateless
public class PedidoEJB implements PedidoEJBLocal {

    private static final Logger LOGGER= Logger.getLogger("gestionrepartidores.ejb");
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public Collection getAllPedidos() throws ExceptionGetAllPedidos {
        Collection <Pedido> pedidos = new ArrayList <Pedido> ();
        LOGGER.info("buscando todos los pedidos");
        try{
          pedidos =em.createNamedQuery("findAllPedidos").getResultList();
        }catch(Exception e){
            LOGGER.severe("error al buscar todos los pedidos"+e.getMessage());
            throw new ExceptionGetAllPedidos(e.getMessage());
        }
   
        LOGGER.info("fin busqueda pedidos");
        return  pedidos;
    }

    @Override
    public void addPedido(Pedido pedido) throws ExceptionAddPedido {
        LOGGER.info("Añadir pedido");
        try{
          em.persist(pedido);
        }catch(Exception e){
            LOGGER.severe("error al añadir pedido"+e.getMessage());
            throw new ExceptionAddPedido(e.getMessage());
        }
   
        LOGGER.info("Pedido añadido");
    }
arreglar
    @Override
    public void updatePedido(Pedido pedido) throws ExceptionUpdatePedido {
        LOGGER.info("actualizando pedido");
        try{
          em.remove(pedido);
        }catch(Exception e){
            LOGGER.severe("error al actualizar pedido"+e.getMessage());
            throw new ExceptionUpdatePedido(e.getMessage());
        }
   
        LOGGER.info("pedido actualizado");
    }

    @Override
    public Collection getPedidosBusquedaSimple(String selectedItem, String tfBuscarSimple) throws ExceptionGetPedidosBusquedaSimple {
        Collection <Pedido> pedidos = new ArrayList <Pedido> ();
        LOGGER.info("búsqueda simple pedido");
        try{
          
          pedidos = em.createNamedQuery("");
        }catch(Exception e){
            LOGGER.severe("error al efectuar una búsqueda simple"+e.getMessage());
            throw new ExceptionGetPedidosBusquedaSimple(e.getMessage());
        }
   
        LOGGER.info("búsqueda simple finalizada");
        return  pedidos;
    }

    @Override
    public Collection getPedidosBusquedaAvanzada(String selectedItem, LocalDate dpfechaEntrada, LocalDate dpfechaSalida, AreaEJBLocal areaManager) throws ExceptionGetPedidosBusquedaAvanzada {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removePedido(Pedido pedido) throws ExceptionRemovePedido {
        LOGGER.info("Borrar pedido");
        try{
          em.remove(pedido);
        }catch(Exception e){
            LOGGER.severe("error al borrar pedido"+e.getMessage());
            throw new ExceptionRemovePedido(e.getMessage());
        }
   
        LOGGER.info("pedido borrado");
    }

    @Override
    public PedidoEJB getDatosNuevoPedido() throws ExceptionGetDatosNuevoPedido {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
