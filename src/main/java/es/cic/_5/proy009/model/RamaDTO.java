package es.cic._5.proy009.model;

public class RamaDTO {
    //DTO = DataTransferObject
    private Long id; 
    private Long numeroHojas; 
    private Boolean torcida; 
    private Long longitud; 
    private Long grosor; 
    private Long arbolId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getNumeroHojas() {
        return numeroHojas;
    }
    public void setNumeroHojas(Long numeroHojas) {
        this.numeroHojas = numeroHojas;
    }
    public Boolean getTorcida() {
        return torcida;
    }
    public void setTorcida(Boolean torcida) {
        this.torcida = torcida;
    }
    public Long getLongitud() {
        return longitud;
    }
    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }
    public Long getGrosor() {
        return grosor;
    }
    public void setGrosor(Long grosor) {
        this.grosor = grosor;
    }
    public Long getArbolId() {
        return arbolId;
    }
    public void setArbolId(Long arbolId) {
        this.arbolId = arbolId;
    }

    

}
