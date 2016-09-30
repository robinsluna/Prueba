/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Diego Alvarado
 * FECHA	: 08-10-2013
 */

package co.gov.coljuegos.siicol.ejb.vo;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModulo;

import java.util.List;

public class ModuloVO {
    
    private String modActivo;
    private Long modCodigo;
    private Long modCodigoPadre;
    private String modNombre;
    private Integer modOrden;
    private String modPath;
    private String modTitulo;
    //private ModuloVO moduloVo;
    private List<ModuloVO> moduloHijosVoList;
    //private ModuloVO moduloPadreVo;
    private List<PermisoRolModuloVO> permisoRolModuloVoList;
    private String modMbClass;
    private boolean permisoRegistrar = false;
    private boolean permisoConsultar = false;
    private boolean permisoModificar = false;
    private boolean permisoBorrar = false;
    private boolean permisoImprimir = false;
    private boolean permisoRevisar = false;
    private boolean permisoDevolver = false;
    private boolean permisoGenerar = false;
    private boolean permisoAprobar = false;
    private boolean permisoRechazar = false;
    private boolean hijosBuscados = false;
    private String modParametros;
    
    /*
     * Por estar esta tabla referenciada a sí misma se usa el código del padre en lugar del vo padre
     * La entidad no referencia a la entidad padre (ella misma)
     * Al crear este VO usando la entidad se debe adicionalmente consultar la entidad padre y usarla
     * para crear un nuevo VO padre y colocarlo en el campo moduloPadreVo
     */
    public ModuloVO() {
    }
    
    public ModuloVO(SiiModulo siiModulo){
        this.modActivo = siiModulo.getModActivo();
        this.modCodigo = siiModulo.getModCodigo();
        this.modCodigoPadre = siiModulo.getModCodigoPadre();
        this.modNombre = siiModulo.getModNombre();
        this.modOrden = siiModulo.getModOrden();
        this.modPath = siiModulo.getModPath();
        this.modTitulo = siiModulo.getModTitulo();
        this.modMbClass = siiModulo.getModMbClass();
        this.modParametros = siiModulo.getModParametros();
    }
/*
    public void setModuloVo(ModuloVO moduloVo) {
        this.moduloVo = moduloVo;
    }

    public ModuloVO getModuloVo() {
        return moduloVo;
    }
*/

    public void setModuloHijosVoList(List<ModuloVO> moduloHijosVoList) {
        this.moduloHijosVoList = moduloHijosVoList;
    }

    public List<ModuloVO> getModuloHijosVoList() {
        return moduloHijosVoList;
    }
/*
    public void setModuloPadreVo(ModuloVO moduloPadreVo) {
        this.moduloPadreVo = moduloPadreVo;
    }

    public ModuloVO getModuloPadreVo() {
        return moduloPadreVo;
    }
*/
    public void setPermisoRolModuloVoList(List<PermisoRolModuloVO> permisoRolModuloVoList) {
        this.permisoRolModuloVoList = permisoRolModuloVoList;
    }

    public List<PermisoRolModuloVO> getPermisoRolModuloVoList() {
        return permisoRolModuloVoList;
    }

    public void setModActivo(String modActivo) {
        this.modActivo = modActivo;
    }

    public String getModActivo() {
        return modActivo;
    }

    public void setModCodigo(Long modCodigo) {
        this.modCodigo = modCodigo;
    }

    public Long getModCodigo() {
        return modCodigo;
    }

    public void setModCodigoPadre(Long modCodigoPadre) {
        this.modCodigoPadre = modCodigoPadre;
    }

    public Long getModCodigoPadre() {
        return modCodigoPadre;
    }

    public void setModNombre(String modNombre) {
        this.modNombre = modNombre;
    }

    public String getModNombre() {
        return modNombre;
    }

    public void setModOrden(Integer modOrden) {
        this.modOrden = modOrden;
    }

    public Integer getModOrden() {
        return modOrden;
    }

    public void setModPath(String modPath) {
        this.modPath = modPath;
    }

    public String getModPath() {
        return modPath;
    }

    public void setModTitulo(String modTitulo) {
        this.modTitulo = modTitulo;
    }

    public String getModTitulo() {
        return modTitulo;
    }

    public void setModMbClass(String modMbClass) {
        this.modMbClass = modMbClass;
    }

    public String getModMbClass() {
        return modMbClass;
    }


    public void setPermisoRegistrar(boolean permisoRegistrar) {
        this.permisoRegistrar = permisoRegistrar;
    }

    public boolean isPermisoRegistrar() {
        return permisoRegistrar;
    }

    public void setPermisoConsultar(boolean permisoConsultar) {
        this.permisoConsultar = permisoConsultar;
    }

    public boolean isPermisoConsultar() {
        return permisoConsultar;
    }

    public void setPermisoModificar(boolean permisoModificar) {
        this.permisoModificar = permisoModificar;
    }

    public boolean isPermisoModificar() {
        return permisoModificar;
    }

    public void setPermisoBorrar(boolean permisoBorrar) {
        this.permisoBorrar = permisoBorrar;
    }

    public boolean isPermisoBorrar() {
        return permisoBorrar;
    }

    public void setPermisoImprimir(boolean permisoImprimir) {
        this.permisoImprimir = permisoImprimir;
    }

    public boolean isPermisoImprimir() {
        return permisoImprimir;
    }

    public void setPermisoRevisar(boolean permisoRevisar) {
        this.permisoRevisar = permisoRevisar;
    }

    public boolean isPermisoRevisar() {
        return permisoRevisar;
    }

    public void setPermisoDevolver(boolean permisoDevolver) {
        this.permisoDevolver = permisoDevolver;
    }

    public boolean isPermisoDevolver() {
        return permisoDevolver;
    }

    public void setPermisoGenerar(boolean permisoGenerar) {
        this.permisoGenerar = permisoGenerar;
    }

    public boolean isPermisoGenerar() {
        return permisoGenerar;
    }

    public void setPermisoAprobar(boolean permisoAprobar) {
        this.permisoAprobar = permisoAprobar;
    }

    public boolean isPermisoAprobar() {
        return permisoAprobar;
    }

    public void setPermisoRechazar(boolean permisoRechazar) {
        this.permisoRechazar = permisoRechazar;
    }

    public boolean isPermisoRechazar() {
        return permisoRechazar;
    }

    public void setHijosBuscados(boolean hijosBuscados) {
        this.hijosBuscados = hijosBuscados;
    }

    public boolean isHijosBuscados() {
        return hijosBuscados;
    }

    public void setModParametros(String modParametros) {
        this.modParametros = modParametros;
    }

    public String getModParametros() {
        return modParametros;
    }
}
