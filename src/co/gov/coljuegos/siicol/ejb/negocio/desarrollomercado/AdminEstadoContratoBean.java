package co.gov.coljuegos.siicol.ejb.negocio.desarrollomercado;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoContratoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoContrato;
import co.gov.coljuegos.siicol.ejb.vo.EstadoContratoVO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminEstadoContratoBean implements AdminEstadoContrato {
    @EJB 
    EstadoContratoDAO estadoContratoDao;
    
    public AdminEstadoContratoBean() {
        
    }
    
    
    public EstadoContratoVO buscarEstadoContratoPorNombre(String ecoNombre) throws ExcepcionDAO {
        return new EstadoContratoVO(estadoContratoDao.buscarEstadoContratoPorNombre(ecoNombre));
    }
    
    @Override
    public EstadoContratoVO buscarEstadoContratoPorId(Long ecoCodigo) throws ExcepcionDAO 
    {
        EstadoContratoVO resultado = null;
        SiiEstadoContrato siiEstadoContrato = estadoContratoDao.buscarEstadoContratoPorId(ecoCodigo);
        if (siiEstadoContrato!=null)
            resultado = new EstadoContratoVO(siiEstadoContrato);
        
        return (resultado);
    }
}
