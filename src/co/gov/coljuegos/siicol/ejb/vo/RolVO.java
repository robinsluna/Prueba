package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRol;

import java.util.List;

public class RolVO {
    
    private String rolActivo;
    private Long rolCodigo;
    private String rolDescripcion;
    private String rolNombre;
    private List<PermisoRolModuloVO> permisoRolModuloVoList;
    private List<UsuarioRolVO> usuarioRolVoList;
    private boolean seleccionado;
    private UsuarioVO usuarioConectadoVo;
    
    public RolVO() {
    }
    
    public RolVO(SiiRol siiRol) {
        this.rolActivo = siiRol.getRolActivo();
        this.rolCodigo = siiRol.getRolCodigo();
        this.rolDescripcion = siiRol.getRolDescripcion();
        this.rolNombre = siiRol.getRolNombre();
    }


    public void setRolActivo(String rolActivo) {
        this.rolActivo = rolActivo;
    }

    public String getRolActivo() {
        return rolActivo;
    }

    public void setRolCodigo(Long rolCodigo) {
        this.rolCodigo = rolCodigo;
    }

    public Long getRolCodigo() {
        return rolCodigo;
    }

    public void setRolDescripcion(String rolDescripcion) {
        this.rolDescripcion = rolDescripcion;
    }

    public String getRolDescripcion() {
        return rolDescripcion;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setPermisoRolModuloVoList(List<PermisoRolModuloVO> permisoRolModuloVoList) {
        this.permisoRolModuloVoList = permisoRolModuloVoList;
    }

    public List<PermisoRolModuloVO> getPermisoRolModuloVoList() {
        return permisoRolModuloVoList;
    }


    public void setUsuarioRolVoList(List<UsuarioRolVO> usuarioRolVoList) {
        this.usuarioRolVoList = usuarioRolVoList;
    }

    public List<UsuarioRolVO> getUsuarioRolVoList() {
        return usuarioRolVoList;
    }

    public void setActivo(boolean activo) {
        this.rolActivo = activo?"S":"N";
    }

    public boolean isActivo() {
        return "S".equals(this.rolActivo);
    }

    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }
    
    public void setUsuarioConectadoVo(UsuarioVO usuarioConectadoVo) {
        this.usuarioConectadoVo = usuarioConectadoVo;
    }

    public UsuarioVO getUsuarioConectadoVo() {
        return usuarioConectadoVo;
    }
}
