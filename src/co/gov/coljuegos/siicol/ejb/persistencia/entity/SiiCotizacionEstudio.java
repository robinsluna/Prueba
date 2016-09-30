package co.gov.coljuegos.siicol.ejb.persistencia.entity;

import java.io.Serializable;

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

@Entity
@Table(name = "SII_COTIZACION_ESTUDIO")
public class SiiCotizacionEstudio implements Serializable {
    private static final long serialVersionUID = -2296316265248929535L;
    private Long cesCodigo;
    private String cesCondPago;
    private Long cesDescPronto;
    private String cesEspecificac;
    private String cesGarantia;
    private Long cesIva;
    private Integer cesTiempoEntrega;
    private Long cesValorTotal;
    private String cesVigencia;
    private String cesVigPolizas;
    private List<SiiItemCotizacion> siiItemCotizacionList1;
    private SiiEstudioMercado siiEstudioMercado;
    private SiiProveedor siiProveedor;
    private SiiConsultaWebContrat siiConsultaWebContrat;
    private SiiTipoServicio siiTipoServicio;
    private SiiUbicacion siiUbicacion1;

    public SiiCotizacionEstudio() {
    }

    public SiiCotizacionEstudio(Long cesCodigo, String cesCondPago, Long cesDescPronto, String cesGarantia, Long cesIva,
                                Integer cesTiempoEntrega, Long cesValorTotal, String cesVigPolizas, String cesVigencia,
                                SiiConsultaWebContrat siiConsultaWebContrat, SiiEstudioMercado siiEstudioMercado,
                                SiiProveedor siiProveedor, SiiTipoServicio siiTipoServicio, SiiUbicacion siiUbicacion1, String cesEspecificac) {
        this.cesCodigo = cesCodigo;
        this.cesCondPago = cesCondPago;
        this.cesDescPronto = cesDescPronto;
        this.cesEspecificac = cesEspecificac;
        this.cesGarantia = cesGarantia;
        this.cesIva = cesIva;
        this.cesTiempoEntrega = cesTiempoEntrega;
        this.cesValorTotal = cesValorTotal;
        this.cesVigPolizas = cesVigPolizas;
        this.cesVigencia = cesVigencia;
        this.siiConsultaWebContrat = siiConsultaWebContrat;
        this.siiEstudioMercado = siiEstudioMercado;
        this.siiProveedor = siiProveedor;
        this.siiTipoServicio = siiTipoServicio;
        this.siiUbicacion1 = siiUbicacion1;
    }

    @Id
    @Column(name = "CES_CODIGO", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "SEQ_COTIZ_EST_CODIGO")
    @SequenceGenerator(name = "SEQ_COTIZ_EST_CODIGO", sequenceName = "SEQ_COTIZ_EST_CODIGO",allocationSize=1)
    public Long getCesCodigo() {
        return cesCodigo;
    }

    public void setCesCodigo(Long cesCodigo) {
        this.cesCodigo = cesCodigo;
    }

    @Column(name = "CES_COND_PAGO", nullable = false, length = 500)
    public String getCesCondPago() {
        return cesCondPago;
    }

    public void setCesCondPago(String cesCondPago) {
        this.cesCondPago = cesCondPago;
    }

    @Column(name = "CES_DESC_PRONTO")
    public Long getCesDescPronto() {
        return cesDescPronto;
    }

    public void setCesDescPronto(Long cesDescPronto) {
        this.cesDescPronto = cesDescPronto;
    }

    @Column(name = "CES_ESPECIFICAC", length = 1000)
    public String getCesEspecificac() {
        return cesEspecificac;
    }

    public void setCesEspecificac(String cesEspecificac) {
        this.cesEspecificac = cesEspecificac;
    }

    @Column(name = "CES_GARANTIA", nullable = false, length = 500)
    public String getCesGarantia() {
        return cesGarantia;
    }

    public void setCesGarantia(String cesGarantia) {
        this.cesGarantia = cesGarantia;
    }

