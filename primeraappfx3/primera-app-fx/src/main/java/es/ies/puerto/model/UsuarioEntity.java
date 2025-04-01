package es.ies.puerto.model;

import java.util.Objects;


public class UsuarioEntity {
    String usuario;
    String email;
    String nombre;
    String contrasenia;


    public UsuarioEntity() {
    }

    public UsuarioEntity(String usuario, String email, String nombre, String contrasenia) {
        this.usuario = usuario;
        this.email = email;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return this.contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getUsuario() {
        return this.usuario;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UsuarioEntity)) {
            return false;
        }
        UsuarioEntity usuarioEntity = (UsuarioEntity) o;
        return Objects.equals(usuario, usuarioEntity.usuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(usuario, email, nombre, contrasenia);
    }


  

    @Override
    public String toString() {
        return "{" +
            " usuario='" + getUsuario() + "'" +
            ", email='" + getEmail() + "'" +
            ", nombre='" + getNombre() + "'" +
            ", contrasenia='" + getContrasenia() + "'" +
            "}";
    }
    


}
