package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;

import javax.ejb.Local;

@Local
public interface AdminExpedienteDocum {
    public String listaRadicadosDelExpediente(String edoCodigo) throws ExcepcionDAO;
}