package es.ieseduardoprimo.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.NonNull;

@Entity
@Table(name = "media")
public class Media {

    @Id
    private Integer id;

    @Column(name = "name")
    @NonNull
    private String nombre;

    private Collection<Sala> salas;

    @ManyToMany(mappedBy = "Sala")
    public Collection<Sala> getSalas(){
        return salas;
    }

    @Override
    public String toString() {
        return "Media [id=" + id + ", nombre=" + nombre + "]";
    }

    /**
     * @param id
     * @param nombre
     */
    public Media(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

}
