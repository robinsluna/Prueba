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
@Table(name = "SII_RECEPCION_ALEGATO_PRO_SAN")
public class SiiRecepcionAlegatoProSan implements Serializable {
    private static final long serialVersionUID = -3155763542715152279L;
    private Long ralCodigo;
    private Date ralFechaRad;
    private String ralPruebas;
    private String ralRadicado;
    private String ralSolicitaPru;
    private SiiUsuario siiUsuarioConec;
    private SiiProcesoSancionatorio siiProcesoSancionatorio;

    public SiiRecepcionAlegatoProSan() {
    }

    public SiiRecepcionAlegatoProSan(SiiProcesoSancionatorio siiProcesoSancionatorio, Long ralCodigo, Date ralFechaRad, String ralPruebas, String ralRadicado, String ralSolicitaPru,
                                     SiiUsuario siiUsuarioConec) {
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
        this.ralCodigo = ralCodigo;
        this.ralFechaRad = ralFechaRad;
        this.ralPruebas = ralPruebas;
        this.ralRadicado = ralRadicado;
        this.ralSolicitaPru = ralSolicitaPru;
        this.siiUsuarioConec = siiUsuarioConec;
    }


    @Id
    @Column(name = "RAL_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_RECEP_ALEGATO_PRO_SAN_COD")
    @SequenceGenerator(name = "SEQ_RECEP_ALEGATO_PRO_SAN_COD", sequenceName = "SEQ_RECEP_ALEGATO_PRO_SAN_COD",allocationSize=1)
    public Long getRalCodigo() {
        return ralCodigo;
    }

    public void setRalCodigo(Long ralCodigo) {
        this.ralCodigo = ralCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "RAL_FECHA_RAD", nullable = false)
    public Date getRalFechaRad() {
        return ralFechaRad;
    }

    public void setRalFechaRad(Date ralFechaRad) {
        this.ralFechaRad = ralFechaRad;
    }

    @Column(name = "RAL_PRUEBAS")
    public String getRalPruebas() {
        return ralPruebas;
    }

    public void setRalPruebas(String ralPruebas) {
        this.ralPruebas = ralPruebas;
    }

    @Column(name = "RAL_RADICADO", nullable = false, length = 30)
    public String getRalRadicado() {
        return ralRadicado;
    }

    public void setRalRadicado(String ralRadicado) {
        this.ralRadicado = ralRadicado;
    }

    @Column(name = "RAL_SOLICITA_PRU", nullable = false, length = 1)
    public String getRalSolicitaPru() {
        return ralSolicitaPru;
    }

    public void setRalSolicitaPru(String ralSolicitaPru) {
        this.ralSolicitaPru = ralSolicitaPru;
    }


    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CON")
    public SiiUsuario getSiiUsuarioConec() {
        return siiUsuarioConec;
    }

    public void setSiiUsuarioConec(SiiUsuario siiUsuarioConec) {
        this.siiUsuarioConec = siiUsuarioConec;
    }

    @ManyToOne
    @JoinColumn(name = "PSA_CODIGO")
    public SiiProcesoSancionatorio getSiiProcesoSancionatorio() {
        return siiProcesoSancionatorio;
    }

    public void setSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
    }
}
