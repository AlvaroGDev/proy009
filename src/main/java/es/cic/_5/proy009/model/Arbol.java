package es.cic._5.proy009.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Arbol {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long edad;
    private String especie;
    private String tipoHoja; // Caducifolia, perenne
    private Boolean frutal;

    @OneToMany(mappedBy = "arbol", cascade = { CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE }, fetch = FetchType.LAZY)
    private List<Rama> ramas = new ArrayList<>();

    public Arbol(){

    }

    public Arbol(Long id, Long edad, String especie, String tipoHoja, Boolean frutal, List<Rama> ramas) {
        this.id = id;
        this.edad = edad;
        this.especie = especie;
        this.tipoHoja = tipoHoja;
        this.frutal = frutal;
        this.ramas = ramas;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getEdad() {
        return edad;
    }
    public void setEdad(Long edad) {
        this.edad = edad;
    }
    public String getEspecie() {
        return especie;
    }
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    public String getTipoHoja() {
        return tipoHoja;
    }
    public void setTipoHoja(String tipoHoja) {
        this.tipoHoja = tipoHoja;
    }
    public Boolean getFrutal() {
        return frutal;
    }
    public void setFrutal(Boolean frutal) {
        this.frutal = frutal;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Arbol other = (Arbol) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Arbol [id=" + id + ", edad=" + edad + ", especie=" + especie + ", tipoHoja=" + tipoHoja + ", frutal="
                + frutal + "]";
    }
    
}
