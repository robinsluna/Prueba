package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCotizacionEstudio;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.math.BigDecimal;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class CotizacionEstudioDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;


    public CotizacionEstudioDAO() {
        recursos = new Recursos();

    }

    public SiiCotizacionEstudio buscarCotizacionEstudioPorId(Long idCotizacionEstudio) throws ExcepcionDAO {
        SiiCotizacionEstudio localCotizacionEstudio = null;
        try {
            localCotizacionEstudio =
                (SiiCotizacionEstudio) manager.find(SiiCotizacionEstudio.class, idCotizacionEstudio);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CotizacionEstudioDAO");
        }
        return localCotizacionEstudio;
    }


    public List<SiiCotizacionEstudio> buscarCotizacionEstudioPorEM(Long idEstudioMercado) throws ExcepcionDAO {
        List<SiiCotizacionEstudio> listaCotizacionEstudio = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT o FROM SiiCotizacionEstudio o INNER JOIN o.siiEstudioMercado estudioMercado WHERE estudioMercado.emeCodigo = :idEstudioMercado");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idEstudioMercado", idEstudioMercado);
            listaCotizacionEstudio = query.getResultList();
            return listaCotizacionEstudio;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CotizacionEstudioDAO");
        }

    }

    public SiiCotizacionEstudio insertarCotizacionEstudio(SiiCotizacionEstudio cotizacionEstudio) throws ExcepcionDAO {
        try {
            manager.persist(cotizacionEstudio);
            manager.flush();
            return cotizacionEstudio;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CotizacionEstudioDAO");
        }
    }

    public SiiCotizacionEstudio actualizarCotizacionEstudio(SiiCotizacionEstudio cotizacionEstudio) throws ExcepcionDAO {
        try {
            manager.merge(cotizacionEstudio);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CotizacionEstudioDAO");
        }
        return cotizacionEstudio;
    }

    public void eliminarCotizacionEstudio(Long idCotizacionEstudio) throws ExcepcionDAO {
        try {
            SiiCotizacionEstudio localCotizacionEstudio =
                (SiiCotizacionEstudio) manager.find(SiiCotizacionEstudio.class, idCotizacionEstudio);
            manager.remove(localCotizacionEstudio);
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CotizacionEstudioDAO");
        }
    }

    public List<SiiCotizacionEstudio> buscarTodoCotizacionEstudio() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiCotizacionEstudio o");
            //            sql.append(" where o.cotizacionEstudio.cesCodigo=:codigo");
            Query query = manager.createQuery(sql.toString());
            //            query.setParameter("codigo", cotizacionEstudio.getCesCodigo());
            List<SiiCotizacionEstudio> listaCotizacionEstudio = query.getResultList();
            return listaCotizacionEstudio;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CotizacionEstudioDAO");
        }
    }


    /**
     * @param prcCodigo
     * @return lista de cotizaciones por proceso de contratacion
     * @throws ExcepcionDAO
     */
    public List<SiiCotizacionEstudio> ofertas(Long prcCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiCotizacionEstudio o INNER JOIN o.siiEstudioMercado eme WHERE eme.siiProcesoContratacion1.prcCodigo=:prcCodigo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("prcCodigo", prcCodigo);
            List<SiiCotizacionEstudio> listaCotizacionEstudio = query.getResultList();
            return listaCotizacionEstudio;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CotizacionEstudioDAO");
        }
    }
    
    public BigDecimal preciosMinimosTotales(Long emeCodigo) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT MIN(ces.ces_valor_total)\n" + 
            "FROM sii_cotizacion_estudio ces\n" + 
            "WHERE ces.eme_codigo = #emeCodigo");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("emeCodigo", emeCodigo);
            return (BigDecimal) query.getSingleResult();

        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemCotizacionDAO");
        }
    }

    public String nombreProveedorMinimosTotales(Long emeCodigo) throws ExcepcionDAO  {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  LISTAGG(CASE\n" + 
            "    WHEN per_tipo_persona = 'J'\n" + 
            "    THEN per_jur_nombre_largo\n" + 
            "    WHEN per_tipo_persona = 'N'\n" + 
            "    THEN per_primer_nombre\n" + 
            "      ||' '\n" + 
            "      ||per_segundo_nombre\n" + 
            "      ||' '\n" + 
            "      ||per_primer_apellido\n" + 
            "      ||' '\n" + 
            "      ||per_segundo_apellido\n" + 
            "      end, ', ') WITHIN GROUP (order by 1)  \n" + 
            "    FROM sii_persona\n" + 
            "    WHERE per_codigo IN\n" + 
            "      (SELECT per_codigo\n" + 
            "      FROM sii_proveedor\n" + 
            "      WHERE pro_codigo IN\n" + 
            "        (SELECT pro_codigo\n" + 
            "        FROM sii_cotizacion_estudio\n" + 
            "        WHERE ces_valor_total =\n" + 
            "          (SELECT MIN(ces.ces_valor_total)\n" + 
            "          FROM sii_cotizacion_estudio ces\n" + 
            "          WHERE ces.eme_codigo = #emeCodigo\n" + 
            "          )\n" + 
            "        )\n" + 
            "      )");
            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("emeCodigo", emeCodigo);
            return (String) query.getSingleResult();

        }catch(PersistenceException pe){
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError,"ItemCotizacionDAO");
        }
    }
}
