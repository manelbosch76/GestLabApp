
package gestlab.model;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Classe que representa les empreses
 * @author manel bosch
 */
public class Empresa implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String nif;
    
    private String nombreEmpresa;
    
    private String direccionEmpresa;
   
    private Collection<Cliente> clienteCollection;

    /**
     * Constructor per defecte
     * @author manel bosch
     */
    public Empresa() {
    }

    /**
     * Constructor entrant nif de l'empresa
     * @author manel bosch
     * @param nif de l'empresa
     */
    public Empresa(String nif) {
        this.nif = nif;
    }

    /**
     * Constructor amb totes les dades de l'empresa passades com a paràmetres
     * @author manel bosch
     * @param nif nif de l'empresa
     * @param nombreEmpresa Nom de l'empresa
     * @param direccionEmpresa Adreça de l'empresa
     */
    public Empresa(String nif, String nombreEmpresa, String direccionEmpresa) {
        this.nif = nif;
        this.nombreEmpresa = nombreEmpresa;
        this.direccionEmpresa = direccionEmpresa;
    }

    /**
     * Obté el nif de l'empresa
     * @author manel bosch
     * @return NIF nif de l'empresa
     */
    public String getNif() {
        return nif;
    }

    /**
     * Entra el nif de l'empresa
     * @author manel bosch
     * @param nif nif de l'empresa
     */
    public void setNif(String nif) {
        this.nif = nif;
    }

    /**
     * Obté el nom de l'empresa
     * @author manel bosch
     * @return nom Nom de l'empresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * Entra el nom de l'empresa
     * @author manel bosch
     * @param nombreEmpresa Nom de l'empresa
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    /**
     * Obté l'adreça de l'empresa
     * @author manel bosch
     * @return adreça Adreça de l'empresa
     */
    public String getDireccionEmpresa() {
        return direccionEmpresa;
    }

    /**
     * Entra l'adreça de l'empresa
     * @author manel bosch
     * @param direccionEmpresa Adreça de l'empresa
     */
    public void setDireccionEmpresa(String direccionEmpresa) {
        this.direccionEmpresa = direccionEmpresa;
    }

    /**
     * Obté els diferents clients que té registrats 
     * @author manel bosch
     * @return llista de clients de l'empresa
     */
    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    /**
     * Entra la llista de clients registrats que pertanyen a l'empresa
     * @author manel bosch
     * @param clienteCollection llista de clients de l'empresa
     */
    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nif != null ? nif.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.nif == null && other.nif != null) || (this.nif != null && !this.nif.equals(other.nif))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestlab.model.Empresa[ nif=" + nif + " ]";
    }
    
}
