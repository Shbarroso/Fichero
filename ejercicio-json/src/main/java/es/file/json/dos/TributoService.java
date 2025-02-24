package es.file.json.dos;

import java.io.File;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TributoService {
    ObjectMapper objectMapper;
    String path = "src/main/resources/tributos.json";

    List<Tributo> listTributos;
    File file;

    public TributoService() {
        objectMapper = new ObjectMapper();
        file = new File(path);
        listTributos = loadAll();
    }

    public Tributo findById(int id) {
        Tributo tributo = new Tributo(id);
        int posicion = listTributos.indexOf(tributo);
        if (posicion < 0) {
            return null;
        }
        return listTributos.get(posicion);
    }

    public void saveFile(File file, List<Tributo> tributos){
        try {
            objectMapper.writeValue(file, tributos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Tributo> findByDateRange(String startDate, String endDate) {
        return null;
    }

    public List<Tributo> getList() {
        return listTributos;
    }
    
    public List<Tributo> loadAll() {
        try{
            listTributos = objectMapper.readValue(file, new TypeReference<List<Tributo>>() {} );
        }catch(Exception e){
            e.printStackTrace();
        }
        return listTributos;
    }
    
    
    
    public boolean add(Tributo obj) {
        if (obj == null) {
            return false;
        }
        int posicion = listTributos.indexOf(obj);
        if (posicion >= 0) {
            return false;
        }
        boolean insertar = listTributos.add(obj);
        if (insertar) {
            saveFile(file, listTributos);
        }
        return insertar;
    }

    public boolean delete(Tributo obj) {
        if (obj == null) {
            return false;
        }
        boolean borrar = listTributos.remove(obj);
        if (borrar) {
            saveFile(file, listTributos);
        }
        return borrar;
    }
    
    
}
