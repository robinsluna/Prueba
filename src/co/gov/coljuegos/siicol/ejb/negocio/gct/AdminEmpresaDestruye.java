/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 27-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EmpresaDestruyeVO;

import java.util.List;

/**
 * Interface que gestiona la empresa que destruye
 * @author PAOLA ANDREA RUEDA LEÓN
 */

public interface AdminEmpresaDestruye {
    /**
     * Insertar Empresa Destruye
     * @param empresaDestruyeVo
     * @return resultado - Empresa Destruye
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    EmpresaDestruyeVO insertarEmpresaDestruye(EmpresaDestruyeVO empresaDestruyeVo) throws ExcepcionDAO,
                                                                                          ExcepcionAplicacion;

    /**
     * Actualizar la empresa que destruye
     * @param empresaDestruyeVo
     * @return resultado - Empresa que Destruye
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    EmpresaDestruyeVO actualizarEmpresaDestruye(EmpresaDestruyeVO empresaDestruyeVo) throws ExcepcionDAO,
                                                                                            ExcepcionAplicacion;

    /**
     * Buscar todas las empresas que destruyen
     * @return resultado - Lista de empresas que destruyen.
     * @throws ExcepcionDAO
     */

    List<EmpresaDestruyeVO> buscarTodaEmpresaDestruye() throws ExcepcionDAO;
    
    /**
     * Buscar la empresa que destruye vigente 
     * @return
     * @throws ExcepcionDAO
     */
    
    public List<EmpresaDestruyeVO> buscarEmpresaDestruyeVigente() throws ExcepcionDAO;
}
