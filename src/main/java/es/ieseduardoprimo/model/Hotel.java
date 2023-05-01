package es.ieseduardoprimo.model;

import java.util.Collection;

import jakarta.persistence.OneToMany;

public class Hotel {
    
    private long id;
    
    private String nombre;
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
    public Hotel(long id, String nombre, int telefono) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
    }
    /**
     * @return the id
     */
    public long getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(long id) {
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

}
