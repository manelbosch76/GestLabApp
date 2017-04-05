/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestlab.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author manel
 */

public class HistorialEquipos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private Date inicioAlquiler;
    
    private Date finalAlquiler;
    
    private Equipo iDEquipo;
    
    private Cliente iDCliente;

    public HistorialEquipos() {
    }

    public HistorialEquipos(Integer id) {
        this.id = id;
    }

    public HistorialEquipos(Integer id, Date inicioAlquiler, Date finalAlquiler) {
        this.id = id;
        this.inicioAlquiler = inicioAlquiler;
        this.finalAlquiler = finalAlquiler;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicioAlquiler() {
        return inicioAlquiler;
    }

    public void setInicioAlquiler(Date inicioAlquiler) {
        this.inicioAlquiler = inicioAlquiler;
    }

    public Date getFinalAlquiler() {
        return finalAlquiler;
    }

    public void setFinalAlquiler(Date finalAlquiler) {
        this.finalAlquiler = finalAlquiler;
    }

    public Equipo getIDEquipo() {
        return iDEquipo;
    }

    public void setIDEquipo(Equipo iDEquipo) {
        this.iDEquipo = iDEquipo;
    }

    public Cliente getIDCliente() {
        return iDCliente;
    }

    public void setIDCliente(Cliente iDCliente) {
        this.iDCliente = iDCliente;
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
        if (!(object instanceof HistorialEquipos)) {
            return false;
        }
        HistorialEquipos other = (HistorialEquipos) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.HistorialEquipos[ id=" + id + " ]";
    }
    
}
