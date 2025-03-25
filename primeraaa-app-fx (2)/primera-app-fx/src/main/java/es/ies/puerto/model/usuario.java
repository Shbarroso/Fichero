package es.ies.puerto.model;
import java.util.Objects;

public class usuario {
    String nombre;
    String email;
    String contrasenia;

    public usuario() {
    }

    public usuario(String nombre, String email, String contrasenia) {
        this.nombre = nombre;
        this.email = email;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public usuario nombre(String nombre) {
        setNombre(nombre);
        return this;
    }

    public usuario email(String email) {
        setEmail(email);
        return this;
    }

    public usuario contrasenia(String contrasenia) {
        setContrasenia(contrasenia);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof usuario)) {
            return false;
        }
        usuario usuario = (usuario) o;
        return Objects.equals(email, usuario.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    @Override
    public String toString() {
        return "{" +
            " nombre='" + getNombre() + "'" +
            ", email='" + getEmail() + "'" +
            ", contrasenia='" + getContrasenia() + "'" +
            "}";
    }
    
}
