package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.InformeContrProvVO;

import java.util.List;

import javax.ejb.Local;

@Local 
public interface AdminInformeContrProv {
    List<InformeContrProvVO> buscarInformeContrProvPorActaInicio(Long acnCodigo) throws ExcepcionDAO;
}
