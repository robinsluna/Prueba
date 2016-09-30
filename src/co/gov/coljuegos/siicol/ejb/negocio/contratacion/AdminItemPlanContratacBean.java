package co.gov.coljuegos.siicol.ejb.negocio.contratacion;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFuenteFinanciacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemPlanContDetRubDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ItemPlanContratacDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PlanContratacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContDetRub;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiItemPlanContratac;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPlanContratacion;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContratacVO;
import co.gov.coljuegos.siicol.ejb.vo.ItemPlanContratacionCdpVO;
import co.gov.coljuegos.siicol.ejb.vo.PlanContratacionVO;
import co.gov.coljuegos.siicol.ejb.vo.PrRubroVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import javax.ejb.EJB;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;

@Stateless
public class AdminItemPlanContratacBean implements AdminItemPlanContratac {
    @Resource
    SessionContext sessionContext;

    @EJB
    ItemPlanContratacDAO itemPlanContratacDao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    PlanContratacionDAO planContratacionDao;
    @EJB
    RubroDAO rubroDao;
    @EJB
    DetalleFuenteFinanciacionDAO detalleFuenteFinanciacionDao;
    @EJB
    ItemPlanContDetRubDAO itemPlanContDetRubDao;
    @EJB
    DetalleRubroDAO detalleRubroDao;

    public AdminItemPlanContratacBean() {
    }

    public ItemPlanContratacVO insertarItemPlanContratac(ItemPlanContratacVO itemPlanContratacVO) throws ExcepcionDAO {
        SiiItemPlanContratac ItemPlanContratac = conversionVoEntidad.convertir(itemPlanContratacVO);
        SiiItemPlanContratac localItemPlanContratac = itemPlanContratacDao.insertarItemPlanContratac(ItemPlanContratac);
        return new ItemPlanContratacVO(localItemPlanContratac);
    }

    public ItemPlanContratacVO buscarItemPlanContratacPorId(Long idItemPlanContratac) throws ExcepcionDAO {
        SiiItemPlanContratac localItemPlanContratac =
            itemPlanContratacDao.buscarItemPlanContratacPorId(idItemPlanContratac);
        if (localItemPlanContratac != null) {
            return new ItemPlanContratacVO(localItemPlanContratac);
        } else {
            return new ItemPlanContratacVO();
        }
    }

    public ItemPlanContratacVO actualizarItemPlanContratac(ItemPlanContratacVO itemPlanContratacVO) throws ExcepcionDAO {
        SiiItemPlanContratac itemPlanContratac = conversionVoEntidad.convertir(itemPlanContratacVO);
        itemPlanContratac = itemPlanContratacDao.actualizarItemPlanContractac(itemPlanContratac);
        return new ItemPlanContratacVO(itemPlanContratac);
    }

    public List<ItemPlanContratacVO> buscarTodoItemPlanContratac() throws ExcepcionDAO {
        List<SiiItemPlanContratac> listaItemPlanContratac = itemPlanContratacDao.buscarTodoItemPlanContratac();
        List<ItemPlanContratacVO> listaItemPlanContratacVO = new ArrayList();
        for (SiiItemPlanContratac unItemPlanContratac : listaItemPlanContratac) {
            listaItemPlanContratacVO.add(new ItemPlanContratacVO(unItemPlanContratac));
        }
        return listaItemPlanContratacVO;
    }

    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorSEMArea(Long idArea,
                                                                             Long anoVigencia) throws ExcepcionDAO {
        List<ItemPlanContratacionCdpVO> listaItemPlanContratacionCdpVo =
            itemPlanContratacDao.buscarItemPlanContratacPorSEMArea(idArea, anoVigencia);
        return listaItemPlanContratacionCdpVo;
    }

    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorArea(Long idArea,
                                                                          Long anoVigencia) throws ExcepcionDAO {
        List<ItemPlanContratacionCdpVO> listaItemPlanContratacionCdpVo =
            itemPlanContratacDao.buscarItemPlanContratacPorArea(idArea, anoVigencia);
        return listaItemPlanContratacionCdpVo;
    }

