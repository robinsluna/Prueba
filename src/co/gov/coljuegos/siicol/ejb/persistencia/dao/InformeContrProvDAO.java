package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeContrProv;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@LocalBean
public class InformeContrProvDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public InformeContrProvDAO() {
        recursos = new Recursos();
    }

    public List<SiiInformeContrProv> buscarInformeContrProvPorActaInicio(Long acnCodigo) {
        return null;
    }
}
