package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_CUENTAS_CONTABLES")
public class SiiCuentasContables implements Serializable {
    private static final long serialVersionUID = -5977564085452552262L;
    private String ccoAcumTerc;
    private String ccoCentroCost;
    private Long ccoCodigo;
    private String ccoConcInfExog;
    private String ccoCtaBalance;
    private String ccoCtaImpuestos;
    private String ccoCtaResult;
    private String ccoDescripcion;
    private String ccoFteFinanc;
    private String ccoNaturaleza;
    private String ccoNivel1;
    private String ccoNivel2;
    private String ccoNivel3;
    private String ccoNivel4;
    private String ccoNivel5;
    private String ccoNumDocConta;
    private String ccoObligaTerc;
    private String ccoReferencia1;
    private String ccoReferencia2;
    private String ccoTipoCuenta;
    private String ccoTipDocConta;
    private List<SiiConceptoGasto> siiConceptoGastoDebList;
    private List<SiiConceptoGasto> siiConceptoGastoCredList;
    private List<SiiTipoRetencion> siiTipoRetencionList;
    private List<SiiImputacionContable> siiImputacionContableList;
    private List<SiiCuentaContTipoDocCont> siiCuentaContTipoDocContList;
    private List<SiiImpContabOblNoPres> siiImpContabOblNoPresList;
    private String ccoPermiteObl;
    private List<SiiCuentaBancaria> siiCuentaBancariaList;
    private List<SiiActividadIca> siiActividadIcaList;
    private List<SiiDetalleCierreCont> siiDetalleCierreContList;
    private List<SiiCtaContabConcepCuota> siiCtaContabConcepCuotaList;
    private SiiEstadoCuentaContable siiEstadoCuentaContable;
    private String ccoCtaAcreedora;
    private SiiPersona siiPersonaCancSaldo;

    public SiiCuentasContables() {
    }

    public SiiCuentasContables(String ccoAcumTerc, String ccoCentroCost, Long ccoCodigo, String ccoConcInfExog,
                               String ccoCtaBalance, String ccoCtaImpuestos, String ccoCtaResult, String ccoDescripcion,
                               String ccoFteFinanc, String ccoNaturaleza, String ccoNivel1, String ccoNivel2,
                               String ccoNivel3, String ccoNivel4, String ccoNivel5, String ccoNumDocConta,
                               String ccoObligaTerc, String ccoReferencia1, String ccoReferencia2,
                               String ccoTipDocConta, String ccoTipoCuenta) {
        this.ccoAcumTerc = ccoAcumTerc;
        this.ccoCentroCost = ccoCentroCost;
        this.ccoCodigo = ccoCodigo;
        this.ccoConcInfExog = ccoConcInfExog;
        this.ccoCtaBalance = ccoCtaBalance;
        this.ccoCtaImpuestos = ccoCtaImpuestos;
        this.ccoCtaResult = ccoCtaResult;
        this.ccoDescripcion = ccoDescripcion;
        this.ccoFteFinanc = ccoFteFinanc;
        this.ccoNaturaleza = ccoNaturaleza;
        this.ccoNivel1 = ccoNivel1;
        this.ccoNivel2 = ccoNivel2;
        this.ccoNivel3 = ccoNivel3;
        this.ccoNivel4 = ccoNivel4;
        this.ccoNivel5 = ccoNivel5;
        this.ccoNumDocConta = ccoNumDocConta;
        this.ccoObligaTerc = ccoObligaTerc;
        this.ccoReferencia1 = ccoReferencia1;
        this.ccoReferencia2 = ccoReferencia2;
        this.ccoTipDocConta = ccoTipDocConta;
        this.ccoTipoCuenta = ccoTipoCuenta;
    }

    @Column(name = "CCO_ACUM_TERC", nullable = false, length = 1)
    public String getCcoAcumTerc() {
        return ccoAcumTerc;
    }

    public void setCcoAcumTerc(String ccoAcumTerc) {
        this.ccoAcumTerc = ccoAcumTerc;
    }

    @Column(name = "CCO_CENTRO_COST", nullable = false, length = 1)
    public String getCcoCentroCost() {
        return ccoCentroCost;
    }

