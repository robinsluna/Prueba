package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import java.util.List;

import javax.ejb.Local;

@Local
public interface AdminAuxiliarOperaciones {
    
    public long consultarTipoOperacion(long numeroDocumento, String tipoOperacion) throws ExcepcionDAO;
    public List<Long> consultarNumeroOperacionPorTipo (String tipoOperacion, Integer vigencia, String tdcCodigo, String tdcCodigoOrp) throws ExcepcionDAO;

}
