package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.FirmaDocumentoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.OficioDesigSupervDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFirmaDocumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOficioDesigSuperv;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.FirmaDocumentoVO;
import co.gov.coljuegos.siicol.ejb.vo.OficioDesigSupervVO;

import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminOficioDesigSupervBean implements AdminOficioDesigSuperv{
    @Resource
    SessionContext sessionContext;
    
    @EJB
    OficioDesigSupervDAO oficioDesigSupervDao;
    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    FirmaDocumentoDAO firmaDocumentoDao;
    
    public AdminOficioDesigSupervBean() {        
    }
    
    public OficioDesigSupervVO insertarOficioDesigSuperv (OficioDesigSupervVO oficioDesigSupervVo, OficioDesigSupervVO actOficioDesigSupervVo, List<FirmaDocumentoVO> listaAgregarFirmaDocumentoVo, List<FirmaDocumentoVO> listaEliminarFirmaDocumentoVo) throws ExcepcionDAO{
        SiiOficioDesigSuperv siiOficioDesigSuperv = conversionVoEntidad.convertir(oficioDesigSupervVo);
        SiiOficioDesigSuperv unSiiOficioDesigSuperv = oficioDesigSupervDao.insertarOficioDesigSuperv(siiOficioDesigSuperv);
        
        if (actOficioDesigSupervVo != null){
            SiiOficioDesigSuperv siiActOficioDesigSuperv = conversionVoEntidad.convertir(actOficioDesigSupervVo);
            oficioDesigSupervDao.actualizarOficioDesigSuperv(siiActOficioDesigSuperv);
        }
        
        if (listaAgregarFirmaDocumentoVo != null){
            for (FirmaDocumentoVO firmaDocumentoVo : listaAgregarFirmaDocumentoVo){
                SiiFirmaDocumento nuevaFirmaDocumento = conversionVoEntidad.convertirVoAEntidad(firmaDocumentoVo);
                if (nuevaFirmaDocumento.getFdoCodigo() == null){
                    nuevaFirmaDocumento.setFdoCodigo(nuevaFirmaDocumento.getFdoCodigo());
                    nuevaFirmaDocumento.setFdoIdDocumento(unSiiOficioDesigSuperv.getOdsCodgo());
                    nuevaFirmaDocumento.setSiiFirmasRequeridas (nuevaFirmaDocumento.getSiiFirmasRequeridas());
                    nuevaFirmaDocumento.setSiiUsuario(nuevaFirmaDocumento.getSiiUsuario());
                    nuevaFirmaDocumento.setTdoFechaFirma(firmaDocumentoVo.getFdoFechaFirma());
                    firmaDocumentoDao.insertarFirmaDocumento(nuevaFirmaDocumento);
                }
            }
        }
        if (listaEliminarFirmaDocumentoVo != null){
            for (FirmaDocumentoVO firmaDocumentoVo : listaEliminarFirmaDocumentoVo){
                SiiFirmaDocumento nuevaFirmaDocumento = conversionVoEntidad.convertirVoAEntidad(firmaDocumentoVo);
                if (nuevaFirmaDocumento.getFdoCodigo() != null){
                    firmaDocumentoDao.eliminarFirmaDocumento(nuevaFirmaDocumento.getFdoCodigo());
                }
            }
        }
        return new OficioDesigSupervVO(unSiiOficioDesigSuperv);
        
    }
    
    
    public List<OficioDesigSupervVO> buscarTodoOficioDesigSuperv () throws ExcepcionDAO{
        List<SiiOficioDesigSuperv> listaOficioDesigSuperv = oficioDesigSupervDao.buscarTodoOficioDesigSuperv();
        List<OficioDesigSupervVO> listaOficioDesigSupervVo = new ArrayList<OficioDesigSupervVO>();
        for (SiiOficioDesigSuperv siiOficioDesigSuperv : listaOficioDesigSuperv){
            listaOficioDesigSupervVo.add(new OficioDesigSupervVO(siiOficioDesigSuperv));
        }
        return listaOficioDesigSupervVo;
    }
    
    public OficioDesigSupervVO buscarOficioDesigSupervPorId (Long idOficioDesigSuperv) throws ExcepcionDAO{        
        SiiOficioDesigSuperv siiOficioDesigSuperv = oficioDesigSupervDao.buscarOficioDesigSupervPorId(idOficioDesigSuperv);
        return new OficioDesigSupervVO(siiOficioDesigSuperv);
    }
    
    public OficioDesigSupervVO actualizarOficioDesigSuperv (OficioDesigSupervVO oficioDesigSupervVo, List<FirmaDocumentoVO> listaAgregarFirmaDocumentoVo, List<FirmaDocumentoVO> listaEliminarFirmaDocumentoVo) throws ExcepcionDAO{
        SiiOficioDesigSuperv siiOficioDesigSuperv = conversionVoEntidad.convertir(oficioDesigSupervVo);
        siiOficioDesigSuperv = oficioDesigSupervDao.actualizarOficioDesigSuperv(siiOficioDesigSuperv);
        
        if (listaAgregarFirmaDocumentoVo != null){
            for (FirmaDocumentoVO firmaDocumentoVo : listaAgregarFirmaDocumentoVo){
                SiiFirmaDocumento nuevaFirmaDocumento = conversionVoEntidad.convertirVoAEntidad(firmaDocumentoVo);
                if (nuevaFirmaDocumento.getFdoCodigo() == null){
                    nuevaFirmaDocumento.setFdoCodigo(nuevaFirmaDocumento.getFdoCodigo());
                    nuevaFirmaDocumento.setFdoIdDocumento(nuevaFirmaDocumento.getFdoIdDocumento());
                    nuevaFirmaDocumento.setSiiFirmasRequeridas (nuevaFirmaDocumento.getSiiFirmasRequeridas());
                    nuevaFirmaDocumento.setSiiUsuario(nuevaFirmaDocumento.getSiiUsuario());
                    nuevaFirmaDocumento.setTdoFechaFirma(firmaDocumentoVo.getFdoFechaFirma());
                    firmaDocumentoDao.insertarFirmaDocumento(nuevaFirmaDocumento);
                }
            }
        }
        if (listaEliminarFirmaDocumentoVo != null){
            for (FirmaDocumentoVO firmaDocumentoVo : listaEliminarFirmaDocumentoVo){
                SiiFirmaDocumento nuevaFirmaDocumento = conversionVoEntidad.convertirVoAEntidad(firmaDocumentoVo);
                if (nuevaFirmaDocumento.getFdoCodigo() != null){
                    firmaDocumentoDao.eliminarFirmaDocumento(nuevaFirmaDocumento.getFdoCodigo());
                }
            }
        }
        return new OficioDesigSupervVO(siiOficioDesigSuperv);
    }
    
    public List<OficioDesigSupervVO> buscarOficioDesigSupervPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO{
        List<SiiOficioDesigSuperv> listaOficioDesigSuperv = oficioDesigSupervDao.buscarOficioDesigSupervPorIdProcesoContratacion(idProcesoContratacion);
        List<OficioDesigSupervVO> listaOficioDesigSupervVo = new ArrayList<OficioDesigSupervVO>();
        for (SiiOficioDesigSuperv siiOficioDesigSuperv : listaOficioDesigSuperv){
            listaOficioDesigSupervVo.add(new OficioDesigSupervVO(siiOficioDesigSuperv));
        }
        return listaOficioDesigSupervVo;
    }
    
    public List<OficioDesigSupervVO> buscarUltimoOficioDesigSupervPorIdProcesoContratacion(Long idProcesoContratacion) throws ExcepcionDAO{
        List<SiiOficioDesigSuperv> listaOficioDesigSuperv = oficioDesigSupervDao.buscarUltimoOficioDesigSupervPorIdProcesoContratacion(idProcesoContratacion);
        List<OficioDesigSupervVO> listaOficioDesigSupervVo = new ArrayList<OficioDesigSupervVO>();
        for (SiiOficioDesigSuperv siiOficioDesigSuperv : listaOficioDesigSuperv){
            listaOficioDesigSupervVo.add(new OficioDesigSupervVO(siiOficioDesigSuperv));
        }
        return listaOficioDesigSupervVo;
    }
    
    public List<OficioDesigSupervVO> buscarOficioDesigSupervPorIdProcesoContratacionEstado(Long idProcesoContratacion) throws ExcepcionDAO{
        List<SiiOficioDesigSuperv> listaOficioDesigSuperv = oficioDesigSupervDao.buscarOficioDesigSupervPorIdProcesoContratacionEstado(idProcesoContratacion);
        List<OficioDesigSupervVO> listaOficioDesigSupervVo = new ArrayList<OficioDesigSupervVO>();
        for (SiiOficioDesigSuperv siiOficioDesigSuperv : listaOficioDesigSuperv){
            listaOficioDesigSupervVo.add(new OficioDesigSupervVO(siiOficioDesigSuperv));
        }
        return listaOficioDesigSupervVo;
    }
    
    public List<ProcesoContratacionVO> buscarProcesoContratacionOficioDesigSuperv() throws ExcepcionDAO{
        return oficioDesigSupervDao.buscarProcesoContratacionOficioDesigSuperv();
    }
}
    
    