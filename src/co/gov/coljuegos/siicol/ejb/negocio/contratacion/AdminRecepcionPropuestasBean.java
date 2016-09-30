/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACIÓN
 * AUTOR	: Camilo Miranda
 * FECHA	: 05-12-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ArchivoFisicoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PropuestaRecibDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RecepcionPropuestasDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiArchivoFisico;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPropuestaRecib;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecepcionPropuestas;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;

import co.gov.coljuegos.siicol.ejb.vo.PropuestaRecibVO;
import co.gov.coljuegos.siicol.ejb.vo.RecepcionPropuestasVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminRecepcionPropuestasBean implements AdminRecepcionPropuestas
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad; 
    @EJB
    private RecepcionPropuestasDAO recepcionPropuestasDAO;
    @EJB
    private PropuestaRecibDAO propuestaRecibDAO;
    @EJB
    private ArchivoFisicoDAO archivoFisicoDao;
    
    
    
    /**
     * Constructor.
     */
    public AdminRecepcionPropuestasBean() 
    {
        super();
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.RecepcionPropuestasDAO#buscarPorCodigoRecepcionPropuestas(java.lang.Long)
     */
    @Override
    public RecepcionPropuestasVO buscarPorCodigoRecepcionPropuestas(Long idCodigoRecepcionPropuestas) throws ExcepcionDAO {
        SiiRecepcionPropuestas rp = recepcionPropuestasDAO.buscarPorCodigoRecepcionPropuestas(idCodigoRecepcionPropuestas);
        return ( new RecepcionPropuestasVO(rp) );
    }
    
    
    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de las Propuestas Recibidas asociadas a la Recepci&oacute;n Propuestas.
     * @param rp - Entidad Recepci&oacute;n Propuestas.
     * @param recepcionPropuestasVO - Value Object Recepci&oacute;n Propuestas.
     * @throws ExcepcionDAO
     */
    private void persistirPropuestasRecibidas (SiiRecepcionPropuestas rp, RecepcionPropuestasVO recepcionPropuestasVO) 
        throws ExcepcionDAO
    {
        List<PropuestaRecibVO> propuestaRecibList = recepcionPropuestasVO.getPropuestaRecibList();
        for (PropuestaRecibVO prVO : propuestaRecibList) {
            SiiPropuestaRecib siiPr = conversionVoEntidad.convertir(prVO);
            if (siiPr!=null) {
                siiPr.setSiiRecepcionPropuestas(rp);
                if (siiPr.getPreCodigo()==null) {
                    // OPERACION INSERTAR
                    propuestaRecibDAO.insertarSiiPropuestaRecib(siiPr);
                }
                else {
                    // OPERACION ACTUALIZAR
                    propuestaRecibDAO.actualizarSiiPropuestaRecib(siiPr);
                }
            }
        }
    }
    
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.RecepcionPropuestasDAO#insertarSiiRecepcionPropuestas(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecepcionPropuestas)
     */
    @Override
    public RecepcionPropuestasVO insertarSiiRecepcionPropuestas(RecepcionPropuestasVO recepcionPropuestasVO) throws ExcepcionDAO {
        SiiRecepcionPropuestas rp = recepcionPropuestasDAO.insertarSiiRecepcionPropuestas(conversionVoEntidad.convertir(recepcionPropuestasVO));
        
        //////////////////////////
        // PROPUESTAS RECIBIDAS //
        //////////////////////////
        this.persistirPropuestasRecibidas(rp, recepcionPropuestasVO);
        
        return ( new RecepcionPropuestasVO(rp) );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.RecepcionPropuestasDAO#actualizarSiiRecepcionPropuestas(co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRecepcionPropuestas)
     */
    @Override
    public RecepcionPropuestasVO actualizarSiiRecepcionPropuestas(RecepcionPropuestasVO recepcionPropuestasVO) throws ExcepcionDAO {
        if(recepcionPropuestasVO.getArchivoFisico() != null && recepcionPropuestasVO.getArchivoFisico().getAfiCodigo() == null){
            //Insertar Archivo Fisico
            SiiArchivoFisico siiArchivoFisico = archivoFisicoDao.insertarArchivoFisico(conversionVoEntidad.convertir(recepcionPropuestasVO.getArchivoFisico()));
            recepcionPropuestasVO.getArchivoFisico().setAfiCodigo(siiArchivoFisico.getAfiCodigo());
        }
        SiiRecepcionPropuestas rp = recepcionPropuestasDAO.actualizarSiiRecepcionPropuestas(conversionVoEntidad.convertir(recepcionPropuestasVO));
        
        //////////////////////////
        // PROPUESTAS RECIBIDAS //
        //////////////////////////
        this.persistirPropuestasRecibidas(rp, recepcionPropuestasVO);
        
        return ( new RecepcionPropuestasVO(rp) );
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.RecepcionPropuestasDAO#borrarSiiRecepcionPropuestas(java.lang.Long)
     */
    @Override
    public void borrarSiiRecepcionPropuestas(Long idCodigoRecepcionPropuestas) throws ExcepcionDAO {
        recepcionPropuestasDAO.borrarSiiRecepcionPropuestas(idCodigoRecepcionPropuestas);
    }
    
    
    /*
     * (non-Javadoc)
     * @see co.gov.coljuegos.siicol.ejb.persistencia.dao.RecepcionPropuestasDAO#buscarTodoSiiRecepcionPropuestas()
     */
    public List<RecepcionPropuestasVO> buscarTodoSiiRecepcionPropuestas () throws ExcepcionDAO {
        List<RecepcionPropuestasVO> listaRP = null;
        List<SiiRecepcionPropuestas> lista = recepcionPropuestasDAO.buscarTodoSiiRecepcionPropuestas();
        
        if (lista!=null && !lista.isEmpty()) {
            listaRP = new ArrayList<RecepcionPropuestasVO>();
            
            for (SiiRecepcionPropuestas rp: lista) {
                listaRP.add(new RecepcionPropuestasVO(rp));
            }
        }
        
        return (listaRP);
    }

    @Override
    public List<RecepcionPropuestasVO> buscarPorCodigoProcesoContratacion(Long prcCodigo) throws ExcepcionDAO {
        List<RecepcionPropuestasVO> listaRP = null;
        List<SiiRecepcionPropuestas> lista = recepcionPropuestasDAO.buscarPorCodigoProcesoContratacion(prcCodigo);
        
        if (lista!=null && !lista.isEmpty()) {
            listaRP = new ArrayList<RecepcionPropuestasVO>();
            
            for (SiiRecepcionPropuestas rp: lista) {
                listaRP.add(new RecepcionPropuestasVO(rp));
            }
        }
        
        return (listaRP);
    }
}
