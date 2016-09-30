/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 11-06-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.NotaCreditoDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConcDetRubVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCredOblConceptoVO;
import co.gov.coljuegos.siicol.ejb.vo.NotaCreditoVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para la administraci&oacute;n de Notas de Cr&eacute;dito.
 * @author Camilo Miranda
 */
@Stateless
public class AdminNotaCreditoBean implements AdminNotaCredito 
{
    @EJB
    private NotaCreditoDAO notaCreditoDao;
    @EJB
    private AdminNotaCredOblConcepto adminNotaCredOblConcepto;
    @EJB
    private AdminNotaCredOblConcDetRub adminNotaCredOblConcDetRub;
    @EJB
    private AdminDocumentoContable adminDocumentoContable;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    
    
    ////////////////////////////////////////////////
    // Listas para eliminacion de entidades hijas //
    ////////////////////////////////////////////////
    private List<NotaCredOblConceptoVO> listaNotaCredOblConceptoEliminar;
    private List<NotaCredOblConcDetRubVO> listaNotaCredOblConcDetRubEliminar;
    
    
    
    /**
     * Constructor.
     */
    public AdminNotaCreditoBean() { }
    
    

    @Override
    public NotaCreditoVO buscarNotaCreditoPorId(Long ncrCodigo) throws ExcepcionDAO {
        NotaCreditoVO resultado = null;
        SiiNotaCredito siiNotaCredito = notaCreditoDao.buscarPorCodigo(ncrCodigo);
        if (siiNotaCredito!=null)
            resultado = new NotaCreditoVO(siiNotaCredito);
        
        return (resultado);
    }
    
    
    
