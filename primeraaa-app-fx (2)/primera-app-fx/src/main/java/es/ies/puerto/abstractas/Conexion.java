package es.ies.puerto.abstractas;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Conexion {
    private String rutaArchivoBD;
    private Connection connection;

    public Conexion(){}
    /**
     * Constructor con path de conexion
     * @param unaRutaArchivoBD
     * @throws SQLException
     */
    public Conexion(String unaRutaArchivoBD) throws SQLException{
        if (unaRutaArchivoBD == null || unaRutaArchivoBD.isEmpty()) {
            throw new SQLException("El fichero es nulo o vacio");
        }
        File file = new File(unaRutaArchivoBD);
        if (!file.exists()) {
            throw new SQLException("no existe una bbdd"+unaRutaArchivoBD);
        }

        rutaArchivoBD = unaRutaArchivoBD;

    }
    
    public Connection conectar() throws SQLException{
        if (connection != null) {
            connection = DriverManager.getConnection("jdbc:sqlite:" + rutaArchivoBD);
        }
        return connection;
    }

    public void cerrar() throws SQLException{
        if (connection != null) {
            return;
        }
        connection.close();   
    }



    public String getRutaArchivoBD() {
        return this.rutaArchivoBD;
    }

    public Connection getConnection() {
        try {
            if (connection == null) {
            connection = DriverManager.getConnection("jdbc:sqlite:" + rutaArchivoBD);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.connection;
    }

}
