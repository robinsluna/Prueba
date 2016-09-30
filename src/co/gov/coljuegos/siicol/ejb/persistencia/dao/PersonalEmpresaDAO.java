/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-10-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersonalEmpresa;
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
public class PersonalEmpresaDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public PersonalEmpresaDAO() {
        recursos = new Recursos();
    }

    public SiiPersonalEmpresa buscarPersonalEmpresaPorCodigo(Long idCodigoPersonalEmpresa) throws ExcepcionDAO {
        SiiPersonalEmpresa Retorno = null;
        try {
            Retorno = (SiiPersonalEmpresa) manager.find(SiiPersonalEmpresa.class, idCodigoPersonalEmpresa);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonalEmpresaDAO");
        }
        return Retorno;

    }

    public SiiPersonalEmpresa insertarSiiPersonalEmpresa(SiiPersonalEmpresa siiPersonalEmpresa) throws ExcepcionDAO {
        try {
            manager.persist(siiPersonalEmpresa);
            manager.flush();
            return siiPersonalEmpresa;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonalEmpresaDAO");
        }
    }

    public SiiPersonalEmpresa actualizarSiiPersonalEmpresa(SiiPersonalEmpresa siiPersonalEmpresa) throws ExcepcionDAO {
        try {
            manager.merge(siiPersonalEmpresa);
            manager.flush();
            return siiPersonalEmpresa;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonalEmpresaDAO");
        }
    }

    public void borrarPersonalEmpresa(Long idCodigoPersonalEmpresa) throws ExcepcionDAO {
        SiiPersonalEmpresa personalEmpresaBorrar = null;
        try {
            personalEmpresaBorrar = manager.find(SiiPersonalEmpresa.class, idCodigoPersonalEmpresa);
            manager.remove(personalEmpresaBorrar);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonalEmpresaDAO");
        }
    }


    public List<SiiPersonalEmpresa> buscarTodoSiiPersonalEmpresa() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiPersonalEmpresa o");
            Query query = manager.createQuery(sql.toString());
            List<SiiPersonalEmpresa> listaPersonalEmpresa = query.getResultList();
            return listaPersonalEmpresa;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonalEmpresaDAO");
        }

    }

    //Por Gatopardo:
    public List<SiiPersonalEmpresa> buscarPersonalEmpresaPorIdPersona(Long idPersona) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pem FROM SiiPersonalEmpresa pem WHERE pem.siiPersona.perCodigo = :idPersona");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idPersona", idPersona);
            List<SiiPersonalEmpresa> listaPersonalEmpresa = query.getResultList();
            return listaPersonalEmpresa;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonalEmpresaDAO");
        }

    }

    /**
     * Elimina un contacto de la persona operador
     * @author Giovanni
     * @param siiPersonalEmpresa
     * @return
     * @throws ExcepcionDAO
     */
    public SiiPersonalEmpresa eliminarSiiPersonalEmpresa(SiiPersonalEmpresa siiPersonalEmpresa) throws ExcepcionDAO {
        try {
            manager.remove(siiPersonalEmpresa);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonalEmpresaDAO");
        }
        return siiPersonalEmpresa;
    }

    /**
     * Metodo para consultar un contacto para un operador ya sea autorizado, potencia o proveedor de tecnologia
     * @author Giovanni
     * @param idOperador
     * @param idPersonaContacto
     * @return
     * @throws ExcepcionDAO
     */
    public SiiPersonalEmpresa buscarPersonalEmpresaXOperadorXPerosna(long idOperador,
                                                                     long idPersonaContacto) throws ExcepcionDAO {
        SiiPersonalEmpresa siiPersonalEmpresa = new SiiPersonalEmpresa();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pem FROM SiiPersonalEmpresa pem");
            sql.append(" WHERE pem.siiPersona3.perCodigo = :idOperador");
            sql.append(" AND pem.siiPersona.perCodigo = :idPersonaContacto");
            
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idOperador", idOperador);
            query.setParameter("idPersonaContacto", idPersonaContacto);
            
            List<SiiPersonalEmpresa> siiPersonalEmpresas = new ArrayList<SiiPersonalEmpresa>();
            siiPersonalEmpresas = query.getResultList();            
            if(siiPersonalEmpresas != null && !siiPersonalEmpresas.isEmpty() ){
                siiPersonalEmpresa = siiPersonalEmpresas.get(0);
            }      
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonalEmpresaDAO");
        }
        return siiPersonalEmpresa;
    }

    public SiiPersonalEmpresa buscarPersonalEmpresaPorEmpresaPorRol(Long perCodigoEmpresa, String rol
                                                                     ) throws ExcepcionDAO {
        SiiPersonalEmpresa siiPersonalEmpresa = new SiiPersonalEmpresa();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT pem FROM SiiPersonalEmpresa pem " +
                " WHERE pem.siiPersona.perCodigo = :perCodigoEmpresa " +
                " AND pem.pemActivo = 'S' " +
                " AND pem.siiTipoPersonal.tpeNombre = :rol");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("perCodigoEmpresa", perCodigoEmpresa);
            query.setParameter("rol", rol);
            
            List<SiiPersonalEmpresa> siiPersonalEmpresas = new ArrayList<SiiPersonalEmpresa>();
            siiPersonalEmpresas = query.getResultList();            
            if(siiPersonalEmpresas != null && !siiPersonalEmpresas.isEmpty() ){
                siiPersonalEmpresa = siiPersonalEmpresas.get(0);
            }      
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonalEmpresaDAO");
        }
        return siiPersonalEmpresa;
    }

}
