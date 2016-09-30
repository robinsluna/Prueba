
/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 13-01-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleDeclaracion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionMes;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.DetalleDeclaracionVO;
import co.gov.coljuegos.siicol.ejb.vo.PersonaVO;
import co.gov.coljuegos.siicol.ejb.vo.RecaudoEstablecimientoManualVO;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean


public class DetalleDeclaracionDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public DetalleDeclaracionDAO() {
        recursos = new Recursos();
    }

    public SiiDetalleDeclaracion actualizarDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) throws ExcepcionDAO {
        try {
            siiDetalleDeclaracion = manager.merge(siiDetalleDeclaracion);
            manager.flush();
            
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiDetalleDeclaracion;
    }

    public List<SiiDetalleDeclaracion> BuscarDetalleDeclaracionXIdRefPago(Long idRefPago) throws ExcepcionDAO {
        List<SiiDetalleDeclaracion> listaSiiDetalleDeclaracion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select det from SiiDetalleDeclaracion det");
            sql.append(" inner join det.siiReferenciaPagoDecl ref");
            sql.append(" where ref.rpdNumero = :idRefPago and (det.ddeValorDeclarado > 0 or det.ddeValorInter > 0) ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idRefPago", idRefPago);
            listaSiiDetalleDeclaracion = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDetalleDeclaracion;
    }

    public SiiDetalleDeclaracion insertarDetalleDeclaracion(SiiDetalleDeclaracion siiDetalleDeclaracion) throws ExcepcionDAO {
        try {
            manager.persist(siiDetalleDeclaracion);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiDetalleDeclaracion;
    }

    public long buscarConsecutivoDetalle() throws ExcepcionDAO {
        long consecutivo = 0L;
        try {
            StringBuilder sql = new StringBuilder();


            sql.append("select MAX(DDE_CODIGO)+1 from SII_DETALLE_DECLARACION");
            Query query = manager.createNativeQuery(sql.toString());

            if (query.getSingleResult() != null) {
                consecutivo = ((BigDecimal) query.getSingleResult()).longValue();
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return consecutivo;
    }

    /**
     *Metodo encargado de hacer la busqueda de la lsita de detalles de declaracion para la cuota de un operador
     * @author David Tafur
     * @param codigoCuota
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiDetalleDeclaracion> buscarDetalleDeclaracionPorXCodigoCuota(Long codigoCuota) throws ExcepcionDAO {
        List<SiiDetalleDeclaracion> listaSiiDetalleDeclaracion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ded FROM SiiDetalleDeclaracion ded");
            sql.append(" WHERE ded.siiCuotaOperador.copCodigo = :codigoCuota");
            sql.append(" order by ded.ddeCodigo desc ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoCuota", codigoCuota);
            listaSiiDetalleDeclaracion = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDetalleDeclaracion;
    }
    
    public List<SiiDetalleDeclaracion> buscarDetalleDeclaracionPorXCodigoCuotaConDetalle (Long codigoCuota)throws ExcepcionDAO {
        List<SiiDetalleDeclaracion> listaSiiDetalleDeclaracion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT ded FROM SiiDetalleDeclaracion ded");
            sql.append(" WHERE ded.siiCuotaOperador.copCodigo = :codigoCuota");
            sql.append(" order by ded.ddeCodigo desc ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoCuota", codigoCuota);
            listaSiiDetalleDeclaracion = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDetalleDeclaracion;
    }    

    public SiiDetalleDeclaracion buscarPorCodigoDetalleDeclaracion(Long idCodigoDetalleDeclar) throws ExcepcionDAO {
        SiiDetalleDeclaracion retorno = null;
        try {
            retorno = manager.find(SiiDetalleDeclaracion.class, idCodigoDetalleDeclar);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return retorno;

    }


    /**
     *Metodo encargado de hacer la busqueda del detalle declaracion por el numero de referencia de pago entrante
     * @author David Tafur
     * @param numeroReferenciaPago
     * @return
     * @throws ExcepcionDAO
     */
    public SiiDetalleDeclaracion buscarDetalleDeclaracionPorReferenciaPago(long numeroReferenciaPago) throws ExcepcionDAO {
        SiiDetalleDeclaracion siiDetalleDeclaracion = new SiiDetalleDeclaracion();

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT u FROM SiiDetalleDeclaracion u");
            sql.append(" INNER JOIN u.siiReferenciaPagoDecl rfp");
            sql.append(" WHERE rfp.rpdNumero = :numeroReferenciaPago");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("numeroReferenciaPago", numeroReferenciaPago);

            List<SiiDetalleDeclaracion> listaDetalleDeclaracion = new ArrayList<SiiDetalleDeclaracion>();
            listaDetalleDeclaracion = consulta.getResultList();

            if(listaDetalleDeclaracion!=null&&listaDetalleDeclaracion.size()>0){
                    siiDetalleDeclaracion = listaDetalleDeclaracion.get(0); 
            }
         
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return siiDetalleDeclaracion;
    }


    /**
     * Método que busca los detalles declaración con detalle recaudo asociado
     * @author El Gatopardo
     * @param codigoCuota
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiDetalleDeclaracion> buscarDetalleDeclaracionDetRacaudoPorXCodigoCuota(Long codigoCuota) throws ExcepcionDAO {
        List<SiiDetalleDeclaracion> listaSiiDetalleDeclaracion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dde FROM SiiDetalleDeclaracion dde");
            sql.append(" INNER JOIN dde.siiDetalleRecaudo dre");
            sql.append(" WHERE dde.siiCuotaOperador.copCodigo = :codigoCuota");
            sql.append(" order by dde.ddeCodigo desc ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("codigoCuota", codigoCuota);
            listaSiiDetalleDeclaracion = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDetalleDeclaracion;
    }
    
    public List<SiiDetalleDeclaracion> buscarDetalleDeclaracionPorIdRecaudoBanco(Long idRecaudo) throws ExcepcionDAO {
        List<SiiDetalleDeclaracion> listaSiiDetalleDeclaracion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT dde FROM SiiDetalleDeclaracion dde");
            sql.append(" INNER JOIN dde.siiDetalleRecaudo dre");
            sql.append(" WHERE dre.siiRecaudoBanco.rbaCodigo = :idRecaudo");
            //sql.append(" order by dde.ddeCodigo desc ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idRecaudo", idRecaudo);
            listaSiiDetalleDeclaracion = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDetalleDeclaracion;
    }
    
    public List<RecaudoEstablecimientoManualVO> buscarPagoSinRecaudoEstabl(String numContrato) throws ExcepcionDAO {
              List<RecaudoEstablecimientoManualVO> listaRecaudoEstablecimientoManualVo = new ArrayList();
              try {
              StringBuilder sql = new StringBuilder();
              sql.append(" select con_numero,cop_num_cuota,dde_codigo,per_codigo,per_num_identificacion, nombre, ");
              sql.append(" (case when rba_fecha_rec is null then rps_fecha_estado else rba_fecha_rec end ) as fecha_recaudo , valor ");
              sql.append(" from ( ");
              sql.append(" select con.con_numero,cop.cop_num_cuota ,dde.dde_codigo ,p.per_codigo, p.per_num_identificacion ,    ");
              sql.append(" case when p.per_jur_nombre_largo is not null   then p.per_jur_nombre_largo   ");
              sql.append(" else (p.per_primer_nombre || ' ' ||p.per_segundo_nombre ||' ' ||p.per_primer_apellido || ' ' || p.per_segundo_apellido) end as  nombre,   ");
              sql.append(" rb.rba_fecha_rec  ,rps_fecha_estado,dde.DDE_VALOR_PAGADO valor  ");
              sql.append(" FROM SII_DETALLE_DECLARACION dde");
              sql.append(" left join sii_recaudo_establec rec on rec.dde_codigo = dde.dde_codigo");
              sql.append(" inner join sii_detalle_recaudo dr on dr.dre_codigo = dde.dre_codigo");
              sql.append(" INNER JOIN SII_CUOTA_OPERADOR cop  ON  cop.COP_CODIGO = dde.COP_CODIGO ");
              sql.append(" INNER JOIN SII_LIQUIDACION_MES lme  ON  lme.LME_CODIGO = cop.LME_CODIGO ");
              sql.append(" inner join sii_contrato con on lme.con_codigo = con.con_codigo");
              sql.append(" inner join sii_concepto_cuota co on cop.ccu_codigo = co.ccu_codigo");
              sql.append(" inner join sii_operador op on op.ope_codigo = con.ope_codigo");
              sql.append(" inner join sii_persona p on p.per_codigo = op.per_codigo");
              sql.append(" left join sii_recaudo_banco rb on rb.rba_codigo = dr.rba_codigo ");
              sql.append(" left join sii_recaudo_pse pse on pse.rps_codigo = dr.rps_codigo");
              sql.append(" left join sii_asignacion_recaudo asi on dde.dde_codigo = asi.dde_codigo  ");
              sql.append(" where NVL(dde.DDE_VALOR_PAGADO, 0) > 0  and rec.ree_codigo is null  and asi.are_codigo is null and co.ccu_abreviatura = 'DE' and con.con_numero = #numContrato )");
              sql.append(" order by 1,2 asc ");
                  

              Query query = manager.createNativeQuery(sql.toString());
              query.setParameter("numContrato", numContrato);
              List<Object[]> results = query.getResultList();
              if (results != null && !results.isEmpty()) {
                    for (Object[] object : results) {
                        RecaudoEstablecimientoManualVO recEstabManualVo =new RecaudoEstablecimientoManualVO();
                        DetalleDeclaracionVO detalleDeclaracionVo = new DetalleDeclaracionVO();
                        PersonaVO personaVo = new PersonaVO();
                        recEstabManualVo.setNumeroContrato((String) object[0]);
                        recEstabManualVo.setNumeroCuota(((BigDecimal) object[1]).longValue());
                        detalleDeclaracionVo.setDdeCodigo(((BigDecimal) object[2]).longValue());
                        recEstabManualVo.setDetalleDeclaracionVo(detalleDeclaracionVo);
                        personaVo.setPerCodigo(((BigDecimal) object[3]).longValue());
                        personaVo.setPerNumIdentificacion((String) object[4]);
                        personaVo.setPerJurNombreLargo((String) object[5]);    
                        recEstabManualVo.setPersonaVo(personaVo);
                        recEstabManualVo.setFechaPago((Date) object[6]);
                        recEstabManualVo.setValorPago((BigDecimal) object[7]);
                        listaRecaudoEstablecimientoManualVo.add(recEstabManualVo);
                    }
                }
                  
    } catch (PersistenceException pe) {
        String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
        throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
    } catch (Exception ex) {
        ex.printStackTrace();
        throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
    }
    return listaRecaudoEstablecimientoManualVo;
    }
    
    public List<SiiDetalleDeclaracion> buscarDetalleDeclaracionPorXVigenciaMesConNumero(Integer vigencia, Integer mes, String conNumero) throws ExcepcionDAO {
        List<SiiDetalleDeclaracion> listaSiiDetalleDeclaracion = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT ded FROM SiiDetalleDeclaracion ded ");
            sql.append(" INNER JOIN ded.siiCuotaOperador cop ");
            sql.append(" INNER JOIN cop.siiLiquidacionMes lme ");
            sql.append(" INNER JOIN lme.siiContrato con ");
            sql.append(" WHERE cop.copVigencia = :idVigencia ");
            sql.append(" AND  cop.mesCodigo = :idMes ");            
            sql.append(" AND con.conNumero = :conNumero ");
            sql.append(" order by ded.ddeCodigo desc ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idVigencia", vigencia);
            query.setParameter("idMes", mes);
            query.setParameter("conNumero", conNumero);
            listaSiiDetalleDeclaracion = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new ExcepcionDAO("Error general de base de datos : " + ex.getMessage(), getClass().getSimpleName());
        }
        return listaSiiDetalleDeclaracion;
    }                  
}
