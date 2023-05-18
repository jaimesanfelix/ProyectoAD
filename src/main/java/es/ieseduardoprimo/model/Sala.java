package es.ieseduardoprimo.model;

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
    private Integer id;

    private Hotel hotel;

    @Override
    public String toString() {
        return "Sala [id=" + id + ", hotel=" + hotel + "]";
    }
    
    private Collection<Media> media;
    @ManyToMany()
    @JoinTable(name = "rooms_media")

    /**
     * @param media the media to set
     */
    public void setMedia(Collection<Media> media) {
        this.media = media;
    }

    public Collection<Media> getMedia(){
        return media;
    }

    /**
     * @param id
     * @param hotel
     */
    public Sala(Integer id, Hotel hotel) {
        this.id = id;
        this.hotel = hotel;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
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
