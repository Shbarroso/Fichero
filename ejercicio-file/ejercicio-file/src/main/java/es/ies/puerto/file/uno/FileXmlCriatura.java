package es.ies.puerto.file.uno;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.NodeList;

public class FileXmlCriatura {
    static List<Criatura> criaturas = new ArrayList<>();
    public static void main(String[] args) {
        File archivo = new File("src/main/resources/uno.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(archivo);

        
    }
    /**
     * Metodo para obtener las criaturas de la lista.
     * @return una lista con las criaturas.
     */
    public List<Criatura> obtenerCriaturas() {
        return null;
    }
    /**
     * Metodo para obtener una criatura de una lista.
     * @param criatura
     * @return
     */
    public Criatura obtener(Criatura criatura) {
        return null;
    }
    /**
     * Metodo para añadir una criatura a una lista.
     * @param criatura
     */
    public void addCriatura(Criatura criatura) {
    }
    /**
     * Metodo para eliminar una criatura de la lisa.
     * @param criatura
     */
    public void deleteCriatura(Criatura criatura) {

    }
    /**
     * Metodo para aptualizar una criatura en la lista.
     * @param criatura
     */
    public void updateCriatura(Criatura criatura) {

    }
}
