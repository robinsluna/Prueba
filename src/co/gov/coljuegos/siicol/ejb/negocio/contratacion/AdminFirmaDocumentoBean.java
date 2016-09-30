package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FirmaDocumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmaDocumento;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.FirmaDocumentoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminFirmaDocumentoBean implements AdminFirmaDocumento {
    @EJB
    FirmaDocumentoDAO firmaDocumentoDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;

    public AdminFirmaDocumentoBean() {

    }

    public FirmaDocumentoVO insertarFirmaDocumento(FirmaDocumentoVO firmaDocumentoVO) throws ExcepcionDAO {
        return new FirmaDocumentoVO(firmaDocumentoDao.insertarFirmaDocumento(conversionVoEntidad.convertirVoAEntidad(firmaDocumentoVO)));
    }

    public FirmaDocumentoVO buscarFirmaDocumentoPorId(FirmaDocumentoVO firmaDocumentoVO) throws ExcepcionDAO {
        return new FirmaDocumentoVO(firmaDocumentoDao.buscarFirmaDocumentoPorId(firmaDocumentoVO.getFdoCodigo()));
    }


    public FirmaDocumentoVO actualizarFirmaDocumentos(FirmaDocumentoVO firmaDocumentoVO) throws ExcepcionDAO {
        return new FirmaDocumentoVO(firmaDocumentoDao.actualizarFirmaDocumento(conversionVoEntidad.convertirVoAEntidad(firmaDocumentoVO)));
    }


    public void eliminarFirmaDocumento(FirmaDocumentoVO firmaDocumentoVO) throws ExcepcionDAO {
        firmaDocumentoDao.eliminarFirmaDocumento(firmaDocumentoVO.getFdoCodigo());
    }

    public List<FirmaDocumentoVO> buscarFirmaDocumentoPorIdTipoDocumento(Long idTipoDocumento) throws ExcepcionDAO {
        List<SiiFirmaDocumento> listaFirmaDocumento = new ArrayList<SiiFirmaDocumento>();
        listaFirmaDocumento = firmaDocumentoDao.buscarFirmaDocumentoPorIdTipoDocumento(idTipoDocumento);
        List<FirmaDocumentoVO> listaFirmaDocumentoVo = new ArrayList<FirmaDocumentoVO>();
        for (SiiFirmaDocumento unaFirmaDocumento : listaFirmaDocumento) {
            FirmaDocumentoVO nuevoFirmaDocumentoVO = new FirmaDocumentoVO(unaFirmaDocumento);
            listaFirmaDocumentoVo.add(nuevoFirmaDocumentoVO);
        }
        return listaFirmaDocumentoVo;
    }

    public List<FirmaDocumentoVO> buscarFirmaDocumentoPorIdDocumentoTipoDocumento(Long idDocumento,
                                                                                  Long idTipoDocumento) throws ExcepcionDAO {
        List<SiiFirmaDocumento> listaFirmaDocumento = new ArrayList<SiiFirmaDocumento>();
        listaFirmaDocumento =
            firmaDocumentoDao.buscarFirmaDocumentoPorIdDocumentoTipoDocumento(idDocumento, idTipoDocumento);
        List<FirmaDocumentoVO> listaFirmaDocumentoVo = new ArrayList<FirmaDocumentoVO>();
        for (SiiFirmaDocumento unaFirmaDocumento : listaFirmaDocumento) {
            FirmaDocumentoVO nuevoFirmaDocumentoVO = new FirmaDocumentoVO(unaFirmaDocumento);
            listaFirmaDocumentoVo.add(nuevoFirmaDocumentoVO);
        }
        return listaFirmaDocumentoVo;
    }

    public List<FirmaDocumentoVO> buscarJqlFirmaDocumentoPorIdDocumentoTipoDocumento(Long idDocumento,
                                                                                     Long idTipoDocumento) throws ExcepcionDAO {
        List<FirmaDocumentoVO> listaFirmaDocumentoVo = new ArrayList<FirmaDocumentoVO>();
        List<SiiFirmaDocumento> listafirmaDocumento =
            firmaDocumentoDao.buscarJqlFirmaDocumentoPorIdDocumentoTipoDocumento(idDocumento, idTipoDocumento);
        for (SiiFirmaDocumento unaFirmaDocumento : listafirmaDocumento) {
            listaFirmaDocumentoVo.add(new FirmaDocumentoVO(unaFirmaDocumento));
        }
        return listaFirmaDocumentoVo;

    }

    public List<FirmaDocumentoVO> buscarFirmaDocumentoPorIdTipoDocumentoEntidad(Long idDocumento,
                                                                                Long idTipoDocumento) throws ExcepcionDAO {
        List<SiiFirmaDocumento> listaFirmaDocumento = new ArrayList<SiiFirmaDocumento>();
        listaFirmaDocumento =
            firmaDocumentoDao.buscarFirmaDocumentoPorIdTipoDocumentoEntidad(idDocumento, idTipoDocumento);
        List<FirmaDocumentoVO> listaFirmaDocumentoVo = new ArrayList<FirmaDocumentoVO>();
        for (SiiFirmaDocumento unaFirmaDocumento : listaFirmaDocumento) {
            FirmaDocumentoVO nuevoFirmaDocumentoVO = new FirmaDocumentoVO(unaFirmaDocumento);
            listaFirmaDocumentoVo.add(nuevoFirmaDocumentoVO);
        }
        return listaFirmaDocumentoVo;
    }
}

