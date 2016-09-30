package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.InteresCuotaVO;

import co.gov.coljuegos.siicol.ejb.vo.ValidacionInteresVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface  AdminInteresDiario {
    
    public InteresCuotaVO insertarInteresCuota(InteresCuotaVO interesVo) throws ExcepcionDAO;
    public Integer buscarConsecutivoDocumento(String tipoDoc) throws ExcepcionDAO ;
    public List<ValidacionInteresVO>  BuscarInteresTotal(String fechaCorte) throws ExcepcionDAO;
}
