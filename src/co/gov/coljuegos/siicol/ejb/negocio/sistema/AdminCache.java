package co.gov.coljuegos.siicol.ejb.negocio.sistema;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import javax.ejb.Local;

@Local
public interface AdminCache {
    public void limpiarCache() throws ExcepcionDAO;
}
