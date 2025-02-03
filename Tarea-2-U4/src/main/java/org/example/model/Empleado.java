package org.example.model;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Empleado {
    private String identificador;
    private  String nombre;
    private String puesto;
    private double salario;
    private  String fechaNacimiento;

    /**
     * Constructores
     * @param identificador
     */

    public Empleado(String identificador) {
        this.identificador = identificador;
    }

    public Empleado(String identificador, String nombre, String puesto, double salario, String fechaNacimiento) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.puesto = puesto;
        this.salario = salario;
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Getter and Setter
     * @return
     */
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * Metodo para calcular la edad
     * @return
     */
    public int getEdad() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaNac = LocalDate.parse(fechaNacimiento, formatter);
        return Period.between(fechaNac, LocalDate.now()).getYears();
    }

    /**
     * Equal que utiliza el parametro identificador
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empleado empleado = (Empleado) o;
        return Objects.equals(identificador, empleado.identificador);
    }

    @Override
    public int hashCode() {
        return Objects.hash(identificador);
    }

    /**
     * ToString  para mostrar empleado"
     * @return
     */
    @Override
    public String toString() {
        return "Empleado{" +
                "identificador='" + identificador + '\'' +
                ", nombre='" + nombre + '\'' +
                ", puesto='" + puesto + '\'' +
                ", salario=" + salario +
                ", fechaNacimiento='" + fechaNacimiento + '\'' +
                '}';
    }
}
