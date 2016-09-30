package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.contabilidad.AdminNotaCredOblConcDetRub;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.AutoComisorioAccConDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAutoComisorioAccCon;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.vo.AutoComisorioAccConVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminAutoComisorioAccConBean implements AdminAutoComisorioAccCon {
    
    @EJB
    private AutoComisorioAccConDAO autoComisorioAccConDao;
    
    /**
     * Constructor.
     */
    
    public AdminAutoComisorioAccConBean() {
    }
    
    /**
     * Buscar un auto comisorio de acción control según el id de una denuncia.
     * @param denCodigo
     * @return resultado - AutoComisorioAccConVO
     * @throws ExcepcionDAO
     */
    
    public AutoComisorioAccConVO buscarUnAutoComisorioAccPorDenuncia(Long denCodigo) throws ExcepcionDAO {
        AutoComisorioAccConVO resultado = null;
        SiiAutoComisorioAccCon siiAutoComisorioAccCon = autoComisorioAccConDao.buscarUnAutoComisorioAccPorDenuncia(denCodigo);
        if (siiAutoComisorioAccCon!=null)
            resultado = new AutoComisorioAccConVO(siiAutoComisorioAccCon);
        
        return (resultado);
    }
}
