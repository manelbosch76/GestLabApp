
package gestlab.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Classe que representa la compra d'un producte per part d'un client
 * @author manel bosch
 */
public class HistorialProductos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;

    private Date fechaCompra;
    
    private float cantidad;
    
    private Producto idproducto;
    
    private Cliente idcliente;

    /**
     * Constructor per defecte
     * @author manel bosch
     */
    public HistorialProductos() {
    }

    /**
     * Constructor entrant id de la compra
     * @author manel bosch
     * @param id de la compra
     */
    public HistorialProductos(Integer id) {
        this.id = id;
    }

    /**
     * Constructor entrant totes les dades de la compra com a paràmetre
     * @author manel bosch
     * @param id identificador de la compra
     * @param fechaCompra data de la compra
     * @param cantidad quantita comprada
     */
    public HistorialProductos(Integer id, Date fechaCompra, float cantidad) {
        this.id = id;
        this.fechaCompra = fechaCompra;
        this.cantidad = cantidad;
    }

    /**
     * Obté l'identificador de la compra
     * @author manel bosch
     * @return identificador de la compra
     */
    public Integer getId() {
        return id;
    }

    /**
     * Entra l'identificador de la compra
     * @author manel bosch
     * @param id identificador de la compra
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obté la data de la compra
     * @author manel bosch
     * @return Date de la compra
     */
    public Date getFechaCompra() {
        return fechaCompra;
    }

    /**
     * Entra la data de la compra
     * @author manel bosch
     * @param fechaCompra Date de la compra
     */
    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    /**
     * Obté la quantitat comprada
     * @author manel bosch
     * @return float amb la quantitat comprada
     */
    public float getCantidad() {
        return cantidad;
    }

    /**
     * Entra la quantitat comprada
     * @author manel bosch
     * @param cantidad float amb la quantitat comprada
     */
    public void setCantidad(float cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obté el producte comprat
     * @author manel bosch
     * @return Producto comprat
     */
    public Producto getIdproducto() {
        return idproducto;
    }

    /**
     * Entra el producte comprat
     * @author manel bosch
     * @param idproducto Producto comprat
     */
    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    /**
     * Obté el client que fa la compra
     * @author manel bosch
     * @return Cliente que compra
     */
    public Cliente getIdcliente() {
        return idcliente;
    }

    /**
     * Obté el client que fa la compra
     * @author manel bosch
     * @param idcliente Cliente que compra
     */
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
