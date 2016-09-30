package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.InformeActaIniVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminInformeActaIni {
   public List<InformeActaIniVO>  buscarInformeActaIniPorActaInicio(Long acnCodigo) throws ExcepcionDAO;
}
