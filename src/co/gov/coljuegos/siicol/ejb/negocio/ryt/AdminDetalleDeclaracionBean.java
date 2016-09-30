package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleDeclaracionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuotaOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.vo.CuotaOperadorVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleDeclaracionVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminDetalleDeclaracionBean implements AdminDetalleDeclaracion{
    @EJB
    DetalleDeclaracionDAO detalleDeclaracionDao;
    
    public AdminDetalleDeclaracionBean() {       
    }
    public DetalleDeclaracionVO buscarPorCodigoDetalleDeclaracion(Long idCodigoDetalleDeclar)  throws ExcepcionDAO {
        SiiDetalleDeclaracion siiDetalleDeclaracion = detalleDeclaracionDao.buscarPorCodigoDetalleDeclaracion(idCodigoDetalleDeclar);
        return new DetalleDeclaracionVO(siiDetalleDeclaracion);
    }
    
    public List<DetalleDeclaracionVO> buscarDetalleDeclaracionPorXCodigoCuota(Long codigoCuota) throws ExcepcionDAO {
            List<DetalleDeclaracionVO>  listaDetalleDeclaracionVo = new ArrayList< DetalleDeclaracionVO>() ;
            List<SiiDetalleDeclaracion>  listSiiDetalleDeclaracion= new ArrayList< SiiDetalleDeclaracion>() ;
            listSiiDetalleDeclaracion= detalleDeclaracionDao.buscarDetalleDeclaracionPorXCodigoCuota(codigoCuota);
            for( SiiDetalleDeclaracion siiDetalleDeclaracion: listSiiDetalleDeclaracion ){
                DetalleDeclaracionVO detalleDeclaracionVo = new DetalleDeclaracionVO(siiDetalleDeclaracion);
                listaDetalleDeclaracionVo.add(detalleDeclaracionVo);
                
            }
        return listaDetalleDeclaracionVo;
        }    
    
}
