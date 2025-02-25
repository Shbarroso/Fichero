package es.file.json.dos;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import es.file.json.tres.Hechizo;

public class TributoService {
    ObjectMapper objectMapper;
    String path = "src/main/resources/tributos.json";

    List<Tributo> listTributos;
    File file;
    /**
     * Constructor con 3 parametros.
     */
    public TributoService() {
        objectMapper = new ObjectMapper();
        file = new File(path);
        listTributos = loadAll();
    }
    /**
     * Funcion que encuentra un tributo por id.
     * @param id
     * @return
     */
    public Tributo findById(int id) {
        Tributo tributo = new Tributo(id);
        int posicion = listTributos.indexOf(tributo);
        if (posicion < 0) {
            return null;
        }
        return listTributos.get(posicion);
    }
    /**
     * Funcion para escribir
     * @param file
     * @param tributos
     */
    public void saveFile(File file, List<Tributo> tributos){
        try {
            objectMapper.writeValue(file, tributos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Funcion para comparar un rango de fechas.
     * @param startDate
     * @param endDate
     * @return
     */
    public List<Tributo> findByDateRange(String startDate, String endDate) {
    if (startDate == null || endDate == null||startDate.isEmpty()||endDate.isEmpty()) {
            return null;
        }
        List<Tributo> tributos = new ArrayList<>();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate fechaInicio =LocalDate.parse(startDate,formato);
        LocalDate fechaFin =LocalDate.parse(endDate,formato);
        for (Tributo tributo : listTributos) {
            LocalDate fecha = LocalDate.parse(tributo.getFechaSeleccion(), formato);
            if (!fecha.isBefore(fechaInicio) && !fecha.isAfter(fechaFin)) {
                tributos.add(tributo);
            }
        }
        return tributos;
    }
    /**
     * Funcion para obtener la lista
     * @return
     */
    public List<Tributo> getList() {
        return listTributos;
    }
    /**
     * Funcion para leer
     * @return
     */
    public List<Tributo> loadAll() {
        try{
            listTributos = objectMapper.readValue(file, new TypeReference<List<Tributo>>() {} );
        }catch(Exception e){
            e.printStackTrace();
        }
        return listTributos;
    }
        
    /**
     * Funcion para añadir un tributo.
     * @param obj
     * @return
     */
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
    /**
     * Funcion para eliminar un tributo.
     * @param obj
     * @return
     */
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
