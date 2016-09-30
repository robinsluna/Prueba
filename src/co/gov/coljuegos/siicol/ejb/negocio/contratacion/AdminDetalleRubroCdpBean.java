package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRubroCdpDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubroCdp;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroCdpVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminDetalleRubroCdpBean implements AdminDetalleRubroCdp{
    @EJB 
    ConversionVOEntidad conversionVoEntidad; 
    @EJB 
    DetalleRubroCdpDAO detalleRubroCdpDao;


    public AdminDetalleRubroCdpBean() {
    }

    
    public DetalleRubroCdpVO buscarPorCodigoDetalleRubro(Long idDetalleRubroCdp) throws ExcepcionDAO {
        SiiDetalleRubroCdp detalleRubroCdp = detalleRubroCdpDao.buscarPorCodigoDetalleRubro(idDetalleRubroCdp);
        return new DetalleRubroCdpVO(detalleRubroCdp);
    }

    
    public DetalleRubroCdpVO insertarSiiDetalleRubroCdp(DetalleRubroCdpVO detalleRubroCdpVO) throws ExcepcionDAO {
        SiiDetalleRubroCdp detalleRubroCdp = detalleRubroCdpDao.insertarSiiDetalleRubroCdp(conversionVoEntidad.convertir(detalleRubroCdpVO));
        return new DetalleRubroCdpVO(detalleRubroCdp);
    }

   
    public DetalleRubroCdpVO actualizarSiiDetalleRubroCdp(DetalleRubroCdpVO detalleRubroCdpVO) throws ExcepcionDAO {
        SiiDetalleRubroCdp detalleRubroCdp = detalleRubroCdpDao.actualizarSiiDetalleRubroCdp(conversionVoEntidad.convertir(detalleRubroCdpVO));
        return new DetalleRubroCdpVO(detalleRubroCdp);
    }

    public void borrarPorCodigoDetalleRubro(Long idDetalleRubroCdp) throws ExcepcionDAO {
        detalleRubroCdpDao.borrarPorCodigoDetalleRubro(idDetalleRubroCdp);
    }

    public List<DetalleRubroCdpVO> buscarTodoSiiDetalleRubroCdp() throws ExcepcionDAO {
        List<SiiDetalleRubroCdp> listaDetalleRubroCdp = detalleRubroCdpDao.buscarTodoSiiDetalleRubroCdp();
        List<DetalleRubroCdpVO> listaDetalleRubroCdpVO = new ArrayList();
        for (SiiDetalleRubroCdp unDetalleRubroCdp : listaDetalleRubroCdp) {
            listaDetalleRubroCdpVO.add(new DetalleRubroCdpVO(unDetalleRubroCdp));
        }
        return listaDetalleRubroCdpVO;
    }
    
    public List<DetalleRubroCdpVO> buscarDetalleRubroCdpPorIdCdp(Long idCdp) throws ExcepcionDAO {
        List<SiiDetalleRubroCdp> listaDetalleRubroCdp = detalleRubroCdpDao.buscarDetalleRubroCdpPorIdCdp(idCdp);
        List<DetalleRubroCdpVO> listaDetalleRubroCdpVo = new ArrayList();
        for (SiiDetalleRubroCdp unDetalleRubroCdp : listaDetalleRubroCdp){
            listaDetalleRubroCdpVo.add(new DetalleRubroCdpVO(unDetalleRubroCdp));
        }
        return listaDetalleRubroCdpVo;
    }
    
    public List<DetalleRubroCdpVO> buscarDetalleRubroCdpPorDetalleRubroYcdp(Long druCodigo, Long cdpCodigo )  throws ExcepcionDAO {
        List<DetalleRubroCdpVO> listaDetalleRubroCdpVo = new ArrayList();
        for (SiiDetalleRubroCdp unDetalleRubroCdp :detalleRubroCdpDao.buscarDetalleRubroCdpPorDetalleRubroYcdp (druCodigo,cdpCodigo)) {
            listaDetalleRubroCdpVo.add(new DetalleRubroCdpVO(unDetalleRubroCdp));
        }
        return listaDetalleRubroCdpVo;
    }
    
    public DetalleRubroCdpVO buscarDetalleRubroCdpPorDetalleRubroYcdpYgmf(Long druCodigo, Long cdpCodigo , String drcAplicaGmf) throws ExcepcionDAO {
        return new DetalleRubroCdpVO(detalleRubroCdpDao.buscarDetalleRubroCdpPorDetalleRubroYcdpYgmf(druCodigo, cdpCodigo, drcAplicaGmf));
    }
    
    public String aplicaGmfAlRubroDelCdp(Long druCodigo, Long cdpCodigo) throws ExcepcionDAO {
        return detalleRubroCdpDao.aplicaGmfAlRubroDelCdp(druCodigo, cdpCodigo);
    }
    
    public List<DetalleRubroCdpVO> buscarDetallesRubroCdpPorDruCodigo(Long druCodigo) throws ExcepcionDAO {
        List<DetalleRubroCdpVO> detallesRubroCdpVO = new ArrayList<DetalleRubroCdpVO>();
        for  (SiiDetalleRubroCdp detalle :detalleRubroCdpDao.buscarDetallesRubroCdpPorDruCodigo(druCodigo) ) {
            detallesRubroCdpVO.add(new DetalleRubroCdpVO(detalle));
        }
        return detallesRubroCdpVO;
    }

}
