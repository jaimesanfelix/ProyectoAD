package es.ieseduardoprimo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import es.ieseduardoprimo.model.Hotel;
import es.ieseduardoprimo.model.Media;
import es.ieseduardoprimo.model.Sala;

public class ConsultasHotel {

    public void procesarStreams() {

        Hotel h1 = new Hotel(1, "hotel1", 111111);
        Hotel h2 = new Hotel(2, "hotel2", 222222);
        Hotel h3 = new Hotel(3, "hotel3", 333333);

        List<Hotel> listaHoteles = new ArrayList<Hotel>();
        listaHoteles.add(h1);
        listaHoteles.add(h2);
        listaHoteles.add(h3);

        System.out.println("Stream de listados");
        listaHoteles.stream().forEach(System.out::println);
        System.out.println("Fin de stream de listados");
        System.out.println("");

        System.out.println("Stream de nombre de hoteles");
        listaHoteles.stream().map((h) -> h.getNombre()).forEach(System.out::println);
        System.out.println("Fin de stream de nombre de hoteles");
        System.out.println("");

        System.out.println("Contar el numero de hoteles: " + listaHoteles.stream().count());
        System.out.println("Fin de contar numero de hoteles");
        System.out.println("");


        Sala s1 = new Sala("01A");
        Sala s2 = new Sala("02B");
        Sala s3 = new Sala("03C");
        Sala s4 = new Sala("04D");

        h1.setSala(s1);
        h1.setSala(s2);
        h1.setSala(s3);
        h1.setSala(s4);

        h2.setSala(s1);
        h2.setSala(s2);
        h2.setSala(s3);

        h3.setSala(s1);
        h3.setSala(s2);
        h3.setSala(s3);


        Media m1 = new Media(1, "Television");
        Media m2 = new Media(2, "Radio");
        Media m3 = new Media(3, "Video");
        Media m4 = new Media(4, "Internet");

        s1.setMedia(m1);
        s1.setMedia(m2);
        s1.setMedia(m3);
        s1.setMedia(m4);

        s2.setMedia(m2);
        s2.setMedia(m4);

        s3.setMedia(m1);
        s3.setMedia(m3);

        System.out.println("Stream de nombre de hotel con television");
        listaHoteles.stream().map(h -> h.getListaSalas()).flatMap(s -> s.stream()).filter(s -> s.getIdMedia(1)).map(s -> s.getListaMedia()).flatMap(salas -> salas.stream()).map((Sala s) -> s.getNombre().equals("Television")).forEach(System.out::println);
        System.out.println("Fin de stream de nombre de hotel con television\n");


        System.out.println("Listamos el nombre de cada sala");
        listaHoteles.stream().map((Hotel h) -> h.getListaSalas()).flatMap(salas -> salas.stream()).map((Sala s) -> s.getId()).forEach(System.out::println);
        System.out.println("Fin listar nombre sala\n");

        System.out.println("Numero habitaciones por hotel1: " + listaHoteles.stream().filter(h -> h.getId() == 1).map(h -> h.getListaSalas()).flatMap(salas -> salas.stream()).map((Sala s) -> s.getId()).count());
        System.out.println("Fin contar habitaciones hotel1\n");
        
        System.out.println("Numero habitaciones por hotel2: " + listaHoteles.stream().filter(h -> h.getId() == 2).map(h -> h.getListaSalas()).flatMap(salas -> salas.stream()).map((Sala s) -> s.getId()).count());
        System.out.println("Fin contar habitaciones hotel2\n");

        System.out.println("Numero habitaciones por hotel3: " + listaHoteles.stream().filter(h -> h.getId() == 3).map(h -> h.getListaSalas()).flatMap(salas -> salas.stream()).map((Sala s) -> s.getId()).count());
        System.out.println("Fin contar habitaciones hotel3\n");

    }

}
