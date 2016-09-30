package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.DireccionPersonaAtienVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminDireccionPersonaAtien {
    public List<DireccionPersonaAtienVO> buscarDireccionesPorPersona(Long peaCodigo) throws ExcepcionDAO;

    public DireccionPersonaAtienVO buscarDireccionPorCodigo(Long dpaCodigo) throws ExcepcionDAO;
}
