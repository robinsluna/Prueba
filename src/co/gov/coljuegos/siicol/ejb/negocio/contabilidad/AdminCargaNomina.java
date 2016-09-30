/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 15-05-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CargaNominaVO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;


/**
 * Interface local para el Cargue de archivos de N&oacute;mina.
 * @author Camilo Miranda
 */
@Local
public interface AdminCargaNomina {
    
    public CargaNominaVO buscarCargaNominaPorId (Long cnoCodigo) throws ExcepcionDAO;
    public CargaNominaVO insertarCargaNomina (CargaNominaVO cargaNominaVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public CargaNominaVO actualizarCargaNomina (CargaNominaVO cargaNominaVo) throws ExcepcionDAO;
    public void borrarCargaNomina (Long cnoCodigo) throws ExcepcionDAO;
    public List<CargaNominaVO> buscarTodoCargaNomina () throws ExcepcionDAO;
    public CargaNominaVO buscarPorNombreArchivo (String cnoNombreArch) throws ExcepcionDAO;
    public Long buscarUltimoConsecutivo (Calendar calendar) throws ExcepcionDAO;
    public Long buscarUltimoConsecutivo (Date fecha) throws ExcepcionDAO;
    public Long buscarUltimoConsecutivo (String formatoFecha) throws ExcepcionDAO;
    public List<CargaNominaVO> buscarCargaNominaSinOrdenPago () throws ExcepcionDAO;
    public List<CargaNominaVO> buscarCargaNominaConOrdenPagoPendientes () throws ExcepcionDAO;
    
}
