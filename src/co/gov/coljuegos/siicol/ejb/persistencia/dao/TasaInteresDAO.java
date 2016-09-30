/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: CARLOS YESID ARCINIEGAS BARÓN - CYAB
 * FECHA	: 2016-02-09
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;


import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaIntSuperban;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTasaInteres;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class TasaInteresDAO extends AbstractDAO<Long, SiiTasaInteres>{
    public TasaInteresDAO() {
        super(SiiTasaInteres.class);
    }
    
    public SiiTasaInteres consultarTasaIntXFecha(Date fecha,String ttiAbreviatura) throws ExcepcionDAO {
        SiiTasaInteres siiTasaInteres = new SiiTasaInteres();
        List<SiiTasaInteres>  listSiiTasaInteres = new ArrayList();
        System.out.println(fecha);   
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("Select u FROM SiiTasaInteres u  where  ");
            sql.append(" :fecha between u.taiFechaDesde and u.taiFechaHasta  and u.siiTipoTasaInteres.ttiAbreviatura =:ttiAbreviatura " );
            sql.append(" and taiActivo='S'  order by u.taiCodigo desc ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("fecha", fecha);
            query.setParameter("ttiAbreviatura", ttiAbreviatura);
            listSiiTasaInteres =  query.getResultList();
            if(listSiiTasaInteres.size()>0)
                return listSiiTasaInteres.get(0);
            else 
                 return siiTasaInteres; 
       
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TasaIntSuperbanDAO");
        }
    }
}
