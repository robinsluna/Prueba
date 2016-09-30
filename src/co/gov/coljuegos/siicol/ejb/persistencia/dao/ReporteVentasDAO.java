/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y Transferencia
 * AUTOR	: Mónica Pabón
 * FECHA	: 19-08-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReporteVentas;
import co.gov.coljuegos.siicol.ejb.vo.ContratoVO;
import co.gov.coljuegos.siicol.ejb.vo.ReporteVentasVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ReporteVentasDAO extends GenericDAO<SiiReporteVentas>{
    
    public ReporteVentasDAO() {
        super(SiiReporteVentas.class);
    }
    /**
     * Obtiene el parámetro del reporte de ventas.
     * @param mes - mes del reporte.
     * @param vigencia - vigencia del reporte.
     * @return siiReporteVentas
     */
    
    public ReporteVentasVO buscarReporteVentasPorMesYVigencia(Integer mes, Integer vigencia) throws ExcepcionDAO {
        ReporteVentasVO reporteVentasVo = null;        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select Rv.Rve_Tipo_Reporte,Rv.Con_Codigo" );
            sql.append(" from Sii_Reporte_Ventas rv");            
            sql.append(" where Rv.Mes_Codigo = #mes and Rv.Rve_Vigencia=#vigencia");
           
            Query query = em.createNativeQuery(sql.toString());
            
            query.setParameter("mes",mes);
            query.setParameter("vigencia",vigencia);
			       
            
            List<Object[]> results = query.getResultList();
            for(Object[] object : results){
		reporteVentasVo = new ReporteVentasVO(); 
                reporteVentasVo.setRveTipoReporte((String) object[0]);
                if(object[1]!= null){
                    ContratoVO contrato = new ContratoVO();
                    contrato.setConCodigo(((BigDecimal) object[1]).longValue());
                    reporteVentasVo.setContratoVo(contrato);
                }      
            }
        } catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoContratoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstadoContratoDAO");

        }
        return reporteVentasVo;       
    }
    
    public SiiReporteVentas buscarReporteVentasPorCodigo(Long idCodigoReporteVtas) throws ExcepcionDAO {
        SiiReporteVentas retorno = null;
        try {
            retorno = (SiiReporteVentas) em.find(SiiReporteVentas.class, idCodigoReporteVtas);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReporteVentasDAO");
        }
        return retorno;

    }
    
    public SiiReporteVentas buscarReporteVentasPorVigenciaMesContratoNitTipo(Integer vigencia, Integer mesCodigo, String contrato, String nit, String tipoReporte) throws ExcepcionDAO{
        SiiReporteVentas siiReporteVentas = null;
        //tipoReporte += "%";
        try{
            List<SiiReporteVentas> listaSiiReporteVentas = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rve FROM SiiReporteVentas rve");
            sql.append(" INNER JOIN rve.siiContrato con");
            sql.append(" INNER JOIN con.siiOperador ope");
            sql.append(" INNER JOIN ope.siiPersona per");
            sql.append(" WHERE con.conNumero = :contrato");
            sql.append(" AND per.perNumIdentificacion = :nit");
            sql.append(" AND rve.rveVigencia = :vigencia");
            sql.append(" AND rve.siiMes.mesCodigo = :mesCodigo");
            sql.append(" AND rve.rveTipoReporte = :tipoReporte");
            
            Query query = em.createQuery(sql.toString());
            query.setParameter("contrato", contrato);
            query.setParameter("nit", nit);
            query.setParameter("vigencia", vigencia);
            query.setParameter("mesCodigo", mesCodigo);
            query.setParameter("tipoReporte", tipoReporte);
            
            listaSiiReporteVentas = query.getResultList();
            if(listaSiiReporteVentas != null && !listaSiiReporteVentas.isEmpty()){
                siiReporteVentas = listaSiiReporteVentas.get(0);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return siiReporteVentas;
    }
	
	/**
     * Obtiene el parámetro del reporte de ventas.
     * @param mes - mes del reporte.
     * @param vigencia - vigencia del reporte.
     * @return siiReporteVentas
     */
    
        public SiiReporteVentas buscarReporteVentasPorMesVigenciaTipoReporte(Integer mes, Integer vigencia, String tipoReporte, Long codigoContrato) throws ExcepcionDAO {
        SiiReporteVentas siiReporteVentas = null;        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select rv from SiiReporteVentas rv " );
            sql.append(" Inner Join rv.siiMes mes");
            sql.append (" Inner Join rv.siiContrato con");
            sql.append(" where mes.mesCodigo=:mes and rv.rveVigencia =:vigencia");            
            sql.append(" and Rv.rveTipoReporte=:tipoReporte and con.conCodigo =:codigoContrato");
           
            Query query = em.createQuery(sql.toString());
            
            query.setParameter("mes",mes);
            query.setParameter("vigencia",vigencia);
			query.setParameter("tipoReporte",tipoReporte);
			query.setParameter("codigoContrato",codigoContrato);
			             
            
            List<SiiReporteVentas> listaReporte = new ArrayList<SiiReporteVentas>();
            listaReporte = query.getResultList();

            if (!listaReporte.isEmpty()) {
                siiReporteVentas = listaReporte.get(0);
            }

        } catch (PersistenceException pe) {

            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoContratoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstadoContratoDAO");

        }
        return siiReporteVentas;       
    }
        
    /**
    * Obtiene el parámetro del reporte de ventas.
    * @param mes - mes del reporte.
    * @param vigencia - vigencia del reporte.
    * @return List<SiiReporteVentas>
    */
    
    public List<SiiReporteVentas> buscarUltimoReporteVentasPorMesVigenciaTipoReporte(Integer mes, Integer vigencia, String tipoReporte, Long codigoContrato) throws ExcepcionDAO {
        List<SiiReporteVentas> listaReporte = new ArrayList<SiiReporteVentas>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select rv from SiiReporteVentas rv " );
            sql.append(" Inner Join rv.siiMes mes");
            sql.append (" Inner Join rv.siiContrato con");
            sql.append(" where mes.mesCodigo=:mes and rv.rveVigencia =:vigencia");            
            sql.append(" and Rv.rveTipoReporte=:tipoReporte and con.conCodigo =:codigoContrato order by rv.rveCodigo desc");
           
            Query query = em.createQuery(sql.toString());
            
            query.setParameter("mes",mes);
            query.setParameter("vigencia",vigencia);
                        query.setParameter("tipoReporte",tipoReporte);
                        query.setParameter("codigoContrato",codigoContrato);
                                     
            
            
            listaReporte = query.getResultList();
    
           
        } catch (PersistenceException pe) {
    
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoContratoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstadoContratoDAO");
    
        }
        return listaReporte;       
    }
    
    public List<SiiReporteVentas> buscarReportesVentasPorMovimiento(Long movSolicitud) throws ExcepcionDAO {
        List<SiiReporteVentas> listaReporte = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT rve FROM SiiReporteVentas rve " );
            sql.append(" WHERE rve.rveMovimiento = :movSolicitud");
           
            Query query = em.createQuery(sql.toString());
    
            query.setParameter("movSolicitud",movSolicitud);
                                     
            listaReporte = query.getResultList();
           
        } catch (PersistenceException pe) {
    
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstadoContratoDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), "EstadoContratoDAO");
    
        }
        return listaReporte;       
    }
    
}
