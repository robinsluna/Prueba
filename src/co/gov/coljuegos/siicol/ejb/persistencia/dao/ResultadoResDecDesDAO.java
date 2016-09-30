package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResultadoResDecDes;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTramiteResolDecDes;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ResultadoResDecDesDAO extends AbstractDAO<Long, SiiResultadoResDecDes> {
    
    
    public ResultadoResDecDesDAO() {
        
        super(SiiResultadoResDecDes.class);
    
    }


}