    /**
     * Persiste los hijos de la Nota de Cr&eacute;dito.
     * @param notaCreditoVo - Nota de Cr&eacute;dito padre.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirHijos (NotaCreditoVO notaCreditoVo) throws ExcepcionDAO, ExcepcionAplicacion
    {
        this.persistirNotaCredOblConceptos(notaCreditoVo);
        this.persistirNotaCredOblConcDetRub(notaCreditoVo);
        this.persistirDocumentosContables(notaCreditoVo);
    }
    
    
    
    /**
     * Persiste los Conceptos asociados a la Nota de Cr&eacute;dito especificada.
     * @param notaCreditoVo - Nota de Cr&eacute;dito.
     * @throws ExcepcionDAO
     */
    private void persistirNotaCredOblConceptos (NotaCreditoVO notaCreditoVo) throws ExcepcionDAO 
    {
        if (notaCreditoVo!=null && notaCreditoVo.getNotaCredOblConceptoList()!=null) {
            for (NotaCredOblConceptoVO ncocoVo: notaCreditoVo.getNotaCredOblConceptoList()) {
                if (ncocoVo!=null) {
                    ncocoVo.setNotaCreditoVo(notaCreditoVo);
                    
                    if (ncocoVo.getNcoCodigo() == null) {
                        // OPERACION INSERTAR
                        adminNotaCredOblConcepto.insertarNotaCredOblConcepto(ncocoVo);
                    } else {
                        // OPERACION ACTUALIZAR
                        adminNotaCredOblConcepto.actualizarNotaCredOblConcepto(ncocoVo);
                    }
                }
            }
        }
    }
    
    
    /**
     * Persiste los Conceptos/Detalle Rubro asociados a la Nota de Cr&eacute;dito especificada.
     * @param notaCreditoVo - Nota de Cr&eacute;dito.
     * @throws ExcepcionDAO
     */
    private void persistirNotaCredOblConcDetRub (NotaCreditoVO notaCreditoVo) throws ExcepcionDAO 
    {
        if (notaCreditoVo!=null && notaCreditoVo.getNotaCredOblConcDetRubList()!=null) {
            for (NotaCredOblConcDetRubVO ncocrVo: notaCreditoVo.getNotaCredOblConcDetRubList()) {
                if (ncocrVo!=null) {
                    ncocrVo.setNotaCreditoVo(notaCreditoVo);
                    
                    if (ncocrVo.getNdrCodigo() == null) {
                        // OPERACION INSERTAR
                        adminNotaCredOblConcDetRub.insertarNotaCredOblConcDetRub(ncocrVo);
                    } else {
                        // OPERACION ACTUALIZAR
                        adminNotaCredOblConcDetRub.actualizarNotaCredOblConcDetRub(ncocrVo);
                    }
                }
            }
        }
    }
    
    
    /**
     * Persiste los Documentos Contables asociados a la Nota de Cr&eacute;dito especificada.
     * @param notaCreditoVo - Nota de Cr&eacute;dito.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirDocumentosContables (NotaCreditoVO notaCreditoVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        if (notaCreditoVo!=null && notaCreditoVo.getDocumentoContableList()!=null) {
            for (DocumentoContableVO documentoContableVo: notaCreditoVo.getDocumentoContableList()) {
                if (documentoContableVo!=null) {
                    documentoContableVo.setNotaCreditoVo(notaCreditoVo);
                    
                    if (documentoContableVo.getDcoCodigo() == null) {
                        // OPERACION INSERTAR
                        adminDocumentoContable.insertarDocumentoContable(documentoContableVo, true);
                    } else {
                        // OPERACION ACTUALIZAR
                        adminDocumentoContable.actualizarDocumentoContable(documentoContableVo, notaCreditoVo.getUsuarioApruebaVo(), true);
                    }
                }
            }
        }
    }
    
    
    
    @Override
    public NotaCreditoVO insertarNotaCredito(NotaCreditoVO notaCreditoVo) throws ExcepcionDAO, ExcepcionAplicacion {
        NotaCreditoVO resultado = null;
        
        try {
            SiiNotaCredito siiNotaCredito = notaCreditoDao.insertar(conversionVoEntidad.convertir(notaCreditoVo));
            if (siiNotaCredito!=null) {
                resultado = new NotaCreditoVO(siiNotaCredito);
                
                // persistir las entidades hijas provenientes de la nota de credito
                resultado.setNotaCredOblConceptoList(notaCreditoVo.getNotaCredOblConceptoList());
                resultado.setNotaCredOblConcDetRubList(notaCreditoVo.getNotaCredOblConcDetRubList());
                resultado.setDocumentoContableList(notaCreditoVo.getDocumentoContableList());
                this.persistirHijos(resultado);
            }
        }
        catch(ExcepcionAplicacion|ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al insertar la Nota de Crédito: "+e.getMessage());
        }
        
        return (resultado);
    }
    
    
    @Override
    public NotaCreditoVO actualizarNotaCredito(NotaCreditoVO notaCreditoVo) throws ExcepcionDAO, ExcepcionAplicacion {
        NotaCreditoVO resultado = null;
        
        try {
            // eliminar entidades hijas pendientes por remover
            this.eliminarHijos();
            
            
            SiiNotaCredito siiNotaCredito = notaCreditoDao.actualizar(conversionVoEntidad.convertir(notaCreditoVo));
            if (siiNotaCredito!=null) {
                resultado = new NotaCreditoVO(siiNotaCredito);
                
                // persistir las entidades hijas provenientes de la nota de credito
                resultado.setNotaCredOblConceptoList(notaCreditoVo.getNotaCredOblConceptoList());
                resultado.setNotaCredOblConcDetRubList(notaCreditoVo.getNotaCredOblConcDetRubList());
                resultado.setDocumentoContableList(notaCreditoVo.getDocumentoContableList());
                this.persistirHijos(resultado);
            }
        }
        catch(ExcepcionAplicacion|ExcepcionDAO ex) {
            throw ex;
        }
        catch (Exception e) {
            e.printStackTrace();
            throw new ExcepcionAplicacion("Error al actualizar la Nota de Crédito: "+e.getMessage());
        }
        
        return (resultado);
    }
    
    
    @Override
    public void borrarNotaCredito(Long ncrCodigo) throws ExcepcionDAO {
        notaCreditoDao.eliminar(ncrCodigo);
    }
    
    
    @Override
    public List<NotaCreditoVO> buscarTodaNotaCredito() throws ExcepcionDAO {
        List<NotaCreditoVO> resultado = null;
        List<SiiNotaCredito> lista = notaCreditoDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<NotaCreditoVO>();
            for (SiiNotaCredito siiNotaCredito: lista) {
                if (siiNotaCredito!=null)
                    resultado.add(new NotaCreditoVO(siiNotaCredito));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public Date obtenerUltimaFechaRegistrada (String ncrTipoNota) throws ExcepcionDAO {
        return ( notaCreditoDao.obtenerUltimaFechaRegistrada(ncrTipoNota) );
    }
    
    
    @Override
    public Integer obtenerConsecutivoNotaCredito (String ncrTipoNota) throws ExcepcionDAO {
        return ( notaCreditoDao.obtenerConsecutivoNotaCredito(ncrTipoNota) );
    }
    
    
    @Override
    public List<NotaCreditoVO> buscarNotaCreditoPorTipo (String ncrTipoNota) throws ExcepcionDAO {
        List<NotaCreditoVO> resultado = null;
        List<SiiNotaCredito> lista = notaCreditoDao.buscarNotaCreditoPorTipo(ncrTipoNota);
        if (lista!=null) {
            resultado = new ArrayList<NotaCreditoVO>();
            for (SiiNotaCredito siiNotaCredito: lista) {
                if (siiNotaCredito!=null)
                    resultado.add(new NotaCreditoVO(siiNotaCredito));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<NotaCreditoVO> buscarNotaCreditoPorCodigoObligacion(Long oblCodigo) throws ExcepcionDAO {
        List<NotaCreditoVO> resultado = null;
        List<SiiNotaCredito> lista = notaCreditoDao.buscarNotaCreditoPorCodigoObligacion(oblCodigo);
        if (lista!=null) {
            resultado = new ArrayList<NotaCreditoVO>();
            for (SiiNotaCredito siiNotaCredito: lista) {
                if (siiNotaCredito!=null)
                    resultado.add(new NotaCreditoVO(siiNotaCredito));
            }
        }
        
        return (resultado);
    }
    
    
    
    @Override
    public List<NotaCreditoVO> buscarNotaCreditoPorObligacionFFCTipoNotaEstado(Long oblCodigo, String ffcCodigo, String ncrTipoNota, String ncrEstado) throws ExcepcionDAO 
    {
        List<NotaCreditoVO> resultado = null;
        List<SiiNotaCredito> lista = notaCreditoDao.buscarNotaCreditoPorObligacionFFCTipoNotaEstado(oblCodigo, ffcCodigo, ncrTipoNota, ncrEstado);
        if (lista!=null) {
            resultado = new ArrayList<NotaCreditoVO>();
            for (SiiNotaCredito siiNotaCredito: lista) {
                if (siiNotaCredito!=null)
                    resultado.add(new NotaCreditoVO(siiNotaCredito));
            }
        }
        
        return (resultado);
    }
    
    
    
    @Override
    public void setListaNotaCredOblConceptoEliminar(List<NotaCredOblConceptoVO> listaNotaCredOblConceptoEliminar) {
        this.listaNotaCredOblConceptoEliminar = listaNotaCredOblConceptoEliminar;
    }
    
    @Override
    public void setListaNotaCredOblConcDetRubEliminar(List<NotaCredOblConcDetRubVO> listaNotaCredOblConcDetRubEliminar) {
        this.listaNotaCredOblConcDetRubEliminar = listaNotaCredOblConcDetRubEliminar;
    }
    
    
    /**
     * Elimina las entidades hijas que se encuentran pendientes por remover.
     * @throws ExcepcionDAO
     */
    private void eliminarHijos() throws ExcepcionDAO {
        ///////////////
        // Conceptos //
        ///////////////
        if (listaNotaCredOblConceptoEliminar != null)
            this.eliminarNotaCredOblConcepto();

        //////////////////////////
        // RP Detalle Rubro CDP //
        //////////////////////////
        if (listaNotaCredOblConcDetRubEliminar != null)
            this.eliminarNotaCredOblConcDetRub();
    }


