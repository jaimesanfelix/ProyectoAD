package es.ieseduardoprimo.model;

import java.util.Collection;

import jakarta.persistence.ManyToMany;

public class Media {
    private Integer id;

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
