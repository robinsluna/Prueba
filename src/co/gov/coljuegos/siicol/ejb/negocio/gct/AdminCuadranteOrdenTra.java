/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 15-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CuadranteOrdenTraVO;

import java.util.List;

/**
 * Interface de AdminCuadranteOrdenTra
 * @author PAOLA ANDREA RUEDA LEÓN
 */
public interface AdminCuadranteOrdenTra {
    
    public CuadranteOrdenTraVO insertarCuadranteOrdenTra(CuadranteOrdenTraVO cuadranteOrdenTraVo) throws ExcepcionDAO;
    public CuadranteOrdenTraVO actualizarCuadranteOrdenTra(CuadranteOrdenTraVO cuadranteOrdenTraVo, String limite1,
                                                           String limite2, String limite3,
                                                           String limite4) throws ExcepcionDAO;
    public List<CuadranteOrdenTraVO> buscarCuadranteOrdenTraXCodOrdenTrabajo(Long codOrdenTrabajo) throws ExcepcionDAO;
}
