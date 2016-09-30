/*
 * SISTEMA	: SIICOL
 * MÓDULO	: Recaudo y transferencia
 * AUTOR	: Walter Becerra
 * FECHA	: 07-03-2014
 */


package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDetalleFinanc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDocumentoContable;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTrasladoBancario;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.vo.DocumentoContableVO;
import co.gov.coljuegos.siicol.ejb.vo.TrasladoCuentasBancariasVO;

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
public class TrasladoCuentasBancariasDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;
    

    
    public TrasladoCuentasBancariasDAO() {
        recursos = new Recursos();  
    }
    
    public SiiTrasladoBancario  buscarTrasladoBancarioPorId(Long idTrasCuentaBan) throws ExcepcionDAO {
        SiiTrasladoBancario siiTrasladoBancario = null;
        try {
            siiTrasladoBancario = (SiiTrasladoBancario) manager.find(SiiTrasladoBancario.class, idTrasCuentaBan);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "TrasladoCuentasBancariasDAO");
        }
        return siiTrasladoBancario;
    }

    public SiiTrasladoBancario insertarTrasladoBancario(SiiTrasladoBancario siiTrasladoBancario) throws ExcepcionDAO {
        try {
            manager.persist(siiTrasladoBancario);
            manager.flush();
            return siiTrasladoBancario;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TrasladoCuentasBancariasDAO");
        }
    }


    public List<SiiTrasladoBancario> buscarTodoTrasladoBancario() throws ExcepcionDAO {
        try {
            List<SiiTrasladoBancario> listaSiiTrasladoBancario = new ArrayList();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT persona FROM SiiTrasladoBancario persona");
            sql.append(" order by persona.tbaCodigo desc ");
            Query query = manager.createQuery(sql.toString());
            listaSiiTrasladoBancario = query.getResultList();
            return listaSiiTrasladoBancario;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TrasladoCuentasBancariasDAO");
        }
    }

    public SiiTrasladoBancario actualizarTrasladoBancario(SiiTrasladoBancario siiTrasladoBancario) throws ExcepcionDAO {
        try {
            manager.merge(siiTrasladoBancario);
            manager.flush();
            return siiTrasladoBancario;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "TrasladoCuentasBancariasDAO");
        }
    }
    
    public TrasladoCuentasBancariasVO buscarSaldoCuentaTrasladoBancario(Long idCuentaBancaria) throws ExcepcionDAO {
           TrasladoCuentasBancariasVO  unTrasladoCuentasBancariasVo= new TrasladoCuentasBancariasVO();
           BigDecimal valor = new BigDecimal(0);
           StringBuilder sql = new StringBuilder();
           sql.append(" select sum(d)-sum(c)as saldo from (");
           sql.append(" select sum(imc.imc_valor)as C, 0 as D from sii_cuenta_bancaria cba");
           sql.append(" inner join sii_cuentas_contables cco on cba.cco_codigo=cco.cco_codigo");
           sql.append(" inner join sii_imputacion_contable imc on cco.cco_codigo=imc.cco_codigo");
           sql.append(" inner join sii_documento_contable d on imc.dco_codigo = d.dco_codigo ");
           sql.append(" where imc.imc_tipo_movim='C' and cba.cba_codigo = #idCuentaBancaria  and d.edo_codigo = 2  union");
           sql.append(" select 0 as c   ,sum(imc.imc_valor) as D  from sii_cuenta_bancaria cba");
           sql.append(" inner join sii_cuentas_contables cco on cba.cco_codigo=cco.cco_codigo");
           sql.append(" inner join sii_imputacion_contable imc on cco.cco_codigo=imc.cco_codigo");  
          sql.append(" inner join sii_documento_contable d on imc.dco_codigo = d.dco_codigo ");
           sql.append(" where imc.imc_tipo_movim='D' and cba.cba_codigo = #idCuentaBancaria  and d.edo_codigo = 2  )");
           Query query = manager.createNativeQuery(sql.toString());
           query.setParameter("idCuentaBancaria",idCuentaBancaria);
           Object results = query.getSingleResult();
           unTrasladoCuentasBancariasVo.setTbaSaldoCuenta((BigDecimal) results);
    
    return unTrasladoCuentasBancariasVo;
    }
    
    public SiiDocumentoContable buscarPorCodigoTrasBanco (Long trbCodigo) throws ExcepcionDAO 
    {
            SiiDocumentoContable unaSiiDocumentoContable= new SiiDocumentoContable();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT dc FROM SiiDocumentoContable dc ");
            sql.append(" INNER JOIN  dc.siiTrasladoBancario tr  ");
            sql.append(" WHERE tr.tbaCodigo = :trbCodigo ");
                        
            Query query = manager.createQuery(sql.toString());
            query.setParameter("trbCodigo", trbCodigo);
            
            List<SiiDocumentoContable> listaSiiDocumentoContable = query.getResultList();
                if (listaSiiDocumentoContable.size() > 0) {
                    unaSiiDocumentoContable = listaSiiDocumentoContable.get(0);
                }
            
            return unaSiiDocumentoContable;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
    }
    
  
}
    