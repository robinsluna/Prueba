package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConsultaWebContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCotizacionEstudio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioMercado;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemCotizacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedor;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoServicio;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;

import java.util.List;

public class CotizacionEstudioVO {
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
    private List<ItemCotizacionVO> itemCotizacionListVO1;
    private EstudioMercadoVO estudioMercadoVO;
    private ProveedorVO proveedorVO;
    private ConsultaWebContratVO consultaWebContratVO;
    private TipoServicioVO tipoServicioVO;
    private UbicacionVO ubicacionVO;
    
    public CotizacionEstudioVO() {
    }


    public CotizacionEstudioVO(SiiCotizacionEstudio cotizacionEstudio) {
        this.cesCodigo = cotizacionEstudio.getCesCodigo();
        this.cesCondPago = cotizacionEstudio.getCesCondPago();
        this.cesDescPronto = cotizacionEstudio.getCesDescPronto();
        this.cesGarantia = cotizacionEstudio.getCesGarantia();
        this.cesIva = cotizacionEstudio.getCesIva();
        this.cesTiempoEntrega = cotizacionEstudio.getCesTiempoEntrega();
        this.cesValorTotal = cotizacionEstudio.getCesValorTotal();
        this.cesVigPolizas = cotizacionEstudio.getCesVigPolizas();
        this.cesVigencia = cotizacionEstudio.getCesVigencia();
        this.cesEspecificac = cotizacionEstudio.getCesEspecificac();
        //Padres:
        if(cotizacionEstudio.getSiiConsultaWebContrat() != null){
            this.consultaWebContratVO = new ConsultaWebContratVO(cotizacionEstudio.getSiiConsultaWebContrat());
        }
        
        if (cotizacionEstudio.getSiiEstudioMercado() != null ) {
            this.estudioMercadoVO = new EstudioMercadoVO(cotizacionEstudio.getSiiEstudioMercado());
        }
        
        if (cotizacionEstudio.getSiiProveedor()!=null) {
            this.proveedorVO = new ProveedorVO(cotizacionEstudio.getSiiProveedor());
        }
        if (cotizacionEstudio.getSiiTipoServicio()!=null) {
            this.tipoServicioVO = new TipoServicioVO(cotizacionEstudio.getSiiTipoServicio());
        }
        if (cotizacionEstudio.getSiiUbicacion1() !=null) {
            this.ubicacionVO = new UbicacionVO(cotizacionEstudio.getSiiUbicacion1());
        }
        
    }

    public void setCesCodigo(Long cesCodigo) {
        this.cesCodigo = cesCodigo;
    }

    public Long getCesCodigo() {
        return cesCodigo;
    }

    public void setCesCondPago(String cesCondPago) {
        this.cesCondPago = cesCondPago;
    }

    public String getCesCondPago() {
        return cesCondPago;
    }

    public void setCesDescPronto(Long cesDescPronto) {
        this.cesDescPronto = cesDescPronto;
    }

    public Long getCesDescPronto() {
        return cesDescPronto;
    }

    public void setCesGarantia(String cesGarantia) {
        this.cesGarantia = cesGarantia;
    }

    public String getCesGarantia() {
        return cesGarantia;
    }

    public void setCesIva(Long cesIva) {
        this.cesIva = cesIva;
    }

    public Long getCesIva() {
        return cesIva;
    }

    public void setCesTiempoEntrega(Integer cesTiempoEntrega) {
        this.cesTiempoEntrega = cesTiempoEntrega;
    }

    public Integer getCesTiempoEntrega() {
        return cesTiempoEntrega;
    }

    public void setCesValorTotal(Long cesValorTotal) {
        this.cesValorTotal = cesValorTotal;
    }

    public Long getCesValorTotal() {
        return cesValorTotal;
    }

    public void setCesVigencia(String cesVigencia) {
        this.cesVigencia = cesVigencia;
    }

    public String getCesVigencia() {
        return cesVigencia;
    }

    public void setCesVigPolizas(String cesVigPolizas) {
        this.cesVigPolizas = cesVigPolizas;
    }

    public String getCesVigPolizas() {
        return cesVigPolizas;
    }

    public void setItemCotizacionListVO1(List<ItemCotizacionVO> itemCotizacionListVO1) {
        this.itemCotizacionListVO1 = itemCotizacionListVO1;
    }

    public List<ItemCotizacionVO> getItemCotizacionListVO1() {
        return itemCotizacionListVO1;
    }

    public void setEstudioMercadoVO(EstudioMercadoVO estudioMercadoVO) {
        this.estudioMercadoVO = estudioMercadoVO;
    }

    public EstudioMercadoVO getEstudioMercadoVO() {
        return estudioMercadoVO;
    }

    public void setProveedorVO(ProveedorVO proveedorVO) {
        this.proveedorVO = proveedorVO;
    }

    public ProveedorVO getProveedorVO() {
        return proveedorVO;
    }

    public void setConsultaWebContratVO(ConsultaWebContratVO consultaWebContratVO) {
        this.consultaWebContratVO = consultaWebContratVO;
    }

    public ConsultaWebContratVO getConsultaWebContratVO() {
        return consultaWebContratVO;
    }

    public void setTipoServicioVO(TipoServicioVO tipoServicioVO) {
        this.tipoServicioVO = tipoServicioVO;
    }

    public TipoServicioVO getTipoServicioVO() {
        return tipoServicioVO;
    }


    public void setUbicacionVO(UbicacionVO ubicacionVO) {
        this.ubicacionVO = ubicacionVO;
    }

    public UbicacionVO getUbicacionVO() {
        return ubicacionVO;
    }

    public void setCesEspecificac(String cesEspecificac) {
        this.cesEspecificac = cesEspecificac;
    }

    public String getCesEspecificac() {
        return cesEspecificac;
    }
}

