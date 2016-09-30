package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.DescargoProcIlegVO;

import java.util.List;

import javax.ejb.Local;


/**
 * Interfaz local para el manejo de Descargos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Local
public interface AdminDescargoProcIleg 
{
    public DescargoProcIlegVO buscarDescargoProcIlegPorId (Long dprCodigo) throws ExcepcionDAO;
    public DescargoProcIlegVO insertarDescargoProcIleg (DescargoProcIlegVO descargoProcIlegVo) throws ExcepcionDAO;
    public DescargoProcIlegVO insertarDescargoProcIleg (DescargoProcIlegVO descargoProcIlegVo, boolean cascadeUpdate) throws ExcepcionDAO;
    public DescargoProcIlegVO actualizarDescargoProcIleg (DescargoProcIlegVO descargoProcIlegVo) throws ExcepcionDAO;
    public DescargoProcIlegVO actualizarDescargoProcIleg (DescargoProcIlegVO descargoProcIlegVo, boolean cascadeUpdate) throws ExcepcionDAO;
    public void eliminarDescargoProcIleg (Long dprCodigo) throws ExcepcionDAO;
    public List<DescargoProcIlegVO> buscarTodoDescargoProcIleg () throws ExcepcionDAO;
    public List<DescargoProcIlegVO> buscarDescargoProcIlegPorIdProcesoSancIlegalidad (Long prsCodigo) throws ExcepcionDAO;
}
