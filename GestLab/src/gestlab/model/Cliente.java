
package gestlab.model;

import java.io.Serializable;

/**
 * Classe que reprsenta els clients
 * @author manel bosch
 */
public class Cliente implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String dni;
    
    private String nombre;
    
    private String primerApellido;
    
    private String segundoApellido;
    
    private String email;
    
    private String telefono;
    
    private Empresa idempresa;

    /**
     * Constructor per defecte
     * @author manel bosch
     */
    public Cliente() {
    }

    /**
     * Constructor entrant dni del client
     * @author manel bosch
     * @param dni Dni del client
     */
    public Cliente(String dni) {
        this.dni = dni;
    }

    /**
     * Constructor amb totes les dades del client passades com a paràmetres
     * @author manel bosch
     * @param dni dni del client
     * @param nombre nom del client
     * @param primerApellido primer cognom del client
     * @param segundoApellido segon cognom del client
     * @param email Email del client
     * @param telefono Telèfon del client
     */
    public Cliente(String dni, String nombre, String primerApellido, String segundoApellido, String email, String telefono) {
        this.dni = dni;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
        this.email = email;
        this.telefono = telefono;
    }

    /**
     * Obté el dni del cient
     * @author manel bosch
     * @return DNI
     */
    public String getDni() {
        return dni;
    }

    /**
     * Entra el dni del cient
     * @author manel bosch
     * @param dni Dni del client
     */
    public void setDni(String dni) {
        this.dni = dni;
    }

    /**
     * Obté el nom del cient
     * @author manel bosch
     * @return nom Nom del client
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Entra el nom del cient
     * @author manel bosch
     * @param nombre Nom del client
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obté el primer cognom del cient
     * @author manel bosch
     * @return primer cognom
     */
    public String getPrimerApellido() {
        return primerApellido;
    }

    /**
     * Entra el primer cognom del cient
     * @author manel bosch
     * @param primerApellido primer cognom del client
     */
    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    /**
     * Obté el segon cognom del cient
     * @author manel bosch
     * @return segon cognom
     */
    public String getSegundoApellido() {
        return segundoApellido;
    }

    /**
     * Entra el segon congnom  del cient
     * @author manel bosch
     * @param segundoApellido segon cognom del client
     */
    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    /**
     * Obté el email del cient
     * @author manel bosch
     * @return email Email del client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Entra el email del cient
     * @author manel bosch
     * @param email Email del client
     */
    public void setEmail(String email) {
        this.email = email;
    }

     /**
     * Obté el telefon del cient
     * @author manel bosch
     * @return telefon Telèfon del client
     */
    public String getTelefono() {
        return telefono;
    }

     /**
     * Entra el telefon del cient
     * @author manel bosch
     * @param telefono Telèfon del client
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

     /**
     * Obté l'empresa del cient
     * @author manel bosch
     * @return Empresa on està vinculat el client
     */
    public Empresa getIdempresa() {
        return idempresa;
    }

    /**
     * Entra l'empresa del cient
     * @author manel bosch
     * @param iDEmpresa Empresa on està vinculat el client
     */
    public void setIdempresa(Empresa iDEmpresa) {
        this.idempresa = iDEmpresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dni != null ? dni.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.dni == null && other.dni != null) || (this.dni != null && !this.dni.equals(other.dni))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestlab.model.Cliente[ dni=" + dni + " ]";
    }
    
}
