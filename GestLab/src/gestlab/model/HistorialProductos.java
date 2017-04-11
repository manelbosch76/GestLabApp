/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestlab.model;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author manel
 */

public class HistorialProductos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;

    private Date fechaCompra;
    
    private float cantidad;
    
    private Producto idproducto;
    
    private Cliente idcliente;

    public HistorialProductos() {
    }

    public HistorialProductos(Integer id) {
        this.id = id;
    }

    public HistorialProductos(Integer id, Date fechaCompra, float cantidad) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    public Cliente getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Cliente idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistorialProductos)) {
            return false;
        }
        HistorialProductos other = (HistorialProductos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.HistorialProductos[ id=" + id + " ]";
    }
    
}
