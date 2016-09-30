/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-12-2014
 */
package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;


import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoDetRubroVigenFutura;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.VigenciaFuturaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiVigenciaFutura;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.DetRubroVigenFuturaVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.VigenciaFuturaResultVO;
import co.gov.coljuegos.siicol.ejb.vo.VigenciaFuturaVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 * Bean para el manejo de Vigencias Futuras.
 * @author Camilo Miranda
 */
@Stateless
public class AdminVigenciaFuturaBean implements AdminVigenciaFutura 
{
    @EJB
    private VigenciaFuturaDAO vigenciaFuturaDao;
    
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    
    @EJB
    private AdminDetRubroVigenFutura adminDetRubroVigenFutura;
    
    
    ////////////////////////////////////////////////
    // Listas para eliminacion de entidades hijas //
    ////////////////////////////////////////////////
    private List<VigenciaFuturaResultVO> listaVigenciaFuturaResultEliminar;
    
    
    /**
     * Constructor.
     */
    public AdminVigenciaFuturaBean() {
        listaVigenciaFuturaResultEliminar = null;
    }

    
    
    
    /**
     * Almacena la informaci&oacute;n de los hijos de la Obligaci&oacute;n.
     * @throws ExcepcionDAO
     */
    private void persistirHijos(VigenciaFuturaVO vigenciaFuturaVo) throws ExcepcionDAO, ExcepcionAplicacion
    {
        this.persistirDetRubroVigenFutura(vigenciaFuturaVo);
    }
    
    
    /**
     * Almacena los registros de Vigencias Futuras por Detalle Rubro, asociados a la Vigencia Futura.
     * @param vigenciaFuturaVo
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    private void persistirDetRubroVigenFutura(VigenciaFuturaVO vigenciaFuturaVo) throws ExcepcionDAO, ExcepcionAplicacion
    {
        if (vigenciaFuturaVo != null && vigenciaFuturaVo.getDetRubroVigenFuturaList() != null &&
            !vigenciaFuturaVo.getDetRubroVigenFuturaList().isEmpty()) 
        {

            for (DetRubroVigenFuturaVO detRubroVigenFuturaVo : vigenciaFuturaVo.getDetRubroVigenFuturaList()) {
                if (detRubroVigenFuturaVo != null) {
                    detRubroVigenFuturaVo.setVigenciaFuturaVo(vigenciaFuturaVo);

                    if (detRubroVigenFuturaVo.getDrvCodigo() == null) {
                        // OPERACION INSERTAR
                        adminDetRubroVigenFutura.insertarDetRubroVigenFutura(detRubroVigenFuturaVo);
                    } else {
                        // OPERACION ACTUALIZAR
                        adminDetRubroVigenFutura.actualizarDetRubroVigenFutura(detRubroVigenFuturaVo);
                    }
                }
            }
        }
    }
    
    
    
    @Override
    public VigenciaFuturaVO buscarVigenciaFuturaPorId(Long vfuCodigo) throws ExcepcionDAO 
    {
        VigenciaFuturaVO resultado = null;
        SiiVigenciaFutura siiVigenciaFutura = vigenciaFuturaDao.buscarPorCodigo(vfuCodigo);
        if (siiVigenciaFutura!=null)
            resultado = new VigenciaFuturaVO(siiVigenciaFutura);
        
        return (resultado);
    }
    
    
    
    @Override
    public VigenciaFuturaVO insertarVigenciaFutura(VigenciaFuturaVO vigenciaFuturaVo) throws ExcepcionDAO, ExcepcionAplicacion {
        return ( this.insertarVigenciaFutura(vigenciaFuturaVo, false) );
    }
    
    
    @Override
    public VigenciaFuturaVO insertarVigenciaFutura(VigenciaFuturaVO vigenciaFuturaVo, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        VigenciaFuturaVO resultado = null;
        
        // eliminar entidades hijas pendientes por remover
        this.eliminarHijos();
        
        
        SiiVigenciaFutura siiVigenciaFutura = vigenciaFuturaDao.insertar(conversionVoEntidad.convertir(vigenciaFuturaVo));
        
        if (siiVigenciaFutura!=null) {
            resultado = new VigenciaFuturaVO(siiVigenciaFutura);
            resultado.setDetRubroVigenFuturaList(vigenciaFuturaVo.getDetRubroVigenFuturaList());
        }
        
        
        if (cascade) {
            this.persistirHijos(resultado);
        }
        
        return (resultado);
    }
    
    
    
    @Override
    public VigenciaFuturaVO actualizarVigenciaFutura(VigenciaFuturaVO vigenciaFuturaVo) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        return ( this.actualizarVigenciaFutura(vigenciaFuturaVo, false) );
    }
    
    
    @Override
    public VigenciaFuturaVO actualizarVigenciaFutura(VigenciaFuturaVO vigenciaFuturaVo, boolean cascade) throws ExcepcionDAO, ExcepcionAplicacion 
    {
        VigenciaFuturaVO resultado = null;
        
        // eliminar entidades hijas pendientes por remover
        this.eliminarHijos();
        
        
        SiiVigenciaFutura siiVigenciaFutura = vigenciaFuturaDao.actualizar(conversionVoEntidad.convertir(vigenciaFuturaVo));
        
        if (siiVigenciaFutura!=null) {
            resultado = new VigenciaFuturaVO(siiVigenciaFutura);
            resultado.setDetRubroVigenFuturaList(vigenciaFuturaVo.getDetRubroVigenFuturaList());
        }
        
        
        if (cascade) {
            this.persistirHijos(resultado);
        }
        
        return (resultado);
    }
    
    
    @Override
    public void borrarVigenciaFutura(Long vfuCodigo) throws ExcepcionDAO {
        vigenciaFuturaDao.eliminar(vfuCodigo);
    }
    
    
    @Override
    public List<VigenciaFuturaVO> buscarTodaVigenciaFutura() throws ExcepcionDAO 
    {
        List<VigenciaFuturaVO> resultado = null;
        
        List<SiiVigenciaFutura> lista = vigenciaFuturaDao.buscarTodo();
        if (lista!=null) {
            resultado = new ArrayList<VigenciaFuturaVO>();
            for (SiiVigenciaFutura siiVigenciaFutura: lista) {
                if (siiVigenciaFutura!=null)
                    resultado.add(new VigenciaFuturaVO(siiVigenciaFutura));
            }
        }
        
        return (resultado);
    }
    
    
    @Override
    public List<VigenciaFuturaVO> buscarVigenciaFuturaPorEstado(String vfuEstado) throws ExcepcionDAO 
    {
        List<VigenciaFuturaVO> resultado = null;
        
        List<SiiVigenciaFutura> lista = vigenciaFuturaDao.buscarVigenciaFuturaPorEstado(vfuEstado);
        if (lista!=null) {
            resultado = new ArrayList<VigenciaFuturaVO>();
            for (SiiVigenciaFutura siiVigenciaFutura: lista) {
                if (siiVigenciaFutura!=null)
                    resultado.add(new VigenciaFuturaVO(siiVigenciaFutura));
            }
        }
        
        return (resultado);
    }
    
    
    
    @Override
    public void setListaVigenciaFuturaResultEliminar(List<VigenciaFuturaResultVO> listaVigenciaFuturaResultEliminar) {
        this.listaVigenciaFuturaResultEliminar = listaVigenciaFuturaResultEliminar;
    }
    
    
    
    /**
     * Elimina las entidades hijas que se encuentran pendientes por remover.
     * @throws ExcepcionDAO
     */
    private void eliminarHijos() throws ExcepcionDAO 
    {
        ////////////////////////////
        // Vigencia Futura Result //
        ////////////////////////////
        if (listaVigenciaFuturaResultEliminar!=null && !listaVigenciaFuturaResultEliminar.isEmpty()) {
            this.eliminarVigenciasFuturasResult();
        }
    }
    
    
    
