package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCorteCartera;

import java.util.Date;

public class CorteCarteraVO {
    
    private Long ccaCodigo;
    private Date ccaFecha;
    private Integer ccaVigencia;
    private MesVO mesVo;
    //private List<SiiDetCorteCartera> siiDetCorteCarteraList;
    private UsuarioVO usuarioVo;
    
    
    public CorteCarteraVO() {
    }
    
    public CorteCarteraVO(SiiCorteCartera siiCorteCartera) {
        this.ccaCodigo = siiCorteCartera.getCcaCodigo();
        this.ccaFecha = siiCorteCartera.getCcaFecha();
        this.ccaVigencia = siiCorteCartera.getCcaVigencia();
        if(siiCorteCartera.getSiiMes() != null){
            this.mesVo = new MesVO(siiCorteCartera.getSiiMes() );
        }
        if(siiCorteCartera.getSiiUsuario() != null){
            this.usuarioVo = new UsuarioVO(siiCorteCartera.getSiiUsuario());
        }
    }


    public void setCcaCodigo(Long ccaCodigo) {
        this.ccaCodigo = ccaCodigo;
    }

    public Long getCcaCodigo() {
        return ccaCodigo;
    }

    public void setCcaFecha(Date ccaFecha) {
        this.ccaFecha = ccaFecha;
    }

    public Date getCcaFecha() {
        return ccaFecha;
    }

    public void setCcaVigencia(Integer ccaVigencia) {
        this.ccaVigencia = ccaVigencia;
    }

    public Integer getCcaVigencia() {
        return ccaVigencia;
    }


    public void setMesVo(MesVO mesVo) {
        this.mesVo = mesVo;
    }

    public MesVO getMesVo() {
        return mesVo;
    }

    public void setUsuarioVo(UsuarioVO usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public UsuarioVO getUsuarioVo() {
        return usuarioVo;
    }
}
