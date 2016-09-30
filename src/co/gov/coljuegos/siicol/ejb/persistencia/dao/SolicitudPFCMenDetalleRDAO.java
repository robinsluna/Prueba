/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Pac y Tesorería
 * AUTOR	: Walter Becerra
 * FECHA	: 27-12-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolPfcMensDetRub;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiSolicitudPfcMens;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class SolicitudPFCMenDetalleRDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    
    public SolicitudPFCMenDetalleRDAO() {
        recursos = new Recursos();
    }
    
    public SiiSolPfcMensDetRub buscarSolicitudPfcMensDettalleRPorId(Long idSolicitudPfcMenDetalle) throws ExcepcionDAO{
        SiiSolPfcMensDetRub siiSolPfcMensDetRubRetorno = null;
        try{
            siiSolPfcMensDetRubRetorno = (SiiSolPfcMensDetRub) manager.find(SiiSolPfcMensDetRub.class, idSolicitudPfcMenDetalle);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"SolicitudEstMercadoDAO");            
        }
        return siiSolPfcMensDetRubRetorno;
    }
    
    public SiiSolPfcMensDetRub insertarSolicPfcMenDetalleR(SiiSolPfcMensDetRub siiSolPfcMensDetRub) throws ExcepcionDAO {
        try {
            manager.persist(siiSolPfcMensDetRub);                                                            //La guarda en el almacen
            manager.flush();                                                                                 //Pasa a la Bd
            return siiSolPfcMensDetRub;                                                                      //Retorna la entidad

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"SolicitudPFCMenDetalleRDAO");
        }
    }
    
    public List<SiiSolPfcMensDetRub> buscarTodaSolicitudPfcMensualDettaleXIdSpf(Long idSpf) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT solPfcMenDet FROM SiiSolPfcMensDetRub solPfcMenDet");
            sql.append(" WHERE  solPfcMenDet.siiSolicitudPfcMens.spfCodigo = :idSolicitudPfcMensual ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idSolicitudPfcMensual", idSpf);
            List<SiiSolPfcMensDetRub> listaSolicPfcm = query.getResultList();
            
            return listaSolicPfcm;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "SolicitudPfcMensualDAO");
        }
    }
    
    
}
