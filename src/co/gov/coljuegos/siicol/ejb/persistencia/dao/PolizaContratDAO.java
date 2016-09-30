package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoPolizaContrato;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPolizaContrat;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.PolizaContratVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class PolizaContratDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public PolizaContratDAO() {
        recursos = new Recursos();

    }

    public SiiPolizaContrat buscarPolizaContratPorCodigo(Long codigo) throws ExcepcionDAO {
        SiiPolizaContrat poliza = null;
        try {
            poliza = (SiiPolizaContrat) manager.find(SiiPolizaContrat.class, codigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return poliza;
    }

    /**
     *
     * @param siiPolizaContrat
     * @return
     * @throws ExcepcionDAO
     */
    public SiiPolizaContrat insertarPolizaContrat(SiiPolizaContrat siiPolizaContrat) throws ExcepcionDAO {
        try {
            manager.persist(siiPolizaContrat);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiPolizaContrat;
    }

    public void actualizarPolizaContrat(SiiPolizaContrat siiPolizaContrat) throws ExcepcionDAO {
        try {
            siiPolizaContrat = manager.merge(siiPolizaContrat);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
    }


    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiPolizaContrat> buscarPolizasContrat() throws ExcepcionDAO {
        List<SiiPolizaContrat> siiPolizaContrats = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pcc FROM SiiPolizaContrat pcc");
            sql.append(" WHERE pcc.siiEstadoPolizaCont.epoCodigo != " + EnumEstadoPolizaContrato.INACTIVO.getId());
            sql.append(" AND pcc.siiOtrosi IS NULL");
            sql.append(" AND (pcc.pccRenovacion = 'N' OR pcc.pccRenovacion IS NULL)");
            sql.append(" ORDER BY pcc.siiContrato.conNumero DESC");

            Query query = manager.createQuery(sql.toString());
            siiPolizaContrats = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiPolizaContrats;
    }
    
    public List<SiiPolizaContrat> buscarPolizasContratRenovacion() throws ExcepcionDAO {
        List<SiiPolizaContrat> siiPolizaContrats = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pcc FROM SiiPolizaContrat pcc");
            sql.append(" WHERE pcc.siiEstadoPolizaCont.epoCodigo != " + EnumEstadoPolizaContrato.INACTIVO.getId());
            sql.append(" AND pcc.siiOtrosi IS NULL");
            sql.append(" AND pcc.pccRenovacion = 'S'");
            sql.append(" ORDER BY pcc.pccCodigo DESC");

            Query query = manager.createQuery(sql.toString());
            siiPolizaContrats = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiPolizaContrats;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiPolizaContrat> buscarPolizasOtrosiConcesion() throws ExcepcionDAO {
        List<SiiPolizaContrat> siiPolizaContrats = new ArrayList<SiiPolizaContrat>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pcc FROM SiiPolizaContrat pcc");
            sql.append(" WHERE pcc.siiEstadoPolizaCont.epoCodigo != " + EnumEstadoPolizaContrato.INACTIVO.getId());
            sql.append(" AND pcc.siiOtrosi.osiCodigo IS NOT NULL");
            sql.append(" AND (pcc.pccRenovacion = 'N' OR pcc.pccRenovacion IS NULL)");
            sql.append(" ORDER BY pcc.pccFechaAprobac");

            Query query = manager.createQuery(sql.toString());
            siiPolizaContrats = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiPolizaContrats;
    }
    
    /**
     *Metodo encargado de consultar la ultima poliza del operador por un estado y un nit
     * @param String nit
     * @param long codigoEstadoPoliza
     * @Author David Tafur
     * @return
     * @throws ExcepcionDAO
     */
    public SiiPolizaContrat consultarPolizaXContrato(String contrato, long codigoEstadoPoliza) throws ExcepcionDAO {
        SiiPolizaContrat siiPolizaContrat = new SiiPolizaContrat();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT po FROM SiiPolizaContrat po");
            sql.append(" INNER JOIN po.siiContrato cont");
            sql.append(" WHERE cont.conNumero =:contrato");
            sql.append(" AND po.siiEstadoPolizaCont.epoCodigo = :codigoEstadoPoliza");
            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("contrato", contrato);
            consulta.setParameter("codigoEstadoPoliza", codigoEstadoPoliza);

            List<SiiPolizaContrat> listaPolizaContrato = new ArrayList<SiiPolizaContrat>();
            listaPolizaContrato = consulta.getResultList();

            if (listaPolizaContrato.size() > 0) {
                siiPolizaContrat = listaPolizaContrato.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiPolizaContrat;
    }

    /**
     *Metodo encargado de consultar la ultima poliza del operador por un estado y un nit
     * @param String nit
     * @param long codigoEstadoPoliza
     * @Author David Tafur
     * @return
     * @throws ExcepcionDAO
     */
    public SiiPolizaContrat consultarPolizaXOperadorYEstado(String nit, long codigoEstadoPoliza) throws ExcepcionDAO {
        SiiPolizaContrat siiPolizaContrat = new SiiPolizaContrat();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT po FROM SiiPolizaContrat po");
            sql.append(" INNER JOIN po.siiContrato cont");
            sql.append(" INNER JOIN cont.siiOperador ope");
            sql.append(" INNER JOIN ope.siiPersona per");
            sql.append(" WHERE per.perNumIdentificacion =:identificacionOperador");
            sql.append(" AND po.siiEstadoPolizaCont.epoCodigo = :codigoEstadoPoliza");
            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("identificacionOperador", nit);
            consulta.setParameter("codigoEstadoPoliza", codigoEstadoPoliza);

            List<SiiPolizaContrat> listaPolizaContrato = new ArrayList<SiiPolizaContrat>();
            listaPolizaContrato = consulta.getResultList();

            if (listaPolizaContrato.size() > 0) {
                siiPolizaContrat = listaPolizaContrato.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiPolizaContrat;
    }

    /**
     *Metodo encargado de consultar la ultima poliza OtroSi del operador por un estado y un nit
     * @param nit
     * @param codigoEstadoPoliza
     * @Author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public SiiPolizaContrat consultarPolizaOtroSiXOperadorYEstado(String nit, long codigoEstadoPoliza,
                                                                  Long codOtroSi) throws ExcepcionDAO {
        SiiPolizaContrat siiPolizaContrat = new SiiPolizaContrat();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT po FROM SiiPolizaContrat po");
            sql.append(" INNER JOIN po.siiContrato cont");
            sql.append(" INNER JOIN cont.siiOperador ope");
            sql.append(" INNER JOIN ope.siiPersona per");
            sql.append(" WHERE per.perNumIdentificacion =:identificacionOperador");
            sql.append(" AND po.siiEstadoPolizaCont.epoCodigo = :codigoEstadoPoliza");
            sql.append(" AND po.siiOtrosi.osiCodigo = :codOtroSi");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("identificacionOperador", nit);
            consulta.setParameter("codigoEstadoPoliza", codigoEstadoPoliza);
            consulta.setParameter("codOtroSi", codOtroSi);

            List<SiiPolizaContrat> listaPolizaContrato = new ArrayList<SiiPolizaContrat>();
            listaPolizaContrato = consulta.getResultList();

            if (listaPolizaContrato.size() > 0) {
                siiPolizaContrat = listaPolizaContrato.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiPolizaContrat;
    }
    
    
    public List<SiiPolizaContrat> buscarPolizasPorContrato(Long idContrato) throws ExcepcionDAO {
        List<SiiPolizaContrat> siiPolizaContrats = new ArrayList<SiiPolizaContrat>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pcc FROM SiiPolizaContrat pcc");
            sql.append(" WHERE pcc.siiContrato.conCodigo = :idContrato  ");
            sql.append(" order by  pcc.pccCodigo asc  ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idContrato", idContrato);
            siiPolizaContrats = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiPolizaContrats;
    }
    
    public PolizaContratVO buscarValorImputacionPoliza(Long  codigo) throws ExcepcionDAO {
        PolizaContratVO  polizaContratVo = new PolizaContratVO();
        try {
            StringBuilder sql = new StringBuilder();           
            sql.append(" select p.pcc_codigo ,  nvl(sum(olq.ota_der_expl_mes),0) as DE, nvl(sum (olq.ota_gas_admin),0) as GA from sii_oficio_liquidacion ofi" );
            sql.append(" inner join sii_solicitud_autoriz  s on ofi.sau_codigo=s.sau_codigo " );
            sql.append(" inner join sii_resolucion_autoriz ra on s.sau_codigo = ra.sau_codigo " );
            sql.append(" inner join sii_novedad n on s.sau_codigo = n.sau_codigo " );
            sql.append(" inner join sii_otrosi ot on ot.osi_codigo = n.osi_codigo " );
            sql.append(" inner join sii_contrato c on n.con_codigo = c.con_codigo " );
            sql.append(" inner join sii_ofic_liq_tipo_apuesta olq on olq.oli_codigo = ofi.oli_codigo " );
            sql.append(" left join sii_poliza_contrat p on p.osi_codigo = ot.osi_codigo " );
            sql.append(" where p.pcc_codigo = #codigo and olq.ota_indicador_liq ='M'  group by p.pcc_codigo");
            
            Query query = manager.createNativeQuery(sql.toString());        
            query.setParameter("codigo", codigo);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {                
                for (Object[] object : results) {
                    polizaContratVo.setPccCodigo(((BigDecimal) object[0]).longValue());
                    polizaContratVo.setValorDe((BigDecimal) object[1]);
                    polizaContratVo.setValorGa((BigDecimal) object[2]);
                }
            }
                
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return polizaContratVo;
    }
    
    
    
}
