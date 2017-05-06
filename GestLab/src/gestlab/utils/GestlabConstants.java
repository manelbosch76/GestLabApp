package gestlab.utils;

/**
 * Classe amb les diferents constants que s'utilitzen en l'aplicació
 * @author manel bosch
 */
public class GestlabConstants {

    //Constants per gestionar la connexió al servei RESTful
    public static final String SERVICE = "http://localhost:8080/GestLabService/webresources";
    public static final String SERVICE_SSL = "https://localhost:8181/GestLabService/webresources";
    public static final String USUARIO_SERVICE = "model.usuario";
    public static final String CLIENTE_SERVICE = "model.cliente";
    public static final String EMPRESA_SERVICE = "model.empresa";
    public static final String PRODUCTO_SERVICE = "model.producto";
    public static final String EQUIPO_SERVICE = "model.equipo";
    public static final String HISTORIAL_EQUIPO_SERVICE = "model.historialequipos";
    public static final String HISTORIAL_PRODUCTO_SERVICE = "model.historialproductos";
    
    //Constant per controlar el número de caràcters mínim que ha de tenir el password
    public static final int PASSWD_MIN_SIZE = 5;// A la realitat serien més
    public static final int LOGIN_MIN_SIZE = 9;
    
    //Constant per controlar la quantitat mínima d'stock d'un producte
    public static final float MIN_STOCK = 100;
}
