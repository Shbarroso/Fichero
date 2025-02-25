package es.file.json.uno;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.file.json.tres.Hechizo;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class CaballeroService {
    ObjectMapper objectMapper;
    String path = "src/main/resources/caballeros.json";

    List<Caballero> listCaballero;
    File file;
    /**
     * Constructor con 3 parametros.
     */
    public CaballeroService() {
        objectMapper = new ObjectMapper();
        file = new File(path);
        loadAll();
    }
    /**
     * Funcion que encuentra un caballero por id.
     * @param id
     * @return
     */
    public Caballero findById(int id) {
        Caballero caballero = new Caballero(id);
        int posicion = listCaballero.indexOf(caballero);
        if (posicion < 0) {
            return null;
        }
        return listCaballero.get(posicion);
    }
    /**
     * Funcion para leer
     * @param file
     * @param caballeros
     */
    public void saveFile(File file, List<Caballero> caballeros) {
        try {
            objectMapper.writeValue(file, caballeros);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Funcion que compara dos rango de fechas.
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Caballero> findByDateRange(String startDate, String endDate) {
       if (startDate == null || endDate == null||startDate.isEmpty()||endDate.isEmpty()) {
            return null;
        }
        List<Caballero> caballeros = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaInicio = LocalDate.parse(startDate,formato);
        LocalDate fechaFin = LocalDate.parse(endDate,formato);
        for (Caballero caballero : listCaballero) {
            LocalDate fecha = LocalDate.parse(caballero.getFechaIngreso(), formato);
            if (!fecha.isBefore(fechaInicio) && !fecha.isAfter(fechaFin)) {
                caballeros.add(caballero);
            }
        }
        return caballeros;
    }
    /**
     * Funcion para obtener la lista.
     * @return
     */
    public List<Caballero> getList() {
        return listCaballero;
    }
    /**
     * Funcion para leer
     * @return
     */
    public List<Caballero> loadAll() {
        try {
            listCaballero = objectMapper.readValue(file, new TypeReference<List<Caballero>>() {});
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCaballero;
    }
    /**
     * Funcion que añade un caballero.
     * @param obj
     * @return
     */
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
    /**
     * Funcion que elimina un caballero.
     * @param obj
     * @return
     */
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
