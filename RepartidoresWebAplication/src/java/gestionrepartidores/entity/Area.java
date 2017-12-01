/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Sergio Lopez Fuentefría
 */
@Entity
public class Area implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id
    private Integer cp;
    private String nombre;
    private String descripcion;
    @ManyToMany
    private List<Repartidor> repartidors;
    @OneToMany(mappedBy = "area")
    private Collection<Pedido> pedidos;

    public Collection<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Collection<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    
    public List<Repartidor> getRepartidors() {
        return repartidors;
    }

    public void setRepartidors(List<Repartidor> repartidors) {
        this.repartidors = repartidors;
    }

    
    public Integer getCp() {
        return cp;
    }

    public void setCp(Integer cp) {
        this.cp = cp;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cp != null ? cp.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the cp fields are not set
        if (!(object instanceof Area)) {
            return false;
        }
        Area other = (Area) object;
        if ((this.cp == null && other.cp != null) || (this.cp != null && !this.cp.equals(other.cp))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionrepartcpores.entity.Area[ cp=" + cp + " ]";
    }
    
}
