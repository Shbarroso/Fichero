package es.ies.puerto.model;
import javax.xml.parsers.*;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;
import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class XmlToJava {

    static List<Empleado> empleados = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        File archivo = new File("src/main/resources/empleados.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(archivo);
        
        NodeList lista = doc.getElementsByTagName("empleado");
        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                String fecha = elemento.getElementsByTagName("fechaNacimiento").item(0).getTextContent();
                String puesto = elemento.getElementsByTagName("puesto").item(0).getTextContent();
                Empleado empleado = new Empleado(id, nombre, fecha, puesto);
                empleados.add(empleado);
            }
        }
        //System.out.println(empleados);
        //escribirXml();
        //modificar(empleados);
        Empleado empleado = new Empleado("1", "Pepe", "0/0/000", "Dios");
        //modificar(empleado, empleados);
        eliminar(empleado, empleados);
    }

    public static void escribirXml() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        
        Element root = doc.createElement("empleados");
        doc.appendChild(root);
        
        Element empleado = doc.createElement("empleado");
        root.appendChild(empleado);
        
        Element id = doc.createElement("id");
        id.appendChild(doc.createTextNode("1"));
        empleado.appendChild(id);
        
        Element nombre = doc.createElement("nombre");
        nombre.appendChild(doc.createTextNode("Mi nombre"));
        empleado.appendChild(nombre);
        
        Element fechaNacimiento = doc.createElement("fechaNacimiento");
        fechaNacimiento.appendChild(doc.createTextNode("1993-05-12"));
        empleado.appendChild(fechaNacimiento);
        
        Element puesto = doc.createElement("puesto");
        puesto.appendChild(doc.createTextNode("Desarrollador"));
        empleado.appendChild(puesto);
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/main/resources/empleados2.xml"));
        transformer.transform(source, result);
    }

    public static Empleado buscar(String idBuscar) throws Exception{
        File archivo = new File("src/main/resources/empleados.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(archivo);
        
        NodeList lista = doc.getElementsByTagName("empleado");
        for (int i = 0; i < lista.getLength(); i++) {
            Node nodo = lista.item(i);
            if (nodo.getNodeType() == Node.ELEMENT_NODE) {
                Element elemento = (Element) nodo;
                String id = elemento.getElementsByTagName("id").item(0).getTextContent();
                if(id.equals(idBuscar)) {
                    String nombre = elemento.getElementsByTagName("nombre").item(0).getTextContent();
                    String fecha = elemento.getElementsByTagName("fechaNacimiento").item(0).getTextContent();
                    String puesto = elemento.getElementsByTagName("puesto").item(0).getTextContent();
                    return new Empleado(id, nombre, fecha, puesto);
                }
               
            }
        }
        return null;
    }
    public static Empleado buscar(String idBuscar, HashSet<Empleado> empleados){
        Empleado empleadoBuscar = new Empleado(idBuscar);
        for(Empleado empleado: empleados){
            if (empleado.equals(empleadoBuscar)) {
                return empleado;
            }
        }
        return null;
        
    }

    public static boolean modificar(Empleado empleado, List<Empleado> empleados)throws Exception {
        if (empleado == null) {
            return false;
        }
        int posicion = empleados.indexOf(empleado);
        if (posicion < 0) {
            return false;
        }
        empleados.set(posicion, empleado);
        volcarFichero(empleados);

        return true;
    }


    public static boolean eliminar(Empleado empleado, List<Empleado> empleados)throws Exception {
        if (empleado == null) {
            return false;
        }

        boolean eliminado = empleados.remove(empleado);
        if (eliminado) {
            volcarFichero(empleados);
        }
        return eliminado;
    }

    public static void volcarFichero(List<Empleado> empleados) throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.newDocument();
        
        Element root = doc.createElement("empleados");
        doc.appendChild(root);

        for (Empleado empleado : empleados) {
            Element empleadoXml = doc.createElement("empleado");
            root.appendChild(empleadoXml);
            
            Element id = doc.createElement("id");
            id.appendChild(doc.createTextNode(empleado.getId()));
            empleadoXml.appendChild(id);
            
            Element nombreXml = doc.createElement("nombre");
            nombreXml.appendChild(doc.createTextNode(empleado.getNombre()));
            empleadoXml.appendChild(nombreXml);

            Element fechaNacimientoXml = doc.createElement("fechaNacimiento");
            fechaNacimientoXml.appendChild(doc.createTextNode(empleado.getFechaNacimiento()));
            empleadoXml.appendChild(fechaNacimientoXml);
            
            Element puestoXml = doc.createElement("puesto");
            puestoXml.appendChild(doc.createTextNode(empleado.getPuesto()));
            empleadoXml.appendChild(puestoXml);
        }
        
        
        
        
        
        
        
        
        
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("src/main/resources/empleados2.xml"));
        transformer.transform(source, result);
    }
}
