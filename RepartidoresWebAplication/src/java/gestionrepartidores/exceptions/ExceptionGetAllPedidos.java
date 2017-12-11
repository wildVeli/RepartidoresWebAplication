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
public class ExceptionGetAllPedidos extends Exception {

    /**
     * Creates a new instance of <code>ExceptionGetAllPedidos</code> without
     * detail message.
     */
    public ExceptionGetAllPedidos() {
    }

    /**
     * Constructs an instance of <code>ExceptionGetAllPedidos</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionGetAllPedidos(String msg) {
        super(msg);
    }
}
