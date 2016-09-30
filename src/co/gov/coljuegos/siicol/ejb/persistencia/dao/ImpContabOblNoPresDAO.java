package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumEstadoImputacionObligaNoPresupuestal;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaContTipoDocCont;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentasContables;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiImpContabOblNoPres;
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
public class ImpContabOblNoPresDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    
    public ImpContabOblNoPresDAO() {
        recursos = new Recursos();
    }
    
    public SiiImpContabOblNoPres buscarImpContabOblNoPresPorCodigo(Long idImpContabOblNoPres) throws ExcepcionDAO{
        SiiImpContabOblNoPres retorno = null;
        try{
            retorno = manager.find(SiiImpContabOblNoPres.class, idImpContabOblNoPres);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"ImpContabOblNoPresDAO");
        }
        return retorno;
    }
    
    public SiiImpContabOblNoPres insertarSiiImpContabOblNoPres(SiiImpContabOblNoPres siiImpContabOblNoPres) throws ExcepcionDAO {
        try {
            manager.persist(siiImpContabOblNoPres); 
            manager.flush(); 
            return siiImpContabOblNoPres; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ImpContabOblNoPresDAO");
        }
    }
    
    public SiiCuentasContables buscarCuentaContablePorDocumentoYConcepto(String tipoDoc,String concepto ) throws ExcepcionDAO {
        SiiCuentasContables siiCuentaContable= null;
        List<SiiCuentasContables> listaSiiCuentasContable = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  cc  FROM SiiCuentasContables cc  ");
            sql.append(" Inner Join  cc.siiImputacionContableList ic");
            sql.append(" Inner Join  ic.siiDocumentoContable dc");
            sql.append(" Inner Join dc.siiTipoDocContable td ");
            sql.append(" where td.tdcCodigo=:tipoDoc and dc.dcoConcepto=:concepto");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tipoDoc", tipoDoc);
            query.setParameter("concepto", concepto);
                        
            listaSiiCuentasContable = query.getResultList();
            
            if (listaSiiCuentasContable != null && !listaSiiCuentasContable.isEmpty()) {
                siiCuentaContable = listaSiiCuentasContable.get(0);
            }

            return siiCuentaContable;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch(Exception ex){
                ex.printStackTrace();
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"ImpContabOblNoPresDAO");
            }
    }
    
    public List<SiiCuentaContTipoDocCont> buscarCuentaContablePorDocumentoYFuente(String tipoDoc,String fuente ) throws ExcepcionDAO {
        List<SiiCuentaContTipoDocCont> listaSiiCuentasContable = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  cc  FROM SiiCuentaContTipoDocCont cc  ");
            sql.append(" Inner Join  cc.siiTipoDocContable ic Inner Join cc.siiFuenteFinancContab dc");            
            sql.append(" where ic.tdcCodigo=:tipoDoc and dc.ffcCodigo=:fuente");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tipoDoc", tipoDoc);
            query.setParameter("fuente", fuente);           
            
            listaSiiCuentasContable = query.getResultList();
            
            
            return listaSiiCuentasContable;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch(Exception ex){
                ex.printStackTrace();
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"ImpContabOblNoPresDAO");
            }
    }
    public List<SiiImpContabOblNoPres> buscarImputaContableNoPresPorIdObligacion(Long idObligacionNoPres) throws ExcepcionDAO {
        List<SiiImpContabOblNoPres> listaSiiImpContNp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  o  FROM SiiImpContabOblNoPres o  ");           
            sql.append("where o.siiObligacionNoPresup.onpCodigo=:idObligacionNoPres and o.ionEstado='A'");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idObligacionNoPres", idObligacionNoPres);
            
            listaSiiImpContNp = query.getResultList();
            
            
            return listaSiiImpContNp;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
            } catch(Exception ex){
                ex.printStackTrace();
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"ImpContabOblNoPresDAO");
            }
    }
    
    
    /**
     * Realiza la b&uacute;squeda de los registros de Imputaci&oacute;n Contable de Obligaciones No Presupuestales en estado <i>ACTIVO</i>, asociados a la Obligaci&oacute;n e Imputaci&oacute;n Contable especificadas.
     * @param idObligacionNoPres - ID de la Obligaci&oacute;n No Presupuestal.
     * @param idImputacion - ID de la Imputaci&oacute;n Contable.
     * @return Listado de SiiImpContabOblNoPres.
     * @throws ExcepcionDAO
     */
    public List<SiiImpContabOblNoPres> buscarImputaContableNoPresPorIdObligacionYIdImputacionContable(Long idObligacionNoPres, Long idImputacion) throws ExcepcionDAO 
    {
        return ( this.buscarImputaContableNoPresPorIdObligacionYIdImputacionContable(idObligacionNoPres, idImputacion, EnumEstadoImputacionObligaNoPresupuestal.ACTIVO.getId()) );
    }
    
    
    /**
     * Realiza la b&uacute;squeda de los registros de Imputaci&oacute;n Contable de Obligaciones No Presupuestales asociados a la Obligaci&oacute;n, Imputaci&oacute;n Contable y Estado especificados.
     * @param idObligacionNoPres - ID de la Obligaci&oacute;n No Presupuestal.
     * @param idImputacion - ID de la Imputaci&oacute;n Contable.
     * @param ionEstado - Estado del registro de Imputaci&oacute;n Contable de Obligaci&oacute;n No Presupuestal.
     * @return Listado de SiiImpContabOblNoPres.
     * @throws ExcepcionDAO
     */
    public List<SiiImpContabOblNoPres> buscarImputaContableNoPresPorIdObligacionYIdImputacionContable(Long idObligacionNoPres, Long idImputacion, String ionEstado) throws ExcepcionDAO 
    {
        List<SiiImpContabOblNoPres> listaSiiImpContNp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  o  FROM SiiImpContabOblNoPres o  ");           
            sql.append(" where o.siiObligacionNoPresup.onpCodigo=:idObligacionNoPres and o.siiImputacionContable.imcCodigo =:idImputacion ");
            sql.append(" and o.ionEstado = :ionEstado ");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idObligacionNoPres", idObligacionNoPres);
            query.setParameter("idImputacion", idImputacion);
            query.setParameter("ionEstado", ionEstado);
            
            listaSiiImpContNp = query.getResultList();
            
            
            return listaSiiImpContNp;
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch(Exception ex) {
            ex.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(),"ImpContabOblNoPresDAO");
        }
    }
    
    
    public SiiImpContabOblNoPres actualizarSiiImpContabOblNoPres(SiiImpContabOblNoPres imputacion) throws ExcepcionDAO {
        try {
            manager.merge(imputacion); 
            manager.flush(); 
            return imputacion; 

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ImpContabOblNoPresDAO");
        }
    }
    
    /*public void borrarImpContabOblNoPresPorCodigoObligacion(Long idCodigoObligacionNp) throws ExcepcionDAO {        
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("delete from sii_imp_contab_obl_no_pres where onp_codigo = #idCodigoObligacionNp ");           
                        
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("idCodigoObligacionNp", idCodigoObligacionNp);
            int resultado = query.executeUpdate();
            
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ImpContabOblNoPresDAO");
        }
    }*/
    
    
    
    /**
     * Obtiene el listado de Imputaciones Contables No Presupuestales que se encuentran asociadas a la Imputaci&oacute;n Contable especificada.
     * @param imcCodigo - C&oacute;digo de la Imputaci&oacute;n Contable.
     * @return List of SiiImpContabOblNoPres
     * @throws ExcepcionDAO
     */
    public List<SiiImpContabOblNoPres> buscarImpContabOblNoPresPorIdImputacionContable (Long imcCodigo) throws ExcepcionDAO 
    {
        List<SiiImpContabOblNoPres> listaSiiImpContNp = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  o  FROM SiiImpContabOblNoPres o  ");           
            sql.append(" where o.siiImputacionContable.imcCodigo = :imcCodigo ");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("imcCodigo", imcCodigo);
            
            listaSiiImpContNp = query.getResultList();
            
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } 
        catch(Exception ex){
                ex.printStackTrace();
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + ex.getMessage(), getClass().getSimpleName());
        }
        
        return (listaSiiImpContNp);
    }
}
