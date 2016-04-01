package co.com.worldsoft.puppycare.utils;

/**
 * Constantes
 */
public class Constantes {

    /**
     * Puerto que utilizas para la conexión.
     * Dejalo en blanco si no has configurado esta característica.
     */
    private static final String PUERTO_HOST = ":80";//Posible error

    /**
     * Dirección IP de genymotion o AVD
     */
    private static final String IP = "http://192.168.1.52";

    /**
     * URLs del Web Service
     */
    public static final String GET_URL = IP+PUERTO_HOST+"/puppycare/web/obtener_perros.php";
    public static final String INSERT_URL = IP+PUERTO_HOST +"/puppycare/web/insertar_perro.php";

    /**
     * Campos de las respuestas Json
     */
    public static final String ID_GASTO = "idGasto";
    public static final String ESTADO = "estado";
    public static final String GASTOS = "gastos";
    public static final String MENSAJE = "mensaje";

    /**
     * Códigos del campo {@link ESTADO}
     */
    public static final String SUCCESS = "1";
    public static final String FAILED = "2";

    /**
     * Tipo de cuenta para la sincronización
     */
    public static final String ACCOUNT_TYPE = "co.com.worldsoft.puppycare.account";


}
