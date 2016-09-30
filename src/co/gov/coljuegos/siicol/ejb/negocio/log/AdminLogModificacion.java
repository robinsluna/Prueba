package co.gov.coljuegos.siicol.ejb.negocio.log;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.vo.LogModificacionVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminLogModificacion {
    public List<LogModificacionVO> buscarTablasLogModificacion() throws ExcepcionDAO;
}