    public void setCcoCentroCost(String ccoCentroCost) {
        this.ccoCentroCost = ccoCentroCost;
    }

    @Id
    @Column(name = "CCO_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_CUENTAS_CONTABLES_COD")
    @SequenceGenerator(name = "SEQ_CUENTAS_CONTABLES_COD", sequenceName = "SEQ_CUENTAS_CONTABLES_COD",allocationSize=1)
    public Long getCcoCodigo() {
        return ccoCodigo;
    }

    public void setCcoCodigo(Long ccoCodigo) {
        this.ccoCodigo = ccoCodigo;
    }

    @Column(name = "CCO_CONC_INF_EXOG", nullable = false, length = 1)
    public String getCcoConcInfExog() {
        return ccoConcInfExog;
    }

    public void setCcoConcInfExog(String ccoConcInfExog) {
        this.ccoConcInfExog = ccoConcInfExog;
    }

    @Column(name = "CCO_CTA_BALANCE", nullable = false, length = 1)
    public String getCcoCtaBalance() {
        return ccoCtaBalance;
    }

    public void setCcoCtaBalance(String ccoCtaBalance) {
        this.ccoCtaBalance = ccoCtaBalance;
    }

    @Column(name = "CCO_CTA_IMPUESTOS", nullable = false, length = 1)
    public String getCcoCtaImpuestos() {
        return ccoCtaImpuestos;
    }

    public void setCcoCtaImpuestos(String ccoCtaImpuestos) {
        this.ccoCtaImpuestos = ccoCtaImpuestos;
    }

    @Column(name = "CCO_CTA_RESULT", nullable = false, length = 1)
    public String getCcoCtaResult() {
        return ccoCtaResult;
    }

    public void setCcoCtaResult(String ccoCtaResult) {
        this.ccoCtaResult = ccoCtaResult;
    }

    @Column(name = "CCO_DESCRIPCION", nullable = false, length = 100)
    public String getCcoDescripcion() {
        return ccoDescripcion;
    }

    public void setCcoDescripcion(String ccoDescripcion) {
        this.ccoDescripcion = ccoDescripcion;
    }

    @Column(name = "CCO_FTE_FINANC", nullable = false, length = 1)
    public String getCcoFteFinanc() {
        return ccoFteFinanc;
    }

    public void setCcoFteFinanc(String ccoFteFinanc) {
        this.ccoFteFinanc = ccoFteFinanc;
    }

    @Column(name = "CCO_NATURALEZA", nullable = false, length = 1)
    public String getCcoNaturaleza() {
        return ccoNaturaleza;
    }

    public void setCcoNaturaleza(String ccoNaturaleza) {
        this.ccoNaturaleza = ccoNaturaleza;
    }

    @Column(name = "CCO_NIVEL1", nullable = false, length = 1)
    public String getCcoNivel1() {
        return ccoNivel1;
    }

    public void setCcoNivel1(String ccoNivel1) {
        this.ccoNivel1 = ccoNivel1;
    }

    @Column(name = "CCO_NIVEL2", length = 1)
    public String getCcoNivel2() {
        return ccoNivel2;
    }

    public void setCcoNivel2(String ccoNivel2) {
        this.ccoNivel2 = ccoNivel2;
    }

    @Column(name = "CCO_NIVEL3", length = 2)
    public String getCcoNivel3() {
        return ccoNivel3;
    }

    public void setCcoNivel3(String ccoNivel3) {
        this.ccoNivel3 = ccoNivel3;
    }

    @Column(name = "CCO_NIVEL4", length = 2)
    public String getCcoNivel4() {
        return ccoNivel4;
    }

    public void setCcoNivel4(String ccoNivel4) {
        this.ccoNivel4 = ccoNivel4;
    }

    @Column(name = "CCO_NIVEL5", length = 2)
    public String getCcoNivel5() {
        return ccoNivel5;
    }

    public void setCcoNivel5(String ccoNivel5) {
        this.ccoNivel5 = ccoNivel5;
    }

    @Column(name = "CCO_NUM_DOC_CONTA", nullable = false, length = 1)
    public String getCcoNumDocConta() {
        return ccoNumDocConta;
    }

