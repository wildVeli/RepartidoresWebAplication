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
public class ExceptionRemovePedido extends Exception {

    /**
     * Creates a new instance of <code>ExceptionRemovePedido</code> without
     * detail message.
     */
    public ExceptionRemovePedido() {
    }

    /**
     * Constructs an instance of <code>ExceptionRemovePedido</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionRemovePedido(String msg) {
        super(msg);
    }
}
