/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionrepartidores.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Sergio López Fuentefría
 */
@Entity
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
    private Character tipoPago;
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

    public Character getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(Character tipoPago) {
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
