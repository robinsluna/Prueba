/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */

package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;
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


public class BancoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public BancoDAO() {
        recursos = new Recursos();
    }

    public SiiBanco buscarBancoXId(String idBanco) throws ExcepcionDAO {
        SiiBanco retornoSiiBanco = null;
        try {
            retornoSiiBanco = (SiiBanco) manager.find(SiiBanco.class, idBanco);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecaudoBancoDAO");
        }
        return retornoSiiBanco;

    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiBanco> consultarBancos() throws ExcepcionDAO {
        List<SiiBanco> siiBancos = new ArrayList<SiiBanco>();

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT b FROM SiiBanco b");
            sql.append(" ORDER BY b.banNombre ASC");

            Query query = manager.createQuery(sql.toString());
            siiBancos = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "BancoDAO");
        }
        return siiBancos;
    }
    public SiiBanco buscarBancoPorCodigo(String idBanco) throws ExcepcionDAO {
        SiiBanco retorno = null;
        try {
            retorno = (SiiBanco) manager.find(SiiBanco.class, idBanco);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AcuerdoPagoDAO");
        }
        return retorno;

    }

}