    public void setCcoNumDocConta(String ccoNumDocConta) {
        this.ccoNumDocConta = ccoNumDocConta;
    }

    @Column(name = "CCO_OBLIGA_TERC", nullable = false, length = 1)
    public String getCcoObligaTerc() {
        return ccoObligaTerc;
    }

    public void setCcoObligaTerc(String ccoObligaTerc) {
        this.ccoObligaTerc = ccoObligaTerc;
    }

    @Column(name = "CCO_REFERENCIA_1", nullable = false, length = 1)
    public String getCcoReferencia1() {
        return ccoReferencia1;
    }

    public void setCcoReferencia1(String ccoReferencia1) {
        this.ccoReferencia1 = ccoReferencia1;
    }

    @Column(name = "CCO_REFERENCIA_2", nullable = false, length = 1)
    public String getCcoReferencia2() {
        return ccoReferencia2;
    }

    public void setCcoReferencia2(String ccoReferencia2) {
        this.ccoReferencia2 = ccoReferencia2;
    }

    @Column(name = "CCO_TIPO_CUENTA", nullable = false, length = 1)
    public String getCcoTipoCuenta() {
        return ccoTipoCuenta;
    }

    public void setCcoTipoCuenta(String ccoTipoCuenta) {
        this.ccoTipoCuenta = ccoTipoCuenta;
    }

    @Column(name = "CCO_TIP_DOC_CONTA", nullable = false, length = 1)
    public String getCcoTipDocConta() {
        return ccoTipDocConta;
    }

    public void setCcoTipDocConta(String ccoTipDocConta) {
        this.ccoTipDocConta = ccoTipDocConta;
    }

    @OneToMany(mappedBy = "siiCuentasContablesDeb")
    public List<SiiConceptoGasto> getSiiConceptoGastoDebList() {
        return siiConceptoGastoDebList;
    }

    public void setSiiConceptoGastoDebList(List<SiiConceptoGasto> siiConceptoGastoDebList) {
        this.siiConceptoGastoDebList = siiConceptoGastoDebList;
    }

    public SiiConceptoGasto addSiiConceptoGasto(SiiConceptoGasto siiConceptoGasto) {
        getSiiConceptoGastoDebList().add(siiConceptoGasto);
        siiConceptoGasto.setSiiCuentasContablesDeb(this);
        return siiConceptoGasto;
    }

    public SiiConceptoGasto removeSiiConceptoGasto(SiiConceptoGasto siiConceptoGasto) {
        getSiiConceptoGastoDebList().remove(siiConceptoGasto);
        siiConceptoGasto.setSiiCuentasContablesDeb(null);
        return siiConceptoGasto;
    }

    @OneToMany(mappedBy = "siiCuentasContablesCred")
    public List<SiiConceptoGasto> getSiiConceptoGastoCredList() {
        return siiConceptoGastoCredList;
    }

    public void setSiiConceptoGastoCredList(List<SiiConceptoGasto> siiConceptoGastoCredList) {
        this.siiConceptoGastoCredList = siiConceptoGastoCredList;
    }

    @OneToMany(mappedBy = "siiCuentasContables")
    public List<SiiTipoRetencion> getSiiTipoRetencionList() {
        return siiTipoRetencionList;
    }

    public void setSiiTipoRetencionList(List<SiiTipoRetencion> siiTipoRetencionList) {
        this.siiTipoRetencionList = siiTipoRetencionList;
    }

    public SiiTipoRetencion addSiiTipoRetencion(SiiTipoRetencion siiTipoRetencion) {
        getSiiTipoRetencionList().add(siiTipoRetencion);
        siiTipoRetencion.setSiiCuentasContables(this);
        return siiTipoRetencion;
    }

    public SiiTipoRetencion removeSiiTipoRetencion(SiiTipoRetencion siiTipoRetencion) {
        getSiiTipoRetencionList().remove(siiTipoRetencion);
        siiTipoRetencion.setSiiCuentasContables(null);
        return siiTipoRetencion;
    }

    @OneToMany(mappedBy = "siiCuentasContables")
    public List<SiiImputacionContable> getSiiImputacionContableList() {
        return siiImputacionContableList;
    }

