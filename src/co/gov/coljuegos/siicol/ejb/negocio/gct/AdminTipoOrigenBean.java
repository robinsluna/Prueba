package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AseguradoraDAO;

import co.gov.coljuegos.siicol.ejb.persistencia.dao.TipoOrigenDAO;

import co.gov.coljuegos.siicol.ejb.vo.AseguradoraVO;

import co.gov.coljuegos.siicol.ejb.vo.TipoOrigenVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
@Stateless
public class AdminTipoOrigenBean implements AdminTipoOrigen{    
    @EJB 
    TipoOrigenDAO tipoOrigenDao;
    
    public AdminTipoOrigenBean() {       
    }
    
    public TipoOrigenVO buscarTipoOrigenPorCodigo(Long tipoOrigenCodigo) throws ExcepcionDAO {
        
        return new TipoOrigenVO(tipoOrigenDao.buscarTipoOrigenPorId(tipoOrigenCodigo));
    }
}
