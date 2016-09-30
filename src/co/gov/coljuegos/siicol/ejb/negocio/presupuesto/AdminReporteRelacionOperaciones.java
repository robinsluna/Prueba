package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import javax.ejb.Local;

@Local
public interface AdminReporteRelacionOperaciones {

    public long consultarTipoOperacion(long concepto, String tipoOperacion) throws ExcepcionDAO;
    
}
