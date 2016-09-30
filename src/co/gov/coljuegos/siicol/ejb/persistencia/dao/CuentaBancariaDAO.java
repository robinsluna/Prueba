package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumDecision;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCuentaBancaria;
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
public class CuentaBancariaDAO {
    
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    
    public CuentaBancariaDAO() {
        recursos = new Recursos();
    }
    
    public SiiCuentaBancaria buscarCuentaPorId(Long idCodigoCcuenta) throws ExcepcionDAO {
        SiiCuentaBancaria resultadoCuenta = null;
        try{
            resultadoCuenta = (SiiCuentaBancaria) manager.find(SiiCuentaBancaria.class, idCodigoCcuenta);
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"CuentaBancariaDAO");
        }
        return resultadoCuenta;
    }
    
    public SiiCuentaBancaria insertarCuenta(SiiCuentaBancaria siiCuentaBancaria) throws ExcepcionDAO{
        try{
            manager.persist(siiCuentaBancaria);                                                                                
            manager.flush();                                                                                               
            return siiCuentaBancaria;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"CuentaBancariaDAO");
        }
    }
    
    public SiiCuentaBancaria actualizarCuenta(SiiCuentaBancaria siiCuentaBancaria) throws ExcepcionDAO{
        try{
            manager.merge(siiCuentaBancaria);                                                                                
            manager.flush();                                                                                               
            return siiCuentaBancaria;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"CuentaBancariaDAO");
        }
    }

    
    public void eliminarCuenta(Long idCodigoCuenta) throws ExcepcionDAO {
        try{
            SiiCuentaBancaria siiCuentaBancariaBorrar = (SiiCuentaBancaria) manager.find(SiiCuentaBancaria.class, idCodigoCuenta);
            manager.remove(siiCuentaBancariaBorrar);
            manager.flush();
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"CuentaBancariaDAO");
        }
    }
    
    public List<SiiCuentaBancaria> buscarTodasLasCuentas(String fuenteFinanciacion) throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT solCuenta FROM SiiCuentaBancaria solCuenta WHERE solCuenta.siiFuenteFinancContab.ffcCodigo = :fuenteFinanciacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("fuenteFinanciacion", fuenteFinanciacion);
            List<SiiCuentaBancaria> listaCdp = query.getResultList();
            return listaCdp;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"CuentaBancariaDAO");
        }
    }
    
    public List<SiiCuentaBancaria> buscarTodasLasCuentas() throws ExcepcionDAO{
        try{
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT solCuenta FROM SiiCuentaBancaria solCuenta");
            sql.append(" order by solCuenta.siiBanco.banNombre asc");
            Query query = manager.createQuery(sql.toString());
            List<SiiCuentaBancaria> listaCdp = query.getResultList();
            return listaCdp;
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(),"CuentaBancariaDAO");
        }
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de Cuentas Bancarias <i>ACTIVAS</i> a partir de la Fuente de Financiaci&oacute;n Contable especificada.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @return List of SiiCuentaBancaria
     * @throws ExcepcionDAO
     */
    public List<SiiCuentaBancaria> buscarCuentasPorFuenteFinancContab (String ffcCodigo) throws ExcepcionDAO 
    {
        return (this.buscarCuentasPorFuenteFinancContab(ffcCodigo, true));
    }
    
    
    
    /**
     * Realiza la b&uacute;squeda de Cuentas Bancarias a partir de la Fuente de Financiaci&oacute;n Contable especificada.
     * @param ffcCodigo - C&oacute;digo de la Fuente de Financiaci&oacute;n Contable.
     * @param soloActivas - Flag que determina si s&oacute;lamente deben ser obtenidas las Cuentas Bancarias Activas.
     * @return List of SiiCuentaBancaria
     * @throws ExcepcionDAO
     */
    public List<SiiCuentaBancaria> buscarCuentasPorFuenteFinancContab (String ffcCodigo, boolean soloActivas) throws ExcepcionDAO 
    {
        List<SiiCuentaBancaria> lista = null;
        
        try {
            if (ffcCodigo!=null) {
                StringBuilder sql = new StringBuilder();
                sql.append("SELECT cba FROM SiiCuentaBancaria cba ");
                sql.append("WHERE cba.siiFuenteFinancContab.ffcCodigo = :ffcCodigo ");
                
                if (soloActivas) {
                    sql.append("AND cba.cbaActivo = :cbaActivo ");
                }
                
                sql.append("ORDER BY cba.cbaNumero asc ");
                
                Query query = manager.createQuery(sql.toString());
                query.setParameter("ffcCodigo", ffcCodigo);
                
                if (soloActivas)
                    query.setParameter("cbaActivo", EnumDecision.SI.getId());
                
                
                lista = query.getResultList();
            }
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        
        return (lista);
    }
    
    public SiiCuentaBancaria buscarCtaBanXComentario(String cbaComentario) throws ExcepcionDAO {
            SiiCuentaBancaria siiCuentaBancaria = null;
            try {
                StringBuilder sql = new StringBuilder();
                sql.append(" SELECT cba FROM SiiCuentaBancaria cba WHERE cba.cbaComentario = :cbaComentario");
               // sql.append(" and sal.scbEstado = :estado ");
                Query query = manager.createQuery(sql.toString());
                query.setParameter("cbaComentario", cbaComentario);
                //query.setParameter("estado", "A");
                List<SiiCuentaBancaria> listasiiCuentaBancaria = query.getResultList();
                if (listasiiCuentaBancaria != null && !listasiiCuentaBancaria.isEmpty()) 
                     siiCuentaBancaria=listasiiCuentaBancaria.get(0);
                
            }
            catch (javax.persistence.NoResultException ne) {
                siiCuentaBancaria = null;
            }
            catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
            }
            return siiCuentaBancaria;
        }
    
}
