package es.ieseduardoprimo.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import es.ieseduardoprimo.model.Hotel;
import es.ieseduardoprimo.model.Media;
import es.ieseduardoprimo.model.Sala;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
class ContarMedias {

    private String media;
    private Long num;
    
} 

public class ConsultasHotel {


    public List<Hotel> cargarDatosHoteles(){

        Hotel h1 = new Hotel(1, "hotel1", 111111);
        Hotel h2 = new Hotel(2, "hotel2", 222222);
        Hotel h3 = new Hotel(3, "hotel3", 333333);

        List<Hotel> listaHoteles = new ArrayList<Hotel>();
        listaHoteles.add(h1);
        listaHoteles.add(h2);
        listaHoteles.add(h3);

        Sala s1 = new Sala("01A");
        Sala s2 = new Sala("02B");
        Sala s3 = new Sala("03C");
        Sala s4 = new Sala("04D");

        h1.setSala(s1);
        h1.setSala(s2);
        h1.setSala(s3);
        h1.setSala(s4);

        //h2.setSala(s1);
        h2.setSala(s2);
        //h2.setSala(s3);

        h3.setSala(s1);
        h3.setSala(s2);
        h3.setSala(s3);


        Media m1 = new Media(1, "Television");
        Media m2 = new Media(2, "Radio");
        Media m3 = new Media(3, "Video");
        Media m4 = new Media(4, "Internet");

        s1.setMedia(m1);
        s1.setMedia(m1);
        s1.setMedia(m1);
        s1.setMedia(m2);
        s1.setMedia(m3);
        s1.setMedia(m4);

        s2.setMedia(m2);
        s2.setMedia(m4);
        s2.setMedia(m4);

        s3.setMedia(m1);
        s3.setMedia(m1);
        s3.setMedia(m3);
        s3.setMedia(m3);
        s3.setMedia(m3);
        

        s4.setMedia(m1);

        return listaHoteles;

    }


    public List<String> getNombreHoteles(List<Hotel> listaHoteles){
        return listaHoteles.stream().map(h -> h.getNombre()).collect(Collectors.toList());
    }

    public List<Media> getNombreHotelesConTV(List<Hotel> listaHoteles){

        /* Map<String, List<Sala> > hotelsMap = listaHoteles.stream().collect(
            Collectors.toMap(Hotel::getNombre, Hotel::getListaSalas));
            System.out.println("hotels: " + hotelsMap); */

        return listaHoteles.stream().map(h -> h.getListaSalas()).flatMap(s -> s.stream()).map(s -> s.getListaMedia()).flatMap(m -> m.stream()).filter(m -> m.getNombre().equals("Television")).collect(Collectors.toList());
    }

    public List<Media> cargarListaMedia(){
        Media m1 = new Media(1, "Television");
        Media m2 = new Media(2, "Radio");
        Media m3 = new Media(3, "Video");
        Media m4 = new Media(4, "Internet");

        List<Media> listaMedia = new ArrayList<Media>();
        listaMedia.add(m1);
        listaMedia.add(m2);
        listaMedia.add(m3);
        listaMedia.add(m4);

        return listaMedia;        
    }

    public Long getNumeroMedia(List<Hotel> listaHoteles, String nombreHotel, String media){
        Long numMedias = listaHoteles.stream().filter(h -> h.getNombre().equals(nombreHotel)).map(h -> h.getListaSalas()).flatMap(s -> s.stream()).map(s -> s.getListaMedia()).flatMap(m -> m.stream()).filter(m -> m.getNombre().equals(media)).count();
        //System.out.println("getNumeroMedia del hotel: " + nombreHotel + " media = " + media + " num = " + numMedias);
        return numMedias;
    }

