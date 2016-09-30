package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import java.util.List;

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
@Table(name = "SII_CUOTA_OPERADOR")
public class SiiCuotaOperador implements Serializable {
    private static final long serialVersionUID = -4598396494943236161L;
    private String copCancelada;
    private Long copCodigo;
    private Date copFechaLimPag;
    private Integer copNumCuota;
    private String copTipoCartera;
    private String copTipoDocSopor;
    private BigDecimal copValor;
    private Integer copVigencia;
    private Integer mesCodigo;
    private List<SiiDetalleDeclaracion> siiDetalleDeclaracionList;
    private SiiOperador siiOperador;
    private SiiConceptoCuota siiConceptoCuota;
    private SiiLiquidacionMes siiLiquidacionMes;
    private List<SiiInteresCuota> siiInteresCuotaList;
    private SiiAcuerdoPago siiAcuerdoPago;
    private List<SiiAjusteCuota> siiAjusteCuotaList;
    private SiiAmpliacionTemporal siiAmpliacionTemporal;
    private List<SiiDetalleDeclaracionSug> siiDetalleDeclaracionSugList;
    private SiiRifaPromocional siiRifaPromocional;
    private BigDecimal copAbonoIni;
    private BigDecimal copAbonoIniInt;
    private BigDecimal copValorIncApa;
    private BigDecimal copValorIncIntApa;
    private List<SiiCuotaOpeCuotaAcuerdo> siiCuotaOpeCuotaAcuerdoAcuerdoList;
    private List<SiiCuotaOpeCuotaAcuerdo> siiCuotaOpeCuotaAcuerdoCuotaList;
    private List<SiiResumenNoConectado> siiResumenNoConectadoList;
    private List<SiiCuotaOmisProcSanc> siiCuotaOmisProcSancList;
    private List<SiiCuotaInexacProcSanc> siiCuotaInexacProcSancList;
    private SiiIncumplimientoContr siiIncumplimientoContr;
    private SiiCargaActuacionesAdm siiCargaActuacionesAdm;
    private List<SiiActualizacCuotaOpe> siiActualizacCuotaOpeList;
    private List<SiiCuotaInexacProcSanc> siiCuotaInexacProcSancGAList;
    private SiiProcesoSancionatorio siiProcesoSancionatorio;
    private SiiProcesoSancIlegalidad siiProcesoSancIlegalidad;

    public SiiCuotaOperador() {
    }

    public SiiCuotaOperador(SiiConceptoCuota siiConceptoCuota, String copCancelada, Long copCodigo, Date copFechaLimPag,
                            Integer copNumCuota, String copTipoDocSopor, BigDecimal copValor, Integer copVigencia,
                            SiiLiquidacionMes siiLiquidacionMes, Integer mesCodigo,
                            SiiOperador siiOperador, String copTipoCartera) {
        this.siiConceptoCuota = siiConceptoCuota;
        this.copCancelada = copCancelada;
        this.copCodigo = copCodigo;
        this.copFechaLimPag = copFechaLimPag;
        this.copNumCuota = copNumCuota;
        this.copTipoCartera = copTipoCartera;
        this.copTipoDocSopor = copTipoDocSopor;
        this.copValor = copValor;
        this.copVigencia = copVigencia;
        this.siiLiquidacionMes = siiLiquidacionMes;
        this.mesCodigo = mesCodigo;
        this.siiOperador = siiOperador;
    }


    @Column(name = "COP_CANCELADA", nullable = false, length = 1)
    public String getCopCancelada() {
        return copCancelada;
    }

    public void setCopCancelada(String copCancelada) {
        this.copCancelada = copCancelada;
    }

    @Id
    @Column(name = "COP_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CUOTA_OPERADOR_COD")
    @SequenceGenerator(name = "SEQ_CUOTA_OPERADOR_COD", sequenceName = "SEQ_CUOTA_OPERADOR_COD",allocationSize=1)
    public Long getCopCodigo() {
        return copCodigo;
    }

    public void setCopCodigo(Long copCodigo) {
        this.copCodigo = copCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "COP_FECHA_LIM_PAG", nullable = false)
    public Date getCopFechaLimPag() {
        return copFechaLimPag;
    }

    public void setCopFechaLimPag(Date copFechaLimPag) {
        this.copFechaLimPag = copFechaLimPag;
    }

    @Column(name = "COP_NUM_CUOTA", nullable = false)
    public Integer getCopNumCuota() {
        return copNumCuota;
    }

