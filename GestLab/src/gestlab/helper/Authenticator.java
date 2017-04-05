
package gestlab.helper;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.DatatypeConverter;

/**
 * Classe per generar el header per les comunicacions amb el servei RESTful
 * Contindrà el token amb la id i password de l'usuari connectat
 * @author manel bosch
 */
public class Authenticator implements ClientRequestFilter {

    private final String user;
    private final String password;

    public Authenticator(String user, String password) {
        this.user = user;
        this.password = password;
    }

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        MultivaluedMap<String, Object> headers = requestContext.getHeaders();
        final String basicAuthentication = getBasicAuthentication();
        headers.add("Authorization", basicAuthentication);
    }

    /**
     * Mètode per obtenir el token codificat
     * Fet públic per poder obtenir-lo en l'app i afegir-lo al camp token de la taula Usuari
     * En teoria seria el servidor qui guardaria aquesta informació a la taula
     * @return token codificat
     */
    public String getBasicAuthentication() {
        String token = this.user + ":" + this.password;
        try {
            return "BASIC " + DatatypeConverter.printBase64Binary(token.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException ex) {
            throw new IllegalStateException("Cannot encode with UTF-8", ex);
        }
    }
}
