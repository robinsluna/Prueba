package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_RECAUDO_PSE")
public class SiiRecaudoPse implements Serializable {
    private static final long serialVersionUID = 5988756932511046400L;
    private Long rpsCodigo;
    private String rpsCodigoTrans;
    private String rpsEstado;
    private Date rpsFechaEstado;
    private String rpsReferencia1;
    private List<SiiDetalleRecaudo> siiDetalleRecaudoList;

    public SiiRecaudoPse() {
    }

    public SiiRecaudoPse(Long rpsCodigo, String rpsCodigoTrans, Date rpsFechaEstado, String rpsReferencia1, String rpsEstado) {
        this.rpsCodigo = rpsCodigo;
        this.rpsCodigoTrans = rpsCodigoTrans;
        this.rpsEstado = rpsEstado;
        this.rpsFechaEstado = rpsFechaEstado;
        this.rpsReferencia1 = rpsReferencia1;
    }

    @Id
    @Column(name = "RPS_CODIGO", nullable = false)
    public Long getRpsCodigo() {
        return rpsCodigo;
    }

    public void setRpsCodigo(Long rpsCodigo) {
        this.rpsCodigo = rpsCodigo;
    }

    @Column(name = "RPS_CODIGO_TRANS", nullable = false, length = 50)
    public String getRpsCodigoTrans() {
        return rpsCodigoTrans;
    }

    public void setRpsCodigoTrans(String rpsCodigoTrans) {
        this.rpsCodigoTrans = rpsCodigoTrans;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RPS_FECHA_ESTADO", nullable = false)
    public Date getRpsFechaEstado() {
        return rpsFechaEstado;
    }

    public void setRpsFechaEstado(Date rpsFechaEstado) {
        this.rpsFechaEstado = rpsFechaEstado;
    }

    @Column(name = "RPS_REFERENCIA1", nullable = false, length = 150)
    public String getRpsReferencia1() {
        return rpsReferencia1;
    }

    public void setRpsReferencia1(String rpsReferencia1) {
        this.rpsReferencia1 = rpsReferencia1;
    }

    @OneToMany(mappedBy = "siiRecaudoPse")
    public List<SiiDetalleRecaudo> getSiiDetalleRecaudoList() {
        return siiDetalleRecaudoList;
    }

    public void setSiiDetalleRecaudoList(List<SiiDetalleRecaudo> siiDetalleRecaudoList) {
        this.siiDetalleRecaudoList = siiDetalleRecaudoList;
    }

    public SiiDetalleRecaudo addSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().add(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiRecaudoPse(this);
        return siiDetalleRecaudo;
    }

    public SiiDetalleRecaudo removeSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().remove(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiRecaudoPse(null);
        return siiDetalleRecaudo;
    }

    @Column(name = "RPS_ESTADO", nullable = false, length = 1)
    public String getRpsEstado() {
        return rpsEstado;
    }

    public void setRpsEstado(String rpsEstado) {
        this.rpsEstado = rpsEstado;
    }
}
