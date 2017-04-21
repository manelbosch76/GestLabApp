
package gestlab.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.Calendar;

/**
 * Classe que representa la reserva d'un equip per part d'un client
 * @author manel bosch
 */
public class HistorialEquipos implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    
    private Date inicioAlquiler;
    
    private Date finalAlquiler;
    
    private Equipo idequipo;
    
    private Cliente idcliente;
    
    private final Date date = new Date(Calendar.getInstance().getTimeInMillis());//Data del dia actualç
    Date today = java.sql.Date.valueOf(date.toString());//Data del dia actual amb concepte temps a 0

    /**
     * Constructor per defecte
     * @author manel bosch
     */
    public HistorialEquipos() {
    }

    /**
     * Constructor entrant id de la reserva
     * @author manel bosch
     * @param id de la reserva
     */
    public HistorialEquipos(Integer id) {
        this.id = id;
    }

    /**
     * Constructor amb totes les dades de les reserves passades com a paràmetres
     * @author manel bosch
     * @param id v de la reserva
     * @param inicioAlquiler data d'inici de la reserva
     * @param finalAlquiler data de fi de la reserva
     */
    public HistorialEquipos(Integer id, Date inicioAlquiler, Date finalAlquiler) {
        this.id = id;
        this.inicioAlquiler = inicioAlquiler;
        this.finalAlquiler = finalAlquiler;
    }

    /**
     * Obté l'identificador de la reserva
     * @author manel bosch
     * @return identificador de la reserva
     */
    public Integer getId() {
        return id;
    }

    /**
     * Entra l'identificador de la reserva
     * @author manel bosch
     * @param id identificador de la reserva
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Obté la data d'inici de la reserva
     * @author manel bosch
     * @return Date d'inici de la reserva
     */
    public Date getInicioAlquiler() {
        return inicioAlquiler;
    }

    /**
     * Entra la data d'inici de la reserva
     * @author manel bosch
     * @param inicioAlquiler Date d'inici de la reserva
     */
    public void setInicioAlquiler(Date inicioAlquiler) {
        this.inicioAlquiler = inicioAlquiler;
    }

    /**
     * Obté la data de fi de la reserva
     * @author manel bosch
     * @return Date de fi de la reserva
     */
    public Date getFinalAlquiler() {
        return finalAlquiler;
    }

    /**
     * Entra la data de fi de la reserva
     * @author manel bosch
     * @param finalAlquiler Date de fi de la reserva
     */
    public void setFinalAlquiler(Date finalAlquiler) {
        this.finalAlquiler = finalAlquiler;
    }

    /**
     * Obté l'equip reservat
     * @author manel bosch
     * @return Equipo reservat
     */
    public Equipo getIdequipo() {
        return idequipo;
    }

    /**
     * Entra l'equip reservat
     * @author manel bosch
     * @param idequipo Equipo reservat
     */
    public void setIdequipo(Equipo idequipo) {
        this.idequipo = idequipo;
    }

    /**
     * Obté el client que fa la reserva
     * @author manel bosch
     * @return Cliente que reserva
     */
    public Cliente getIdcliente() {
        return idcliente;
    }

    /**
     * Entra el client que fa la reserva
     * @author manel bosch
     * @param idcliente Cliente que reserva
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
    
    /**
     * Mètode per comprovar si el dia actual un equip està reservat.
     * @author manel bosch
     * @param begining data d'inici de la reserva
     * @param end data de fi de la reserva
     * @return true o false
     */
    public boolean isBookedNow(Date begining, Date end){
        return begining.compareTo(today) <= 0 && end.compareTo(today) >= 0;
    }
}
