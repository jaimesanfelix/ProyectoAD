package es.ieseduardoprimo.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

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
    private String telefono;

    private Collection<Sala> salas;
    private List<Sala> listaSalas = new ArrayList<Sala>();

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + "]";
    }

    /**
     * @param id
     * @param nombre
     * @param telefono
     */
    public Hotel(int id, String nombre, String telefono) {
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
    public String getTelefono() {
        return telefono;
    }
    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @OneToMany(mappedBy = "hotel")
    public Collection<Sala> getSalas(){
        return salas;
    }

    public List<Sala> getListaSalas(){
        return listaSalas;
    }

    /**
     * @param salas the salas to set
     */
    public void setSalas(Collection<Sala> salas) {
        this.salas = salas;
    }

    public void setSala(Sala s){
        listaSalas.add(s);
    }

}
