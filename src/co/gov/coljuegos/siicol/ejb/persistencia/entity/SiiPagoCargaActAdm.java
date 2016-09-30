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
@Table(name = "SII_PAGO_CARGA_ACT_ADM")
public class SiiPagoCargaActAdm implements Serializable {
    private static final long serialVersionUID = -8186273045832775607L;
    private String pcaActivo;
    private Long pcaCodigo;
    private Date pcaFechaPago;
    private BigDecimal pcaValorCapital;
    private BigDecimal pcaValorInteres;
    private SiiUsuario siiUsuarioConectado;
    private SiiCargaActuacionesAdm siiCargaActuacionesAdm;
    private SiiConceptoCuota siiConceptoCuota;
    private List<SiiDetalleRecaudo> siiDetalleRecaudoList;

    public SiiPagoCargaActAdm() {
    }

    public SiiPagoCargaActAdm(SiiCargaActuacionesAdm siiCargaActuacionesAdm, SiiConceptoCuota siiConceptoCuota, String pcaActivo, Long pcaCodigo, Date pcaFechaPago, BigDecimal pcaValorCapital,
                              BigDecimal pcaValorInteres, SiiUsuario siiUsuarioConectado) {
        this.siiCargaActuacionesAdm = siiCargaActuacionesAdm;
        this.siiConceptoCuota = siiConceptoCuota;
        this.pcaActivo = pcaActivo;
        this.pcaCodigo = pcaCodigo;
        this.pcaFechaPago = pcaFechaPago;
        this.pcaValorCapital = pcaValorCapital;
        this.pcaValorInteres = pcaValorInteres;
        this.siiUsuarioConectado = siiUsuarioConectado;
    }


    @Column(name = "PCA_ACTIVO", nullable = false, length = 1)
    public String getPcaActivo() {
        return pcaActivo;
    }

    public void setPcaActivo(String pcaActivo) {
        this.pcaActivo = pcaActivo;
    }
    
    @Id
    @Column(name = "PCA_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_PAGO_CARGA_ACT_ADM_COD")
    @SequenceGenerator(name = "SEQ_PAGO_CARGA_ACT_ADM_COD", sequenceName = "SEQ_PAGO_CARGA_ACT_ADM_COD",allocationSize=1)
    public Long getPcaCodigo() {
        return pcaCodigo;
    }

    public void setPcaCodigo(Long pcaCodigo) {
        this.pcaCodigo = pcaCodigo;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "PCA_FECHA_PAGO", nullable = false)
    public Date getPcaFechaPago() {
        return pcaFechaPago;
    }

    public void setPcaFechaPago(Date pcaFechaPago) {
        this.pcaFechaPago = pcaFechaPago;
    }

    @Column(name = "PCA_VALOR_CAPITAL", nullable = false)
    public BigDecimal getPcaValorCapital() {
        return pcaValorCapital;
    }

    public void setPcaValorCapital(BigDecimal pcaValorCapital) {
        this.pcaValorCapital = pcaValorCapital;
    }

    @Column(name = "PCA_VALOR_INTERES", nullable = false)
    public BigDecimal getPcaValorInteres(){
        return pcaValorInteres;
    }
    
    public void setPcaValorInteres(BigDecimal pcaValorInteres){
        this.pcaValorInteres = pcaValorInteres;
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

    @ManyToOne
    @JoinColumn(name = "CCU_CODIGO")
    public SiiConceptoCuota getSiiConceptoCuota() {
        return siiConceptoCuota;
    }

    public void setSiiConceptoCuota(SiiConceptoCuota siiConceptoCuota) {
        this.siiConceptoCuota = siiConceptoCuota;
    }

    @OneToMany(mappedBy = "siiPagoCargaActAdm")
    public List<SiiDetalleRecaudo> getSiiDetalleRecaudoList() {
        return siiDetalleRecaudoList;
    }

    public void setSiiDetalleRecaudoList(List<SiiDetalleRecaudo> siiDetalleRecaudoList) {
        this.siiDetalleRecaudoList = siiDetalleRecaudoList;
    }

    public SiiDetalleRecaudo addSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().add(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiPagoCargaActAdm(this);
        return siiDetalleRecaudo;
    }

    public SiiDetalleRecaudo removeSiiDetalleRecaudo(SiiDetalleRecaudo siiDetalleRecaudo) {
        getSiiDetalleRecaudoList().remove(siiDetalleRecaudo);
        siiDetalleRecaudo.setSiiPagoCargaActAdm(null);
        return siiDetalleRecaudo;
    }
}
