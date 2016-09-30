package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermisoRolModulo;


public class PermisoRolModuloVO {
    
    private Long prmCodigo;
    private RolVO rolVo;
    private ModuloVO moduloVo;
    private PermisoVO permisoVo;
    
    public PermisoRolModuloVO() {
    }
    
    public PermisoRolModuloVO(SiiPermisoRolModulo siiPermisoRolModulo) {
        this.prmCodigo = siiPermisoRolModulo.getPrmCodigo();
        //Padres
        if(siiPermisoRolModulo.getSiiRol() !=  null){
            this.rolVo = new RolVO(siiPermisoRolModulo.getSiiRol());
        }
        if(siiPermisoRolModulo.getSiiModulo1() != null){
            this.moduloVo = new ModuloVO(siiPermisoRolModulo.getSiiModulo1());
        }
        if(siiPermisoRolModulo.getSiiPermiso() != null){
            this.permisoVo = new PermisoVO(siiPermisoRolModulo.getSiiPermiso());
        }
    }


    public void setPrmCodigo(Long prmCodigo) {
        this.prmCodigo = prmCodigo;
    }

    public Long getPrmCodigo() {
        return prmCodigo;
    }

    public void setRolVo(RolVO rolVo) {
        this.rolVo = rolVo;
    }

    public RolVO getRolVo() {
        return rolVo;
    }

    public void setModuloVo(ModuloVO moduloVo) {
        this.moduloVo = moduloVo;
    }

    public ModuloVO getModuloVo() {
        return moduloVo;
    }

    public void setPermisoVo(PermisoVO permisoVo) {
        this.permisoVo = permisoVo;
    }

    public PermisoVO getPermisoVo() {
        return permisoVo;
    }
}
