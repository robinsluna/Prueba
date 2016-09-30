package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.GarantiaExigidaVO;

import java.util.List;

public interface AdminGarantiaExigida {
    public List<GarantiaExigidaVO> buscarTodaGarantiaExigida() throws ExcepcionDAO;
}
