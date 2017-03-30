
package gestlab.model;

import java.io.Serializable;

/**
 * Classe que representa els usuaris
 * @author manel bosch
 */

public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String id;
    
    private String contrasena;
    
    private boolean administrador;
    
    private String token;

    /**
     * Constructor per defecte
     * @author manel bosch
     */
    public Usuario() {
    }

     /**
     * Constructor entrant dni de l'usuari
     * @author manel bosch
     * @param id Dni de l'usuari
     */
    public Usuario(String id) {
        this.id = id;
    }

    /**
     * Constructor amb totes les dades de l'usuari passades com a paràmetres
     * @author manel bosch
     * @param id Dni de l'usuari
     * @param contrasena Contrasenya de l'usuari
     * @param administrador Booleà que indica si l'usuari és administrador
     */
    public Usuario(String id, String contrasena, boolean administrador) {
        this.id = id;
        this.contrasena = contrasena;
        this.administrador = administrador;
    }

    /**
     * Obté el dni (login) de l'usuari
     * @author manel bosch
     * @return login
     */
    public String getId() {
        return id;
    }

    /**
     * Entra el dni (login) de l'usuari
     * @author manel bosch
     * @param id DNI de l'usuari
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Obté la contrassenya de l'usuari
     * @author manel bosch
     * @return contrasenya de l'usuari
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Entra la contrassenya de l'usuari
     * @author manel bosch
     * @param contrasena contrasenya de l'usuari
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Obté si l'usuari és administrador o no
     * @author manel bosch
     * @return true o false
     */
    public boolean getAdministrador() {
        return administrador;
    }

    /**
     * Entra si l'usuari és administrador o no
     * @author manel bosch
     * @param administrador Booleà per indicar si és administrador o no
     */
    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    /**
     * Obté el token de l'usuari
     * @author manel bosch
     * @return token Token de l'usuari
     */
    public String getToken() {
        return token;
    }

    /**
     * Entra el token de l'usuari
     * @author manel bosch
     * @param token Token de l'usuari
     */
    public void setToken(String token) {
        this.token = token;
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
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gestlab.model.Usuario[ id=" + id + " ]";
    }
    
}
