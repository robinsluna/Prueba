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
@Table(name = "SII_MODIFIC_PRESUP")
public class SiiModificPresup implements Serializable {
    private static final long serialVersionUID = -5805867067853886457L;
    private Long mprCodigo;
    private Date mprFecha;
    private Date mprFechaAcuerdoJunta;
    private Date mprFechaDecreto;
    private Date mprFechaOficioDesagregacion;
    private String mprNumeroAcuerdoJunta;
    private String mprNumeroDecreto;
    private String mprNumOficioDesagregacion;
    private String mprTipo;
    private Integer mprVigencia;
    private SiiEstadoModifPresup siiEstadoModifPresup;
    private List<SiiModPresDetRubro> siiModPresDetRubroList2;
    private Long mprConsecutivo;
    private SiiUsuario siiUsuarioConec;

    public SiiModificPresup() {
    }

    public SiiModificPresup(SiiEstadoModifPresup siiEstadoModifPresup, Long mprCodigo, Date mprFecha, String mprTipo,
                            Integer mprVigencia) {
        this.siiEstadoModifPresup = siiEstadoModifPresup;
        this.mprCodigo = mprCodigo;
        this.mprFecha = mprFecha;
        this.mprTipo = mprTipo;
        this.mprVigencia = mprVigencia;
    }


    @Id
    @Column(name = "MPR_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_MODIFIC_PRESUP_COD")
    @SequenceGenerator(name = "SEQ_MODIFIC_PRESUP_COD", sequenceName = "SEQ_MODIFIC_PRESUP_COD",allocationSize=1)
    public Long getMprCodigo() {
        return mprCodigo;
    }

    public void setMprCodigo(Long mprCodigo) {
        this.mprCodigo = mprCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MPR_FECHA", nullable = false)
    public Date getMprFecha() {
        return mprFecha;
    }

    public void setMprFecha(Date mprFecha) {
        this.mprFecha = mprFecha;
    }

    @Column(name = "MPR_TIPO", nullable = false, length = 1)
    public String getMprTipo() {
        return mprTipo;
    }

    public void setMprTipo(String mprTipo) {
        this.mprTipo = mprTipo;
    }

    @Column(name = "MPR_VIGENCIA", nullable = false)
    public Integer getMprVigencia() {
        return mprVigencia;
    }

    public void setMprVigencia(Integer mprVigencia) {
        this.mprVigencia = mprVigencia;
    }

    @ManyToOne
    @JoinColumn(name = "EMP_CODIGO")
    public SiiEstadoModifPresup getSiiEstadoModifPresup() {
        return siiEstadoModifPresup;
    }

    public void setSiiEstadoModifPresup(SiiEstadoModifPresup siiEstadoModifPresup) {
        this.siiEstadoModifPresup = siiEstadoModifPresup;
    }

    @OneToMany(mappedBy = "siiModificPresup")
    public List<SiiModPresDetRubro> getSiiModPresDetRubroList2() {
        return siiModPresDetRubroList2;
    }

    public void setSiiModPresDetRubroList2(List<SiiModPresDetRubro> siiModPresDetRubroList2) {
        this.siiModPresDetRubroList2 = siiModPresDetRubroList2;
    }

    public SiiModPresDetRubro addSiiModPresDetRubro(SiiModPresDetRubro siiModPresDetRubro) {
        getSiiModPresDetRubroList2().add(siiModPresDetRubro);
        siiModPresDetRubro.setSiiModificPresup(this);
        return siiModPresDetRubro;
    }

    public SiiModPresDetRubro removeSiiModPresDetRubro(SiiModPresDetRubro siiModPresDetRubro) {
        getSiiModPresDetRubroList2().remove(siiModPresDetRubro);
        siiModPresDetRubro.setSiiModificPresup(null);
        return siiModPresDetRubro;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MPR_FECHA_ACUERDO_JUNTA")
    public Date getMprFechaAcuerdoJunta() {
        return mprFechaAcuerdoJunta;
    }

    public void setMprFechaAcuerdoJunta(Date mprFechaAcuerdoJunta) {
        this.mprFechaAcuerdoJunta = mprFechaAcuerdoJunta;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MPR_FECHA_DECRETO")
    public Date getMprFechaDecreto() {
        return mprFechaDecreto;
    }

    public void setMprFechaDecreto(Date mprFechaDecreto) {
        this.mprFechaDecreto = mprFechaDecreto;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "MPR_FECHA_OFICIO_DESAGREGACION")
    public Date getMprFechaOficioDesagregacion() {
        return mprFechaOficioDesagregacion;
    }

    public void setMprFechaOficioDesagregacion(Date mprFechaOficioDesagregacion) {
        this.mprFechaOficioDesagregacion = mprFechaOficioDesagregacion;
    }

    @Column(name = "MPR_NUMERO_ACUERDO_JUNTA", length = 20)
    public String getMprNumeroAcuerdoJunta() {
        return mprNumeroAcuerdoJunta;
    }

    public void setMprNumeroAcuerdoJunta(String mprNumeroAcuerdoJunta) {
        this.mprNumeroAcuerdoJunta = mprNumeroAcuerdoJunta;
    }

    @Column(name = "MPR_NUMERO_DECRETO", length = 20)
    public String getMprNumeroDecreto() {
        return mprNumeroDecreto;
    }

    public void setMprNumeroDecreto(String mprNumeroDecreto) {
        this.mprNumeroDecreto = mprNumeroDecreto;
    }

    @Column(name = "MPR_NUM_OFICIO_DESAGREGACION", length = 20)
    public String getMprNumOficioDesagregacion() {
        return mprNumOficioDesagregacion;
    }

    public void setMprNumOficioDesagregacion(String mprNumOficioDesagregacion) {
        this.mprNumOficioDesagregacion = mprNumOficioDesagregacion;
    }

    @Column(name = "MPR_CONSECUTIVO")
    public Long getMprConsecutivo() {
        return mprConsecutivo;
    }

    public void setMprConsecutivo(Long mprConsecutivo) {
        this.mprConsecutivo = mprConsecutivo;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }
}
