/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Mónica Pabón
 * FECHA	: 01-07-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiVentasMet;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReporteVentas;

import co.gov.coljuegos.siicol.ejb.vo.LiquidaMetOnLineVO;

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
public class VentasMetDAO extends GenericDAO<SiiVentasMet>{

    public VentasMetDAO() {
        super(SiiVentasMet.class);
    }

    /**
     *
     * @param ventasMet
     * @return
     * @throws ExcepcionDAO
     */
    public SiiVentasMet insertarSiiVentasMet(SiiVentasMet ventasMet) throws ExcepcionDAO {
        try {
            em.persist(ventasMet);
            em.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return ventasMet;
    }

    /**
     *Metodo encargado de hacer la consulta de ventas registradas por met para un mes determinado
     * @author David Tafur
     * @param codMes
     * @param codMet
     * @return
     * @throws ExcepcionDAO
     */
    public SiiVentasMet consultarVentasMetPorMesYMet(Integer codMes, long codMet) throws ExcepcionDAO {
        SiiVentasMet siiVentasMet = new SiiVentasMet();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT svm FROM SiiVentasMet svm");
            sql.append(" INNER JOIN svm.siiMet met");
            sql.append(" INNER JOIN svm.siiMes mes");
            sql.append(" WHERE met.metCodigo =:codigoMet");
            sql.append(" AND mes.mesCodigo =:codigoMes");

            Query consulta = em.createQuery(sql.toString());
            consulta.setParameter("codigoMet", codMet);
            consulta.setParameter("codigoMes", codMes);

            List<SiiVentasMet> listaVentasMet = new ArrayList<SiiVentasMet>();
            listaVentasMet = consulta.getResultList();

            if (!listaVentasMet.isEmpty()) {
                siiVentasMet = listaVentasMet.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiVentasMet;
    }
    /**
        *Metodo encargado de obtener las ventas reportadas por met OnLine
        * @Author Mónica Pabón
        * @param metCodigo
        * @param mesCodigo
        * @param vigencia
        * @throws ExcepcionDAO
        */
       public LiquidaMetOnLineVO buscarVentasMet(Long metCodigo,Integer mesCodigo, Integer vigencia,SiiReporteVentas reporteVtasVo ) throws ExcepcionDAO {
            LiquidaMetOnLineVO vo = null;
            try{
                StringBuilder sql = new StringBuilder();                     
                sql.append(" select ve.vme_codigo,NVL(ve.vme_valor_inicial,0),NVL(ve.vme_valor_modif,0)," );
                sql.append(" NVL(ve.vme_valor_correc,0),NVL(ve.vme_valor_consulta,0) ");
                sql.append(" from sii_ventas_met ve");                
                sql.append(" where ve.Met_Codigo = #metCodigo and ve.rve_codigo = #codigoReporteVtas");
                
                
                Query query = em.createNativeQuery(sql.toString());
                
                query.setParameter("metCodigo",metCodigo);
                query.setParameter("mesCodigo",mesCodigo);
                query.setParameter("vigencia",vigencia);
				query.setParameter("codigoReporteVtas",reporteVtasVo.getRveCodigo());
                
                List<Object[]> results = query.getResultList();
                for(Object[] object : results){
                    vo = new LiquidaMetOnLineVO();
                    vo.setVmeCodigo(((BigDecimal) object[0]).longValue());
                    //vo.setInvCodigo(((BigDecimal) object[1]).longValue());
                    vo.setValorInicialVentas((BigDecimal) object[1]);
                    vo.setValorModifVentas((BigDecimal) object[2]);
                    vo.setValorCorrecVentas((BigDecimal) object[3]);
                    vo.setValorConsulta((BigDecimal) object[4]);
                    //vo.setPorcentaje(Integer.parseInt(((BigDecimal) object[5]).toString()));                                  
                }
                
            } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
            return vo;
        }
    
    
    public SiiVentasMet buscarVentasMetPorVigenciaMesNuc(Integer vigencia, Integer mesCodigo, String nuc, Long rveCodigo) throws ExcepcionDAO{
        SiiVentasMet siiVentasMet = null;
        try{
            List<SiiVentasMet> listaSiiVentasMet = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT vme FROM SiiVentasMet vme");
            sql.append(" INNER JOIN vme.siiMet met");
            sql.append(" INNER JOIN vme.siiReporteVentas rev");
            sql.append(" WHERE vme.vmeVigencia = :vigencia");
            sql.append(" AND vme.siiMes.mesCodigo = :mesCodigo");
            sql.append(" AND met.metUid = :nuc");
            sql.append(" AND rev.rveCodigo = :rveCodigo");
            sql.append(" AND vme.siiReporteVentas.rveCodigo = :rveCodigo");
            sql.append(" ORDER BY vme.vmeCodigo ASC");
            Query query = em.createQuery(sql.toString());
            query.setParameter("vigencia", vigencia);
            query.setParameter("mesCodigo", mesCodigo);
            query.setParameter("nuc", nuc);
            query.setParameter("rveCodigo", rveCodigo);
            
            listaSiiVentasMet = query.getResultList();
            if(listaSiiVentasMet != null && !listaSiiVentasMet.isEmpty()){
                siiVentasMet = listaSiiVentasMet.get(0);
            }
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return siiVentasMet;
    }
    
    public List<SiiVentasMet> buscarVentasMetPorReporteVentas(Long idReporteVentas) throws ExcepcionDAO{
        List<SiiVentasMet> listaSiiVentasMet = null;
        try{
            listaSiiVentasMet = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT vme FROM SiiVentasMet vme");
            sql.append(" WHERE vme.siiReporteVentas.rveCodigo = :idReporteVentas");
            Query query = em.createQuery(sql.toString());
            query.setParameter("idReporteVentas", idReporteVentas);
            
            listaSiiVentasMet = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return listaSiiVentasMet;
    }
    
    public SiiVentasMet actualizarSiiVentasMet(SiiVentasMet ventasMet) throws ExcepcionDAO {
         try {
             em.merge(ventasMet); 
             em.flush(); 

         } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
         return ventasMet;
     }
    
    public List<SiiVentasMet> buscarVentasMetPorReporteVentasYNuc(Long idReporteVentas, String nuc) throws ExcepcionDAO{
        List<SiiVentasMet> listaSiiVentasMet = null;
        try{
            listaSiiVentasMet = new ArrayList();           
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT vme FROM SiiVentasMet vme");            
            sql.append(" WHERE vme.siiReporteVentas.rveCodigo = :idReporteVentas");
            sql.append(" AND vme.siiMet.metUid = :nuc");
            Query query = em.createQuery(sql.toString());
            query.setParameter("idReporteVentas", idReporteVentas);
            query.setParameter("nuc", nuc);
            
            listaSiiVentasMet = query.getResultList();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return listaSiiVentasMet;
    }
    
    public SiiVentasMet buscarVentasMetPorId (Long idVentasMet) throws ExcepcionDAO{
        SiiVentasMet siiVentasMet = null;
        try{
            siiVentasMet = em.find(SiiVentasMet.class, idVentasMet);
        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiVentasMet;
    }
}
