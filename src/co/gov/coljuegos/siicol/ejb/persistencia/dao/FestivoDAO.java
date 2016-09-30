/* 
 * SISTEMA	: SIICOL
 * MÓDULO	: RYT
 * AUTOR	: Mónica Pabón
 * FECHA	: 12-06-2014
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiFestivo;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;

import java.math.BigDecimal;

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
public class FestivoDAO {    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public FestivoDAO() {
        recursos = new Recursos();
    }
    
    public Date buscarSiiFestivo(Date pFecha ) throws ExcepcionDAO {
        Date siiFestivo = null;
       
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiFestivo o WHERE o.fesFecha=:pFecha");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pFecha", Utilidades.truncDate(pFecha));
            List<SiiFestivo> listaFestivo = query.getResultList();
            if (listaFestivo.size() > 0) {
                siiFestivo = listaFestivo.get(0).getFesFecha();
            }
            return siiFestivo;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "FestivoDAO");
        }

    }

    /**
     * @param fechaInicial
     * @param fechaFinal
     * @return el numero de dias festivos entre las fechas dadas sin contar sabados ni domingos.
     * @throws ExcepcionDAO
     */
    public int diasFestivosEntre(Date fechaInicial, Date fechaFinal) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT COUNT(fes_fecha)\n" + 
            "FROM sii_festivo\n" + 
            "WHERE fes_fecha BETWEEN #fechaInicial AND #fechaFinal\n" + 
            "AND TO_CHAR( fes_fecha,'D') NOT IN (7,1)");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("fechaInicial", Utilidades.truncDate(fechaInicial));
            query.setParameter("fechaFinal", Utilidades.truncDate(fechaFinal));
            BigDecimal x = (BigDecimal) query.getSingleResult();
            return x.intValue();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "FestivoDAO");
        }
    }
}
