package org.example.model;

import org.example.model.Empleado;

import java.util.Set;

public interface OperacionesInterfaces {
    public boolean create(Empleado empleado);
    public Empleado read(String identificador);
    public Empleado read(Empleado empleado);
    public boolean update(Empleado empleado);
    public boolean delete(String identificador);
    public Set<Empleado> empleadosPorPuesto(String puesto);
    public Set<Empleado> empleadosPorEdad(String fechaInicio, String fechaFin);
}