    public void setCopNumCuota(Integer copNumCuota) {
        this.copNumCuota = copNumCuota;
    }

    @Column(name = "COP_TIPO_CARTERA", length = 1)
    public String getCopTipoCartera() {
        return copTipoCartera;
    }

    public void setCopTipoCartera(String copTipoCartera) {
        this.copTipoCartera = copTipoCartera;
    }

    @Column(name = "COP_TIPO_DOC_SOPOR", nullable = false, length = 2)
    public String getCopTipoDocSopor() {
        return copTipoDocSopor;
    }

    public void setCopTipoDocSopor(String copTipoDocSopor) {
        this.copTipoDocSopor = copTipoDocSopor;
    }

    @Column(name = "COP_VALOR", nullable = false)
    public BigDecimal getCopValor() {
        return copValor;
    }

    public void setCopValor(BigDecimal copValor) {
        this.copValor = copValor;
    }

    @Column(name = "COP_VIGENCIA", nullable = false)
    public Integer getCopVigencia() {
        return copVigencia;
    }

    public void setCopVigencia(Integer copVigencia) {
        this.copVigencia = copVigencia;
    }


    @Column(name = "MES_CODIGO", nullable = false)
    public Integer getMesCodigo() {
        return mesCodigo;
    }

    public void setMesCodigo(Integer mesCodigo) {
        this.mesCodigo = mesCodigo;
    }


    @OneToMany(mappedBy = "siiCuotaOperador")
    public List<SiiDetalleDeclaracion> getSiiDetalleDeclaracionList() {
        return siiDetalleDeclaracionList;
    }

    public void setSiiDetalleDeclaracionList(List<SiiDetalleDeclaracion> siiDetalleDeclaracionList) {
        this.siiDetalleDeclaracionList = siiDetalleDeclaracionList;
    }

