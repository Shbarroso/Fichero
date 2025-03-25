package es.ies.puerto.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import es.ies.puerto.abstractas.Conexion;

public class UsuarioDto extends Conexion {

    public UsuarioDto(){

    }

    public UsuarioDto(String unaRutaArchivoBD) throws SQLException {
        super(unaRutaArchivoBD);
    }

    public ArrayList<usuario> obtenerPerros() throws SQLException{
        ArrayList<usuario> usuarios = new ArrayList<usuario>();
        
        try{
            PreparedStatement sentencia = getConnection().prepareStatement("SELECT * FROM usuario");
            ResultSet resultado = sentencia.executeQuery();
            ArrayList<usuario> usuarios = new ArrayList<usuario>();
            while(resultado.next()){
                String nombreStr = resultado.getString("nombre");
                String email = resultado.getString("email");
                String contrasenia = resultado.getString("contrasenia");
                usuario usuario = new usuario(nombreStr, email, contrasenia );
                usuarios.add(usuario);
            }
            return usuarios;
        }catch(Exception e){
            e.printStackTrace();
        } finally{
            cerrar();
        }
        return usuarios;
    }
    

}   
