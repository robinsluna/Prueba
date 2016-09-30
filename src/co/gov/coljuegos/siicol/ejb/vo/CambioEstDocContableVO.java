package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDocContab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import java.util.Date;

/**
 * Value Object para el Documento Contable.
 * @author Camilo Miranda
 */
public class CambioEstDocContableVO 
{
    private Long dcoCodigo;
    private Date dcoFechaOper;
    private Integer dcoNumeroCompr;

    private String estadoDocContabVo;
    private String tipoDocContableVo;
    

    /**
     * Constructor.
     */
    public CambioEstDocContableVO() { }
    
    /**
     * Constructor.
     * @param siiDocumentoContable
     */
    public CambioEstDocContableVO (CambioEstDocContableVO siiDocumentoContable) {
        if (siiDocumentoContable!=null) {
            this.dcoCodigo = siiDocumentoContable.getDcoCodigo();
            this.dcoFechaOper = siiDocumentoContable.getDcoFechaOper();
            this.dcoNumeroCompr = siiDocumentoContable.getDcoNumeroCompr();
            this.estadoDocContabVo = siiDocumentoContable.getEstadoDocContabVo();
            this.tipoDocContableVo = siiDocumentoContable.getTipoDocContableVo();
            
        }
    }

    public void setDcoCodigo(Long dcoCodigo) {
        this.dcoCodigo = dcoCodigo;
    }

    public Long getDcoCodigo() {
        return dcoCodigo;
    }

    public void setDcoFechaOper(Date dcoFechaOper) {
        this.dcoFechaOper = dcoFechaOper;
    }

    public Date getDcoFechaOper() {
        return dcoFechaOper;
    }

    public void setDcoNumeroCompr(Integer dcoNumeroCompr) {
        this.dcoNumeroCompr = dcoNumeroCompr;
    }

    public Integer getDcoNumeroCompr() {
        return dcoNumeroCompr;
    }

    public void setEstadoDocContabVo(String estadoDocContabVo) {
        this.estadoDocContabVo = estadoDocContabVo;
    }

    public String getEstadoDocContabVo() {
        return estadoDocContabVo;
    }

    public void setTipoDocContableVo(String tipoDocContableVo) {
        this.tipoDocContableVo = tipoDocContableVo;
    }

    public String getTipoDocContableVo() {
        return tipoDocContableVo;
    }
}
