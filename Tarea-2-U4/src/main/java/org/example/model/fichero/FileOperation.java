package org.example.model.fichero;

import org.example.model.Empleado;
import org.example.model.OperacionesInterfaces;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class FileOperation implements OperacionesInterfaces {
    File fichero;
    String path ="/home/dam/Escritorio/Fichero/Tarea-2-U4/src/main/resources/empleados.txt";

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
        Set<Empleado> empleados = read(fichero);
        if (empleados.contains(empleado)) {
            return false;
        }
       return create(empleado.toString(), fichero);
    }


    private boolean create(String data,File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(data);
            writer.newLine(); 
            return true;
        } catch (IOException e) {
            return false;
        }
    }



    /**
     * Metodo que lee los datos de un empleado a partir del identificador
     * @param identificador
     * @return
     */
    @Override
    public Empleado read(String identificador) {
        if (identificador == null || identificador.isEmpty()) {
            return null;
        }
        Empleado empleado = new Empleado(identificador);
        return search(empleado);
    }

    /**
     * Metodo para buscar un empleado.
     * @param empleado
     * @return
     */
    public Empleado search(Empleado empleado) {
        if (empleado == null) {
            return empleado;
        }
        Set<Empleado> empleados = read(fichero);
        for (Empleado empleadoBuscar : empleados) {
            if (empleadoBuscar.equals(empleado)) {
                return empleadoBuscar;
            }
        }
        return empleado;
    }

    /**
     * Metodo que lee los datos de un empleado a partir del objeto empleado
     * @param empleado
     * @return
     */
    @Override
    public Empleado read(Empleado empleado) {
        if (empleado == null) {
            return empleado;
        }
        Set<Empleado> empleados = read(fichero);
        for (Empleado empleadoBuscar : empleados) {
            if (empleadoBuscar.equals(empleado)) {
                return empleadoBuscar;
            }
        }
        return empleado;
    }


    private Set<Empleado> read(File file) {
        Set<Empleado> empleados = new HashSet<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] arrayLine =  line.split(",");
                Empleado empleado = new Empleado(arrayLine[0], arrayLine[1], arrayLine[2], Double.parseDouble(arrayLine[3]), arrayLine[4]);
                empleados.add(empleado);

            }
        } catch (IOException e) {
            return new HashSet<>();
        }
        return empleados;
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