    Long numTelevision;
    Long numInternet;
    int i;
    Long numMedias;
    Long mayorQue = (long) 0;
    ContarMedias media;
    ArrayList<ContarMedias> medias = new ArrayList<ContarMedias>();
    ArrayList<String> mediaAEnviar = new ArrayList<String>();
    public ArrayList<String> getMedioMasUtilizado(List<Hotel> listaHoteles, List<Media> listaMedias){
        //Recorremos los hoteles
        List<String> hList = listaHoteles.stream().map(h -> h.getNombre()).collect(Collectors.toList());
        
        hList.forEach(h -> {
            medias = new ArrayList<ContarMedias>();
            for (i = 0; i < listaMedias.size(); i++) {
                /* System.out.println("Hotel: " + h); */
                numMedias = getNumeroMedia(listaHoteles, h, listaMedias.get(i).getNombre());
                ContarMedias contarMedias = new ContarMedias(listaMedias.get(i).getNombre(), numMedias);
                medias.add(contarMedias);                
                //System.out.printf("Total de " + listaMedias.get(i).getNombre() + ": [%s]\n", numMedias);
            }
            System.out.println();
            media = medioMasUtilizado(medias);
            mediaAEnviar.add("El medio mas utilizado del hotel " + h + " es " + media.getMedia() + " y tiene " + media.getNum() + " unidades");

            //System.out.println("Hotel " + h + " el medio mas utilizado es " + media);
        });

        /* hList.forEach(h -> {
            System.out.println("Hotel: " + h);
            numTelevision = getNumeroMedia(listaHoteles, h, "Television");
            System.out.printf("Total de televisiones: [%s]\n", numTelevision);
            numInternet = getNumeroMedia(listaHoteles, h, "Internet");
            System.out.printf("Total de televisiones: [%s]\n", numInternet);
            System.out.println();
        
        }); */
        return mediaAEnviar;
    }

    public ContarMedias medioMasUtilizado(ArrayList<ContarMedias> contarMedias){
        ContarMedias max = contarMedias.get(0);
        for (int i = 0; i < contarMedias.size(); i++) {
            if (contarMedias.get(i).getNum() > max.getNum()) {
                max = contarMedias.get(i);
            }
        }
        /* System.out.println("numMedias es " + max.getNum() + " media = " + max.getMedia()); */
        return max;
    }

    public Long getNumeroHabitaciones(List<Hotel> listaHoteles, String nombreHotel){
        return listaHoteles.stream().filter(h -> h.getNombre().equals(nombreHotel)).map(h -> h.getListaSalas()).flatMap(salas -> salas.stream()).map((Sala s) -> s.getId()).count();
    }

    public Long getNumeroTotalHabitaciones(List<Hotel> listaHoteles, String nombreHotel){
        Long hotel1 = getNumeroHabitaciones(listaHoteles, nombreHotel);
        Long hotel2 = getNumeroHabitaciones(listaHoteles, nombreHotel);
        Long hotel3 = getNumeroHabitaciones(listaHoteles, nombreHotel);

        Long numeroTotal = hotel1 + hotel2 + hotel3;
        return numeroTotal;
    }

    private long num;
    private long numPrevio = 0;
    String nombreHotel;
    public String getHotelConMayorNumeroDeHabitaciones(List<Hotel> listaHoteles){
        List<String> hList = listaHoteles.stream().map(h -> h.getNombre()).collect(Collectors.toList());
         
        hList.forEach(h -> {
            num = getNumeroHabitaciones(listaHoteles, h); 
            if (numPrevio < num) {
                numPrevio = num;
                nombreHotel = h;
            }
        });
        
          return nombreHotel;
    }

    Long num1;
    public Long getMedioMasUtilizadoPorHotel(List<Hotel> listaHoteles){
        List<String> hList = listaHoteles.stream().map(h -> h.getNombre()).collect(Collectors.toList());
        List<Media> hListMedia = listaHoteles.stream().map(h -> h.getListaSalas()).flatMap(s -> s.stream()).map(s -> s.getListaMedia()).flatMap(m -> m.stream()).collect(Collectors.toList());

        hList.forEach(h1-> {
            System.out.println("\nHotel: " + h1);
            num1 = listaHoteles.stream().filter(h -> h.getNombre().equals(h1)).map(h -> h.getListaSalas()).flatMap(s -> s.stream()).map(s -> s.getListaMedia()).count();
        });


        return num1;
    }


   /*  public void procesarStreams() {

        listaHoteles.stream().map((h) -> h.getNombre()).forEach(System.out::println);

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

    } */

}
