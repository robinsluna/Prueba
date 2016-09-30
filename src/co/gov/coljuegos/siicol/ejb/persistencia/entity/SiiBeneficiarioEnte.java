package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "SII_BENEFICIARIO_ENTE")
public class SiiBeneficiarioEnte implements Serializable {
    private static final long serialVersionUID = 6945201275200033680L;
    private String benActivo;
    private Long benCodigo;
    private Date benFecha;
    private SiiPersona siiPersona;
    private SiiEnteTerritorial siiEnteTerritorial;
    private Integer benVigencia;
    private SiiMes siiMes;
    private Date benFechaFinAct;
    private Date benFechaIniAct;

    public SiiBeneficiarioEnte() {
    }

    public SiiBeneficiarioEnte(String benActivo, Long benCodigo, Date benFecha, SiiEnteTerritorial siiEnteTerritorial,
                               SiiPersona siiPersona) {
        this.benActivo = benActivo;
        this.benCodigo = benCodigo;
        this.benFecha = benFecha;
        this.siiEnteTerritorial = siiEnteTerritorial;
        this.siiPersona = siiPersona;
    }

    @Column(name = "BEN_ACTIVO", nullable = false, length = 1)
    public String getBenActivo() {
        return benActivo;
    }

    public void setBenActivo(String benActivo) {
        this.benActivo = benActivo;
    }

    @Id
    @Column(name = "BEN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_BENEFICIARIO_ENTE_COD")
    @SequenceGenerator(name = "SEQ_BENEFICIARIO_ENTE_COD", sequenceName = "SEQ_BENEFICIARIO_ENTE_COD",allocationSize=1)
    public Long getBenCodigo() {
        return benCodigo;
    }

    public void setBenCodigo(Long benCodigo) {
        this.benCodigo = benCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BEN_FECHA", nullable = false)
    public Date getBenFecha() {
        return benFecha;
    }

    public void setBenFecha(Date benFecha) {
        this.benFecha = benFecha;
    }


    @ManyToOne
    @JoinColumn(name = "PER_CODIGO")
    public SiiPersona getSiiPersona() {
        return siiPersona;
    }

    public void setSiiPersona(SiiPersona siiPersona) {
        this.siiPersona = siiPersona;
    }

    @ManyToOne
    @JoinColumn(name = "ETI_CODIGO")
    public SiiEnteTerritorial getSiiEnteTerritorial() {
        return siiEnteTerritorial;
    }

    public void setSiiEnteTerritorial(SiiEnteTerritorial siiEnteTerritorial) {
        this.siiEnteTerritorial = siiEnteTerritorial;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BEN_FECHA_FIN_ACT")
    public Date getBenFechaFinAct() {
        return benFechaFinAct;
    }

    public void setBenFechaFinAct(Date benFechaFinAct) {
        this.benFechaFinAct = benFechaFinAct;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "BEN_FECHA_INI_ACT")
    public Date getBenFechaIniAct() {
        return benFechaIniAct;
    }

    public void setBenFechaIniAct(Date benFechaIniAct) {
        this.benFechaIniAct = benFechaIniAct;
    }

    @Column(name = "BEN_VIGENCIA")
    public Integer getBenVigencia() {
        return benVigencia;
    }

    public void setBenVigencia(Integer benVigencia) {
        this.benVigencia = benVigencia;
    }

    @ManyToOne
    @JoinColumn(name = "MES_CODIGO")
    public SiiMes getSiiMes() {
        return siiMes;
    }

    public void setSiiMes(SiiMes siiMes) {
        this.siiMes = siiMes;
    }
}
