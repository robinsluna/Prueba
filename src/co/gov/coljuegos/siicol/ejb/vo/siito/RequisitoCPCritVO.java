package co.gov.coljuegos.siicol.ejb.vo.siito;

public class RequisitoCPCritVO {
    private Long rcrCodigo;
    private String rcrNombre;
    private Integer rcrValor;
    
    public RequisitoCPCritVO() {    
    }


    public void setRcrCodigo(Long rcrCodigo) {
        this.rcrCodigo = rcrCodigo;
    }

    public Long getRcrCodigo() {
        return rcrCodigo;
    }

    public void setRcrNombre(String rcrNombre) {
        this.rcrNombre = rcrNombre;
    }

    public String getRcrNombre() {
        return rcrNombre;
    }

    public void setRcrValor(Integer rcrValor) {
        this.rcrValor = rcrValor;
    }

    public Integer getRcrValor() {
        return rcrValor;
    }
}
