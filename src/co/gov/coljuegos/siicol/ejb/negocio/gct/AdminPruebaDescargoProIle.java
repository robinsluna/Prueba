package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.PruebaDescargoProIleVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Pruebas de Descargo de Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Local
public interface AdminPruebaDescargoProIle 
{
    public PruebaDescargoProIleVO buscarPruebaDescargoProIlePorId (Long pdpCodigo) throws ExcepcionDAO;
    public PruebaDescargoProIleVO insertarPruebaDescargoProIle (PruebaDescargoProIleVO pruebaDescargoProIleVo) throws ExcepcionDAO;
    public PruebaDescargoProIleVO actualizarPruebaDescargoProIle (PruebaDescargoProIleVO pruebaDescargoProIleVo) throws ExcepcionDAO;
    public void eliminarPruebaDescargoProIle (Long pdpCodigo) throws ExcepcionDAO;
    public List<PruebaDescargoProIleVO> buscarTodaPruebaDescargoProIle () throws ExcepcionDAO;
    public List<PruebaDescargoProIleVO> buscarPruebaDescargoProIlePorIdDescargo (Long dprCodigo) throws ExcepcionDAO;
}
