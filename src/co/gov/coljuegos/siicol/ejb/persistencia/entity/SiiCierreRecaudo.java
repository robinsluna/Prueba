package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_CIERRE_RECAUDO")
public class SiiCierreRecaudo implements Serializable {
    private static final long serialVersionUID = -2005865217443960364L;
    private Long cirCodigo;
    private Integer cirConsecutivo;
    private Date cirFechaCieCar;
    private Date cirFechaCieCont;
    private Date cirFechaCierre;
    private Integer cirVigencia;
    private Integer mesCodigo;
    private List<SiiDistribucionMes> siiDistribucionMesList;
    private SiiEstadoCierrreRec siiEstadoCierrreRec;

    public SiiCierreRecaudo() {
    }

    public SiiCierreRecaudo(Long cirCodigo, Integer cirVigencia, SiiEstadoCierrreRec siiEstadoCierrreRec,
                            Integer mesCodigo) {
        this.cirCodigo = cirCodigo;
        this.cirVigencia = cirVigencia;
        this.siiEstadoCierrreRec = siiEstadoCierrreRec;
        this.mesCodigo = mesCodigo;
    }

    @Id
    @Column(name = "CIR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CIERRE_RECAUDO_COD")
    @SequenceGenerator(name = "SEQ_CIERRE_RECAUDO_COD", sequenceName = "SEQ_CIERRE_RECAUDO_COD",allocationSize=1)
    public Long getCirCodigo() {
        return cirCodigo;
    }

    public void setCirCodigo(Long cirCodigo) {
        this.cirCodigo = cirCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CIR_FECHA_CIERRE")
    public Date getCirFechaCierre() {
        return cirFechaCierre;
    }

    public void setCirFechaCierre(Date cirFechaCierre) {
        this.cirFechaCierre = cirFechaCierre;
    }

    @Column(name = "CIR_VIGENCIA", nullable = false)
    public Integer getCirVigencia() {
        return cirVigencia;
    }

    public void setCirVigencia(Integer cirVigencia) {
        this.cirVigencia = cirVigencia;
    }


    @Column(name = "MES_CODIGO", nullable = false)
    public Integer getMesCodigo() {
        return mesCodigo;
    }

    public void setMesCodigo(Integer mesCodigo) {
        this.mesCodigo = mesCodigo;
    }

    @OneToMany(mappedBy = "siiCierreRecaudo")
    public List<SiiDistribucionMes> getSiiDistribucionMesList() {
        return siiDistribucionMesList;
    }

    public void setSiiDistribucionMesList(List<SiiDistribucionMes> siiDistribucionMesList) {
        this.siiDistribucionMesList = siiDistribucionMesList;
    }

    public SiiDistribucionMes addSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        getSiiDistribucionMesList().add(siiDistribucionMes);
        siiDistribucionMes.setSiiCierreRecaudo(this);
        return siiDistribucionMes;
    }

    public SiiDistribucionMes removeSiiDistribucionMes(SiiDistribucionMes siiDistribucionMes) {
        getSiiDistribucionMesList().remove(siiDistribucionMes);
        siiDistribucionMes.setSiiCierreRecaudo(null);
        return siiDistribucionMes;
    }

    @ManyToOne
    @JoinColumn(name = "ECR_CODIGO")
    public SiiEstadoCierrreRec getSiiEstadoCierrreRec() {
        return siiEstadoCierrreRec;
    }

    public void setSiiEstadoCierrreRec(SiiEstadoCierrreRec siiEstadoCierrreRec) {
        this.siiEstadoCierrreRec = siiEstadoCierrreRec;
    }

    @Column(name = "CIR_CONSECUTIVO")
    public Integer getCirConsecutivo() {
        return cirConsecutivo;
    }

    public void setCirConsecutivo(Integer cirConsecutivo) {
        this.cirConsecutivo = cirConsecutivo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CIR_FECHA_CIE_CAR")
    public Date getCirFechaCieCar() {
        return cirFechaCieCar;
    }

    public void setCirFechaCieCar(Date cirFechaCieCar) {
        this.cirFechaCieCar = cirFechaCieCar;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CIR_FECHA_CIE_CONT")
    public Date getCirFechaCieCont() {
        return cirFechaCieCont;
    }

    public void setCirFechaCieCont(Date cirFechaCieCont) {
        this.cirFechaCieCont = cirFechaCieCont;
    }
}
