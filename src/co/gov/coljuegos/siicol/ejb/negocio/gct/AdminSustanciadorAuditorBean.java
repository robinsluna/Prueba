/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 05-10-2015
 */
package co.gov.coljuegos.siicol.ejb.negocio.gct;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoActuacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionAplicacion;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.AuditorOrdenTrabDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.HistEstadoSustanDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.dao.SustanciadorAuditorDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiHistEstadoSustan;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSustanciadorAuditor;
import co.gov.coljuegos.siicol.ejb.util.ConversionVOEntidad;
import co.gov.coljuegos.siicol.ejb.vo.HistEstadoSustanVO;
import co.gov.coljuegos.siicol.ejb.vo.SustanciadorAuditorVO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Bean que gestiona los sustanciadores/auditores de las órdenes de trabajo de visita.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
public class AdminSustanciadorAuditorBean implements AdminSustanciadorAuditor {

    @EJB
    private SustanciadorAuditorDAO sustanciadorAuditorDao;
    @EJB
    private HistEstadoSustanDAO histEstadoSustanDao;
    @EJB
    private AuditorOrdenTrabDAO auditorOrdenTrabDao;
    @EJB
    private ConversionVOEntidad conversionVoEntidad;


    /**
     * Constructor.
     */
    public AdminSustanciadorAuditorBean() {
        super();
    }

    /**
     * Buscar los sustanciadores/auditores que estén activos en orden alfabético
     * @param numFun - número de funcionarios que se necesitan.
     * @return resultado - lista de sustanciadores/auditores que se necesitan.
     * @throws ExcepcionDAO
     */
    public List<SustanciadorAuditorVO> buscarSustanciadoresAuditoresActivosOrdAlfa(Integer numFun) throws ExcepcionDAO {
        Map<Integer, SustanciadorAuditorVO> mapaSustanciadorAuditor = new HashMap<Integer, SustanciadorAuditorVO>();

        List<SustanciadorAuditorVO> listaSustanciadoresAct = sustanciadorAuditorDao.buscarTodosSustanciadoresAuditoresActivosXTipoActuacion(EnumTipoActuacion.VERIFICACION_EN_CAMPO.getTacCodigo());
        Integer ord = listaSustanciadoresAct.size();

        if(listaSustanciadoresAct.size() <= numFun) {
            return listaSustanciadoresAct;
        }
        else {

            for(SustanciadorAuditorVO sustanciadorAuditorVo : listaSustanciadoresAct) {
                mapaSustanciadorAuditor.put(ord, sustanciadorAuditorVo);
                ord--;
            }

            Iterator<Integer> sustanciadoresIterator = mapaSustanciadorAuditor.keySet().iterator();
            Integer clave;
            List<Integer> listaSustEliminar = new ArrayList<Integer>();
            while(sustanciadoresIterator.hasNext()) {
                clave = sustanciadoresIterator.next();

                if(mapaSustanciadorAuditor.size() > numFun) {
                    if(auditorOrdenTrabDao.isAsignado(mapaSustanciadorAuditor.get(clave).getSuaCodigo())) {
                        if(mapaSustanciadorAuditor.containsKey(clave)) {
                            listaSustEliminar.add(clave);
                        }
                    }
                }
            }

            int size = mapaSustanciadorAuditor.size();
            listaSustanciadoresAct = new ArrayList<SustanciadorAuditorVO>();

            if(size > numFun) {
                for(int i = size, j = 0; j < numFun; i--) {

                    if(!listaSustEliminar.contains(i)) {

                        if(i > 0) {
                            listaSustanciadoresAct.add(j, mapaSustanciadorAuditor.get(i));
                        }
                        j++;
                    }
                }
            }

            if(listaSustanciadoresAct.isEmpty()) {
                for(int i = 1; i <= numFun; i++) {

                    listaSustanciadoresAct.add(i - 1, mapaSustanciadorAuditor.get(i));
                }
            }


        }

        return (listaSustanciadoresAct);
    }

