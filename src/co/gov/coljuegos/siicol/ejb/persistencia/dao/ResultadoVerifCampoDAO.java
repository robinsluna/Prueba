package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResultadoVerifCampo;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ResultadoVerifCampoDAO extends AbstractDAO<Long, SiiResultadoVerifCampo>{
    public ResultadoVerifCampoDAO(){
        super(SiiResultadoVerifCampo.class);
    }
}
