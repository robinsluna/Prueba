package co.gov.coljuegos.siicol.ejb.persistencia.dao;

import co.gov.coljuegos.siicol.ejb.excepcion.ExcepcionDAO;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiPersona;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiTipoIdentificacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUbicacion;
import co.gov.coljuegos.siicol.ejb.persistencia.entity.SiiUsuario;
import co.gov.coljuegos.siicol.ejb.util.Recursos;
import co.gov.coljuegos.siicol.ejb.util.Utilidades;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;


@Stateless
@LocalBean
public class PersonaDAO {

    @PersistenceContext(unitName = "siicolPU")
    private EntityManager manager;
    private Recursos recursos;

    @EJB
    private TipoIdentificacionDAO tipoIdentificacionDao;
    @EJB
    private UbicacionDAO ubicacionDao;


    public PersonaDAO() {
        recursos = new Recursos();
    }

    public SiiPersona insertarPersona(SiiPersona persona) throws ExcepcionDAO {
        try {
            persona.setPerFechaCrea(new Date());
            manager.persist(persona);
            manager.flush();
            return persona;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
    }

    
    public SiiPersona buscarPersonaPorId(Long idPersona) throws ExcepcionDAO {
        SiiPersona personaRetorno = null;
        try {
            personaRetorno = manager.find(SiiPersona.class, idPersona);
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "EstadoUsuarioDAO");
        }
        return personaRetorno;
    }

