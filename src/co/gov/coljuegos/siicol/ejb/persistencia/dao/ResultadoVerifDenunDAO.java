package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoIlegDenun;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResultadoVerifDenun;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class ResultadoVerifDenunDAO extends AbstractDAO<Long, SiiResultadoVerifDenun> {


    public ResultadoVerifDenunDAO() {
        super(SiiResultadoVerifDenun.class);
    }
    
}
