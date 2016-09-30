package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CargaRpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaRp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CargaRpVO;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminCargaRpBean implements AdminCargaRp {
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    @EJB
    private CargaRpDAO cargaRpDao;

    @EJB
    AdminRp adminRp;

    public AdminCargaRpBean() {
        super();
    }

    public CargaRpVO buscarCargaRpPorId(Long id) throws ExcepcionDAO {
        return new CargaRpVO(cargaRpDao.buscarCargaRpPorId(id));
    }

    public List<CargaRpVO> buscarTodoCargaRp() throws ExcepcionDAO {
        List<CargaRpVO> listaCargaRpVo = new ArrayList<CargaRpVO>();
        if (cargaRpDao.buscarTodoCargaRp() != null) {
            for (SiiCargaRp cargaRp : cargaRpDao.buscarTodoCargaRp()) {
                if (cargaRp != null) {
                    listaCargaRpVo.add(new CargaRpVO(cargaRp));
                }
            }
        }
        return listaCargaRpVo;
    }

    public CargaRpVO insertarCargaRp(CargaRpVO cargaRpVo) throws ExcepcionDAO, ExcepcionAplicacion {
        return new CargaRpVO(cargaRpDao.insertarCargaRp(conversionVoEntidad.convertir(cargaRpVo)));
    }

    public CargaRpVO actualizarCargaRp(CargaRpVO cargaRpVo) throws ExcepcionDAO, ExcepcionAplicacion {
        return new CargaRpVO(cargaRpDao.actualizarCargaRp(conversionVoEntidad.convertir(cargaRpVo)));
    }

    public void eliminarCargaRp(Long id) throws ExcepcionDAO {
        cargaRpDao.elimiarCargaRp(id);
    }

    public CargaRpVO buscarCargaRpPorNombreArchivo(String crpNombreArch) throws ExcepcionDAO {
        return new CargaRpVO(cargaRpDao.buscarCargaRpPorNombreArchivo(crpNombreArch));
    }
    
    public Long buscarUltimoConsecutivo(Calendar calendar) throws ExcepcionDAO {
        return (cargaRpDao.buscarUltimoConsecutivo(calendar));
    }

    public Long buscarUltimoConsecutivo(Date fecha) throws ExcepcionDAO {
        return (cargaRpDao.buscarUltimoConsecutivo(fecha));
    }

    public Long buscarUltimoConsecutivo(String formatoFecha) throws ExcepcionDAO {
        return (cargaRpDao.buscarUltimoConsecutivo(formatoFecha));
    }

}
