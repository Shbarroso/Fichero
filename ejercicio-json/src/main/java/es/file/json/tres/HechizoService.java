package es.file.json.tres;


import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;


public class HechizoService   {
    ObjectMapper objectMapper;
    String path = "src/main/resources/hechizos.json";

    List<Hechizo> listhHechizos;
    File file;
    /**
     * Constructor con 3 parametros.
     */
    public HechizoService() {
        objectMapper = new ObjectMapper();
        file = new File(path);
        listhHechizos = loadAll();
    }
    /**
     * Funcion que encuentra una Hechizo por la id.
     * @param id 
     * @return
     */
    public Hechizo findById(int id) {
        Hechizo hechizo = new Hechizo(id);
        int posicion = listhHechizos.indexOf(hechizo);
        if (posicion < 0) {
            return null;
        }
        return listhHechizos.get(posicion);
    }
    /**
     * Funcion para ecribir.
     * @param file
     * @param hechizos
     */
    public void saveFile(File file, List<Hechizo> hechizos){
        try {
            objectMapper.writeValue(file, hechizos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Funcion que compara un rango de fechas.
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Hechizo> findByDateRange(String startDate, String endDate) {
        if (startDate == null || endDate == null||startDate.isEmpty()||endDate.isEmpty()) {
            return null;
        }
        List<Hechizo> hechizos = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaInicio =LocalDate.parse(startDate,formato);
        LocalDate fechaFin =LocalDate.parse(endDate,formato);
        for (Hechizo hechizo : listhHechizos) {
            LocalDate fecha = LocalDate.parse(hechizo.getFechaCreacion(), formato);
            if (!fecha.isBefore(fechaInicio) && !fecha.isAfter(fechaFin)) {
                hechizos.add(hechizo);
            }
        }
        return hechizos;
    }
    /**
     * Funcion que obtiene la lista de Hechizos
     * @return
     */
    public List<Hechizo> getList() {
        return listhHechizos;
    }
    /**
     * Fucion para leer
     * @return
     */
    public List<Hechizo> loadAll() {
        try {
            listhHechizos = objectMapper.readValue(file, new TypeReference<List<Hechizo>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listhHechizos;
    }
    
    
    /**
     * Funcion que añade un Hechizo.
     * @param obj
     * @return
     */
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
    /**
     * Funcion que elimina Hechizo.
     * @param obj
     * @return
     */
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
