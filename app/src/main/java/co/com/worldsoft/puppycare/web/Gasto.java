package co.com.worldsoft.puppycare.web;

/**
 * Esta clase representa un gasto individual de cada registro de la base de datos
 */
public class Gasto {
    public String idGasto;
    public String nombre;
    public String ubicacion;
    public String descripcion;
    public String imagen;


    public Gasto(String idGasto, String nombre, String ubicacion, String descripcion, String imagen) {
        this.idGasto = idGasto;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.imagen = imagen;
    }
}
