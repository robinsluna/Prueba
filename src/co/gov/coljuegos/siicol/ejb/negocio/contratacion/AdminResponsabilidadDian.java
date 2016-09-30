package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.ResponsabilidadDianVO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminResponsabilidadDian {
    public ResponsabilidadDianVO buscarResponsabilidadDianPorId (ResponsabilidadDianVO responsabilidadDianVo) throws ExcepcionDAO;
    public List<ResponsabilidadDianVO> buscarTodosResponsabilidadDian() throws ExcepcionDAO;
}
