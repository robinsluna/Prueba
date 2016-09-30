package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstudioPrevio;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiProveedor;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;

import co.gov.coljuegos.siicol.ejb.vo.ProveedorVO;

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

public class ProveedorDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ProveedorDAO() {
        recursos = new Recursos();
    }

    public SiiProveedor buscarProveedorPorId(Long idProveedor) throws ExcepcionDAO {
        SiiProveedor localProveedor = null;
        try {
            localProveedor = (SiiProveedor) manager.find(SiiProveedor.class, idProveedor);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorDAO");
        }
        return localProveedor;

    }


    public SiiProveedor insertarProveedor(SiiProveedor proveedor) throws ExcepcionDAO {
        try {
            manager.persist(proveedor);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorDAO");
        }
        return proveedor;
    }

    public SiiProveedor actualizarProveedor(SiiProveedor proveedor) throws ExcepcionDAO {
        try {
            manager.merge(proveedor);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorDAO");
        }
        return proveedor;
    }

    public void eliminarProveedor(Long idProveedor) throws ExcepcionDAO {
        SiiProveedor localProveedor;
        try {
            localProveedor = (SiiProveedor) manager.find(SiiProveedor.class, idProveedor);
            manager.remove(localProveedor);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorDAO");
        }
    }

    public List<SiiProveedor> buscarTodoProveedor() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();            
            sql.append("select o from SiiProveedor o order by o.siiPersona.perJurNombreLargo");           
           
            Query query = manager.createQuery(sql.toString());           
            List<SiiProveedor> listaProveedor = query.getResultList();
            return listaProveedor;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorDAO");
        }
    }

    public List<SiiProveedor> buscarProveedorPorNombre(String nombre) throws ExcepcionDAO {
        List<SiiProveedor> listaProveedor = null;
        try {
            StringBuilder sql = new StringBuilder();
            
            sql.append("SELECT pro FROM SiiProveedor pro INNER JOIN pro.siiPersona per");           
            sql.append(" WHERE UPPER(per.perJurNombreLargo) like :nombre or UPPER(per.perJurNombreCorto) like :nombre");
            sql.append(" or UPPER(per.perPrimerNombre) like :nombre or UPPER(per.perSegundoNombre) like :nombre");
            sql.append(" or UPPER(per.perPrimerApellido) like :nombre  or UPPER(per.perSegundoApellido) like :nombre");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("nombre", "%" + nombre + "%"); //nombre es una variable String que llega como parámetro
            listaProveedor = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return listaProveedor;
    }

    public List<SiiProveedor> buscarProveedorPorIdentificacion(String numeroId) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pro FROM SiiProveedor pro");
            sql.append(" INNER JOIN pro.siiPersona per");
            sql.append(" WHERE per.perNumIdentificacion like :numeroId");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numeroId",
                               "%" + numeroId + "%"); //numeroId es una variable String que llega como parámetro
            List<SiiProveedor> listaProveedor = query.getResultList();
            return listaProveedor;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorDAO");
        }
    }

    public SiiProveedor buscarProveedorPorPersona(PersonaVO personaVo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pro FROM SiiProveedor pro");
            sql.append(" INNER JOIN pro.siiPersona per INNER JOIN per.siiTipoIdentificacion1 tid");
            sql.append(" WHERE per.perNumIdentificacion = :numeroId AND tid.tidCodigo = :tipoIdentificacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numeroId",
                               personaVo.getPerNumIdentificacion()); //numeroId es una variable String que llega como parámetro
            query.setParameter("tipoIdentificacion", personaVo.getTipoIdentificacionVo().getTidCodigo());
            List<SiiProveedor> listaProveedor = query.getResultList();
            if(listaProveedor != null && listaProveedor.size()>0){
                return listaProveedor.get(0);
            }
            else{
                return null;
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "ProveedorDAO");
        }
    }
    public List<ProveedorVO> buscarProveedoresCotizacion(long idproceso) throws ExcepcionDAO {
        List<ProveedorVO> listaProvedores = new ArrayList<ProveedorVO>();
        try {
            StringBuilder sql = new StringBuilder();  
            sql.append (" select pro.pro_codigo,pro.pro_ejecutivo_cuenta,Per.Per_Jur_Nombre_Largo,per.per_direccion,Per.Per_Telefono,Per.Per_Codigo");
            sql.append (" from sii_proveedor pro Inner Join sii_persona per on (pro.per_codigo = per.per_codigo)" );
            sql.append (" Inner Join sii_cotizacion_estudio cot on(pro.pro_codigo = cot.pro_codigo)"); 
            sql.append (" Inner Join sii_estudio_mercado em on (cot.eme_codigo = em.eme_codigo and em.prc_codigo = #idproceso)");            
             
            Query query = manager.createNativeQuery(sql.toString()); 
            query.setParameter("idproceso",idproceso);
            
            List<Object[]> results = query.getResultList();           
            
            if (results != null && !results.isEmpty()) {                
                    for (Object[] object : results) {
                        ProveedorVO unProveedor = new ProveedorVO();
                        PersonaVO personaVo = new PersonaVO();
                        unProveedor.setProCodigo(((BigDecimal) object[0]).longValue());
                        unProveedor.setProEjecutivoCuenta((String) object[1]);
                        personaVo.setPerJurNombreLargo((String) object[2]);
                        personaVo.setPerDireccion((String) object[3]);
                        personaVo.setPerTelefono((String) object[4]);
                        personaVo.setPerCodigo(((BigDecimal) object[5]).longValue());
                        unProveedor.setPersonaVo(personaVo);
                        listaProvedores.add(unProveedor);
                    }
            }
                        
        } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError, "ProveedorDAO");
        }
        return listaProvedores;
    }
}
