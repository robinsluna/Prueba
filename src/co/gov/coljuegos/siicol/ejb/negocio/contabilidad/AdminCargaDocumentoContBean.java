/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTABILIDAD
 * AUTOR	: Camilo Miranda
 * FECHA	: 30-04-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CargaDocumentoContDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaDocumentoCont;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CargaDocumentoContVO;

import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminCargaDocumentoContBean implements AdminCargaDocumentoCont 
{
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private CargaDocumentoContDAO cargaDocumentoContDao;
    @EJB
    private AdminDocumentoContable adminDocumentoContable;
    
    
    
    /**
     * Constructor.
     */
    public AdminCargaDocumentoContBean() {
        super();
    }
    
    
    
    @Override
    public CargaDocumentoContVO buscarCargaDocumentoContPorId(Long cdcCodigo) throws ExcepcionDAO 
    {
        CargaDocumentoContVO resultado = null;
        SiiCargaDocumentoCont siiCargaDocumentoCont = cargaDocumentoContDao.buscarPorCodigo(cdcCodigo);
        if (siiCargaDocumentoCont!=null)
            resultado = new CargaDocumentoContVO(siiCargaDocumentoCont);
        
        return (resultado);
    }
    

    @Override
    public CargaDocumentoContVO insertarCargaDocumentoCont(CargaDocumentoContVO cargaDocumentoContVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        CargaDocumentoContVO resultado = null;
        SiiCargaDocumentoCont siiCargaDocumentoCont = cargaDocumentoContDao.insertar(conversionVoEntidad.convertir(cargaDocumentoContVo));
        if (siiCargaDocumentoCont!=null) {
            resultado = new CargaDocumentoContVO(siiCargaDocumentoCont);
            
            resultado.setDocumentoContableList(cargaDocumentoContVo.getDocumentoContableList());
            this.persistirDocumentosContables(resultado);
        }
        
        return (resultado);
    }
    
    
    @Override
    public CargaDocumentoContVO actualizarCargaDocumentoCont(CargaDocumentoContVO cargaDocumentoContVo) throws ExcepcionDAO {
        CargaDocumentoContVO resultado = null;
        SiiCargaDocumentoCont siiCargaDocumentoCont = cargaDocumentoContDao.actualizar(conversionVoEntidad.convertir(cargaDocumentoContVo));
        if (siiCargaDocumentoCont!=null) 
            resultado = new CargaDocumentoContVO(siiCargaDocumentoCont);
        
        return (resultado);
    }
    
    
    @Override
    public void borrarCargaDocumentoCont(Long cdcCodigo) throws ExcepcionDAO {
        cargaDocumentoContDao.eliminar(cdcCodigo);
    }
    
    
    @Override
    public List<CargaDocumentoContVO> buscarTodoCargaDocumentoCont() throws ExcepcionDAO {
        List<CargaDocumentoContVO> resultado = null;
        List<SiiCargaDocumentoCont> lista = cargaDocumentoContDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<CargaDocumentoContVO>();
            
            for (SiiCargaDocumentoCont siiCargaDocumentoCont: lista) {
                if (siiCargaDocumentoCont!=null)
                    resultado.add(new CargaDocumentoContVO(siiCargaDocumentoCont));
            }
        }
        
        return (resultado);
    }
    
    
    
    /**
     * Almacena el listado de Obligaciones que hacen parte de la entidad Carga N&oacute;mina.
     * @throws ExcepcionDAO
     */
    private void persistirDocumentosContables (CargaDocumentoContVO cargaDocumentoContVo) throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (cargaDocumentoContVo!=null && cargaDocumentoContVo.getDocumentoContableList()!=null) {
            for (DocumentoContableVO documentoContableVo: cargaDocumentoContVo.getDocumentoContableList()) {
                if (documentoContableVo!=null) {
                    documentoContableVo.setCargaDocumentoContVo(cargaDocumentoContVo);
                    
                    if (documentoContableVo.getDcoCodigo()==null) {
                        // OPERACION INSERTAR
                        adminDocumentoContable.insertarDocumentoContable(documentoContableVo);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        // TODO revisar el null, por si se requiere un UsuarioVO para el log de cambio de estado
                        adminDocumentoContable.actualizarDocumentoContable(documentoContableVo, null);
                    }
                }
            }
        }
    }
}