    @Column(name = "CES_IVA", nullable = false)
    public Long getCesIva() {
        return cesIva;
    }

    public void setCesIva(Long cesIva) {
        this.cesIva = cesIva;
    }

    @Column(name = "CES_TIEMPO_ENTREGA", nullable = false)
    public Integer getCesTiempoEntrega() {
        return cesTiempoEntrega;
    }

    public void setCesTiempoEntrega(Integer cesTiempoEntrega) {
        this.cesTiempoEntrega = cesTiempoEntrega;
    }

    @Column(name = "CES_VALOR_TOTAL", nullable = false)
    public Long getCesValorTotal() {
        return cesValorTotal;
    }

    public void setCesValorTotal(Long cesValorTotal) {
        this.cesValorTotal = cesValorTotal;
    }

    @Column(name = "CES_VIGENCIA", nullable = false, length = 100)
    public String getCesVigencia() {
        return cesVigencia;
    }

    public void setCesVigencia(String cesVigencia) {
        this.cesVigencia = cesVigencia;
    }

    @Column(name = "CES_VIG_POLIZAS", nullable = false, length = 500)
    public String getCesVigPolizas() {
        return cesVigPolizas;
    }

    public void setCesVigPolizas(String cesVigPolizas) {
        this.cesVigPolizas = cesVigPolizas;
    }


    @OneToMany(mappedBy = "siiCotizacionEstudio")
    public List<SiiItemCotizacion> getSiiItemCotizacionList1() {
        return siiItemCotizacionList1;
    }

    public void setSiiItemCotizacionList1(List<SiiItemCotizacion> siiItemCotizacionList1) {
        this.siiItemCotizacionList1 = siiItemCotizacionList1;
    }

    public SiiItemCotizacion addSiiItemCotizacion(SiiItemCotizacion siiItemCotizacion) {
        getSiiItemCotizacionList1().add(siiItemCotizacion);
        siiItemCotizacion.setSiiCotizacionEstudio(this);
        return siiItemCotizacion;
    }

    public SiiItemCotizacion removeSiiItemCotizacion(SiiItemCotizacion siiItemCotizacion) {
        getSiiItemCotizacionList1().remove(siiItemCotizacion);
        siiItemCotizacion.setSiiCotizacionEstudio(null);
        return siiItemCotizacion;
    }

    @ManyToOne
    @JoinColumn(name = "EME_CODIGO")
    public SiiEstudioMercado getSiiEstudioMercado() {
        return siiEstudioMercado;
    }

    public void setSiiEstudioMercado(SiiEstudioMercado siiEstudioMercado) {
        this.siiEstudioMercado = siiEstudioMercado;
    }

    @ManyToOne
    @JoinColumn(name = "PRO_CODIGO")
    public SiiProveedor getSiiProveedor() {
        return siiProveedor;
    }

    public void setSiiProveedor(SiiProveedor siiProveedor) {
        this.siiProveedor = siiProveedor;
    }

    @ManyToOne
    @JoinColumn(name = "CWC_CODIGO")
    public SiiConsultaWebContrat getSiiConsultaWebContrat() {
        return siiConsultaWebContrat;
    }

    public void setSiiConsultaWebContrat(SiiConsultaWebContrat siiConsultaWebContrat) {
        this.siiConsultaWebContrat = siiConsultaWebContrat;
    }

    @ManyToOne
    @JoinColumn(name = "TSE_CODIGO")
    public SiiTipoServicio getSiiTipoServicio() {
        return siiTipoServicio;
    }

    public void setSiiTipoServicio(SiiTipoServicio siiTipoServicio) {
        this.siiTipoServicio = siiTipoServicio;
    }

    @ManyToOne
    @JoinColumn(name = "UBI_CODIGO_ENTREGA")
    public SiiUbicacion getSiiUbicacion1() {
        return siiUbicacion1;
    }

    public void setSiiUbicacion1(SiiUbicacion siiUbicacion1) {
        this.siiUbicacion1 = siiUbicacion1;
    }
}
