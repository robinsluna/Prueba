package co.gov.coljuegos.siicol.ejb.negocio.pactesoreria;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoDocCobroSolPagoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.TrasladoCuentasBancariasDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoDocSopSolicPago;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTrasladoBancario;
import co.gov.coljuegos.siicol.ejb.vo.TipoDocCobroSolPagoVO;
import co.gov.coljuegos.siicol.ejb.vo.TrasladoCuentasBancariasVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminTipoDocCobroSolPagoBean  implements AdminTipoDocCobroSolPago {
    @EJB
    TipoDocCobroSolPagoDAO tipoDocCobroSolPagoDao;
    
    
    /**
     * Constructor.
     */
    public AdminTipoDocCobroSolPagoBean() {
   
    }
    
    
    public List<TipoDocCobroSolPagoVO> buscarTodoTipoDocCobroSolPago() throws ExcepcionDAO{
        List<TipoDocCobroSolPagoVO> listaSiiTipoDocSopSolicPago= new ArrayList<TipoDocCobroSolPagoVO>();
        
        List<SiiTipoDocSopSolicPago>  listaTipoDocSopSolic = tipoDocCobroSolPagoDao.buscarTodoTipoDocCobroSolPago();
        
        for(SiiTipoDocSopSolicPago  unTrasBancario :listaTipoDocSopSolic){
            TipoDocCobroSolPagoVO nuevoTipoDocCobroSolPagoVO= new TipoDocCobroSolPagoVO(unTrasBancario); 
            listaSiiTipoDocSopSolicPago.add(nuevoTipoDocCobroSolPagoVO);
            
        }
        return listaSiiTipoDocSopSolicPago;
    }


    public TipoDocCobroSolPagoVO buscarTipoDocSopSolicPagoPorId(Long tspCodigo) throws ExcepcionDAO {
        TipoDocCobroSolPagoVO resultado = null;
        SiiTipoDocSopSolicPago siiTipoDocSopSolicPago = tipoDocCobroSolPagoDao.buscarPorCodigo(tspCodigo);
        if (siiTipoDocSopSolicPago!=null)
            resultado = new TipoDocCobroSolPagoVO(siiTipoDocSopSolicPago);
        
        return (resultado);
    }
}
