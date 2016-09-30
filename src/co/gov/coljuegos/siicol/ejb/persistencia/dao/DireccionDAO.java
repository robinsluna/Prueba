package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDenunciaOrdenTrab;

import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiDireccion;

import java.math.BigDecimal;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.PersistenceException;
import javax.persistence.Query;

@Stateless
@LocalBean

public class DireccionDAO extends AbstractDAO<Long, SiiDireccion> {
    
    
    public DireccionDAO() {
        super(SiiDireccion.class);
    }

    /**
     * Buscar la dirección completa y armada según id de la denuncia
     * @return direccion - String
     * @throws ExcepcionDAO
     */

    public String buscarDireccionCompletaXIdDenuncia(Long denCodigo) throws ExcepcionDAO {
        String direccion = null;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT concat(tcd.tcd_nombre,concat(' ',concat(d.dir_calle_ppal, concat(tsc.tsc_nombre, concat(tsu.tsu_nombre, concat(tsc12.tsc_nombre,concat(' ',concat(tsd.tsd_nombre,concat(' ' , concat(d.dir_numero1, concat(tsc_cod.tsc_nombre, concat('-',concat(d.dir_numero2,concat( ' ', concat( tsd_num2.tsd_nombre, d.dir_info_adicional)))) ) ) ) ) ) ) ) )))) Direccion ");
            sql.append("FROM sii_direccion d ");
            sql.append("INNER JOIN sii_denuncia den ");
            sql.append("ON d.dir_codigo = den.dir_codigo ");
            sql.append("INNER JOIN sii_tipo_calle_direccion tcd ");
            sql.append("ON tcd.tcd_codigo = d.tcd_codigo ");
            sql.append("LEFT JOIN sii_tipo_sufijo1_calle tsc ");
            sql.append("ON tsc.tsc_codigo = d.tsc_codigo1_ppal ");
            sql.append("LEFT JOIN sii_tipo_sufijo2_calle tsu ");
            sql.append("ON tsu.tsu_codigo = d.tsu_codigo ");
            sql.append("LEFT JOIN sii_tipo_sufijo1_calle tsc12 ");
            sql.append("ON tsc12.tsc_codigo= d.tsc_codigo2_ppal ");
            sql.append("LEFT JOIN sii_tipo_sector_direc tsd ");
            sql.append("ON tsd.tsd_codigo= d.tsd_codigo_ppal ");
            sql.append("LEFT JOIN sii_tipo_sufijo1_calle tsc_cod ");
            sql.append("ON tsc_cod.tsc_codigo = d.tsc_codigo_num1 ");
            sql.append("LEFT JOIN sii_tipo_sector_direc tsd_num2 ");
            sql.append("ON tsd_num2.tsd_codigo= d.tsd_codigo_num2 ");
            sql.append("WHERE den.den_codigo  = ");
            sql.append(denCodigo);
            sql.append(" AND d.dir_codigo      =den.dir_codigo ");
            sql.append("AND d.dir_activo      = 'S' ");
            sql.append("ORDER BY direccion ");

            Query query = em.createNativeQuery(sql.toString());

            if(query.getSingleResult() != null) {
                direccion = query.getSingleResult().toString();
            }

        } catch(javax.persistence.NoResultException ne) {
            direccion = null;
        } catch(PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return direccion;
    }
}
