package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.TipoOrigenVO;

import javax.ejb.Local;
@Local
public interface AdminTipoOrigen {
    public TipoOrigenVO buscarTipoOrigenPorCodigo(Long tipoOrigenCodigo) throws ExcepcionDAO;
}
