/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestlab.model;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author manel
 */

public class Producto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String nombre;
    
    private String casaComercial;
    
    private String referencia;
    
    private String unidades;
    
    private float cantidad;
    
    private Collection<HistorialProductos> historialProductosCollection;

    public Producto() {
    }

    public Producto(Integer id) {
        this.id = id;
    }

    public Producto(Integer id, String nombre, String casaComercial, String referencia, String unidades, float cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.casaComercial = casaComercial;
        this.referencia = referencia;
        this.unidades = unidades;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCasaComercial() {
        return casaComercial;
    }

    public void setCasaComercial(String casaComercial) {
        this.casaComercial = casaComercial;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public float getCantidad() {
        return cantidad;
    }

    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    @XmlTransient
    public Collection<HistorialProductos> getHistorialProductosCollection() {
        return historialProductosCollection;
    }

    public void setHistorialProductosCollection(Collection<HistorialProductos> historialProductosCollection) {
        this.historialProductosCollection = historialProductosCollection;
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
        if (!(object instanceof Producto)) {
            return false;
        }
        Producto other = (Producto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Producto[ id=" + id + " ]";
    }
    
}
