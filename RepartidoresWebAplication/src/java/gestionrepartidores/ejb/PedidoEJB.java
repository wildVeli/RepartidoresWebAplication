/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.ejb;

import gestionrepartidores.entity.Pedido;
import gestionrepartidores.ejb.AreaEJBLocal;
import gestionrepartidores.exceptions.ExceptionAddPedido;
import gestionrepartidores.exceptions.ExceptionFindNumeroSeguimiento;
import gestionrepartidores.exceptions.ExceptionGetAllPedidos;
import gestionrepartidores.exceptions.ExceptionGetDatosNuevoPedido;
import gestionrepartidores.exceptions.ExceptionGetNumeroArea;
import gestionrepartidores.exceptions.ExceptionGetPedidosBusquedaAvanzada;
import gestionrepartidores.exceptions.ExceptionGetPedidosBusquedaSimple;
import gestionrepartidores.exceptions.ExceptionRemovePedido;
import gestionrepartidores.exceptions.ExceptionUpdatePedido;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Sergio López Fuentefía
 */
@Stateless
public class PedidoEJB implements PedidoEJBLocal {

    private static final Logger LOGGER= Logger.getLogger("gestionrepartidores.ejb");
    @EJB
    private AreaEJBLocal ejbArea;
    
    @PersistenceContext
    private EntityManager em;
    private String formato = "dd-MM-yyyy";
    private DateFormat df;
    
    
    
    @Override
    public Pedido findPedidoByNumeroSeguimiento(Integer nSeguimiento) throws ExceptionFindNumeroSeguimiento {
        LOGGER.info("UserManager: Finding pedido by número seguimiento.");
        return em.find(Pedido.class, nSeguimiento);
    }
    
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

    @Override
    public void updatePedido(Pedido pedido) throws ExceptionUpdatePedido {
        LOGGER.info("actualizando pedido");
        try{
          if(!em.contains(pedido))pedido = em.merge(pedido);
        }catch(Exception e){
            LOGGER.severe("error al actualizar pedido"+e.getMessage());
            throw new ExceptionUpdatePedido(e.getMessage());
        }
   
        LOGGER.info("pedido actualizado");
    }

    @Override
    public Collection<Pedido> getPedidosBusquedaSimple(String selectedItem, String tfBuscarSimple) throws ExceptionGetPedidosBusquedaSimple {
        Collection<Pedido> pedidos = new ArrayList<Pedido> ();
        LOGGER.info("búsqueda simple pedido");
        try{
            Collection busqueda = null;
            switch(selectedItem){
            case ("nseguimiento"):
                pedidos = em.createNamedQuery("findPedidosByNSeguimiento").setParameter("nSeguimiento",Integer.valueOf(tfBuscarSimple)).getResultList();
                break;
            case ("destino"):
                pedidos = em.createNamedQuery("findPedidosByDestino").setParameter("destino",tfBuscarSimple).getResultList();
                break;
            case ("albaran"):
                pedidos = em.createNamedQuery("findPedidosByAlbaran").setParameter("albaran",Integer.valueOf(tfBuscarSimple)).getResultList();
                break;
            case ("fechaentrada"):
                df = new SimpleDateFormat(formato); 
                Date fechaEntrada;
                Date fechaSalida;
                fechaEntrada = df.parse(tfBuscarSimple);
                pedidos = em.createNamedQuery("findPedidosByFechaEntrada").setParameter("fechaEntrada",fechaEntrada).getResultList();
                break;
        }
          
        }catch(Exception e){
            LOGGER.severe("error al efectuar una búsqueda simple"+e.getMessage());
            throw new ExceptionGetPedidosBusquedaSimple(e.getMessage());
        }
   
        LOGGER.info("búsqueda simple finalizada");
        return  pedidos;
    }

 
    @Override
    public Collection getPedidosBusquedaAvanzada(String selectedItem, String dpfechaEntrada, String dpfechaSalida) throws ExceptionGetPedidosBusquedaAvanzada {
        Collection<Pedido> busqueda = null;
        try {
            Collection <Pedido> pedidos = this.getAllPedidos();
            
            int numeroArea=ejbArea.getNumeroArea(selectedItem);
            df = new SimpleDateFormat(formato); 
            Date fechaEntrada;
            Date fechaSalida;
            fechaEntrada = df.parse(dpfechaEntrada);
            fechaSalida = df.parse(dpfechaSalida);
            if(dpfechaEntrada!=null){
                
                busqueda = pedidos.stream().filter(c -> c.getFechaEntrada().compareTo(fechaEntrada)>=0)
                        .collect(Collectors.toList());
            }
            if(dpfechaSalida!=null){
                busqueda = busqueda.stream().filter(c -> c.getFechaSalida().compareTo(fechaSalida)<=0)
                        .collect(Collectors.toList());
            }
            if(!selectedItem.equals("todaslasareas")){
                busqueda = busqueda.stream().filter(c ->c.getArea().equals(numeroArea)).collect(Collectors.toList());
            }
        } catch (ExceptionGetNumeroArea ex) {
            LOGGER.severe("error al recoger el número de área"+ex.getMessage());  
        } catch (ExceptionGetAllPedidos ex) {
            LOGGER.severe("error al recoger todos los pedidos"+ex.getMessage());  
        } catch (ParseException ex) {
            LOGGER.severe("error al convertir fecha"+ex.getMessage());  
        }
        return busqueda;
        
    }

    @Override
    public void removePedido(Pedido pedido) throws ExceptionRemovePedido {
        LOGGER.info("Borrar pedido");
        try{
          pedido=em.merge(pedido);
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
