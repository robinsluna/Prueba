/*
 * SISTEMA	: SIICOL
 * MÓDULO	: GCT
 * AUTOR	: PAOLA ANDREA RUEDA LEÓN
 * FECHA	: 15-09-2015
 */
package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenuncia;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenunciaOrdenTrab;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiNotaCredito;

import co.gov.coljuegos.siicol.ejb.vo.DenunciaOrdenTrabVO;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

/**
 * Data Access Object que gestiona las denuncias de las órdenes de trabajo de visita.
 * @author PAOLA ANDREA RUEDA LEÓN
 */

@Stateless
@LocalBean
public class DenunciaOrdenTrabDAO extends AbstractDAO<Long, SiiDenunciaOrdenTrab> {

    /**
     * Constructor
     */
    public DenunciaOrdenTrabDAO() {
        super(SiiDenunciaOrdenTrab.class);
    }

    /**
     * Buscar todas las denuncias con orden de trabajo según código de la orden.
     * @param codOrdenTrab
     * @return listaDenunciaOrdenTrab - Lista de denuncias con orden de trabajo.
     * @throws ExcepcionDAO
     */
    public List<SiiDenunciaOrdenTrab> buscarTodoDenunciaOrdenTrabXCodigoOrdenTrab(Long codOrdenTrab) throws ExcepcionDAO {
        List<SiiDenunciaOrdenTrab> listaDenunciaOrdenTrab = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT dot FROM SiiDenunciaOrdenTrab dot");
            sql.append(" WHERE dot.siiOrdenTrabajoVisita.otvCodigo = :codOrdenTrab and dot.dotActivo='S' ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("codOrdenTrab", codOrdenTrab);
            listaDenunciaOrdenTrab = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "DenunciaOrdenTrabDAO");
        }
        return listaDenunciaOrdenTrab;

    }

    /**
     * Buscar la denuncia de orden de trabajo, según id de orden de trabajo y id de la denuncia
     * @param otvCodigo
     * @param denCodigo
     * @return consecutivo - Consecutivo de la denuncia de la orden de trabajo.
     * @throws ExcepcionDAO
     */

    public Long buscarDenunciaOrdTrabXIdOrdTrabXIdDenuncia(Long otvCodigo, Long denCodigo) throws ExcepcionDAO {
        Long consecutivo = null;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("select dot.dot_codigo from sii_denuncia_orden_trab dot inner join sii_denuncia d on d.den_codigo=dot.den_codigo ");
            sql.append("where dot.den_codigo= " + denCodigo);
            sql.append("and dot.otv_codigo=" + otvCodigo);
            sql.append("and dot.dot_activo='S'");
            Query query = em.createNativeQuery(sql.toString());
            //     query.setParameter("denCodigo", denCodigo);
            //      query.setParameter("otvCodigo", otvCodigo);

            if (query.getSingleResult() != null) {
                consecutivo = new Long(((BigDecimal) query.getSingleResult()).longValue());
            } else {
                consecutivo = 0L;
            }

            return consecutivo;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "DenunciaOrdenTrabDAO");
        }

    }

    /**
     * Indica si existe una denuncia para una orden de trabajo según código de denuncia
     * @param codDenuncia
     * @return resul - boolean
     * @throws ExcepcionDAO
     */

    public boolean existeDenunciaOrdenTrabXCod(Long codDenuncia) throws ExcepcionDAO {
        boolean resul = false;
        List<SiiDenunciaOrdenTrab> listaDenunciaOrdenTrab = null;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT dot FROM SiiDenunciaOrdenTrab dot");
            sql.append(" WHERE dot.siiDenuncia.denCodigo = :codDenuncia and dot.dotActivo='S' ");
            Query query = em.createQuery(sql.toString());
            query.setParameter("codDenuncia", codDenuncia);
            listaDenunciaOrdenTrab = query.getResultList();
            if (!listaDenunciaOrdenTrab.isEmpty()) {
                resul = true;
            }
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "DenunciaOrdenTrabDAO");
        }
        return resul;
    }
}
