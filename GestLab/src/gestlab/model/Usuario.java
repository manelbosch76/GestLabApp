
package gestlab.model;

import java.io.Serializable;

/**
 * Classe que representa els usuaaris del sistema
 * @author manel bosch
 */

public class Usuario implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Long id;
    
    private String login;
    
    private String contrasena;
    
    private String dni;
    
    private String nombre;
    
    private String primerApellido;
   
    private String segundoApellido;
    
    private String email;
    
    private String telefono;
    
    private boolean administrador;
    
    private Empresa idEmpresa;

    public Usuario() {
    }

    /**
     * Crea un usuari a partir del seu identificador
     * @author manel bosch
     * @param id identificador
     */
    public Usuario(Long id) {
        this.id = id;
    }

    /**
     * Crea un usuari a partir de les seves dades
     * @author manel bosch
     * @param id identificador
     * @param login 
     * @param contrasena 
     * @param dni 
     * @param nombre 
     * @param primerApellido 
     * @param email 
     * @param telefono 
     * @param administrador 
     */
    public Usuario(Long id, String login, String contrasena, String dni, String nombre, String primerApellido, String email, String telefono, boolean administrador) {
        this.id = id;
        this.login = login;
        this.contrasena = contrasena;
        this.dni = dni;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.email = email;
        this.telefono = telefono;
        this.administrador = administrador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(boolean administrador) {
        this.administrador = administrador;
    }

    public Empresa getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(Empresa idEmpresa) {
        this.idEmpresa = idEmpresa;
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
