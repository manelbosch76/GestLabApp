
package gestlab.model;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Classe que representa els equips
 * @author manel bosch
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
    
    /**
     * Constructor per defecte
     * @author manel bosch
     */
    public Equipo() {
    }

    /**
     * Constructor entrant id de l'equip
     * @author manel bosch
     * @param id de l'equip
     */
    public Equipo(Integer id) {
        this.id = id;
    }

    /**
     * Constructor entrant les dades d'equip com a paràmetres
     * @author manel bosch
     * @param id identificador de l'equip
     * @param nombre nom de l'equip
     * @param marca marca de l'equip
     * @param modelo model de l'equip
     * @param numeroInventario Número d'inventari de l'equip
     * @param estadoAlquiler Estat de reserva de l'equip
     */
    public Equipo(Integer id, String nombre, String marca, String modelo, String numeroInventario, boolean estadoAlquiler) {
        this.id = id;
        this.nombre = nombre;
        this.marca = marca;
        this.modelo = modelo;
        this.numeroInventario = numeroInventario;
        this.estadoAlquiler = estadoAlquiler;
    }

    /**
     * Obté l'identificador de l'equip
     * @author manel bosch
     * @return identificador de l'equip
     */
    public Integer getId() {
        return id;
    }

    /**
     * Entra l'identificador de l'equip
     * @author manel bosch
     * @param id identificador de l'equip
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obté el nom de l'equip
     * @author manel bosch
     * @return String amb nom de l'equip
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Entra el nom de l'equip
     * @author manel bosch
     * @param nombre String amb nom de l'equip
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obté la marca de l'equip
     * @author manel bosch
     * @return String amb la marca de l'equip
     */
    public String getMarca() {
        return marca;
    }

    /**
     * Entra la marca de l'equip
     * @author manel bosch
     * @param marca String amb la marca de l'equip
     */
    public void setMarca(String marca) {
        this.marca = marca;
    }

    /**
     * Obté el model de l'equip
     * @author manel bosch
     * @return String amb el model d'equip
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * Entra el model de l'equip
     * @author manel bosch
     * @param modelo String amb el model d'equip
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * Obté el número d'inventari de l'equip
     * @author manel bosch
     * @return String amb el número d'inventari de l'equip
     */
    public String getNumeroInventario() {
        return numeroInventario;
    }

    /**
     * Entra el número d'inventari de l'equip
     * @author manel bosch
     * @param numeroInventario String amb el número d'inventari de l'equip
     */
    public void setNumeroInventario(String numeroInventario) {
        this.numeroInventario = numeroInventario;
    }

    /**
     * Obté l'estat de reserva de l'equip
     * @author manel bosch
     * @return cert si està reservat i false en cas contrari
     */
    public boolean getEstadoAlquiler() {
        return estadoAlquiler;
    }

    /**
     * Entra l'estat de reserva de l'equip
     * @author manel bosch
     * @param estadoAlquiler cert si està reservat i false en cas contrari
     */
    public void setEstadoAlquiler(boolean estadoAlquiler) {
        this.estadoAlquiler = estadoAlquiler;
    }

    /**
     * Obté les diferents reserves que té registrades l'equip
     * @author manel bosch
     * @return llista de reserves de l'equip
     */
    @XmlTransient
    public Collection<HistorialEquipos> getHistorialEquiposCollection() {
        return historialEquiposCollection;
    }

    /**
     * Entra les diferents reserves que té registrades l'equip
     * @author manel bosch
     * @param historialEquiposCollection llista de reserves de l'equip
     */
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
