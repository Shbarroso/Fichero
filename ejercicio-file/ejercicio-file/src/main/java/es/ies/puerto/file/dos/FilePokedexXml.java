package es.ies.puerto.file.dos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class FilePokedexXml {
    static List<Pokemon> pokemons = new ArrayList<>();

    public List<Pokemon> obtenerPokemons() {
        try {
            File archivo = new File("src/main/resources/uno.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(archivo);

            NodeList lista = doc.getElementsByTagName("pokemon");
            for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String tipos = elemento.getElementsByTagName("tipos").item(0).getTextContent();
                String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();
                Pokemon pokemon = new Pokemon(id, nombre, tipos, descripcion);
                pokemons.add(pokemon);
            }
        }

            
        } catch (Exception e) {

    }
    return pokemons;
}


    public Pokemon obtenerPokemon(Pokemon pokemon) {
        return null;
    }
    public void addPokemon(Pokemon pokemon) {

    }
    public void deletePokemon(Pokemon pokemon) {

    }
    public void updatePokemon(Pokemon pokemon) {

    }

}

