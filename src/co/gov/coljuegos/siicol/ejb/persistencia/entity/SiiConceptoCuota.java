package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SII_CONCEPTO_CUOTA")
public class SiiConceptoCuota implements Serializable {
    private static final long serialVersionUID = 3042801093418562787L;
    private Long ccuCodigo;
    private String ccuNombre;
    private List<SiiCuotaOperador> siiCuotaOperadorList;
    private String ccuAbreviatura;
    private String ccuDestino;
    private String ccuTipoTasa;
    private String ccuDistribucion;
    private String ccuAbrevImp;
    private List<SiiCtaContabConcepCuota> siiCtaContabConcepCuotaList;
    private SiiCategoriaDistrib siiCategoriaDistrib;
    private List<SiiConcepCuotCarActAdm> siiConcepCuotCarActAdmList;
    private List<SiiPagoCargaActAdm> siiPagoCargaActAdmList;
    private List<SiiAbonoIniAcuerdoPago> siiAbonoIniAcuerdoPagoList;


    public SiiConceptoCuota() {
    }

    public SiiConceptoCuota(Long ccuCodigo, String ccuNombre) {
        this.ccuCodigo = ccuCodigo;
        this.ccuNombre = ccuNombre;
    }

    @Id
    @Column(name = "CCU_CODIGO", nullable = false)
    public Long getCcuCodigo() {
        return ccuCodigo;
    }

    public void setCcuCodigo(Long ccuCodigo) {
        this.ccuCodigo = ccuCodigo;
    }

    @Column(name = "CCU_NOMBRE", nullable = false, length = 20)
    public String getCcuNombre() {
        return ccuNombre;
    }

    public void setCcuNombre(String ccuNombre) {
        this.ccuNombre = ccuNombre;
    }

    @OneToMany(mappedBy = "siiConceptoCuota")
    public List<SiiCuotaOperador> getSiiCuotaOperadorList() {
        return siiCuotaOperadorList;
    }

    public void setSiiCuotaOperadorList(List<SiiCuotaOperador> siiCuotaOperadorList) {
        this.siiCuotaOperadorList = siiCuotaOperadorList;
    }

