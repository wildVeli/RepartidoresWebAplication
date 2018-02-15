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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *  Mantiene los datos que contienen las áreas
 *  <ul>
 *      <li><strong>cp</strong> Código postal del área</li>
 *      <li><strong>nombre</strong> Nombre del área</li>
 *      <li><strong>descripcion</strong> Descripción del área</li>
 *      <li><strong>repartidors</strong> Lista de repartidores {@link  gestionrepartidores.entity.Repartidor} que reparten en ese área</li>
 *      <li><strong>pedidos</strong> Collección de pedidos {@link  gestionrepartidores.entity.Pedido} existentes en ese área</li>
 *  </ul>
 * @author Sergio Lopez Fuentefría
 */

@Entity
@Table(name="areas",schema="dimdb")
@NamedQueries({
    @NamedQuery(
            name="findAllAreas",
            query="SELECT u FROM Area u"
    ),
    @NamedQuery(
            name="findNumeroArea",
            query="SELECT u.cp FROM Area u WHERE u.nombre = :nombreArea"
    ),
    @NamedQuery(
            name="findAllAreasNames",
            query="SELECT u.nombre FROM Area u"
    )
 })
@XmlRootElement
public class Area implements Serializable {



    private static final long serialVersionUID = 1L;
    @Id
    private Integer cp;
    private String nombre;
    private String descripcion;
    //@ManyToMany
    //private List<Repartidor> repartidors;
    @OneToMany(mappedBy = "area")
    private Collection<Pedido> pedidos;
    
    @XmlTransient
    public Collection<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Collection<Pedido> pedidos) {
        this.pedidos = pedidos;
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
