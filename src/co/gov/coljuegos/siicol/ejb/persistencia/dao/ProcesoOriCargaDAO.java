package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiConceptoProyeccionCar;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoOriCarga;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

@Stateless
@LocalBean
public class ProcesoOriCargaDAO  extends GenericDAO<SiiProcesoOriCarga>{
    public ProcesoOriCargaDAO(){
        super(SiiProcesoOriCarga.class);
    }
    
    
}
