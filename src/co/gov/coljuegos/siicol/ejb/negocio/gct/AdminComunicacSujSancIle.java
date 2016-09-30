/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 22-04-2016
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ComunicacSujSancIleVO;

import java.util.List;

import javax.ejb.Local;

/**
 * Interface que gestiona las comunicaciones del sujeto sancionable
 * @author Paola Andrea Rueda León
 */

@Local
public interface AdminComunicacSujSancIle {
    
    /**
     * Insertar la comunicación del sujeto sancionable
     * @param comunicacSujSancIleVo
     * @return resultado - ComunicacSujSancIleVO ya insertado en la BD
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */

    ComunicacSujSancIleVO insertarComunicacSujSancIle(ComunicacSujSancIleVO comunicacSujSancIleVo) throws ExcepcionDAO, ExcepcionAplicacion;
    
    /**
     * Buscar las comunicaciones por determinar sujeto sancionable según id del proceso de ilegalidad
     * @param prsCodigo
     * @return resultado - Lista de ComunicacSujSancIleVO
     * @throws ExcepcionDAO
     */
    
    public List<ComunicacSujSancIleVO> buscarComunicacSujSancIleXIdProceso(Long prsCodigo) throws ExcepcionDAO;
}
