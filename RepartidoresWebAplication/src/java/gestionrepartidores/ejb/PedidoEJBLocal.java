/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.ejb;

import gestionrepartidores.entity.Pedido;
import gestionrepartidores.exceptions.ExceptionGetAllPedidos;
import gestionrepartidores.exceptions.ExceptionGetPedidosBusquedaSimple;
import gestionrepartidores.exceptions.ExceptionUpdatePedido;
import gestionrepartidores.exceptions.ExceptionRemovePedido;
import gestionrepartidores.exceptions.ExceptionGetPedidosBusquedaAvanzada;
import gestionrepartidores.exceptions.ExceptionAddPedido;
import gestionrepartidores.exceptions.ExceptionGetDatosNuevoPedido;
import java.time.LocalDate;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Sergio López Fuentefría
 */
@Local
public interface PedidoEJBLocal {
         /**
     * Devuelve todos los pedidos
     * @return colleción con todos los pedidos
     */
    public Collection getAllPedidos()throws ExceptionGetAllPedidos;
    /**
     * Añade un pedido a los existentes
     * @param pedidoBean pedido que se añadirá a la colección
     */
    public void addPedido(Pedido pedido)throws ExceptionAddPedido;
     /**
     * Remplaza cierta información de un pedido
     * @param pedidoBean pedido que contiene la nueva información modificada
     */
    public void updatePedido(Pedido pedido)throws ExceptionUpdatePedido;
     /**
     * Efectúa una selección de ciertos pedidos según unos parámetros
     * @param selectedItem contiene porque parámetro se filtrará
     * @param tfBuscarSimple texto del usuario para filtrar la búsqueda
     * @return colección de pedidos que cuadren con los parámetros de búsqueda
     */
    public Collection getPedidosBusquedaSimple(String selectedItem, String tfBuscarSimple)throws ExceptionGetPedidosBusquedaSimple;
      /**
     * Efectúa una selección de ciertos pedidos según unos parámetros
     * @param selectedItem  área seleccionada por la que se filtrará
     * @param dpfechaEntrada contiene la fecha de inicio con la que se filtrará
     * @param dpfechaSalida contiene la fecha final con la que se filtrará
     * @return colección de pedidos que cuadren con los parámetros de búsqueda
     */
    public Collection getPedidosBusquedaAvanzada(String selectedItem, LocalDate dpfechaEntrada, LocalDate dpfechaSalida,AreaEJBLocal areaManager)throws ExceptionGetPedidosBusquedaAvanzada;
        /**
     * Elimina un pedido
     * @param nSeguimiento número de seguimiento del pedido a eliminar
     */
    public void removePedido(Pedido pedido)throws ExceptionRemovePedido;
    /**
     * Crea los datos para un nuevo pedido
     * @return devuelve un nuevo pedido con los datos basicos generados en base a los pedidos existentes
     */
    public PedidoEJB getDatosNuevoPedido()throws ExceptionGetDatosNuevoPedido;
}
