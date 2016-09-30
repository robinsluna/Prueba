package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.FiscalizadorSustancDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistEstadoFiscalizDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.PersonaDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFiscalizadorSustanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoFiscaliz;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.FiscalizadorSustancVO;
import co.gov.coljuegos.siicol.ejb.vo.HistEstadoFiscalizVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class AdminFiscalizadorSustancBean implements AdminFiscalizadorSustanc {
    @EJB
    private FiscalizadorSustancDAO fiscalizadorSustancDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;
    @EJB
    private PersonaDAO personaDao;
    @EJB
    HistEstadoFiscalizDAO histEstadoFiscalizDao;

    public AdminFiscalizadorSustancBean() {

    }

    public List<FiscalizadorSustancVO> buscarTodoFiscalizadorSustanc() throws ExcepcionDAO {
        List<FiscalizadorSustancVO> fiscalizadoresVo = new ArrayList<FiscalizadorSustancVO>();
        List<SiiFiscalizadorSustanc> fiscalizadores = fiscalizadorSustancDao.buscarTodoOrdenadoPorId();
        if(fiscalizadores != null && fiscalizadores.size() > 0) {
            for(SiiFiscalizadorSustanc fiscalizador : fiscalizadores) {
                fiscalizadoresVo.add(new FiscalizadorSustancVO(fiscalizador));
            }
            Date hoy = new Date();
            int i = 0;
            for(FiscalizadorSustancVO fiscalizador : fiscalizadoresVo) {
                List<SiiHistEstadoFiscaliz> historia = histEstadoFiscalizDao.buscarHistEstadoFiscalizPorFiscaliz(fiscalizador.getFsuCodigo());
                if(historia.size() > 0) {
                    if(historia.get(0).getHefFechaAct().before(hoy) && (historia.get(0).getHefFechaInact() == null || historia.get(0).getHefFechaInact().after(hoy))) {
                        fiscalizador.setEstadoActual(historia.get(0).getHefEstado());
                    }
                    else {
                        fiscalizador.setEstadoActual("");
                    }

                }
            }
            return fiscalizadoresVo;
        }
        else {
            return new ArrayList<FiscalizadorSustancVO>();
        }

    }

    public FiscalizadorSustancVO buscarFiscalizadorSustancPorCodigo(Long fsuCodigo) throws ExcepcionDAO {

        return new FiscalizadorSustancVO(fiscalizadorSustancDao.buscarPorCodigo(fsuCodigo));
    }

    public FiscalizadorSustancVO insertarFiscalizadorSustanc(FiscalizadorSustancVO fiscalizadorSustancVo) throws ExcepcionDAO, ExcepcionAplicacion {
        boolean existePersonaRolTipoActuacion = false;
        if(fiscalizadorSustancVo.getPersonaVo().getPerCodigo() != null) {
            existePersonaRolTipoActuacion =
                fiscalizadorSustancDao.existeFiscalizadorSustancPorPersonaRolTipoActuacion(fiscalizadorSustancVo.getPersonaVo().getPerCodigo(), fiscalizadorSustancVo.getFsuRol(),
                                                                                           fiscalizadorSustancVo.getTipoActuacionVo().getTacCodigo());
        }
        if(existePersonaRolTipoActuacion) {
            String rol;
            switch(fiscalizadorSustancVo.getFsuRol()) {
            case "F":
                rol = "Fiscalizador";
                break;
            case "S":
                rol = "Sustanciador";
                break;
            case "A":
                rol = "Auditor";
                break;
            default:
                rol = "Invalido";
            }

            throw new ExcepcionAplicacion("Ya existe esta persona con el rol " + rol + " y tipo de actuacion " + fiscalizadorSustancVo.getTipoActuacionVo().getTacNombre());


        }
        else {
            FiscalizadorSustancVO fiscalizadorVo = new FiscalizadorSustancVO(fiscalizadorSustancDao.insertar(conversionVoEntidad.convertir(fiscalizadorSustancVo)));
            if(fiscalizadorSustancVo.getHistEstadoFiscalizListVo() != null && fiscalizadorSustancVo.getHistEstadoFiscalizListVo().size() > 0) {
                for(HistEstadoFiscalizVO historia : fiscalizadorSustancVo.getHistEstadoFiscalizListVo()) {
                    historia.setFiscalizadorSustancVo(fiscalizadorVo);
                    historia = new HistEstadoFiscalizVO(histEstadoFiscalizDao.insertar(conversionVoEntidad.convertir(historia)));
                }
                fiscalizadorVo.setHistEstadoFiscalizListVo(fiscalizadorSustancVo.getHistEstadoFiscalizListVo());
            }
            else {
                fiscalizadorVo.setHistEstadoFiscalizListVo(new ArrayList<HistEstadoFiscalizVO>());
            }
            return fiscalizadorVo;
        }

    }

    public FiscalizadorSustancVO actualizarFiscalizadorSustanc(FiscalizadorSustancVO fiscalizadorSustancVo) throws ExcepcionDAO {
        FiscalizadorSustancVO fiscalizadorVo = new FiscalizadorSustancVO(fiscalizadorSustancDao.actualizar(conversionVoEntidad.convertir(fiscalizadorSustancVo)));
        for(HistEstadoFiscalizVO historia : fiscalizadorSustancVo.getHistEstadoFiscalizListVo()) {
            if(historia.getHefCodigo() == null) {
                historia.setFiscalizadorSustancVo(fiscalizadorVo);
                historia = new HistEstadoFiscalizVO(histEstadoFiscalizDao.insertar(conversionVoEntidad.convertir(historia)));
            }
            else {
                historia = new HistEstadoFiscalizVO(histEstadoFiscalizDao.actualizar(conversionVoEntidad.convertir(historia)));
            }
        }
        fiscalizadorVo.setHistEstadoFiscalizListVo(fiscalizadorSustancVo.getHistEstadoFiscalizListVo());
        return fiscalizadorVo;
    }

    public FiscalizadorSustancVO sustanciadorParaAsignarProceso(Long tacCodigo) throws ExcepcionDAO, ExcepcionAplicacion {
        return new FiscalizadorSustancVO(fiscalizadorSustancDao.buscarPorCodigo(fiscalizadorSustancDao.sustanciadorParaAsignarProceso(tacCodigo)));

    }


}
