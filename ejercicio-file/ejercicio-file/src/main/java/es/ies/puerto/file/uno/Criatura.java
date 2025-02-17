package es.ies.puerto.file.uno;
import java.util.Objects;
/**
 * @author Shbarroso
 * @version 1.0.0
 */
public class Criatura {
    private String id;
    private String nombre;
    private String descripcion;
    private String categoria;

    public Criatura(){}

    /*+
     * Constructor con un solo parametro
     */
    public Criatura(String id) {
        this.id = id;
    }
    /**
     * Constructor con todos los parametros.
     * @param id
     * @param nombre
     * @param descripcion
     * @param categoria
     */
    public Criatura(String id, String nombre, String descripcion, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.categoria = categoria;
    }
    
    /**
     * Getter and Setter
     * @return
     */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    /**
     * ToString
     */
    @Override
    public String toString() {
        return getId() + getNombre() + getDescripcion() + getCategoria();
    }
    /**
     * Equals
     */
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Criatura)) {
            return false;
        }
        Criatura criatura = (Criatura) o;
        return Objects.equals(id, criatura.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, descripcion, categoria);
    }

}
