/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-10-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.enumeration.EnumTipoApuesta;
import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiMet;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.InventarioVO;
import co.gov.coljuegos.siicol.ejb.vo.NovedadVO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class MetDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public MetDAO() {
        recursos = new Recursos();
    }

    public SiiMet buscarPorCodigoMet(Long idCodigoMet) throws ExcepcionDAO {
        SiiMet retorno = null;
        try {
            retorno = manager.find(SiiMet.class, idCodigoMet);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return retorno;

    }

    public SiiMet insertarSiiMet(SiiMet met) throws ExcepcionDAO {
        try {
            manager.persist(met);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return met;
    }

    /**
     *Metodo encargado de hacer la consulta de una met por varios criterios
     * @author David Tafur
     * @param serial
     * @param nuc
     * @param nuid
     * @param codigoLocal
     * @param marca
     * @param nit
     * @return
     * @throws ExcepcionDAO
     */
    public SiiMet buscarMetXPorNucYContrato(Long nuc, String codigoLocal, String nit, String contrato) throws ExcepcionDAO {
        SiiMet met = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT met FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN est.siiOperador2 ope");
            sql.append(" INNER JOIN ope.siiPersona per");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" INNER JOIN met.siiMarca marca");
            sql.append(" WHERE per.perNumIdentificacion =:nit");
            sql.append(" AND est.estCodInterno = :codLocal");
            sql.append(" AND inv.invEstado = 'A'");
            sql.append(" AND con.conNumero = :conNumero");

            if (nuc != null && nuc > 0)
                sql.append(" AND met.metUid =:nuc");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("nit", nit);
            consulta.setParameter("codLocal", codigoLocal);
            consulta.setParameter("conNumero", contrato);

            if (nuc != null && nuc > 0)
                consulta.setParameter("nuc", String.valueOf(nuc));


            List<SiiMet> listaMet = consulta.getResultList();

            if (listaMet.size() > 0)
                met = listaMet.get(0);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return met;
    }


    /**
     *Metodo encargado de hacer la consulta de una met por varios criterios
     * @author David Tafur
     * @param serial
     * @param nuc
     * @param nuid
     * @param codigoLocal
     * @param marca
     * @param nit
     * @return
     * @throws ExcepcionDAO
     */
    public SiiMet buscarMetXMarcaYSerialYLocalYContrato(String serial, String codigoLocal, long marca, String nit, String contrato) throws ExcepcionDAO {
        SiiMet met = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT met FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN est.siiOperador2 ope");
            sql.append(" INNER JOIN ope.siiPersona per");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" INNER JOIN met.siiMarca marca");
            sql.append(" WHERE per.perNumIdentificacion =:nit");
            sql.append(" AND est.estCodInterno = :codLocal");
            sql.append(" AND inv.invEstado = 'A'");
            sql.append(" AND con.conNumero = :conNumero");

            if (serial != null && !serial.equals(""))
                sql.append(" AND met.metSerial =:serial");
            if (marca > 0)
                sql.append(" AND marca.marCodigo =:marca");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("nit", nit);
            consulta.setParameter("codLocal", codigoLocal);
            consulta.setParameter("conNumero", contrato);

            if (serial != null && !serial.equals(""))
                consulta.setParameter("serial", serial);
            if (marca > 0)
                consulta.setParameter("marca", marca);

            List<SiiMet> listaMet = consulta.getResultList();

            if (listaMet.size() > 0)
                met = listaMet.get(0);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return met;
    }

    /**
     *
     * @param met
     * @return
     * @throws ExcepcionDAO
     */
    public SiiMet actualizarSiiMet(SiiMet met) throws ExcepcionDAO {
        try {
            manager.merge(met);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return met;
    }


    public String generarNuc(Connection dbConnection) throws ExcepcionDAO, SQLException, ClassNotFoundException {

        CallableStatement callableStatement = null;
        String sql = "{? = call pr.fn_nuid()}"; //String sql = "{ ? = call get_empName(?)}";
        String nuc = null;
        try {
            callableStatement = dbConnection.prepareCall(sql); //CallableStatement cstmt = con.dbstate().prepareCall(call);
            callableStatement.registerOutParameter(1, Types.VARCHAR); //cstmt.registerOutParameter(1, oracle.jdbc.OracleTypes.VARCHAR);


            callableStatement.executeQuery(); //cstmt.executeQuery();
            nuc = callableStatement.getString(1); //name = cstmt.getString(1); con.dbstate().close();
            System.out.print(".");
            //System.out.print("Valor nuc: " + nuc+ " ");
            return nuc;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExcepcionDAO("Error general : " + e.getMessage(), getClass().getSimpleName());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        } finally {
            try {
                if (callableStatement != null) {
                    callableStatement.close();
                }
            } catch (SQLException se2) {
                se2.printStackTrace();
            }           

        }

    }

    public List<String> asignarUids(Connection dbConnection, int numeroUids) throws ExcepcionDAO, SQLException, ClassNotFoundException {
        List<String> uids = null;
        CallableStatement callableStatement = null;
        try {
            String sql = "{? = call pr.fn_nuid()}";
            callableStatement = dbConnection.prepareCall(sql);
            callableStatement.registerOutParameter(1, Types.VARCHAR);
            for (int i = 1; i <= numeroUids; i = i + 1) {
                callableStatement.executeQuery();
                uids.add(callableStatement.getString(1));
            }
            return uids;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ExcepcionDAO("Error general : " + e.getMessage(), getClass().getSimpleName());
        } catch (PersistenceException pe) {
            pe.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        } finally {
            if (callableStatement != null) {
                callableStatement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();

            }
        }
    }

    public SiiMet buscarMetPorNuc(String nuc) throws ExcepcionDAO {
        SiiMet siiMet = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT met FROM SiiMet met");
            sql.append(" WHERE met.metUid = :nuc");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("nuc", nuc);

            List<SiiMet> listaMet = consulta.getResultList();

            if (listaMet != null && listaMet.size() > 0) {
                siiMet = listaMet.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }

        return siiMet;
    }

    public int buscarMetMarcadasPorContrato(String contrato, String nit) throws ExcepcionDAO {

        List<SiiInventario> siiInventarios = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("select m.met_online,m.met_fecha_marc_online , " +
                       "iv.inv_estado,iv.inv_codigo   ,iv.inv_pg,o.ope_tipo_poblac ,n.con_codigo ,c.con_numero   ,n.con_codigo ,p.per_num_identificacion NIT   " +
                       ",c.con_fecha_ini, c.con_fecha_fin , iv.inv_fecha_ini_liq , iv.inv_fecha_fin_liq  ,e.est_codigo , IV.INV_ESTADO   " +
                       ",e.ubi_codigo, e.est_cod_interno, ti.tin_nombre , i.ins_codigo , m.met_codigo  ,m.met_online , m.met_serial, ma.mar_codigo   " +
                       ",ma.mar_nombre, m.met_marca_anterior  , m.met_uid  ,jm.jme_nombre, ta.tap_codigo_apuesta  " +
                       ", iv.tap_codigo, iv.inv_sillas, ta.tap_min_sillas , tn.tno_nombre, n.nov_fecha  , n.nov_codigo   " + "from sii_inventario iv     " +
                       "left join sii_instrumento i on iv.ins_codigo = i.ins_codigo   " + "left join sii_mesa_casino mc on mc.mca_codigo = i.mca_codigo   " +
                       "left join sii_juego_mesa jm on mc.jme_codigo = jm.jme_codigo   " + "left join sii_met m on i.met_codigo = m.met_codigo     " +
                       "left join sii_marca ma on m.mar_codigo = ma.mar_codigo     " + "left join sii_establecimiento e on iv.est_codigo = e.est_codigo " +
                       "left join sii_novedad n on iv.nov_codigo = n.nov_codigo     " + "left join sii_contrato c on c.con_codigo = n.con_codigo     " +
                       "left join sii_tipo_apuesta ta on iv.tap_codigo = ta.tap_codigo  " + "left join sii_tipo_instrumento ti on i.tin_codigo = ti.tin_codigo    " +
                       "left join sii_tipo_novedad tn on n.tno_codigo = tn.tno_codigo   " + "left join sii_operador o on o.ope_codigo = c.ope_codigo   " +
                       "left join sii_persona p on p.per_codigo = o.per_codigo   " + "where c.con_numero = #contrato and m.met_online = 'S' and iv.inv_estado = 'A' " +
                       "order by m.met_serial, c.con_numero, n.nov_fecha desc, iv.inv_codigo desc");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("contrato", contrato);

            siiInventarios = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InventarioDAO");
        }

        return siiInventarios.size();
    }
}
