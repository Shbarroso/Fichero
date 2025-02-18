package es.ies.puerto.file.dos;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;




public class FilePokedexXml {
    static List<Pokemon> pokemons = new ArrayList<>();

    public List<Pokemon> obtenerPokemons() {
        try {
            File archivo = new File("src/main/resources/dos.xml");
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
                List<String> tipos = new ArrayList<>();
                NodeList tiposXMl = elemento.getElementsByTagName("tipo");
                for (int j = 0; j < tiposXMl.getLength(); j++) {
                    tipos.add(tiposXMl.item(j).getTextContent());
                }
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
        if (pokemon == null || pokemon.getId() == null) {
            return null;
        }
        pokemons = obtenerPokemons();
        for(Pokemon pokemonBuscado : pokemons){
            if (pokemon.equals(pokemonBuscado)) {
                return pokemonBuscado;
            }
        }
        return null;
    }
    public void addPokemon(Pokemon pokemon) {
        if (!pokemons.contains(pokemon)) {
            pokemons.add(pokemon);
            aptualizarFichero(pokemons);
        }

    }
    public void deletePokemon(Pokemon pokemon) {
        if (pokemons.contains(pokemon)) {
            pokemons.remove(pokemon);
            aptualizarFichero(pokemons);
        }

    }
    public void updatePokemon(Pokemon pokemon) {
        if (pokemons.contains(pokemon)) {
            pokemons.set(pokemons.indexOf(pokemon), pokemon);
            aptualizarFichero(pokemons);
        }
    }

    public static void aptualizarFichero(List<Pokemon> pokemons)  {
        
        try{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        
        Element root = doc.createElement("pokemons");
        doc.appendChild(root);

        for (Pokemon pokemon: pokemons) {
            Element pokemonXml = doc.createElement("pokemon");
            root.appendChild(pokemonXml);
            
            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(pokemon.getId()));
            pokemonXml.appendChild(id);
            
            Element nombreXml = doc.createElement("nombre");
            nombreXml.appendChild(doc.createTextNode(pokemon.getNombre()));
            pokemonXml.appendChild(nombreXml);

            Element tipoXml = doc.createElement("tipos");
            pokemonXml.appendChild(tipoXml);

            for (String tipo : pokemon.getTipos()) {
                Element tiposXml = doc.createElement("tipo");
                tiposXml.appendChild(doc.createTextNode(tipo));
                tipoXml.appendChild(tiposXml);
            }
        
            Element descripcionXml = doc.createElement("descripcion");
            descripcionXml.appendChild(doc.createTextNode(pokemon.getDescripcion()));
            pokemonXml.appendChild(descripcionXml);
        }

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/main/resources/dos.xml"));
        transformer.transform(source, result);
        } catch(Exception e){

        }

    }

}

