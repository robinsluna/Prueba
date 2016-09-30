package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoModifCdpVO;

import co.gov.coljuegos.siicol.ejb.vo.EstadoModificRpVO;

import javax.ejb.Local;

@Local
public interface AdminEstadoModificRp {
    public EstadoModificRpVO buscarEstadoModificRpPorId(Long mrpCodigo) throws ExcepcionDAO;
    public EstadoModificRpVO buscarEstadoModificRpPorNombre(String nombre) throws ExcepcionDAO;
}
