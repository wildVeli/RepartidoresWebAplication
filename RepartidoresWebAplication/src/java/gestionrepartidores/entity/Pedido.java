/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;



/**E
 *
 * @author Sergio López Fuentefría
 */
@Entity
@Table(name="pedidos",schema="dimdb")
@NamedQueries({
    @NamedQuery(
            name="findAllPedidos",
            query="SELECT u FROM Pedido u"
    ),
    @NamedQuery(
            name="findPedidosByNSeguimiento",
            query="SELECT u FROM Pedido u WHERE u.nSeguimiento = :nSeguimiento"
    ),
    @NamedQuery(
            name="findPedidosByAlbaran",
            query="SELECT u FROM Pedido u WHERE u.albaran = :albaran"
    ),
    @NamedQuery(
            name="findPedidosByDestino",
            query="SELECT u FROM Pedido u WHERE u.destino = :destino"
    ),
        @NamedQuery(
                //https://community.oracle.com/blogs/juztinjames/2015/05/21/sql-date-functions-in-jpql
            name="findPedidosByFechaEntrada",
            query="SELECT u FROM Pedido u WHERE fun('TO_DATE',u.fechaEntrada, 'dd/mm/yyyy')  = :fechaEntrada"
    )
 })
@XmlRootElement
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer nSeguimiento;
    private Integer albaran;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaEntrada;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaSalida;
    private String destino;
    @Enumerated(EnumType.ORDINAL)
    private TipoPago tipoPago;
    @ManyToOne
    private Repartidor repartidor;
    @ManyToOne
    private Area area;

    
    public Integer getnSeguimiento() {
        return nSeguimiento;
    }

    public void setnSeguimiento(Integer nSeguimiento) {
        this.nSeguimiento = nSeguimiento;
    }

    public Integer getAlbaran() {
        return albaran;
    }

    public void setAlbaran(Integer albaran) {
        this.albaran = albaran;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(TipoPago tipoPago) {
        this.tipoPago = tipoPago;
    }



    public Repartidor getRepartidor() {
        return repartidor;
    }

    public void setRepartidor(Repartidor repartidor) {
        this.repartidor = repartidor;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }


    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nSeguimiento != null ? nSeguimiento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the nSeguimiento fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.nSeguimiento == null && other.nSeguimiento != null) || (this.nSeguimiento != null && !this.nSeguimiento.equals(other.nSeguimiento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestionrepartidores.entity.Pedido[ nSeguimiento=" + nSeguimiento + " ]";
    }
    
}
