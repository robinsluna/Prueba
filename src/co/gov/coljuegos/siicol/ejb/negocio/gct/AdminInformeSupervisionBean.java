package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoIncumplContractDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.EstadoProcesoSancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FiscalizadorSustancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.IncumplimientoContrDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.InformeSupervisionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.MotivoIncuInfSupervDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.ProcesoSancionatorioDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.RepartoFiscalizadorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiIncumplimientoContr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInformeSupervision;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProcesoSancionatorio;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.EstadoIncumplContractVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcesoSancVO;
import co.gov.coljuegos.siicol.ejb.vo.FiscalizadorSustancVO;
import co.gov.coljuegos.siicol.ejb.vo.IncumplimientoContrVO;
import co.gov.coljuegos.siicol.ejb.vo.InformeSupervisionVO;
import co.gov.coljuegos.siicol.ejb.vo.MotivoIncuInfSupervVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoSancionatorioVO;
import co.gov.coljuegos.siicol.ejb.vo.RepartoFiscalizadorVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminInformeSupervisionBean implements AdminInformeSupervision {
    private static final Long INCUMPLIMIENTO_CONTR = 3L;
    private static final Long PROCESO_SANCIONATORIO = 4L;
    private static final String ESTADO_INFORME_SUPERVISION = "INFORME SUPERVISIÓN";
    @EJB
    private InformeSupervisionDAO informeSupervisionDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private MotivoIncuInfSupervDAO motivoIncuInfSupervDao;
    @EJB
    private IncumplimientoContrDAO incumplimientoContrDao;
    @EJB
    private RepartoFiscalizadorDAO repartoFiscalizadorDao;
    @EJB
    private EstadoIncumplContractDAO estadoIncumplContractDao;
    @EJB
    private FiscalizadorSustancDAO fiscalizadorSustancDao;
    @EJB
    private ProcesoSancionatorioDAO procesoSancionatorioDao;
    @EJB
    private EstadoProcesoSancDAO estadoProcesoSancDao;

    public AdminInformeSupervisionBean() {

    }

    public List<InformeSupervisionVO> buscarInformesSupervision() throws ExcepcionDAO {
        List<InformeSupervisionVO> informesVo = convertirListaSiiInformeSupervisionEnListaVo(informeSupervisionDao.buscarInformesOrdenadosPorFechaRadiYCodigo());
        if (informesVo != null && informesVo.size()>0) {
            for(InformeSupervisionVO informeVo : informesVo) {
                informeVo.setIncumplimientoContrListVo(new ArrayList<IncumplimientoContrVO>());
                for (SiiIncumplimientoContr incumplimiento : incumplimientoContrDao.buscarIncumplimientosInforme(informeVo.getIsuCodigo())) {
                    informeVo.getIncumplimientoContrListVo().add(new IncumplimientoContrVO(incumplimiento));            
                }
                informeVo.setProcesoSancionatorioListVo(new ArrayList<ProcesoSancionatorioVO>());
                for (SiiProcesoSancionatorio procesoSancionatorio : procesoSancionatorioDao.buscarProcesosInforme(informeVo.getIsuCodigo())) {
                    informeVo.getProcesoSancionatorioListVo().add(new ProcesoSancionatorioVO(procesoSancionatorio));            
                }
            } 

        }         
        return informesVo;  
    }

    public List<InformeSupervisionVO> buscarInformesSupervision(Long usuCodigo) throws ExcepcionDAO {
        List<InformeSupervisionVO> informesVo = convertirListaSiiInformeSupervisionEnListaVo(informeSupervisionDao.buscarInformesSupervision(usuCodigo));
            if (informesVo != null && informesVo.size()>0) {
                for(InformeSupervisionVO informeVo : informesVo) {
                    informeVo.setIncumplimientoContrListVo(new ArrayList<IncumplimientoContrVO>()); 
                    informeVo.setProcesoSancionatorioListVo(new ArrayList<ProcesoSancionatorioVO>());
                    for (SiiIncumplimientoContr incumplimiento : incumplimientoContrDao.buscarIncumplimientosInforme(informeVo.getIsuCodigo())) {
                        informeVo.getIncumplimientoContrListVo().add(new IncumplimientoContrVO(incumplimiento));            
                    }
                    for (SiiProcesoSancionatorio proceso : procesoSancionatorioDao.buscarProcesosInforme(informeVo.getIsuCodigo())) {
                        informeVo.getProcesoSancionatorioListVo().add(new ProcesoSancionatorioVO(proceso));            
                    }
                } 

            }
        return informesVo;
    }

    private List<InformeSupervisionVO> convertirListaSiiInformeSupervisionEnListaVo(List<SiiInformeSupervision> informesSupervision) throws co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO {
        List<InformeSupervisionVO> informesVo = new ArrayList<InformeSupervisionVO>();
        for(SiiInformeSupervision informe : informesSupervision) {
            informesVo.add(new InformeSupervisionVO(informe));
        }
        return informesVo;
    }

    public InformeSupervisionVO insertarInformeSupervision(InformeSupervisionVO informeSupervisionVo) throws ExcepcionDAO {
        InformeSupervisionVO nuevoInformeSupervisionVo = new InformeSupervisionVO(informeSupervisionDao.insertar(conversionVoEntidad.convertir(informeSupervisionVo)));
        if(informeSupervisionVo.getMotivoIncuInfSupervListVo() != null) {
            for(MotivoIncuInfSupervVO motivo : informeSupervisionVo.getMotivoIncuInfSupervListVo()) {
                motivo.setInformeSupervisionVo(nuevoInformeSupervisionVo);
                motivo = new MotivoIncuInfSupervVO(motivoIncuInfSupervDao.insertar(conversionVoEntidad.convertir(motivo)));
            }
        }
        restaurarVariablesAdicionalesInforme(informeSupervisionVo, nuevoInformeSupervisionVo);
        if (informeSupervisionVo.getTipoActuacionVo().getTacCodigo().equals(INCUMPLIMIENTO_CONTR)) {
            IncumplimientoContrVO incumplimientoContrVo = new IncumplimientoContrVO();
            incumplimientoContrVo.setInformeSupervisionVo(nuevoInformeSupervisionVo);
            incumplimientoContrVo.setIcnConsecutivo(incumplimientoContrDao.calcularConsecutivo(informeSupervisionVo.getTipoActuacionVo().getTacCodigo()));
            informeSupervisionDao.calcularConsecutivoProcesoPorTipoActuacionSupervisor(informeSupervisionVo.getTipoActuacionVo().getTacCodigo());

            incumplimientoContrVo.setEstadoIncumplContractVo(new EstadoIncumplContractVO(estadoIncumplContractDao.buscarEstadoPorNombre(ESTADO_INFORME_SUPERVISION)));
            incumplimientoContrVo = new IncumplimientoContrVO(incumplimientoContrDao.insertar(conversionVoEntidad.convertir(incumplimientoContrVo)));
    
        } else if (informeSupervisionVo.getTipoActuacionVo().getTacCodigo().equals(PROCESO_SANCIONATORIO)) {
            ProcesoSancionatorioVO procesoSancionatorioVo= new ProcesoSancionatorioVO();
            procesoSancionatorioVo.setInformeSupervisionVo(nuevoInformeSupervisionVo);
            procesoSancionatorioVo.setPsaConsecutivo(procesoSancionatorioDao.calcularConsecutivo(informeSupervisionVo.getTipoActuacionVo().getTacCodigo()));
            procesoSancionatorioVo.setContratoVo(informeSupervisionVo.getContratoVo());
            procesoSancionatorioVo.setPsaMotivoOmision("N");
            procesoSancionatorioVo.setPsaMotivoInexac("N");
            for (MotivoIncuInfSupervVO motivo :informeSupervisionVo.getMotivoIncuInfSupervListVo()) {
                if (motivo.getMotivoIncumplimientoVo().getMinNombre().equals("Omisión")) {
                    procesoSancionatorioVo.setPsaMotivoOmision("S");
                } else if (motivo.getMotivoIncumplimientoVo().getMinNombre().equals("Inexactitud")) {
                    procesoSancionatorioVo.setPsaMotivoInexac("S");
                }
            }
            informeSupervisionDao.calcularConsecutivoProcesoPorTipoActuacionSupervisor(informeSupervisionVo.getTipoActuacionVo().getTacCodigo());

            procesoSancionatorioVo.setEstadoProcesoSancVo(new EstadoProcesoSancVO(estadoProcesoSancDao.buscarEstadoPorNombre(ESTADO_INFORME_SUPERVISION)));
            procesoSancionatorioVo = new ProcesoSancionatorioVO(procesoSancionatorioDao.insertar(conversionVoEntidad.convertir(procesoSancionatorioVo))); 
        }
        
        return nuevoInformeSupervisionVo;
    }


    public InformeSupervisionVO actualizarInformeSupervision(InformeSupervisionVO informeSupervisionVo) throws ExcepcionDAO {
        InformeSupervisionVO nuevoInformeSupervisionVo = new InformeSupervisionVO(informeSupervisionDao.actualizar(conversionVoEntidad.convertir(informeSupervisionVo)));
        if(informeSupervisionVo.getMotivoIncuInfSupervListVo() != null) {
            for(MotivoIncuInfSupervVO motivo : informeSupervisionVo.getMotivoIncuInfSupervListVo()) {
                if(motivo.getMiiCodigo() != null) {
                    motivo = new MotivoIncuInfSupervVO(motivoIncuInfSupervDao.actualizar(conversionVoEntidad.convertir(motivo)));
                }
                else {
                    motivo = new MotivoIncuInfSupervVO(motivoIncuInfSupervDao.insertar(conversionVoEntidad.convertir(motivo)));
                }

            }
        }
        restaurarVariablesAdicionalesInforme(informeSupervisionVo, nuevoInformeSupervisionVo);
        return nuevoInformeSupervisionVo;
    }

    private void restaurarVariablesAdicionalesInforme(InformeSupervisionVO informeSupervisionVo, InformeSupervisionVO nuevoInformeSupervisionVo) {
        nuevoInformeSupervisionVo.setMotivo(informeSupervisionVo.getMotivo());
        nuevoInformeSupervisionVo.setValorInicialContrato(informeSupervisionVo.getValorInicialContrato());
        nuevoInformeSupervisionVo.setPolizasVo(informeSupervisionVo.getPolizasVo());
        nuevoInformeSupervisionVo.setListaOtroSiVo(informeSupervisionVo.getListaOtroSiVo());
        nuevoInformeSupervisionVo.setIndicadorEstadoCuenta(informeSupervisionVo.getIndicadorEstadoCuenta());
    }

    public InformeSupervisionVO aprobarInformeSupervision(InformeSupervisionVO informeSupervisionVo) throws ExcepcionDAO {

        if (informeSupervisionVo.getTipoActuacionVo().getTacCodigo().equals(PROCESO_SANCIONATORIO)) {
            ProcesoSancionatorioVO procesoSancionatorioVo = informeSupervisionVo.getProcesoSancionatorioVo();
            procesoSancionatorioVo.setEstadoProcesoSancVo(new EstadoProcesoSancVO(estadoProcesoSancDao.buscarEstadoPorNombre("REPARTIDO")));
            procesoSancionatorioVo.setInformeSupervisionVo(informeSupervisionVo);


            //       informeSupervisionVo.setIncumplimientoContrVo(new IncumplimientoContrVO(incumplimientoContrDao.actualizar(conversionVoEntidad.convertir(procesoSancionatorioVo))));

            procesoSancionatorioVo.setRepartoFiscalizadorList(new ArrayList<RepartoFiscalizadorVO>());
            procesoSancionatorioVo.getRepartoFiscalizadorList().add(new RepartoFiscalizadorVO());
            procesoSancionatorioVo.getRepartoFiscalizadorList().get(0).setRfsActivo("S");
            procesoSancionatorioVo.getRepartoFiscalizadorList().get(0).setRfsFecha(new Date());
            procesoSancionatorioVo.getRepartoFiscalizadorList().get(0).setProcesoSancionatorioVo(informeSupervisionVo.getProcesoSancionatorioVo());

            RepartoFiscalizadorVO repartoVo = procesoSancionatorioVo.getRepartoFiscalizadorList().get(0);
            repartoVo.setFiscalizadorSustancVo(new FiscalizadorSustancVO(fiscalizadorSustancDao.buscarPorCodigo(fiscalizadorSustancDao.sustanciadorParaAsignarProceso(informeSupervisionVo.getTipoActuacionVo().getTacCodigo()))));

            informeSupervisionVo.getProcesoSancionatorioVo().getRepartoFiscalizadorList().add(new RepartoFiscalizadorVO(repartoFiscalizadorDao.insertar(conversionVoEntidad.convertir(repartoVo))));

            InformeSupervisionVO nuevoInformeSupervisionVo = actualizarInformeSupervision(informeSupervisionVo);
            procesoSancionatorioVo.setInformeSupervisionVo(nuevoInformeSupervisionVo);
            procesoSancionatorioDao.actualizar(conversionVoEntidad.convertir(procesoSancionatorioVo));
            restaurarVariablesAdicionalesInforme(informeSupervisionVo, nuevoInformeSupervisionVo);
            return nuevoInformeSupervisionVo;
            
        } else if (informeSupervisionVo.getTipoActuacionVo().getTacCodigo().equals(INCUMPLIMIENTO_CONTR)) {
            IncumplimientoContrVO incumplimientoVo = informeSupervisionVo.getIncumplimientoContrVo();
            incumplimientoVo.setEstadoIncumplContractVo(new EstadoIncumplContractVO(estadoIncumplContractDao.buscarEstadoPorNombre("REPARTIDO")));
            incumplimientoVo.setInformeSupervisionVo(informeSupervisionVo);


            //       informeSupervisionVo.setIncumplimientoContrVo(new IncumplimientoContrVO(incumplimientoContrDao.actualizar(conversionVoEntidad.convertir(incumplimientoVo))));

            incumplimientoVo.setRepartoFiscalizadorListVo(new ArrayList<RepartoFiscalizadorVO>());
            incumplimientoVo.getRepartoFiscalizadorListVo().add(new RepartoFiscalizadorVO());
            incumplimientoVo.getRepartoFiscalizadorListVo().get(0).setRfsActivo("S");
            incumplimientoVo.getRepartoFiscalizadorListVo().get(0).setRfsFecha(new Date());
            incumplimientoVo.getRepartoFiscalizadorListVo().get(0).setIncumplimientoContrVo(informeSupervisionVo.getIncumplimientoContrVo());

            RepartoFiscalizadorVO repartoVo = incumplimientoVo.getRepartoFiscalizadorListVo().get(0);
            repartoVo.setFiscalizadorSustancVo(new FiscalizadorSustancVO(fiscalizadorSustancDao.buscarPorCodigo(fiscalizadorSustancDao.sustanciadorParaAsignarProceso(informeSupervisionVo.getTipoActuacionVo().getTacCodigo()))));

            informeSupervisionVo.getIncumplimientoContrVo().getRepartoFiscalizadorListVo().add(new RepartoFiscalizadorVO(repartoFiscalizadorDao.insertar(conversionVoEntidad.convertir(repartoVo))));

            InformeSupervisionVO nuevoInformeSupervisionVo = actualizarInformeSupervision(informeSupervisionVo);
            incumplimientoVo.setInformeSupervisionVo(nuevoInformeSupervisionVo);
            incumplimientoContrDao.actualizar(conversionVoEntidad.convertir(incumplimientoVo));
            restaurarVariablesAdicionalesInforme(informeSupervisionVo, nuevoInformeSupervisionVo);
            return nuevoInformeSupervisionVo;
        }
        

        return null;

    }


}
