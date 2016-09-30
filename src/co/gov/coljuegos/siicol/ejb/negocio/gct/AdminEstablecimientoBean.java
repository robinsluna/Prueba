package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecimientoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecimiento;
import co.gov.coljuegos.siicol.ejb.vo.EstablecimientoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstablecimientoBean implements AdminEstablecimiento {
    @EJB
    private EstablecimientoDAO establecimientoDao;

    public AdminEstablecimientoBean() {
    }

    public List<EstablecimientoVO> buscarEstablecimientosPorContrato(Long conCodigo) throws ExcepcionDAO {
        List<EstablecimientoVO> establecimientosVo = new ArrayList<EstablecimientoVO>();
        for(SiiEstablecimiento establecimiento : establecimientoDao.buscarEstablecimientosPorContrato(conCodigo)) {
            establecimientosVo.add(new EstablecimientoVO(establecimiento));
        }
        return establecimientosVo;
    }

    public EstablecimientoVO buscarEstablecimientoPorId(Long estCodigo) throws ExcepcionDAO {
        return new EstablecimientoVO(establecimientoDao.buscarEstablecimientoPorId(estCodigo));
    }
    
    public String buscarEstablecimientoPorNitOperador (String nit) throws ExcepcionDAO {
        return establecimientoDao.buscarEstablecimientoPorNitOperador(nit);
    }
}
