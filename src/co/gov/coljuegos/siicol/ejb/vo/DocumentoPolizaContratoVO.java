package co.gov.coljuegos.siicol.ejb.vo;


public class DocumentoPolizaContratoVO {
    
    private String nombreDacumento;
    private boolean seleccion;
    
    public DocumentoPolizaContratoVO() {
    }

    public String getNombreDacumento() {
        return nombreDacumento;
    }

    public void setNombreDacumento(String nombreDacumento) {
        this.nombreDacumento = nombreDacumento;
    }

    public boolean isSeleccion() {
        return seleccion;
    }

    public void setSeleccion(boolean seleccion) {
        this.seleccion = seleccion;
    }
}
