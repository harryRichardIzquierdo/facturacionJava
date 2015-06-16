/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bago.entitys;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author desarrollo
 */
@Entity
@Table(name = "FACTURA_DETALLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaDetalle.findAll", query = "SELECT f FROM FacturaDetalle f"),
    @NamedQuery(name = "FacturaDetalle.findByCantidad", query = "SELECT f FROM FacturaDetalle f WHERE f.cantidad = :cantidad"),
    @NamedQuery(name = "FacturaDetalle.findByTotal", query = "SELECT f FROM FacturaDetalle f WHERE f.total = :total"),
    @NamedQuery(name = "FacturaDetalle.findByIdFacturaDetalle", query = "SELECT f FROM FacturaDetalle f WHERE f.idFacturaDetalle = :idFacturaDetalle")})
public class FacturaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "CANTIDAD")
    private Integer cantidad;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "TOTAL")
    private BigDecimal total;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_FACTURA_DETALLE")
    @SequenceGenerator(name="FACTURA_DETALLE", initialValue=1, sequenceName = "FACTURA_DETALLE_SEQ",allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FACTURA_DETALLE")
    private BigDecimal idFacturaDetalle;
    @JoinColumn(name = "ID_FACTURA", referencedColumnName = "ID_FACTURA")
    @ManyToOne(optional = false)
    private Factura idFactura;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne
    private Producto idProducto;

    public FacturaDetalle() {
    }

    public FacturaDetalle(BigDecimal idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getIdFacturaDetalle() {
        return idFacturaDetalle;
    }

    public void setIdFacturaDetalle(BigDecimal idFacturaDetalle) {
        this.idFacturaDetalle = idFacturaDetalle;
    }

    public Factura getIdFactura() {
        return idFactura;
    }

    public void setIdFactura(Factura idFactura) {
        this.idFactura = idFactura;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFacturaDetalle != null ? idFacturaDetalle.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaDetalle)) {
            return false;
        }
        FacturaDetalle other = (FacturaDetalle) object;
        if ((this.idFacturaDetalle == null && other.idFacturaDetalle != null) || (this.idFacturaDetalle != null && !this.idFacturaDetalle.equals(other.idFacturaDetalle))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bago.entitys.FacturaDetalle[ idFacturaDetalle=" + idFacturaDetalle + " ]";
    }
    
}
