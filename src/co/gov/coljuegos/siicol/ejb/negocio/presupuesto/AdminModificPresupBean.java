/*
 * SISTEMA	: SIICOL
 * MÓDULO	: PRESUPUESTO
 * AUTOR	: Camilo Miranda
 * FECHA	: 10-02-2014
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModPresDetRubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ModificPresupDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModPresDetRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiModificPresup;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ModPresDetRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.ModificPresupVO;
import co.gov.coljuegos.siicol.ejb.vo.UsuarioVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


@Stateless
public class AdminModificPresupBean implements AdminModificPresup {

    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private ModificPresupDAO modificPresupDao;
    @EJB
    private ModPresDetRubroDAO modPresDetRubroDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;

    /**
     * Constructor.
     */
    public AdminModificPresupBean() {
    }


    /**
     * Realiza la inserci&oacute;n/actualizaci&oacute;n de los Detalles de Rubro asociados a la Modificaci&oacute;n Presupuestal.
     * @param siiModificPresup - Entidad padre.
     * @param modPresDetRubroList - Listado de hijos.
     * @throws ExcepcionDAO
     */
    private void persistirModPresDetRubro(SiiModificPresup siiModificPresup, List<ModPresDetRubroVO> modPresDetRubroList) throws ExcepcionDAO {
        if(modPresDetRubroList != null) {
            for(ModPresDetRubroVO conceptoVO : modPresDetRubroList) {
                SiiModPresDetRubro siiModPresDetRubro = conversionVoEntidad.convertir(conceptoVO);
                if(siiModPresDetRubro != null) {
                    siiModPresDetRubro.setSiiModificPresup(siiModificPresup);

                    if(siiModPresDetRubro.getMpdCodigo() == null) {
                        // OPERACION INSERTAR
                        modPresDetRubroDao.insertarModPresDetRubro(siiModPresDetRubro);
                    }
                    else {
                        // OPERACION ACTUALIZAR
                        modPresDetRubroDao.actualizarModPresDetRubro(siiModPresDetRubro);
                    }
                }

            }
        }
    }


    public ModificPresupVO buscarModificPresupPorId(Long idMprCodigo) throws ExcepcionDAO {
        SiiModificPresup siiModificPresup = modificPresupDao.buscarModificPresupPorId(idMprCodigo);
        return (new ModificPresupVO(siiModificPresup));
    }

    /**
     * @author Modifica Giovanni
     * @param modificPresupVo
     * @param usuarioLogueado
     * @return
     * @throws ExcepcionDAO
     * @throws ExcepcionAplicacion
     */
    public ModificPresupVO actualizarModificPresup(ModificPresupVO modificPresupVo, UsuarioVO usuarioLogueado) throws ExcepcionDAO, ExcepcionAplicacion {
        if(modificPresupVo != null) {
            /*
             * Manejo de error de concurrencia
             */

            /*SiiModificPresup siiModificPresupTemp = modificPresupDao.buscarModificPresupPorId(modificPresupVo.getMprCodigo());

            if (siiModificPresupTemp!=null && siiModificPresupTemp.getSiiEstadoModifPresup()!=null && siiModificPresupTemp.getSiiEstadoModifPresup().getEmpCodigo()!=null &&
                !siiModificPresupTemp.getSiiEstadoModifPresup().getEmpCodigo().equals(modificPresupVo.getIdEstadoAnterior()))
            {
                throw new ExcepcionAplicacion("Error de concurrencia: El estado del modificacion presupuestal fue cambiado durante la modificación. Seleccione nuevamente la modificacion presupuestal");
            }*/


            /*
             * Registro del log de estados esto solo si el estado tuvo un cambio
             */
            if(modificPresupVo.getEstadoModifPresupVo() != null && modificPresupVo.getEstadoModifPresupVo().getEmpCodigo() != null &&
               !modificPresupVo.getEstadoModifPresupVo().getEmpCodigo().equals(modificPresupVo.getIdEstadoAnterior())) {
                adminLogCambioEstado.insertarLogCambioEstado(EnumTipoDocColjuegos.MODIFICACION_PRESUPUESTAL.getId(), modificPresupVo.getEstadoModifPresupVo().getEmpCodigo(), usuarioLogueado,
                                                             modificPresupVo.getMprCodigo());
            }


            SiiModificPresup siiModificPresup = modificPresupDao.actualizarModificPresup(conversionVoEntidad.convertir(modificPresupVo));
            this.persistirModPresDetRubro(siiModificPresup, modificPresupVo.getModPresDetRubroListVo());
            return (new ModificPresupVO(siiModificPresup));
        }
        else {
            throw new ExcepcionAplicacion("No ha sido especificada ninguna modificación presupuestal para la actualización.");
        }
    }


    public ModificPresupVO insertarModificPresup(ModificPresupVO modificPresupVo) throws ExcepcionDAO {
        SiiModificPresup siiModificPresup = modificPresupDao.insertarModificPresup(conversionVoEntidad.convertir(modificPresupVo));
        if(siiModificPresup != null)
            modificPresupVo.setMprCodigo(siiModificPresup.getMprCodigo());

        this.persistirModPresDetRubro(siiModificPresup, modificPresupVo.getModPresDetRubroListVo());
        return (new ModificPresupVO(siiModificPresup));
    }


    public List<ModificPresupVO> buscarTodaModificPresup() throws ExcepcionDAO {
        List<ModificPresupVO> listaVo = new ArrayList<ModificPresupVO>();
        List<SiiModificPresup> lista = modificPresupDao.buscarTodaModificPresup();

        if(lista != null) {
            for(SiiModificPresup siiModificPresup : lista) {
                listaVo.add(new ModificPresupVO(siiModificPresup));
            }
        }

        return (listaVo);
    }


    public List<ModificPresupVO> buscarModificPresupPorEstado(Long empCodigo) throws ExcepcionDAO {
        List<ModificPresupVO> listaVo = new ArrayList<ModificPresupVO>();
        List<SiiModificPresup> lista = modificPresupDao.buscarModificPresupPorEstado(empCodigo);

        if(lista != null) {
            for(SiiModificPresup siiModificPresup : lista) {
                listaVo.add(new ModificPresupVO(siiModificPresup));
            }
        }

        return (listaVo);
    }

    public List<ModificPresupVO> buscarModificPresupPorTipoYEstado(String mprTipo, Long empCodigo) throws ExcepcionDAO {
        List<ModificPresupVO> listaVo = new ArrayList<ModificPresupVO>();
        List<SiiModificPresup> lista = modificPresupDao.buscarModificPresupPorTipoYEstado(mprTipo, empCodigo);

        if(lista != null) {
            for(SiiModificPresup siiModificPresup : lista) {
                listaVo.add(new ModificPresupVO(siiModificPresup));
            }
        }

        return (listaVo);
    }

    public List<ModificPresupVO> buscarTodoTrasladoPresupuestal() throws ExcepcionDAO {
        List<ModificPresupVO> listaVo = new ArrayList<ModificPresupVO>();
        List<SiiModificPresup> lista = modificPresupDao.buscarTodoTrasladoPresupuestal();

        if(lista != null) {
            for(SiiModificPresup siiModificPresup : lista) {
                listaVo.add(new ModificPresupVO(siiModificPresup));
            }
        }

        return (listaVo);
    }

    public List<ModificPresupVO> buscarTrasladoPresupuestalPorEstado(Long empCodigo) throws ExcepcionDAO {
        List<ModificPresupVO> listaVo = new ArrayList<ModificPresupVO>();
        List<SiiModificPresup> lista = modificPresupDao.buscarTrasladoPresupuestalPorEstado(empCodigo);

        if(lista != null) {
            for(SiiModificPresup siiModificPresup : lista) {
                listaVo.add(new ModificPresupVO(siiModificPresup));
            }
        }

        return (listaVo);
    }

    public List<ModificPresupVO> buscarTodaAdicionPresupuestal() throws ExcepcionDAO {
        List<ModificPresupVO> listaVo = new ArrayList<ModificPresupVO>();
        List<SiiModificPresup> lista = modificPresupDao.buscarTodaAdicionPresupuestal();

        if(lista != null) {
            for(SiiModificPresup siiModificPresup : lista) {
                listaVo.add(new ModificPresupVO(siiModificPresup));
            }
        }

        return (listaVo);
    }

    public List<ModificPresupVO> buscarAdicionPresupuestalPorEstado(Long empCodigo) throws ExcepcionDAO {
        List<ModificPresupVO> listaVo = new ArrayList<ModificPresupVO>();
        List<SiiModificPresup> lista = modificPresupDao.buscarAdicionPresupuestalPorEstado(empCodigo);

        if(lista != null) {
            for(SiiModificPresup siiModificPresup : lista) {
                listaVo.add(new ModificPresupVO(siiModificPresup));
            }
        }

        return (listaVo);
    }

    public List<ModificPresupVO> buscarTodaReduccionPresupuestal() throws ExcepcionDAO {
        List<ModificPresupVO> listaVo = new ArrayList<ModificPresupVO>();
        List<SiiModificPresup> lista = modificPresupDao.buscarTodaReduccionPresupuestal();

        if(lista != null) {
            for(SiiModificPresup siiModificPresup : lista) {
                listaVo.add(new ModificPresupVO(siiModificPresup));
            }
        }

        return (listaVo);
    }

    public List<ModificPresupVO> buscarReduccionPresupuestalPorEstado(Long empCodigo) throws ExcepcionDAO {
        List<ModificPresupVO> listaVo = new ArrayList<ModificPresupVO>();
        List<SiiModificPresup> lista = modificPresupDao.buscarReduccionPresupuestalPorEstado(empCodigo);

        if(lista != null) {
            for(SiiModificPresup siiModificPresup : lista) {
                listaVo.add(new ModificPresupVO(siiModificPresup));
            }
        }

        return (listaVo);
    }

    public Long generarConsecutivoModificPresup() throws ExcepcionDAO {
        return (modificPresupDao.generarConsecutivoModificPresup());
    }

    public BigDecimal valorAdicionesPorDruCodigo(Long druCodigo) throws ExcepcionDAO {
        return modificPresupDao.valorAdicionesPorDruCodigo(druCodigo);
    }

    public BigDecimal valorReduccionesPorDruCodigo(Long druCodigo) throws ExcepcionDAO {
        return modificPresupDao.valorReduccionesPorDruCodigo(druCodigo);
    }
    
    public BigDecimal valorCreditoPorDruCodigo(Long druCodigo) throws ExcepcionDAO {
        return modificPresupDao.valorCreditoPorDruCodigo(druCodigo);
    }
    
    public BigDecimal valorContracreditoPorDruCodigo(Long druCodigo) throws ExcepcionDAO {
        return modificPresupDao.valorContracreditoPorDruCodigo(druCodigo);
    }
    
    @Override
    public BigDecimal obtenerSaldoDetalleRubroModificPresup (Long druCodigo) throws ExcepcionDAO {
        return ( modificPresupDao.obtenerSaldoDetalleRubroModificPresup(druCodigo) );
    }
}
