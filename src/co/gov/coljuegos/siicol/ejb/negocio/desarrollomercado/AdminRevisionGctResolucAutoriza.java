package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionGctResolucAutorizaVO;

import java.util.List;

public interface AdminRevisionGctResolucAutoriza {
    public List<RevisionGctResolucAutorizaVO> buscarRevisionGctPorResolucion(Long rauCodigo) throws ExcepcionDAO;
}
