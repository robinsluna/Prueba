package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaActuacionesAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoCuota;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPagoCargaActAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.math.BigDecimal;

import java.util.Date;

public class PagoCargaActAdmVO{
  
    private String pcaActivo;
    private Long pcaCodigo;
    private Date pcaFechaPago;
    private BigDecimal pcaValorCapital;
    private BigDecimal pcaValorInteres;
    private UsuarioVO usuarioConectadoVo;
    private CargaActuacionesAdmVO cargaActuacionesAdmVo;
    private ConceptoCuotaVO conceptoCuotaVo;
    private String ccuNombre;
    private Long diasPago;

    public PagoCargaActAdmVO(SiiPagoCargaActAdm siiPagoCargaActAdm){
        this.pcaActivo = siiPagoCargaActAdm.getPcaActivo();
        this.pcaCodigo = siiPagoCargaActAdm.getPcaCodigo();
        this.pcaFechaPago = siiPagoCargaActAdm.getPcaFechaPago();
        this.pcaValorCapital = siiPagoCargaActAdm.getPcaValorCapital();
        this.pcaValorInteres = siiPagoCargaActAdm.getPcaValorInteres();
        
        if (siiPagoCargaActAdm.getSiiUsuarioConectado() != null  )
            this.usuarioConectadoVo = new UsuarioVO(siiPagoCargaActAdm.getSiiUsuarioConectado());
        
        if (siiPagoCargaActAdm.getSiiCargaActuacionesAdm() != null )
            this.cargaActuacionesAdmVo = new CargaActuacionesAdmVO(siiPagoCargaActAdm.getSiiCargaActuacionesAdm());
        
        if (siiPagoCargaActAdm.getSiiConceptoCuota() != null )
            this.conceptoCuotaVo = new ConceptoCuotaVO(siiPagoCargaActAdm.getSiiConceptoCuota() );
        
    }
  
    public PagoCargaActAdmVO(){
       
    }

    public void setPcaActivo(String pcaActivo){
        this.pcaActivo = pcaActivo;
    }

    public String getPcaActivo(){
        return pcaActivo;
    }

    public void setPcaCodigo(Long pcaCodigo){
        this.pcaCodigo = pcaCodigo;
    }

    public Long getPcaCodigo(){
        return pcaCodigo;
    }

    public void setPcaFechaPago(Date pcaFechaPago){
        this.pcaFechaPago = pcaFechaPago;
    }

    public Date getPcaFechaPago(){
        return pcaFechaPago;
    }

    public void setPcaValorCapital(BigDecimal pcaValorCapital){
        this.pcaValorCapital = pcaValorCapital;
    }

    public BigDecimal getPcaValorCapital(){
        return pcaValorCapital;
    }


    public void setPcaValorInteres(BigDecimal pcaValorInteres){
        this.pcaValorInteres = pcaValorInteres;
    }

    public BigDecimal getPcaValorInteres(){
        return pcaValorInteres;
    }

    public void setUsuarioConectadoVo(UsuarioVO usuarioConectadoVo){
        this.usuarioConectadoVo = usuarioConectadoVo;
    }

    public UsuarioVO getUsuarioConectadoVo(){
        return usuarioConectadoVo;
    }

    public void setCargaActuacionesAdmVo(CargaActuacionesAdmVO cargaActuacionesAdmVo){
        this.cargaActuacionesAdmVo = cargaActuacionesAdmVo;
    }

    public CargaActuacionesAdmVO getCargaActuacionesAdmVo(){
        return cargaActuacionesAdmVo;
    }

    public void setConceptoCuotaVo(ConceptoCuotaVO conceptoCuotaVo){
        this.conceptoCuotaVo = conceptoCuotaVo;
    }

    public ConceptoCuotaVO getConceptoCuotaVo(){
        return conceptoCuotaVo;
    }

    public void setCcuNombre(String ccuNombre){
        this.ccuNombre = ccuNombre;
    }

    public String getCcuNombre(){
        return ccuNombre;
    }


    public void setDiasPago(Long diasPago) {
        this.diasPago = diasPago;
    }

    public Long getDiasPago() {
        return diasPago;
    }
}
