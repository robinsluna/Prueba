package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoDenunciaVO;

import co.gov.coljuegos.siicol.ejb.vo.EstadoTramResDecDesVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminEstadoTramResDecDes {

    public List<EstadoTramResDecDesVO> buscarTodos() throws ExcepcionDAO;
    //public EstadoTramResDecDesVO buscarEstadoPorNombre(String estado) throws ExcepcionDAO;

}
