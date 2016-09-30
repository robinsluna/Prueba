package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.FirmaDocumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.TerminacionAnticipContVO;

import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminTerminacionAnticipCont {
    public TerminacionAnticipContVO buscarTerminacionAnticipadaPorId (Long idTanCodigo) throws ExcepcionDAO;
    public TerminacionAnticipContVO insertarTerminacionAnticipada(TerminacionAnticipContVO terminacionAnticipContVo, UsuarioVO usuarioVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public TerminacionAnticipContVO actualizarTerminacionAnticipada (TerminacionAnticipContVO terminacionAnticipContVo, UsuarioVO usuarioVo) throws ExcepcionDAO, ExcepcionAplicacion;
    public List<TerminacionAnticipContVO> buscarTerminacionAnticipadaPorEstado (String estadoNombre) throws ExcepcionDAO;
    /**
     * Buscar terminaciones anticipadas según Id de contrato
     * @param conCodigo
     * @return listaTerminacionAnticipadaPorEstadoVo - Lista de terminaciones anticipadas
     * @throws ExcepcionDAO
     */

    public List<TerminacionAnticipContVO> buscarTerminacionAnticipadaPorIdContrato(Long conCodigo) throws ExcepcionDAO;
    public List<TerminacionAnticipContVO> buscarTodasTerminacionAnticipada () throws ExcepcionDAO;
    public int diasFestivosEntre(Date fechaInicial, Date fechaFinal) throws ExcepcionDAO;
}
