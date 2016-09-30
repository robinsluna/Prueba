package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstablecSuspensionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecSuspension;
import co.gov.coljuegos.siicol.ejb.vo.EstablecSuspensionVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstablecSuspensionBean implements AdminEstablecSuspension {
    @EJB
    private EstablecSuspensionDAO establecSuspensionDao;
    public List<EstablecSuspensionVO> buscarEstablecSuspensionPorSuspension(Long scoCodigo) throws ExcepcionDAO {
        List<EstablecSuspensionVO> establecimientoSuspensionVo = new ArrayList<EstablecSuspensionVO>();
        for (SiiEstablecSuspension establecimientoSuspension : establecSuspensionDao.buscarEstablecSuspensionPorSuspension(scoCodigo) ) {
            establecimientoSuspensionVo.add(new EstablecSuspensionVO(establecimientoSuspension));
        }
        return establecimientoSuspensionVo;
    }
}
