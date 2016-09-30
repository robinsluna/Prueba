/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 28-10-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAdendaTdr;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInstrumento;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiInventario;
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
public class InstrumentoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public InstrumentoDAO() {
        recursos = new Recursos();
    }


    public SiiInstrumento insertarSiiInstrumento(SiiInstrumento instrumento) throws ExcepcionDAO {
        try {
            manager.persist(instrumento);
            manager.flush();
            return instrumento;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrumentoDAO");
        }
    }

    public SiiInstrumento actualizarSiiInstrumento(SiiInstrumento instrumento) throws ExcepcionDAO {
        try {
            manager.merge(instrumento);
            manager.flush();
            return instrumento;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrumentoDAO");
        }
    }

    public SiiInstrumento buscarPorCodigoInstrumento(Long idCodigoInstrumento) throws ExcepcionDAO {
        SiiInstrumento instrRetorno = null;
        try {
            instrRetorno = (SiiInstrumento) manager.find(SiiInstrumento.class, idCodigoInstrumento);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrumentoDAO");
        }
        return instrRetorno;

    }


    public List<SiiAdendaTdr> buscarTodoSiiAdenda() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiAdendaTdr o");
            Query query = manager.createQuery(sql.toString());
            List<SiiAdendaTdr> listaAdendas = query.getResultList();
            return listaAdendas;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "AdendaDAO");
        }

    }

    /**
     * @author Giovanni
     * @param codTipoInstrumento
     * @param codOperador
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInstrumento consultarInstrumentosMETXCriterios(Long codTipoInstrumento, Long codOperador,
                                                             String nuc) throws ExcepcionDAO {
        List<SiiInstrumento> siiInstrumentos = null;
        SiiInstrumento siiInstrumento = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ins FROM SiiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" WHERE ins.siiTipoInstrumento.tinCodigo = :codTipoInstrumento");
            sql.append(" AND ins.siiOperador1.opeCodigo = :codOperador");
            sql.append(" AND ins.insActivo = 'S'");
            sql.append(" AND met.metUid = :nuc");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codTipoInstrumento", codTipoInstrumento);
            query.setParameter("codOperador", codOperador);
            query.setParameter("nuc", nuc);

            siiInstrumentos = query.getResultList();
            if (siiInstrumentos != null && !siiInstrumentos.isEmpty()) {
                siiInstrumento = siiInstrumentos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrumentoDAO");
        }

        return siiInstrumento;
    }
    
    /**
     * @author aperez
     * @param nuc     
     * @return SiiInstrumento
     * @throws ExcepcionDAO
     */
    public SiiInstrumento consultarInstrumentosMETXNUC(String nuc) throws ExcepcionDAO {
        List<SiiInstrumento> siiInstrumentos = null;
        SiiInstrumento siiInstrumento = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ins FROM SiiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" WHERE met.metUid = :nuc");

            Query query = manager.createQuery(sql.toString());                        
            query.setParameter("nuc", nuc);

            siiInstrumentos = query.getResultList();
            if (siiInstrumentos != null && !siiInstrumentos.isEmpty()) {
                siiInstrumento = siiInstrumentos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrumentoDAO");
        }

        return siiInstrumento;
    }

    /**
     * @author Giovanni
     * @param codOperador
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiInstrumento> consultarInstrumentosXOperador(Long codOperador) throws ExcepcionDAO {
        List<SiiInstrumento> siiInstrumentos = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ins FROM SiiInstrumento ins");
            sql.append(" WHERE ins.siiOperador1.opeCodigo = :codOperador");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codOperador", codOperador);

            siiInstrumentos = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrumentoDAO");
        }

        return siiInstrumentos;
    }
    
    /**
     * @author Giovanni
     * @param codOperador
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiInstrumento> consultarInstrumentosXOperadorPG(Long codOperador) throws ExcepcionDAO {
        List<SiiInstrumento> siiInstrumentos = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ins FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" WHERE ins.opeCodigo = :codOperador");
            sql.append(" AND inv.invPg = 'S'");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codOperador", codOperador);

            siiInstrumentos = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrumentoDAO");
        }

        return siiInstrumentos;
    }

    /**
     * @author Giovanni
     * @param serial
     * @param marca
     * @return
     * @throws ExcepcionDAO
     */
    public boolean validarInstrumentoMETXCriterios(String serial, long marca) throws ExcepcionDAO {
        List<SiiInstrumento> siiInstrumentos = null;
        boolean estaInstrumento = false;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ins FROM SiiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" INNER JOIN met.siiMarca mar");
            sql.append(" WHERE met.metSerial = :serial");
            sql.append(" AND mar.marCodigo = :marca");
            sql.append(" AND ins.insActivo = 'S'");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("serial", serial);
            query.setParameter("marca", marca);

            siiInstrumentos = query.getResultList();
            if (siiInstrumentos != null && !siiInstrumentos.isEmpty()) {
                estaInstrumento = true;
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrumentoDAO");
        }

        return estaInstrumento;
    }   

    /**
     * @author Giovanni
     * @param serial
     * @param marca
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInstrumento buscarInstrumentoMETXCriterios(String serial, Long marca) throws ExcepcionDAO {
        SiiInstrumento siiInstrumento = null;
        List<SiiInstrumento> siiInstrumentos = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ins FROM SiiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" INNER JOIN met.siiMarca mar");
            sql.append(" WHERE met.metSerial = :serial");
            sql.append(" AND mar.marCodigo = :marca");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("serial", serial);
            query.setParameter("marca", marca);

            siiInstrumentos = query.getResultList();
            if (siiInstrumentos != null && !siiInstrumentos.isEmpty()) {
                siiInstrumento = siiInstrumentos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrumentoDAO");
        }

        return siiInstrumento;
    }

    /**
     * @author Giovanni
     * @param nuc
     * @param contrato
     * @param codigoLocal
     * @param codigoDane
     * @param tipoApuesta
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInstrumento validarNUCXContratoXCodigoLocalXCodigoDaneXTipoApuesta(String nuc, String contrato,
                                                                                 String codigoLocal, String codigoDane,
                                                                                 Long tipoApuesta) throws ExcepcionDAO {
        SiiInstrumento siiInstrumento = null;
        List<SiiInstrumento> siiInstrumentos = null;

        try {

            /*StringBuilder sql = new StringBuilder();
            sql.append("SELECT ins FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN inv.siiTipoApuesta tap");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN est.siiUbicacion1 ubi");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" WHERE inv.invEstado = 'A'");
            sql.append(" AND met.metUid = :nuc");
            sql.append(" AND con.conNumero = :contrato");
            sql.append(" AND est.estCodInterno = :codLocal");
            sql.append(" AND ubi.ubiCodigo = :codDane");
            sql.append(" AND ins.tapCodigo = :tapCodigo");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("nuc", nuc);
            query.setParameter("contrato", contrato);
            query.setParameter("codLocal", codigoLocal);
            query.setParameter("codDane", codigoDane);
            query.setParameter("tapCodigo", tipoApuesta);*/
            
            /*StringBuilder sql = new StringBuilder();
            sql.append("SELECT inv FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" WHERE met.metUid = :codUidMet");
            sql.append(" AND inv.invEstado = 'A'");
            sql.append(" AND con.conNumero = :conNumero");
            sql.append(" AND est.estCodInterno = :codLocal");
            sql.append(" AND ins.tapCodigo = :tapCodigo");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codUidMet", nuc);
            query.setParameter("conNumero", contrato);
            query.setParameter("codLocal", codigoLocal);
            query.setParameter("tapCodigo", tipoApuesta);*/
            
            /*StringBuilder sql = new StringBuilder();
            sql.append("SELECT ins FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiTipoApuesta tap");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN est.siiUbicacion1 ubi");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            //sql.append(" WHERE inv.invEstado = 'A'");
            //sql.append(" AND met.metUid = :codUidMet");
            sql.append(" WHERE ins.tapCodigo = :tapCodigo");
            sql.append(" AND con.conNumero = :contrato");
            sql.append(" AND est.estCodInterno = :codLocal");
            sql.append(" AND ubi.ubiCodigo = :codDane");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("contrato", contrato);
            query.setParameter("codLocal", codigoLocal);
            query.setParameter("codDane", codigoDane);
            query.setParameter("tapCodigo", tipoApuesta);
            //query.setParameter("codUidMet", nuc);*/
            
            StringBuilder sql = new StringBuilder();
            /*sql.append("select instru.* from sii_persona persona inner join sii_operador operador on persona.per_codigo = operador.per_codigo ");
            sql.append(" inner join sii_establecimiento estable on estable.ope_codigo = operador.ope_codigo ");
            sql.append(" inner join sii_ubicacion ubi on ubi.ubi_codigo = estable.ubi_codigo ");
            sql.append(" inner join sii_inventario inven on inven.est_codigo = estable.est_codigo ");
            sql.append(" inner join sii_instrumento instru on instru.ope_codigo = estable.ope_codigo ");
            sql.append(" inner join sii_contrato con on instru.ope_codigo = con.ope_codigo ");
            sql.append(" inner join sii_tipo_instrumento tipoins on tipoins.tin_codigo = instru.tin_codigo ");
            sql.append(" inner join sii_tipo_apuesta apuesta on inven.tap_codigo = apuesta.tap_codigo ");
            sql.append(" inner join sii_tipo_juego tipjuego on tipjuego.tju_codigo = apuesta.tju_codigo ");
            sql.append(" inner join sii_met met on met.met_codigo = instru.met_codigo ");
            sql.append(" inner join sii_marca marca on met.mar_codigo = marca.mar_codigo  ");
            sql.append(" and operador.ope_codigo = estable.ope_codigo ");
            sql.append(" and persona.per_codigo = operador.per_codigo ");
            sql.append(" and inven.ins_codigo = instru.ins_codigo  ");
            sql.append(" and met.met_uid = #uid "); 
            sql.append(" and con.con_numero = #contrato ");
            sql.append(" and ubi.ubi_codigo = #ubica ");
            sql.append(" and estable.est_cod_interno = #codigoLocal ");
            sql.append(" and apuesta.tap_codigo = #apuesta ");
            sql.append(" order by estable.est_codigo,tipoins.tin_nombre,met.met_serial desc ");*/
            
            
            sql.append(" select i.* from sii_inventario iv    "); 
            sql.append(" left join sii_instrumento i on iv.ins_codigo = i.ins_codigo  "); 
            sql.append(" left join sii_mesa_casino mc on mc.mca_codigo = i.mca_codigo  "); 
            sql.append(" left join sii_juego_mesa jm on mc.jme_codigo = jm.jme_codigo  "); 
            sql.append(" left join sii_met m on i.met_codigo = m.met_codigo    "); 
            sql.append(" left join sii_marca ma on m.mar_codigo = ma.mar_codigo  ");   
            sql.append(" left join sii_establecimiento e on iv.est_codigo = e.est_codigo ");     
            sql.append(" left join sii_novedad n on iv.nov_codigo = n.nov_codigo ");    
            sql.append(" left join sii_contrato c on c.con_codigo = n.con_codigo  ");   
            sql.append(" left join sii_tipo_apuesta ta on iv.tap_codigo = ta.tap_codigo  ");   
            sql.append(" left join sii_tipo_instrumento ti on i.tin_codigo = ti.tin_codigo  ");   
            sql.append(" left join sii_tipo_novedad tn on n.tno_codigo = tn.tno_codigo  "); 
            sql.append(" left join sii_operador o on o.ope_codigo = c.ope_codigo  "); 
            sql.append(" left join sii_persona p on p.per_codigo = o.per_codigo  "); 
            sql.append(" where iv.inv_estado = 'A' and m.met_uid = #uid "); 
            sql.append(" and c.con_numero = #contrato "); 
            sql.append(" and e.ubi_codigo = #ubica "); 
            sql.append(" and e.est_cod_interno = #codigoLocal "); 
            sql.append(" and iv.tap_codigo = #apuesta "); 
            sql.append(" order by m.met_serial, c.con_numero, n.nov_fecha desc, iv.inv_codigo desc"); 

            Query query = manager.createNativeQuery(sql.toString(),SiiInstrumento.class);
            query.setParameter("uid", nuc);
            query.setParameter("contrato", contrato);
            query.setParameter("ubica", codigoDane);
            query.setParameter("codigoLocal", codigoLocal);
            query.setParameter("apuesta", tipoApuesta);

            siiInstrumentos = query.getResultList();
            
            if (siiInstrumentos != null && !siiInstrumentos.isEmpty()) {
                siiInstrumento = siiInstrumentos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrumentoDAO");
        }

        return siiInstrumento;
    }

    /**
     * @author Giovanni
     * @param serial
     * @param marca
     * @param contrato
     * @param codigoLocal
     * @param codigoDane
     * @param tipoApuesta
     * @return
     * @throws ExcepcionDAO
     */
    public SiiInstrumento validarSerialYMarcaXContratoXCodigoLocalXCodigoDaneXTipoApuesta(String serial, Long marca,
                                                                                          String contrato,
                                                                                          String codigoLocal,
                                                                                          String codigoDane,
                                                                                          Long tipoApuesta) throws ExcepcionDAO {
        SiiInstrumento siiInstrumento = null;
        List<SiiInstrumento> siiInstrumentos = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ins FROM SiiInventario inv");
            sql.append(" INNER JOIN inv.siiTipoApuesta tap");
            sql.append(" INNER JOIN inv.siiNovedad nov");
            sql.append(" INNER JOIN nov.siiContrato con");
            sql.append(" INNER JOIN inv.siiEstablecimiento est");
            sql.append(" INNER JOIN est.siiUbicacion1 ubi");
            sql.append(" INNER JOIN inv.siiInstrumento ins");
            sql.append(" INNER JOIN ins.siiMet met");
            sql.append(" INNER JOIN met.siiMarca mar");
            sql.append(" WHERE inv.invEstado = 'A'");
            sql.append(" AND met.metSerial = :serial");
            sql.append(" AND mar.marCodigo = :marca");
            sql.append(" AND con.conNumero = :contrato");
            sql.append(" AND est.estCodInterno = :codLocal");
            sql.append(" AND ubi.ubiCodigo = :codDane");
            sql.append(" AND ins.tapCodigo = :tapCodigo");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("serial", serial);
            query.setParameter("marca", marca);
            query.setParameter("contrato", contrato);
            query.setParameter("codLocal", codigoLocal);
            query.setParameter("codDane", codigoDane);
            query.setParameter("tapCodigo", tipoApuesta);

            siiInstrumentos = query.getResultList();
            if (siiInstrumentos != null && !siiInstrumentos.isEmpty()) {
                siiInstrumento = siiInstrumentos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "InstrumentoDAO");
        }

        return siiInstrumento;
    }

}
