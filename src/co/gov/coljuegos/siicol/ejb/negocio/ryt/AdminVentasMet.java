package co.gov.coljuegos.siicol.ejb.negocio.ryt;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import javax.ejb.Local;

@Local
public interface AdminVentasMet {
    
    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public String cargarInformacionReporteMETLinea(Long movSolicitud, String tipoReporte, int numRegistros, Long totalVentas) throws ExcepcionDAO, ExcepcionAplicacion;

}
