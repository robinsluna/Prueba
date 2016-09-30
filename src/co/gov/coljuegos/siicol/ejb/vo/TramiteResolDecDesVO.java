/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 27-10-2015
 */
package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolDecDes;

import java.util.Date;

/**
 * Value object que gestiona los trámites de Resolución de Decomiso y Destrucción.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public class TramiteResolDecDesVO {

    private Long trdCodigo;
    private Date trdFecha;

    private EstadoTramResDecDesVO estadoTramResDecDesVo;
    private UsuarioVO usuarioConectVo;
    private ResolucionDecomDestVO resolucionDecomDestVo;

    /**
     * Constructor.
     */
    
    public TramiteResolDecDesVO(){
        
    }

    public TramiteResolDecDesVO(SiiTramiteResolDecDes siiTramiteResolDecDes) {

        if (siiTramiteResolDecDes != null) {
            this.trdCodigo = siiTramiteResolDecDes.getTrdCodigo();
            this.trdFecha = siiTramiteResolDecDes.getTrdFecha();

            if (siiTramiteResolDecDes.getSiiEstadoTramResDecDes() != null) {
                this.estadoTramResDecDesVo =
                    new EstadoTramResDecDesVO(siiTramiteResolDecDes.getSiiEstadoTramResDecDes());
            }

            if (siiTramiteResolDecDes.getSiiResolucionDecomDest() != null) {
                this.resolucionDecomDestVo =
                    new ResolucionDecomDestVO(siiTramiteResolDecDes.getSiiResolucionDecomDest());
            }
            
            if(siiTramiteResolDecDes.getSiiUsuarioConect()!=null){
                this.usuarioConectVo= new UsuarioVO(siiTramiteResolDecDes.getSiiUsuarioConect());
            }
        }

    }

    public void setTrdCodigo(Long trdCodigo) {
        this.trdCodigo = trdCodigo;
    }

    public Long getTrdCodigo() {
        return trdCodigo;
    }

    public void setTrdFecha(Date trdFecha) {
        this.trdFecha = trdFecha;
    }

    public Date getTrdFecha() {
        return trdFecha;
    }

    public void setEstadoTramResDecDesVo(EstadoTramResDecDesVO estadoTramResDecDesVo) {
        this.estadoTramResDecDesVo = estadoTramResDecDesVo;
    }

    public EstadoTramResDecDesVO getEstadoTramResDecDesVo() {
        return estadoTramResDecDesVo;
    }

    public void setUsuarioConectVo(UsuarioVO usuarioConectVo) {
        this.usuarioConectVo = usuarioConectVo;
    }

    public UsuarioVO getUsuarioConectVo() {
        return usuarioConectVo;
    }

    public void setResolucionDecomDestVo(ResolucionDecomDestVO resolucionDecomDestVo) {
        this.resolucionDecomDestVo = resolucionDecomDestVo;
    }

    public ResolucionDecomDestVO getResolucionDecomDestVo() {
        return resolucionDecomDestVo;
    }

}
