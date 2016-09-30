package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPermiso;

import java.util.List;

public class PermisoVO {
    
    private Long pmsCodigo;
    private String pmsNombre;
    private List<PermisoRolModuloVO> permisoRolModuloVoList;
    private boolean seleccionado = false;
    
    public PermisoVO() {
    }
    
    public PermisoVO(SiiPermiso siiPermiso) {
        this.pmsCodigo = siiPermiso.getPmsCodigo();
        this.pmsNombre = siiPermiso.getPmsNombre();
    }


    public void setPmsCodigo(Long pmsCodigo) {
        this.pmsCodigo = pmsCodigo;
    }

    public Long getPmsCodigo() {
        return pmsCodigo;
    }

    public void setPmsNombre(String pmsNombre) {
        this.pmsNombre = pmsNombre;
    }

    public String getPmsNombre() {
        return pmsNombre;
    }

    public void setPermisoRolModuloVoList(List<PermisoRolModuloVO> permisoRolModuloVoList) {
        this.permisoRolModuloVoList = permisoRolModuloVoList;
    }

    public List<PermisoRolModuloVO> getPermisoRolModuloVoList() {
        return permisoRolModuloVoList;
    }


    public void setSeleccionado(boolean seleccionado) {
        this.seleccionado = seleccionado;
    }

    public boolean isSeleccionado() {
        return seleccionado;
    }
}
