/*
 * SISTEMA	: SIICOL
 * M�DULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LE�N
 * FECHA	: 07-03-2016
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ComunicResolPersIleVO;

import java.util.List;

import javax.ejb.Local;

/**
 * Interfaz que maneja las comunicaciones de las resoluciones de las personas investigadas
 * @author Paola Andrea Rueda Le�n
 */
@Local
public interface AdminComunicResolPersIle {
    /**
     * Insertar a la base de datos la comunicaci�n de la resoluci�n de las personas investigadas
     * @param comunicResolPersIleVo
     * @return
     * @throws ExcepcionDAO
     */

    ComunicResolPersIleVO insertarComunicResolPersIle(ComunicResolPersIleVO comunicResolPersIleVo) throws ExcepcionDAO;
    /**
     * Actualizar la comunici�n de la resoluci�n de las personas investigadas
     * @param comunicResolPersIleVo
     * @return resultado - ComunicResolPersIleVO
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public ComunicResolPersIleVO actualizarComunicResolPersIle(ComunicResolPersIleVO comunicResolPersIleVo) throws ExcepcionDAO, ExcepcionAplicacion ;
    
    public List<ComunicResolPersIleVO> buscarComunicResolPersIlePorResolucion(Long rpiCodigo) throws ExcepcionDAO ;
    
}
