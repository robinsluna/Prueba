package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionFinanVO;

import co.gov.coljuegos.siicol.ejb.vo.RevisionGctVO;

import java.util.List;

public interface AdminRevisionGct {
    public List<RevisionGctVO> buscarRevisionGctPorContrato(Long conCodigo) throws ExcepcionDAO;
}
