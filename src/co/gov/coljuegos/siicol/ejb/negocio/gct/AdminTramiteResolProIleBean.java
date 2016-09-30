package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TramiteResolProIleDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolProIle;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.TramiteResolProIleVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTramiteResolProIleBean implements AdminTramiteResolProIle {
    @EJB
    private TramiteResolProIleDAO tramiteResolProIleDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    public AdminTramiteResolProIleBean() {
        super();
    }

    @Override
    public TramiteResolProIleVO buscarTramiteResolProIlePorCodigo(Long trpCodigo) throws ExcepcionDAO {
        TramiteResolProIleVO tramiteVo = null;
        SiiTramiteResolProIle tramite = tramiteResolProIleDao.buscarPorCodigo(trpCodigo);
        if (tramite!=null) 
            tramiteVo = new TramiteResolProIleVO(tramite);
        return tramiteVo;
    }

    @Override
    public List<TramiteResolProIleVO> buscarTodoTramiteResolProIle() throws ExcepcionDAO {
        List<TramiteResolProIleVO> tramitesVo = null;
        List<SiiTramiteResolProIle> tramites = tramiteResolProIleDao.buscarTodo();
        if (tramites!=null) {
            tramitesVo = new ArrayList<TramiteResolProIleVO>();
            for (SiiTramiteResolProIle tramite : tramites) {
                if (tramite!=null) {
                    tramitesVo.add(new TramiteResolProIleVO(tramite));
                }
            }
        }
        return tramitesVo;
    }

    @Override
    public List<TramiteResolProIleVO> buscarTramiteResolProIlePorIdResolucion(Long rpiCodigo) throws ExcepcionDAO {
        List<TramiteResolProIleVO> tramitesVo = null;
        List<SiiTramiteResolProIle> tramites = tramiteResolProIleDao.buscarTramiteResolProIlePorIdResolucion(rpiCodigo);
        if (tramites!= null) {
            tramitesVo = new ArrayList<TramiteResolProIleVO>();
            for (SiiTramiteResolProIle tramite : tramites) {
                if (tramite != null) tramitesVo.add(new TramiteResolProIleVO(tramite));
            }
        }
        return tramitesVo;
    }

    @Override
    public TramiteResolProIleVO insertarTramiteResolProIle(TramiteResolProIleVO tramiteVo) throws ExcepcionDAO {
        SiiTramiteResolProIle tramite = tramiteResolProIleDao.insertar(conversionVoEntidad.convertir(tramiteVo));
        if (tramite !=null) tramiteVo = new TramiteResolProIleVO(tramite);
        return tramiteVo;
    }

    @Override
    public TramiteResolProIleVO actualizarTramiteResolProIle(TramiteResolProIleVO tramiteVo) throws ExcepcionDAO {
        SiiTramiteResolProIle tramite = tramiteResolProIleDao.actualizar(conversionVoEntidad.convertir(tramiteVo));
        if (tramite!=null) tramiteVo = new TramiteResolProIleVO(tramite);
        return tramiteVo;
    }

    @Override
    public void eliminarTramiteResolProIle(Long trpCodigo) throws ExcepcionDAO {
        tramiteResolProIleDao.eliminar(trpCodigo);
    }
}
