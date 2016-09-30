package co.gov.coljuegos.siicol.ejb.negocio.gct;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DescargoProcIlegDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDescargoProcIleg;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DescargoProcIlegVO;

import co.gov.coljuegos.siicol.ejb.vo.PruebaDescargoProIleVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Descargos del Proceso Sancionatorio de Ilegalidad.
 * @author Camilo Miranda
 */
@Stateless
public class AdminDescargoProcIlegBean implements AdminDescargoProcIleg 
{
    @EJB
    private DescargoProcIlegDAO descargoProcIlegDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private AdminPruebaDescargoProIle adminPruebaDescargoProIle;
    
    
    
    /**
     * Constructor.
     */
    public AdminDescargoProcIlegBean() {
        super();
    }
    
    
    
    /**
     * Establece las listas hijas al value object resultante del almacenamiento de la entidad.
     * @param resultado - Value Object resultante.
     * @param descargoProcIlegVo -  Value Object base.
     */
    private void asignarHijos (DescargoProcIlegVO resultado, DescargoProcIlegVO descargoProcIlegVo) 
    {
        resultado.setPruebaDescargoProIleList(descargoProcIlegVo.getPruebaDescargoProIleList());
    }
    
    
    /**
     * Persiste las entidades hijas del Descargo del Proceso Sancionatorio de Ilegalidad.
     * @param descargoProcIlegVo - Descargo del Proceso Sancionatorio de Ilegalidad.
     * @throws ExcepcionDAO
     */
    private void persistirHijos (DescargoProcIlegVO descargoProcIlegVo) throws ExcepcionDAO
    {
        this.persistirPruebaDescargoProIle(descargoProcIlegVo);
    }
    
    
    /**
     * Almacena la informaci&oacute;n de las Pruebas de los Descargos del Proceso Sancionatorio de Ilegalidad.
     * @param descargoProcIlegVo - Descargo del Proceso Sancionatorio de Ilegalidad.
     * @throws ExcepcionDAO
     */
    private void persistirPruebaDescargoProIle (DescargoProcIlegVO descargoProcIlegVo) throws ExcepcionDAO
    {
        if(descargoProcIlegVo != null) {
            List<PruebaDescargoProIleVO> listaPruebaDescargoProIle = descargoProcIlegVo.getPruebaDescargoProIleList();
            if(listaPruebaDescargoProIle != null && !listaPruebaDescargoProIle.isEmpty()) {
                for(PruebaDescargoProIleVO pdpVo : listaPruebaDescargoProIle) {
                    if(pdpVo != null) {
                        pdpVo.setDescargoProcIlegVo(descargoProcIlegVo);

                        if(pdpVo.getPdpCodigo() == null) {
                            // OPERACION INSERTAR
                            adminPruebaDescargoProIle.insertarPruebaDescargoProIle(pdpVo);
                        }
                        else {
                            // OPERACION ACTUALIZAR
                            adminPruebaDescargoProIle.actualizarPruebaDescargoProIle(pdpVo);
                        }
                    }
                }
            }
        }
    }
    
    
    
    @Override
    public DescargoProcIlegVO buscarDescargoProcIlegPorId(Long dprCodigo) throws ExcepcionDAO 
    {
        DescargoProcIlegVO resultado = null;
        SiiDescargoProcIleg siiDescargoProcIleg = descargoProcIlegDao.buscarPorCodigo(dprCodigo);
        if (siiDescargoProcIleg!=null)
            resultado = new DescargoProcIlegVO(siiDescargoProcIleg);
        
        return (resultado);
    }
    
    
    @Override
    public DescargoProcIlegVO insertarDescargoProcIleg(DescargoProcIlegVO descargoProcIlegVo) throws ExcepcionDAO 
    {
        return ( this.insertarDescargoProcIleg(descargoProcIlegVo, false) );
    }
    
    
    @Override
    public DescargoProcIlegVO insertarDescargoProcIleg(DescargoProcIlegVO descargoProcIlegVo, boolean cascadeUpdate) throws ExcepcionDAO 
    {
        DescargoProcIlegVO resultado = null;
        SiiDescargoProcIleg siiDescargoProcIleg = descargoProcIlegDao.insertar(conversionVoEntidad.convertir(descargoProcIlegVo));
        if (siiDescargoProcIleg!=null) {
            resultado = new DescargoProcIlegVO(siiDescargoProcIleg);
            
            if (cascadeUpdate) {
                this.asignarHijos(resultado, descargoProcIlegVo);
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public DescargoProcIlegVO actualizarDescargoProcIleg(DescargoProcIlegVO descargoProcIlegVo) throws ExcepcionDAO 
    {
        return ( this.actualizarDescargoProcIleg(descargoProcIlegVo, false) );
    }
    
    
    @Override
    public DescargoProcIlegVO actualizarDescargoProcIleg(DescargoProcIlegVO descargoProcIlegVo, boolean cascadeUpdate) throws ExcepcionDAO 
    {
        DescargoProcIlegVO resultado = null;
        SiiDescargoProcIleg siiDescargoProcIleg = descargoProcIlegDao.actualizar(conversionVoEntidad.convertir(descargoProcIlegVo));
        if (siiDescargoProcIleg!=null) {
            resultado = new DescargoProcIlegVO(siiDescargoProcIleg);
            
            if (cascadeUpdate) {
                this.asignarHijos(resultado, descargoProcIlegVo);
                this.persistirHijos(resultado);
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public void eliminarDescargoProcIleg(Long dprCodigo) throws ExcepcionDAO 
    {
        descargoProcIlegDao.eliminar(dprCodigo);
    }
    
    
    @Override
    public List<DescargoProcIlegVO> buscarTodoDescargoProcIleg() throws ExcepcionDAO 
    {
        List<DescargoProcIlegVO> resultado = null;
        List<SiiDescargoProcIleg> lista = descargoProcIlegDao.buscarTodo();
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<DescargoProcIlegVO>();
            
            for (SiiDescargoProcIleg siiDescargoProcIleg: lista) {
                if (siiDescargoProcIleg!=null) 
                    resultado.add(new DescargoProcIlegVO(siiDescargoProcIleg));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<DescargoProcIlegVO> buscarDescargoProcIlegPorIdProcesoSancIlegalidad(Long prsCodigo) throws ExcepcionDAO 
    {
        List<DescargoProcIlegVO> resultado = null;
        List<SiiDescargoProcIleg> lista = descargoProcIlegDao.buscarDescargoProcIlegPorIdProcesoSancIlegalidad(prsCodigo);
        if (lista!=null && !lista.isEmpty()) {
            resultado = new ArrayList<DescargoProcIlegVO>();
            
            for (SiiDescargoProcIleg siiDescargoProcIleg: lista) {
                if (siiDescargoProcIleg!=null) 
                    resultado.add(new DescargoProcIlegVO(siiDescargoProcIleg));
            }
        }
        
        return (resultado);
    }
}
