package co.gov.coljuegos.siicol.ejb.negocio.contabilidad;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.pactesoreria.AdminDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.CierreAnualContableDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCierreAnualContable;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.CierreAnualContableVO;

import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminCierreAnualContableBean implements AdminCierreAnualContable 
{
    @EJB
    private CierreAnualContableDAO cierreAnualContableDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminDocumentoContable adminDocumentoContable;
    
    
    
    /**
     * Constructor.
     */
    public AdminCierreAnualContableBean() { }

    @Override
    public CierreAnualContableVO buscarCierreAnualContablePorId(Long cacCodigo) throws ExcepcionDAO {
        CierreAnualContableVO resultado = null;
        SiiCierreAnualContable siiCierreAnualContable = cierreAnualContableDao.buscarPorCodigo(cacCodigo);
        if (siiCierreAnualContable!=null)
            resultado = new CierreAnualContableVO(siiCierreAnualContable);
        
        return (resultado);
    }
    
    
    
    /**
     * Almacena la informaci&oacute;n de los hijos del Cierre Anual Contable.
     */
    private void persistirHijos(CierreAnualContableVO cierreAnualContableVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        // DOCUMENTOS CONTABLES
        this.persistirDocumentosContables(cierreAnualContableVo);
    }
    
    
    /**
     * Almacena los registros de Documento Contable que se encuentran asociados al Cierre Anual Contable especificado.
     * @param cierreAnualContableVo - Cierre Anual Contable.
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirDocumentosContables (CierreAnualContableVO cierreAnualContableVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        if (cierreAnualContableVo!=null && cierreAnualContableVo.getDocumentoContableList()!=null && !cierreAnualContableVo.getDocumentoContableList().isEmpty()) {
            for (DocumentoContableVO documentoContableVo: cierreAnualContableVo.getDocumentoContableList()) {
                if (documentoContableVo!=null) {
                    // asociar el presente registro de Cierre Anual Contable
                    documentoContableVo.setCierreAnualContableVo(cierreAnualContableVo);
                    
                    if (cierreAnualContableVo.getCacCodigo()==null) {
                        // INSERTAR
                        adminDocumentoContable.insertarDocumentoContable(documentoContableVo);
                    }
                    else {
                        // ACTUALIZAR
                        adminDocumentoContable.actualizarDocumentoContable(documentoContableVo, documentoContableVo.getUsuarioRegistraVo());
                    }
                }
            }
        }
    }
    
    
    
    @Override
    public CierreAnualContableVO insertarCierreAnualContable(CierreAnualContableVO cierreAnualContableVo) throws ExcepcionDAO, ExcepcionAplicacion {
        return ( this.insertarCierreAnualContable(cierreAnualContableVo, false) );
    }
    
    @Override
    public CierreAnualContableVO insertarCierreAnualContable(CierreAnualContableVO cierreAnualContableVo, boolean doCascade) throws ExcepcionDAO, ExcepcionAplicacion {
        CierreAnualContableVO resultado = null;
        SiiCierreAnualContable siiCierreAnualContable = cierreAnualContableDao.insertar(conversionVoEntidad.convertir(cierreAnualContableVo));
        if (siiCierreAnualContable!=null) {
            resultado = new CierreAnualContableVO(siiCierreAnualContable);
            
            if (doCascade) {
                resultado.setDocumentoContableList(cierreAnualContableVo.getDocumentoContableList());
                
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public CierreAnualContableVO actualizarCierreAnualContable(CierreAnualContableVO cierreAnualContableVo) throws ExcepcionDAO, ExcepcionAplicacion {
        return ( this.actualizarCierreAnualContable(cierreAnualContableVo, false) );
    }
    
    
    @Override
    public CierreAnualContableVO actualizarCierreAnualContable(CierreAnualContableVO cierreAnualContableVo, boolean doCascade) throws ExcepcionDAO, ExcepcionAplicacion {
        CierreAnualContableVO resultado = null;
        SiiCierreAnualContable siiCierreAnualContable = cierreAnualContableDao.actualizar(conversionVoEntidad.convertir(cierreAnualContableVo));
        if (siiCierreAnualContable!=null) {
            resultado = new CierreAnualContableVO(siiCierreAnualContable);
            
            if (doCascade) {
                resultado.setDocumentoContableList(cierreAnualContableVo.getDocumentoContableList());
                
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public void borrarCierreAnualContable(Long cacCodigo) throws ExcepcionDAO {
        cierreAnualContableDao.eliminar(cacCodigo);
    }
    
    
    @Override
    public List<CierreAnualContableVO> buscarTodoCierreAnualContable() throws ExcepcionDAO {
        List<CierreAnualContableVO> resultado = null;
        List<SiiCierreAnualContable> lista = cierreAnualContableDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<CierreAnualContableVO>();
            
            for (SiiCierreAnualContable siiCierreAnualContable: lista) {
                if (siiCierreAnualContable!=null) {
                    resultado.add(new CierreAnualContableVO(siiCierreAnualContable));
                }
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<CierreAnualContableVO> buscarPorVigencia (Integer cacVigencia) throws ExcepcionDAO {
        List<CierreAnualContableVO> resultado = null;
        List<SiiCierreAnualContable> lista = cierreAnualContableDao.buscarPorVigencia(cacVigencia);
        if (lista!=null) {
            resultado = new ArrayList<CierreAnualContableVO>();
            
            for (SiiCierreAnualContable siiCierreAnualContable: lista) {
                if (siiCierreAnualContable!=null) {
                    resultado.add(new CierreAnualContableVO(siiCierreAnualContable));
                }
            }
        }
        return (resultado);
    }
    
    
    @Override
    public List<CierreAnualContableVO> buscarCierresAprobados () throws ExcepcionDAO {
        List<CierreAnualContableVO> resultado = null;
        List<SiiCierreAnualContable> lista = cierreAnualContableDao.buscarCierresAprobados();
        if (lista!=null) {
            resultado = new ArrayList<CierreAnualContableVO>();
            
            for (SiiCierreAnualContable siiCierreAnualContable: lista) {
                if (siiCierreAnualContable!=null) {
                    resultado.add(new CierreAnualContableVO(siiCierreAnualContable));
                }
            }
        }
        return (resultado);
    }
    
    
    @Override
    public CierreAnualContableVO buscarPorVigenciaYEstado (Integer cacVigencia, Long ecaCodigo) throws ExcepcionDAO {
        CierreAnualContableVO resultado = null;
        SiiCierreAnualContable siiCierreAnualContable = cierreAnualContableDao.buscarPorVigenciaYEstado(cacVigencia, ecaCodigo);
        if (siiCierreAnualContable!=null)
            resultado = new CierreAnualContableVO(siiCierreAnualContable);
        
        return (resultado);
    }
    
    
    @Override
    public List<CierreAnualContableVO> buscarTodoPorVigenciaYEstado (Integer cacVigencia, Long ecaCodigo) throws ExcepcionDAO {
        List<CierreAnualContableVO> resultado = null;
        List<SiiCierreAnualContable> lista = cierreAnualContableDao.buscarTodoPorVigenciaYEstado(cacVigencia, ecaCodigo);
        if (lista!=null) {
            resultado = new ArrayList<CierreAnualContableVO>();
            
            for (SiiCierreAnualContable siiCierreAnualContable: lista) {
                if (siiCierreAnualContable!=null) {
                    resultado.add(new CierreAnualContableVO(siiCierreAnualContable));
                }
            }
        }
        return (resultado);
    }
}
