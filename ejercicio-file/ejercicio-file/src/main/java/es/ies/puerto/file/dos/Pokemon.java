package es.ies.puerto.file.dos;

import java.util.;
import java.util.Objects;

public class Pokemon {

    private String id;
    private String nombre;
    private String tipos;
    private String descripcion;

    public Pokemon() {
    }

    public Pokemon(String id) {
        this.id = id;
    }


    public Pokemon(String id, String nombre, String tipos, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tipos = tipos;
        this.descripcion = descripcion;
    }


    // Constructor, getters y setters

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

    public String getTipos() {
        return tipos;
    }

    public void setTipos(String tipos) {
        this.tipos = tipos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Pokemon)) {
            return false;
        }
        Pokemon pokemon = (Pokemon) o;
        return Objects.equals(id, pokemon.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, tipos, descripcion);
    }

    @Override
    public String toString() {
        return  getId() + getNombre() + getTipos() + getDescripcion();
    }
    
}