    /**
     * Elimina el listado de Vigencias Futuras Result que se encuentra pendiente por remover.
     * @throws ExcepcionDAO
     */
    private void eliminarVigenciasFuturasResult () throws ExcepcionDAO 
    {
        if (listaVigenciaFuturaResultEliminar!=null && !listaVigenciaFuturaResultEliminar.isEmpty()) {
            for (VigenciaFuturaResultVO vfrVo: listaVigenciaFuturaResultEliminar) {
                if (vfrVo!=null) {
                    VigenciaFuturaVO vigenciaFuturaVo = vfrVo.getVigenciaFuturaVo();
                    if (vigenciaFuturaVo!=null && vigenciaFuturaVo.getVfuCodigo()!=null) {
                        DetalleRubroVO detalleRubroVo = vfrVo.getDetalleRubroVo();
                        if (detalleRubroVo!=null && detalleRubroVo.getDruCodigo()!=null) {
                            // buscar las ocurrencias dentro del listado de detalle rubro vigencia futura
                            List<DetRubroVigenFuturaVO> listaDetRubroVigenFutura = adminDetRubroVigenFutura.buscarPorVigenciaFuturaDetalleRubro(vigenciaFuturaVo.getVfuCodigo(), detalleRubroVo.getDruCodigo());
                            if (listaDetRubroVigenFutura!=null && !listaDetRubroVigenFutura.isEmpty()) {
                                // eliminar c/u de los registros
                                for (DetRubroVigenFuturaVO detRubroVigenFuturaVo: listaDetRubroVigenFutura) {
                                    if (detRubroVigenFuturaVo!=null && detRubroVigenFuturaVo.getDrvCodigo()!=null) {
                                        //adminDetRubroVigenFutura.borrarDetRubroVigenFutura(detRubroVigenFuturaVo.getDrvCodigo());
                                        
                                        /////////////////////////////////////
                                        // ACTUALIZAR EL ESTADO A INACTIVO //
                                        /////////////////////////////////////
                                        detRubroVigenFuturaVo.setDrvEstado(EnumEstadoDetRubroVigenFutura.INACTIVO.getId());
                                        adminDetRubroVigenFutura.actualizarDetRubroVigenFutura(detRubroVigenFuturaVo);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
