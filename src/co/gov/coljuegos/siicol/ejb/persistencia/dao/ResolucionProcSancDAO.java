package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiResolucionProcSanc;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * Data Access Object para el manejo de Resoluci&oacute;n de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class ResolucionProcSancDAO extends AbstractDAO<Long, SiiResolucionProcSanc> 
{
    /**
     * Constructor.
     */
    public ResolucionProcSancDAO() 
    {
        super(SiiResolucionProcSanc.class);
    }
}
