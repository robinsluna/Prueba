package co.gov.coljuegos.siicol.ejb.vo;

public class RubroEstudioPrevioVO {
    private Long interno;
    private String descripcion;
    
    public RubroEstudioPrevioVO() {    
    }

    public void setInterno(Long interno) {
        this.interno = interno;
    }

    public Long getInterno() {
        return interno;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
