/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.ejb;

import gestionrepartidores.exceptions.ExceptionGetAllRepartidores;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Sergio López Fuentefría
 */
@Local
public interface RepartidorEJBLocal {

     /**
     * Recoge todos los repartidores
     * @return una colección de repartidores
     */
    public Collection getAllRepartidores() throws ExceptionGetAllRepartidores;

}
