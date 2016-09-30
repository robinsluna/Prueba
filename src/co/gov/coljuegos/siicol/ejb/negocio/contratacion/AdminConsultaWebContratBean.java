package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ArchivoFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ConsultaWebContratDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CotizacionEstudioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConsultaWebContrat;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCotizacionEstudio;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ConsultaWebContratVO;
import co.gov.coljuegos.siicol.ejb.vo.CotizacionEstudioVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless

public class AdminConsultaWebContratBean implements AdminConsultaWebContrat{
    @Resource
    SessionContext sessionContext;

    @EJB
    ConsultaWebContratDAO consultaWebContratDao;
    @EJB
    CotizacionEstudioDAO cotizacionEstudioDao;
    @EJB
    ArchivoFisicoDAO archivoFisicoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminConsultaWebContratBean() {
    }

    public ConsultaWebContratVO buscarConsultaWebContratPorId(ConsultaWebContratVO consultaWebContratVo) throws ExcepcionDAO {
        SiiConsultaWebContrat localConsultaWebContrat = consultaWebContratDao.buscarConsultaWebContratPorId(consultaWebContratVo.getCwcCodigo());
        return new ConsultaWebContratVO(localConsultaWebContrat);
    }

    public ConsultaWebContratVO insertarConsultaWebContrat(ConsultaWebContratVO consultaWebContratVo) throws ExcepcionDAO {
        SiiConsultaWebContrat consultaWebContrat = conversionVoEntidad.convertir(consultaWebContratVo);
        List<CotizacionEstudioVO> listaCotizacionEstudioVo = consultaWebContratVo.getCotizacionEstudioList2VO();
        
        SiiConsultaWebContrat localConsultaWebContrat =  consultaWebContratDao.insertarConsultaWebContrat(consultaWebContrat);
        for (CotizacionEstudioVO unaCotizacionEstudioVo : listaCotizacionEstudioVo) {
            SiiCotizacionEstudio nuevaCotizacionEstudio = conversionVoEntidad.convertir(unaCotizacionEstudioVo);
            cotizacionEstudioDao.insertarCotizacionEstudio(nuevaCotizacionEstudio);
            //nuevaCotizacionEstudio.setSiiConsultaWebContrat(consultaWebContrat);
        }
        return new ConsultaWebContratVO(localConsultaWebContrat);
    }

    public ConsultaWebContratVO actualizarConsultaWebContrat(ConsultaWebContratVO consultaWebContratVO) throws ExcepcionDAO {
        SiiConsultaWebContrat consultaWebContrat = conversionVoEntidad.convertir(consultaWebContratVO);
        consultaWebContrat = consultaWebContratDao.actualizarConsultaWebContrat(consultaWebContrat);
        return new ConsultaWebContratVO(consultaWebContrat);
    }

    public void eliminarConsultaWebContratPorId(ConsultaWebContratVO consultaWebContratVO) throws ExcepcionDAO {
        consultaWebContratDao.eliminarConsultaWebContrat(consultaWebContratVO.getCwcCodigo());
    }

    public List<ConsultaWebContratVO> buscarTodoConsultaWebContrat() throws ExcepcionDAO {
        List<SiiConsultaWebContrat> listaConsultaWebContrat =
            consultaWebContratDao.buscarTodoConsultaWebContrat();
        List<ConsultaWebContratVO> listaConsultaWebContratVO = new ArrayList();
        for (SiiConsultaWebContrat unaConsultaWebContrat : listaConsultaWebContrat) {
            listaConsultaWebContratVO.add(new ConsultaWebContratVO(unaConsultaWebContrat));
        }
        return listaConsultaWebContratVO;
    }

}
