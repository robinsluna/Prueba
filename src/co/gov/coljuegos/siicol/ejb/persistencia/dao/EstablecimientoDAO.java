/*
 * SISTEMA	: SIICOL
 * MÓDULO	: CONTRATACION
 * AUTOR	: Mónica Pabón
 * FECHA	: 24-12-2013
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiEstablecimiento;
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
public class EstablecimientoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public EstablecimientoDAO() {
        recursos = new Recursos();
    }

    public SiiEstablecimiento insertarSiiEstablecimiento(SiiEstablecimiento establecimiento) throws ExcepcionDAO {
        try {
            manager.persist(establecimiento);
            manager.flush();
            return establecimiento;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
    }

    public SiiEstablecimiento buscarEstablecimientoPorId(Long estCodigo) throws ExcepcionDAO {
        try {
            return (SiiEstablecimiento) manager.find(SiiEstablecimiento.class, estCodigo);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
    }

    /**
     *Metodo encargado de consultar los establecimientos relacionados con un operador
     * @Author David Tafur
     * @param codigoOperador
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiEstablecimiento> buscarEstablecimientosPorOperador(Long codigoOperador) throws ExcepcionDAO {
        List<SiiEstablecimiento> listaEstablecimientos = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT est FROM SiiEstablecimiento est");
            sql.append(" WHERE est.siiOperador2.opeCodigo = :codigoOperador");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoOperador", codigoOperador);

            listaEstablecimientos = consulta.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
        return listaEstablecimientos;
    }


    /**
     *Metodo encargado de consulta un establecimiento por el codigo interno con el cual se maneja
     * @Author David Tafur
     * @param codigoInternoEst
     * @return
     * @throws ExcepcionDAO
     */
    public SiiEstablecimiento buscarEstablecimientoXOperadorYCodInterno(Long codigoOperador,
                                                                        String codigoInternoEst) throws ExcepcionDAO {
        SiiEstablecimiento resultadoEst = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT est FROM SiiEstablecimiento est");
            sql.append(" WHERE est.siiOperador2.opeCodigo = :codigoOperador");
            sql.append(" AND est.estCodInterno = :codigoInternoEst"); 
            sql.append(" AND (est.estEstado in('A','PA') or est.estEstado is null)");
            Query consulta = manager.createQuery(sql.toString(),SiiEstablecimiento.class);
            consulta.setParameter("codigoOperador", codigoOperador);
            consulta.setParameter("codigoInternoEst", codigoInternoEst);

            List<SiiEstablecimiento> listaEstablecimientos = new ArrayList<SiiEstablecimiento>();
            listaEstablecimientos = consulta.getResultList();

            if (listaEstablecimientos.size() > 0) {
                resultadoEst = listaEstablecimientos.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
        return resultadoEst;
    }      

    

    public SiiEstablecimiento buscarEstablecimientoXOperadorYCodInternoEnInventario(Long codigoOperador,
                                                                            String codigoInternoEst) throws ExcepcionDAO {
            SiiEstablecimiento resultadoEst = null;
            try {
                StringBuilder sql = new StringBuilder();
                sql.append("select distinct e.est_codigo,e.ubi_codigo,e.est_direccion,e.est_cod_interno,e.ope_codigo,e.est_nombre,e.est_longitud,e.est_latitud,e.nov_codigo,e.est_estado ");
                sql.append("from sii_inventario iv  ");
                sql.append("left join sii_instrumento i on iv.ins_codigo = i.ins_codigo   ");
                sql.append("left join sii_mesa_casino mc on mc.mca_codigo = i.mca_codigo   ");
                sql.append("left join sii_juego_mesa jm on mc.jme_codigo = jm.jme_codigo  "); 
                sql.append("left join sii_met m on i.met_codigo = m.met_codigo     ");
                sql.append("left join sii_marca ma on m.mar_codigo = ma.mar_codigo  ");   
                sql.append("left join sii_establecimiento e on iv.est_codigo = e.est_codigo ");    
                sql.append("left join sii_novedad n on iv.nov_codigo = n.nov_codigo ");    
                sql.append("left join sii_contrato c on c.con_codigo = n.con_codigo ");   
                sql.append("left join sii_tipo_apuesta ta on iv.tap_codigo = ta.tap_codigo ");    
                sql.append("left join sii_tipo_instrumento ti on i.tin_codigo = ti.tin_codigo ");    
                sql.append("left join sii_tipo_novedad tn on n.tno_codigo = tn.tno_codigo ");  
                sql.append("left join sii_operador o on o.ope_codigo = c.ope_codigo ");  
                sql.append("left join sii_persona p on p.per_codigo = o.per_codigo ");  
                sql.append("where iv.inv_estado = 'A' ");
                sql.append("and o.ope_codigo= "+codigoOperador+" ");
                sql.append("and e.est_cod_interno='"+codigoInternoEst+"' ");

                
                Query consulta = manager.createNativeQuery(sql.toString(),SiiEstablecimiento.class);
                List<SiiEstablecimiento> listaEstablecimientos = new ArrayList<SiiEstablecimiento>();
                listaEstablecimientos = consulta.getResultList();

                if (listaEstablecimientos.size() > 0) {
                    resultadoEst = listaEstablecimientos.get(0);
                }

            } catch (PersistenceException pe) {
                String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
                throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
            }
            return resultadoEst;
        }



    /**
     * Metodo encargado de consultar el nuemro de establecimientos relacionados con un operador
     * @author Giovanni
     * @param codigoOperador
     * @return
     * @throws ExcepcionDAO
     */
    public int buscarNumeroEstablecimientosPorOperador(Long codigoOperador) throws ExcepcionDAO {
        int numeroEstablecimientos = 0;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT COUNT (est) FROM SiiEstablecimiento est");
            sql.append(" WHERE est.siiOperador2.opeCodigo = :codigoOperador");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoOperador", codigoOperador);

            Long temp = (Long) consulta.getSingleResult();
            numeroEstablecimientos = temp.intValue();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
        return numeroEstablecimientos;
    }

    /**
     *  @author Giovanni
     * @param siiEstablecimiento
     * @return
     * @throws ExcepcionDAO
     */
    public SiiEstablecimiento actualizarPersona(SiiEstablecimiento siiEstablecimiento) throws ExcepcionDAO {
        try {
            manager.merge(siiEstablecimiento);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
        return siiEstablecimiento;
    }

    public SiiEstablecimiento actualizarEstablecimiento(SiiEstablecimiento siiEstablecimiento) throws ExcepcionDAO {
        try {
            manager.merge(siiEstablecimiento);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
        return siiEstablecimiento;
    }

    /**
     * @author Giovanni
     * @param codigoNovedad
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiEstablecimiento> consultarEstablecimientosXNovedadEstadoPA(Long codigoNovedad) throws ExcepcionDAO {
        List<SiiEstablecimiento> siiEstablecimientos = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT est FROM SiiEstablecimiento est");
            sql.append(" WHERE est.siiNovedad.novCodigo = :codigoNovedad");
            sql.append(" AND est.estEstado = 'PA'");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoNovedad", codigoNovedad);

            siiEstablecimientos = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
        return siiEstablecimientos;
    }


    public int numeroEstablecimientosPorContrato(Long conCodigo) throws ExcepcionDAO {

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT COUNT(DISTINCT est.EST_CODIGO)\n" + 
            "FROM Sii_Establecimiento est\n" + 
            "INNER JOIN sii_inventario inv\n" + 
            "ON inv.EST_CODIGO = est.EST_CODIGO\n" + 
            "INNER JOIN sii_novedad nov\n" + 
            "ON nov.NOV_CODIGO = inv.NOV_CODIGO\n" + 
            "INNER JOIN sii_contrato con\n" + 
            "ON con.CON_CODIGO = nov.CON_CODIGO\n" + 
            "INNER JOIN sii_Operador ope\n" + 
            "ON ope.OPE_CODIGO    = con.OPE_CODIGO\n" + 
            "WHERE con.con_codigo = #conCodigo");

            Query consulta = manager.createNativeQuery(sql.toString());
            consulta.setParameter("conCodigo", conCodigo);

            BigDecimal temp = (BigDecimal) consulta.getSingleResult();
            return  temp.intValue();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
    }
    
    public List<SiiEstablecimiento> buscarEstablecimientoXIdContrato(Long  conCodigo) throws ExcepcionDAO {
        List<SiiEstablecimiento> listaEstablecimientos ;
        List<SiiEstablecimiento> resultado = null;
        try {
            StringBuilder sql = new StringBuilder();  
            sql.append(" SELECT distinct est.est_codigo, est.est_cod_interno");
            sql.append(" FROM sii_inventario inv");
            sql.append(" LEFT JOIN sii_establecimiento est ON inv.est_codigo = est.est_codigo");
            sql.append(" LEFT JOIN sii_ubicacion ubi ON ubi.ubi_codigo = est.ubi_codigo");
            sql.append(" LEFT JOIN sii_ubicacion ubi2 ON ubi2.ubi_codigo = ubi.ubi_codigo_padre");
            sql.append(" LEFT JOIN sii_novedad n ON inv.nov_codigo = n.nov_codigo");
            sql.append(" LEFT JOIN sii_contrato con ON con.con_codigo = n.con_codigo");
            sql.append(" WHERE con.con_codigo =  #conCodigo");
            sql.append(" order by 2 asc");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("conCodigo", conCodigo);

            List<Object[]> rows = query.getResultList();
            
            if (rows!=null) {
                resultado = new ArrayList<SiiEstablecimiento>();
                
                for (Object[] row: rows) {
                    if (row[0]!=null) {
                        resultado.add(buscarEstablecimientoPorId(((BigDecimal) row[0]).longValue()));
                    }
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
        return resultado;
    }

    public List<SiiEstablecimiento> buscarEstablecimientosPorContrato(Long conCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT est FROM SiiEstablecimiento est, IN(est.siiInventarioList3) inv");
            sql.append(" WHERE inv.siiNovedad.siiContrato.conCodigo  = :conCodigo");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("conCodigo", conCodigo);

            return  consulta.getResultList();
            

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
    }

    public void buscarEstablecimientosPorSuspension(Long scoCodigo)  {
    }
    
    public String buscarEstablecimientoPorNitOperador (String nit) throws ExcepcionDAO {
        String establecimiento = null;
        try {
            StringBuilder sql = new StringBuilder();  
            sql.append("select ListAgg(est.est_nombre || \' Dirección \' || est.est_direccion || \' \' || u.ubi_nombre || \' - \' || u2.ubi_nombre , \',\') WITHIN GROUP (ORDER BY est.est_nombre)" + 
            " from sii_persona per" + 
            " inner join sii_operador ope on (per.per_codigo = ope.per_codigo)" + 
            " inner join sii_establecimiento est on (ope.ope_codigo = est.ope_codigo)" + 
            " inner join sii_ubicacion u on (est.ubi_codigo = u.ubi_codigo)" + 
            " inner join sii_ubicacion u2 on (u.ubi_codigo_padre = u2.ubi_codigo )" + 
            " where " + 
            " est.est_estado=\'A\'" + 
            " and per.per_num_identificacion = #nit ");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("nit", nit);
            if (query.getSingleResult() != null){
                establecimiento = query.getSingleResult().toString();
            }else {
                establecimiento ="";
            }

        }catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "EstablecimientoDAO");
        }
        
        return establecimiento;
    }
    
    
}
