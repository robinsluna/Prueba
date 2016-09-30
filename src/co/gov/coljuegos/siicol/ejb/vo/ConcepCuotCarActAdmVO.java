package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepCuotCarActAdm;

import java.math.BigDecimal;

import java.util.List;

public class ConcepCuotCarActAdmVO{
    
    private String camActivo;
    private Long camCodigo;
    private BigDecimal camValor;
    private CargaActuacionesAdmVO cargaActuacionesAdmVo;
    private ConceptoCuotaVO conceptoCuotaVo;
    private UsuarioVO UsuarioConectadoVo;
    private List<EstablecConCuoCarVO> listEstablecConCuoCarVo;
    // datos para grilla
    private Long ccuCodigo;
    private String ccuNombre;
    
    
    public ConcepCuotCarActAdmVO(SiiConcepCuotCarActAdm siiConcepCuotCarActAdm){
        
        this.camActivo =  siiConcepCuotCarActAdm.getCamActivo();  
        this.camCodigo = siiConcepCuotCarActAdm.getCamCodigo();
        this.camValor = siiConcepCuotCarActAdm.getCamValor();
        
        if(siiConcepCuotCarActAdm.getSiiCargaActuacionesAdm() != null  )
            this.cargaActuacionesAdmVo = new CargaActuacionesAdmVO(siiConcepCuotCarActAdm.getSiiCargaActuacionesAdm());
        
        if(siiConcepCuotCarActAdm.getSiiConceptoCuota() != null )
            this.conceptoCuotaVo = new ConceptoCuotaVO(siiConcepCuotCarActAdm.getSiiConceptoCuota());
        
        if(siiConcepCuotCarActAdm.getSiiUsuarioConectado() != null )
            this.UsuarioConectadoVo = new UsuarioVO(siiConcepCuotCarActAdm.getSiiUsuarioConectado());
        
    }
    
    public ConcepCuotCarActAdmVO(){
        
        
    }


    public void setCamActivo(String camActivo){
        this.camActivo = camActivo;
    }

    public String getCamActivo(){
        return camActivo;
    }

    public void setCamCodigo(Long camCodigo){
        this.camCodigo = camCodigo;
    }

    public Long getCamCodigo(){
        return camCodigo;
    }


    public void setCamValor(BigDecimal camValor){
        this.camValor = camValor;
    }

    public BigDecimal getCamValor(){
        return camValor;
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

    public void setUsuarioConectadoVo(UsuarioVO UsuarioConectadoVo){
        this.UsuarioConectadoVo = UsuarioConectadoVo;
    }

    public UsuarioVO getUsuarioConectadoVo(){
        return UsuarioConectadoVo;
    }

    public void setCcuCodigo(Long ccuCodigo){
        this.ccuCodigo = ccuCodigo;
    }

    public Long getCcuCodigo(){
        return ccuCodigo;
    }

    public void setCcuNombre(String ccuNombre){
        this.ccuNombre = ccuNombre;
    }

    public String getCcuNombre(){
        return ccuNombre;
    }

    public void setListEstablecConCuoCarVo(List<EstablecConCuoCarVO> listEstablecConCuoCarVo){
        this.listEstablecConCuoCarVo = listEstablecConCuoCarVo;
    }

    public List<EstablecConCuoCarVO> getListEstablecConCuoCarVo(){
        return listEstablecConCuoCarVo;
    }

 
}
