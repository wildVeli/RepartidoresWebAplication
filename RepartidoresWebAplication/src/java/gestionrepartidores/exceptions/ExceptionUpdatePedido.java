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
public class ExceptionUpdatePedido extends Exception {

    /**
     * Creates a new instance of <code>ExceptionUpdatePedido</code> without
     * detail message.
     */
    public ExceptionUpdatePedido() {
    }

    /**
     * Constructs an instance of <code>ExceptionUpdatePedido</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionUpdatePedido(String msg) {
        super(msg);
    }
}
