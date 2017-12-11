/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.exceptions;

/**
 *
 * @author ubuntu
 */
public class ExceptionGetPedidosBusquedaAvanzada extends Exception {

    /**
     * Creates a new instance of
     * <code>ExceptionGetPedidosBusquedaAvanzada</code> without detail message.
     */
    public ExceptionGetPedidosBusquedaAvanzada() {
    }

    /**
     * Constructs an instance of
     * <code>ExceptionGetPedidosBusquedaAvanzada</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionGetPedidosBusquedaAvanzada(String msg) {
        super(msg);
    }
}
