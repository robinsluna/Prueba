/*
 * SISTEMA	: SIICOL
 * MÓDULO	: RECAUDO Y TRANSFERENCIA
 * AUTOR	: Mónica Pabón
 * FECHA	: 14-03-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDistrib;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiRp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.DetalleDistribucionVO;

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
public class DetalleDistribDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public DetalleDistribDAO() {
        recursos = new Recursos();
       
    }
    
    public SiiDetalleDistrib buscarPorCodigoDetalleDistrib(Long idCodigoDetalleDistribu) throws ExcepcionDAO {
        SiiDetalleDistrib retorno = null;
        try {
            retorno = (SiiDetalleDistrib) manager.find(SiiDetalleDistrib.class, idCodigoDetalleDistribu);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleDistribDAO");
        }
        return retorno;

    }
    
    public SiiDetalleDistrib insertarSiiDetalleDistrib(SiiDetalleDistrib detalleDistri) throws ExcepcionDAO {
        try {
            manager.persist(detalleDistri); 
            manager.flush(); 
            return detalleDistri; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DetalleDistribDAO");
        }
    }
    
    public List<SiiDetalleDistrib> buscarDetalleDistribPorIdDistribucion(Long idDistriMes) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT det FROM SiiDetalleDistrib det INNER JOIN det.siiDistribucionMes dist WHERE dist.dmeCodigo = :idDistriMes");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idDistriMes", idDistriMes);
            List<SiiDetalleDistrib> listaDet = query.getResultList();
            return listaDet;
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DetalleDistribDAO");
        }
    }
    
    public List<DetalleDistribucionVO> buscarDetalleDistribucionPorId(Long idDistriMes) throws ExcepcionDAO {
        List<DetalleDistribucionVO> listaDet = new ArrayList();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select distinct ub2.ubi_nombre, Ub.Ubi_Nombre,ub2.ubi_codigo,Ub.Ubi_Codigo,Cc.Ccu_Abreviatura,Cc.Ccu_Tipo, " );
            sql.append(" Dd.Ddi_Valor_Rec,Dd.Ddi_Valor_Prop,Dd.Ddi_Valor_Todos,Dd.Ddi_Valor_Detod  " );
            sql.append(" from Sii_Detalle_Distrib dd");
            sql.append(" Inner Join sii_ente_territorial et on (dd.eti_Codigo = et.eti_codigo)");
            sql.append(" Inner Join sii_ubicacion ub on (et.ubi_codigo = ub.ubi_codigo)");
            sql.append(" Inner Join sii_ubicacion ub2 on (ub.ubi_codigo_padre = ub2.ubi_codigo)");
            sql.append(" Inner Join sii_detalle_declaracion dde on (dd.dme_codigo = dde.dme_codigo)");
            sql.append(" Inner Join sii_cuota_operador co on (dde.cop_codigo = co.cop_codigo)");
            sql.append(" Inner Join sii_concepto_cuota cc on (co.ccu_codigo = cc.ccu_codigo)");
            sql.append(" where Dd.Dme_Codigo = #idDistriMes");
            sql.append(" order by Ub2.Ubi_Nombre,Ub.Ubi_Nombre");
            Query query = manager.createNativeQuery(sql.toString());        
            query.setParameter("idDistriMes", idDistriMes);
            List<Object[]> results = query.getResultList();
            if (results != null && !results.isEmpty()) {                
                for (Object[] object : results) {
                    DetalleDistribucionVO vo = new DetalleDistribucionVO();
                    vo.setDepto((String) object[0]);
                    vo.setMunicipio((String) object[1]);
                    vo.setCodDepto((String) object[2]);
                    vo.setCodMunicipio((String) object[3]);
                    vo.setConcepto((String) object[4]);
                    vo.setTipoConcepto((String) object[5]);
                    vo.setValorRecaudo((BigDecimal) object[6]);
                    vo.setValorPropio((BigDecimal) object[7]);
                    vo.setValorTodos((BigDecimal) object[8]);
                    vo.setValorDeTodos((BigDecimal) object[9]);
                    listaDet.add(vo);
                }
            }
             
            return listaDet;
        } catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"DetalleDistribDAO");
        }
    }
}
