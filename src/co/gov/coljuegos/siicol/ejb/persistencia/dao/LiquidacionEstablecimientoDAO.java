package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiBanco;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiLiquidacionEstabl;
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
public class LiquidacionEstablecimientoDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public LiquidacionEstablecimientoDAO() {
        recursos = new Recursos();
    }


    public List<SiiLiquidacionEstabl> buscarTodaLiquidacionEstablXidCuotaOperador(Long idCuota) throws ExcepcionDAO {
        List<SiiLiquidacionEstabl> listaSiiLiquidacionEstabl;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" select liq FROM SiiLiquidacionEstabl liq ");
            sql.append(" INNER JOIN liq.siiLiquidacionMes lme ");
            sql.append(" INNER JOIN lme.siiCuotaOperadorList cuo");
            sql.append(" WHERE cuo.copCodigo = :idCuota");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("idCuota", idCuota);

            listaSiiLiquidacionEstabl = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "SolicitudEstMercadoDAO");
        } catch (Exception ex) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "SolicitudEstMercadoDAO");
        }
        return listaSiiLiquidacionEstabl;
    }

    public SiiLiquidacionEstabl insertarSiiLiquidacionEstabl(SiiLiquidacionEstabl liquidacionEst) throws ExcepcionDAO {
        try {
            manager.persist(liquidacionEst);
            manager.flush();
            return liquidacionEst;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LiquidacionEstablecimientoDAO");
        }
    }

    /**
     *Metodo encargado de buscar la liquidacion de un establecimiento teniendo como parametros de entrada la liquidacion
     * mensual para el operador y el codigo del establecimiento
     * @author David Tafur
     * @param codigoEstablecimiento
     * @param codigoLiquidacionMes
     * @return
     * @throws ExcepcionDAO
     */
    public SiiLiquidacionEstabl buscarLiquidacionEstablecimientoXCodigoEstablXCodigoLiqMes(long codigoEstablecimiento,
                                                                                           long codigoLiquidacionMes) throws ExcepcionDAO {

        SiiLiquidacionEstabl siiLiquidacionEstabl = new SiiLiquidacionEstabl();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT lie FROM SiiLiquidacionEstabl lie");
            sql.append(" WHERE lie.siiLiquidacionMes.lmeCodigo =:codigoLiqMes");
            sql.append(" AND lie.siiEstablecimiento.estCodigo =:codigoEstablecimiento");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoLiqMes", codigoLiquidacionMes);
            consulta.setParameter("codigoEstablecimiento", codigoEstablecimiento);

            List<SiiLiquidacionEstabl> listaLiquidacionEs = new ArrayList<SiiLiquidacionEstabl>();
            listaLiquidacionEs = consulta.getResultList();

            if (listaLiquidacionEs.size() > 0) {
                siiLiquidacionEstabl = listaLiquidacionEs.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "LiquidacionEstablecimientoDAO");
        }
        return siiLiquidacionEstabl;
    }
    
    public SiiLiquidacionEstabl buscarLiquidacionEstablXId(Long lesCodigo) throws ExcepcionDAO {
        SiiLiquidacionEstabl retornoiquidacionEstabl = null;
        try {
            retornoiquidacionEstabl = (SiiLiquidacionEstabl) manager.find(SiiLiquidacionEstabl.class, lesCodigo);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "RecaudoBancoDAO");
        }
        return retornoiquidacionEstabl;

    }

    

}