    public SiiCuotaOperador addSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().add(siiCuotaOperador);
        siiCuotaOperador.setSiiConceptoCuota(this);
        return siiCuotaOperador;
    }

    public SiiCuotaOperador removeSiiCuotaOperador(SiiCuotaOperador siiCuotaOperador) {
        getSiiCuotaOperadorList().remove(siiCuotaOperador);
        siiCuotaOperador.setSiiConceptoCuota(null);
        return siiCuotaOperador;
    }

    @Column(name = "CCU_DESTINO", length = 2)
    public String getCcuDestino() {
        return ccuDestino;
    }

    public void setCcuDestino(String ccuDestino) {
        this.ccuDestino = ccuDestino;
    }

    @Column(name = "CCU_TIPO_TASA", nullable = false, length = 3)
    public String getCcuTipoTasa() {
        return ccuTipoTasa;
    }

    public void setCcuTipoTasa(String ccuTipoTasa) {
        this.ccuTipoTasa = ccuTipoTasa;
    }

    @Column(name = "CCU_ABREVIATURA", length = 10)
    public String getCcuAbreviatura() {
        return ccuAbreviatura;
    }

    public void setCcuAbreviatura(String ccuAbreviatura) {
        this.ccuAbreviatura = ccuAbreviatura;
    }

    @Column(name = "CCU_DISTRIBUCION", length = 10)
    public String getCcuDistribucion() {
        return ccuDistribucion;
    }

    public void setCcuDistribucion(String ccuDistribucion) {
        this.ccuDistribucion = ccuDistribucion;
    }

    @Column(name = "CCU_ABREV_IMP", length = 60)
    public String getCcuAbrevImp() {
        return ccuAbrevImp;
    }

    public void setCcuAbrevImp(String ccuAbrevImp) {
        this.ccuAbrevImp = ccuAbrevImp;
    }

    @OneToMany(mappedBy = "siiConceptoCuota")
    public List<SiiCtaContabConcepCuota> getSiiCtaContabConcepCuotaList() {
        return siiCtaContabConcepCuotaList;
    }

    public void setSiiCtaContabConcepCuotaList(List<SiiCtaContabConcepCuota> siiCtaContabConcepCuotaList) {
        this.siiCtaContabConcepCuotaList = siiCtaContabConcepCuotaList;
    }

    public SiiCtaContabConcepCuota addSiiCtaContabConcepCuota(SiiCtaContabConcepCuota siiCtaContabConcepCuota) {
        getSiiCtaContabConcepCuotaList().add(siiCtaContabConcepCuota);
        siiCtaContabConcepCuota.setSiiConceptoCuota(this);
        return siiCtaContabConcepCuota;
    }

    public SiiCtaContabConcepCuota removeSiiCtaContabConcepCuota(SiiCtaContabConcepCuota siiCtaContabConcepCuota) {
        getSiiCtaContabConcepCuotaList().remove(siiCtaContabConcepCuota);
        siiCtaContabConcepCuota.setSiiConceptoCuota(null);
        return siiCtaContabConcepCuota;
    }
    
    @ManyToOne
    @JoinColumn(name = "CAD_CODIGO")
    public SiiCategoriaDistrib getSiiCategoriaDistrib() {
        return siiCategoriaDistrib;
    }

    public void setSiiCategoriaDistrib(SiiCategoriaDistrib siiCategoriaDistrib) {
        this.siiCategoriaDistrib = siiCategoriaDistrib;
    }

    @OneToMany(mappedBy = "siiConceptoCuota")
    public List<SiiConcepCuotCarActAdm> getSiiConcepCuotCarActAdmList() {
        return siiConcepCuotCarActAdmList;
    }

    public void setSiiConcepCuotCarActAdmList(List<SiiConcepCuotCarActAdm> siiConcepCuotCarActAdmList) {
        this.siiConcepCuotCarActAdmList = siiConcepCuotCarActAdmList;
    }

    public SiiConcepCuotCarActAdm addSiiConcepCuotCarActAdm(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm) {
        getSiiConcepCuotCarActAdmList().add(siiConcepCuotCarActAdm);
        siiConcepCuotCarActAdm.setSiiConceptoCuota(this);
        return siiConcepCuotCarActAdm;
    }

    public SiiConcepCuotCarActAdm removeSiiConcepCuotCarActAdm(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm) {
        getSiiConcepCuotCarActAdmList().remove(siiConcepCuotCarActAdm);
        siiConcepCuotCarActAdm.setSiiConceptoCuota(null);
        return siiConcepCuotCarActAdm;
    }

    @OneToMany(mappedBy = "siiConceptoCuota")
    public List<SiiPagoCargaActAdm> getSiiPagoCargaActAdmList() {
        return siiPagoCargaActAdmList;
    }

    public void setSiiPagoCargaActAdmList(List<SiiPagoCargaActAdm> siiPagoCargaActAdmList) {
        this.siiPagoCargaActAdmList = siiPagoCargaActAdmList;
    }

    public SiiPagoCargaActAdm addSiiPagoCargaActAdm(SiiPagoCargaActAdm siiPagoCargaActAdm) {
        getSiiPagoCargaActAdmList().add(siiPagoCargaActAdm);
        siiPagoCargaActAdm.setSiiConceptoCuota(this);
        return siiPagoCargaActAdm;
    }

    public SiiPagoCargaActAdm removeSiiPagoCargaActAdm(SiiPagoCargaActAdm siiPagoCargaActAdm) {
        getSiiPagoCargaActAdmList().remove(siiPagoCargaActAdm);
        siiPagoCargaActAdm.setSiiConceptoCuota(null);
        return siiPagoCargaActAdm;
    }

    @OneToMany(mappedBy = "siiConceptoCuota")
    public List<SiiAbonoIniAcuerdoPago> getSiiAbonoIniAcuerdoPagoList() {
        return siiAbonoIniAcuerdoPagoList;
    }

    public void setSiiAbonoIniAcuerdoPagoList(List<SiiAbonoIniAcuerdoPago> siiAbonoIniAcuerdoPagoList) {
        this.siiAbonoIniAcuerdoPagoList = siiAbonoIniAcuerdoPagoList;
    }

    public SiiAbonoIniAcuerdoPago addSiiAbonoIniAcuerdoPago(SiiAbonoIniAcuerdoPago siiAbonoIniAcuerdoPago) {
        getSiiAbonoIniAcuerdoPagoList().add(siiAbonoIniAcuerdoPago);
        siiAbonoIniAcuerdoPago.setSiiConceptoCuota(this);
        return siiAbonoIniAcuerdoPago;
    }

    public SiiAbonoIniAcuerdoPago removeSiiAbonoIniAcuerdoPago(SiiAbonoIniAcuerdoPago siiAbonoIniAcuerdoPago) {
        getSiiAbonoIniAcuerdoPagoList().remove(siiAbonoIniAcuerdoPago);
        siiAbonoIniAcuerdoPago.setSiiConceptoCuota(null);
        return siiAbonoIniAcuerdoPago;
    }
}
