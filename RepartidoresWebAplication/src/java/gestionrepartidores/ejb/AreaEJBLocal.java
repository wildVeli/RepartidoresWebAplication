/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.ejb;

import gestionrepartidores.exceptions.ExceptionGetNumeroArea;
import gestionrepartidores.exceptions.ExceptionGetAllAreaNames;
import java.util.Collection;
import javax.ejb.Local;

/**
 *
 * @author Sergio López Fuentefría
 */
@Local
public interface AreaEJBLocal {

     /**
     * Recoge todos los nombres de las áreas
     * @return una colección con los nombres de las áreas
     */
    public Collection getAllAreas() throws ExceptionGetAllAreaNames;
    /**
     * Busca el CP correspondiente al nombre de un área
     * @param selectedItem nombre del área que se consultará
     * @return Devuelve el CP correspondiente a un área
     */
    public int getNumeroArea(String selectedItem)throws ExceptionGetNumeroArea;
}
