
package gestlab.model;

import java.io.Serializable;
import java.util.Collection;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Classe que representa els productes
 * @author manel bosch
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

    /**
     * Constructor per defecte
     * @author manel bosch
     */
    public Producto() {
    }

     /**
     * Constructor entrant id del producte
     * @author manel bosch
     * @param id de l'equip
     */
    public Producto(Integer id) {
        this.id = id;
    }

    /**
     * Contstructor entrant totes les dades d'un producte com a paràmetres
     * @author manel bosch
     * @param id identificador del producte
     * @param nombre nom del producte
     * @param casaComercial Casa comercial del producte
     * @param referencia Referència del producte
     * @param unidades Unitats amb les que es comptabilitza el producte
     * @param cantidad Quantitat existent en stock del producte
     */
    public Producto(Integer id, String nombre, String casaComercial, String referencia, String unidades, float cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.casaComercial = casaComercial;
        this.referencia = referencia;
        this.unidades = unidades;
        this.cantidad = cantidad;
    }

    /**
     * Obté l'identificador del producte
     * @author manel bosch
     * @return identificador del producte
     */
    public Integer getId() {
        return id;
    }

    /**
     * Entra l'identificador del producte
     * @author manel bosch
     * @param id identificador del producte
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obté el nom del producte
     * @author manel bosch
     * @return String amb el nom del producte
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Entra el nom del producte
     * @author manel bosch
     * @param nombre String amb el nom del producte
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obté el nom de la casa comercial del producte
     * @author manel bosch
     * @return String amb el nom de la casa comercial del producte
     */
    public String getCasaComercial() {
        return casaComercial;
    }

    /**
     * Entra el nom de la casa comercial del producte
     * @author manel bosch
     * @param casaComercial String amb el nom de la casa comercial del producte
     */
    public void setCasaComercial(String casaComercial) {
        this.casaComercial = casaComercial;
    }

    /**
     * Obté la referència del producte
     * @author manel bosch
     * @return String amb la referència del producte
     */
    public String getReferencia() {
        return referencia;
    }

    /**
     * Entra la referència del producte
     * @author manel bosch
     * @param referencia String amb la referència del producte
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    /**
     * Obté les unitats de mesura del producte
     * @author manel bosch
     * @return String amb les unitats de mesura del producte
     */
    public String getUnidades() {
        return unidades;
    }

    /**
     * Entra les unitats de mesura del producte
     * @author manel bosch
     * @param unidades String amb les unitats de mesura del producte
     */
    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    /**
     * Obté la quatitat en stock del producte
     * @author manel bosch
     * @return float amb la quatitat en stock del producte
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * Entra la quatitat en stock del producte
     * @author manel bosch
     * @param cantidad float amb la quatitat en stock del producte
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obté les diferents compres que s'han fet del producte
     * @author manel bosch
     * @return llista de compres del producte
     */
    @XmlTransient
    public Collection<HistorialProductos> getHistorialProductosCollection() {
        return historialProductosCollection;
    }

    /**
     * Entra les diferents compres que s'han fet del producte
     * @author manel bosch
     * @param historialProductosCollection llista de compres del producte
     */
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
