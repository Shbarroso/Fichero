package es.file.json;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class PokemonService {
    ObjectMapper objectMapper;
    String path;
    File file;
    List<Pokemon> listPokemon;

    public PokemonService(){
        path = "src/main/resources/pokemon.json";
        objectMapper = new ObjectMapper();
        file = new File(path);
        loadAll();
    }
    public Pokemon findById(int id){
        Pokemon pokemon = new Pokemon(id);
        int posicion = listPokemon.indexOf(pokemon);
        if (posicion < 0){
            return null;
        }
        return listPokemon.get(posicion);
    }
    public void saveFile(File file, List<Pokemon> pokemons) {
        try {
            objectMapper.writeValue(file, pokemons); // java to json
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Pokemon> loadAll() {
        try {
            listPokemon = objectMapper.readValue(file, new TypeReference<List<Pokemon>>() {}); // json to java
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listPokemon;
    }
    public List<Pokemon> getList(){
        return listPokemon;
    }

    public boolean add(Pokemon obj) {
        if (obj == null){
            return false;
        }
        int posicion = listPokemon.indexOf(obj);
        if (posicion >= 0){
            return  false;
        }
        boolean resultado = listPokemon.add(obj);
        if (resultado){
            saveFile(file, listPokemon);
        }
        return true;
    }
    public boolean delete(Pokemon obj){
        if (obj == null){
            return false;
        }
        boolean resultado = listPokemon.remove(obj);
        if (resultado){
            saveFile(file, listPokemon);
        }
        return true;
    }
    public boolean update (Pokemon obj){
        if (obj == null){
            return false;
        }
        if (!listPokemon.contains(obj)){
            listPokemon.set(listPokemon.indexOf(obj), obj);
            saveFile(file, listPokemon);
        }
        return true;
    }
}
