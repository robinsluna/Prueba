package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.vo.CargaRpVO;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminCargaRp {
    public CargaRpVO buscarCargaRpPorId(Long id) throws ExcepcionDAO;

    public List<CargaRpVO> buscarTodoCargaRp() throws ExcepcionDAO;

    public CargaRpVO insertarCargaRp(CargaRpVO cargaRpVo) throws ExcepcionDAO, ExcepcionAplicacion;

    public CargaRpVO actualizarCargaRp(CargaRpVO cargaRpVo) throws ExcepcionDAO, ExcepcionAplicacion;

    public void eliminarCargaRp(Long id) throws ExcepcionDAO;

    public CargaRpVO buscarCargaRpPorNombreArchivo(String crpNombreArch) throws ExcepcionDAO;

    public Long buscarUltimoConsecutivo(Calendar calendar) throws ExcepcionDAO;

    public Long buscarUltimoConsecutivo(Date fecha) throws ExcepcionDAO;

    public Long buscarUltimoConsecutivo(String formatoFecha) throws ExcepcionDAO;

}
