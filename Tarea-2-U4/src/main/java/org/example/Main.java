package org.example;

import org.example.model.Empleado;
import org.example.model.fichero.FileOperation;

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("4","Maria", "Gerente",10000,"01/02/2023");
        FileOperation fileOperation = new FileOperation();
        System.out.println(fileOperation.read(empleado));

    }
}