/*
 * SISTEMA	: SIICOL
 * MÓDULO	: DESARROLLO DE MERCADO
 * AUTOR	: Mónica Pabón
 * FECHA	: 14-12-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiOperador;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

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
public class OperadorDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public OperadorDAO() {
        recursos = new Recursos();
    }

    public SiiOperador buscarPorCodigoOperador(Long idCodigoOperador) throws ExcepcionDAO {
        SiiOperador retornoOperador = null;
        try {
            retornoOperador = (SiiOperador) manager.find(SiiOperador.class, idCodigoOperador);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OperadorDAO");
        }
        return retornoOperador;

    }

    public SiiOperador insertarSiiOperador(SiiOperador operador) throws ExcepcionDAO {
        try {
            if(operador.getOpeEstado() == null){
                operador.setOpeEstado("H");
            }
            manager.persist(operador);
            manager.flush();
            return operador;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OperadorDAO");
        }
    }

    public SiiOperador actualizarSiiOperador(SiiOperador operador) throws ExcepcionDAO {
        try {
            manager.merge(operador);
            manager.flush();
            return operador;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OperadorDAO");
        }
    }

    public void borrarOperador(Long idCodigoOperador) throws ExcepcionDAO {
        SiiOperador operadorBorrar = null;
        try {
            operadorBorrar = manager.find(SiiOperador.class, idCodigoOperador);
            manager.remove(operadorBorrar);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OperadorDAO");
        }
    }


    public List<SiiOperador> buscarTodoSiiOperador() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiOperador o");
            Query query = manager.createQuery(sql.toString());
            List<SiiOperador> listaOperadores = query.getResultList();
            return listaOperadores;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OperadorDAO");
        }

    }

    public List<SiiOperador> buscarOperadorPorNit(String pNit) throws ExcepcionDAO {
        List<SiiOperador> listaOperadores = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o from SiiOperador o INNER JOIN o.siiPersona pc WHERE o.siiPersona.perNumIdentificacion = :pNit");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("pNit", pNit);
            listaOperadores = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OperadorDAO");
        }
        return listaOperadores;
    }

    /**
     *Metodo encargado de buscar un operador por el codigo de la persona
     * Author David Tafur
     * @param codigoPersona
     * @return
     * @throws ExcepcionDAO
     */
    public SiiOperador buscarOperadorXCodigoPersona(long codigoPersona) throws ExcepcionDAO {
        SiiOperador operador = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ope FROM SiiOperador ope WHERE ope.siiPersona.perCodigo =:codigoPersona");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoPersona", codigoPersona);

            List<SiiOperador> listaOperadores = new ArrayList<SiiOperador>();
            listaOperadores = query.getResultList();

            operador = listaOperadores.get(0);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "OperadorDAO");
        }
        return operador;
    }

    /**
     *Metodo encargado de hacer la busqueda de los operadores que no marcaron sus met en linea por lo tanto
     * se les debe aplicar la resolucion 1400
     * @author David Tafur
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiOperador> buscarOperadoresNoMarcaMetLinea(String tipoOperador) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o.* FROM sii_operador o");
            sql.append(" WHERE o.ope_tipo_poblac = '" + tipoOperador +
                       "' AND o.ope_codigo NOT IN (Select DISTINCT opedis.ope_codigo FROM sii_establecimiento estdis");
            sql.append(" INNER JOIN sii_inventario invdis ON estdis.est_codigo = invdis.est_codigo");
            sql.append(" INNER JOIN sii_operador opedis ON estdis.ope_codigo = opedis.ope_codigo");
            sql.append(" INNER JOIN sii_novedad novdis ON invdis.nov_codigo = novdis.nov_codigo");
            sql.append(" INNER JOIN sii_instrumento insdis ON invdis.ins_codigo = insdis.ins_codigo");
            sql.append(" INNER JOIN sii_met metdis ON metdis.met_codigo = insdis.met_codigo");
            sql.append(" INNER JOIN sii_ente_territorial entdis ON estdis.ubi_codigo = entdis.ubi_codigo");
            sql.append(" WHERE metdis.met_online = 'S')");
            Query query = manager.createNativeQuery(sql.toString());


            List<Object[]> results = query.getResultList();
            List<SiiOperador> listaOperadores = new ArrayList<SiiOperador>();
            for (Object[] object : results) {
                SiiOperador siiOperador = new SiiOperador();
                siiOperador.setOpeCodigo(((BigDecimal) object[0]).longValue());
                SiiPersona siiPersona = new SiiPersona();
                siiPersona.setPerCodigo(((BigDecimal) object[1]).longValue());
                siiOperador.setSiiPersona(siiPersona);
                siiOperador.setOpePotencial((String) object[2]);
                siiOperador.setOpeTipoPoblac((String) object[3]);

                listaOperadores.add(siiOperador);
            }


            return listaOperadores;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "OperadorDAO");
        }

    }
}
