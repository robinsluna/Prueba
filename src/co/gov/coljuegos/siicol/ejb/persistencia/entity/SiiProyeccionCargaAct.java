package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
@Table(name = "SII_PROYECCION_CARGA_ACT")
public class SiiProyeccionCargaAct implements Serializable {
    private static final long serialVersionUID = 296656645054476065L;
    private Long pycCodigo;
    private String pycEstado;
    private Date pycFechaLiq;
    private List<SiiConceptoProyeccionCar> siiConceptoProyeccionCarList;
    private SiiUsuario siiUsuarioConectado;
    private SiiCargaActuacionesAdm siiCargaActuacionesAdm;
    

    public SiiProyeccionCargaAct() {
    }

    public SiiProyeccionCargaAct(Long pycCodigo, String pycEstado, Date pycFechaLiq) {
        this.pycCodigo = pycCodigo;
        this.pycEstado = pycEstado;
        this.pycFechaLiq = pycFechaLiq;
    }

    @Id
    @Column(name = "PYC_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PROYECC_CARGA_ACT_COD")
    @SequenceGenerator(name = "SEQ_PROYECC_CARGA_ACT_COD", sequenceName = "SEQ_PROYECC_CARGA_ACT_COD",allocationSize=1)
    public Long getPycCodigo() {
    return pycCodigo;
    }

    public void setPycCodigo(Long pycCodigo) {
        this.pycCodigo = pycCodigo;
    }

    @Column(name = "PYC_ESTADO", nullable = false, length = 1)
    public String getPycEstado() {
        return pycEstado;
    }

    public void setPycEstado(String pycEstado) {
        this.pycEstado = pycEstado;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PYC_FECHA_LIQ", nullable = false)
    public Date getPycFechaLiq() {
        return pycFechaLiq;
    }

    public void setPycFechaLiq(Date pycFechaLiq) {
        this.pycFechaLiq = pycFechaLiq;
    }

    @OneToMany(mappedBy = "siiProyeccionCargaAct")
    public List<SiiConceptoProyeccionCar> getSiiConceptoProyeccionCarList() {
        return siiConceptoProyeccionCarList;
    }

    public void setSiiConceptoProyeccionCarList(List<SiiConceptoProyeccionCar> siiConceptoProyeccionCarList) {
        this.siiConceptoProyeccionCarList = siiConceptoProyeccionCarList;
    }

    public SiiConceptoProyeccionCar addSiiConceptoProyeccionCar(SiiConceptoProyeccionCar siiConceptoProyeccionCar) {
        getSiiConceptoProyeccionCarList().add(siiConceptoProyeccionCar);
        siiConceptoProyeccionCar.setSiiProyeccionCargaAct(this);
        return siiConceptoProyeccionCar;
    }

    public SiiConceptoProyeccionCar removeSiiConceptoProyeccionCar(SiiConceptoProyeccionCar siiConceptoProyeccionCar) {
        getSiiConceptoProyeccionCarList().remove(siiConceptoProyeccionCar);
        siiConceptoProyeccionCar.setSiiProyeccionCargaAct(null);
        return siiConceptoProyeccionCar;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConectado() {
        return siiUsuarioConectado;
    }

    public void setSiiUsuarioConectado(SiiUsuario siiUsuarioConectado) {
        this.siiUsuarioConectado = siiUsuarioConectado;
    }

    @ManyToOne
    @JoinColumn(name = "CAA_CODIGO")
    public SiiCargaActuacionesAdm getSiiCargaActuacionesAdm() {
        return siiCargaActuacionesAdm;
    }

    public void setSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        this.siiCargaActuacionesAdm = siiCargaActuacionesAdm;
    }

}
