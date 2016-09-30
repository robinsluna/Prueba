package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAreaColjuegos;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiAsignacionRecaudo;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.AsignacionRecaudoVO;
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
public class AsignacionRecaudoDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
   
   
    public AsignacionRecaudoDAO() {
        recursos = new Recursos();
    }
    
    public SiiAsignacionRecaudo insertarAsignacionRecaudo(SiiAsignacionRecaudo siiAsignacionRecaudo) throws ExcepcionDAO{
        try{
            manager.persist(siiAsignacionRecaudo);                                                                                
            manager.flush();                                                                                               
            return siiAsignacionRecaudo;                                                                                                 
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"AsignacionRecaudoDAO");
        }
    }
    
    public SiiAsignacionRecaudo actualizarAsignacionRecaudo (SiiAsignacionRecaudo siiAsignacionRecaudo) throws ExcepcionDAO{
        try{            
            manager.merge(siiAsignacionRecaudo);
            manager.flush();
            return siiAsignacionRecaudo;
        
        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "AsignacionRecaudoDAO");
        }
    }
    
    public SiiAsignacionRecaudo buscarAsignacionRecaudoPorId(Long areCodigo) throws ExcepcionDAO{
        SiiAsignacionRecaudo siiAsignacionRecaudo = null;
        try{
            siiAsignacionRecaudo = (SiiAsignacionRecaudo) manager.find(SiiAsignacionRecaudo.class, areCodigo);            
        }catch (PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"AreaColjuegosDAO");            
        }
        return siiAsignacionRecaudo;
    }
    
    
    public List<RecaudoEstablecimientoManualVO> todoAsignacionRecaudo() throws ExcepcionDAO {
              List<RecaudoEstablecimientoManualVO> listaRecaudoEstablecimientoManualVo = new ArrayList();
              try {
              StringBuilder sql = new StringBuilder();
              sql.append(" select con_numero,cop_num_cuota,dde_codigo,per_codigo,per_num_identificacion, nombre, ");
              sql.append(" (case when rba_fecha_rec is null then rps_fecha_estado else rba_fecha_rec end ) as fecha_recaudo , valor,are_codigo,are_estado ");
              sql.append(" from ( ");
              sql.append(" select con.con_numero,cop.cop_num_cuota ,dde.dde_codigo ,p.per_codigo, p.per_num_identificacion ,    ");
              sql.append(" case when p.per_jur_nombre_largo is not null   then p.per_jur_nombre_largo   ");
              sql.append(" else (p.per_primer_nombre || ' ' ||p.per_segundo_nombre ||' ' ||p.per_primer_apellido || ' ' || p.per_segundo_apellido) end as  nombre,   ");
              sql.append(" rb.rba_fecha_rec  ,rps_fecha_estado,dde.DDE_VALOR_PAGADO valor,asi.are_codigo,asi.are_estado    ");
              sql.append(" FROM SII_DETALLE_DECLARACION dde");
              sql.append(" inner join sii_detalle_recaudo dr on dr.dre_codigo = dde.dre_codigo");
              sql.append(" INNER JOIN SII_CUOTA_OPERADOR cop  ON  cop.COP_CODIGO = dde.COP_CODIGO ");
              sql.append(" INNER JOIN SII_LIQUIDACION_MES lme  ON  lme.LME_CODIGO = cop.LME_CODIGO ");
              sql.append(" inner join sii_contrato con on lme.con_codigo = con.con_codigo");
              sql.append(" inner join sii_concepto_cuota co on cop.ccu_codigo = co.ccu_codigo");
              sql.append(" inner join sii_operador op on op.ope_codigo = con.ope_codigo");
              sql.append(" inner join sii_persona p on p.per_codigo = op.per_codigo");
              sql.append(" left join sii_recaudo_banco rb on rb.rba_codigo = dr.rba_codigo ");
              sql.append(" left join sii_recaudo_pse pse on pse.rps_codigo = dr.rps_codigo");
              sql.append(" inner join sii_asignacion_recaudo asi on dde.dde_codigo = asi.dde_codigo  ");
              sql.append(" where NVL(dde.DDE_VALOR_PAGADO, 0) > 0  )");
              sql.append(" order by 1,2 desc ");
                  

              Query query = manager.createNativeQuery(sql.toString());
         
              List<Object[]> results = query.getResultList();
              if (results != null && !results.isEmpty()) {
                    for (Object[] object : results) {
                        RecaudoEstablecimientoManualVO recEstabManualVo =new RecaudoEstablecimientoManualVO();
                        DetalleDeclaracionVO detalleDeclaracionVo = new DetalleDeclaracionVO();
                        AsignacionRecaudoVO asignacionRecaudoVo = new AsignacionRecaudoVO();
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
                        asignacionRecaudoVo.setAreCodigo(((BigDecimal) object[8]).longValue() );
                        String tempEstado =(String) object[9];
                        if(tempEstado.equals("B") )
                            asignacionRecaudoVo.setAreEstado("BORRADOR");
                        if(tempEstado.equals("A") )
                            asignacionRecaudoVo.setAreEstado("APROBADO");
                        recEstabManualVo.setAsignacionRecaudoVo(asignacionRecaudoVo);
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
    
        public List<RecaudoEstablecimientoManualVO> buscarAsignacionRecaudoXid(Long areCodigo) throws ExcepcionDAO {
                  List<RecaudoEstablecimientoManualVO> listaRecaudoEstablecimientoManualVo = new ArrayList();
                  try {
                  StringBuilder sql = new StringBuilder();
                  sql.append(" select con_numero,cop_num_cuota,dde_codigo,per_codigo,per_num_identificacion, nombre, ");
                  sql.append(" (case when rba_fecha_rec is null then rps_fecha_estado else rba_fecha_rec end ) as fecha_recaudo , valor,are_codigo ");
                  sql.append(" from ( ");
                  sql.append(" select con.con_numero,cop.cop_num_cuota ,dde.dde_codigo ,p.per_codigo, p.per_num_identificacion ,    ");
                  sql.append(" case when p.per_jur_nombre_largo is not null   then p.per_jur_nombre_largo   ");
                  sql.append(" else (p.per_primer_nombre || ' ' ||p.per_segundo_nombre ||' ' ||p.per_primer_apellido || ' ' || p.per_segundo_apellido) end as  nombre,   ");
                  sql.append(" rb.rba_fecha_rec  ,rps_fecha_estado,dde.DDE_VALOR_PAGADO valor,asi.are_codigo   ");
                  sql.append(" FROM SII_DETALLE_DECLARACION dde");
                  sql.append(" inner join sii_detalle_recaudo dr on dr.dre_codigo = dde.dre_codigo");
                  sql.append(" INNER JOIN SII_CUOTA_OPERADOR cop  ON  cop.COP_CODIGO = dde.COP_CODIGO ");
                  sql.append(" INNER JOIN SII_LIQUIDACION_MES lme  ON  lme.LME_CODIGO = cop.LME_CODIGO ");
                  sql.append(" inner join sii_contrato con on lme.con_codigo = con.con_codigo");
                  sql.append(" inner join sii_concepto_cuota co on cop.ccu_codigo = co.ccu_codigo");
                  sql.append(" inner join sii_operador op on op.ope_codigo = con.ope_codigo");
                  sql.append(" inner join sii_persona p on p.per_codigo = op.per_codigo");
                  sql.append(" left join sii_recaudo_banco rb on rb.rba_codigo = dr.rba_codigo ");
                  sql.append(" left join sii_recaudo_pse pse on pse.rps_codigo = dr.rps_codigo");
                  sql.append(" inner join sii_asignacion_recaudo asi on dde.dde_codigo = asi.dde_codigo  ");
                  sql.append(" where asi.are_codigo = #areCodigo  )");
                  sql.append(" order by 1,2 asc ");
                      

                  Query query = manager.createNativeQuery(sql.toString());
                  query.setParameter("areCodigo", areCodigo);
                  List<Object[]> results = query.getResultList();
                  if (results != null && !results.isEmpty()) {
                        for (Object[] object : results) {
                            RecaudoEstablecimientoManualVO recEstabManualVo =new RecaudoEstablecimientoManualVO();
                            DetalleDeclaracionVO detalleDeclaracionVo = new DetalleDeclaracionVO();
                            AsignacionRecaudoVO asignacionRecaudoVo = new AsignacionRecaudoVO();
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
                            asignacionRecaudoVo.setAreCodigo(((BigDecimal) object[8]).longValue() );
                            recEstabManualVo.setAsignacionRecaudoVo(asignacionRecaudoVo);
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
    
    
 
    
}
