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
@Table(name = "SII_ALCANCE_INVITACION")
public class SiiAlcanceInvitacion implements Serializable {
    private static final long serialVersionUID = 5181505640969848895L;
    private Long aliCodigo;
    private Date aliFecha;
    private Date aliFechaVencim;
    private String aliFormaPago;
    private String aliObligacContrat;
    private String aliOtroTipAlcan;
    private Integer aliTiempoDurac;
    private String aliUnidadDurac;
    private Long aliValor;
    private SiiEstadoAlcanceInv siiEstadoAlcanceInv;
    private SiiProcesoContratacion siiProcesoContratacion;
    private List<SiiReqAlcanceInv> siiReqAlcanceInvList;
    private SiiArchivoFisico siiArchivoFisico1;

    public SiiAlcanceInvitacion() {
    }

    public SiiAlcanceInvitacion(SiiArchivoFisico siiArchivoFisico1,Long aliCodigo, Date aliFechaVencim, String aliFormaPago, String aliObligacContrat,
                                String aliOtroTipAlcan, Integer aliTiempoDurac, String aliUnidadDurac, Long aliValor,
                                SiiEstadoAlcanceInv siiEstadoAlcanceInv,
                                SiiProcesoContratacion siiProcesoContratacion, Date aliFecha) {
        this.siiArchivoFisico1 = siiArchivoFisico1;
        this.aliCodigo = aliCodigo;
        this.aliFecha = aliFecha;
        this.aliFechaVencim = aliFechaVencim;
        this.aliFormaPago = aliFormaPago;
        this.aliObligacContrat = aliObligacContrat;
        this.aliOtroTipAlcan = aliOtroTipAlcan;
        this.aliTiempoDurac = aliTiempoDurac;
        this.aliUnidadDurac = aliUnidadDurac;
        this.aliValor = aliValor;
        this.siiEstadoAlcanceInv = siiEstadoAlcanceInv;
        this.siiProcesoContratacion = siiProcesoContratacion;
    }

    @Id
    @Column(name = "ALI_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_ALCANCE_INVITACION")
    @SequenceGenerator(name = "SEQ_ALCANCE_INVITACION", sequenceName = "SEQ_ALCANCE_INVITACION",allocationSize=1)
    public Long getAliCodigo() {
        return aliCodigo;
    }

    public void setAliCodigo(Long aliCodigo) {
        this.aliCodigo = aliCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ALI_FECHA", nullable = false)
    public Date getAliFecha() {
        return aliFecha;
    }

    public void setAliFecha(Date aliFecha) {
        this.aliFecha = aliFecha;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ALI_FECHA_VENCIM", nullable = false)
    public Date getAliFechaVencim() {
        return aliFechaVencim;
    }

    public void setAliFechaVencim(Date aliFechaVencim) {
        this.aliFechaVencim = aliFechaVencim;
    }

    @Column(name = "ALI_FORMA_PAGO", nullable = false, length = 1000)
    public String getAliFormaPago() {
        return aliFormaPago;
    }

    public void setAliFormaPago(String aliFormaPago) {
        this.aliFormaPago = aliFormaPago;
    }

    @Column(name = "ALI_OBLIGAC_CONTRAT", nullable = false, length = 20)
    public String getAliObligacContrat() {
        return aliObligacContrat;
    }

    public void setAliObligacContrat(String aliObligacContrat) {
        this.aliObligacContrat = aliObligacContrat;
    }

    @Column(name = "ALI_OTRO_TIP_ALCAN", nullable = false, length = 2000)
    public String getAliOtroTipAlcan() {
        return aliOtroTipAlcan;
    }

    public void setAliOtroTipAlcan(String aliOtroTipAlcan) {
        this.aliOtroTipAlcan = aliOtroTipAlcan;
    }

    @Column(name = "ALI_TIEMPO_DURAC", nullable = false)
    public Integer getAliTiempoDurac() {
        return aliTiempoDurac;
    }

    public void setAliTiempoDurac(Integer aliTiempoDurac) {
        this.aliTiempoDurac = aliTiempoDurac;
    }

    @Column(name = "ALI_UNIDAD_DURAC", nullable = false, length = 1)
    public String getAliUnidadDurac() {
        return aliUnidadDurac;
    }

    public void setAliUnidadDurac(String aliUnidadDurac) {
        this.aliUnidadDurac = aliUnidadDurac;
    }

    @Column(name = "ALI_VALOR", nullable = false)
    public Long getAliValor() {
        return aliValor;
    }

    public void setAliValor(Long aliValor) {
        this.aliValor = aliValor;
    }


    @ManyToOne
    @JoinColumn(name = "EAI_CODIGO")
    public SiiEstadoAlcanceInv getSiiEstadoAlcanceInv() {
        return siiEstadoAlcanceInv;
    }

    public void setSiiEstadoAlcanceInv(SiiEstadoAlcanceInv siiEstadoAlcanceInv) {
        this.siiEstadoAlcanceInv = siiEstadoAlcanceInv;
    }

    @ManyToOne
    @JoinColumn(name = "PRC_CODIGO")
    public SiiProcesoContratacion getSiiProcesoContratacion() {
        return siiProcesoContratacion;
    }

    public void setSiiProcesoContratacion(SiiProcesoContratacion siiProcesoContratacion) {
        this.siiProcesoContratacion = siiProcesoContratacion;
    }

    @OneToMany(mappedBy = "siiAlcanceInvitacion")
    public List<SiiReqAlcanceInv> getSiiReqAlcanceInvList() {
        return siiReqAlcanceInvList;
    }

    public void setSiiReqAlcanceInvList(List<SiiReqAlcanceInv> siiReqAlcanceInvList) {
        this.siiReqAlcanceInvList = siiReqAlcanceInvList;
    }

    public SiiReqAlcanceInv addSiiReqAlcanceInv(SiiReqAlcanceInv siiReqAlcanceInv) {
        getSiiReqAlcanceInvList().add(siiReqAlcanceInv);
        siiReqAlcanceInv.setSiiAlcanceInvitacion(this);
        return siiReqAlcanceInv;
    }

    public SiiReqAlcanceInv removeSiiReqAlcanceInv(SiiReqAlcanceInv siiReqAlcanceInv) {
        getSiiReqAlcanceInvList().remove(siiReqAlcanceInv);
        siiReqAlcanceInv.setSiiAlcanceInvitacion(null);
        return siiReqAlcanceInv;
    }

    @ManyToOne
    @JoinColumn(name = "AFI_CODIGO")
    public SiiArchivoFisico getSiiArchivoFisico1() {
        return siiArchivoFisico1;
    }

    public void setSiiArchivoFisico1(SiiArchivoFisico siiArchivoFisico1) {
        this.siiArchivoFisico1 = siiArchivoFisico1;
    }
}
