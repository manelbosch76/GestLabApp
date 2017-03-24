
package gestlab.model;

import java.io.Serializable;

/**
 * Classe que representa les empreses dels usuaris de la base de dades
 * @author manel bosch
 */

public class Empresa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private String nif;
    
    private String nombreEmpresa;
    
    private String direccionEmpresa;

    public Empresa() {
    }

    /**
     * Crea una empresa a partir del seu identificador
     * @author manel bosch
     * @param id identificador
     */
    public Empresa(Long id) {
        this.id = id;
    }

    /**
     * Crea una empresa a partir de les seves dades
     * @author manel bosch
     * @param id identificador
     * @param nif
     * @param nombreEmpresa
     * @param direccionEmpresa 
     */
    public Empresa(Long id, String nif, String nombreEmpresa, String direccionEmpresa) {
        this.id = id;
        this.nif = nif;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
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
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestlab.model.Empresa[ id=" + id + " ]";
    }
    
}
