package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.RevisionFinancResolAutorizVO;

import java.util.List;

public interface AdminRevisionFinancResolAutoriz {
    public List<RevisionFinancResolAutorizVO> buscarRevisionFinanPorResolucion(Long rauCodigo) throws ExcepcionDAO;
}