    public List<SustanciadorAuditorVO> buscarTodoSustanciadorAuditor() throws ExcepcionDAO {
        List<SustanciadorAuditorVO> auditoresVo = new ArrayList<SustanciadorAuditorVO>();
        List<SiiSustanciadorAuditor> auditores = sustanciadorAuditorDao.buscarTodoOrdenadoPorId();
        if(auditores != null && auditores.size() > 0) {
            for(SiiSustanciadorAuditor auditor : auditores) {
                auditoresVo.add(new SustanciadorAuditorVO(auditor));
            }
            Date hoy = new Date();
            int i = 0;
            for(SustanciadorAuditorVO auditor : auditoresVo) {
                List<SiiHistEstadoSustan> historia = histEstadoSustanDao.buscarHistEstadoSustanPorAuditor(auditor.getSuaCodigo(),null);
                if(historia.size() > 0) {
                    if(historia.get(0).getHesFechaAct().before(hoy) && (historia.get(0).getHesFechaInact() == null || historia.get(0).getHesFechaInact().after(hoy))) {
                        auditor.setEstadoActual(historia.get(0).getHesEstado());
                    }
                    else {
                        auditor.setEstadoActual("");
                    }

                }
            }
            return auditoresVo;
        }
        else {
            return new ArrayList<SustanciadorAuditorVO>();
        }

    }

    public SustanciadorAuditorVO insertarSustanciadorAuditor(SustanciadorAuditorVO sustanciadorAuditorVo) throws ExcepcionDAO, ExcepcionAplicacion {
        boolean existePersonaRolTipoActuacion = false;
        if(sustanciadorAuditorVo.getPersonaVo().getPerCodigo() != null) {
            existePersonaRolTipoActuacion =
                sustanciadorAuditorDao.existeSustanciadorAuditorPorPersonaRolTipoActuacion(sustanciadorAuditorVo.getPersonaVo().getPerCodigo(), sustanciadorAuditorVo.getSuaRol(),
                                                                                           sustanciadorAuditorVo.getTipoActuacionVo().getTacCodigo());
        }
        if(existePersonaRolTipoActuacion) {
            String rol;
            switch(sustanciadorAuditorVo.getSuaRol()) {
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

            throw new ExcepcionAplicacion("Ya existe esta persona con el rol " + rol + " y tipo de actuacion " + sustanciadorAuditorVo.getTipoActuacionVo().getTacNombre());


        }
        else {
            SustanciadorAuditorVO sustanciadorVo = new SustanciadorAuditorVO(sustanciadorAuditorDao.insertar(conversionVoEntidad.convertir(sustanciadorAuditorVo)));
            if(sustanciadorAuditorVo.getHistEstadoSustanListVo() != null && sustanciadorAuditorVo.getHistEstadoSustanListVo().size() > 0) {
                for(HistEstadoSustanVO historia : sustanciadorAuditorVo.getHistEstadoSustanListVo()) {
                    historia.setSustanciadorAuditorVo(sustanciadorVo);
                    historia = new HistEstadoSustanVO(histEstadoSustanDao.insertar(conversionVoEntidad.convertir(historia)));
                }
                sustanciadorVo.setHistEstadoSustanListVo(sustanciadorAuditorVo.getHistEstadoSustanListVo());
            }
            return sustanciadorVo;
        }

    }


    public SustanciadorAuditorVO actualizarSustanciadorAuditor(SustanciadorAuditorVO sustanciadorAuditorVo) throws ExcepcionDAO {
        SustanciadorAuditorVO sustanciadorVo = new SustanciadorAuditorVO(sustanciadorAuditorDao.actualizar(conversionVoEntidad.convertir(sustanciadorAuditorVo)));
        for(HistEstadoSustanVO historia : sustanciadorAuditorVo.getHistEstadoSustanListVo()) {
            if(historia.getHesCodigo() == null) {
                historia.setSustanciadorAuditorVo(sustanciadorVo);
                historia = new HistEstadoSustanVO(histEstadoSustanDao.insertar(conversionVoEntidad.convertir(historia)));
            }
            // No se actualiza la historia.
            /* else {
                SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
                System.out.println("Fecha Act "+sdf.format( historia.getHesFechaAct())+" fecha Inact "+sdf.format( historia.getHesFechaInact()));
                historia = new HistEstadoSustanVO(histEstadoSustanDao.actualizar(conversionVoEntidad.convertir(historia)));
            } */
        }
        sustanciadorVo.setHistEstadoSustanListVo(sustanciadorAuditorVo.getHistEstadoSustanListVo());
        return sustanciadorVo;

    }
}
