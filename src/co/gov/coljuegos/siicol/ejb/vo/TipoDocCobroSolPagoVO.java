package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSopSolicPago;

public class TipoDocCobroSolPagoVO {
    
    private Long tspCodigo;
    private String tspCombre;
    
    public TipoDocCobroSolPagoVO( ) {
    
    }
    
    public TipoDocCobroSolPagoVO(SiiTipoDocSopSolicPago siiTipoDocSopSolicPago) {
       this.tspCodigo=siiTipoDocSopSolicPago.getTspCodigo();
       this.tspCombre=siiTipoDocSopSolicPago.getTspCombre();
    }


    public void setTspCodigo(Long tspCodigo) {
        this.tspCodigo = tspCodigo;
    }

    public Long getTspCodigo() {
        return tspCodigo;
    }

    public void setTspCombre(String tspCombre) {
        this.tspCombre = tspCombre;
    }

    public String getTspCombre() {
        return tspCombre;
    }

}
