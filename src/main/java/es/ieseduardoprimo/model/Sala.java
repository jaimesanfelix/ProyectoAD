package es.ieseduardoprimo.model;

import java.util.Collection;
import java.util.List;


import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;

public class Sala {

    private Integer id;
    private Hotel hotel;

    @Override
    public String toString() {
        return "Sala [id=" + id + ", hotel=" + hotel + "]";
    }
//Falta añadir el metodo addMedia
    private Collection<Media> media;
    @ManyToMany()
    @JoinTable(name = "Rooms_Media")

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
