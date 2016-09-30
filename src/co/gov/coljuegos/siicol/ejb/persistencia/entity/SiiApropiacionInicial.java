package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "SII_APROPIACION_INICIAL")
public class SiiApropiacionInicial implements Serializable {
    private static final long serialVersionUID = -8354565780074300394L;
    private String ainAutorizado;
    private String ainCerrado;
    private Long ainCodigo;
    private String ainElaborado;
    private Date ainFechaAcuerdoJunta;
    private Date ainFechaAutorizacion;
    private Date ainFechaCierre;
    private Date ainFechaDecreto;
    private Date ainFechaElaboracion;
    private Date ainFechaOficioDesagregacion;
    private String ainNumOficioDesagregacion;
    private String ainNumeroAcuerdoJunta;
    private String ainNumeroDecreto;
    private Integer ainVigencia;
    private SiiUsuario siiUsuario1; //Usuario autorización
    private SiiUsuario siiUsuario3; //Usuario Elaboración
    private SiiUsuario siiUsuario4; //Usuario Cierre
    private SiiArchivoFisico siiArchivoFisico;

    public SiiApropiacionInicial() {
    }

    public SiiApropiacionInicial(String ainAutorizado, String ainCerrado, Long ainCodigo, String ainElaborado,
                                 Date ainFechaAcuerdoJunta, Date ainFechaAutorizacion, Date ainFechaCierre,
                                 Date ainFechaDecreto, Date ainFechaElaboracion, Date ainFechaOficioDesagregacion,
                                 String ainNumOficioDesagregacion, String ainNumeroAcuerdoJunta,
                                 String ainNumeroDecreto, Integer ainVigencia, SiiUsuario siiUsuario1,
                                 SiiUsuario siiUsuario4, SiiUsuario siiUsuario3, SiiArchivoFisico siiArchivoFisico) {
        this.ainAutorizado = ainAutorizado;
        this.ainCerrado = ainCerrado;
        this.ainCodigo = ainCodigo;
        this.ainElaborado = ainElaborado;
        this.ainFechaAcuerdoJunta = ainFechaAcuerdoJunta;
        this.ainFechaAutorizacion = ainFechaAutorizacion;
        this.ainFechaCierre = ainFechaCierre;
        this.ainFechaDecreto = ainFechaDecreto;
        this.ainFechaElaboracion = ainFechaElaboracion;
        this.ainFechaOficioDesagregacion = ainFechaOficioDesagregacion;
        this.ainNumOficioDesagregacion = ainNumOficioDesagregacion;
        this.ainNumeroAcuerdoJunta = ainNumeroAcuerdoJunta;
        this.ainNumeroDecreto = ainNumeroDecreto;
        this.ainVigencia = ainVigencia;
        this.siiUsuario1 = siiUsuario1;
        this.siiUsuario4 = siiUsuario4;
        this.siiUsuario3 = siiUsuario3;
        this.siiArchivoFisico = siiArchivoFisico;
    }

    @Column(name = "AIN_AUTORIZADO", length = 1)
    public String getAinAutorizado() {
        return ainAutorizado;
    }

    public void setAinAutorizado(String ainAutorizado) {
        this.ainAutorizado = ainAutorizado;
    }

    @Column(name = "AIN_CERRADO", length = 1)
    public String getAinCerrado() {
        return ainCerrado;
    }

    public void setAinCerrado(String ainCerrado) {
        this.ainCerrado = ainCerrado;
    }

    @Id
    @Column(name = "AIN_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_APROPIACION_INICIAL_CODIG")
    @SequenceGenerator(name = "SEQ_APROPIACION_INICIAL_CODIG", sequenceName = "SEQ_APROPIACION_INICIAL_CODIG",allocationSize=1)
    public Long getAinCodigo() {
        return ainCodigo;
    }

    public void setAinCodigo(Long ainCodigo) {
        this.ainCodigo = ainCodigo;
    }

    @Column(name = "AIN_ELABORADO", length = 1)
    public String getAinElaborado() {
        return ainElaborado;
    }

