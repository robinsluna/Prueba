package co.gov.coljuegos.siicol.ejb.persistencia.dao.siito;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.siito.SiitoMovCargueInventario;
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
public class ConsultaInvSiicolDAO {

    @PersistenceContext(unitName = "siitoPU")
    private EntityManager manager;
    private Recursos recursos;

    
    public List<SiitoMovCargueInventario> insertarInventarioXNit(
                    String nitOperador) throws ExcepcionDAO {

        List<SiitoMovCargueInventario> listaInventarios = new ArrayList<SiitoMovCargueInventario>();
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT inv FROM SiitoMovCargueInventario inv");
        sql.append(" WHERE inv.movSolCodigo = :codigoSolicitudSiito");
        sql.append(" AND inv.movCargueInvTipSolCodigo = :codigoTipoSolicitud");

        try {
            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoSolicitudSiito", nitOperador);
            
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
