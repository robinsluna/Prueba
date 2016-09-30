/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 23-10-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEmpresaDestruye;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data access object que gestiona las empresas que destruyen
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
public class EmpresaDestruyeDAO extends AbstractDAO<Long, SiiEmpresaDestruye> {

    /**
     * Constructor.
     */

    public EmpresaDestruyeDAO() {
        super(SiiEmpresaDestruye.class);
    }

    /**
     * Buscar empresa que destruye que esté vigente
     * @param anio
     * @return
     * @throws ExcepcionDAO
     */

    public List<SiiEmpresaDestruye> buscarEmpresaDestruyeVigente(Integer anio) throws ExcepcionDAO {
        List<SiiEmpresaDestruye> resultado = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ed FROM SiiEmpresaDestruye ed ");
            sql.append("WHERE ed.emdActivo='S' and ed.emdVigencia= :anio and ed.emdFechaInac is null ");

            Query query = em.createQuery(sql.toString());
            query.setParameter("anio", anio);

            resultado = query.getResultList();

        } catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), this.getClass().getSimpleName());
        }


        return (resultado);
    }
}
