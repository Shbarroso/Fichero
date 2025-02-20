package es.ies.puerto;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.ObjectMapper;

public class TabajoJson {
    static ObjectMapper objectMapper = new ObjectMapper();
    public static void main(String[] args) {
        Coche miCoche = new Coche();
        miCoche.setColor("gris");
        miCoche.setTipo("automovil");
        Set<Coche> coches = new HashSet<>();
        coches.add(miCoche);
        coches.add(miCoche);

        Coche coche = objectMapper.readValue(new File("src/main/resources/coche.json"), coches);


        try{
            objectMapper.writeValue(new File("src/main/resources/Coche.json"), coches);
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
