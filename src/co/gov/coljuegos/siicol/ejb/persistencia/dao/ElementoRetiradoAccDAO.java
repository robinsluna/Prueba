package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiElementoRetiradoAcc;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class ElementoRetiradoAccDAO extends AbstractDAO<Long, SiiElementoRetiradoAcc> {
    public ElementoRetiradoAccDAO() {
        super(SiiElementoRetiradoAcc.class);
    }

    public SiiElementoRetiradoAcc insertarSiiElementoRetiradoAcc(SiiElementoRetiradoAcc elemento) throws ExcepcionDAO {
        if(elemento.getElrCodigo() == null) {
            elemento.setElrActivo("S");
            return insertar(elemento);
        }
        else {
            SiiElementoRetiradoAcc elementoPrevio = this.buscarPorCodigo(elemento.getElrCodigo());
            elementoPrevio.setElrActivo("S");
            return actualizar(elementoPrevio);

        }
    }

    public void eleminarSiiElementoRetiradoAcc(SiiElementoRetiradoAcc elemento) throws ExcepcionDAO {
        try {
            SiiElementoRetiradoAcc elementoPrevio = buscarPorCodigo(elemento.getElrCodigo());
            elementoPrevio.setElrActivo("N");
            actualizar(elementoPrevio);

        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ElementoRetiradoAccDAO");
        }

    }

    /**
     * Buscar un elemento retirado según Id de acción control
     * @param accCodigo
     * @return resultado -  Lista de elementos retirados según id de acción control.
     * @throws ExcepcionDAO
     */

    public List<SiiElementoRetiradoAcc> buscarElementoRetiradoAccXIdAccionControl(Long accCodigo) throws ExcepcionDAO {
        List<SiiElementoRetiradoAcc> resultado = null;

        if (accCodigo != null) {
            try {

                StringBuilder sql = new StringBuilder();
                sql.append("SELECT er FROM SiiElementoRetiradoAcc er ");
                sql.append("WHERE er.siiAccionControl.accCodigo = :accCodigo ");

                Query query = em.createQuery(sql.toString());
                query.setParameter("accCodigo", accCodigo);

                resultado = query.getResultList();

            } catch (PersistenceException e) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
            }
        }

        return (resultado);
    }

    public List<SiiElementoRetiradoAcc> buscarElementoRetiradoPorAccionControl(Long accCodigo) throws ExcepcionDAO {
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiElementoRetiradoAcc o ");
            sql.append("WHERE o.siiAccionControl.accCodigo = :accCodigo AND o.elrActivo='S'");

            Query query = em.createQuery(sql.toString());
            query.setParameter("accCodigo", accCodigo);

            return query.getResultList();

        } catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());



        }
        
    }    }
