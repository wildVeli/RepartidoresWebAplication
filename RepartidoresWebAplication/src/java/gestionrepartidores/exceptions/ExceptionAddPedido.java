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
public class ExceptionAddPedido extends Exception {

    /**
     * Creates a new instance of <code>ExceptionAddPedido</code> without detail
     * message.
     */
    public ExceptionAddPedido() {
    }

    /**
     * Constructs an instance of <code>ExceptionAddPedido</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionAddPedido(String msg) {
        super(msg);
    }
}
