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
public class ExceptionFindNumeroSeguimiento extends Exception {

    /**
     * Creates a new instance of <code>ExceptionFindNumeroSeguimiento</code>
     * without detail message.
     */
    public ExceptionFindNumeroSeguimiento() {
    }

    /**
     * Constructs an instance of <code>ExceptionFindNumeroSeguimiento</code>
     * with the specified detail message.
     *
     * @param msg the detail message.
     */
    public ExceptionFindNumeroSeguimiento(String msg) {
        super(msg);
    }
}
