package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiContratoProveedor;

import java.math.BigDecimal;

import java.util.Date;

public class ContratoProveedorVO {
    private Long cprCodigo;
    private Date cprFecha;
    private BigDecimal cprValor;
    private EstadoContrProvVO estadoContrProvVo;
    private OficioAdjudicaVO oficioAdjudicaVo;
    private ArchivoFisicoVO archivoFisicoVo;
    private Long idEstadoAnterior;
    
    public ContratoProveedorVO() {        
    }
    
    public ContratoProveedorVO(SiiContratoProveedor siiContratoProveedor){
        this.cprCodigo = siiContratoProveedor.getCprCodigo();
        this.cprFecha = siiContratoProveedor.getCprFecha();
        this.cprValor = siiContratoProveedor.getCprValor();
        
        //Estado
        if(siiContratoProveedor.getSiiEstadoContrProv() != null){
            this.estadoContrProvVo = new EstadoContrProvVO(siiContratoProveedor.getSiiEstadoContrProv());
            this.idEstadoAnterior = siiContratoProveedor.getSiiEstadoContrProv().getEcpCodigo();
        }
        if (siiContratoProveedor.getSiiOficioAdjudica() != null){
            this.oficioAdjudicaVo = new OficioAdjudicaVO(siiContratoProveedor.getSiiOficioAdjudica());
        }
        if (siiContratoProveedor.getSiiArchivoFisico() != null){
            this.archivoFisicoVo = new ArchivoFisicoVO(siiContratoProveedor.getSiiArchivoFisico());
        }
    }

    public void setCprCodigo(Long cprCodigo) {
        this.cprCodigo = cprCodigo;
    }

    public Long getCprCodigo() {
        return cprCodigo;
    }

    public void setCprFecha(Date cprFecha) {
        this.cprFecha = cprFecha;
    }

    public Date getCprFecha() {
        return cprFecha;
    }

    public void setCprValor(BigDecimal cprValor) {
        this.cprValor = cprValor;
    }

    public BigDecimal getCprValor() {
        return cprValor;
    }

    public void setEstadoContrProvVo(EstadoContrProvVO estadoContrProvVo) {
        this.estadoContrProvVo = estadoContrProvVo;
    }

    public EstadoContrProvVO getEstadoContrProvVo() {
        return estadoContrProvVo;
    }

    public void setOficioAdjudicaVo(OficioAdjudicaVO oficioAdjudicaVo) {
        this.oficioAdjudicaVo = oficioAdjudicaVo;
    }

    public OficioAdjudicaVO getOficioAdjudicaVo() {
        return oficioAdjudicaVo;
    }

    public void setArchivoFisicoVo(ArchivoFisicoVO archivoFisicoVo) {
        this.archivoFisicoVo = archivoFisicoVo;
    }

    public ArchivoFisicoVO getArchivoFisicoVo() {
        return archivoFisicoVo;
    }

    public Long getIdEstadoAnterior() {
        return idEstadoAnterior;
    }

    public void setIdEstadoAnterior(Long idEstadoAnterior) {
        this.idEstadoAnterior = idEstadoAnterior;
    }
}

