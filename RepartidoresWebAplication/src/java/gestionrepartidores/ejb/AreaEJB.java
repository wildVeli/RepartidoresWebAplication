/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.ejb;

import gestionrepartidores.exceptions.ExceptionGetAllAreaNames;
import gestionrepartidores.exceptions.ExceptionGetNumeroArea;
import java.util.Collection;
import javax.ejb.Stateless;

/**
 *
 * @author ubuntu
 */
@Stateless
public class AreaEJB implements AreaEJBLocal {

    @Override
    public Collection getAllAreaNames() throws ExceptionGetAllAreaNames {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumeroArea(String selectedItem) throws ExceptionGetNumeroArea {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
