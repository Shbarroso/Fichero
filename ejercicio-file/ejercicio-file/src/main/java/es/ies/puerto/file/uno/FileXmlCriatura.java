package es.ies.puerto.file.uno;

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

public class FileXmlCriatura {
    static List<Criatura> criaturas = new ArrayList<>();
    public static void main(String[] args) {
        FileXmlCriatura ceiatura= new FileXmlCriatura();
        System.out.println(ceiatura.obtenerCriaturas());

    }
    
    /**
     * Metodo para obtener las criaturas de la lista.
     * @return una lista con las criaturas.
     */
    public List<Criatura> obtenerCriaturas() {
        try {
            File archivo = new File("src/main/resources/uno.xml");
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(archivo);

            NodeList lista = doc.getElementsByTagName("criatura");
            for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String descripcion = elemento.getElementsByTagName("descripcion").item(0).getTextContent();
                String categoria = elemento.getElementsByTagName("categoria").item(0).getTextContent();
                Criatura criatura = new Criatura(id, nombre, descripcion, categoria);
                criaturas.add(criatura);
            }
        }

            
        } catch (Exception e) {

    }
    return criaturas;
}
    /**
     * Metodo para obtener una criatura de una lista.
     * @param criatura
     * @return
     */
    public Criatura obtener(Criatura criatura) {
        if (criatura == null || criatura.getId() == null) {
            return null;
        }
        criaturas = obtenerCriaturas();
        for (Criatura criaturaBuscada : criaturas) {
            if (criatura.equals(criaturaBuscada)) {
                return criaturaBuscada;
            }    
        }
        return null;
    }
    /**
     * Metodo para añadir una criatura a una lista.
     * @param criatura
     */
    public void addCriatura(Criatura criatura) {
        if (!criaturas.contains(criatura)) {
            criaturas.add(criatura);
            aptualizarFichero(criaturas);
        }
    }
    /**
     * Metodo para eliminar una criatura de la lisa.
     * @param criatura
     */
    public void deleteCriatura(Criatura criatura) {
        if (!criaturas.contains(criatura)) {
            criaturas.remove(criatura);
            aptualizarFichero(criaturas);
        }
    }
    /**
     * Metodo para aptualizar una criatura en la lista.
     * @param criatura
     */
    public void updateCriatura(Criatura criatura) {
        if (!criaturas.contains(criatura)) {
            criaturas.set(criaturas.indexOf(criatura), criatura);
            aptualizarFichero(criaturas);
        }
    }
    public static void aptualizarFichero(List<Criatura> criaturas)  {
        
        try{
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        
        Element root = doc.createElement("empleados");
        doc.appendChild(root);

        for (Criatura criatura: criaturas) {
            Element criaturaXml = doc.createElement("criatura");
            root.appendChild(criaturaXml);
            
            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(criatura.getId()));
            criaturaXml.appendChild(id);
            
            Element nombreXml = doc.createElement("nombre");
            nombreXml.appendChild(doc.createTextNode(criatura.getNombre()));
            criaturaXml.appendChild(nombreXml);

            Element descripcionXml = doc.createElement("fechaNacimiento");
            descripcionXml.appendChild(doc.createTextNode(criatura.getDescripcion()));
            criaturaXml.appendChild(descripcionXml);
            
            Element categoriaXml = doc.createElement("categoria");
            categoriaXml.appendChild(doc.createTextNode(criatura.getCategoria()));
            criaturaXml.appendChild(categoriaXml);
        }
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/main/resources/empleados2.xml"));
        transformer.transform(source, result);
        } catch(Exception e){

        }
    }
}


