package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInvitacionProceso;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.EstadoInvitacionVO;
import co.gov.coljuegos.siicol.ejb.vo.EstadoProcContratVO;
import co.gov.coljuegos.siicol.ejb.vo.ImprimirInvitacionVO;
import co.gov.coljuegos.siicol.ejb.vo.InvitacionProcesoVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.ProcesoContratacionVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class InvitacionProcesoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public InvitacionProcesoDAO() {
        recursos = new Recursos();
    }

    public SiiInvitacionProceso buscarInvitacionProcesoPorId(Long iprCodigo) throws ExcepcionDAO {
        SiiInvitacionProceso localInvitacionProceso = null;
        try {
            localInvitacionProceso = (SiiInvitacionProceso) manager.find(SiiInvitacionProceso.class, iprCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return localInvitacionProceso;

    }

    public SiiInvitacionProceso insertarInvitacionProceso(SiiInvitacionProceso invitacionProceso) throws ExcepcionDAO {
        try {
            manager.persist(invitacionProceso);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return invitacionProceso;
    }

    public SiiInvitacionProceso actualizarInvitacionProceso(SiiInvitacionProceso invitacionProceso) throws ExcepcionDAO {
        try {
            manager.merge(invitacionProceso);
            manager.flush();
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return invitacionProceso;
    }

    public List<SiiInvitacionProceso> buscarInvitacionProcesoPorProceso(SiiInvitacionProceso invitacionProceso) throws ExcepcionDAO {
        List<SiiInvitacionProceso> resultado = null;

        if(invitacionProceso != null && invitacionProceso.getSiiProcesoContratacion() != null && invitacionProceso.getSiiProcesoContratacion().getPrcCodigo() != null) {
            resultado = this.buscarInvitacionProcesoPorProceso(invitacionProceso.getSiiProcesoContratacion().getPrcCodigo());
        }

        return (resultado);
    }


    /**
     * Realiza la b&uacute;squeda de las Invitaciones asociadas a un Proceso de Contrataci&oacute;n.
     * @param prcCodigo - C&oacute;digo del Proceso de Contrataci&oacute;n.
     * @return List of SiiInvitacionProceso
     * @throws ExcepcionDAO
     */
    public List<SiiInvitacionProceso> buscarInvitacionProcesoPorProceso(Long prcCodigo) throws ExcepcionDAO {
        List<SiiInvitacionProceso> localInvitacionProceso = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiInvitacionProceso o INNER JOIN o.siiProcesoContratacion pc WHERE o.siiProcesoContratacion.prcCodigo = :prcCodigo ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("prcCodigo", prcCodigo);
            localInvitacionProceso = query.getResultList();

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return localInvitacionProceso;
    }


    public List<SiiInvitacionProceso> buscarTodaInvitacionProceso(SiiInvitacionProceso invitacionProceso) throws ExcepcionDAO {
        List<SiiInvitacionProceso> localInvitacionProceso = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiInvitacionProceso ");
            Query query = manager.createQuery(toString());
            List<SiiInvitacionProceso> listaInvitacionProceso = query.getResultList();
            return listaInvitacionProceso;

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }

    public ImprimirInvitacionVO buscarDatosImpresionInvitacion(Integer idInvitacion) throws ExcepcionDAO {
        ImprimirInvitacionVO miInvitacion = new ImprimirInvitacionVO();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select pr.prc_objeto_c,ep.epe_valor_contrat,ep.epe_forma_pag_c, ep.epe_tiempo_durac,");
            sql.append(" case ep.epe_unidad_durac when '1' then 'dias habiles' when '2' then 'dias calendario' ");
            sql.append(" when '3' then 'meses' when '4' then 'anos' end,");
            sql.append(" ep.epe_obligac_contra_c, inv.ipr_Fecha_venc");
            sql.append(" from sii_estudio_previo ep");
            sql.append(" inner Join sii_proceso_contratacion pr on (ep.prc_codigo = pr.prc_codigo)");
            sql.append(" Right outer Join sii_invitacion_proceso inv on (pr.prc_codigo = inv.prc_codigo )");
            sql.append(" where inv.ipr_codigo =#idInvitacion");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idInvitacion", idInvitacion);

            List<Object[]> results = query.getResultList();
            if(results != null && !results.isEmpty()) {

                for(Object[] object : results) {

                    miInvitacion.setObjeto((String) object[0]);
                    miInvitacion.setValorContract((BigDecimal) object[1]);
                    miInvitacion.setFormaPago((String) object[2]);
                    if(object[3] != null) {
                        miInvitacion.setTiempoDurac(Integer.valueOf(((BigDecimal) object[3]).intValue()));
                    }
                    miInvitacion.setUnidadDurac((String) object[4]);
                    miInvitacion.setObligaciones((String) object[5]);
                    miInvitacion.setFechaVencimiento((Date) object[6]);
                }
            }


        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return miInvitacion;
    }

    public PersonaVO buscarDatosFuncionarioImpresion(Long codigoFuncionario) throws ExcepcionDAO {
        PersonaVO persona = new PersonaVO();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select per.per_primer_nombre, per.per_Segundo_nombre, per.per_primer_apellido, per.per_segundo_apellido,fun.fun_nombre");
            sql.append(" from sii_persona per Inner Join sii_usuario usu on (per.per_codigo =usu.per_codigo)");
            sql.append(" Inner Join sii_funcion fun on (usu.fun_codigo = fun.fun_codigo)");
            sql.append(" where fun.fun_codigo =#codigoFuncionario");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("codigoFuncionario", codigoFuncionario);

            List<Object[]> results = query.getResultList();
            if(results != null && !results.isEmpty()) {

                for(Object[] object : results) {
                    persona.setPerPrimerNombre((String) object[0] + " " + (String) object[1] + " " + (String) object[2] + " " + (String) object[3]);
                    persona.setPerEmail((String) object[4]);
                }
            }

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return persona;
    }

    public List<InvitacionProcesoVO> buscarProcesoContratacionInvitacion() throws ExcepcionDAO {

        List<InvitacionProcesoVO> listaProc = new ArrayList<InvitacionProcesoVO>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select pro.prc_codigo,pro.prc_objeto_c,pro.epc_codigo,inv.ipr_codigo,inv.ein_codigo,epc.epc_nombre,ein.ein_nombre");
            sql.append(" from sii_proceso_contratacion pro");
            sql.append(" inner Join sii_estado_proc_contrat epc on (pro.epc_codigo = epc.epc_codigo)");
            sql.append(" left outer Join sii_invitacion_proceso inv on (pro.prc_codigo = inv.prc_codigo )");
            sql.append(" left Join sii_estado_invitacion ein on (inv.ein_codigo = ein.ein_codigo)");
            sql.append(" where pro.epc_codigo in (5,63)");
            sql.append(" order by pro.prc_codigo desc ");

            Query query = manager.createNativeQuery(sql.toString());

            List<Object[]> results = query.getResultList();
            if(results != null && !results.isEmpty()) {

                for(Object[] object : results) {
                    InvitacionProcesoVO invita = new InvitacionProcesoVO();
                    ProcesoContratacionVO procesoVo = new ProcesoContratacionVO();
                    EstadoInvitacionVO estadoInvita = new EstadoInvitacionVO();
                    EstadoProcContratVO estadoProceso = new EstadoProcContratVO();

                    procesoVo.setPrcCodigo(((BigDecimal) object[0]).longValue());
                    procesoVo.setPrcObjeto((String) object[1]);
                    estadoProceso.setEpcCodigo(((BigDecimal) object[2]).longValue());
                    estadoProceso.setEpcNombre((String) object[5]);
                    procesoVo.setEstadoProcContrat(estadoProceso);

                    if(object[3] != null) {
                        invita.setIprCodigo(((BigDecimal) object[3]).longValue());
                    }
                    if(object[4] != null) {
                        estadoInvita.setEinCodigo(((BigDecimal) object[4]).longValue());
                        estadoInvita.setEinNombre((String) object[6]);
                        invita.setEstadoInvitacionVO(estadoInvita);
                    }
                    invita.setProcesoContratacionVO(procesoVo);
                    listaProc.add(invita);

                }
            }

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaProc;
    }

}


