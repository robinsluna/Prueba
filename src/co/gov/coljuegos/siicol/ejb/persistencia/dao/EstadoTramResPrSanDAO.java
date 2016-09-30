package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstadoTramResPrSan;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;


/**
 * Data Access Object para el manejo de Estados de Tr&aacute;mite de Resoluci&oacute;n de Proceso Sancionatorio.
 * @author Camilo Miranda
 */
@Stateless
@LocalBean
public class EstadoTramResPrSanDAO extends AbstractDAO<Long, SiiEstadoTramResPrSan> 
{
    /**
     * Constructor.
     */
    public EstadoTramResPrSanDAO() 
    {
        super(SiiEstadoTramResPrSan.class);
    }
}
