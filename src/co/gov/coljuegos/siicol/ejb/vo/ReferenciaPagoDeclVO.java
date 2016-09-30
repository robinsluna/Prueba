package co.gov.coljuegos.siicol.ejb.vo;

public class ReferenciaPagoDeclVO {
    private Long rpdNumero;
    private Long rpdCodigo;
    
    public ReferenciaPagoDeclVO() {
       
    }


    public void setRpdNumero(Long rpdNumero) {
        this.rpdNumero = rpdNumero;
    }

    public Long getRpdNumero() {
        return rpdNumero;
    }

    public void setRpdCodigo(Long rpdCodigo) {
        this.rpdCodigo = rpdCodigo;
    }

    public Long getRpdCodigo() {
        return rpdCodigo;
    }

}