    public void setAinElaborado(String ainElaborado) {
        this.ainElaborado = ainElaborado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AIN_FECHA_ACUERDO_JUNTA", nullable = false)
    public Date getAinFechaAcuerdoJunta() {
        return ainFechaAcuerdoJunta;
    }

    public void setAinFechaAcuerdoJunta(Date ainFechaAcuerdoJunta) {
        this.ainFechaAcuerdoJunta = ainFechaAcuerdoJunta;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AIN_FECHA_AUTORIZACION")
    public Date getAinFechaAutorizacion() {
        return ainFechaAutorizacion;
    }

    public void setAinFechaAutorizacion(Date ainFechaAutorizacion) {
        this.ainFechaAutorizacion = ainFechaAutorizacion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AIN_FECHA_CIERRE")
    public Date getAinFechaCierre() {
        return ainFechaCierre;
    }

    public void setAinFechaCierre(Date ainFechaCierre) {
        this.ainFechaCierre = ainFechaCierre;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AIN_FECHA_DECRETO", nullable = false)
    public Date getAinFechaDecreto() {
        return ainFechaDecreto;
    }

    public void setAinFechaDecreto(Date ainFechaDecreto) {
        this.ainFechaDecreto = ainFechaDecreto;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AIN_FECHA_ELABORACION")
    public Date getAinFechaElaboracion() {
        return ainFechaElaboracion;
    }

    public void setAinFechaElaboracion(Date ainFechaElaboracion) {
        this.ainFechaElaboracion = ainFechaElaboracion;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "AIN_FECHA_OFICIO_DESAGREGACION", nullable = false)
    public Date getAinFechaOficioDesagregacion() {
        return ainFechaOficioDesagregacion;
    }

    public void setAinFechaOficioDesagregacion(Date ainFechaOficioDesagregacion) {
        this.ainFechaOficioDesagregacion = ainFechaOficioDesagregacion;
    }

    @Column(name = "AIN_NUM_OFICIO_DESAGREGACION", nullable = false, length = 20)
    public String getAinNumOficioDesagregacion() {
        return ainNumOficioDesagregacion;
    }

    public void setAinNumOficioDesagregacion(String ainNumOficioDesagregacion) {
        this.ainNumOficioDesagregacion = ainNumOficioDesagregacion;
    }

    @Column(name = "AIN_NUMERO_ACUERDO_JUNTA", nullable = false, length = 20)
    public String getAinNumeroAcuerdoJunta() {
        return ainNumeroAcuerdoJunta;
    }

    public void setAinNumeroAcuerdoJunta(String ainNumeroAcuerdoJunta) {
        this.ainNumeroAcuerdoJunta = ainNumeroAcuerdoJunta;
    }

    @Column(name = "AIN_NUMERO_DECRETO", nullable = false, length = 20)
    public String getAinNumeroDecreto() {
        return ainNumeroDecreto;
    }

    public void setAinNumeroDecreto(String ainNumeroDecreto) {
        this.ainNumeroDecreto = ainNumeroDecreto;
    }

    @Column(name = "AIN_VIGENCIA", nullable = false)
    public Integer getAinVigencia() {
        return ainVigencia;
    }

    public void setAinVigencia(Integer ainVigencia) {
        this.ainVigencia = ainVigencia;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_AUTORIZACION")
    public SiiUsuario getSiiUsuario1() {
        return siiUsuario1;
    }

    public void setSiiUsuario1(SiiUsuario siiUsuario1) {
        this.siiUsuario1 = siiUsuario1;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_ELABORACION")
    public SiiUsuario getSiiUsuario3() {
        return siiUsuario3;
    }

    public void setSiiUsuario3(SiiUsuario siiUsuario3) {
        this.siiUsuario3 = siiUsuario3;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CIERRE")
    public SiiUsuario getSiiUsuario4() {
        return siiUsuario4;
    }

    public void setSiiUsuario4(SiiUsuario siiUsuario4) {
        this.siiUsuario4 = siiUsuario4;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico() {
        return siiArchivoFisico;
    }

    public void setSiiArchivoFisico(SiiArchivoFisico siiArchivoFisico) {
        this.siiArchivoFisico = siiArchivoFisico;
    }
}