    public SiiDetalleDeclaracion addSiiDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) {
        getSiiDetalleDeclaracionList().add(siiDetalleDeclaracion);
        siiDetalleDeclaracion.setSiiCuotaOperador(this);
        return siiDetalleDeclaracion;
    }

    public SiiDetalleDeclaracion removeSiiDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) {
        getSiiDetalleDeclaracionList().remove(siiDetalleDeclaracion);
        siiDetalleDeclaracion.setSiiCuotaOperador(null);
        return siiDetalleDeclaracion;
    }

    @ManyToOne
    @JoinColumn(name = "OPE_CODIGO")
    public SiiOperador getSiiOperador() {
        return siiOperador;
    }

    public void setSiiOperador(SiiOperador siiOperador) {
        this.siiOperador = siiOperador;
    }

    @ManyToOne
    @JoinColumn(name = "CCU_CODIGO")
    public SiiConceptoCuota getSiiConceptoCuota() {
        return siiConceptoCuota;
    }

    public void setSiiConceptoCuota(SiiConceptoCuota siiConceptoCuota) {
        this.siiConceptoCuota = siiConceptoCuota;
    }

    @ManyToOne
    @JoinColumn(name = "LME_CODIGO")
    public SiiLiquidacionMes getSiiLiquidacionMes() {
        return siiLiquidacionMes;
    }

    public void setSiiLiquidacionMes(SiiLiquidacionMes siiLiquidacionMes) {
        this.siiLiquidacionMes = siiLiquidacionMes;
    }

    @OneToMany(mappedBy = "siiCuotaOperador")
    public List<SiiInteresCuota> getSiiInteresCuotaList() {
        return siiInteresCuotaList;
    }

    public void setSiiInteresCuotaList(List<SiiInteresCuota> siiInteresCuotaList) {
        this.siiInteresCuotaList = siiInteresCuotaList;
    }

    public SiiInteresCuota addSiiInteresCuota(SiiInteresCuota siiInteresCuota) {
        getSiiInteresCuotaList().add(siiInteresCuota);
        siiInteresCuota.setSiiCuotaOperador(this);
        return siiInteresCuota;
    }

    public SiiInteresCuota removeSiiInteresCuota(SiiInteresCuota siiInteresCuota) {
        getSiiInteresCuotaList().remove(siiInteresCuota);
        siiInteresCuota.setSiiCuotaOperador(null);
        return siiInteresCuota;
    }

    @ManyToOne
    @JoinColumn(name = "APA_CODIGO")
    public SiiAcuerdoPago getSiiAcuerdoPago() {
        return siiAcuerdoPago;
    }

    public void setSiiAcuerdoPago(SiiAcuerdoPago siiAcuerdoPago) {
        this.siiAcuerdoPago = siiAcuerdoPago;
    }

    @OneToMany(mappedBy = "siiCuotaOperador")
    public List<SiiAjusteCuota> getSiiAjusteCuotaList() {
        return siiAjusteCuotaList;
    }

    public void setSiiAjusteCuotaList(List<SiiAjusteCuota> siiAjusteCuotaList) {
        this.siiAjusteCuotaList = siiAjusteCuotaList;
    }

    public SiiAjusteCuota addSiiAjusteCuota(SiiAjusteCuota siiAjusteCuota) {
        getSiiAjusteCuotaList().add(siiAjusteCuota);
        siiAjusteCuota.setSiiCuotaOperador(this);
        return siiAjusteCuota;
    }

    public SiiAjusteCuota removeSiiAjusteCuota(SiiAjusteCuota siiAjusteCuota) {
        getSiiAjusteCuotaList().remove(siiAjusteCuota);
        siiAjusteCuota.setSiiCuotaOperador(null);
        return siiAjusteCuota;
    }

    @ManyToOne
    @JoinColumn(name = "ATE_CODIGO")
    public SiiAmpliacionTemporal getSiiAmpliacionTemporal() {
        return siiAmpliacionTemporal;
    }

    public void setSiiAmpliacionTemporal(SiiAmpliacionTemporal siiAmpliacionTemporal) {
        this.siiAmpliacionTemporal = siiAmpliacionTemporal;
    }

    @OneToMany(mappedBy = "siiCuotaOperador")
    public List<SiiDetalleDeclaracionSug> getSiiDetalleDeclaracionSugList() {
        return siiDetalleDeclaracionSugList;
    }

    public void setSiiDetalleDeclaracionSugList(List<SiiDetalleDeclaracionSug> siiDetalleDeclaracionSugList) {
        this.siiDetalleDeclaracionSugList = siiDetalleDeclaracionSugList;
    }

    public SiiDetalleDeclaracionSug addSiiDetalleDeclaracionSug(SiiDetalleDeclaracionSug siiDetalleDeclaracionSug) {
        getSiiDetalleDeclaracionSugList().add(siiDetalleDeclaracionSug);
        siiDetalleDeclaracionSug.setSiiCuotaOperador(this);
        return siiDetalleDeclaracionSug;
    }

    public SiiDetalleDeclaracionSug removeSiiDetalleDeclaracionSug(SiiDetalleDeclaracionSug siiDetalleDeclaracionSug) {
        getSiiDetalleDeclaracionSugList().remove(siiDetalleDeclaracionSug);
        siiDetalleDeclaracionSug.setSiiCuotaOperador(null);
        return siiDetalleDeclaracionSug;
    }

    @ManyToOne
    @JoinColumn(name = "RFP_CODIGO")
    public SiiRifaPromocional getSiiRifaPromocional() {
        return siiRifaPromocional;
    }

    public void setSiiRifaPromocional(SiiRifaPromocional siiRifaPromocional) {
        this.siiRifaPromocional = siiRifaPromocional;
    }

    @Column(name = "COP_ABONO_INI")
    public BigDecimal getCopAbonoIni() {
        return copAbonoIni;
    }

    public void setCopAbonoIni(BigDecimal copAbonoIni) {
        this.copAbonoIni = copAbonoIni;
    }

    @Column(name = "COP_ABONO_INI_INT")
    public BigDecimal getCopAbonoIniInt() {
        return copAbonoIniInt;
    }

    public void setCopAbonoIniInt(BigDecimal copAbonoIniInt) {
        this.copAbonoIniInt = copAbonoIniInt;
    }

    @Column(name = "COP_VALOR_INC_APA", length = 20)
    public BigDecimal getCopValorIncApa() {
        return copValorIncApa;
    }

    public void setCopValorIncApa(BigDecimal copValorIncApa) {
        this.copValorIncApa = copValorIncApa;
    }

    @Column(name = "COP_VALOR_INC_INT_APA", length = 20)
    public BigDecimal getCopValorIncIntApa() {
        return copValorIncIntApa;
    }

    public void setCopValorIncIntApa(BigDecimal copValorIncIntApa) {
        this.copValorIncIntApa = copValorIncIntApa;
    }

    @OneToMany(mappedBy = "siiCuotaOperadorAcuerdo")
    public List<SiiCuotaOpeCuotaAcuerdo> getSiiCuotaOpeCuotaAcuerdoAcuerdoList() {
        return siiCuotaOpeCuotaAcuerdoAcuerdoList;
    }

    public void setSiiCuotaOpeCuotaAcuerdoAcuerdoList(List<SiiCuotaOpeCuotaAcuerdo> siiCuotaOpeCuotaAcuerdoAcuerdoList) {
        this.siiCuotaOpeCuotaAcuerdoAcuerdoList = siiCuotaOpeCuotaAcuerdoAcuerdoList;
    }

    public SiiCuotaOpeCuotaAcuerdo addSiiCuotaOpeCuotaAcuerdo(SiiCuotaOpeCuotaAcuerdo siiCuotaOpeCuotaAcuerdo) {
        getSiiCuotaOpeCuotaAcuerdoAcuerdoList().add(siiCuotaOpeCuotaAcuerdo);
        siiCuotaOpeCuotaAcuerdo.setSiiCuotaOperadorAcuerdo(this);
        return siiCuotaOpeCuotaAcuerdo;
    }

    public SiiCuotaOpeCuotaAcuerdo removeSiiCuotaOpeCuotaAcuerdo(SiiCuotaOpeCuotaAcuerdo siiCuotaOpeCuotaAcuerdo) {
        getSiiCuotaOpeCuotaAcuerdoAcuerdoList().remove(siiCuotaOpeCuotaAcuerdo);
        siiCuotaOpeCuotaAcuerdo.setSiiCuotaOperadorAcuerdo(null);
        return siiCuotaOpeCuotaAcuerdo;
    }

    @OneToMany(mappedBy = "siiCuotaOperador")
    public List<SiiCuotaOpeCuotaAcuerdo> getSiiCuotaOpeCuotaAcuerdoCuotaList() {
        return siiCuotaOpeCuotaAcuerdoCuotaList;
    }

    public void setSiiCuotaOpeCuotaAcuerdoCuotaList(List<SiiCuotaOpeCuotaAcuerdo> siiCuotaOpeCuotaAcuerdoCuotaList) {
        this.siiCuotaOpeCuotaAcuerdoCuotaList = siiCuotaOpeCuotaAcuerdoCuotaList;
    }

    @OneToMany(mappedBy = "siiCuotaOperador")
    public List<SiiResumenNoConectado> getSiiResumenNoConectadoList() {
        return siiResumenNoConectadoList;
    }

    public void setSiiResumenNoConectadoList(List<SiiResumenNoConectado> siiResumenNoConectadoList) {
        this.siiResumenNoConectadoList = siiResumenNoConectadoList;
    }

    public SiiResumenNoConectado addSiiResumenNoConectado(SiiResumenNoConectado siiResumenNoConectado) {
        getSiiResumenNoConectadoList().add(siiResumenNoConectado);
        siiResumenNoConectado.setSiiCuotaOperador(this);
        return siiResumenNoConectado;
    }

    public SiiResumenNoConectado removeSiiResumenNoConectado(SiiResumenNoConectado siiResumenNoConectado) {
        getSiiResumenNoConectadoList().remove(siiResumenNoConectado);
        siiResumenNoConectado.setSiiCuotaOperador(null);
        return siiResumenNoConectado;
    }

    @OneToMany(mappedBy = "siiCuotaOperador")
    public List<SiiCuotaOmisProcSanc> getSiiCuotaOmisProcSancList() {
        return siiCuotaOmisProcSancList;
    }

    public void setSiiCuotaOmisProcSancList(List<SiiCuotaOmisProcSanc> siiCuotaOmisProcSancList) {
        this.siiCuotaOmisProcSancList = siiCuotaOmisProcSancList;
    }

    public SiiCuotaOmisProcSanc addSiiCuotaOmisProcSanc(SiiCuotaOmisProcSanc siiCuotaOmisProcSanc) {
        getSiiCuotaOmisProcSancList().add(siiCuotaOmisProcSanc);
        siiCuotaOmisProcSanc.setSiiCuotaOperador(this);
        return siiCuotaOmisProcSanc;
    }

    public SiiCuotaOmisProcSanc removeSiiCuotaOmisProcSanc(SiiCuotaOmisProcSanc siiCuotaOmisProcSanc) {
        getSiiCuotaOmisProcSancList().remove(siiCuotaOmisProcSanc);
        siiCuotaOmisProcSanc.setSiiCuotaOperador(null);
        return siiCuotaOmisProcSanc;
    }

    @OneToMany(mappedBy = "siiCuotaOperador")
    public List<SiiCuotaInexacProcSanc> getSiiCuotaInexacProcSancList() {
        return siiCuotaInexacProcSancList;
    }

    public void setSiiCuotaInexacProcSancList(List<SiiCuotaInexacProcSanc> siiCuotaInexacProcSancList) {
        this.siiCuotaInexacProcSancList = siiCuotaInexacProcSancList;
    }

    public SiiCuotaInexacProcSanc addSiiCuotaInexacProcSanc(SiiCuotaInexacProcSanc siiCuotaInexacProcSanc) {
        getSiiCuotaInexacProcSancList().add(siiCuotaInexacProcSanc);
        siiCuotaInexacProcSanc.setSiiCuotaOperador(this);
        return siiCuotaInexacProcSanc;
    }

    public SiiCuotaInexacProcSanc removeSiiCuotaInexacProcSanc(SiiCuotaInexacProcSanc siiCuotaInexacProcSanc) {
        getSiiCuotaInexacProcSancList().remove(siiCuotaInexacProcSanc);
        siiCuotaInexacProcSanc.setSiiCuotaOperador(null);
        return siiCuotaInexacProcSanc;
    }


    @JoinColumn(name = "ICN_CODIGO")
    public SiiIncumplimientoContr getSiiIncumplimientoContr() {
        return siiIncumplimientoContr;
    }

    public void setSiiIncumplimientoContr(SiiIncumplimientoContr siiIncumplimientoContr) {
        this.siiIncumplimientoContr = siiIncumplimientoContr;
    }
    
    @ManyToOne
    @JoinColumn(name = "CAA_CODIGO")
    public SiiCargaActuacionesAdm getSiiCargaActuacionesAdm() {
        return siiCargaActuacionesAdm;
    }

    public void setSiiCargaActuacionesAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm) {
        this.siiCargaActuacionesAdm = siiCargaActuacionesAdm;
    }

    @OneToMany(mappedBy = "siiCuotaOperador")
    public List<SiiActualizacCuotaOpe> getSiiActualizacCuotaOpeList() {
        return siiActualizacCuotaOpeList;
    }

    public void setSiiActualizacCuotaOpeList(List<SiiActualizacCuotaOpe> siiActualizacCuotaOpeList) {
        this.siiActualizacCuotaOpeList = siiActualizacCuotaOpeList;
    }

    public SiiActualizacCuotaOpe addSiiActualizacCuotaOpe(SiiActualizacCuotaOpe siiActualizacCuotaOpe) {
        getSiiActualizacCuotaOpeList().add(siiActualizacCuotaOpe);
        siiActualizacCuotaOpe.setSiiCuotaOperador(this);
        return siiActualizacCuotaOpe;
    }

    public SiiActualizacCuotaOpe removeSiiActualizacCuotaOpe(SiiActualizacCuotaOpe siiActualizacCuotaOpe) {
        getSiiActualizacCuotaOpeList().remove(siiActualizacCuotaOpe);
        siiActualizacCuotaOpe.setSiiCuotaOperador(null);
        return siiActualizacCuotaOpe;
    }

    @OneToMany(mappedBy = "siiCuotaOperadorGA")
    public List<SiiCuotaInexacProcSanc> getSiiCuotaInexacProcSancGAList() {
        return siiCuotaInexacProcSancGAList;
    }

    public void setSiiCuotaInexacProcSancGAList(List<SiiCuotaInexacProcSanc> siiCuotaInexacProcSancGAList) {
        this.siiCuotaInexacProcSancGAList = siiCuotaInexacProcSancGAList;
    }

    @ManyToOne
    @JoinColumn(name = "PSA_CODIGO")
    public SiiProcesoSancionatorio getSiiProcesoSancionatorio() {
        return siiProcesoSancionatorio;
    }

    public void setSiiProcesoSancionatorio(SiiProcesoSancionatorio siiProcesoSancionatorio) {
        this.siiProcesoSancionatorio = siiProcesoSancionatorio;
    }

    @ManyToOne
    @JoinColumn(name = "PRS_CODIGO")
    public SiiProcesoSancIlegalidad getSiiProcesoSancIlegalidad() {
        return siiProcesoSancIlegalidad;
    }

    public void setSiiProcesoSancIlegalidad(SiiProcesoSancIlegalidad siiProcesoSancIlegalidad) {
        this.siiProcesoSancIlegalidad = siiProcesoSancIlegalidad;
    }
}
