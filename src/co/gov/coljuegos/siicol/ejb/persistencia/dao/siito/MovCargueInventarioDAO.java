package co.gov.coljuegos.siicol.ejb.persistencia.dao.siito;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoMovCargueInventario;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import co.gov.coljuegos.siicol.ejb.wsvo.SolicitudAutorizaWSVO;

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
public class MovCargueInventarioDAO {

    @PersistenceContext(unitName = "siitoPU")
    private EntityManager manager;
    private Recursos recursos;

    /**
     *Metodo encargado de hacer la consulta de todos los registros de la tabla temporal de siito que cumpla con la condicion del codigo de la solicitud y el codigo del movimiento
     * @param codigoSolicitud
     * @param codigoMovimiento
     * @return
     */
    public List<SiitoMovCargueInventario> consultarMovCargueInventarioXCodSolicitudYCodigoMov(long codigoSolicitudSiito,
                                                                                              long codigoTipoSolicitud) throws ExcepcionDAO {

        List<SiitoMovCargueInventario> listaInventarios = new ArrayList<SiitoMovCargueInventario>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT inv FROM SiitoMovCargueInventario inv");
        sql.append(" WHERE inv.movSolCodigo = :codigoSolicitudSiito");
        sql.append(" AND inv.movCargueInvTipSolCodigo = :codigoTipoSolicitud");

        try {
            Query consulta = manager.createQuery(sql.toString(),SiitoMovCargueInventario.class);
            consulta.setParameter("codigoSolicitudSiito", codigoSolicitudSiito);
            consulta.setParameter("codigoTipoSolicitud", codigoTipoSolicitud);

            listaInventarios = consulta.getResultList();
        } catch (PersistenceException e) {
            e.printStackTrace();
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), "MovCargueInventarioDAO");
        } catch (Exception ex) {
            ex.printStackTrace();
            System.out.print(ex.getMessage());
        }

        return listaInventarios;
    }
    
    public List<SiitoMovCargueInventario> consultarElementosXTipoNovedad(long codigoSolicitudSiito,long codigoTipoNovedad) throws ExcepcionDAO {

        List<SiitoMovCargueInventario> listaInventarios = new ArrayList<SiitoMovCargueInventario>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT inv FROM SiitoMovCargueInventario inv");
        sql.append(" WHERE inv.movSolCodigo = :codigoSolicitudSiito");
        sql.append(" AND inv.movCargueInvTipNov = :codigoTipoNovedad");

        try {
            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoSolicitudSiito", codigoSolicitudSiito);
            consulta.setParameter("codigoTipoNovedad", codigoTipoNovedad);

            listaInventarios = consulta.getResultList();
        } catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), "MovCargueInventarioDAO");
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }

        return listaInventarios;
    }

}
