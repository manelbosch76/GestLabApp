
package gestlab.restfulclient;

import gestlab.model.Producto;
import gestlab.utils.GestlabConstants;
import java.util.List;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 * Classe que gestiona la connexió al servei RESTful de Productos
 * Jersey REST client generated for REST resource:ProductoFacadeREST
 * [model.producto]<br>
 * USAGE:
 * <pre>
 *        ProductoClientSsl client = new ProductoClientSsl();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author manel bosch
 */
public class ProductoClientSsl {
    private WebTarget webTarget;
    private Client client;
    private Response response;

    /**
     * Constructor per defecte
     * @author manel bosch
     */
    public ProductoClientSsl() {
        client = javax.ws.rs.client.ClientBuilder.newBuilder().sslContext(getSSLContext()).hostnameVerifier(getHostnameVerifier()).build();
        webTarget = client.target(GestlabConstants.SERVICE_SSL).path(GestlabConstants.PRODUCTO_SERVICE);
    }

    /**
     * Constructor amb el login i el password passats com a paràmetres
     * @author manel bosch
     * @param username login de l'usuari
     * @param password password de l'usuari
     */
    public ProductoClientSsl(String username, String password) {
        this();
        setUsernamePassword(username, password);
    }
    
    /**
     * Constructor per generar un client al servei de productes amb el token associat a l'usuari
     * @author manel bosch
     * @param token token amb el id i password de l'usuari codificats
     */
    public ProductoClientSsl(String token) {
        this();
        webTarget.register(token);
    }

    /*
    public String countREST() throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("count");
        return resource.request(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
    }*/

    /**
     * Mètode per actualitzar un Producte del servei
     * @author manel bosch
     * @param requestEntity Producte a modificar
     * @param id identificador del Producte
     * @return Response amb el número que indica com ha resultat la connexió al servei
     * @throws ClientErrorException 
     */
    public int edit_JSON(Object requestEntity, String id) throws ClientErrorException {
        response = webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
        return response.getStatus();
    }

    /**
     * Mètode per trobar un Producte al servei RESTful
     * @author manel bosch
     * @param <T> classe que identifica el Producte
     * @param responseType classe Producte
     * @param id identificador del Producte buscat
     * @return Producto
     * @throws ClientErrorException 
     */
    public <T> T find_JSON(Class<T> responseType, String id) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}", new Object[]{id}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    /*
    public <T> T findRange_JSON(Class<T> responseType, String from, String to) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("{0}/{1}", new Object[]{from, to}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }*/

    /**
     * Mètode per crear un Producte nou al servei RESTful
     * @author manel bosch
     * @param requestEntity Producte a crear
     * @return Response amb el número que indica com ha resultat la connexió al servei
     * @throws ClientErrorException 
     */
    public int create_JSON(Object requestEntity) throws ClientErrorException {
        response = webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
        return response.getStatus();
    }

    /*
    public <T> T findAll_JSON(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }*/
    
    /**
     * Mètode per poder obtenir llista de productes
     * @author manel bosch
     * @param genericType tipus genèric que representa la llista de productes
     * @return llista de productes
     * @throws ClientErrorException Excepció generada pel client del servei RESTful
     */
    public List<Producto> findAll_JSON(GenericType<List<Producto>> genericType) throws ClientErrorException{
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(genericType);
    }

    /**
     * Mètode per eliminar un Producte del servei RESTful
     * @author manel bosch
     * @param id identificador del Producte
     * @return Response amb el número que indica com ha resultat la connexió al servei
     * @throws ClientErrorException 
     */
    public int remove(String id) throws ClientErrorException {
        response = webTarget.path(java.text.MessageFormat.format("{0}", new Object[]{id})).request().delete();
        return response.getStatus();
    }

    /**
     * Mètode per tancar la connexió al servei
     * @author manel bosch
     */
    public void close() {
        client.close();
    }

    /**
     * Mètode per registrar el login i el password a la connexió
     * @author manel bosch
     * @param username
     * @param password 
     */
    public final void setUsernamePassword(String username, String password) {
        webTarget.register(new org.glassfish.jersey.client.filter.HttpBasicAuthFilter(username, password));
    }

    /**
     * Mètode per verificar el nom del host en la connexió al servei
     * @author manel bosch
     * @return true si el verifica i false en cas contrari
     */
    private HostnameVerifier getHostnameVerifier() {
        return new HostnameVerifier() {
            @Override
            public boolean verify(String hostname, javax.net.ssl.SSLSession sslSession) {
                return true;
            }
        };
    }

    /**
     * Mètode per obtenir el context SSL de la connexió al servei
     * @author manel bosch
     * @return SSLContext
     */
    private SSLContext getSSLContext() {
        // for alternative implementation checkout org.glassfish.jersey.SslConfigurator
        javax.net.ssl.TrustManager x509 = new javax.net.ssl.X509TrustManager() {
            @Override
            public void checkClientTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
                return;
            }

            @Override
            public void checkServerTrusted(java.security.cert.X509Certificate[] arg0, String arg1) throws java.security.cert.CertificateException {
                return;
            }

            @Override
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {
                return null;
            }
        };
        SSLContext ctx = null;
        try {
            ctx = SSLContext.getInstance("TLSv1");
            System.setProperty("https.protocols", "TLSv1");
            ctx.init(null, new javax.net.ssl.TrustManager[]{x509}, new java.security.SecureRandom());
        } catch (java.security.GeneralSecurityException ex) {
        }
        return ctx;
    }
}
