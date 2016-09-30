package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ClaseContratoVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminClaseContrato {
    public List<ClaseContratoVO> listaClaseContrato() throws ExcepcionDAO;
    public ClaseContratoVO buscarClaseContratoPorNombre(String clcNombre) throws ExcepcionDAO;
    public ClaseContratoVO buscarClaseContratoPorId(Long clcCodigo) throws ExcepcionDAO;
}
    