/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 10-03-2016
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcSanIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoProcSanIleg;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcSanIlegVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que administra los estados del proceso sancionatorio de ilegalidad
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminEstadoProcSanIlegBean implements AdminEstadoProcSanIleg {
    
    @EJB
    private EstadoProcSanIlegDAO estadoProcSanIlegDao;
    
    /**
     * Constructor
     */
    
    public AdminEstadoProcSanIlegBean() {
        super();
    }
    
    /**
     * Buscar el estado del proceso sancionatorio de ilegalidad por código
     * @param epiCodigo
     * @return resultado - EstadoProcSanIlegVO
     * @throws ExcepcionDAO
     */
    
    public EstadoProcSanIlegVO buscarEstadoProcSanIlegPorCodigo(Long epiCodigo) throws ExcepcionDAO {
        EstadoProcSanIlegVO resultado = null;
        SiiEstadoProcSanIleg siiEstadoProcSanIleg = estadoProcSanIlegDao.buscarPorCodigo(epiCodigo);
        if (siiEstadoProcSanIleg!=null)
            resultado = new EstadoProcSanIlegVO(siiEstadoProcSanIleg);
        
        return (resultado);
    }
}
