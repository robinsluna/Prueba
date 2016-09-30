package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "SII_TERMINOS_PROCESALES")
public class SiiTerminosProcesales implements Serializable {
    private static final long serialVersionUID = -5522067114905498425L;
    private Long tprCodigo;
    private Integer tprDias;
    private String tprProceso;
    private String tprTipoDia;
    private SiiEstadoProcesoSanc siiEstadoProcesoSanc;
    private SiiEstadoProcSanIleg siiEstadoProcSanIleg;

    public SiiTerminosProcesales() {
    }

    public SiiTerminosProcesales(SiiEstadoProcSanIleg siiEstadoProcSanIleg, SiiEstadoProcesoSanc siiEstadoProcesoSanc, Long tprCodigo, Integer tprDias, String tprProceso, String tprTipoDia) {
        this.siiEstadoProcSanIleg = siiEstadoProcSanIleg;
        this.siiEstadoProcesoSanc = siiEstadoProcesoSanc;
        this.tprCodigo = tprCodigo;
        this.tprDias = tprDias;
        this.tprProceso = tprProceso;
        this.tprTipoDia = tprTipoDia;
    }


    @Id
    @Column(name = "TPR_CODIGO", nullable = false)
    public Long getTprCodigo() {
        return tprCodigo;
    }

    public void setTprCodigo(Long tprCodigo) {
        this.tprCodigo = tprCodigo;
    }

    @Column(name = "TPR_DIAS", nullable = false)
    public Integer getTprDias() {
        return tprDias;
    }

    public void setTprDias(Integer tprDias) {
        this.tprDias = tprDias;
    }

    @Column(name = "TPR_PROCESO", nullable = false, length = 1)
    public String getTprProceso() {
        return tprProceso;
    }

    public void setTprProceso(String tprProceso) {
        this.tprProceso = tprProceso;
    }

    @Column(name = "TPR_TIPO_DIA", nullable = false, length = 1)
    public String getTprTipoDia() {
        return tprTipoDia;
    }

    public void setTprTipoDia(String tprTipoDia) {
        this.tprTipoDia = tprTipoDia;
    }

    @ManyToOne
    @JoinColumn(name = "EPS_CODIGO")
    public SiiEstadoProcesoSanc getSiiEstadoProcesoSanc() {
        return siiEstadoProcesoSanc;
    }

    public void setSiiEstadoProcesoSanc(SiiEstadoProcesoSanc siiEstadoProcesoSanc) {
        this.siiEstadoProcesoSanc = siiEstadoProcesoSanc;
    }

    @ManyToOne
    @JoinColumn(name = "EPI_CODIGO")
    public SiiEstadoProcSanIleg getSiiEstadoProcSanIleg() {
        return siiEstadoProcSanIleg;
    }

    public void setSiiEstadoProcSanIleg(SiiEstadoProcSanIleg siiEstadoProcSanIleg) {
        this.siiEstadoProcSanIleg = siiEstadoProcSanIleg;
    }
}
