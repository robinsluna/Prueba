/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 14-09-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AuditorOrdenTrabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAuditorOrdenTrab;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuadranteOrdenTra;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredOblConcepto;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.AuditorOrdenTrabVO;

import co.gov.coljuegos.siicol.ejb.vo.CuadranteOrdenTraVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConceptoVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona los auditores de las órdenes de trabajo de visita.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminAuditorOrdenTrabBean implements AdminAuditorOrdenTrab{
    
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    @EJB
    private AuditorOrdenTrabDAO auditorOrdenTrabDao;
    
    /**
     * Constructor.
     */
    public AdminAuditorOrdenTrabBean() {
        super();
    }
    
    /**
     * Insertar el auditor de la orden de trabajo de visita
     * @param auditorOrdenTrabVo 
     * @return resultado - Auditor que se insertó en la BD
     * @throws ExcepcionDAO
     */
    public AuditorOrdenTrabVO insertarAuditorOrdenTrab(AuditorOrdenTrabVO auditorOrdenTrabVo) throws ExcepcionDAO {
        AuditorOrdenTrabVO resultado = null;
        SiiAuditorOrdenTrab siiAuditorOrdenTrab = auditorOrdenTrabDao.insertar(conversionVoEntidad.convertir(auditorOrdenTrabVo));
        if (siiAuditorOrdenTrab!=null)
            resultado = new AuditorOrdenTrabVO(siiAuditorOrdenTrab);
        
        return (resultado);
    }
    
    /**
     * Actualizar el auditor de la orden de trabajo de visita
     * @param auditorOrdenTrabVo
     * @return resultado - auditor actualizado
     * @throws ExcepcionDAO
     */
    public AuditorOrdenTrabVO actualizarAuditorOrdenTrab(AuditorOrdenTrabVO auditorOrdenTrabVo) throws ExcepcionDAO {
        AuditorOrdenTrabVO resultado = null;
        SiiAuditorOrdenTrab siiAuditorOrdenTrab = auditorOrdenTrabDao.actualizar(conversionVoEntidad.convertir(auditorOrdenTrabVo));
        if (siiAuditorOrdenTrab!=null)
            resultado = new AuditorOrdenTrabVO(siiAuditorOrdenTrab);
        
        return (resultado);
    }
    
    /**
     * Busca todos los auditores con ese código de orden de trabajo de visita.
     * @param codOrdenTrabajo
     * @return resultado - Lista de los auditores
     * @throws ExcepcionDAO
     */
    public List<AuditorOrdenTrabVO> buscarAuditorOrdenTraXCodOrdenTrabajo(Long codOrdenTrabajo) throws ExcepcionDAO {
        List<AuditorOrdenTrabVO> resultado = new ArrayList();
        List<SiiAuditorOrdenTrab> listaAuditorOrdenTra =
            auditorOrdenTrabDao.buscarTodoAuditorXOrdenTrab(codOrdenTrabajo);

        if (listaAuditorOrdenTra != null) {
            for (SiiAuditorOrdenTrab aud : listaAuditorOrdenTra) {
                resultado.add(new AuditorOrdenTrabVO(aud));
            }
        }

        return resultado;
    }
    
    /**
     * 
     * @param suaCodigo
     * @return boolean
     * @throws ExcepcionDAO
     */
    
   public boolean isAsignado(Long suaCodigo) throws ExcepcionDAO {
        return auditorOrdenTrabDao.isAsignado(suaCodigo) ;
    }
}
