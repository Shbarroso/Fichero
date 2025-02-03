package org.example;

import org.example.model.Empleado;
import org.example.model.fichero.FileOperation;

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("0000000F","Maria","10",1000,"00/1/1212");
        FileOperation fileOperation = new FileOperation();

        System.out.println(empleado);

    }
}