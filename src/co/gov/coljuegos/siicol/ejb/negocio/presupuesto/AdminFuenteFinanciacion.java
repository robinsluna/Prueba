/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Glenis Reyes
 * FECHA	: 19-09-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.DetFuenteFinanciacionVO;
import co.gov.coljuegos.siicol.ejb.vo.FuenteFinanciacionVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminFuenteFinanciacion {

    public FuenteFinanciacionVO insertarFuenteFinanciacion(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO;
    
    public FuenteFinanciacionVO insertarFuenteFinanciacionConDetalles(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO;

    public FuenteFinanciacionVO buscarFuenteFinanciacionPorId(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO;
    
    public FuenteFinanciacionVO buscarFuenteFinanciacionPorNombre(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO;
    
    public FuenteFinanciacionVO buscarCodFuenteFinanciacionPorNombre(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO;
    
    public void actualizarFuenteFinanciacion(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO;
    
    public void actualizarFuenteDetallesAgregarBorrar(FuenteFinanciacionVO fuenteFinanciacionVo, List<DetFuenteFinanciacionVO> listaDetallesAgregar,
                                    List<DetFuenteFinanciacionVO> listaDetallesBorrar) throws ExcepcionDAO;
    
    public void eliminarFuenteFinanciacion(FuenteFinanciacionVO siiFuenteFinanciacionVo) throws ExcepcionDAO;

    List<FuenteFinanciacionVO> buscarTodoFteFinanciacionConDtle() throws ExcepcionDAO;
    
    public List<FuenteFinanciacionVO> buscarFuenteFinanciacionPorRp(Long rpCodigo) throws ExcepcionDAO;
}


