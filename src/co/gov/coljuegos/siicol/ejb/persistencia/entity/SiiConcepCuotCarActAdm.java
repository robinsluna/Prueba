package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

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

@Entity
@Table(name = "SII_CONCEP_CUOT_CAR_ACT_ADM")
public class SiiConcepCuotCarActAdm implements Serializable {
    private static final long serialVersionUID = -6436632876776450923L;
    private String camActivo;
    private Long camCodigo;
    private BigDecimal camValor;
    private SiiCargaActuacionesAdm siiCargaActuacionesAdm;
    private SiiConceptoCuota siiConceptoCuota;
    private List<SiiEstablecConCuoCar> siiEstablecConCuoCarList;
    private SiiUsuario siiUsuarioConectado;
    private List<SiiConceptoProyeccionCar> siiConceptoProyeccionCarList;
    private List<SiiAjusteContCarAct> siiAjusteContCarActList;

    public SiiConcepCuotCarActAdm() {
    }

    public SiiConcepCuotCarActAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm, String camActivo, Long camCodigo, BigDecimal camValor, SiiConceptoCuota siiConceptoCuota, SiiUsuario siiUsuarioConectado) {
        this.siiCargaActuacionesAdm = siiCargaActuacionesAdm;
        this.camActivo = camActivo;
        this.camCodigo = camCodigo;
        this.camValor = camValor;
        this.siiConceptoCuota = siiConceptoCuota;
        this.siiUsuarioConectado = siiUsuarioConectado;
    }


    @Column(name = "CAM_ACTIVO", nullable = false, length = 1)
    public String getCamActivo() {
        return camActivo;
    }

    public void setCamActivo(String camActivo) {
        this.camActivo = camActivo;
    }
    
    @Id
    @Column(name = "CAM_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CONC_CUOT_CAR_AC_AD_COD")
    @SequenceGenerator(name = "SEQ_CONC_CUOT_CAR_AC_AD_COD", sequenceName = "SEQ_CONC_CUOT_CAR_AC_AD_COD",allocationSize=1)
    public Long getCamCodigo() {
        return camCodigo;
    }

    public void setCamCodigo(Long camCodigo) {
        this.camCodigo = camCodigo;
    }

    @Column(name = "CAM_VALOR", nullable = false)
    public BigDecimal getCamValor(){
        return camValor;
    }
    
    public void setCamValor(BigDecimal camValor){
        this.camValor = camValor;
    }

    @ManyToOne
    @JoinColumn(name = "CAA_CODIGO")
    public SiiCargaActuacionesAdm getSiiCargaActuacionesAdm() {
        return siiCargaActuacionesAdm;
    }

    public void setSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        this.siiCargaActuacionesAdm = siiCargaActuacionesAdm;
    }

    @ManyToOne
    @JoinColumn(name = "CCU_CODIGO")
    public SiiConceptoCuota getSiiConceptoCuota() {
        return siiConceptoCuota;
    }

    public void setSiiConceptoCuota(SiiConceptoCuota siiConceptoCuota) {
        this.siiConceptoCuota = siiConceptoCuota;
    }

    @OneToMany(mappedBy = "siiConcepCuotCarActAdm")
    public List<SiiEstablecConCuoCar> getSiiEstablecConCuoCarList() {
        return siiEstablecConCuoCarList;
    }

    public void setSiiEstablecConCuoCarList(List<SiiEstablecConCuoCar> siiEstablecConCuoCarList) {
        this.siiEstablecConCuoCarList = siiEstablecConCuoCarList;
    }

    public SiiEstablecConCuoCar addSiiEstablecConCuoCar(SiiEstablecConCuoCar siiEstablecConCuoCar) {
        getSiiEstablecConCuoCarList().add(siiEstablecConCuoCar);
        siiEstablecConCuoCar.setSiiConcepCuotCarActAdm(this);
        return siiEstablecConCuoCar;
    }

    public SiiEstablecConCuoCar removeSiiEstablecConCuoCar(SiiEstablecConCuoCar siiEstablecConCuoCar) {
        getSiiEstablecConCuoCarList().remove(siiEstablecConCuoCar);
        siiEstablecConCuoCar.setSiiConcepCuotCarActAdm(null);
        return siiEstablecConCuoCar;
    }

    @ManyToOne
    @JoinColumn(name = "USU_CODIGO_CONEC")
    public SiiUsuario getSiiUsuarioConectado() {
        return siiUsuarioConectado;
    }

    public void setSiiUsuarioConectado(SiiUsuario siiUsuarioConectado) {
        this.siiUsuarioConectado = siiUsuarioConectado;
    }

    @OneToMany(mappedBy = "siiConcepCuotCarActAdm")
    public List<SiiConceptoProyeccionCar> getSiiConceptoProyeccionCarList() {
        return siiConceptoProyeccionCarList;
    }

    public void setSiiConceptoProyeccionCarList(List<SiiConceptoProyeccionCar> siiConceptoProyeccionCarList) {
        this.siiConceptoProyeccionCarList = siiConceptoProyeccionCarList;
    }

    public SiiConceptoProyeccionCar addSiiConceptoProyeccionCar(SiiConceptoProyeccionCar siiConceptoProyeccionCar) {
        getSiiConceptoProyeccionCarList().add(siiConceptoProyeccionCar);
        siiConceptoProyeccionCar.setSiiConcepCuotCarActAdm(this);
        return siiConceptoProyeccionCar;
    }

    public SiiConceptoProyeccionCar removeSiiConceptoProyeccionCar(SiiConceptoProyeccionCar siiConceptoProyeccionCar) {
        getSiiConceptoProyeccionCarList().remove(siiConceptoProyeccionCar);
        siiConceptoProyeccionCar.setSiiConcepCuotCarActAdm(null);
        return siiConceptoProyeccionCar;
    }

    @OneToMany(mappedBy = "siiConcepCuotCarActAdm")
    public List<SiiAjusteContCarAct> getSiiAjusteContCarActList() {
        return siiAjusteContCarActList;
    }

    public void setSiiAjusteContCarActList(List<SiiAjusteContCarAct> siiAjusteContCarActList) {
        this.siiAjusteContCarActList = siiAjusteContCarActList;
    }

    public SiiAjusteContCarAct addSiiAjusteContCarAct(SiiAjusteContCarAct siiAjusteContCarAct) {
        getSiiAjusteContCarActList().add(siiAjusteContCarAct);
        siiAjusteContCarAct.setSiiConcepCuotCarActAdm(this);
        return siiAjusteContCarAct;
    }

    public SiiAjusteContCarAct removeSiiAjusteContCarAct(SiiAjusteContCarAct siiAjusteContCarAct) {
        getSiiAjusteContCarActList().remove(siiAjusteContCarAct);
        siiAjusteContCarAct.setSiiConcepCuotCarActAdm(null);
        return siiAjusteContCarAct;
    }
}
