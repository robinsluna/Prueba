package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuarioRol;

public class UsuarioRolVO {
    
    private Long uroCodigo;
    private UsuarioVO usuarioVo;
    private RolVO rolVo;
    
    public UsuarioRolVO() {
    }
    
    public UsuarioRolVO(SiiUsuarioRol siiUsuarioRol) {
        this.uroCodigo = siiUsuarioRol.getUroCodigo();
        if(siiUsuarioRol.getSiiUsuario() != null){
            this.usuarioVo = new UsuarioVO(siiUsuarioRol.getSiiUsuario());
        }
        if(siiUsuarioRol.getSiiRol1() != null){
            this.rolVo = new RolVO(siiUsuarioRol.getSiiRol1());
        }
    }


    public void setUroCodigo(Long uroCodigo) {
        this.uroCodigo = uroCodigo;
    }

    public Long getUroCodigo() {
        return uroCodigo;
    }

    public void setUsuarioVo(UsuarioVO usuarioVo) {
        this.usuarioVo = usuarioVo;
    }

    public UsuarioVO getUsuarioVo() {
        return usuarioVo;
    }

    public void setRolVo(RolVO rolVo) {
        this.rolVo = rolVo;
    }

    public RolVO getRolVo() {
        return rolVo;
    }
}