    public void insertarItemsPlanContratacionTotal(List<ItemPlanContratacVO> listaItemsPlanContratac) throws ExcepcionDAO,
                                                                                                             ExcepcionAplicacion {
        PlanContratacionVO planContratacionVo = null;
        SiiPlanContratacion planContratacion = null;
        //Buscar los detalles de fuente
        SiiDtlleFuenteFinanciacion detFuenteNacionActual = detalleFuenteFinanciacionDao.buscarCodDetFuenteFinanciacionPorNombreFuentePorNombre("RECURSOS NACIÓN", "Vigencia Actual");
        if (detFuenteNacionActual == null) {
            throw new ExcepcionAplicacion("No se encontró el detalle de Fuente " + "RECURSOS NACIÓN - Vigencia Actual");
        }
        SiiDtlleFuenteFinanciacion detFuenteNacionFutura = detalleFuenteFinanciacionDao.buscarCodDetFuenteFinanciacionPorNombreFuentePorNombre("RECURSOS NACIÓN", "Vigencia Futura");
        if (detFuenteNacionFutura == null) {
            throw new ExcepcionAplicacion("No se encontró el detalle de Fuente " + "RECURSOS NACIÓN - Vigencia Futura");
        }
        SiiDtlleFuenteFinanciacion detFuentePropiosGastos = detalleFuenteFinanciacionDao.buscarCodDetFuenteFinanciacionPorNombreFuentePorNombre("RECURSOS PROPIOS", "Gastos de Administración");
        if (detFuentePropiosGastos == null) {
            throw new ExcepcionAplicacion("No se encontró el detalle de Fuente " + "RECURSOS PROPIOS - Gastos de Administración");
        }
        SiiDtlleFuenteFinanciacion detFuentePropiosCaducos = detalleFuenteFinanciacionDao.buscarCodDetFuenteFinanciacionPorNombreFuentePorNombre("RECURSOS PROPIOS", "Caducos");
        if (detFuentePropiosCaducos == null) {
            throw new ExcepcionAplicacion("No se encontró el detalle de Fuente " + "RECURSOS PROPIOS - Caducos");
        }
        SiiDtlleFuenteFinanciacion detFuentePropiosTransfSalud = detalleFuenteFinanciacionDao.buscarCodDetFuenteFinanciacionPorNombreFuentePorNombre("RECURSOS PROPIOS", "Transferencias a la Salud");
        if (detFuentePropiosTransfSalud == null) {
            throw new ExcepcionAplicacion("No se encontró el detalle de Fuente " + "RECURSOS PROPIOS - Transferencias a la Salud");
        }
        SiiDtlleFuenteFinanciacion detFuenteVigFuturasPropios = detalleFuenteFinanciacionDao.buscarCodDetFuenteFinanciacionPorNombreFuentePorNombre("RECURSOS PROPIOS", "Vigencia Futura Recursos Propios");
        if (detFuenteVigFuturasPropios == null) {
            throw new ExcepcionAplicacion("No se encontró el detalle de Fuente " + "RECURSOS PROPIOS - Vigencia Futura Recursos Propios");
        }
        
        int i = 0;
        try {
            for (ItemPlanContratacVO unItemPlanContratacionVo : listaItemsPlanContratac) {
                i++;
                System.out.println(i);
                if (planContratacionVo == null) {
                    planContratacionVo = unItemPlanContratacionVo.getPlanContratacionVo();
                }
                //Busca el rubro
                PrRubroVO rubroBusqueda = rubroDao.buscarRubroPorNiveles(planContratacionVo.getPcnVigencia(), unItemPlanContratacionVo.getNiveles());
                if (rubroBusqueda == null) {
                    throw new ExcepcionAplicacion("No se encontró el Rubro para la fila " + i);
                }
                //Busca los detalle rubro
                SiiDetalleRubro detRubroNacionActual = null;
                SiiDetalleRubro detRubroNacionFutura = null;
                SiiDetalleRubro detRubroPropiosGastos = null;
                SiiDetalleRubro detRubroPropiosCaducos = null;
                SiiDetalleRubro detRubroPropiosTransfSalud = null;
                SiiDetalleRubro detRubroPropiosVigFutPropios = null;
                
                if (unItemPlanContratacionVo.getIpcValorNacion() != null) {
                    detRubroNacionActual = detalleRubroDao.buscarDetalleRubroPorDetFuentePorRubro(detFuenteNacionActual.getDffCodigo(), rubroBusqueda.getInterno(), planContratacionVo.getPcnVigencia());
                    if (detRubroNacionActual == null && !unItemPlanContratacionVo.getIpcValorNacion().equals(BigDecimal.ZERO)) {
                        throw new ExcepcionAplicacion("No se encontró el detalle del Rubro fuente Nación - Vigencia Actual para la fila " + i);
                    }
                }
                if (unItemPlanContratacionVo.getIpcValorVigFut() != null) {
                    detRubroNacionFutura = detalleRubroDao.buscarDetalleRubroPorDetFuentePorRubro(detFuenteNacionFutura.getDffCodigo(), rubroBusqueda.getInterno(), planContratacionVo.getPcnVigencia());
                    if (detRubroNacionFutura == null && !unItemPlanContratacionVo.getIpcValorVigFut().equals(BigDecimal.ZERO)) {
                        throw new ExcepcionAplicacion("No se encontró el detalle del Rubro fuente Nación - Vigencia Futura para la fila " + i);
                    }
                }
                if (unItemPlanContratacionVo.getIpcValorPropios() != null) {
                    detRubroPropiosGastos = detalleRubroDao.buscarDetalleRubroPorDetFuentePorRubro(detFuentePropiosGastos.getDffCodigo(), rubroBusqueda.getInterno(), planContratacionVo.getPcnVigencia());
                    if (detRubroPropiosGastos == null && !unItemPlanContratacionVo.getIpcValorPropios().equals(BigDecimal.ZERO)) {
                        throw new ExcepcionAplicacion("No se encontró el detalle del Rubro fuente Propios - Gastos para la fila " + i);
                    }
                }
                if (unItemPlanContratacionVo.getIpcValorCaducos() != null) {
                    detRubroPropiosCaducos = detalleRubroDao.buscarDetalleRubroPorDetFuentePorRubro(detFuentePropiosCaducos.getDffCodigo(), rubroBusqueda.getInterno(), planContratacionVo.getPcnVigencia());
                    if (detRubroPropiosCaducos == null && !unItemPlanContratacionVo.getIpcValorCaducos().equals(BigDecimal.ZERO)) {
                        throw new ExcepcionAplicacion("No se encontró el detalle del Rubro fuente Propios - Caducos para la fila " + i);
                    }
                }
                if (unItemPlanContratacionVo.getIpcValorTransfSalud() != null) {
                    detRubroPropiosTransfSalud = detalleRubroDao.buscarDetalleRubroPorDetFuentePorRubro(detFuentePropiosTransfSalud.getDffCodigo(), rubroBusqueda.getInterno(), planContratacionVo.getPcnVigencia());
                    if (detRubroPropiosTransfSalud == null && !unItemPlanContratacionVo.getIpcValorTransfSalud().equals(BigDecimal.ZERO)) {
                        throw new ExcepcionAplicacion("No se encontró el detalle del Rubro fuente Propios - Transferencias a la salud para la fila " + i);
                    }
                }
                if (unItemPlanContratacionVo.getIpcValorVigFutRecursosPropios() != null) {
                    detRubroPropiosVigFutPropios = detalleRubroDao.buscarDetalleRubroPorDetFuentePorRubro(detFuenteVigFuturasPropios.getDffCodigo(), rubroBusqueda.getInterno(), planContratacionVo.getPcnVigencia());
                    if (detRubroPropiosVigFutPropios == null && !unItemPlanContratacionVo.getIpcValorVigFutRecursosPropios().equals(BigDecimal.ZERO)) {
                        throw new ExcepcionAplicacion("No se encontró el detalle del Rubro fuente Propios - Vigencias fututras recursos propios para la fila " + i);
                    }
                }
                
                unItemPlanContratacionVo.setIpcFechaIniProc(unItemPlanContratacionVo.getIpcFechaFinCon());
                

                //La primera vez agrega el plan de contratación
                if (planContratacion == null) {
                    //Busca el plan. Si lo encuentra no crea plan nuevo
                    planContratacion = planContratacionDao.buscarPlanContratacionPorVigencia(planContratacionVo.getPcnVigencia());
                    if (planContratacion == null) {
                        planContratacion = planContratacionDao.insertarPlanContratacion(conversionVoEntidad.convertir(planContratacionVo));
                        System.out.println("Agregado plan " + planContratacion.getPcnCodigo());
                    }
                }
                SiiItemPlanContratac itemPlanContratac = itemPlanContratacDao.buscarItemPlanContratacPorNombrePorIdPlan(unItemPlanContratacionVo.getIpcNombre(), planContratacion.getPcnCodigo());
                if(itemPlanContratac == null){ //Si no existe el plan, se agrega
                    itemPlanContratac = conversionVoEntidad.convertir(unItemPlanContratacionVo);
                    itemPlanContratac.setSiiPlanContratacion(planContratacion);
                    //Null en los valores en cada item
                    itemPlanContratac.setIpcValorNacion(null);
                    itemPlanContratac.setIpcValorVigFut(null);
                    itemPlanContratac.setIpcValorPropios(null);
                    
                    itemPlanContratac = itemPlanContratacDao.insertarItemPlanContratac(itemPlanContratac);
                    System.out.println("Agregado item del plan " + itemPlanContratac.getIpcCodigo());
                }
                
                //Agregamos los itemPlanContratacionDetRubro
                if (unItemPlanContratacionVo.getIpcValorNacion() != null && detRubroNacionActual != null) {
                    SiiItemPlanContDetRub siiItemPlanContDetRub = new SiiItemPlanContDetRub();
                    siiItemPlanContDetRub.setSiiItemPlanContratac(itemPlanContratac);
                    siiItemPlanContDetRub.setSiiDetalleRubro(detRubroNacionActual);
                    siiItemPlanContDetRub.setIdrValor(unItemPlanContratacionVo.getIpcValorNacion().longValue());
                    siiItemPlanContDetRub = itemPlanContDetRubDao.insertarItemPlanContDetRub(siiItemPlanContDetRub);
                    System.out.println("Agregado item plan detalle rubro " + itemPlanContratac.getIpcCodigo());
                }
                if (unItemPlanContratacionVo.getIpcValorVigFut() != null && detRubroNacionFutura != null) {
                    SiiItemPlanContDetRub siiItemPlanContDetRub = new SiiItemPlanContDetRub();
                    siiItemPlanContDetRub.setSiiItemPlanContratac(itemPlanContratac);
                    siiItemPlanContDetRub.setSiiDetalleRubro(detRubroNacionFutura);
                    siiItemPlanContDetRub.setIdrValor(unItemPlanContratacionVo.getIpcValorVigFut().longValue());
                    siiItemPlanContDetRub = itemPlanContDetRubDao.insertarItemPlanContDetRub(siiItemPlanContDetRub);
                    System.out.println("Agregado item plan detalle rubro " + itemPlanContratac.getIpcCodigo());
                }
                if (unItemPlanContratacionVo.getIpcValorPropios() != null && detRubroPropiosGastos != null) {
                    SiiItemPlanContDetRub siiItemPlanContDetRub = new SiiItemPlanContDetRub();
                    siiItemPlanContDetRub.setSiiItemPlanContratac(itemPlanContratac);
                    siiItemPlanContDetRub.setSiiDetalleRubro(detRubroPropiosGastos);
                    siiItemPlanContDetRub.setIdrValor(unItemPlanContratacionVo.getIpcValorPropios().longValue());
                    siiItemPlanContDetRub = itemPlanContDetRubDao.insertarItemPlanContDetRub(siiItemPlanContDetRub);
                    System.out.println("Agregado item plan detalle rubro " + itemPlanContratac.getIpcCodigo());
                }
                if (unItemPlanContratacionVo.getIpcValorCaducos() != null && detRubroPropiosCaducos != null) {
                    SiiItemPlanContDetRub siiItemPlanContDetRub = new SiiItemPlanContDetRub();
                    siiItemPlanContDetRub.setSiiItemPlanContratac(itemPlanContratac);
                    siiItemPlanContDetRub.setSiiDetalleRubro(detRubroPropiosCaducos);
                    siiItemPlanContDetRub.setIdrValor(unItemPlanContratacionVo.getIpcValorCaducos().longValue());
                    siiItemPlanContDetRub = itemPlanContDetRubDao.insertarItemPlanContDetRub(siiItemPlanContDetRub);
                    System.out.println("Agregado item plan detalle rubro " + itemPlanContratac.getIpcCodigo());
                }
                if (unItemPlanContratacionVo.getIpcValorTransfSalud() != null && detRubroPropiosTransfSalud != null) {
                    SiiItemPlanContDetRub siiItemPlanContDetRub = new SiiItemPlanContDetRub();
                    siiItemPlanContDetRub.setSiiItemPlanContratac(itemPlanContratac);
                    siiItemPlanContDetRub.setSiiDetalleRubro(detRubroPropiosTransfSalud);
                    siiItemPlanContDetRub.setIdrValor(unItemPlanContratacionVo.getIpcValorTransfSalud().longValue());
                    siiItemPlanContDetRub = itemPlanContDetRubDao.insertarItemPlanContDetRub(siiItemPlanContDetRub);
                    System.out.println("Agregado item plan detalle rubro " + itemPlanContratac.getIpcCodigo());
                }
                if (unItemPlanContratacionVo.getIpcValorVigFutRecursosPropios() != null && detRubroPropiosVigFutPropios != null) {
                    SiiItemPlanContDetRub siiItemPlanContDetRub = new SiiItemPlanContDetRub();
                    siiItemPlanContDetRub.setSiiItemPlanContratac(itemPlanContratac);
                    siiItemPlanContDetRub.setSiiDetalleRubro(detRubroPropiosVigFutPropios);
                    siiItemPlanContDetRub.setIdrValor(unItemPlanContratacionVo.getIpcValorVigFutRecursosPropios().longValue());
                    siiItemPlanContDetRub = itemPlanContDetRubDao.insertarItemPlanContDetRub(siiItemPlanContDetRub);
                    System.out.println("Agregado item plan detalle rubro " + itemPlanContratac.getIpcCodigo());
                }
            }
        } catch (ExcepcionDAO ex) {
            throw new ExcepcionAplicacion("Error de base de datos, línea " + i + " Mensaje: " + ex.getMessage());
        } catch (ExcepcionAplicacion ex) {
            throw ex;
        } catch (Exception ex) {
            throw new ExcepcionAplicacion(ex.getMessage());
        }
    }

    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorVigencia(Long anoVigencia) throws ExcepcionDAO {
        List<ItemPlanContratacionCdpVO> listaItemPlanContratacionCdpVo =
            itemPlanContratacDao.buscarItemPlanContratacPorVigencia(anoVigencia);
        return listaItemPlanContratacionCdpVo;
    }

