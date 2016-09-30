package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaActuacionesAdm;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoProyeccionCar;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProyeccionCargaAct;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;

import java.util.Date;
import java.util.List;

public class ProyeccionCargaActVO{

    private Long pycCodigo;
    private String pycEstado;
    private Date pycFechaLiq;
    private UsuarioVO usuarioConectadoVo;
    private CargaActuacionesAdmVO cargaActuacionesAdmVo;
    private Integer pycConsecutivo;
    
    
    public ProyeccionCargaActVO(){
    }
    
    public ProyeccionCargaActVO(SiiProyeccionCargaAct siiProyeccionCargaAct){
    this.pycCodigo = siiProyeccionCargaAct.getPycCodigo();
    this.pycEstado = siiProyeccionCargaAct.getPycEstado();
    this.pycFechaLiq = siiProyeccionCargaAct.getPycFechaLiq();
    
        if(siiProyeccionCargaAct.getSiiCargaActuacionesAdm() != null )
            this.cargaActuacionesAdmVo = new CargaActuacionesAdmVO (siiProyeccionCargaAct.getSiiCargaActuacionesAdm());
     
        if(siiProyeccionCargaAct.getSiiUsuarioConectado() != null )
            this.usuarioConectadoVo = new UsuarioVO (siiProyeccionCargaAct.getSiiUsuarioConectado());
    }


    public void setPycCodigo(Long pycCodigo){
        this.pycCodigo = pycCodigo;
    }

    public Long getPycCodigo(){
        return pycCodigo;
    }

    public void setPycEstado(String pycEstado){
        this.pycEstado = pycEstado;
    }

    public String getPycEstado(){
        return pycEstado;
    }

    public void setPycFechaLiq(Date pycFechaLiq){
        this.pycFechaLiq = pycFechaLiq;
    }

    public Date getPycFechaLiq(){
        return pycFechaLiq;
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

 
}
