package es.ieseduardoprimo.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.NonNull;

@Entity
@Table(name = "hotels")
public class Hotel {
    
    @Id
    private int id;
    
    @Column(name = "name")
    @NonNull
    private String nombre;
    @Column(name = "telephone")
    @NonNull
    private int telefono;

    private Collection<Sala> salas;

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + "]";
    }

    /**
     * @param id
     * @param nombre
     * @param telefono
     */
    public Hotel(int id, String nombre, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return the telefono
     */
    public int getTelefono() {
        return telefono;
    }
    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @OneToMany(mappedBy = "hotel")
    public Collection<Sala> getSalas(){
        return salas;
    }

    /**
     * @param salas the salas to set
     */
    public void setSalas(Collection<Sala> salas) {
        this.salas = salas;
    }

}
