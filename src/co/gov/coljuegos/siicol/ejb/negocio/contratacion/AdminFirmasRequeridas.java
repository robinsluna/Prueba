/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Contratacion
 * AUTOR	: Orlando Rodriguez Bayona
 * FECHA	: 25-09-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.FirmasRequeridasDocumentosVO;
import co.gov.coljuegos.siicol.ejb.vo.FirmasRequeridasVO;

import java.util.List;

import javax.ejb.Local;


@Local
public interface AdminFirmasRequeridas {
    public FirmasRequeridasVO insertarFirmasRequeridas(FirmasRequeridasVO firmasRequeridasVO) throws ExcepcionDAO;
    public FirmasRequeridasVO buscarFirmasRequeridasPorId(FirmasRequeridasVO firmasRequeridasVO) throws ExcepcionDAO;
    public FirmasRequeridasVO actualizarFirmasRequeridas(FirmasRequeridasVO firmasRequeridasVO) throws ExcepcionDAO;
    public void eliminarFirmasRequeridas(FirmasRequeridasVO firmasRequeridasVO) throws ExcepcionDAO;
    public List<FirmasRequeridasDocumentosVO> consultarFirmasRequeridas(Long idTipoDocumento) throws ExcepcionDAO;
    public List<FirmasRequeridasDocumentosVO> consultarFirmasRequeridas(Long idTipoDocumento, Long idDocumento) throws ExcepcionDAO;
    public List<FirmasRequeridasDocumentosVO> consultarFirmasRequeridasUsuario(Long idTipoDocumento, Long idUsuario) throws ExcepcionDAO;
    public List<FirmasRequeridasVO> buscarFirmasRequeridasPorIdTipoDocColjuegos (Long idTipoDocumento) throws ExcepcionDAO;
}

