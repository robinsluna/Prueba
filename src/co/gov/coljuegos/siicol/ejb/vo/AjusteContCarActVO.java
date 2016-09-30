package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAjusteContCarAct;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaActuacionesAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConcepCuotCarActAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.math.BigDecimal;

import java.util.Date;

public class AjusteContCarActVO{
    
    private String ajcActivo;
    private String ajcDescripcion;
    private Long ajcCodigo;
    private BigDecimal ajcValor;
    private Date ajcFechaAjuste;
    private UsuarioVO usuarioConectadoVo;
    private CargaActuacionesAdmVO cargaActuacionesAdmVo;
    private ConcepCuotCarActAdmVO concepCuotCarActAdmVo;
    //para grilla
    private String ccuNombre;
    
     
    public AjusteContCarActVO(){

    }
    
    public AjusteContCarActVO(SiiAjusteContCarAct siiAjusteContCarAct){
        
        this.ajcActivo = siiAjusteContCarAct.getAjcActivo();
        this.ajcCodigo = siiAjusteContCarAct.getAjcCodigo();
        this.ajcValor = siiAjusteContCarAct.getAjcValor();
        this.ajcDescripcion = siiAjusteContCarAct.getAjcDescripcion();
        this.ajcFechaAjuste = siiAjusteContCarAct.getAjcFecha();
        
        if (siiAjusteContCarAct.getSiiUsuarioConectado() != null ){
            this.usuarioConectadoVo = new UsuarioVO(siiAjusteContCarAct.getSiiUsuarioConectado());
        }
        if (siiAjusteContCarAct.getSiiCargaActuacionesAdm() != null){
            this.cargaActuacionesAdmVo = new CargaActuacionesAdmVO(siiAjusteContCarAct.getSiiCargaActuacionesAdm());
        }
        if (siiAjusteContCarAct.getSiiConcepCuotCarActAdm() != null){
            this.concepCuotCarActAdmVo = new ConcepCuotCarActAdmVO(siiAjusteContCarAct.getSiiConcepCuotCarActAdm());
        }

    }


    public void setAjcActivo(String ajcActivo){
        this.ajcActivo = ajcActivo;
    }

    public String getAjcActivo(){
        return ajcActivo;
    }

    public void setAjcCodigo(Long ajcCodigo){
        this.ajcCodigo = ajcCodigo;
    }

    public Long getAjcCodigo(){
        return ajcCodigo;
    }

    public void setAjcValor(BigDecimal ajcValor){
        this.ajcValor = ajcValor;
    }

    public BigDecimal getAjcValor(){
        return ajcValor;
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


    public void setCcuNombre(String ccuNombre){
        this.ccuNombre = ccuNombre;
    }

    public String getCcuNombre(){
        return ccuNombre;
    }

    public void setAjcDescripcion(String ajcDescripcion){
        this.ajcDescripcion = ajcDescripcion;
    }

    public String getAjcDescripcion(){
        return ajcDescripcion;
    }

    public void setAjcFechaAjuste(Date ajcFechaAjuste){
        this.ajcFechaAjuste = ajcFechaAjuste;
    }

    public Date getAjcFechaAjuste(){
        return ajcFechaAjuste;
    }

    public void setConcepCuotCarActAdmVo(ConcepCuotCarActAdmVO concepCuotCarActAdmVo){
        this.concepCuotCarActAdmVo = concepCuotCarActAdmVo;
    }

    public ConcepCuotCarActAdmVO getConcepCuotCarActAdmVo(){
        return concepCuotCarActAdmVo;
    }
}
