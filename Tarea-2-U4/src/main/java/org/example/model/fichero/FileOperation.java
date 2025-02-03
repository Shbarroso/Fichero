package org.example.model.fichero;

import org.example.model.Empleado;
import org.example.model.OperacionesInterfaces;

import java.io.File;
import java.util.Set;

public class FileOperation implements OperacionesInterfaces {
    File fichero;
    String path ="/Users/Usuario/Desktop/2023-2024-programacion/Tarea-2-U4/src/main/resources/empleados.txt";

    /**
     * Metodo que manda una exection si el fichero no existe.
     */
    public FileOperation(){
        fichero = new File(path);
        if (!fichero.exists() || !fichero.isFile()) {
            throw new IllegalArgumentException("El recurso no es de tipo fichero: "+path);
        }
    }

    /**
     * Metodo que crea un nuevo empleado
     * @param empleado
     * @return
     */
    @Override
    public boolean create(Empleado empleado) {
        if (empleado == null || empleado.getIdentificador() == null || empleado.getIdentificador().isEmpty()) {
            return false;
        }

        return false;
    }

    /**
     * Metodo que lee los datos de un empleado a partir del identificador
     * @param identificador
     * @return
     */
    @Override
    public Empleado read(String identificador) {
        return null;
    }

    /**
     * Metodo que lee los datos de un empleado a partir del objeto empleado
     * @param empleado
     * @return
     */
    @Override
    public Empleado read(Empleado empleado) {
        return null;
    }

    /**
     * Metodo que actualiza un objeto existente
     * @param empleado
     * @return
     */
    @Override
    public boolean update(Empleado empleado) {
        return false;
    }

    /**
     * Metodo que borra un objeto a partir del identificador
     * @param identificador
     * @return
     */
    @Override
    public boolean delete(String identificador) {
        return false;
    }

    /**
     * Metodo que devuelve el listado de empleados de un puesto en concreto
     * @param puesto
     * @return
     */
    @Override
    public Set<Empleado> empleadosPorPuesto(String puesto) {
        return null;
    }

    /**
     * Metodo que devuelve el listado de un puesto entre dos fechas concretas.
     * @param fechaInicio
     * @param fechaFin
     * @return
     */
    @Override
    public Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin) {
        return null;
    }
}
