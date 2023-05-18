package es.ieseduardoprimo;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import es.ieseduardoprimo.model.Hotel;
import es.ieseduardoprimo.stream.ConsultasHotel;



public final class App {
    //Acabar comentarios
    //Primero hacer el ejercicio 4 JDBC
    //Despues el resto sin importar el orden
    public static void main(String[] args) {

        System.out.println("Vamos a generar XML a partir de la base de datos ajedrez");

        PreparedStatement sentencia = null;

        ResultSet resultado = null;

        try {

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ajedrez", "root", "root");
            DocumentBuilderFactory  dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            //Definimos el documento raiz del documento
            Element eRaiz = doc.createElement("ajedrez");
            doc.appendChild(eRaiz);
            String sentenciaSQL = "SELECT * FROM hotels";

            sentencia = con.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();

            /* ConsultasHotel ch = new ConsultasHotel();
            ArrayList<Hotel> listadoHoteles = ch.getListaHotels(resultado);
            System.out.println("Filtrar solo nombres de hoteles");
            listadoHoteles.stream().map((p)->p.getNombre()).forEach(System.out::println);
            System.out.println("Filtrado finalizado"); */

            String id,nombre,telefono;
            while (resultado.next()) {
                Element eHotel = doc.createElement("hotels");
                eRaiz.appendChild(eHotel);

                id = resultado.getString(1);
                System.out.println(id);
                
                //Atributo para el nodo hoteld
                Attr attr = doc.createAttribute("id");
                attr.setValue(id);

                eHotel.setAttributeNode(attr);

                nombre = resultado.getString(2);

                Element eName = doc.createElement("nombre");
                eName.appendChild(doc.createTextNode(nombre));
                eHotel.appendChild(eName);

                telefono = resultado.getString(3);

                Element eTelefono = doc.createElement("telefono");
                eTelefono.appendChild(doc.createTextNode(telefono));
                eHotel.appendChild(eTelefono);
            }

            //Vamos a leer tablaMedia
            sentenciaSQL = "SELECT * FROM media";

            sentencia = con.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();

            String id_media, nombre_media;
            while (resultado.next()) {
                Element eMedia = doc.createElement("media");
                eRaiz.appendChild(eMedia);

                id_media = resultado.getString(1);
                System.out.println(id_media);
                
                //Atributo para el nodo hoteld
                Attr attr = doc.createAttribute("id");
                attr.setValue(id_media);

                eMedia.setAttributeNode(attr);

                nombre_media = resultado.getString(2);

                Element eName = doc.createElement("nombre");
                eName.appendChild(doc.createTextNode(nombre_media));
                eMedia.appendChild(eName);
            }

            sentenciaSQL = "SELECT * FROM rooms";

            sentencia = con.prepareStatement(sentenciaSQL);
            resultado = sentencia.executeQuery();

            String id_sala, hotel_id;
            while (resultado.next()) {
                Element eSala = doc.createElement("rooms");
                eRaiz.appendChild(eSala);

                id_sala = resultado.getString(1);
                System.out.println(id_sala);
                
                //Atributo para el nodo hoteld
                Attr attr = doc.createAttribute("id");
                attr.setValue(id_sala);

                eSala.setAttributeNode(attr);

                hotel_id = resultado.getString(2);

                Element eName = doc.createElement("hotel_id");
                eName.appendChild(doc.createTextNode(hotel_id));
                eSala.appendChild(eName);
            }


            //Clases necesarias para finalizar la creacion del archivo xml
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            
            Transformer transformer = transformerFactory.newTransformer();

            DOMSource source = new DOMSource(doc);

            StreamResult result = new StreamResult(new File("ajedrez.xml"));

            transformer.transform(source, result);

            //Cerrar conexion jdbc
            con.close();
            con = null;

        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    
}
