package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ReporteRelacionOperacionesDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminReporteRelacionOperacionesBean implements AdminReporteRelacionOperaciones{
    
    @EJB
    private ReporteRelacionOperacionesDAO ReporteRelacionOperacionesDAO;
    
    /**
     * Constructor.
     */
    public AdminReporteRelacionOperacionesBean() {
    }
     
    public long consultarTipoOperacion(long concepto, String tipoOperacion) throws ExcepcionDAO {
        long nuOperacion = ReporteRelacionOperacionesDAO.consultarTipoOperacion(concepto, tipoOperacion);
        return nuOperacion;
    }

}