    /**
     * Elimina c/u de los Conceptos de Obligaci&oacute;n que se encuentran asociados a la Nota de Cr&eacute;dito, pero que est&aacute;n pendientes por eliminar.
     * @throws ExcepcionDAO
     */
    private void eliminarNotaCredOblConcepto() throws ExcepcionDAO {
        try {
            if (listaNotaCredOblConceptoEliminar != null && !listaNotaCredOblConceptoEliminar.isEmpty()) {
                for (NotaCredOblConceptoVO notaCredOblConceptoVo: listaNotaCredOblConceptoEliminar) {
                    if (notaCredOblConceptoVo!=null && notaCredOblConceptoVo.getNcoCodigo()!=null) {
                        adminNotaCredOblConcepto.borrarNotaCredOblConcepto(notaCredOblConceptoVo.getNcoCodigo());
                    }
                }
                
                listaNotaCredOblConceptoEliminar = null;
            }
        }
        catch (ExcepcionDAO e) {
            throw new ExcepcionDAO("Error al momento de eliminar los Conceptos ("+e.getMessage()+").", e);
        }
    }
    
    
    /**
     * Elimina c/u de los Conceptos que se encuentran asociados a la Obligaci&oacute;n, pero que est&aacute;n pendientes por eliminar.
     * @throws ExcepcionDAO
     */
    private void eliminarNotaCredOblConcDetRub() throws ExcepcionDAO {
        try {
            if (listaNotaCredOblConcDetRubEliminar != null && !listaNotaCredOblConcDetRubEliminar.isEmpty()) {
                for (NotaCredOblConcDetRubVO notaCredOblConcDetRubVo: listaNotaCredOblConcDetRubEliminar) {
                    if (notaCredOblConcDetRubVo!=null && notaCredOblConcDetRubVo.getNdrCodigo()!=null) {
                        adminNotaCredOblConcDetRub.borrarNotaCredOblConcDetRub(notaCredOblConcDetRubVo.getNdrCodigo());
                    }
                }
                
                listaNotaCredOblConcDetRubEliminar = null;
            }
        }
        catch (ExcepcionDAO e) {
                throw new ExcepcionDAO("Error al momento de eliminar los Conceptos/Detalle Rubro ("+e.getMessage()+").", e);
        }
    }
}
