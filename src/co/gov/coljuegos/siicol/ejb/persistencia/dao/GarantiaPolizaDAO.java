package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGarantiaPoliza;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

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
public class GarantiaPolizaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public GarantiaPolizaDAO() {
        recursos = new Recursos();
    }

    public SiiGarantiaPoliza insertarGarantiaPoliza(SiiGarantiaPoliza garantiaPoliza) throws ExcepcionDAO {
        try {
            manager.persist(garantiaPoliza);
            manager.flush();
            return garantiaPoliza;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "GarantiaPolizaDAO");
        }

    }

    public SiiGarantiaPoliza actualizarGarantiaPoliza(SiiGarantiaPoliza garantiaPoliza) throws ExcepcionDAO {
        try {
            manager.merge(garantiaPoliza);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "GarantiaPolizaDAO");
        }
        return garantiaPoliza;
    }


    public SiiGarantiaPoliza buscarGarantiaPolizaPorCodigo(Long cpoCodigo) throws ExcepcionDAO {
        SiiGarantiaPoliza garantia = null;
        try {
            garantia = (SiiGarantiaPoliza) manager.find(SiiGarantiaPoliza.class, cpoCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "GarantiaPolizaDAO");
        }
        return garantia;
    }

    public List<SiiGarantiaPoliza> buscarGarantiaPolizaPorPolizaContrat(Long pccCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiGarantiaPoliza o JOIN o.siiPolizaContrat pc ");
            sql.append(" WHERE pc.pccCodigo = :pccCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pccCodigo", pccCodigo);
            return query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "GarantiaPolizaDAO");
        }
    }
    
    public List<SiiGarantiaPoliza> buscarGarantiasUltimaPolizaXContratoXEstado(Long idContrato, long codigoEstadoPoliza) throws ExcepcionDAO {
        List<SiiGarantiaPoliza> listaSiiPolizaContrat = null;
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT garPol FROM SiiGarantiaPoliza garPol");
            sql.append(" INNER JOIN garPol.siiPolizaContrat pcc");
            sql.append(" WHERE pcc.siiContrato.conCodigo =:idContrato");
            sql.append(" AND pcc.siiEstadoPolizaCont.epoCodigo = :codigoEstadoPoliza");
            sql.append(" ORDER BY pcc.pccFechaAprobac");
            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("idContrato", idContrato);
            consulta.setParameter("codigoEstadoPoliza", codigoEstadoPoliza);

            listaSiiPolizaContrat = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiPolizaContrat;
    }
    
    public List<SiiGarantiaPoliza> buscarGarantiasUltimaPolizaXOtrosiContratoXEstado(Long idContrato, long codigoEstadoPoliza) throws ExcepcionDAO {
        List<SiiGarantiaPoliza> listaSiiPolizaContrat = null;
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT garPol FROM SiiGarantiaPoliza garPol");
            sql.append(" INNER JOIN garPol.siiPolizaContrat pcc");
            sql.append(" INNER JOIN pcc.siiOtrosi osi");
            sql.append(" INNER JOIN osi.siiNovedadList nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" WHERE con.conCodigo =:idContrato");
            sql.append(" AND pcc.siiEstadoPolizaCont.epoCodigo = :codigoEstadoPoliza");
            sql.append(" ORDER BY pcc.pccFechaAprobac");
            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("idContrato", idContrato);
            consulta.setParameter("codigoEstadoPoliza", codigoEstadoPoliza);

            listaSiiPolizaContrat = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiPolizaContrat;
    }

    /**
     *Metodo encargado de verificar si la poliza del contrato tiene garantias vencidas
     * @Author David Tafur
     * @param pccCodigo
     * @return
     * @throws ExcepcionDAO
     */
    public boolean verificarGarantiaPolizaVencida(Long pccCodigo) throws ExcepcionDAO {
        boolean tieneGarPolizVencida = false;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiGarantiaPoliza o JOIN o.siiPolizaContrat pc ");
            sql.append(" WHERE pc.pccCodigo = :pccCodigo");
            sql.append(" AND o.gpoVigenciaHasta < CURRENT_DATE");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pccCodigo", pccCodigo);

            List<SiiGarantiaPoliza> listaGarantiaPoliza = new ArrayList<SiiGarantiaPoliza>();
            listaGarantiaPoliza = query.getResultList();

            if (listaGarantiaPoliza != null && listaGarantiaPoliza.size() > 0) {
                tieneGarPolizVencida = true;
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "GarantiaPolizaDAO");
        }
        return tieneGarPolizVencida;
    }

}

