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

public class Equipo implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private String nombre;
    
    private String marca;
    
    private String modelo;
    
    private String numeroInventario;
    
    private boolean estadoAlquiler;
    
    private Collection<HistorialEquipos> historialEquiposCollection;

    public Equipo() {
    }

    public Equipo(Integer id) {
        this.id = id;
    }

    public Equipo(Integer id, String nombre, String marca, String modelo, String numeroInventario, boolean estadoAlquiler) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroInventario = numeroInventario;
        this.estadoAlquiler = estadoAlquiler;
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

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getNumeroInventario() {
        return numeroInventario;
    }

    public void setNumeroInventario(String numeroInventario) {
        this.numeroInventario = numeroInventario;
    }

    public boolean getEstadoAlquiler() {
        return estadoAlquiler;
    }

    public void setEstadoAlquiler(boolean estadoAlquiler) {
        this.estadoAlquiler = estadoAlquiler;
    }

    @XmlTransient
    public Collection<HistorialEquipos> getHistorialEquiposCollection() {
        return historialEquiposCollection;
    }

    public void setHistorialEquiposCollection(Collection<HistorialEquipos> historialEquiposCollection) {
        this.historialEquiposCollection = historialEquiposCollection;
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
        if (!(object instanceof Equipo)) {
            return false;
        }
        Equipo other = (Equipo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Equipo[ id=" + id + " ]";
    }
    
}
