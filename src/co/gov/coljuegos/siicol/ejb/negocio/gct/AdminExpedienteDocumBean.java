package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ExpedienteDocumDAO;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminExpedienteDocumBean implements AdminExpedienteDocum{
    @EJB 
    ExpedienteDocumDAO expedienteDocumDao;
    public AdminExpedienteDocumBean() {
       
    }
    public String listaRadicadosDelExpediente(String edoCodigo) throws ExcepcionDAO {
        return expedienteDocumDao.listaRadicadosDelExpediente(edoCodigo);
    }
}