    public SiiPersona actualizarPersona(SiiPersona persona) throws ExcepcionDAO {
        try {
            manager.merge(persona);
            manager.flush();
            return persona;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
    }

    public void eliminarPersona(Long idPersona) throws ExcepcionDAO {
        try {
            SiiPersona personaBorrar = manager.find(SiiPersona.class, idPersona);
            manager.remove(personaBorrar);
            manager.flush();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
    }

    public List<SiiPersona> buscarTodoPersona() throws ExcepcionDAO {
        try {
            List<SiiPersona> listaPersona = new ArrayList();
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT persona FROM SiiPersona persona");
            Query query = manager.createQuery(sql.toString());
            listaPersona = query.getResultList();
            return listaPersona;

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
    }

    public List<SiiPersona> buscarPersonaPorIdentificacionPorTipoIdentificacion(SiiPersona unPersona) throws ExcepcionDAO {
        List<SiiPersona> PersonaRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT persona FROM SiiPersona persona"); // INNER JOIN persona.siiTipoIdentificacion1 tid");
            sql.append(" WHERE persona.perNumIdentificacion = :numIdentificacion");
            sql.append(" AND persona.siiTipoIdentificacion1.tidCodigo = :tipoIdentificacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numIdentificacion", unPersona.getPerNumIdentificacion());
            query.setParameter("tipoIdentificacion", unPersona.getSiiTipoIdentificacion1().getTidCodigo());
            PersonaRetorno = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        //SolicitudEstMercadoVO retornoSolicitudEstMercadoVo = new SolicitudEstMercadoVO();
        return PersonaRetorno;
    }

    public List<SiiPersona> buscarPersonaPorIdUsuario(Long idUsuario) throws ExcepcionDAO {
        List<SiiPersona> PersonaRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT per FROM SiiUsuario usu ");
            sql.append(" INNER JOIN usu.siiPersona per");
            sql.append(" WHERE usu.usuCodigo = :idUsuario");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("idUsuario", idUsuario);
            PersonaRetorno = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        //SolicitudEstMercadoVO retornoSolicitudEstMercadoVo = new SolicitudEstMercadoVO();
        return PersonaRetorno;
    }

    public SiiPersona buscarPersonaPorNumeroIdYTipoId(String numeroIdentificacion, String tipoId) throws ExcepcionDAO {
        SiiPersona persona = null;
        List<SiiPersona> listaSiiPersona = new ArrayList<SiiPersona>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT per FROM SiiPersona per WHERE per.perNumIdentificacion = :numeroIdentificacion AND per.siiTipoIdentificacion1.tidNombreCorto = :tipoId ");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numeroIdentificacion", numeroIdentificacion);
            query.setParameter("tipoId", tipoId);
            listaSiiPersona = query.getResultList();
            if (listaSiiPersona != null && !listaSiiPersona.isEmpty()) {
                persona = listaSiiPersona.get(0);
            }
            //persona = (SiiPersona) query.getSingleResult();

        } catch (javax.persistence.NoResultException ne) {
            persona = null;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "PersonaDAO");
        }
        return persona;
    }


    /**
     * Realiza la b&uacute;squeda de una Persona por medio de su N&uacute;mero y Tipo de Identificaci&oacute;n.
     * @param perNumIdentificacion - N&uacute;mero de Identificaci&oacute;n.
     * @param tidCodigo - C&oacute;digo del Tipo de Identificaci&oacute;n.
     * @return instance of SiiPersona
     * @throws ExcepcionDAO
     */
    public SiiPersona buscarPersonaPorTipoYNumeroIdentificacion(Long tidCodigo,
                                                                String perNumIdentificacion) throws ExcepcionDAO {
        SiiPersona persona = null;
        List<SiiPersona> listaSiiPersona = new ArrayList<SiiPersona>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT per FROM SiiPersona per ");
            sql.append("WHERE per.perNumIdentificacion = :perNumIdentificacion ");
            sql.append("AND per.siiTipoIdentificacion1.tidCodigo = :tidCodigo ");

            Query query = manager.createQuery(sql.toString());
            query.setParameter("perNumIdentificacion", perNumIdentificacion);
            query.setParameter("tidCodigo", tidCodigo);

            listaSiiPersona = query.getResultList();
            if (listaSiiPersona != null && !listaSiiPersona.isEmpty()) {
                persona = listaSiiPersona.get(0);
            }

        } catch (javax.persistence.NoResultException ne) {
            persona = null;
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), "PersonaDAO");
        }
        return persona;
    }


    public List<SiiPersona> buscarPersonaPorIdentificacionPorTipoIdentificacionUsuario(SiiPersona unPersona) throws ExcepcionDAO {
        List<SiiPersona> PersonaRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT per FROM SiiUsuario usuario");
            sql.append(" inner join usuario.siiPersona per ");
            sql.append(" WHERE per.perNumIdentificacion = :numIdentificacion");
            sql.append(" AND per.siiTipoIdentificacion1.tidCodigo = :tipoIdentificacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numIdentificacion", unPersona.getPerNumIdentificacion());
            query.setParameter("tipoIdentificacion", unPersona.getSiiTipoIdentificacion1().getTidCodigo());
            PersonaRetorno = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        //SolicitudEstMercadoVO retornoSolicitudEstMercadoVo = new SolicitudEstMercadoVO();
        return PersonaRetorno;
    }


    public List<SiiUsuario> buscarPersonaUsuario() throws ExcepcionDAO {
        List<SiiUsuario> listaUsuario = new ArrayList<SiiUsuario>();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT usuario FROM SiiUsuario usuario inner join usuario.siiPersona per");
            Query query = manager.createQuery(sql.toString());
            listaUsuario = query.getResultList();
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        return listaUsuario;
    }


    public List<SiiPersona> buscarPersonaPorNombreId(SiiPersona unaPersona) throws ExcepcionDAO {
        List<SiiPersona> listaPersonaRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT per FROM SiiPersona  per");
            sql.append(" WHERE 1 = 1");
            if (unaPersona.getPerPrimerNombre()!= null && !unaPersona.getPerPrimerNombre().equals("")) {
                sql.append(" AND UPPER(per.perPrimerNombre) LIKE :primerNombre");
            }
            if (unaPersona.getPerPrimerApellido()!= null && !unaPersona.getPerPrimerApellido().equals("")) {
                sql.append(" AND UPPER(per.perPrimerApellido) LIKE :primerApellido");
            }
            if (unaPersona.getPerSegundoNombre()!= null && !unaPersona.getPerSegundoNombre().equals("")) {
                sql.append(" AND UPPER(per.perSegundoNombre) LIKE :segundoNombre");
            }
            if (unaPersona.getPerSegundoApellido() != null && !unaPersona.getPerSegundoApellido().equals("")) {
                sql.append(" AND UPPER(per.perSegundoApellido) LIKE :segundoApellido");
            }
            if (unaPersona.getSiiTipoIdentificacion1() != null &&
                unaPersona.getSiiTipoIdentificacion1().getTidCodigo() != null) {
                sql.append(" AND per.siiTipoIdentificacion1.tidCodigo = :tidCodigo");
            }
            if (unaPersona.getPerNumIdentificacion()!= null && !unaPersona.getPerNumIdentificacion().equals("")) {
                sql.append(" AND per.perNumIdentificacion LIKE :numIdentificacion");
            }
            if (unaPersona.getPerTipoPersona() != null) {
                if (!unaPersona.getPerTipoPersona().equals("")) {
                    sql.append(" AND per.perTipoPersona = :tipoPersona");
                }
            }
            if (unaPersona.getPerJurNombreLargo() != null) {
                if (!unaPersona.getPerJurNombreLargo().equals("")) {
                    sql.append(" AND per.perJurNombreLargo LIKE :perJurNombreLargo");
                }
            }

            sql.append(" ORDER BY per.perPrimerNombre");

            Query query = manager.createQuery(sql.toString());

            if (unaPersona.getPerPrimerNombre() !=null && !unaPersona.getPerPrimerNombre().equals("")) {
                query.setParameter("primerNombre", "%" + unaPersona.getPerPrimerNombre().toUpperCase() + "%");
            }
            if (unaPersona.getPerPrimerApellido() !=null && !unaPersona.getPerPrimerApellido().equals("")) {
                query.setParameter("primerApellido", "%" + unaPersona.getPerPrimerApellido().toUpperCase() + "%");
            }
            if (unaPersona.getPerSegundoNombre() !=null && !unaPersona.getPerSegundoNombre().equals("")) {
                query.setParameter("segundoNombre", "%" + unaPersona.getPerSegundoNombre().toUpperCase() + "%");
            }
            if (unaPersona.getPerSegundoApellido() !=null && !unaPersona.getPerSegundoApellido().equals("")) {
                query.setParameter("segundoApellido", "%" + unaPersona.getPerSegundoApellido().toUpperCase() + "%");
            }
            if (unaPersona.getSiiTipoIdentificacion1() != null &&
                unaPersona.getSiiTipoIdentificacion1().getTidCodigo() != null) {
                query.setParameter("tidCodigo", unaPersona.getSiiTipoIdentificacion1().getTidCodigo());
            }
            if (unaPersona.getPerNumIdentificacion()!= null && !unaPersona.getPerNumIdentificacion().equals("")) {
                query.setParameter("numIdentificacion", "%" + unaPersona.getPerNumIdentificacion() + "%");
            }
            if (unaPersona.getPerTipoPersona() != null) {
                if (!unaPersona.getPerTipoPersona().equals("")) {
                    query.setParameter("tipoPersona", unaPersona.getPerTipoPersona());
                }
            }
            if (unaPersona.getPerJurNombreLargo() != null) {
                if (!unaPersona.getPerJurNombreLargo().equals("")) {
                    query.setParameter("perJurNombreLargo", "%" + unaPersona.getPerJurNombreLargo().toUpperCase()  + "%");
                }
            }

            //query.setParameter("numIdentificacion", unPersona.getPerNumIdentificacion());
            //query.setParameter("tipoIdentificacion", unPersona.getSiiTipoIdentificacion1().getTidCodigo());
            listaPersonaRetorno = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        return listaPersonaRetorno;
    }


    /**
     * Realiza la b&uacute;squeda de Personas por medio del NIT/Nombre.
     * @param nombre - Nombre de la Persona Natural/Jur&iacute;dica.
     * @throws ExcepcionDAO
     */
    public List<SiiPersona> buscarPersonaPorNombre(String nombre) throws ExcepcionDAO {
        return (this.buscarPersonaPorNombreId(nombre, null));
    }


    /**
     * Realiza la b&uacute;squeda de Personas por medio del NIT/Nombre y N&uacute;mero de Identificaci&oacute;n.
     * @param nombre - Nombre de la Persona.
     * @param numIdentificacion - N&uacute;mero de Identificaci&oacute;n de la Persona.
     * @throws ExcepcionDAO
     */
    public List<SiiPersona> buscarPersonaPorNombreId(String nombre, Long numIdentificacion) throws ExcepcionDAO {
        List<SiiPersona> resultado = null;
        try {
            StringBuilder sql = new StringBuilder();

            sql.append("SELECT per FROM SiiPersona per ");
            sql.append(" WHERE 1 = 1 ");

            if (nombre != null) {
                sql.append(" AND (UPPER(per.perJurNombreLargo) like :nombre or UPPER(per.perJurNombreCorto) like :nombre ");
                sql.append("      or UPPER(per.perPrimerNombre) like :nombre or UPPER(per.perSegundoNombre) like :nombre ");
                sql.append("      or UPPER(per.perPrimerApellido) like :nombre  or UPPER(per.perSegundoApellido) like :nombre) ");
            }

            if (numIdentificacion != null) {
                sql.append(" AND per.perNumIdentificacion LIKE :numIdentificacion ");
            }

            Query query = manager.createQuery(sql.toString());

            if (nombre != null)
                query.setParameter("nombre", "%" + nombre.toUpperCase() + "%");

            if (numIdentificacion != null)
                query.setParameter("numIdentificacion", "%" + numIdentificacion + "%");

            resultado = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), getClass().getSimpleName());
        }
        return (resultado);
    }

    public List<SiiPersona> buscarPersonaProveedores() throws ExcepcionDAO {
        List<SiiPersona> PersonaRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append(" SELECT per FROM SiiPersona per");
            //sql.append(" inner join SiiProveedor pro on pro.proCodigo = per.perCodigo");
            Query query = manager.createQuery(sql.toString());
            PersonaRetorno = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        //SolicitudEstMercadoVO retornoSolicitudEstMercadoVo = new SolicitudEstMercadoVO();
        return PersonaRetorno;
    }


    /**
     * Realiza la consulta de todas las Personas que se encuentren dentro del rango especificado, de acuerdo al ordenamiento implementado.
     * @param first - Valor inicial del rango.
     * @param last - Valor filan del rango.
     * @param sortField - Nombre de la columna por medio la cual se realizar&aacute; el ordenamiento.
     * @param sortOrder - Cadena del sentido de ordenamiento (ASC/DESC).
     * @return List of SiiDocumentoContable
     * @throws ExcepcionDAO
     */
    public List<SiiPersona> buscarPorRangoPaginacion(Integer first, Integer last, String sortField,
                                                     String sortOrder) throws ExcepcionDAO {
        return (this.buscarPorFiltrosYPaginacion(null, sortField, sortOrder, first, last));
    }


    /**
     * Realiza la consulta de todos los Documentos Contables qe se encuentren dentro del rango especificado.
     * @param filtros - Mapa que contiene el nombre y valor de los filtros que se desean aplicar a la b&uacute;squeda.
     * @param sortField - Nombre de la columna por medio la cual se realizar&aacute; el ordenamiento.
     * @param sortOrder - Cadena del sentido de ordenamiento (ASC/DESC).
     * @return List of SiiDocumentoContable
     * @throws ExcepcionDAO
     */
    public List<SiiPersona> buscarPorFiltros(Map<String, Object> filtros, String sortField, String sortOrder) throws ExcepcionDAO 
    {
        return (this.buscarPorFiltrosYPaginacion(filtros, sortField, sortOrder, null, null));
    }


    /**
     * Realiza la consulta de todos los Documentos Contables qe se encuentren dentro del rango especificado.
     * @param filtros - Mapa que contiene el nombre y valor de los filtros que se desean aplicar a la b&uacute;squeda.
     * @param sortField - Nombre de la columna por medio la cual se realizar&aacute; el ordenamiento.
     * @param sortOrder - Cadena del sentido de ordenamiento (ASC/DESC).
     * @param first - Valor inicial del rango.
     * @param last - Valor final del rango.
     * @return List of SiiDocumentoContable
     * @throws ExcepcionDAO
     */
    public List<SiiPersona> buscarPorFiltrosYPaginacion(Map<String, Object> filtros, String sortField, String sortOrder, Integer first, Integer last) throws ExcepcionDAO 
    {
        List<SiiPersona> resultado = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT  PER_CODIGO, ");
            sql.append("        PER_PRIMER_NOMBRE, ");
            sql.append("        PER_SEGUNDO_NOMBRE, ");
            sql.append("        PER_PRIMER_APELLIDO, ");
            sql.append("        PER_SEGUNDO_APELLIDO, ");
            sql.append("        TID_CODIGO, ");
            sql.append("        PER_NUM_IDENTIFICACION, ");
            sql.append("        PER_TIPO_PERSONA, ");
            sql.append("        PER_JUR_NOMBRE_LARGO, ");
            sql.append("        PER_JUR_NOMBRE_CORTO, ");
            sql.append("        PER_EMAIL, ");
            sql.append("        PER_TELEFONO, ");
            sql.append("        PER_FAX, ");
            sql.append("        PER_DIRECCION, ");
            sql.append("        PER_CODIGO_REPRESENTANTE, ");
            sql.append("        PER_CELULAR, ");
            sql.append("        UBI_CODIGO, ");
            sql.append("        PER_ORIGEN, ");
            sql.append("        PER_DIGITO_VERIF, ");
            sql.append("        PER_TELEFONO2, ");
            sql.append("        PER_TIPO_PROVEEDOR, ");
            sql.append("        TRE_CODIGO_RENTA, ");
            sql.append("        TRE_CODIGO_VENTAS, ");
            sql.append("        TRE_CODIGO, ");
            sql.append("        RDI_CODIGO_VENTAS, ");
            sql.append("        RDI_CODIGO_RENTA ");
            sql.append("FROM SII_PERSONA per ");


            // FILTROS
            if (filtros != null && !filtros.isEmpty()) {
                this.adicionarSentenciasSQLFiltros(sql, filtros);
            }

            // ORDENAMIENTO
            if (sortField != null && !sortField.isEmpty()) {
                /*
                String columnName = Utilidades.getColumnNameFromProperty(SiiPersona.class, sortField);

                if (columnName!=null) {
                    sql.append("ORDER BY "+columnName+" ");

                    if (sortOrder!=null && !sortOrder.isEmpty()) {
                        sql.append(sortOrder+" ");
                    }
                }*/



            }
            //else {
            sql.append("ORDER BY PER_PRIMER_APELLIDO, PER_SEGUNDO_APELLIDO, PER_PRIMER_NOMBRE, PER_SEGUNDO_NOMBRE, PER_JUR_NOMBRE_LARGO, PER_JUR_NOMBRE_CORTO, PER_NUM_IDENTIFICACION ");
            //}


            Query query = manager.createNativeQuery(sql.toString());


            // PAGINACION
            if (first != null)
                query.setFirstResult(first);
            if (last != null)
                query.setMaxResults(last);


            List<Object[]> rows = query.getResultList();


            // convertir el listado de registros a un listado de instancias de entidad SiiPersona.
            resultado = this.generarListaPersonas(rows);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), getClass().getSimpleName());
        }

        return (resultado);
    }


    /**
     * Adiciona las sentencias SQL correspondientes a los filtros suministrados.
     * @param sql - String Builder que contiene las sentencias SQL.
     * @param filtros - Filtros aplicados a la consulta.
     */
    private void adicionarSentenciasSQLFiltros(StringBuilder sql, Map<String, Object> filtros) {
        if (filtros != null && !filtros.isEmpty()) {
            sql.append("WHERE 1=1 ");

            Set<String> columnas = filtros.keySet();
            if (columnas != null) {
                for (String columna : columnas) {
                    Object valor = filtros.get(columna);
                    
                    if (valor!=null) {
                        String strValor = valor.toString();
                        
                        // PREVENCION DE SQL INJECTION
                        strValor = Utilidades.filtrarInyeccionSQL(strValor);
                        
                        String columnName = Utilidades.getColumnNameFromProperty(SiiPersona.class, columna);
                        if (columnName != null && strValor != null) {
                            sql.append("AND  UPPER(" + columnName + ")  LIKE UPPER('%" + strValor + "%') ");
                        }
    
                        // FILTRO POR NOMBRE (unicamente aplicable a Persona)
                        else {
                            if (strValor != null &&
                                columna.toUpperCase().contains(String.valueOf("nombreCompleto").toUpperCase())) {
                                sql.append(" AND (UPPER(PER_JUR_NOMBRE_LARGO) like UPPER('%" + strValor +
                                           "%') or UPPER(PER_JUR_NOMBRE_CORTO) like UPPER('%" + strValor + "%') ");
                                sql.append("      or UPPER(PER_PRIMER_NOMBRE) like UPPER('%" + strValor +
                                           "%') or UPPER(PER_SEGUNDO_NOMBRE) like UPPER('%" + strValor + "%') ");
                                sql.append("      or UPPER(PER_PRIMER_APELLIDO) like UPPER('%" + strValor +
                                           "%')  or UPPER(PER_SEGUNDO_APELLIDO) like UPPER('%" + strValor + "%')) ");
                            }
                        }
                        // FIN FILTRO POR NOMBRE
                    }
                }
            }
        }
    }


    /**
     * Genera el listado de Personas a partir de la lista de registros resultante de la consulta SQL.
     * @param rows - Listado que contiene la informaci&oacute;n de las filas obtenidas luego de la ejecuci&oacute;n de una consulta SQL.
     * @return List of SiiPersona
     * @throws ExcepcionDAO
     */
    private List<SiiPersona> generarListaPersonas(List<Object[]> rows) throws ExcepcionDAO {
        List<SiiPersona> resultado = null;


        if (rows != null) {
            resultado = new ArrayList<SiiPersona>();

            for (Object[] row : rows) {
                SiiPersona siiPersona = new SiiPersona();

                if (row[0] != null)
                    siiPersona.setPerCodigo(((BigDecimal) row[0]).longValue());
                if (row[1] != null)
                    siiPersona.setPerPrimerNombre((String) row[1]);
                if (row[2] != null)
                    siiPersona.setPerSegundoNombre((String) row[2]);
                if (row[3] != null)
                    siiPersona.setPerPrimerApellido((String) row[3]);
                if (row[4] != null)
                    siiPersona.setPerSegundoApellido((String) row[4]);

                if (row[5] != null) {
                    Long tidCodigo = ((BigDecimal) row[5]).longValue();
                    SiiTipoIdentificacion siiTipoIdentificacion =
                        tipoIdentificacionDao.buscarTipoIdentificacionPorId(tidCodigo);
                    siiPersona.setSiiTipoIdentificacion1(siiTipoIdentificacion);
                }

                if (row[6] != null)
                    siiPersona.setPerNumIdentificacion((String) row[6]);
                if (row[7] != null)
                    siiPersona.setPerTipoPersona((String) row[7]);
                if (row[8] != null)
                    siiPersona.setPerJurNombreLargo((String) row[8]);
                if (row[9] != null)
                    siiPersona.setPerJurNombreCorto((String) row[9]);
                if (row[10] != null)
                    siiPersona.setPerEmail((String) row[10]);
                if (row[11] != null)
                    siiPersona.setPerTelefono((String) row[11]);
                if (row[12] != null)
                    siiPersona.setPerFax((String) row[12]);
                if (row[13] != null)
                    siiPersona.setPerDireccion((String) row[13]);

                if (row[14] != null) {
                    Long perCodigoRepresentante = ((BigDecimal) row[14]).longValue();
                }

                if (row[15] != null)
                    siiPersona.setPerCelular((String) row[15]);

                if (row[16] != null) {
                    String ubiCodigo = (String) row[16];
                    SiiUbicacion siiUbicacion = ubicacionDao.buscarUbicacionPorId(ubiCodigo);
                    siiPersona.setSiiUbicacion1(siiUbicacion);
                }

                if (row[17] != null)
                    siiPersona.setPerOrigen((String) row[17]);
                if (row[18] != null)
                    siiPersona.setPerDigitoVerif(((BigDecimal) row[18]).intValue());
                if (row[19] != null)
                    siiPersona.setPerTelefono2((String) row[19]);

                if (row[20] != null) {
                    String perTipoProveedor = (String) row[20];
                }

                if (row[21] != null) {
                    String treCodigoRenta = (String) row[21];
                }

                if (row[22] != null) {
                    String treCodigoVentas = (String) row[22];
                }

                if (row[23] != null) {
                    Long treCodigo = ((BigDecimal) row[23]).longValue();
                }

                if (row[24] != null) {
                    Long rdiCodigoVentas = ((BigDecimal) row[24]).longValue();
                }

                if (row[25] != null) {
                    Long rdiCodigoRenta = ((BigDecimal) row[25]).longValue();
                }


                resultado.add(siiPersona);
            }
        }

        return (resultado);
    }


    /**
     * Obtiene la cantidad de registros de la tabla.
     * @throws ExcepcionDAO
     */
    public Integer obtenerRowCount() throws ExcepcionDAO {
        return (this.obtenerRowCount(null));
    }


    /**
     * Obtiene la cantidad de registros de la tabla.
     * @param filtros - Filtros aplicados a la consulta.
     * @throws ExcepcionDAO
     */
    public Integer obtenerRowCount(Map<String, Object> filtros) throws ExcepcionDAO {
        Integer resultado = null;

        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT COUNT(1) FROM SII_PERSONA ");


            // FILTROS
            if (filtros != null && !filtros.isEmpty()) {
                this.adicionarSentenciasSQLFiltros(sql, filtros);
            }


            Query query = manager.createNativeQuery(sql.toString());

            Object result = query.getSingleResult();

            if (result != null)
                resultado = ((BigDecimal) result).intValue();
            else
                resultado = new Integer(0);

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage() + " : " + pe.getMessage(), getClass().getSimpleName());
        }

        return (resultado);
    }


    /**
     *Metodo encargado de buscar una persona por su numero de identificacion
     * @Author David Tafur
     * @param identificacion
     * @return
     * @throws ExcepcionDAO
     */
    //TODO: Borrar este Método (El Gatopardo)
    /*
    public SiiPersona buscarPersonaXNumeroIdentificacion(String identificacion) throws ExcepcionDAO {
        SiiPersona personaRetorno = new SiiPersona();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT per FROM SiiPersona per");
            sql.append(" WHERE per.perNumIdentificacion = :numIdentificacion");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("numIdentificacion", identificacion);

            List<SiiPersona> listaResultadosPersona = new ArrayList<SiiPersona>();
            listaResultadosPersona = query.getResultList();

            if (listaResultadosPersona.size() > 0) {
                personaRetorno = listaResultadosPersona.get(0);
            }


        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        //SolicitudEstMercadoVO retornoSolicitudEstMercadoVo = new SolicitudEstMercadoVO();
        return personaRetorno;
    }
*/

    /**
     *Metodo encargado de buscar para una empresa una persona que hace parte de su personal
     * por su tipo de personal empresa
     * @author David Tafur
     * @param codigoOperadorPersona
     * @param codigoTipoPersonal
     * @return
     * @throws ExcepcionDAO
     */
    public SiiPersona buscarPersonaPersonalEmpresaXOperadorXTipoPersonal(long codigoOperadorPersona,
                                                                         long codigoTipoPersonal) throws ExcepcionDAO {
        SiiPersona siiPersona = new SiiPersona();
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT per FROM SiiPersonalEmpresa pere");
            sql.append(" INNER JOIN pere.siiPersona3 per");
            sql.append(" WHERE pere.siiTipoPersonal.tpeCodigo = :codigoTipoPersonal");
            sql.append(" AND pere.siiPersona.perCodigo = :codigoOperadorPersona");

            Query consulta = manager.createQuery(sql.toString());
            consulta.setParameter("codigoOperadorPersona", codigoOperadorPersona);
            consulta.setParameter("codigoTipoPersonal", codigoTipoPersonal);

            List<SiiPersona> resultadosBd = new ArrayList<>();
            resultadosBd = consulta.getResultList();

            if (resultadosBd.size() > 0) {
                siiPersona = resultadosBd.get(0);
            }

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        return siiPersona;
    }


    /**
     * Se encarga de devolver todas la personas que sea operadores autorizados
     * @autor Giovanni
     * @return personas
     * @throws ExcepcionDAO
     */
    public List<SiiPersona> buscarPersonaOperadorPotencialAutorizado() throws ExcepcionDAO {
        List<SiiPersona> personas = new ArrayList<SiiPersona>();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT siip FROM SiiOperador siiop");
            sql.append(" INNER JOIN siiop.siiPersona siip");
            sql.append(" WHERE siiop.opePotencial IS NULL");
            sql.append(" ORDER BY siip.perJurNombreLargo ASC");

            Query query = manager.createQuery(sql.toString());

            personas = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        return personas;
    }

    /**
     * Se encarga de devolver todas la personas que sea operadores potenciales
     * @autor Giovanni
     * @return personas
     * @throws ExcepcionDAO
     */
    public List<SiiPersona> buscarPersonaOperadorPotencial() throws ExcepcionDAO {
        List<SiiPersona> personas = new ArrayList<SiiPersona>();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT siip FROM SiiOperador siiop");
            sql.append(" INNER JOIN siiop.siiPersona siip");
            sql.append(" WHERE siiop.opePotencial = 'S'");
            sql.append(" ORDER BY siip.perJurNombreLargo ASC");

            Query query = manager.createQuery(sql.toString());

            personas = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        return personas;
    }

    /**
     * Se encarga de devolver todas la personas que sea o y provedores tecnologia
     * @autor Giovanni
     * @return personas
     * @throws ExcepcionDAO
     */
    public List<SiiPersona> buscarPersonaProveedorTecnologia() throws ExcepcionDAO {
        List<SiiPersona> personas = new ArrayList<SiiPersona>();
        try {

            StringBuilder sql = new StringBuilder();
            sql.append("SELECT siip FROM SiiProveedorTecn siiprt");
            sql.append(" INNER JOIN siiprt.siiPersona siip");
            sql.append(" ORDER BY siip.perJurNombreLargo ASC");

            Query query = manager.createQuery(sql.toString());

            personas = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        return personas;
    }

    public String buscarNombreFuncionario(String cargo, String activo) throws ExcepcionDAO {
        try {
            String s = null;
            StringBuilder sql = new StringBuilder();
            sql.append("select per from SiiUsuario usu join usu.siiFuncion1 fun join usu.siiPersona per where fun.funNombre like :cargo and usu.siiEstadoUsuario.eusNombre = :activo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("cargo", cargo);
            query.setParameter("activo", activo);
            List<SiiPersona> resultadosBd = new ArrayList<>();
            resultadosBd = query.getResultList();
            if(resultadosBd.size()>0 ){
                s = resultadosBd.get(0).getPerPrimerNombre();
                if (resultadosBd.get(0).getPerSegundoNombre() != null) {
                    s = s + " " + resultadosBd.get(0).getPerSegundoNombre();
                }
                s = s + " " + resultadosBd.get(0).getPerPrimerApellido();
                if (resultadosBd.get(0).getPerSegundoApellido() != null) {
                    s = s + " " + resultadosBd.get(0).getPerSegundoApellido();
                }
            }

            return s;

        } catch (NoResultException pe) {
            return "_______________________";
        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }

    }
   
    public SiiPersona buscarPersonaXNombreFuncionario(String cargo, String activo) throws ExcepcionDAO {
        SiiPersona siiPersona=new SiiPersona();
       
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("select per from SiiUsuario usu join usu.siiFuncion1 fun join usu.siiPersona per where fun.funNombre like :cargo and usu.siiEstadoUsuario.eusNombre = :activo");
            Query query = manager.createQuery(sql.toString());
            query.setParameter("cargo", cargo);
            query.setParameter("activo", activo);
                       
            List<SiiPersona> resultadosBd = new ArrayList<>();
            resultadosBd = query.getResultList();

            if (resultadosBd.size() > 0) {
               siiPersona = resultadosBd.get(0);
            }
            return siiPersona;

        }             
         catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }

    }
    public List<SiiPersona> buscarPersonaXCodigoOperador(SiiPersona unaPersona) throws ExcepcionDAO {
        List<SiiPersona> listaPersonaRetorno = null;
        try {
            StringBuilder sql = new StringBuilder();
            sql.append("SELECT per FROM SiiOperador op inner join  op.siiPersona per  ");
            sql.append(" WHERE 1 = 1 ");             
            if (unaPersona.getPerPrimerNombre()!= null && !unaPersona.getPerPrimerNombre().equals("")) {
                sql.append(" AND UPPER(per.perPrimerNombre) LIKE :primerNombre");
            }
            if (unaPersona.getPerPrimerApellido()!= null && !unaPersona.getPerPrimerApellido().equals("")) {
                sql.append(" AND UPPER(per.perPrimerApellido) LIKE :primerApellido");
            }
            if (unaPersona.getPerSegundoNombre()!= null && !unaPersona.getPerSegundoNombre().equals("")) {
                sql.append(" AND UPPER(per.perSegundoNombre) LIKE :segundoNombre");
            }
            if (unaPersona.getPerSegundoApellido() != null && !unaPersona.getPerSegundoApellido().equals("")) {
                sql.append(" AND UPPER(per.perSegundoApellido) LIKE :segundoApellido");
            }
            if (unaPersona.getSiiTipoIdentificacion1() != null &&
                unaPersona.getSiiTipoIdentificacion1().getTidCodigo() != null) {
                sql.append(" AND per.siiTipoIdentificacion1.tidCodigo = :tidCodigo");
            }
            if (unaPersona.getPerNumIdentificacion()!= null && !unaPersona.getPerNumIdentificacion().equals("")) {
                sql.append(" AND per.perNumIdentificacion LIKE :numIdentificacion");
            }
            if (unaPersona.getPerTipoPersona() != null) {
                if (!unaPersona.getPerTipoPersona().equals("")) {
                    sql.append(" AND per.perTipoPersona = :tipoPersona");
                }
            }
            if (unaPersona.getPerJurNombreLargo() != null) {
                if (!unaPersona.getPerJurNombreLargo().equals("")) {
                    sql.append(" AND per.perJurNombreLargo LIKE :perJurNombreLargo");
                }
            }

            sql.append(" ORDER BY per.perPrimerNombre");

            Query query = manager.createQuery(sql.toString());

            if (unaPersona.getPerPrimerNombre() !=null && !unaPersona.getPerPrimerNombre().equals("")) {
                query.setParameter("primerNombre", "%" + unaPersona.getPerPrimerNombre().toUpperCase() + "%");
            }
            if (unaPersona.getPerPrimerApellido() !=null && !unaPersona.getPerPrimerApellido().equals("")) {
                query.setParameter("primerApellido", "%" + unaPersona.getPerPrimerApellido().toUpperCase() + "%");
            }
            if (unaPersona.getPerSegundoNombre() !=null && !unaPersona.getPerSegundoNombre().equals("")) {
                query.setParameter("segundoNombre", "%" + unaPersona.getPerSegundoNombre().toUpperCase() + "%");
            }
            if (unaPersona.getPerSegundoApellido() !=null && !unaPersona.getPerSegundoApellido().equals("")) {
                query.setParameter("segundoApellido", "%" + unaPersona.getPerSegundoApellido().toUpperCase() + "%");
            }
            if (unaPersona.getSiiTipoIdentificacion1() != null &&
                unaPersona.getSiiTipoIdentificacion1().getTidCodigo() != null) {
                query.setParameter("tidCodigo", unaPersona.getSiiTipoIdentificacion1().getTidCodigo());
            }
            if (unaPersona.getPerNumIdentificacion()!= null && !unaPersona.getPerNumIdentificacion().equals("")) {
                query.setParameter("numIdentificacion", "%" + unaPersona.getPerNumIdentificacion() + "%");
            }
            if (unaPersona.getPerTipoPersona() != null) {
                if (!unaPersona.getPerTipoPersona().equals("")) {
                    query.setParameter("tipoPersona", unaPersona.getPerTipoPersona());
                }
            }
            if (unaPersona.getPerJurNombreLargo() != null) {
                if (!unaPersona.getPerJurNombreLargo().equals("")) {
                    query.setParameter("perJurNombreLargo", "%" + unaPersona.getPerJurNombreLargo().toUpperCase()  + "%");
                }
            }

            //query.setParameter("numIdentificacion", unPersona.getPerNumIdentificacion());
            //query.setParameter("tipoIdentificacion", unPersona.getSiiTipoIdentificacion1().getTidCodigo());
            listaPersonaRetorno = query.getResultList();

        } catch (PersistenceException pe) {
            String mensajeError = recursos.obtenerRecurso("ERROR_DAO", "mensajes_sistema");
            throw new ExcepcionDAO(mensajeError + " : " + pe.getMessage(), "PersonaDAO");
        }
        return listaPersonaRetorno;
    }
}
