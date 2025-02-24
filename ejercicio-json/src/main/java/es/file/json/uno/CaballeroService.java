package es.file.json.uno;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CaballeroService {
    ObjectMapper objectMapper;
    String path = "src/main/resources/caballeros.json";

    List<Caballero> listCaballero;
    File file;

    public CaballeroService() {
        objectMapper = new ObjectMapper();
        file = new File(path);
        loadFile(file);

    }
    private void loadFile(File file) {
        try {
            listCaballero = objectMapper.readValue(file, new TypeReference<List<Caballero>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public Caballero findById(int id) {
        Caballero caballero = new Caballero(id);
        int posicion = listCaballero.indexOf(caballero);
        if (posicion < 0) {
            return null;
        }
        return listCaballero.get(posicion);
    }

    public void saveFile(File file, List<Caballero> caballeros) {
        try {
            objectMapper.writeValue(file, caballeros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<Caballero> findByDateRange(String startDate, String endDate) {
        return null;
    }

    public List<Caballero> getList() {
        return listCaballero;
    }
    
    public List<Caballero> loadAll() {
        return listCaballero;
    }
    
    
    
    public boolean add(Caballero obj) {
        if (obj == null) {
            return false;
        }
        int posicion = listCaballero.indexOf(obj);
        if (posicion >= 0) {
            return false;
        }
        boolean insertar =  listCaballero.add(obj);
        if (insertar) {
            saveFile(file, listCaballero);
        }
        return true;
    }

    public boolean delete(Caballero obj) {
        if (obj == null){
            return false;
        }
        boolean borrar = listCaballero.remove(obj);
        if (borrar){
            saveFile(file, listCaballero);
        }
        return borrar;
    }

}
