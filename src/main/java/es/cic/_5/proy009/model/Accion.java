package es.cic._5.proy009.model;

public class Accion {

    private String tipoAccion; //Crear, modificar, borrar, actualizar
    private RamaDTO dataRama;

    public String getTipoAccion() {
        return tipoAccion;
    }
    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }
    public RamaDTO getDataRama() {
        return dataRama;
    }
    public void setDataRama(RamaDTO dataRama) {
        this.dataRama = dataRama;
    }

    public Accion(String tipoAccion, es.cic._5.proy009.model.RamaDTO dataRama) {
        this.tipoAccion = tipoAccion;
        this.dataRama = dataRama;
    }
    

    
    
}
