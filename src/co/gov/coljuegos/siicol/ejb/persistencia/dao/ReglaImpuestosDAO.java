package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiGrupoRetenc;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiReglaImpuestos;
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
public class ReglaImpuestosDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public ReglaImpuestosDAO() {
        recursos = new Recursos();
    }

    public SiiReglaImpuestos buscarReglaImpuestosPorId(Long idReglaImpuestos) throws ExcepcionDAO {
        SiiReglaImpuestos reglaimpuestos = new SiiReglaImpuestos();
        try {
            reglaimpuestos = manager.find(SiiReglaImpuestos.class, idReglaImpuestos);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReglaImpuestosDAO");
        }
        return reglaimpuestos;
    }

    public List<SiiReglaImpuestos> buscarTodoReglaImpuestos() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sri FROM SiiReglaImpuestos sri");
            Query query = manager.createQuery(sql.toString());
            List<SiiReglaImpuestos> listaReglaImpuestos = query.getResultList();
            return listaReglaImpuestos;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReglaImpuestosDAO");
        }
    }

    /**
     * @author Modifica Giovanni
     * @param tipoContribuyente
     * @param tipoProveedor
     * @param idGrupoRetenciones
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiReglaImpuestos> buscarReglaImpuestosPorTipoContribuyenteTipoProveedorGrupoRetenciones(String tipoContribuyente,
                                                                                                         String tipoProveedor,
                                                                                                         Long idGrupoRetenciones) throws ExcepcionDAO {
        List<SiiReglaImpuestos> listaReglaImpuestos = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sri FROM SiiReglaImpuestos sri");
            sql.append(" WHERE sri.rimTipoContrib = :tipoContribuyente");
            sql.append(" AND sri.rimTipoProveed = :tipoProveedor");
            sql.append(" AND sri.siiGrupoRetenc.greCodigo = :idGrupoRetenciones");
            sql.append(" ORDER BY sri.siiTipoRetencion.treCodigo");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("tipoContribuyente", tipoContribuyente);
            query.setParameter("tipoProveedor", tipoProveedor);
            query.setParameter("idGrupoRetenciones", idGrupoRetenciones);

            listaReglaImpuestos = query.getResultList();


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReglaImpuestosDAO");
        }
        return listaReglaImpuestos;
    }

    /**
     * @author Giovanni
     * @return
     * @throws ExcepcionDAO
     */
    public List<SiiReglaImpuestos> buscarGruposReglaImpuestos() throws ExcepcionDAO {
        List<SiiReglaImpuestos> siiReglaImpuestoss = null;
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT DISTINCT sri.rimGrupoRespon, sri.siiGrupoRetenc.greCodigo");
            sql.append(" FROM SiiReglaImpuestos sri");

            Query query = manager.createQuery(sql.toString());

            List<Object[]> results = query.getResultList();
            if (results != null && results.size() > 0) {
                siiReglaImpuestoss = new ArrayList<SiiReglaImpuestos>();
                for (Object[] object : results) {
                    SiiReglaImpuestos siiReglaImpuestos = new SiiReglaImpuestos();
                    siiReglaImpuestos.setRimGrupoRespon((String) object[0]);

                    SiiGrupoRetenc siiGrupoRetenc = new SiiGrupoRetenc();
                    siiGrupoRetenc.setGreCodigo((Long) object[1]);
                    siiReglaImpuestos.setSiiGrupoRetenc(siiGrupoRetenc);
                    siiReglaImpuestoss.add(siiReglaImpuestos);
                }
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReglaImpuestosDAO");
        }
        return siiReglaImpuestoss;
    }


    /**
     * Realiza la consulta de aquellas Reglas de Impuestos que cumplen con los critoerios de b&uacute;squeda definidos.
     * @param greCodigo - C&oacute;digo del Grupo de Retenci&oacute;n.
     * @param rimTipoContrib - Tipo del Contribuyente.
     * @param rimTipoProveed - Tipo de Proveedor.
     * @param rimGrupoRespon - Grupo de Responsabilidades DIAN separadas por comas.
     * @return List of SiiReglaImpuestos
     * @throws ExcepcionDAO
     */
    public List<SiiReglaImpuestos> buscarPorDatosPersonaResponsabilidades(Long greCodigo, String rimTipoContrib,
                                                                          String rimTipoProveed,
                                                                          String rimGrupoRespon) throws ExcepcionDAO {
        List<SiiReglaImpuestos> resultado = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT rim FROM SiiReglaImpuestos rim ");
            sql.append("WHERE rim.rimCodigo = rim.rimCodigo ");


            if (greCodigo != null)
                sql.append("AND rim.siiGrupoRetenc.greCodigo = :greCodigo ");
            if (rimTipoContrib != null)
                sql.append("AND rim.rimTipoContrib = :rimTipoContrib ");
            if (rimTipoProveed != null)
                sql.append("AND rim.rimTipoProveed = :rimTipoProveed ");
            if (rimGrupoRespon != null)
                sql.append("AND rim.rimGrupoRespon = :rimGrupoRespon ");


            Query query = manager.createQuery(sql.toString());


            if (greCodigo != null)
                query.setParameter("greCodigo", greCodigo);
            if (rimTipoContrib != null)
                query.setParameter("rimTipoContrib", rimTipoContrib);
            if (rimTipoProveed != null)
                query.setParameter("rimTipoProveed", rimTipoProveed);
            if (rimGrupoRespon != null)
                query.setParameter("rimGrupoRespon", rimGrupoRespon);


            resultado = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }

        return (resultado);
    }


    public List<SiiReglaImpuestos> buscarReglaImpuestosPorTipoRetencion(String tipoRetencion, String tipoContribuyente,
                                                                        String tipoProveedor) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT sri FROM SiiReglaImpuestos sri WHERE sri.siiTipoRetencion.treCodigo = :tipoRetencion" +
                       " and sri.rimTipoContrib = :tipoContribuyente and sri.rimTipoProveed = :tipoProveedor ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("tipoRetencion", tipoRetencion);
            query.setParameter("tipoContribuyente", tipoContribuyente);
            query.setParameter("tipoProveedor", tipoProveedor);
            List<SiiReglaImpuestos> listaReglaImpuestos = query.getResultList();
            return listaReglaImpuestos;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "ReglaImpuestosDAO");
        }
    }

}