    public List<ItemPlanContratacionCdpVO> buscarItemPlanContratacPorSEM(Long anoVigencia) throws ExcepcionDAO {
        List<ItemPlanContratacionCdpVO> listaItemPlanContratacionCdpVo =
            itemPlanContratacDao.buscarItemPlanContratacPorSEM(anoVigencia);
        return listaItemPlanContratacionCdpVo;
    }
    
    public List<ItemPlanContratacVO> buscarItemPlanContratacVigencia(Long anoVigencia) throws ExcepcionDAO {
        List<SiiItemPlanContratac> listaItemPlanContratacionVo =
            itemPlanContratacDao.buscarItemPlanContratacVigencia (anoVigencia);
        List<ItemPlanContratacVO> listaItemPlanContratacVo = new ArrayList();
        for (SiiItemPlanContratac unItemPlanContratac : listaItemPlanContratacionVo) {
            listaItemPlanContratacVo.add(new ItemPlanContratacVO(unItemPlanContratac));
        }
        return listaItemPlanContratacVo;
    }

    public List<ItemPlanContratacVO> itemsPlanContratacionPorModificacion(Long mpcCodigo) throws ExcepcionDAO {
        List<ItemPlanContratacVO> itemsPlanVo = new ArrayList<ItemPlanContratacVO>();
        for (SiiItemPlanContratac itemPlan : itemPlanContratacDao.itemsPlanContratacionPorModificacion(mpcCodigo)) {
            itemsPlanVo.add(new ItemPlanContratacVO(itemPlan));
        }
        return itemsPlanVo;
    }
}

