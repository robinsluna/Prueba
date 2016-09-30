package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionFinanVO;

import java.util.List;

public interface AdminRevisionFinan {
    public List<RevisionFinanVO> buscarRevisionFinanPorContrato(Long conCodigo, String rfiTipoValidac) throws ExcepcionDAO;
}