    public void setSiiImputacionContableList(List<SiiImputacionContable> siiImputacionContableList) {
        this.siiImputacionContableList = siiImputacionContableList;
    }

    public SiiImputacionContable addSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().add(siiImputacionContable);
        siiImputacionContable.setSiiCuentasContables(this);
        return siiImputacionContable;
    }

    public SiiImputacionContable removeSiiImputacionContable(SiiImputacionContable siiImputacionContable) {
        getSiiImputacionContableList().remove(siiImputacionContable);
        siiImputacionContable.setSiiCuentasContables(null);
        return siiImputacionContable;
    }

    @OneToMany(mappedBy = "siiCuentasContables")
    public List<SiiCuentaContTipoDocCont> getSiiCuentaContTipoDocContList() {
        return siiCuentaContTipoDocContList;
    }

    public void setSiiCuentaContTipoDocContList(List<SiiCuentaContTipoDocCont> siiCuentaContTipoDocContList) {
        this.siiCuentaContTipoDocContList = siiCuentaContTipoDocContList;
    }

    public SiiCuentaContTipoDocCont addSiiCuentaContTipoDocCont(SiiCuentaContTipoDocCont siiCuentaContTipoDocCont) {
        getSiiCuentaContTipoDocContList().add(siiCuentaContTipoDocCont);
        siiCuentaContTipoDocCont.setSiiCuentasContables(this);
        return siiCuentaContTipoDocCont;
    }

    public SiiCuentaContTipoDocCont removeSiiCuentaContTipoDocCont(SiiCuentaContTipoDocCont siiCuentaContTipoDocCont) {
        getSiiCuentaContTipoDocContList().remove(siiCuentaContTipoDocCont);
        siiCuentaContTipoDocCont.setSiiCuentasContables(null);
        return siiCuentaContTipoDocCont;
    }

    @OneToMany(mappedBy = "siiCuentasContables")
    public List<SiiImpContabOblNoPres> getSiiImpContabOblNoPresList() {
        return siiImpContabOblNoPresList;
    }

    public void setSiiImpContabOblNoPresList(List<SiiImpContabOblNoPres> siiImpContabOblNoPresList) {
        this.siiImpContabOblNoPresList = siiImpContabOblNoPresList;
    }

    public SiiImpContabOblNoPres addSiiImpContabOblNoPres(SiiImpContabOblNoPres siiImpContabOblNoPres) {
        getSiiImpContabOblNoPresList().add(siiImpContabOblNoPres);
        siiImpContabOblNoPres.setSiiCuentasContables(this);
        return siiImpContabOblNoPres;
    }

    public SiiImpContabOblNoPres removeSiiImpContabOblNoPres(SiiImpContabOblNoPres siiImpContabOblNoPres) {
        getSiiImpContabOblNoPresList().remove(siiImpContabOblNoPres);
        siiImpContabOblNoPres.setSiiCuentasContables(null);
        return siiImpContabOblNoPres;
    }

    @Column(name = "CCO_PERMITE_OBL", nullable = false, length = 1)
    public String getCcoPermiteObl() {
        return ccoPermiteObl;
    }

    public void setCcoPermiteObl(String ccoPermiteObl) {
        this.ccoPermiteObl = ccoPermiteObl;
    }

    @OneToMany(mappedBy = "siiCuentasContables")
    public List<SiiCuentaBancaria> getSiiCuentaBancariaList() {
        return siiCuentaBancariaList;
    }

    public void setSiiCuentaBancariaList(List<SiiCuentaBancaria> siiCuentaBancariaList) {
        this.siiCuentaBancariaList = siiCuentaBancariaList;
    }

    public SiiCuentaBancaria addSiiCuentaBancaria(SiiCuentaBancaria siiCuentaBancaria) {
        getSiiCuentaBancariaList().add(siiCuentaBancaria);
        siiCuentaBancaria.setSiiCuentasContables(this);
        return siiCuentaBancaria;
    }

    public SiiCuentaBancaria removeSiiCuentaBancaria(SiiCuentaBancaria siiCuentaBancaria) {
        getSiiCuentaBancariaList().remove(siiCuentaBancaria);
        siiCuentaBancaria.setSiiCuentasContables(null);
        return siiCuentaBancaria;
    }

    @OneToMany(mappedBy = "siiCuentasContables")
    public List<SiiActividadIca> getSiiActividadIcaList() {
        return siiActividadIcaList;
    }

    public void setSiiActividadIcaList(List<SiiActividadIca> siiActividadIcaList) {
        this.siiActividadIcaList = siiActividadIcaList;
    }

    public SiiActividadIca addSiiActividadIca(SiiActividadIca siiActividadIca) {
        getSiiActividadIcaList().add(siiActividadIca);
        siiActividadIca.setSiiCuentasContables(this);
        return siiActividadIca;
    }

    public SiiActividadIca removeSiiActividadIca(SiiActividadIca siiActividadIca) {
        getSiiActividadIcaList().remove(siiActividadIca);
        siiActividadIca.setSiiCuentasContables(null);
        return siiActividadIca;
    }

    @OneToMany(mappedBy = "siiCuentasContables")
    public List<SiiDetalleCierreCont> getSiiDetalleCierreContList() {
        return siiDetalleCierreContList;
    }

    public void setSiiDetalleCierreContList(List<SiiDetalleCierreCont> siiDetalleCierreContList) {
        this.siiDetalleCierreContList = siiDetalleCierreContList;
    }

    public SiiDetalleCierreCont addSiiDetalleCierreCont(SiiDetalleCierreCont siiDetalleCierreCont) {
        getSiiDetalleCierreContList().add(siiDetalleCierreCont);
        siiDetalleCierreCont.setSiiCuentasContables(this);
        return siiDetalleCierreCont;
    }

    public SiiDetalleCierreCont removeSiiDetalleCierreCont(SiiDetalleCierreCont siiDetalleCierreCont) {
        getSiiDetalleCierreContList().remove(siiDetalleCierreCont);
        siiDetalleCierreCont.setSiiCuentasContables(null);
        return siiDetalleCierreCont;
    }

    @OneToMany(mappedBy = "siiCuentasContables")
    public List<SiiCtaContabConcepCuota> getSiiCtaContabConcepCuotaList() {
        return siiCtaContabConcepCuotaList;
    }

    public void setSiiCtaContabConcepCuotaList(List<SiiCtaContabConcepCuota> siiCtaContabConcepCuotaList) {
        this.siiCtaContabConcepCuotaList = siiCtaContabConcepCuotaList;
    }

    public SiiCtaContabConcepCuota addSiiCtaContabConcepCuota(SiiCtaContabConcepCuota siiCtaContabConcepCuota) {
        getSiiCtaContabConcepCuotaList().add(siiCtaContabConcepCuota);
        siiCtaContabConcepCuota.setSiiCuentasContables(this);
        return siiCtaContabConcepCuota;
    }

    public SiiCtaContabConcepCuota removeSiiCtaContabConcepCuota(SiiCtaContabConcepCuota siiCtaContabConcepCuota) {
        getSiiCtaContabConcepCuotaList().remove(siiCtaContabConcepCuota);
        siiCtaContabConcepCuota.setSiiCuentasContables(null);
        return siiCtaContabConcepCuota;
    }

    @ManyToOne
    @JoinColumn(name = "ECC_CODIGO")
    public SiiEstadoCuentaContable getSiiEstadoCuentaContable() {
        return siiEstadoCuentaContable;
    }

    public void setSiiEstadoCuentaContable(SiiEstadoCuentaContable siiEstadoCuentaContable) {
        this.siiEstadoCuentaContable = siiEstadoCuentaContable;
    }

    @Column(name = "CCO_CTA_ACREEDORA", length = 1)
    public String getCcoCtaAcreedora(){
        return ccoCtaAcreedora;
    }
    
    public void setCcoCtaAcreedora(String ccoCtaAcreedora){
        this.ccoCtaAcreedora = ccoCtaAcreedora;
    }

    @ManyToOne
    @JoinColumn(name = "PER_CODIGO_CANC_SAL")
    public SiiPersona getSiiPersonaCancSaldo() {
        return siiPersonaCancSaldo;
    }

    public void setSiiPersonaCancSaldo(SiiPersona siiPersonaCancSaldo) {
        this.siiPersonaCancSaldo = siiPersonaCancSaldo;
    }
}
