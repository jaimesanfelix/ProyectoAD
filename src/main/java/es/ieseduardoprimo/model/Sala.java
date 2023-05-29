package es.ieseduardoprimo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rooms")
public class Sala {

    @Id
    private String id;

    private Hotel hotel;

    private List<Media> listaMedias = new ArrayList<Media>();

    @Override
    public String toString() {
        return "Sala [id=" + id + "]";
    }
    

    @ManyToMany()
    @JoinTable(name = "rooms_media")

    /**
     * @param media the media to set
     */
    

    public void setMedia(Media m){
        listaMedias.add(m);
    }

    public int getIdMedia(int media){
        return media;
    }

    public List<Media> getListaMedia(){
        return listaMedias;
    }

    /**
     * @param id
     * @param hotel
     */
    public Sala(String id, Hotel hotel) {
        this.id = id;
        this.hotel = hotel;
    }

    public Sala(String id){
        this.id = id;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @param hotel the hotel to set
     */
    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    @ManyToOne
    @JoinColumn(name = "hotel_id", referencedColumnName = "id", nullable = false)
    public Hotel getHotel(){
        return hotel;
    }

}
