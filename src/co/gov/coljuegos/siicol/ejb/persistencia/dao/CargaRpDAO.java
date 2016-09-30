package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiCargaRp;
import co.gov.coljuegos.siicol.ejb.util.Recursos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean
public class CargaRpDAO {
    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    public CargaRpDAO() {
        recursos = new Recursos();
    }

    public SiiCargaRp buscarCargaRpPorId(Long id) throws ExcepcionDAO {
        try {
            return (SiiCargaRp) manager.find(SiiCargaRp.class, id);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CargaRpDAO");
        }
    }

    public SiiCargaRp insertarCargaRp(SiiCargaRp cargaRp) throws ExcepcionDAO {
        try {
            manager.persist(cargaRp);
            manager.flush();
            return cargaRp;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CargaRpDAO");
        }
    }

    public SiiCargaRp actualizarCargaRp(SiiCargaRp cargaRp) throws ExcepcionDAO {
        try {
            manager.merge(cargaRp);
            manager.flush();
            return cargaRp;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CargaRpDAO");
        }
    }

    public void elimiarCargaRp(Long id) throws ExcepcionDAO {
        try {
            manager.remove((SiiCargaRp) manager.find(SiiCargaRp.class, id));
            manager.flush();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CargaRpDAO");
        }
    }

    public List<SiiCargaRp> buscarTodoCargaRp() throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select o from SiiCargaRp o");
            Query query = manager.createQuery(sql.toString());
            return query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CargaRpDAO");
        }
    }

    public SiiCargaRp buscarCargaRpPorNombreArchivo(String crpNombreArch) throws ExcepcionDAO {
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT o FROM SiiCargaRp o WHERE o.crpNombreArch = :crpNombreArch ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("crpNombreArch", crpNombreArch);
            return (SiiCargaRp) query.getSingleResult();
        }  catch (NoResultException nr) {
            return new SiiCargaRp();
        }
        catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError, "CargaRpDAO");
        }
    }

    public Long buscarUltimoConsecutivo(Calendar calendar) throws ExcepcionDAO {
        return (this.buscarUltimoConsecutivo(calendar.getTime()));
    }


    /**
     * Realiza la consulta del &uacute;ltimo consecutivo de archivo cargado en el sistema, correspondiente a la fecha suministrada.
     * @param fecha - Fecha correspondiente al consecutivo que se desea buscar.
     * @return Consecutivo del archivo en formato yyyyMMdd-#
     * @throws ExcepcionDAO
     */
    public Long buscarUltimoConsecutivo(Date fecha) throws ExcepcionDAO {
        DateFormat df = new SimpleDateFormat("yyyyMMdd");
        String formatoFecha = df.format(fecha);
        return (this.buscarUltimoConsecutivo(formatoFecha));
    }


    /**
     * Realiza la consulta del &uacute;ltimo consecutivo de archivo cargado en el sistema, correspondiente al formato de fecha suministrado.
     * @param formatoFecha - Fecha en formato yyyyMMdd.
     * @return Consecutivo del archivo en formato yyyyMMdd-#
     * @throws ExcepcionDAO
     */
    public Long buscarUltimoConsecutivo(String formatoFecha) throws ExcepcionDAO {
        Long consecutivo = 0L;

        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT SUBSTR(NOMBRE_ARCH, INSTR(NOMBRE_ARCH, '-',1,2)+1, LENGTH(NOMBRE_ARCH)-INSTR(NOMBRE_ARCH, '-')) AS CONSECUTIVO ");
            sql.append("FROM ( ");
            sql.append("        SELECT MAX(crp.CRP_NOMBRE_ARCH) AS NOMBRE_ARCH ");
            sql.append("        FROM SII_CARGA_RP crp ");
            sql.append("        WHERE crp.CRP_NOMBRE_ARCH LIKE #formatoFecha ");
            sql.append(") ");

            Query query = manager.createNativeQuery(sql.toString());
            query.setParameter("formatoFecha", "%" + formatoFecha + "%");

            String result = (String) query.getSingleResult();
            if (result != null)
                consecutivo = Long.parseLong(result);
        } catch (NoResultException e) {
            consecutivo = 0L;
        } catch (NumberFormatException e) {
            consecutivo = 0L;
        } catch (PersistenceException e) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + e.getMessage(), getClass().getSimpleName());
        }

        return (consecutivo);
    }
}
