/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Presupuesto
 * AUTOR	: Diego Alvarado
 * FECHA	: 12-09-2013
 */

package co.gov.coljuegos.siicol.ejb.negocio.presupuesto;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoDocColjuegos;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.negocio.log.AdminLogCambioEstado;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ApropiacionInicialDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleFuenteFinanciacionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.DetalleRubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FuenteFinancContabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.Nivel1DAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.Nivel2DAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.Nivel3DAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.Nivel4DAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.Nivel5DAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.Nivel6DAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.Nivel7DAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.Nivel8DAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RubroDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel1;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel2;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel3;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel4;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel5;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel6;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel7;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrNivel8;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.PrRubroPK;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiApropiacionInicial;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleRubro;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDtlleFuenteFinanciacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFuenteFinancContab;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.ApropiacionInicialVO;
import co.gov.coljuegos.siicol.ejb.vo.DetalleRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.NivelRubroDetFuenteValorVO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel1VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel2VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel3VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel4VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel5VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel6VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel7VO;
import co.gov.coljuegos.siicol.ejb.vo.PrNivel8VO;
import co.gov.coljuegos.siicol.ejb.vo.PrRubroVO;
import co.gov.coljuegos.siicol.ejb.vo.ReporteEjecucionPreGastosVO;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminRubroBean implements AdminRubro {

    @EJB
    ApropiacionInicialDAO apropiacionInicialDao;
    @EJB
    RubroDAO rubroDao;
    @EJB
    DetalleRubroDAO detalleRubroDao;
    @EJB
    DetalleFuenteFinanciacionDAO detalleFuenteFinanciacionDao;
    @EJB
    Nivel1DAO nivel1Dao;
    @EJB
    Nivel2DAO nivel2Dao;
    @EJB
    Nivel3DAO nivel3Dao;
    @EJB
    Nivel4DAO nivel4Dao;
    @EJB
    Nivel5DAO nivel5Dao;
    @EJB
    Nivel6DAO nivel6Dao;
    @EJB
    Nivel7DAO nivel7Dao;
    @EJB
    Nivel8DAO nivel8Dao;
    @EJB
    ConversionVOEntidad conversionVoEntidad;
    @EJB
    FuenteFinancContabDAO fuenteFinancContabDao;
    @EJB
    private AdminLogCambioEstado adminLogCambioEstado;


    private ArrayList<PrNivel1VO> listaNivel1Sinduplicados;

    public AdminRubroBean() {
    }

    public void insertarApropiacionTotal(ApropiacionInicialVO insertApropiacionInicialVo, List<PrRubroVO> listaRubrosVo) throws ExcepcionDAO, ExcepcionAplicacion {
        SiiApropiacionInicial siiApropiacionInicial = conversionVoEntidad.convertir(insertApropiacionInicialVo);
        SiiApropiacionInicial apRetorno = apropiacionInicialDao.insertarApropiacionInicial(siiApropiacionInicial);
        int i = 0;
        for(PrRubroVO unRubroVo : listaRubrosVo) {
            System.out.println("Analizando linea " + i++);
            PrNivel1 nivel1 = null;
            PrNivel2 nivel2 = null;
            PrNivel3 nivel3 = null;
            PrNivel4 nivel4 = null;
            PrNivel5 nivel5 = null;
            PrNivel6 nivel6 = null;
            PrNivel7 nivel7 = null;
            PrNivel8 nivel8 = null;
            //buscamos nivel 1. Si no existe lo creamos
            nivel1 = nivel1Dao.buscarNivel1PorCodigoPorVigencia(unRubroVo.getInternoNivel1().toString(), insertApropiacionInicialVo.getAinVigencia());
            if(nivel1 == null) {
                PrNivel1 nuevoNivel1 = new PrNivel1();
                nuevoNivel1.setCodigo(unRubroVo.getInternoNivel1().toString());
                nuevoNivel1.setDescripcion(nuevoNivel1.getCodigo() + " - " + insertApropiacionInicialVo.getAinVigencia());
                nuevoNivel1.setVigencia(insertApropiacionInicialVo.getAinVigencia());
                nivel1 = nivel1Dao.insertarNivel1(nuevoNivel1);
            }
            if(unRubroVo.getInternoNivel2() != null) {
                nivel2 = nivel2Dao.buscarNivel2PorCodigoPorVigencia(unRubroVo.getInternoNivel2().toString(), insertApropiacionInicialVo.getAinVigencia());
                if(nivel2 == null) {
                    PrNivel2 nuevoNivel2 = new PrNivel2();
                    nuevoNivel2.setInternoNivel1(nivel1.getInterno());
                    nuevoNivel2.setCodigo(unRubroVo.getInternoNivel2().toString());
                    nuevoNivel2.setDescripcion(nuevoNivel2.getCodigo() + " - " + insertApropiacionInicialVo.getAinVigencia());
                    nuevoNivel2.setTipoPlan(unRubroVo.getTipoPlan());
                    nuevoNivel2.setVigencia(insertApropiacionInicialVo.getAinVigencia());
                    nivel2 = nivel2Dao.insertarNivel2(nuevoNivel2);
                }
            }
            if(unRubroVo.getInternoNivel3() != null) {
                nivel3 = nivel3Dao.buscarNivel3PorCodigoPorVigencia(unRubroVo.getInternoNivel3().toString(), insertApropiacionInicialVo.getAinVigencia());
                if(nivel3 == null) {
                    PrNivel3 nuevoNivel3 = new PrNivel3();
                    nuevoNivel3.setInternoNivel2(nivel2.getInterno());
                    nuevoNivel3.setCodigo(unRubroVo.getInternoNivel3().toString());
                    nuevoNivel3.setDescripcion(nuevoNivel3.getCodigo() + " - " + insertApropiacionInicialVo.getAinVigencia());
                    nuevoNivel3.setTipoPlan(unRubroVo.getTipoPlan());
                    nuevoNivel3.setVigencia(insertApropiacionInicialVo.getAinVigencia());
                    nivel3 = nivel3Dao.insertarNivel3(nuevoNivel3);
                }
            }
            if(unRubroVo.getInternoNivel4() != null) {
                nivel4 = nivel4Dao.buscarNivel4PorCodigoPorVigencia(unRubroVo.getInternoNivel4().toString(), insertApropiacionInicialVo.getAinVigencia());
                if(nivel4 == null) {
                    PrNivel4 nuevoNivel4 = new PrNivel4();
                    nuevoNivel4.setInternoNivel3(nivel3.getInterno());
                    nuevoNivel4.setCodigo(unRubroVo.getInternoNivel4().toString());
                    nuevoNivel4.setDescripcion(nuevoNivel4.getCodigo() + " - " + insertApropiacionInicialVo.getAinVigencia());
                    nuevoNivel4.setTipoPlan(unRubroVo.getTipoPlan());
                    nuevoNivel4.setVigencia(insertApropiacionInicialVo.getAinVigencia());
                    nivel4 = nivel4Dao.insertarNivel4(nuevoNivel4);
                }
            }
            if(unRubroVo.getInternoNivel5() != null) {
                nivel5 = nivel5Dao.buscarNivel5PorCodigoPorVigencia(unRubroVo.getInternoNivel5().toString(), insertApropiacionInicialVo.getAinVigencia());
                if(nivel5 == null) {
                    PrNivel5 nuevoNivel5 = new PrNivel5();
                    nuevoNivel5.setInternoNivel4(nivel4.getInterno());
                    nuevoNivel5.setCodigo(unRubroVo.getInternoNivel5().toString());
                    nuevoNivel5.setDescripcion(nuevoNivel5.getCodigo() + " - " + insertApropiacionInicialVo.getAinVigencia());
                    nuevoNivel5.setTipoPlan(unRubroVo.getTipoPlan());
                    nuevoNivel5.setVigencia(insertApropiacionInicialVo.getAinVigencia());
                    nivel5 = nivel5Dao.insertarNivel5(nuevoNivel5);
                }
            }
            if(unRubroVo.getInternoNivel6() != null) {
                nivel6 = nivel6Dao.buscarNivel6PorCodigoPorVigencia(unRubroVo.getInternoNivel6().toString(), insertApropiacionInicialVo.getAinVigencia());
                if(nivel6 == null) {
                    PrNivel6 nuevoNivel6 = new PrNivel6();
                    nuevoNivel6.setInternoNivel5(nivel5.getInterno());
                    nuevoNivel6.setCodigo(unRubroVo.getInternoNivel6().toString());
                    nuevoNivel6.setDescripcion(nuevoNivel6.getCodigo() + " - " + insertApropiacionInicialVo.getAinVigencia());
                    nuevoNivel6.setTipoPlan(unRubroVo.getTipoPlan());
                    nuevoNivel6.setVigencia(insertApropiacionInicialVo.getAinVigencia());
                    nivel6 = nivel6Dao.insertarNivel6(nuevoNivel6);
                }
            }
            if(unRubroVo.getInternoNivel7() != null) {
                nivel7 = nivel7Dao.buscarNivel7PorCodigoPorVigencia(unRubroVo.getInternoNivel7().toString(), insertApropiacionInicialVo.getAinVigencia());
                if(nivel7 == null) {
                    PrNivel7 nuevoNivel7 = new PrNivel7();
                    nuevoNivel7.setInternoNivel6(nivel6.getInterno());
                    nuevoNivel7.setCodigo(unRubroVo.getInternoNivel7().toString());
                    nuevoNivel7.setDescripcion(nuevoNivel7.getCodigo() + " - " + insertApropiacionInicialVo.getAinVigencia());
                    nuevoNivel7.setTipoPlan(unRubroVo.getTipoPlan());
                    nuevoNivel7.setVigencia(insertApropiacionInicialVo.getAinVigencia());
                    nivel7 = nivel7Dao.insertarNivel7(nuevoNivel7);
                }
            }
            if(unRubroVo.getInternoNivel8() != null) {
                nivel8 = nivel8Dao.buscarNivel8PorCodigoPorVigencia(unRubroVo.getInternoNivel8().toString(), insertApropiacionInicialVo.getAinVigencia());
                if(nivel8 == null) {
                    PrNivel8 nuevoNivel8 = new PrNivel8();
                    nuevoNivel8.setInternoNivel7(nivel7.getInterno());
                    nuevoNivel8.setCodigo(unRubroVo.getInternoNivel7().toString());
                    nuevoNivel8.setDescripcion(nuevoNivel8.getCodigo() + " - " + insertApropiacionInicialVo.getAinVigencia());
                    nuevoNivel8.setTipoPlan(unRubroVo.getTipoPlan());
                    nuevoNivel8.setVigencia(insertApropiacionInicialVo.getAinVigencia());
                    nivel8 = nivel8Dao.insertarNivel8(nuevoNivel8);
                }
            }

            unRubroVo.setInternoNivel1(nivel1.getInterno());
            PrRubro unRubro = conversionVoEntidad.convertir(unRubroVo);
            //Armamos la cadena de búsqueda
            String cadenaNiveles = nivel1 == null ? "" : nivel1.getCodigo() + ".";
            cadenaNiveles += nivel2 == null ? "." : nivel2.getCodigo().toString() + ".";
            cadenaNiveles += nivel3 == null ? "." : nivel3.getCodigo().toString() + ".";
            cadenaNiveles += nivel4 == null ? "." : nivel4.getCodigo().toString() + ".";
            cadenaNiveles += nivel5 == null ? "." : nivel5.getCodigo().toString() + ".";
            cadenaNiveles += nivel6 == null ? "." : nivel6.getCodigo().toString() + ".";
            cadenaNiveles += nivel7 == null ? "." : nivel7.getCodigo().toString() + ".";
            cadenaNiveles += nivel8 == null ? "." : nivel8.getCodigo().toString() + ".";
            PrRubroVO rubroBusqueda = rubroDao.buscarRubroPorNiveles(insertApropiacionInicialVo.getAinVigencia(), cadenaNiveles);
            if(rubroBusqueda == null) {
                unRubro.setAinCodigo(apRetorno.getAinCodigo());
                unRubro.setInternoNivel1(nivel1.getInterno());
                if(nivel2 != null) {
                    unRubro.setInternoNivel2(nivel2.getInterno());
                }
                if(nivel3 != null) {
                    unRubro.setInternoNivel3(nivel3.getInterno());
                }
                if(nivel4 != null) {
                    unRubro.setInternoNivel4(nivel4.getInterno());
                }
                if(nivel5 != null) {
                    unRubro.setInternoNivel5(nivel5.getInterno());
                }
                if(nivel6 != null) {
                    unRubro.setInternoNivel6(nivel6.getInterno());
                }
                if(nivel7 != null) {
                    unRubro.setInternoNivel7(nivel7.getInterno());
                }
                if(nivel8 != null) {
                    unRubro.setInternoNivel8(nivel8.getInterno());
                }
                unRubro = rubroDao.insertarPrRubro(unRubro);
            }
            else {
                unRubro.setInterno(rubroBusqueda.getInterno());
                unRubro = rubroDao.buscarPorInternoRubroVig(new PrRubroPK(rubroBusqueda.getInterno(), insertApropiacionInicialVo.getAinVigencia()));
            }
            if(!unRubroVo.getTipoPlan().equals("")) {
                unRubro.setTipoPlan(unRubroVo.getTipoPlan());
                rubroDao.actualizarPrRubro(unRubro);
            }
            if(!unRubroVo.getFuenteContable().equals("")) {
                unRubro.setFuenteContable(unRubroVo.getFuenteContable());
                rubroDao.actualizarPrRubro(unRubro);
            }
            //Si hay detalle fuente, consultar detalle fuente y agregar detalleRubro
            if(!unRubroVo.getDetFuenteFinanciacion().equals("")) {
                //Buscamos el detalle de fuente por código de fuente y código de recurso de detalle fuente
                SiiDtlleFuenteFinanciacion siiDtlleFuenteFinanciacion =
                    detalleFuenteFinanciacionDao.buscarDetFuenteFinanciacionPorCodigoFuentePorCodigoRecurso(Integer.parseInt(unRubroVo.getFuenteFinanciacion()),
                                                                                                            Integer.parseInt(unRubroVo.getDetFuenteFinanciacion()));
                if(siiDtlleFuenteFinanciacion == null) {
                    throw new ExcepcionAplicacion("No se encuentra la fuente código " + unRubroVo.getDetFuenteFinanciacion() + " con el detalle de fuente código " +
                                                  unRubroVo.getDetFuenteFinanciacion());
                }

                SiiDetalleRubro siiDetalleRubro = new SiiDetalleRubro();
                siiDetalleRubro.setDruValor(unRubroVo.getValor());
                siiDetalleRubro.setInterno(unRubro.getInterno());
                siiDetalleRubro.setVigencia(unRubroVo.getVigencia());
                siiDetalleRubro.setSiiDtlleFuenteFinanciacion(siiDtlleFuenteFinanciacion);

                //Reglas de asignación de fuente de financiación contable
                Long detFteFinCod = siiDtlleFuenteFinanciacion.getDffCodigo();
                if(detFteFinCod != null) {
                    if(detFteFinCod == 1 || detFteFinCod == 2 || detFteFinCod == 3) {
                        if(cadenaNiveles.equals("2.1.1.") || cadenaNiveles.equals("1.1.1.2.1.1.")) {
                            SiiFuenteFinancContab siiFuenteFinancContab = fuenteFinancContabDao.buscarPorCodigo("RNP");
                            siiDetalleRubro.setSiiFuenteFinancContab(siiFuenteFinancContab);
                        }
                        else if(cadenaNiveles.equals("2.1.2.") || cadenaNiveles.equals("1.1.1.2.1.2.")) {
                            SiiFuenteFinancContab siiFuenteFinancContab = fuenteFinancContabDao.buscarPorCodigo("RNG");
                            siiDetalleRubro.setSiiFuenteFinancContab(siiFuenteFinancContab);
                        }
                        else if(cadenaNiveles.equals("2.1.3.") || cadenaNiveles.equals("1.1.1.2.1.3.")) {
                            SiiFuenteFinancContab siiFuenteFinancContab = fuenteFinancContabDao.buscarPorCodigo("RNT");
                            siiDetalleRubro.setSiiFuenteFinancContab(siiFuenteFinancContab);
                        }
                    }
                    else if(detFteFinCod == 4 || detFteFinCod == 5 || detFteFinCod == 6 || detFteFinCod == 7 || detFteFinCod == 8) {
                        SiiFuenteFinancContab siiFuenteFinancContab = fuenteFinancContabDao.buscarPorCodigo("RPE");
                        siiDetalleRubro.setSiiFuenteFinancContab(siiFuenteFinancContab);
                    }
                }

                siiDetalleRubro = detalleRubroDao.insertarSiiDetalleRubro(siiDetalleRubro);
            }
        }
    }

    public List<ApropiacionInicialVO> buscarTodaApropiacionInicial() throws ExcepcionDAO {
        List<SiiApropiacionInicial> listaApropiacionIni = apropiacionInicialDao.buscarTodaApropiacionInicial();

        List<ApropiacionInicialVO> listaApropiacionIniVo = new ArrayList();

        for(SiiApropiacionInicial unaApropiacionIni : listaApropiacionIni) {
            ApropiacionInicialVO nuevaApropiacionIniVo = new ApropiacionInicialVO(unaApropiacionIni);
            listaApropiacionIniVo.add(nuevaApropiacionIniVo);
        }
        return listaApropiacionIniVo;
    }

    public List<NivelRubroDetFuenteValorVO> buscarTodaApropiacionIniPorVigencia(Integer vigencia) throws ExcepcionDAO {
        return apropiacionInicialDao.buscarTodaApropiacionIniPorVigencia(vigencia);
    }

    public List<NivelRubroDetFuenteValorVO> buscarTodaApropiacionIniPorVigenciaFuenteFin(Integer vigencia, String fuenteFin) throws ExcepcionDAO {
        return apropiacionInicialDao.buscarTodaApropiacionIniPorVigenciaFuenteFin(vigencia, fuenteFin);
    }

    public ApropiacionInicialVO buscarApropiacionInicialPorId(ApropiacionInicialVO apropiacionInicialVo) throws ExcepcionDAO {
        SiiApropiacionInicial siiApropiacionInicial = conversionVoEntidad.convertir(apropiacionInicialVo);
        SiiApropiacionInicial apropiacionInicial = apropiacionInicialDao.buscarApropiacionInicialPorId(siiApropiacionInicial.getAinCodigo());
        return new ApropiacionInicialVO(apropiacionInicial);

    }

    public ApropiacionInicialVO actualizarApropiacionInicial(ApropiacionInicialVO apropiacionInicialVo) throws ExcepcionDAO {
        SiiApropiacionInicial apropiacionInicial = conversionVoEntidad.convertir(apropiacionInicialVo);
        SiiApropiacionInicial retornoApropiacionInicial = apropiacionInicialDao.actualizarApropiacionInicial(apropiacionInicial);
        
        if(apropiacionInicialVo.getAinCerrado() != null){
        adminLogCambioEstado.insertarLogCambioEstadoConNombreEstado(EnumTipoDocColjuegos.APROPIACION_INICIAL.getId(),
                                                    apropiacionInicialVo.getAinCerrado(),
                                                    apropiacionInicialVo.getUsuarioVo4(), apropiacionInicialVo.getAinCodigo());
        }
        
        return new ApropiacionInicialVO(retornoApropiacionInicial);
    }


    public List<ApropiacionInicialVO> buscarApropiacionIniPorVigencia(ApropiacionInicialVO apropiacionInicialVo) throws ExcepcionDAO {
        SiiApropiacionInicial siiApropiacionInicial = conversionVoEntidad.convertir(apropiacionInicialVo);

        List<SiiApropiacionInicial> listaApropiacionIni = apropiacionInicialDao.buscarApropiacionIniPorVigencia(siiApropiacionInicial);

        List<ApropiacionInicialVO> listaApropiacionIniVo = new ArrayList();

        for(SiiApropiacionInicial unaApropiacionInicial : listaApropiacionIni) {
            ApropiacionInicialVO nuevaApropiacionInicialVo = new ApropiacionInicialVO(unaApropiacionInicial);
            listaApropiacionIniVo.add(nuevaApropiacionInicialVo);
        }
        return listaApropiacionIniVo;
    }

    public PrRubroVO insertarPrRubro(PrRubroVO prRubroVo) throws ExcepcionDAO {
        PrRubro prRubro = conversionVoEntidad.convertir(prRubroVo);
        PrRubro RetornoRubro = rubroDao.insertarPrRubro(prRubro);
        return new PrRubroVO(RetornoRubro);
    }

    public PrRubroVO buscarPorInternoRubroVig(PrRubroVO prRubroVo) throws ExcepcionDAO {
        PrRubro prRubro = conversionVoEntidad.convertir(prRubroVo);
        //PrRubro RetornoRubro = rubroDao.buscarPorInternoRubroVig(new PrRubroPK(prRubroVo.getInterno(), prRubroVo.getVigencia()));
        PrRubro RetornoRubro = rubroDao.buscarPorInternoRubroVig(new PrRubroPK(prRubro.getInterno(), prRubro.getVigencia()));
        return new PrRubroVO(RetornoRubro);
    }

    public PrRubroVO actualizarPrRubro(PrRubroVO prRubroVo) throws ExcepcionDAO {
        PrRubro prRubro = conversionVoEntidad.convertir(prRubroVo);
        PrRubro RetornoRubro = rubroDao.actualizarPrRubro(prRubro);
        return new PrRubroVO(RetornoRubro);
    }

    public List<PrRubroVO> buscarTodoPrRubro() throws ExcepcionDAO {
        List<PrRubro> listaRubros = rubroDao.buscarTodoPrRubro();

        List<PrRubroVO> listaRubrosVo = new ArrayList();

        for(PrRubro unaEntidadRubro : listaRubros) {
            PrRubroVO nuevoRubroVo = new PrRubroVO(unaEntidadRubro);
            listaRubrosVo.add(nuevoRubroVo);
        }
        return listaRubrosVo;
    }

    public List<PrRubroVO> buscarTodoPrRubroVigencia(PrRubroVO prRubroVo) throws ExcepcionDAO {
        PrRubro prRubro = conversionVoEntidad.convertir(prRubroVo);

        List<PrRubro> listaRubros = rubroDao.buscarTodoPrRubroVigencia(prRubro);

        List<PrRubroVO> listaRubrosVo = new ArrayList();

        for(PrRubro unaEntidadRubro : listaRubros) {
            PrRubroVO nuevoRubroVo = new PrRubroVO(unaEntidadRubro);
            listaRubrosVo.add(nuevoRubroVo);
        }
        return listaRubrosVo;
    }

    public DetalleRubroVO buscarPorCodigoDetalleRubro(DetalleRubroVO detalleRubroVo) throws ExcepcionDAO {
        SiiDetalleRubro siiDettalleRubro = conversionVoEntidad.convertir(detalleRubroVo);
        SiiDetalleRubro siiDetalleRubroRetorno = detalleRubroDao.buscarPorCodigoDetalleRubro(siiDettalleRubro.getDruCodigo());
        return new DetalleRubroVO(siiDetalleRubroRetorno);
    }


    public DetalleRubroVO insertarSiiDetalleRubro(DetalleRubroVO detalleRubroVo) throws ExcepcionDAO {
        SiiDetalleRubro siiDetalleRubro = conversionVoEntidad.convertir(detalleRubroVo);
        SiiDtlleFuenteFinanciacion unNuevoDetFuenteFinan = detalleFuenteFinanciacionDao.buscarCodDetFuenteFinanciacionPorNombre(siiDetalleRubro.getSiiDtlleFuenteFinanciacion().getDffCodigoRecurso());
        siiDetalleRubro.setSiiDtlleFuenteFinanciacion(unNuevoDetFuenteFinan);
        SiiDetalleRubro siiDetalleRubroRetorno = detalleRubroDao.insertarSiiDetalleRubro(siiDetalleRubro);
        return new DetalleRubroVO(siiDetalleRubroRetorno);
    }

    public List<DetalleRubroVO> actualizarSiiDetalleRubro(List<DetalleRubroVO> listaDetalleRubroVo) throws ExcepcionDAO {
        List<SiiDetalleRubro> listaDRB = new ArrayList();
        List<DetalleRubroVO> listaDRBVo = new ArrayList();
        for(DetalleRubroVO tempDetalleRubroVo : listaDetalleRubroVo) {
            SiiDetalleRubro siiDetalleRubro = conversionVoEntidad.convertir(tempDetalleRubroVo);
            SiiDetalleRubro siiDetalleRubroRetorno = detalleRubroDao.actualizarSiiDetalleRubro(siiDetalleRubro);
            listaDRB.add(siiDetalleRubroRetorno);
        }
        for(SiiDetalleRubro unDetalle : listaDRB)
            listaDRBVo.add(new DetalleRubroVO(unDetalle));
        return listaDRBVo;
    }

    public void borrarPorCodigoDetalleRubro(DetalleRubroVO detalleRubroVo) throws ExcepcionDAO {
        detalleRubroDao.borrarPorCodigoDetalleRubro(detalleRubroVo.getDruCodigo());
    }

    public List<DetalleRubroVO> buscarTodoSiiDetalleRubro() throws ExcepcionDAO {
        List<SiiDetalleRubro> listaDetalleRubro = detalleRubroDao.buscarTodoSiiDetalleRubro();
        List<DetalleRubroVO> listaDetalleRubroVo = new ArrayList();

        for(SiiDetalleRubro UnaEntidadDetRubro : listaDetalleRubro) {
            listaDetalleRubroVo.add(new DetalleRubroVO(UnaEntidadDetRubro));
        }
        return listaDetalleRubroVo;
    }

    public PrNivel1VO insertarNivel1(PrNivel1VO prNivel1Vo) throws ExcepcionDAO {
        PrNivel1 prNivel1 = conversionVoEntidad.convertir(prNivel1Vo);
        PrNivel1 prNivel1Retorno = nivel1Dao.insertarNivel1(prNivel1);
        return new PrNivel1VO(prNivel1Retorno);
    }

    public PrNivel2VO insertarNivel2(PrNivel2VO prNivel2Vo) throws ExcepcionDAO {
        PrNivel2 prNivel2 = conversionVoEntidad.convertir(prNivel2Vo);
        PrNivel2 prNivel2Retorno = nivel2Dao.insertarNivel2(prNivel2);
        return new PrNivel2VO(prNivel2Retorno);
    }

    public PrNivel3VO insertarNivel3(PrNivel3VO prNivel3Vo) throws ExcepcionDAO {
        PrNivel3 prNivel3 = conversionVoEntidad.convertir(prNivel3Vo);
        PrNivel3 prNivel3Retorno = nivel3Dao.insertarNivel3(prNivel3);
        return new PrNivel3VO(prNivel3Retorno);
    }

    public PrNivel4VO insertarNivel4(PrNivel4VO prNivel4Vo) throws ExcepcionDAO {
        PrNivel4 prNivel4 = conversionVoEntidad.convertir(prNivel4Vo);
        PrNivel4 prNivel4Retorno = nivel4Dao.insertarNivel4(prNivel4);
        return new PrNivel4VO(prNivel4Retorno);
    }

    public PrNivel5VO insertarNivel5(PrNivel5VO prNivel5Vo) throws ExcepcionDAO {
        PrNivel5 prNivel5 = conversionVoEntidad.convertir(prNivel5Vo);
        PrNivel5 prNivel5Retorno = nivel5Dao.insertarNivel5(prNivel5);
        return new PrNivel5VO(prNivel5Retorno);
    }

    public PrNivel6VO insertarNivel6(PrNivel6VO prNivel6Vo) throws ExcepcionDAO {
        PrNivel6 prNivel6 = conversionVoEntidad.convertir(prNivel6Vo);
        PrNivel6 prNivel6Retorno = nivel6Dao.insertarNivel6(prNivel6);
        return new PrNivel6VO(prNivel6Retorno);
    }

    public PrNivel7VO insertarNivel7(PrNivel7VO prNivel7Vo) throws ExcepcionDAO {
        PrNivel7 prNivel7 = conversionVoEntidad.convertir(prNivel7Vo);
        PrNivel7 prNivel7Retorno = nivel7Dao.insertarNivel7(prNivel7);
        return new PrNivel7VO(prNivel7Retorno);
    }

    public PrNivel8VO insertarNivel8(PrNivel8VO prNivel8Vo) throws ExcepcionDAO {
        PrNivel8 prNivel8 = conversionVoEntidad.convertir(prNivel8Vo);
        PrNivel8 prNivel8Retorno = nivel8Dao.insertarNivel8(prNivel8);
        return new PrNivel8VO(prNivel8Retorno);
    }

    public String buscarCodigoPresupuestal(Long interno, Long vigencia) throws ExcepcionDAO {
        return detalleRubroDao.buscarCodigoPresupuestal(interno, vigencia);
    }

    public String buscarCodigoPresupuestal(Long mrdCodigo) throws ExcepcionDAO {
        return detalleRubroDao.buscarCodigoPresupuestal(mrdCodigo);
    }

    public String buscarNombreRubro(Long interno, Long vigencia) throws ExcepcionDAO {
        return detalleRubroDao.buscarNombreRubro(interno, vigencia);
    }

    public String buscarNombreRubro(Long mrdCodigo) throws ExcepcionDAO {
        return detalleRubroDao.buscarNombreRubro(mrdCodigo);
    }

    public ReporteEjecucionPreGastosVO calculoEjecucionPreGastos(String idRubro, String fechaIni, String fechaFin) throws ExcepcionDAO {
        ReporteEjecucionPreGastosVO unReporteEjecucionPreGastosVo = new ReporteEjecucionPreGastosVO();
        ReporteEjecucionPreGastosVO aprobadoVo = rubroDao.buscarPresupuestoAprobadoXidRubro(idRubro);

        if(aprobadoVo.getPreAprobado() != null) {
            ReporteEjecucionPreGastosVO cdpAprobadoVo = rubroDao.buscarCDPAprobadoXidRubro(Long.parseLong(idRubro), fechaIni, fechaFin);
            ReporteEjecucionPreGastosVO rpAprobadoVo = rubroDao.buscarRPAprobadoXidRubro(idRubro, fechaIni, fechaFin);
            ReporteEjecucionPreGastosVO obligacionesAprobadasVo = rubroDao.buscarObligacionesAprobadoXidRubro(idRubro, fechaIni, fechaFin);
            ReporteEjecucionPreGastosVO pagosAprobadosVo = rubroDao.buscarPagosAprobadasXidRubro(idRubro, fechaIni, fechaFin);

            unReporteEjecucionPreGastosVo.setPreAprobado(aprobadoVo.getPreAprobado());
            unReporteEjecucionPreGastosVo.setPrePorEjecutar(aprobadoVo.getPreAprobado().subtract(cdpAprobadoVo.getCerExpedidos()));
            unReporteEjecucionPreGastosVo.setCerExpedidos(cdpAprobadoVo.getCerExpedidos());
            unReporteEjecucionPreGastosVo.setCerPorEjecutar(cdpAprobadoVo.getCerExpedidos().subtract(rpAprobadoVo.getRegExpedidos()));
            unReporteEjecucionPreGastosVo.setRegExpedidos(rpAprobadoVo.getRegExpedidos());
            unReporteEjecucionPreGastosVo.setRegPorEjecutar(rpAprobadoVo.getRegExpedidos().subtract(obligacionesAprobadasVo.getObliExpedidos()));
            unReporteEjecucionPreGastosVo.setObliExpedidos(obligacionesAprobadasVo.getObliExpedidos());
            unReporteEjecucionPreGastosVo.setObliPorEjecutar(obligacionesAprobadasVo.getObliExpedidos().subtract(pagosAprobadosVo.getTotalPago()));
            unReporteEjecucionPreGastosVo.setTotalPago(pagosAprobadosVo.getTotalPago());
        }


        return unReporteEjecucionPreGastosVo;
    }

    public Long buscarRubroPorVigenciaCodigoNiveles(Integer vigencia, String unidad, String tipo, String cuenta, String subcuenta, String objeto, String ordinal,
                                                    String subordinal) throws ExcepcionDAO {
        return rubroDao.buscarRubroPorVigenciaCodigoNiveles(vigencia, unidad, tipo, cuenta, subcuenta, objeto, ordinal, subordinal);
    }

}
