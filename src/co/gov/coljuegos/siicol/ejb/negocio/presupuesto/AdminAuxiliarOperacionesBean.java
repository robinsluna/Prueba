package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoContratacionDAO;

import java.util.Collections;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless

public class AdminAuxiliarOperacionesBean implements AdminAuxiliarOperaciones {

    @EJB
    private ProcesoContratacionDAO procesoContratacionDAO;

    public AdminAuxiliarOperacionesBean() {
        super();
    }


    public long consultarTipoOperacion(long numeroDocumento, String tipoOperacion) throws ExcepcionDAO {
        long numeroOperacion = procesoContratacionDAO.consultarTipoOperacion(numeroDocumento, tipoOperacion);
        return numeroOperacion;
    }

    @Override
    public List<Long> consultarNumeroOperacionPorTipo(String tipoOperacion, Integer vigencia, String tdcCodigo, String tdcCodigoOrp) throws ExcepcionDAO {
        return procesoContratacionDAO.consultarNumeroOperacionPorTipo(tipoOperacion, vigencia, tdcCodigo, tdcCodigoOrp);
    }
    
}
