package es.file.json.tres;


import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class HechizoService   {
    ObjectMapper objectMapper;
    String path = "src/main/resources/hechizos.json";

    List<Hechizo> listhHechizos;
    File file;
    
    public HechizoService() {
        objectMapper = new ObjectMapper();
        file = new File(path);
        listhHechizos = loadAll();
    }

    public Hechizo findById(int id) {
        Hechizo hechizo = new Hechizo(id);
        int posicion = listhHechizos.indexOf(hechizo);
        if (posicion < 0) {
            return null;
        }
        return listhHechizos.get(posicion);
    }

    public void saveFile(File file, List<Hechizo> hechizos){
        try {
            objectMapper.writeValue(file, hechizos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Hechizo> findByDateRange(String startDate, String endDate) {
        return null;
    }

    public List<Hechizo> getList() {
        return listhHechizos;
    }
    
    public List<Hechizo> loadAll() {
        try {
            listhHechizos = objectMapper.readValue(file, new TypeReference<List<Hechizo>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listhHechizos;
    }
    
    
    
    public boolean add(Hechizo obj) {
        if (obj == null) {
            return false;
        }
        int posicion = listhHechizos.indexOf(obj);
        if (posicion >= 0) {
            return false;
        }
        boolean insertar = listhHechizos.add(obj);
        if (insertar) {
            saveFile(file, listhHechizos);
        }
        return insertar;
    }

    public boolean delete(Hechizo obj) {
        if (obj == null) {
            return false;
        }
        boolean borrar = listhHechizos.remove(obj);
        if (borrar) {
            saveFile(file, listhHechizos);
        }
        return borrar;
    }
    
    
}
