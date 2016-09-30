package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ElementoRetiradoAccVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminElementoRetiradoAcc {
    public List<ElementoRetiradoAccVO> buscarElementoRetiradoPorAccionControl(Long accCodigo) throws ExcepcionDAO;

    public ElementoRetiradoAccVO buscarElementoPorCodigo(Long elrCodigo) throws ExcepcionDAO;
    
    public List<ElementoRetiradoAccVO> buscarElementoRetiradoAccVOXIdAccionControl(Long accCodigo) throws ExcepcionDAO;
    
    /**
     * Actualizar el elemento retirado de acción control
     * @param elementoRetiradoAccVo
     * @return siiElementoRetiradoAcc - Value Object
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    
    public ElementoRetiradoAccVO actualizarElementoRetiradoAccVo(ElementoRetiradoAccVO elementoRetiradoAccVo) throws ExcepcionDAO,
                                                                                                               ExcepcionAplicacion;
}
